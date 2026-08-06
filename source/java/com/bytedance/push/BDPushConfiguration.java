package com.bytedance.push;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.bytedance.praisedialoglib.PraiseDialogConstant;
import com.bytedance.push.configuration.AbsBDPushConfiguration;
import com.bytedance.push.configuration.BDPushBaseConfiguration;
import com.bytedance.push.frontier.FrontierStrategy;
import com.bytedance.push.frontier.interfaze.IFrontierService;
import com.bytedance.push.interfaze.I18nCommonParams;
import com.bytedance.push.interfaze.IRegisterResultCallback;
import com.bytedance.push.interfaze.OnPushClickListener;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.im.network.INetworkDepend;
import com.bytedance.trae.network.FrontierConnection;
import com.bytedance.trae.push.api.PushConst;
import com.bytedance.trae.push.api.PushDeeplinkPendingStore;
import com.bytedance.trae.push.impl.CustomNotificationBuilder;
import com.bytedance.trae.push.impl.PushEventManager;
import com.bytedance.trae.push.impl.PushMsgShowInterceptor;
import com.bytedance.trae.push.impl.PushTrackerType;
import com.bytedance.trae.utils.AppLocaleUtils;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* compiled from: BDPushConfiguration.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0003H\u0016J\n\u0010%\u001a\u0004\u0018\u00010&H\u0016J$\u0010'\u001a\u00020(2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/push/BDPushConfiguration;", "Lcom/bytedance/push/configuration/AbsBDPushConfiguration;", "host", "", "<init>", "(Ljava/lang/String;)V", "getBDPushBaseConfiguration", "Lcom/bytedance/push/configuration/BDPushBaseConfiguration;", "isDebug", "", "enableAutoInit", "enableAutoStart", "enableALog", "enableExceptionInDebugModeWhenFatalError", "getCustomNotificationBuilder", "Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;", "getPushMsgShowInterceptor", "Lcom/bytedance/trae/push/impl/PushMsgShowInterceptor;", "enableAutoRequestSettings", "autoRequestNotificationPermission", "getOnPushClickListener", "Lcom/bytedance/push/interfaze/OnPushClickListener;", "getRegisterResultCallback", "Lcom/bytedance/push/interfaze/IRegisterResultCallback;", "registerReceiver", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "var1", "Landroid/content/BroadcastReceiver;", "var2", "Landroid/content/IntentFilter;", "getFrontierMode", "Lcom/bytedance/push/frontier/FrontierStrategy;", "getFrontierService", "Lcom/bytedance/push/frontier/interfaze/IFrontierService;", "getSessionId", "getI18nCommonParams", "Lcom/bytedance/push/interfaze/I18nCommonParams;", "handlePushClick", "", PraiseDialogConstant.FROM, "", "body", "Lcom/bytedance/push/PushBody;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BDPushConfiguration extends AbsBDPushConfiguration {
    private static final String TAG = "BDPushConfiguration";
    private final String host;

    public boolean autoRequestNotificationPermission() {
        return false;
    }

    @Override // com.bytedance.push.configuration.AbsBDPushConfiguration
    public boolean enableALog() {
        return true;
    }

    @Override // com.bytedance.push.configuration.AbsBDPushConfiguration
    public boolean enableAutoInit() {
        return false;
    }

    @Override // com.bytedance.push.configuration.AbsBDPushConfiguration
    public boolean enableAutoRequestSettings() {
        return false;
    }

    @Override // com.bytedance.push.configuration.AbsBDPushConfiguration
    public boolean enableAutoStart() {
        return false;
    }

    public boolean enableExceptionInDebugModeWhenFatalError() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDPushConfiguration(String str) {
        super(AppHost.Companion.getApplication());
        Intrinsics.checkNotNullParameter(str, "host");
        this.host = str;
    }

    @Override // com.bytedance.push.configuration.AbsBDPushConfiguration
    public BDPushBaseConfiguration getBDPushBaseConfiguration() {
        AppInfo appInfo = new AppInfo();
        appInfo.setAid(AppHost.Companion.getAppId());
        appInfo.setAppName(AppHost.Companion.getAppName());
        appInfo.setChannel(AppHost.Companion.getBuildChannel());
        appInfo.setVersionName(AppHost.Companion.getVersionName());
        appInfo.setVersionCode(AppHost.Companion.getVersionCode());
        appInfo.setUpdateVersionCode(AppHost.Companion.getUpdateVersionCode());
        return new BDPushBaseConfiguration(appInfo, this.host, AppHost.Companion.isOversea());
    }

    @Override // com.bytedance.push.configuration.AbsBDPushConfiguration
    public boolean isDebug() {
        return AppHost.Companion.isDebug();
    }

    @Override // com.bytedance.push.configuration.AbsBDPushConfiguration
    public CustomNotificationBuilder getCustomNotificationBuilder() {
        return new CustomNotificationBuilder();
    }

    @Override // com.bytedance.push.configuration.AbsBDPushConfiguration
    public PushMsgShowInterceptor getPushMsgShowInterceptor() {
        return new PushMsgShowInterceptor();
    }

    @Override // com.bytedance.push.configuration.AbsBDPushConfiguration
    public OnPushClickListener getOnPushClickListener() {
        return new OnPushClickListener() { // from class: com.bytedance.push.BDPushConfiguration$$ExternalSyntheticLambda0
            @Override // com.bytedance.push.interfaze.OnPushClickListener
            public final JSONObject onClickPush(Context context, int i, PushBody pushBody, String str) {
                JSONObject onPushClickListener$lambda$0;
                onPushClickListener$lambda$0 = BDPushConfiguration.getOnPushClickListener$lambda$0(BDPushConfiguration.this, context, i, pushBody, str);
                return onPushClickListener$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject getOnPushClickListener$lambda$0(BDPushConfiguration bDPushConfiguration, Context context, int i, PushBody pushBody, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        FLogger.INSTANCE.mo428i(TAG, "onPushClick from=" + i + ", body=" + (pushBody != null ? pushBody.getOriginData() : null));
        PushEventManager.INSTANCE.onPushClick(pushBody, i);
        bDPushConfiguration.handlePushClick(context, i, pushBody);
        return null;
    }

    @Override // com.bytedance.push.configuration.AbsBDPushConfiguration
    public IRegisterResultCallback getRegisterResultCallback() {
        return new IRegisterResultCallback() { // from class: com.bytedance.push.BDPushConfiguration$$ExternalSyntheticLambda1
            @Override // com.bytedance.push.interfaze.IRegisterResultCallback
            public final void onResult(boolean z, int i) {
                BDPushConfiguration.getRegisterResultCallback$lambda$1(z, i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRegisterResultCallback$lambda$1(boolean z, int i) {
        FLogger.INSTANCE.mo428i(TAG, "onChannelRegistered success=" + z + ", type=" + i);
        PushEventManager.INSTANCE.onChannelRegisterResult(z, i);
    }

    public Intent registerReceiver(Context context, BroadcastReceiver var1, IntentFilter var2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(var1, "var1");
        Intrinsics.checkNotNullParameter(var2, "var2");
        if (Build.VERSION.SDK_INT >= 33) {
            return m233x853739ed(context, var1, var2, 2);
        }
        return m232x853739ed(context, var1, var2);
    }

    public FrontierStrategy getFrontierMode() {
        if (AppHost.Companion.isOversea()) {
            return null;
        }
        return FrontierStrategy.STRATEGY_USE_HOST;
    }

    public IFrontierService getFrontierService() {
        return new IFrontierService() { // from class: com.bytedance.push.BDPushConfiguration$getFrontierService$1
            @Override // com.bytedance.push.frontier.interfaze.IFrontierService
            public void registerFrontierPush(OnMessageReceiveListener listener) {
                FrontierConnection pushFrontierConnection;
                if (AppHost.Companion.isOversea() || listener == null || (pushFrontierConnection = INetworkDepend.Companion.getInstance().getPushFrontierConnection()) == null) {
                    return;
                }
                pushFrontierConnection.registerPushListener(listener);
            }

            @Override // com.bytedance.push.frontier.interfaze.IFrontierService
            public void unRegisterFrontierPush() {
                FrontierConnection pushFrontierConnection;
                if (AppHost.Companion.isOversea() || (pushFrontierConnection = INetworkDepend.Companion.getInstance().getPushFrontierConnection()) == null) {
                    return;
                }
                pushFrontierConnection.unregisterPushListener();
            }
        };
    }

    public String getSessionId() {
        return IApplog.Companion.getSessionId();
    }

    @Override // com.bytedance.push.configuration.AbsBDPushConfiguration
    public I18nCommonParams getI18nCommonParams() {
        return new I18nCommonParams() { // from class: com.bytedance.push.BDPushConfiguration$getI18nCommonParams$1
            @Override // com.bytedance.push.interfaze.I18nCommonParams
            public String getAppRegion() {
                String country = AppLocaleUtils.INSTANCE.getAppLocale().getCountry();
                return country == null ? "" : country;
            }

            @Override // com.bytedance.push.interfaze.I18nCommonParams
            public String getAppLanguage() {
                String language = AppLocaleUtils.INSTANCE.getAppLocale().getLanguage();
                return language == null ? "" : language;
            }
        };
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        com.bytedance.trae.push.impl.PushEventManager.INSTANCE.trackPushProcess(com.bytedance.trae.push.impl.PushTrackerType.FAIL, kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to("fail_reason", "invalid_open_url")));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handlePushClick(Context context, int from, PushBody body) {
        Uri uri;
        if (body == null || context == null) {
            return;
        }
        String str = body.open_url;
        if (str == null) {
            str = "";
        }
        PushEventManager.INSTANCE.updateCurrentPushOpenUrl(str);
        Intent intent = null;
        PushEventManager.trackPushProcess$default(PushEventManager.INSTANCE, PushTrackerType.START, null, 2, null);
        try {
            boolean z = true;
            if (str.length() > 0) {
                Uri parse = Uri.parse(str);
                String scheme = parse.getScheme();
                if (scheme != null && scheme.length() != 0) {
                    z = false;
                }
                uri = parse.buildUpon().appendQueryParameter(PushConst.PUSH_KEY_IS_FROM_PUSH, RouterConstants.TRUE).appendQueryParameter(PushConst.PUSH_KEY_IS_FROM_CUSTOM_PUSH, RouterConstants.TRUE).build();
            } else {
                PushEventManager.INSTANCE.trackPushProcess(PushTrackerType.FAIL, MapsKt.mapOf(TuplesKt.to("fail_reason", "missing_open_url")));
                uri = null;
            }
            if (uri != null) {
                PushEventManager.trackPushProcess$default(PushEventManager.INSTANCE, PushTrackerType.TOUCHED_ROUTER, null, 2, null);
            }
            if (uri != null) {
                PushDeeplinkPendingStore pushDeeplinkPendingStore = PushDeeplinkPendingStore.INSTANCE;
                Application application = AppHost.Companion.getApplication();
                String uri2 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
                pushDeeplinkPendingStore.save(application, uri2);
            }
            PackageManager packageManager = AppHost.Companion.getApplication().getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(AppHost.Companion.getApplication().getPackageName());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268468224);
                intent = launchIntentForPackage;
            }
            if (intent != null) {
                intent.setAction("android.intent.action.VIEW");
            }
            if (intent != null) {
                intent.putExtra("push_body", body.getOriginData());
            }
            if (intent != null) {
                intent.putExtra(PushConst.KEY_PUSH_MESSAGE_FROM, from);
            }
            if (intent != null) {
                intent.setPackage(AppHost.Companion.getApplication().getPackageName());
            }
            if (uri != null && intent != null) {
                intent.setData(uri);
            }
            try {
                context.startActivity(intent);
            } catch (Exception unused) {
                FLogger.INSTANCE.mo430w(TAG, "startActivity blocked by BAL, relying on pending store");
            }
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e(TAG, "handlePushClick error: " + e.getMessage());
            PushEventManager pushEventManager = PushEventManager.INSTANCE;
            PushTrackerType pushTrackerType = PushTrackerType.FAIL;
            String message = e.getMessage();
            if (message == null) {
                message = "unknown_error";
            }
            pushEventManager.trackPushProcess(pushTrackerType, MapsKt.mapOf(TuplesKt.to("fail_reason", message)));
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_push_BDPushConfiguration_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m232x853739ed(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.iab.omid.library.bytedance.b.b"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_push_BDPushConfiguration_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m233x853739ed(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, i);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter, i);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter, i);
        }
    }
}
