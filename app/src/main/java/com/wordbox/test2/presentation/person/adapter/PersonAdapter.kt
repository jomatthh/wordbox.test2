package com.wordbox.test2.presentation.person.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wordbox.test2.databinding.ItemPersonBinding
import com.wordbox.test2.presentation.person.model.PersonModel

class PersonAdapter(
    private var items: List<PersonModel>,
    private val listener: OnPersonaApterListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemPersonBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(items[position])
    }

    fun update(newItems: List<PersonModel>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(private val binding: ItemPersonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: PersonModel) = with(binding) {
            personItemFTvName.text = model.name
            Glide.with(binding.root.context).load(model.pictureUrl).into(personItemFIvIcon)
            binding.root.setOnClickListener {
                listener.itemClick(model)
            }
        }
    }

    interface OnPersonaApterListener {
        fun itemClick(model: PersonModel)
    }
}