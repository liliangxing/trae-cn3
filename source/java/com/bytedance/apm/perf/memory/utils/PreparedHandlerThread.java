package com.bytedance.apm.perf.memory.utils;

import android.os.HandlerThread;

@Deprecated
/* loaded from: classes3.dex */
public class PreparedHandlerThread extends HandlerThread {
    private PreparedCallBack preparedCallBack;

    /* loaded from: classes3.dex */
    public interface PreparedCallBack {
        void onLooperPrepared();
    }

    public PreparedHandlerThread(String str) {
        super(str);
    }

    public PreparedHandlerThread(String str, int i) {
        super(str, i);
    }

    public void setPreparedCallBack(PreparedCallBack preparedCallBack) {
        this.preparedCallBack = preparedCallBack;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        synchronized (PreparedHandlerThread.class) {
            PreparedCallBack preparedCallBack = this.preparedCallBack;
            if (preparedCallBack != null) {
                preparedCallBack.onLooperPrepared();
            }
        }
    }
}
