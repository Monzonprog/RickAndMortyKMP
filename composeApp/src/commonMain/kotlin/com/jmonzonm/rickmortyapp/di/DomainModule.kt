package com.jmonzonm.rickmortyapp.di

import com.jmonzonm.rickmortyapp.domain.GetAllCharacters
import com.jmonzonm.rickmortyapp.domain.GetRandomCharacter
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetRandomCharacter)
    factoryOf(::GetAllCharacters)
}