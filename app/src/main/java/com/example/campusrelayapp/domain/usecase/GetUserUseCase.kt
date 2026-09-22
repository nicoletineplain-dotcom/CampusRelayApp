package com.example.campusrelayapp.domain.usecase

import com.example.campusrelayapp.data.repository.UserRepository
import com.example.campusrelayapp.domain.model.User

/**
 * Gets the current user from local storage.
 */
class GetUserUseCase(
    private val userRepository: UserRepository
) {

    /**
     * Execute the use case.
     */
    suspend operator fun invoke(): User? {

        val entity = userRepository.current()

        return entity?.let {

            User(
                id = it.id,
                name = it.name,
                email = it.email,
                studentNumber = it.studentNumber,
                ecoScore = it.ecoScore
            )
        }
    }
}