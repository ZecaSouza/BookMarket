package com.mercadolivro.Controller.response

import java.lang.reflect.Field

data class ErrorResponse(
    var httpCode: Int,
    var message: String,
    var internalCode: String,
    var erros: List<FieldErroResponse>?
)
