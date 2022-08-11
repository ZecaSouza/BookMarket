package com.mercadolivro.repository

import com.mercadolivro.enums.EnumBook
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustumerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository <BookModel, Int> {
    abstract fun findByStatus(ativo: EnumBook, pageable: Pageable): Page<BookModel>
    abstract fun findByCustumer(custumer: CustumerModel): List<BookModel>

//    abstract fun findAll(pageable: Pageable): Page<BookModel>

}