package com.bytedance.ies.uikit.switchview;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.CompoundButton;

/* loaded from: classes4.dex */
public class SwitchBase extends CompoundButton {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int TOUCH_MODE_CLICK = 3;
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE = 0;
    private int mMinFlingVelocity;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private Drawable mThumbDrawable;
    private float mThumbPosition;
    private int mThumbWidth;
    private int mTouchMode;
    private int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private VelocityTracker mVelocityTracker;

    public SwitchBase(Context context) {
        this(context, null);
    }

    public SwitchBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.bytedance.ugc.uikit.R.styleable.SwitchBase, i, 0);
        this.mThumbDrawable = obtainStyledAttributes.getDrawable(com.bytedance.ugc.uikit.R.styleable.SwitchBase_ms_thumb);
        this.mTrackDrawable = obtainStyledAttributes.getDrawable(com.bytedance.ugc.uikit.R.styleable.SwitchBase_ms_track);
        this.mSwitchMinWidth = obtainStyledAttributes.getDimensionPixelSize(com.bytedance.ugc.uikit.R.styleable.SwitchBase_ms_switchMinWidth, 0);
        this.mSwitchPadding = obtainStyledAttributes.getDimensionPixelSize(com.bytedance.ugc.uikit.R.styleable.SwitchBase_ms_switchPadding, 0);
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchPadding(int i) {
        this.mSwitchPadding = i;
        requestLayout();
    }

    public void setTrackDrawable(Drawable drawable) {
        this.mTrackDrawable = drawable;
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(getContext().getResources().getDrawable(i));
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    public void setThumbDrawable(Drawable drawable) {
        this.mThumbDrawable = drawable;
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(getContext().getResources().getDrawable(i));
    }

    public Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int max = Math.max(this.mSwitchMinWidth, this.mTrackDrawable.getIntrinsicWidth());
        int intrinsicHeight = this.mTrackDrawable.getIntrinsicHeight();
        this.mThumbWidth = this.mThumbDrawable.getIntrinsicWidth();
        this.mSwitchWidth = max;
        this.mSwitchHeight = intrinsicHeight;
        setMeasuredDimension(max, intrinsicHeight);
    }

    private boolean hitThumb(float f, float f2) {
        this.mThumbDrawable.getPadding(this.mTempRect);
        int i = this.mSwitchTop;
        int i2 = this.mTouchSlop;
        int i3 = i - i2;
        int i4 = (this.mSwitchLeft + ((int) (this.mThumbPosition + 0.5f))) - i2;
        int i5 = this.mThumbWidth + i4 + this.mTempRect.left + this.mTempRect.right;
        int i6 = this.mTouchSlop;
        return f > ((float) i4) && f < ((float) (i5 + i6)) && f2 > ((float) i3) && f2 < ((float) (this.mSwitchBottom + i6));
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
    
        if (r0 != 3) goto L40;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (isEnabled()) {
                if (hitThumb(x, y)) {
                    this.mTouchMode = 1;
                } else {
                    this.mTouchMode = 3;
                }
                this.mTouchX = x;
                this.mTouchY = y;
            }
        } else {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.mTouchMode;
                    if (i == 1) {
                        float x2 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        if (Math.abs(x2 - this.mTouchX) > this.mTouchSlop || Math.abs(y2 - this.mTouchY) > this.mTouchSlop) {
                            this.mTouchMode = 2;
                            this.mTouchX = x2;
                            this.mTouchY = y2;
                            return true;
                        }
                    } else if (i == 2) {
                        float x3 = motionEvent.getX();
                        float max = Math.max(0.0f, Math.min(this.mThumbPosition + (x3 - this.mTouchX), getThumbScrollRange()));
                        if (max != this.mThumbPosition) {
                            this.mThumbPosition = max;
                            this.mTouchX = x3;
                            invalidate();
                        }
                        return true;
                    }
                }
            }
            int i2 = this.mTouchMode;
            if (i2 == 2) {
                stopDrag(motionEvent);
                return true;
            }
            if (i2 == 1 || i2 == 3) {
                this.mTouchMode = 0;
                this.mVelocityTracker.clear();
                toggle();
                return true;
            }
            this.mTouchMode = 0;
            this.mVelocityTracker.clear();
        }
        return this.mTouchMode != 0;
    }

    private void cancelSuperTouch(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private void stopDrag(MotionEvent motionEvent) {
        boolean z = false;
        this.mTouchMode = 0;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        cancelSuperTouch(motionEvent);
        if (z2) {
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float xVelocity = this.mVelocityTracker.getXVelocity();
            if (Math.abs(xVelocity) <= this.mMinFlingVelocity) {
                z = getTargetCheckedState();
            } else if (xVelocity > 0.0f) {
                z = true;
            }
            animateThumbToCheckedState(z);
            return;
        }
        animateThumbToCheckedState(isChecked());
    }

    protected void animateThumbToCheckedState(boolean z) {
        setChecked(z);
    }

    private boolean getTargetCheckedState() {
        return this.mThumbPosition >= ((float) (getThumbScrollRange() / 2));
    }

    private void setThumbPosition(boolean z) {
        this.mThumbPosition = z ? getThumbScrollRange() : 0.0f;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        setThumbPosition(isChecked());
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        super.onLayout(z, i, i2, i3, i4);
        setThumbPosition(isChecked());
        int width = getWidth() - getPaddingRight();
        int i8 = width - this.mSwitchWidth;
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i5 = this.mSwitchHeight;
            i6 = paddingTop - (i5 / 2);
        } else if (gravity != 80) {
            i6 = getPaddingTop();
            i5 = this.mSwitchHeight;
        } else {
            i7 = getHeight() - getPaddingBottom();
            i6 = i7 - this.mSwitchHeight;
            this.mSwitchLeft = i8;
            this.mSwitchTop = i6;
            this.mSwitchBottom = i7;
            this.mSwitchRight = width;
        }
        i7 = i5 + i6;
        this.mSwitchLeft = i8;
        this.mSwitchTop = i6;
        this.mSwitchBottom = i7;
        this.mSwitchRight = width;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.mSwitchLeft;
        int i2 = this.mSwitchTop;
        int i3 = this.mSwitchRight;
        int i4 = this.mSwitchBottom;
        this.mTrackDrawable.setBounds(i, i2, i3, i4);
        this.mTrackDrawable.draw(canvas);
        canvas.save();
        this.mTrackDrawable.getPadding(this.mTempRect);
        int i5 = i + this.mTempRect.left;
        canvas.clipRect(i5, i2, i3 - this.mTempRect.right, i4);
        this.mThumbDrawable.getPadding(this.mTempRect);
        int i6 = (int) (this.mThumbPosition + 0.5f);
        this.mThumbDrawable.setBounds((i5 - this.mTempRect.left) + i6, i2, i5 + i6 + this.mThumbWidth + this.mTempRect.right, i4);
        this.mThumbDrawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.mSwitchPadding : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.mSwitchWidth;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.mSwitchPadding : compoundPaddingRight;
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.mTrackDrawable;
        if (drawable == null) {
            return 0;
        }
        drawable.getPadding(this.mTempRect);
        return ((this.mSwitchWidth - this.mThumbWidth) - this.mTempRect.left) - this.mTempRect.right;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            drawable.setState(drawableState);
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.setState(drawableState);
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mThumbDrawable || drawable == this.mTrackDrawable;
    }
}
