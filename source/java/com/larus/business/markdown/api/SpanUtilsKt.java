package com.larus.business.markdown.api;

import android.graphics.Bitmap;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpanUtils.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0016\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"getLeadingMargin", "", "Landroid/text/Spanned;", "index", "orDefault", "Landroid/graphics/Bitmap$Config;", "defaultConfig", "markdown-api_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class SpanUtilsKt {
    public static final Bitmap.Config orDefault(Bitmap.Config config, Bitmap.Config defaultConfig) {
        Intrinsics.checkNotNullParameter(defaultConfig, "defaultConfig");
        return config == null ? defaultConfig : config;
    }

    public static final int getLeadingMargin(Spanned spanned, int i) {
        Intrinsics.checkNotNullParameter(spanned, "<this>");
        Object[] spans = spanned.getSpans(0, spanned.length(), LeadingMarginSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(0, length, LeadingMarginSpan::class.java)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : spans) {
            LeadingMarginSpan leadingMarginSpan = (LeadingMarginSpan) obj;
            if (spanned.getSpanStart(leadingMarginSpan) <= i && i <= spanned.getSpanEnd(leadingMarginSpan)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += ((LeadingMarginSpan) it.next()).getLeadingMargin(false);
        }
        return i2;
    }

    public static /* synthetic */ Bitmap.Config orDefault$default(Bitmap.Config config, Bitmap.Config config2, int i, Object obj) {
        if ((i & 1) != 0) {
            config2 = Bitmap.Config.ARGB_8888;
        }
        return orDefault(config, config2);
    }
}
