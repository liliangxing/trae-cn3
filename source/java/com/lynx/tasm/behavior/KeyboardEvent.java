package com.lynx.tasm.behavior;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.p000ui.UIBody;
import com.lynx.tasm.event.LynxKeyboardEvent;
import com.lynx.tasm.utils.ContextUtils;
import com.lynx.tasm.utils.LynxConstants;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class KeyboardEvent {
    private static final double KEYBOARD_HIGHER_THRESHOLD = 0.9d;
    private static final double KEYBOARD_LOWER_THRESHOLD = 0.4d;
    private Rect mDisplayFrame;
    private float mDpi;
    private KeyboardMonitor mKeyboardMonitor;
    private LynxContext mLynxContext;
    private ViewTreeObserver.OnGlobalLayoutListener mListener = null;
    private boolean isStartedInUIThread = false;
    private int mViewHeight = 0;

    @Deprecated
    private int mOldViewHeight = 0;
    private int keyboardHeightForLast = 0;
    private int keyboardTopFromLynxView = 0;
    private WeakHashMap<Object, ViewTreeObserver.OnGlobalLayoutListener> mOnGlobalLayoutListenerList = new WeakHashMap<>();
    private WeakHashMap<Object, KeyboardEventObserver> mObservers = new WeakHashMap<>();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface KeyboardEventObserver {
        void keyboardWillHide();

        void keyboardWillShow(int i);
    }

    public KeyboardEvent(LynxContext lynxContext) {
        LLog.d(LynxConstants.TAG, "KeyboardEvent initialized.");
        this.mLynxContext = lynxContext;
        this.mDpi = lynxContext.getScreenMetrics().density;
        this.mDisplayFrame = new Rect();
    }

    public synchronized void start() {
        if (this.isStartedInUIThread) {
            LLog.d(LynxConstants.TAG, "KeyboardEvent already started");
            return;
        }
        if (!UIThreadUtils.isOnUiThread()) {
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.behavior.KeyboardEvent.1
                @Override // java.lang.Runnable
                public void run() {
                    KeyboardEvent.this.startInMain();
                }
            });
        } else {
            startInMain();
        }
    }

    public boolean isStart() {
        return this.isStartedInUIThread;
    }

    public KeyboardMonitor getKeyboardMonitor() {
        return this.mKeyboardMonitor;
    }

    public void addOnGlobalLayoutListener(Object obj, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.mOnGlobalLayoutListenerList.put(obj, onGlobalLayoutListener);
        start();
    }

    public void removeOnGlobalLayoutListener(Object obj, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (onGlobalLayoutListener != null) {
            try {
                if (this.mKeyboardMonitor != null) {
                    this.mOnGlobalLayoutListenerList.remove(obj);
                }
            } catch (Exception unused) {
            }
        }
    }

    public ViewTreeObserver.OnGlobalLayoutListener getListener(Object obj) {
        return this.mOnGlobalLayoutListenerList.get(obj);
    }

    public void detectKeyboardChangeAndSendEvent() {
        float f;
        float f2;
        try {
            Activity activity = ContextUtils.getActivity(this.mLynxContext);
            if (activity == null) {
                LLog.e(LynxConstants.TAG, "KeyboardEvent's context must be Activity.");
                return;
            }
            LynxContext lynxContext = this.mLynxContext;
            View decorView = activity.getWindow().getDecorView();
            boolean useRelativeKeyboardHeightApi = lynxContext.useRelativeKeyboardHeightApi();
            if (lynxContext.getUIBody() == null) {
                return;
            }
            WeakReference weakReference = new WeakReference(lynxContext.getUIBody().getBodyView());
            this.mKeyboardMonitor.getDecorView().getWindowVisibleDisplayFrame(this.mDisplayFrame);
            int height = this.mKeyboardMonitor.getDecorView().getHeight() + this.mDisplayFrame.top;
            int height2 = this.mKeyboardMonitor.getDecorView().getHeight();
            if (this.mOldViewHeight == 0) {
                this.mOldViewHeight = decorView.getHeight();
            }
            this.mViewHeight = this.mKeyboardMonitor.getDefaultMonitorBottom() - this.mDisplayFrame.top;
            int rotation = activity.getWindow().getWindowManager().getDefaultDisplay().getRotation();
            int i = this.mOldViewHeight;
            int i2 = this.mViewHeight;
            double d = height2 / i2;
            if ((rotation == 0 || rotation == 2) && d < KEYBOARD_LOWER_THRESHOLD) {
                UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.behavior.KeyboardEvent.2
                    @Override // java.lang.Runnable
                    public void run() {
                        KeyboardEvent.this.mKeyboardMonitor.getDecorView().requestLayout();
                    }
                });
                return;
            }
            int i3 = 0;
            boolean z = d < KEYBOARD_HIGHER_THRESHOLD;
            UIBody.UIBodyView uIBodyView = (UIBody.UIBodyView) weakReference.get();
            int i4 = z ? (int) ((i - height2) / this.mDpi) : 0;
            if (useRelativeKeyboardHeightApi && uIBodyView != null) {
                int[] iArr = new int[2];
                uIBodyView.getLocationOnScreen(iArr);
                f = (iArr[1] + uIBodyView.getHeight()) - height;
                f2 = this.mDpi;
            } else {
                if (z) {
                    f = i2 - height2;
                    f2 = this.mDpi;
                }
                LLog.d(LynxConstants.TAG, "KeyboardEvent visible = " + z + ", height = " + i4 + ", compatHeight = " + i3);
                if (i4 == this.keyboardHeightForLast || (useRelativeKeyboardHeightApi && i3 != this.keyboardTopFromLynxView)) {
                    sendKeyboardEvent(z, i4, i3);
                    this.keyboardHeightForLast = i4;
                    this.keyboardTopFromLynxView = i3;
                }
                dispatchOnGlobalLayout();
            }
            i3 = (int) (f / f2);
            LLog.d(LynxConstants.TAG, "KeyboardEvent visible = " + z + ", height = " + i4 + ", compatHeight = " + i3);
            if (i4 == this.keyboardHeightForLast) {
            }
            sendKeyboardEvent(z, i4, i3);
            this.keyboardHeightForLast = i4;
            this.keyboardTopFromLynxView = i3;
            dispatchOnGlobalLayout();
        } catch (Exception e) {
            LLog.e(LynxConstants.TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInMain() {
        LLog.d(LynxConstants.TAG, "KeyboardEvent starting");
        Activity activity = ContextUtils.getActivity(this.mLynxContext);
        if (activity == null) {
            LLog.e(LynxConstants.TAG, "KeyboardEvent's context must be Activity");
            return;
        }
        if (this.mKeyboardMonitor == null) {
            this.mKeyboardMonitor = new KeyboardMonitor(activity);
        }
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.lynx.tasm.behavior.KeyboardEvent.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                LLog.d(LynxConstants.TAG, "onGlobalLayout invoked.");
                KeyboardEvent.this.detectKeyboardChangeAndSendEvent();
            }
        };
        this.mListener = onGlobalLayoutListener;
        this.mKeyboardMonitor.addOnGlobalLayoutListener(onGlobalLayoutListener);
        this.mKeyboardMonitor.start();
        this.isStartedInUIThread = true;
    }

    public synchronized void stop() {
        if (this.isStartedInUIThread) {
            if (!UIThreadUtils.isOnUiThread()) {
                UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.behavior.KeyboardEvent.4
                    @Override // java.lang.Runnable
                    public void run() {
                        KeyboardEvent.this.stopInMain();
                    }
                });
            } else {
                stopInMain();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopInMain() {
        KeyboardMonitor keyboardMonitor;
        LLog.d(LynxConstants.TAG, "KeyboardEvent stopping");
        try {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.mListener;
            if (onGlobalLayoutListener != null && (keyboardMonitor = this.mKeyboardMonitor) != null) {
                keyboardMonitor.removeOnGlobalLayoutListener(onGlobalLayoutListener);
                this.mKeyboardMonitor.stop();
            }
        } catch (Exception e) {
            LLog.w(LynxConstants.TAG, "stop KeyboardEvent failed for " + e.toString());
        }
        this.isStartedInUIThread = false;
    }

    private void sendKeyboardEvent(boolean z, int i, int i2) {
        if (this.mLynxContext.getEventEmitter() != null) {
            JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
            javaOnlyArray.pushString(z ? "on" : "off");
            javaOnlyArray.pushInt(i2);
            javaOnlyArray.pushInt(i2);
            this.mLynxContext.sendGlobalEvent(LynxKeyboardEvent.KEYBOARD_STATUS_CHANGED, javaOnlyArray);
        }
        Iterator<Map.Entry<Object, KeyboardEventObserver>> it = this.mObservers.entrySet().iterator();
        while (it.hasNext()) {
            KeyboardEventObserver value = it.next().getValue();
            if (z) {
                value.keyboardWillShow((int) (i2 * this.mDpi));
            } else {
                value.keyboardWillHide();
            }
        }
    }

    public Rect getDisplayFrame() {
        return this.mDisplayFrame;
    }

    public int getEventViewHeight() {
        return this.mViewHeight;
    }

    private void dispatchOnGlobalLayout() {
        for (Map.Entry<Object, ViewTreeObserver.OnGlobalLayoutListener> entry : this.mOnGlobalLayoutListenerList.entrySet()) {
            if (entry.getKey() != null) {
                entry.getValue().onGlobalLayout();
            }
        }
    }

    public void addKeyboardEventObserver(KeyboardEventObserver keyboardEventObserver) {
        if (keyboardEventObserver != null) {
            this.mObservers.put(keyboardEventObserver, keyboardEventObserver);
        }
    }
}
