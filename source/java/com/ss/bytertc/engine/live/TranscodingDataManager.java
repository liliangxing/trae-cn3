package com.ss.bytertc.engine.live;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class TranscodingDataManager {
    private static Context mContext;

    public static void SetContext(Context context) {
        mContext = context;
    }

    static byte[] getCompressImageBuf(ByteBuffer imageBuf, int imgWidth, int imgHeight, int quality) {
        Bitmap createBitmap = Bitmap.createBitmap(imgWidth, imgHeight, Bitmap.Config.ARGB_8888);
        imageBuf.rewind();
        createBitmap.copyPixelsFromBuffer(imageBuf);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.JPEG, quality, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
