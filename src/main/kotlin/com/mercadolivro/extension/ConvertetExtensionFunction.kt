package com.mercadolivro.extension

import com.mercadolivro.Controller.request.PostBookRequest
import com.mercadolivro.Controller.request.PostCustumerRequest
import com.mercadolivro.Controller.request.PutBookRequest
import com.mercadolivro.Controller.request.PutCustumerRequest
import com.mercadolivro.Controller.response.BookResponse
import com.mercadolivro.Controller.response.CustumerResponse
import com.mercadolivro.enums.CustumerStatus
import com.mercadolivro.enums.EnumBook
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustumerModel

fun PostCustumerRequest.toCustumerModel(): CustumerModel{
    return CustumerModel(name = this.name, email =  this.email, status = CustumerStatus.ATIVO)
}

fun PutCustumerRequest.toCustumerModel(preveisValue: CustumerModel): CustumerModel{
    return CustumerModel(id = preveisValue.id, name = this.name, email =  this.email, status = preveisValue.status)
}

fun PostBookRequest.toBookModel(custumer : CustumerModel): BookModel{
    return BookModel(
        name = this.name,
        price = this.price,
        status = EnumBook.ATIVO,
        custumer = custumer
    )
}

fun PutBookRequest.toBookModel(preveisValue : BookModel): BookModel{
    return BookModel(
        id = preveisValue.id,
        name = this.name ?: preveisValue.name,
        price = this.price ?: preveisValue.price,
        status = preveisValue.status,
        custumer = preveisValue.custumer
    )
}

fun CustumerModel.toReponse(): CustumerResponse {
    return CustumerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status
    )

}

fun BookModel.toResponde(): BookResponse {
    return  BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        custumer = this.custumer,
        status = this.status
    )
}