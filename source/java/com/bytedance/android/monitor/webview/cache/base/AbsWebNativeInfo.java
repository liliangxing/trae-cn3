package com.bytedance.android.monitor.webview.cache.base;

import com.bytedance.android.monitor.base.BaseNativeInfo;

/* loaded from: classes3.dex */
public abstract class AbsWebNativeInfo extends BaseNativeInfo {
    private boolean canReport;

    public abstract void reset();

    public AbsWebNativeInfo(String str) {
        super(str);
        this.canReport = false;
    }

    public final boolean isCanReport() {
        return this.canReport;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void enableReport() {
        this.canReport = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void disableReport() {
        this.canReport = false;
    }
}
