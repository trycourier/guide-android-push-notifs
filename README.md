# Android Push Notification App

This is a simple Android application that demonstrates how to implement push notifications using the Courier Android SDK. The app allows you to send push notifications to devices using Firebase Cloud Messaging (FCM) as the push notification provider.

## Requirements

- Android Studio
- Firebase Cloud Messaging (FCM) setup (instructions provided below)

## Setup

To get started with the Android Push Notification App, follow these steps:

1. Clone this repository to your local machine.
2. Open the project in Android Studio.
3. Install the required packages by running the following command in the terminal: `./gradlew build`
4. Go into MyApplication.kt, replace `YOUR_AUTH_KEY` with your auth key and `YOUR_COURIER_ID` with the appropriate id.

This will download and install all the necessary dependencies for the project (including the Courier Android SDK 2.0.2).

## Firebase Cloud Messaging (FCM) Setup

Before you can send push notifications using this app, you need to set up Firebase Cloud Messaging (FCM) and link it with your Courier dashboard. Here's how you can do it:

1. Go to the [Firebase Console](https://console.firebase.google.com/).
2. Create a new project and follow the instructions to set up FCM for Android. Make sure to follow the steps to implement the SDK into the project.
3. Download the google-services.json file and add it to the root of this Android project.
4. In your Firebase project settings, go to the "Service accounts" tab and generate a new private key. Download this JSON for later.
5. Once you've set up FCM, go to the [Courier Dashboard](https://app.courier.com/).
6. In "Channels", Add Firebase Cloud Messaging (FCM) as a new provider. This will require your Firebase "Service Account JSON" - paste in the JSON you saved in step 4.

## Sending Push Notifications

To send push notifications using this app, follow these steps:

1. Run the app on an Android device (a physical device is recommended as Courier does not support the emulator). You will need to turn on developer options and USB debugging.
2. Once you've installed the app on your device, go to the settings for this app and allow push notifications.
3. To check that your app can receive a basic push notification, send the following cURL request:

```curl --request POST   --url https://api.courier.com/send   --header 'Authorization: Bearer <YOUR_COURIER_AUTH_KEY>'   --header 'Content-Type: application/json'   --data '{
    "message": {
        "to": {
            "user_id": "<YOUR_COURIER_USER_ID>"
        },
        "content": {
            "title": "Hey there 👋",
            "body": "Have a great day 😁"
        },
        "routing": {
            "method": "all",
            "channels": [
                "firebase-fcm"
            ]
        }
    }
}'```

