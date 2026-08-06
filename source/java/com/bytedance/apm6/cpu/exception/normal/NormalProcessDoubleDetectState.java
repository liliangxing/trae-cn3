package com.bytedance.apm6.cpu.exception.normal;

import com.bytedance.apm6.cpu.exception.CpuExceptionStateMachine;
import com.bytedance.apm6.cpu.exception.StateType;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
class NormalProcessDoubleDetectState extends BaseProcessDetectState {
    private static final long DETECTED_BACKGROUND_INTERVAL = 300000;
    private static final long DETECTED_INTERVAL = 5000;
    private static final int MAX_OVER_TIMES = 2;
    private int overTimes;

    public NormalProcessDoubleDetectState(CpuExceptionStateMachine cpuExceptionStateMachine) {
        super(cpuExceptionStateMachine);
        this.overTimes = 0;
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public StateType provideType() {
        return StateType.PROCESS_DOUBLE_DETECT;
    }

    @Override // com.bytedance.apm6.cpu.exception.normal.BaseProcessDetectState
    protected long provideDetectInterval() {
        return this.isBackground ? 300000L : 5000L;
    }

    @Override // com.bytedance.apm6.cpu.exception.normal.BaseProcessDetectState, com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean z) {
        if (z) {
            this.overTimes = 0;
        }
        super.onLifeCycleChange(z);
    }

    @Override // com.bytedance.apm6.cpu.exception.normal.BaseProcessDetectState
    protected boolean reactAfterJudge(boolean z) {
        if (z) {
            this.overTimes++;
            cpuExceptionLog("over time: " + this.overTimes + " max over time: 2");
            if (this.overTimes < 2) {
                return false;
            }
            this.overTimes = 0;
            this.machine.onThreadDetect();
            return true;
        }
        this.overTimes = 0;
        this.machine.onProcessDetect();
        return true;
    }

    @Override // com.bytedance.apm6.cpu.exception.normal.BaseProcessDetectState
    protected boolean reactOnSkip() {
        this.overTimes = 0;
        this.machine.onProcessDetect();
        return true;
    }
}
