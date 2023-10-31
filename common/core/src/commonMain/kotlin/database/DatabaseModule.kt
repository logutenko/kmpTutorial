package database

import com.example.kmm.Database
import org.koin.dsl.module

internal val databaseModule = module {
    single {
        DbDriverFactory(get())
    }

    single {
        val driverFactory: DbDriverFactory = get()
        val driver = driverFactory.createDriver(Database.Schema, "kmp_db")
        Database.Schema.create(driver)
        Database(driver)
    }
}