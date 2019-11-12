package com.omurkmr.githubrepo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omurkmr.githubrepo.databinding.RepositoryListItemBinding
import com.omurkmr.githubrepo.extentions.setImageUrl
import com.omurkmr.githubrepo.models.search.Item

class GithubSearchAdapter : RecyclerView.Adapter<GithubSearchAdapter.ItemViewHolder>() {

    var items = listOf<Item>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = holder.bind(items[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(RepositoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = items.size

    inner class ItemViewHolder(private val itemBinding: RepositoryListItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(itemViewModel: Item) {
            itemBinding.item = itemViewModel

            itemBinding.repositoryIV.setImageUrl(itemViewModel.owner?.avatar_url)

            itemBinding.executePendingBindings()
        }
    }
}