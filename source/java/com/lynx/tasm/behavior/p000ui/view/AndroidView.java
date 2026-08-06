package com.lynx.tasm.behavior.p000ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.IDrawChildHook;
import com.lynx.tasm.behavior.p000ui.MeaningfulPaintingArea;
import com.lynx.tasm.behavior.p000ui.UIBody;
import com.lynx.tasm.gesture.arena.GestureArenaManager;
import com.lynx.tasm.utils.BlurUtils;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AndroidView extends ViewGroup implements IDrawChildHook.IDrawChildHookBinding, MeaningfulPaintingArea.IMeaningfulPaintingAreaInvalidateHook {
    private Bitmap mBlurBitmap;
    private Canvas mBlurCanvas;
    private float mBlurRadius;
    private int mBlurSampling;
    private boolean mConsumeHoverEvent;
    protected IDrawChildHook mDrawChildHook;
    private WeakReference<GestureArenaManager> mGestureArenaManager;
    private String mImpressionId;
    private Boolean mInterceptGesture;
    private boolean mIsAttachToWindow;
    private boolean mNeedUsePreDrawListener;
    private final ViewTreeObserver.OnPreDrawListener mPreDrawListener;
    private boolean mPreDrawListenerAdded;
    private boolean nativeInteractionEnabled;

    public void setBlurSampling(int i) {
        this.mBlurSampling = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-lynx-tasm-behavior-ui-view-AndroidView, reason: not valid java name */
    public /* synthetic */ boolean m4133lambda$new$0$comlynxtasmbehavioruiviewAndroidView() {
        updateBlur();
        return true;
    }

    private void updateBlur() {
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 || height <= 0) {
            this.mBlurBitmap = null;
            return;
        }
        Bitmap bitmap = this.mBlurBitmap;
        if (bitmap == null || bitmap.getWidth() != width || this.mBlurBitmap.getHeight() != height) {
            this.mBlurBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            this.mBlurCanvas = new Canvas(this.mBlurBitmap);
        }
        this.mBlurBitmap.eraseColor(0);
        this.mBlurCanvas.save();
        super.draw(this.mBlurCanvas);
        this.mBlurCanvas.restore();
        Bitmap blur = BlurUtils.blur(getContext(), this.mBlurBitmap, width, height, this.mBlurRadius, this.mBlurSampling);
        this.mBlurBitmap = blur;
        this.mBlurCanvas.setBitmap(blur);
    }

    public AndroidView(Context context) {
        super(context);
        this.mBlurRadius = 0.0f;
        this.mPreDrawListenerAdded = false;
        this.mNeedUsePreDrawListener = false;
        this.mIsAttachToWindow = false;
        this.mInterceptGesture = null;
        this.mBlurSampling = 1;
        this.mPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.lynx.tasm.behavior.ui.view.AndroidView$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return AndroidView.this.m4133lambda$new$0$comlynxtasmbehavioruiviewAndroidView();
            }
        };
        this.mConsumeHoverEvent = false;
        this.nativeInteractionEnabled = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IDrawChildHook iDrawChildHook;
        if (getRootView().isLayoutRequested() || (iDrawChildHook = this.mDrawChildHook) == null) {
            return;
        }
        iDrawChildHook.performLayoutChildrenUI();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        IDrawChildHook iDrawChildHook;
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        if (getRootView().isLayoutRequested() || (iDrawChildHook = this.mDrawChildHook) == null) {
            return;
        }
        iDrawChildHook.performMeasureChildrenUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttachToWindow = true;
        if (!this.mNeedUsePreDrawListener || this.mPreDrawListenerAdded) {
            return;
        }
        getViewTreeObserver().addOnPreDrawListener(this.mPreDrawListener);
        this.mPreDrawListenerAdded = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsAttachToWindow = false;
        if (this.mPreDrawListenerAdded) {
            getViewTreeObserver().removeOnPreDrawListener(this.mPreDrawListener);
            this.mPreDrawListenerAdded = false;
        }
    }

    public void interceptGesture(boolean z) {
        this.mInterceptGesture = Boolean.valueOf(z);
    }

    private boolean isInterceptGestureNotNull() {
        return this.mInterceptGesture != null;
    }

    private boolean isNeedInterceptGesture() {
        return isInterceptGestureNotNull() && this.mInterceptGesture.booleanValue();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (isNeedInterceptGesture()) {
            return this.mInterceptGesture.booleanValue();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nativeInteractionEnabled) {
            return true;
        }
        if (isInterceptGestureNotNull()) {
            if (motionEvent.getActionMasked() == 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            if (motionEvent.getActionMasked() == 2) {
                getParent().requestDisallowInterceptTouchEvent(this.mInterceptGesture.booleanValue());
                return !this.mInterceptGesture.booleanValue() ? super.onTouchEvent(motionEvent) : this.mInterceptGesture.booleanValue();
            }
            if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) {
                this.mInterceptGesture = null;
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setNativeInteractionEnabled(boolean z) {
        this.nativeInteractionEnabled = z;
    }

    public void setImpressionId(String str) {
        this.mImpressionId = str;
    }

    public String getImpressionId() {
        return this.mImpressionId;
    }

    @Override // com.lynx.tasm.behavior.ui.MeaningfulPaintingArea.IMeaningfulPaintingAreaInvalidateHook
    public IDrawChildHook getDrawChildHook() {
        return this.mDrawChildHook;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public void bindDrawChildHook(IDrawChildHook iDrawChildHook) {
        this.mDrawChildHook = iDrawChildHook;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        IDrawChildHook iDrawChildHook = this.mDrawChildHook;
        if (iDrawChildHook != null) {
            iDrawChildHook.beforeDraw(canvas);
        }
        if (this.mBlurRadius != 0.0f && (bitmap = this.mBlurBitmap) != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        } else {
            super.draw(canvas);
        }
        IDrawChildHook iDrawChildHook2 = this.mDrawChildHook;
        if (iDrawChildHook2 != null) {
            iDrawChildHook2.afterDraw(canvas);
        }
    }

    public void setGestureManager(GestureArenaManager gestureArenaManager) {
        this.mGestureArenaManager = new WeakReference<>(gestureArenaManager);
    }

    @Override // android.view.View
    public void computeScroll() {
        GestureArenaManager gestureArenaManager;
        super.computeScroll();
        WeakReference<GestureArenaManager> weakReference = this.mGestureArenaManager;
        if (weakReference == null || (gestureArenaManager = weakReference.get()) == null) {
            return;
        }
        gestureArenaManager.computeScroll();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        IDrawChildHook iDrawChildHook = this.mDrawChildHook;
        if (iDrawChildHook != null) {
            iDrawChildHook.beforeDispatchDraw(canvas);
        }
        super.dispatchDraw(canvas);
        IDrawChildHook iDrawChildHook2 = this.mDrawChildHook;
        if (iDrawChildHook2 != null) {
            iDrawChildHook2.afterDispatchDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild;
        IDrawChildHook iDrawChildHook = this.mDrawChildHook;
        Rect beforeDrawChild = iDrawChildHook != null ? iDrawChildHook.beforeDrawChild(canvas, view, j) : null;
        if (beforeDrawChild != null) {
            canvas.save();
            canvas.clipRect(beforeDrawChild);
            drawChild = super.drawChild(canvas, view, j);
            canvas.restore();
        } else {
            drawChild = super.drawChild(canvas, view, j);
        }
        IDrawChildHook iDrawChildHook2 = this.mDrawChildHook;
        if (iDrawChildHook2 != null) {
            iDrawChildHook2.afterDrawChild(canvas, view, j);
        }
        return drawChild;
    }

    @Override // android.view.ViewGroup
    public void setChildrenDrawingOrderEnabled(boolean z) {
        super.setChildrenDrawingOrderEnabled(z);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        IDrawChildHook iDrawChildHook = this.mDrawChildHook;
        if (iDrawChildHook != null) {
            return iDrawChildHook.getChildDrawingOrder(i, i2);
        }
        return super.getChildDrawingOrder(i, i2);
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        IDrawChildHook iDrawChildHook = this.mDrawChildHook;
        if (iDrawChildHook != null) {
            return iDrawChildHook.hasOverlappingRendering();
        }
        return super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent) || this.mConsumeHoverEvent;
    }

    public void setConsumeHoverEvent(boolean z) {
        this.mConsumeHoverEvent = z;
    }

    public void setBlur(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.mBlurRadius = f;
        if (BlurUtils.createEffect(this, f)) {
            return;
        }
        if (f == 0.0f) {
            removeBlur();
            return;
        }
        this.mNeedUsePreDrawListener = true;
        if (!this.mIsAttachToWindow || this.mPreDrawListenerAdded) {
            return;
        }
        getViewTreeObserver().addOnPreDrawListener(this.mPreDrawListener);
        setBackgroundColor(0);
        this.mPreDrawListenerAdded = true;
    }

    public void removeBlur() {
        this.mBlurRadius = 0.0f;
        if (BlurUtils.removeEffect(this)) {
            return;
        }
        this.mNeedUsePreDrawListener = false;
        if (this.mPreDrawListenerAdded) {
            if (this.mIsAttachToWindow) {
                getViewTreeObserver().removeOnPreDrawListener(this.mPreDrawListener);
                this.mPreDrawListenerAdded = false;
            }
            this.mBlurBitmap = null;
            this.mBlurCanvas = null;
        }
    }

    @Override // com.lynx.tasm.behavior.ui.MeaningfulPaintingArea.IMeaningfulPaintingAreaInvalidateHook
    public void invalidateMeaningfulPaintingArea() {
        UIBody.UIBodyView uIBodyView;
        if (!(getContext() instanceof LynxContext) || (uIBodyView = ((LynxContext) getContext()).getUIBodyView()) == null) {
            return;
        }
        uIBodyView.invalidateMeaningfulPaintingArea();
    }
}
