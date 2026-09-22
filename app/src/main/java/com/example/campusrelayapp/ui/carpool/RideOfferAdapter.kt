package com.example.campusrelayapp.ui.carpool

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.campusrelayapp.databinding.ItemRideOfferBinding
import com.example.campusrelayapp.domain.model.RideOffer

class RideOfferAdapter :
    RecyclerView.Adapter<RideOfferAdapter.ViewHolder>() {

    private val items = mutableListOf<RideOffer>()

    fun submitList(newItems: List<RideOffer>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val binding = ItemRideOfferBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(
        private val binding: ItemRideOfferBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RideOffer) {

            binding.tvRideRoute.text =
                "${item.origin} → ${item.destination}"

            binding.tvRideMeta.text =
                "${item.seats} seats • R${item.pricePerSeat} per seat"

            binding.tvRideDriver.text =
                "Driver: ${item.driverId}"
        }
    }
}