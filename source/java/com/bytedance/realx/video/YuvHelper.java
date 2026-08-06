package com.bytedance.realx.video;

import android.util.Log;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class YuvHelper {
    private static native void nativeCopyPlane(ByteBuffer src, int srcStride, ByteBuffer dst, int dstStride, int width, int height);

    private static native void nativeI420Copy(ByteBuffer srcY, int srcStrideY, ByteBuffer srcU, int srcStrideU, ByteBuffer srcV, int srcStrideV, ByteBuffer dstY, int dstStrideY, ByteBuffer dstU, int dstStrideU, ByteBuffer dstV, int dstStrideV, int width, int height);

    private static native void nativeI420Rotate(ByteBuffer srcY, int srcStrideY, ByteBuffer srcU, int srcStrideU, ByteBuffer srcV, int srcStrideV, ByteBuffer dstY, int dstStrideY, ByteBuffer dstU, int dstStrideU, ByteBuffer dstV, int dstStrideV, int srcWidth, int srcHeight, int rotationMode);

    private static native void nativeI420ToNV12(ByteBuffer srcY, int srcStrideY, ByteBuffer srcU, int srcStrideU, ByteBuffer srcV, int srcStrideV, ByteBuffer dstY, int dstStrideY, ByteBuffer dstUV, int dstStrideUV, int width, int height);

    private static native void nativeNV12Copy(ByteBuffer srcY, int srcStrideY, ByteBuffer srcUV, int srcStrideUV, ByteBuffer dstY, int dstStrideY, ByteBuffer dstUV, int dstStrideUV, int width, int height);

    public static void I420Copy(ByteBuffer srcY, int srcStrideY, ByteBuffer srcU, int srcStrideU, ByteBuffer srcV, int srcStrideV, ByteBuffer dst, int width, int height) {
        I420Copy(srcY, srcStrideY, srcU, srcStrideU, srcV, srcStrideV, dst, width, height, width, height);
    }

    public static void NV12Copy(ByteBuffer srcY, int srcStrideY, ByteBuffer srcUV, int srcStrideUV, ByteBuffer dst, int width, int height) {
        NV12Copy(srcY, srcStrideY, srcUV, srcStrideUV, dst, width, height, width, height);
    }

    public static void I420ToNV12(ByteBuffer srcY, int srcStrideY, ByteBuffer srcU, int srcStrideU, ByteBuffer srcV, int srcStrideV, ByteBuffer dst, int width, int height) {
        I420ToNV12(srcY, srcStrideY, srcU, srcStrideU, srcV, srcStrideV, dst, width, height, width, height);
    }

    public static void I420Copy(ByteBuffer srcY, int srcStrideY, ByteBuffer srcU, int srcStrideU, ByteBuffer srcV, int srcStrideV, ByteBuffer dst, int srcWidth, int srcHeight, int dstWidth, int dstHeight) {
        if (srcY == null || srcU == null || srcV == null || dst == null) {
            Log.e("YuvHelper", "I420Copy params is null");
            return;
        }
        int i = (dstWidth + 1) / 2;
        int i2 = dstWidth * dstHeight;
        int i3 = ((dstHeight + 1) / 2) * i;
        int i4 = (i3 * 2) + i2;
        if (dst.capacity() < i4) {
            throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i4 + " was " + dst.capacity());
        }
        dst.position(0);
        ByteBuffer slice = dst.slice();
        dst.position(i2);
        ByteBuffer slice2 = dst.slice();
        dst.position(i3 + i2);
        nativeI420Copy(srcY, srcStrideY, srcU, srcStrideU, srcV, srcStrideV, slice, dstWidth, slice2, i, dst.slice(), i, srcWidth, srcHeight);
    }

    public static void NV12Copy(ByteBuffer srcY, int srcStrideY, ByteBuffer srcUV, int srcStrideUV, ByteBuffer dst, int srcWidth, int srcHeight, int dstWidth, int dstHeight) {
        int i = (dstWidth + 1) / 2;
        int i2 = dstWidth * dstHeight;
        int i3 = (((dstHeight + 1) / 2) * i * 2) + i2;
        if (dst.capacity() < i3) {
            throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i3 + " was " + dst.capacity());
        }
        dst.position(0);
        ByteBuffer slice = dst.slice();
        dst.position(i2);
        nativeNV12Copy(srcY, srcStrideY, srcUV, srcStrideUV, slice, dstWidth, dst.slice(), i * 2, srcWidth, srcHeight);
    }

    public static void I420ToNV12(ByteBuffer srcY, int srcStrideY, ByteBuffer srcU, int srcStrideU, ByteBuffer srcV, int srcStrideV, ByteBuffer dst, int srcWidth, int srcHeight, int dstWidth, int dstHeight) {
        int i = (dstWidth + 1) / 2;
        int i2 = dstWidth * dstHeight;
        int i3 = (((dstHeight + 1) / 2) * i * 2) + i2;
        if (dst.capacity() < i3) {
            throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i3 + " was " + dst.capacity());
        }
        dst.position(0);
        ByteBuffer slice = dst.slice();
        dst.position(i2);
        nativeI420ToNV12(srcY, srcStrideY, srcU, srcStrideU, srcV, srcStrideV, slice, dstWidth, dst.slice(), i * 2, srcWidth, srcHeight);
    }

    public static void I420Rotate(ByteBuffer srcY, int srcStrideY, ByteBuffer srcU, int srcStrideU, ByteBuffer srcV, int srcStrideV, ByteBuffer dst, int srcWidth, int srcHeight, int rotationMode) {
        int i = rotationMode % 180;
        int i2 = i == 0 ? srcWidth : srcHeight;
        int i3 = i == 0 ? srcHeight : srcWidth;
        int i4 = (i3 + 1) / 2;
        int i5 = (i2 + 1) / 2;
        int i6 = i3 * i2;
        int i7 = i4 * i5;
        int i8 = (i7 * 2) + i6;
        if (dst.capacity() < i8) {
            throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i8 + " was " + dst.capacity());
        }
        dst.position(0);
        ByteBuffer slice = dst.slice();
        dst.position(i6);
        ByteBuffer slice2 = dst.slice();
        dst.position(i7 + i6);
        nativeI420Rotate(srcY, srcStrideY, srcU, srcStrideU, srcV, srcStrideV, slice, i2, slice2, i5, dst.slice(), i5, srcWidth, srcHeight, rotationMode);
    }

    public static void copyPlane(ByteBuffer src, int srcStride, ByteBuffer dst, int dstStride, int width, int height) {
        nativeCopyPlane(src, srcStride, dst, dstStride, width, height);
    }

    public static void I420Copy(ByteBuffer srcY, int srcStrideY, ByteBuffer srcU, int srcStrideU, ByteBuffer srcV, int srcStrideV, ByteBuffer dstY, int dstStrideY, ByteBuffer dstU, int dstStrideU, ByteBuffer dstV, int dstStrideV, int width, int height) {
        nativeI420Copy(srcY, srcStrideY, srcU, srcStrideU, srcV, srcStrideV, dstY, dstStrideY, dstU, dstStrideU, dstV, dstStrideV, width, height);
    }

    public static void I420ToNV12(ByteBuffer srcY, int srcStrideY, ByteBuffer srcU, int srcStrideU, ByteBuffer srcV, int srcStrideV, ByteBuffer dstY, int dstStrideY, ByteBuffer dstUV, int dstStrideUV, int width, int height) {
        nativeI420ToNV12(srcY, srcStrideY, srcU, srcStrideU, srcV, srcStrideV, dstY, dstStrideY, dstUV, dstStrideUV, width, height);
    }

    public static void I420Rotate(ByteBuffer srcY, int srcStrideY, ByteBuffer srcU, int srcStrideU, ByteBuffer srcV, int srcStrideV, ByteBuffer dstY, int dstStrideY, ByteBuffer dstU, int dstStrideU, ByteBuffer dstV, int dstStrideV, int srcWidth, int srcHeight, int rotationMode) {
        nativeI420Rotate(srcY, srcStrideY, srcU, srcStrideU, srcV, srcStrideV, dstY, dstStrideY, dstU, dstStrideU, dstV, dstStrideV, srcWidth, srcHeight, rotationMode);
    }
}
