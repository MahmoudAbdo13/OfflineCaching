package com.mahmoud.offlinecaching.api

import com.mahmoud.offlinecaching.data.Restaurant
import retrofit2.http.GET

interface RestaurantApi {
    companion object{
        const val BASE_URI = "https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant?size=30")
    suspend fun getAllRestaurant(): List<Restaurant>
}