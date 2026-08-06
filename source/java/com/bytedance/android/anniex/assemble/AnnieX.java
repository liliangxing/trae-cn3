package com.bytedance.android.anniex.assemble;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.anniex.ability.AnnieXRouterService;
import com.bytedance.android.anniex.assemble.initialize.IAnnieXHostDepend;
import com.bytedance.android.anniex.base.builder.LitePageBuilder;
import com.bytedance.android.anniex.base.builder.PageBuilder;
import com.bytedance.android.anniex.base.builder.PopupBuilder;
import com.bytedance.android.anniex.base.builder.ViewBuilder;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.IPageContainer;
import com.bytedance.android.anniex.base.container.IPopupContainer;
import com.bytedance.android.anniex.base.container.IViewContainer;
import com.bytedance.android.anniex.base.container.holder.IDialogFragmentHolder;
import com.bytedance.android.anniex.base.container.holder.IDialogHolder;
import com.bytedance.android.anniex.base.container.holder.IFragmentHolder;
import com.bytedance.android.anniex.base.container.holder.IViewHolder;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.base.depend.AnnieXRuntimeBuilder;
import com.bytedance.android.anniex.base.monitor.IMonitorCenter;
import com.bytedance.android.anniex.base.monitor.MonitorCenter;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.base.service.AnnieXServiceProvider;
import com.bytedance.android.anniex.base.service.IAnnieXService;
import com.bytedance.android.anniex.container.AnnieXPageContainer;
import com.bytedance.android.anniex.container.AnnieXPopupContainer;
import com.bytedance.android.anniex.container.AnnieXViewContainer;
import com.bytedance.android.anniex.container.holder.AnnieXDialogFragmentHolder;
import com.bytedance.android.anniex.container.holder.AnnieXDialogHolder;
import com.bytedance.android.anniex.container.holder.AnnieXFragmentHolder;
import com.bytedance.android.anniex.container.holder.AnnieXViewHolder;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.lite.flow.AnnieXFlow;
import com.bytedance.android.anniex.lite.flow.base.FlowDispatchConfig;
import com.bytedance.android.anniex.lite.utils.AnnieXSettings;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.ies.bullet.base.InitializeConfig;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.redirect.AnnieXRedirectImplProcessor;
import com.bytedance.ies.bullet.redirect.api.IAnnieXRedirectProcessor;
import com.bytedance.ies.bullet.service.base.api.BaseServiceContext;
import com.bytedance.ies.bullet.service.base.api.BaseServiceToken;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.lynx.ILynxKitService;
import com.bytedance.ies.bullet.service.base.router.config.RouterOpenConfig;
import com.bytedance.ies.bullet.web.pia.PiaHelper;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieX.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0004J\u001f\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0002\b\u0019J\u001f\u0010\u001a\u001a\u00020\u001b2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0002\b\u0019J\u001f\u0010\u001d\u001a\u00020\u001e2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0002\b\u0019J\u001f\u0010 \u001a\u00020!2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0002\b\u0019J\u001f\u0010\"\u001a\u00020#2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0002\b\u0019J\u001f\u0010$\u001a\u00020%2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0002\b\u0019J\u001f\u0010'\u001a\u00020(2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0002\b\u0019J*\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100J\u000e\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u0004J\u000e\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+J\b\u00107\u001a\u00020\u000bH\u0007J.\u00108\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0:09j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0:`<J\u0010\u0010=\u001a\u0004\u0018\u00010;2\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010>\u001a\u00020?J\u000e\u0010@\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+J-\u0010A\u001a\u0004\u0018\u0001HB\"\b\b\u0000\u0010B*\u00020C2\u0006\u0010,\u001a\u00020\u00042\f\u0010D\u001a\b\u0012\u0004\u0012\u0002HB0E¢\u0006\u0002\u0010FJ\u000e\u0010G\u001a\u00020\u00182\u0006\u0010/\u001a\u00020HJ\u001f\u0010I\u001a\u00020\u00182\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0002\b\u0019J\b\u0010K\u001a\u00020\u000bH\u0007J\u0006\u0010L\u001a\u00020\u000bJ1\u0010M\u001a\u00020\u000b2\u0006\u00104\u001a\u0002052\u0006\u0010-\u001a\u00020.2\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0002\b\u0019J\u0006\u0010O\u001a\u00020\u000bJ\u0006\u0010P\u001a\u00020\u000bJ\u0018\u0010Q\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u00042\u0006\u0010R\u001a\u00020SH\u0007J\u0018\u0010T\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010U\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/bytedance/android/anniex/assemble/AnnieX;", "", "()V", "CONTAINER_VIEW_TYPE_CARD", "", "CONTAINER_VIEW_TYPE_PAGE", "CONTAINER_VIEW_TYPE_POPUP", "FLAG_ASYNC_LAYOUT", "", "FLAG_PRE_CREATE", "gForceLynxServiceToAnnieX", "", "Ljava/lang/Boolean;", "lockObj", "Ljava/lang/Object;", "redirectProcessor", "Lcom/bytedance/ies/bullet/redirect/api/IAnnieXRedirectProcessor;", "closeContainerById", "containerId", "createDialogHolder", "Lcom/bytedance/android/anniex/base/container/holder/IDialogHolder;", "block", "Lkotlin/Function1;", "Lcom/bytedance/android/anniex/base/builder/PopupBuilder;", "", "Lkotlin/ExtensionFunctionType;", "createFragmentHolder", "Lcom/bytedance/android/anniex/base/container/holder/IFragmentHolder;", "Lcom/bytedance/android/anniex/base/builder/PageBuilder;", "createFullScreenFragmentHolder", "Lcom/bytedance/android/anniex/base/container/holder/IDialogFragmentHolder;", "Lcom/bytedance/android/anniex/base/builder/LitePageBuilder;", "createPageContainer", "Lcom/bytedance/android/anniex/base/container/IPageContainer;", "createPopupContainer", "Lcom/bytedance/android/anniex/base/container/IPopupContainer;", "createViewContainer", "Lcom/bytedance/android/anniex/base/container/IViewContainer;", "Lcom/bytedance/android/anniex/base/builder/ViewBuilder;", "createViewHolder", "Lcom/bytedance/android/anniex/base/container/holder/IViewHolder;", "dispatchFlow", "application", "Landroid/app/Application;", "bid", StrategyConstants.SCHEMA, "Landroid/net/Uri;", "config", "Lcom/bytedance/android/anniex/lite/flow/base/FlowDispatchConfig;", "enablePia", StreamTrafficObservable.STREAM_URL, "ensureLynxInitialized", "context", "Landroid/content/Context;", "ensureRelaxInitialized", "forceLynxServiceToAnnieX", "getAllContainer", "Ljava/util/LinkedHashMap;", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/android/anniex/base/container/IContainer;", "Lkotlin/collections/LinkedHashMap;", "getContainerById", "getMonitorCenter", "Lcom/bytedance/android/anniex/base/monitor/IMonitorCenter;", "getRedirectProcessor", "getService", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/anniex/base/service/IAnnieXService;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Lcom/bytedance/android/anniex/base/service/IAnnieXService;", "init", "Lcom/bytedance/ies/bullet/base/InitializeConfig;", "initAnnieXRuntime", "Lcom/bytedance/android/anniex/base/depend/AnnieXRuntimeBuilder;", "isDebug", "isDouyinPaas", "open", "Lcom/bytedance/android/anniex/assemble/RouterOpenBuilder;", "optimizeBulletInit", "optimizeWebcastInit", "registerServiceProvider", "serviceProvider", "Lcom/bytedance/android/anniex/base/service/AnnieXServiceProvider;", "removeContainerById", "release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieX {
    public static final String CONTAINER_VIEW_TYPE_CARD = "card";
    public static final String CONTAINER_VIEW_TYPE_PAGE = "page";
    public static final String CONTAINER_VIEW_TYPE_POPUP = "popup";
    public static final int FLAG_ASYNC_LAYOUT = 2;
    public static final int FLAG_PRE_CREATE = 1;
    private static volatile Boolean gForceLynxServiceToAnnieX;
    private static IAnnieXRedirectProcessor redirectProcessor;
    public static final AnnieX INSTANCE = new AnnieX();
    private static final Object lockObj = new Object();

    private AnnieX() {
    }

    @Deprecated(message = "临时接口，只用于 HybridKit 下线逻辑")
    public final boolean forceLynxServiceToAnnieX() {
        Boolean bool = gForceLynxServiceToAnnieX;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = false;
        try {
            Class<?> cls = Class.forName("com.bytedance.android.anniex.assemble.initialize.impl.LynxServiceExperiment");
            Object invoke = cls.getMethod("forceLynxServiceToAnnieX", new Class[0]).invoke(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), new Object[0]);
            Boolean bool2 = invoke instanceof Boolean ? (Boolean) invoke : null;
            if (bool2 != null) {
                z = bool2.booleanValue();
            }
        } catch (Exception unused) {
        }
        gForceLynxServiceToAnnieX = Boolean.valueOf(z);
        return z;
    }

    public final void initAnnieXRuntime(Function1<? super AnnieXRuntimeBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        AnnieXRuntime annieXRuntime = AnnieXRuntime.INSTANCE;
        AnnieXRuntimeBuilder annieXRuntimeBuilder = new AnnieXRuntimeBuilder();
        block.invoke(annieXRuntimeBuilder);
        annieXRuntime.init(annieXRuntimeBuilder);
    }

    public final void init(InitializeConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        BulletSdk.INSTANCE.init(config);
    }

    @Deprecated(message = "容器不保证使用此方法注入的端能力一定会生效", replaceWith = @ReplaceWith(expression = "IAnnieXHostDepend.createServiceProvider", imports = {}))
    public final void registerServiceProvider(String bid, AnnieXServiceProvider serviceProvider) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
        AnnieXServiceCenter.INSTANCE.registerServiceProvider(bid, serviceProvider);
    }

    public final void ensureRelaxInitialized(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        IAnnieXHostDepend hostDepend = AnnieXRuntime.INSTANCE.getHostDepend();
        if (hostDepend != null) {
            hostDepend.initRelax(application);
        }
    }

    public final boolean optimizeBulletInit() {
        return AnnieXSettings.INSTANCE.getOptimizeBulletInit();
    }

    public final boolean optimizeWebcastInit() {
        return AnnieXSettings.INSTANCE.getOptimizeWebcastInit();
    }

    public final <T extends IAnnieXService> T getService(String bid, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) AnnieXServiceCenter.INSTANCE.getService(bid, clazz);
    }

    public final IFragmentHolder createFragmentHolder(Function1<? super PageBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        PageBuilder pageBuilder = new PageBuilder();
        block.invoke(pageBuilder);
        return new AnnieXFragmentHolder(pageBuilder);
    }

    public final IDialogHolder createDialogHolder(Function1<? super PopupBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        PopupBuilder popupBuilder = new PopupBuilder();
        block.invoke(popupBuilder);
        return new AnnieXDialogHolder(popupBuilder);
    }

    public final IDialogFragmentHolder createFullScreenFragmentHolder(Function1<? super LitePageBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        LitePageBuilder litePageBuilder = new LitePageBuilder();
        block.invoke(litePageBuilder);
        return new AnnieXDialogFragmentHolder(litePageBuilder);
    }

    public final IViewHolder createViewHolder(Function1<? super ViewBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ViewBuilder viewBuilder = new ViewBuilder();
        block.invoke(viewBuilder);
        return new AnnieXViewHolder(viewBuilder);
    }

    public final IPageContainer createPageContainer(Function1<? super PageBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        PageBuilder pageBuilder = new PageBuilder();
        block.invoke(pageBuilder);
        return new AnnieXPageContainer(pageBuilder);
    }

    public final IPopupContainer createPopupContainer(Function1<? super PopupBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        PopupBuilder popupBuilder = new PopupBuilder();
        block.invoke(popupBuilder);
        return new AnnieXPopupContainer(popupBuilder);
    }

    public final IViewContainer createViewContainer(Function1<? super ViewBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ViewBuilder viewBuilder = new ViewBuilder();
        block.invoke(viewBuilder);
        return new AnnieXViewContainer(viewBuilder);
    }

    public final boolean closeContainerById(String containerId) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        return AnnieXContainerManager.INSTANCE.closeContainerById(containerId);
    }

    public static /* synthetic */ boolean removeContainerById$default(AnnieX annieX, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return annieX.removeContainerById(str, z);
    }

    public final boolean removeContainerById(String containerId, boolean release) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        return AnnieXContainerManager.INSTANCE.removeContainerById(containerId, release);
    }

    public final IContainer getContainerById(String containerId) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        return AnnieXContainerManager.INSTANCE.getContainerById(containerId);
    }

    public final LinkedHashMap<String, WeakReference<IContainer>> getAllContainer() {
        LinkedHashMap<String, WeakReference<IContainer>> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, WeakReference<IContainer>> entry : AnnieXContainerManager.INSTANCE.getAllContainer().entrySet()) {
            IContainer iContainer = entry.getValue().get();
            if (iContainer != null) {
                linkedHashMap.put(entry.getKey(), new WeakReference<>(iContainer));
            }
        }
        return linkedHashMap;
    }

    public final void ensureLynxInitialized(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HybridLogger.i$default(HybridLogger.INSTANCE, "XInit", "call ensureLynxInitialized", (Map) null, (LoggerContext) null, 12, (Object) null);
        if (!BulletSdk.INSTANCE.isDefaultBidReady()) {
            synchronized (this) {
                if (!BulletSdk.INSTANCE.isDefaultBidReady()) {
                    BulletSdk.INSTANCE.ensureDefaultBidReady(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        ILynxKitService iLynxKitService = ServiceCenter.Companion.instance().get(ILynxKitService.class);
        if (iLynxKitService != null) {
            HybridLogger.i$default(HybridLogger.INSTANCE, "XInit", "call initKit", (Map) null, (LoggerContext) null, 12, (Object) null);
            if (iLynxKitService.ready()) {
                return;
            }
            iLynxKitService.initKit(new BaseServiceToken("default_bid", new BaseServiceContext(BulletEnv.Companion.getInstance().getApplication(), BulletEnv.Companion.getInstance().getDebuggable())));
        }
    }

    public final boolean enablePia(String url) {
        Intrinsics.checkNotNullParameter(url, StreamTrafficObservable.STREAM_URL);
        return PiaHelper.INSTANCE.support(url);
    }

    public final IAnnieXRedirectProcessor getRedirectProcessor(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        if (redirectProcessor == null) {
            synchronized (lockObj) {
                if (redirectProcessor == null) {
                    BulletSdk.INSTANCE.ensureDefaultBidReady(application);
                    redirectProcessor = new AnnieXRedirectImplProcessor();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        IAnnieXRedirectProcessor iAnnieXRedirectProcessor = redirectProcessor;
        Intrinsics.checkNotNull(iAnnieXRedirectProcessor);
        return iAnnieXRedirectProcessor;
    }

    public final IMonitorCenter getMonitorCenter() {
        return MonitorCenter.INSTANCE.instance();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean open$default(AnnieX annieX, Context context, Uri uri, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1<RouterOpenBuilder, Unit>() { // from class: com.bytedance.android.anniex.assemble.AnnieX$open$1
                public final void invoke(RouterOpenBuilder routerOpenBuilder) {
                    Intrinsics.checkNotNullParameter(routerOpenBuilder, "$this$null");
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((RouterOpenBuilder) obj2);
                    return Unit.INSTANCE;
                }
            };
        }
        return annieX.open(context, uri, function1);
    }

    public final boolean open(Context context, Uri schema, Function1<? super RouterOpenBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(block, "block");
        String queryParameter = schema.getQueryParameter("bid");
        if (queryParameter == null) {
            queryParameter = "default_bid";
        }
        BulletSdk.INSTANCE.ensureDefaultBidReady(context);
        return AnnieXRouterService.INSTANCE.open(context, schema, new RouterOpenConfig(), queryParameter);
    }

    public static /* synthetic */ String dispatchFlow$default(AnnieX annieX, Application application, String str, Uri uri, FlowDispatchConfig flowDispatchConfig, int i, Object obj) {
        if ((i & 8) != 0) {
            flowDispatchConfig = null;
        }
        return annieX.dispatchFlow(application, str, uri, flowDispatchConfig);
    }

    public final String dispatchFlow(Application application, String bid, Uri schema, FlowDispatchConfig config) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        return AnnieXFlow.INSTANCE.dispatchFlow$anniex_release(application, bid, schema, config);
    }

    @JvmStatic
    public static final boolean isDebug() {
        return AnnieXRuntime.INSTANCE.getApplicationDepend().isDebug();
    }

    public final boolean isDouyinPaas() {
        return AnnieXRuntime.INSTANCE.getApplicationDepend().isDouyinPaas();
    }
}
