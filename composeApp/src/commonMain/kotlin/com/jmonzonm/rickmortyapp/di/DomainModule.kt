package com.jmonzonm.rickmortyapp.di

import com.jmonzonm.rickmortyapp.domain.GetAllCharactersUseCase
import com.jmonzonm.rickmortyapp.domain.GetRandomCharacterUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetRandomCharacterUseCase)
    factoryOf(::GetAllCharactersUseCase)
}