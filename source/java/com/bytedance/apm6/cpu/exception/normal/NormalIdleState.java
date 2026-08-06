package com.bytedance.apm6.cpu.exception.normal;

import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.BaseCpuExceptionState;
import com.bytedance.apm6.cpu.exception.CpuExceptionStateMachine;
import com.bytedance.apm6.cpu.exception.StateType;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NormalIdleState extends BaseCpuExceptionState {
    public NormalIdleState(CpuExceptionStateMachine cpuExceptionStateMachine) {
        super(cpuExceptionStateMachine);
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onEnterThisState(CpuExceptionConfig cpuExceptionConfig, boolean z) {
        super.onEnterThisState(cpuExceptionConfig, z);
        this.machine.onProcessDetect();
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onStopDetect() {
        super.onStopDetect();
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean z) {
        super.onLifeCycleChange(z);
        cpuExceptionLog("life cycle change when state is idle, lifecycle change to back?: " + z);
        this.machine.onProcessDetect();
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public StateType provideType() {
        return StateType.IDLE;
    }
}
