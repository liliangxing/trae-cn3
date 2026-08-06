package com.bytedance.push.alive;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;

/* loaded from: classes4.dex */
public interface IAlive {
    boolean checkConfig(Context context, String str) throws PackageManager.NameNotFoundException;

    void doKeepAlive(Context context, Handler handler);

    void enableMessageReceiver(Context context, boolean z);

    boolean isSsWoFinished();
}
