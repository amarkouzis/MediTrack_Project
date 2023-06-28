# MediTrack Project

### Introduction
___

The rhythm of modern life drags us along, more and more with it. Every day we neglect important parts of our lives, just trying to keep up with these rhythms. Among all the things we leave aside is also our health, which is very important. This phenomenon is particularly common, especially in older people. Recognising all of the above, the MediTrack app comes to fill this gap by offering its users an easier way to manage the various medications they need to take. It aims to organize a database where the user records all the information about the medicines he needs to take and at the same time provides easy access to this database in order to inform the user about his records.

### Design and develop from scratch
___

The MediTrack application was created in the Android Studio environment based on Java and XML. The application is structured in 6 different Activities. Two of them are aimed at registering the user in the application and also at logging the user in, if there is already an account. The information is taken from the app and sent to an online database, Firebase, where it is kept even after the app is deleted from the device (this is a main feature in external storages). Then, after the registration/login of the user, we go to the user's home screen where there is the Activity with the main functions of the application. The first function is to scan the medical treatment and store the recognized text in Firebase. This is achieved by using a Firebase package called ML Kit, which is capable of recognizing text in photos. In the present project the free version of this package was used, so it is possible to recognize only Latin characters and numbers. Next, we have the user's access to these logs and finally an option for the account settings, where the user's data can be edited and a medication can be deleted.

* Target to API 19+.


<img src="https://github.com/amarkouzis/MediTrack_Project/assets/115666194/f522ec9d-d021-4325-8293-68f93baa1916" alt="drawing" width="200"/> 
<img src="https://github.com/amarkouzis/MediTrack_Project/assets/115666194/31379a3d-2f74-4e86-9305-de0e5faca957" alt="drawing" width="200"/> 
<img src="https://github.com/amarkouzis/MediTrack_Project/assets/115666194/8b91597d-44a9-41e4-8331-a619d012b7b6" alt="drawing" width="200"/> 
<img src="https://github.com/amarkouzis/MediTrack_Project/assets/115666194/f64ecdb0-862d-4092-b3de-aeaff42698a0" alt="drawing" width="200"/> 
<img src="https://github.com/amarkouzis/MediTrack_Project/assets/115666194/c20b99da-9d60-4cc0-bf15-b377b39c834e" alt="drawing" width="200"/> 
<img src="https://github.com/amarkouzis/MediTrack_Project/assets/115666194/5ac3941b-b712-456d-b166-ce70813e8240" alt="drawing" width="200"/> 
<img src="https://github.com/amarkouzis/MediTrack_Project/assets/115666194/61fd5c1c-398a-46b2-ad93-4efb92c312ca" alt="drawing" width="200"/> 
<img src="https://github.com/amarkouzis/MediTrack_Project/assets/115666194/027b79e1-e0b6-443e-912c-bcbf83d60436" alt="drawing" width="200"/> 
