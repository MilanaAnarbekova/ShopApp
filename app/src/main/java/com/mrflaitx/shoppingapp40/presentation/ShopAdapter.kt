package com.mrflaitx.shoppingapp40.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mrflaitx.shoppingapp40.databinding.ItemColorListBinding
import com.mrflaitx.shoppingapp40.databinding.ItemNoColorListBinding
import com.mrflaitx.shoppingapp40.domain.entity.ShopItem


private const val COLOR_ITEM = 0
private const val NOT_COLOR_ITEM = 1

class ShopAdapter(private val onItemClick: (shopItem: ShopItem) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var _list = listOf<ShopItem>()
    var list = listOf<ShopItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            COLOR_ITEM -> {
                return ColorViewHolder(
                    ItemColorListBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            NOT_COLOR_ITEM -> {
                return NotColorViewHolder(
                    ItemNoColorListBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                throw RuntimeException("Not found")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            COLOR_ITEM -> (holder as ColorViewHolder).bind(_list[position])
            NOT_COLOR_ITEM -> (holder as NotColorViewHolder).bind(_list[position])
        }
    }

    override fun getItemCount(): Int {
        return _list.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (_list[position].enable) {
            true -> COLOR_ITEM
            false -> NOT_COLOR_ITEM
        }
    }

    fun initList(list: List<ShopItem>) {
        val callback = DiffCallBack(this._list, list)
        val diffResult = DiffUtil.calculateDiff(callback)
        diffResult.dispatchUpdatesTo(this)
        this._list = list
        this.list = _list
    }

    inner class NotColorViewHolder(private val binding: ItemNoColorListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(shopItem: ShopItem) {
            binding.tvCount.text = shopItem.count.toString()
            binding.tvName.text = shopItem.name
            itemView.setOnLongClickListener{
                onItemClick(shopItem)
                return@setOnLongClickListener true
            }
        }

    }

    inner class ColorViewHolder(private val binding: ItemColorListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(shopItem: ShopItem) {
            binding.tvCount.text = shopItem.count.toString()
            binding.tvName.text = shopItem.name
                itemView.setOnLongClickListener {
                    onItemClick(shopItem)
                    return@setOnLongClickListener true
                }
            }
        }

    }

