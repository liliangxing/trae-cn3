package com.lynx.tasm.image;

import android.os.Handler;
import android.os.Looper;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureFunc;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.MeasureOutput;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.group.BitmapSize;
import com.lynx.tasm.group.ILynxViewRuntimeCacheManager;
import com.ss.android.socialbase.appdownloader.util.parser.manifest.TypedValue;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AutoSizeImage extends ShadowNode implements MeasureFunc {
    private int mBitmapHeight;
    private int mBitmapWidth;
    private Handler mLayoutHandler;
    private Runnable mPendingRunnable;
    private String source;
    private boolean mAutoSize = false;
    private boolean mBlockAutoSizeMarkDirty = false;
    private int mCachedBitmapWidth = 0;
    private int mCachedBitmapHeight = 0;
    private boolean mExactly = true;
    private final Object mLock = new Object();

    public AutoSizeImage() {
        setMeasureFunc(this);
    }

    @LynxProp(name = PropsConstants.SRC)
    public void setSrc(String str) {
        this.source = str;
        this.mCachedBitmapHeight = 0;
        this.mCachedBitmapWidth = 0;
    }

    private BitmapSize getCacheBitmapSize(String str) {
        ILynxViewRuntimeCacheManager runtimeCacheManager;
        if (this.mContext == null || (runtimeCacheManager = this.mContext.getRuntimeCacheManager()) == null) {
            return null;
        }
        return runtimeCacheManager.getBitmapSizeCache(str);
    }

    @Override // com.lynx.tasm.behavior.shadow.MeasureFunc
    public long measure(LayoutNode layoutNode, float f, MeasureMode measureMode, float f2, MeasureMode measureMode2) {
        String str;
        int i;
        int i2;
        String str2 = null;
        if (TraceEvent.isTracingStarted()) {
            str = "AutoSizeImage Measure: " + f + Constants.COLON_SEPARATOR + measureMode.intValue() + " - " + f2 + Constants.COLON_SEPARATOR + measureMode2.intValue() + " " + this.source;
            TraceEvent.beginSection(str);
        } else {
            str = null;
        }
        synchronized (this.mLock) {
            if (this.mLayoutHandler == null) {
                Handler handler = new Handler(Looper.myLooper());
                this.mLayoutHandler = handler;
                Runnable runnable = this.mPendingRunnable;
                if (runnable != null) {
                    handler.post(runnable);
                    this.mPendingRunnable = null;
                }
            }
        }
        boolean z = false;
        boolean z2 = measureMode == MeasureMode.EXACTLY && measureMode2 == MeasureMode.EXACTLY;
        this.mExactly = z2;
        if (z2) {
            if (TraceEvent.isTracingStarted()) {
                TraceEvent.endSection(str);
            }
            this.mBlockAutoSizeMarkDirty = true;
            return MeasureOutput.make(f, f2);
        }
        BitmapSize cacheBitmapSize = getCacheBitmapSize(this.source);
        if (cacheBitmapSize != null) {
            if (TraceEvent.isTracingStarted()) {
                str2 = "CacheHit";
                TraceEvent.beginSection("CacheHit");
            }
            this.mCachedBitmapWidth = cacheBitmapSize.getWidth();
            i2 = cacheBitmapSize.getHeight();
            this.mCachedBitmapHeight = i2;
            i = this.mCachedBitmapWidth;
            if (TraceEvent.isTracingStarted()) {
                TraceEvent.endSection(str2);
            }
        } else {
            i = this.mBitmapWidth;
            i2 = this.mBitmapHeight;
        }
        if ((f == 0.0f && measureMode != MeasureMode.UNDEFINED) || (f2 == 0.0f && measureMode2 != MeasureMode.UNDEFINED)) {
            z = true;
        }
        this.mExactly = z;
        if (!this.mAutoSize || i <= 0 || i2 <= 0 || z) {
            if (TraceEvent.isTracingStarted()) {
                TraceEvent.endSection(str);
            }
            if (measureMode != MeasureMode.EXACTLY) {
                f = 0.0f;
            }
            if (measureMode2 != MeasureMode.EXACTLY) {
                f2 = 0.0f;
            }
            return MeasureOutput.make(f, f2);
        }
        if (measureMode == MeasureMode.EXACTLY) {
            float f3 = (i2 / i) * f;
            if (measureMode2 != MeasureMode.AT_MOST ? measureMode2 == MeasureMode.UNDEFINED : f2 > f3) {
                f2 = f3;
            }
        } else {
            if (measureMode == MeasureMode.UNDEFINED) {
                f = TypedValue.DENSITY_NONE;
            }
            if (measureMode2 == MeasureMode.UNDEFINED) {
                f2 = TypedValue.DENSITY_NONE;
            }
            if (measureMode2 == MeasureMode.EXACTLY) {
                float f4 = (i / i2) * f2;
                if (f > f4) {
                    f = f4;
                }
            } else {
                float f5 = i;
                if (f5 <= f) {
                    float f6 = i2;
                    if (f6 <= f2) {
                        f = f5;
                        f2 = f6;
                    }
                }
                float f7 = i2 / f5;
                if (f2 / f < f7) {
                    f = f2 / f7;
                } else {
                    f2 = f7 * f;
                }
            }
        }
        if (TraceEvent.isTracingStarted()) {
            TraceEvent.endSection(str);
        }
        return MeasureOutput.make(f, f2);
    }

    public void justSizeIfNeeded(final boolean z, final int i, final int i2, final int i3, final int i4) {
        synchronized (this.mLock) {
            Handler handler = this.mLayoutHandler;
            if (handler == null) {
                this.mPendingRunnable = new Runnable() { // from class: com.lynx.tasm.image.AutoSizeImage.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AutoSizeImage.this.justSize(z, i, i2, i3, i4);
                    }
                };
            } else {
                handler.post(new Runnable() { // from class: com.lynx.tasm.image.AutoSizeImage.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AutoSizeImage.this.justSize(z, i, i2, i3, i4);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void justSize(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = this.mAutoSize;
        this.mAutoSize = z;
        this.mBitmapWidth = i;
        this.mBitmapHeight = i2;
        if (i == this.mCachedBitmapWidth && i2 == this.mCachedBitmapHeight) {
            return;
        }
        if (this.mContext != null && this.mContext.isEmbeddedModeOn() && this.mBlockAutoSizeMarkDirty) {
            return;
        }
        if (z2 != z) {
            markDirty();
            return;
        }
        if (!this.mExactly && z && i > 0 && i2 > 0) {
            if (i3 == 0 || i4 == 0 || Math.abs((i3 / i4) - (i / i2)) > 0.05d) {
                markDirty();
            }
        }
    }
}
