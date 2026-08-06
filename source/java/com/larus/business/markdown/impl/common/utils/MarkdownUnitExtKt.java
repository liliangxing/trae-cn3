package com.larus.business.markdown.impl.common.utils;

import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkdownUnitExt.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0004*\u00020\u0002¨\u0006\b"}, d2 = {"dp2px", "", "", "dp2pxFloat", "", "px2dp", "sp2px", "sp2pxFloat", "markdown-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class MarkdownUnitExtKt {
    public static final float px2dp(Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return (number.floatValue() / Resources.getSystem().getDisplayMetrics().density) + 0.5f;
    }

    public static final int dp2px(Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return (int) ((number.floatValue() * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static final float dp2pxFloat(Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return number.floatValue() * Resources.getSystem().getDisplayMetrics().density;
    }

    public static final int sp2px(Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return (int) ((number.floatValue() * Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static final float sp2pxFloat(Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return number.floatValue() * Resources.getSystem().getDisplayMetrics().scaledDensity;
    }
}
