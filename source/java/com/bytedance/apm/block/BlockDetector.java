package com.bytedance.apm.block;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.FluencySwitchListener;
import com.bytedance.apm.FluencySwitchManager;
import com.bytedance.apm.block.trace.MainThreadMonitor;
import com.bytedance.apm.config.FluencyConfig;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.listener.IBlockListener;
import com.bytedance.apm.logging.Logger;
import com.bytedance.services.apm.api.IActivityLifeObserver;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BlockDetector extends AbsLooperObserver implements IActivityLifeObserver, FluencySwitchListener {
    private static final String TAG = "BlockDetector";
    private boolean mInited;
    private StackThread mStackThread = StackThread.getInstance();
    private boolean mStarted;

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityPause(Activity activity) {
    }

    public void onActivityResume(Activity activity) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onChange(Activity activity, Fragment fragment) {
    }

    public void init() {
        ActivityLifeObserver.getInstance().register(this);
        FluencySwitchManager.addListener(this);
        this.mStackThread.init();
        MainThreadMonitor.getMonitor().addObserver(this);
        MainThreadMonitor.getMonitor().setBlockDetectorAdded();
        this.mInited = true;
        if (ApmContext.isDebugMode()) {
            Logger.m86d(TAG, "BlockDetector init: ");
        }
    }

    public void setSliverEnable(boolean z) {
        this.mStackThread.setSliverDump(z);
    }

    @Override // com.bytedance.apm.FluencySwitchListener
    public void onRefresh(FluencyConfig fluencyConfig) {
        if (fluencyConfig == null) {
            return;
        }
        long blockThreshold = fluencyConfig.getBlockThreshold();
        long seriousBlockThreshold = fluencyConfig.getSeriousBlockThreshold();
        boolean isEnableGfxMonitor = fluencyConfig.isEnableGfxMonitor();
        boolean isBlockDumpStackEnable = fluencyConfig.isBlockDumpStackEnable();
        this.mStackThread.setEnableGfxMonitor(isEnableGfxMonitor);
        this.mStackThread.setBlockInterval(blockThreshold);
        this.mStackThread.setSeriousBlockInterval(seriousBlockThreshold);
        this.mStackThread.setEnableDumpStack(isBlockDumpStackEnable);
        this.mStackThread.setNeedMonitorBlock(fluencyConfig.isBlockEnableUpload());
        this.mStackThread.setNeedMonitorSeriousBlock(ApmContext.isNeedSalvage() || fluencyConfig.isSeriousBlockEnableUpload());
    }

    public void start() {
        if (!this.mInited || this.mStarted) {
            return;
        }
        this.mStarted = true;
        if (ApmContext.isDebugMode()) {
            Logger.m86d(TAG, "BlockDetector start: ");
        }
    }

    public void stop() {
        if (this.mStarted) {
            this.mStarted = false;
            this.mStackThread.printEnd(false);
            if (ApmContext.isDebugMode()) {
                Logger.m86d(TAG, "BlockDetector stop: ");
            }
        }
    }

    @Override // com.bytedance.apm.block.AbsLooperObserver
    public void dispatchEnd(long j, long j2, long j3, long j4, boolean z) {
        super.dispatchEnd(j, j2, j3, j4, z);
        if (this.mStarted) {
            this.mStackThread.printEnd(z);
        }
    }

    @Override // com.bytedance.apm.block.AbsLooperObserver
    public void dispatchBegin(String str) {
        super.dispatchBegin(str);
        if (this.mStarted) {
            this.mStackThread.printStart(str);
        }
    }

    public void onBackground(Activity activity) {
        stop();
    }

    public void onFront(Activity activity) {
        start();
    }

    public void setBlockThresholdMs(long j) {
        this.mStackThread.setBlockInterval(j);
    }

    public void setWithSeriousBlockDetect(boolean z) {
        this.mStackThread.setWithSeriousBlock(z);
    }

    public void setIgnoreInvalidStack(boolean z) {
        this.mStackThread.setIgnoreInvalidStack(z);
    }

    public void setBlockListener(IBlockListener iBlockListener) {
        this.mStackThread.setBlockListener(iBlockListener);
    }
}
