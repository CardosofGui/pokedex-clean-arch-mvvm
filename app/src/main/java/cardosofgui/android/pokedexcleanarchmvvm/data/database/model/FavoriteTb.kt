package cardosofgui.android.pokedexcleanarchmvvm.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "favorite_tb"
)
data class FavoriteTb(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val pokemonId: Long? = null
)