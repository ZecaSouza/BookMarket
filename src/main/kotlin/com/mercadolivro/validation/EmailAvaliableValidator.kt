package com.mercadolivro.validation

import com.mercadolivro.service.CostumerService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class EmailAvaliableValidator(var costumerService: CostumerService): ConstraintValidator<EmailAvaliable, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if(value.isNullOrEmpty()){
            return false
        }
        return costumerService.emailAvailable(value)
    }


}
