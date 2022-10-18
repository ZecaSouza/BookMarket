package com.mercadolivro.Controller.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PutCustumerRequest (
    @field:NotEmpty
    var name: String,

    @field:Email
    var email: String
    )