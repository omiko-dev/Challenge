package com.example.challenge.domain.usecase.validator

class EmailValidatorUseCase {

    private val emailRegex = Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")

    operator fun invoke(email: String): Boolean {
        return email.isNotBlank() && email.matches(emailRegex)
    }
}