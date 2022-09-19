package com.mercadolivro.model

import com.mercadolivro.enums.EnumBook
import com.mercadolivro.enums.Errors
import com.mercadolivro.excpetion.BadRequestException
import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "book")
data class BookModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @ManyToOne
    @JoinColumn(name = "custumer_id")
    var custumer: CustumerModel? = null
    ){

    @Column
    @Enumerated(EnumType.STRING)
    var status: EnumBook? = null
        set(value){
            if (field == EnumBook.DELETADO || field == EnumBook.CANCELADO){
                throw BadRequestException(Errors.ML102.message.format(field), Errors.ML102.code)
            }
            field = value
        }
    constructor(id: Int? = null,
                name: String,
                price: BigDecimal,
                custumer: CustumerModel? = null,
                status: EnumBook?) : this(id, name, price, custumer){
                    this.status = status
                }

}
