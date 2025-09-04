package com.echosystem.echosystemapp.features.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.echosystem.echosystemapp.features.dispositivo.domain.models.Dispositivo
import kotlinx.coroutines.flow.Flow

@Dao
interface DispositivoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(dispositivo: Dispositivo)

    @Query("SELECT * FROM Dispositivo")
    fun getAllDispositivo() : Flow<List<Dispositivo>>
}