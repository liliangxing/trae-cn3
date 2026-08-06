package com.bytedance.ies.bullet.lynx.init;

import android.app.Application;
import bolts.Task;
import com.bytedance.android.monitorV2.lynx.MonitorSDKEventReporterObserver;
import com.bytedance.ies.bullet.lynx.model.LynxModuleWrapper;
import com.bytedance.ies.bullet.lynx.resource.DefaultTemplateProvider;
import com.bytedance.ies.bullet.lynx.resource.GlobalTemplateProvider;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.kit.nglynx.resource.DefaultLynxRequestProvider;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.bytedance.vmsdk.VmSdk;
import com.bytedance.vmsdk.service.IVmSdkHostService;
import com.bytedance.vmsdk.service.VmSdkServiceManager;
import com.lynx.animax.util.LynxAnimaX;
import com.lynx.tasm.ClassWarmer;
import com.lynx.tasm.IDynamicHandler;
import com.lynx.tasm.INativeLibraryLoader;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.Behavior;
import com.lynx.tasm.behavior.BehaviorBundle;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.provider.AbsTemplateProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LynxKit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0003J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/init/LynxKitEnv;", "", "()V", "TAG", "", "isVmSdkReady", "", EventConstants.PARAM_SOURCE_INIT, "", "lynxConfig", "Lcom/bytedance/ies/bullet/lynx/init/LynxConfig;", "token", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "initAnimaX", "initVmSdk", "loadLibrary", "pluginPackageName", "soName", "loadV8BridgeInHost", "tryInitVmSdk", "fromInit", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxKitEnv {
    public static final LynxKitEnv INSTANCE = new LynxKitEnv();
    private static final String TAG = "LynxKitEnv";
    private static boolean isVmSdkReady;

    private LynxKitEnv() {
    }

    public final void init(final LynxConfig lynxConfig, IServiceToken token) {
        DefaultTemplateProvider defaultTemplateProvider;
        Intrinsics.checkNotNullParameter(lynxConfig, "lynxConfig");
        Intrinsics.checkNotNullParameter(token, "token");
        BulletLogger.INSTANCE.printLog("LynxKitEnv start init", LogLevel.I, "XLynxKit");
        ClassWarmer.warmClass();
        LynxKitEnv$init$_libraryLoader$1 libraryLoader = lynxConfig.libraryLoader() == null ? new INativeLibraryLoader() { // from class: com.bytedance.ies.bullet.lynx.init.LynxKitEnv$init$_libraryLoader$1
            public final void loadLibrary(String str) {
                try {
                    System.loadLibrary(str);
                } catch (Throwable th) {
                    BulletLogger.INSTANCE.printReject(th, "Lynx init failed, exception message = " + th.getMessage(), "XLynxKit");
                }
            }
        } : lynxConfig.libraryLoader();
        ILynxImageConfig imageInitConfig = lynxConfig.imageInitConfig();
        if (imageInitConfig != null) {
            LynxEnv.inst().setBackgroundImageLoader(imageInitConfig.getBackgroundImageLoader());
        }
        BulletLogger.INSTANCE.printLog("LynxKitEnv behaviors size == " + lynxConfig.globalBehaviors().size(), LogLevel.I, "XLynxKit");
        BehaviorBundle behaviorBundle = new BehaviorBundle() { // from class: com.bytedance.ies.bullet.lynx.init.LynxKitEnv$init$behaviorBundle$1
            public final List<Behavior> create() {
                ArrayList arrayList = new ArrayList();
                LynxConfig lynxConfig2 = LynxConfig.this;
                List<Behavior> globalBehaviors = lynxConfig2.globalBehaviors();
                BulletLogger.INSTANCE.printLog("LynxKitEnv globalBehaviors size == " + globalBehaviors.size(), LogLevel.I, "XLynxKit");
                arrayList.addAll(globalBehaviors);
                ILynxImageConfig imageInitConfig2 = lynxConfig2.imageInitConfig();
                if (imageInitConfig2 != null) {
                    BulletLogger.INSTANCE.printLog("LynxKitEnv imageBehaviors size == " + imageInitConfig2.getImageBehaviors().size(), LogLevel.I, "XLynxKit");
                    arrayList.addAll(imageInitConfig2.getImageBehaviors());
                }
                return arrayList;
            }
        };
        LynxEnv.inst().setResProvider(new DefaultLynxRequestProvider(token));
        LynxEnv.inst().setCheckPropsSetter(lynxConfig.isCheckPropsSetter());
        if (IConditionCallKt.enableGlobalTemplateProvider()) {
            defaultTemplateProvider = new GlobalTemplateProvider();
        } else {
            defaultTemplateProvider = new DefaultTemplateProvider(token);
        }
        LynxEnv inst = LynxEnv.inst();
        Application context = LynxKitBase.INSTANCE.getContext();
        AbsTemplateProvider templateProvider = lynxConfig.templateProvider();
        inst.init(context, libraryLoader, templateProvider == null ? defaultTemplateProvider : templateProvider, behaviorBundle, (IDynamicHandler) null);
        if (LynxEnv.inst().isNativeLibraryLoaded()) {
            LLog.initALog(LynxKitALogDelegate.INSTANCE.getALOGREF());
            LLog.addLoggingDelegate(new LynxKitALogDelegate(token));
            if (!IConditionCallKt.separateVMSdkLoad()) {
                tryInitVmSdk(true);
            }
            ILynxCanvasConfig canvasInitConfig = lynxConfig.canvasInitConfig();
            if (canvasInitConfig != null) {
                canvasInitConfig.init(LynxKitBase.INSTANCE.getContext(), libraryLoader);
            }
        }
        Iterator<T> it = lynxConfig.globalModules().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            LynxEnv.inst().registerModule((String) entry.getKey(), ((LynxModuleWrapper) entry.getValue()).getClz(), ((LynxModuleWrapper) entry.getValue()).getModuleParams());
        }
        Function1<LynxEnv, Unit> additionLynxInit = lynxConfig.additionLynxInit();
        LynxEnv inst2 = LynxEnv.inst();
        Intrinsics.checkNotNullExpressionValue(inst2, "inst()");
        additionLynxInit.invoke(inst2);
        LynxEventReporter.addObserver(new MonitorSDKEventReporterObserver());
        if (!LynxKitBase.INSTANCE.getDebug()) {
            LynxEnv.inst().enableRedBox(false);
            LynxEnv.inst().enableLynxDebug(false);
        } else {
            List<LynxDevtoolProcessor> devtoolProcessors = lynxConfig.devtoolProcessors();
            if (!(devtoolProcessors.size() > 0)) {
                devtoolProcessors = null;
            }
            if (devtoolProcessors != null) {
                LynxDevtoolWrapper.INSTANCE.registerDevtoolListener$anniex_release();
                Iterator<T> it2 = devtoolProcessors.iterator();
                while (it2.hasNext()) {
                    LynxDevtoolWrapper.INSTANCE.addDevtoolProcessor((LynxDevtoolProcessor) it2.next());
                }
            }
        }
        if (IConditionCallKt.enableLynxAnimax()) {
            initAnimaX();
        }
    }

    private final void initAnimaX() {
        Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.init.LynxKitEnv$initAnimaX$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                LynxAnimaX.inst().init();
            }
        }, Task.BACKGROUND_EXECUTOR);
    }

    public final boolean isVmSdkReady() {
        return isVmSdkReady;
    }

    public final void tryInitVmSdk(boolean fromInit) {
        synchronized (LynxKitEnv.class) {
            if (!isVmSdkReady) {
                isVmSdkReady = INSTANCE.initVmSdk();
            }
            Unit unit = Unit.INSTANCE;
        }
        BulletLogger.INSTANCE.printLog("LynxKitEnv tryInitVmSdk: fromInit=" + fromInit + ", isVmSdkReady=" + isVmSdkReady, LogLevel.I, "XLynxKit");
    }

    private final boolean initVmSdk() {
        String packageName = LynxKitBase.INSTANCE.getContext().getApplicationContext().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
        if (StringsKt.startsWith$default(packageName, "com.ss.android.ugc.aweme", false, 2, (Object) null)) {
            VmSdkServiceManager.getInstance().registerService(IVmSdkHostService.class, new HostVmSdkServiceImpl(true));
        }
        String v8PluginName = VmSdk.getV8PluginName();
        String vmSdkPluginName = VmSdk.getVmSdkPluginName();
        Intrinsics.checkNotNullExpressionValue(v8PluginName, "v8PluginName");
        boolean loadLibrary = loadLibrary(v8PluginName, "v8_libfull.cr");
        Intrinsics.checkNotNullExpressionValue(vmSdkPluginName, "vmSdkPluginName");
        boolean loadLibrary2 = loadLibrary(vmSdkPluginName, "napi_v8");
        boolean loadV8BridgeInHost = loadV8BridgeInHost();
        if (!loadV8BridgeInHost) {
            loadV8BridgeInHost = loadLibrary(vmSdkPluginName, "lynx_v8_bridge");
        }
        return loadLibrary && loadLibrary2 && loadV8BridgeInHost;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:3:0x0008, B:5:0x0012, B:10:0x001e, B:18:0x003f), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #0 {all -> 0x0044, blocks: (B:3:0x0008, B:5:0x0012, B:10:0x001e, B:18:0x003f), top: B:2:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean loadLibrary(String pluginPackageName, String soName) {
        String pluginLibAbsPath;
        String str;
        boolean z;
        boolean z2 = false;
        try {
            pluginLibAbsPath = VmSdk.getPluginLibAbsPath(pluginPackageName, soName);
            str = pluginLibAbsPath;
        } catch (Throwable th) {
            LLog.e(TAG, "vmsdk loadLibrary: lib" + soName + ".so, PluginName: " + pluginPackageName + " error:" + th.getMessage());
        }
        if (str != null && str.length() != 0) {
            z = false;
            if (!z) {
                LLog.e(TAG, pluginPackageName + " plugin's lib" + soName + ".so not found");
            } else {
                System.load(pluginLibAbsPath);
                z2 = true;
            }
            LLog.i(TAG, "vmsdk loadLibrary: lib" + soName + ".so, PluginName: " + pluginPackageName + (!z2 ? " Success" : " Failed"));
            return z2;
        }
        z = true;
        if (!z) {
        }
        LLog.i(TAG, "vmsdk loadLibrary: lib" + soName + ".so, PluginName: " + pluginPackageName + (!z2 ? " Success" : " Failed"));
        return z2;
    }

    private final boolean loadV8BridgeInHost() {
        boolean z;
        try {
            System.loadLibrary("lynx_v8_bridge");
            z = true;
        } catch (Throwable th) {
            LLog.e(TAG, "vmsdk load liblynx_v8_bridge.so in host error:" + th.getMessage());
            z = false;
        }
        LLog.i(TAG, "vmsdk load liblynx_v8_bridge.so".concat(z ? " Success" : " Failed"));
        return z;
    }
}
