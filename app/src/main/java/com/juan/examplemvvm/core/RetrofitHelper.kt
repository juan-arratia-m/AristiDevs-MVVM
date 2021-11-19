package com.juan.examplemvvm.core

import com.juan.examplemvvm.utils.ConstantsAndValues
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
        //URL NNTV: http://91.126.138.138/api/channels
    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(ConstantsAndValues.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}