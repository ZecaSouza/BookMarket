package com.mercadolivro.repository

import com.mercadolivro.model.CustumerModel
import org.springframework.data.repository.CrudRepository

interface CustumerRepository : CrudRepository <CustumerModel, Int> {

    fun findByNameContaining(name: String): List<CustumerModel>
    fun existsByEmail(email: String): Boolean
}