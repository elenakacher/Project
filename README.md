## **Automated test project for an online bookstore** <a href="https://latest.oscarcommerce.com/" target="_blank"> <b> Oscar Sandbox </b></a>
The graduation paper of the Tel-Ran School testers' group. Practical application what I have learned at school.

<a target="_blank">
  <img src="https://github.com/elenakacher/Project/blob/master/images/OscarSandbox.jpg">
</a>


### **Objective of the project**

- Creating of test documentation (testplan, testsuits, testcases, checklists)
- Identification and description of bugs (bugreports)
- Automating the testing of an online bookstore. 
- Compilation of a set of autotests for smoke testing of the pilot version of the website to regularly and effectively test the performance of the site when extending its functionality
- Compilation of a set of autotests for regression testing to regularly and effectively test of the site's performance when fixing bugs and make changes to the programm code. 

### **Description**

The whole body of work was divided into four parts: 
- **Home Page**
- **User**
- **Product**
- **Basket**
  
My colleague and I developed the **Basket** part. You can see the **Test plan** <a href="https://docs.google.com/spreadsheets/d/1E53fUlBurmhZyhmSGJSuPg5L7KQCmIgu/edit?usp=sharing&ouid=107532909200609964385&rtpof=true&sd=true" target="_blank"> here</a>.

<details><summary> Example of <b>test-suites</b> and <b>test-case</b> in the <b>TestLink</b> </summary>

<a target="_blank" width="50%" heidth="50%">
  <img src="https://github.com/elenakacher/Project/blob/master/images/testlinkExample.jpg">
</a>

</details>

<details><summary> <b>Mind Map</b> for the part <b>Basket </b></summary>

<a target="_blank" width="50%" heidth="50%">
  <img src="https://github.com/elenakacher/Project/blob/master/images/mindMap.jpg">
</a>

</details>

### **Testing was implemented using:**
| Selenium 3.141 | Java 11 | Gradle | IntelliJ IDEA | Jenkins | Atlassian Jira | TestLink | MindMup
|--------|:-------|:-------|:-------|:-------|:-------|:-------|:-------| 
|<p align="center"><a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/selenium.svg" align="center" alt="selenium" width="40" height="40" /> </a></p> | <p align="center"> <a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/java-original-wordmark.svg" alt="java" width="40" height="40"/> </a> </p> | <p align="center"> <a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/gradle.svg" alt="gradle" width="40" height="40"/> </a> </p> | <p align="center"> <a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/intellij-idea.svg" alt="IntelliJ" width="40" height="40"/> </a></p> | <p align="center"> <a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/jenkins-original.svg" alt="jenkins" width="40" height="40"/> </a></p> | <p align="center"> <a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/jira.svg" alt="jira" width="40" height="40"/> </a> </p> | <p align="center"> <a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/testlink.png" alt="testlink" width="40" height="40"/> </a></p> | <p align="center"> <a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/MindMup.png" alt="mindmup" width="40" height="40"/> </a></p>


## **Manual testing**

Manual testing of the website took approximately 6 hours.

During manual testing of the first version of the website, bugs were found, which I described in detail in the **Jira** software. An example of the description of some bugs can be seen <a href="https://github.com/elenakacher/Project/blob/master/images/bugReports.pdf" target="_blank"> here</a>. I found a total of 10 bugs in the Basket section. 7 of them were fixed in the final version of the site and 2 are marked as features. 

## **Automated testing**

75 tests were performed for 23 min. 

### **UI testing**
UI testing was carried out on the Homepage, Book page and the Products page.
- Check of the broken links on the Homepage
- Check of the Breadcrumbs on Products and Book page 
- Check of required submenu items for the Catalogue menu on the Products page
- Check of the required information on the Book page

### **Functional testing. What's special:**

- Page Object Model
- Parameterized assembly
- Regex
- DataProvider for loading data from files
- MyListener for generating reports
- Autotests are run on the Jenkins server

### **How to run**

1. Clone the project on your computer
2. Run cmd and make sure you are in the project folder
![Image alt](https://github.com/elenakacher/Project/blob/master/images/cmd1.jpg)
3. Write command to run corresponding set of autotests
```
gradlew testngUser
```
or
```
gradlew testngProduct
```
or
```
gradlew testngBasket
```
or
```
gradlew testngSmoky
```
or
```
gradlew testngRegression
```
### **How to use this project**
In the project have been used many generic methods to access and process web page objects. Thay could be used in the another test projects.
For example:
- clickWithJSExecutor
- typeWithJSExecutor
- pause
- isElementPresent
- checkBrockenImages
- verifyLinks
- takeScreenshotMyListener
- takeScreenshotWithScrollDown
- ...
