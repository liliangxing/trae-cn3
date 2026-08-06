package com.bytedance.ies.argus.base;

import android.net.Uri;
import com.bytedance.forest.chain.fetchers.GeckoFetcher;
import com.bytedance.forest.interceptor.ForestInterceptor;
import com.bytedance.forest.interceptor.GlobalInterceptor;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.Scene;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.ies.argus.api.interfaces.ArgusInitConfig;
import com.bytedance.ies.argus.api.params.LoadStaticResourceParams;
import com.bytedance.ies.argus.api.params.LoadStaticResourceRewritePayload;
import com.bytedance.ies.argus.aspect.ArgusLynxSecurityHandler;
import com.bytedance.ies.argus.base.ArgusInitializer;
import com.bytedance.ies.argus.bean.ArgusMonitorKeyName;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.plugin.PluginManager;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import com.bytedance.ies.argus.repository.ArgusSdkGeckoAppRegister;
import com.bytedance.ies.argus.strategy.ArgusTTMStrategyManagerWrapper;
import com.bytedance.ies.argus.strategy.GlobalStrategyManager;
import com.bytedance.ies.argus.util.ForceHttpsUtil;
import com.bytedance.ies.bullet.kit.resourceloader.debugger.GlobalResourceInterceptor;
import com.bytedance.ies.bullet.kit.resourceloader.debugger.ResourceLoaderHooker;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.lynx.service.security.LynxSecurityService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import org.json.JSONObject;

