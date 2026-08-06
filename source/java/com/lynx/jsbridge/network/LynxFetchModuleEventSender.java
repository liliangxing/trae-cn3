package com.lynx.jsbridge.network;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxBackgroundRuntime;
import com.lynx.tasm.behavior.LynxContext;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxFetchModuleEventSender {
    private WeakReference<LynxContext> weakContext = new WeakReference<>(null);
    private WeakReference<LynxBackgroundRuntime> weakRuntime = new WeakReference<>(null);

    public void setWeakContext(LynxContext lynxContext) {
        this.weakContext = new WeakReference<>(lynxContext);
    }

    public void setWeakRuntime(LynxBackgroundRuntime lynxBackgroundRuntime) {
        this.weakRuntime = new WeakReference<>(lynxBackgroundRuntime);
    }

    public void sendGlobalEvent(String str, JavaOnlyArray javaOnlyArray) {
        LynxContext lynxContext = this.weakContext.get();
        if (lynxContext != null) {
            lynxContext.sendGlobalEvent(str, javaOnlyArray);
            return;
        }
        LynxBackgroundRuntime lynxBackgroundRuntime = this.weakRuntime.get();
        if (lynxBackgroundRuntime != null) {
            lynxBackgroundRuntime.sendGlobalEvent(str, javaOnlyArray);
        }
    }
}
