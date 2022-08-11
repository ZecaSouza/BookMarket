package com.mercadolivro.model

import com.mercadolivro.enums.CustumerStatus
import javax.persistence.*

@Entity(name = "custumer")
data class CustumerModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var email: String,

    @Column
    @Enumerated(EnumType.STRING)
    var status: CustumerStatus
    )
