package com.wordbox.test2.di

import org.koin.core.context.loadKoinModules

class KoinModules {
    companion object {
        fun init() = loadKoinModules(
            listOf(personModule)
        )
    }
}