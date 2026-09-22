package com.example.campusrelayapp.ui.leaderboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.campusrelayapp.databinding.ItemLeaderboardBinding

class EcoLeaderboardAdapter :
    RecyclerView.Adapter<EcoLeaderboardAdapter.ViewHolder>() {

    private val items =
        mutableListOf<LeaderboardUiItem>()

    fun submitList(
        newItems: List<LeaderboardUiItem>
    ) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        return ViewHolder(
            ItemLeaderboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(
            position + 1,
            items[position]
        )
    }

    override fun getItemCount(): Int =
        items.size

    class ViewHolder(
        private val binding: ItemLeaderboardBinding
    ) : RecyclerView.ViewHolder(
        binding.root
    ) {

        fun bind(
            rank: Int,
            item: LeaderboardUiItem
        ) {

            binding.tvRank.text =
                "$rank."

            binding.tvName.text =
                item.name

            binding.tvScore.text =
                "%,d".format(
                    item.score
                )
        }
    }
}