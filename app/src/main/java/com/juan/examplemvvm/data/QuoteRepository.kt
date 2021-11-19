package com.juan.examplemvvm.data

import com.juan.examplemvvm.data.model.QuoteModel
import com.juan.examplemvvm.data.model.QuoteProvider
import com.juan.examplemvvm.data.network.QuoteService

// Será la encargada de si accedemos a network o a ddbb

class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes() : List<QuoteModel> {
        val response : List<QuoteModel> = api.getQuotes() //Call to backend
        QuoteProvider.quotes = response //Save in local
        return response
    }
}