package com.example.framework.remote

import com.example.constants.EndPoints
import com.example.core.DataState
import com.example.core.UiComponent
import com.example.datasource.service.ImageRemoteService
import com.example.domain.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.net.ssl.SSLHandshakeException

class ImageRemoteServiceImpl @Inject constructor(private val apiService: ApiService) :
    ImageRemoteService {

    override suspend fun getImageList(pageNumber: Int): Flow<DataState<Photo>> = flow<DataState<Photo>> {
            withContext(Dispatchers.IO) {
                try {

                    val response =
                        apiService.getImages(apiKey = EndPoints.API_KEY, pageNumber = pageNumber)
                    withContext(Dispatchers.Main.immediate) {
                        if (response.isSuccessful) {
                            if (response.body() != null) {
                                emit(DataState.Data(response.body()?.toPhoto()))
                            }
                        } else {
                            emit(
                                DataState.Response(
                                    uiComponent = UiComponent.Dialog(

                                        title = "NetWorkError",
                                        description = response.message()
                                    )
                                )
                            )
                        }
                    }

                }catch (e:Exception){
                    e.printStackTrace()
                    withContext(Dispatchers.Main.immediate) {
                        emit(
                            DataState.Response(
                                uiComponent = UiComponent.Dialog(

                                    title = "Error",
                                    description = e.message ?: "UnknownError"
                                )
                            )
                        )
                    }
                } catch (e: SSLHandshakeException) {
                    e.printStackTrace()
                    withContext(Dispatchers.Main.immediate) {
                        emit(
                            DataState.Response(
                                uiComponent = UiComponent.Dialog(

                                    title = "NetworkError",
                                    description = e.message ?: "NetworkErrorr"
                                )
                            )
                        )
                    }
                }
            }

        }

}