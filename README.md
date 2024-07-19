# gsauto-test-task

## Test Code Tasks

1. Download the following zip file.
2. Extract and open the project in IntelliJ.
3. Follow the task instructions below.
4. Allow up to **90 minutes** for all three tasks.
5. Zip up your project and attach it to this page.

[Download TestCodeTask.zip](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c9d82a37-627b-4ac5-832f-4c7e0f41b93e/TestCodeTask.zip)

## Task 1: Cucumber FixMe

- The test with the tag `@FixMe` used to work but has broken. Fix this test so it runs.
- Remove the `@FixMe` tag once the test is fixed.
- Change the test so the search term is a parameter in the Gherkin scenario.

## Task 2: Write a New Test

Create a new test that takes the following steps:

1. Go to [Google UK](https://www.google.co.uk).
2. Type in the search term "BBC".
3. Click on "I’m Feeling Lucky".
4. Verify that the browser has been redirected to a URL containing the search term.

Ensure this is written with behavioral steps, rather than procedural steps as listed above.

## Task 3: Refactor Test Code

- Improve both tests by creating a Page Object for the Google Homepage.
- Wrap up the wait and Selenium logic into reusable methods.
- Tag both tests to assign the test a “Smoke” test.
