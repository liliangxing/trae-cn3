package com.edu.onetex;

import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScreenUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007\"\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"res", "Landroid/content/res/Resources;", "getRes", "()Landroid/content/res/Resources;", "scaledDensity", "", "getScaledDensity", "()F", "screenDensity", "getScreenDensity", "screenHeight", "", "getScreenHeight", "()I", "screenWidth", "getScreenWidth", "onetex_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ScreenUtilKt {
    private static final Resources res;

    static {
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        res = system;
    }

    public static final Resources getRes() {
        return res;
    }

    public static final int getScreenWidth() {
        return res.getDisplayMetrics().widthPixels;
    }

    public static final int getScreenHeight() {
        return res.getDisplayMetrics().heightPixels;
    }

    public static final float getScreenDensity() {
        return res.getDisplayMetrics().density;
    }

    public static final float getScaledDensity() {
        return res.getDisplayMetrics().scaledDensity;
    }
}
