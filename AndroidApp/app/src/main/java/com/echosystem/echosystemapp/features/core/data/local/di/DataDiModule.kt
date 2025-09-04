package com.echosystem.echosystemapp.features.core.data.local.di

import android.content.Context
import androidx.room.Room
import com.echosystem.echosystemapp.features.core.data.local.dao.DispositivoDao
import com.echosystem.echosystemapp.features.core.data.local.database.EchoSystemAppDataBase
import com.echosystem.echosystemapp.features.core.data.local.repository.DispositivoRepositoryImpl
import com.echosystem.echosystemapp.features.dispositivo.domain.repository.DispositivoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataDiModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): EchoSystemAppDataBase {
        return Room.databaseBuilder(
            context,
            EchoSystemAppDataBase::class.java,
            "echosystemapp_database"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDispositivoDao(database: EchoSystemAppDataBase): DispositivoDao {
        return database.dispositivoDao()
    }

    @Provides
    @Singleton
    fun provideDispositivoRepository(
        dispositivoDao: DispositivoDao
    ): DispositivoRepository {
        return DispositivoRepositoryImpl(dispositivoDao)
    }
}
