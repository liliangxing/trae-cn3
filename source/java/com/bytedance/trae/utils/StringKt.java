package com.bytedance.trae.utils;

import android.util.Base64;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: String.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u00020\u0002\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0002*\u00020\u0002\u001a(\u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u00022\u0014\b\u0004\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\bH\u0086\bø\u0001\u0000\u001a\f\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\u0002\u001a\f\u0010\u000b\u001a\u00020\u0002*\u0004\u0018\u00010\u0002\u001a\n\u0010\f\u001a\u00020\r*\u00020\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"isNotNullOrEmpty", "", "", "base64", "base64Decode", "runWhenNotEmpty", "", "block", "Lkotlin/Function1;", "getCodePointCount", "", "analysis", "getWordPercent", "", "utils_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class StringKt {
    public static final boolean isNotNullOrEmpty(String str) {
        if (str != null) {
            return str.length() > 0;
        }
        return false;
    }

    public static final String base64(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            obj = Result.constructor-impl(Base64.encodeToString(bytes, 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (String) obj;
    }

    public static final String base64Decode(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            byte[] decode = Base64.decode(str, 0);
            Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
            obj = Result.constructor-impl(new String(decode, Charsets.UTF_8));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (String) obj;
    }

    public static final void runWhenNotEmpty(String str, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        function1.invoke(str);
    }

    public static final int getCodePointCount(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return 0;
        }
        return str.codePointCount(0, str.length());
    }

    public static final String analysis(String str) {
        if (str == null) {
            return "be_null";
        }
        return str.length() == 0 ? "be_empty" : str;
    }

    public static final float getWordPercent(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int i = 0;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (!('A' <= charAt && charAt < '[')) {
                if (!('a' <= charAt && charAt < '{')) {
                    if (z) {
                        i2++;
                        i3++;
                        z = false;
                    }
                    i3++;
                    i++;
                }
            }
            i++;
            z = true;
        }
        if (z) {
            i2++;
            i3++;
        }
        FLogger.INSTANCE.mo425d("getWordPercent", "word = " + i2 + ", total = " + i3);
        return i2 / i3;
    }
}
