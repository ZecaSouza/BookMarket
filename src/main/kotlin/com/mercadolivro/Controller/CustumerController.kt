package com.mercadolivro.Controller

import com.mercadolivro.Controller.request.PostCustumerRequest
import com.mercadolivro.Controller.request.PutCustumerRequest
import com.mercadolivro.Controller.response.CustumerResponse
import com.mercadolivro.extension.toCustumerModel
import com.mercadolivro.extension.toReponse
import com.mercadolivro.service.CostumerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("custumer")
class CustumerController(

    val costumerService: CostumerService,
) {

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustumerResponse> {
            return costumerService.getAll(name).map { it.toReponse() }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid custumer: PostCustumerRequest) {
         costumerService.create(custumer.toCustumerModel())
    }

    @GetMapping("/{id}")
    fun getCustumer(@PathVariable id: Int): CustumerResponse {
        return costumerService.getById(id).toReponse()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @Valid @RequestBody custumer: PutCustumerRequest) {
        val custumerSaved = costumerService.getById(id)
        costumerService.update(custumer.toCustumerModel(custumerSaved))
        }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        costumerService.delete(id)
    }


}
