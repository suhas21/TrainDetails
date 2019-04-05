package com.example.suhas.traininfo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.suhas.traininfo.TrainInfoJSONClasses.TrainInfoPOJO
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun findResults(v:View)
    {
        val r = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.railwayapi.com/").build()
        val a3 = r.create(TrainInfoINFF::class.java)
        val z = et1.text.toString().toInt()
        val call: Call<TrainInfoPOJO> = a3.getName(z)

        call.enqueue(object : retrofit2.Callback<TrainInfoPOJO> {
            override fun onFailure(call: Call<TrainInfoPOJO>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed", Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<TrainInfoPOJO>, response: Response<TrainInfoPOJO>) {
                Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
                val list = mutableListOf<String>()
                val tname = response.body()
                list.add("Train Name:" + tname!!.train.name)
                list.add("Train Num:" + tname.train.number)
                val days = tname.train.days
                val seats = tname.train.classes
                list.add("Running Days")
                for (x in days!!) {
                    list.add("DAY:" + x.code)
                    list.add("RUNS:" + x.runs)
                    list.add(" ")
                }
                list.add("Types of Seats Available")
                for (x in seats!!) {
                    list.add("Name:" + x.name)
                    list.add("Code:" + x.code)
                    list.add("Available:" + x.available)
                    list.add(" ")
                }
                val myadapter = ArrayAdapter(this@MainActivity, R.layout.myownstyle, list)
                Lview.adapter=myadapter

            }
        })
    }
}
