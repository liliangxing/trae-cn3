package com.lynx.tasm;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxCustomEvent;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class TemplateAssembler {
    private static final String TAG = "TemplateAssembler";
    private WeakReference<LynxContext> mLynxContext;

    public void sendCustomEvent(LynxCustomEvent lynxCustomEvent) {
        if (this.mLynxContext.get() == null || this.mLynxContext.get().getEventEmitter() == null) {
            LLog.m2577e(TAG, "sendCustomEvent event: " + lynxCustomEvent.getName() + " failed since mLynxContext or getEventEmitter() is null.");
        } else {
            this.mLynxContext.get().getEventEmitter().sendCustomEvent(lynxCustomEvent);
        }
    }

    public void setLynxContext(LynxContext lynxContext) {
        this.mLynxContext = new WeakReference<>(lynxContext);
    }
}
