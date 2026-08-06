package com.bytedance.forest.utils;

import android.util.Log;
import com.bytedance.applog.server.Api;
import com.ss.android.agilelogger.ALog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J«\u0001\u0010\u0011\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00132c\b\u0002\u0010\u0014\u001a]\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015j\u0004\u0018\u0001`\u00182\b\b\u0002\u0010\t\u001a\u00020\u00042\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001aJ&\u0010\u001b\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rJ·\u0001\u0010\u001b\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0012\u001a\u00020\u00132c\b\u0002\u0010\u0014\u001a]\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015j\u0004\u0018\u0001`\u00182\b\b\u0002\u0010\t\u001a\u00020\u00042\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001aJ«\u0001\u0010\u001c\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00132c\b\u0002\u0010\u0014\u001a]\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015j\u0004\u0018\u0001`\u00182\b\b\u0002\u0010\t\u001a\u00020\u00042\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001aJ:\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u001a2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001aH\u0002Jp\u0010\u001e\u001a\u00020\u000f2h\u0010\u0005\u001ad\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0006j\u0002`\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000Rt\u0010\u0005\u001ah\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0006j\u0004\u0018\u0001`\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/forest/utils/LogUtils;", "", "()V", "TAG_PREFIX", "", "listener", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "logLevel", Api.COL_TAG, "msg", "", "throwable", "", "Lcom/bytedance/forest/utils/Listener;", "d", "needALog", "", "report", "Lkotlin/Function3;", "", "params", "Lcom/bytedance/forest/utils/LogReporter;", "extra", "", "e", "i", "processReportInfo", "setListener", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LogUtils {
    public static final LogUtils INSTANCE = new LogUtils();
    private static final String TAG_PREFIX = "Forest";
    private static Function4<? super Integer, ? super String, ? super String, ? super Throwable, Unit> listener;

    private LogUtils() {
    }

    public static /* synthetic */ int d$default(LogUtils logUtils, String str, String str2, boolean z, Function3 function3, String str3, Map map, int i, Object obj) {
        String str4;
        Function3 function32;
        Map map2;
        if ((i & 1) != 0) {
            str4 = null;
        } else {
            str4 = str;
        }
        boolean z2 = (i & 4) != 0 ? false : z;
        if ((i & 8) != 0) {
            function32 = null;
        } else {
            function32 = function3;
        }
        String str5 = (i & 16) != 0 ? "" : str3;
        if ((i & 32) != 0) {
            map2 = null;
        } else {
            map2 = map;
        }
        return logUtils.m288d(str4, str2, z2, function32, str5, map2);
    }

    /* renamed from: d */
    public final int m288d(String tag, String msg, boolean needALog, Function3<? super Integer, ? super String, ? super Map<String, ? extends Object>, Unit> report, String name, Map<String, Object> extra) {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Intrinsics.checkParameterIsNotNull(name, "name");
        Map<String, Object> processReportInfo = processReportInfo(name, msg, extra);
        String obj = processReportInfo.toString();
        Function4<? super Integer, ? super String, ? super String, ? super Throwable, Unit> function4 = listener;
        if (function4 != null) {
        }
        if (needALog) {
            if (report != null) {
                try {
                    if (name.length() > 0) {
                        report.invoke(3, "Forest_" + tag, processReportInfo);
                        return 1;
                    }
                } catch (Throwable unused) {
                    return Log.d("Forest_" + tag, obj);
                }
            }
            ALog.d("Forest_" + tag, obj);
            return 1;
        }
        return Log.d("Forest_" + tag, obj);
    }

    public static /* synthetic */ int i$default(LogUtils logUtils, String str, String str2, boolean z, Function3 function3, String str3, Map map, int i, Object obj) {
        String str4;
        Function3 function32;
        Map map2;
        if ((i & 1) != 0) {
            str4 = null;
        } else {
            str4 = str;
        }
        boolean z2 = (i & 4) != 0 ? false : z;
        if ((i & 8) != 0) {
            function32 = null;
        } else {
            function32 = function3;
        }
        String str5 = (i & 16) != 0 ? "" : str3;
        if ((i & 32) != 0) {
            map2 = null;
        } else {
            map2 = map;
        }
        return logUtils.m291i(str4, str2, z2, function32, str5, map2);
    }

    /* renamed from: i */
    public final int m291i(String tag, String msg, boolean needALog, Function3<? super Integer, ? super String, ? super Map<String, ? extends Object>, Unit> report, String name, Map<String, Object> extra) {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Intrinsics.checkParameterIsNotNull(name, "name");
        Map<String, Object> processReportInfo = processReportInfo(name, msg, extra);
        String obj = processReportInfo.toString();
        Function4<? super Integer, ? super String, ? super String, ? super Throwable, Unit> function4 = listener;
        if (function4 != null) {
        }
        if (needALog) {
            if (report != null) {
                try {
                    if ((name.length() > 0) && extra != null) {
                        report.invoke(4, "Forest_" + tag, processReportInfo);
                    }
                } catch (Throwable unused) {
                }
            }
            ALog.i("Forest_" + tag, obj);
        }
        return Log.i("Forest_" + tag, obj);
    }

    public static /* synthetic */ int e$default(LogUtils logUtils, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            th = null;
        }
        return logUtils.m289e(str, str2, th);
    }

    /* renamed from: e */
    public final int m289e(String tag, String msg, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Function4<? super Integer, ? super String, ? super String, ? super Throwable, Unit> function4 = listener;
        if (function4 != null) {
        }
        return Log.e("Forest_" + tag, msg, throwable);
    }

    public static /* synthetic */ int e$default(LogUtils logUtils, String str, String str2, Throwable th, boolean z, Function3 function3, String str3, Map map, int i, Object obj) {
        String str4;
        Throwable th2;
        Function3 function32;
        Map map2;
        if ((i & 1) != 0) {
            str4 = null;
        } else {
            str4 = str;
        }
        if ((i & 4) != 0) {
            th2 = null;
        } else {
            th2 = th;
        }
        boolean z2 = (i & 8) != 0 ? false : z;
        if ((i & 16) != 0) {
            function32 = null;
        } else {
            function32 = function3;
        }
        String str5 = (i & 32) != 0 ? "" : str3;
        if ((i & 64) != 0) {
            map2 = null;
        } else {
            map2 = map;
        }
        return logUtils.m290e(str4, str2, th2, z2, function32, str5, map2);
    }

    /* renamed from: e */
    public final int m290e(String tag, String msg, Throwable throwable, boolean needALog, Function3<? super Integer, ? super String, ? super Map<String, ? extends Object>, Unit> report, String name, Map<String, Object> extra) {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Intrinsics.checkParameterIsNotNull(name, "name");
        Map<String, Object> processReportInfo = processReportInfo(name, msg, extra);
        String obj = processReportInfo.toString();
        Function4<? super Integer, ? super String, ? super String, ? super Throwable, Unit> function4 = listener;
        if (function4 != null) {
        }
        if (needALog) {
            if (report != null) {
                try {
                    if ((name.length() > 0) && extra != null) {
                        report.invoke(6, "Forest_" + tag, processReportInfo);
                        return 1;
                    }
                } catch (Throwable unused) {
                    return Log.e("Forest_" + tag, obj, throwable);
                }
            }
            ALog.e("Forest_" + tag, obj, throwable);
            return 1;
        }
        return Log.e("Forest_" + tag, obj, throwable);
    }

    public final void setListener(Function4<? super Integer, ? super String, ? super String, ? super Throwable, Unit> listener2) {
        Intrinsics.checkParameterIsNotNull(listener2, "listener");
        listener = listener2;
    }

    private final Map<String, Object> processReportInfo(String name, String msg, Map<String, Object> extra) {
        if (extra == null) {
            extra = new HashMap(2);
        }
        extra.put("name", name);
        extra.put("message", msg);
        return extra;
    }
}
