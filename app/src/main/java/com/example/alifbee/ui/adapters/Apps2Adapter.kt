package com.example.alifbee.ui.adapters

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alifbee.R
import com.example.alifbee.model.TheApps
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.apps.view.*

class Apps2Adapter : RecyclerView.Adapter<Apps2Adapter.AppsHolder>() {

    inner class AppsHolder(itemView: View) : RecyclerView.ViewHolder(itemView)




    var apps: List<TheApps> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppsHolder {
        return AppsHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.apps,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AppsHolder, position: Int) {

            val app = apps[position]
            holder.itemView.apply {
                Picasso.get().load(app.icon).into(apps_img)
                apps_name.text = app.title
                apps_dis.text = app.description
                holder.itemView.setOnClickListener {
                    val url = Uri.parse(app.android_link)
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url.toString())))
                }
            }
    }


    override fun getItemCount() = apps.size



}