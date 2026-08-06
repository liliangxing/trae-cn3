package com.bytedance.lynx.service.extension;

import com.lynx.jsbridge.LynxExtensionModule;
import com.lynx.jsbridge.WebAssemblyBridge;
import com.lynx.tasm.ClassWarmer;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.BehaviorRegistry;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.service.ILynxExtensionService;
import kotlin.Metadata;

/* compiled from: LynxExtensionService.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/lynx/service/extension/LynxExtensionService;", "Lcom/lynx/tasm/service/ILynxExtensionService;", "()V", "LYNX_KRYPTON_MODULE", "", "TAG", "destroyLynxKrypton", "", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "onLynxEnvSetup", "onLynxViewDestroy", "onLynxViewSetup", "group", "Lcom/lynx/tasm/LynxGroup;", "behaviorRegistry", "Lcom/lynx/tasm/behavior/BehaviorRegistry;", "setUpLynxKrypton", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxExtensionService implements ILynxExtensionService {
    public static final LynxExtensionService INSTANCE = new LynxExtensionService();
    private static final String LYNX_KRYPTON_MODULE = "LynxKryptonModule";
    private static final String TAG = "LynxExtensionService";

    private LynxExtensionService() {
    }

    public void onLynxEnvSetup() {
        ClassWarmer.warmClassForBehaviors(LynxEnv.inst().getBehaviors());
        WebAssemblyBridge.initWasm();
    }

    public void onLynxViewSetup(LynxContext context, LynxGroup group, BehaviorRegistry behaviorRegistry) {
        setUpLynxKrypton(context, group, behaviorRegistry);
    }

    public void onLynxViewDestroy(LynxContext context) {
        destroyLynxKrypton(context);
    }

    private final void setUpLynxKrypton(LynxContext context, LynxGroup group, BehaviorRegistry behaviorRegistry) {
        if (context == null || context.isEmbeddedModeOn()) {
            LLog.e(TAG, "LynxContext is null or embedded mode is ON");
            return;
        }
        try {
            Object newInstance = Class.forName("com.lynx.tasm.behavior.ui.krypton.LynxKryptonModule").getConstructor(LynxContext.class, LynxGroup.class, BehaviorRegistry.class).newInstance(context, group, behaviorRegistry);
            if (newInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.lynx.jsbridge.LynxExtensionModule");
            }
            context.setExtensionModuleForKey((LynxExtensionModule) newInstance, LYNX_KRYPTON_MODULE);
        } catch (Exception e) {
            LLog.e(TAG, "Failed init LynxKryptonModule with exception: " + e);
        }
    }

    private final void destroyLynxKrypton(LynxContext context) {
        if (context == null) {
            LLog.e(TAG, "LynxContext is null");
            return;
        }
        LynxExtensionModule extensionModuleByKey = context.getExtensionModuleByKey(LYNX_KRYPTON_MODULE);
        if (extensionModuleByKey == null) {
            return;
        }
        extensionModuleByKey.destroy();
    }
}
