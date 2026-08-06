package com.bytedance.sdk.open.aweme.p001ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CircleImageView extends ImageView {
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int COLORDRAWABLE_DIMENSION = 2;
    private int boarder;
    private Paint paint;

    public CircleImageView(Context context) {
        this(context, null, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.boarder = 0;
        this.paint = new Paint();
    }

    private Bitmap dealRawBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int min = Math.min(width, height);
        return scaleBitmap(Bitmap.createBitmap(bitmap, (width - min) / 2, (height - min) / 2, min, min, (Matrix) null, false));
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        int width;
        int height;
        Bitmap.Config config;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                config = BITMAP_CONFIG;
                width = 2;
                height = 2;
            } else {
                width = getWidth();
                height = getHeight();
                config = BITMAP_CONFIG;
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, config);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception unused) {
            return null;
        }
    }

    private Bitmap scaleBitmap(Bitmap bitmap) {
        float width = (getWidth() - (this.boarder * 2)) / bitmap.getWidth();
        Matrix matrix = new Matrix();
        matrix.postScale(width, width);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private Bitmap toRoundCorner(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        this.paint.setColor(-12434878);
        float width = bitmap.getWidth() / 2;
        canvas.drawCircle(width, width, width, this.paint);
        this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, this.paint);
        return createBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmapFromDrawable = getBitmapFromDrawable(getDrawable());
        if (bitmapFromDrawable == null) {
            super.onDraw(canvas);
            return;
        }
        Bitmap roundCorner = toRoundCorner(dealRawBitmap(bitmapFromDrawable));
        int width = roundCorner.getWidth() / 2;
        this.paint.reset();
        int i = this.boarder;
        canvas.drawBitmap(roundCorner, (Rect) null, new Rect(i, i, getWidth() - this.boarder, getHeight() - this.boarder), this.paint);
        if (this.boarder > 0) {
            Paint paint = new Paint();
            paint.setColor(-1);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.boarder);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2, width + (this.boarder / 2), paint);
        }
    }

    public void setBoarder(int i) {
        this.boarder = i;
    }
}
