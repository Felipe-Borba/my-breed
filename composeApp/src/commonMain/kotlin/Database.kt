import app.cash.sqldelight.db.SqlDriver
import com.felipeborba.mybreed.Database

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DriverFactory): Database {
    val driver = driverFactory.createDriver()
    val database = Database(driver)

    // Do more work with the database (see below).
    val t = database.breedQueries.selectAll().executeAsList()
    return database
}