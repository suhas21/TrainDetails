package com.example.suhas.traininfo.TrainInfoJSONClasses

import com.google.gson.annotations.SerializedName

data class DaysItem(@SerializedName("code")
                    val code: String = "",
                    @SerializedName("runs")
                    val runs: String = "")