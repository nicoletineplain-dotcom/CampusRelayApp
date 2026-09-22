package com.example.campusrelayapp.data.local.dao

import androidx.room.*

import com.example.campusrelayapp.data.local.entity.MarketplaceEntity

@Dao
interface MarketplaceDao {

    @Query(
        "SELECT * FROM marketplace ORDER BY rowid DESC"
    )
    suspend fun getAll():
            List<MarketplaceEntity>

    @Insert(
        onConflict =
            OnConflictStrategy.REPLACE
    )
    suspend fun upsert(
        listing: MarketplaceEntity
    )

    @Insert(
        onConflict =
            OnConflictStrategy.REPLACE
    )
    suspend fun upsertAll(
        listings: List<MarketplaceEntity>
    )
}