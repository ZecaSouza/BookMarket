package com.mercadolivro.Controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class PostPurchaseRequest(
    @field:NotNull
    @field:Positive
    @JsonAlias("customer_id")
    val customerId: Int,

    @field:NotNull
    @JsonAlias("book_id")
    val bookIds: Set<Int>
)
