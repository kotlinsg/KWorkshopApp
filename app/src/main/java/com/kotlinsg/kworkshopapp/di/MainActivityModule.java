package com.kotlinsg.kworkshopapp.di;

import com.kotlinsg.kworkshopapp.MainUseCaseImpl;
import com.kotlinsg.kworkshopapp.MainUseCase;

import dagger.Binds;
import dagger.Module;

@Module
public interface MainActivityModule {
    @ActivityScope
    @Binds
    MainUseCase bindsInterface(MainUseCaseImpl impl);
}