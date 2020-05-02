# beginnersguidefortesting
this will give beginners an idea on how to build and learn TestNg

##setup:
 Java JDK- https://www.oracle.com/java/technologies/javase-downloads.html
 how to Install Java JDK on Windows- https://www.guru99.com/install-java.html
 maven -    https://maven.apache.org/download.cgi
 How to Install Maven on Windows: https://www.mkyong.com/maven/how-to-install-maven-in-windows/

####Validate Java and Maven is correctly setup
####Command line:
1. `java -version`
2. `mvn -version`

###TestNG Order of Execution
1. @BeforeSuite         - The annotated method will be run before all tests in this suite have run.
2. @BeforeTest          - The annotated method will be run before any test method belonging to the classes inside the <test> tag is run.
3. @BeforeClass         - The annotated method will be run before the first test method in the current class is invoked.
4. @BeforeMethod        - The annotated method will be run before each test method.
5. @Test                - Marks a class or a method as part of the test.
6. @AfterMethod         - The annotated method will be run after each test method.
7. @AfterClass          - The annotated method will be run after all the test methods in the current class have been run.
8. @AfterTest           - The annotated method will be run after all the test methods belonging to the classes inside the <test> tag have run.
9. @AfterSuite          - The annotated method will be run after all tests in this suite have run.
The annotations above will also be honored (inherited) when placed on a superclass of a TestNG class.

additional annotations:
1. @DataProvider
2. @Listeners
3. @Parameters

Parameters  -   Describes how to pass parameters to a @Test method.
value       -	The list of variables used to fill the parameters of this method.
Parameters
    1 - Parameters from testng.xml
    2 - Parameters with DataProviders
    3 - Parameters in reports
    
DO NOT test data as declare class level local variable; 
maintenance of the test data is a challenge; if we have 100+ tests spread all over multiple packages.  

####Additional Documentation can be accessed using : https://testng.org/doc/documentation-main.html
TestNG.xml helps to execute a suite of tests.
 
***package com.guide.beginners.testng.samplejava*** 
-should share insight on how testNG works

***package com.guide.beginners.testng.theinternet.individualtestclass*** 
-should share insight on usage of testNG with selenium

With the knowledge gained in from the above 2 packages; We shall sping off a Selenium TestNG framework.

####Step.1
Before designing a framework; develop a test that achieves a simple goal. 
`class name="com.guide.beginners.testng.theinternet.individualtestclass.Step1"`
Demonstrate test design and the rough draft of code to check if it works. 

####Step.2
`class name="com.guide.beginners.testng.theinternet.individualtestclass.Step2"`
Demonstates seperating data and page objects from the tests. 
Here were still declaring with private to class;
all variable components of the test and using additional testng annotations to create a chain of events

####Step.3
`class name="com.guide.beginners.testng.theinternet.individualtestclass.Step3"`
Test data is now totally isolated and is passed in via seleniumsuite.xml
Refer the file path: "src\test\resources\testngsuite\seleniumsuite.xml"
`@Optional` -  Specifies that the current parameter is optional.  
TestNG will pass in a specified default value, or <code>null</code> if none is specified.

####Step.4
Extracting driver setup to base in framework
`package com.guide.beginners.testng.theinternet.frameworktestng.base`

We are using:
@BeforeClass and @AfterClassto setup/teardown the WebDriver
@BeforeMethod for instantiating or launchTestUrl setting up the test env or building the context to test.
each test class is a scenario and each class may have one or more @Test cases.

As per testng official documentation:
You can instruct TestNG to run your tests in separate threads in various ways.
    1. Parallel suites
     ```   This is useful if you are running several suite files (e.g. "java org.testng.TestNG testng1.xml testng2.xml") 
        and you want each of these suites to be run in a separate thread. 
        You can use the following command line flag to specify the size of a thread pool:
            java org.testng.TestNG -suitethreadpoolsize 3 testng1.xml testng2.xml testng3.xml```
    2. Parallel tests, classes and methods
        - parallel="methods": 
          TestNG will run all your test methods in separate threads. Dependent methods will also run in separate threads but they will respect the order that you specified.
        - parallel="tests":
          TestNG will run all the methods in the same <test> tag in the same thread, but each <test> tag will be in a separate thread.
          This allows you to group all your classes that are not thread safe in the same <test> and guarantee they will all run in the same thread
          while taking advantage of TestNG using as many threads as possible to run your tests.  
        - parallel="classes": 
          TestNG will run all the methods in the same class in the same thread, but each class will be run in a separate thread.
        - parallel="instances": 
          TestNG will run all the methods in the same instance in the same thread, but two methods on two different instances will be running in different threads.
          Additionally, the attribute thread-count allows you to specify how many threads should be allocated for this execution.
          The parallel attribute on the <suite> tag can take one of following values:
                -`<suite name="My suite" parallel="methods" thread-count="5">`
                -`<suite name="My suite" parallel="tests" thread-count="5">`
                -`<suite name="My suite" parallel="classes" thread-count="5">`
                -`<suite name="My suite" parallel="instances" thread-count="5">`
        
       
        
       

Note: the @Test attribute timeOut works in both parallel and non-parallel mode.
if ever we want to run parallel we cannot use parallel mode at the level of methods. 


Command line executon:
`mvn clean test -DsuiteXmlFiles=CrossBrowserParallelSuite.xml`










 
 