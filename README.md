
# Banking Exercise Project

This project is designed to help students practice Java programming, object-oriented principles, and basic testing with JUnit. The project consists of a simple banking system where students need to complete certain methods and make the provided test functions work correctly.

## Project Structure

The project contains the following main classes:

1. **Bank**: Manages clients and their accounts.
2. **BankAccount**: Represents an individual bank account with basic balance operations.
3. **Client**: Represents a bank client with personal details and a list of accounts.
4. **BankTest**: Contains JUnit tests to verify the functionality of the Bank system.

Each class has incomplete methods that need to be implemented.

## Instructions

### Task 1: Complete the Code

1. Open each class file and implement the unfinished methods marked with comments. The goal is to create a fully functional banking system where clients can log in, manage accounts, and perform transactions.

2. Pay attention to the requirements provided in the comments within each method. For example:
   - In `Bank`, ensure clients can only log in with valid credentials.
   - In `BankAccount`, ensure only valid transactions (e.g., non-negative balances) are allowed.
   - In `Client`, handle edge cases for adding or removing accounts.

### Task 2: Run the JUnit Tests

After completing the methods, run the tests in `BankTest.java` to verify your implementation. Make sure the tests pass successfully.

## Setting up the Project in IntelliJ IDEA

Follow these steps to open the project in IntelliJ IDEA and set up JUnit for testing.

### Step 1: Open the Project

1. Open IntelliJ IDEA.
2. Select **Open** from the welcome screen.
3. Navigate to the folder containing this project and open it.
4. If needed select an SDK

### Step 2: Set Up JUnit

To run the tests, JUnit must be added as a library.

1. Go to the BankTest.java file in the IDE
2. Expand the imported modules
3. Place the cursor on junit and press Alt + Enter
4. Select 'Add 'JUnit4' to class path', then select OK.

### Step 3: Run the Tests

1. Open `BankTest.java`.
2. Right-click anywhere in the code and select **Run 'BankTest'** to execute all test cases.
3. Check the test results. Any failed tests indicate methods that need further debugging or completion.

### Troubleshooting

- If you encounter issues with JUnit not being recognized, double-check that the library is correctly added to the project.
- Refer to the comments within each method for guidance on implementing the logic required for the tests to pass.

---

#### IMPLEMENTED 🔥 [https://github.com/ShakilAhmmed/macs-vub-bank-v2]