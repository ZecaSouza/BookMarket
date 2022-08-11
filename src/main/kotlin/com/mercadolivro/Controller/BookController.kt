package com.mercadolivro.Controller

import com.mercadolivro.Controller.request.PostBookRequest
import com.mercadolivro.Controller.request.PutBookRequest
import com.mercadolivro.Controller.response.BookResponse
import com.mercadolivro.extension.toBookModel
import com.mercadolivro.extension.toResponde
import com.mercadolivro.service.BookService
import com.mercadolivro.service.CostumerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("book")
class BookController(
    val bookService: BookService,
    val custumerService: CostumerService
) {

    @RequestMapping
    fun findAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> = bookService.findAll(pageable).map { it.toResponde() }

    @RequestMapping("/actives")
    fun findActives(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> = bookService.findActives(pageable).map { it.toResponde() }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest){
        val custumer = custumerService.getById(request.custumerId!!)
        bookService.create(request.toBookModel(custumer))
    }

    @RequestMapping("/{id}")
    fun finfById(@PathVariable id: Int): BookResponse {
        return bookService.finfById(id).toResponde()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int){
        return bookService.delete(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody book: PutBookRequest){
        val bookSaved = bookService.finfById(id)
        bookService.update(book.toBookModel(bookSaved))
    }

}