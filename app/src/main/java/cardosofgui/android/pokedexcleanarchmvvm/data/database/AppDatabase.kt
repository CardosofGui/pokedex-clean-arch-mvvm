package cardosofgui.android.pokedexcleanarchmvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import cardosofgui.android.pokedexcleanarchmvvm.data.database.dao.FavoriteDao
import cardosofgui.android.pokedexcleanarchmvvm.data.database.model.FavoriteTb

@Database(entities = [FavoriteTb::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    /**
     * Retorna uma instância do DAO [FavoriteDao] para acessar as operações relacionadas à tabela de favoritos.
     *
     * @return Instância do DAO [FavoriteDao].
     */
    abstract fun favoriteDao(): FavoriteDao
}