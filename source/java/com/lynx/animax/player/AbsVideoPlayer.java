package com.lynx.animax.player;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.lynx.animax.base.AnimaXError;
import com.lynx.animax.listener.AnimaXErrorParam;
import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.util.AnimaXLog;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbsVideoPlayer implements IVideoPlayer {
    private static final String TAG = "AbsVideoPlayer";
    protected VideoAsset mAsset;
    protected VideoPlayerConfig mConfig;
    protected long mNativePlayer;
    protected Surface mSurface;
    protected SurfaceTexture mSurfaceTexture;
    protected float[] mTransformMatrix;
    private boolean mHasReportedError = false;
    private int mErrorCount = 0;
    private boolean mHasDrewOnce = false;
    private boolean mHasDrewOnceAfterError = false;

    public AbsVideoPlayer(long j, VideoPlayerConfig videoPlayerConfig) {
        AnimaXLog.m2541i(TAG, "create: " + this);
        this.mNativePlayer = j;
        this.mConfig = videoPlayerConfig;
    }

    @Override // com.lynx.animax.player.IVideoPlayer
    public void attachAsset(VideoAsset videoAsset) {
        if (this.mAsset != null) {
            AnimaXLog.m2540e(TAG, "Attach asset more than once");
        } else if (videoAsset == null || !videoAsset.isValid()) {
            AnimaXLog.m2540e(TAG, "attachAsset error: asset isn't valid");
        } else {
            this.mAsset = videoAsset;
        }
    }

    @Override // com.lynx.animax.player.IVideoPlayer
    public void setSurface(int i) {
        releaseSurface();
        this.mSurfaceTexture = new SurfaceTexture(i);
        this.mSurface = new Surface(this.mSurfaceTexture);
    }

    @Override // com.lynx.animax.player.IVideoPlayer
    public float[] getTransformMatrix() {
        if (this.mTransformMatrix == null) {
            this.mTransformMatrix = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.getTransformMatrix(this.mTransformMatrix);
        }
        return this.mTransformMatrix;
    }

    @Override // com.lynx.animax.player.IVideoPlayer
    public void destroy() {
        AnimaXLog.m2541i(TAG, "destroy: " + this);
        this.mAsset = null;
        releaseSurface();
        this.mNativePlayer = 0L;
        reportErrorHasOccurredIfNecessary();
    }

    private void releaseSurface() {
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener(null);
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hasDrewOnce() {
        this.mHasDrewOnce = true;
        this.mHasDrewOnceAfterError = this.mErrorCount > 0;
    }

    private void reportErrorInner(String str) {
        logError(str);
        IAnimaXMonitorService iAnimaXMonitorService = (IAnimaXMonitorService) this.mConfig.getServiceRegistry().getService(IAnimaXMonitorService.class);
        if (iAnimaXMonitorService == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("code", Integer.valueOf(AnimaXError.VIDEO_PLAYER_ERROR_HAS_OCCURRED.ordinal()));
        hashMap.put("msg", str);
        hashMap.put("error_count", Integer.valueOf(this.mErrorCount));
        iAnimaXMonitorService.reportError(new AnimaXErrorParam(hashMap));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportErrorOnce(String str) {
        this.mErrorCount++;
        this.mHasDrewOnceAfterError = false;
        if (this.mHasReportedError) {
            logError(str);
        } else {
            this.mHasReportedError = true;
            reportErrorInner(str);
        }
    }

    private void logError(String str) {
        AnimaXLog.m2540e(TAG, "Error(" + this.mErrorCount + "): " + str);
    }

    private void reportErrorHasOccurredIfNecessary() {
        if (this.mErrorCount <= 0) {
            return;
        }
        reportErrorInner("[" + getClass().getName() + "]: Error has occurred, mHasDrewOnce: " + this.mHasDrewOnce + ", mHasDrewOnceAfterError: " + this.mHasDrewOnceAfterError);
    }
}
