package com.example.data.utils

import com.example.domain.models.params.Params as DomainParams
import com.example.data.storage.models.params.Params as DataParams
import com.example.domain.models.Model as DomainModel
import com.example.data.storage.models.Model as DataModel
import com.example.data.utils.Response as DataResponse
import com.example.domain.utils.Response as DomainResponse

object Mapper {

    fun DomainModel.map(): DataModel = DataModel(data = data)
    fun DataModel.map(): DomainModel = DomainModel(data = data)

    fun DomainParams.map(): DataParams = DataParams(param = param)

    @JvmName("mapResponseModel")
    fun DataResponse<DataModel>.map(): DomainResponse<DomainModel> = when (this) {
        is DataResponse.Error -> DomainResponse.Error(exception = exception)
        is DataResponse.Success.Data -> DomainResponse.Success.Data(data = data.map())
        is DataResponse.Success.Empty -> DomainResponse.Success.Empty
    }

    @JvmName("mapResponseAny")
    fun DataResponse<Any>.map(): DomainResponse<Any> = when (this) {
        is DataResponse.Error -> DomainResponse.Error(exception = exception)
        is DataResponse.Success -> DomainResponse.Success.Empty
    }
}