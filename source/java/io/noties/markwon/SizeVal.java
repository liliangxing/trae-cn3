package io.noties.markwon;

import android.text.TextPaint;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

/* compiled from: SizeVal.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lio/noties/markwon/SizeVal;", "", "()V", "paint", "Landroid/text/TextPaint;", "getPaint", "()Landroid/text/TextPaint;", "setPaint", "(Landroid/text/TextPaint;)V", "tableMaxWidth", "Ljava/util/concurrent/atomic/AtomicInteger;", "width", "", "getWidth", "()I", "setWidth", "(I)V", "getTabMaxWidth", "setTableMaxWidth", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class SizeVal {
    private static TextPaint paint;
    private static int width;
    public static final SizeVal INSTANCE = new SizeVal();
    private static final AtomicInteger tableMaxWidth = new AtomicInteger();

    private SizeVal() {
    }

    public final int getWidth() {
        return width;
    }

    public final void setWidth(int i) {
        width = i;
    }

    public final TextPaint getPaint() {
        return paint;
    }

    public final void setPaint(TextPaint textPaint) {
        paint = textPaint;
    }

    public final void setTableMaxWidth(int width2) {
        tableMaxWidth.set(width2);
    }

    public final int getTabMaxWidth() {
        return tableMaxWidth.get();
    }
}
