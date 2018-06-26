package lx610.com.accountbook.Base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
    Activity mActivity;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView==null){
            mView = inflater.inflate(getLayouResId(),container,false);
        }
        initView(mView,savedInstanceState);
        return mView;
    }

    protected abstract void initView(View rootView, Bundle savedInstanceState);

    public abstract int getLayouResId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData(savedInstanceState);
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initData(Bundle savedInstanceState);

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    public Activity getSafeActivity(){
        return mActivity;
    }

}
