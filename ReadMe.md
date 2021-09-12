# Text Counter

### Author: Amir Soltani

#### Date: September 12, 2021

###### JDK 11 [download](https://www.oracle.com/ca-en/java/technologies/javase-jdk11-downloads.html)

###### Created with: Eclipse ver. 2021-06 (4.20.0) [download](https://www.eclipse.org/downloads/)

###### File Encoding: UTF-8

___

#### small application that implements the following

1. Return a distinct list of all the characters in the file along with their counts. The results should be sorted by
   character.
2. Return a distinct list of all punctuation in the file along with their counts. The results should be sorted based on
   punctuation occurrence from most frequent to least frequent.
3. Return a list of distinct words and their respective counts ordered alphabetically.
4. Return top "X" used words (with an option to include or exclude conjunctions) and their counts where "X" is a passed
   in parameter.*

___

* The included files “A Tale of Two Cities - Charles Dickens.txt” and “Alices Adventures in Wonderland - Lewis
  Carroll.txt” are provided to test the application.
* Running the application provide the user with an interface and an option to choose one of the files as the test case.
* Upon successful run the program will log the results in **/Results** directory.
* Number of top used words and the option for including the conjunctions can be changed from the method call in the AppDriver class.
---
_[4]* By default the top 20 words will be printed excluding the conjunctions_

_[4]* [NLTK's list of english stop words](https://gist.github.com/sebleier/554280) is used as a reference for the conjunctions_