package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.net.UnknownHostException;

/* loaded from: classes7.dex */
final class el {

    /* loaded from: classes7.dex */
    static class a {
        eh a;

        /* renamed from: a, reason: collision with other field name */
        String f438a;

        a() {
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static void m9858a(Exception exc) {
        exc.getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Throwable] */
    public static a a(Exception exc) {
        m9858a(exc);
        boolean z = exc instanceof fh;
        Exception exc2 = exc;
        if (z) {
            fh fhVar = (fh) exc;
            exc2 = exc;
            if (fhVar.a() != null) {
                exc2 = fhVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        int a2 = fb.a(exc2);
        if (a2 != 0) {
            aVar.a = eh.a(eh.GSLB_REQUEST_SUCCESS.a() + a2);
        }
        if (aVar.a == null) {
            aVar.a = eh.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.a == eh.GSLB_TCP_ERR_OTHER) {
            aVar.f438a = str;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Throwable] */
    public static a b(Exception exc) {
        Throwable cause;
        m9858a(exc);
        boolean z = exc instanceof fh;
        Exception exc2 = exc;
        if (z) {
            fh fhVar = (fh) exc;
            exc2 = exc;
            if (fhVar.a() != null) {
                exc2 = fhVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = fb.a(exc2);
        String str = exc2.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (a2 != 0) {
            aVar.a = eh.a(eh.CONN_SUCCESS.a() + a2);
            if (aVar.a == eh.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                aVar.a = eh.CONN_BOSH_UNKNOWNHOST;
            }
        } else {
            aVar.a = eh.CONN_XMPP_ERR;
        }
        if (aVar.a == eh.CONN_TCP_ERR_OTHER || aVar.a == eh.CONN_XMPP_ERR || aVar.a == eh.CONN_BOSH_ERR) {
            aVar.f438a = str;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Throwable] */
    public static a c(Exception exc) {
        m9858a(exc);
        boolean z = exc instanceof fh;
        Exception exc2 = exc;
        if (z) {
            fh fhVar = (fh) exc;
            exc2 = exc;
            if (fhVar.a() != null) {
                exc2 = fhVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = fb.a(exc2);
        String str = exc2.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (a2 == 105) {
            aVar.a = eh.BIND_TCP_READ_TIMEOUT;
        } else if (a2 == 199) {
            aVar.a = eh.BIND_TCP_ERR;
        } else if (a2 == 499) {
            aVar.a = eh.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.a = eh.BIND_BOSH_ITEM_NOT_FOUND;
            }
        } else if (a2 == 109) {
            aVar.a = eh.BIND_TCP_CONNRESET;
        } else if (a2 == 110) {
            aVar.a = eh.BIND_TCP_BROKEN_PIPE;
        } else {
            aVar.a = eh.BIND_XMPP_ERR;
        }
        if (aVar.a == eh.BIND_TCP_ERR || aVar.a == eh.BIND_XMPP_ERR || aVar.a == eh.BIND_BOSH_ERR) {
            aVar.f438a = str;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Throwable] */
    public static a d(Exception exc) {
        m9858a(exc);
        boolean z = exc instanceof fh;
        Exception exc2 = exc;
        if (z) {
            fh fhVar = (fh) exc;
            exc2 = exc;
            if (fhVar.a() != null) {
                exc2 = fhVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        int a2 = fb.a(exc2);
        String str = exc2.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (a2 == 105) {
            aVar.a = eh.CHANNEL_TCP_READTIMEOUT;
        } else if (a2 == 199) {
            aVar.a = eh.CHANNEL_TCP_ERR;
        } else if (a2 == 499) {
            aVar.a = eh.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.a = eh.CHANNEL_BOSH_ITEMNOTFIND;
            }
        } else if (a2 == 109) {
            aVar.a = eh.CHANNEL_TCP_CONNRESET;
        } else if (a2 == 110) {
            aVar.a = eh.CHANNEL_TCP_BROKEN_PIPE;
        } else {
            aVar.a = eh.CHANNEL_XMPPEXCEPTION;
        }
        if (aVar.a == eh.CHANNEL_TCP_ERR || aVar.a == eh.CHANNEL_XMPPEXCEPTION || aVar.a == eh.CHANNEL_BOSH_EXCEPTION) {
            aVar.f438a = str;
        }
        return aVar;
    }
}
