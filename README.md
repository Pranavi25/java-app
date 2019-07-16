# Java project
## Overview

 - [Java Grep App](#grep) - This implements searching for certain regex patterns and return them in a output file.
 - [JDBC](#jdbc) - This implements a use case to understand JDBC connectivity.
 - [Twitter CLI App](#twitter) - This implements spring boot framework to create tweets and post them on twitter account.

 
<a name="grep"><a/>

## Java Grep App

## Introduction
We want to find certain text patterns or regex patterns  from different files that reside inside a directory. If there are few files we can go into each file and find the text pattern but what if there are millions of files in a directory and millions of text lines in these files? To handle certain situations this Grep App is implemented to go through all the files in a directory recursively and find the regex pattern and write to a output stream file. 
## Usage
This App can be implemented when there is a rootPath, regex and outfile to find the files in the rootPath, read the lines to find the regex pattern and write the matched lines to a new output file respectively. A detail description of the three arguments:

 - regex: a special text string for describing a search pattern
 - rootPath: root directory Path
 - outFile: output file name

When we want to find and return all the lines where it contains the word "coordinates", the regex will be "*coordinates *" 
from the root directory it goes inside each file and returns the matched lines and writes to an output file.

## Design and Implementation
Interface has process(), listFiles(), readLines(), containesPattern() and writeToFile() methods which is implemented by JavaGrepImp class. 
The process() implements the below pseudo code:

    matchedLines = [];
    for file in listFiles(rootDir)
	    for line in readLines(file)
		    if containsPattern(line)
			    matchedLines.add(line);
	writeToFile(matchedLines);
In listFiles() it traverses the given directory and returns all the files under it.
In readLines() the files are read using File reader, buffer reader and character encoding. The purpose is to read the files in the directory and return lines.
In containsPattern() it checks if the line contains the regex pattern passed by user and return the line if it is true.
In writeToFile() it writes the lines to the file and through File output stream, Output stream writer and buffered writer.
Finally, all these methods are implemented in the main method.

### Libraries
The following libraries are used while implementing the grep app are: 

 

     - java.io.File 
     - java.io.IOException 
     - java.util.List

 
### Diagram
![
](https://lh3.googleusercontent.com/RtM3kByrsq3ibPhdblPP3nhokM3Dfqirkxm0L988b2yRBhNsSM0lsvnh4zRGFVS9PGozOF7fCWUG "Structure")


![
](https://lh3.googleusercontent.com/5pk2RG4oAzGyCn1FKOqD5cwboo4PDxbU9B4D3QNoLNfHimedQbyTecOMIn4lXBepxaFEm0cil-qO "Work Flow")

## Enhancement

 - we can implement it for multiple directories
 - write it to database instead of file
 - create it as a web application
<a name="jdbc"> </a>
# JDBC
## Introduction
In this the use case is implemented to understand Java Database Connectivity (JDBC) API, showing how to use it to read and manage data from relational databases such as Postgres in applications programmed with Java.

## Usage
For a dynamic application implementation we need to connect with relational DBMS in order to integrate data in our application. 
 
## Design Implementation
Database connection manager- In this for connection host,  database name, username,  password are set.
DTO - It is the Data Transferable Object which is an interface where we create are required variables to achieve DRY.
DAO - It is Data access object which extends the DTO where methods such as create, find by id, update and delete are instantiated.
Customer - This implements DTO interface and create new variables such as first name, last name, email, phone, address, city, state and zip code.
Customer DAO -  This implements DAO where Insert, find, update and delete methods are implemented.
JDBC executor - This is the main method where JDBC connection is called and the main implementation works.

### Libraries

    java.sql.*
   

### Diagrams
![
](https://lh3.googleusercontent.com/fQpT-41jugbFYHyrWaBLukJgOEv74ipTABamuoKZMzHgpmfYPcSqLRp2mA5kdNqhfoPHXMIW-brZ "JDBC structure")

## Enhancement

 - Make it GUI user friendly
 - have multiple connections

# Twitter CLI App

## Introduction

Twitter Command Line Interface allows the user to interact through Post, Show and Delete tweets on twitter. This implementation uses the users developer keys. 

## Usage
There are three main usages:

- Post Tweet
-  Show Tweet
-  Delete Tweet

#### Post Tweet
This creates a tweet a short message along with the coordinates or geotag. For example:

    Hello this is my First tweet #Toronto #myfirsttweet 50.089:-46.890
The above tweet will be posted on the twitter.
#### Show Tweet
This will enable to view the tweet with the given id and their specified fields which are in a list format. The following are few fields that can be viewed:
created_at,  hashtags, user_mentions, coordinates, retweet_count, favorited and etc.

#### Delete Tweet
This will delete the tweet by the given id. We can delete multiple id's tweets by providing them with comma separation.




 

## Design and Implementation

 - Interface
 Twitter CLI service class resides in the interface which is implemented by Twitter Servi
 

 - service
 - Access
 - Storage
 

### libraries

    org.apache.http.HttpResponse
    org.apache.http.util.EntityUtils
    org.springframework.beans.factory.annotation.Autowired
    org.springframework.stereotype.Repository
    java.io.IOException
    java.io.UnsupportedEncodingException
    java.net.URI
    java.net.URISyntaxException
    java.net.URLEncoder
    java.nio.charset.StandardCharsets
    org.springframework.boot.autoconfigure.SpringBootApplication

### Diagram
![
](https://lh3.googleusercontent.com/q1HDW4inhwt-AZlgFE0eFdR-wA_Xd4jyUDrZJUnf_8j7ao0PPXuhsfQlp6nNuRTkDgyjlr_rAcU "Twitter API")
## Enhancement


<a name="twitter"> </a>







 



<!--stackedit_data:
eyJoaXN0b3J5IjpbLTU0MzM0MDEwNCwxODczNDk3NjM4LDk1Nz
I3OTc1MiwtMjcwMjQyNTA2LDIwMTQ4NjUyNzMsLTE1NDIzNDEw
OTAsMjQ1MjYxNTEwLC00NDY1MTIyNzBdfQ==
-->