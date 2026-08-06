package com.lynx.tasm.behavior.p000ui.list;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.lynx.tasm.behavior.p000ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.p000ui.utils.BorderRadius;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ScrollContainerDrawHelper {
    private Rect mUiBound = null;

    public void setUiBound(Rect rect) {
        this.mUiBound = rect;
    }

    public Path getClipPath(View view) {
        if (view == null) {
            return null;
        }
        Path path = new Path();
        Drawable background = view.getBackground();
        int scrollX = view.getScrollX();
        int scrollY = view.getScrollY();
        int width = view.getWidth();
        int height = view.getHeight();
        if (background instanceof BackgroundDrawable) {
            BackgroundDrawable backgroundDrawable = (BackgroundDrawable) background;
            RectF directionAwareBorderInsets = backgroundDrawable.getDirectionAwareBorderInsets();
            BorderRadius borderRadius = backgroundDrawable.getBorderRadius();
            Rect rect = this.mUiBound;
            if (rect == null) {
                rect = background.getBounds();
            }
            RectF rectF = new RectF(rect.left + scrollX + directionAwareBorderInsets.left, rect.top + scrollY + directionAwareBorderInsets.top, (scrollX + rect.right) - directionAwareBorderInsets.right, (scrollY + rect.bottom) - directionAwareBorderInsets.bottom);
            if (borderRadius == null) {
                path.addRect(rectF, Path.Direction.CW);
            } else {
                path.addRoundRect(rectF, BackgroundDrawable.RoundRectPath.newBorderRadius(borderRadius.getArray(), directionAwareBorderInsets, 1.0f), Path.Direction.CW);
            }
        } else {
            Rect rect2 = this.mUiBound;
            if (rect2 == null) {
                rect2 = new Rect(0, 0, width, height);
            }
            path.addRect(new RectF(rect2.left + scrollX, rect2.top + scrollY, scrollX + rect2.right, scrollY + rect2.bottom), Path.Direction.CW);
        }
        return path;
    }
}
