package cardosofgui.android.pokedexcleanarchmvvm.application.startup

import android.content.Context
import androidx.startup.Initializer
import cardosofgui.android.pokedexcleanarchmvvm.application.modules.databaseModules
import cardosofgui.android.pokedexcleanarchmvvm.application.modules.networkModules
import cardosofgui.android.pokedexcleanarchmvvm.application.modules.repositoryModules
import cardosofgui.android.pokedexcleanarchmvvm.application.modules.useCaseModules
import cardosofgui.android.pokedexcleanarchmvvm.application.modules.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class KoinInitializer : Initializer<KoinApplication> {
    override fun create(context: Context): KoinApplication {
        val modules = mutableListOf(
            databaseModules,
            networkModules,
            repositoryModules,
            useCaseModules,
            viewModelModules
        )

        return startKoin {
            androidContext(context)
            modules(modules)
            allowOverride(true)
        }
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}