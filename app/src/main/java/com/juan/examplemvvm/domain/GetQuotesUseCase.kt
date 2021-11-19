package com.juan.examplemvvm.domain

import com.juan.examplemvvm.data.QuoteRepository
import com.juan.examplemvvm.data.model.QuoteModel

class GetQuotesUseCase {
    private val repository = QuoteRepository()

    suspend operator fun invoke() : List<QuoteModel> ? {
        return repository.getAllQuotes()
    }
}