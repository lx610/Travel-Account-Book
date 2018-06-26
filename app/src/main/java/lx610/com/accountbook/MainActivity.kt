package lx610.com.accountbook

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import lx610.com.accountbook.fragment.MainFragment

class MainActivity : AppCompatActivity() {
    var root: ConstraintLayout? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        root = findViewById(R.id.root);

        var ts : FragmentTransaction =supportFragmentManager.beginTransaction();
        var fm : Fragment
        fm = MainFragment();
        ts.replace(R.id.root,fm);
        ts.commit();

    }

    fun changeFragmentTo( fragment:Fragment) {
        var ts : FragmentTransaction =supportFragmentManager.beginTransaction();
        ts.replace(R.id.root,fragment);
        ts.commit();
    }
}
