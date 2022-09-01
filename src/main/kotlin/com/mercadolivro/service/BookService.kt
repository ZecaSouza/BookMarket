package com.mercadolivro.service

import com.mercadolivro.enums.EnumBook
import com.mercadolivro.enums.Errors
import com.mercadolivro.excpetion.NotFoundException
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustumerModel
import com.mercadolivro.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class  BookService(
    val bookRepository: BookRepository
) {

    fun create(book: BookModel) = bookRepository.save(book)

    fun findAll(pageable: Pageable): Page<BookModel> = bookRepository.findAll(pageable)

    fun findActives(pageable: Pageable): Page<BookModel> = bookRepository.findByStatus(EnumBook.ATIVO, pageable)

    fun finfById(id: Int): BookModel = bookRepository.findById(id).orElseThrow{ NotFoundException(Errors.ML001.message.format(id), Errors.ML001.code) }

    fun delete(id: Int) {
        val book = finfById(id)

        book.status = EnumBook.CANCELADO

        update(book)
    }

    fun update(book: BookModel) = bookRepository.save(book)


    fun DeleteByCustumer(custumer: CustumerModel) {
        val books = bookRepository.findByCustumer(custumer)
        for (book in books){
            book.status = EnumBook.DELETADO
        }
        bookRepository.saveAll(books)
    }

}
