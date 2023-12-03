package navigation

import androidx.compose.runtime.Composable
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.viewmodel.viewModel
import screens.breed.detail.BreedDetailScreen
import screens.breed.list.HomeScreen
import screens.breed.list.HomeViewModel


@Composable
fun Navigation() {
    val navController = rememberNavigator()
    NavHost(navigator = navController, initialRoute = Screen.BreedListScreen.route) {
        scene(Screen.BreedListScreen.route) {
            val homeViewModel = viewModel(modelClass = HomeViewModel::class) {
                HomeViewModel(it, navController)
            }
            HomeScreen(homeViewModel)
        }

        scene(Screen.BreedDetailScreen.route + "/{id}") { entry ->
            val id = entry.path<String>("id") ?: ""
            BreedDetailScreen(id, onBack = {
                navController.goBack()
            })
        }
    }
}

