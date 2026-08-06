package com.bytedance.android.sdk.bdticketguard;

import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u0005H\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"sdf", "Ljava/text/SimpleDateFormat;", "getSdf", "()Ljava/text/SimpleDateFormat;", "mask", "", "bd_ticket_guard_api_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class SnapshotKt {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");

    public static final SimpleDateFormat getSdf() {
        return sdf;
    }

    public static final String mask(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return String.valueOf(str);
        }
        if (str.length() < 30) {
            return "*****";
        }
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str.substring(0, 10);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        StringBuilder append = sb.append(substring).append("*****");
        int length = str.length() - 10;
        int length2 = str.length();
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring2 = str.substring(length, length2);
        Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return append.append(substring2).toString();
    }
}
