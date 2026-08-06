package com.bytedance.bdinstall.util;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.IInstallListener;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.OnResetListener;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TimeoutInstallListener implements IInstallListener {
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private OnResetListener mListener;
    private final long mTimeout;
    private InstallOptions sOptions;

    public TimeoutInstallListener(long j, OnResetListener onResetListener, InstallOptions installOptions) {
        this.mTimeout = j;
        this.mListener = onResetListener;
        this.sOptions = installOptions;
    }

    @Override // com.bytedance.bdinstall.IInstallListener
    public void installFinished(final InstallInfo installInfo) {
        this.mHandler.post(new Runnable() { // from class: com.bytedance.bdinstall.util.TimeoutInstallListener.1
            @Override // java.lang.Runnable
            public void run() {
                if (TimeoutInstallListener.this.mListener != null) {
                    TimeoutInstallListener.this.mListener.onDidUpdate(installInfo);
                    TimeoutInstallListener.this.removeInstallListener();
                }
                TimeoutInstallListener.this.mListener = null;
            }
        });
    }

    public void startTiming() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.bytedance.bdinstall.util.TimeoutInstallListener.2
            @Override // java.lang.Runnable
            public void run() {
                if (TimeoutInstallListener.this.mListener != null) {
                    TimeoutInstallListener.this.mListener.onTimeout();
                    TimeoutInstallListener.this.removeInstallListener();
                }
                TimeoutInstallListener.this.mListener = null;
            }
        }, this.mTimeout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeInstallListener() {
        InstallOptions installOptions = this.sOptions;
        if (installOptions == null || installOptions.isMainInstance()) {
            BDInstall.removeInstallListener(this);
        } else {
            BDInstall.getInstance(String.valueOf(this.sOptions.getAid())).removeInstallListener(this);
        }
    }
}
