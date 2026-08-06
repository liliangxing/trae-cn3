package com.bytedance.apm6.cpu.exception;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.watson.assist.api.AssistStatFactory;
import com.bytedance.watson.assist.api.IAssistStat;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CpuExceptionStateMachine {
    private IAssistStat assistStat;
    private CpuExceptionConfig config;
    private ICpuExceptionState coolDownState;
    private ICpuExceptionState currentState;
    private ICpuExceptionState idleState;
    private boolean isBackground;
    private ActivityLifecycleService lifecycleService;
    private ICpuExceptionState processDetectState;
    private ICpuExceptionState processDoubleDetectState;
    private ICpuExceptionState threadDetectState;
    private boolean isStart = false;
    private boolean isInit = false;

    public CpuExceptionStateMachine(ActivityLifecycleService activityLifecycleService) {
        this.lifecycleService = activityLifecycleService;
    }

    public void init(ICpuExceptionState iCpuExceptionState, ICpuExceptionState iCpuExceptionState2, ICpuExceptionState iCpuExceptionState3, ICpuExceptionState iCpuExceptionState4, ICpuExceptionState iCpuExceptionState5) {
        if (this.isInit) {
            return;
        }
        this.processDetectState = iCpuExceptionState;
        this.processDoubleDetectState = iCpuExceptionState2;
        this.threadDetectState = iCpuExceptionState3;
        this.coolDownState = iCpuExceptionState4;
        this.idleState = iCpuExceptionState5;
        try {
            this.assistStat = AssistStatFactory.create(ApmContext.getContext());
        } catch (Throwable unused) {
        }
        this.isInit = true;
    }

    public synchronized void start(CpuExceptionConfig cpuExceptionConfig) {
        if (!this.isStart && this.isInit) {
            this.config = cpuExceptionConfig;
            boolean z = true;
            this.isStart = true;
            CpuExceptionJudgeHelper.initScene(ApmCpuManager.getInstance().getCpuSceneString());
            if (this.lifecycleService.isForeground()) {
                z = false;
            }
            this.isBackground = z;
            onProcessDetect();
        }
    }

    public synchronized void stop() {
        ICpuExceptionState iCpuExceptionState = this.currentState;
        if (iCpuExceptionState != null && this.isStart) {
            iCpuExceptionState.onStopDetect();
            this.isStart = false;
        }
    }

    public synchronized void onIdle() {
        changeState(this.idleState);
    }

    public synchronized void onProcessDetect() {
        changeState(this.processDetectState);
    }

    public synchronized void onProcessDoubleDetect() {
        changeState(this.processDoubleDetectState);
    }

    public synchronized void onThreadDetect() {
        changeState(this.threadDetectState);
    }

    public synchronized void onCoolDown() {
        changeState(this.coolDownState);
    }

    public synchronized void onLifeCycleChange(boolean z) {
        ICpuExceptionState iCpuExceptionState = this.currentState;
        if (iCpuExceptionState != null && this.isStart) {
            if (this.isBackground == z) {
                return;
            }
            this.isBackground = z;
            iCpuExceptionState.onLifeCycleChange(z);
        }
    }

    public IAssistStat getAssistStat() {
        return this.assistStat;
    }

    private void changeState(ICpuExceptionState iCpuExceptionState) {
        if (this.isStart && this.isInit) {
            this.currentState = iCpuExceptionState;
            CpuExceptionConfig cpuExceptionConfig = this.config;
            ActivityLifecycleService activityLifecycleService = this.lifecycleService;
            iCpuExceptionState.onEnterThisState(cpuExceptionConfig, activityLifecycleService == null || !activityLifecycleService.isForeground());
            logState();
        }
    }

    private void logState() {
        if (com.bytedance.apm6.foundation.context.ApmContext.isDebugMode()) {
            Logger.m122i(Constants.TAG, "change cpu exception detect state: " + this.currentState);
        }
    }
}
