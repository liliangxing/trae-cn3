package com.ss.android.message.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: classes7.dex */
public class BitmapUtils {
    public static final int CORNER_ALL = 15;
    public static final int CORNER_BOTTOM = 12;
    public static final int CORNER_BOTTOM_LEFT = 4;
    public static final int CORNER_BOTTOM_RIGHT = 8;
    public static final int CORNER_LEFT = 5;
    public static final int CORNER_NONE = 0;
    public static final int CORNER_RIGHT = 10;
    public static final int CORNER_TOP = 3;
    public static final int CORNER_TOP_LEFT = 1;
    public static final int CORNER_TOP_RIGHT = 2;
    private static String TAG = "BitmapUtils";

    public static Bitmap zoomImg(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap bitmapRound(Bitmap bitmap, float f) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        float f = width / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static Bitmap getCornerBitmap(Bitmap bitmap, int i, int i2) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawARGB(0, 0, 0, 0);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(-16777216);
            float f = i;
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, width, height), f, f, paint);
            int i3 = i2 ^ 15;
            if ((i3 & 1) != 0) {
                clipTopLeft(canvas, paint, i, width, height);
            }
            if ((i3 & 2) != 0) {
                clipTopRight(canvas, paint, i, width, height);
            }
            if ((i3 & 4) != 0) {
                clipBottomLeft(canvas, paint, i, width, height);
            }
            if ((i3 & 8) != 0) {
                clipBottomRight(canvas, paint, i, width, height);
            }
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            Rect rect = new Rect(0, 0, width, height);
            canvas.drawBitmap(bitmap, rect, rect, paint);
            return createBitmap;
        } catch (Exception unused) {
            return bitmap;
        }
    }

    private static void clipTopLeft(Canvas canvas, Paint paint, int i, int i2, int i3) {
        canvas.drawRect(new Rect(0, 0, i, i), paint);
    }

    private static void clipTopRight(Canvas canvas, Paint paint, int i, int i2, int i3) {
        canvas.drawRect(new Rect(i2 - i, 0, i2, i), paint);
    }

    private static void clipBottomLeft(Canvas canvas, Paint paint, int i, int i2, int i3) {
        canvas.drawRect(new Rect(0, i3 - i, i, i3), paint);
    }

    private static void clipBottomRight(Canvas canvas, Paint paint, int i, int i2, int i3) {
        canvas.drawRect(new Rect(i2 - i, i3 - i, i2, i3), paint);
    }

    public static Bitmap getSquareBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == height) {
            return bitmap;
        }
        int min = Math.min(width, height);
        return Bitmap.createBitmap(bitmap, (width - min) / 2, (height - min) / 2, min, min);
    }

    public static Bitmap processBitmapForGif(Bitmap bitmap, int i, float f) {
        Bitmap createScaledBitmap;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > i || height > i) {
            float max = i / Math.max(width, height);
            createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (width * max), (int) (height * max), true);
            width = createScaledBitmap.getWidth();
            height = createScaledBitmap.getHeight();
        } else {
            createScaledBitmap = bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, width, height), f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(createScaledBitmap, 0.0f, 0.0f, paint);
        bitmap.recycle();
        createScaledBitmap.recycle();
        return createBitmap;
    }

    public static Bitmap buildLeftTopEmptyBitmap(Bitmap bitmap, int i) {
        int i2 = i * 2;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i2, true);
        Canvas canvas = new Canvas(createScaledBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        float f = i2;
        canvas.drawArc(new RectF(0.0f, 0.0f, f, f), 180.0f, 90.0f, true, paint);
        return Bitmap.createBitmap(createScaledBitmap, 0, 0, i, i);
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap mergeBitmapsVertically(Bitmap bitmap, Bitmap bitmap2) {
        Bitmap createBitmap = Bitmap.createBitmap(Math.max(bitmap.getWidth(), bitmap2.getWidth()), bitmap.getHeight() + bitmap2.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, 0.0f, bitmap.getHeight(), (Paint) null);
        return createBitmap;
    }

    public static Bitmap mergeBitmapsHorizontally(Bitmap bitmap, Bitmap bitmap2) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth() + bitmap2.getWidth(), Math.max(bitmap.getHeight(), bitmap2.getHeight()), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, bitmap.getWidth(), 0.0f, (Paint) null);
        return createBitmap;
    }

    public static Bitmap drawXOnBitmap(Bitmap bitmap, int i, int i2, int i3, int i4, int i5) {
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(copy);
        Paint paint = new Paint();
        paint.setColor(i2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(i3);
        int width = copy.getWidth();
        copy.getHeight();
        int i6 = width - i4;
        float f = i6 - i;
        float f2 = i5;
        float f3 = i6;
        float f4 = i + i5;
        canvas.drawLine(f, f2, f3, f4, paint);
        canvas.drawLine(f, f4, f3, f2, paint);
        return copy;
    }
}
