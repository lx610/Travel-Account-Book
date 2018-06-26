package lx610.com.accountbook.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Button
import lx610.com.accountbook.Base.BaseFragment
import lx610.com.accountbook.R
import lx610.com.accountbook.adapter.MainAdapter

class TravalDetailListFragment : BaseFragment() {
  var  bt_add_record : Button?=null;
  var  rv_travel_detail_list : RecyclerView?=null;
    override fun initView(rootView: View?, savedInstanceState: Bundle?) {

        bt_add_record = rootView?.findViewById(R.id.bt_add_record);
        rv_travel_detail_list =rootView?.findViewById<RecyclerView>(R.id.rv_travel_detail_list)
    }

    override fun getLayouResId(): Int {
       return R.layout.fragment_travel_list_detail;
    }

    override fun initListener() {
        bt_add_record?.setOnClickListener(View.OnClickListener { Log.d("TravelDetail","记录一笔") })
    }

    override fun initData(savedInstanceState: Bundle?) {
        rv_travel_detail_list?.layoutManager = LinearLayoutManager(safeActivity);
        var list2 :ArrayList<String> = ArrayList();
        for (i in 1..10){
            list2.add("a");
        }
        rv_travel_detail_list?.adapter = MainAdapter(list2);
    }
}