package com.example.campusrelayapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

import com.example.campusrelayapp.data.local.dao.*
import com.example.campusrelayapp.data.local.entity.*

@Database(

    entities = [

        UserEntity::class,

        DeliveryEntity::class,

        MarketplaceEntity::class,

        RideOfferEntity::class,

        MessageEntity::class,

        ReviewEntity::class,

        OfflineTransactionEntity::class

    ],

    version = 1,

    exportSchema = false
)
abstract class AppDatabase :
    RoomDatabase() {

    abstract fun userDao():
            UserDao

    abstract fun deliveryDao():
            DeliveryDao

    abstract fun marketplaceDao():
            MarketplaceDao

    abstract fun rideOfferDao():
            RideOfferDao

    abstract fun offlineTransactionDao():
            OfflineTransactionDao
}