package com.ss.android.common.dialog;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;

/* loaded from: classes7.dex */
public abstract class WindowBase {
    private static final int SHOW_INTERVAL = 20;
    protected Context mContext;
    private long mLastShowTime;
    private WindowManager.LayoutParams mLayoutParams;
    private boolean mShow;
    private View mView;
    private WindowManager mWindowManager;

    protected abstract WindowManager.LayoutParams initLayoutParams();

    public WindowBase(Context context) {
        this.mContext = context;
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams initLayoutParams = initLayoutParams();
        this.mLayoutParams = initLayoutParams;
        if (initLayoutParams == null) {
            throw new NullPointerException("initLayoutParams() can't return null");
        }
    }

    public WindowManager.LayoutParams getLayoutParams() {
        return this.mLayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isShowing() {
        return this.mShow;
    }

    private boolean checkInterval() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastShowTime < 20) {
            return true;
        }
        this.mLastShowTime = currentTimeMillis;
        return false;
    }

    public void show(View view, IBinder iBinder) {
        show(view, 0, 0, iBinder);
    }

    public void show(View view, int i, int i2, IBinder iBinder) {
        if (this.mShow || checkInterval()) {
            return;
        }
        this.mView = view;
        if (this.mWindowManager == null || view == null) {
            return;
        }
        if (iBinder != null) {
            try {
                this.mLayoutParams.token = iBinder;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.mLayoutParams.x = i;
        this.mLayoutParams.y = i2;
        this.mWindowManager.addView(this.mView, this.mLayoutParams);
        this.mShow = true;
    }

    public void remove() {
        WindowManager windowManager;
        View view;
        if (!this.mShow || checkInterval() || (windowManager = this.mWindowManager) == null || (view = this.mView) == null) {
            return;
        }
        try {
            windowManager.removeViewImmediate(view);
            this.mShow = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(int i, int i2) {
        if (!this.mShow || this.mWindowManager == null || this.mView == null) {
            return;
        }
        try {
            this.mLayoutParams.x = i;
            this.mLayoutParams.y = i2;
            this.mWindowManager.updateViewLayout(this.mView, this.mLayoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(WindowManager.LayoutParams layoutParams) {
        WindowManager windowManager;
        View view;
        if (!this.mShow || (windowManager = this.mWindowManager) == null || (view = this.mView) == null) {
            return;
        }
        try {
            this.mLayoutParams = layoutParams;
            windowManager.updateViewLayout(view, layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WindowManager getWindowManager() {
        return this.mWindowManager;
    }
}
