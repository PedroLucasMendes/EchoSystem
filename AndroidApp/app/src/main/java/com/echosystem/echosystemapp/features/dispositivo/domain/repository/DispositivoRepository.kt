package com.echosystem.echosystemapp.features.dispositivo.domain.repository


import com.echosystem.echosystemapp.features.dispositivo.domain.models.Dispositivo
import kotlinx.coroutines.flow.Flow

interface DispositivoRepository {

    suspend fun saveDispositivo(dispositivo: Dispositivo)

    suspend fun getAllDispositivo() : Flow<List<Dispositivo>>

    suspend fun getDispostivoById(dispositivoId: Long): Dispositivo?

}