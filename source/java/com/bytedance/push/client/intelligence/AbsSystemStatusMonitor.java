package com.bytedance.push.client.intelligence;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.interfaze.ISystemBroadcastService;
import com.bytedance.push.utils.Logger;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsSystemStatusMonitor extends BroadcastReceiver implements ISystemBroadcastService.IBroadcastReceiver {
    private final String TAG = "AbsSystemStatusMonitor";
    private Context mContext;
    private boolean mHasMonitorScreenStatus;

    abstract void onNotificationBarPull();

    abstract void onUserPresent();

    public AbsSystemStatusMonitor(Context context) {
        this.mContext = context;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Logger.m268d("AbsSystemStatusMonitor", "onReceive:" + intent.getAction());
        if (TextUtils.equals(intent.getAction(), "android.intent.action.USER_PRESENT")) {
            Logger.m268d("AbsSystemStatusMonitor", "on user present");
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.client.intelligence.AbsSystemStatusMonitor.1
                @Override // java.lang.Runnable
                public void run() {
                    AbsSystemStatusMonitor.this.onUserPresent();
                }
            });
        }
    }

    @Override // com.bytedance.push.interfaze.ISystemBroadcastService.IBroadcastReceiver
    public void onReceiveFromPushSystemBroadcastService(Intent intent) {
        if (TextUtils.equals(intent.getAction(), ISystemBroadcastService.MIUI_NOTIFICATION_ACTION)) {
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.client.intelligence.AbsSystemStatusMonitor.2
                @Override // java.lang.Runnable
                public void run() {
                    AbsSystemStatusMonitor.this.onNotificationBarPull();
                }
            });
        }
    }

    public void startMonitorSystemBroadCastForUnDoze() {
        if (ToolUtils.isMainProcess(this.mContext)) {
            Logger.m268d("AbsSystemStatusMonitor", "register system action for un doze");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            PushCommonSupport.getInstance().getIPushCommonConfiguration().registerReceiver(this.mContext, this, intentFilter);
            startMonitorScreenOn();
        }
    }

    public void startMonitorScreenOn() {
        if (this.mHasMonitorScreenStatus) {
            return;
        }
        this.mHasMonitorScreenStatus = true;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.USER_PRESENT");
        Logger.m268d("AbsSystemStatusMonitor", "register as : android.intent.action.USER_PRESENT");
        m234xd2706686(this.mContext, this, intentFilter);
    }

    public void startMonitorNotificationBarPull() {
        PushSupporter.get().getSystemBroadcastService().addNotificationBarPullDownListener(this);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_push_client_intelligence_AbsSystemStatusMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m234xd2706686(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
}
