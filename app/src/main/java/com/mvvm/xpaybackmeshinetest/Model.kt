package com.mvvm.xpaybackmeshinetest

const val NETWORK_PAGE_SIZE = 25

data class MovieResponse(val users: List<users>)


data class users(val id:Int?,
                 val firstName: String?,
                 val lastName: String?,
                 val maidenName: String?,
                 val age: Int?,
                 val gender: String?,
                 val email: String?,
                 val phone: String?, val username: String?,
                 val password: String?,
                 val birthDate: String?,
                 val image:String?,
                 val bloodGroup: String?,
                 val height: Double?,
                 val weight: Double?,
                 val eyeColor: String?,
                 val hair:hair?,
                 val domain:String?,
                 val ip:String?,
                 val address: address?,
                 val macAddress:String?,
                 val university:String?,
                 val bank: bank?,
                 val company: company?,
                 val ein:String?,
                 val ssn:String?,
                 val userAgent: String?
                 )

data class hair(
    val color: String?,
    val type: String?,
)

data class address(
    val address: String?,
    val city: String?,
    val coordinates: coordinates?,
    val postalCode:String?,
    val state:String?
)

data class coordinates(
    val lat: Double?,
    val lng: Double?,
)
data class bank(
    val cardExpire: String?,
    val cardNumber: String?,
    val cardType: String?,
    val currency: String?,
    val iban: String?

)
data class company(
   val address: address?,
   val department:String?,
   val name:String?,
   val title:String?


)
