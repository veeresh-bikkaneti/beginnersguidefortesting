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
1. @BeforeSuite
2. @BeforeTest
3. @BeforeClass
4. @BeforeMethod
5. @Test
6. @AfterMethod
7. @AfterClass
8. @AfterTest
9. @AfterSuite


additional annotations:
1. @DataProvider
2. @Listeners
3. @Parameters


####Additional Documentation can be accessed using : https://testng.org/doc/documentation-main.html

The annotations above will also be honored (inherited) when placed on a superclass of a TestNG class. 
This is useful for example to centralize test setup for multiple test classes in a common superclass.
In that case, TestNG guarantees that the "@Before" methods are executed in inheritance order 
(highest superclass first, then going down the inheritance chain),
 and the "@After" methods in reverse order (going up the inheritance chain).
 
 TestNG.xml will help you run a suite of tests.
 
***package com.guide.beginners.testng.samplejava.tutorial1*** 
-should share insight on how testNG works

***package com.guide.beginners.testng.theinternet;*** 
-should share insight on usage of testNG with selenium

 
 