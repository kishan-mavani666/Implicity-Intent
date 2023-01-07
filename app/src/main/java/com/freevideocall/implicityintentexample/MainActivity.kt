package com.freevideocall.implicityintentexample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_dial.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel: +919876543210")
            startActivity(intent)
        }

        btn_msg.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("smsto:" + Uri.encode("+919876543210"))
            intent.putExtra("sms_body", "send any sms")
            startActivity(intent)
        }

        btn_email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("abc@gmail.com", "xyz@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Queries")
            intent.putExtra(Intent.EXTRA_TEXT, "Please Solve This")
            startActivity(Intent.createChooser(intent, "Email via"))
        }

        btn_share.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Download This Video Link")
            startActivity(Intent.createChooser(intent, "Share via"))
        }
    }
}