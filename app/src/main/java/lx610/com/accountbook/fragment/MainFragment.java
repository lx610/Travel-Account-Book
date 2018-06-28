package lx610.com.accountbook.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import lx610.com.accountbook.Base.BaseAdapter;
import lx610.com.accountbook.Base.BaseFragment;
import lx610.com.accountbook.Dao.ProjectDao;
import lx610.com.accountbook.MainActivity;
import lx610.com.accountbook.R;
import lx610.com.accountbook.adapter.MainAdapter;
import lx610.com.accountbook.bean.ProjectListBean;
import lx610.com.accountbook.window.AddProjectWindow;

public class MainFragment extends BaseFragment {


    private RecyclerView mList;
    private Button mBtAdd;
    private MainAdapter mAdapter;
    private AddProjectWindow mWindow;
    private List<ProjectListBean> mProjectList;

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mBtAdd = rootView.findViewById(R.id.bt_add_travel);
        mList = rootView.findViewById(R.id.rv_tavel_list);
        mList.setLayoutManager(new LinearLayoutManager(getSafeActivity()));
        mWindow = new AddProjectWindow(getSafeActivity());
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
                mWindow.showWindow(getSafeActivity());
            }
        });
        mAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, Object data, Object rootView) {
                MainActivity activity = (MainActivity) getSafeActivity();
                activity.changeFragmentTo(new TravalDetailListFragment());
            }
        });

        mWindow.setDataChangeListener(new AddProjectWindow.DataChangeListener() {
            @Override
            public void refreshData() {
                ProjectDao dao =new ProjectDao(getSafeActivity());
                List<ProjectListBean> list = dao.query_project();
                mProjectList.clear();
                mProjectList.addAll(list);
                mAdapter.notifyDataSetChanged();
            }
        });

        mAdapter.setOnItemLongClickListener(new BaseAdapter.OnItemLongClickListener<ProjectListBean,BaseAdapter.BaseViewHolder>() {
            @Override
            public void onlongClick(int position, ProjectListBean data, BaseAdapter.BaseViewHolder rootView) {
                ProjectDao dao =new ProjectDao(getSafeActivity());
                dao.deletProject(data.getProjectName());
                mProjectList.remove(position);
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        ProjectDao dao =new ProjectDao(getSafeActivity());
        mProjectList = dao.query_project();
//        for (int i = 0; i < 10; i++) {
//            list.add(i +"");
//        }
        mAdapter = new MainAdapter(mProjectList);
        mList.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
