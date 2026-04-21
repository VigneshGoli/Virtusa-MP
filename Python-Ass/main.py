import csv
import matplotlib.pyplot as plt
from datetime import datetime

FILE_NAME = "expenses.csv"

# Add expense
def add_expense():
    date = input("Enter date (DD-MM-YYYY): ")
    try:
        datetime.strptime(date, "%d-%m-%Y")
    except ValueError:
        print("Invalid date format! Please use DD-MM-YYYY.\n")
        return

    category = input("Enter category (Food/Travel/Bills/etc): ")
    amount = float(input("Enter amount: "))
    description = input("Enter description: ")

    with open(FILE_NAME, mode='a', newline='') as file:
        writer = csv.writer(file)
        writer.writerow([date, category, amount, description])

    print("Expense added successfully!\n")


# View all expenses
def view_expenses():
    with open(FILE_NAME, mode='r') as file:
        reader = csv.reader(file)
        for row in reader:
            print(row)


# Monthly summary
def monthly_summary():
    month = input("Enter month (MM-YYYY): ")
    total = 0

    with open(FILE_NAME, mode='r') as file:
        reader = csv.DictReader(file)
        for row in reader:
            try:
                row_date = datetime.strptime(row['date'], "%d-%m-%Y")
                if row_date.strftime("%m-%Y") == month:
                    total += float(row['amount'])
            except ValueError:
                continue

    print(f"Total expense for {month}: {total}")


# Category summary
def category_summary():
    categories = {}

    with open(FILE_NAME, mode='r') as file:
        reader = csv.DictReader(file)
        for row in reader:
            cat = row['category']
            amt = float(row['amount'])

            if cat in categories:
                categories[cat] += amt
            else:
                categories[cat] = amt

    for cat, amt in categories.items():
        print(cat, ":", amt)

    return categories


# Highest spending category
def highest_category():
    categories = category_summary()

    if categories:
        max_cat = max(categories, key=categories.get)
        print("Highest spending category:", max_cat)
    else:
        print("No data available")


# Pie chart
def show_pie_chart():
    categories = category_summary()

    if categories:
        labels = list(categories.keys())
        values = list(categories.values())

        plt.pie(values, labels=labels, autopct='%1.1f%%')
        plt.title("Expense Distribution")
        plt.show()
    else:
        print("No data to display")


# Main menu
def main():
    while True:
        print("\n--- Expense Tracker ---")
        print("1. Add Expense")
        print("2. View Expenses")
        print("3. Monthly Summary")
        print("4. Category Summary")
        print("5. Highest Spending Category")
        print("6. Show Pie Chart")
        print("7. Exit")

        choice = input("Enter your choice: ")

        if choice == '1':
            add_expense()
        elif choice == '2':
            view_expenses()
        elif choice == '3':
            monthly_summary()
        elif choice == '4':
            category_summary()
        elif choice == '5':
            highest_category()
        elif choice == '6':
            show_pie_chart()
        elif choice == '7':
            print("Exiting program...")
            break
        else:
            print("Invalid choice!")


if __name__ == "__main__":
    main()