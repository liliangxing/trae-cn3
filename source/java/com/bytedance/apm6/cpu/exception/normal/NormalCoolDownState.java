package com.bytedance.apm6.cpu.exception.normal;

import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.BaseCpuExceptionState;
import com.bytedance.apm6.cpu.exception.CpuExceptionStateMachine;
import com.bytedance.apm6.cpu.exception.StateType;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
class NormalCoolDownState extends BaseCpuExceptionState {
    private static final long COOL_DOWN_INTERVAL = 120000;
    private static final long COOL_DOWN_INTERVAL_BACKGROUND = 1200000;
    private AsyncTask finishCoolDownTask;
    private volatile boolean isBackground;

    public NormalCoolDownState(final CpuExceptionStateMachine cpuExceptionStateMachine) {
        super(cpuExceptionStateMachine);
        this.isBackground = false;
        this.finishCoolDownTask = new AsyncTask(getInterval(), 0L) { // from class: com.bytedance.apm6.cpu.exception.normal.NormalCoolDownState.1
            @Override // java.lang.Runnable
            public void run() {
                NormalCoolDownState.this.cpuExceptionLog("cool down task run, is back?: " + NormalCoolDownState.this.isBackground);
                cpuExceptionStateMachine.onIdle();
            }
        };
    }

    private long getInterval() {
        return this.isBackground ? 1200000L : 120000L;
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onEnterThisState(CpuExceptionConfig cpuExceptionConfig, boolean z) {
        super.onEnterThisState(cpuExceptionConfig, z);
        AsyncTask asyncTask = this.finishCoolDownTask;
        if (asyncTask != null) {
            asyncTask.refresh(getInterval(), 0L);
        }
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.finishCoolDownTask);
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onStopDetect() {
        super.onStopDetect();
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).removeTask(this.finishCoolDownTask);
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean z) {
        super.onLifeCycleChange(z);
        this.isBackground = z;
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public StateType provideType() {
        return StateType.COOL_DOWN;
    }
}
