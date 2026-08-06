package com.bytedance.android.anniex.container.popup;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import coil3.disk.DiskLruCache;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.base.builder.PopupBuilder;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.holder.IDialogHolder;
import com.bytedance.android.anniex.base.container.listener.AnnieXDialogListener;
import com.bytedance.android.anniex.base.service.IAnnieXPopupService;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.framwork.core.sdklib.MonitorCommonConstants;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IPreRenderCallback;
import com.bytedance.ies.bullet.service.base.IPreRenderService;
import com.bytedance.ies.bullet.service.base.IPreRenderServiceWithBundle;
import com.bytedance.ies.bullet.service.base.PoolResult;
import com.bytedance.ies.bullet.service.base.api.IBulletUIComponent;
import com.bytedance.ies.bullet.service.base.api.IBulletUILifecycleListener;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.api.UIShowConfig;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.popup.PopupFragmentConfig;
import com.bytedance.ies.bullet.service.schema.utils.SchemaUtilsKt;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.lynx.tasm.LynxViewClient;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXPopUpService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/AnnieXPopUpService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/android/anniex/base/service/IAnnieXPopupService;", "()V", "activityLifeCycleCallBacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "config", "Lcom/bytedance/ies/bullet/service/base/api/UIShowConfig;", "showNext", "", "appendViewCacheKeyIfNeed", "Landroid/net/Uri;", StrategyConstants.SCHEMA, "sessionId", "", "show", "context", "Landroid/content/Context;", "schemaOrigin", "showInner", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXPopUpService extends BaseBulletService implements IAnnieXPopupService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EVENT_PAGE_READY = "pageReady";
    private static final String POPUP_CREATE_FAILED_MSG = "create popup container failed";
    private static final String POPUP_CREATE_SUCCESS_MSG = "create popup container successfully";
    private Application.ActivityLifecycleCallbacks activityLifeCycleCallBacks;
    private volatile UIShowConfig config;
    private volatile boolean showNext;

    /* compiled from: AnnieXPopUpService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/AnnieXPopUpService$Companion;", "", "()V", "EVENT_PAGE_READY", "", "POPUP_CREATE_FAILED_MSG", "POPUP_CREATE_SUCCESS_MSG", "getAnnieXPopupContainer", "Lcom/bytedance/android/anniex/base/container/IContainer;", "containerId", "getAnnieXPopupContainer$anniex_release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IContainer getAnnieXPopupContainer$anniex_release(String containerId) {
            Intrinsics.checkNotNullParameter(containerId, "containerId");
            return AnnieXContainerManager.INSTANCE.getContainerById(containerId);
        }
    }

    public boolean show(final Context context, Uri schemaOrigin, final UIShowConfig config) {
        IPreRenderServiceWithBundle iPreRenderServiceWithBundle;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemaOrigin, "schemaOrigin");
        Intrinsics.checkNotNullParameter(config, "config");
        final Uri appendViewCacheKeyIfNeed = appendViewCacheKeyIfNeed(schemaOrigin, config.getSessionId());
        final PopupFragmentConfig popupFragmentConfig = new PopupFragmentConfig(getBid(), appendViewCacheKeyIfNeed, config.getBundle(), context);
        final LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(MonitorCommonConstants.KEY_SESSION_ID, config.getSessionId());
        loggerContext.pushStage("callId", config.getCallId());
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("isScanOpen", Boolean.valueOf(popupFragmentConfig.isScanOpen()));
        pairArr[1] = TuplesKt.to("isDelayOpen", Boolean.valueOf(popupFragmentConfig.isDelayOpen()));
        boolean z = context instanceof Activity;
        Activity activity = z ? (Activity) context : null;
        pairArr[2] = TuplesKt.to("isActivityFinish", Boolean.valueOf(activity != null && activity.isFinishing()));
        pairArr[3] = TuplesKt.to("isShowOnSuccess", Boolean.valueOf(popupFragmentConfig.showOnSuccess()));
        hybridLogger.i("XPopup", "popup service show", MapsKt.mapOf(pairArr), loggerContext);
        if (!popupFragmentConfig.isScanOpen() && !popupFragmentConfig.isDelayOpen()) {
            Activity activity2 = z ? (Activity) context : null;
            if (!(activity2 != null && activity2.isFinishing())) {
                if (popupFragmentConfig.showOnSuccess() && (iPreRenderServiceWithBundle = (IPreRenderService) StandardServiceManager.INSTANCE.get(getBid(), IPreRenderService.class)) != null) {
                    IPreRenderServiceWithBundle iPreRenderServiceWithBundle2 = iPreRenderServiceWithBundle instanceof IPreRenderServiceWithBundle ? iPreRenderServiceWithBundle : null;
                    if (iPreRenderServiceWithBundle2 == null) {
                        IBulletUILifecycleListener lifecycleListener = config.getLifecycleListener();
                        if (lifecycleListener != null) {
                            lifecycleListener.onLoadFailed((IBulletUIComponent) null, new RuntimeException("invalid IPreRenderServiceWithBundle"));
                        }
                        return false;
                    }
                    HybridLogger.INSTANCE.i("XRouter", "popup with show_on_success, start preRender", MapsKt.mapOf(TuplesKt.to(StrategyConstants.SCHEMA, appendViewCacheKeyIfNeed.toString())), loggerContext);
                    iPreRenderServiceWithBundle2.preRender(appendViewCacheKeyIfNeed, config.getBundle(), context, new IPreRenderCallback() { // from class: com.bytedance.android.anniex.container.popup.AnnieXPopUpService$show$2$1
                        public void onSuccess(String sessinId) {
                            Intrinsics.checkNotNullParameter(sessinId, "sessinId");
                            HybridLogger.INSTANCE.i("XRouter", "popup with show_on_success, preRender success", MapsKt.mapOf(TuplesKt.to(StrategyConstants.SCHEMA, appendViewCacheKeyIfNeed.toString())), loggerContext);
                            Context context2 = context;
                            Activity activity3 = context2 instanceof Activity ? (Activity) context2 : null;
                            boolean z2 = false;
                            if (activity3 != null && activity3.isFinishing()) {
                                z2 = true;
                            }
                            if (z2) {
                                IBulletUILifecycleListener lifecycleListener2 = config.getLifecycleListener();
                                if (lifecycleListener2 != null) {
                                    lifecycleListener2.onLoadFailed((IBulletUIComponent) null, new ActivityFinishedException());
                                    return;
                                }
                                return;
                            }
                            final Uri uri = appendViewCacheKeyIfNeed;
                            final LoggerContext loggerContext2 = loggerContext;
                            final PopupFragmentConfig popupFragmentConfig2 = popupFragmentConfig;
                            final AnnieXPopUpService annieXPopUpService = this;
                            final Context context3 = context;
                            final UIShowConfig uIShowConfig = config;
                            EventCenter.registerJsEventSubscriber("pageReady", new JsEventSubscriber() { // from class: com.bytedance.android.anniex.container.popup.AnnieXPopUpService$show$2$1$onSuccess$2
                                public void onReceiveJsEvent(Js2NativeEvent jsEvent) {
                                    String str;
                                    Intrinsics.checkNotNullParameter(jsEvent, "jsEvent");
                                    XReadableMap params = jsEvent.getParams();
                                    if (params == null || (str = params.getString("code")) == null) {
                                        str = "0";
                                    }
                                    HybridLogger.INSTANCE.i("XRouter", "popup with show_on_success, receive pageReady event", MapsKt.mapOf(new Pair[]{TuplesKt.to(StrategyConstants.SCHEMA, uri.toString()), TuplesKt.to("code", str)}), loggerContext2);
                                    if (Intrinsics.areEqual(DiskLruCache.VERSION, str)) {
                                        popupFragmentConfig2.getBundle().putString("prerender", DiskLruCache.VERSION);
                                        annieXPopUpService.showInner(context3, uri, uIShowConfig);
                                    }
                                    EventCenter.unregisterJsEventSubscriber("pageReady", this);
                                }
                            }, sessinId);
                        }

                        public void onFailed(PoolResult result, String errorMsg) {
                            Intrinsics.checkNotNullParameter(result, StrategyConstants.RESULT);
                            HybridLogger hybridLogger2 = HybridLogger.INSTANCE;
                            Pair[] pairArr2 = new Pair[2];
                            pairArr2[0] = TuplesKt.to("errorMsg", errorMsg == null ? "" : errorMsg);
                            pairArr2[1] = TuplesKt.to(StrategyConstants.SCHEMA, appendViewCacheKeyIfNeed.toString());
                            hybridLogger2.i("XRouter", "popup with show_on_success, preRender failed", MapsKt.mapOf(pairArr2), loggerContext);
                            IBulletUILifecycleListener lifecycleListener2 = config.getLifecycleListener();
                            if (lifecycleListener2 != null) {
                                lifecycleListener2.onLoadFailed((IBulletUIComponent) null, new PreRenderFailedException(errorMsg));
                            }
                        }
                    });
                    return true;
                }
                return showInner(context, appendViewCacheKeyIfNeed, config);
            }
        }
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "lazy show " + appendViewCacheKeyIfNeed, (LogLevel) null, "XPopup", 2, (Object) null);
        Context applicationContext = context.getApplicationContext();
        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application == null) {
            HybridLogger.INSTANCE.e("XRouter", POPUP_CREATE_FAILED_MSG, MapsKt.mapOf(new Pair[]{TuplesKt.to("reason", "application is null"), TuplesKt.to(StrategyConstants.SCHEMA, appendViewCacheKeyIfNeed.toString())}), loggerContext);
            return false;
        }
        this.showNext = true;
        this.config = config;
        if (this.activityLifeCycleCallBacks == null) {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.android.anniex.container.popup.AnnieXPopUpService$show$1$1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity3, Bundle savedInstanceState) {
                    Intrinsics.checkNotNullParameter(activity3, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity3) {
                    Intrinsics.checkNotNullParameter(activity3, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity3) {
                    Intrinsics.checkNotNullParameter(activity3, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity3, Bundle outState) {
                    Intrinsics.checkNotNullParameter(activity3, "activity");
                    Intrinsics.checkNotNullParameter(outState, "outState");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity3) {
                    Intrinsics.checkNotNullParameter(activity3, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity3) {
                    Intrinsics.checkNotNullParameter(activity3, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity3) {
                    boolean z2;
                    UIShowConfig uIShowConfig;
                    Intrinsics.checkNotNullParameter(activity3, "activity");
                    z2 = AnnieXPopUpService.this.showNext;
                    if (z2) {
                        uIShowConfig = AnnieXPopUpService.this.config;
                        if (uIShowConfig != null) {
                            AnnieXPopUpService.this.showInner(activity3, appendViewCacheKeyIfNeed, uIShowConfig);
                        }
                        AnnieXPopUpService.this.showNext = false;
                        AnnieXPopUpService.this.config = null;
                    }
                }
            };
            this.activityLifeCycleCallBacks = activityLifecycleCallbacks;
            application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        HybridLogger.INSTANCE.i("XRouter", POPUP_CREATE_SUCCESS_MSG, MapsKt.mapOf(TuplesKt.to(StrategyConstants.SCHEMA, appendViewCacheKeyIfNeed.toString())), loggerContext);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean showInner(final Context context, Uri schema, UIShowConfig config) {
        Object obj;
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(MonitorCommonConstants.KEY_SESSION_ID, config.getSessionId());
        loggerContext.pushStage("callId", config.getCallId());
        HybridLogger.INSTANCE.i("XPopup", "PopUpService showInner", MapsKt.mapOf(TuplesKt.to(StrategyConstants.SCHEMA, schema.toString())), loggerContext);
        if ((context instanceof FragmentActivity ? (FragmentActivity) context : null) == null) {
            HybridLogger.INSTANCE.i("XPopup", POPUP_CREATE_FAILED_MSG, MapsKt.mapOf(new Pair[]{TuplesKt.to("reason", "fragmentActivity is null"), TuplesKt.to(StrategyConstants.SCHEMA, schema.toString())}), loggerContext);
            IBulletUILifecycleListener lifecycleListener = config.getLifecycleListener();
            if (lifecycleListener != null) {
                lifecycleListener.onLoadFailed((IBulletUIComponent) null, new NonFragmentActivityException());
            }
            if (BulletEnv.Companion.getInstance().getDebuggable()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.android.anniex.container.popup.AnnieXPopUpService$showInner$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Toast.makeText(context, "popup show with non-act", 0).show();
                    }
                });
            }
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            IDialogHolder createDialogHolder = AnnieX.INSTANCE.createDialogHolder(new Function1<PopupBuilder, Unit>() { // from class: com.bytedance.android.anniex.container.popup.AnnieXPopUpService$showInner$3$dialogHolder$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((PopupBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(PopupBuilder popupBuilder) {
                    Intrinsics.checkNotNullParameter(popupBuilder, "$this$createDialogHolder");
                    popupBuilder.fragmentActivity((FragmentActivity) context);
                    popupBuilder.listener(new AnnieXDialogListener());
                    popupBuilder.lynxViewClient(new LynxViewClient() { // from class: com.bytedance.android.anniex.container.popup.AnnieXPopUpService$showInner$3$dialogHolder$1.1
                    });
                    popupBuilder.webViewClient(new WebViewClient() { // from class: com.bytedance.android.anniex.container.popup.AnnieXPopUpService$showInner$3$dialogHolder$1.2
                    });
                    popupBuilder.bid(this.getBid());
                }
            });
            String uri = schema.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "schema.toString()");
            createDialogHolder.loadSchema(uri);
            IDialogHolder.DefaultImpls.show$default(createDialogHolder, null, 1, null);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return Result.isSuccess-impl(obj);
    }

    private final Uri appendViewCacheKeyIfNeed(Uri schema, String sessionId) {
        BulletContext context = BulletContextManager.Companion.getInstance().getContext(sessionId);
        if (context == null || !Intrinsics.areEqual(new BooleanParam(context.getSchemaModelUnion().getSchemaData(), "show_on_success", false).getValue(), true) || SchemaUtilsKt.getQueryParameterSafely(schema, "view_cache_key") != null) {
            return schema;
        }
        Uri build = schema.buildUpon().appendQueryParameter("view_cache_key", UUID.randomUUID().toString()).build();
        Intrinsics.checkNotNullExpressionValue(build, "schema.buildUpon()\n     …                 .build()");
        return build;
    }
}
