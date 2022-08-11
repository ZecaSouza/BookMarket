package com.mercadolivro.Controller.response

import com.mercadolivro.enums.CustumerStatus

class CustumerResponse(
    var id: Int? = null,

    var name: String,

    var email: String,

    var status: CustumerStatus
)