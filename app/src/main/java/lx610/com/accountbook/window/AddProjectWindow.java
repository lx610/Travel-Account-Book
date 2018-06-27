package lx610.com.accountbook.window;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import lx610.com.accountbook.Base.BasePopupWindow;
import lx610.com.accountbook.R;

public class AddProjectWindow extends BasePopupWindow {


    public AddProjectWindow(Context context) {
        super(context);
    }

    @Override
    protected void initView(Context context, View contentView) {
        TextView title = contentView.findViewById(R.id.title);
        TextView conentTitle = contentView.findViewById(R.id.content_title1);
        TextView etConet = contentView.findViewById(R.id.et_content);
        TextView bt_ok = contentView.findViewById(R.id.bt_ok);
        TextView bt_cancel = contentView.findViewById(R.id.bt_cancel);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.window_add_project;
    }


}
