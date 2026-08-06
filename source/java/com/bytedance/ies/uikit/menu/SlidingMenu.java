package com.bytedance.ies.uikit.menu;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.bytedance.ies.uikit.menu.CustomViewAbove;
import com.bytedance.ugc.uikit.R;

/* loaded from: classes4.dex */
public class SlidingMenu extends RelativeLayout {
    static boolean DEBUG = false;
    private static final int INVALID_POINTER = -1;
    public static final int LEFT = 0;
    public static final int LEFT_RIGHT = 2;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    public static final int RIGHT = 1;
    public static final int SLIDING_CONTENT = 1;
    public static final int SLIDING_WINDOW = 0;
    private static final String TAG = "SlidingMenu";
    public static final int TOUCHMODE_FULLSCREEN = 1;
    public static final int TOUCHMODE_MARGIN = 0;
    public static final int TOUCHMODE_NONE = 2;
    private boolean mActionbarOverlay;
    protected int mActivePointerId;
    private OnClickCloseListener mClickCloseListener;
    private OnCloseListener mCloseListener;
    private boolean mEnabled;
    private int mFlingDistance;
    private Handler mHandler;
    private boolean mIgnoreContentsBackground;
    private float mInitialMotionX;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private float mLastMotionX;
    private float mLastMotionY;
    protected int mMaximumVelocity;
    private int mMinimumVelocity;
    private OnOpenListener mOpenListener;
    private boolean mQuickReturn;
    private int mTouchSlop;
    protected VelocityTracker mVelocityTracker;
    private CustomViewAbove mViewAbove;
    private CustomViewBehind mViewBehind;

    /* loaded from: classes4.dex */
    public interface CanvasTransformer {
        void transformCanvas(Canvas canvas, float f);
    }

    /* loaded from: classes4.dex */
    public interface OnClickCloseListener {
        void onClickClose();
    }

    /* loaded from: classes4.dex */
    public interface OnCloseListener {
        void onClose();
    }

    /* loaded from: classes4.dex */
    public interface OnClosedListener {
        void onClosed();
    }

    /* loaded from: classes4.dex */
    public interface OnOpenListener {
        void onOpen();
    }

    /* loaded from: classes4.dex */
    public interface OnOpenedListener {
        void onOpened();
    }

