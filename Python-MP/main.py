# FareCalc - Travel Optimizer

# Dictionary for rates (per km)
rates = {
    "Economy": 10,
    "Premium": 18,
    "SUV": 25
}

# Function to calculate fare
def calculate_fare(km, vehicle_type, hour):
    try:
        # Check if vehicle type exists
        if vehicle_type not in rates:
            return None

        base_rate = rates[vehicle_type]
        total = km * base_rate

        # Apply surge pricing (5 PM to 8 PM)
        if 17 <= hour <= 20:
            total = total * 1.5

        return total

    except:
        return None


# Main program
def main():
    print("----- CityCab Fare Calculator -----")  

    try:
        km = float(input("Enter distance (in km): "))
        vehicle_type = input("Enter vehicle type (Economy/Premium/SUV): ")
        hour = int(input("Enter hour of travel (0-23): "))

        fare = calculate_fare(km, vehicle_type, hour)

        if fare is None:
            print("Service Not Available")
        else:
            print("\n----- Price Receipt -----")
            print("Distance:", km, "km")
            print("Vehicle Type:", vehicle_type)
            print("Travel Hour:", hour)

            if 17 <= hour <= 20:
                print("Surge Pricing Applied (1.5x)")

            print("Total Fare: ₹", round(fare, 2))

    except:
        print("Invalid input! Please enter correct values.")


if __name__ == "__main__":
    main()