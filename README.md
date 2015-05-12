EEUtils
=======

[![Build Status](https://ci.larry1123.net/job/EEUtils/badge/icon)](https://ci.larry1123.net/job/EEUtils/)  
[Latest Build](https://ci.larry1123.net/job/EEUtils/lastBuild/)  
[Latest Successful Build](https://ci.larry1123.net/job/EEUtils/lastSuccessfulBuild/)

EEUtils currently contains a logger and a management system for PropertiesFile from VIUtils

Development
=============

Maven
-------------

        <dependency>
            <groupId>net.larry1123</groupId>
            <artifactId>EEUtils</artifactId>
            <version>[1.3.0,)</version> <!-- Will always use the latest version found (including snapshots)-->
        </dependency>


*Repository:*

        <repository>
            <id>repo1123</id>
            <name>Larry1123's Repo</name>
            <url>http://public.repo.larry1123.net/</url>
        </repository>

Java Docs
-------------

Primary: https://repo.larry1123.net/content/sites/eeutils_site/apidocs/
Jenkins: https://ci.larry1123.net/job/EEUtils/javadocs/

Compilation
=============

Use maven to handle dependencies.

* Install [Maven 3](http://maven.apache.org/download.html)
* Check out the repo and: `mvn clean install`
