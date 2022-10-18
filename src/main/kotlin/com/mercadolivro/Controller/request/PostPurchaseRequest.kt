package com.mercadolivro.Controller.request

import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class PostPurchaseRequest(
    @field:NotNull
    @field:Positive
    val custumerId: Int,

    @field:NotNull
    val bookIds: Set<Int>
)
