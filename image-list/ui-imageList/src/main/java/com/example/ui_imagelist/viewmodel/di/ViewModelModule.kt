package com.example.ui_imagelist.viewmodel.di

import com.example.datasource.network.network.ApiService
import com.example.datasource.network.network.ImageService
import com.example.datasource.network.network.ImageServiceImpl
import com.example.usecase.GetImages
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideImageService(apiService: ApiService): ImageServiceImpl = ImageServiceImpl(apiService)

    @Provides
    @ViewModelScoped
    fun provideGetImagesInteractor(imageService: ImageServiceImpl): GetImages {
        return GetImages(imageService)
    }
}