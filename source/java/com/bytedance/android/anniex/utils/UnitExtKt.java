package com.bytedance.android.anniex.utils;

import android.content.res.Resources;
import android.util.TypedValue;
import io.noties.markwon.image.CustomImageSizeResolverDef;
import kotlin.Metadata;

/* compiled from: UnitExt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005\"\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\n\u0010\b\"\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\f\u0010\b\"\u0015\u0010\r\u001a\u00020\u0004*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {CustomImageSizeResolverDef.UNIT_DP, "", "getDp", "(F)F", "", "(I)I", "dp2px", "getDp2px", "(F)I", "px2dp", "getPx2dp", "px2sp", "getPx2sp", "sp2px", "getSp2px", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class UnitExtKt {
    public static final float getDp(float f) {
        return TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }

    public static final int getDp(int i) {
        return (int) TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics());
    }

    public static final int getDp2px(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static final int getPx2dp(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static final int getSp2px(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static final int getPx2sp(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
