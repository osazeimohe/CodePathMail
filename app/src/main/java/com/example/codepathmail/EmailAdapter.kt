package com.example.codepathmail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>): RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //Create member variables for any view that will be set
        // as you render a row.
        lateinit var sender: TextView
        lateinit var emailTitle: TextView
        lateinit var summary: TextView
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            //Store each of the layout's views into  the public final member variables created above
            sender = itemView.findViewById<TextView>(R.id.senderTextView)
            emailTitle = itemView.findViewById<TextView>(R.id.TitleTextView)
            summary = itemView.findViewById<TextView>(R.id.summaryTextView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context =  parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.email_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val email = emails.get(position)
        holder.sender.text = email.sender
        holder.emailTitle.text = email.title
        holder.summary.text = email.summary


    }

    override fun getItemCount(): Int {
        return emails.size
    }
}