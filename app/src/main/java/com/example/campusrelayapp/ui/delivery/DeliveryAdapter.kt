package com.example.campusrelayapp.ui.delivery

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import com.example.campusrelayapp.databinding.ItemDeliveryBinding
import com.example.campusrelayapp.domain.model.Delivery

class DeliveryAdapter :
    RecyclerView.Adapter<
            DeliveryAdapter.DeliveryViewHolder
            >() {

    private val items =
        mutableListOf<Delivery>()

    fun submitList(
        deliveries: List<Delivery>
    ) {

        items.clear()

        items.addAll(
            deliveries
        )

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DeliveryViewHolder {

        return DeliveryViewHolder(

            ItemDeliveryBinding
                .inflate(
                    LayoutInflater.from(
                        parent.context
                    ),
                    parent,
                    false
                )
        )
    }

    override fun getItemCount():
            Int =
        items.size

    override fun onBindViewHolder(
        holder: DeliveryViewHolder,
        position: Int
    ) {

        val delivery =
            items[position]

        holder.binding
            .txtRoute
            .text =
            "${delivery.pickup} → ${delivery.dropoff}"

        holder.binding
            .txtStatus
            .text =
            delivery.status

        holder.binding
            .txtPrice
            .text =
            "R %.2f"
                .format(
                    delivery.price
                )
    }

    class DeliveryViewHolder(

        val binding:
        ItemDeliveryBinding

    ) : RecyclerView.ViewHolder(
        binding.root
    )
}