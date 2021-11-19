package com.juan.examplemvvm.domain

import com.juan.examplemvvm.data.QuoteRepository
import com.juan.examplemvvm.data.model.QuoteModel
import com.juan.examplemvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    operator fun invoke() : QuoteModel ? {
        val quotes = QuoteProvider.quotes //Recupera desde local
        if (!quotes.isNullOrEmpty()){
            val random = quotes.indices.random()
            return quotes[random]
        }
        return null
    }

}