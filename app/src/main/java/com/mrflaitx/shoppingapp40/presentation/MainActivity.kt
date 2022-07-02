package com.mrflaitx.shoppingapp40.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mrflaitx.shoppingapp40.R
import com.mrflaitx.shoppingapp40.databinding.ActivityMainBinding
import com.mrflaitx.shoppingapp40.domain.entity.ShopItem
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import java.util.EnumSet.of
import java.util.List.of


@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var viewModel : MainViewModel
    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    private fun initListeners() {
        binding.apply {
            btnAdd.setOnClickListener {
                viewModel.addShopItem(
                    ShopItem(
                        "potato",
                        2,
                        false
                    )
                )
            }

            btnDelete.setOnClickListener {
                viewModel.removeShopItem(
                    ShopItem(
                        "potato",
                        2,
                        false
                    )
                )
            }

            btnEdit.setOnClickListener {
                viewModel.editShopItem(
                    ShopItem(
                        "tomato",
                        14,
                        false,
                        14
                    )
                )
            }

        }
    }
}