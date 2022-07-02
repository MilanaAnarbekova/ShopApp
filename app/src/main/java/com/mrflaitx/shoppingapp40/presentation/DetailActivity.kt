package com.mrflaitx.shoppingapp40.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mrflaitx.shoppingapp40.R
import com.mrflaitx.shoppingapp40.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity(R.layout.activity_detail) {

    private val binding: ActivityDetailBinding by viewBinding(ActivityDetailBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListener()
    }

    private fun initListener() {
        binding.btnAddItem.setOnClickListener {
            if (binding.etName.text.toString().isEmpty()
                && binding.etCount.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "Your Item is Empty!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent()
                intent.putExtra("name", binding.etName.text.toString())
                intent.putExtra("count", binding.etCount.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}
