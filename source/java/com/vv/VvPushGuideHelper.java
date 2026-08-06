package com.vv;

/* loaded from: classes7.dex */
public class VvPushGuideHelper {
    public static VvPushGuideHelper sInstance = new VvPushGuideHelper();
    public OnPushGuideClickListener onPushGuideClickListener;

    public static VvPushGuideHelper getInstance() {
        return sInstance;
    }

    public void onNotifyGuideDialogResult(int i) {
        OnPushGuideClickListener onPushGuideClickListener = this.onPushGuideClickListener;
        if (onPushGuideClickListener != null) {
            onPushGuideClickListener.onNotifyGuideDialogResult(i);
            this.onPushGuideClickListener = null;
        }
    }

    public void setOnPushGuideClickListener(OnPushGuideClickListener onPushGuideClickListener) {
        this.onPushGuideClickListener = onPushGuideClickListener;
    }
}
