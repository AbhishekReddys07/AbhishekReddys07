import datetime
import _thread

# Get the current date and time
current_datetime = datetime.datetime.now()

# Extract the date and time components
current_date = current_datetime.date()
nxtdate = current_datetime.today()


# Calculate the date for the next three days
next_three_days = [current_date + datetime.timedelta(days=i) for i in range(1, 4)]

# Print the current date and time
print("Current Date:", current_date)
for date in next_three_days:
    if(current_date==date):
        print("shut down")
else:
    print("not sat")
    _thread.start_new_thread()

