package com.lynx.tasm.behavior.p000ui.krypton;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.BehaviorRegistry;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxKryptonHelper {
    private static final String TAG = "LynxKryptonHelper";
    private final BehaviorRegistry mBehaviorRegistry;
    private final LinkedHashMap<Class<?>, Object> mCachedServiceMap = new LinkedHashMap<>();
    private CanvasRuntimeMediator mRuntimeMediator;
    private String mTemporaryDirectory;

    public LynxKryptonHelper(BehaviorRegistry behaviorRegistry) {
        this.mBehaviorRegistry = behaviorRegistry;
    }

    public void registerService(Class<?> cls, Object obj) {
        if (obj == null) {
            LLog.w(TAG, "do not support unregister service or register null service");
            return;
        }
        this.mCachedServiceMap.put(cls, obj);
        CanvasRuntimeMediator canvasRuntimeMediator = this.mRuntimeMediator;
        if (canvasRuntimeMediator != null) {
            canvasRuntimeMediator.registerService(cls, obj);
        }
    }

    public void setTemporaryDirectory(String str) {
        this.mTemporaryDirectory = str;
        CanvasRuntimeMediator canvasRuntimeMediator = this.mRuntimeMediator;
        if (canvasRuntimeMediator != null) {
            canvasRuntimeMediator.setTemporaryDirectory(str);
        }
    }

    public void setRenderFrameCallback(RenderFrameCallback renderFrameCallback) {
        CanvasRuntimeMediator canvasRuntimeMediator = this.mRuntimeMediator;
        if (canvasRuntimeMediator != null) {
            ICanvasManager canvasManager = canvasRuntimeMediator.getCanvasManager();
            if (canvasManager != null) {
                canvasManager.setRenderFrameCallback(renderFrameCallback);
            } else {
                LLog.w(TAG, "do not support set render frame callback when canvas manager is null(only be lazy init mode)");
            }
        }
    }

    public void deInit() {
        CanvasRuntimeMediator canvasRuntimeMediator = this.mRuntimeMediator;
        if (canvasRuntimeMediator != null) {
            canvasRuntimeMediator.deInit();
        }
    }

    public ICanvasManager getCanvasManager() {
        CanvasRuntimeMediator canvasRuntimeMediator = this.mRuntimeMediator;
        if (canvasRuntimeMediator != null) {
            return canvasRuntimeMediator.getCanvasManager();
        }
        return null;
    }

    public void registerCanvasRuntimeMediator(CanvasRuntimeMediator canvasRuntimeMediator) {
        LLog.i(TAG, "[Krypton] Register new CanvasRuntimeMediator." + canvasRuntimeMediator);
        this.mRuntimeMediator = canvasRuntimeMediator;
        String str = this.mTemporaryDirectory;
        if (str != null) {
            canvasRuntimeMediator.setTemporaryDirectory(str);
        }
        for (Map.Entry<Class<?>, Object> entry : this.mCachedServiceMap.entrySet()) {
            this.mRuntimeMediator.registerService(entry.getKey(), entry.getValue());
        }
    }

    public void setupCanvasIfEnableCanvas() {
        LLog.i(TAG, "[Krypton] Setup canvas environment when specify enable_canvas in schema.");
        CanvasRuntimeMediator canvasRuntimeMediator = this.mRuntimeMediator;
        if (canvasRuntimeMediator != null) {
            canvasRuntimeMediator.setupCanvasFromUI();
            this.mRuntimeMediator.registerCanvasBehavior(this.mBehaviorRegistry);
        }
    }

    public void setupCanvasIfCanvasViewCreated() {
        LLog.i(TAG, "[Krypton] Setup canvas environment if introduce canvas tag in app.");
        CanvasRuntimeMediator canvasRuntimeMediator = this.mRuntimeMediator;
        if (canvasRuntimeMediator != null) {
            canvasRuntimeMediator.setupCanvasFromUI();
        }
    }
}
