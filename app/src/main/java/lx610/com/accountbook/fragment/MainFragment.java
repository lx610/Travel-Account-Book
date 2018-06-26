package lx610.com.accountbook.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import lx610.com.accountbook.Base.BaseFragment;
import lx610.com.accountbook.R;

public class MainFragment extends BaseFragment {


    private RecyclerView mList;
    private Button mBtAdd;

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mBtAdd = rootView.findViewById(R.id.bt_add_travel);
        mList = rootView.findViewById(R.id.rv_tavel_list);
    }

    @Override
    public int getLayouResId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initListener() {
        mBtAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getSafeActivity(),"点击了",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
    }
}
