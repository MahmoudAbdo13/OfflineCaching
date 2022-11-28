package com.mahmoud.offlinecaching.data

import androidx.room.withTransaction
import com.mahmoud.offlinecaching.api.RestaurantApi
import com.mahmoud.offlinecaching.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val api: RestaurantApi,
    private val db: RestaurantDatabase
) {
    private val restaurantDao = db.restaurantDao()
    fun getRestaurants() = networkBoundResource(
        query = {
            restaurantDao.getAllRestaurant()
        },
        fetch = {
            delay(2000)
            api.getAllRestaurant()
        },
        saveFetchResult = { restaurants ->
            db.withTransaction {
                restaurantDao.deleteAllRestaurants()
                restaurantDao.insertRestaurants(restaurants)
            }
        }
    )
}