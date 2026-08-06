package com.bytedance.lottie;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

/* loaded from: classes4.dex */
public class SimpleColorFilter extends PorterDuffColorFilter {
    public SimpleColorFilter(int i) {
        super(i, PorterDuff.Mode.SRC_ATOP);
    }
}
