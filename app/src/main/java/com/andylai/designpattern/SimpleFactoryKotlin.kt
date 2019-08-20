package com.andylai.designpattern

class SimpleFactoryKotlin {

    fun test() {
        val factory = PhoneFactory()
        val AndroidPhone = factory.createPhone(Type.Android)

    }

    enum class Type {
        Android,
        IOS
    }

    class PhoneFactory {
        fun createPhone(type: Type):Phone {
            return when(type) {
                Type.Android -> Android()
                Type.IOS -> IOS()
            }
        }
    }

    abstract class Phone {
        abstract fun call()
    }

    class Android : Phone() {
        override fun call() {
        }
    }

    class IOS : Phone() {
        override fun call() {
        }
    }
}