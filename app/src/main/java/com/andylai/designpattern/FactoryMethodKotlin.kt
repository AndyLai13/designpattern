package com.andylai.designpattern

class FactoryMethodKotlin {
    fun test() {
        val factory = AndroidPhoneFactory()
        val AndroidPhone = factory.createPhone()

    }

    class IOSPhoneFactory : PhoneFactory() {
        override fun createPhone(): Phone {
            return IOS()
        }
    }

    class AndroidPhoneFactory : PhoneFactory() {
        override fun createPhone(): Phone {
            return Android()
        }
    }

    abstract class PhoneFactory {
        abstract fun createPhone(): Phone
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