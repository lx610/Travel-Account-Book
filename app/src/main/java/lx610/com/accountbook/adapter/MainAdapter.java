package lx610.com.accountbook.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.List;

import lx610.com.accountbook.Base.BaseAdapter;
import lx610.com.accountbook.R;

public class MainAdapter extends BaseAdapter<BaseAdapter.BaseViewHolder,Object> {
    public MainAdapter(List<Object> Data) {
        super(Data, R.layout.item_main);
    }

    @Override
    public void bindData(RecyclerView.ViewHolder holder, Object o) {

    }
}
