package com.mrflaitx.shoppingapp40.presentation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mrflaitx.shoppingapp40.R
import com.mrflaitx.shoppingapp40.databinding.ActivityRecyclerBinding
import com.mrflaitx.shoppingapp40.domain.entity.ShopItem

class RecyclerActivity : AppCompatActivity(R.layout.activity_recycler) {

    private val viewModel: MainViewModel by viewModels()
    private val binding: ActivityRecyclerBinding by viewBinding(ActivityRecyclerBinding::bind)
    private val adapter = ShopAdapter(this::onClickItem)

    private fun onClickItem(shopItem: ShopItem) {
        viewModel.editShopItem(shopItem)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
        initCallBack()
        initListener()
    }

    private fun initListener() {
        binding.fab.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            activityResult.launch(intent)
        }
    }

    private fun initCallBack() {
        binding.recycler.adapter = adapter
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = adapter.list[viewHolder.absoluteAdapterPosition]
                viewModel.removeShopItem(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.recycler)
    }

    private fun initAdapter() {
        binding.recycler.adapter = adapter
        viewModel.getShopList().observe(this) {
            adapter.initList(it)
        }
    }

    private val activityResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK && it.data != null) {
                val name = it.data?.getStringExtra("name")
                val count = it.data?.getStringExtra("count")
                viewModel.addShopItem(ShopItem(name.toString(), count.toString().toInt(), false))
            }
        }
}