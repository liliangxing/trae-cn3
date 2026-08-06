package com.bytedance.apm.block.trace;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.block.AbsLooperObserver;
import com.bytedance.apm6.foundation.ActivityLifeManager;
import com.bytedance.apm6.service.ServiceManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class AbsTracer extends AbsLooperObserver implements ITracer {
    private static final String TAG = "Matrix.AbsTracer";
    private volatile boolean isAlive = false;

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityPause(Activity activity) {
    }

    public void onActivityResume(Activity activity) {
    }

    public void onActivityStarted(Activity activity) {
    }

    protected void onAlive() {
    }

    public void onBackground(Activity activity) {
    }

    public void onChange(Activity activity, Fragment fragment) {
    }

    protected void onDead() {
    }

    public void onFront(Activity activity) {
    }

    @Override // com.bytedance.apm.block.trace.ITracer
    public final synchronized void onStartTrace() {
        if (!this.isAlive) {
            this.isAlive = true;
            onAlive();
        }
    }

    @Override // com.bytedance.apm.block.trace.ITracer
    public final synchronized void onCloseTrace() {
        if (this.isAlive) {
            this.isAlive = false;
            onDead();
        }
    }

    @Override // com.bytedance.apm.block.trace.ITracer
    public boolean isAlive() {
        return this.isAlive;
    }

    public boolean isForeground() {
        return ((ActivityLifeManager) ServiceManager.getService(ActivityLifeManager.class)).isForeground();
    }
}
