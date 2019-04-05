package com.example.suhas.traininfo.TrainInfoJSONClasses

import com.google.gson.annotations.SerializedName

data class TrainInfoPOJO(@SerializedName("response_code")
                         val responseCode: Int = 0,
                         @SerializedName("debit")
                         val debit: Int = 0,
                         @SerializedName("train")
                         val train: Train)