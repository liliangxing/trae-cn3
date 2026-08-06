package com.bytedance.rts.foundation;

import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: RTSString.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a#\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t\"\u00020\u0001¢\u0006\u0002\u0010\n\u001a#\u0010\u000b\u001a\u00020\f*\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000f\u001a\u001c\u0010\u0010\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u001a\u001e\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u001a\u001e\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u001a\u001e\u0010\u0017\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u001a,\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u001bj\b\u0012\u0004\u0012\u00020\u0001`\u001c*\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u001a#\u0010\u001f\u001a\u00020\f*\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000f\u001a\n\u0010 \u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010!\u001a\u00020\u0001*\u00020\u0001¨\u0006\""}, d2 = {"String", "", "x", "", "charAt", "pos", "", "concat", "strings", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "endsWith", "", "searchString", "endPosition", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Z", "includes", "str", "position", "padEnd", "length", "padString", "padStart", "slice", TraeAuthManager.STAGE_START, MetricConstant.MONITOR_STAGE_LOAD_TEMPLATE, "split", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/foundation/RTSArray;", "delimiters", "limit", "startsWith", "toLowerCase", "toUpperCase", "lib_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RTSStringKt {
    public static final String charAt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return String.valueOf(str.charAt(i));
    }

    public static final String concat(String str, String... strArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(strArr, "strings");
        StringBuilder sb = new StringBuilder(str);
        for (String str2 : strArr) {
            sb.append(str2);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "result.toString()");
        return sb2;
    }

    public static /* synthetic */ String slice$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return slice(str, i, i2);
    }

    public static final String slice(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i >= str.length() || i2 > str.length()) {
            return str;
        }
        if (i < 0) {
            i += str.length();
        }
        if (i2 < 0) {
            i2 += str.length();
        }
        return i >= i2 ? str : StringsKt.slice(str, RangesKt.until(i, i2));
    }

    public static /* synthetic */ ArrayList split$default(String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return split(str, str2, i);
    }

    public static final ArrayList<String> split(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "delimiters");
        List split$default = StringsKt.split$default(str, new String[]{str2}, false, 0, 4, (Object) null);
        if (i != 0) {
            split$default = CollectionsKt.take(split$default, i);
        }
        if (split$default.size() <= 1) {
            return new ArrayList<>(split$default);
        }
        Intrinsics.checkNotNull(split$default, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.String> }");
        return (ArrayList) split$default;
    }

    public static final String toLowerCase(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    public static final String toUpperCase(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }

    public static /* synthetic */ boolean includes$default(String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return includes(str, str2, i);
    }

    public static final boolean includes(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "str");
        if (i >= str.length()) {
            return false;
        }
        if (i < 0) {
            return includes(str, str2, 0);
        }
        return StringsKt.indexOf$default(str, str2, i, false, 4, (Object) null) != -1;
    }

    public static /* synthetic */ String padStart$default(String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return padStart(str, i, str2);
    }

    public static final String padStart(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str2 == null) {
            str2 = " ";
        }
        if (str.length() >= i) {
            return str;
        }
        int length = i - str.length();
        StringBuilder sb = new StringBuilder();
        int length2 = length / str2.length();
        int length3 = length % str2.length();
        for (int i2 = 0; i2 < length2; i2++) {
            sb.append(str2);
        }
        if (length3 > 0) {
            String substring = str2.substring(0, length3);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(substring);
        }
        sb.append(str);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }

    public static /* synthetic */ String padEnd$default(String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return padEnd(str, i, str2);
    }

    public static final String padEnd(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str2 == null) {
            str2 = " ";
        }
        if (str.length() >= i) {
            return str;
        }
        int length = i - str.length();
        StringBuilder sb = new StringBuilder(str);
        int length2 = length / str2.length();
        int length3 = length % str2.length();
        for (int i2 = 0; i2 < length2; i2++) {
            sb.append(str2);
        }
        if (length3 > 0) {
            String substring = str2.substring(0, length3);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(substring);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }

    public static final String String(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "x");
        return obj.toString();
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        return startsWith(str, str2, num);
    }

    public static final boolean startsWith(String str, String str2, Integer num) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "searchString");
        return StringsKt.startsWith(str, str2, num != null ? num.intValue() : 0, false);
    }

    public static /* synthetic */ boolean endsWith$default(String str, String str2, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        return endsWith(str, str2, num);
    }

    public static final boolean endsWith(String str, String str2, Integer num) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "searchString");
        int coerceAtMost = num != null ? RangesKt.coerceAtMost(num.intValue(), str.length()) : str.length();
        if (coerceAtMost < str2.length()) {
            return false;
        }
        return StringsKt.regionMatches$default(str, coerceAtMost - str2.length(), str2, 0, str2.length(), false, 16, (Object) null);
    }
}
