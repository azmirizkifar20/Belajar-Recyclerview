package org.d3if4055.belajarrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import org.d3if4055.belajarrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), RecyclerViewClickListener {

    // inisialisasi binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val listNegara = listOf(
            Negara("Indonesia", "jakarta"),
            Negara("Malaysia", "Kuala Lumpur"),
            Negara("Jepang", "Tokyo"),
            Negara("Australia", "Canberra")
        )

        val negaraAdapter = NegaraAdapter(listNegara)
        val recyclerView = binding.rvNegara

        // set click listener
        negaraAdapter.listener = this

        recyclerView.apply {
            this.adapter = negaraAdapter
            this.layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }

    override fun onItemClicked(view: View, negara: Negara) {
        Toast.makeText(this,
            "Negara ${negara.namaNegara} berhasil di klik",
            Toast.LENGTH_SHORT
        ).show()
    }
}
