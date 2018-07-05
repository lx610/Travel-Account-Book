package lx610.com.accountbook.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import lx610.com.accountbook.Base.BaseFragment
import lx610.com.accountbook.Dao.PersonDao
import lx610.com.accountbook.R

@SuppressLint("ValidFragment")
class TravalDetailListFragment(var project_name: String) : BaseFragment() {
  var  bt_add_record : Button?=null;
  var  rv_travel_detail_list : RecyclerView?=null;
    var addPerson : TextView?=null;
    override fun initView(rootView: View?, savedInstanceState: Bundle?) {

        bt_add_record = rootView?.findViewById(R.id.bt_add_record);
        rv_travel_detail_list =rootView?.findViewById<RecyclerView>(R.id.rv_travel_detail_list)
         addPerson =  rootView?.findViewById(R.id.add_person);
    }

    override fun getLayouResId(): Int {
       return R.layout.fragment_travel_list_detail;
    }

    override fun initListener() {
        bt_add_record?.setOnClickListener(View.OnClickListener { Log.d("TravelDetail","记录一笔") })
        addPerson.setOnClickListener(View.OnClickListener {

        })
    }

    override fun initData(savedInstanceState: Bundle?) {
        rv_travel_detail_list?.layoutManager = LinearLayoutManager(safeActivity);
        var list2 :ArrayList<String> = ArrayList();
        for (i in 1..10){
            list2.add("a");
        }

        var personDao :PersonDao = PersonDao(safeActivity);
        var personList = personDao.query_person(project_name);


    }
}