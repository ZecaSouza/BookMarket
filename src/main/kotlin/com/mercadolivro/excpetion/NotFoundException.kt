package com.mercadolivro.excpetion

class NotFoundException(override val message: String, val errorCode: String): Exception() {
}