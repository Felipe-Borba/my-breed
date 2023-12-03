package screens.breed.list

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.stateholder.SavedStateHolder
import moe.tlaster.precompose.viewmodel.ViewModel
import navigation.Screen

class HomeViewModel(
    private val savedStateHolder: SavedStateHolder,
    private val navController: Navigator
) : ViewModel() {
    private val _name = MutableStateFlow(
        savedStateHolder.consumeRestored("someValue") as String? ?: ""
    )
    val name = _name.asStateFlow()

    init {
        savedStateHolder.registerProvider("someValue") { _name.value }
    }

    fun setName(name: String) {
        _name.value = name
    }

    fun toDetailsScreen(name: String) {
        navController.navigate(Screen.BreedDetailScreen.withArgs(name))
    }
}