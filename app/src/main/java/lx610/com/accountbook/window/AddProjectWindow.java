package lx610.com.accountbook.window;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import lx610.com.accountbook.Base.BasePopupWindow;
import lx610.com.accountbook.Dao.ProjectDao;
import lx610.com.accountbook.R;

public class AddProjectWindow extends BasePopupWindow {


    private TextView mBt_ok;
    private TextView mBt_cancel;
    private TextView mEtConet;
    private Context mContext;


    public AddProjectWindow(Context context) {
        super(context);
    }

    @Override
    protected void initView(Context context, View contentView) {
        mContext = context;
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
                ProjectDao dao =new ProjectDao(mContext);
                SimpleDateFormat format =new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
                dao.insert_project_table(mEtConet.getText().toString(),   format.format(System.currentTimeMillis()));
                if (mDataChangeListener!=null){
                    mDataChangeListener.refreshData();
                }
                dismiss();
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

    public interface DataChangeListener{
        void refreshData();
    }
    DataChangeListener mDataChangeListener;

    public void setDataChangeListener(DataChangeListener dataChangeListener) {
        mDataChangeListener = dataChangeListener;
    }
}
