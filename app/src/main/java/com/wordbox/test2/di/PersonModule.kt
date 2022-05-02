package com.wordbox.test2.di

import com.wordbox.test2.data.remote.api.PersonService
import com.wordbox.test2.data.remote.api_impl.PersonServiceImpl
import com.wordbox.test2.data.remote.person.PersonRemoteDataSource
import com.wordbox.test2.data.repository.PersonRepositoryImpl
import com.wordbox.test2.domain.repository.PersonRepository
import com.wordbox.test2.domain.use_case.GetAllPersonUseCase
import com.wordbox.test2.presentation.person.view.PersonViewModel
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val personModule = module {

    viewModel { PersonViewModel(get()) }

    factory {
        HttpClient(Android) {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(JsonFeature) {
                //serializer = KotlinxSerializer()
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    factory<PersonService> {
        PersonServiceImpl(get())
    }

    factory {
        PersonRemoteDataSource(get())
    }

    factory<PersonRepository> {
        PersonRepositoryImpl(get())
    }

    factory {
        GetAllPersonUseCase(get())
    }

}