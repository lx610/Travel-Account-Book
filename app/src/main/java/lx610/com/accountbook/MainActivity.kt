package lx610.com.accountbook

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import lx610.com.accountbook.R.id.bt_add_travel

class MainActivity : AppCompatActivity() {

    var btAdd: Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         btAdd = findViewById(bt_add_travel);

        btAdd!!.setOnClickListener{
            Toast.makeText(this,"点击了",Toast.LENGTH_SHORT).show();
        }
    }
}
