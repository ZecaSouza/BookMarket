package com.mercadolivro.service

import com.mercadolivro.enums.CustumerStatus
import com.mercadolivro.enums.Errors
import com.mercadolivro.excpetion.NotFoundException
import com.mercadolivro.model.CustumerModel
import com.mercadolivro.repository.CustumerRepository
import org.springframework.stereotype.Service


@Service
class  CostumerService(
    val custumerRepository: CustumerRepository,
    val bookService: BookService
) {

    fun getAll( name: String?): List<CustumerModel> {
        name?.let {
            return custumerRepository.findByNameContaining(it)
        }
        return custumerRepository.findAll().toList()
    }

        fun create(custumer: CustumerModel) = custumerRepository.save(custumer)

    fun getById(id: Int): CustumerModel = custumerRepository.findById(id).orElseThrow{ NotFoundException(Errors.ML202.message.format(id), Errors.ML202.code) }

    fun update(custumer: CustumerModel) {

        if (!custumerRepository.existsById(custumer.id!!)){
            throw Exception()
        }
        custumerRepository.save(custumer)
    }

    fun delete(id: Int){
        val custumer = getById(id)
        bookService.DeleteByCustumer(custumer)

        custumer.status = CustumerStatus.INATIO

        custumerRepository.save(custumer)
    }
}