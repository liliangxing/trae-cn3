package com.lynx.animax.drawable;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.hardware.HardwareBuffer;
import android.os.Build;
import com.lynx.animax.util.AnimaXLog;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public class BitmapBuffer {
    private static final String TAG = "BitmapBuffer";
    private final Bitmap mBitmap;
    private final AtomicReference<BufferState> mBufferState = new AtomicReference<>(BufferState.NotReady);
    private final HardwareBuffer mHardwareBuffer;

    /* loaded from: classes6.dex */
    public enum BufferState {
        NotReady,
        Ready,
        Destroyed
    }

    private BitmapBuffer(Bitmap bitmap, HardwareBuffer hardwareBuffer) {
        this.mBitmap = bitmap;
        this.mHardwareBuffer = hardwareBuffer;
    }

    public static BitmapBuffer create(int i, int i2, boolean z) {
        Bitmap bitmap = null;
        HardwareBuffer createHardwareBuffer = isHardwareBufferSupported(z) ? createHardwareBuffer(i, i2, z) : null;
        if (isBitmapWrappedSupported() && createHardwareBuffer != null) {
            try {
                bitmap = Bitmap.wrapHardwareBuffer(createHardwareBuffer, ColorSpace.get(ColorSpace.Named.SRGB));
            } catch (Exception e) {
                AnimaXLog.e(TAG, "Failed to wrap HardwareBuffer: " + e.getMessage());
                createHardwareBuffer.close();
                createHardwareBuffer = null;
            }
        }
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        return new BitmapBuffer(bitmap, createHardwareBuffer);
    }

    public Bitmap getBitmap() {
        if (this.mBufferState.get() == BufferState.Destroyed) {
            return null;
        }
        return this.mBitmap;
    }

    public HardwareBuffer getHardwareBuffer() {
        if (this.mBufferState.get() == BufferState.Destroyed) {
            return null;
        }
        return this.mHardwareBuffer;
    }

    public void setState(int i) {
        if (i < 0 || i >= BufferState.values().length) {
            return;
        }
        this.mBufferState.set(BufferState.values()[i]);
    }

    public void setState(BufferState bufferState) {
        this.mBufferState.set(bufferState);
    }

    public BufferState getState() {
        return this.mBufferState.get();
    }

    public void release() {
        if (this.mBufferState.getAndSet(BufferState.Destroyed) == BufferState.Destroyed) {
            return;
        }
        if (!this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
        }
        if (this.mHardwareBuffer == null || Build.VERSION.SDK_INT < 26) {
            return;
        }
        this.mHardwareBuffer.close();
    }

    public static boolean isHardwareBufferSupported(boolean z) {
        return Build.VERSION.SDK_INT >= 26 && (!z || isBitmapWrappedSupported());
    }

    public static boolean isBitmapWrappedSupported() {
        return Build.VERSION.SDK_INT >= 29;
    }

    private static HardwareBuffer createHardwareBuffer(int i, int i2, boolean z) {
        long j;
        if (i > 0 && i2 > 0) {
            if (z) {
                j = 304;
            } else {
                j = isBitmapWrappedSupported() ? 768L : 515L;
            }
            try {
                return HardwareBuffer.create(i, i2, 1, 1, j);
            } catch (Exception e) {
                AnimaXLog.e(TAG, "Failed to create HardwareBuffer: " + e.getMessage());
            }
        }
        return null;
    }
}
