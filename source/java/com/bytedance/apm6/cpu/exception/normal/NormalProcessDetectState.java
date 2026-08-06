package com.bytedance.apm6.cpu.exception.normal;

import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.exception.CpuExceptionManager;
import com.bytedance.apm6.cpu.exception.CpuExceptionStateMachine;
import com.bytedance.apm6.cpu.exception.StateType;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
class NormalProcessDetectState extends BaseProcessDetectState {
    private static final long DETECTED_BACKGROUND_INTERVAL = 600000;
    private static final long DETECTED_INTERVAL = 1000;

    @Override // com.bytedance.apm6.cpu.exception.normal.BaseProcessDetectState
    protected boolean reactOnSkip() {
        return false;
    }

    public NormalProcessDetectState(CpuExceptionStateMachine cpuExceptionStateMachine) {
        super(cpuExceptionStateMachine);
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public StateType provideType() {
        return StateType.PROCESS_DETECT;
    }

    @Override // com.bytedance.apm6.cpu.exception.normal.BaseProcessDetectState
    protected long provideDetectInterval() {
        if (this.config == null) {
            return this.isBackground ? 600000L : 30000L;
        }
        if (this.isBackground) {
            return 600000L;
        }
        return this.config.getProcessDetectInterval() * 1000;
    }

    @Override // com.bytedance.apm6.cpu.exception.normal.BaseProcessDetectState
    protected boolean reactAfterJudge(boolean z) {
        if (z) {
            ApmCpuManager.ICpuExceptionFilter exceptionFilter = CpuExceptionManager.getInstance().getExceptionFilter();
            if (exceptionFilter != null && exceptionFilter.needFilter()) {
                return false;
            }
            this.machine.onProcessDoubleDetect();
        }
        return z;
    }
}