    public SlidingMenu(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlidingMenu(Activity activity, int i) {
        this(activity, (AttributeSet) null);
        attachToActivity(activity, i);
    }

    public SlidingMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActionbarOverlay = false;
        this.mIgnoreContentsBackground = false;
        this.mHandler = new Handler();
        this.mQuickReturn = false;
        this.mActivePointerId = -1;
        this.mEnabled = true;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mFlingDistance = (int) (context.getResources().getDisplayMetrics().density * 25.0f);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        CustomViewBehind customViewBehind = new CustomViewBehind(context);
        this.mViewBehind = customViewBehind;
        addView(customViewBehind, layoutParams);
        ViewGroup.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        CustomViewAbove customViewAbove = new CustomViewAbove(context);
        this.mViewAbove = customViewAbove;
        addView(customViewAbove, layoutParams2);
        this.mViewAbove.setCustomViewBehind(this.mViewBehind);
        this.mViewBehind.setCustomViewAbove(this.mViewAbove);
        this.mViewAbove.setOnPageChangeListener(new CustomViewAbove.OnPageChangeListener() { // from class: com.bytedance.ies.uikit.menu.SlidingMenu.1
            public static final int POSITION_CLOSE = 1;
            public static final int POSITION_OPEN = 0;

            @Override // com.bytedance.ies.uikit.menu.CustomViewAbove.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
            }

            @Override // com.bytedance.ies.uikit.menu.CustomViewAbove.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (i2 != 0 || SlidingMenu.this.mOpenListener == null) {
                    if (i2 != 1 || SlidingMenu.this.mCloseListener == null) {
                        return;
                    }
                    SlidingMenu.this.mCloseListener.onClose();
                    return;
                }
                SlidingMenu.this.mOpenListener.onOpen();
            }
        });
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlidingMenu);
        setMode(obtainStyledAttributes.getInt(R.styleable.SlidingMenu_appearMode, 0));
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SlidingMenu_viewAbove, -1);
        if (resourceId != -1) {
            setContent(resourceId);
        } else {
            setContent(new FrameLayout(context));
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.SlidingMenu_viewBehind, -1);
        if (resourceId2 != -1) {
            setMenu(resourceId2);
        } else {
            setMenu(new FrameLayout(context));
        }
        setTouchModeAbove(obtainStyledAttributes.getInt(R.styleable.SlidingMenu_touchModeAbove, 0));
        setTouchModeBehind(obtainStyledAttributes.getInt(R.styleable.SlidingMenu_touchModeBehind, 0));
        int dimension = (int) obtainStyledAttributes.getDimension(R.styleable.SlidingMenu_behindOffset, -1.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(R.styleable.SlidingMenu_behindWidth, -1.0f);
        if (dimension != -1 && dimension2 != -1) {
            throw new IllegalStateException("Cannot set both behindOffset and behindWidth for a SlidingMenu");
        }
        if (dimension != -1) {
            setBehindOffset(dimension);
        } else if (dimension2 != -1) {
            setBehindWidth(dimension2);
        } else {
            setBehindOffset(0);
        }
        setBehindScrollScale(obtainStyledAttributes.getFloat(R.styleable.SlidingMenu_behindScrollScale, 0.33f));
        int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.SlidingMenu_shadowDrawable, -1);
        if (resourceId3 != -1) {
            setShadowDrawable(resourceId3);
        }
        setShadowWidth((int) obtainStyledAttributes.getDimension(R.styleable.SlidingMenu_shadowWidth, 0.0f));
        setFadeEnabled(obtainStyledAttributes.getBoolean(R.styleable.SlidingMenu_fadeEnabled, true));
        setFadeDegree(obtainStyledAttributes.getFloat(R.styleable.SlidingMenu_fadeDegree, 0.33f));
        setSelectorEnabled(obtainStyledAttributes.getBoolean(R.styleable.SlidingMenu_selectorEnabled, false));
        int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.SlidingMenu_selectorDrawable, -1);
        if (resourceId4 != -1) {
            setSelectorDrawable(resourceId4);
        }
        obtainStyledAttributes.recycle();
    }

    public void attachToActivity(Activity activity, int i) {
        attachToActivity(activity, i, false);
    }

    public void attachToActivity(Activity activity, int i, boolean z) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("slideStyle must be either SLIDING_WINDOW or SLIDING_CONTENT");
        }
        if (getParent() != null) {
            throw new IllegalStateException("This SlidingMenu appears to already be attached");
        }
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{android.R.attr.windowBackground});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        if (i != 0) {
            if (i != 1) {
                return;
            }
            this.mActionbarOverlay = z;
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
            View childAt = viewGroup.getChildAt(0);
            viewGroup.removeView(childAt);
            viewGroup.addView(this);
            setContent(childAt);
            if (childAt.getBackground() != null || this.mIgnoreContentsBackground) {
                return;
            }
            childAt.setBackgroundResource(resourceId);
            return;
        }
        this.mActionbarOverlay = false;
        ViewGroup viewGroup2 = (ViewGroup) activity.getWindow().getDecorView();
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getChildAt(0);
        boolean z2 = this.mIgnoreContentsBackground;
        if (!z2) {
            viewGroup3.setBackgroundResource(resourceId);
        } else if (z2) {
            ViewGroup viewGroup4 = (ViewGroup) activity.findViewById(android.R.id.content);
            int childCount = viewGroup3.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt2 = viewGroup3.getChildAt(i2);
                if (childAt2 != viewGroup4 && !(childAt2 instanceof ViewStub) && childAt2.getBackground() == null) {
                    childAt2.setBackgroundResource(resourceId);
                }
            }
        }
        viewGroup2.removeView(viewGroup3);
        viewGroup2.addView(this);
        setContent(viewGroup3);
    }

    public void setContent(int i) {
        setContent(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null));
    }

    public void setContent(View view) {
        this.mViewAbove.setContent(view);
        showContent();
    }

    public View getContent() {
        return this.mViewAbove.getContent();
    }

    public void setMenu(int i) {
        setMenu(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null));
    }

    public void setMenu(View view) {
        this.mViewBehind.setContent(view);
    }

    public View getMenu() {
        return this.mViewBehind.getContent();
    }

    public void setSecondaryMenu(int i) {
        setSecondaryMenu(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null));
    }

    public void setSecondaryMenu(View view) {
        this.mViewBehind.setSecondaryContent(view);
    }

    public View getSecondaryMenu() {
        return this.mViewBehind.getSecondaryContent();
    }

    public void setSlidingEnabled(boolean z) {
        this.mEnabled = z;
        this.mViewAbove.setSlidingEnabled(z);
    }

    public boolean isSlidingEnabled() {
        return this.mViewAbove.isSlidingEnabled();
    }

    public void setMode(int i) {
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalStateException("SlidingMenu mode must be LEFT, RIGHT, or LEFT_RIGHT");
        }
        this.mViewBehind.setMode(i);
    }

    public int getMode() {
        return this.mViewBehind.getMode();
    }

    public void setStatic(boolean z) {
        if (z) {
            setSlidingEnabled(false);
            this.mViewAbove.setCustomViewBehind(null);
            this.mViewAbove.setCurrentItem(1);
        } else {
            this.mViewAbove.setCurrentItem(1);
            this.mViewAbove.setCustomViewBehind(this.mViewBehind);
            setSlidingEnabled(true);
        }
    }

    public void showMenu() {
        showMenu(true);
    }

    public void showMenu(boolean z) {
        this.mViewAbove.setCurrentItem(0, z);
    }

    public void showSecondaryMenu() {
        showSecondaryMenu(true);
    }

    public void showSecondaryMenu(boolean z) {
        this.mViewAbove.setCurrentItem(2, z);
    }

    public void showContent() {
        showContent(true);
    }

    public void showContent(boolean z) {
        this.mViewAbove.setCurrentItem(1, z);
    }

    public void toggle() {
        toggle(true);
    }

    public void toggle(boolean z) {
        if (isMenuShowing()) {
            showContent(z);
        } else {
            showMenu(z);
        }
    }

    public boolean isMenuShowing() {
        return this.mViewAbove.getCurrentItem() == 0 || this.mViewAbove.getCurrentItem() == 2;
    }

    public boolean isSecondaryMenuShowing() {
        return this.mViewAbove.getCurrentItem() == 2;
    }

    public int getCurrentItem() {
        return this.mViewAbove.getCurrentItem();
    }

    public int getBehindOffset() {
        return ((RelativeLayout.LayoutParams) this.mViewBehind.getLayoutParams()).rightMargin;
    }

    public void setRightBehindOffset(int i) {
        this.mViewBehind.setSecondaryWidthOffset(i);
    }

    public void setRightBehindOffsetRes(int i) {
        setRightBehindOffset((int) getContext().getResources().getDimension(i));
    }

    public void setBehindOffset(int i) {
        this.mViewBehind.setWidthOffset(i);
    }

    public void setBehindOffsetRes(int i) {
        setBehindOffset((int) getContext().getResources().getDimension(i));
    }

    public void setAboveOffset(int i) {
        this.mViewAbove.setAboveOffset(i);
    }

    public void setAboveOffsetRes(int i) {
        setAboveOffset((int) getContext().getResources().getDimension(i));
    }

    public void setBehindWidth(int i) {
        int width;
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        try {
            Point point = new Point();
            Display.class.getMethod("getSize", Point.class).invoke(defaultDisplay, point);
            width = point.x;
        } catch (Exception unused) {
            width = defaultDisplay.getWidth();
        }
        setBehindOffset(width - i);
    }

    public void setBehindWidthRes(int i) {
        setBehindWidth((int) getContext().getResources().getDimension(i));
    }

    public float getBehindScrollScale() {
        return this.mViewBehind.getScrollScale();
    }

    public void setBehindScrollScale(float f) {
        if (f < 0.0f && f > 1.0f) {
            throw new IllegalStateException("ScrollScale must be between 0 and 1");
        }
        this.mViewBehind.setScrollScale(f);
    }

    public void setBehindCanvasTransformer(CanvasTransformer canvasTransformer) {
        this.mViewBehind.setCanvasTransformer(canvasTransformer);
    }

    public int getTouchModeAbove() {
        return this.mViewAbove.getTouchMode();
    }

    public void setTouchModeAbove(int i) {
        if (i != 1 && i != 0 && i != 2) {
            throw new IllegalStateException("TouchMode must be set to eitherTOUCHMODE_FULLSCREEN or TOUCHMODE_MARGIN or TOUCHMODE_NONE.");
        }
        this.mViewAbove.setTouchMode(i);
    }

    public void setTouchModeBehind(int i) {
        if (i != 1 && i != 0 && i != 2) {
            throw new IllegalStateException("TouchMode must be set to eitherTOUCHMODE_FULLSCREEN or TOUCHMODE_MARGIN or TOUCHMODE_NONE.");
        }
        this.mViewBehind.setTouchMode(i);
    }

    public void setShadowDrawable(int i) {
        setShadowDrawable(getContext().getResources().getDrawable(i));
    }

    public void setShadowDrawable(Drawable drawable) {
        this.mViewBehind.setShadowDrawable(drawable);
    }

    public void setSecondaryShadowDrawable(int i) {
        setSecondaryShadowDrawable(getContext().getResources().getDrawable(i));
    }

    public void setSecondaryShadowDrawable(Drawable drawable) {
        this.mViewBehind.setSecondaryShadowDrawable(drawable);
    }

    public void setShadowWidthRes(int i) {
        setShadowWidth((int) getResources().getDimension(i));
    }

    public void setShadowWidth(int i) {
        this.mViewBehind.setShadowWidth(i);
    }

    public void setFadeEnabled(boolean z) {
        this.mViewBehind.setFadeEnabled(z);
    }

    public void setFadeDegree(float f) {
        this.mViewBehind.setFadeDegree(f);
    }

    public void setSelectorEnabled(boolean z) {
        this.mViewBehind.setSelectorEnabled(true);
    }

    public void setSelectedView(View view) {
        this.mViewBehind.setSelectedView(view);
    }

    public void setSelectorDrawable(int i) {
        this.mViewBehind.setSelectorBitmap(BitmapFactory.decodeResource(getResources(), i));
    }

    public void setSelectorBitmap(Bitmap bitmap) {
        this.mViewBehind.setSelectorBitmap(bitmap);
    }

    public void addIgnoredView(View view) {
        this.mViewAbove.addIgnoredView(view);
    }

    public void removeIgnoredView(View view) {
        this.mViewAbove.removeIgnoredView(view);
    }

    public void clearIgnoredViews() {
        this.mViewAbove.clearIgnoredViews();
    }

    public void setOnOpenListener(OnOpenListener onOpenListener) {
        this.mOpenListener = onOpenListener;
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.mCloseListener = onCloseListener;
    }

    public void setOnClickCloseListener(OnClickCloseListener onClickCloseListener) {
        this.mClickCloseListener = onClickCloseListener;
    }

    public void setOnOpenedListener(OnOpenedListener onOpenedListener) {
        this.mViewAbove.setOnOpenedListener(onOpenedListener);
    }

    public void setOnClosedListener(OnClosedListener onClosedListener) {
        this.mViewAbove.setOnClosedListener(onClosedListener);
    }

    /* loaded from: classes4.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.bytedance.ies.uikit.menu.SlidingMenu.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private final int mItem;

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.mItem = i;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mItem = parcel.readInt();
        }

        public int getItem() {
            return this.mItem;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mItem);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mViewAbove.getCurrentItem());
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mViewAbove.setCurrentItem(savedState.getItem());
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        int i = rect.left;
        int i2 = rect.right;
        int i3 = rect.top;
        int i4 = rect.bottom;
        if (this.mActionbarOverlay) {
            return true;
        }
        Log.v(TAG, "setting padding!");
        setPadding(i, i3, i2, i4);
        return true;
    }

    public void manageLayers(float f) {
        final int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1)) > 0 && (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1)) < 0 ? 2 : 0;
        if (i != getContent().getLayerType()) {
            this.mHandler.post(new Runnable() { // from class: com.bytedance.ies.uikit.menu.SlidingMenu.2
                @Override // java.lang.Runnable
                public void run() {
                    Log.v(SlidingMenu.TAG, "changing layerType. hardware? " + (i == 2));
                    SlidingMenu.this.getContent().setLayerType(i, null);
                    SlidingMenu.this.getMenu().setLayerType(i, null);
                    if (SlidingMenu.this.getSecondaryMenu() != null) {
                        SlidingMenu.this.getSecondaryMenu().setLayerType(i, null);
                    }
                }
            });
        }
    }

    public boolean isMenuOpen() {
        return this.mViewAbove.isMenuOpen();
    }

    private int getPointerIndex(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mEnabled) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (DEBUG && action == 0) {
            Log.v(TAG, "Received ACTION_DOWN");
        }
        if (action == 3 || action == 1 || (action != 0 && this.mIsUnableToDrag)) {
            endDrag();
            return false;
        }
        if (action == 0) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            int pointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            this.mActivePointerId = pointerId;
            if (pointerId != -1) {
                float x = MotionEventCompat.getX(motionEvent, actionIndex);
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                this.mLastMotionY = MotionEventCompat.getY(motionEvent, actionIndex);
                if (this.mViewAbove.thisTouchAllowed(motionEvent)) {
                    this.mIsBeingDragged = false;
                    this.mIsUnableToDrag = false;
                    this.mQuickReturn = false;
                    if (isMenuOpen() && this.mViewAbove.menuTouchInQuickReturn(motionEvent)) {
                        this.mQuickReturn = true;
                    }
                } else {
                    this.mIsUnableToDrag = true;
                }
            }
        } else if (action == 2) {
            determineDrag(motionEvent);
        } else if (action == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        if (!this.mIsBeingDragged) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
        }
        return this.mIsBeingDragged || this.mQuickReturn;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mEnabled) {
            return false;
        }
        if (!this.mIsBeingDragged && !this.mViewAbove.thisTouchAllowed(motionEvent)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int i = action & 255;
        if (i == 0) {
            this.mViewAbove.completeScroll();
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
            float x = motionEvent.getX();
            this.mInitialMotionX = x;
            this.mLastMotionX = x;
        } else if (i != 1) {
            if (i == 2) {
                if (!this.mIsBeingDragged) {
                    determineDrag(motionEvent);
                    if (this.mIsUnableToDrag) {
                        return false;
                    }
                }
                if (this.mIsBeingDragged) {
                    int pointerIndex = getPointerIndex(motionEvent, this.mActivePointerId);
                    if (this.mActivePointerId != -1) {
                        float x2 = MotionEventCompat.getX(motionEvent, pointerIndex);
                        float f = this.mLastMotionX - x2;
                        this.mLastMotionX = x2;
                        float scrollX = this.mViewAbove.getScrollX() + f;
                        float leftBound = this.mViewAbove.getLeftBound();
                        float rightBound = this.mViewAbove.getRightBound();
                        if (scrollX < leftBound) {
                            scrollX = leftBound;
                        } else if (scrollX > rightBound) {
                            scrollX = rightBound;
                        }
                        int i2 = (int) scrollX;
                        this.mLastMotionX += scrollX - i2;
                        this.mViewAbove.scrollTo(i2, getScrollY());
                        this.mViewAbove.pageScrolled(i2);
                    }
                }
            } else if (i != 3) {
                if (i == 5) {
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    this.mLastMotionX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                } else if (i == 6) {
                    onSecondaryPointerUp(motionEvent);
                    int pointerIndex2 = getPointerIndex(motionEvent, this.mActivePointerId);
                    if (this.mActivePointerId != -1) {
                        this.mLastMotionX = MotionEventCompat.getX(motionEvent, pointerIndex2);
                    }
                }
            } else if (this.mIsBeingDragged) {
                CustomViewAbove customViewAbove = this.mViewAbove;
                customViewAbove.setCurrentItemInternal(customViewAbove.getCurrentItem(), true, true);
                this.mActivePointerId = -1;
                endDrag();
            }
        } else if (this.mIsBeingDragged) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.mActivePointerId);
            float scrollX2 = (this.mViewAbove.getScrollX() - this.mViewAbove.getDestScrollX()) / this.mViewBehind.getBehindWidth();
            int pointerIndex3 = getPointerIndex(motionEvent, this.mActivePointerId);
            if (this.mActivePointerId != -1) {
                this.mViewAbove.setCurrentItemInternal(determineTargetPage(scrollX2, xVelocity, (int) (MotionEventCompat.getX(motionEvent, pointerIndex3) - this.mInitialMotionX)), true, true, xVelocity);
            } else {
                CustomViewAbove customViewAbove2 = this.mViewAbove;
                customViewAbove2.setCurrentItemInternal(customViewAbove2.getCurrentItem(), true, true, xVelocity);
            }
            this.mActivePointerId = -1;
            endDrag();
        } else if (this.mQuickReturn && this.mViewAbove.menuTouchInQuickReturn(motionEvent)) {
            OnClickCloseListener onClickCloseListener = this.mClickCloseListener;
            if (onClickCloseListener != null) {
                onClickCloseListener.onClickClose();
            }
            this.mViewAbove.setCurrentItem(1);
            endDrag();
        }
        return true;
    }

    private void determineDrag(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (i == -1) {
            return;
        }
        float x = MotionEventCompat.getX(motionEvent, pointerIndex);
        float f = x - this.mLastMotionX;
        float abs = Math.abs(f);
        float y = MotionEventCompat.getY(motionEvent, pointerIndex);
        float abs2 = Math.abs(y - this.mLastMotionY);
        if (abs <= (isMenuOpen() ? this.mTouchSlop / 2 : this.mTouchSlop) || abs <= abs2 || !this.mViewAbove.thisSlideAllowed(f)) {
            if (abs > this.mTouchSlop) {
                this.mIsUnableToDrag = true;
            }
        } else {
            startDrag();
            this.mLastMotionX = x;
            this.mLastMotionY = y;
            this.mViewAbove.setScrollingCacheEnabled(true);
        }
    }

    private int determineTargetPage(float f, int i, int i2) {
        int currentItem = this.mViewAbove.getCurrentItem();
        if (Math.abs(i2) <= this.mFlingDistance || Math.abs(i) <= this.mMinimumVelocity) {
            return Math.round(currentItem + f);
        }
        return (i <= 0 || i2 <= 0) ? (i >= 0 || i2 >= 0) ? currentItem : currentItem + 1 : currentItem - 1;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        if (DEBUG) {
            Log.v(TAG, "onSecondaryPointerUp called");
        }
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = MotionEventCompat.getX(motionEvent, i);
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, i);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void startDrag() {
        this.mIsBeingDragged = true;
        this.mQuickReturn = false;
    }

    private void endDrag() {
        this.mQuickReturn = false;
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        this.mActivePointerId = -1;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void setIgnoreContentsBackground(boolean z) {
        this.mIgnoreContentsBackground = z;
    }
}
