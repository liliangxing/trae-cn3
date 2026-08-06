package com.ss.bytertc.engine;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class TranscodingDataManager {
    private static Context mContext;

    public static native void nativeEndProcessRoomRegionTranscodingData(String roomID);

    public static native void nativeProcessRoomRegionTranscodingData(int regionType, String roomID, String uid, byte[] data, int dataParm1, int dataParm2);

    public static native void nativeStartProcessRoomRegionTranscodingData(String roomID);

    public static void SetContext(Context context) {
        mContext = context;
    }

    static byte[] getCompressImageBuf(ByteBuffer imageBuf, int imgWidth, int imgHeight) {
        Bitmap createBitmap = Bitmap.createBitmap(imgWidth, imgHeight, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(imageBuf);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
