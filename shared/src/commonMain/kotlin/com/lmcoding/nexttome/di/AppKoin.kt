package com.lmcoding.nexttome.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

object AppKoin {
    fun init(config: KoinAppDeclaration? = null){
        startKoin {
            config?.invoke(this)
            modules(appModules)
        }
    }
}