package com.bytedance.lego.init.util;

import android.util.Log;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.lego.init.InitScheduler;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u001a\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u001a\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/lego/init/util/InitLogger;", "", "()V", "MAX_LENGTH", "", "TAG", "", AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, "", "classname", "message", "e", RXScreenCaptureService.KEY_INDEX, "isDebug", "", BaseSwitches.V, "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class InitLogger {
    public static final InitLogger INSTANCE = new InitLogger();
    private static final int MAX_LENGTH = 3072;
    private static final String TAG = "#inittask#";

    public final void d(String str) {
        d$default(this, null, str, 1, null);
    }

    public final void e(String str) {
        e$default(this, null, str, 1, null);
    }

    public final void i(String str) {
        i$default(this, null, str, 1, null);
    }

    public final void v(String str) {
        v$default(this, null, str, 1, null);
    }

    private InitLogger() {
    }

    public static /* synthetic */ void v$default(InitLogger initLogger, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        initLogger.v(str, str2);
    }

    public final void v(String classname, String message) {
        Intrinsics.checkParameterIsNotNull(classname, "classname");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release()) {
            String str = classname + ' ' + message;
            int length = str.length();
            int i = 1;
            int i2 = MAX_LENGTH;
            int i3 = 0;
            while (i <= 100) {
                if (length > i2) {
                    String str2 = TAG + i;
                    if (str == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    String substring = str.substring(i3, i2);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.v(str2, substring);
                    i++;
                    i3 = i2;
                    i2 += MAX_LENGTH;
                } else {
                    String str3 = TAG + i;
                    if (str == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    String substring2 = str.substring(i3, length);
                    Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.v(str3, substring2);
                    return;
                }
            }
        }
    }

    public static /* synthetic */ void d$default(InitLogger initLogger, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        initLogger.d(str, str2);
    }

    public final void d(String classname, String message) {
        Intrinsics.checkParameterIsNotNull(classname, "classname");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release()) {
            String str = classname + ' ' + message;
            int length = str.length();
            int i = 1;
            int i2 = MAX_LENGTH;
            int i3 = 0;
            while (i <= 100) {
                if (length > i2) {
                    String str2 = TAG + i;
                    if (str == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    String substring = str.substring(i3, i2);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.d(str2, substring);
                    i++;
                    i3 = i2;
                    i2 += MAX_LENGTH;
                } else {
                    String str3 = TAG + i;
                    if (str == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    String substring2 = str.substring(i3, length);
                    Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.d(str3, substring2);
                    return;
                }
            }
        }
    }

    public static /* synthetic */ void i$default(InitLogger initLogger, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        initLogger.i(str, str2);
    }

    public final void i(String classname, String message) {
        Intrinsics.checkParameterIsNotNull(classname, "classname");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release()) {
            String str = classname + ' ' + message;
            int length = str.length();
            int i = 1;
            int i2 = MAX_LENGTH;
            int i3 = 0;
            while (i <= 100) {
                if (length > i2) {
                    String str2 = TAG + i;
                    if (str == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    String substring = str.substring(i3, i2);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.i(str2, substring);
                    i++;
                    i3 = i2;
                    i2 += MAX_LENGTH;
                } else {
                    String str3 = TAG + i;
                    if (str == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    String substring2 = str.substring(i3, length);
                    Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.i(str3, substring2);
                    return;
                }
            }
        }
    }

    public static /* synthetic */ void e$default(InitLogger initLogger, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        initLogger.e(str, str2);
    }

    public final void e(String classname, String message) {
        Intrinsics.checkParameterIsNotNull(classname, "classname");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Log.e(TAG, classname + ' ' + message);
    }

    public final boolean isDebug() {
        return InitScheduler.INSTANCE.isDebug$initscheduler_release();
    }
}
