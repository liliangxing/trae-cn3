package com.lynx.jsbridge;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.SafeRunnable;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxIntersectionObserver;
import com.lynx.tasm.behavior.LynxIntersectionObserverManager;
import com.lynx.tasm.utils.UIThreadUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxIntersectionObserverModule extends LynxContextModule {
    public static final String NAME = "IntersectionObserverModule";

    public LynxIntersectionObserverModule(LynxContext lynxContext) {
        super(lynxContext);
    }

    @LynxMethod
    void createIntersectionObserver(final int i, final String str, final ReadableMap readableMap) {
        UIThreadUtils.runOnUiThread(new SafeRunnable(this.mLynxContext) { // from class: com.lynx.jsbridge.LynxIntersectionObserverModule.1
            @Override // com.lynx.react.bridge.SafeRunnable
            public void unsafeRun() {
                LynxIntersectionObserverManager intersectionObserverManager = LynxIntersectionObserverModule.this.mLynxContext.getIntersectionObserverManager();
                if (intersectionObserverManager.getObserverById(i) == null) {
                    intersectionObserverManager.addIntersectionObserver(new LynxIntersectionObserver(intersectionObserverManager, i, !str.isEmpty() ? str : "-1", readableMap));
                }
            }
        });
    }

    @LynxMethod
    void relativeTo(final int i, final String str, final ReadableMap readableMap) {
        UIThreadUtils.runOnUiThread(new SafeRunnable(this.mLynxContext) { // from class: com.lynx.jsbridge.LynxIntersectionObserverModule.2
            @Override // com.lynx.react.bridge.SafeRunnable
            public void unsafeRun() {
                LynxIntersectionObserver observerById = LynxIntersectionObserverModule.this.mLynxContext.getIntersectionObserverManager().getObserverById(i);
                if (observerById != null) {
                    observerById.relativeTo(str, readableMap);
                }
            }
        });
    }

    @LynxMethod
    void relativeToViewport(final int i, final ReadableMap readableMap) {
        UIThreadUtils.runOnUiThread(new SafeRunnable(this.mLynxContext) { // from class: com.lynx.jsbridge.LynxIntersectionObserverModule.3
            @Override // com.lynx.react.bridge.SafeRunnable
            public void unsafeRun() {
                LynxIntersectionObserver observerById = LynxIntersectionObserverModule.this.mLynxContext.getIntersectionObserverManager().getObserverById(i);
                if (observerById != null) {
                    observerById.relativeToViewport(readableMap);
                }
            }
        });
    }

    @LynxMethod
    void relativeToScreen(final int i, final ReadableMap readableMap) {
        UIThreadUtils.runOnUiThread(new SafeRunnable(this.mLynxContext) { // from class: com.lynx.jsbridge.LynxIntersectionObserverModule.4
            @Override // com.lynx.react.bridge.SafeRunnable
            public void unsafeRun() {
                LynxIntersectionObserver observerById = LynxIntersectionObserverModule.this.mLynxContext.getIntersectionObserverManager().getObserverById(i);
                if (observerById != null) {
                    observerById.relativeToScreen(readableMap);
                }
            }
        });
    }

    @LynxMethod
    void observe(final int i, final String str, final int i2) {
        UIThreadUtils.runOnUiThread(new SafeRunnable(this.mLynxContext) { // from class: com.lynx.jsbridge.LynxIntersectionObserverModule.5
            @Override // com.lynx.react.bridge.SafeRunnable
            public void unsafeRun() {
                LynxIntersectionObserver observerById = LynxIntersectionObserverModule.this.mLynxContext.getIntersectionObserverManager().getObserverById(i);
                if (observerById != null) {
                    observerById.observe(str, i2);
                }
            }
        });
    }

    @LynxMethod
    void disconnect(final int i) {
        UIThreadUtils.runOnUiThread(new SafeRunnable(this.mLynxContext) { // from class: com.lynx.jsbridge.LynxIntersectionObserverModule.6
            @Override // com.lynx.react.bridge.SafeRunnable
            public void unsafeRun() {
                LynxIntersectionObserver observerById = LynxIntersectionObserverModule.this.mLynxContext.getIntersectionObserverManager().getObserverById(i);
                if (observerById != null) {
                    observerById.disconnect();
                }
            }
        });
    }
}
