package com.bytedance.notification.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.push.settings.notification.NotificationParamsModel;
import com.ss.android.message.util.BitmapUtils;
import com.ss.android.pushmanager.setting.PushSetting;

/* loaded from: classes4.dex */
public class RedBadgeUtils {
    public static Bitmap getRedBadgeBitmapForImNotification(Bitmap bitmap, int i) {
        if (bitmap == null || i == 0) {
            return bitmap;
        }
        if (i > 0) {
            return getRedBadgeBitmapForImNotification_00(bitmap, i);
        }
        if (i == -1) {
            return getRedBadgeBitmapForImNotification_01(bitmap);
        }
        return i == -2 ? getRedBadgeBitmapForImNotification_02(bitmap) : bitmap;
    }

    public static Bitmap getRedBadgeBitmap(Bitmap bitmap, int i) {
        if (bitmap == null || i == 0) {
            return bitmap;
        }
        if (i > 0) {
            return getRedBadgeBitmap_00(bitmap, i);
        }
        if (i == -1) {
            return getRedBadgeBitmap_01(bitmap);
        }
        return i == -2 ? getRedBadgeBitmap_02(bitmap) : bitmap;
    }

    private static Bitmap getRedBadgeBitmap_00(Bitmap bitmap, int i) {
        float f;
        Paint paint;
        if (bitmap == null || i == 0) {
            return bitmap;
        }
        Bitmap squareBitmap = BitmapUtils.getSquareBitmap(bitmap);
        float max = Math.max(squareBitmap.getWidth(), squareBitmap.getHeight());
        float f2 = max / 6.0f;
        float f3 = f2 * 2.0f;
        float f4 = max + f3;
        int i2 = (int) f4;
        Bitmap createBitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
        if (createBitmap == null) {
            return bitmap;
        }
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(BitmapUtils.bitmapRound(squareBitmap, f3), 0.0f, f4 - max, (Paint) null);
        Paint paint2 = new Paint();
        paint2.setColor(getNotificationRedBadgeColor());
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        paint3.setColor(-1);
        paint3.setAntiAlias(true);
        paint3.setTextAlign(Paint.Align.CENTER);
        String valueOf = i > 99 ? "99+" : String.valueOf(i);
        float length = max - (((valueOf.length() - 1) * f2) / 2.0f);
        if (valueOf.length() == 1) {
            canvas.drawCircle(length, f3, f2, paint2);
            f = length;
            paint = paint3;
        } else {
            f = length;
            paint = paint3;
            canvas.drawRoundRect(max - (valueOf.length() * f2), f3 - f2, max + f2, f3 + f2, f2, f2, paint2);
        }
        paint.setTextSize(f2 * 1.8f);
        paint.setTypeface(Typeface.create(paint.getTypeface(), 1));
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        canvas.drawText(valueOf, f, f3 - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), paint);
        return createBitmap;
    }

    private static Bitmap getRedBadgeBitmap_01(Bitmap bitmap) {
        if (bitmap == null) {
            return bitmap;
        }
        Bitmap squareBitmap = BitmapUtils.getSquareBitmap(bitmap);
        float max = Math.max(squareBitmap.getWidth(), squareBitmap.getHeight());
        float f = max / 8.0f;
        float f2 = max + f;
        int i = (int) f2;
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        if (createBitmap == null) {
            return bitmap;
        }
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(BitmapUtils.bitmapRound(squareBitmap, 2.0f * f), 0.0f, f2 - max, (Paint) null);
        Paint paint = new Paint();
        paint.setColor(getNotificationRedBadgeColor());
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        canvas.drawCircle(max - (0.5f * f), 1.5f * f, f, paint);
        return createBitmap;
    }

    private static Bitmap getRedBadgeBitmap_02(Bitmap bitmap) {
        if (bitmap == null) {
            return bitmap;
        }
        Bitmap squareBitmap = BitmapUtils.getSquareBitmap(bitmap);
        float max = Math.max(squareBitmap.getWidth(), squareBitmap.getHeight());
        float f = max / 6.0f;
        float f2 = f * 2.0f;
        float f3 = max + f2;
        int i = (int) f3;
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        if (createBitmap == null) {
            return bitmap;
        }
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(BitmapUtils.bitmapRound(squareBitmap, f2), 0.0f, f3 - max, (Paint) null);
        Paint paint = new Paint();
        paint.setColor(getNotificationRedBadgeColor());
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        paint2.setColor(-1);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        float f4 = max - f;
        canvas.drawRoundRect(f4 - f2, f2 - f, f4 + f2, f2 + f, f, f, paint);
        float f5 = f / 4.0f;
        canvas.drawCircle(f4, f2, f5, paint2);
        canvas.drawCircle(f4 - f, f2, f5, paint2);
        canvas.drawCircle(f4 + f, f2, f5, paint2);
        return createBitmap;
    }

    private static Bitmap getRedBadgeBitmapForImNotification_00(Bitmap bitmap, int i) {
        if (bitmap != null && i != 0) {
            bitmap = BitmapUtils.getSquareBitmap(bitmap);
            float max = Math.max(bitmap.getWidth(), bitmap.getHeight());
            float f = max / 10.0f;
            Canvas canvas = new Canvas(bitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            Paint paint = new Paint();
            paint.setColor(getNotificationRedBadgeColor());
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            Paint paint2 = new Paint();
            paint2.setColor(-1);
            paint2.setAntiAlias(true);
            paint2.setTextAlign(Paint.Align.CENTER);
            String valueOf = i > 99 ? "99+" : String.valueOf(i);
            float length = max - (((valueOf.length() + 1) * f) / 2.0f);
            if (valueOf.length() == 1) {
                canvas.drawCircle(length, f, f, paint);
            } else {
                canvas.drawRoundRect(max - ((valueOf.length() + 1) * f), f - f, max, f + f, f, f, paint);
            }
            paint2.setTextSize(1.8f * f);
            paint2.setTypeface(Typeface.create(paint2.getTypeface(), 1));
            Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
            canvas.drawText(valueOf, length, f - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), paint2);
        }
        return bitmap;
    }

    private static Bitmap getRedBadgeBitmapForImNotification_01(Bitmap bitmap) {
        if (bitmap == null) {
            return bitmap;
        }
        Bitmap squareBitmap = BitmapUtils.getSquareBitmap(bitmap);
        float max = Math.max(squareBitmap.getWidth(), squareBitmap.getHeight());
        float f = max / 12.0f;
        Canvas canvas = new Canvas(squareBitmap);
        canvas.drawBitmap(squareBitmap, 0.0f, 0.0f, (Paint) null);
        Paint paint = new Paint();
        paint.setColor(getNotificationRedBadgeColor());
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        canvas.drawCircle(max - f, f, f, paint);
        return squareBitmap;
    }

    private static Bitmap getRedBadgeBitmapForImNotification_02(Bitmap bitmap) {
        if (bitmap == null) {
            return bitmap;
        }
        Bitmap squareBitmap = BitmapUtils.getSquareBitmap(bitmap);
        float max = Math.max(squareBitmap.getWidth(), squareBitmap.getHeight());
        float f = max / 10.0f;
        Canvas canvas = new Canvas(squareBitmap);
        canvas.drawBitmap(squareBitmap, 0.0f, 0.0f, (Paint) null);
        Paint paint = new Paint();
        paint.setColor(getNotificationRedBadgeColor());
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        paint2.setColor(-1);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        float f2 = 2.0f * f;
        float f3 = max - f2;
        canvas.drawRoundRect(f3 - f2, f - f, f3 + f2, f + f, f, f, paint);
        float f4 = f / 4.0f;
        canvas.drawCircle(f3, f, f4, paint2);
        canvas.drawCircle(f3 - f, f, f4, paint2);
        canvas.drawCircle(f3 + f, f, f4, paint2);
        return squareBitmap;
    }

    private static int getNotificationRedBadgeColor() {
        int parseColor;
        NotificationParamsModel notificationParamsModel = PushSetting.getInstance().getPushOnLineSettings().getNotificationParamsModel();
        return (notificationParamsModel == null || (parseColor = Color.parseColor(notificationParamsModel.notificationRedBadgeColor)) == 0) ? SupportMenu.CATEGORY_MASK : parseColor;
    }
}
