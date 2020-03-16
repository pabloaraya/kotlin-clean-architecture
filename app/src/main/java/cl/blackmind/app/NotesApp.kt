package cl.blackmind.app

import android.app.Application
import cl.blackmind.app.di.appModule
import cl.blackmind.app_api.di.appRemoteModule
import cl.blackmind.app_domain.di.appDomainModule
import cl.blackmind.app_local.di.appLocalModule
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

const val URL_BASE_EXPERIENCE_API = "BuildConfig.URL_BASE_EXPERIENCE_API"

open class NotesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        AndroidThreeTen.init(this)
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@NotesApp)
            modules(
                listOf(
                    appModule,
                    appDomainModule,
                    appLocalModule,
                    appRemoteModule
                )
            )
        }
    }
}
