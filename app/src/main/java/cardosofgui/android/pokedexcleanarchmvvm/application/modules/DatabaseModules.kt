package cardosofgui.android.pokedexcleanarchmvvm.application.modules

import androidx.room.Room
import cardosofgui.android.pokedexcleanarchmvvm.data.database.AppDatabase
import org.koin.dsl.module

/**
 * Nome do arquivo do banco de dados.
 */
const val DATABASE_NAME = "pokedexcleanarch.db"

/**
 * Módulo de injeção de dependência relacionado ao banco de dados do aplicativo.
 */
val databaseModules = module {
    /**
     * Retorna uma instância do [AppDatabase] utilizando a biblioteca Room.
     *
     * @return Instância do banco de dados do aplicativo.
     */
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    /**
     * Retorna uma instância do DAO (Data Access Object) [FavoriteDao] que fornece acesso às operações relacionadas aos favoritos no banco de dados.
     *
     * @return Instância do DAO [FavoriteDao].
     */
    factory {
        get<AppDatabase>().favoriteDao()
    }
}
