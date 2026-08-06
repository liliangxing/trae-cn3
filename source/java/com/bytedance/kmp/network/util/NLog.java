package com.bytedance.kmp.network.util;

import com.bytedance.lynx.service.image.LynxImageService;
import com.bytedance.push.frontier.interfaze.IFrontierMonitor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NLog.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0086\bø\u0001\u0000J\u001c\u0010\r\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0086\bø\u0001\u0000J&\u0010\r\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0086\bø\u0001\u0000J\u001c\u0010\u000f\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0086\bø\u0001\u0000J.\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0081\bø\u0001\u0000J\u001c\u0010\u0013\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0086\bø\u0001\u0000J\u001c\u0010\u0014\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0086\bø\u0001\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"Lcom/bytedance/kmp/network/util/NLog;", "", "()V", "level", "Lcom/bytedance/kmp/network/util/NLog$Level;", "getLevel", "()Lcom/bytedance/kmp/network/util/NLog$Level;", "setLevel", "(Lcom/bytedance/kmp/network/util/NLog$Level;)V", "d", "", "lazyMsg", "Lkotlin/Function0;", "e", "", "i", IFrontierMonitor.KEY_LOG, LynxImageService.PRIORITY_KEY, "throwable", "v", "w", "Level", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NLog {
    public static final NLog INSTANCE = new NLog();
    private static Level level = Level.INFO;

    /* compiled from: NLog.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/kmp/network/util/NLog$Level;", "", "(Ljava/lang/String;I)V", "VERBOSE", "DEBUG", "INFO", "WARN", "ERROR", "NONE", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum Level {
        VERBOSE,
        DEBUG,
        INFO,
        WARN,
        ERROR,
        NONE
    }

    private NLog() {
    }

    public final Level getLevel() {
        return level;
    }

    public final void setLevel(Level level2) {
        Intrinsics.checkNotNullParameter(level2, "<set-?>");
        level = level2;
    }

    /* renamed from: v */
    public final void m78v(Function0<? extends Object> lazyMsg) {
        String str;
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        Level level2 = Level.VERBOSE;
        if (level2.compareTo(getLevel()) >= 0) {
            Object invoke = lazyMsg.invoke();
            if (invoke == null || (str = invoke.toString()) == null) {
                str = "null";
            }
            System.out.println((Object) ("[" + StringsKt.first(level2.name()) + "][kmp-ttnet] " + str));
        }
    }

    /* renamed from: d */
    public final void m74d(Function0<? extends Object> lazyMsg) {
        String str;
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        Level level2 = Level.DEBUG;
        if (level2.compareTo(getLevel()) >= 0) {
            Object invoke = lazyMsg.invoke();
            if (invoke == null || (str = invoke.toString()) == null) {
                str = "null";
            }
            System.out.println((Object) ("[" + StringsKt.first(level2.name()) + "][kmp-ttnet] " + str));
        }
    }

    /* renamed from: i */
    public final void m77i(Function0<? extends Object> lazyMsg) {
        String str;
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        Level level2 = Level.INFO;
        if (level2.compareTo(getLevel()) >= 0) {
            Object invoke = lazyMsg.invoke();
            if (invoke == null || (str = invoke.toString()) == null) {
                str = "null";
            }
            System.out.println((Object) ("[" + StringsKt.first(level2.name()) + "][kmp-ttnet] " + str));
        }
    }

    /* renamed from: w */
    public final void m79w(Function0<? extends Object> lazyMsg) {
        String str;
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        Level level2 = Level.WARN;
        if (level2.compareTo(getLevel()) >= 0) {
            Object invoke = lazyMsg.invoke();
            if (invoke == null || (str = invoke.toString()) == null) {
                str = "null";
            }
            System.out.println((Object) ("[" + StringsKt.first(level2.name()) + "][kmp-ttnet] " + str));
        }
    }

    /* renamed from: e */
    public final void m76e(Function0<? extends Object> lazyMsg) {
        String str;
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        Level level2 = Level.ERROR;
        if (level2.compareTo(getLevel()) >= 0) {
            Object invoke = lazyMsg.invoke();
            if (invoke == null || (str = invoke.toString()) == null) {
                str = "null";
            }
            System.out.println((Object) ("[" + StringsKt.first(level2.name()) + "][kmp-ttnet] " + str));
        }
    }

    public static /* synthetic */ void e$default(NLog nLog, Throwable th, Function0 function0, int i, Object obj) {
        String str;
        if ((i & 2) != 0) {
            function0 = new Function0<String>() { // from class: com.bytedance.kmp.network.util.NLog$e$1
                public final String invoke() {
                    return "";
                }
            };
        }
        Intrinsics.checkNotNullParameter(th, "e");
        Intrinsics.checkNotNullParameter(function0, "lazyMsg");
        Level level2 = Level.ERROR;
        if (level2.compareTo(nLog.getLevel()) >= 0) {
            Object invoke = function0.invoke();
            if (invoke == null || (str = invoke.toString()) == null) {
                str = "null";
            }
            System.out.println((Object) ("[" + StringsKt.first(level2.name()) + "][kmp-ttnet] " + str));
            System.out.println((Object) ("[" + StringsKt.first(level2.name()) + "][kmp-ttnet] Exception: " + th));
        }
    }

    /* renamed from: e */
    public final void m75e(Throwable e, Function0<? extends Object> lazyMsg) {
        String str;
        Intrinsics.checkNotNullParameter(e, "e");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        Level level2 = Level.ERROR;
        if (level2.compareTo(getLevel()) >= 0) {
            Object invoke = lazyMsg.invoke();
            if (invoke == null || (str = invoke.toString()) == null) {
                str = "null";
            }
            System.out.println((Object) ("[" + StringsKt.first(level2.name()) + "][kmp-ttnet] " + str));
            System.out.println((Object) ("[" + StringsKt.first(level2.name()) + "][kmp-ttnet] Exception: " + e));
        }
    }

    public final void log(Level priority, Throwable throwable, Function0<? extends Object> lazyMsg) {
        String str;
        Intrinsics.checkNotNullParameter(priority, LynxImageService.PRIORITY_KEY);
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        if (priority.compareTo(getLevel()) < 0) {
            return;
        }
        Object invoke = lazyMsg.invoke();
        if (invoke == null || (str = invoke.toString()) == null) {
            str = "null";
        }
        System.out.println((Object) ("[" + StringsKt.first(priority.name()) + "][kmp-ttnet] " + str));
        if (throwable != null) {
            System.out.println((Object) ("[" + StringsKt.first(priority.name()) + "][kmp-ttnet] Exception: " + throwable));
        }
    }
}
