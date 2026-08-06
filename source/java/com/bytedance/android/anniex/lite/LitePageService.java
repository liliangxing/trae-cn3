package com.bytedance.android.anniex.lite;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.FragmentActivity;
import bolts.Task;
import com.bytedance.android.anniex.ability.service.IAnnieXLifecycleConfigService;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.base.builder.LitePageBuilder;
import com.bytedance.android.anniex.base.builder.PopupBuilder;
import com.bytedance.android.anniex.base.container.holder.IDialogFragmentHolder;
import com.bytedance.android.anniex.base.container.holder.IDialogHolder;
import com.bytedance.android.anniex.base.container.listener.AnnieXDialogListener;
import com.bytedance.android.anniex.base.container.listener.AnnieXFragmentListener;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.base.service.IAnnieXService;
import com.bytedance.android.anniex.container.p025ui.AnnieXDefaultActivity;
import com.bytedance.android.anniex.container.p025ui.AnnieXPageService;
import com.bytedance.android.anniex.lite.base.IAnnieXHostActivityService;
import com.bytedance.android.anniex.lite.base.IAnnieXLynxProcess;
import com.bytedance.android.anniex.lite.base.ILitePageService;
import com.bytedance.android.anniex.lite.config.LitePageConfig;
import com.bytedance.android.anniex.lite.flow.base.FlowDispatchConfig;
import com.bytedance.android.anniex.lite.flow.web.AnnieXWebDispatchManagerKt;
import com.bytedance.android.anniex.lite.utils.AnnieXLiteUtilsKt;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.utils.AnnieXConstants;
import com.bytedance.android.anniex.utils.AnnieXUrlExtKt;
import com.bytedance.android.anniex.utils.IAnnieXLatchService;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.framwork.core.sdklib.MonitorCommonConstants;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IRouterAbilityProvider;
import com.bytedance.ies.bullet.service.base.api.IBulletUIComponent;
import com.bytedance.ies.bullet.service.base.api.UIShowConfig;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.popup.NonFragmentActivityException;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
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

