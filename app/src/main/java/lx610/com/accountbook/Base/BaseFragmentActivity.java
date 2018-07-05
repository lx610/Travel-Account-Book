package lx610.com.accountbook.Base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import lx610.com.accountbook.R;

public abstract class BaseFragmentActivity extends BaseActivity {
    FrameLayout rootView;


    @Override
    protected void initView(Bundle savedInstanceState) {
        rootView = findViewById(R.id.root);
        FragmentManager manager =getSupportFragmentManager();
        FragmentTransaction ts = manager.beginTransaction();
        ts.replace(R.id.root,getFragment());
        ts.commit();
    }

    protected abstract Fragment getFragment();

    @Override
    public int getLayoutResId() {
        return R.layout.only_fragment_activity;
    }
}
