package lx610.com.accountbook.window;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import lx610.com.accountbook.Base.BasePopupWindow;
import lx610.com.accountbook.Dao.ProjectListDaoHelper;
import lx610.com.accountbook.R;

public class AddProjectWindow extends BasePopupWindow {


    private TextView mBt_ok;
    private TextView mBt_cancel;
    private TextView mEtConet;

    public AddProjectWindow(Context context) {
        super(context);
    }

    @Override
    protected void initView(Context context, View contentView) {
        TextView title = contentView.findViewById(R.id.title);
        TextView conentTitle = contentView.findViewById(R.id.content_title1);
        mEtConet = contentView.findViewById(R.id.et_content);
        mBt_ok = contentView.findViewById(R.id.bt_ok);
        mBt_cancel = contentView.findViewById(R.id.bt_cancel);
        initListener();
    }

    private void initListener() {
        mBt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProjectListDaoHelper daoHelper = new ProjectListDaoHelper();
                daoHelper.creatSql(mEtConet.getText().toString());
            }
        });
        mBt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.window_add_project;
    }


}
