# oibsip_taskno5
## Stopwatch Android application

## **Overview**

The Stopwatch Android Application is a simple, efficient stopwatch that measures the time elapsed between its activation (when the start button is pressed) and deactivation (when the stop or hold button is pressed). This app displays the time in MM:SS:SS format, and includes three main buttons:

    **Start** - Begins tracking the time from 00:00:00.
   **Stop** - Stops the stopwatch and resets the time back to 00:00:00.
    **Hold** - Pauses the stopwatch at the current time, allowing you to resume or stop later.

The app uses the Android SystemClock to measure real-time elapsed time and provides smooth updates every millisecond.
Features

   - Start button begins the stopwatch.
   - Stop button resets the stopwatch.
   - Hold button pauses the stopwatch and saves the current time.
   - Displays time in Minutes:Seconds:Milliseconds format (MM:SS:SS).
   - Responsive user interface with clear time format.


**Requirements**

   - Android Studio (or any compatible IDE for Android development)
   - Android SDK 8 or higher.
    - An Android device or emulator for testing.
    
   ##  Installation

To get started with the project:

    - Clone this repository to your local machine:

    - git clone https://github.com/dilipkumar005/oibsip_taskno5.git

    - Open the project in Android Studio.

    - Build and run the application on an emulator or physical Android device.

## **How to Use**

Once the app is running:

   - Start: Press the Start button to begin the stopwatch. The timer starts counting in MM:SS:SS format.
    - Hold: Press the Hold button to pause the stopwatch. The time will stop updating, and the current elapsed time will be saved.
   - Stop: Press the Stop button to reset the stopwatch and display the time as 00:00:00.

**Code Explanation**
## MainActivity.java

    **Start Button:**
        Initializes the stopwatch and starts it by calling SystemClock.uptimeMillis() to get the current time in milliseconds.
        The Runnable is used to continuously update the UI with the current time in MM:SS:SS format.
   **Hold Button:**
        Pauses the stopwatch and stores the current time in timebuff. This allows you to resume the stopwatch from where it was left off.
    **Stop Button:**
        Stops the stopwatch, resets all variables (milliseconds, startTime, timebuff), and sets the displayed time back to 00:00:00.
