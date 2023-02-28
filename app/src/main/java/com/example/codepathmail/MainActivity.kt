package com.example.codepathmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var emails: List<Email>
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val EmailsRv = findViewById<RecyclerView>(R.id.emailsRv)
        emails = EmailFetcher.getEmails()
        val emailAdapter = EmailAdapter(emails)
        EmailsRv.adapter = emailAdapter

        EmailsRv.layoutManager = LinearLayoutManager(this)
        findViewById<Button>(R.id.LoadMoreBtn).setOnClickListener {
            // Fetch next 5 emails and display in RecyclerView
            emails.addAll(EmailFetcher.getNext5Emails())

            emailAdapter.notifyDataSetChanged()
        }

    }
}