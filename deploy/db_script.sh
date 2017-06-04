#! /usr/bin/env bash

# Variables
DBHOST=localhost
DBNAME=videoclub
DBUSER=testuser
DBPASSWD=dawtest

apt-get -qq update
apt-get -y install vim curl build-essential python-software-properties git >> /vagrant/vm_build.log 2>&1
curl -sL https://deb.nodesource.com/setup_6.x | sudo -E bash - >> /vagrant/vm_build.log 2>&1
apt-get -qq update

debconf-set-selections <<< "mysql-server mysql-server/root_password password $DBPASSWD"
debconf-set-selections <<< "mysql-server mysql-server/root_password_again password $DBPASSWD"
debconf-set-selections <<< "phpmyadmin phpmyadmin/dbconfig-install boolean true"
debconf-set-selections <<< "phpmyadmin phpmyadmin/app-password-confirm password $DBPASSWD"
debconf-set-selections <<< "phpmyadmin phpmyadmin/mysql/admin-pass password $DBPASSWD"
debconf-set-selections <<< "phpmyadmin phpmyadmin/mysql/app-pass password $DBPASSWD"
debconf-set-selections <<< "phpmyadmin phpmyadmin/reconfigure-webserver multiselect none"

apt-get -y install mysql-server phpmyadmin >> /vagrant/vm_build.log 2>&1

mysql -uroot -p$DBPASSWD -e "CREATE DATABASE $DBNAME" >> /vagrant/vm_build.log 2>&1
mysql -uroot -p$DBPASSWD -e "update mysql.user set Host='%' where User='testuser';" >> /vagrant/vm_build.log 2>&1
mysql -uroot -p$DBPASSWD < /vagrant/data/database/database.sql >> /vagrant/vm_build.log 2>&1
mysql -uroot -p$DBPASSWD < /vagrant/data/database/user.sql >> /vagrant/vm_build.log 2>&1
mysql -uroot -p$DBPASSWD < /vagrant/data/database/user_roles.sql >> /vagrant/vm_build.log 2>&1
mysql -uroot -p$DBPASSWD -e "grant all privileges on $DBNAME.* to '$DBUSER'@'%' identified by '$DBPASSWD'" > /vagrant/vm_build.log 2>&1

sudo sed -i 's/bind-address/# bind-address /' /etc/mysql/my.cnf







#sudo apt-get update
#sudo apt-get upgrade < Y
#sudo apt-install mysql
#sudo apt-get update
#sudo apt-get upgrade
#cd /vagrant/data/database
#sudo service mysql start
#mysql -u root -p < create.sql
#mysql -u root -p < database.sql
#mysql -u root -p < movie.sql
#mysql -u root -p < user.sql
#mysql -u root -p < user_roles.sql

# Con esto en teoria deberia desplegarse la BD