package io.noties.markwon.span;

import android.os.Build;
import android.text.style.LineBackgroundSpan;
import android.text.style.LineHeightSpan;
import kotlin.Metadata;

/* compiled from: SpanCompat.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lio/noties/markwon/span/SpanCompat;", "", "()V", "newLineBackgroundSpan", "Landroid/text/style/LineBackgroundSpan;", "color", "", "newLineHeightSpan", "Landroid/text/style/LineHeightSpan;", "height", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SpanCompat {
    public static final SpanCompat INSTANCE = new SpanCompat();

    private SpanCompat() {
    }

    public final LineBackgroundSpan newLineBackgroundSpan(int color) {
        if (Build.VERSION.SDK_INT >= 29) {
            return new LineBackgroundSpan.Standard(color);
        }
        return new StandardLineBackgroundSpan(color);
    }

    public final LineHeightSpan newLineHeightSpan(int height) {
        if (Build.VERSION.SDK_INT >= 29) {
            return new LineHeightSpan.Standard(height);
        }
        return new StandardLineHeightSpan(height);
    }
}
