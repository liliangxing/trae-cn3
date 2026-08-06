package io.noties.markwon.span;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StandardLineHeightSpan.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J8\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lio/noties/markwon/span/StandardLineHeightSpan;", "Landroid/text/style/LineHeightSpan;", "height", "", "(I)V", "getHeight", "()I", "chooseHeight", "", "text", "", "start", "end", "spanstartv", "lineHeight", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class StandardLineHeightSpan implements LineHeightSpan {
    private final int height;

    public StandardLineHeightSpan(int i) {
        this.height = i;
        if (!(i > 0)) {
            throw new IllegalArgumentException(("Height: %d must be positive" + i).toString());
        }
    }

    public final int getHeight() {
        return this.height;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence text, int start, int end, int spanstartv, int lineHeight, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fm, "fm");
        int i = fm.descent - fm.ascent;
        if (i <= 0) {
            return;
        }
        fm.descent = Math.round(fm.descent * ((this.height * 1.0f) / i));
        fm.ascent = fm.descent - this.height;
    }
}
