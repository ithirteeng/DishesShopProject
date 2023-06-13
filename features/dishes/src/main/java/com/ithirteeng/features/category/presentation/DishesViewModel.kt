package com.ithirteeng.features.category.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ithirteeng.features.category.domain.model.DishesModel
import com.ithirteeng.features.category.domain.model.TagModel
import com.ithirteeng.features.category.domain.usecase.GetDishesListUseCase
import com.ithirteeng.features.category.domain.usecase.GetTagsListUseCase
import kotlinx.coroutines.launch

class DishesViewModel(
    private val router: DishesRouter,
    private val getDishesListUseCase: GetDishesListUseCase,
    private val getTagsListUseCase: GetTagsListUseCase,
) : ViewModel() {

    fun exit() {
        router.exit()
    }

    private val _completionLiveData = MutableLiveData(true)

    val completionLiveData: LiveData<Boolean> = _completionLiveData

    private val _dishesListLiveData = MutableLiveData<List<DishesModel>>(listOf())

    val dishesListLiveData: LiveData<List<DishesModel>> = _dishesListLiveData

    private val _tagsLiveData = MutableLiveData<List<TagModel>>(listOf())

    val tagsLiveData: LiveData<List<TagModel>> = _tagsLiveData

    private var dishesList: List<DishesModel>? = null

    fun getDishesList(onErrorAppearance: (error: Throwable) -> Unit) {
        _completionLiveData.value = false
        viewModelScope.launch {
            getDishesListUseCase()
                .onSuccess {
                    dishesList = it
                    _dishesListLiveData.value = it
                    _tagsLiveData.value = getTagsListUseCase(it)
                }
                .onFailure {
                    onErrorAppearance(it)
                }
            _completionLiveData.value = true
        }
    }

    fun filterList(tags: List<String>): List<DishesModel>? {
        return dishesList?.filter { it.tags.containsAll(tags) }

    }


}