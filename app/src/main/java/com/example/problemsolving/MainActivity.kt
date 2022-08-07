package com.example.problemsolving

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.ds.stack.APIInterface
import com.example.ds.stack.Status
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    val BASE_URL = "https://dl.dropboxusercontent.com/s/p57gxwqm84zkp96/"
    private val TAG = "MainActivity"
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.tvTextView)
        getMyData()
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(APIInterface::class.java)

        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<Status> {
            override fun onResponse(call: Call<Status>, response: Response<Status>) {
                val responseBody = response.body()!!
                Log.d("Message ", responseBody.Message)
                Log.d("RecordCount ", responseBody.RecordCount)
                Log.d("Status ", responseBody.Status.toString())


                for (i in 0 until responseBody.Result.size) {
                    Log.d("CategName ", responseBody.Result[i].CategName)
                    Log.d("CurrencySymbol ", responseBody.Result[i].CurrencySymbol)
                    Log.d("DealCategoryID ", responseBody.Result[i].DealCategoryID)
                    Log.d("DealID ", responseBody.Result[i].DealID)
                    Log.d("Description ", responseBody.Result[i].DealType)
                    Log.d("Description ", responseBody.Result[i].Description)
                    Log.d("Discount ", responseBody.Result[i].Discount)
                    Log.d("Image ", responseBody.Result[i].Image)
                    Log.d("MemberTier ", responseBody.Result[i].MemberTier)
                    Log.d("PromoCode ", responseBody.Result[i].PromoCode)
                    Log.d("StoreID ", responseBody.Result[i].StoreID)
                    Log.d("StoreName ", responseBody.Result[i].StoreName)
                    Log.d("TOC ", responseBody.Result[i].TOC)
                    Log.d("Title ", responseBody.Result[i].Title)
                    Log.d("TowerNumber ", responseBody.Result[i].TowerNumber)
                    Log.d("ValidityEnd ", responseBody.Result[i].ValidityEnd)
                    Log.d("ValidityStart ", responseBody.Result[i].ValidityStart)
                    Log.d("isFav ", responseBody.Result[i].isFav + "\n\n")
                }

            }

            override fun onFailure(call: Call<Status>, t: Throwable) {
                Log.d(TAG, "OnFailure: " + t.message)

            }

        }
        )
    }
}