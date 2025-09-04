package com.echosystem.echosystemapp.features.dispositivo.domain.usercases

import com.echosystem.echosystemapp.features.dispositivo.domain.models.Dispositivo
import com.echosystem.echosystemapp.features.dispositivo.domain.repository.DispositivoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetAllDispositivosUseCase @Inject constructor(
    val repository: DispositivoRepository
){
    suspend operator fun invoke(): Flow<List<Dispositivo>>{
        return repository.getAllDispositivo()
    }
}