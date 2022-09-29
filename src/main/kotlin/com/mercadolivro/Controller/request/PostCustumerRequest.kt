package com.mercadolivro.Controller.request

import com.mercadolivro.validation.EmailAvaliable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PostCustumerRequest (
    @field:NotEmpty(message = "Nome deve ser informado")
    var name: String,

    @field:Email(message = "E-mail deve ser válido")
    @EmailAvaliable
    var email: String
    )