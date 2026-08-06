package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.net.UnknownHostException;

/* renamed from: com.xiaomi.push.el */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class C1586el {

    /* renamed from: com.xiaomi.push.el$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static class a {

        /* renamed from: a */
        EnumC1582eh f1622a;

        /* renamed from: a */
        String f1623a;

        a() {
        }
    }

    /* renamed from: a */
    private static void m2392a(Exception exc) {
        exc.getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Throwable] */
    /* renamed from: a */
    public static a m2391a(Exception exc) {
        m2392a(exc);
        boolean z = exc instanceof C1609fh;
        Exception exc2 = exc;
        if (z) {
            C1609fh c1609fh = (C1609fh) exc;
            exc2 = exc;
            if (c1609fh.m2560a() != null) {
                exc2 = c1609fh.m2560a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        int m2541a = C1603fb.m2541a(exc2);
        if (m2541a != 0) {
            aVar.f1622a = EnumC1582eh.m2345a(EnumC1582eh.GSLB_REQUEST_SUCCESS.m2346a() + m2541a);
        }
        if (aVar.f1622a == null) {
            aVar.f1622a = EnumC1582eh.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.f1622a == EnumC1582eh.GSLB_TCP_ERR_OTHER) {
            aVar.f1623a = str;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Throwable] */
    /* renamed from: b */
    public static a m2393b(Exception exc) {
        Throwable cause;
        m2392a(exc);
        boolean z = exc instanceof C1609fh;
        Exception exc2 = exc;
        if (z) {
            C1609fh c1609fh = (C1609fh) exc;
            exc2 = exc;
            if (c1609fh.m2560a() != null) {
                exc2 = c1609fh.m2560a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int m2541a = C1603fb.m2541a(exc2);
        String str = exc2.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (m2541a != 0) {
            aVar.f1622a = EnumC1582eh.m2345a(EnumC1582eh.CONN_SUCCESS.m2346a() + m2541a);
            if (aVar.f1622a == EnumC1582eh.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                aVar.f1622a = EnumC1582eh.CONN_BOSH_UNKNOWNHOST;
            }
        } else {
            aVar.f1622a = EnumC1582eh.CONN_XMPP_ERR;
        }
        if (aVar.f1622a == EnumC1582eh.CONN_TCP_ERR_OTHER || aVar.f1622a == EnumC1582eh.CONN_XMPP_ERR || aVar.f1622a == EnumC1582eh.CONN_BOSH_ERR) {
            aVar.f1623a = str;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Throwable] */
    /* renamed from: c */
    public static a m2394c(Exception exc) {
        m2392a(exc);
        boolean z = exc instanceof C1609fh;
        Exception exc2 = exc;
        if (z) {
            C1609fh c1609fh = (C1609fh) exc;
            exc2 = exc;
            if (c1609fh.m2560a() != null) {
                exc2 = c1609fh.m2560a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int m2541a = C1603fb.m2541a(exc2);
        String str = exc2.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (m2541a == 105) {
            aVar.f1622a = EnumC1582eh.BIND_TCP_READ_TIMEOUT;
        } else if (m2541a == 199) {
            aVar.f1622a = EnumC1582eh.BIND_TCP_ERR;
        } else if (m2541a == 499) {
            aVar.f1622a = EnumC1582eh.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.f1622a = EnumC1582eh.BIND_BOSH_ITEM_NOT_FOUND;
            }
        } else if (m2541a == 109) {
            aVar.f1622a = EnumC1582eh.BIND_TCP_CONNRESET;
        } else if (m2541a == 110) {
            aVar.f1622a = EnumC1582eh.BIND_TCP_BROKEN_PIPE;
        } else {
            aVar.f1622a = EnumC1582eh.BIND_XMPP_ERR;
        }
        if (aVar.f1622a == EnumC1582eh.BIND_TCP_ERR || aVar.f1622a == EnumC1582eh.BIND_XMPP_ERR || aVar.f1622a == EnumC1582eh.BIND_BOSH_ERR) {
            aVar.f1623a = str;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Throwable] */
    /* renamed from: d */
    public static a m2395d(Exception exc) {
        m2392a(exc);
        boolean z = exc instanceof C1609fh;
        Exception exc2 = exc;
        if (z) {
            C1609fh c1609fh = (C1609fh) exc;
            exc2 = exc;
            if (c1609fh.m2560a() != null) {
                exc2 = c1609fh.m2560a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        int m2541a = C1603fb.m2541a(exc2);
        String str = exc2.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (m2541a == 105) {
            aVar.f1622a = EnumC1582eh.CHANNEL_TCP_READTIMEOUT;
        } else if (m2541a == 199) {
            aVar.f1622a = EnumC1582eh.CHANNEL_TCP_ERR;
        } else if (m2541a == 499) {
            aVar.f1622a = EnumC1582eh.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.f1622a = EnumC1582eh.CHANNEL_BOSH_ITEMNOTFIND;
            }
        } else if (m2541a == 109) {
            aVar.f1622a = EnumC1582eh.CHANNEL_TCP_CONNRESET;
        } else if (m2541a == 110) {
            aVar.f1622a = EnumC1582eh.CHANNEL_TCP_BROKEN_PIPE;
        } else {
            aVar.f1622a = EnumC1582eh.CHANNEL_XMPPEXCEPTION;
        }
        if (aVar.f1622a == EnumC1582eh.CHANNEL_TCP_ERR || aVar.f1622a == EnumC1582eh.CHANNEL_XMPPEXCEPTION || aVar.f1622a == EnumC1582eh.CHANNEL_BOSH_EXCEPTION) {
            aVar.f1623a = str;
        }
        return aVar;
    }
}
