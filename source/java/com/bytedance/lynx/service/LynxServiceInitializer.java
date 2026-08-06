package com.bytedance.lynx.service;

import com.bytedance.lynx.service.extension.LynxExtensionService;
import com.bytedance.lynx.service.image.LynxImageService;
import com.bytedance.lynx.service.log.LynxLogService;
import com.bytedance.lynx.service.markdownService.LynxMarkDownService;
import com.bytedance.lynx.service.memory.monitor.LynxMemoryMonitorService;
import com.bytedance.lynx.service.model.LynxServiceConfig;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.lynx.service.network.LynxHttpService;
import com.bytedance.lynx.service.reporter.LynxEventReporterService;
import com.bytedance.lynx.service.resource.ILynxResourceServiceAdapter;
import com.bytedance.lynx.service.resource.LynxResourceService;
import com.bytedance.lynx.service.security.LynxSecurityService;
import com.bytedance.lynx.service.settings.ILynxSettingsDownloaderAdapter;
import com.bytedance.lynx.service.settings.LynxSettingsDownloader;
import com.bytedance.lynx.service.trace.TraceEventDef;
import com.bytedance.lynx.service.trail.ILynxABExperimentAdapter;
import com.bytedance.lynx.service.trail.LynxTrailService;
import com.lynx.service.devtool.LynxDevToolService;
import com.lynx.service.devtool.LynxInternalDevToolService;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.service.ILynxI18nService;
import com.lynx.tasm.service.LynxServiceCenter;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxServiceInitializer.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/lynx/service/LynxServiceInitializer;", "", "()V", "INSTANCE_NAME", "", "TAG", "lynxServiceConfig", "Lcom/bytedance/lynx/service/model/LynxServiceConfig;", "resourceAdapter", "Lcom/bytedance/lynx/service/resource/ILynxResourceServiceAdapter;", "settingsAdapter", "Lcom/bytedance/lynx/service/settings/ILynxSettingsDownloaderAdapter;", "createServiceAdapters", "", "ensureInitialize", "getLynxServiceConfig", "initialize", "isInitial", "", "registerServices", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxServiceInitializer {
    public static final LynxServiceInitializer INSTANCE = new LynxServiceInitializer();
    private static final String INSTANCE_NAME = "INSTANCE";
    public static final String TAG = "LynxServiceInitializer";
    private static LynxServiceConfig lynxServiceConfig;
    private static ILynxResourceServiceAdapter resourceAdapter;
    private static ILynxSettingsDownloaderAdapter settingsAdapter;

    /* compiled from: LynxServiceInitializer.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LynxServiceConfig.AdapterType.values().length];
            iArr[LynxServiceConfig.AdapterType.COMMON.ordinal()] = 1;
            iArr[LynxServiceConfig.AdapterType.GLOBAL.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private LynxServiceInitializer() {
    }

    public final void initialize(LynxServiceConfig lynxServiceConfig2) {
        Intrinsics.checkNotNullParameter(lynxServiceConfig2, "lynxServiceConfig");
        TraceEvent.beginSection(TraceEventDef.LYNX_SERVICE_INIT);
        LLog.i(TAG, "LynxServiceInitializer initialize.");
        lynxServiceConfig = lynxServiceConfig2;
        registerServices();
        createServiceAdapters();
        ILynxResourceServiceAdapter iLynxResourceServiceAdapter = null;
        if (settingsAdapter != null) {
            LynxSettingsDownloader lynxSettingsDownloader = LynxSettingsDownloader.INSTANCE;
            ILynxSettingsDownloaderAdapter iLynxSettingsDownloaderAdapter = settingsAdapter;
            if (iLynxSettingsDownloaderAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsAdapter");
                iLynxSettingsDownloaderAdapter = null;
            }
            lynxSettingsDownloader.initialize(lynxServiceConfig2, iLynxSettingsDownloaderAdapter);
        }
        if (resourceAdapter != null) {
            LynxResourceService lynxResourceService = LynxResourceService.INSTANCE;
            ILynxResourceServiceAdapter iLynxResourceServiceAdapter2 = resourceAdapter;
            if (iLynxResourceServiceAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resourceAdapter");
            } else {
                iLynxResourceServiceAdapter = iLynxResourceServiceAdapter2;
            }
            lynxResourceService.initialize(lynxServiceConfig2, iLynxResourceServiceAdapter);
        }
        LynxMonitorService.INSTANCE.initialize(lynxServiceConfig2);
        LynxMarkDownService.INSTANCE.initialize();
        LynxSecurityService.INSTANCE.getINSTANCE().initialize();
        TraceEvent.endSection(TraceEventDef.LYNX_SERVICE_INIT);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x010d A[Catch: Exception -> 0x0170, TryCatch #0 {Exception -> 0x0170, blocks: (B:8:0x0109, B:10:0x010d, B:11:0x0111, B:18:0x0124, B:20:0x013a, B:22:0x0142, B:23:0x014a, B:24:0x014b, B:26:0x015f, B:28:0x0167, B:29:0x016f), top: B:7:0x0109 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x014b A[Catch: Exception -> 0x0170, TryCatch #0 {Exception -> 0x0170, blocks: (B:8:0x0109, B:10:0x010d, B:11:0x0111, B:18:0x0124, B:20:0x013a, B:22:0x0142, B:23:0x014a, B:24:0x014b, B:26:0x015f, B:28:0x0167, B:29:0x016f), top: B:7:0x0109 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void registerServices() {
        boolean z;
        LynxServiceConfig lynxServiceConfig2;
        LynxServiceConfig lynxServiceConfig3;
        int i;
        LynxServiceCenter.inst().registerService(LynxImageService.getInstance());
        LynxServiceCenter.inst().registerService(LynxLogService.INSTANCE.getINSTANCE());
        LynxServiceCenter.inst().registerService(LynxTrailService.INSTANCE);
        LynxServiceCenter.inst().registerService(LynxHttpService.getInstance());
        LynxServiceCenter.inst().registerService(LynxResourceService.INSTANCE);
        LynxServiceCenter.inst().registerService(LynxMonitorService.INSTANCE);
        LynxServiceCenter.inst().registerService(LynxEventReporterService.INSTANCE);
        LynxServiceCenter.inst().registerService(LynxMemoryMonitorService.INSTANCE);
        LynxServiceCenter.inst().registerService(LynxSecurityService.INSTANCE.getINSTANCE());
        LynxServiceCenter.inst().registerService(LynxExtensionService.INSTANCE);
        try {
            try {
                LynxServiceCenter.inst().registerService(LynxDevToolService.Companion.getINSTANCE());
                LLog.i(TAG, "Register LynxDevToolService");
                z = true;
            } catch (ClassNotFoundException e) {
                LLog.e(TAG, "Failed to register LynxDevToolService: " + e.getMessage());
                z = false;
                if (!z) {
                }
                lynxServiceConfig2 = null;
                lynxServiceConfig3 = lynxServiceConfig;
                if (lynxServiceConfig3 == null) {
                }
                i = WhenMappings.$EnumSwitchMapping$0[lynxServiceConfig3.getAdapterType().ordinal()];
                if (i == 1) {
                }
            } catch (NoClassDefFoundError e2) {
                LLog.e(TAG, "Failed to register LynxDevToolService: " + e2.getMessage());
                z = false;
                if (!z) {
                }
                lynxServiceConfig2 = null;
                lynxServiceConfig3 = lynxServiceConfig;
                if (lynxServiceConfig3 == null) {
                }
                i = WhenMappings.$EnumSwitchMapping$0[lynxServiceConfig3.getAdapterType().ordinal()];
                if (i == 1) {
                }
            }
            lynxServiceConfig3 = lynxServiceConfig;
            if (lynxServiceConfig3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lynxServiceConfig");
                lynxServiceConfig3 = null;
            }
            i = WhenMappings.$EnumSwitchMapping$0[lynxServiceConfig3.getAdapterType().ordinal()];
            if (i == 1) {
                Object newInstance = Class.forName("com.bytedance.lynx.service.adapter.common.trail.LynxABExperimentAdapter").getConstructor(new Class[0]).newInstance(new Object[0]);
                if (newInstance == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.bytedance.lynx.service.trail.ILynxABExperimentAdapter");
                }
                LynxTrailService.INSTANCE.setABExperimentAdapter((ILynxABExperimentAdapter) newInstance);
                return;
            }
            if (i != 2) {
                return;
            }
            Field declaredField = Class.forName("com.bytedance.lynx.service.i18n.LynxI18nService").getDeclaredField(INSTANCE_NAME);
            LynxServiceCenter inst = LynxServiceCenter.inst();
            Object obj = declaredField.get(null);
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.service.ILynxI18nService");
            }
            inst.registerService((ILynxI18nService) obj);
            return;
        } catch (Exception e3) {
            StringBuilder append = new StringBuilder("Failed initServiceCenter with exception: ").append(e3).append(" adapterType: ");
            LynxServiceConfig lynxServiceConfig4 = lynxServiceConfig;
            if (lynxServiceConfig4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lynxServiceConfig");
            } else {
                lynxServiceConfig2 = lynxServiceConfig4;
            }
            LLog.e(TAG, append.append(lynxServiceConfig2.getAdapterType()).toString());
            return;
        }
        if (!z) {
            try {
                LynxServiceCenter.inst().registerService(LynxInternalDevToolService.Companion.getINSTANCE());
                LLog.i(TAG, "Register LynxInternalDevToolService");
            } catch (ClassNotFoundException e4) {
                LLog.e(TAG, "Failed to register LynxInternalDevToolService: " + e4.getMessage());
            } catch (NoClassDefFoundError e5) {
                LLog.e(TAG, "Failed to register LynxInternalDevToolService: " + e5.getMessage());
            }
        }
        lynxServiceConfig2 = null;
    }

    public final void ensureInitialize() {
        if (!isInitial()) {
            LLog.e(TAG, "Please initialize before use.");
            return;
        }
        LLog.i(TAG, "Ensure initialize.");
        ILynxResourceServiceAdapter iLynxResourceServiceAdapter = resourceAdapter;
        if (iLynxResourceServiceAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceAdapter");
            iLynxResourceServiceAdapter = null;
        }
        iLynxResourceServiceAdapter.initForest();
    }

    public final LynxServiceConfig getLynxServiceConfig() {
        if (!isInitial()) {
            LLog.e(TAG, "Please initialize before call getLynxServiceConfig.");
            return null;
        }
        LynxServiceConfig lynxServiceConfig2 = lynxServiceConfig;
        if (lynxServiceConfig2 != null) {
            return lynxServiceConfig2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lynxServiceConfig");
        return null;
    }

    private final boolean isInitial() {
        return (lynxServiceConfig == null || resourceAdapter == null || settingsAdapter == null) ? false : true;
    }

    private final void createServiceAdapters() {
        try {
            LynxServiceConfig lynxServiceConfig2 = lynxServiceConfig;
            if (lynxServiceConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lynxServiceConfig");
                lynxServiceConfig2 = null;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[lynxServiceConfig2.getAdapterType().ordinal()];
            if (i == 1) {
                Object obj = Class.forName("com.bytedance.lynx.service.adapter.common.resource.LynxResourceServiceAdapter").getDeclaredField(INSTANCE_NAME).get(null);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.bytedance.lynx.service.resource.ILynxResourceServiceAdapter");
                }
                resourceAdapter = (ILynxResourceServiceAdapter) obj;
                Object obj2 = Class.forName("com.bytedance.lynx.service.adapter.common.settings.LynxSettingsDownloaderAdapter").getDeclaredField(INSTANCE_NAME).get(null);
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.bytedance.lynx.service.settings.ILynxSettingsDownloaderAdapter");
                }
                settingsAdapter = (ILynxSettingsDownloaderAdapter) obj2;
                return;
            }
            if (i != 2) {
                return;
            }
            Object obj3 = Class.forName("com.bytedance.lynx.service.adapter.global.resource.LynxResourceServiceAdapter").getDeclaredField(INSTANCE_NAME).get(null);
            if (obj3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.bytedance.lynx.service.resource.ILynxResourceServiceAdapter");
            }
            resourceAdapter = (ILynxResourceServiceAdapter) obj3;
            Object obj4 = Class.forName("com.bytedance.lynx.service.adapter.global.settings.LynxSettingsDownloaderAdapter").getDeclaredField(INSTANCE_NAME).get(null);
            if (obj4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.bytedance.lynx.service.settings.ILynxSettingsDownloaderAdapter");
            }
            settingsAdapter = (ILynxSettingsDownloaderAdapter) obj4;
        } catch (Throwable th) {
            LLog.e(TAG, "failed in createServiceAdapters: " + th);
        }
    }
}
