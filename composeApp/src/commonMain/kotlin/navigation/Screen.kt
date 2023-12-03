package navigation

sealed class Screen(val route: String) {
    data object BreedListScreen: Screen("breed_list_screen")
    data object BreedDetailScreen: Screen("breed_detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
