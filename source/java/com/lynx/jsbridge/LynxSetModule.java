package com.lynx.jsbridge;

import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.service.ILynxLogService;
import com.lynx.tasm.service.LynxServiceCenter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxSetModule extends LynxContextModule {
    public static final String NAME = "LynxSetModule";

    public LynxSetModule(LynxContext lynxContext) {
        super(lynxContext);
    }

    @LynxMethod
    public void switchKeyBoardDetect(boolean z) {
        if (z) {
            this.mLynxContext.getLynxView().getKeyboardEvent().start();
        }
    }

    @LynxMethod
    public void switchLogToSystem(boolean z) {
        ILynxLogService service = LynxServiceCenter.inst().getService(ILynxLogService.class);
        if (service != null) {
            service.switchLogToSystem(z);
        }
    }

    @LynxMethod
    public boolean getLogToSystemStatus() {
        ILynxLogService service = LynxServiceCenter.inst().getService(ILynxLogService.class);
        if (service != null) {
            return service.getLogToSystemStatus();
        }
        return false;
    }

    @LynxMethod
    public void switchEnableLayoutOnly(Boolean bool) {
        LynxEnv.inst().enableLayoutOnly(bool.booleanValue());
    }

    @LynxMethod
    public boolean getEnableLayoutOnly() {
        return LynxEnv.inst().isLayoutOnlyEnabled();
    }

    @LynxMethod
    public void switchIsCreateViewAsync(Boolean bool) {
        LynxEnv.inst().setCreateViewAsync(bool.booleanValue());
    }

    @LynxMethod
    public boolean getIsCreateViewAsync() {
        return LynxEnv.inst().getCreateViewAsync();
    }

    @LynxMethod
    public void switchEnableVsyncAlignedFlush(Boolean bool) {
        LynxEnv.inst().setVsyncAlignedFlushGlobalSwitch(bool.booleanValue());
    }

    @LynxMethod
    public boolean getEnableVsyncAlignedFlush() {
        return LynxEnv.inst().getVsyncAlignedFlushGlobalSwitch();
    }
}
