package cardosofgui.android.pokedexcleanarchmvvm.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import cardosofgui.android.pokedexcleanarchmvvm.data.database.model.FavoriteTb
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    /**
     * Insere um Pokémon favorito na tabela [favorite_tb].
     *
     * @param favoriteEntity O objeto [FavoriteTb] representando o Pokémon favorito a ser inserido.
     * @return O ID do Pokémon favorito inserido.
     */
    @Insert
    suspend fun insertFavorite(favoriteEntity: FavoriteTb): Long

    /**
     * Exclui um Pokémon favorito da tabela [favorite_tb] com base no ID do Pokémon.
     *
     * @param pokemonId O ID do Pokémon a ser excluído da lista de favoritos.
     */
    @Query("DELETE FROM favorite_tb WHERE pokemonId = :pokemonId")
    suspend fun deleteFavorite(pokemonId: Long)

    /**
     * Consulta um Pokémon favorito da tabela [favorite_tb] com base no ID do Pokémon.
     *
     * @param pokemonId O ID do Pokémon a ser consultado na lista de favoritos.
     * @return Um [Flow] que emite o objeto [FavoriteTb] representando o Pokémon favorito, ou nulo se não encontrado.
     */
    @Query("SELECT * FROM favorite_tb WHERE pokemonId = :pokemonId")
    fun queryFavorite(pokemonId: Long?): Flow<FavoriteTb?>
}
