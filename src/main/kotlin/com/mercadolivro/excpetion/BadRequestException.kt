package com.mercadolivro.excpetion

class BadRequestException(override val message: String, val errorCode: String): Exception() {
}