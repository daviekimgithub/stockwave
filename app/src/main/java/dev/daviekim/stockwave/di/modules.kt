package dev.daviekim.stockwave.di

import dev.daviekim.stockwave.data.datasource.StockWaveDataSource
import dev.daviekim.stockwave.data.datasource.remote.StockWaveDataSourceImpl
import dev.daviekim.stockwave.data.repository.StockWaveRepositoryImpl
import dev.daviekim.stockwave.domain.InternetService
import dev.daviekim.stockwave.domain.InternetServiceImpl
import dev.daviekim.stockwave.domain.repository.StockWaveRepository
import dev.daviekim.stockwave.domain.usecase.FetchStockWaveUseCase
import dev.daviekim.stockwave.network.StockWaveHttpClient
import dev.daviekim.stockwave.network.StockWaveHttpClientImpl
import dev.daviekim.stockwave.viewmodel.StockWaveViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val DomainModule = module {
    factory { FetchStockWaveUseCase(get(), get()) }
}

val DataModule = module {
    factory<StockWaveHttpClient> { StockWaveHttpClientImpl() }
    single<InternetService> { InternetServiceImpl(androidContext()) }
    single<StockWaveRepository> { StockWaveRepositoryImpl(get()) }
    single<StockWaveDataSource>{ StockWaveDataSourceImpl(get()) }
}

val ViewModelModule = module {
    viewModel { StockWaveViewModel(get()) }
}