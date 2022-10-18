package com.mercadolivro.model

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "purchase")

data class PurchaseModel(
    @Id
    @GeneratedValue
    val id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    val customer: CustumerModel,

    @ManyToMany
    @JoinTable(name = "purchase_book",
        joinColumns = [JoinColumn(name ="purchase_id")],
        inverseJoinColumns = [JoinColumn(name = "book_id")])
    val books: MutableList<BookModel>,

    @Column
    val nfe: String? = null,

    @Column
    val price: BigDecimal,

    @Column(name = "created_at")
    val createAt: LocalDateTime = LocalDateTime.now()
)
