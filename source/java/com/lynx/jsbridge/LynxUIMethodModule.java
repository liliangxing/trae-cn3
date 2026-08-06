package com.lynx.jsbridge;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.SafeRunnable;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.UIThreadUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxUIMethodModule extends LynxContextModule {
    public static final String NAME = "LynxUIMethodModule";

    public LynxUIMethodModule(LynxContext lynxContext) {
        super(lynxContext);
    }

    @LynxMethod
    void invokeUIMethod(final String str, final ReadableArray readableArray, final String str2, final ReadableMap readableMap, final Callback callback) {
        UIThreadUtils.runOnUiThread(new SafeRunnable(this.mLynxContext) { // from class: com.lynx.jsbridge.LynxUIMethodModule.1
            @Override // com.lynx.react.bridge.SafeRunnable
            public void unsafeRun() {
                LynxUIMethodModule.this.mLynxContext.invokeUIMethod(!str.isEmpty() ? str : "-1", readableArray, str2, readableMap, LynxUIMethodModule.wrapCallback(callback));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Callback wrapCallback(final Callback callback) {
        return new Callback() { // from class: com.lynx.jsbridge.LynxUIMethodModule.2
            @Override // com.lynx.react.bridge.Callback
            public void invoke(Object... objArr) {
                if (Callback.this == null) {
                    return;
                }
                JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
                javaOnlyMap.putInt("code", ((Integer) objArr[0]).intValue());
                if (objArr.length > 1) {
                    javaOnlyMap.put("data", objArr[1]);
                }
                Callback.this.invoke(javaOnlyMap);
            }
        };
    }
}
