package com.lynx.tasm.behavior;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.lynx.tasm.base.LLog;

/* loaded from: classes7.dex */
public class KeyboardMonitor extends Dialog {
    private static final String TAG = "KeyboardMonitor";

    public KeyboardMonitor(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setGravity(3);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(2, -1);
        getWindow().setSoftInputMode(16);
        getWindow().addFlags(32);
        getWindow().addFlags(8);
        getWindow().addFlags(131072);
        getWindow().clearFlags(2);
        getWindow().clearFlags(1024);
        getWindow().clearFlags(67108864);
        getWindow().clearFlags(256);
        getWindow().clearFlags(134217728);
        getDecorView().setSystemUiVisibility(0);
        getDecorView().setOutlineProvider(null);
        getDecorView().setElevation(0.0f);
        getDecorView().setTranslationZ(0.0f);
    }

    public int getDefaultMonitorBottom() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getCurrentSizeRange(point, point2);
        defaultDisplay.getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int rotation = defaultDisplay.getRotation();
        if (rotation != 0 && rotation != 2) {
            return i;
        }
        if (point2.y < i) {
            i = point2.y;
        }
        int identifier = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        return i + (identifier > 0 ? getContext().getResources().getDimensionPixelSize(identifier) : 0);
    }

    public View getDecorView() {
        return getWindow().getDecorView();
    }

    private static Activity getActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return getActivity(((ContextWrapper) context).getBaseContext());
        }
        throw new IllegalArgumentException();
    }

    public void start() {
        if (isShowing()) {
            return;
        }
        try {
            if (getActivity(getContext()).isFinishing()) {
                return;
            }
            show();
        } catch (WindowManager.BadTokenException e) {
            LLog.w(TAG, e.toString());
        } catch (RuntimeException e2) {
            LLog.w(TAG, e2.toString());
        }
    }

    public void stop() {
        if (isShowing()) {
            try {
                dismiss();
            } catch (WindowManager.BadTokenException e) {
                LLog.w(TAG, e.toString());
            } catch (RuntimeException e2) {
                LLog.w(TAG, e2.toString());
            }
        }
    }

    public void addOnGlobalLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public void removeOnGlobalLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }
}
