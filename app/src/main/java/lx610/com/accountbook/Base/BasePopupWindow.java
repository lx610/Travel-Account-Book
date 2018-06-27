package lx610.com.accountbook.Base;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

public abstract class BasePopupWindow extends PopupWindow {

    public BasePopupWindow(Context context) {
        super(context);
        init(context);
    }

    public BasePopupWindow(View contentView, int width, int height, boolean focusable) {
        super(contentView, width, height, focusable);
    }

    private void init(Context context) {
        View contentView = LayoutInflater.from(context).inflate(getLayoutRes(), null);
        this.setContentView(contentView);
        this.setWidth( ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        initView(context,contentView);
    }

    protected abstract void initView(Context context, View contentView);

    protected abstract int getLayoutRes();


    public BasePopupWindow(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void showWindow(final Activity activity){
        ViewGroup viewGrop= (ViewGroup) activity.getWindow().getDecorView().findViewById(android.R.id.content);
        // 设置背景颜色变暗
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = 0.7f;
        activity. getWindow().setAttributes(lp);
        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                lp.alpha = 1f;
                activity.getWindow().setAttributes(lp);
            }
        });
        this.showAtLocation(viewGrop, Gravity.CENTER,0,0);
    };
}
