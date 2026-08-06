package com.bytedance.tobshadow.bdtracker;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.tobshadow.applog.log.GlobalLoggerImpl;
import java.net.URL;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* renamed from: com.bytedance.tobshadow.bdtracker.x2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0547x2 {
    @JvmStatic
    /* renamed from: a */
    public static final void m744a(InterfaceC0526u2 interfaceC0526u2, long j, String str, int i) {
        if (str == null) {
            str = "";
        }
        C0429g3 c0429g3 = new C0429g3(j, str, 1L);
        c0429g3.f634a = i;
        if (interfaceC0526u2 != null) {
            ((C0561z2) interfaceC0526u2).m763a(c0429g3);
        }
    }

    @JvmStatic
    /* renamed from: a */
    public static final void m745a(InterfaceC0526u2 interfaceC0526u2, String str, String str2, long j) {
        InterfaceC0400c3 c0384a3;
        Intrinsics.checkParameterIsNotNull(str, "metricsName");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int hashCode = str.hashCode();
        if (hashCode != -73212100) {
            if (hashCode == 270071285 && str.equals("sdk_init")) {
                c0384a3 = new C0471m3(elapsedRealtime - j);
            }
            c0384a3 = null;
        } else {
            if (str.equals("api_usage")) {
                c0384a3 = new C0384a3(str2, elapsedRealtime - j);
            }
            c0384a3 = null;
        }
        if (c0384a3 == null || interfaceC0526u2 == null) {
            return;
        }
        ((C0561z2) interfaceC0526u2).m763a(c0384a3);
    }

    @JvmStatic
    /* renamed from: a */
    public static final void m746a(InterfaceC0526u2 interfaceC0526u2, Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        if (interfaceC0526u2 != null) {
            ((C0561z2) interfaceC0526u2).m763a(new C0422f3(th));
        }
    }

    @JvmStatic
    /* renamed from: b */
    public static final void m748b(InterfaceC0526u2 interfaceC0526u2, Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        boolean z = false;
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            Intrinsics.checkExpressionValueIsNotNull(stackTrace, "e.stackTrace");
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String stackTraceElement = stackTrace[i].toString();
                Intrinsics.checkExpressionValueIsNotNull(stackTraceElement, "ele.toString()");
                if (StringsKt.startsWith$default(stackTraceElement, "com.bytedance.tobshadow.applog", false, 2, (Object) null) || StringsKt.startsWith$default(stackTraceElement, "com.bytedance.tobshadow.bdtracker", false, 2, (Object) null)) {
                    z = true;
                    break;
                }
                i++;
            }
        } catch (Throwable th2) {
            GlobalLoggerImpl.global().error("TraceSDKError hasAppLog err", th2, new Object[0]);
        }
        if (!z || interfaceC0526u2 == null) {
            return;
        }
        ((C0561z2) interfaceC0526u2).m763a(new C0464l3(th));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    @JvmStatic
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m747a(InterfaceC0526u2 interfaceC0526u2, URL url, long j, int i, String str) {
        String str2;
        String[] split;
        Intrinsics.checkParameterIsNotNull(url, IWeixinService.ResponseConstants.URL);
        if (interfaceC0526u2 != null) {
            int i2 = 0;
            if ((url == null || TextUtils.isEmpty(url.getPath())) ? false : url.getPath().startsWith("/simulator/")) {
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            C0457k3 c0457k3 = new C0457k3();
            c0457k3.f721e = elapsedRealtime - j;
            if (url != null) {
                str2 = url.getPath();
                if (!TextUtils.isEmpty(str2)) {
                    if (str2.contains("/") && (split = url.getPath().split("/")) != null && split.length > 0) {
                        str2 = split[split.length - 1];
                    }
                    c0457k3.f720d = str2;
                    if (i != 200) {
                        i2 = 1;
                    } else {
                        c0457k3.f718b = Integer.valueOf(i);
                        c0457k3.f719c = str;
                    }
                    c0457k3.f717a = i2;
                    ((C0561z2) interfaceC0526u2).m763a(c0457k3);
                }
            }
            str2 = "";
            c0457k3.f720d = str2;
            if (i != 200) {
            }
            c0457k3.f717a = i2;
            ((C0561z2) interfaceC0526u2).m763a(c0457k3);
        }
    }
}
