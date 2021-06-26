package com.example.demo.db.model

enum class ValidationRule {
    REGEX {
        override fun isValid(value: String, input: String): Boolean =
            value.toRegex().matches(input)
    },
    MINIMUM_LENGTH {
        override fun isValid(value: String, input: String): Boolean =
            input.length >= value.toInt()
    },
    MAXIMUM_LENGTH {
        override fun isValid(value: String, input: String): Boolean =
            input.length <= value.toInt()
    };

    abstract fun isValid(value: String, input: String): Boolean
}