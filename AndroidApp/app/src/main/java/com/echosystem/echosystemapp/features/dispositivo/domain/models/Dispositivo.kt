package com.echosystem.echosystemapp.features.dispositivo.domain.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "Dispositivo" )
data class Dispositivo(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var apelido: String?,
    var cargaDeBateriaEstimada: Double,
    val latitude: Double,
    val longitude: Double,
) : Parcelable {

    // Sobrescrevendo o metodo que retorna zero por padrão
    override fun describeContents(): Int {
        return 0
    }

    // Implementação do metodo writeToParcel para escrever os dados no Parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(apelido)
        parcel.writeDouble(cargaDeBateriaEstimada)
        parcel.writeDouble(latitude)
        parcel.writeDouble(longitude)
    }

    // Objeto CREATOR que serve para recriar o objeto a partir de um Parcel
    companion object CREATOR : Parcelable.Creator<Dispositivo> {
        override fun createFromParcel(parcel: Parcel): Dispositivo {
            // Criando o objeto Goals a partir dos dados presentes no Parcel
            return Dispositivo(
                id = parcel.readLong(),
                apelido = parcel.readString(),
                cargaDeBateriaEstimada = parcel.readDouble(),
                latitude = parcel.readDouble(),
                longitude = parcel.readDouble()
            )
        }

        override fun newArray(size: Int): Array<Dispositivo?> {
            return arrayOfNulls(size)
        }
    }
}
