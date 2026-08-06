package com.bytedance.tobshadow.bdtracker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.bytedance.tobshadow.bdtracker.x0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0545x0 extends C0552y0 {

    /* renamed from: b */
    public final Paint f1221b;

    public C0545x0(Drawable drawable) {
        super(drawable);
        Paint paint = new Paint();
        this.f1221b = paint;
        paint.setColor(-256);
        paint.setStrokeWidth(8.0f);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Drawable drawable = this.f1252a;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        canvas.drawRect(new Rect(0, 0, canvas.getWidth(), canvas.getHeight()), this.f1221b);
    }
}
