# In Memory Virtual File System Project #

Design and implement a program which will handle and manage a "File System" structure.

### The file system contains the following entities and operations: ###

#### A File is defined as having: ####

* A name - up to 32 characters long

* A size - positive long integer

* A create date (date type)

#### A directory is defined as having: ####

* A name - up to 32 characters long

* A create date (date type)

A directory can contain directories or files

The program will include the following functionalities:

 

#### Function Prototype ####

**addFile(string parentDirName, String fileName, integer fileSize)**

Adds new File under the Directory branch

**addDir(string parentDirName, String dirName)**

Adds new Directory under the parent Directory

**delete(string name)**

Deletes the Directory or the File with this name

**showFileSystem()**

Displays all files & directories with their hierarchical structure (for file display all file properties and for Directory all its properties)

 

> Each name, file or directory is unique in the file system

> Each directory can contain an unlimited number of files or directories

> No need to write anything on the disk - the data structure should be managed in memory only
