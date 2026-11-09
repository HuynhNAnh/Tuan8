package vn.udn.ute.week08.s2415053122202

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import vn.udn.ute.week08.s2415053122202.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKiemTra.setOnClickListener {
            if(kiemTraDuLieu()){

            }
        }
    }
    private fun kiemTraDuLieu(): Boolean{
        val ten = binding.edtTenHP.text.toString().trim()
        val qt = binding.edtQT.text.toString().toDoubleOrNull()
        val ck = binding.edtCK.text.toString().toDoubleOrNull()
        binding.edtTenHP.error = null
        binding.edtQT.error = null
        binding.edtCK.error = null
        var hopLe = true
        if(ten.isEmpty()){
            binding.edtTenHP.error = "Vui lòng nhập tên học phần"
            hopLe = false
        }
        if (qt == null || qt !in 0.0..10.0){
            binding.edtQT.error = "Điểm quá trình phải từ 0 đến 10"
            hopLe = false
        }
        if (ck == null || ck !in 0.0..10.0){
            binding.edtCK.error = "Điểm quá trình phải từ 0 đến 10"
            hopLe = false
        }
        return hopLe
    }

}