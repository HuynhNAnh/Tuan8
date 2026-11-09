package vn.udn.ute.week08.s2415053122202

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import vn.udn.ute.week08.s2415053122202.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.edtTenHP.doAfterTextChanged {
            binding.edtTenHP.error = null
            binding.tvKetQua.text = ""
        }
        binding.edtQT.doAfterTextChanged {
            binding.edtQT.error = null
            binding.tvKetQua.text = ""
        }
        binding.edtCK.doAfterTextChanged {
            binding.edtCK.error = null
            binding.tvKetQua.text = ""
        }
        binding.btnKiemTra.setOnClickListener {
            if(kiemTraDuLieu()){
                Toast.makeText(this,"Dữ liệu hợp lệ", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnKetQua.setOnClickListener {
            binding.tvKetQua.text = ""
            if(kiemTraDuLieu()){
                val qt = binding.edtQT.text.toString().toDouble()
                val ck = binding.edtCK.text.toString().toDouble()
                val t = tinhDiem(qt,ck)
                val xepLoai = phanLoai(t,ck)
                binding.tvKetQua.text = "Điểm T: %.2f\n Kết quả: %s".format(t,xepLoai)
            }
        }
        binding.btnXoa.setOnClickListener {
            binding.edtTenHP.text?.clear()
            binding.edtQT.text?.clear()
            binding.edtCK.text?.clear()
        }
        binding.btnLamSach.setOnClickListener {
            binding.edtTenHP.text?.clear()
            binding.edtQT.text?.clear()
            binding.edtCK.text?.clear()

            binding.edtTenHP.error = null
            binding.edtQT.error = null
            binding.edtCK.error = null
            binding.tvKetQua.text = ""
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
            binding.edtTenHP.error = "Không được để trống"
            hopLe = false
        }
        if (qt == null || qt !in 0.0..10.0){
            binding.edtQT.error = "Điểm quá trình phải từ 0 đến 10"
            hopLe = false
        }
        if (ck == null || ck !in 0.0..10.0){
            binding.edtCK.error = "Điểm cuối kỳ phải từ 0 đến 10"
            hopLe = false
        }
        return hopLe
    }
    private fun tinhDiem(qt: Double, ck: Double): Double{
        return 0.4 * qt + 0.6 * ck
    }
    private fun phanLoai(t: Double,ck: Double): String {
        return if(t >=5.0 && ck >= 3.0){
            "Đạt"
        }else{ "Chưa đạt"}
    }
}