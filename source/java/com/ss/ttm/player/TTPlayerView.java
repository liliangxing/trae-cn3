package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.util.Pair;
import com.ss.android.socialbase.appdownloader.util.parser.manifest.TypedValue;
import com.ss.ttm.player.ITTRenderView;
import com.ss.ttm.player.TTAVPlayerView;
import com.ss.ttm.player.TTPlayerViewHelper;
import com.ss.ttm.player.TTWindowClient;
import com.ss.vcbkit.VLog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TTPlayerView extends FrameLayout implements TTAVPlayerView {
    private float mCropHeightLimit;
    private float mCropWidthLimit;
    private boolean mIsNeededFixedSize;
    private boolean mIsOnloadCallback;
    private boolean mIsSurfaceCreated;
    private boolean mIsTTPlayerDisplaySizeCalled;
    private TTAVPlayerView.LifeCycleCallback mLifeCycleCallback;
    private boolean mLockCpuBuffer;
    private boolean mNeedCrop;
    private ITTRenderView mRenderView;
    private int mScaleType;
    private float mVideoAspect;
    private TTPlayerViewHelper.Size mVideoSize;
    private int mViewType;
    private TTWindowClient mWindowClient;

    public TTPlayerView(Context context, int viewType, float videoAspect, int scaleType) {
        super(context);
        this.mWindowClient = null;
        this.mRenderView = null;
        this.mVideoAspect = 1.7777778f;
        this.mVideoSize = null;
        this.mScaleType = 0;
        this.mCropWidthLimit = 0.0f;
        this.mCropHeightLimit = 0.0f;
        this.mViewType = 1;
        this.mLifeCycleCallback = null;
        this.mIsOnloadCallback = false;
        this.mIsSurfaceCreated = false;
        this.mNeedCrop = false;
        this.mLockCpuBuffer = false;
        this.mIsNeededFixedSize = false;
        this.mIsTTPlayerDisplaySizeCalled = false;
        init(context, null, viewType, videoAspect, scaleType);
    }

    public TTPlayerView(Context context, TTAVPlayerView.LifeCycleCallback callback, int viewType, float videoAspect, int scaleType) {
        super(context);
        this.mWindowClient = null;
        this.mRenderView = null;
        this.mVideoAspect = 1.7777778f;
        this.mVideoSize = null;
        this.mScaleType = 0;
        this.mCropWidthLimit = 0.0f;
        this.mCropHeightLimit = 0.0f;
        this.mViewType = 1;
        this.mLifeCycleCallback = null;
        this.mIsOnloadCallback = false;
        this.mIsSurfaceCreated = false;
        this.mNeedCrop = false;
        this.mLockCpuBuffer = false;
        this.mIsNeededFixedSize = false;
        this.mIsTTPlayerDisplaySizeCalled = false;
        init(context, callback, viewType, videoAspect, scaleType);
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public void setLifeCycleCallback(TTAVPlayerView.LifeCycleCallback callback) {
        TTAVPlayerView.LifeCycleCallback lifeCycleCallback = this.mLifeCycleCallback;
        if (lifeCycleCallback != null || lifeCycleCallback == callback) {
            return;
        }
        this.mLifeCycleCallback = callback;
        if (callback == null || this.mIsOnloadCallback || !this.mIsSurfaceCreated) {
            return;
        }
        this.mIsOnloadCallback = true;
        callback.onLoad(this.mWindowClient);
        this.mLifeCycleCallback.onNewSurfaceAvailable();
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public void setScaleType(int scaleType, float cropWidthLimit, float cropHeightLimit) {
        if (this.mScaleType == scaleType && this.mCropWidthLimit == cropWidthLimit && this.mCropHeightLimit == cropHeightLimit) {
            return;
        }
        this.mScaleType = scaleType;
        this.mCropWidthLimit = cropWidthLimit;
        this.mCropHeightLimit = cropHeightLimit;
        post(new Runnable() { // from class: com.ss.ttm.player.TTPlayerView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TTPlayerView.this.m4210lambda$setScaleType$0$comssttmplayerTTPlayerView();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setScaleType$0$com-ss-ttm-player-TTPlayerView, reason: not valid java name */
    public /* synthetic */ void m4210lambda$setScaleType$0$comssttmplayerTTPlayerView() {
        forceLayout();
        requestLayout();
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public void attachToParent(ViewGroup viewGroup) {
        attachToParent(viewGroup, null);
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public void attachToParent(ViewGroup viewGroup, ViewGroup.LayoutParams params) {
        VLog.m248i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn player view attachToParent: " + TTPlayerViewHelper.objectToString(this) + ", parent: " + TTPlayerViewHelper.objectToString(viewGroup));
        ViewGroup viewGroup2 = (ViewGroup) getParent();
        if (viewGroup == null || viewGroup2 == viewGroup) {
            return;
        }
        if (params == null) {
            params = new FrameLayout.LayoutParams(-1, -1, 17);
        }
        this.mRenderView.reuse();
        detachFromParent();
        setLayoutParams(params);
        viewGroup.addView(this);
    }

    @Override // android.view.View, com.ss.ttm.player.TTAVPlayerView
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public int getViewWidth() {
        return super.getWidth();
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public int getViewHeight() {
        return super.getHeight();
    }

    @Override // android.view.View, com.ss.ttm.player.TTAVPlayerView
    public int getVisibility() {
        return super.getVisibility();
    }

    @Override // android.view.View, com.ss.ttm.player.TTAVPlayerView
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        ITTRenderView iTTRenderView = this.mRenderView;
        if (iTTRenderView != null) {
            iTTRenderView.getView().setVisibility(visibility);
        }
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public boolean isSurfaceAvailable() {
        Surface surface = this.mRenderView.getSurface();
        return surface != null && surface.isValid();
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public boolean isSurfaceView() {
        return this.mRenderView instanceof TTSurfaceView;
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public Size getSurfaceSize() {
        if (this.mRenderView == null) {
            return new Size(0, 0);
        }
        return new Size(this.mRenderView.getView().getWidth(), this.mRenderView.getView().getHeight());
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public Rect getSurfacePosition() {
        ITTRenderView iTTRenderView = this.mRenderView;
        if (iTTRenderView == null) {
            return null;
        }
        return TTPlayerViewHelper.getSurfaceRenderPosition(iTTRenderView.getView());
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public void detachFromParent() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        VLog.m248i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn player view detachFromParent:" + TTPlayerViewHelper.objectToString(this) + ", parent: " + TTPlayerViewHelper.objectToString(viewGroup));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        Pair<TTPlayerViewHelper.Size, Boolean> calculatePlayerViewSize = TTPlayerViewHelper.calculatePlayerViewSize(this.mScaleType, this.mVideoAspect, size, size2, this.mCropWidthLimit, this.mCropHeightLimit);
        TTPlayerViewHelper.Size size3 = (TTPlayerViewHelper.Size) calculatePlayerViewSize.first;
        this.mNeedCrop = Boolean.TRUE.equals(calculatePlayerViewSize.second);
        if (size3 == null || size3.getWidth() == 0 || size3.getHeight() == 0) {
            VLog.m251w(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn player view: " + TTPlayerViewHelper.objectToString(this) + ", client: " + TTPlayerViewHelper.objectToString(this.mWindowClient) + ", viewSize: " + size + "x" + size2 + "vaspect: " + this.mVideoAspect);
            measureChildren(widthMeasureSpec, heightMeasureSpec);
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        VLog.m248i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn player view : " + TTPlayerViewHelper.objectToString(this) + ", client: " + TTPlayerViewHelper.objectToString(this.mWindowClient) + ", render view: " + TTPlayerViewHelper.objectToString(this.mRenderView) + ",onMeasure: " + size3.toString() + " viewSize: " + size + "x" + size2 + ", scaleType: " + this.mScaleType + ", videoAspect: " + this.mVideoAspect);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3.getWidth(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size3.getHeight(), 1073741824);
        this.mRenderView.getView().measure(makeMeasureSpec, makeMeasureSpec2);
        if (getLayoutParams().width == -2) {
            setMeasuredDimension(makeMeasureSpec, makeMeasureSpec2);
        } else {
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        }
    }

    private void init(Context context, TTAVPlayerView.LifeCycleCallback callback, int viewType, float videoAspect, int scaleType) {
        this.mLifeCycleCallback = callback;
        this.mViewType = viewType == 2 ? 2 : 1;
        if (1 == viewType && !TTPlayerViewHelper.isEnableSurfaceView(context)) {
            this.mViewType = 2;
            VLog.m251w(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn player view current device not support surface view");
        }
        this.mVideoAspect = videoAspect;
        this.mScaleType = scaleType;
        setupView();
    }

    private void setupView() {
        if (this.mViewType != 2) {
            this.mRenderView = new TTSurfaceView(getContext());
        } else {
            this.mRenderView = new TTTextureView(getContext());
        }
        addView(this.mRenderView.getView());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRenderView.getView().getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams.gravity = 17;
        }
        this.mRenderView.getView().setLayoutParams(layoutParams);
        this.mWindowClient = new TTWindowClient(this.mRenderView, new TTWindowClient.WindowClientOnInfoCallback() { // from class: com.ss.ttm.player.TTPlayerView.1
            @Override // com.ss.ttm.player.TTWindowClient.WindowClientOnInfoCallback
            public void onInfo(int what, int parameter) {
                int i;
                if (what == 0) {
                    TTPlayerView.this.mIsTTPlayerDisplaySizeCalled = true;
                    int i2 = parameter >> 16;
                    int i3 = parameter & TypedValue.DENSITY_NONE;
                    VLog.m248i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn player view DISPLAY_SIZE: " + TTPlayerViewHelper.objectToString(this) + ", client: " + TTPlayerViewHelper.objectToString(TTPlayerView.this.mWindowClient) + ", fixed: " + TTPlayerView.this.mIsNeededFixedSize + ", vsize: " + TTPlayerView.this.mVideoSize);
                    TTPlayerView.this.updateDisplaySize(i2, i3);
                    return;
                }
                if (what == 3) {
                    TTPlayerView.this.mLockCpuBuffer = true;
                    return;
                }
                if (what == 4) {
                    TTPlayerView.this.mRenderView.reCreateSurface();
                    return;
                }
                if (what == 5) {
                    VLog.m248i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn player view DISPLAY_SIZE_EXT called: " + TTPlayerView.this.mIsTTPlayerDisplaySizeCalled + ", fixed: " + TTPlayerView.this.mIsNeededFixedSize + ", vsize: " + TTPlayerView.this.mVideoSize);
                    if (TTPlayerView.this.mIsTTPlayerDisplaySizeCalled) {
                        return;
                    }
                    TTPlayerView.this.updateDisplaySize(parameter >> 16, parameter & TypedValue.DENSITY_NONE);
                    return;
                }
                if (what != 6) {
                    if (what != 7) {
                        return;
                    }
                    VLog.m248i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn player view CHANGE_BIND: " + TTPlayerViewHelper.objectToString(this) + ", client: " + TTPlayerViewHelper.objectToString(TTPlayerView.this.mWindowClient) + ",  called: " + TTPlayerView.this.mIsTTPlayerDisplaySizeCalled + ", fixed: " + TTPlayerView.this.mIsNeededFixedSize + ", vsize: " + TTPlayerView.this.mVideoSize);
                    TTPlayerView.this.mIsNeededFixedSize = false;
                    TTPlayerView.this.mIsTTPlayerDisplaySizeCalled = false;
                    return;
                }
                boolean z = TTPlayerView.this.mIsNeededFixedSize;
                TTPlayerView tTPlayerView = TTPlayerView.this;
                tTPlayerView.mIsNeededFixedSize = parameter != 0 && (tTPlayerView.mRenderView instanceof TTSurfaceView);
                VLog.m248i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn player view SURFACE_FIXED_SIZE: " + TTPlayerViewHelper.objectToString(this) + ", client: " + TTPlayerViewHelper.objectToString(TTPlayerView.this.mWindowClient) + ", fixed last: " + z + ", fixed: " + TTPlayerView.this.mIsNeededFixedSize + ", vsize: " + TTPlayerView.this.mVideoSize);
                int i4 = -1;
                if (TTPlayerView.this.mIsNeededFixedSize) {
                    boolean z2 = TTPlayerView.this.mVideoSize != null;
                    if (TTPlayerView.this.mVideoSize != null) {
                        i4 = TTPlayerView.this.mVideoSize.getWidth();
                        i = TTPlayerView.this.mVideoSize.getHeight();
                    } else {
                        i = -1;
                    }
                    z = z2;
                } else {
                    i = -1;
                }
                if (z) {
                    TTPlayerView.this.mRenderView.setFixedSizeIfNeeded(i4, i);
                }
            }
        });
        registerRenderViewCallback();
    }

    private void registerRenderViewCallback() {
        this.mRenderView.setRenderCallback(new ITTRenderView.RenderCallback() { // from class: com.ss.ttm.player.TTPlayerView.2
            @Override // com.ss.ttm.player.ITTRenderView.RenderCallback
            public void onSurfaceCreated(Surface surface) {
                TTPlayerView.this.mLockCpuBuffer = false;
                TTPlayerView.this.mIsSurfaceCreated = true;
                if (TTPlayerView.this.mIsNeededFixedSize && TTPlayerView.this.mVideoSize != null) {
                    TTPlayerView.this.mRenderView.setFixedSizeIfNeeded(TTPlayerView.this.mVideoSize.getWidth(), TTPlayerView.this.mVideoSize.getHeight());
                }
                if (TTPlayerView.this.mWindowClient != null) {
                    TTPlayerView.this.mWindowClient.onNewWindowAvailable(surface);
                }
                if (TTPlayerView.this.mLifeCycleCallback != null) {
                    if (!TTPlayerView.this.mIsOnloadCallback) {
                        TTPlayerView.this.mLifeCycleCallback.onLoad(TTPlayerView.this.mWindowClient);
                        TTPlayerView.this.mIsOnloadCallback = true;
                    }
                    TTPlayerView.this.mLifeCycleCallback.onNewSurfaceAvailable();
                }
            }

            @Override // com.ss.ttm.player.ITTRenderView.RenderCallback
            public void onSurfaceChanged(int width, int height) {
                VLog.m248i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn player view: " + TTPlayerViewHelper.objectToString(this) + ", client: " + TTPlayerViewHelper.objectToString(TTPlayerView.this.mWindowClient) + ", vsize: " + TTPlayerView.this.mVideoSize + ", on surface changed： w: " + width + ", h: " + height + ", ext: " + TTPlayerView.this.mIsNeededFixedSize);
                if (TTPlayerView.this.mIsNeededFixedSize) {
                    if (TTPlayerView.this.mVideoSize != null && (width != TTPlayerView.this.mVideoSize.getWidth() || height != TTPlayerView.this.mVideoSize.getHeight())) {
                        TTPlayerView.this.mRenderView.setFixedSizeIfNeeded(TTPlayerView.this.mVideoSize.getWidth(), TTPlayerView.this.mVideoSize.getHeight());
                    }
                    if (TTPlayerView.this.mWindowClient != null) {
                        TTPlayerView.this.mWindowClient.onWindowChanged(TTPlayerView.this.mRenderView.getView().getWidth(), TTPlayerView.this.mRenderView.getView().getHeight(), TTPlayerView.this.mNeedCrop);
                        return;
                    }
                    return;
                }
                if (TTPlayerView.this.mWindowClient != null) {
                    TTPlayerView.this.mWindowClient.onWindowChanged(width, height, TTPlayerView.this.mNeedCrop);
                }
            }

            @Override // com.ss.ttm.player.ITTRenderView.RenderCallback
            public void onSurfaceDestroyed() {
                TTPlayerView.this.mIsSurfaceCreated = false;
                if (TTPlayerView.this.mWindowClient != null) {
                    TTPlayerView.this.mWindowClient.onWindowDestroyed();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisplaySize(int width, int height) {
        VLog.m248i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn player view: " + TTPlayerViewHelper.objectToString(this) + ", window: " + TTPlayerViewHelper.objectToString(this.mWindowClient) + ",update size called: " + this.mIsTTPlayerDisplaySizeCalled + ",width: " + width + ", height: " + height + ". fixed: " + this.mIsNeededFixedSize);
        float f = height == 0 ? 1.0f : width / height;
        if (Math.abs(this.mVideoAspect - f) > 0.001f) {
            this.mVideoAspect = f;
            forceLayout();
            requestLayout();
        }
        TTPlayerViewHelper.Size size = this.mVideoSize;
        if (size != null && width == size.getWidth() && height == this.mVideoSize.getHeight()) {
            return;
        }
        this.mVideoSize = new TTPlayerViewHelper.Size(width, height);
        if (this.mIsNeededFixedSize) {
            this.mRenderView.setFixedSizeIfNeeded(width, height);
        }
    }
}
