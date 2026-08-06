package com.bytedance.apm6.cpu.exception;

import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.normal.NormalCpuExceptionPolicy;
import com.bytedance.apm6.foundation.context.ApmContext;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CpuExceptionManager {
    private CpuExceptionConfig cpuConfig;
    private ApmCpuManager.ICpuExceptionListener exceptionListener;
    private ICpuExceptionPolicy exceptionPolicy;
    private ApmCpuManager.ICpuExceptionFilter filter;

    @Deprecated
    private boolean isForceOpen;
    private boolean isOpen;
    private long lastExceptionTimestamp;
    private boolean needFetchStack;

    private CpuExceptionManager() {
        this.exceptionPolicy = new NormalCpuExceptionPolicy();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static final class SingletonHolder {
        private static final CpuExceptionManager instance = new CpuExceptionManager();

        private SingletonHolder() {
        }
    }

    public static CpuExceptionManager getInstance() {
        return SingletonHolder.instance;
    }

    public synchronized void updateConfig(CpuExceptionConfig cpuExceptionConfig) {
        if (cpuExceptionConfig == null) {
            return;
        }
        if (ApmContext.isMainProcess() || cpuExceptionConfig.isCollectAllProcess()) {
            this.cpuConfig = cpuExceptionConfig;
            if (this.isForceOpen) {
                if (!this.isOpen) {
                    this.isOpen = true;
                    this.needFetchStack = cpuExceptionConfig.isCollectThreadStack();
                    this.exceptionPolicy.startDetect(cpuExceptionConfig);
                }
                return;
            }
            if (cpuExceptionConfig.isOpen()) {
                this.isOpen = true;
                this.needFetchStack = cpuExceptionConfig.isCollectThreadStack();
                this.exceptionPolicy.startDetect(cpuExceptionConfig);
            } else {
                this.isOpen = false;
                this.exceptionPolicy.stopDetect();
            }
        }
    }

    @Deprecated
    public synchronized void forceOpen() {
        this.isForceOpen = true;
    }

    public synchronized void forceOpenNoStack() {
        CpuExceptionConfig cpuExceptionConfig;
        if (!this.isOpen && (cpuExceptionConfig = this.cpuConfig) != null) {
            this.isOpen = true;
            this.needFetchStack = false;
            this.exceptionPolicy.startDetect(cpuExceptionConfig);
        }
    }

    public synchronized void stopForceOpenNoStack() {
        if (this.isOpen && !this.needFetchStack) {
            this.isOpen = false;
            this.exceptionPolicy.stopDetect();
        }
    }

    public synchronized boolean needFetchStack() {
        return this.needFetchStack;
    }

    public long getLastExceptionTimestamp() {
        return this.lastExceptionTimestamp;
    }

    public void setLastExceptionTimestamp(long j) {
        this.lastExceptionTimestamp = j;
    }

    public ApmCpuManager.ICpuExceptionListener getExceptionListener() {
        return this.exceptionListener;
    }

    public ApmCpuManager.ICpuExceptionFilter getExceptionFilter() {
        return this.filter;
    }

    public void setExceptionListener(ApmCpuManager.ICpuExceptionListener iCpuExceptionListener) {
        this.exceptionListener = iCpuExceptionListener;
    }

    public void setCpuFilterListener(ApmCpuManager.ICpuExceptionFilter iCpuExceptionFilter) {
        this.filter = iCpuExceptionFilter;
    }
}
