package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.ss.ttm.player.ITTRenderView;
import com.ss.vcbkit.VLog;

/* loaded from: classes7.dex */
class TTSurfaceView extends SurfaceView implements ITTRenderView {
    int mFixedSizeWidth;
    private ITTRenderView.RenderCallback mRenderCallback;
    private Surface mSurface;

    @Override // com.ss.ttm.player.ITTRenderView
    public View getView() {
        return this;
    }

    public TTSurfaceView(Context context) {
        super(context);
        this.mSurface = null;
        this.mRenderCallback = null;
        this.mFixedSizeWidth = -1;
        init();
    }

    private void init() {
        getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.ss.ttm.player.TTSurfaceView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder holder) {
                VLog.i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn surface view: " + this + ", create: " + holder);
                TTSurfaceView.this.mSurface = holder.getSurface();
                if (TTSurfaceView.this.mRenderCallback != null) {
                    TTSurfaceView.this.mRenderCallback.onSurfaceCreated(TTSurfaceView.this.mSurface);
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                VLog.i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn surface view: " + TTPlayerViewHelper.objectToString(this) + ", changed: " + holder + ", widht: " + width + ", height: " + height);
                if (TTSurfaceView.this.mRenderCallback != null) {
                    if (holder.getSurface() != TTSurfaceView.this.mSurface) {
                        TTSurfaceView.this.mSurface = holder.getSurface();
                        TTSurfaceView.this.mRenderCallback.onSurfaceCreated(TTSurfaceView.this.mSurface);
                    }
                    TTSurfaceView.this.mRenderCallback.onSurfaceChanged(width, height);
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder holder) {
                VLog.i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn surface view: " + TTPlayerViewHelper.objectToString(this) + ", destroyed 111: " + holder);
                TTSurfaceView.this.mSurface = null;
                if (TTSurfaceView.this.mRenderCallback != null) {
                    TTSurfaceView.this.mRenderCallback.onSurfaceDestroyed();
                }
            }
        });
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public Surface getSurface() {
        return this.mSurface;
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void setRenderCallback(ITTRenderView.RenderCallback callback) {
        this.mRenderCallback = callback;
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void setFixedSizeIfNeeded(int width, int height) {
        VLog.i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn surface view: " + TTPlayerViewHelper.objectToString(this) + ", fixed size w: " + width + ", h: " + height + ", ow: " + this.mFixedSizeWidth);
        if (width <= 0 || width >= this.mFixedSizeWidth) {
            getHolder().setFixedSize(width, height);
            this.mFixedSizeWidth = width;
        }
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void reCreateSurface() {
        setVisibility(8);
        setVisibility(0);
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void snapshotBitmap(boolean highQuality, final ITTRenderView.SnapshotCallback callback) {
        if (callback == null) {
            return;
        }
        Bitmap.Config config = highQuality ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        if (Build.VERSION.SDK_INT == 28) {
            config = Bitmap.Config.ARGB_8888;
        }
        final Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), config);
        try {
            PixelCopy.request(this, createBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.ss.ttm.player.TTSurfaceView$$ExternalSyntheticLambda0
                @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                public final void onPixelCopyFinished(int i) {
                    TTSurfaceView.lambda$snapshotBitmap$0(ITTRenderView.SnapshotCallback.this, createBitmap, i);
                }
            }, new Handler(Looper.getMainLooper()));
        } catch (Exception e) {
            VLog.e(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn surface view snapshot failed: " + e);
            callback.onResult(-1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$snapshotBitmap$0(ITTRenderView.SnapshotCallback snapshotCallback, Bitmap bitmap, int i) {
        if (i != 0) {
            bitmap = null;
        }
        snapshotCallback.onResult(i, bitmap);
    }
}
