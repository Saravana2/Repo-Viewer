package com.repo.viewer.presentation.repo.trendinglist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.news.app.presentation.utils.loadImage
import com.repo.viewer.data.model.repo.Repository
import com.repo.viewer.databinding.ItemRepositoryBinding

class RepoAdapter : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {
    private val items = ArrayList<Repository>()

    fun setRepos(newRepos: List<Repository>) {
        val diffResult = RepoDiffUtil(items, newRepos).let {
            DiffUtil.calculateDiff(it)
        }
        items.clear()
        items.addAll(newRepos)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RepoViewHolder(
            ItemRepositoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    class RepoViewHolder(private val binding: ItemRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(repo: Repository) {
            binding.userTextView.text = repo.owner.login
            binding.repoNameTextView.text = repo.name
            binding.repoDescTextView.text = repo.description
            binding.profileImageView.loadImage(repo.owner.avatarUrl)
        }
    }

    class RepoDiffUtil(
        private val oldList: List<Repository>,
        private val newList: List<Repository>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

    }
}