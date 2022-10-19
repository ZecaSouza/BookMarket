package com.mercadolivro.events.listener

import com.mercadolivro.events.PurchaseEvents
import com.mercadolivro.service.BookService
import com.mercadolivro.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.*

@Component
class UpdateSoldBookListener(
    private val bookService: BookService
) {

    @Async
    @EventListener
    fun listen(purchaseEvents: PurchaseEvents){
        bookService.purchase(purchaseEvents.purchaseModel.books)
    }

}