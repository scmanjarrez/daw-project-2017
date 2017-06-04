#! /usr/bin/env bash


apt-get -qq update
sudo apt-get install -y python-software-properties debconf-utils
sudo add-apt-repository -y ppa:webupd8team/java
sudo apt-get update
echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 select true" | sudo debconf-set-selections
sudo apt-get install -y oracle-java8-installer
apt-get -y install maven
cd /vagrant/data/daw-project-2017
./mvwn package
cd ./target
sudo iptables -t nat -A PREROUTING -p tcp --dport 80 -j REDIRECT --to-port 8080
java -jar daw-project-2017-0.0.1-SNAPSHOT.jar
