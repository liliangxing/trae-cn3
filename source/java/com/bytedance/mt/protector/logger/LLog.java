package com.bytedance.mt.protector.logger;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.notification.Constants;
import com.google.gson.Gson;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LLog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u000e\b\u0004\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0019H\u0087\bJ5\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001c\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u001dJ3\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001c\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u0010J\u0006\u0010\"\u001a\u00020\u0010J3\u0010#\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001c\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u001dJ\u0019\u0010$\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0082 J\u001e\u0010%\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nJ?\u0010'\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010(\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010\n2\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001c\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010*J\"\u0010+\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00012\b\u0010&\u001a\u0004\u0018\u00010\nJ\"\u0010+\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010&\u001a\u0004\u0018\u00010\nJ\u001a\u0010,\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010-\u001a\u00020\u0004H\u0002J3\u0010.\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001c\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u001dJ3\u0010/\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001c\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/bytedance/mt/protector/logger/LLog;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "LINE_SEPARATOR", "", "kotlin.jvm.PlatformType", "SEGMENT_SIZE", "", "SO_NAME", "lubanLogImp", "Lcom/bytedance/mt/protector/logger/ILogger;", "mDebugLog", "mIsSetupLogger", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mSetupSuccess", "d", "", Constants.NOTIFICATION_TAG, "block", "Lkotlin/Function0;", "msg", "obj", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "t", "", "getDefaultLog", "getImpl", "i", "nativePrintCompleteLog", "printCompleteLog", "headString", "printErrStackTrace", "tr", "format", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "printJson", "printLine", "isTop", "v", "w", "protector_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LLog {
    private static boolean DEBUG = false;
    private static final String LINE_SEPARATOR;
    private static final int SEGMENT_SIZE = 512;
    private static final String SO_NAME = "logger";
    private static final ILogger lubanLogImp;
    private static final ILogger mDebugLog;
    public static final LLog INSTANCE = new LLog();
    private static final AtomicBoolean mIsSetupLogger = new AtomicBoolean(false);
    private static final AtomicBoolean mSetupSuccess = new AtomicBoolean(false);

    private final native void nativePrintCompleteLog(String tag, String msg);

    static {
        ILogger iLogger = new ILogger() { // from class: com.bytedance.mt.protector.logger.LLog$mDebugLog$1
            /* JADX WARN: Code restructure failed: missing block: B:26:0x0036, code lost:
            
                if (r11 != null) goto L15;
             */
            @Override // com.bytedance.mt.protector.logger.ILogger
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void printJson(String tag, String msg, String headString) {
                String str;
                String str2;
                String str3;
                Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
                String str4 = "";
                if (msg != null) {
                    try {
                        if (StringsKt.startsWith$default(msg, "{", false, 2, (Object) null)) {
                            msg = new JSONObject(msg).toString(4);
                        } else if (StringsKt.startsWith$default(msg, "[", false, 2, (Object) null)) {
                            msg = new JSONArray(msg).toString(4);
                        }
                        if (msg != null) {
                            str4 = msg;
                        }
                    } catch (JSONException unused) {
                    }
                }
                msg = str4;
                LLog.INSTANCE.printLine(tag, true);
                StringBuilder append = new StringBuilder().append(headString);
                LLog lLog = LLog.INSTANCE;
                str = LLog.LINE_SEPARATOR;
                String sb = append.append(str).append(msg).toString();
                LLog lLog2 = LLog.INSTANCE;
                str2 = LLog.LINE_SEPARATOR;
                if (!TextUtils.isEmpty(str2)) {
                    String str5 = sb;
                    LLog lLog3 = LLog.INSTANCE;
                    str3 = LLog.LINE_SEPARATOR;
                    Intrinsics.checkExpressionValueIsNotNull(str3, "LINE_SEPARATOR");
                    Object[] array = StringsKt.split$default(str5, new String[]{str3}, false, 0, 6, (Object) null).toArray(new String[0]);
                    if (array != null) {
                        for (String str6 : (String[]) array) {
                            Log.e(tag, "║ " + str6);
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                LLog.INSTANCE.printLine(tag, false);
            }

            @Override // com.bytedance.mt.protector.logger.ILogger
            /* renamed from: v */
            public void mo118v(String tag, String msg, Object... obj) {
                Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
                Intrinsics.checkParameterIsNotNull(msg, "msg");
                Intrinsics.checkParameterIsNotNull(obj, "obj");
                if (!(obj.length == 0)) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    Object[] copyOf = Arrays.copyOf(obj, obj.length);
                    msg = String.format(msg, Arrays.copyOf(copyOf, copyOf.length));
                    Intrinsics.checkExpressionValueIsNotNull(msg, "java.lang.String.format(format, *args)");
                }
                Log.v(tag, msg);
            }

            @Override // com.bytedance.mt.protector.logger.ILogger
            /* renamed from: i */
            public void mo117i(String tag, String msg, Object... obj) {
                Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
                Intrinsics.checkParameterIsNotNull(msg, "msg");
                Intrinsics.checkParameterIsNotNull(obj, "obj");
                if (!(obj.length == 0)) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    Object[] copyOf = Arrays.copyOf(obj, obj.length);
                    msg = String.format(msg, Arrays.copyOf(copyOf, copyOf.length));
                    Intrinsics.checkExpressionValueIsNotNull(msg, "java.lang.String.format(format, *args)");
                }
                Log.i(tag, msg);
            }

            @Override // com.bytedance.mt.protector.logger.ILogger
            /* renamed from: d */
            public void mo115d(String tag, String msg, Object... obj) {
                Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
                Intrinsics.checkParameterIsNotNull(msg, "msg");
                Intrinsics.checkParameterIsNotNull(obj, "obj");
                if (LLog.INSTANCE.getDEBUG()) {
                    if (!(obj.length == 0)) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        Object[] copyOf = Arrays.copyOf(obj, obj.length);
                        msg = String.format(msg, Arrays.copyOf(copyOf, copyOf.length));
                        Intrinsics.checkExpressionValueIsNotNull(msg, "java.lang.String.format(format, *args)");
                    }
                    Log.d(tag, msg);
                }
            }

            @Override // com.bytedance.mt.protector.logger.ILogger
            /* renamed from: w */
            public void mo119w(String tag, String msg, Object... obj) {
                Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
                Intrinsics.checkParameterIsNotNull(msg, "msg");
                Intrinsics.checkParameterIsNotNull(obj, "obj");
                if (!(obj.length == 0)) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    Object[] copyOf = Arrays.copyOf(obj, obj.length);
                    msg = String.format(msg, Arrays.copyOf(copyOf, copyOf.length));
                    Intrinsics.checkExpressionValueIsNotNull(msg, "java.lang.String.format(format, *args)");
                }
                Log.w(tag, msg);
            }

            @Override // com.bytedance.mt.protector.logger.ILogger
            /* renamed from: e */
            public void mo116e(String tag, String msg, Object... obj) {
                Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
                Intrinsics.checkParameterIsNotNull(msg, "msg");
                Intrinsics.checkParameterIsNotNull(obj, "obj");
                if (!(obj.length == 0)) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    Object[] copyOf = Arrays.copyOf(obj, obj.length);
                    msg = String.format(msg, Arrays.copyOf(copyOf, copyOf.length));
                    Intrinsics.checkExpressionValueIsNotNull(msg, "java.lang.String.format(format, *args)");
                }
                Log.e(tag, msg);
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
            
                if (r5 != null) goto L15;
             */
            /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:
            
                if (r5 != null) goto L15;
             */
            @Override // com.bytedance.mt.protector.logger.ILogger
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void printErrStackTrace(String tag, Throwable tr, String format, Object... obj) {
                Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
                Intrinsics.checkParameterIsNotNull(tr, "tr");
                Intrinsics.checkParameterIsNotNull(obj, "obj");
                if (!(obj.length == 0)) {
                    if (format != null) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        Object[] copyOf = Arrays.copyOf(obj, obj.length);
                        format = String.format(format, Arrays.copyOf(copyOf, copyOf.length));
                        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                    }
                    format = "";
                }
                Log.e(tag, format + "  " + Log.getStackTraceString(tr));
            }
        };
        mDebugLog = iLogger;
        lubanLogImp = iLogger;
        LINE_SEPARATOR = System.getProperty("line.separator");
    }

    private LLog() {
    }

    public final boolean getDEBUG() {
        return DEBUG;
    }

    public final void setDEBUG(boolean z) {
        DEBUG = z;
    }

    public final ILogger getDefaultLog() {
        return mDebugLog;
    }

    public final ILogger getImpl() {
        return lubanLogImp;
    }

    /* renamed from: v */
    public final void m125v(String tag, String msg, Object... obj) {
        Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Intrinsics.checkParameterIsNotNull(obj, "obj");
        lubanLogImp.mo118v(tag, msg, Arrays.copyOf(obj, obj.length));
    }

    /* renamed from: e */
    public final void m122e(String tag, String msg, Object... obj) {
        Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Intrinsics.checkParameterIsNotNull(obj, "obj");
        lubanLogImp.mo116e(tag, msg, Arrays.copyOf(obj, obj.length));
    }

    /* renamed from: e */
    public final void m123e(String tag, Throwable t) {
        Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
        Intrinsics.checkParameterIsNotNull(t, "t");
        ILogger iLogger = lubanLogImp;
        String localizedMessage = t.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = "";
        }
        iLogger.mo116e(tag, localizedMessage, new Object[0]);
    }

    /* renamed from: w */
    public final void m126w(String tag, String msg, Object... obj) {
        Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Intrinsics.checkParameterIsNotNull(obj, "obj");
        lubanLogImp.mo119w(tag, msg, Arrays.copyOf(obj, obj.length));
    }

    /* renamed from: i */
    public final void m124i(String tag, String msg, Object... obj) {
        Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Intrinsics.checkParameterIsNotNull(obj, "obj");
        lubanLogImp.mo117i(tag, msg, Arrays.copyOf(obj, obj.length));
    }

    @JvmStatic
    /* renamed from: d */
    public static final void m120d(String tag, String msg, Object... obj) {
        Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Intrinsics.checkParameterIsNotNull(obj, "obj");
        if (DEBUG) {
            lubanLogImp.mo115d(tag, msg, Arrays.copyOf(obj, obj.length));
        }
    }

    @JvmStatic
    /* renamed from: d */
    public static final void m121d(String tag, Function0<String> block) {
        Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
        Intrinsics.checkParameterIsNotNull(block, "block");
        if (INSTANCE.getDEBUG()) {
            m120d(tag, (String) block.invoke(), new Object[0]);
        }
    }

    @JvmStatic
    public static final void printErrStackTrace(String tag, Throwable tr, String format, Object... obj) {
        Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
        Intrinsics.checkParameterIsNotNull(tr, "tr");
        Intrinsics.checkParameterIsNotNull(obj, "obj");
        lubanLogImp.printErrStackTrace(tag, tr, format, Arrays.copyOf(obj, obj.length));
    }

    public final void printJson(String tag, String msg, String headString) {
        Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
        if (DEBUG) {
            lubanLogImp.printJson(tag, msg, headString);
        }
    }

    public final void printJson(String tag, Object msg, String headString) {
        Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
        if (DEBUG) {
            lubanLogImp.printJson(tag, new Gson().toJson(msg), headString);
        }
    }

    public final void printCompleteLog(String tag, String msg, String headString) {
        String substring;
        Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Intrinsics.checkParameterIsNotNull(headString, "headString");
        try {
            int i = 0;
            if (mIsSetupLogger.compareAndSet(false, true)) {
                System.loadLibrary(SO_NAME);
                mSetupSuccess.set(true);
            }
            if (mSetupSuccess.get()) {
                if (msg.length() <= 512) {
                    nativePrintCompleteLog(tag, headString + ':' + msg);
                    return;
                }
                while (i < msg.length()) {
                    int i2 = i + 512;
                    if (msg.length() <= i2) {
                        substring = msg.substring(i);
                        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                    } else {
                        substring = msg.substring(i, i2);
                        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    nativePrintCompleteLog(tag, headString + ':' + substring);
                    i = i2;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void printLine(String tag, boolean isTop) {
        if (isTop) {
            Log.e(tag, "╔═══════════════════════════════════════════════════════════════════════════════════════");
        } else {
            Log.e(tag, "╚═══════════════════════════════════════════════════════════════════════════════════════");
        }
    }
}
