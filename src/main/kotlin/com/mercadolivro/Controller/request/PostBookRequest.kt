package com.mercadolivro.Controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class PostBookRequest (

    var name: String,

    var price: BigDecimal,

    @JsonAlias("custumer_id")
    var custumerId: Int? = null
        )
