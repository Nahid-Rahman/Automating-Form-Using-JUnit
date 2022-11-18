# Automating-Form-Using-JUnit

## ABOUT THIS PROJECT
  Here I tried to automate a form using JUnit.
  Form Link: https://demoqa.com/automation-practice-form
  
  Tasks done here:
  - Form is automated using JUnit
  - Inputs are sent dynamically
  - Radio boxes are validated
  - Checkboxes are validated
  - Assigned a new Date of birth after removing default one
  - Address was given via input
  - Picture was added via upload, which is why it is not in resources.
  
## Test Cases  
## Positive Test Cases

  - Fill Up the form using valid data
  
## Negative Test Cases:

  Vefiy using:
  - Empty First Name
  - Empty Last Name
  - Invalid Mail
  - Empty Mail
  - No Gender
  - Invalid Phone Number
  - Empty Phone Number
  - Invalid Date of Birth
  - Empty Subject
  - Empty Hobby
  - Without Uploading Image
  - Without Selecting City and State
  
-For detailed test cases, view this spreadsheet: 
-For Bug report, view this spreadsheet: 

## Technology Used
  - Tool: Selenium
  - IDE: Intellij
  - Build tool: Gradle
  - Language: Java
  - Test_Runner: Junit
  
## How to run
  - Open the project in your editor (I used IntelliJ IDEA, so will talk about this)
  - Go to terminal
  - Write Command: gradle clean test
  
## The following screenshot is the overview of the report:
![image](https://user-images.githubusercontent.com/52327199/202682897-806ac7d2-a9af-43b7-84ef-7fa79a477682.png)
