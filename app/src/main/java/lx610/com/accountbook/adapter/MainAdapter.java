package lx610.com.accountbook.adapter;

import java.util.List;

import lx610.com.accountbook.Base.BaseAdapter;
import lx610.com.accountbook.R;
import lx610.com.accountbook.bean.ProjectListBean;

public class MainAdapter extends BaseAdapter<BaseAdapter.BaseViewHolder,ProjectListBean> {
    public MainAdapter(List<ProjectListBean> Data) {
        super(Data, R.layout.item_main);
    }

    @Override
    public void bindData(BaseAdapter.BaseViewHolder holder, ProjectListBean o) {
        holder.setText(R.id.title,o.getProjectName());
    }
}
