package com.bytedance.common.push.interfaze;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.common.interfaze.SensorAbility;
import com.bytedance.common.model.SyncConfig;
import com.bytedance.common.proxy.IActualObjGetterForHandlerBeDynamicProxy;
import com.bytedance.common.push.user.AccountSDKImpl;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.push.frontier.FrontierStrategy;
import com.bytedance.push.frontier.interfaze.IFrontierService;
import com.bytedance.push.utils.Logger;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.push_common_lib.R;
import java.lang.reflect.Method;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class IPushCommonConfiguration {
    private final String TAG = "IPushCommonConfiguration";

    public boolean addInstrumentationListener(IInstrumentationListener iInstrumentationListener) {
        return false;
    }

    public boolean autoRequestNotificationPermission() {
        return true;
    }

    public boolean defaultEnableUnDuplicateMessage() {
        return false;
    }

    public boolean disableAutoStartChildProcess() {
        return false;
    }

    public boolean enableExceptionInDebugModeWhenFatalError() {
        return true;
    }

    public boolean enableInstrKa() {
        return true;
    }

    public boolean enableMonitorNotificationClick() {
        return false;
    }

    public boolean fixAssociationStartMonitorServiceAnr() {
        return true;
    }

    public IEventReportListener getEventReportListener() {
        return null;
    }

    public IFrontierService getFrontierService() {
        return null;
    }

    public IHostSysAccountConfig getHostSysAccountConfig() {
        return null;
    }

    public IHostWidgetService getHostWidgetService() {
        return null;
    }

    public NetworkClient getNetworkClient() {
        return null;
    }

    public String getSessionId() {
        return "";
    }

    public SyncConfig getSyncConfig() {
        return null;
    }

    public boolean hasAgreedForPrivacyDialog() {
        return true;
    }

    public void invokeActivityLifeCycleMethod(Method method, Activity activity) {
    }

    public boolean isGuestMode() {
        return false;
    }

    public void onRemoteViewsServiceGetView(int i) {
    }

    public boolean optActivityThreadHandlerGetScreenState() {
        return true;
    }

    public boolean optAnr() {
        return false;
    }

    public boolean optMainProcessInitTimeCost() {
        return false;
    }

    public boolean optMainProcessInitTimeCostV2() {
        return false;
    }

    public boolean optUidChangeByHostInvoke() {
        return false;
    }

    public void requestPermissions(Activity activity, String[] strArr, int i) {
    }

    public FrontierStrategy getFrontierMode() {
        return FrontierStrategy.STRATEGY_USE_HOST;
    }

    public SensorAbility getSensorAbility() {
        return new SensorAbility() { // from class: com.bytedance.common.push.interfaze.IPushCommonConfiguration.1
            @Override // com.bytedance.common.interfaze.SensorAbility
            public Sensor getDefaultSensor(SensorManager sensorManager, int i) {
                Logger.d("IPushCommonConfiguration", "default SensorAbility#getDefaultSensor");
                return null;
            }

            @Override // com.bytedance.common.interfaze.SensorAbility
            public boolean registerListener(SensorManager sensorManager, SensorEventListener sensorEventListener, Sensor sensor, int i) {
                Logger.d("IPushCommonConfiguration", "default SensorAbility#registerListener");
                return false;
            }

            @Override // com.bytedance.common.interfaze.SensorAbility
            public void unregisterListener(SensorManager sensorManager, SensorEventListener sensorEventListener, Sensor sensor) {
                Logger.d("IPushCommonConfiguration", "default SensorAbility#unregisterListener");
            }
        };
    }

    public IAccountService getAccountService() {
        return new AccountSDKImpl();
    }

    public String getProfileId() {
        IAccountService accountService = getAccountService();
        String str = null;
        if (accountService == null) {
            return null;
        }
        String secUid = accountService.getSecUid();
        if (TextUtils.isEmpty(secUid)) {
            return null;
        }
        try {
            str = DigestUtils.md5Hex(secUid);
            Logger.d("IPushCommonConfiguration", "success md5 sec_uid,sec_uid:" + secUid + " profile_id:" + str);
            return str;
        } catch (Throwable th) {
            Logger.e("IPushCommonConfiguration", "error when md5 sec_uid ", th);
            return str;
        }
    }

    public IActualObjGetterForHandlerBeDynamicProxy getActualObjGetterForHandlerBeDynamicProxy() {
        return new IActualObjGetterForHandlerBeDynamicProxy() { // from class: com.bytedance.common.push.interfaze.IPushCommonConfiguration.2
            @Override // com.bytedance.common.proxy.IActualObjGetterForHandlerBeDynamicProxy
            public IInterface getActualActivityManagerWhenHandlerBeDynamicProxy(IInterface iInterface, IActualObjGetterForHandlerBeDynamicProxy iActualObjGetterForHandlerBeDynamicProxy) {
                Logger.w("IActualObjGetterForHandlerBeDynamicProxy", "default empty getActualActivityManagerWhenHandlerBeDynamicProxy");
                return null;
            }

            @Override // com.bytedance.common.proxy.IActualObjGetterForHandlerBeDynamicProxy
            public IBinder getActualBinderWhenHandlerBeDynamicProxy(IBinder iBinder, IActualObjGetterForHandlerBeDynamicProxy iActualObjGetterForHandlerBeDynamicProxy) {
                Logger.d("IActualObjGetterForHandlerBeDynamicProxy", "default empty getActualBinderWhenHandlerBeDynamicProxy");
                return null;
            }
        };
    }

    public int getAppIconResId() {
        return R.drawable.status_icon;
    }

    public Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (Build.VERSION.SDK_INT >= 33) {
            return m184xf36244ac(context, broadcastReceiver, intentFilter, 2);
        }
        return m183xf36244ac(context, broadcastReceiver, intentFilter);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_common_push_interfaze_IPushCommonConfiguration_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m183xf36244ac(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
    /* renamed from: INVOKEVIRTUAL_com_bytedance_common_push_interfaze_IPushCommonConfiguration_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m184xf36244ac(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
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
