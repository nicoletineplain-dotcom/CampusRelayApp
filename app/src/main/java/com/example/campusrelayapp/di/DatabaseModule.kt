package com.example.campusrelayapp.di

import android.content.Context

import androidx.room.Room

import com.example.campusrelayapp.data.local.AppDatabase
import com.example.campusrelayapp.util.Constants

object DatabaseModule {

    fun provideDatabase(
        context: Context
    ): AppDatabase {

        return Room.databaseBuilder(

            context,

            AppDatabase::class.java,

            Constants.DATABASE_NAME

        )

            .fallbackToDestructiveMigration()

            .build()
    }
}