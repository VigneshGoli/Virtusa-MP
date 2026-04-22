# Password Validator (Java)

A simple console-based Java program that validates user passwords using basic security rules.

## Project Overview

This project asks the user to enter a password and checks whether it satisfies the following conditions:

- Minimum length: 8 characters
- Must contain at least one uppercase letter (`A-Z`)
- Must contain at least one digit (`0-9`)

If the password is invalid, the program prints clear messages and asks the user to try again until a valid password is entered.

## Features

- Continuous retry loop until a valid password is provided
- Rule-by-rule feedback for invalid passwords
- Simple and easy-to-understand Java code
- Great for beginners practicing loops, conditions, methods, and input handling

## File Structure

```
Java-MP/
|-- PasswordValidator.java
|-- README.md
```

## How It Works

1. Program starts and prompts: `Enter password:`
2. It validates the entered password using `validatePassword(String password)`
3. If invalid, it prints one or more error messages and asks again
4. If valid, it prints `Password is valid.` and exits

## Validation Rules

The password must pass all checks:

1. Length must be 8 or more
2. At least one uppercase letter must exist
3. At least one digit must exist

## Requirements

- Java JDK 8 or higher
- Command Prompt, PowerShell, or terminal

## Compile and Run

Open terminal in the project folder and run:

```bash
javac PasswordValidator.java
java PasswordValidator
```

## Sample Console Output

### Example 1: Invalid then valid

```text
Enter password: abc
Too short. Minimum 8 characters required.
Missing an uppercase letter.
Missing a digit.
Please try again.

Enter password: mypassword
Missing an uppercase letter.
Missing a digit.
Please try again.

Enter password: MyPassword1
Password is valid.
```

### Example 2: Missing only digit

```text
Enter password: StrongPass
Missing a digit.
Please try again.

Enter password: StrongPass7
Password is valid.
```


<img width="384" height="95" alt="image" src="https://github.com/user-attachments/assets/19e462be-25bb-4233-b74b-d3138de018f8" />


<img width="314" height="102" alt="image" src="https://github.com/user-attachments/assets/b70caa0c-a9fc-42c0-9094-779a1e64c7dd" />4


<img width="287" height="51" alt="image" src="https://github.com/user-attachments/assets/4c8689d1-7846-4170-b079-fdea5f1869dd" />


## Learning Concepts Used

- `while (true)` loop for retry logic
- Method creation and return values (`boolean`)
- Character checking with `Character.isUpperCase()` and `Character.isDigit()`
- Input handling with `Scanner`

## Possible Improvements

- Add lowercase and special character checks
- Enforce stronger password policy
- Limit number of attempts
- Mask password input (advanced)
- Convert into GUI/web version

## Author

Add your name here.
