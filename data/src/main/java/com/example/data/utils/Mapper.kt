package com.example.data.utils

import com.example.data.storage.models.api.Model as ApiModel
import com.example.data.storage.models.entities.Model as EntityModel
import com.example.data.storage.models.Model as StorageModel
import com.example.data.storage.models.params.Params as DataParams
import com.example.data.utils.Response as DataResponse
import com.example.domain.models.params.Params as DomainParams
import com.example.domain.models.Model as DomainModel
import com.example.domain.utils.Response as DomainResponse

object Mapper {

    fun DomainModel.map(): StorageModel = StorageModel(data = data)
    fun StorageModel.map(): DomainModel = DomainModel(data = data)
    fun ApiModel.map(): StorageModel = StorageModel(data = data)
    fun EntityModel.map(): StorageModel = StorageModel(data = data)
    fun StorageModel.toEntity(): EntityModel = EntityModel(data = data)
    fun DomainParams.map(): DataParams = DataParams(param = param)

    fun <FROM, TO> DataResponse<FROM>.toDataResponse(mapper: (FROM) -> TO): DataResponse<TO> =
        when (this) {
            is DataResponse.Error -> DataResponse.Error(exception = exception)
            is DataResponse.Success.Data -> DataResponse.Success.Data(data = mapper(data))
            is DataResponse.Success.Empty -> DataResponse.Success.Empty
        }

    fun <FROM, TO> DataResponse<FROM>.toDomainResponse(mapper: (FROM) -> TO): DomainResponse<TO> =
        when (this) {
            is DataResponse.Error -> DomainResponse.Error(exception = exception)
            is DataResponse.Success.Data -> DomainResponse.Success.Data(data = mapper(data))
            is DataResponse.Success.Empty -> DomainResponse.Success.Empty
        }

    fun DataResponse<Unit>.toDomainUnitResponse(): DomainResponse<Unit> = when (this) {
        is DataResponse.Error -> DomainResponse.Error(exception = exception)
        is DataResponse.Success -> DomainResponse.Success.Empty
    }
}