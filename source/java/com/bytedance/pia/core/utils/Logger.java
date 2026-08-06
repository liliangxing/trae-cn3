package com.bytedance.pia.core.utils;

import android.util.Log;
import com.bytedance.notification.Constants;
import com.ss.android.agilelogger.ALog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Logger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0007J&\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J&\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0007J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006J&\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0007J&\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/pia/core/utils/Logger;", "", "()V", "TAG", "", "loggerClient", "Lcom/bytedance/pia/core/utils/Logger$LoggerClient;", "d", "", "message", "throwable", "", Constants.NOTIFICATION_TAG, "e", "formatMessageContent", "raw", "i", "setLoggerClient", "client", "v", "w", "LoggerClient", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class Logger {
    public static final Logger INSTANCE = new Logger();
    private static final String TAG = "PiaCore";
    private static LoggerClient loggerClient;

    @JvmStatic
    /* renamed from: d */
    public static final void m175d(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        d$default(str, null, null, 6, null);
    }

    @JvmStatic
    /* renamed from: d */
    public static final void m176d(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "message");
        d$default(str, th, null, 4, null);
    }

    @JvmStatic
    /* renamed from: e */
    public static final void m178e(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        e$default(str, null, null, 6, null);
    }

    @JvmStatic
    /* renamed from: e */
    public static final void m179e(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "message");
        e$default(str, th, null, 4, null);
    }

    @JvmStatic
    /* renamed from: i */
    public static final void m181i(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        i$default(str, null, null, 6, null);
    }

    @JvmStatic
    /* renamed from: i */
    public static final void m182i(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "message");
        i$default(str, th, null, 4, null);
    }

    @JvmStatic
    /* renamed from: v */
    public static final void m184v(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        v$default(str, null, null, 6, null);
    }

    @JvmStatic
    /* renamed from: v */
    public static final void m185v(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "message");
        v$default(str, th, null, 4, null);
    }

    @JvmStatic
    /* renamed from: w */
    public static final void m187w(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        w$default(str, null, null, 6, null);
    }

    @JvmStatic
    /* renamed from: w */
    public static final void m188w(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "message");
        w$default(str, th, null, 4, null);
    }

    private Logger() {
    }

    /* compiled from: Logger.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J$\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J$\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J$\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J$\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\r"}, d2 = {"Lcom/bytedance/pia/core/utils/Logger$LoggerClient;", "", "d", "", Constants.NOTIFICATION_TAG, "", "message", "throwable", "", "e", "i", "v", "w", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface LoggerClient {
        /* renamed from: d */
        void m190d(String tag, String message, Throwable throwable);

        /* renamed from: e */
        void m191e(String tag, String message, Throwable throwable);

        /* renamed from: i */
        void m192i(String tag, String message, Throwable throwable);

        /* renamed from: v */
        void m193v(String tag, String message, Throwable throwable);

        /* renamed from: w */
        void m194w(String tag, String message, Throwable throwable);

        /* compiled from: Logger.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final class DefaultImpls {
            public static /* synthetic */ void v$default(LoggerClient loggerClient, String str, String str2, Throwable th, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: v");
                }
                if ((i & 4) != 0) {
                    th = null;
                }
                loggerClient.m193v(str, str2, th);
            }

            public static /* synthetic */ void d$default(LoggerClient loggerClient, String str, String str2, Throwable th, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: d");
                }
                if ((i & 4) != 0) {
                    th = null;
                }
                loggerClient.m190d(str, str2, th);
            }

            public static /* synthetic */ void i$default(LoggerClient loggerClient, String str, String str2, Throwable th, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: i");
                }
                if ((i & 4) != 0) {
                    th = null;
                }
                loggerClient.m192i(str, str2, th);
            }

            public static /* synthetic */ void w$default(LoggerClient loggerClient, String str, String str2, Throwable th, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: w");
                }
                if ((i & 4) != 0) {
                    th = null;
                }
                loggerClient.m194w(str, str2, th);
            }

            public static /* synthetic */ void e$default(LoggerClient loggerClient, String str, String str2, Throwable th, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: e");
                }
                if ((i & 4) != 0) {
                    th = null;
                }
                loggerClient.m191e(str, str2, th);
            }
        }
    }

    public final void setLoggerClient(LoggerClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        loggerClient = client;
    }

    public static /* synthetic */ void v$default(String str, Throwable th, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            str2 = TAG;
        }
        m186v(str, th, str2);
    }

    @JvmStatic
    /* renamed from: v */
    public static final void m186v(String message, Throwable throwable, String tag) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        String formatMessageContent = INSTANCE.formatMessageContent(message);
        ALog.v(tag, formatMessageContent + Log.getStackTraceString(throwable));
        LoggerClient loggerClient2 = loggerClient;
        if (loggerClient2 != null) {
            loggerClient2.m193v(tag, formatMessageContent, throwable);
        }
    }

    public static /* synthetic */ void d$default(String str, Throwable th, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            str2 = TAG;
        }
        m177d(str, th, str2);
    }

    @JvmStatic
    /* renamed from: d */
    public static final void m177d(String message, Throwable throwable, String tag) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        String formatMessageContent = INSTANCE.formatMessageContent(message);
        ALog.d(tag, formatMessageContent + Log.getStackTraceString(throwable));
        LoggerClient loggerClient2 = loggerClient;
        if (loggerClient2 != null) {
            loggerClient2.m190d(tag, formatMessageContent, throwable);
        }
    }

    public static /* synthetic */ void i$default(String str, Throwable th, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            str2 = TAG;
        }
        m183i(str, th, str2);
    }

    @JvmStatic
    /* renamed from: i */
    public static final void m183i(String message, Throwable throwable, String tag) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        String formatMessageContent = INSTANCE.formatMessageContent(message);
        ALog.i(tag, formatMessageContent + Log.getStackTraceString(throwable));
        LoggerClient loggerClient2 = loggerClient;
        if (loggerClient2 != null) {
            loggerClient2.m192i(tag, formatMessageContent, throwable);
        }
    }

    public static /* synthetic */ void w$default(String str, Throwable th, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            str2 = TAG;
        }
        m189w(str, th, str2);
    }

    @JvmStatic
    /* renamed from: w */
    public static final void m189w(String message, Throwable throwable, String tag) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        String formatMessageContent = INSTANCE.formatMessageContent(message);
        ALog.w(tag, formatMessageContent + Log.getStackTraceString(throwable));
        LoggerClient loggerClient2 = loggerClient;
        if (loggerClient2 != null) {
            loggerClient2.m194w(tag, formatMessageContent, throwable);
        }
    }

    public static /* synthetic */ void e$default(String str, Throwable th, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            str2 = TAG;
        }
        m180e(str, th, str2);
    }

    @JvmStatic
    /* renamed from: e */
    public static final void m180e(String message, Throwable throwable, String tag) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        String formatMessageContent = INSTANCE.formatMessageContent(message);
        ALog.e(tag, formatMessageContent + Log.getStackTraceString(throwable));
        LoggerClient loggerClient2 = loggerClient;
        if (loggerClient2 != null) {
            loggerClient2.m191e(tag, formatMessageContent, throwable);
        }
    }

    private final String formatMessageContent(String raw) {
        return StringsKt.startsWith$default(raw, "[PIA]", false, 2, (Object) null) ? raw : "[PIA] " + raw;
    }
}
