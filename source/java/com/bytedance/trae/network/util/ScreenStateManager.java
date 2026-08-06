package com.bytedance.trae.network.util;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.network.util.ScreenStateManager;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: ScreenStateManager.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/network/util/ScreenStateManager;", "", "<init>", "()V", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenStateListener;", "receiver", "Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver;", "register", "", "screenStateListener", "unregister", "ensureReceiverRegistered", "unregisterReceiver", "ScreenBroadcastReceiver", "ScreenStateListener", "ScreenState", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ScreenStateManager {
    public static final ScreenStateManager INSTANCE = new ScreenStateManager();
    private static final CopyOnWriteArraySet<ScreenStateListener> listeners = new CopyOnWriteArraySet<>();
    private static ScreenBroadcastReceiver receiver;

    /* compiled from: ScreenStateManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenStateListener;", "", "onScreenOn", "", "onScreenOff", "onUserPresent", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface ScreenStateListener {
        void onScreenOff();

        void onScreenOn();

        void onUserPresent();
    }

    private ScreenStateManager() {
    }

    public final void register(ScreenStateListener screenStateListener) {
        Intrinsics.checkNotNullParameter(screenStateListener, "screenStateListener");
        CopyOnWriteArraySet<ScreenStateListener> copyOnWriteArraySet = listeners;
        if (copyOnWriteArraySet.isEmpty()) {
            ensureReceiverRegistered();
        }
        copyOnWriteArraySet.add(screenStateListener);
    }

    public final void unregister(ScreenStateListener screenStateListener) {
        Intrinsics.checkNotNullParameter(screenStateListener, "screenStateListener");
        CopyOnWriteArraySet<ScreenStateListener> copyOnWriteArraySet = listeners;
        copyOnWriteArraySet.remove(screenStateListener);
        if (copyOnWriteArraySet.isEmpty()) {
            unregisterReceiver();
        }
    }

    private final void ensureReceiverRegistered() {
        if (receiver == null) {
            receiver = new ScreenBroadcastReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            if (Build.VERSION.SDK_INT >= 33) {
                m414x56862b2b(AppHost.Companion.getApplication(), receiver, intentFilter, 4);
            } else {
                m413x56862b2b(AppHost.Companion.getApplication(), receiver, intentFilter);
            }
        }
    }

    private final void unregisterReceiver() {
        ScreenBroadcastReceiver screenBroadcastReceiver = receiver;
        if (screenBroadcastReceiver != null) {
            m415xb2756d84(AppHost.Companion.getApplication(), screenBroadcastReceiver);
            receiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScreenStateManager.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\n\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\fH\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "notifyListeners", "notification", "Lkotlin/Function1;", "Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenStateListener;", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class ScreenBroadcastReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent != null ? intent.getAction() : null;
            if (action != null) {
                int hashCode = action.hashCode();
                if (hashCode == -2128145023) {
                    if (action.equals("android.intent.action.SCREEN_OFF")) {
                        notifyListeners(new Function1() { // from class: com.bytedance.trae.network.util.ScreenStateManager$ScreenBroadcastReceiver$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                Unit onReceive$lambda$1;
                                onReceive$lambda$1 = ScreenStateManager.ScreenBroadcastReceiver.onReceive$lambda$1((ScreenStateManager.ScreenStateListener) obj);
                                return onReceive$lambda$1;
                            }
                        });
                    }
                } else if (hashCode == -1454123155) {
                    if (action.equals("android.intent.action.SCREEN_ON")) {
                        notifyListeners(new Function1() { // from class: com.bytedance.trae.network.util.ScreenStateManager$ScreenBroadcastReceiver$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                Unit onReceive$lambda$0;
                                onReceive$lambda$0 = ScreenStateManager.ScreenBroadcastReceiver.onReceive$lambda$0((ScreenStateManager.ScreenStateListener) obj);
                                return onReceive$lambda$0;
                            }
                        });
                    }
                } else if (hashCode == 823795052 && action.equals("android.intent.action.USER_PRESENT")) {
                    notifyListeners(new Function1() { // from class: com.bytedance.trae.network.util.ScreenStateManager$ScreenBroadcastReceiver$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit onReceive$lambda$2;
                            onReceive$lambda$2 = ScreenStateManager.ScreenBroadcastReceiver.onReceive$lambda$2((ScreenStateManager.ScreenStateListener) obj);
                            return onReceive$lambda$2;
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onReceive$lambda$0(ScreenStateListener screenStateListener) {
            Intrinsics.checkNotNullParameter(screenStateListener, "it");
            screenStateListener.onScreenOn();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onReceive$lambda$1(ScreenStateListener screenStateListener) {
            Intrinsics.checkNotNullParameter(screenStateListener, "it");
            screenStateListener.onScreenOff();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onReceive$lambda$2(ScreenStateListener screenStateListener) {
            Intrinsics.checkNotNullParameter(screenStateListener, "it");
            screenStateListener.onUserPresent();
            return Unit.INSTANCE;
        }

        private final void notifyListeners(Function1<? super ScreenStateListener, Unit> notification) {
            for (ScreenStateListener screenStateListener : ScreenStateManager.listeners) {
                try {
                    Intrinsics.checkNotNull(screenStateListener);
                    notification.invoke(screenStateListener);
                } catch (Exception e) {
                    Log.e("ScreenListener", "Error notifying listener", e);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ScreenStateManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenState;", "", "<init>", "(Ljava/lang/String;I)V", "SCREEN_ON", "SCREEN_OFF", "USER_PRESENT", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class ScreenState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ScreenState[] $VALUES;
        public static final ScreenState SCREEN_ON = new ScreenState("SCREEN_ON", 0);
        public static final ScreenState SCREEN_OFF = new ScreenState("SCREEN_OFF", 1);
        public static final ScreenState USER_PRESENT = new ScreenState("USER_PRESENT", 2);

        private static final /* synthetic */ ScreenState[] $values() {
            return new ScreenState[]{SCREEN_ON, SCREEN_OFF, USER_PRESENT};
        }

        public static EnumEntries<ScreenState> getEntries() {
            return $ENTRIES;
        }

        private ScreenState(String str, int i) {
        }

        static {
            ScreenState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static ScreenState valueOf(String str) {
            return (ScreenState) Enum.valueOf(ScreenState.class, str);
        }

        public static ScreenState[] values() {
            return (ScreenState[]) $VALUES.clone();
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_trae_network_util_ScreenStateManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m413x56862b2b(Application application, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.iab.omid.library.bytedance.b.b"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_trae_network_util_ScreenStateManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m414x56862b2b(Application application, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
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
                return ContextCompat.registerReceiver(application, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, i);
            }
            return application.registerReceiver(broadcastReceiver, intentFilter, i);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter, i);
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    /* renamed from: INVOKEVIRTUAL_com_bytedance_trae_network_util_ScreenStateManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m415xb2756d84(Application application, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        application.unregisterReceiver(broadcastReceiver);
    }
}
