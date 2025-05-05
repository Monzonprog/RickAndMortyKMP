package com.jmonzonm.rickmortyapp.di

import com.jmonzonm.rickmortyapp.data.database.RickMortyDatabase
import com.jmonzonm.rickmortyapp.data.database.getDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module {
    return module {
        single<RickMortyDatabase> { getDatabase(get()) }
    }
}