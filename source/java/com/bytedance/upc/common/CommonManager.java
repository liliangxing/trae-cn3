package com.bytedance.upc.common;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.bytedance.upc.Configuration;
import com.bytedance.upc.UpcSettingsConfig;
import com.bytedance.upc.common.activity.ActivityLifeObserver;
import com.bytedance.upc.common.log.LogUtils;
import com.bytedance.upc.common.network.UpcNetChangeManager;
import com.bytedance.webx.seclink.util.ReportUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: CommonManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/upc/common/CommonManager;", "", "()V", "mConfiguration", "Lcom/bytedance/upc/Configuration;", "mContext", "Landroid/app/Application;", "getConfiguration", "getContext", "Landroid/content/Context;", ReportUtil.Event.EVENT_INIT, "", "context", "configuration", "initCommon", "initReceiver", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CommonManager {
    public static final CommonManager INSTANCE = new CommonManager();
    private static Configuration mConfiguration;
    private static Application mContext;

    private CommonManager() {
    }

    public final void init(Context context, Configuration configuration) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(configuration, "configuration");
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
        }
        mContext = (Application) applicationContext;
        mConfiguration = configuration;
        initCommon();
    }

    private final void initCommon() {
        Configuration.AppInfo appInfo;
        UpcSettingsConfig upcSettingsConfig;
        Application application = mContext;
        if (application == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
        }
        application.registerActivityLifecycleCallbacks(ActivityLifeObserver.INSTANCE);
        Configuration configuration = mConfiguration;
        boolean z = true;
        if (configuration == null || !configuration.mDebug) {
            Configuration configuration2 = mConfiguration;
            if (!Intrinsics.areEqual((configuration2 == null || (appInfo = configuration2.mAppInfo) == null) ? null : appInfo.channel, "local_test")) {
                z = false;
            }
        }
        LogUtils.setDebug(z);
        Configuration configuration3 = mConfiguration;
        long delayInitReceiverTime = (configuration3 == null || (upcSettingsConfig = configuration3.mUpcSettingsConfig) == null) ? 0L : upcSettingsConfig.getDelayInitReceiverTime();
        if (delayInitReceiverTime > 0) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.upc.common.CommonManager$initCommon$1
                @Override // java.lang.Runnable
                public final void run() {
                    CommonManager.INSTANCE.initReceiver();
                }
            }, delayInitReceiverTime);
        } else {
            initReceiver();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initReceiver() {
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        Application application = mContext;
        if (application == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
        }
        m0xfe1b149d(application, UpcNetChangeManager.INSTANCE.inst(), intentFilter);
    }

    public final Context getContext() {
        Application application = mContext;
        if (application == null) {
            Intrinsics.throwNpe();
        }
        Context applicationContext = application.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "mContext!!.applicationContext");
        return applicationContext;
    }

    public final Configuration getConfiguration() {
        Configuration configuration = mConfiguration;
        if (configuration == null) {
            Intrinsics.throwNpe();
        }
        return configuration;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_upc_common_CommonManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m0xfe1b149d(Application application, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                return application.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                return ContextCompat.registerReceiver(application, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return application.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}
