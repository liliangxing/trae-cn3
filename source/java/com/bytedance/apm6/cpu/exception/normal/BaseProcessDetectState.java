package com.bytedance.apm6.cpu.exception.normal;

import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.BaseCpuExceptionState;
import com.bytedance.apm6.cpu.exception.CpuExceptionJudgeHelper;
import com.bytedance.apm6.cpu.exception.CpuExceptionStateMachine;
import com.bytedance.apm6.cpu.exception.CpuLoadCollector;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.watson.assist.api.IAssistStat;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class BaseProcessDetectState extends BaseCpuExceptionState {
    public CpuExceptionConfig config;
    private AsyncTask detectTask;
    protected boolean isBackground;

    protected abstract long provideDetectInterval();

    protected abstract boolean reactAfterJudge(boolean z);

    protected abstract boolean reactOnSkip();

    public BaseProcessDetectState(CpuExceptionStateMachine cpuExceptionStateMachine) {
        super(cpuExceptionStateMachine);
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onEnterThisState(CpuExceptionConfig cpuExceptionConfig, boolean z) {
        super.onEnterThisState(cpuExceptionConfig, z);
        this.config = cpuExceptionConfig;
        this.isBackground = z;
        Logger.m122i(Constants.TAG, "enter : " + provideType() + " provideDetectInterval : " + provideDetectInterval() + " isBack : " + z);
        AsyncTask asyncTask = this.detectTask;
        if (asyncTask == null) {
            this.detectTask = new AsyncTask(provideDetectInterval(), provideDetectInterval()) { // from class: com.bytedance.apm6.cpu.exception.normal.BaseProcessDetectState.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseProcessDetectState.this.judgeCpuLoad();
                }
            };
        } else {
            asyncTask.refresh(provideDetectInterval(), provideDetectInterval());
        }
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(this.detectTask);
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onStopDetect() {
        super.onStopDetect();
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).removeTask(this.detectTask);
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean z) {
        super.onLifeCycleChange(z);
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).removeTask(this.detectTask);
        this.machine.onIdle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void judgeCpuLoad() {
        boolean judge;
        if (CpuExceptionJudgeHelper.isNeedSkipJudge()) {
            if (reactOnSkip()) {
                AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).removeTask(this.detectTask);
                return;
            }
            return;
        }
        double collectSpeed = CpuLoadCollector.collectSpeed();
        IAssistStat assistStat = this.machine.getAssistStat();
        if (assistStat != null) {
            judge = assistStat.isCpuAbnormalProcess((float) collectSpeed);
            if (judge) {
                judge = CpuExceptionJudgeHelper.judge(this.config, collectSpeed, this.isBackground);
            }
        } else {
            judge = CpuExceptionJudgeHelper.judge(this.config, collectSpeed, this.isBackground);
        }
        cpuExceptionLog("run judge process cpu usage task, is over max threshold?: " + judge + " speed: " + collectSpeed + ", back max speed: " + this.config.getMaxProcessBackCpuSpeed() + ", fore max speed: " + this.config.getMaxProcessForeCpuSpeed());
        if (reactAfterJudge(judge)) {
            AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).removeTask(this.detectTask);
        }
    }
}
