package com.example.campusrelayapp.data.local.dao

import androidx.room.*

import com.example.campusrelayapp.data.local.entity.UserEntity

@Dao
interface UserDao {

    @Query(
        "SELECT * FROM users LIMIT 1"
    )
    suspend fun getCurrent():
            UserEntity?

    @Insert(
        onConflict =
            OnConflictStrategy.REPLACE
    )
    suspend fun upsert(
        user: UserEntity
    )

    @Query("DELETE FROM users")
    suspend fun clear()
}