/* compiled from: ArgusInitializer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 $2\u00020\u0001:\u0003$%&B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\fJ\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00120\bH\u0002J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00120\bH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\r\u0010\u0016\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0017J \u0010\u0018\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\t\u0018\u00010\bJ\b\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J\b\u0010\u001c\u001a\u00020\fH\u0002J\b\u0010\u001d\u001a\u00020\fH\u0002J\b\u0010\u001e\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\fH\u0002J\f\u0010 \u001a\u00020!*\u00020\"H\u0002J\f\u0010 \u001a\u00020!*\u00020#H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/ies/argus/base/ArgusInitializer;", "", "initConfig", "Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig;", "(Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig;)V", "_hasFinishedSetup", "", "deferredSetupTask", "", "Lkotlin/Pair;", "Lcom/bytedance/ies/argus/base/ArgusInitializer$TaskPriority;", "Lkotlinx/coroutines/Deferred;", "", "hasInitAsyncSetupTask", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasStartedBlockSetup", "ensureExecuteSetupTask", "getHighPrioritySetupJobs", "Lkotlin/Function0;", "getLowPrioritySetupJobs", "getSecureConfig", "hasFinishSetup", "init", "init$anniex_release", "initAsyncSetupTask", "initLoaderSecurityInterceptor", "initLynxHandler", "initTTMachine", "innerEnsureExecuteSetupTask", "registerConfigListener", "setFinishSetup", "syncExecuteSetupTask", "toResourceType", "Lcom/bytedance/ies/argus/base/ArgusInitializer$ResourceType;", "Lcom/bytedance/forest/model/Scene;", "", "Companion", "ResourceType", "TaskPriority", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusInitializer {
    private static final String TAG = "ArgusInitializer";
    private boolean _hasFinishedSetup;
    private List<? extends Pair<? extends TaskPriority, ? extends Deferred<Unit>>> deferredSetupTask;
    private final AtomicBoolean hasInitAsyncSetupTask;
    private final AtomicBoolean hasStartedBlockSetup;
    private final ArgusInitConfig initConfig;

    /* compiled from: ArgusInitializer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/argus/base/ArgusInitializer$TaskPriority;", "", "(Ljava/lang/String;I)V", "HIGH", "LOW", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum TaskPriority {
        HIGH,
        LOW
    }

    /* compiled from: ArgusInitializer.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Scene.values().length];
            try {
                iArr[Scene.LYNX_TEMPLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Scene.WEB_MAIN_DOCUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Scene.LYNX_EXTERNAL_JS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Scene.LYNX_COMPONENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Scene.LYNX_IMAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Scene.LYNX_VIDEO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Scene.LYNX_I18N.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Scene.LYNX_FONT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Scene.LYNX_LOTTIE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[Scene.LYNX_SVG.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[Scene.LYNX_CHILD_RESOURCE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[Scene.WEB_CHILD_RESOURCE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[Scene.PRELOAD_CONFIG.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[Scene.OTHER.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ArgusInitializer(ArgusInitConfig argusInitConfig) {
        Intrinsics.checkNotNullParameter(argusInitConfig, "initConfig");
        this.initConfig = argusInitConfig;
        this.hasInitAsyncSetupTask = new AtomicBoolean(false);
        this.hasStartedBlockSetup = new AtomicBoolean(false);
    }

    public final List<Pair<TaskPriority, Deferred<Unit>>> initAsyncSetupTask() {
        if (this.hasInitAsyncSetupTask.compareAndSet(false, true)) {
            ArgusLog.i$default(ArgusLog.INSTANCE, TAG, "init async setup task", null, 4, null);
            ArrayList arrayList = new ArrayList();
            CoroutineScope sharedScope = ArgusEnv.INSTANCE.getInstance().getSharedScope();
            Iterator<T> it = getHighPrioritySetupJobs().iterator();
            while (it.hasNext()) {
                arrayList.add(new Pair(TaskPriority.HIGH, BuildersKt.async$default(sharedScope, (CoroutineContext) null, (CoroutineStart) null, new ArgusInitializer$initAsyncSetupTask$1$job$1((Function0) it.next(), null), 3, (Object) null)));
            }
            Iterator<T> it2 = getLowPrioritySetupJobs().iterator();
            while (it2.hasNext()) {
                arrayList.add(new Pair(TaskPriority.LOW, BuildersKt.async$default(sharedScope, (CoroutineContext) null, (CoroutineStart) null, new ArgusInitializer$initAsyncSetupTask$2$job$1((Function0) it2.next(), null), 3, (Object) null)));
            }
            this.deferredSetupTask = CollectionsKt.toList(arrayList);
        }
        return this.deferredSetupTask;
    }

    public final void ensureExecuteSetupTask() {
        if (hasFinishSetup() || !this.hasStartedBlockSetup.compareAndSet(false, true)) {
            return;
        }
        synchronized (this) {
            innerEnsureExecuteSetupTask();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean hasFinishSetup() {
        boolean z;
        boolean z2;
        if (this._hasFinishedSetup) {
            return true;
        }
        List<? extends Pair<? extends TaskPriority, ? extends Deferred<Unit>>> list = this.deferredSetupTask;
        if (list != null) {
            List<? extends Pair<? extends TaskPriority, ? extends Deferred<Unit>>> list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    if (!(pair.getFirst() != TaskPriority.HIGH || ((Deferred) pair.getSecond()).isCompleted())) {
                        z2 = false;
                        break;
                    }
                }
            }
            z2 = true;
            if (z2) {
                z = true;
                if (z) {
                    return false;
                }
                setFinishSetup();
                return true;
            }
        }
        z = false;
        if (z) {
        }
    }

    private final void setFinishSetup() {
        this._hasFinishedSetup = true;
        this.deferredSetupTask = null;
    }

    private final void innerEnsureExecuteSetupTask() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        if (this.hasInitAsyncSetupTask.compareAndSet(false, true)) {
            syncExecuteSetupTask();
            objectRef.element = "sync execute setup task, hasn't init async setup task";
        } else {
            if (this.deferredSetupTask != null && (!r0.isEmpty())) {
                z = true;
            }
            if (z) {
                BuildersKt.runBlocking$default((CoroutineContext) null, new ArgusInitializer$innerEnsureExecuteSetupTask$time$1$1(ArgusEnv.INSTANCE.getInstance().getInitSetting().getInitSyncTimeWaiting(), this, objectRef, booleanRef, null), 1, (Object) null);
            } else {
                objectRef.element = "async task is null";
            }
        }
        setFinishSetup();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (booleanRef.element) {
            JSONObject put = new JSONObject().put(ArgusMonitorKeyName.SEC_EVENT_TYPE, "init").put("msg", objectRef.element).put("finish_setup_cost", currentTimeMillis2);
            ArgusMonitor argusMonitor = ArgusMonitor.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(put, "data");
            argusMonitor.asyncReportLifeCycle(put);
        }
        ArgusLog.i$default(ArgusLog.INSTANCE, TAG, "finish setup: " + ((String) objectRef.element) + ", cost " + currentTimeMillis2 + " ms", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncExecuteSetupTask() {
        Iterator<T> it = getHighPrioritySetupJobs().iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
        CoroutineScope sharedScope = ArgusEnv.INSTANCE.getInstance().getSharedScope();
        Iterator<T> it2 = getLowPrioritySetupJobs().iterator();
        while (it2.hasNext()) {
            BuildersKt.async$default(sharedScope, (CoroutineContext) null, (CoroutineStart) null, new ArgusInitializer$syncExecuteSetupTask$2$1((Function0) it2.next(), null), 3, (Object) null);
        }
    }

    private final void registerConfigListener() {
        GlobalStrategyManager.INSTANCE.setup();
        PluginManager.INSTANCE.getInstance().setup();
    }

    private final List<Function0<Unit>> getHighPrioritySetupJobs() {
        return CollectionsKt.listOf(new Function0[]{new Function0<Unit>() { // from class: com.bytedance.ies.argus.base.ArgusInitializer$getHighPrioritySetupJobs$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m601invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m601invoke() {
                ArgusInitializer.this.getSecureConfig();
                ArgusInitializer.this.initTTMachine();
            }
        }, new Function0<Unit>() { // from class: com.bytedance.ies.argus.base.ArgusInitializer$getHighPrioritySetupJobs$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m602invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m602invoke() {
                ArgusInitializer.this.initLynxHandler();
            }
        }});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getSecureConfig() {
        registerConfigListener();
        GeckoGlobalManager.inst().registerGecko(new ArgusSdkGeckoAppRegister());
        ArgusConfigManager.INSTANCE.getInstance().triggerGetOfflineConfig();
        ArgusConfigManager.INSTANCE.getInstance().triggerGetLatestConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initTTMachine() {
        if (ArgusEnv.INSTANCE.getInstance().getEnableTTM()) {
            ArgusTTMStrategyManagerWrapper.INSTANCE.getInstance().setup();
        }
    }

    private final List<Function0<Unit>> getLowPrioritySetupJobs() {
        return CollectionsKt.listOf(new Function0<Unit>() { // from class: com.bytedance.ies.argus.base.ArgusInitializer$getLowPrioritySetupJobs$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m603invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m603invoke() {
                PluginManager.INSTANCE.getInstance().setupPlugin();
                ArgusInitializer.this.initLoaderSecurityInterceptor();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initLynxHandler() {
        if (this.initConfig.getHostConfig().getCloseLynxVerify()) {
            ArgusLog.i$default(ArgusLog.INSTANCE, TAG, "init config force close lynx verify", null, 4, null);
        } else {
            LynxSecurityService.Companion.getINSTANCE().setSecurityDelegate(new ArgusLynxSecurityHandler());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initLoaderSecurityInterceptor() {
        GlobalInterceptor.INSTANCE.registerHook(new ForestInterceptor() { // from class: com.bytedance.ies.argus.base.ArgusInitializer$initLoaderSecurityInterceptor$1
            @Override // com.bytedance.forest.interceptor.ForestInterceptor
            public void onRequestCreated(Request request) {
                ArgusInitializer.ResourceType resourceType;
                LoadStaticResourceRewritePayload rewritePayload;
                Map<String, String> rewriteHeaders;
                Intrinsics.checkNotNullParameter(request, "request");
                String url = request.getUrl();
                Map<String, String> injectedHttpHeaders = request.getInjectedHttpHeaders();
                ArgusGlobalDelegate companion = ArgusGlobalDelegate.Companion.getInstance();
                Map<String, String> injectedHttpHeaders2 = request.getInjectedHttpHeaders();
                resourceType = ArgusInitializer.this.toResourceType(request.getScene());
                AspectVerifyResult<LoadStaticResourceRewritePayload> verifyLoadStaticResource = companion.verifyLoadStaticResource(new LoadStaticResourceParams(url, injectedHttpHeaders2, resourceType.getValue(), GeckoFetcher.GECKO_SDK_INVOKE_ASYNC_TAG));
                if (verifyLoadStaticResource.isRewrite() && (rewritePayload = verifyLoadStaticResource.getRewritePayload()) != null && (rewriteHeaders = rewritePayload.getRewriteHeaders()) != null) {
                    for (Map.Entry<String, String> entry : rewriteHeaders.entrySet()) {
                        injectedHttpHeaders.put(entry.getKey(), entry.getValue());
                    }
                }
                request.setUrl(ForceHttpsUtil.INSTANCE.forceToHttps(url));
            }
        });
        GlobalResourceInterceptor.INSTANCE.registerMonitor(new ResourceLoaderHooker() { // from class: com.bytedance.ies.argus.base.ArgusInitializer$initLoaderSecurityInterceptor$2
            public Uri hookUrl(String url, TaskConfig config) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(config, "config");
                return null;
            }

            public void onLoadFailed(ResourceInfo resInfo, TaskConfig taskConfig, Throwable e) {
                Intrinsics.checkNotNullParameter(resInfo, "resInfo");
                Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
                Intrinsics.checkNotNullParameter(e, "e");
            }

            public void onLoadSuccess(ResourceInfo resInfo, TaskConfig taskConfig) {
                Intrinsics.checkNotNullParameter(resInfo, "resInfo");
                Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
            }

            public void onLoadStart(ResourceInfo resInfo, TaskConfig taskConfig) {
                ArgusInitializer.ResourceType resourceType;
                Intrinsics.checkNotNullParameter(resInfo, "resInfo");
                Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
                String cdnUrl = taskConfig.getCdnUrl();
                if (cdnUrl.length() == 0) {
                    cdnUrl = ExtKt.getCDN$default(resInfo.getSrcUri(), (String) null, 1, (Object) null);
                }
                String str = cdnUrl;
                if (str == null) {
                    str = resInfo.getSrcUri().toString();
                    Intrinsics.checkNotNullExpressionValue(str, "resInfo.srcUri.toString()");
                }
                Map injectedHttpHeaders = taskConfig.getInjectedHttpHeaders();
                if (injectedHttpHeaders == null) {
                    injectedHttpHeaders = MapsKt.emptyMap();
                }
                ArgusGlobalDelegate companion = ArgusGlobalDelegate.Companion.getInstance();
                resourceType = ArgusInitializer.this.toResourceType(resInfo.getResTag());
                AspectVerifyResult<LoadStaticResourceRewritePayload> verifyLoadStaticResource = companion.verifyLoadStaticResource(new LoadStaticResourceParams(str, injectedHttpHeaders, resourceType.getValue(), "ResourceLoader"));
                if (verifyLoadStaticResource.isRewrite()) {
                    Map mutableMap = MapsKt.toMutableMap(injectedHttpHeaders);
                    LoadStaticResourceRewritePayload rewritePayload = verifyLoadStaticResource.getRewritePayload();
                    Map<String, String> rewriteHeaders = rewritePayload != null ? rewritePayload.getRewriteHeaders() : null;
                    if (rewriteHeaders != null) {
                        for (Map.Entry<String, String> entry : rewriteHeaders.entrySet()) {
                            mutableMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    taskConfig.setInjectedHttpHeaders(MapsKt.toMap(mutableMap));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResourceType toResourceType(Scene scene) {
        switch (WhenMappings.$EnumSwitchMapping$0[scene.ordinal()]) {
            case 1:
                return ResourceType.TEMPLATE;
            case 2:
                return ResourceType.HTML;
            case 3:
            case 4:
                return ResourceType.FILE;
            case 5:
                return ResourceType.IMAGE;
            case 6:
                return ResourceType.VIDEO;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return ResourceType.FILE;
            case 14:
                return ResourceType.OTHER;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        if (r2.equals("sub_resource") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return com.bytedance.ies.argus.base.ArgusInitializer.ResourceType.FILE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
    
        if (r2.equals("external_js") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return com.bytedance.ies.argus.base.ArgusInitializer.ResourceType.FILE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
    
        if (r2.equals("prefetch") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
    
        if (r2.equals("template") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
    
        if (r2.equals("component") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r2.equals("lynx") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:?, code lost:
    
        return com.bytedance.ies.argus.base.ArgusInitializer.ResourceType.TEMPLATE;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ResourceType toResourceType(String str) {
        switch (str.hashCode()) {
            case -1399907075:
                break;
            case -1321546630:
                break;
            case -1288666633:
                break;
            case -1153075651:
                break;
            case -159301843:
                break;
            case 117588:
                if (str.equals("web")) {
                    return ResourceType.HTML;
                }
                return ResourceType.OTHER;
            case 3337239:
                break;
            default:
                return ResourceType.OTHER;
        }
    }

    /* compiled from: ArgusInitializer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/argus/base/ArgusInitializer$ResourceType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TEMPLATE", "HTML", "IMAGE", "VIDEO", "FILE", "OTHER", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum ResourceType {
        TEMPLATE("template"),
        HTML("html"),
        IMAGE("img"),
        VIDEO("video"),
        FILE("file"),
        OTHER(PreloadConfig.KEY_OTHER);

        private final String value;

        ResourceType(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public final void init$anniex_release() {
        long currentTimeMillis = System.currentTimeMillis();
        ArgusLog.i$default(ArgusLog.INSTANCE, TAG, "init", null, 4, null);
        ArgusEnv.INSTANCE.getInstance().setInitConfig$anniex_release(this.initConfig);
        ArgusConfigManager.INSTANCE.getInstance().setup();
        ArgusLog.d$default(ArgusLog.INSTANCE, TAG, "init cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms", null, 4, null);
    }
}
