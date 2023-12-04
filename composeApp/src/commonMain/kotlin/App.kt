import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import moe.tlaster.precompose.PreComposeApp
import navigation.Navigation

@Composable
fun App(driverFactory: DriverFactory) {
    PreComposeApp {
        createDatabase(driverFactory)
        MaterialTheme {
            Navigation()
        }
    }
}