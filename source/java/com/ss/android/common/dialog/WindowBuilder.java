package com.ss.android.common.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.Animation;
import com.bytedance.common.utility.collection.WeakHandler;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public abstract class WindowBuilder implements View.OnKeyListener, View.OnTouchListener, DialogInterface, WeakHandler.IHandler {
    private static final int CANCEL = 68;
    public static final int CLOSE_BACK = -2;
    public static final int CLOSE_NO_REASON = -1;
    public static final int CLOSE_OUTTOUCH = -3;
    private static final int DISMISS = 67;
    private static final int SHOW = 69;
    private WeakReference<View> mAttachView;
    private boolean mBackDisable;
    private boolean mBlockDismiss;
    private boolean mCancelable;
    private WeakReference<Context> mContextRef;
    private boolean mCreated;
    private WeakHandler mHandler;
    private final boolean mNoToken;
    private DialogInterface.OnCancelListener mOnCancelListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private DialogInterface.OnShowListener mOnShowListener;
    private Runnable mPendingShowRunnable;
    protected ViewGroup mRootView;
    private IBinder mToken;
    protected WindowBase mWindowBase;

    public abstract ViewGroup getRootView();

    public abstract WindowBase getWindowBase();

    public boolean onBackPressed() {
        return false;
    }

    protected void onCreate(Bundle bundle) {
    }

    public void onDismissEvent(int i) {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WindowBuilder() {
        this((View) null);
    }

    public WindowBuilder(Activity activity) {
        this(activity.getWindow().getDecorView());
    }

    public WindowBuilder(View view) {
        this.mHandler = new WeakHandler(this);
        boolean z = view == null;
        this.mNoToken = z;
        IBinder windowToken = z ? null : view.getWindowToken();
        this.mToken = windowToken;
        if (windowToken == null && !z) {
            this.mAttachView = new WeakReference<>(view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.ss.android.common.dialog.WindowBuilder.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    View view2 = (View) WindowBuilder.this.mAttachView.get();
                    if (view2 == null) {
                        return;
                    }
                    WindowBuilder.this.mAttachView.clear();
                    WindowBuilder.this.mAttachView = null;
                    view2.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    if (WindowBuilder.this.mToken == null) {
                        WindowBuilder.this.mToken = view2.getWindowToken();
                    }
                    if (WindowBuilder.this.mToken == null || WindowBuilder.this.mPendingShowRunnable == null) {
                        return;
                    }
                    if (!WindowBuilder.this.isShowing()) {
                        WindowBuilder.this.mPendingShowRunnable.run();
                    }
                    WindowBuilder.this.mPendingShowRunnable = null;
                }
            });
        }
        if (view != null) {
            this.mContextRef = new WeakReference<>(view.getContext());
        }
        initBuilder();
    }

    private void initBuilder() {
        WindowBase windowBase = getWindowBase();
        this.mWindowBase = windowBase;
        if (windowBase == null) {
            throw new NullPointerException("getWindowBase() can't return null");
        }
        ViewGroup rootView = getRootView();
        this.mRootView = rootView;
        if (rootView == null) {
            throw new NullPointerException("getRootView() can't return null");
        }
        rootView.setFocusableInTouchMode(true);
        this.mRootView.setOnKeyListener(this);
        this.mRootView.setOnTouchListener(this);
    }

    public Context getContext() {
        WeakReference<Context> weakReference = this.mContextRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void setFlags(int i, int i2) {
        WindowManager.LayoutParams layoutParams = this.mWindowBase.getLayoutParams();
        layoutParams.flags = (i & i2) | (layoutParams.flags & (~i2));
    }

    public View findViewById(int i) {
        return this.mRootView.findViewById(i);
    }

    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.mOnShowListener = onShowListener;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setCancelable(boolean z) {
        this.mCancelable = z;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.mCancelable = z;
    }

    public void dispatchDismissEvent(int i) {
        this.mHandler.sendEmptyMessage(67);
        onDismissEvent(i);
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public boolean isShowing() {
        return this.mWindowBase.isShowing();
    }

    public void show() {
        show(0, 0);
    }

    public void show(final int i, final int i2) {
        if (this.mNoToken || this.mToken != null) {
            onPreShow();
            this.mWindowBase.show(this.mRootView, i, i2, this.mToken);
            onShow();
            return;
        }
        this.mPendingShowRunnable = new Runnable() { // from class: com.ss.android.common.dialog.WindowBuilder.2
            @Override // java.lang.Runnable
            public void run() {
                WindowBuilder.this.onPreShow();
                WindowBuilder.this.mWindowBase.show(WindowBuilder.this.mRootView, i, i2, WindowBuilder.this.mToken);
                WindowBuilder.this.onShow();
            }
        };
    }

    protected void onPreShow() {
        if (this.mCreated) {
            return;
        }
        dispatchOnCreate(null);
    }

    protected void onShow() {
        this.mHandler.sendEmptyMessage(69);
    }

    protected void dispatchOnCreate(Bundle bundle) {
        if (this.mCreated) {
            return;
        }
        onCreate(bundle);
        this.mCreated = true;
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.mOnCancelListener = onCancelListener;
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        this.mHandler.sendEmptyMessage(68);
        close();
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        close();
    }

    public void close() {
        close(-1);
    }

    public void requestBlockDismiss() {
        this.mBlockDismiss = true;
    }

    public void close(int i) {
        dispatchDismissEvent(i);
        if (!this.mBlockDismiss) {
            this.mWindowBase.remove();
        } else {
            this.mBlockDismiss = false;
        }
    }

    public void update(int i, int i2) {
        this.mWindowBase.update(i, i2);
    }

    public void update(WindowManager.LayoutParams layoutParams) {
        this.mWindowBase.update(layoutParams);
    }

    public void startAnimation(int i, Animation animation) {
        this.mRootView.findViewById(i).startAnimation(animation);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.mCancelable) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0 && (x < 0 || x >= this.mRootView.getWidth() || y < 0 || y >= this.mRootView.getHeight())) {
            close(-3);
            return true;
        }
        if (motionEvent.getAction() != 4) {
            return false;
        }
        close(-3);
        return true;
    }

    public void setBackDisable(boolean z) {
        this.mBackDisable = z;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.mBackDisable) {
            return false;
        }
        DialogInterface.OnKeyListener onKeyListener = this.mOnKeyListener;
        if (onKeyListener != null && onKeyListener.onKey(this, i, keyEvent)) {
            return true;
        }
        if (i != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        if (!onBackPressed()) {
            close(-2);
        }
        return true;
    }

    public static void closeSelf(WindowBuilder windowBuilder) {
        if (windowBuilder == null || !windowBuilder.isShowing()) {
            return;
        }
        windowBuilder.close();
    }

    public WindowManager getWindowManager() {
        WindowBase windowBase = this.mWindowBase;
        if (windowBase != null) {
            return windowBase.getWindowManager();
        }
        return null;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message message) {
        switch (message.what) {
            case 67:
                DialogInterface.OnDismissListener onDismissListener = this.mOnDismissListener;
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(this);
                    return;
                }
                return;
            case 68:
                DialogInterface.OnCancelListener onCancelListener = this.mOnCancelListener;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(this);
                    return;
                }
                return;
            case 69:
                DialogInterface.OnShowListener onShowListener = this.mOnShowListener;
                if (onShowListener != null) {
                    onShowListener.onShow(this);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
