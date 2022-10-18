package com.mercadolivro.Controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PostBookRequest (
    @field:NotEmpty
    var name: String,

    @field:NotNull
    var price: BigDecimal,

    @JsonAlias("custumer_id")
    var custumerId: Int? = null
)
