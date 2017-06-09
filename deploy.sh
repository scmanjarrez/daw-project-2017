#!/usr/bin/env bash

RED='\033[0;31m'
GREEN='\033[0;32m'
CYAN='\033[0;36m'
NC='\033[0m'

create_files()
{

    cat > Vagrantfile <<EOF
# -*- mode: ruby -*-
# vi: set ft=ruby :

# Vagrantfile API/syntax version. Don't touch unless you know what you're doing!
VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = "atorre/daw"


  config.vm.define "db" do |db|
    db.vm.network "private_network", ip: "192.168.33.20"

    db.vm.provider "virtualbox" do |vb|
      vb.memory = 350
    end

    db.vm.provision "file", source: "database.sql", destination: "/home/vagrant/database.sql"

    db.vm.provision "shell", path: "db_provision.sh"
  end


  config.vm.define "web" do |web|
    web.vm.network "private_network", ip: "192.168.33.21"

    web.vm.provision "file", source: "daw-project-2017-0.0.1-SNAPSHOT.jar",
                     destination: "/home/vagrant/daw-project-2017-0.0.1-SNAPSHOT.jar"

    web.vm.provision "shell", path: "web_provision.sh"
  end
end

EOF

    cat > db_provision.sh <<EOF
#!/usr/bin/env bash


apt-get -qq update

export DEBIAN_FRONTEND=noninteractive

apt-get install -qq -y mysql-server

sed -i 's/bind-address/# bind-address /' /etc/mysql/my.cnf

mysql -u root -e "CREATE DATABASE IF NOT EXISTS videoclub"

mysql -u root -e "GRANT ALL ON *.* TO root@'%' IDENTIFIED BY 'toor'; flush privileges;"

mysql -u root videoclub < database.sql

service mysql restart

EOF

    cat > web_provision.sh <<EOF
#!/usr/bin/env bash


add-apt-repository -y ppa:webupd8team/java

apt-get -qq update

apt-get install -y debconf-utils

export DEBIAN_FRONTEND=noninteractive

echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 select true" | sudo debconf-set-selections

apt-get install -qq -y oracle-java8-installer

apt-get install -qq -y mysql-client

iptables -F

iptables -t nat -A PREROUTING -p tcp --dport 80 -j REDIRECT --to-port 8080

nohup java -jar daw-project-2017-0.0.1-SNAPSHOT.jar > videoclub.log 2>&1 & sleep 1


# sudo nohup java -jar daw-project-2017-0.0.1-SNAPSHOT.jar \
#       --spring.datasource.url=jdbc:mysql://192.168.33.20:3306/videoclub \
#       --spring.datasource.username=root \
#       --spring.datasource.password=toor > videoclub.log 2>&1 & sleep 1

EOF

}

clean()
{
    echo -e "${GREEN}"
    echo -e "##########################################"
    echo -e "###     Removing deploying files...    ###"
    echo -e "##########################################"
    echo -e "${NC}"

    rm Vagrantfile db_provision.sh web_provision.sh daw-project-2017-0.0.1-SNAPSHOT.jar

    cd ..

    echo -e "${GREEN}"
    echo -e "##########################################"
    echo -e "###       Removing maven files...      ###"
    echo -e "##########################################"
    echo -e "${NC}"

    ./mvnw clean
}

stop()
{
    echo -e "${GREEN}"
    echo -e "##########################################"
    echo -e "###     Stopping virtual machines...   ###"
    echo -e "##########################################"
    echo -e "${NC}"

    vagrant halt

    echo -e "${GREEN}"
    echo -e "##########################################"
    echo -e "###      Removing virtual machines...  ###"
    echo -e "##########################################"
    echo -e "${NC}"

    vagrant destroy -f web db
}


if [ "$1" == "--clean" ]
then
    stop

    clean

    echo -e "${GREEN}Completed succesfully${NC}\n"

    exit 0
fi

vagrant init atorre/daw https://vagrantcloud.com/atorre/boxes/daw/versions/1.0/providers/virtualbox.box

echo -e "${GREEN}"
echo -e "##########################################"
echo -e "###    Creating provisioning files...  ###"
echo -e "##########################################"
echo -e "${NC}"

create_files

echo -e "${GREEN}"
echo -e "##########################################"
echo -e "###         Deploying database...      ###"
echo -e "##########################################"
echo -e "${NC}"

vagrant up db

chmod +x mvnw

echo -e "${GREEN}"
echo -e "##########################################"
echo -e "###        Generating JAR file...      ###"
echo -e "##########################################"
echo -e "${NC}"

./mvnw package

ln -s target/daw-project-2017-0.0.1-SNAPSHOT.jar daw-project-2017-0.0.1-SNAPSHOT.jar

echo -e "${GREEN}"
echo -e "##########################################"
echo -e "###          Deploying website...      ###"
echo -e "##########################################"
echo -e "${NC}"

vagrant up web

echo -e "${GREEN}"
echo -e "*******************************************************"
echo -e "* Check the videoclub website at ${CYAN}192.168.33.20${GREEN} *"
echo -e "*******************************************************"
echo -e "${NC}"

