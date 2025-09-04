package com.echosystem.echosystemapp.features.core.data.local.repository

import com.echosystem.echosystemapp.features.core.data.local.dao.DispositivoDao
import com.echosystem.echosystemapp.features.dispositivo.domain.models.Dispositivo
import com.echosystem.echosystemapp.features.dispositivo.domain.repository.DispositivoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DispositivoRepositoryImpl @Inject constructor(
    private val dispositivoDao : DispositivoDao
): DispositivoRepository {
    override suspend fun saveDispositivo(dispositivo: Dispositivo) {
        dispositivoDao.save(dispositivo)
    }

    override suspend fun getAllDispositivo(): Flow<List<Dispositivo>> {
        return dispositivoDao.getAllDispositivo()
    }

    override suspend fun getDispostivoById(dispositivoId: Long): Dispositivo? {
        TODO("Not yet implemented")
    }
}