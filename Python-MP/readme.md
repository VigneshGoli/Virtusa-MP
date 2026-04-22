# FareCalc - CityCab Fare Calculator

A simple Python command-line application that calculates cab fare based on:
- Distance in kilometers
- Vehicle type (Economy, Premium, SUV)
- Hour of travel (with surge pricing support)

This project is beginner-friendly and demonstrates clean use of dictionaries, functions, conditional logic, and basic error handling in Python.

## Features

- Calculates fare using fixed per-km rates
- Supports 3 vehicle categories:
  - Economy: Rs 10/km
  - Premium: Rs 18/km
  - SUV: Rs 25/km
- Applies surge pricing (1.5x) during peak hours (5 PM to 8 PM)
- Handles invalid inputs gracefully
- Prints a clean price receipt in the console

## Project Structure

- `main.py` - Main Python script containing:
  - Rate configuration
  - Fare calculation logic
  - Command-line interaction

## Requirements

- Python 3.7 or above
- No external libraries required

## How It Works

1. User enters travel distance in km.
2. User selects vehicle type: Economy, Premium, or SUV.
3. User enters travel hour (0 to 23).
4. Program computes fare using:

   Base Fare = distance x vehicle_rate

5. If travel hour is between 17 and 20 (inclusive), surge is applied:

   Final Fare = Base Fare x 1.5

6. Program displays receipt with total fare.

## Run the Program

Open terminal in the project folder and run:

```bash
python main.py
```

## Sample Input/Output

Example 1 (with surge):

```text
----- CityCab Fare Calculator -----
Enter distance (in km): 12
Enter vehicle type (Economy/Premium/SUV): Premium
Enter hour of travel (0-23): 18

----- Price Receipt -----
Distance: 12.0 km
Vehicle Type: Premium
Travel Hour: 18
Surge Pricing Applied (1.5x)
Total Fare: ₹ 324.0
```

Example 2 (invalid vehicle type):

```text
----- CityCab Fare Calculator -----
Enter distance (in km): 10
Enter vehicle type (Economy/Premium/SUV): Mini
Enter hour of travel (0-23): 12
Service Not Available
```

## Error Handling

The program safely handles:
- Non-numeric distance input
- Invalid hour format
- Unexpected input errors

If an input error occurs, the app prints:

```text
Invalid input! Please enter correct values.
```

## Notes

- Vehicle type matching is case-sensitive in the current implementation.
  - Valid values: `Economy`, `Premium`, `SUV`
- Currency symbol shown is Indian Rupee (₹).

## Future Improvements

- Case-insensitive vehicle type support
- Input validation for negative distance values
- Unit tests for `calculate_fare`
- Optional support for coupon/discount logic

## Author

Goli Vignesh
