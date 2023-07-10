package cardosofgui.android.pokedexcleanarchmvvm.application.modules

import android.util.Log
import cardosofgui.android.pokedexcleanarchmvvm.data.network.service.PokemonApiClient
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import kotlinx.serialization.json.Json
import org.koin.dsl.module

/**
 * Módulo de injeção de dependência relacionado à camada de rede do aplicativo.
 */
val networkModules = module {
    /**
     * Retorna uma instância do [PokemonApiClient] configurado com o cliente HTTP Ktor.
     *
     * @return Instância do [PokemonApiClient].
     */
    single {
        PokemonApiClient(
            ktorClient = HttpClient {
                install(Logging) {
                    logger = object : Logger {
                        override fun log(message: String) {
                            Log.v("Log Ktor", message)
                        }
                    }
                    level = LogLevel.BODY
                }

                install(ContentNegotiation) {
                    val converter = KotlinxSerializationConverter(Json {
                        prettyPrint = true
                        ignoreUnknownKeys = true
                    })

                    register(ContentType.Application.Json, converter)
                }
            }
        )
    }
}
