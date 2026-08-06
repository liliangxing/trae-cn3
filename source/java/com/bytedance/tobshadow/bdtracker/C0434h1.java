package com.bytedance.tobshadow.bdtracker;

import androidx.viewpager.widget.ViewPager;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.bytedance.tobshadow.bdtracker.h1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0434h1 implements ViewPager.OnPageChangeListener {

    /* renamed from: a */
    public int f643a;

    /* renamed from: b */
    public int f644b;

    /* renamed from: c */
    public final int f645c;

    /* renamed from: d */
    public final Function3<Float, Float, Integer, Unit> f646d;

    /* JADX WARN: Multi-variable type inference failed */
    public C0434h1(int i, Function3<? super Float, ? super Float, ? super Integer, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "sendScrollObserveCallback");
        this.f645c = i;
        this.f646d = function3;
        this.f644b = -1;
    }

    public void onPageScrollStateChanged(int i) {
        if (i == 0 && Math.abs(this.f643a) >= this.f645c) {
            this.f646d.invoke(Float.valueOf(this.f643a), Float.valueOf(0.0f), Integer.valueOf(this.f643a > this.f644b ? 4 : 3));
            this.f643a = 0;
            this.f644b = -1;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (Math.abs(i2) > this.f645c || Math.abs(0) > this.f645c) {
            int i3 = this.f643a;
            this.f643a = i2 > 0 ? Math.max(i3, i2) : Math.min(i3, i2);
        }
        if (this.f644b == -1) {
            this.f644b = this.f643a;
        }
    }

    public void onPageSelected(int i) {
    }
}
