package com.bytedance.apm6.cpu.exception.normal;

import android.app.Activity;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.CpuExceptionStateMachine;
import com.bytedance.apm6.cpu.exception.ICpuExceptionPolicy;
import com.bytedance.apm6.cpu.exception.ICpuExceptionState;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.lifecycle.DummyLifecycleListener;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NormalCpuExceptionPolicy extends DummyLifecycleListener implements ICpuExceptionPolicy {
    private ActivityLifecycleService lifecycleService = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
    private volatile CpuExceptionStateMachine stateMachine = new CpuExceptionStateMachine(this.lifecycleService);
    private ICpuExceptionState processDetectState = new NormalProcessDetectState(this.stateMachine);
    private ICpuExceptionState processDoubleDetectState = new NormalProcessDoubleDetectState(this.stateMachine);
    private ICpuExceptionState threadDetectState = new NormalThreadDetectState(this.stateMachine);
    private ICpuExceptionState coolDownState = new NormalCoolDownState(this.stateMachine);
    private ICpuExceptionState idleState = new NormalIdleState(this.stateMachine);

    public NormalCpuExceptionPolicy() {
        this.stateMachine.init(this.processDetectState, this.processDoubleDetectState, this.threadDetectState, this.coolDownState, this.idleState);
        this.lifecycleService.register(this);
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionPolicy
    public void startDetect(CpuExceptionConfig cpuExceptionConfig) {
        this.stateMachine.start(cpuExceptionConfig);
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionPolicy
    public void stopDetect() {
        this.stateMachine.stop();
    }

    @Override // com.bytedance.apm6.service.lifecycle.DummyLifecycleListener, com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
    public void onFront(Activity activity) {
        this.stateMachine.onLifeCycleChange(false);
    }

    @Override // com.bytedance.apm6.service.lifecycle.DummyLifecycleListener, com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
    public void onBackground(Activity activity) {
        this.stateMachine.onLifeCycleChange(true);
    }
}
