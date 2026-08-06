package com.lynx.animax.drawable;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.lynx.animax.util.AnimaXLog;

/* loaded from: classes6.dex */
public class AnimaXSurfaceDrawable {
    private static final String TAG = "AnimaXSurfaceDrawable";
    private final BitmapBufferGroup mBitmapBufferGroup;
    private int mHeight;
    private final Surface mSurface;
    private final SurfaceTexture mSurfaceTexture;
    private final DrawableType mType;
    private int mWidth;
    private boolean mEnableAntiAliasing = false;
    private boolean mEnableSoftwareRender = false;
    private boolean mIsPlatformSurfaceInitiallyInvalid = false;
    private boolean mEnableAutoDestroyEGLContext = false;

    /* loaded from: classes6.dex */
    public enum DrawableType {
        Invalid,
        TextureView,
        SurfaceView,
        BitmapBufferGroup
    }

    private AnimaXSurfaceDrawable(Surface surface, SurfaceTexture surfaceTexture, BitmapBufferGroup bitmapBufferGroup, int i, int i2) {
        this.mSurface = surface;
        this.mSurfaceTexture = surfaceTexture;
        this.mBitmapBufferGroup = bitmapBufferGroup;
        if (surfaceTexture != null) {
            this.mType = DrawableType.TextureView;
        } else if (bitmapBufferGroup != null) {
            this.mType = DrawableType.BitmapBufferGroup;
            bitmapBufferGroup.setBufferSize(i, i2);
        } else if (surface != null) {
            this.mType = DrawableType.SurfaceView;
        } else {
            this.mType = DrawableType.Invalid;
        }
        this.mWidth = i;
        this.mHeight = i2;
    }

    public static AnimaXSurfaceDrawable createFromTexture(SurfaceTexture surfaceTexture, int i, int i2) {
        return new AnimaXSurfaceDrawable(new Surface(surfaceTexture), surfaceTexture, null, i, i2);
    }

    public static AnimaXSurfaceDrawable createFromFirstFrameAwareSurfaceTexture(FirstFrameAwareSurfaceTexture firstFrameAwareSurfaceTexture, int i, int i2) {
        return new AnimaXSurfaceDrawable(firstFrameAwareSurfaceTexture.getSurface(), firstFrameAwareSurfaceTexture, null, i, i2);
    }

    public static AnimaXSurfaceDrawable createFromSurface(Surface surface, int i, int i2) {
        return new AnimaXSurfaceDrawable(surface, null, null, i, i2);
    }

    public static AnimaXSurfaceDrawable createFromBitmapBufferGroup(BitmapBufferGroup bitmapBufferGroup, int i, int i2) {
        return new AnimaXSurfaceDrawable(null, null, bitmapBufferGroup, i, i2);
    }

    public boolean updateSize(int i, int i2) {
        if (isSizeChangeWithinRange(i, i2)) {
            AnimaXLog.i(TAG, "Skip same size: " + i + " / " + i2);
            return false;
        }
        setSize(i, i2);
        AnimaXLog.i(TAG, "Update size success: " + i + " / " + i2);
        return true;
    }

    private boolean isSizeChangeWithinRange(int i, int i2) {
        return Math.abs(this.mWidth - i) <= 1 && Math.abs(this.mHeight - i2) <= 1;
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    public BitmapBufferGroup getBitmapBufferGroup() {
        return this.mBitmapBufferGroup;
    }

    public boolean isTextureFirstFrameAware() {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            return false;
        }
        return surfaceTexture instanceof FirstFrameAwareSurfaceTexture;
    }

    public void setSize(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        BitmapBufferGroup bitmapBufferGroup = this.mBitmapBufferGroup;
        if (bitmapBufferGroup != null) {
            bitmapBufferGroup.setBufferSize(i, i2);
        }
    }

    public void rebuildBufferGroup() {
        BitmapBufferGroup bitmapBufferGroup = this.mBitmapBufferGroup;
        if (bitmapBufferGroup != null) {
            bitmapBufferGroup.setBufferSize(this.mWidth, this.mHeight);
        }
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public boolean isAntiAliasingEnabled() {
        return this.mEnableAntiAliasing;
    }

    public void setEnableAntiAliasing(boolean z) {
        this.mEnableAntiAliasing = z;
    }

    public boolean isSoftwareRenderEnabled() {
        return this.mEnableSoftwareRender;
    }

    public void setEnableSoftwareRender(boolean z) {
        this.mEnableSoftwareRender = z;
    }

    public boolean isPlatformSurfaceInitiallyInvalid() {
        return this.mIsPlatformSurfaceInitiallyInvalid;
    }

    public void setPlatformSurfaceInitiallyInvalid(boolean z) {
        this.mIsPlatformSurfaceInitiallyInvalid = z;
    }

    public boolean isAutoDestroyEGLContextEnabled() {
        return this.mEnableAutoDestroyEGLContext;
    }

    public void setEnableAutoDestroyEGLContext(boolean z) {
        this.mEnableAutoDestroyEGLContext = z;
    }

    private long getTypeIndex() {
        return this.mType.ordinal();
    }

    public DrawableType getType() {
        return this.mType;
    }
}
