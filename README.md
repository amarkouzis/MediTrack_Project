# MediTrack Project

### Introduction
___

The speed of modern life drags us along, more and more with it. Every day we neglect important parts of our lives, just trying to keep up with these rhythms. Among all the things we leave aside is also our health, which is very important. This phenomenon is particularly common, especially in older people. Recognising all of the above, the MediTrack app comes to fill this gap by offering its users an easier way to manage the various medications they need to take. It aims to organize a database where the user records all the information about the medicines he needs to take and at the same time provides easy access to this database in order to inform the user about his records.

### Design and develop from scratch
___

The MediTrack application was created in the Android Studio environment based on Java. The application is structured in 6 different Activities. Two of them are aimed at registering the user in the application and also at logging the user in, if there is already an account. The information is taken from the app and sent to an online database in Firebase, where it is kept even after the app is deleted from the device. Then, after the registration/login of the user, we go to the user's home screen where there is the Activity with the main functions of the application. The first function is to scan the medical treatment and store the recognized text in Firebase. This is achieved by using a Firebase package called ML Kit, which is capable of recognizing text in photos. In the present project the free version of this package was used, so it is possible to recognize only Latin characters and numbers. Next, we have the user's access to these logs and finally an option for the account settings, where the user's data can be edited and a medication can be deleted.
