package com.echosystem.echosystemapp.features.core.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.echosystem.echosystemapp.features.core.data.local.converters.DateConverters
import com.echosystem.echosystemapp.features.core.data.local.dao.DispositivoDao
import com.echosystem.echosystemapp.features.dispositivo.domain.models.Dispositivo

@Database(
    entities = [Dispositivo::class],
    exportSchema = false,
    version = 0
)

@TypeConverters(DateConverters::class)
abstract class EchoSystemAppDataBase: RoomDatabase() {
    abstract fun dispositivoDao() : DispositivoDao
}