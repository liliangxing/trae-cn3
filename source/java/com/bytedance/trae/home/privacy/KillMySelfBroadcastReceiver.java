package com.bytedance.trae.home.privacy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: KillMySelfBroadcastReceiver.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KillMySelfBroadcastReceiver extends BroadcastReceiver {
    public static final int $stable = 0;
    private static final String ACTION_SUFFIX = ".action.KILL_MAIN_PROCESS";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.i(PrivacyManager.TAG, "KillMySelfBroadcastReceiver onReceive, kill main process");
        Process.killProcess(Process.myPid());
    }

    /* compiled from: KillMySelfBroadcastReceiver.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver$Companion;", "", "<init>", "()V", "ACTION_SUFFIX", "", "getAction", "context", "Landroid/content/Context;", "getPermission", "registerReceiver", "", "sendBroadcast", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final String getAction(Context context) {
            return context.getPackageName() + KillMySelfBroadcastReceiver.ACTION_SUFFIX;
        }

        private final String getPermission(Context context) {
            return context.getPackageName() + ".permission.PRIVACY_BROADCAST";
        }

        public final void registerReceiver(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            IntentFilter intentFilter = new IntentFilter(getAction(context));
            KillMySelfBroadcastReceiver killMySelfBroadcastReceiver = new KillMySelfBroadcastReceiver();
            if (Build.VERSION.SDK_INT >= 33) {
                INVOKEVIRTUAL_com_bytedance_trae_home_privacy_KillMySelfBroadcastReceiver$Companion_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(context, killMySelfBroadcastReceiver, intentFilter, getPermission(context), null, 4);
            } else {
                INVOKEVIRTUAL_com_bytedance_trae_home_privacy_KillMySelfBroadcastReceiver$Companion_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(context, killMySelfBroadcastReceiver, intentFilter, getPermission(context), null);
            }
            Log.i(PrivacyManager.TAG, "registerReceiver success");
        }

        public final void sendBroadcast(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(getAction(context));
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent, getPermission(context));
            Log.i(PrivacyManager.TAG, "sendBroadcast to kill main process");
        }

        @Proxy("registerReceiver")
        @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.iab.omid.library.bytedance.b.b"})
        public static Intent INVOKEVIRTUAL_com_bytedance_trae_home_privacy_KillMySelfBroadcastReceiver$Companion_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
                ReceiverRegisterCrashOptimizer.doHWReceiverFix();
            }
            try {
                return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
            } catch (Exception e) {
                if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                    throw e;
                }
                return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter, str, handler);
            }
        }

        @Proxy("registerReceiver")
        @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.iab.omid.library.bytedance.b.b"})
        public static Intent INVOKEVIRTUAL_com_bytedance_trae_home_privacy_KillMySelfBroadcastReceiver$Companion_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
                ReceiverRegisterCrashOptimizer.doHWReceiverFix();
            }
            try {
                return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i);
            } catch (Exception e) {
                if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                    throw e;
                }
                return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter, str, handler, i);
            }
        }
    }
}
