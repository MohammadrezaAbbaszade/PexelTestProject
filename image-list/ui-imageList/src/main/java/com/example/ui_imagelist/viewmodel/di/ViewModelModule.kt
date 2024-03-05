package com.example.ui_imagelist.viewmodel.di

import com.example.framework.remote.ApiService
import com.example.datasource.repository.ImageRepositoryImpl
import com.example.framework.datastorage.PhotoDataStorage
import com.example.framework.datastorage.PhotoDataStorageImpl
import com.example.framework.local.ImageLocalServiceImpl
import com.example.framework.remote.ImageRemoteServiceImpl
import com.example.usecase.GetImages
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideImageRemoteService(apiService: ApiService): ImageRemoteServiceImpl =
        ImageRemoteServiceImpl(apiService)

    @Provides
    @ViewModelScoped
    fun provideImageLocalService(photoDataStorage: PhotoDataStorage): ImageLocalServiceImpl =
        ImageLocalServiceImpl(photoDataStorage)

    @Provides
    @ViewModelScoped
    fun provideImageRepository(imageRemoteService: ImageRemoteServiceImpl,imageLocalServiceImpl: ImageLocalServiceImpl): ImageRepositoryImpl =
        ImageRepositoryImpl(imageRemoteService,imageLocalServiceImpl)



    @Provides
    @ViewModelScoped
    fun provideGetImagesInteractor(imageRepositoryImpl: ImageRepositoryImpl): GetImages {
        return GetImages(imageRepositoryImpl)
    }
}