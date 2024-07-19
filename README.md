# Test Code Tasks

## Getting Started

1. **Fork this Repository:**
   - Navigate to the repository page on GitHub: https://github.com/gymshark/gsauto-test-code-task
   - Click on the `Fork` button at the top right of the page to create your own copy of the repository.

2. **Clone Your Fork:**
   - Open your terminal or Git Bash.
   - Clone your forked repository to your local machine using the following command (replace this with your username and forked repo, e.g. https://github.com/owynowyn/gsauto-test-code-task):
     ```sh
     git clone https://github.com/your-username/your-forked-repo.git
     ```

3. **Open the Project in IntelliJ:**
   - Open IntelliJ IDEA.
   - Navigate to `File > Open` and select the cloned repository directory.

4. **Follow the Task Instructions Below:**
   - Complete the tasks as outlined in the instructions below.

5. **Allow up to 90 Minutes for All Three Tasks:**
   - Ensure you complete all tasks within the allocated time.

6. **Commit and Push Your Changes:**
   - After completing the tasks, commit and push your changes to your local repository.

7. **Create a Pull Request:**
   - Go to your forked repository on GitHub.
   - Click on the `Compare & pull request` button to submit your changes to the original repository.
   - Provide a meaningful description of the changes you made and submit the pull request.

## Task Instructions

### Task 1: Cucumber FixMe
- The test with the tag `@FixMe` used to work but has broken. Fix this test so it runs.
- Remove the `@FixMe` tag once the test is fixed.
- Change the test so the search term is a parameter in the Gherkin scenario.

### Task 2: Write a New Test
- Create a new test that takes the following steps:
  1. Go to Google UK.
  2. Type in the search term "BBC".
  3. Click on "I’m Feeling Lucky".
  4. Verify that the browser has been redirected to a URL containing the search term.
- Ensure this is written with behavioral steps, rather than procedural steps as listed above.

### Task 3: Refactor Test Code
- Improve both tests by creating a Page Object for the Google Homepage.
- Wrap up the wait and Selenium logic into reusable methods.
- Tag both tests to assign the test a “Smoke” test.
