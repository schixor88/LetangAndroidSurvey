# LetangAndroidSurvey
<h4>This repo is for the andorid data collection application made during the governmental data profile development of <a href="https://goo.gl/maps/tgGxFkRRhfdYy28s6">Letang Municipality</a> situated in Morang </h4>

<h3><i>Description</i></h3>
<h5>The application is java based with minimum sdk 17 and api setting to 19, which makes it runnable with android versions of 4.4.x</h5>
<h5>Dependancy used</h5>
<ul><li>implementation 'com.ajts.androidmads.SQLite2Excel:library:1.0.4'</li>
    <li>implementation 'com.android.support:multidex:1.0.3'</li>
    <li>implementation 'com.google.firebase:firebase-core:16.0.1'</li>
    <li>implementation 'com.google.firebase:firebase-database:16.0.1'</li>
    <li>implementation 'io.paperdb:paperdb:2.1'</li>
    <li>implementation 'com.github.rey5137:material:1.2.4'</li>
   <li> implementation 'com.nabinbhandari.android:permissions:3.8'</li>
    <li>implementation 'com.google.android:flexbox:1.0.0'</li>
    <li>implementation 'com.github.medyo:fancybuttons:1.8.4'</li></ul>
    
<h5>Databases used</h5>
  <ul><li>Firebase</li><li>Android SQLite</li></ul>

<h4>System Working</h4>
<p>
The data collectors login with their respective phone number and password. The data collected during the survery is stored in the local SQLite and during the presence of working internet the data is exported as CSV to the collectors email. All the questions are in Nepali. The GPS traces Latitude, Longitute and Altitude from the simcard of the phone are stores the data in the database during collection</p>

<h5>Project Presence</h5>
 <a href="https://play.google.com/store/apps/details?id=com.kushagra.letang.test">Google Play Store</a>
