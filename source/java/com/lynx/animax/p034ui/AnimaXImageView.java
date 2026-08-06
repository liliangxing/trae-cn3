package com.lynx.animax.p034ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;
import com.lynx.animax.AnimaXPlayer;
import com.lynx.animax.C1335R;
import com.lynx.animax.ability.NativeAbility;
import com.lynx.animax.base.VisibilityState;
import com.lynx.animax.drawable.AnimaXSurfaceDrawable;
import com.lynx.animax.drawable.BitmapBuffer;
import com.lynx.animax.drawable.BitmapBufferGroup;
import com.lynx.animax.p034ui.AnimaXContext;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.animax.util.UIPropertyUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AnimaXImageView extends View implements IAnimaXView, IAnimaXPlayerDelegate {
    private static final String TAG = "AnimaXImageView";
    private final BitmapBufferGroup mBufferGroup;
    private boolean mEnableNativeTapLayerEvent;
    private boolean mIgnoreAttachStatus;
    private final Paint mPaint;
    private final IAnimaXPlayer mPlayer;
    private BitmapBuffer mRenderBitmapBuffer;
    private AnimaXSurfaceDrawable mSurfaceDrawable;

    public AnimaXImageView(Context context) {
        super(context);
        this.mEnableNativeTapLayerEvent = false;
        this.mIgnoreAttachStatus = false;
        AnimaXPlayer animaXPlayer = new AnimaXPlayer(new AnimaXContext.Builder(new NativeAbility(), context).build());
        this.mPlayer = animaXPlayer;
        this.mPaint = new Paint(6);
        animaXPlayer.enableSoftwareRender(true);
        this.mBufferGroup = new BitmapBufferGroup(this, true);
        initView(null);
    }

    public AnimaXImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEnableNativeTapLayerEvent = false;
        this.mIgnoreAttachStatus = false;
        AnimaXPlayer animaXPlayer = new AnimaXPlayer(new AnimaXContext.Builder(new NativeAbility(), context).build());
        this.mPlayer = animaXPlayer;
        this.mPaint = new Paint(6);
        animaXPlayer.enableSoftwareRender(true);
        this.mBufferGroup = new BitmapBufferGroup(this, true);
        initView(attributeSet);
    }

    public AnimaXImageView(AnimaXContext animaXContext) {
        super(animaXContext.getContext());
        this.mEnableNativeTapLayerEvent = false;
        this.mIgnoreAttachStatus = false;
        AnimaXPlayer animaXPlayer = new AnimaXPlayer(animaXContext);
        this.mPlayer = animaXPlayer;
        this.mPaint = new Paint(6);
        animaXPlayer.enableSoftwareRender(true);
        this.mBufferGroup = new BitmapBufferGroup(this, true);
        initView(null);
    }

    public AnimaXImageView(AnimaXPlayer animaXPlayer) {
        super(animaXPlayer.getAnimaXContext().getContext());
        this.mEnableNativeTapLayerEvent = false;
        this.mIgnoreAttachStatus = false;
        this.mPlayer = animaXPlayer;
        this.mPaint = new Paint(6);
        animaXPlayer.enableSoftwareRender(true);
        this.mBufferGroup = new BitmapBufferGroup(this, true);
        initView(null);
    }

    private void initView(AttributeSet attributeSet) {
        AnimaXContext animaXContext = this.mPlayer.getAnimaXContext();
        if (animaXContext == null || animaXContext.getAbility() == null) {
            AnimaXLog.m2540e(TAG, "initView fail, missing AnimaXContext or Ability.");
            return;
        }
        animaXContext.getAbility().setCompositionReadyListener(this);
        try {
            initAttributes(animaXContext.getContext(), attributeSet);
        } catch (NullPointerException unused) {
            AnimaXLog.m2540e(TAG, "initAttributes fail, context's theme is null.");
        }
    }

    private void initAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (context.getTheme() == null) {
            AnimaXLog.m2540e(TAG, "initAttributes fail, context's theme is null.");
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1335R.styleable.AnimaXImageView);
        String string = obtainStyledAttributes.getString(C1335R.styleable.AnimaXImageView_animax_image_animationUrl);
        if (string != null) {
            this.mPlayer.setSrc(string);
        }
        this.mPlayer.setAutoPlay(obtainStyledAttributes.getBoolean(C1335R.styleable.AnimaXImageView_animax_image_autoPlay, true));
        this.mPlayer.setLoop(obtainStyledAttributes.getBoolean(C1335R.styleable.AnimaXImageView_animax_image_loop, false));
        String string2 = obtainStyledAttributes.getString(C1335R.styleable.AnimaXImageView_animax_image_objectFit);
        if (string2 != null) {
            this.mPlayer.setObjectFit(UIPropertyUtil.convertStringToObjectFit(string2));
        }
        obtainStyledAttributes.recycle();
    }

    public Bitmap getCurrentBitmap() {
        BitmapBuffer bitmapBuffer = this.mRenderBitmapBuffer;
        if (bitmapBuffer != null) {
            return bitmapBuffer.getBitmap();
        }
        return null;
    }

    @Override // com.lynx.animax.p034ui.IAnimaXView, com.lynx.animax.p034ui.IAnimaXPlayer
    public void release() {
        AnimaXLog.m2541i(TAG, "release: " + this);
        BitmapBuffer bitmapBuffer = this.mRenderBitmapBuffer;
        if (bitmapBuffer != null) {
            bitmapBuffer.release();
        }
        this.mBufferGroup.release();
        this.mPlayer.release();
    }

    @Override // com.lynx.animax.p034ui.IAnimaXView, com.lynx.animax.p034ui.IAnimaXPlayerDelegate
    public IAnimaXPlayer getPlayer() {
        return this.mPlayer;
    }

    @Override // com.lynx.animax.p034ui.IAnimaXView
    public void setEnableTapLayerEvent(boolean z) {
        this.mEnableNativeTapLayerEvent = z;
    }

    @Override // com.lynx.animax.p034ui.IAnimaXView
    public void setIgnoreAttachStatus(boolean z) {
        this.mIgnoreAttachStatus = z;
    }

    @Override // com.lynx.animax.base.IAnimaXCompositionReadyListener
    public void onCompositionReady() {
        if (this.mSurfaceDrawable == null && this.mIgnoreAttachStatus) {
            this.mPlayer.markPlatformSurfaceAsInvalid(true);
            AnimaXLog.m2541i(TAG, "The Surface has not been created yet; Creating a temporary one.");
            onSizeChanged(1, 1, 0, 0);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mEnableNativeTapLayerEvent) {
            handleTouchEvent(motionEvent);
        }
        if (motionEvent != null) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        if (this.mIgnoreAttachStatus) {
            return;
        }
        super.onAttachedToWindow();
        this.mPlayer.updateVisibilityState(true, VisibilityState.ATTACH);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.mIgnoreAttachStatus) {
            return;
        }
        super.onDetachedFromWindow();
        this.mPlayer.updateVisibilityState(false, VisibilityState.ATTACH);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        this.mPlayer.updateVisibilityState(i == 0, VisibilityState.VISIBLE);
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        super.setAlpha(f);
        boolean z = getAlpha() > 0.0f;
        boolean z2 = f > 0.0f;
        if (z != z2) {
            this.mPlayer.updateVisibilityState(z2, VisibilityState.OPACITY);
        }
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (this.mIgnoreAttachStatus) {
            return;
        }
        this.mPlayer.updateVisibilityState(z, VisibilityState.AGGREGATED);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mPlayer.updateVisibilityState(i > 0 && i2 > 0, VisibilityState.SIZE);
        if (i <= 0 || i2 <= 0) {
            AnimaXLog.m2541i(TAG, "Skip invalid size: " + i + " / " + i2);
            return;
        }
        BitmapBuffer bitmapBuffer = this.mRenderBitmapBuffer;
        if (bitmapBuffer != null) {
            bitmapBuffer.release();
            this.mRenderBitmapBuffer = null;
        }
        AnimaXSurfaceDrawable animaXSurfaceDrawable = this.mSurfaceDrawable;
        if (animaXSurfaceDrawable == null) {
            AnimaXSurfaceDrawable createFromBitmapBufferGroup = AnimaXSurfaceDrawable.createFromBitmapBufferGroup(this.mBufferGroup, i, i2);
            this.mSurfaceDrawable = createFromBitmapBufferGroup;
            this.mPlayer.createAnimaXSurface(createFromBitmapBufferGroup);
        } else if (animaXSurfaceDrawable.updateSize(i, i2)) {
            this.mPlayer.updateAnimaXSurface(this.mSurfaceDrawable);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mRenderBitmapBuffer == null) {
            this.mRenderBitmapBuffer = this.mBufferGroup.swapBitmapBuffer(null);
        }
        BitmapBuffer bitmapBuffer = this.mRenderBitmapBuffer;
        if (bitmapBuffer == null) {
            return;
        }
        if (bitmapBuffer.getState() != BitmapBuffer.BufferState.Ready) {
            this.mRenderBitmapBuffer.release();
            this.mRenderBitmapBuffer = null;
            return;
        }
        Bitmap bitmap = this.mRenderBitmapBuffer.getBitmap();
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        int save = canvas.save();
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.mPaint);
        canvas.restoreToCount(save);
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: com.lynx.animax.ui.AnimaXImageView$$ExternalSyntheticLambda0
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                AnimaXImageView.this.m2912lambda$onDraw$0$comlynxanimaxuiAnimaXImageView(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onDraw$0$com-lynx-animax-ui-AnimaXImageView, reason: not valid java name */
    public /* synthetic */ void m2912lambda$onDraw$0$comlynxanimaxuiAnimaXImageView(long j) {
        BitmapBuffer bitmapBuffer = this.mRenderBitmapBuffer;
        BitmapBuffer swapBitmapBuffer = this.mBufferGroup.swapBitmapBuffer(bitmapBuffer);
        this.mRenderBitmapBuffer = swapBitmapBuffer;
        if (swapBitmapBuffer == null || bitmapBuffer == swapBitmapBuffer) {
            return;
        }
        invalidate();
    }
}
