package com.edu.onetex;

import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DimensionUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002¨\u0006\u0005"}, d2 = {"dp2px", "", "", "dp2pxf", "", "onetex_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class DimensionUtilKt {
    public static final int dp2px(Number dp2px) {
        Intrinsics.checkNotNullParameter(dp2px, "$this$dp2px");
        return (int) TypedValue.applyDimension(1, dp2px.floatValue(), ScreenUtilKt.getRes().getDisplayMetrics());
    }

    public static final float dp2pxf(Number dp2pxf) {
        Intrinsics.checkNotNullParameter(dp2pxf, "$this$dp2pxf");
        return TypedValue.applyDimension(1, dp2pxf.floatValue(), ScreenUtilKt.getRes().getDisplayMetrics());
    }
}
