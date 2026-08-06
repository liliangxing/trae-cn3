package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LineBackgroundSpan;
import com.lynx.tasm.behavior.p000ui.utils.LynxBackground;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxTextBackgroundSpan implements LineBackgroundSpan {
    private LynxBackground mBackground;
    private boolean mIsVisible = true;
    private HashMap<Integer, int[]> mLineStartEndPositions;
    private int mSpanEnd;
    private int mSpanStart;

    @Override // android.text.style.LineBackgroundSpan
    public void drawBackground(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, int i8) {
        HashMap<Integer, int[]> hashMap;
        int[] iArr;
        if (this.mBackground == null || (hashMap = this.mLineStartEndPositions) == null || !this.mIsVisible || !hashMap.containsKey(Integer.valueOf(i8)) || (iArr = this.mLineStartEndPositions.get(Integer.valueOf(i8))) == null || iArr.length != 2 || this.mBackground.getDrawable() == null) {
            return;
        }
        this.mBackground.getDrawable().setBounds(Math.min(iArr[0], iArr[1]), i3, Math.max(iArr[0], iArr[1]), i5);
        this.mBackground.getDrawable().draw(canvas);
    }

    public LynxTextBackgroundSpan(int i, int i2, LynxBackground lynxBackground) {
        this.mSpanStart = i;
        this.mSpanEnd = i2;
        this.mBackground = lynxBackground;
    }

    public void updateSpanPosition(Layout layout) {
        this.mLineStartEndPositions = new HashMap<>();
        for (int lineForOffset = layout.getLineForOffset(this.mSpanStart); lineForOffset <= layout.getLineForOffset(this.mSpanEnd); lineForOffset++) {
            int lineStart = layout.getLineStart(lineForOffset);
            int lineEnd = layout.getLineEnd(lineForOffset);
            int i = this.mSpanStart;
            if (i > lineStart && i < lineEnd) {
                lineStart = i;
            }
            int i2 = this.mSpanEnd;
            if (i2 > lineStart && i2 < lineEnd) {
                lineEnd = i2;
            }
            int primaryHorizontal = (int) layout.getPrimaryHorizontal(lineStart);
            int primaryHorizontal2 = (int) layout.getPrimaryHorizontal(lineEnd);
            if (lineStart == layout.getLineStart(lineForOffset)) {
                primaryHorizontal = (int) layout.getLineLeft(lineForOffset);
            }
            if (lineEnd == layout.getLineEnd(lineForOffset)) {
                primaryHorizontal2 = (int) layout.getLineRight(lineForOffset);
            }
            this.mLineStartEndPositions.put(Integer.valueOf(lineForOffset), new int[]{primaryHorizontal, primaryHorizontal2});
        }
    }

    public void updateBackgroundStartEndIndex(int i) {
        this.mSpanStart += i;
        this.mSpanEnd += i;
    }

    public void updateBackgroundEndIndex(int i) {
        if (this.mSpanStart >= i) {
            this.mIsVisible = false;
        } else if (this.mSpanEnd > i) {
            this.mSpanEnd = i;
        }
    }
}
