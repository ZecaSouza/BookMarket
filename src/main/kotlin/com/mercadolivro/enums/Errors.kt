package com.mercadolivro.enums

enum class Errors(
    val code: String,
    val message: String
    ) {

    ML001("ML-001", "Invalid Request"),
    ML101("ML-101", "Book [%s] not exist"),
    ML102("ML-102", "Cannot update book with status [%s]"),
    ML202("ML-202", "Custumer [%s] not exist")

}