package lx610.com.accountbook.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;

import lx610.com.accountbook.Base.BaseFragmentActivity;
import lx610.com.accountbook.Dao.ProjectDao;
import lx610.com.accountbook.fragment.TravalDetailListFragment;

public class ProjectDetailActivity extends BaseFragmentActivity {

    private String mProject_name;

    @Override
    protected Fragment getFragment() {
        handlerIntent();
        return new TravalDetailListFragment(mProject_name);
    }

    private void handlerIntent() {
        Intent intent = getIntent();
        mProject_name = intent.getStringExtra(ProjectDao.PROJECT_NAME);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
