package com.example.module_4_lesson_1_hw_1_compose

class DataValidator {
    fun checkInput(
        username: String,
        email: String,
        password: String,
        passwordConfirm: String,
        age: String,
        country: String
    ): String {
        var textInfo = ""

        val listLogin = listOf("ivan3000", "kozak3241", "kingofeverything", "workhardplayhard")
        val ageInt = age.toIntOrNull() ?: 0
        val countryCheck = "ukraine"
        val emailCheck = "@"

        // login check
        for (i in listLogin.indices) {
            if (username == listLogin[i]) {
                textInfo = "This login is already taken. Please, choose another one."
                break
            } else if (i == listLogin.size - 1) {

                // email check
                if (email.contains(emailCheck)) {

                    // password check
                    if (password == passwordConfirm) {

                        // age check
                        if (ageInt >= 18) {

                            // country check
                            val countryLowerCase = country.lowercase()
                            if (countryLowerCase == countryCheck) {
                                textInfo = "You have been successfully registered!"
                                break
                            } else {
                                textInfo =
                                    "Excuse me. We don't support users outside the Ukraine yet."
                            }
                        } else {
                            textInfo =
                                "Your age is less than 18 years. Please, try again later."
                        }
                    } else {
                        textInfo = "Check password. You put in different passwords."
                    }
                } else {
                    textInfo = "Please, check your email. Something wrong."
                }
            }
        }
        return textInfo
    }
}