package com.facebook.common.heif;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.facebook.common.webp.BitmapCreator;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes6.dex */
public interface HeifBitmapFactory {
    Bitmap decodeByNativePtr(long j, int i, Rect rect, BitmapFactory.Options options, HeifDecodeData heifDecodeData);

    Bitmap decodeByNativePtrCombineSr(long j, int i, Rect rect, BitmapFactory.Options options, HeifDecodeData heifDecodeData, HeicSROptions heicSROptions, Map<String, String> map);

    Bitmap decodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options);

    Bitmap decodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options);

    Bitmap decodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options, HeifDecodeData heifDecodeData);

    Bitmap decodeThumb(InputStream inputStream, Rect rect, BitmapFactory.Options options);

    Bitmap decodeThumb(InputStream inputStream, Rect rect, BitmapFactory.Options options, HeifDecodeData heifDecodeData);

    Bitmap decodeThumbByNativePtr(long j, int i, int i2, int i3, Rect rect, BitmapFactory.Options options, HeifDecodeData heifDecodeData);

    void setBitmapCreator(BitmapCreator bitmapCreator);
}
