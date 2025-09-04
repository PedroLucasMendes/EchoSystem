package com.echosystem.echosystemapp.features.dispositivo.domain.usercases

import com.echosystem.echosystemapp.features.dispositivo.domain.models.Dispositivo
import com.echosystem.echosystemapp.features.dispositivo.domain.repository.DispositivoRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreateDispositivoUseCase @Inject constructor(private val repository: DispositivoRepository) {
    suspend operator fun invoke(dispostivo: Dispositivo){
        repository.saveDispositivo(dispostivo)
    }
}