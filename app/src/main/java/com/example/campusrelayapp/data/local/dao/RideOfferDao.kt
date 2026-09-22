package com.example.campusrelayapp.data.local.dao

import androidx.room.*

import com.example.campusrelayapp.data.local.entity.RideOfferEntity

@Dao
interface RideOfferDao {

    @Query(
        "SELECT * FROM ride_offers ORDER BY rowid DESC"
    )
    suspend fun getAll():
            List<RideOfferEntity>

    @Insert(
        onConflict =
            OnConflictStrategy.REPLACE
    )
    suspend fun upsert(
        ride: RideOfferEntity
    )

    @Insert(
        onConflict =
            OnConflictStrategy.REPLACE
    )
    suspend fun upsertAll(
        rides: List<RideOfferEntity>
    )
}