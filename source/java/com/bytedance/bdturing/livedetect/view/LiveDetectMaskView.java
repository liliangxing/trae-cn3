package com.bytedance.bdturing.livedetect.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.bdturing.C0603R;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LiveDetectMaskView extends View {
    private static final float CIRCLE_START_DEGREE = 90.0f;
    private static final float DEFAULT_BOX_WIDTH_RATIO = 0.6f;
    private static final float DEFAULT_STROKE_WIDTH = 10.0f;
    private static final float DEFAULT_VIEW_BOX_GAP = 5.0f;
    public static final int DETECT_STATE_IDLE = 1;
    public static final int DETECT_STATE_RUNNING = 2;
    public static final int DETECT_STATE_SUCCESS = 3;
    private final int BOX_MASK_COLOR_END;
    private final int BOX_MASK_COLOR_START;
    private final long SCAN_ANIM_DURATION;
    private String TAG;
    private boolean isDebugMode;
    private Matrix mAnimMatrix;
    private RectF mAnimRect;
    private int[] mAnimShaderColors;
    private ValueAnimator mAnimator;
    private int mBackGroundColor;
    private int[] mBgCircleColors;
    private Matrix mBgCircleMatrix;
    private Paint mBgCirclePaint;
    private SweepGradient mBgCircleShader;
    private float mBoxHeightRatio;
    private BoxStateListener mBoxStateListener;
    private float mBoxTopMarginRatio;
    private Rect mBoxViewDrawRect;
    private Rect mBoxViewLayoutRect;
    private Paint mBoxViewPaint;
    private float mBoxWidthRatio;
    private Paint mCircleAnimPaint;
    private ArrayList<Float> mDetectBoxInfo;
    private Paint mDetectBoxPaint;
    private int mDetectState;
    private int mHeight;
    private int mSuccessStateColor;
    private SweepGradient mSweepGradient;
    private int mWidth;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface BoxStateListener {
        void onBoxSizeChange(Rect rect);
    }

    public boolean isDebugMode() {
        return this.isDebugMode;
    }

    public void setDebugMode(boolean z) {
        this.isDebugMode = z;
        this.mBackGroundColor = Color.parseColor(z ? "#59ffffff" : "#ffffff");
    }

    public LiveDetectMaskView(Context context) {
        this(context, null);
    }

    public LiveDetectMaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveDetectMaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBoxTopMarginRatio = 0.0f;
        this.TAG = "LiveDetectMaskView";
        this.SCAN_ANIM_DURATION = 1600L;
        this.BOX_MASK_COLOR_START = Color.parseColor("#CCFFFFFF");
        this.BOX_MASK_COLOR_END = Color.parseColor("#4DFFFFFF");
        this.mDetectState = 1;
        initView(attributeSet);
    }

    private void initView(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0603R.styleable.turing_detect_mask_view);
        int i = C0603R.styleable.turing_detect_mask_view_box_width_ratio;
        float f = DEFAULT_BOX_WIDTH_RATIO;
        float f2 = obtainStyledAttributes.getFloat(i, DEFAULT_BOX_WIDTH_RATIO);
        this.mBoxWidthRatio = f2;
        if (f2 > 0.0f) {
            f = f2;
        }
        this.mBoxWidthRatio = f;
        float f3 = obtainStyledAttributes.getFloat(C0603R.styleable.turing_detect_mask_view_box_width_height_ratio, 1.0f);
        this.mBoxHeightRatio = f3;
        this.mBoxHeightRatio = f3 > 0.0f ? f3 : 1.0f;
        this.mBoxTopMarginRatio = obtainStyledAttributes.getFloat(C0603R.styleable.turing_detect_mask_view_box_top_margin_ratio, 0.15f);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mBoxViewPaint = paint;
        paint.setAntiAlias(true);
        this.mBoxViewPaint.setStyle(Paint.Style.FILL);
        this.mBoxViewPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.mBoxViewPaint.setColor(this.BOX_MASK_COLOR_START);
        setLayerType(1, null);
        Paint paint2 = new Paint();
        this.mCircleAnimPaint = paint2;
        paint2.setAntiAlias(true);
        this.mCircleAnimPaint.setStyle(Paint.Style.STROKE);
        this.mCircleAnimPaint.setStrokeWidth(DEFAULT_STROKE_WIDTH);
        this.mCircleAnimPaint.setStrokeCap(Paint.Cap.ROUND);
        int parseColor = Color.parseColor("#001664FF");
        int parseColor2 = Color.parseColor("#ff1664FF");
        this.mBackGroundColor = Color.parseColor(this.isDebugMode ? "#59ffffff" : "#ffffff");
        this.mAnimShaderColors = new int[]{parseColor, parseColor2};
        Paint paint3 = new Paint();
        this.mBgCirclePaint = paint3;
        paint3.setAntiAlias(true);
        this.mBgCirclePaint.setStyle(Paint.Style.STROKE);
        this.mBgCirclePaint.setStrokeWidth(DEFAULT_STROKE_WIDTH);
        this.mBgCirclePaint.setStrokeCap(Paint.Cap.ROUND);
        int parseColor3 = Color.parseColor("#99000000");
        int parseColor4 = Color.parseColor("#00000000");
        this.mSuccessStateColor = Color.parseColor("#309256");
        this.mBgCircleColors = new int[]{parseColor3, parseColor4};
        Paint paint4 = new Paint();
        this.mDetectBoxPaint = paint4;
        paint4.setAntiAlias(true);
        this.mDetectBoxPaint.setStyle(Paint.Style.STROKE);
        this.mDetectBoxPaint.setStrokeWidth(3.0f);
        this.mDetectBoxPaint.setColor(-65536);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (this.mWidth == i && this.mHeight == i2) {
            return;
        }
        this.mWidth = i;
        this.mHeight = i2;
        int max = (int) (this.mWidth * Math.max(Math.min(0.9f, this.mBoxWidthRatio / ((i * 1.0f) / getScreenWidth())), this.mBoxWidthRatio));
        int i5 = (int) (max / this.mBoxHeightRatio);
        Rect rect = new Rect();
        this.mBoxViewDrawRect = rect;
        rect.left = (this.mWidth - max) / 2;
        this.mBoxViewDrawRect.top = (int) (this.mWidth * this.mBoxTopMarginRatio);
        Rect rect2 = this.mBoxViewDrawRect;
        rect2.right = rect2.left + max;
        Rect rect3 = this.mBoxViewDrawRect;
        rect3.bottom = rect3.top + i5;
        int width = (int) (((this.mBoxViewDrawRect.width() * 1.0f) / 2.0f) * 0.2f);
        ArrayList<Float> arrayList = new ArrayList<>(4);
        this.mDetectBoxInfo = arrayList;
        arrayList.add(Float.valueOf(((this.mBoxViewDrawRect.left + width) * 1.0f) / this.mWidth));
        this.mDetectBoxInfo.add(Float.valueOf((this.mBoxViewDrawRect.top * 1.0f) / this.mHeight));
        this.mDetectBoxInfo.add(Float.valueOf(((this.mBoxViewDrawRect.right - width) * 1.0f) / this.mWidth));
        this.mDetectBoxInfo.add(Float.valueOf((this.mBoxViewDrawRect.bottom * 1.0f) / this.mHeight));
        this.mAnimRect = new RectF(this.mBoxViewDrawRect.left - DEFAULT_STROKE_WIDTH, this.mBoxViewDrawRect.top - DEFAULT_STROKE_WIDTH, this.mBoxViewDrawRect.right + DEFAULT_STROKE_WIDTH, this.mBoxViewDrawRect.bottom + DEFAULT_STROKE_WIDTH);
        this.mBoxViewLayoutRect = new Rect();
        ViewParent parent = getParent();
        if (parent != null) {
            parent = parent.getParent();
        }
        if (parent != null && (parent instanceof LiveDetectView)) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) ((ViewGroup) parent).getLayoutParams();
        } else {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        }
        this.mBoxViewLayoutRect.top = marginLayoutParams.topMargin + this.mBoxViewDrawRect.top;
        this.mBoxViewLayoutRect.left = this.mBoxViewDrawRect.left;
        this.mBoxViewLayoutRect.right = this.mBoxViewDrawRect.right;
        Rect rect4 = this.mBoxViewLayoutRect;
        rect4.bottom = rect4.top + this.mBoxViewDrawRect.height();
        onBoxSizeChange(this.mBoxViewLayoutRect);
    }

    private int getScreenWidth() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    private void onBoxSizeChange(Rect rect) {
        BoxStateListener boxStateListener;
        if (rect == null || (boxStateListener = this.mBoxStateListener) == null) {
            return;
        }
        boxStateListener.onBoxSizeChange(rect);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.mBackGroundColor);
        canvas.drawCircle(this.mBoxViewDrawRect.centerX(), this.mBoxViewDrawRect.centerY(), (this.mBoxViewDrawRect.width() * 1.0f) / 2.0f, this.mBoxViewPaint);
        drawCircleBg(canvas);
        drawCircleAnim(canvas);
        drawDetectBox(canvas);
    }

    private void drawDetectBox(Canvas canvas) {
        if (this.isDebugMode) {
            canvas.drawRect(this.mDetectBoxInfo.get(0).floatValue() * this.mWidth, this.mDetectBoxInfo.get(1).floatValue() * this.mHeight, this.mDetectBoxInfo.get(2).floatValue() * this.mWidth, this.mDetectBoxInfo.get(3).floatValue() * this.mHeight, this.mDetectBoxPaint);
        }
    }

    private void drawCircleBg(Canvas canvas) {
        if (this.mDetectState != 3) {
            return;
        }
        drawSuccessCircle(canvas);
    }

    private void drawSuccessCircle(Canvas canvas) {
        this.mBgCirclePaint.setShader(null);
        this.mBgCirclePaint.setColor(this.mSuccessStateColor);
        canvas.drawArc(this.mAnimRect, 0.0f, 360.0f, false, this.mBgCirclePaint);
    }

    private void drawIdleCircle(Canvas canvas) {
        if (this.mBgCircleShader == null) {
            this.mBgCircleShader = new SweepGradient(this.mBoxViewDrawRect.centerX(), this.mBoxViewDrawRect.centerY(), this.mBgCircleColors, (float[]) null);
            Matrix matrix = new Matrix();
            this.mBgCircleMatrix = matrix;
            matrix.setRotate(CIRCLE_START_DEGREE, this.mBoxViewDrawRect.centerX(), this.mBoxViewDrawRect.centerY());
        }
        this.mBgCircleShader.setLocalMatrix(this.mBgCircleMatrix);
        this.mBgCirclePaint.setShader(this.mBgCircleShader);
        canvas.drawArc(this.mAnimRect, 0.0f, 360.0f, false, this.mBgCirclePaint);
    }

    public void updateDetectState(int i) {
        if (this.mDetectState == i) {
            return;
        }
        this.mDetectState = i;
        postInvalidate();
    }

    private void drawCircleAnim(Canvas canvas) {
        if (this.mAnimator == null || this.mDetectState == 3) {
            return;
        }
        if (this.mSweepGradient == null) {
            this.mSweepGradient = new SweepGradient(this.mBoxViewDrawRect.centerX(), this.mBoxViewDrawRect.centerY(), this.mAnimShaderColors, (float[]) null);
            this.mAnimMatrix = new Matrix();
            this.mCircleAnimPaint.setShader(this.mSweepGradient);
        }
        this.mSweepGradient.setLocalMatrix(this.mAnimMatrix);
        canvas.drawArc(this.mAnimRect, 0.0f, 360.0f, false, this.mCircleAnimPaint);
    }

    public void startScanAnim() {
        this.mDetectState = 2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mAnimator = ofFloat;
        ofFloat.setDuration(1600L);
        this.mAnimator.setRepeatCount(-1);
        this.mAnimator.setRepeatMode(1);
        this.mAnimator.setInterpolator(PathInterpolatorCompat.create(0.55f, 0.15f, 0.45f, 0.85f));
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.bdturing.livedetect.view.LiveDetectMaskView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (LiveDetectMaskView.this.mAnimMatrix != null && LiveDetectMaskView.this.mBoxViewDrawRect != null) {
                    LiveDetectMaskView.this.mAnimMatrix.setRotate(((animatedFraction * 360.0f) + LiveDetectMaskView.CIRCLE_START_DEGREE) % 360.0f, LiveDetectMaskView.this.mBoxViewDrawRect.centerX(), LiveDetectMaskView.this.mBoxViewDrawRect.centerY());
                }
                LiveDetectMaskView.this.postInvalidate();
            }
        });
        this.mAnimator.start();
    }

    public void stopAnim() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void showBoxMask(boolean z) {
        int i;
        if (z) {
            i = this.BOX_MASK_COLOR_START;
        } else {
            i = this.BOX_MASK_COLOR_END;
        }
        Paint paint = this.mBoxViewPaint;
        if (paint == null || paint.getColor() == i) {
            return;
        }
        this.mBoxViewPaint.setColor(i);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public ArrayList<Float> getBoxRectInfo() {
        return this.mDetectBoxInfo;
    }

    public void setBoxStateListener(BoxStateListener boxStateListener) {
        this.mBoxStateListener = boxStateListener;
    }
}
