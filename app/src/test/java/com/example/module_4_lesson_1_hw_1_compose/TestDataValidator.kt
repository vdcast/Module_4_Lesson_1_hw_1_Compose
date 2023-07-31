package com.example.module_4_lesson_1_hw_1_compose

import org.junit.Test
// need this import for assertEquals without Assert
import org.junit.Assert.*

class TestDataValidator {

    @Test
    fun checkInputTestOne() {
        assertEquals(
            DataValidator().checkInput(
                "Kek",
                "email@mail.com",
                "123456",
                "123456",
                "22",
                "Ukraine"),
            "You have been successfully registered!"
        )
    }

    @Test
    fun checkInputTestTwo() {
        assertEquals(
            DataValidator().checkInput(
                "kozak3241",
                "email@mail.com",
                "123456",
                "123456",
                "22",
                "Ukraine"),
            "This login is already taken. Please, choose another one."
        )
    }
    @Test
    fun checkInputTestThree() {
        assertEquals(
            DataValidator().checkInput(
                "wiz48",
                "emailcom",
                "123456",
                "123456",
                "22",
                "Ukraine"),
            "Please, check your email. Something wrong."
        )
    }
    @Test
    fun checkInputTestFour() {
        assertEquals(
            DataValidator().checkInput(
                "wiz48",
                "email@mail.com",
                "123456",
                "1234",
                "22",
                "Ukraine"),
            "Check password. You put in different passwords."
        )
    }
    @Test
    fun checkInputTestFive() {
        assertEquals(
            DataValidator().checkInput(
                "wiz48",
                "email@mail.com",
                "123456",
                "123456",
                "8",
                "Ukraine"),
            "Your age is less than 18 years. Please, try again later."
        )
    }
    @Test
    fun checkInputTestSix() {
        assertEquals(
            DataValidator().checkInput(
                "wiz48",
                "email@mail.com",
                "123456",
                "123456",
                "22",
                "Cyprus"),
            "Excuse me. We don't support users outside the Ukraine yet."
        )
    }
}