package com.bytedance.android.sdk.bdticketguard;

import android.content.Context;
import com.bytedance.android.sdk.bdticketguard.util.ProcessUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardFramework.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J(\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010H\u0007J\u001c\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0013H\u0007J\u001c\u0010\u0014\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0013H\u0007J\u001c\u0010\u0015\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0013H\u0007R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/TicketGuardFramework;", "", "()V", "<set-?>", "Lcom/bytedance/android/sdk/bdticketguard/TicketGuardService;", "service", "getService", "()Lcom/bytedance/android/sdk/bdticketguard/TicketGuardService;", "initInstance", "", "applicationContext", "Landroid/content/Context;", "tryInit", "ticketGuardInitParam", "Lcom/bytedance/android/sdk/bdticketguard/TicketGuardInitParam;", "initCallback", "Lkotlin/Function1;", "", "tryInitEncryption", "Lcom/bytedance/android/sdk/bdticketguard/TicketInitCallback;", "tryInitRee", "tryInitTee", "bd_ticket_guard_core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TicketGuardFramework {
    public static final TicketGuardFramework INSTANCE = new TicketGuardFramework();
    private static TicketGuardService service;

    @JvmStatic
    public static final void tryInit(TicketGuardInitParam ticketGuardInitParam) {
        tryInit$default(ticketGuardInitParam, null, 2, null);
    }

    @JvmStatic
    public static final void tryInitEncryption(TicketGuardInitParam ticketGuardInitParam) {
        tryInitEncryption$default(ticketGuardInitParam, null, 2, null);
    }

    @JvmStatic
    public static final void tryInitRee(TicketGuardInitParam ticketGuardInitParam) {
        tryInitRee$default(ticketGuardInitParam, null, 2, null);
    }

    @JvmStatic
    public static final void tryInitTee(TicketGuardInitParam ticketGuardInitParam) {
        tryInitTee$default(ticketGuardInitParam, null, 2, null);
    }

    private TicketGuardFramework() {
    }

    public final TicketGuardService getService() {
        return service;
    }

    public static /* synthetic */ void tryInit$default(TicketGuardInitParam ticketGuardInitParam, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        tryInit(ticketGuardInitParam, function1);
    }

    @JvmStatic
    public static final void tryInit(TicketGuardInitParam ticketGuardInitParam, Function1<? super Boolean, Unit> initCallback) {
        Intrinsics.checkParameterIsNotNull(ticketGuardInitParam, "ticketGuardInitParam");
        INSTANCE.initInstance(ticketGuardInitParam.getApplicationContext());
        TicketGuardService ticketGuardService = service;
        if (ticketGuardService != null) {
            ticketGuardService.tryInit(ticketGuardInitParam, initCallback);
        }
    }

    public static /* synthetic */ void tryInitRee$default(TicketGuardInitParam ticketGuardInitParam, TicketInitCallback ticketInitCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            ticketInitCallback = null;
        }
        tryInitRee(ticketGuardInitParam, ticketInitCallback);
    }

    @JvmStatic
    public static final void tryInitRee(TicketGuardInitParam ticketGuardInitParam, TicketInitCallback initCallback) {
        Intrinsics.checkParameterIsNotNull(ticketGuardInitParam, "ticketGuardInitParam");
        INSTANCE.initInstance(ticketGuardInitParam.getApplicationContext());
        TicketGuardService ticketGuardService = service;
        if (ticketGuardService != null) {
            ticketGuardService.tryInitRee(ticketGuardInitParam, initCallback);
        }
    }

    public static /* synthetic */ void tryInitTee$default(TicketGuardInitParam ticketGuardInitParam, TicketInitCallback ticketInitCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            ticketInitCallback = null;
        }
        tryInitTee(ticketGuardInitParam, ticketInitCallback);
    }

    @JvmStatic
    public static final void tryInitTee(TicketGuardInitParam ticketGuardInitParam, TicketInitCallback initCallback) {
        Intrinsics.checkParameterIsNotNull(ticketGuardInitParam, "ticketGuardInitParam");
        INSTANCE.initInstance(ticketGuardInitParam.getApplicationContext());
        TicketGuardService ticketGuardService = service;
        if (ticketGuardService != null) {
            ticketGuardService.tryInitTee(ticketGuardInitParam, initCallback);
        }
    }

    public static /* synthetic */ void tryInitEncryption$default(TicketGuardInitParam ticketGuardInitParam, TicketInitCallback ticketInitCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            ticketInitCallback = null;
        }
        tryInitEncryption(ticketGuardInitParam, ticketInitCallback);
    }

    @JvmStatic
    public static final void tryInitEncryption(TicketGuardInitParam ticketGuardInitParam, TicketInitCallback initCallback) {
        Intrinsics.checkParameterIsNotNull(ticketGuardInitParam, "ticketGuardInitParam");
        INSTANCE.initInstance(ticketGuardInitParam.getApplicationContext());
        TicketGuardService ticketGuardService = service;
        if (ticketGuardService != null) {
            ticketGuardService.tryInitEncryption(ticketGuardInitParam, initCallback);
        }
    }

    private final void initInstance(Context applicationContext) {
        SubTicketGuardManager subTicketGuardManager;
        if (service == null) {
            synchronized (this) {
                if (service == null) {
                    if (ProcessUtils.INSTANCE.isMainProcess(applicationContext)) {
                        subTicketGuardManager = new MainTicketGuardManager();
                    } else {
                        subTicketGuardManager = new SubTicketGuardManager();
                    }
                    service = subTicketGuardManager;
                    TicketGuardApi.INSTANCE.register(subTicketGuardManager);
                    TicketGuardInnerFrameWork.INSTANCE.setManager(subTicketGuardManager);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
