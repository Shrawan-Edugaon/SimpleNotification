package com.example.simplenotification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toolbar
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val NotificationButton = findViewById<Button>(R.id.button)

        NotificationButton.setOnClickListener {
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
            {
                val imp = NotificationManager.IMPORTANCE_HIGH
                val CHANNEL_ID_ANDROID = " "
                val CHANNEL_NAME = " "
                val mNotificationChannel = NotificationChannel(CHANNEL_ID_ANDROID,CHANNEL_NAME,imp)
                val notificationBuild:Notification.Builder = Notification.Builder(this@MainActivity,CHANNEL_ID_ANDROID)
                    .setSmallIcon(R.drawable.kotlin1)
                    .setContentTitle("Simple Notification")
                    .setContentText("This is Simple Notification example!!.....")
                    .setPriority(Notification.PRIORITY_DEFAULT)

                val notificationManager:NotificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(mNotificationChannel)
                notificationManager.notify(0,notificationBuild.build())
            }
            else
            {
                val notificationBuilder2:NotificationCompat.Builder = NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.kotlin1)
                    .setContentTitle("Simple Notification...")
                    .setContentText("This is Simple Notification example!......")

                val notificationManager:NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.notify(0,notificationBuilder2.build())
            }
        }
    }
}