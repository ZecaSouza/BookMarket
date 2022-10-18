package com.mercadolivro.Controller.mapper

import com.mercadolivro.Controller.request.PostPurchaseRequest
import com.mercadolivro.model.PurchaseModel
import com.mercadolivro.service.BookService
import com.mercadolivro.service.CostumerService
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    private val bookService: BookService,
    private val custumerService: CostumerService
) {

    fun toModel(request: PostPurchaseRequest): PurchaseModel {
        val customer = custumerService.getById(request.customerId)
        val books = bookService.findAllByIds(request.bookIds)

        return PurchaseModel(
            customer = customer,
            books = books.toMutableList(),
            price = books.sumOf { it.price }
        )
    }

}