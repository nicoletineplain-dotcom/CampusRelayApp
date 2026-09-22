package com.example.campusrelayapp.domain.usecase

import com.example.campusrelayapp.data.repository.MarketplaceRepository
import com.example.campusrelayapp.domain.model.MarketplaceItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Gets marketplace items.
 */
class GetMarketplaceItemsUseCase(
    private val marketplaceRepository: MarketplaceRepository
) {

    /**
     * Returns available marketplace items.
     */
    operator fun invoke(): Flow<List<MarketplaceItem>> = flow {

        val items = marketplaceRepository.feed()

        emit(
            items.map { item ->

                MarketplaceItem(
                    id = item.id,
                    sellerId = item.sellerId,
                    title = item.title,
                    category = item.category,
                    price = item.price,
                    condition = item.condition,
                    status = item.status
                )
            }
        )
    }
}