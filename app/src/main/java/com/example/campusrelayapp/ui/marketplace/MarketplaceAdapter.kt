package com.example.campusrelayapp.ui.marketplace

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import com.example.campusrelayapp.data.remote.dto.MarketplaceDto
import com.example.campusrelayapp.databinding.ItemMarketplaceBinding

class MarketplaceAdapter :
    RecyclerView.Adapter<
            MarketplaceAdapter.ViewHolder
            >() {

    private val items =
        mutableListOf<MarketplaceDto>()

    fun submitList(
        values: List<MarketplaceDto>
    ) {

        items.clear()

        items.addAll(
            values
        )

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        return ViewHolder(

            ItemMarketplaceBinding
                .inflate(
                    LayoutInflater.from(
                        parent.context
                    ),
                    parent,
                    false
                )
        )
    }

    override fun getItemCount() =
        items.size

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val item =
            items[position]

        holder.binding.title.text =
            item.title

        holder.binding.meta.text =
            "${item.category} • ${item.condition}"

        holder.binding.price.text =
            "R %.2f".format(
                item.price
            )
    }

    class ViewHolder(
        val binding:
        ItemMarketplaceBinding
    ) : RecyclerView.ViewHolder(
        binding.root
    )
}