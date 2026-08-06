package com.bytedance.apm6.cpu.exception;

import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class BaseCpuExceptionState implements ICpuExceptionState {
    protected static final boolean IS_DEBUG = false;
    protected CpuExceptionStateMachine machine;

    public BaseCpuExceptionState(CpuExceptionStateMachine cpuExceptionStateMachine) {
        this.machine = cpuExceptionStateMachine;
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onEnterThisState(CpuExceptionConfig cpuExceptionConfig, boolean z) {
        if (ApmContext.isDebugMode()) {
            Logger.m122i(Constants.TAG, "enter : " + provideType());
        }
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onStopDetect() {
        if (ApmContext.isDebugMode()) {
            Logger.m122i(Constants.TAG, "stop detect when state is : " + provideType());
        }
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean z) {
        if (ApmContext.isDebugMode()) {
            Logger.m122i(Constants.TAG, "onLifeCycleChange when state is : " + provideType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cpuExceptionLog(String str) {
        if (ApmContext.isDebugMode()) {
            Logger.m122i(Constants.TAG, "[" + provideType() + "]: " + str);
        }
    }
}
