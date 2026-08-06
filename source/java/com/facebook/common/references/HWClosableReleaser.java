package com.facebook.common.references;

import android.graphics.Bitmap;
import android.os.Build;
import com.facebook.common.logging.FLog;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public class HWClosableReleaser implements ResourceReleaser<Bitmap> {
    private static long DEFAULT_MAX_SIZE = 67108864;
    private static HWClosableReleaser sInstance;
    private long mFreeValues;
    private long mInUseValues;
    private long mMaxSize = DEFAULT_MAX_SIZE;

    public static HWClosableReleaser getInstance() {
        if (sInstance == null) {
            synchronized (HWClosableReleaser.class) {
                if (sInstance == null) {
                    sInstance = new HWClosableReleaser();
                }
            }
        }
        return sInstance;
    }

    public void setMaxSize(long j) {
        this.mMaxSize = j;
    }

    public synchronized void addBitmap(Bitmap bitmap) {
        this.mInUseValues += getSizeInBytes(bitmap);
    }

    public long getFreeValues() {
        return this.mMaxSize - this.mInUseValues;
    }

    public synchronized boolean canAddBitmap(Bitmap bitmap) {
        return ((long) getSizeInBytes(bitmap)) < this.mMaxSize - this.mInUseValues;
    }

    public synchronized void decreaseBitmap(Bitmap bitmap) {
        this.mInUseValues -= getSizeInBytes(bitmap);
    }

    @Override // com.facebook.common.references.ResourceReleaser
    public void release(Bitmap bitmap) {
        try {
            if (Build.VERSION.SDK_INT < 26 || bitmap.getConfig() != Bitmap.Config.HARDWARE) {
                return;
            }
            decreaseBitmap(bitmap);
            if (bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
        } catch (Throwable th) {
            FLog.d("debug_hw", "HWClosableReleaser, release: t = " + th);
        }
    }

    public int getSizeInBytes(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        try {
            return bitmap.getAllocationByteCount();
        } catch (NullPointerException unused) {
            return bitmap.getByteCount();
        }
    }
}
