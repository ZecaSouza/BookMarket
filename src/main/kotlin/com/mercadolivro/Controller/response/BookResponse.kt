package com.mercadolivro.Controller.response

import com.mercadolivro.enums.EnumBook
import com.mercadolivro.model.CustumerModel
import java.math.BigDecimal

data class BookResponse (
    var id: Int? = null,

    var name: String,

    var price: BigDecimal,

    var custumer: CustumerModel? = null,

    var status: EnumBook? = null
        )
