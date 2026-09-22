package com.example.campusrelayapp.domain.model

/**
 * Represents an action waiting to be synchronized
 * with the server.
 */
data class OfflineTransaction(

    /**
     * Unique transaction ID.
     */
    val id: String,

    /**
     * Type of operation.
     *
     * Examples:
     * CREATE_DELIVERY
     * CREATE_RIDE
     * CREATE_MARKETPLACE_ITEM
     */
    val type: String,

    /**
     * Data needed to perform the operation.
     */
    val payload: String,

    /**
     * Date/time when the transaction was created.
     */
    val createdAt: Long,

    /**
     * Indicates whether synchronization
     * has been completed.
     */
    val synced: Boolean,

    /**
     * Number of synchronization attempts.
     */
    val attempts: Int
)