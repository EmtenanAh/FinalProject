package com.example.finalproject.Util

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UnitTest {

    private lateinit var validator: RegisterValidations

    @Before
    fun setup() {
        validator = RegisterValidations()
    }

    @Test
    fun emailIsValidWithInvalidEmailThenReturnFalseValue() {
        val validation = validator.emailIsValid("test-dd.com")

        Assert.assertEquals(false, validation)
    }

    @Test
    fun emailIsValidWithValidEmailThenReturnTrueValue() {
        val validation = validator.emailIsValid("test@test.com")

        Assert.assertEquals(true, validation)
    }


    @Test
    fun passwordIsValidWithInvalidPasswordThenReturnFalseValue() {
        val validation = validator.passwordIsValid("73")

        Assert.assertEquals(false, validation)
    }


    @Test
    fun passwordIsValidWithValidPasswordThenReturnTrueValue() {
        val validation = validator.passwordIsValid("Tu@2185697")

        Assert.assertEquals(true, validation)
    }

}