/* compiled from: LitePageService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\f\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0002J0\u0010\u0018\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J0\u0010\u001e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J0\u0010\u001f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J(\u0010 \u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J2\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/android/anniex/lite/LitePageService;", "Lcom/bytedance/android/anniex/lite/base/ILitePageService;", "()V", "activityLifeCycleCallBacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "config", "Lcom/bytedance/ies/bullet/service/base/api/UIShowConfig;", "litePageConfig", "Lcom/bytedance/android/anniex/lite/config/LitePageConfig;", "showNext", "", "getContextName", "", "context", "Landroid/content/Context;", "getStartActivity", "Ljava/lang/Class;", "isNeedDelayOpen", "isOpenWithReplace", "markOpenTime", "", "bundle", "Landroid/os/Bundle;", "sessionId", "openFlowActivity", "bid", StrategyConstants.SCHEMA, "Landroid/net/Uri;", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "openFlowDialog", "openLiteFragment", "show", "showInner", "useFlow", "isFromScan", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LitePageService implements ILitePageService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<AnnieXLiteFragment> dialogFragmentStack = new ArrayList();
    private Application.ActivityLifecycleCallbacks activityLifeCycleCallBacks;
    private volatile UIShowConfig config;
    private volatile LitePageConfig litePageConfig;
    private volatile boolean showNext;

    /* compiled from: LitePageService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KitType.values().length];
            try {
                iArr[KitType.WEB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KitType.LYNX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: LitePageService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/anniex/lite/LitePageService$Companion;", "", "()V", "dialogFragmentStack", "", "Lcom/bytedance/android/anniex/lite/AnnieXLiteFragment;", "destroyBulletPopup", "", "dialogFragment", "getLitePageByContainer", "Lcom/bytedance/ies/bullet/service/base/IRouterAbilityProvider;", "containerId", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IRouterAbilityProvider getLitePageByContainer(String containerId) {
            Object obj;
            Intrinsics.checkNotNullParameter(containerId, "containerId");
            Iterator it = LitePageService.dialogFragmentStack.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((AnnieXLiteFragment) obj).getContainerId(), containerId)) {
                    break;
                }
            }
            return (IRouterAbilityProvider) obj;
        }

        public final void destroyBulletPopup(AnnieXLiteFragment dialogFragment) {
            Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
            LitePageService.dialogFragmentStack.remove(dialogFragment);
        }
    }

    @Override // com.bytedance.android.anniex.lite.base.ILitePageService
    public boolean show(Context context, String bid, Uri schema, UIShowConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(config, "config");
        if (LitePageSwitch.INSTANCE.isHDTLitePageDisabled$anniex_release()) {
            return false;
        }
        BulletSdk.INSTANCE.ensureDefaultBidReady(context);
        markOpenTime(config.getBundle(), config.getSessionId());
        SLMonitorCompat.INSTANCE.reportPV(config.getSessionId(), schema, SLMonitorCompat.ViewType.Page.getValue());
        String string = config.getBundle().getString(AnnieXConstants.ANNIEX_POPUP_TYPE_OPT);
        Pair pair = string != null ? new Pair(true, string) : new Pair(false, config.getBundle().getString(AnnieXConstants.ANNIEX_PAGE_TYPE_OPT));
        boolean booleanValue = ((Boolean) pair.component1()).booleanValue();
        String str = (String) pair.component2();
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -766138496) {
                if (hashCode == 3146030 && str.equals(AnnieXConstants.FLOW)) {
                    if (booleanValue) {
                        MonitorManager.INSTANCE.onContainerCreateBegin(bid, config.getSessionId(), AnnieXConstants.ANNIE_X_FLOW_POPUP);
                    } else {
                        MonitorManager.INSTANCE.onContainerCreateBegin(bid, config.getSessionId(), AnnieXConstants.ANNIE_X_FLOW_PAGE);
                    }
                }
            } else if (str.equals(AnnieXConstants.LITE_PAGE)) {
                MonitorManager.INSTANCE.onContainerCreateBegin(bid, config.getSessionId(), AnnieXConstants.ANNIE_X_LITE_PAGE);
            }
        }
        String sessionId = config.getSessionId();
        FlowDispatchConfig flowDispatchConfig = new FlowDispatchConfig();
        flowDispatchConfig.setBundle(config.getBundle());
        flowDispatchConfig.setInterceptors(config.getInterceptors());
        Unit unit = Unit.INSTANCE;
        SchemaModelUnion annieXSchemaModelUnion = AnnieXLiteUtilsKt.getAnnieXSchemaModelUnion(bid, schema, sessionId, flowDispatchConfig);
        if (str != null) {
            int hashCode2 = str.hashCode();
            if (hashCode2 != -766138496) {
                if (hashCode2 == 3146030 && str.equals(AnnieXConstants.FLOW)) {
                    if (booleanValue) {
                        return openFlowDialog(context, bid, schema, annieXSchemaModelUnion, config);
                    }
                    return openFlowActivity(context, bid, schema, annieXSchemaModelUnion, config);
                }
            } else if (str.equals(AnnieXConstants.LITE_PAGE)) {
                if (openLiteFragment(context, bid, schema, annieXSchemaModelUnion, config)) {
                    return true;
                }
                if (AnnieXUrlExtKt.enableSwitchFowPage(schema)) {
                    return openFlowActivity(context, bid, schema, annieXSchemaModelUnion, config);
                }
                return false;
            }
        }
        MonitorManager.INSTANCE.onContainerError$anniex_release(bid, config.getSessionId(), AbsBulletMonitorCallback.ErrStage.Container, "error_flow_schema_parse");
        return false;
    }

    private final boolean openLiteFragment(final Context context, final String bid, final Uri schema, SchemaModelUnion schemaModelUnion, final UIShowConfig config) {
        IAnnieXLynxProcess iAnnieXLynxProcess;
        LitePageConfig litePageConfig = new LitePageConfig(bid, schema, config);
        boolean isNeedDelayOpen = isNeedDelayOpen(litePageConfig);
        if (isOpenWithReplace(litePageConfig)) {
            MonitorManager.INSTANCE.onContainerError$anniex_release(bid, config.getSessionId(), AbsBulletMonitorCallback.ErrStage.Container, "jsb_open_with_replace");
            return false;
        }
        IAnnieXHostActivityService iAnnieXHostActivityService = (IAnnieXHostActivityService) AnnieX.INSTANCE.getService(bid, IAnnieXHostActivityService.class);
        if (((iAnnieXHostActivityService == null || iAnnieXHostActivityService.isTopResumeActivity(context)) ? false : true) && !isNeedDelayOpen) {
            MonitorManager.INSTANCE.onContainerError$anniex_release(bid, config.getSessionId(), AbsBulletMonitorCallback.ErrStage.Container, "not_in_top_and_without_delay_open");
            return false;
        }
        Uri parse = Uri.parse((String) schemaModelUnion.getSchemaData().getQueryItems().get(StreamTrafficObservable.STREAM_URL));
        if (parse == null) {
            parse = schema;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[AnnieXLiteUtilsKt.getKitTypeFromSchema(parse).ordinal()];
        if (i == 1) {
            AnnieXProcessCenter.INSTANCE.preCreateWebModel(bid, config.getSessionId(), parse);
        } else if (i == 2) {
            AnnieX.INSTANCE.ensureLynxInitialized(context);
            String safeGetQueryParameter = ExtKt.safeGetQueryParameter(parse, "ssr_url");
            if ((safeGetQueryParameter == null || safeGetQueryParameter.length() == 0) && (iAnnieXLynxProcess = (IAnnieXLynxProcess) AnnieXServiceCenter.INSTANCE.getService(bid, IAnnieXLynxProcess.class)) != null) {
                iAnnieXLynxProcess.preCreateLynxModel(bid, config.getSessionId(), parse);
            }
            IAnnieXLatchService iAnnieXLatchService = (IAnnieXLatchService) AnnieX.INSTANCE.getService(bid, IAnnieXLatchService.class);
            if (iAnnieXLatchService != null && iAnnieXLatchService.isEnableLatch(schema)) {
                Task.callInBackground(new Callable() { // from class: com.bytedance.android.anniex.lite.LitePageService$openLiteFragment$1
                    @Override // java.util.concurrent.Callable
                    public final Unit call() {
                        IAnnieXLatchService iAnnieXLatchService2 = (IAnnieXLatchService) AnnieX.INSTANCE.getService(bid, IAnnieXLatchService.class);
                        if (iAnnieXLatchService2 == null) {
                            return null;
                        }
                        iAnnieXLatchService2.handlePrefetch(context, schema, config.getSessionId(), true);
                        return Unit.INSTANCE;
                    }
                });
            }
        }
        if (!isNeedDelayOpen) {
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (!(activity != null && activity.isFinishing())) {
                return showInner$default(this, false, context, bid, config, false, 16, null);
            }
        }
        Context applicationContext = context.getApplicationContext();
        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application == null) {
            MonitorManager.INSTANCE.onContainerError$anniex_release(bid, config.getSessionId(), AbsBulletMonitorCallback.ErrStage.Container, "application_is_null");
            return false;
        }
        this.showNext = true;
        this.litePageConfig = litePageConfig;
        this.config = config;
        if (this.activityLifeCycleCallBacks == null) {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.android.anniex.lite.LitePageService$openLiteFragment$2$1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity2, Bundle savedInstanceState) {
                    Intrinsics.checkNotNullParameter(activity2, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity2) {
                    Intrinsics.checkNotNullParameter(activity2, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity2) {
                    Intrinsics.checkNotNullParameter(activity2, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity2, Bundle outState) {
                    Intrinsics.checkNotNullParameter(activity2, "activity");
                    Intrinsics.checkNotNullParameter(outState, "outState");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity2) {
                    Intrinsics.checkNotNullParameter(activity2, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity2) {
                    Intrinsics.checkNotNullParameter(activity2, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity2) {
                    boolean z;
                    LitePageConfig litePageConfig2;
                    UIShowConfig uIShowConfig;
                    Intrinsics.checkNotNullParameter(activity2, "activity");
                    z = LitePageService.this.showNext;
                    if (z) {
                        litePageConfig2 = LitePageService.this.litePageConfig;
                        if (litePageConfig2 != null) {
                            LitePageService litePageService = LitePageService.this;
                            String str = bid;
                            uIShowConfig = litePageService.config;
                            if (uIShowConfig != null) {
                                litePageService.showInner(false, activity2, str, uIShowConfig, true);
                            }
                        }
                        LitePageService.this.showNext = false;
                        LitePageService.this.litePageConfig = null;
                        LitePageService.this.config = null;
                    }
                }
            };
            this.activityLifeCycleCallBacks = activityLifecycleCallbacks;
            application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        return true;
    }

    private final boolean openFlowActivity(Context context, String bid, Uri schema, SchemaModelUnion schemaModelUnion, UIShowConfig config) {
        boolean z;
        Integer requestCode;
        Unit unit;
        Uri parse = Uri.parse((String) schemaModelUnion.getSchemaData().getQueryItems().get(StreamTrafficObservable.STREAM_URL));
        if (parse == null) {
            parse = schema;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[AnnieXLiteUtilsKt.getKitTypeFromSchema(parse).ordinal()];
        if (i == 1) {
            AnnieXWebDispatchManagerKt.dispatchWebFlow(bid, config.getSessionId(), parse);
        } else if (i == 2) {
            AnnieX.INSTANCE.ensureLynxInitialized(context);
            IAnnieXLynxProcess iAnnieXLynxProcess = (IAnnieXLynxProcess) AnnieXServiceCenter.INSTANCE.getService(bid, IAnnieXLynxProcess.class);
            if (iAnnieXLynxProcess != null) {
                iAnnieXLynxProcess.dispatchFlow(bid, config.getSessionId(), parse);
            }
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, getStartActivity()));
        intent.setData(schema);
        boolean z2 = context instanceof Activity;
        if (!z2) {
            intent.addFlags(268435456);
        }
        Integer flags = config.getFlags();
        if (flags != null) {
            intent.addFlags(flags.intValue());
        }
        config.getBundle().putString(AnnieXPageService.BUNDLE_ANNIEX_BID, bid);
        config.getBundle().putBoolean(AnnieXPageService.BUNDLE_ANNIE_X_FLOW, true);
        intent.putExtras(config.getBundle());
        Unit unit2 = null;
        if (!z2 || (requestCode = config.getRequestCode()) == null) {
            z = false;
        } else {
            int intValue = requestCode.intValue();
            Bundle animationBundle = config.getAnimationBundle();
            if (animationBundle != null) {
                ((Activity) context).startActivityForResult(intent, intValue, animationBundle);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                ((Activity) context).startActivityForResult(intent, intValue);
            }
            z = true;
        }
        if (!z) {
            Bundle animationBundle2 = config.getAnimationBundle();
            if (animationBundle2 != null) {
                context.startActivity(intent, animationBundle2);
                unit2 = Unit.INSTANCE;
            }
            if (unit2 == null) {
                context.startActivity(intent);
            }
        }
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        Map mapOf = MapsKt.mapOf(TuplesKt.to(StreamTrafficObservable.STREAM_URL, schema.toString()));
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(MonitorCommonConstants.KEY_SESSION_ID, config.getSessionId());
        loggerContext.pushStage("callId", config.getCallId());
        Unit unit3 = Unit.INSTANCE;
        hybridLogger.i("XRouter", "create page container successfully", mapOf, loggerContext);
        return true;
    }

    private final boolean openFlowDialog(Context context, final String bid, Uri schema, SchemaModelUnion schemaModelUnion, UIShowConfig config) {
        Uri parse = Uri.parse((String) schemaModelUnion.getSchemaData().getQueryItems().get(StreamTrafficObservable.STREAM_URL));
        if (parse == null) {
            parse = schema;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[AnnieXLiteUtilsKt.getKitTypeFromSchema(parse).ordinal()];
        if (i == 1) {
            AnnieXWebDispatchManagerKt.dispatchWebFlow(bid, config.getSessionId(), parse);
        } else if (i == 2) {
            AnnieX.INSTANCE.ensureLynxInitialized(context);
            IAnnieXLynxProcess iAnnieXLynxProcess = (IAnnieXLynxProcess) AnnieXServiceCenter.INSTANCE.getService(bid, IAnnieXLynxProcess.class);
            if (iAnnieXLynxProcess != null) {
                iAnnieXLynxProcess.dispatchFlow(bid, config.getSessionId(), parse);
            }
        }
        config.getBundle().putString(AnnieXPageService.BUNDLE_ANNIEX_BID, bid);
        config.getBundle().putBoolean(AnnieXPageService.BUNDLE_ANNIE_X_FLOW, true);
        LitePageConfig litePageConfig = new LitePageConfig(bid, schema, config);
        boolean isNeedDelayOpen = isNeedDelayOpen(litePageConfig);
        IAnnieXHostActivityService iAnnieXHostActivityService = (IAnnieXHostActivityService) AnnieX.INSTANCE.getService(bid, IAnnieXHostActivityService.class);
        if (((iAnnieXHostActivityService == null || iAnnieXHostActivityService.isTopResumeActivity(context)) ? false : true) && !isNeedDelayOpen) {
            MonitorManager.INSTANCE.onContainerError$anniex_release(bid, config.getSessionId(), AbsBulletMonitorCallback.ErrStage.Container, "not_in_top_and_without_delay_open");
            return false;
        }
        if (!isNeedDelayOpen) {
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (!(activity != null && activity.isFinishing())) {
                return showInner$default(this, true, context, bid, config, false, 16, null);
            }
        }
        Context applicationContext = context.getApplicationContext();
        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application == null) {
            MonitorManager.INSTANCE.onContainerError$anniex_release(bid, config.getSessionId(), AbsBulletMonitorCallback.ErrStage.Container, "application_is_null");
            return false;
        }
        this.showNext = true;
        this.litePageConfig = litePageConfig;
        this.config = config;
        if (this.activityLifeCycleCallBacks == null) {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.android.anniex.lite.LitePageService$openFlowDialog$1$1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity2, Bundle savedInstanceState) {
                    Intrinsics.checkNotNullParameter(activity2, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity2) {
                    Intrinsics.checkNotNullParameter(activity2, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity2) {
                    Intrinsics.checkNotNullParameter(activity2, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity2, Bundle outState) {
                    Intrinsics.checkNotNullParameter(activity2, "activity");
                    Intrinsics.checkNotNullParameter(outState, "outState");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity2) {
                    Intrinsics.checkNotNullParameter(activity2, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity2) {
                    Intrinsics.checkNotNullParameter(activity2, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity2) {
                    boolean z;
                    LitePageConfig litePageConfig2;
                    UIShowConfig uIShowConfig;
                    Intrinsics.checkNotNullParameter(activity2, "activity");
                    z = LitePageService.this.showNext;
                    if (z) {
                        litePageConfig2 = LitePageService.this.litePageConfig;
                        if (litePageConfig2 != null) {
                            LitePageService litePageService = LitePageService.this;
                            String str = bid;
                            uIShowConfig = litePageService.config;
                            if (uIShowConfig != null) {
                                litePageService.showInner(true, activity2, str, uIShowConfig, true);
                            }
                        }
                        LitePageService.this.showNext = false;
                        LitePageService.this.litePageConfig = null;
                        LitePageService.this.config = null;
                    }
                }
            };
            this.activityLifeCycleCallBacks = activityLifecycleCallbacks;
            application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        return true;
    }

    private final Class<?> getStartActivity() {
        Object obj;
        Class<?> cls = null;
        try {
            Result.Companion companion = Result.Companion;
            cls = Class.forName(AnnieXPageService.CUSTOM_ACTIVITY_CLAZZ);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isSuccess-impl(obj)) {
            return cls == null ? AnnieXDefaultActivity.class : cls;
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, "XRouter", "get custom page container failed,use default container", (Map) null, (LoggerContext) null, 12, (Object) null);
        return AnnieXDefaultActivity.class;
    }

    private final boolean isNeedDelayOpen(LitePageConfig litePageConfig) {
        return litePageConfig.isScanOpen() || litePageConfig.isDelayOpen() || litePageConfig.isFromScan();
    }

    private final boolean isOpenWithReplace(LitePageConfig litePageConfig) {
        return litePageConfig.isOpenWithReplace();
    }

    static /* synthetic */ boolean showInner$default(LitePageService litePageService, boolean z, Context context, String str, UIShowConfig uIShowConfig, boolean z2, int i, Object obj) {
        if ((i & 16) != 0) {
            z2 = false;
        }
        return litePageService.showInner(z, context, str, uIShowConfig, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean showInner(boolean useFlow, final Context context, final String bid, final UIShowConfig config, final boolean isFromScan) {
        try {
            try {
                if ((context instanceof FragmentActivity ? (FragmentActivity) context : null) == null) {
                    config.getLifecycleListener().onLoadFailed((IBulletUIComponent) null, new NonFragmentActivityException());
                    if (BulletEnv.Companion.getInstance().getDebuggable()) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.android.anniex.lite.LitePageService$showInner$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                Toast.makeText(context, "非FragmentActivity，不支持轻量级全页", 0).show();
                            }
                        });
                    }
                    MonitorManager.INSTANCE.onContainerError$anniex_release(bid, config.getSessionId(), AbsBulletMonitorCallback.ErrStage.Container, "activity_is_not_fragment_activity: " + getContextName(context));
                    return false;
                }
                IAnnieXService service = AnnieX.INSTANCE.getService(bid, IAnnieXLifecycleConfigService.class);
                if (!IConditionCallKt.getEnableLitePageBidOpt()) {
                    service = null;
                }
                final IAnnieXLifecycleConfigService iAnnieXLifecycleConfigService = (IAnnieXLifecycleConfigService) service;
                final AbsAnnieXLifecycle createLifecycle = iAnnieXLifecycleConfigService != null ? iAnnieXLifecycleConfigService.createLifecycle() : null;
                if (useFlow) {
                    IDialogHolder.DefaultImpls.show$default(AnnieX.INSTANCE.createDialogHolder(new Function1<PopupBuilder, Unit>() { // from class: com.bytedance.android.anniex.lite.LitePageService$showInner$dialogHolder$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((PopupBuilder) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PopupBuilder popupBuilder) {
                            AnnieXDialogListener createDialogListener;
                            Intrinsics.checkNotNullParameter(popupBuilder, "$this$createDialogHolder");
                            popupBuilder.bid(bid);
                            popupBuilder.bundle(config.getBundle());
                            popupBuilder.fragmentActivity((FragmentActivity) context);
                            AbsAnnieXLifecycle absAnnieXLifecycle = createLifecycle;
                            if (absAnnieXLifecycle != null) {
                                popupBuilder.lifecycle(absAnnieXLifecycle);
                            }
                            IAnnieXLifecycleConfigService iAnnieXLifecycleConfigService2 = iAnnieXLifecycleConfigService;
                            if (iAnnieXLifecycleConfigService2 != null && (createDialogListener = iAnnieXLifecycleConfigService2.createDialogListener()) != null) {
                                popupBuilder.listener(createDialogListener);
                            }
                            popupBuilder.useFlow(true);
                        }
                    }), null, 1, null);
                } else {
                    IDialogFragmentHolder createFullScreenFragmentHolder = AnnieX.INSTANCE.createFullScreenFragmentHolder(new Function1<LitePageBuilder, Unit>() { // from class: com.bytedance.android.anniex.lite.LitePageService$showInner$fragmentHolder$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((LitePageBuilder) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LitePageBuilder litePageBuilder) {
                            AnnieXFragmentListener createFragmentListener;
                            Intrinsics.checkNotNullParameter(litePageBuilder, "$this$createFullScreenFragmentHolder");
                            litePageBuilder.setBid$anniex_release(bid);
                            litePageBuilder.bundle(config.getBundle());
                            litePageBuilder.activity((FragmentActivity) context);
                            AbsAnnieXLifecycle absAnnieXLifecycle = createLifecycle;
                            if (absAnnieXLifecycle != null) {
                                litePageBuilder.lifecycle(absAnnieXLifecycle);
                            }
                            IAnnieXLifecycleConfigService iAnnieXLifecycleConfigService2 = iAnnieXLifecycleConfigService;
                            if (iAnnieXLifecycleConfigService2 != null && (createFragmentListener = iAnnieXLifecycleConfigService2.createFragmentListener()) != null) {
                                litePageBuilder.listener(createFragmentListener);
                            }
                            litePageBuilder.setFromScan(isFromScan);
                        }
                    });
                    List<AnnieXLiteFragment> list = dialogFragmentStack;
                    ActivityResultCaller dialog = createFullScreenFragmentHolder.getDialog();
                    Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.bytedance.android.anniex.lite.AnnieXLiteFragment");
                    list.add((AnnieXLiteFragment) dialog);
                    createFullScreenFragmentHolder.show(AnnieXConstants.ANNIE_X_LITE_PAGE);
                }
                return true;
            } catch (Throwable th) {
                th = th;
                MonitorManager.INSTANCE.onContainerError$anniex_release(bid, config.getSessionId(), AbsBulletMonitorCallback.ErrStage.Container, "open_dialog_fragment_with_exp :" + th.getMessage());
                th.printStackTrace();
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final String getContextName(Context context) {
        if (context != null) {
            try {
                Class<?> cls = context.getClass();
                if (cls != null) {
                    return cls.getSimpleName();
                }
            } catch (Throwable th) {
                return th.getMessage();
            }
        }
        return null;
    }

    private final void markOpenTime(Bundle bundle, String sessionId) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = bundle.getLong("open_time");
        if (j > 0) {
            MonitorManager.INSTANCE.markOpenTime(sessionId, Long.valueOf(j));
        } else {
            MonitorManager.INSTANCE.markOpenTime(sessionId, Long.valueOf(currentTimeMillis));
        }
    }
}
