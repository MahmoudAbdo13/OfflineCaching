package com.mahmoud.offlinecaching.features.restaurants

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mahmoud.offlinecaching.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(repository: RestaurantRepository) : ViewModel() {
    val restaurants = repository.getRestaurants().asLiveData()

    /* private val restaurantLiveData = MutableLiveData<List<Restaurant>>()
     val restaurants: LiveData<List<Restaurant>> = restaurantLiveData
     init {
         viewModelScope.launch {
             val restaurants = api.getAllRestaurant()
             restaurantLiveData.value = restaurants
         }
     }*/
}