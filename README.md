
# Api Testing Scenario

To build automated tests inorder to verify the working of an open weather api station.


## Step 1: Setup tools
1. I used Eclipse as my IDE because I can download Cucumber plugins and generate a Maven project, used Java as a programming language.
2. If you use Eclipse, install the Cucumber Plugin via Eclipse Marketplace.
3. Install Maven.
4. Need to register in [open weather map](https://openweathermap.org/stations)


## Step 2: Initial setup and add dependencies
1. Created a Maven project
2. Added all the required dependencies into pom.xml file. You can find them in the [Maven repository](https://mvnrepository.com/)

## Step 3: Framework structure
1.Under Features folder--->Weather_station.feature, test scenarios are mentioned.
2. Under src/test/java--->stepDefinitions, all the corresponding methods for Weather_station.feature is created in steps.java
3.  src/test/java--->testRunner--->TestRunner is created to execute Weather_station.feature file which is mentioned above.

## Step 4: To run the tests
1. To run the test, go to src/test/java--->testRunner--->TestRunner, now run as Junit test.
2. We can also use pom.xml file to run the tests.Go to pom.xml,use run as Maven test command . Also remotely using command prompt by mvn test command.

## Step 5: Generate reports
1. After executing tests successfully, we get reports under reports--->myreport.html, myreport.jsn files. Output is also displayed in console.
