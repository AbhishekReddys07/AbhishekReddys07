import os
import time


def mai():
    local_time = time.localtime()
    count = 0
    time.strftime("%H:%M:%S", local_time)
    hour = local_time.tm_hour
    minute = local_time.tm_min
    minutes = minute
    hour1 = hour
    # print('current minutes --> ' + str(hour1)+":"+str(minutes))
    minutesFunction(minutes, hour1, count)


def minutesFunction(minutes, hour1, count):
    # print(hour1)
    if hour1 == 24:
        count += 1
        hour1 = 0
        if count == 1:
            print("off"+" "+str(count))
            shutdown_pc()
        else:
            print("noo 2")
            minutesFunction(minutes, hour1, count)
    else:
        for i in range(minutes, 59):
            if minutes <= 59:
                time.sleep(2)
                minutes += 1
                print(f'{hour1:02d}:{minutes:02d}')
                # print(str(hour1)+" "+str(minutes))
                if minutes == 59:
                    minutes = 0
                    hour1 += 1
                    print('Time --> ' + str(hour1) + ":" + str(minutes))

                    minutesFunction(minutes, hour1, count)


def shutdown_pc():
    os.system('shutdown /s /t 1')

mai()
