package com.mercadolivro.enums

enum class Errors(val code: String, val message: String) {

    ML001("ML-001", "Book [%s] not exist"),
    ML002("ML-002", "Custumer [%s] not exist")
}