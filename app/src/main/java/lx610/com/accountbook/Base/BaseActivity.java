package lx610.com.accountbook.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        initView(savedInstanceState);
        initData();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initData();
    

    protected abstract void initView(Bundle savedInstanceState);

    public abstract int getLayoutResId();
}
