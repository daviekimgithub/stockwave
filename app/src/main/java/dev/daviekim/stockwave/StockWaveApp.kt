package dev.daviekim.stockwave

import android.app.Application
import dev.daviekim.stockwave.di.DataModule
import dev.daviekim.stockwave.di.DomainModule
import dev.daviekim.stockwave.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class StockWaveApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            printLogger()
            androidContext(this@StockWaveApp)
            modules(
                DomainModule,
                DataModule,
                ViewModelModule
            )
        }
    }
}