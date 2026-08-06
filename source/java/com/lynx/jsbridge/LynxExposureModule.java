package com.lynx.jsbridge;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.SafeRunnable;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.UIExposure;
import com.lynx.tasm.utils.UIThreadUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxExposureModule extends LynxContextModule {
    public static final String NAME = "LynxExposureModule";

    public LynxExposureModule(LynxContext lynxContext) {
        super(lynxContext);
    }

    @LynxMethod
    void stopExposure(final ReadableMap readableMap) {
        UIThreadUtils.runOnUiThread(new SafeRunnable(this.mLynxContext) { // from class: com.lynx.jsbridge.LynxExposureModule.1
            @Override // com.lynx.react.bridge.SafeRunnable
            public void unsafeRun() {
                UIExposure exposure = LynxExposureModule.this.mLynxContext.getExposure();
                if (exposure != null) {
                    exposure.stopExposure(readableMap.asHashMap());
                }
            }
        });
    }

    @LynxMethod
    void resumeExposure() {
        UIThreadUtils.runOnUiThread(new SafeRunnable(this.mLynxContext) { // from class: com.lynx.jsbridge.LynxExposureModule.2
            @Override // com.lynx.react.bridge.SafeRunnable
            public void unsafeRun() {
                UIExposure exposure = LynxExposureModule.this.mLynxContext.getExposure();
                if (exposure != null) {
                    exposure.resumeExposure();
                }
            }
        });
    }

    @LynxMethod
    void setObserverFrameRate(final ReadableMap readableMap) {
        UIThreadUtils.runOnUiThread(new SafeRunnable(this.mLynxContext) { // from class: com.lynx.jsbridge.LynxExposureModule.3
            @Override // com.lynx.react.bridge.SafeRunnable
            public void unsafeRun() {
                UIExposure exposure = LynxExposureModule.this.mLynxContext.getExposure();
                if (exposure != null) {
                    exposure.setObserverFrameRate(readableMap);
                }
            }
        });
    }
}
