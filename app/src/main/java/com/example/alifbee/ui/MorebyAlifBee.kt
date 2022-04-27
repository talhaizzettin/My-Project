package com.example.alifbee.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.alifbee.R
import com.example.alifbee.databinding.ActivityMorebyAlifBeeBinding
import com.example.alifbee.model.Apps
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.apps.view.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.net.URL
import javax.net.ssl.HttpsURLConnection


private lateinit var binding: ActivityMorebyAlifBeeBinding
lateinit var top_title : TextView
lateinit var back_img : ImageView
var apps_con : Int = 0
var my_context:Context?=null

class MorebyAlifBee : AppCompatActivity() {
    var adapter:appAdapter?=null
    var listOfApps=ArrayList<Apps>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMorebyAlifBeeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        top_title = findViewById(R.id.tob_bar_text)
        back_img = findViewById(R.id.back_bu)
        top_title.text = resources.getString(R.string.more_by_alifBee)
        back_img.setOnClickListener{
            val intent = Intent(this@MorebyAlifBee,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        my_context = this
        load()



    }
    fun load(){
        val url ="https://api01.arabiansinbad.com/api/v2/general/initial"
        //listOfApps.add(Apps(R.drawable.img1,"AlifBee - Learn Arabic The Easy Way","Discover the fun world of Arabic with the AlifBee Kids - Let them have fun while ...",""))
        //listOfApps.add(Apps(R.drawable.img2,"AlifBee - Learn Arabic The Easy Way","Discover the fun world of Arabic with the AlifBee Kids - Let them have fun while ...",""))
       // listOfApps.add(Apps(R.drawable.img3,"AlifBee - Learn Arabic The Easy Way","Discover the fun world of Arabic with the AlifBee Kids - Let them have fun while ...",""))
       // listOfApps.add(Apps(R.drawable.img4,"AlifBee - Learn Arabic The Easy Way","Discover the fun world of Arabic with the AlifBee Kids - Let them have fun while ...",""))
        MyClass().execute(url)
    }

    inner class MyClass:AsyncTask<String,String,String>(){
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg p0: String?): String {
            try {
                val url= URL(p0[0])
                val urlCon = url.openConnection() as HttpsURLConnection
                urlCon.connectTimeout= 1000

                val dataFromUrl = dataToStr(urlCon.inputStream)
                publishProgress(dataFromUrl)

            }catch (ex:Exception){

            }
            return ""
        }

        override fun onProgressUpdate(vararg values: String?) {
            val json=JSONObject(values[0])
            val body = json.getJSONObject("body")
            val our_apps = body.getJSONObject("our_apps")
            val en_apps  = our_apps.getJSONArray("en")

            apps_con = en_apps.length()-1

            for (index in 0..apps_con){
                var app = en_apps.getJSONObject(index)
                listOfApps.add(Apps(app.getString("icon"),app.getString("title"),app.getString("description"),app.getString("android_link")))
            }
            adapter = appAdapter(listOfApps, my_context as MorebyAlifBee)
            binding.listOfApp.adapter= adapter
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
        }

    }


    class appAdapter:BaseAdapter{
        var context:Context?=null
        var listOfApps2=ArrayList<Apps>()
        constructor(listOfApps:ArrayList<Apps>,context:Context){
            listOfApps2=listOfApps
            this.context=context
        }
        override fun getCount(): Int {
            return listOfApps2.size
        }

        override fun getItem(p0: Int): Any {
            return listOfApps2[p0]
        }

        override fun getItemId(p0: Int): Long {
            return  p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val app = listOfApps2[p0]
            val inflator=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val appsVime = inflator.inflate(R.layout.apps,null)
            val img : ImageView = appsVime.findViewById(R.id.apps_img)
            val nam : TextView = appsVime.findViewById(R.id.apps_name)
            val dis : TextView = appsVime.findViewById(R.id.apps_dis)
           // img.setImageResource(app.app_img!!)
            Picasso.get().load(app.app_img).into(img)
            nam.setText(app.app_name!!)
            dis.setText(app.app_dis!!)


            return appsVime
        }

    }



    fun dataToStr (input: InputStream):String{
        val buffer = BufferedReader(InputStreamReader(input))
        var line:String
        var data: String=""


            line=buffer.readLine()
            data+= line

        buffer.close()
        return data
    }
}