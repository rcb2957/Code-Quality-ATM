# Code-Quality-ATM
An Exercise for M&amp;T Tech's 2022 Intern Cohort to learn about bug fixing, Test-Driven Design, code refactoring and code coverage tools

## Instructions
You've recently been assigned to a team that works on the functioning of automated teller machines (ATMs). The last developer on the team created some code that simply doesn't work. Your task is to find the bugs in the code, refactor the code to follow best practices and write JUnit tests for complete code coverage of the project.

### Bug Fixing
There are a mix of syntax and logic errors in the ATM.java file that you should fix. Some bugs may not be as apparent as others. Make sure to think about how your inputs to methods may affect the functioning of the code. In particular, make sure to look out for negative numbers and unrecognized string inputs.

### Refactoring
As it is currently written, the ATM class uses double-precision floating point numbers to handle currency values. This is extremely bad practice as floating point numbers tend to not be precise in some situations. Because of this, you will be refactoring the code to use the [Java BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html) class to store currency values instead. None of the method declarations should be modified (e.g. if a method return a double it should still return a double after your refactor). For examples of BigDecimal usage you can visit the [GeeksForGeeks BigDecimal page](https://www.geeksforgeeks.org/bigdecimal-class-java/) to learn more about the class.

### Unit Testing
You will be writing unit tests using [JUnit 5](https://junit.org/junit5/docs/current/user-guide/). Two tests have already been written for you to demonstrate JUnit syntax and how to test the ATM class. At the end of your testing, your unit tests should all pass and have 100% code coverage, meaning your tests run every single line of code.

## Recommended Tools
Although you can use all the tools we mentin here separately, we recommend using the Eclipse IDE because it contains everything we need to complete this project. It is also recommended that you do this work on your personal computers rather than a work laptop. Feel free to work on this during the normal workday as well.

### Eclipse Installation
1. Download the [Eclipse IDE Installer](https://www.eclipse.org/downloads/packages/installer)
2. Run the installer and select Eclipse IDE for Java Developers
3. Use the defaults from the installer and open the IDE

### Repo Setup
1. Fork this repo
2. Once forked, copy the HTTPS clone link from the forked repo
3. Open Eclipse
4. Select File > Import > Git > Projects from Git (with smart import) > Clone URI
5. Paste the clone link from before in the URI field in the window that pops up
6. Enter your github username and password in the Authentication section and click finish

### Checking Unit Test Coverage
In the top bar, to the right of the run button, you will find the test coverage button. Clicking this button will give you your code coverage percent and also highlight which lines of code your tests cover and which lines of code they dont. Use this tool to help you develop more unit tests.


### Committing to Git
1. Use CTRL + 3 or CMD + 3 and type git staging in the search box
2. Open git staging and stage all changes with the double + button
3. Write a commit message and click commit and push

### Submission
Once you've committed and pushed all of your changes to GitHub, go to the page for your fork on GitHub and click the pull request button. If you need to make any adjustments to your pull request, just push the updates to GitHub. Your pull request will automatically track the changes and update. 
