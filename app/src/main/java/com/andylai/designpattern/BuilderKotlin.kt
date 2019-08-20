package com.andylai.designpattern

class BuilderKotlin {
    fun test() {
        val niceHotel = Hotel("Nice")
        val funRestaurant = Restaurant("Fun")
        val tickets = listOf("Jurasic park")

        val builder1 = ThreeDayVocationBuilder()
        builder1.setBeginDate("12/1")
        builder1.setEndDate("12/30")
        builder1.setHotel(niceHotel)
        builder1.setRestaurant(funRestaurant)
        builder1.setTicket(tickets)
        val threeDayVocation: Vocation = ThreeDayVocationBuilder().create()

        val threeDayVocation2: Vocation = ThreeDayVocationBuilder()
                .setBeginDate("12/1")
                .setEndDate("12/30")
                .setHotel(niceHotel)
                .setRestaurant(funRestaurant)
                .setTicket(tickets).create()

    }

    inner class ThreeDayVocationBuilder : VocationBuilder {

        private lateinit var beginDate: String
        private lateinit var endDate: String
        private lateinit var hotel: Hotel
        private lateinit var restaurant: Restaurant
        private lateinit var tickets: List<String>

        override fun setBeginDate(date: String): VocationBuilder {
            this.beginDate = date
            return this
        }

        override fun setEndDate(date: String): VocationBuilder {
            this.endDate = date
            return this
        }

        override fun setHotel(hotel: Hotel): VocationBuilder {
            this.hotel = hotel
            return this
        }

        override fun setRestaurant(restaurant: Restaurant): VocationBuilder {
            this.restaurant = restaurant
            return this
        }

        override fun setTicket(tickets: List<String>): VocationBuilder {
            this.tickets = tickets
            return this
        }

        override fun create(): Vocation {
            return Vocation(beginDate, endDate, hotel, restaurant, tickets)
        }

    }

    interface VocationBuilder {
        fun setBeginDate(date: String): VocationBuilder

        fun setEndDate(date: String): VocationBuilder

        fun setHotel(hotel: Hotel): VocationBuilder

        fun setRestaurant(restaurant: Restaurant): VocationBuilder

        fun setTicket(tickets: List<String>): VocationBuilder

        fun create(): Vocation
    }

    data class Hotel(private val name: String)
    data class Restaurant(private val name: String)
    class Vocation(val beginDate: String, val endDate: String,
                   val hotel: Hotel, val restaurant: Restaurant,
                   val tickets: List<String>)
}