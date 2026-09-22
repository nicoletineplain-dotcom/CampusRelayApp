package com.example.campusrelayapp.data.repository

import com.example.campusrelayapp.data.local.dao.UserDao

class UserRepository(
    private val dao: UserDao
) {

    suspend fun current() =
        dao.getCurrent()
}