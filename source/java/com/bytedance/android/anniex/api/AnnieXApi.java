package com.bytedance.android.anniex.api;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import com.bytedance.android.anniex.ability.GlobalPropsHelper;
import com.bytedance.android.anniex.ability.XBridgeHelper;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.config.LynxEngineConfig;
import com.bytedance.android.anniex.engine.AnnieXLynxEngine;
import com.bytedance.android.anniex.engine.AnnieXLynxEngineBuilder;
import com.bytedance.android.anniex.engine.AnnieXLynxEngineManager;
import com.bytedance.android.anniex.model.AnnieXLynxModel;
import com.bytedance.android.anniex.model.LynxViewBuilderParams;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.p026ui.AnnieXLynxView;
import com.bytedance.android.anniex.utils.IAnnieXLatchService;
import com.bytedance.android.anniex.utils.InteractiveXUtil;
import com.bytedance.android.anniex.utils.LokiManager;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.android.monitorV2.lynx.config.LynxViewMonitorConfig;
import com.bytedance.android.monitorV2.lynx.jsb.LynxViewMonitorModule;
import com.bytedance.android.monitorV2.lynx.jsb.LynxViewProvider;
import com.bytedance.android.monitorV2.lynx_helper.LynxViewMonitorHelper;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.device.BulletDeviceUtils;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.lynx.element.LynxCanvasTTPlayer;
import com.bytedance.ies.bullet.lynx.init.ILynxCanvasConfig;
import com.bytedance.ies.bullet.lynx.init.LynxConfig;
import com.bytedance.ies.bullet.service.base.IKitConfig;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.MonitorConfig;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.lynx.ILynxKitService;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.monitor.ContainerStandardMonitorWrapper;
import com.bytedance.ies.bullet.service.monitor.MonitorReportService;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.lynx.canvas.KryptonVideoPlayerService;
import com.lynx.canvas.LynxKryptonUtils;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;
import com.lynx.tasm.navigator.NavigationModule;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: AnnieXApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004J'\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\b\u0012J\u001f\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0003¢\u0006\u0002\u0010\u0017J9\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010\u001fJ\"\u0010 \u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\u0018\u0010\"\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u001a2\b\b\u0002\u0010(\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001a¨\u0006)"}, d2 = {"Lcom/bytedance/android/anniex/api/AnnieXApi;", "", "()V", "createLynxEngine", "Lcom/bytedance/android/anniex/engine/AnnieXLynxEngine;", "context", "Landroid/content/Context;", "lynxModel", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel;", "config", "Lcom/bytedance/android/anniex/config/LynxEngineConfig;", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "createLynxView", "Lcom/bytedance/android/anniex/ui/AnnieXLynxView;", "createLynxViewFromEngine", "inputEngine", "createNewLynxEngine", "createNewLynxEngine$anniex_release", "initCanvasSettings", "", "lynxView", "Lcom/lynx/tasm/LynxView;", "(Landroid/content/Context;Lcom/lynx/tasm/LynxView;)Lkotlin/Unit;", "initMonitorConfig", "bid", "", "enableBlankDetect", "", "isCompactMode", "sessionId", "(Ljava/lang/String;Lcom/lynx/tasm/LynxView;ZZLjava/lang/String;)Lkotlin/Unit;", "initMonitorConfigByID", "monitorID", "latchRegisterModule", "lynxViewBuilder", "Lcom/lynx/tasm/LynxViewBuilder;", "latchattachToLynxView", "preloadTemplate", StreamTrafficObservable.STREAM_URL, "withSubResources", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXApi {
    public static final AnnieXApi INSTANCE = new AnnieXApi();

    private AnnieXApi() {
    }

    public static /* synthetic */ AnnieXLynxView createLynxViewFromEngine$default(AnnieXApi annieXApi, Context context, AnnieXLynxModel annieXLynxModel, AnnieXLynxEngine annieXLynxEngine, int i, Object obj) {
        if ((i & 4) != 0) {
            annieXLynxEngine = null;
        }
        return annieXApi.createLynxViewFromEngine(context, annieXLynxModel, annieXLynxEngine);
    }

    public static /* synthetic */ void preloadTemplate$default(AnnieXApi annieXApi, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        annieXApi.preloadTemplate(str, z, str2);
    }

    public final void preloadTemplate(String url, boolean withSubResources, String sessionId) {
        Intrinsics.checkNotNullParameter(url, StreamTrafficObservable.STREAM_URL);
        ForestLoader.preload$default(ForestLoader.INSTANCE, (Forest) null, url, withSubResources, sessionId, PreloadType.LYNX, true, "AnnieX_card", (TaskConfig) null, true, (Function2) null, 641, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void latchRegisterModule(AnnieXLynxModel lynxModel, LynxViewBuilder lynxViewBuilder) {
        IAnnieXLatchService.Process latchProcess;
        List<IAnnieXLatchService.LynxModuleCreation> createOrGetLynxModule;
        IAnnieXLatchService iAnnieXLatchService = (IAnnieXLatchService) AnnieX.INSTANCE.getService(lynxModel.getBid(), IAnnieXLatchService.class);
        if (iAnnieXLatchService == null || (latchProcess = iAnnieXLatchService.getLatchProcess(lynxModel.getSessionId())) == null || (createOrGetLynxModule = latchProcess.createOrGetLynxModule()) == null) {
            return;
        }
        for (IAnnieXLatchService.LynxModuleCreation lynxModuleCreation : createOrGetLynxModule) {
            lynxViewBuilder.registerModule(lynxModuleCreation.getName(), lynxModuleCreation.getModuleType(), lynxModuleCreation.getParams());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void latchattachToLynxView(AnnieXLynxModel lynxModel, LynxView lynxView) {
        IAnnieXLatchService.Process latchProcess;
        IAnnieXLatchService iAnnieXLatchService = (IAnnieXLatchService) AnnieX.INSTANCE.getService(lynxModel.getBid(), IAnnieXLatchService.class);
        if (iAnnieXLatchService == null || (latchProcess = iAnnieXLatchService.getLatchProcess(lynxModel.getSessionId())) == null) {
            return;
        }
        latchProcess.attachToLynxView(lynxView);
    }

    static /* synthetic */ Unit initMonitorConfig$default(AnnieXApi annieXApi, String str, LynxView lynxView, boolean z, boolean z2, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = false;
        }
        return annieXApi.initMonitorConfig(str, lynxView, z, z2, str2);
    }

    @Deprecated(message = "请使用AnnieX.createLynxView()代替", replaceWith = @ReplaceWith(expression = "AnnieX.createLynxView()", imports = {}))
    public final AnnieXLynxView createLynxView(Context context, AnnieXLynxModel lynxModel) {
        AnnieXLynxView annieXLynxView;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lynxModel, "lynxModel");
        TraceEvent.beginSection("AnnieXApi:createLynxView");
        try {
            if (Intrinsics.areEqual(lynxModel.getBid(), "Loki")) {
                annieXLynxView = LokiManager.INSTANCE.createAnnieXLynxView(context, lynxModel);
            } else {
                AnnieXLynxModel.CompactConfig compactConfig = lynxModel.getCompactConfig();
                if (compactConfig != null && compactConfig.getCompactMonitor()) {
                    MonitorManager.INSTANCE.addIgnoreSession(lynxModel.getSessionId());
                }
                MonitorManager.INSTANCE.onKitViewCreateBegin(lynxModel.getSessionId());
                LynxViewProvider lynxViewProvider = new LynxViewProvider((LynxView) null, 1, (DefaultConstructorMarker) null);
                LynxViewBuilder lynxViewBuilder = lynxModel.getLynxViewBuilderParams().toLynxViewBuilder(lynxModel.getSessionId());
                TraceEvent.beginSection("LynxViewBuilder:registerModule");
                lynxViewBuilder.registerModule(NavigationModule.NAME, NavigationModule.class, (Object) null);
                lynxViewBuilder.registerModule("hybridMonitor", LynxViewMonitorModule.class, lynxViewProvider);
                INSTANCE.latchRegisterModule(lynxModel, lynxViewBuilder);
                TraceEvent.endSection("LynxViewBuilder:registerModule");
                LynxBDXBridge lynxBridge = lynxModel.getUseXBridge3() ? XBridgeHelper.INSTANCE.getLynxBridge(context, lynxModel, lynxViewBuilder) : null;
                LynxViewBuilderParams lynxViewBuilderParams = lynxModel.getLynxViewBuilderParams();
                if (!(lynxViewBuilderParams.getViewZoom() == 1.0f)) {
                    if (lynxViewBuilderParams.getScreenWidth() == -1 && lynxViewBuilderParams.getScreenHeight() == -1) {
                        Display display = BulletDeviceUtils.INSTANCE.getDisplay(context);
                        if (display != null) {
                            try {
                                display.getSize(new Point());
                                lynxViewBuilder.setScreenSize((int) (r12.x * lynxViewBuilderParams.getViewZoom()), (int) (r12.y * lynxViewBuilderParams.getViewZoom()));
                            } catch (Exception e) {
                                HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieX", ": " + e, (Map) null, (LoggerContext) null, 12, (Object) null);
                                Unit unit = Unit.INSTANCE;
                            }
                        }
                    } else if (lynxViewBuilderParams.getScreenWidth() != -1 && lynxViewBuilderParams.getScreenHeight() != -1) {
                        lynxViewBuilder.setScreenSize((int) (lynxViewBuilderParams.getScreenWidth() * lynxViewBuilderParams.getViewZoom()), (int) (lynxViewBuilderParams.getScreenHeight() * lynxViewBuilderParams.getViewZoom()));
                    }
                }
                TraceEvent.endSection("LynxViewBuilderParams:toLynxViewBuilder");
                TraceEvent.beginSection("AnnieXLynxView:init");
                annieXLynxView = new AnnieXLynxView(context, lynxModel.getSessionId(), lynxModel.getBid(), lynxViewBuilder);
                if (InteractiveXUtil.INSTANCE.useMotion(lynxModel.getOriginalUri())) {
                    InteractiveXUtil.INSTANCE.injectMotionPhysics(annieXLynxView);
                }
                if (lynxBridge != null) {
                    annieXLynxView.initBridge(lynxBridge, lynxModel);
                }
                if (!lynxModel.isCompactMode()) {
                    AnnieXLynxModel.CompactConfig compactConfig2 = lynxModel.getCompactConfig();
                    if (!(compactConfig2 != null && compactConfig2.getCompactCanvas())) {
                        INSTANCE.initCanvasSettings(context, annieXLynxView);
                    }
                }
                AnnieXLynxModel.CompactConfig compactConfig3 = lynxModel.getCompactConfig();
                if (compactConfig3 != null && compactConfig3.getCompactMonitor()) {
                    INSTANCE.initMonitorConfigByID(lynxModel.getCompactConfig().getMonitorID(), annieXLynxView, lynxModel.getSessionId());
                } else {
                    INSTANCE.initMonitorConfig(lynxModel.getBid(), annieXLynxView, !lynxModel.getOriginalUri().getBooleanQueryParameter("use_card_mode", true), lynxModel.isCompactMode(), lynxModel.getSessionId());
                }
                lynxViewProvider.setView(annieXLynxView);
                annieXLynxView.setViewZoom(lynxModel.getLynxViewBuilderParams().getViewZoom());
                String lynxGroupName = lynxModel.getLynxViewBuilderParams().getLynxGroupName();
                if (lynxGroupName != null) {
                    annieXLynxView.setGroupName(lynxGroupName);
                }
                INSTANCE.latchattachToLynxView(lynxModel, annieXLynxView);
                TraceEvent.endSection("AnnieXLynxView:init");
                MonitorManager.INSTANCE.onKitViewCreateEnd(annieXLynxView, lynxModel.getSessionId());
            }
            return annieXLynxView;
        } finally {
            TraceEvent.endSection("AnnieXApi:createLynxView");
        }
    }

    public final AnnieXLynxEngine createLynxEngine(Context context, AnnieXLynxModel lynxModel, LynxEngineConfig config, ContextProviderFactory contextProviderFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lynxModel, "lynxModel");
        TraceEvent.beginSection("AnnieXApi:createLynxEngine");
        try {
            AnnieXLynxEngine annieXLynxEngine = null;
            if (!LynxEnv.inst().hasInited()) {
                HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieX", "LynxEnv.inst.hasInited == false", (Map) null, (LoggerContext) null, 12, (Object) null);
            } else {
                boolean z = true;
                LynxViewProvider lynxViewProvider = new LynxViewProvider((LynxView) null, 1, (DefaultConstructorMarker) null);
                LynxViewBuilder lynxEngineBuilder = lynxModel.getLynxViewBuilderParams().toLynxEngineBuilder(lynxModel.getSessionId());
                TraceEvent.beginSection("LynxViewBuilder:registerModule");
                lynxEngineBuilder.registerModule(NavigationModule.NAME, NavigationModule.class, (Object) null);
                lynxEngineBuilder.registerModule("hybridMonitor", LynxViewMonitorModule.class, lynxViewProvider);
                INSTANCE.latchRegisterModule(lynxModel, lynxEngineBuilder);
                TraceEvent.endSection("LynxViewBuilder:registerModule");
                MutableContextWrapper mutableContextWrapper = new MutableContextWrapper(context.getApplicationContext());
                LynxBDXBridge lynxBridge = lynxModel.getUseXBridge3() ? XBridgeHelper.INSTANCE.getLynxBridge(mutableContextWrapper, lynxModel, lynxEngineBuilder) : null;
                LynxViewBuilderParams lynxViewBuilderParams = lynxModel.getLynxViewBuilderParams();
                if (!(lynxViewBuilderParams.getViewZoom() == 1.0f)) {
                    if (lynxViewBuilderParams.getScreenWidth() == -1 && lynxViewBuilderParams.getScreenHeight() == -1) {
                        Display display = BulletDeviceUtils.INSTANCE.getDisplay(context);
                        if (display != null) {
                            try {
                                display.getSize(new Point());
                                lynxEngineBuilder.setScreenSize((int) (r12.x * lynxViewBuilderParams.getViewZoom()), (int) (r12.y * lynxViewBuilderParams.getViewZoom()));
                            } catch (Exception e) {
                                HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieX", ": " + e, (Map) null, (LoggerContext) null, 12, (Object) null);
                                Unit unit = Unit.INSTANCE;
                            }
                        }
                    } else if (lynxViewBuilderParams.getScreenWidth() != -1 && lynxViewBuilderParams.getScreenHeight() != -1) {
                        lynxEngineBuilder.setScreenSize((int) (lynxViewBuilderParams.getScreenWidth() * lynxViewBuilderParams.getViewZoom()), (int) (lynxViewBuilderParams.getScreenHeight() * lynxViewBuilderParams.getViewZoom()));
                    }
                }
                TraceEvent.endSection("LynxViewBuilderParams:toLynxEngineBuilder");
                AnnieXLynxEngine build = new AnnieXLynxEngineBuilder(null, null, null, 7, null).setLynxBdxBridge(lynxBridge).setLynxViewProvider(lynxViewProvider).setConfig(config).build(lynxModel.getBid(), mutableContextWrapper, lynxEngineBuilder, lynxModel.getSessionId());
                if (!(config != null && config.getDisableCache())) {
                    AnnieXLynxEngineManager.INSTANCE.putEngine(lynxModel.getBid(), lynxModel.getSessionId(), build);
                }
                build.load$anniex_release(lynxModel, contextProviderFactory);
                if (config == null || !config.getDisableCache()) {
                    z = false;
                }
                if (z) {
                    annieXLynxEngine = build;
                } else {
                    BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new AnnieXApi$createLynxEngine$1$2(build, null), 3, (Object) null);
                }
            }
            return annieXLynxEngine;
        } finally {
            TraceEvent.endSection("AnnieXApi:createLynxEngine");
        }
    }

    public final AnnieXLynxEngine createNewLynxEngine$anniex_release(Context context, AnnieXLynxModel lynxModel, LynxEngineConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lynxModel, "lynxModel");
        TraceEvent.beginSection("AnnieXApi:createLynxEngine");
        try {
            boolean z = true;
            LynxViewProvider lynxViewProvider = new LynxViewProvider((LynxView) null, 1, (DefaultConstructorMarker) null);
            LynxViewBuilder lynxEngineBuilder = lynxModel.getLynxViewBuilderParams().toLynxEngineBuilder(lynxModel.getSessionId());
            TraceEvent.beginSection("LynxViewBuilder:registerModule");
            lynxEngineBuilder.registerModule(NavigationModule.NAME, NavigationModule.class, (Object) null);
            lynxEngineBuilder.registerModule("hybridMonitor", LynxViewMonitorModule.class, lynxViewProvider);
            INSTANCE.latchRegisterModule(lynxModel, lynxEngineBuilder);
            TraceEvent.endSection("LynxViewBuilder:registerModule");
            MutableContextWrapper mutableContextWrapper = new MutableContextWrapper(context.getApplicationContext());
            LynxBDXBridge lynxBridge = lynxModel.getUseXBridge3() ? XBridgeHelper.INSTANCE.getLynxBridge(mutableContextWrapper, lynxModel, lynxEngineBuilder) : null;
            lynxEngineBuilder.setPresetMeasuredSpec(View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            LynxViewBuilderParams lynxViewBuilderParams = lynxModel.getLynxViewBuilderParams();
            if (lynxViewBuilderParams.getViewZoom() != 1.0f) {
                z = false;
            }
            if (!z) {
                if (lynxViewBuilderParams.getScreenWidth() == -1 && lynxViewBuilderParams.getScreenHeight() == -1) {
                    Display display = BulletDeviceUtils.INSTANCE.getDisplay(context);
                    if (display != null) {
                        try {
                            display.getSize(new Point());
                            lynxEngineBuilder.setScreenSize((int) (r6.x * lynxViewBuilderParams.getViewZoom()), (int) (r6.y * lynxViewBuilderParams.getViewZoom()));
                        } catch (Exception e) {
                            HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieX", ": " + e, (Map) null, (LoggerContext) null, 12, (Object) null);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                } else if (lynxViewBuilderParams.getScreenWidth() != -1 && lynxViewBuilderParams.getScreenHeight() != -1) {
                    lynxEngineBuilder.setScreenSize((int) (lynxViewBuilderParams.getScreenWidth() * lynxViewBuilderParams.getViewZoom()), (int) (lynxViewBuilderParams.getScreenHeight() * lynxViewBuilderParams.getViewZoom()));
                }
            }
            TraceEvent.endSection("LynxViewBuilderParams:toLynxEngineBuilder");
            AnnieXLynxEngine build = new AnnieXLynxEngineBuilder(null, null, null, 7, null).setLynxBdxBridge(lynxBridge).setLynxViewProvider(lynxViewProvider).setConfig(config).build(lynxModel.getBid(), mutableContextWrapper, lynxEngineBuilder, lynxModel.getSessionId());
            AnnieXLynxEngineManager.INSTANCE.putEngine(lynxModel.getBid(), lynxModel.getSessionId(), build);
            return build;
        } finally {
            TraceEvent.endSection("AnnieXApi:createLynxEngine");
        }
    }

    public final AnnieXLynxView createLynxViewFromEngine(Context context, AnnieXLynxModel lynxModel, AnnieXLynxEngine inputEngine) {
        AnnieXLynxView createLynxView;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lynxModel, "lynxModel");
        TraceEvent.beginSection("AnnieXApi:createLynxViewFromEngine");
        try {
            MonitorManager.INSTANCE.onKitViewCreateBegin(lynxModel.getSessionId());
            TraceEvent.beginSection("AnnieXLynxView:init");
            if (inputEngine == null) {
                inputEngine = AnnieXLynxEngineManager.INSTANCE.getEngine(lynxModel.getBid(), lynxModel.getSessionId());
            }
            if (inputEngine != null) {
                MutableContextWrapper contextWrapper = inputEngine.getContextWrapper();
                LynxViewProvider lynxViewProvider = inputEngine.getLynxViewProvider();
                createLynxView = new AnnieXLynxView(context, lynxModel.getSessionId(), lynxModel.getBid(), inputEngine);
                ContainerStandardMonitorWrapper.INSTANCE.addContext(lynxModel.getSessionId(), "is_from_engine", "true");
                if (lynxViewProvider != null) {
                    lynxViewProvider.setView(createLynxView);
                }
                Map<String, Object> pageGlobalPropsByActivity = GlobalPropsHelper.INSTANCE.getPageGlobalPropsByActivity(createLynxView.getContext());
                if (!Intrinsics.areEqual(pageGlobalPropsByActivity, GlobalPropsHelper.INSTANCE.getPageGlobalPropsByActivity(contextWrapper.getBaseContext())) && pageGlobalPropsByActivity != null) {
                    createLynxView.updateGlobalProps((Map<String, ? extends Object>) pageGlobalPropsByActivity);
                }
                contextWrapper.setBaseContext(context);
                LynxBDXBridge lynxBdxBridge = inputEngine.getLynxBdxBridge();
                if (lynxBdxBridge != null) {
                    createLynxView.initBridge(lynxBdxBridge, lynxModel);
                }
                createLynxView.setResourceInfo$anniex_release(inputEngine.getResourceInfo());
                if (!lynxModel.isCompactMode()) {
                    INSTANCE.initCanvasSettings(context, createLynxView);
                }
                AnnieXApi annieXApi = INSTANCE;
                annieXApi.initMonitorConfig(lynxModel.getBid(), createLynxView, !lynxModel.getOriginalUri().getBooleanQueryParameter("use_card_mode", true), lynxModel.isCompactMode(), lynxModel.getSessionId());
                createLynxView.setViewZoom(lynxModel.getLynxViewBuilderParams().getViewZoom());
                String lynxGroupName = lynxModel.getLynxViewBuilderParams().getLynxGroupName();
                if (lynxGroupName != null) {
                    createLynxView.setGroupName(lynxGroupName);
                }
                annieXApi.latchattachToLynxView(lynxModel, createLynxView);
                inputEngine.setHasAttachLynxView$anniex_release(true);
                TraceEvent.endSection("AnnieXLynxView:init");
                MonitorManager.INSTANCE.onKitViewCreateEnd(createLynxView, lynxModel.getSessionId());
            } else {
                createLynxView = AnnieXApiKt.createLynxView(AnnieX.INSTANCE, context, lynxModel);
            }
            return createLynxView;
        } finally {
            TraceEvent.endSection("AnnieXApi:createLynxViewFromEngine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004e A[Catch: all -> 0x00af, TryCatch #2 {all -> 0x00af, blocks: (B:7:0x0033, B:9:0x0044, B:10:0x004a, B:12:0x004e, B:14:0x0054, B:16:0x005a, B:30:0x00a9, B:34:0x0089, B:41:0x001a, B:19:0x0060, B:20:0x0068, B:22:0x006e, B:25:0x0084, B:3:0x0008, B:5:0x000e), top: B:2:0x0008, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e A[Catch: all -> 0x0088, TryCatch #0 {all -> 0x0088, blocks: (B:19:0x0060, B:20:0x0068, B:22:0x006e, B:25:0x0084), top: B:18:0x0060, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0044 A[Catch: all -> 0x00af, TryCatch #2 {all -> 0x00af, blocks: (B:7:0x0033, B:9:0x0044, B:10:0x004a, B:12:0x004e, B:14:0x0054, B:16:0x005a, B:30:0x00a9, B:34:0x0089, B:41:0x001a, B:19:0x0060, B:20:0x0068, B:22:0x006e, B:25:0x0084, B:3:0x0008, B:5:0x000e), top: B:2:0x0008, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Unit initCanvasSettings(Context context, LynxView lynxView) {
        Unit unit;
        LynxConfig lynxConfig;
        ILynxCanvasConfig canvasInitConfig;
        Map lynxCanvasServiceMap;
        TraceEvent.beginSection("AnnieXApi:initCanvasSettings");
        try {
            try {
                LynxKryptonHelper lynxKryptonHelper = LynxKryptonUtils.getLynxKryptonHelper(lynxView);
                if (lynxKryptonHelper != null) {
                    lynxKryptonHelper.registerService(KryptonVideoPlayerService.class, new LynxCanvasTTPlayer.Companion.LynxCanvasPlayerService(context));
                }
            } finally {
                ILynxKitService iLynxKitService = ServiceCenter.Companion.instance().get(ILynxKitService.class);
                unit = null;
                if (iLynxKitService == null) {
                }
                if (!(r10 instanceof LynxConfig)) {
                }
                if (lynxConfig != null) {
                    try {
                        while (r10.hasNext()) {
                        }
                    } catch (Throwable th) {
                        HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieX", "take it easy. Krypton Player require Lynx >= 2.10: " + th, (Map) null, (LoggerContext) null, 12, (Object) null);
                    }
                    unit = Unit.INSTANCE;
                }
                TraceEvent.endSection("AnnieXApi:initCanvasSettings");
                return unit;
            }
            ILynxKitService iLynxKitService2 = ServiceCenter.Companion.instance().get(ILynxKitService.class);
            unit = null;
            IKitConfig kitConfig = iLynxKitService2 == null ? iLynxKitService2.getKitConfig() : null;
            lynxConfig = !(kitConfig instanceof LynxConfig) ? (LynxConfig) kitConfig : null;
            if (lynxConfig != null && (canvasInitConfig = lynxConfig.canvasInitConfig()) != null && (lynxCanvasServiceMap = canvasInitConfig.getLynxCanvasServiceMap()) != null) {
                for (Map.Entry entry : lynxCanvasServiceMap.entrySet()) {
                    Class cls = (Class) entry.getKey();
                    Object value = entry.getValue();
                    LynxKryptonHelper lynxKryptonHelper2 = LynxKryptonUtils.getLynxKryptonHelper(lynxView);
                    if (lynxKryptonHelper2 != null) {
                        lynxKryptonHelper2.registerService(cls, value);
                    }
                }
                unit = Unit.INSTANCE;
            }
            TraceEvent.endSection("AnnieXApi:initCanvasSettings");
            return unit;
        } catch (Throwable th2) {
            TraceEvent.endSection("AnnieXApi:initCanvasSettings");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Unit initMonitorConfig(String bid, LynxView lynxView, boolean enableBlankDetect, boolean isCompactMode, String sessionId) {
        Unit unit;
        Iterator<String> keys;
        TraceEvent.beginSection("AnnieXApi:initMonitorConfig");
        try {
            IMonitorReportService iMonitorReportService = ServiceCenter.Companion.instance().get(bid, IMonitorReportService.class);
            if (iMonitorReportService == null) {
                iMonitorReportService = (IMonitorReportService) MonitorReportService.Companion.getFallbackDefault();
            }
            MonitorConfig monitorConfig = iMonitorReportService.getMonitorConfig();
            LynxViewMonitorConfig lynxViewMonitorConfig = new LynxViewMonitorConfig(monitorConfig.getBizTag());
            lynxViewMonitorConfig.setVirtualAID(monitorConfig.getVirtualAID());
            lynxViewMonitorConfig.setEnableMonitor(monitorConfig.getLogSwitch());
            lynxViewMonitorConfig.setEnableBlankDetect(enableBlankDetect);
            lynxViewMonitorConfig.setCompactMode(isCompactMode);
            lynxViewMonitorConfig.setSessionId(sessionId);
            LynxViewMonitorHelper.registerLynxMonitor(lynxView, lynxViewMonitorConfig);
            JSONObject category = monitorConfig.getCategory();
            if (category == null || (keys = category.keys()) == null) {
                unit = null;
            } else {
                Intrinsics.checkNotNullExpressionValue(keys, "keys()");
                while (keys.hasNext()) {
                    String next = keys.next();
                    LynxViewMonitor instance = LynxViewMonitor.Companion.getINSTANCE();
                    Intrinsics.checkNotNullExpressionValue(next, "it");
                    JSONObject category2 = monitorConfig.getCategory();
                    Intrinsics.checkNotNull(category2);
                    instance.addContext(lynxView, next, category2.get(next).toString());
                }
                unit = Unit.INSTANCE;
            }
            return unit;
        } finally {
            TraceEvent.endSection("AnnieXApi:initMonitorConfig");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initMonitorConfigByID(String monitorID, LynxView lynxView, String sessionId) {
        TraceEvent.beginSection("AnnieXApi:initMonitorConfig");
        try {
            MonitorManager.INSTANCE.onLynxMonitorInitSync(sessionId, (View) lynxView);
            if (monitorID == null) {
                monitorID = "bullet_custom_bid";
            }
            LynxViewMonitorConfig lynxViewMonitorConfig = new LynxViewMonitorConfig(monitorID);
            lynxViewMonitorConfig.setEnableMonitor(true);
            lynxViewMonitorConfig.setEnableBlankDetect(false);
            LynxViewMonitorHelper.registerLynxMonitor(lynxView, lynxViewMonitorConfig);
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXApi:initMonitorConfig");
        }
    }
}
