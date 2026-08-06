package io.noties.markwon.ext.tasklist;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.utils.LeadingMarginUtils;

/* loaded from: classes7.dex */
public class TaskListSpan implements LeadingMarginSpan {
    private static final int[] STATE_CHECKED = {android.R.attr.state_checked};
    private static final int[] STATE_NONE = new int[0];
    private final Drawable drawable;
    private boolean isDone;
    private final MarkwonTheme theme;

    public TaskListSpan(MarkwonTheme markwonTheme, Drawable drawable, boolean z) {
        this.theme = markwonTheme;
        this.drawable = drawable;
        this.isDone = z;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public void setDone(boolean z) {
        this.isDone = z;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return this.theme.getBlockMargin();
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int i8;
        int[] iArr;
        if (z && LeadingMarginUtils.selfStart(i6, charSequence, this)) {
            float descent = paint.descent();
            float ascent = paint.ascent();
            int save = canvas.save();
            try {
                int blockMargin = this.theme.getBlockMargin();
                int i9 = (int) ((blockMargin * 0.75f) + 0.5f);
                this.drawable.setBounds(0, 0, i9, (int) ((((int) ((descent - ascent) + 0.5f)) * 0.75f) + 0.5f));
                if (this.drawable.isStateful()) {
                    if (this.isDone) {
                        iArr = STATE_CHECKED;
                    } else {
                        iArr = STATE_NONE;
                    }
                    this.drawable.setState(iArr);
                }
                if (i2 > 0) {
                    i8 = i + ((blockMargin - i9) / 2);
                } else {
                    i8 = (i - ((blockMargin - i9) / 2)) - i9;
                }
                canvas.translate(i8, ((int) (i4 + ascent + 0.5f)) + ((r6 - r12) / 2));
                this.drawable.draw(canvas);
            } finally {
                canvas.restoreToCount(save);
            }
        }
    }
}
