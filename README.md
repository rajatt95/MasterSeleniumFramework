# OC_MasterSeleniumFramework
With further updates - This project is designed and developed with the help of -
1. Udemy course (OmPrakash Chavan - Selenium Java Test Framework & Best Practices - Masterclass)
2. YouTube playlist (Testing Mini Bytes - Selenium Automation Framework with Real-time dashboard)

It has a concept of Atomic tests (Achieved by Selenium WebDriver API and RestAssured API)
------------------------------------------------------------
![image](https://user-images.githubusercontent.com/26399692/135917549-ee1e000a-ce07-4051-89b1-b57ec9b6b9b7.png)
------------------------------------------------------------
Updations done:
------------------------------------------------------------
**ExtentReports V5** 
1. User can apply the Filters - 
- Author - Rajat, Nishant, Gautam, Pankaj 
- Browser - Chrome, Edge, Safari, Firefox 
- TestType - Smoke, Sanity, Regression, BVT

2. Screenshots are attached in the ExtentReport as Base64 format.
![image](https://user-images.githubusercontent.com/26399692/135918483-ca9320af-83da-4b55-b3d7-24449cc1bd04.png)
![image](https://user-images.githubusercontent.com/26399692/135918943-a430a4fc-dd05-4803-9765-dbb94bb4fd89.png)

------------------------------------------------------------
**Allure Reports** 
![image](https://user-images.githubusercontent.com/26399692/135977881-10e654b4-6224-4aa9-8343-841af16aeeb3.png)
------------------------------------------------------------
**User has options for customization**
![image](https://user-images.githubusercontent.com/26399692/135927821-1e293278-14f2-4ad2-94dc-5505b080680d.png)
------------------------------------------------------------
**Email to User(s) using Java mail API**
![image](https://user-images.githubusercontent.com/26399692/135975570-d520d163-a7eb-4695-b22c-a25979415ef5.png)
------------------------------------------------------------
**Others implementations:**
1. Retry failed test cases
2. Custom Enums, Exceptions, Annotations 
3. Serialization and Deserialization using Jackson-Databind dependency
4. Data Driven testing using JSON file
5. Zip the ExtentReports directory into Project path (you can send this Zip file as well as an Attachment in Email)
6. Automatically open the report after tests execution.
7. Request details added in ExtentReports:
<img width="938" alt="Reports" src="https://user-images.githubusercontent.com/26399692/137579695-25e94096-fce3-4c1b-936c-65b62a976c36.png">
9. Send EMail using Java mail API to User(s) with attachment(s).
        https://mvnrepository.com/artifact/javax.mail/mail/1.4.7
        https://www.tutorialspoint.com/java/java_sending_email.htm
        Gmail -> 
        Manage your Google account: 
        ![image](https://user-images.githubusercontent.com/26399692/137579797-578b5235-d66e-4254-8f44-befabdf5696d.png)-> 
        Security -> 
        Turn on : Less Secure App access:
        ![image](https://user-images.githubusercontent.com/26399692/137579818-ce2b441c-20da-45a7-a04e-18a68250a1c9.png)

------------------------------------------------------------
**How to run the Project from Local machine**
1. Pull the code into your machine and import in IDE (Eclipse/intelliJ).
2. Go to testng_Local.xml -> Run this file as TestNG suite
  It should start the execution -> Parallel Cross Browser Testing.
 - **NOTE:** stg_config.properties is the default configuration file.
3. To view the Allure reports 
 - Setup the Allure in your machine
 - Go to URL (https://docs.qameta.io/allure/) -> Search for Manual installation -> Steps are mentioned
 - Go to your project location
 - Open command prompt -> allure serve allure-results
------------------------------------------------------------
**How to run the Project from Jenkins**
[__Final-OC_Selenium-Github-ActiveChoiceParams.pdf](https://github.com/rajatt95/MasterSeleniumFramework/files/7314914/__Final-OC_Selenium-Github-ActiveChoiceParams.pdf)
![image](https://user-images.githubusercontent.com/26399692/136642687-ce999564-df0a-4c64-a4e5-bccc05ef0388.png)
------------------------------------------------------------
**Email to User(s) using Jenkins:**
1. You can refer: https://www.youtube.com/watch?v=MFgbp00hbVI&ab_channel=Mukeshotwani
![image](https://user-images.githubusercontent.com/26399692/136642963-4a658292-b024-421c-ad7c-ada22777128b.png)
------------------------------------------------------------
