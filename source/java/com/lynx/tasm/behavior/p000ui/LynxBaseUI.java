package com.lynx.tasm.behavior.p000ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.animation.keyframe.KeyframeManager;
import com.lynx.tasm.animation.layout.LayoutAnimationManager;
import com.lynx.tasm.animation.transition.TransitionAnimationManager;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.CSSPropertySetter;
import com.lynx.tasm.behavior.ForegroundListener;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxIntersectionObserver;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxPropGroup;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.PatchFinishListener;
import com.lynx.tasm.behavior.PropertiesDispatcher;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.TouchEventDispatcher;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.event.EventTargetBase;
import com.lynx.tasm.behavior.p000ui.UIBody;
import com.lynx.tasm.behavior.p000ui.UIShadowProxy;
import com.lynx.tasm.behavior.p000ui.accessibility.LynxAccessibilityHelper;
import com.lynx.tasm.behavior.p000ui.accessibility.LynxAccessibilityWrapper;
import com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll;
import com.lynx.tasm.behavior.p000ui.scroll.IScrollSticky;
import com.lynx.tasm.behavior.p000ui.scroll.LynxUIScrollViewInternal;
import com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollView;
import com.lynx.tasm.behavior.p000ui.utils.BorderStyle;
import com.lynx.tasm.behavior.p000ui.utils.LynxBackground;
import com.lynx.tasm.behavior.p000ui.utils.LynxMask;
import com.lynx.tasm.behavior.p000ui.utils.LynxUIHelper;
import com.lynx.tasm.behavior.p000ui.utils.TransformOrigin;
import com.lynx.tasm.behavior.p000ui.utils.TransformRaw;
import com.lynx.tasm.behavior.p000ui.view.AndroidView;
import com.lynx.tasm.behavior.p000ui.view.UIComponent;
import com.lynx.tasm.behavior.shadow.MeasureUtils;
import com.lynx.tasm.behavior.utils.LynxUISetter;
import com.lynx.tasm.behavior.utils.PropsUpdater;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxCustomEvent;
import com.lynx.tasm.event.LynxEventDetail;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.gesture.GestureArenaMember;
import com.lynx.tasm.gesture.LynxNewGestureDelegate;
import com.lynx.tasm.gesture.arena.GestureArenaManager;
import com.lynx.tasm.gesture.detector.GestureDetector;
import com.lynx.tasm.gesture.handler.BaseGestureHandler;
import com.lynx.tasm.utils.ContextUtils;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.PixelUtils;
import com.lynx.tasm.utils.SizeValue;
import com.lynx.tasm.utils.UnitUtils;
import com.ss.android.deviceregister.utils.RomUtils;
import com.ss.android.socialbase.appdownloader.util.parser.manifest.TypedValue;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.update.UpdateEventUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class LynxBaseUI implements UIParent, EventTarget, PropertiesDispatcher, Cloneable, LynxNewGestureDelegate {
    protected static final int DEFAULT_PERSPECTIVE_FACTOR = 100;
    public static final short OVERFLOW_HIDDEN = 0;
    public static final short OVERFLOW_X = 1;
    public static final short OVERFLOW_XY = 3;
    public static final short OVERFLOW_Y = 2;
    private static final String TAG = "LynxBaseUI";
    protected boolean hasTransformChanged;
    private ArrayList mAccessibilityActions;
    protected int mAccessibilityElementStatus;
    private ArrayList<String> mAccessibilityElements;
    private ArrayList<String> mAccessibilityElementsA11y;
    protected boolean mAccessibilityEnableTap;
    private String mAccessibilityId;
    protected boolean mAccessibilityKeepFocused;
    private String mAccessibilityLabel;
    private String mAccessibilityRoleDescription;
    private String mAccessibilityStatus;
    private LynxAccessibilityHelper.LynxAccessibilityTraits mAccessibilityTraits;
    private float mAlpha;
    protected int mBackgroundColor;
    protected Bitmap.Config mBitmapConfig;
    private boolean mBlockListEvent;
    private boolean mBlockNativeEvent;
    private ArrayList<ArrayList<SizeValue>> mBlockNativeEventAreas;
    protected int mBorderBottomWidth;
    protected int mBorderLeftWidth;
    protected int mBorderRightWidth;
    private int mBorderSpacingIndex;
    protected int mBorderTopWidth;
    private int mBorderWidth;
    private Rect mBound;
    protected ArrayList<Runnable> mBoundingClientRectCallbacks;
    protected int mCSSPosition;
    protected final List<LynxBaseUI> mChildren;
    private boolean mClipToRadius;
    protected boolean mConsumeHoverEvent;
    private ArrayList<ArrayList<Float>> mConsumeSlideEventAngles;
    protected LynxContext mContext;
    private ReadableMap mDataset;
    protected UIParent mDrawParent;
    protected DrawableCallback mDrawableCallback;
    private boolean mEnableBitmapGradient;
    private EventTarget.EnableStatus mEnableExposureUIClip;
    private Boolean mEnableExposureUIMargin;
    private boolean mEnableScrollMonitor;
    protected boolean mEnableTouchPseudoPropagation;
    protected EventTarget.EnableStatus mEventThrough;
    protected ArrayList<ArrayList<SizeValue>> mEventThroughActiveRegions;
    protected Map<String, EventsListener> mEvents;
    private String mExposureArea;
    private String mExposureID;
    private String mExposureScene;
    private float mExposureScreenMarginBottom;
    private float mExposureScreenMarginLeft;
    private float mExposureScreenMarginRight;
    private float mExposureScreenMarginTop;
    private String mExposureUIMarginBottom;
    private String mExposureUIMarginLeft;
    private String mExposureUIMarginRight;
    private String mExposureUIMarginTop;
    private float mExtraOffsetX;
    private float mExtraOffsetY;
    protected int mFlattenChildrenCount;
    protected boolean mFocusable;
    protected float mFontSize;
    protected int mGestureArenaMemberId;
    protected Map<Integer, GestureDetector> mGestureDetectors;
    protected Map<Integer, BaseGestureHandler> mGestureHandlers;
    private boolean mHasRadius;
    protected boolean mHasTranslateDiff;
    private int mHeight;
    private float mHitSlopBottom;
    private float mHitSlopLeft;
    private float mHitSlopRight;
    private float mHitSlopTop;
    private Matrix mHitTestMatrix;
    private String mIdSelector;
    protected EventTarget.EnableStatus mIgnoreFocus;
    protected int mImageRendering;
    protected boolean mIncludeNativeGesture;
    private boolean mIsDetachedWithView;
    protected boolean mIsFirstAnimatedReady;
    protected boolean mIsTransformNode;
    private final Point mLastSize;
    private float mLastTranslateZ;
    private final Point mLatestSize;
    private int mLeft;
    protected LynxBackground mLynxBackground;
    protected int mLynxDirection;
    protected LynxMask mLynxMask;
    protected int mMarginBottom;
    protected int mMarginLeft;
    protected int mMarginRight;
    protected int mMarginTop;
    protected float mMaxHeight;
    private String mName;
    private boolean mNeedSortChildren;
    private boolean mNeedsBackgroundRecreation;
    protected LynxBaseUI mNextDrawUI;
    protected int mNodeIndex;
    private WeakReference<int[]> mOffsetDescendantRectToLynxView;
    private boolean mOnResponseChain;
    private int mOriginLeft;
    private int mOriginTop;
    protected int mOverflow;
    protected int mPaddingBottom;
    protected int mPaddingLeft;
    protected int mPaddingRight;
    protected int mPaddingTop;
    protected Object mParam;
    protected UIParent mParent;
    protected ReadableArray mPerspective;
    protected EventTarget.PointerEventsValue mPointerEvents;
    protected float mPrePerspectiveValue;
    protected LynxBaseUI mPreviousDrawUI;
    protected final JavaOnlyMap mProps;
    private int mPseudoStatus;
    private String mRefId;
    private String mScrollMonitorTag;
    private volatile ScrollStateChangeListener mScrollStateChangeListener;
    private boolean mShouldAttachChildrenView;
    private int mSign;
    private float mSkewX;
    private float mSkewY;
    private boolean mSkipLayoutUpdated;
    private boolean mSkipRedirection;
    private volatile Set<ScrollStateChangeListener> mStateChangeListeners;
    protected Sticky mSticky;
    private String mTagName;
    private String mTestTagName;
    private int mTop;
    private float mTouchSlop;
    private Matrix mTransformMatrix;
    protected TransformOrigin mTransformOrigin;
    protected List<TransformRaw> mTransformRaw;
    protected float mTranslationZ;
    private CSSPropertySetter.UIPaintStyles mUIPaintStyles;
    private Dynamic mUseLocalCache;
    private int mWidth;
    protected boolean nativeInteractionEnabled;
    protected boolean userInteractionEnabled;
    public static final int[] SPACING_TYPES = {8, 0, 2, 1, 3, 4, 5};
    private static final int[] sDefaultOffsetToLynxView = {Integer.MIN_VALUE, Integer.MIN_VALUE};
    protected static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = (float) Math.sqrt(5.0d);
    private static final Set<String> BACKGROUND_PROPS = new HashSet(Arrays.asList(PropsConstants.BACKGROUND_COLOR, PropsConstants.BACKGROUND_IMAGE, PropsConstants.BACKGROUND_ORIGIN, PropsConstants.BACKGROUND_POSITION, PropsConstants.BACKGROUND_REPEAT, PropsConstants.BACKGROUND_SIZE, PropsConstants.BORDER_BOTTOM_LEFT_RADIUS, PropsConstants.BORDER_BOTTOM_RIGHT_RADIUS, PropsConstants.BORDER_TOP_LEFT_RADIUS, PropsConstants.BORDER_TOP_RIGHT_RADIUS, PropsConstants.BORDER_RADIUS));

    public boolean canHaveFlattenChild() {
        return true;
    }

    protected void consumeGesture(boolean z) {
    }

    protected MeaningfulPaintingArea convertToMeaningfulPaintingArea(int i, int i2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createViewAsync() {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean dispatchEvent(LynxEventDetail lynxEventDetail) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.PropertiesDispatcher
    public void dispatchProperties(StylesDiffMap stylesDiffMap) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean dispatchTouch(MotionEvent motionEvent) {
        return false;
    }

    public boolean enableLayoutAnimation() {
        return false;
    }

    protected void ensureCreateView(View view) {
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIParent
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return null;
    }

    public LynxBaseUI getExposeReceiveTarget() {
        return this;
    }

    public int getInitialOverflowType() {
        return 1;
    }

    public KeyframeManager getKeyframeManager() {
        return null;
    }

    public LayoutAnimationManager getLayoutAnimator() {
        return null;
    }

    public long getMemoryUsageBytes() {
        return 0L;
    }

    public Map<String, String> getMemoryUsageDetail() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getScaleX() {
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getScaleY() {
        return 1.0f;
    }

    public int getScrollX() {
        return 0;
    }

    public int getScrollY() {
        return 0;
    }

    public TransitionAnimationManager getTransitionAnimator() {
        return null;
    }

    public float getTranslationX() {
        return CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    public float getTranslationY() {
        return CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    public Object getValueFromNativeStorage(String str) {
        return null;
    }

    public boolean getVisibility() {
        return true;
    }

    public void initTransitionAnimator(ReadableMap readableMap) {
    }

    public boolean initialPropsFlushed(String str, String str2) {
        return true;
    }

    public void initialize() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void interceptGesture(boolean z) {
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIParent
    public void invalidate() {
    }

    public boolean isAccessibilityDirectionVertical() {
        return true;
    }

    public boolean isAccessibilityHostUI() {
        return false;
    }

    public boolean isCustomHittest() {
        return false;
    }

    public boolean isFlatten() {
        return false;
    }

    public boolean isOverlay() {
        return false;
    }

    public boolean isScrollContainer() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isScrollable() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIParent
    public boolean needCustomLayout() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean needGenerateMeaningfulPaintingArea() {
        return false;
    }

    public void onAnimationNodeReady() {
    }

    @Deprecated
    public void onAnimationUpdated() {
    }

    public void onBeforeAnimation(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
    }

    public void onBorderRadiusUpdated(int i) {
    }

    protected void onDrawingPositionChanged() {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onFocusChanged(boolean z, boolean z2) {
    }

    @Deprecated
    public void onLayoutFinish(long j) {
    }

    public void onLayoutFinish(long j, LynxBaseUI lynxBaseUI) {
    }

    public void onNodeReload() {
    }

    public void onNodeRemoved() {
    }

    protected void registerViewAccordingToNodeIndex() {
    }

    public void removeChildrenExposureUI() {
    }

    public void removeKeyFromNativeStorage(String str) {
    }

    public void renderIfNeeded() {
    }

    public boolean requestChildUIRectangleOnScreen(LynxBaseUI lynxBaseUI, Rect rect, boolean z) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIParent
    public void requestLayout() {
    }

    @Override // com.lynx.tasm.gesture.LynxNewGestureDelegate
    public float[] scrollBy(float f, float f2) {
        return new float[]{CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, f, f2};
    }

    @LynxProp(name = PropsConstants.ACCESSIBILITY_HEADING)
    public void setAccessibilityHeading(boolean z) {
    }

    @LynxProp(name = PropsConstants.ACCESSIBILITY_VALUE)
    public void setAccessibilityValue(String str) {
    }

    public void setAnimation(ReadableArray readableArray) {
    }

    @LynxProp(name = PropsConstants.CARET_COLOR)
    public void setCaretColor(String str) {
    }

    public void setInitialPropsHasFlushed(String str, String str2) {
    }

    public void storeKeyToNativeStorage(String str, Object obj) {
    }

    public void updateExtraData(Object obj) {
    }

    public LynxBaseUI getPreviousDrawUI() {
        return this.mPreviousDrawUI;
    }

    public void setPreviousDrawUI(LynxBaseUI lynxBaseUI) {
        this.mPreviousDrawUI = lynxBaseUI;
    }

    public LynxBaseUI getNextDrawUI() {
        return this.mNextDrawUI;
    }

    public void setNextDrawUI(LynxBaseUI lynxBaseUI) {
        this.mNextDrawUI = lynxBaseUI;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class Sticky extends RectF {

        /* renamed from: x */
        float f1x;

        /* renamed from: y */
        float f2y;

        public Sticky() {
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class TransOffset {
        public float[] left_bottom;
        public float[] left_top;
        public float[] right_bottom;
        public float[] right_top;

        public TransOffset() {
        }
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public void setAlpha(float f) {
        this.mAlpha = f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void detachWithViewInfo(ViewInfo viewInfo) {
        Iterator<LynxBaseUI> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().detachWithViewInfo(viewInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void attachToView(LynxContext lynxContext) {
        this.mContext = lynxContext;
        Iterator<LynxBaseUI> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().attachToView(lynxContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convertToMeaningfulPaintingAreaRecursive(int i, int i2, ArrayList<MeaningfulPaintingArea> arrayList) {
        MeaningfulPaintingArea convertToMeaningfulPaintingArea = convertToMeaningfulPaintingArea(i, i2);
        if (convertToMeaningfulPaintingArea != null) {
            arrayList.add(convertToMeaningfulPaintingArea);
        }
        int originLeft = i + getOriginLeft();
        int originTop = i2 + getOriginTop();
        for (LynxBaseUI lynxBaseUI : this.mChildren) {
            if (lynxBaseUI != null) {
                lynxBaseUI.convertToMeaningfulPaintingAreaRecursive(originLeft, originTop, arrayList);
            }
        }
    }

    public float getSkewX() {
        return this.mSkewX;
    }

    public void setSkewX(float f) {
        this.mSkewX = f;
    }

    public float getSkewY() {
        return this.mSkewY;
    }

    public void setSkewY(float f) {
        this.mSkewY = f;
    }

    public LynxContext getLynxContext() {
        return this.mContext;
    }

    public void invalidateMeaningfulPaintingArea() {
        if (getLynxContext() == null || getLynxContext().getUIBodyView() == null) {
            return;
        }
        getLynxContext().getUIBodyView().invalidateMeaningfulPaintingArea();
    }

    public void recognizeGesturere() {
        LynxContext lynxContext = this.mContext;
        if (lynxContext != null) {
            lynxContext.onGestureRecognized(this);
        }
    }

    @Deprecated
    protected LynxBaseUI(Context context) {
        this((LynxContext) context);
    }

    protected LynxBaseUI(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LynxBaseUI(LynxContext lynxContext, Object obj) {
        this.mPreviousDrawUI = null;
        this.mNextDrawUI = null;
        this.mTranslationZ = CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.mGestureArenaMemberId = 0;
        this.mIsTransformNode = false;
        this.mChildren = new ArrayList();
        this.mProps = new JavaOnlyMap();
        this.mIncludeNativeGesture = false;
        this.mDataset = new JavaOnlyMap();
        this.mNodeIndex = 0;
        this.mHasRadius = false;
        this.mSkipLayoutUpdated = false;
        this.mOverflow = 0;
        this.mClipToRadius = false;
        this.mFocusable = false;
        this.mIgnoreFocus = EventTarget.EnableStatus.Undefined;
        this.mPerspective = null;
        this.mPrePerspectiveValue = CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.hasTransformChanged = false;
        this.userInteractionEnabled = true;
        this.nativeInteractionEnabled = false;
        this.mSticky = null;
        this.mMaxHeight = -1.0f;
        this.mBackgroundColor = 0;
        this.mEnableExposureUIMargin = null;
        this.mEnableExposureUIClip = EventTarget.EnableStatus.Undefined;
        this.mIsDetachedWithView = false;
        this.mNeedsBackgroundRecreation = false;
        this.mAlpha = 1.0f;
        this.mSkewX = CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.mSkewY = CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.mShouldAttachChildrenView = false;
        this.mExtraOffsetX = CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.mExtraOffsetY = CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.mAccessibilityLabel = "";
        this.mAccessibilityId = "";
        this.mAccessibilityElementStatus = -1;
        this.mAccessibilityEnableTap = false;
        this.mAccessibilityKeepFocused = false;
        this.mConsumeHoverEvent = false;
        this.mAccessibilityTraits = LynxAccessibilityHelper.LynxAccessibilityTraits.NONE;
        this.mDrawableCallback = new DrawableCallback();
        this.mBitmapConfig = null;
        this.mCSSPosition = 1;
        this.mTouchSlop = 8.0f;
        this.mOnResponseChain = false;
        this.mBlockNativeEvent = false;
        this.mBlockNativeEventAreas = null;
        this.mEventThrough = EventTarget.EnableStatus.Undefined;
        this.mEventThroughActiveRegions = null;
        this.mPointerEvents = EventTarget.PointerEventsValue.Unset;
        this.mFlattenChildrenCount = 0;
        this.mNeedSortChildren = false;
        this.mLastTranslateZ = CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.mEnableTouchPseudoPropagation = true;
        this.mTransformMatrix = new Matrix();
        this.mHitTestMatrix = new Matrix();
        this.mConsumeSlideEventAngles = null;
        this.mBlockListEvent = false;
        this.mOffsetDescendantRectToLynxView = new WeakReference<>(null);
        this.mUseLocalCache = null;
        this.mSkipRedirection = false;
        this.mImageRendering = -1;
        this.mBoundingClientRectCallbacks = new ArrayList<>();
        this.mIsFirstAnimatedReady = true;
        this.mHasTranslateDiff = false;
        this.mLynxDirection = 3;
        this.mContext = lynxContext;
        this.mParam = obj;
        LynxBackground lynxBackground = new LynxBackground(lynxContext);
        this.mLynxBackground = lynxBackground;
        lynxBackground.setDrawableCallback(this.mDrawableCallback);
        float dipToPx = PixelUtils.dipToPx(14.0f, lynxContext.getScreenMetrics().density);
        this.mFontSize = dipToPx;
        this.mLynxBackground.setFontSize(dipToPx);
        this.mLatestSize = new Point();
        this.mLastSize = new Point();
        initialize();
    }

    public CSSPropertySetter.UIPaintStyles getOrCreateUIPaintStyles() {
        if (this.mUIPaintStyles == null) {
            this.mUIPaintStyles = new CSSPropertySetter.UIPaintStyles();
        }
        return this.mUIPaintStyles;
    }

    public void applyUIPaintStylesToTarget(LynxBaseUI lynxBaseUI) {
        CSSPropertySetter.updateUIPaintStyle(lynxBaseUI, this.mUIPaintStyles);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void destroy() {
        LynxUIOwner lynxUIOwner;
        if (this instanceof PatchFinishListener) {
            this.mContext.unregisterPatchFinishListener((PatchFinishListener) this);
        }
        if ((this instanceof ForegroundListener) && (lynxUIOwner = this.mContext.getLynxUIOwner()) != null) {
            lynxUIOwner.unregisterForegroundListener((ForegroundListener) this);
        }
        if (this.mContext.getIntersectionObserverManager() != null) {
            this.mContext.getIntersectionObserverManager().removeAttachedIntersectionObserver(this);
        }
        LynxBackground lynxBackground = this.mLynxBackground;
        if (lynxBackground != null) {
            lynxBackground.onDetach();
        }
        LynxMask lynxMask = this.mLynxMask;
        if (lynxMask != null) {
            lynxMask.onDetach();
        }
        LynxAccessibilityWrapper lynxAccessibilityWrapper = this.mContext.getLynxAccessibilityWrapper();
        if (lynxAccessibilityWrapper != null) {
            lynxAccessibilityWrapper.addOrRemoveUIFromExclusiveMap(this, false);
        }
        GestureArenaManager gestureArenaManager = getGestureArenaManager();
        if (gestureArenaManager != null && (this instanceof GestureArenaMember)) {
            gestureArenaManager.removeMember((GestureArenaMember) this);
        }
        Map<Integer, BaseGestureHandler> map = this.mGestureHandlers;
        if (map != null) {
            map.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLynxBackground(LynxBackground lynxBackground) {
        this.mLynxBackground = lynxBackground;
    }

    public LynxBackground getLynxBackground() {
        return this.mLynxBackground;
    }

    private void ensureLynxBackground() {
        if (this.mLynxBackground == null || this.mNeedsBackgroundRecreation) {
            LynxBackground lynxBackground = new LynxBackground(this.mContext);
            this.mLynxBackground = lynxBackground;
            lynxBackground.setDrawableCallback(this.mDrawableCallback);
            this.mLynxBackground.setFontSize(this.mFontSize);
            this.mNeedsBackgroundRecreation = false;
            restoreBackgroundProps();
        }
    }

    private void restoreBackgroundProps() {
        ReadableMapKeySetIterator keySetIterator = this.mProps.keySetIterator();
        StylesDiffMap stylesDiffMap = null;
        LynxUISetter<LynxBaseUI> lynxUISetter = null;
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            if (BACKGROUND_PROPS.contains(nextKey)) {
                if (stylesDiffMap == null) {
                    stylesDiffMap = new StylesDiffMap(this.mProps);
                    lynxUISetter = PropsUpdater.getLynxUISetter(this);
                }
                if (lynxUISetter != null) {
                    lynxUISetter.setProperty(this, nextKey, stylesDiffMap);
                }
            }
        }
    }

    protected void setLynxMask(LynxMask lynxMask) {
        this.mLynxMask = lynxMask;
    }

    public LynxMask getLynxMask() {
        return this.mLynxMask;
    }

    public void setSign(int i, String str) {
        this.mSign = i;
        this.mTagName = str;
    }

    public void setNodeIndex(int i) {
        this.mNodeIndex = i;
    }

    public int getNodeIndex() {
        return this.mNodeIndex;
    }

    public String getTagName() {
        return this.mTagName;
    }

    public void setEvents(Map<String, EventsListener> map) {
        this.mEvents = map;
    }

    public boolean getIncludeNativeGesture() {
        return this.mIncludeNativeGesture;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Map<Integer, BaseGestureHandler> getGestureHandlers() {
        if (!isEnableNewGesture()) {
            return null;
        }
        if (this.mGestureHandlers == null && (this instanceof GestureArenaMember)) {
            this.mGestureHandlers = BaseGestureHandler.convertToGestureHandler(getSign(), getLynxContext(), (GestureArenaMember) this, getGestureDetectorMap());
        }
        return this.mGestureHandlers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setGestureDetectors(Map<Integer, GestureDetector> map) {
        GestureArenaManager gestureArenaManager;
        Map<Integer, BaseGestureHandler> map2;
        this.mGestureDetectors = map;
        if (map == null || map.isEmpty() || (gestureArenaManager = getGestureArenaManager()) == null) {
            return;
        }
        if (gestureArenaManager.isMemberExist(getGestureArenaMemberId()) && (map2 = this.mGestureHandlers) != null) {
            map2.clear();
            this.mGestureHandlers = null;
        }
        if (this.mGestureHandlers == null && getSign() > 0 && (this instanceof GestureArenaMember)) {
            Map<Integer, BaseGestureHandler> convertToGestureHandler = BaseGestureHandler.convertToGestureHandler(getSign(), getLynxContext(), (GestureArenaMember) this, getGestureDetectorMap());
            this.mGestureHandlers = convertToGestureHandler;
            if (convertToGestureHandler != null) {
                this.mIncludeNativeGesture = false;
                Iterator<Integer> it = convertToGestureHandler.keySet().iterator();
                while (it.hasNext()) {
                    if (it.next().intValue() == 7) {
                        this.mIncludeNativeGesture = true;
                        return;
                    }
                }
            }
        }
    }

    public void setParent(UIParent uIParent) {
        ScrollStateChangeListener[] scrollStateChangeListenerArr;
        ScrollStateChangeListener[] scrollStateChangeListenerArr2;
        if (this.mStateChangeListeners == null) {
            this.mParent = uIParent;
            return;
        }
        int i = 0;
        if (uIParent instanceof LynxBaseUI) {
            synchronized (this) {
                scrollStateChangeListenerArr2 = (ScrollStateChangeListener[]) this.mStateChangeListeners.toArray(new ScrollStateChangeListener[this.mStateChangeListeners.size()]);
            }
            int length = scrollStateChangeListenerArr2.length;
            while (i < length) {
                ((LynxBaseUI) uIParent).registerScrollStateListener(scrollStateChangeListenerArr2[i]);
                i++;
            }
        } else if (this.mParent instanceof LynxBaseUI) {
            synchronized (this) {
                scrollStateChangeListenerArr = (ScrollStateChangeListener[]) this.mStateChangeListeners.toArray(new ScrollStateChangeListener[this.mStateChangeListeners.size()]);
            }
            int length2 = scrollStateChangeListenerArr.length;
            while (i < length2) {
                ((LynxBaseUI) this.mParent).unRegisterScrollStateListener(scrollStateChangeListenerArr[i]);
                i++;
            }
        }
        this.mParent = uIParent;
    }

    public void setDrawParent(UIParent uIParent) {
        this.mDrawParent = uIParent;
    }

    public LynxBaseUI getDrawParent() {
        return (LynxBaseUI) this.mDrawParent;
    }

    public UIParent getParent() {
        return this.mParent;
    }

    public void insertChild(LynxBaseUI lynxBaseUI, int i) {
        this.mChildren.add(i, lynxBaseUI);
        lynxBaseUI.setParent(this);
    }

    public void flattenChildrenCountIncrement() {
        this.mFlattenChildrenCount++;
    }

    public void removeChild(LynxBaseUI lynxBaseUI) {
        this.mChildren.remove(lynxBaseUI);
        lynxBaseUI.setParent(null);
    }

    public void flattenChildrenCountDecrement() {
        this.mFlattenChildrenCount--;
    }

    public int flattenChildrenCount() {
        return this.mFlattenChildrenCount;
    }

    public int getIndex(LynxBaseUI lynxBaseUI) {
        return this.mChildren.indexOf(lynxBaseUI);
    }

    public List<LynxBaseUI> getChildren() {
        return this.mChildren;
    }

    public LynxBaseUI getChildAt(int i) {
        return this.mChildren.get(i);
    }

    public JavaOnlyMap getProps() {
        return this.mProps;
    }

    public float getTranslationZ() {
        return this.mTranslationZ;
    }

    protected float getRealTimeTranslationZ() {
        return this.mTranslationZ;
    }

    public void setTranslationZ(float f) {
        this.mTranslationZ = f;
    }

    public boolean getClipToRadius() {
        return this.mClipToRadius;
    }

    public final void updateProperties(StylesDiffMap stylesDiffMap) {
        updatePropertiesInterval(stylesDiffMap);
        afterPropsUpdated(stylesDiffMap);
    }

    public void updatePropertiesInterval(StylesDiffMap stylesDiffMap) {
        if (stylesDiffMap == null || stylesDiffMap.isEmpty()) {
            return;
        }
        this.mProps.merge(stylesDiffMap.mBackingMap);
        PropsUpdater.updateProps(this, stylesDiffMap);
    }

    public void afterPropsUpdated(StylesDiffMap stylesDiffMap) {
        if (stylesDiffMap != null && !stylesDiffMap.isEmpty()) {
            invalidate();
        }
        onPropsUpdated();
        onAnimationUpdated();
        LynxAccessibilityWrapper lynxAccessibilityWrapper = this.mContext.getLynxAccessibilityWrapper();
        if (lynxAccessibilityWrapper != null) {
            lynxAccessibilityWrapper.handleMutationStyleUpdate(this, stylesDiffMap);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.View] */
    @LynxUIMethod
    public void boundingClientRect(final ReadableMap readableMap, final Callback callback) {
        LynxUIOwner lynxUIOwner = this.mContext.getLynxUIOwner();
        if (lynxUIOwner == null) {
            boundingClientRectInner(readableMap, callback);
            return;
        }
        UIBody rootUI = lynxUIOwner.getRootUI();
        if (rootUI == null) {
            boundingClientRectInner(readableMap, callback);
            return;
        }
        ?? view = rootUI.getView();
        if (view == 0) {
            boundingClientRectInner(readableMap, callback);
        } else if (!view.isLayoutRequested()) {
            boundingClientRectInner(readableMap, callback);
        } else {
            this.mContext.getLynxUIOwner().registerBoundingClientRectUI(this);
            this.mBoundingClientRectCallbacks.add(new Runnable() { // from class: com.lynx.tasm.behavior.ui.LynxBaseUI.1
                @Override // java.lang.Runnable
                public void run() {
                    LynxBaseUI.this.boundingClientRectInner(readableMap, callback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boundingClientRectInner(ReadableMap readableMap, Callback callback) {
        RectF relativePositionInfo = LynxUIHelper.getRelativePositionInfo(this, readableMap);
        float f = getLynxContext().getScreenMetrics().density;
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString("id", getIdSelector());
        javaOnlyMap.putMap(PropsConstants.DATASET, getDataset());
        javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_LEFT, relativePositionInfo.left / f);
        javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_TOP, relativePositionInfo.top / f);
        javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_RIGHT, relativePositionInfo.right / f);
        javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_BOTTOM, relativePositionInfo.bottom / f);
        javaOnlyMap.putDouble("width", relativePositionInfo.width() / f);
        javaOnlyMap.putDouble("height", relativePositionInfo.height() / f);
        callback.invoke(new Object[]{0, javaOnlyMap});
    }

    public void uiOwnerDidPerformLayout() {
        if (this.mBoundingClientRectCallbacks.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.mBoundingClientRectCallbacks);
        this.mBoundingClientRectCallbacks.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    @LynxUIMethod
    public void requestUIInfo(ReadableMap readableMap, Callback callback) {
        ArrayList arrayList = new ArrayList();
        if (readableMap != null) {
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                if (readableMap.getBoolean(nextKey, false)) {
                    arrayList.add(nextKey);
                }
            }
        }
        JavaOnlyMap positionInfo = getPositionInfo(readableMap != null && readableMap.getBoolean(PropsConstants.ANDROID_ENABLE_TRANSFORM_PROPS, false));
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        if (arrayList.contains("id")) {
            javaOnlyMap.put("id", getIdSelector());
        }
        if (arrayList.contains(PropsConstants.DATASET)) {
            javaOnlyMap.put(PropsConstants.DATASET, getDataset());
        }
        if (arrayList.contains("rect")) {
            javaOnlyMap.put(PropsConstants.HIT_SLOP_LEFT, positionInfo.get(PropsConstants.HIT_SLOP_LEFT));
            javaOnlyMap.put(PropsConstants.HIT_SLOP_TOP, positionInfo.get(PropsConstants.HIT_SLOP_TOP));
            javaOnlyMap.put(PropsConstants.HIT_SLOP_RIGHT, positionInfo.get(PropsConstants.HIT_SLOP_RIGHT));
            javaOnlyMap.put(PropsConstants.HIT_SLOP_BOTTOM, positionInfo.get(PropsConstants.HIT_SLOP_BOTTOM));
        }
        if (arrayList.contains(MonitorConstants.SIZE)) {
            javaOnlyMap.put("width", positionInfo.get("width"));
            javaOnlyMap.put("height", positionInfo.get("height"));
        }
        if (arrayList.contains("scrollOffset")) {
            float f = getLynxContext().getScreenMetrics().density;
            javaOnlyMap.put("scrollLeft", Float.valueOf(getScrollX() / f));
            javaOnlyMap.put("scrollTop", Float.valueOf(getScrollY() / f));
        }
        if (arrayList.contains("node")) {
            javaOnlyMap.put("node", new JavaOnlyMap());
        }
        callback.invoke(new Object[]{0, javaOnlyMap});
    }

    private JavaOnlyMap getPositionInfo(boolean z) {
        RectF rectF;
        new RectF();
        if (z) {
            rectF = LynxUIHelper.convertRectFromUIToRootUI(this, new RectF(CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, getWidth(), getHeight()));
        } else {
            rectF = new RectF(getBoundingClientRect());
        }
        float f = getLynxContext().getScreenMetrics().density;
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString("id", getIdSelector());
        javaOnlyMap.putMap(PropsConstants.DATASET, getDataset());
        javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_LEFT, rectF.left / f);
        javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_TOP, rectF.top / f);
        javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_RIGHT, rectF.right / f);
        javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_BOTTOM, rectF.bottom / f);
        javaOnlyMap.putDouble("width", rectF.width() / f);
        javaOnlyMap.putDouble("height", rectF.height() / f);
        return javaOnlyMap;
    }

    @Deprecated
    public void scrollIntoView(ReadableMap readableMap) {
        scrollIntoView(readableMap, null);
    }

    @LynxUIMethod
    public void scrollIntoView(ReadableMap readableMap, Callback callback) {
        if (readableMap == null) {
            if (callback != null) {
                callback.invoke(new Object[]{4, "missing the param of `scrollIntoViewOptions`"});
            }
        } else {
            HashMap hashMap = (HashMap) readableMap.asHashMap().get("scrollIntoViewOptions");
            if (hashMap == null) {
                callback.invoke(new Object[]{4, "missing the param of `scrollIntoViewOptions`"});
            } else {
                scrollIntoView((hashMap.containsKey("behavior") ? (String) hashMap.get("behavior") : UpdateEventUtils.SOURCE_AUTO).equals("smooth"), hashMap.containsKey("block") ? (String) hashMap.get("block") : "start", hashMap.containsKey("inline") ? (String) hashMap.get("inline") : "nearest", callback);
            }
        }
    }

    @Deprecated
    public void scrollIntoView(boolean z, String str, String str2) {
        scrollIntoView(z, str, str2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void scrollIntoView(boolean z, String str, String str2, Callback callback) {
        Boolean bool = false;
        UIParent parent = getParent();
        while (true) {
            LynxBaseUI lynxBaseUI = (LynxBaseUI) parent;
            if (lynxBaseUI == null || !(lynxBaseUI instanceof LynxBaseUI)) {
                break;
            }
            if (lynxBaseUI instanceof AbsLynxUIScroll) {
                ((AbsLynxUIScroll) lynxBaseUI).scrollInto(this, z, str, str2);
                bool = true;
                break;
            } else if (lynxBaseUI instanceof LynxUIScrollViewInternal) {
                LynxUIScrollViewInternal lynxUIScrollViewInternal = (LynxUIScrollViewInternal) lynxBaseUI;
                if (!((LynxBaseScrollView) lynxUIScrollViewInternal.getView()).isVertical()) {
                    str = str2;
                }
                lynxUIScrollViewInternal.scrollInto(this, z, str);
                bool = true;
            } else {
                parent = lynxBaseUI.getParent();
            }
        }
        if (bool.booleanValue()) {
            if (callback != null) {
                callback.invoke(new Object[]{0});
            }
        } else {
            LLog.e(TAG, "scrollIntoView failed for nodeId:" + getSign());
            if (callback != null) {
                callback.invoke(new Object[]{8, "scrollIntoView failed for nodeId:" + getSign()});
            }
        }
    }

    @LynxProp(name = PropsConstants.FOCUSABLE)
    public void setFocusable(Boolean bool) {
        this.mFocusable = bool != null ? bool.booleanValue() : false;
    }

    @LynxProp(name = PropsConstants.IGNORE_FOCUS)
    public void setIgnoreFocus(Dynamic dynamic) {
        if (dynamic == null) {
            this.mIgnoreFocus = EventTarget.EnableStatus.Undefined;
            return;
        }
        try {
            this.mIgnoreFocus = dynamic.asBoolean() ? EventTarget.EnableStatus.Enable : EventTarget.EnableStatus.Disable;
        } catch (Throwable th) {
            LLog.i(TAG, th.toString());
            this.mIgnoreFocus = EventTarget.EnableStatus.Undefined;
        }
    }

    @LynxProp(name = PropsConstants.TEST_TAG)
    public void setTestID(String str) {
        this.mTestTagName = str;
    }

    public String getTestID() {
        String str = this.mTestTagName;
        return str == null ? "" : str;
    }

    public Rect getBoundingClientRect() {
        int i;
        ViewGroup bodyView = this.mContext.getUIBody().getBodyView();
        int i2 = 0;
        if (bodyView == null) {
            return new Rect(0, 0, getWidth() + 0, getHeight() + 0);
        }
        if (this instanceof LynxUI) {
            View view = ((LynxUI) this).mView;
            if (view instanceof UIShadowProxy.ShadowView) {
                UIShadowProxy.ShadowView shadowView = (UIShadowProxy.ShadowView) view;
                if (shadowView.getChildCount() > 0) {
                    view = shadowView.getChildAt(0);
                }
            }
            Rect rect = new Rect();
            View rootView = view.getRootView();
            if (bodyView.getRootView() != rootView && (rootView instanceof ViewGroup)) {
                bodyView = (ViewGroup) rootView;
            }
            try {
                bodyView.offsetDescendantRectToMyCoords(view, rect);
                rect.offset(view.getScrollX(), view.getScrollY());
            } catch (IllegalArgumentException unused) {
            }
            int[] offsetDescendantRectToLynxView = getOffsetDescendantRectToLynxView();
            int i3 = offsetDescendantRectToLynxView[0];
            if (i3 != Integer.MIN_VALUE) {
                rect.offset(i3, offsetDescendantRectToLynxView[1]);
            }
            int i4 = rect.top;
            i2 = rect.left;
            i = i4;
        } else if (this instanceof LynxFlattenUI) {
            UIParent uIParent = this.mParent;
            if (uIParent != null && uIParent != this.mContext.getUIBody()) {
                LynxBaseUI lynxBaseUI = this;
                i = 0;
                while ((lynxBaseUI instanceof LynxFlattenUI) && lynxBaseUI != this.mContext.getUIBody()) {
                    i2 += lynxBaseUI.getOriginLeft();
                    i += lynxBaseUI.getOriginTop();
                    lynxBaseUI = lynxBaseUI.getParentBaseUI();
                }
                if (lynxBaseUI != null) {
                    Rect boundingClientRect = lynxBaseUI.getBoundingClientRect();
                    i2 += boundingClientRect.left - lynxBaseUI.getScrollX();
                    i += boundingClientRect.top - lynxBaseUI.getScrollY();
                }
            } else {
                i2 = this.mLeft;
                i = this.mTop;
            }
        } else {
            i = 0;
        }
        return new Rect(i2, i, getWidth() + i2, getHeight() + i);
    }

    public void transformFromViewToRootView(View view, float[] fArr) {
        if (!view.getMatrix().isIdentity()) {
            view.getMatrix().mapPoints(fArr);
        }
        View rootView = view.getRootView();
        while (view != rootView) {
            View view2 = (View) view.getParent();
            if (view2 == null) {
                LLog.e(TAG, "transformFromViewToRootView failed, parent is null.");
                return;
            }
            fArr[0] = fArr[0] + view.getLeft();
            fArr[1] = fArr[1] + view.getTop();
            fArr[0] = fArr[0] - view2.getScrollX();
            fArr[1] = fArr[1] - view2.getScrollY();
            if (!view2.getMatrix().isIdentity()) {
                view2.getMatrix().mapPoints(fArr);
            }
            view = view2;
        }
    }

    public TransOffset getTransformValue(float f, float f2, float f3, float f4) {
        TransOffset transOffset = new TransOffset();
        transOffset.left_top = getLocationOnScreen(new float[]{f, f3});
        transOffset.right_top = getLocationOnScreen(new float[]{this.mWidth + f2, f3});
        transOffset.right_bottom = getLocationOnScreen(new float[]{this.mWidth + f2, this.mHeight + f4});
        transOffset.left_bottom = getLocationOnScreen(new float[]{f, this.mHeight + f4});
        return transOffset;
    }

    public Rect getRectToWindow() {
        UIBody.UIBodyView bodyView = this.mContext.getUIBody().getBodyView();
        if (bodyView == null) {
            return new Rect();
        }
        int[] iArr = new int[2];
        bodyView.getLocationOnScreen(iArr);
        Rect boundingClientRect = getBoundingClientRect();
        boundingClientRect.offset(iArr[0], iArr[1]);
        return boundingClientRect;
    }

    @LynxProp(name = "name")
    public void setName(String str) {
        this.mName = str;
    }

    @LynxProp(name = PropsConstants.ID_SELECTOR)
    public void setIdSelector(String str) {
        this.mIdSelector = str;
    }

    @LynxProp(name = PropsConstants.REACT_REF_ID)
    public void setRefIdSelector(String str) {
        this.mRefId = str;
    }

    @LynxProp(name = PropsConstants.DATASET)
    public void setDataset(ReadableMap readableMap) {
        this.mDataset = readableMap;
    }

    @LynxProp(defaultInt = 0, name = PropsConstants.BACKGROUND_COLOR)
    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
        if (getKeyframeManager() != null) {
            getKeyframeManager().notifyPropertyUpdated("BackgroundColor", Integer.valueOf(i));
        }
        if (getTransitionAnimator() != null && getTransitionAnimator().containTransition(64)) {
            getTransitionAnimator().applyPropertyTransition(this, 64, Integer.valueOf(i));
            return;
        }
        ensureLynxBackground();
        this.mLynxBackground.setBackgroundColor(i);
        invalidate();
    }

    @LynxProp(name = PropsConstants.CONSUME_SLIDE_EVENT)
    public void setConsumeSlideEvent(ReadableArray readableArray) {
        if (readableArray == null) {
            this.mConsumeSlideEventAngles = null;
            return;
        }
        try {
            ArrayList arrayList = readableArray.toArrayList();
            this.mConsumeSlideEventAngles = new ArrayList<>();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if ((next instanceof ArrayList) && ((ArrayList) next).size() == 2 && (((ArrayList) next).get(0) instanceof Number) && (((ArrayList) next).get(1) instanceof Number)) {
                    ArrayList<Float> arrayList2 = new ArrayList<>();
                    arrayList2.add(Float.valueOf(((Number) ((ArrayList) next).get(0)).floatValue()));
                    arrayList2.add(Float.valueOf(((Number) ((ArrayList) next).get(1)).floatValue()));
                    this.mConsumeSlideEventAngles.add(arrayList2);
                }
            }
        } catch (Throwable th) {
            LLog.e(TAG, "setConsumeSlideEvent failed since " + th.getMessage());
        }
    }

    @LynxProp(defaultBoolean = false, name = "block-list-event")
    public void setBlockListEvent(boolean z) {
        this.mBlockListEvent = z;
    }

    private boolean isImageConfigBadCase() {
        return Build.VERSION.SDK_INT == 25 && isMeizu15();
    }

    private static boolean isMeizu() {
        String str = Build.BRAND;
        return str != null && str.toLowerCase(Locale.ENGLISH).indexOf("meizu") > -1;
    }

    private static boolean isMeizu15() {
        if (!isMeizu() || TextUtils.isEmpty(Build.DEVICE)) {
            return false;
        }
        return Build.DEVICE.contains("15");
    }

    private LynxMask getOrCreateLynxMask() {
        if (this.mLynxMask == null) {
            LynxMask lynxMask = new LynxMask(this.mContext);
            this.mLynxMask = lynxMask;
            lynxMask.setDrawableCallback(this.mDrawableCallback);
            this.mLynxMask.setFontSize(this.mFontSize);
            this.mLynxMask.setEnableBitmapGradient(this.mEnableBitmapGradient);
            this.mLynxMask.setBitmapConfig(this.mBitmapConfig);
            this.mLynxMask.setBorderWidth(SPACING_TYPES[this.mBorderSpacingIndex], this.mBorderWidth);
            this.mLynxMask.updatePaddingWidths(this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom, this.mPaddingLeft);
        }
        return this.mLynxMask;
    }

    @LynxProp(name = PropsConstants.IAMGE_CONFIG)
    public void setImageConfig(String str) {
        if (str == null || str.equalsIgnoreCase("")) {
            this.mBitmapConfig = null;
            return;
        }
        if (str.equalsIgnoreCase("ALPHA_8")) {
            this.mBitmapConfig = Bitmap.Config.ALPHA_8;
        } else if (str.equalsIgnoreCase("RGB_565")) {
            if (!isImageConfigBadCase()) {
                this.mBitmapConfig = Bitmap.Config.RGB_565;
            } else {
                LLog.w("LynxBaseUI setImageConfig warn: ", "RGB_565 can't be set on Meizu15");
                this.mBitmapConfig = null;
            }
        } else if (str.equalsIgnoreCase("ARGB_8888")) {
            this.mBitmapConfig = Bitmap.Config.ARGB_8888;
        } else if (str.equalsIgnoreCase("RGBA_F16")) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mBitmapConfig = Bitmap.Config.RGBA_F16;
            } else {
                LLog.w("LynxBaseUI setImageConfig warn: ", "RGBA_F16 requires build version >= VERSION_CODES.O");
                this.mBitmapConfig = null;
            }
        } else if (str.equalsIgnoreCase("HARDWARE")) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mBitmapConfig = Bitmap.Config.HARDWARE;
            } else {
                this.mBitmapConfig = null;
                LLog.w("LynxBaseUI setImageConfig warn: ", "HARDWARE requires build version >= VERSION_CODES.O");
            }
        } else {
            this.mBitmapConfig = null;
        }
        LynxBackground lynxBackground = this.mLynxBackground;
        if (lynxBackground != null) {
            lynxBackground.setBitmapConfig(this.mBitmapConfig);
        }
        LynxMask lynxMask = this.mLynxMask;
        if (lynxMask != null) {
            lynxMask.setBitmapConfig(this.mBitmapConfig);
        }
    }

    @LynxProp(name = PropsConstants.IMAGE_RENDERING)
    public void setImageRendering(int i) {
        this.mImageRendering = i;
    }

    @LynxProp(name = PropsConstants.BITMAP_GRADIENT)
    public void setEnableBitmapGradient(boolean z) {
        this.mEnableBitmapGradient = z;
        this.mLynxBackground.setEnableBitmapGradient(z);
        LynxMask lynxMask = this.mLynxMask;
        if (lynxMask != null) {
            lynxMask.setEnableBitmapGradient(z);
        }
        invalidate();
    }

    @LynxProp(name = PropsConstants.BACKGROUND_IMAGE)
    public void setBackgroundImage(ReadableArray readableArray) {
        ensureLynxBackground();
        this.mLynxBackground.setLayerImage(readableArray, this);
        invalidate();
    }

    @LynxProp(name = PropsConstants.BACKGROUND_ORIGIN)
    public void setBackgroundOrigin(ReadableArray readableArray) {
        ensureLynxBackground();
        this.mLynxBackground.setLayerOrigin(readableArray);
        invalidate();
    }

    @LynxProp(name = PropsConstants.BACKGROUND_POSITION)
    public void setBackgroundPosition(ReadableArray readableArray) {
        ensureLynxBackground();
        this.mLynxBackground.setLayerPosition(readableArray);
        invalidate();
    }

    @LynxProp(name = PropsConstants.BACKGROUND_REPEAT)
    public void setBackgroundRepeat(ReadableArray readableArray) {
        ensureLynxBackground();
        this.mLynxBackground.setLayerRepeat(readableArray);
        invalidate();
    }

    @LynxProp(name = PropsConstants.BACKGROUND_SIZE)
    public void setBackgroundSize(ReadableArray readableArray) {
        ensureLynxBackground();
        this.mLynxBackground.setLayerSize(readableArray);
        invalidate();
    }

    @LynxProp(name = PropsConstants.MASK_IMAGE)
    public void setMaskImage(ReadableArray readableArray) {
        getOrCreateLynxMask().setLayerImage(readableArray, this);
        invalidate();
    }

    @LynxProp(name = PropsConstants.MASK_ORIGIN)
    public void setMaskOrigin(ReadableArray readableArray) {
        getOrCreateLynxMask().setLayerOrigin(readableArray);
        invalidate();
    }

    @LynxProp(name = PropsConstants.MASK_POSITION)
    public void setMaskPosition(ReadableArray readableArray) {
        getOrCreateLynxMask().setLayerPosition(readableArray);
        invalidate();
    }

    @LynxProp(name = PropsConstants.MASK_REPEAT)
    public void setMaskRepeat(ReadableArray readableArray) {
        getOrCreateLynxMask().setLayerRepeat(readableArray);
        invalidate();
    }

    @LynxProp(name = PropsConstants.MASK_SIZE)
    public void setMaskSize(ReadableArray readableArray) {
        getOrCreateLynxMask().setLayerSize(readableArray);
        invalidate();
    }

    @LynxProp(name = PropsConstants.MASK_CLIP)
    public void setMaskClip(ReadableArray readableArray) {
        getOrCreateLynxMask().setLayerClip(readableArray);
        invalidate();
    }

    @LynxProp(name = PropsConstants.BOX_SHADOW)
    public void setBoxShadow(ReadableArray readableArray) {
        UIParent uIParent = this.mParent;
        if (uIParent instanceof UIShadowProxy) {
            ((UIShadowProxy) uIParent).setBoxShadow(readableArray);
        }
    }

    @LynxProp(name = PropsConstants.EXPOSURE_ID)
    public void setExposureID(Dynamic dynamic) {
        this.mContext.removeUIFromExposedMap(this);
        String asString = dynamic.asString();
        if (asString == null || asString.isEmpty()) {
            this.mExposureID = null;
            LLog.e(TAG, "setExposureID(Dynamic exposureID) failed, since it is not number/string, or it is empty string");
            LLog.DTHROW(new RuntimeException("setExposureID(Dynamic exposureID) failed, since it is not number/string, or it is empty string"));
            return;
        }
        this.mExposureID = asString;
    }

    public String getExposureID() {
        return this.mExposureID;
    }

    @LynxProp(name = PropsConstants.EXPOSURE_SCENE)
    public void setExposureScene(String str) {
        this.mContext.removeUIFromExposedMap(this);
        this.mExposureScene = str;
    }

    public String getExposureScene() {
        return this.mExposureScene;
    }

    @LynxProp(name = PropsConstants.EXPOSURE_SCREEN_MARGIN_TOP)
    public void setExposureScreenMarginTop(String str) {
        this.mExposureScreenMarginTop = UnitUtils.toPx(str);
    }

    public float getExposureScreenMarginTop() {
        return this.mExposureScreenMarginTop;
    }

    @LynxProp(name = PropsConstants.EXPOSURE_SCREEN_MARGIN_BOTTOM)
    public void setExposureScreenMarginBottom(String str) {
        this.mExposureScreenMarginBottom = UnitUtils.toPx(str);
    }

    public float getExposureScreenMarginBottom() {
        return this.mExposureScreenMarginBottom;
    }

    @LynxProp(name = PropsConstants.EXPOSURE_SCREEN_MARGIN_LEFT)
    public void setExposureScreenMarginLeft(String str) {
        this.mExposureScreenMarginLeft = UnitUtils.toPx(str);
    }

    public float getExposureScreenMarginLeft() {
        return this.mExposureScreenMarginLeft;
    }

    @LynxProp(name = PropsConstants.EXPOSURE_SCREEN_MARGIN_RIGHT)
    public void setExposureScreenMarginRight(String str) {
        this.mExposureScreenMarginRight = UnitUtils.toPx(str);
    }

    public float getExposureScreenMarginRight() {
        return this.mExposureScreenMarginRight;
    }

    @LynxProp(name = PropsConstants.ENABLE_EXPOSURE_UI_MARGIN)
    public void setEnableExposureUIMargin(boolean z) {
        this.mEnableExposureUIMargin = Boolean.valueOf(z);
    }

    public boolean getEnableExposureUIMargin() {
        Boolean bool = this.mEnableExposureUIMargin;
        return bool != null ? bool.booleanValue() : this.mContext.getEnableExposureUIMargin();
    }

    @LynxProp(name = PropsConstants.EXPOSURE_UI_MARGIN_TOP)
    public void setExposureUIMarginTop(String str) {
        this.mExposureUIMarginTop = str;
    }

    public String getExposureUIMarginTop() {
        return this.mExposureUIMarginTop;
    }

    @LynxProp(name = PropsConstants.EXPOSURE_UI_MARGIN_BOTTOM)
    public void setExposureUIMarginBottom(String str) {
        this.mExposureUIMarginBottom = str;
    }

    public String getExposureUIMarginBottom() {
        return this.mExposureUIMarginBottom;
    }

    @LynxProp(name = PropsConstants.EXPOSURE_UI_MARGIN_LEFT)
    public void setExposureUIMarginLeft(String str) {
        this.mExposureUIMarginLeft = str;
    }

    public String getExposureUIMarginLeft() {
        return this.mExposureUIMarginLeft;
    }

    @LynxProp(name = PropsConstants.EXPOSURE_UI_MARGIN_RIGHT)
    public void setExposureUIMarginRight(String str) {
        this.mExposureUIMarginRight = str;
    }

    public String getExposureUIMarginRight() {
        return this.mExposureUIMarginRight;
    }

    @LynxProp(name = PropsConstants.EXPOSURE_AREA)
    public void setExposureArea(String str) {
        this.mExposureArea = str;
    }

    public String getExposureArea() {
        return this.mExposureArea;
    }

    @LynxProp(name = PropsConstants.ENABLE_EXPOSURE_UI_CLIP)
    public void setEnableExposureUIClip(boolean z) {
        this.mEnableExposureUIClip = z ? EventTarget.EnableStatus.Enable : EventTarget.EnableStatus.Disable;
    }

    public EventTarget.EnableStatus getEnableExposureUIClip() {
        return this.mEnableExposureUIClip;
    }

    @Deprecated
    public void setBorderRadius(int i, String str) {
        LLog.DTHROW(new RuntimeException("setBorderWidth(int, String) is deprecated.This has no effect."));
    }

    @Deprecated
    public void setBorderWidth(int i, String str) {
        LLog.DTHROW(new RuntimeException("setBorderWidth(int, String) is deprecated.This has no effect."));
    }

    @Deprecated
    public void setBorderColor(String str) {
        LLog.DTHROW(new RuntimeException("setBorderColor(String) is deprecated.This has no effect."));
    }

    @LynxPropGroup(names = {PropsConstants.BORDER_RADIUS, PropsConstants.BORDER_TOP_LEFT_RADIUS, PropsConstants.BORDER_TOP_RIGHT_RADIUS, PropsConstants.BORDER_BOTTOM_RIGHT_RADIUS, PropsConstants.BORDER_BOTTOM_LEFT_RADIUS})
    public void setBorderRadius(int i, ReadableArray readableArray) {
        ensureLynxBackground();
        this.mHasRadius = false;
        if (this.mLynxBackground.setBorderRadius(i, readableArray)) {
            this.mHasRadius = true;
        }
        onBorderRadiusUpdated(i);
    }

    @LynxProp(name = PropsConstants.OVERFLOW)
    public void setOverflow(Integer num) {
        int intValue;
        if (num == null) {
            intValue = getInitialOverflowType();
        } else {
            intValue = num.intValue();
        }
        setOverflow(intValue);
    }

    public void setOverflow(int i) {
        setOverflowWithMask((short) 3, i);
    }

    @LynxProp(name = PropsConstants.OVERFLOW_X)
    public void setOverflowX(Integer num) {
        int intValue;
        if (num == null) {
            intValue = getInitialOverflowType();
        } else {
            intValue = num.intValue();
        }
        setOverflowWithMask((short) 1, intValue);
    }

    @LynxProp(name = PropsConstants.OVERFLOW_Y)
    public void setOverflowY(Integer num) {
        int intValue;
        if (num == null) {
            intValue = getInitialOverflowType();
        } else {
            intValue = num.intValue();
        }
        setOverflowWithMask((short) 2, intValue);
    }

    @LynxProp(name = PropsConstants.POINTER_EVENTS)
    public void setPointerEvents(int i) {
        if (i < EventTarget.PointerEventsValue.Auto.ordinal() || i >= EventTarget.PointerEventsValue.Unset.ordinal()) {
            return;
        }
        this.mPointerEvents = EventTarget.PointerEventsValue.values()[i];
    }

    @LynxProp(defaultBoolean = true, name = PropsConstants.USER_INTERACTION_ENABLED)
    public void setUserInteractionEnabled(boolean z) {
        this.userInteractionEnabled = z;
    }

    @LynxProp(defaultBoolean = false, name = PropsConstants.NATIVE_INTERACTION_ENABLED)
    public void setNativeInteractionEnabled(boolean z) {
        this.nativeInteractionEnabled = z;
    }

    @LynxProp(defaultBoolean = false, name = PropsConstants.BLOCK_NATIVE_EVENT)
    public void setBlockNativeEvent(boolean z) {
        this.mBlockNativeEvent = z;
    }

    @LynxProp(name = PropsConstants.BLOCK_NATIVE_EVENT_AREAS)
    public void setBlockNativeEventAreas(Dynamic dynamic) {
        this.mBlockNativeEventAreas = null;
        if (dynamic == null || dynamic.getType() != ReadableType.Array || dynamic.asArray() == null) {
            LLog.w(TAG, "setBlockNativeEventAreas input type error");
            return;
        }
        ReadableArray asArray = dynamic.asArray();
        ArrayList<ArrayList<SizeValue>> arrayList = new ArrayList<>();
        for (int i = 0; i < asArray.size(); i++) {
            ReadableArray array = asArray.getArray(i);
            if (array == null || array.size() != 4) {
                LLog.w(TAG, "setBlockNativeEventAreas " + i + "th type error, size != 4");
            } else {
                SizeValue fromCSSString = SizeValue.fromCSSString(array.getString(0));
                SizeValue fromCSSString2 = SizeValue.fromCSSString(array.getString(1));
                SizeValue fromCSSString3 = SizeValue.fromCSSString(array.getString(2));
                SizeValue fromCSSString4 = SizeValue.fromCSSString(array.getString(3));
                if (fromCSSString != null && fromCSSString2 != null && fromCSSString3 != null && fromCSSString4 != null) {
                    ArrayList<SizeValue> arrayList2 = new ArrayList<>();
                    arrayList2.add(fromCSSString);
                    arrayList2.add(fromCSSString2);
                    arrayList2.add(fromCSSString3);
                    arrayList2.add(fromCSSString4);
                    arrayList.add(arrayList2);
                } else {
                    LLog.w(TAG, "setBlockNativeEventAreas " + i + "th type error");
                }
            }
        }
        if (arrayList.size() > 0) {
            this.mBlockNativeEventAreas = arrayList;
        } else {
            LLog.w(TAG, "setBlockNativeEventAreas empty areas");
        }
    }

    @LynxProp(name = PropsConstants.EVENT_THROUGH)
    public void setEventThrough(Dynamic dynamic) {
        if (dynamic == null) {
            this.mEventThrough = EventTarget.EnableStatus.Undefined;
            return;
        }
        try {
            this.mEventThrough = dynamic.asBoolean() ? EventTarget.EnableStatus.Enable : EventTarget.EnableStatus.Disable;
        } catch (Throwable th) {
            LLog.i(TAG, th.toString());
            this.mEventThrough = EventTarget.EnableStatus.Undefined;
        }
    }

    @LynxProp(name = PropsConstants.EVENT_THROUGH_ACTIVE_REGIONS)
    public void setEventThroughActiveRegions(Dynamic dynamic) {
        this.mEventThroughActiveRegions = null;
        if (dynamic == null || dynamic.getType() != ReadableType.Array || dynamic.asArray() == null) {
            LLog.w(TAG, "setEventThroughActiveRegions input type error");
            return;
        }
        ReadableArray asArray = dynamic.asArray();
        ArrayList<ArrayList<SizeValue>> arrayList = new ArrayList<>();
        for (int i = 0; i < asArray.size(); i++) {
            ReadableArray array = asArray.getArray(i);
            if (array == null || array.size() != 4) {
                LLog.w(TAG, "setEventThroughActiveRegions " + i + "th type error, size != 4");
            } else {
                SizeValue fromCSSString = SizeValue.fromCSSString(array.getString(0));
                SizeValue fromCSSString2 = SizeValue.fromCSSString(array.getString(1));
                SizeValue fromCSSString3 = SizeValue.fromCSSString(array.getString(2));
                SizeValue fromCSSString4 = SizeValue.fromCSSString(array.getString(3));
                if (fromCSSString != null && fromCSSString2 != null && fromCSSString3 != null && fromCSSString4 != null) {
                    ArrayList<SizeValue> arrayList2 = new ArrayList<>();
                    arrayList2.add(fromCSSString);
                    arrayList2.add(fromCSSString2);
                    arrayList2.add(fromCSSString3);
                    arrayList2.add(fromCSSString4);
                    arrayList.add(arrayList2);
                } else {
                    LLog.w(TAG, "setEventThroughActiveRegions " + i + "th type error");
                }
            }
        }
        if (arrayList.size() > 0) {
            this.mEventThroughActiveRegions = arrayList;
        } else {
            LLog.w(TAG, "setEventThroughActiveRegions empty regions");
        }
    }

    @LynxProp(name = PropsConstants.ENABLE_TOUCH_PSEUDO_PROPAGATION)
    public void setEnableTouchPseudoPropagation(Dynamic dynamic) {
        if (dynamic == null) {
            this.mEnableTouchPseudoPropagation = true;
            return;
        }
        try {
            this.mEnableTouchPseudoPropagation = dynamic.asBoolean();
        } catch (Throwable th) {
            LLog.i(TAG, th.toString());
            this.mEnableTouchPseudoPropagation = true;
        }
    }

    protected void setOverflowWithMask(short s, int i) {
        int i2 = this.mOverflow;
        this.mOverflow = i == 0 ? s | i2 : (~s) & i2;
        requestLayout();
    }

    public int getOverflow() {
        return this.mOverflow;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Rect getBoundRectForOverflow() {
        if (getOverflow() == 3) {
            return null;
        }
        return getClipBounds();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Rect getClipBounds() {
        int i;
        int width = getWidth();
        int height = getHeight();
        DisplayMetrics screenMetrics = getLynxContext().getScreenMetrics();
        int i2 = 0;
        if ((getOverflow() & 1) != 0) {
            i = 0 - screenMetrics.widthPixels;
            width += screenMetrics.widthPixels * 2;
        } else {
            i = 0;
        }
        if ((getOverflow() & 2) != 0) {
            i2 = 0 - screenMetrics.heightPixels;
            height += screenMetrics.heightPixels * 2;
        }
        return new Rect(i, i2, width + i, height + i2);
    }

    @LynxPropGroup(defaultInt = -1, names = {PropsConstants.BORDER_STYLE, PropsConstants.BORDER_LEFT_STYLE, PropsConstants.BORDER_RIGHT_STYLE, PropsConstants.BORDER_TOP_STYLE, PropsConstants.BORDER_BOTTOM_STYLE})
    public void setBorderStyle(int i, int i2) {
        ensureLynxBackground();
        this.mLynxBackground.setBorderStyle(SPACING_TYPES[i], i2);
    }

    private float toPix(String str) {
        return UnitUtils.toPxWithDisplayMetrics(str, this.mContext.getUIBody().getFontSize(), getFontSize(), r0.getWidth(), r0.getHeight(), 1.0E21f, this.mContext.getScreenMetrics());
    }

    @LynxPropGroup(names = {PropsConstants.BORDER_WIDTH, PropsConstants.BORDER_LEFT_WIDTH, PropsConstants.BORDER_RIGHT_WIDTH, PropsConstants.BORDER_TOP_WIDTH, PropsConstants.BORDER_BOTTOM_WIDTH})
    public void setBorderWidth(int i, int i2) {
        ensureLynxBackground();
        this.mBorderSpacingIndex = i;
        this.mBorderWidth = i2;
        LynxBackground lynxBackground = this.mLynxBackground;
        int[] iArr = SPACING_TYPES;
        float f = i2;
        lynxBackground.setBorderWidth(iArr[i], f);
        LynxMask lynxMask = this.mLynxMask;
        if (lynxMask != null) {
            lynxMask.setBorderWidth(iArr[i], f);
        }
    }

    @LynxPropGroup(customType = "Color", names = {PropsConstants.BORDER_LEFT_COLOR, PropsConstants.BORDER_RIGHT_COLOR, PropsConstants.BORDER_TOP_COLOR, PropsConstants.BORDER_BOTTOM_COLOR})
    public void setBorderColor(int i, Integer num) {
        ensureLynxBackground();
        this.mLynxBackground.setBorderColorForSpacingIndex(SPACING_TYPES[i + 1], num);
    }

    @LynxProp(defaultInt = -16777216, name = PropsConstants.OUTLINE_COLOR)
    public void setOutlineColor(int i) {
        UIParent uIParent = this.mParent;
        if (uIParent instanceof UIShadowProxy) {
            ((UIShadowProxy) uIParent).setOutlineColor(i);
        }
    }

    @LynxProp(defaultInt = 0, name = PropsConstants.OUTLINE_WIDTH)
    public void setOutlineWidth(float f) {
        UIParent uIParent = this.mParent;
        if (uIParent instanceof UIShadowProxy) {
            ((UIShadowProxy) uIParent).setOutlineWidth(f);
        }
    }

    @LynxProp(defaultInt = -1, name = PropsConstants.OUTLINE_STYLE)
    public void setOutlineStyle(int i) {
        UIParent uIParent = this.mParent;
        if (uIParent instanceof UIShadowProxy) {
            ((UIShadowProxy) uIParent).setOutlineStyle(BorderStyle.parse(i));
        }
    }

    @LynxProp(defaultFloat = MeasureUtils.UNDEFINED, name = PropsConstants.FONT_SIZE)
    public void setFontSize(float f) {
        if (f != 1.0E21f) {
            ensureLynxBackground();
            this.mFontSize = f;
            this.mLynxBackground.setFontSize(f);
            LynxMask lynxMask = this.mLynxMask;
            if (lynxMask != null) {
                lynxMask.setFontSize(this.mFontSize);
            }
        }
    }

    @LynxProp(name = PropsConstants.BACKGROUND_CLIP)
    public void setBackgroundClip(ReadableArray readableArray) {
        ensureLynxBackground();
        this.mLynxBackground.setLayerClip(readableArray);
    }

    @LynxProp(name = PropsConstants.CLIP_TO_RADIUS)
    public void setClipToRadius(Dynamic dynamic) {
        if (dynamic == null) {
            return;
        }
        ReadableType type = dynamic.getType();
        if (type == ReadableType.Boolean) {
            this.mClipToRadius = dynamic.asBoolean();
        } else if (type == ReadableType.String) {
            String asString = dynamic.asString();
            this.mClipToRadius = asString.equalsIgnoreCase("true") || asString.equalsIgnoreCase("yes");
        }
    }

    @Deprecated
    public void setBorderColor(Integer num) {
        setBorderColorForAllSpacingIndex(num);
    }

    @Deprecated
    private void setBorderColorForAllSpacingIndex(Integer num) {
        ensureLynxBackground();
        float intValue = num == null ? 1.0E21f : num.intValue() & TypedValue.COMPLEX_MANTISSA_MASK;
        float intValue2 = num != null ? num.intValue() >>> 24 : 1.0E21f;
        for (int i = 1; i <= 4; i++) {
            this.mLynxBackground.setBorderColor(SPACING_TYPES[i], intValue, intValue2);
        }
    }

    @LynxProp(name = PropsConstants.ANDROID_ACCESSIBILITY_KEEP_FOCUSED)
    public void setAccessibilityKeepFocused(Dynamic dynamic) {
        boolean z;
        if (dynamic != null) {
            ReadableType type = dynamic.getType();
            if (type == ReadableType.String) {
                z = Boolean.parseBoolean(dynamic.asString());
            } else if (type == ReadableType.Boolean) {
                z = dynamic.asBoolean();
            }
            this.mAccessibilityKeepFocused = z;
        }
        z = false;
        this.mAccessibilityKeepFocused = z;
    }

    @LynxProp(name = PropsConstants.ACCESSIBILITY_ELEMENTS)
    public void setAccessibilityElements(Dynamic dynamic) {
        if (dynamic == null || dynamic.getType() != ReadableType.String) {
            return;
        }
        String[] split = dynamic.asString().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (split.length > 0) {
            if (this.mAccessibilityElements == null) {
                this.mAccessibilityElements = new ArrayList<>();
            }
            this.mAccessibilityElements.clear();
            for (String str : split) {
                this.mAccessibilityElements.add(str);
            }
            LynxAccessibilityWrapper lynxAccessibilityWrapper = this.mContext.getLynxAccessibilityWrapper();
            if (lynxAccessibilityWrapper != null) {
                lynxAccessibilityWrapper.addAccessibilityElementsUI(this);
            }
        }
    }

    @LynxProp(name = PropsConstants.ACCESSIBILITY_LABEL)
    public void setAccessibilityLabel(Dynamic dynamic) {
        String str;
        if (dynamic != null) {
            ReadableType type = dynamic.getType();
            if (type == ReadableType.String) {
                str = dynamic.asString();
            } else if (type == ReadableType.Int || type == ReadableType.Number || type == ReadableType.Long) {
                str = String.valueOf(dynamic.asInt());
            } else if (type == ReadableType.Boolean) {
                str = String.valueOf(dynamic.asBoolean());
            }
            this.mAccessibilityLabel = str;
        }
        str = "";
        this.mAccessibilityLabel = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = PropsConstants.ACCESSIBILITY_ELEMENT)
    public void setAccessibilityElement(Dynamic dynamic) {
        int i = 1;
        i = 1;
        i = 1;
        if (dynamic != null) {
            ReadableType type = dynamic.getType();
            if (type == ReadableType.String) {
                i = Boolean.parseBoolean(dynamic.asString());
            } else if (type == ReadableType.Int || type == ReadableType.Number || type == ReadableType.Long) {
                if (dynamic.asInt() == 0) {
                    i = 0;
                }
            } else if (type == ReadableType.Boolean) {
                i = dynamic.asBoolean();
            }
        }
        this.mAccessibilityElementStatus = i;
    }

    @LynxProp(name = PropsConstants.ACCESSIBILITY_ENABLE_TAP)
    public void setAccessibilityEnableTap(Dynamic dynamic) {
        boolean z;
        if (dynamic != null) {
            ReadableType type = dynamic.getType();
            if (type == ReadableType.String) {
                z = Boolean.parseBoolean(dynamic.asString());
            } else if (type == ReadableType.Boolean) {
                z = dynamic.asBoolean();
            }
            this.mAccessibilityEnableTap = z;
        }
        z = false;
        this.mAccessibilityEnableTap = z;
    }

    @LynxProp(name = PropsConstants.ACCESSIBILITY_ELEMENTS_A11Y)
    public void setAccessibilityElementsA11y(Dynamic dynamic) {
        if (dynamic == null || dynamic.getType() != ReadableType.String) {
            return;
        }
        String[] split = dynamic.asString().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (split.length > 0) {
            if (this.mAccessibilityElementsA11y == null) {
                this.mAccessibilityElementsA11y = new ArrayList<>();
            }
            this.mAccessibilityElementsA11y.clear();
            for (String str : split) {
                this.mAccessibilityElementsA11y.add(str);
            }
            LynxAccessibilityWrapper lynxAccessibilityWrapper = this.mContext.getLynxAccessibilityWrapper();
            if (lynxAccessibilityWrapper != null) {
                lynxAccessibilityWrapper.addAccessibilityElementsA11yUI(this);
            }
        }
    }

    @LynxProp(name = PropsConstants.ACCESSIBILITY_ID)
    public void setA11yId(Dynamic dynamic) {
        this.mAccessibilityId = (dynamic == null || ReadableType.String != dynamic.getType()) ? "" : dynamic.asString();
    }

    @LynxProp(defaultBoolean = false, name = PropsConstants.ACCESSIBILITY_EXCLUSIVE_FOCUS)
    public void setAccessibilityExclusiveFocus(boolean z) {
        LynxAccessibilityWrapper lynxAccessibilityWrapper = this.mContext.getLynxAccessibilityWrapper();
        if (lynxAccessibilityWrapper != null) {
            lynxAccessibilityWrapper.addOrRemoveUIFromExclusiveMap(this, z);
        }
    }

    @LynxProp(defaultBoolean = false, name = PropsConstants.CONSUME_HOVER_EVENT)
    public void setConsumeHoverEvent(boolean z) {
        LynxAccessibilityWrapper lynxAccessibilityWrapper = this.mContext.getLynxAccessibilityWrapper();
        if (lynxAccessibilityWrapper == null || !lynxAccessibilityWrapper.enableHelper()) {
            return;
        }
        this.mConsumeHoverEvent = z;
    }

    @LynxProp(name = PropsConstants.ACCESSIBILITY_TRAITS)
    public void setAccessibilityTraits(Dynamic dynamic) {
        if (dynamic == null || dynamic.getType() != ReadableType.String) {
            return;
        }
        this.mAccessibilityTraits = LynxAccessibilityHelper.LynxAccessibilityTraits.fromValue(dynamic.asString());
    }

    @LynxProp(name = PropsConstants.ACCESSIBILITY_ROLE_DESCRIPTION)
    public void setAccessibilityRoleDescription(Dynamic dynamic) {
        if (dynamic == null || dynamic.getType() != ReadableType.String) {
            return;
        }
        this.mAccessibilityRoleDescription = dynamic.asString();
    }

    @LynxProp(name = PropsConstants.ACCESSIBILITY_STATUS)
    public void setAccessibilityStatus(Dynamic dynamic) {
        if (dynamic == null || dynamic.getType() != ReadableType.String) {
            return;
        }
        this.mAccessibilityStatus = dynamic.asString();
    }

    @LynxProp(name = PropsConstants.ACCESSIBILITY_ACTIONS)
    public void setAccessibilityActions(ReadableArray readableArray) {
        this.mAccessibilityActions = readableArray.asArrayList();
    }

    @LynxUIMethod
    public void requestAccessibilityFocus(ReadableMap readableMap, Callback callback) {
        if (this.mContext.getLynxAccessibilityWrapper() != null) {
            this.mContext.getLynxAccessibilityWrapper().requestAccessibilityFocus(this, callback);
        }
    }

    @LynxUIMethod
    public void fetchAccessibilityTargets(ReadableMap readableMap, Callback callback) {
        if (this.mContext.getLynxAccessibilityWrapper() != null) {
            this.mContext.getLynxAccessibilityWrapper().fetchAccessibilityTargets(this, callback);
        }
    }

    @LynxUIMethod
    public void innerText(ReadableMap readableMap, Callback callback) {
        if (this.mContext.getLynxAccessibilityWrapper() != null) {
            this.mContext.getLynxAccessibilityWrapper().innerText(this, callback);
        }
    }

    public String getAccessibilityId() {
        return this.mAccessibilityId;
    }

    public String getAccessibilityStatus() {
        return this.mAccessibilityStatus;
    }

    public ArrayList<String> getAccessibilityActions() {
        return this.mAccessibilityActions;
    }

    public ArrayList<String> getAccessibilityElementsA11y() {
        return this.mAccessibilityElementsA11y;
    }

    @LynxProp(defaultFloat = DisplayMetricsHolder.DEFAULT_SCREEN_SCALE, name = PropsConstants.POSITION)
    public final void setCSSPosition(int i) {
        this.mCSSPosition = i;
    }

    @LynxProp(name = PropsConstants.ENABLE_SCROLL_MONITOR)
    public void setEnableScrollMonitor(boolean z) {
        this.mEnableScrollMonitor = z;
    }

    @LynxProp(name = PropsConstants.SCROLL_MONITOR_TAG)
    public void setScrollMonitorTag(String str) {
        this.mScrollMonitorTag = str;
    }

    @LynxProp(defaultInt = 3, name = PropsConstants.DRIECTION)
    public void setLynxDirection(int i) {
        this.mLynxDirection = i;
    }

    @LynxProp(name = PropsConstants.INTERSECTION_OBSERVERS)
    public void setIntersectionObservers(ReadableArray readableArray) {
        this.mContext.getIntersectionObserverManager().removeAttachedIntersectionObserver(this);
        if (readableArray == null || !this.mEvents.containsKey("intersection")) {
            return;
        }
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            if (map != null) {
                this.mContext.getIntersectionObserverManager().addIntersectionObserver(new LynxIntersectionObserver(this.mContext.getIntersectionObserverManager(), map, this));
            }
        }
    }

    public JSONObject getPlatformCustomInfo() {
        return new JSONObject();
    }

    public int getCSSPositionType() {
        return this.mCSSPosition;
    }

    public ArrayList<String> getAccessibilityElements() {
        return this.mAccessibilityElements;
    }

    public CharSequence getAccessibilityLabel() {
        return this.mAccessibilityLabel;
    }

    public boolean getAccessibilityKeepFocused() {
        return this.mAccessibilityKeepFocused;
    }

    public int getAccessibilityElementStatus() {
        return this.mAccessibilityElementStatus;
    }

    public boolean getAccessibilityEnableTap() {
        return this.mAccessibilityEnableTap;
    }

    public LynxAccessibilityHelper.LynxAccessibilityTraits getAccessibilityTraits() {
        return this.mAccessibilityTraits;
    }

    public String getAccessibilityRoleDescription() {
        return this.mAccessibilityRoleDescription;
    }

    public String getName() {
        return this.mName;
    }

    public String getIdSelector() {
        return this.mIdSelector;
    }

    public String getRefIdSelector() {
        return this.mRefId;
    }

    @Override // com.lynx.tasm.behavior.event.EventTargetBase
    public ReadableMap getDataset() {
        return this.mDataset;
    }

    public Rect getBound() {
        return this.mBound;
    }

    public void setBound(Rect rect) {
        this.mBound = rect;
    }

    public void markDetachWithViewRecursively(boolean z) {
        this.mIsDetachedWithView = z;
        this.mNeedsBackgroundRecreation = z;
        Iterator<LynxBaseUI> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().markDetachWithViewRecursively(z);
        }
    }

    public boolean isDetachedWithView() {
        return this.mIsDetachedWithView;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getTop() {
        return this.mTop;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getBorderLeftWidth() {
        return this.mBorderLeftWidth;
    }

    public int getBorderTopWidth() {
        return this.mBorderTopWidth;
    }

    public int getBorderBottomWidth() {
        return this.mBorderBottomWidth;
    }

    public int getBorderRightWidth() {
        return this.mBorderRightWidth;
    }

    public int getMarginLeft() {
        return this.mMarginLeft;
    }

    public int getMarginTop() {
        return this.mMarginTop;
    }

    public int getMarginRight() {
        return this.mMarginRight;
    }

    public int getMarginBottom() {
        return this.mMarginBottom;
    }

    public float getFontSize() {
        return this.mFontSize;
    }

    public boolean getHasRadius() {
        return this.mHasRadius;
    }

    public List<TransformRaw> getTransformRaws() {
        return this.mTransformRaw;
    }

    public boolean isEnableScrollMonitor() {
        return this.mEnableScrollMonitor;
    }

    public String getScrollMonitorTag() {
        return this.mScrollMonitorTag;
    }

    public void setTransform(ReadableArray readableArray) {
        this.hasTransformChanged = true;
        List<TransformRaw> transformRaw = TransformRaw.toTransformRaw(readableArray);
        this.mTransformRaw = transformRaw;
        setTranslationZ(TransformRaw.hasZValue(transformRaw));
        if (getParent() instanceof UIShadowProxy) {
            ((UIShadowProxy) getParent()).updateTransform();
        }
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean hasConsumeSlideEventAngles() {
        ArrayList<ArrayList<Float>> arrayList = this.mConsumeSlideEventAngles;
        return (arrayList == null || arrayList.isEmpty()) ? false : true;
    }

    public TransformOrigin getTransformOriginStr() {
        return this.mTransformOrigin;
    }

    @LynxProp(name = PropsConstants.TRANSFORM_ORIGIN)
    public void setTransformOrigin(ReadableArray readableArray) {
        this.hasTransformChanged = true;
        this.mTransformOrigin = TransformOrigin.TRANSFORM_ORIGIN_DEFAULT;
        if (readableArray == null) {
            return;
        }
        TransformOrigin MakeTransformOrigin = TransformOrigin.MakeTransformOrigin(readableArray);
        this.mTransformOrigin = MakeTransformOrigin;
        if (MakeTransformOrigin == null) {
            LLog.e(TAG, "transform params error.");
            this.mTransformOrigin = TransformOrigin.TRANSFORM_ORIGIN_DEFAULT;
        }
    }

    @LynxProp(name = PropsConstants.PERSPECTIVE)
    public void setPerspective(ReadableArray readableArray) {
        this.mPerspective = readableArray;
    }

    @LynxProp(name = PropsConstants.LOCAL_CACHE)
    public void setLocalCache(Dynamic dynamic) {
        this.mUseLocalCache = dynamic;
    }

    @LynxProp(name = PropsConstants.SKIP_REDIRECTION)
    public void setSkipRedirection(boolean z) {
        this.mSkipRedirection = z;
    }

    public Dynamic getEnableLocalCache() {
        return this.mUseLocalCache;
    }

    public boolean getSkipRedirection() {
        return this.mSkipRedirection;
    }

    public int getImageRendering() {
        return this.mImageRendering;
    }

    public final boolean shouldDoTransform() {
        return this.hasTransformChanged || ((TransformRaw.hasPercent(this.mTransformRaw) || TransformOrigin.hasPercent(this.mTransformOrigin)) && hasSizeChanged());
    }

    public void updateLayout(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, Rect rect) {
        this.mSkipLayoutUpdated = true;
        updateLayoutInfo(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, rect);
        this.mSkipLayoutUpdated = false;
        onLayoutUpdated();
        sendLayoutChangeEvent();
    }

    public final void updateLayoutSize(int i, int i2) {
        this.mLatestSize.x = i;
        this.mLatestSize.y = i2;
    }

    public final int getLatestWidth() {
        return this.mLatestSize.x;
    }

    public final int getLatestHeight() {
        return this.mLatestSize.y;
    }

    public final boolean hasSizeChanged() {
        return !this.mLastSize.equals(this.mLatestSize);
    }

    public void measure() {
        Iterator<LynxBaseUI> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().measure();
        }
    }

    public void layout() {
        Iterator<LynxBaseUI> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().layout();
        }
    }

    private void sendLayoutChangeEvent() {
        Map<String, EventsListener> map = this.mEvents;
        if (map == null || !map.containsKey("layoutchange")) {
            return;
        }
        getLynxContext().getEventEmitter().sendCustomEvent(new LynxCustomEvent(getSign(), "layoutchange", getPositionInfo(LynxEnv.inst().enableTransformForPositionCalculation())));
    }

    @Deprecated
    public void updateLayout(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, Rect rect) {
        updateLayoutInfo(i, i2, i3, i4, i5, i6, i7, i8, 0, 0, 0, 0, i9, i10, i11, i12, rect);
        onLayoutUpdated();
    }

    public int getOriginTop() {
        return this.mOriginTop;
    }

    public int getOriginLeft() {
        return this.mOriginLeft;
    }

    public void setOriginLeft(int i) {
        this.mOriginLeft = i;
    }

    public void setOriginTop(int i) {
        this.mOriginTop = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
    
        if (java.lang.Float.compare(r5.mTop, r7) == 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void updateLayoutInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, Rect rect) {
        LynxContext lynxContext = this.mContext;
        if (lynxContext != null && lynxContext.isTouchMoving() && Float.compare(this.mWidth, CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) != 0 && Float.compare(this.mHeight, CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) != 0) {
            if (Float.compare(this.mLeft, i) != 0) {
            }
            this.mContext.onPropsChanged(this);
        }
        setPosition(i, i2);
        this.mWidth = i3;
        this.mHeight = i4;
        this.mPaddingLeft = i5;
        this.mPaddingRight = i7;
        this.mPaddingBottom = i8;
        this.mPaddingTop = i6;
        this.mMarginLeft = i9;
        this.mMarginTop = i10;
        this.mMarginRight = i11;
        this.mMarginBottom = i12;
        this.mBorderTopWidth = i14;
        this.mBorderBottomWidth = i16;
        this.mBorderLeftWidth = i13;
        this.mBorderRightWidth = i15;
        this.mBound = rect;
    }

    protected void setPosition(int i, int i2) {
        this.mLeft = i;
        this.mTop = i2;
        this.mOriginTop = i2;
        this.mOriginLeft = i;
    }

    public void updateLayoutInfo(LynxBaseUI lynxBaseUI) {
        updateLayoutInfo(lynxBaseUI.getLeft(), lynxBaseUI.getTop(), lynxBaseUI.getWidth(), lynxBaseUI.getHeight(), lynxBaseUI.getPaddingLeft(), lynxBaseUI.getPaddingTop(), lynxBaseUI.getPaddingRight(), lynxBaseUI.getPaddingBottom(), lynxBaseUI.getMarginLeft(), lynxBaseUI.getMarginTop(), lynxBaseUI.getMarginRight(), lynxBaseUI.getMarginBottom(), lynxBaseUI.getBorderLeftWidth(), lynxBaseUI.getBorderTopWidth(), lynxBaseUI.getBorderRightWidth(), lynxBaseUI.getBorderBottomWidth(), lynxBaseUI.getBound());
        this.mOriginLeft = lynxBaseUI.getOriginLeft();
        this.mOriginTop = lynxBaseUI.getOriginTop();
    }

    public boolean updateDrawingLayoutInfo(int i, int i2, Rect rect) {
        boolean z;
        boolean z2 = true;
        if (this.mLeft != i) {
            this.mLeft = i;
            z = true;
        } else {
            z = false;
        }
        if (this.mTop != i2) {
            this.mTop = i2;
        } else {
            z2 = z;
        }
        this.mBound = rect;
        if (z2) {
            onDrawingPositionChanged();
        }
        return z2;
    }

    public void setLeft(int i) {
        this.mLeft = i;
        this.mOriginLeft = i;
        onLayoutUpdated();
    }

    public void setTop(int i) {
        this.mTop = i;
        this.mOriginTop = i;
        onLayoutUpdated();
    }

    public void setWidth(int i) {
        this.mWidth = i;
        onLayoutUpdated();
    }

    public void setHeight(int i) {
        this.mHeight = i;
        onLayoutUpdated();
    }

    public void onLayoutUpdated() {
        if (this.mSkipLayoutUpdated) {
            return;
        }
        LynxBackground lynxBackground = this.mLynxBackground;
        if (lynxBackground != null) {
            lynxBackground.updatePaddingWidths(this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom, this.mPaddingLeft);
        }
        LynxMask lynxMask = this.mLynxMask;
        if (lynxMask != null) {
            lynxMask.updatePaddingWidths(this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom, this.mPaddingLeft);
        }
        invalidate();
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onPropsUpdated() {
        GestureArenaManager gestureArenaManager;
        LynxContext lynxContext = this.mContext;
        if (lynxContext != null) {
            lynxContext.addUIToExposedMap(this);
        }
        if (this.mGestureHandlers == null || !(this instanceof GestureArenaMember) || (gestureArenaManager = getGestureArenaManager()) == null || gestureArenaManager.isMemberExist(getGestureArenaMemberId())) {
            return;
        }
        this.mGestureArenaMemberId = gestureArenaManager.addMember((GestureArenaMember) this);
    }

    public void afterAnimationNodeReady() {
        if (this.mIsFirstAnimatedReady) {
            this.mIsFirstAnimatedReady = false;
        }
        this.mLastSize.x = this.mLatestSize.x;
        this.mLastSize.y = this.mLatestSize.y;
        this.hasTransformChanged = false;
    }

    public void onNodeReady() {
        onAnimationNodeReady();
        afterAnimationNodeReady();
    }

    public boolean isFirstAnimatedReady() {
        return this.mIsFirstAnimatedReady;
    }

    public void onAttach() {
        LynxBackground lynxBackground = this.mLynxBackground;
        if (lynxBackground != null) {
            lynxBackground.onAttach();
        }
        LynxMask lynxMask = this.mLynxMask;
        if (lynxMask != null) {
            lynxMask.onAttach();
        }
    }

    public void onDetach() {
        LynxBackground lynxBackground = this.mLynxBackground;
        if (lynxBackground != null) {
            lynxBackground.onDetach();
        }
        LynxMask lynxMask = this.mLynxMask;
        if (lynxMask != null) {
            lynxMask.onDetach();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class DrawableCallback implements Drawable.Callback {
        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        }

        private DrawableCallback() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            LynxBaseUI.this.invalidate();
        }
    }

    protected Rect getRect() {
        float width = getWidth() * getScaleX();
        float height = getHeight() * getScaleY();
        float originLeft = ((getOriginLeft() + (getWidth() / 2.0f)) - (width / 2.0f)) + getTranslationX();
        float originTop = ((getOriginTop() + (getHeight() / 2.0f)) - (height / 2.0f)) + getTranslationY();
        return new Rect((int) originLeft, (int) originTop, (int) (originLeft + width), (int) (originTop + height));
    }

    protected Rect getRectWithoutTransform() {
        float originLeft = getOriginLeft();
        float originTop = getOriginTop();
        return new Rect((int) originLeft, (int) originTop, (int) (originLeft + getWidth()), (int) (originTop + getHeight()));
    }

    public LynxBaseUI getParentBaseUI() {
        UIParent uIParent = this.mParent;
        if (uIParent instanceof UIShadowProxy) {
            return (LynxBaseUI) ((UIShadowProxy) uIParent).getParent();
        }
        return (LynxBaseUI) uIParent;
    }

    public String getExposeUniqueID() {
        return String.valueOf(this.mSign);
    }

    public void updateSticky(float[] fArr) {
        if (fArr == null || fArr.length < 4) {
            this.mSticky = null;
            return;
        }
        Sticky sticky = new Sticky();
        this.mSticky = sticky;
        sticky.left = fArr[0];
        this.mSticky.top = fArr[1];
        this.mSticky.right = fArr[2];
        this.mSticky.bottom = fArr[3];
        Sticky sticky2 = this.mSticky;
        sticky2.f2y = CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        sticky2.f1x = CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        Cloneable parentBaseUI = getParentBaseUI();
        if (parentBaseUI instanceof IScrollSticky) {
            ((IScrollSticky) parentBaseUI).setEnableSticky();
        }
    }

    public void updateMaxHeight(float f) {
        this.mMaxHeight = f;
    }

    public boolean checkStickyOnParentScroll(int i, int i2) {
        if (this.mSticky == null) {
            return false;
        }
        float left = getLeft() - i;
        float top = getTop() - i2;
        if (left < this.mSticky.left) {
            Sticky sticky = this.mSticky;
            sticky.f1x = sticky.left - left;
        } else {
            if (getParentBaseUI() == null) {
                LLog.e(TAG, "checkStickyOnParentScroll failed, parent is null.");
                return false;
            }
            float width = getWidth() + left;
            float width2 = getParentBaseUI().getWidth();
            if (this.mSticky.right + width > width2) {
                Sticky sticky2 = this.mSticky;
                sticky2.f1x = Math.max((width2 - width) - sticky2.right, this.mSticky.left - left);
            } else {
                this.mSticky.f1x = CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            }
        }
        if (top < this.mSticky.top) {
            Sticky sticky3 = this.mSticky;
            sticky3.f2y = sticky3.top - top;
            return true;
        }
        if (getParentBaseUI() == null) {
            LLog.e(TAG, "checkStickyOnParentScroll failed, parent is null.");
            return false;
        }
        float height = getHeight() + top;
        float height2 = getParentBaseUI().getHeight();
        if (this.mSticky.bottom + height > height2) {
            Sticky sticky4 = this.mSticky;
            sticky4.f2y = Math.max((height2 - height) - sticky4.bottom, this.mSticky.top - top);
            return true;
        }
        this.mSticky.f2y = CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        return true;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public int getSign() {
        return this.mSign;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public int getGestureArenaMemberId() {
        return this.mGestureArenaMemberId;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public int getPseudoStatus() {
        return this.mPseudoStatus;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget parent() {
        UIParent uIParent = this.mParent;
        if (uIParent instanceof EventTarget) {
            return (EventTarget) uIParent;
        }
        return null;
    }

    @Override // com.lynx.tasm.behavior.event.EventTargetBase
    public EventTargetBase parentResponder() {
        UIParent uIParent = this.mParent;
        if (uIParent instanceof EventTargetBase) {
            return (EventTargetBase) uIParent;
        }
        return null;
    }

    public float[] getTargetPoint(float f, float f2, int i, int i2, Rect rect, Matrix matrix) {
        float[] fArr = {(f + i) - rect.left, (f2 + i2) - rect.top};
        Matrix hitTestMatrix = getHitTestMatrix();
        if (matrix.invert(hitTestMatrix)) {
            float[] fArr2 = {fArr[0], fArr[1]};
            hitTestMatrix.mapPoints(fArr2);
            fArr[0] = fArr2[0];
            fArr[1] = fArr2[1];
        } else {
            fArr[0] = Float.MAX_VALUE;
            fArr[1] = Float.MAX_VALUE;
        }
        return fArr;
    }

    public float[] getTargetPoint(float f, float f2, int i, int i2, View view, Matrix matrix) {
        return getTargetPoint(f, f2, i, i2, new Rect(view.getLeft(), view.getTop(), 0, 0), matrix);
    }

    public float[] getLocationOnScreen(float[] fArr) {
        View view;
        int[] iArr = new int[2];
        if (isFlatten()) {
            fArr[0] = fArr[0] + getLeft();
            fArr[1] = fArr[1] + getTop();
        }
        if (isFlatten()) {
            UIParent uIParent = this.mDrawParent;
            if (uIParent == null) {
                LLog.e(TAG, "mDrawParent of flattenUI is null, which causes the value getLocationOnScreen returns is not the correct coordinates relative to the screen!");
                return fArr;
            }
            view = ((LynxUI) uIParent).getView();
            fArr[0] = fArr[0] - view.getScrollX();
            fArr[1] = fArr[1] - view.getScrollY();
        } else {
            view = ((LynxUI) this).getView();
        }
        view.getRootView().getLocationOnScreen(iArr);
        transformFromViewToRootView(view, fArr);
        fArr[0] = fArr[0] + iArr[0];
        fArr[1] = fArr[1] + iArr[1];
        return fArr;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float f, float f2) {
        return hitTest(f, f2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0109 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00da  */
    @Override // com.lynx.tasm.behavior.event.EventTarget
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EventTarget hitTest(float f, float f2, boolean z) {
        float f3;
        float f4;
        boolean z2;
        LynxBaseUI lynxBaseUI;
        boolean containsPoint;
        Log.d("hxh-debug", "hitTest x: " + f + " y: " + f2);
        ArrayList arrayList = new ArrayList();
        int size = this.mChildren.size() - 1;
        LynxBaseUI lynxBaseUI2 = null;
        float f5 = f;
        float f6 = f2;
        while (true) {
            if (size < 0) {
                f3 = f5;
                f4 = f6;
                break;
            }
            LynxBaseUI lynxBaseUI3 = this.mChildren.get(size);
            if (lynxBaseUI3 instanceof UIShadowProxy) {
                lynxBaseUI3 = ((UIShadowProxy) lynxBaseUI3).getChild();
            }
            LynxBaseUI lynxBaseUI4 = lynxBaseUI3;
            if (lynxBaseUI4 instanceof UIComponent) {
                UIComponent uIComponent = (UIComponent) lynxBaseUI4;
                if (uIComponent.getView() != 0 && ((AndroidView) uIComponent.getView()).getParent() == null) {
                    z2 = true;
                    if ((!z || lynxBaseUI4.isUserInteractionEnabled()) && lynxBaseUI4.getVisibility() && ((lynxBaseUI4.getDrawParent() == null || ((LynxUI) lynxBaseUI4.getDrawParent()).getView() == null || ((LynxUI) lynxBaseUI4.getDrawParent()).getView().getParent() != null) && !z2)) {
                        float[] fArr = {f, f2};
                        if (!this.mContext.getEnableEventRefactor()) {
                            fArr = getTargetPoint(fArr[0], fArr[1], getScrollX(), getScrollY(), lynxBaseUI4.getRectWithoutTransform(), lynxBaseUI4.getTransformMatrix());
                            lynxBaseUI = lynxBaseUI4;
                            containsPoint = lynxBaseUI.containsPoint(fArr[0], fArr[1], z);
                        } else {
                            lynxBaseUI = lynxBaseUI4;
                            containsPoint = lynxBaseUI.containsPoint(fArr[0], fArr[1], z);
                        }
                        if (containsPoint) {
                            continue;
                        } else {
                            arrayList.add(lynxBaseUI);
                            if (lynxBaseUI.isOnResponseChain()) {
                                float f7 = fArr[0];
                                f4 = fArr[1];
                                f3 = f7;
                                lynxBaseUI2 = lynxBaseUI;
                                break;
                            }
                            if (lynxBaseUI2 == null || lynxBaseUI2.getRealTimeTranslationZ() < lynxBaseUI.getRealTimeTranslationZ()) {
                                f5 = fArr[0];
                                f6 = fArr[1];
                                lynxBaseUI2 = lynxBaseUI;
                            }
                        }
                    }
                    size--;
                }
            }
            z2 = false;
            if (!z) {
            }
            float[] fArr2 = {f, f2};
            if (!this.mContext.getEnableEventRefactor()) {
            }
            if (containsPoint) {
            }
            size--;
        }
        EventTarget performHitTestOnTarget = lynxBaseUI2 == null ? this : performHitTestOnTarget(lynxBaseUI2, f, f2, f3, f4, z);
        if (performHitTestOnTarget == null || performHitTestOnTarget.pointerEvents() == EventTarget.PointerEventsValue.None) {
            performHitTestOnTarget = findHitTargetInSiblings(arrayList, lynxBaseUI2, f, f2, z);
        }
        return performHitTestOnTarget != null ? performHitTestOnTarget : this;
    }

    private EventTarget performHitTestOnTarget(LynxBaseUI lynxBaseUI, float f, float f2, float f3, float f4, boolean z) {
        if (!lynxBaseUI.isCustomHittest() && lynxBaseUI.needCustomLayout() && (lynxBaseUI instanceof UIGroup)) {
            return performCustomLayoutHitTest((UIGroup) lynxBaseUI, f, f2, f3, f4);
        }
        return performStandardHitTest(lynxBaseUI, f, f2, f3, f4, z);
    }

    private EventTarget performCustomLayoutHitTest(UIGroup uIGroup, float f, float f2, float f3, float f4) {
        if (this.mContext.getEnableEventRefactor()) {
            return uIGroup.findUIWithCustomLayout(f3, f4, uIGroup);
        }
        return uIGroup.findUIWithCustomLayout(f - uIGroup.getOriginLeft(), f2 - uIGroup.getOriginTop(), uIGroup);
    }

    private EventTarget performStandardHitTest(LynxBaseUI lynxBaseUI, float f, float f2, float f3, float f4, boolean z) {
        if (this.mContext.getEnableEventRefactor()) {
            return lynxBaseUI.hitTest(f3, f4, z);
        }
        return lynxBaseUI.hitTest(((f + lynxBaseUI.getScrollX()) - lynxBaseUI.getOriginLeft()) - lynxBaseUI.getTranslationX(), ((f2 + lynxBaseUI.getScrollY()) - lynxBaseUI.getOriginTop()) - lynxBaseUI.getTranslationY(), z);
    }

    private EventTarget findHitTargetInSiblings(List<EventTarget> list, EventTarget eventTarget, float f, float f2, boolean z) {
        EventTarget performHitTestOnSibling;
        for (int i = 0; i < list.size(); i++) {
            LynxBaseUI lynxBaseUI = (LynxBaseUI) list.get(i);
            if (lynxBaseUI != null && lynxBaseUI != eventTarget && (performHitTestOnSibling = performHitTestOnSibling(lynxBaseUI, f, f2, z)) != null) {
                return performHitTestOnSibling;
            }
        }
        return null;
    }

    private EventTarget performHitTestOnSibling(LynxBaseUI lynxBaseUI, float f, float f2, boolean z) {
        float[] calculateSiblingCoordinates = calculateSiblingCoordinates(lynxBaseUI, f, f2);
        float f3 = calculateSiblingCoordinates[0];
        float f4 = calculateSiblingCoordinates[1];
        if (!lynxBaseUI.isCustomHittest() && lynxBaseUI.needCustomLayout() && (lynxBaseUI instanceof UIGroup)) {
            UIGroup uIGroup = (UIGroup) lynxBaseUI;
            return uIGroup.findUIWithCustomLayout(f3, f4, uIGroup);
        }
        return lynxBaseUI.hitTest(f3, f4, z);
    }

    private float[] calculateSiblingCoordinates(LynxBaseUI lynxBaseUI, float f, float f2) {
        float scrollX;
        float scrollY;
        if (this.mContext.getEnableEventRefactor()) {
            return getTargetPoint(f, f2, getScrollX(), getScrollY(), lynxBaseUI.getRectWithoutTransform(), lynxBaseUI.getTransformMatrix());
        }
        if (!lynxBaseUI.isCustomHittest() && lynxBaseUI.needCustomLayout() && (lynxBaseUI instanceof UIGroup)) {
            scrollX = f - lynxBaseUI.getOriginLeft();
            scrollY = f2 - lynxBaseUI.getOriginTop();
        } else {
            scrollX = f + ((lynxBaseUI.getScrollX() - lynxBaseUI.getOriginLeft()) - lynxBaseUI.getTranslationX());
            scrollY = f2 + ((lynxBaseUI.getScrollY() - lynxBaseUI.getOriginTop()) - lynxBaseUI.getTranslationY());
        }
        return new float[]{scrollX, scrollY};
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean containsPoint(float f, float f2) {
        return containsPoint(f, f2, false);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean containsPoint(float f, float f2, boolean z) {
        float touchSlop = getTouchSlop();
        boolean z2 = false;
        if (this.mContext.getEnableEventRefactor()) {
            float f3 = -touchSlop;
            float f4 = f3 - this.mHitSlopLeft;
            float f5 = this.mWidth + touchSlop + this.mHitSlopRight;
            float f6 = f3 - this.mHitSlopTop;
            float f7 = this.mHeight + touchSlop + this.mHitSlopBottom;
            if (f4 <= f && f5 >= f && f6 <= f2 && f7 >= f2) {
                z2 = true;
            }
            if (z2 || getOverflow() == 0) {
                return z2;
            }
            if (getOverflow() == 1) {
                if (f2 < f6 || f2 > f7) {
                    return z2;
                }
            } else if (getOverflow() == 2 && (f < f4 || f > f5)) {
                return z2;
            }
            return childrenContainPoint(f, f2, z);
        }
        Rect rect = getRect();
        if (rect.left - touchSlop < f && rect.right + touchSlop > f && rect.top - touchSlop < f2 && rect.bottom + touchSlop > f2) {
            z2 = true;
        }
        if (z2 || getOverflow() == 0) {
            return z2;
        }
        if (getOverflow() == 1) {
            if (rect.top - touchSlop >= f2 || rect.bottom + touchSlop <= f2) {
                return z2;
            }
        } else if (getOverflow() == 2 && (rect.left - touchSlop >= f || rect.right + touchSlop <= f)) {
            return z2;
        }
        return childrenContainPoint(f, f2, z);
    }

    public boolean childrenContainPoint(float f, float f2) {
        return childrenContainPoint(f, f2, false);
    }

    public boolean childrenContainPoint(float f, float f2, boolean z) {
        if (this.mContext.getEnableEventRefactor()) {
            for (LynxBaseUI lynxBaseUI : this.mChildren) {
                if (lynxBaseUI instanceof UIShadowProxy) {
                    lynxBaseUI = ((UIShadowProxy) lynxBaseUI).getChild();
                }
                float[] targetPoint = getTargetPoint(f, f2, getScrollX(), getScrollY(), lynxBaseUI.getRectWithoutTransform(), lynxBaseUI.getTransformMatrix());
                if (z || lynxBaseUI.isUserInteractionEnabled()) {
                    if (lynxBaseUI.getVisibility() && lynxBaseUI.containsPoint(targetPoint[0], targetPoint[1], z)) {
                        return true;
                    }
                }
            }
            return false;
        }
        float scrollX = ((f + getScrollX()) - getOriginLeft()) - getTranslationX();
        float scrollY = ((f2 + getScrollY()) - getOriginTop()) - getTranslationY();
        for (LynxBaseUI lynxBaseUI2 : this.mChildren) {
            if (z || lynxBaseUI2.isUserInteractionEnabled()) {
                if (lynxBaseUI2.getVisibility() && lynxBaseUI2.containsPoint(scrollX, scrollY, z)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public Map<String, EventsListener> getEvents() {
        return this.mEvents;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public Map<Integer, GestureDetector> getGestureDetectorMap() {
        return this.mGestureDetectors;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public Matrix getTransformMatrix() {
        this.mTransformMatrix.reset();
        return this.mTransformMatrix;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isUserInteractionEnabled() {
        return this.userInteractionEnabled;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean ignoreFocus() {
        if (this.mIgnoreFocus == EventTarget.EnableStatus.Enable) {
            return true;
        }
        if (this.mIgnoreFocus == EventTarget.EnableStatus.Disable || parent() == null) {
            return false;
        }
        return parent().ignoreFocus();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isFocusable() {
        return this.mFocusable;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isClickable() {
        Map<String, EventsListener> map = this.mEvents;
        return map != null && map.containsKey(LynxTouchEvent.EVENT_TAP);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isLongClickable() {
        Map<String, EventsListener> map = this.mEvents;
        return map != null && map.containsKey(LynxTouchEvent.EVENT_LONG_PRESS);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean enableTouchPseudoPropagation() {
        return this.mEnableTouchPseudoPropagation;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onPseudoStatusChanged(int i, int i2) {
        this.mPseudoStatus = i2;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onResponseChain() {
        this.mOnResponseChain = true;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void offResponseChain() {
        this.mOnResponseChain = false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isOnResponseChain() {
        return this.mOnResponseChain;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean consumeSlideEvent(float f) {
        ArrayList<ArrayList<Float>> arrayList = this.mConsumeSlideEventAngles;
        if (arrayList == null) {
            return false;
        }
        Iterator<ArrayList<Float>> it = arrayList.iterator();
        while (it.hasNext()) {
            ArrayList<Float> next = it.next();
            if (f >= next.get(0).floatValue() && f <= next.get(1).floatValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean blockNativeEvent(MotionEvent motionEvent) {
        if (this.mBlockNativeEvent) {
            return true;
        }
        if (this.mBlockNativeEventAreas == null) {
            return false;
        }
        Rect boundingClientRect = getLynxContext().getUIBody().getBoundingClientRect();
        Rect boundingClientRect2 = getBoundingClientRect();
        LynxTouchEvent.Point convert = new LynxTouchEvent.Point(motionEvent.getX(), motionEvent.getY()).convert(boundingClientRect, boundingClientRect2);
        int i = 0;
        boolean z = false;
        while (true) {
            if (i >= this.mBlockNativeEventAreas.size()) {
                break;
            }
            ArrayList<SizeValue> arrayList = this.mBlockNativeEventAreas.get(i);
            if (arrayList != null && arrayList.size() == 4) {
                float convertToDevicePx = arrayList.get(0).convertToDevicePx(boundingClientRect2.right - boundingClientRect2.left);
                float convertToDevicePx2 = arrayList.get(1).convertToDevicePx(boundingClientRect2.bottom - boundingClientRect2.top);
                z = convert.getX() >= convertToDevicePx && convert.getX() < arrayList.get(2).convertToDevicePx((float) (boundingClientRect2.right - boundingClientRect2.left)) + convertToDevicePx && convert.getY() >= convertToDevicePx2 && convert.getY() < arrayList.get(3).convertToDevicePx((float) (boundingClientRect2.bottom - boundingClientRect2.top)) + convertToDevicePx2;
                if (z) {
                    LLog.i(TAG, "blocked this point!");
                    break;
                }
            }
            i++;
        }
        return z;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean eventThrough(float f, float f2) {
        boolean z;
        float f3;
        float f4;
        if (this.mEventThrough == EventTarget.EnableStatus.Enable) {
            z = true;
        } else {
            if (this.mEventThrough != EventTarget.EnableStatus.Disable && parent() != null) {
                EventTarget parent = parent();
                if (!(parent instanceof UIBody)) {
                    if (parent instanceof LynxBaseUI) {
                        RectF convertRectFromUIToAnotherUI = LynxUIHelper.convertRectFromUIToAnotherUI(this, (LynxBaseUI) parent, new RectF(CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, r1.getWidth(), r1.getHeight()));
                        f3 = f - convertRectFromUIToAnotherUI.left;
                        f4 = f2 - convertRectFromUIToAnotherUI.top;
                    } else {
                        f3 = f;
                        f4 = f2;
                    }
                    z = parent.eventThrough(f3, f4);
                }
            }
            z = false;
        }
        if (this.mEventThroughActiveRegions == null) {
            return z;
        }
        int i = 0;
        boolean z2 = false;
        while (true) {
            if (i >= this.mEventThroughActiveRegions.size()) {
                break;
            }
            ArrayList<SizeValue> arrayList = this.mEventThroughActiveRegions.get(i);
            if (arrayList != null && arrayList.size() == 4) {
                float convertToDevicePx = arrayList.get(0).convertToDevicePx(this.mWidth);
                float convertToDevicePx2 = arrayList.get(1).convertToDevicePx(this.mHeight);
                z2 = f >= convertToDevicePx && f < arrayList.get(2).convertToDevicePx((float) this.mWidth) + convertToDevicePx && f2 >= convertToDevicePx2 && f2 < arrayList.get(3).convertToDevicePx((float) this.mHeight) + convertToDevicePx2;
                if (z2) {
                    LLog.i(TAG, "hit the event through active regions!");
                    break;
                }
            }
            i++;
        }
        return z2 ? z : !z;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget.PointerEventsValue pointerEvents() {
        Log.d("hxh-debug", "pointerevents");
        if (this.mPointerEvents != EventTarget.PointerEventsValue.Unset) {
            return this.mPointerEvents;
        }
        if (parent() != null) {
            return parent().pointerEvents();
        }
        return EventTarget.PointerEventsValue.Auto;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget getParentLynxPageUI() {
        LynxContext lynxContext = this.mContext;
        if (lynxContext == null || lynxContext.getUIBody() == null) {
            return null;
        }
        return this.mContext.getUIBody().getParentLynxPageUI();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void setParentLynxPageUI(EventTarget eventTarget) {
        LynxContext lynxContext = this.mContext;
        if (lynxContext == null || lynxContext.getUIBody() == null) {
            return;
        }
        this.mContext.getUIBody().setParentLynxPageUI(eventTarget);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public HashMap<String, EventTarget> getChildrenLynxPageUI() {
        LynxContext lynxContext = this.mContext;
        if (lynxContext == null || lynxContext.getUIBody() == null) {
            return null;
        }
        return this.mContext.getUIBody().getChildrenLynxPageUI();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void setChildrenLynxPageUI(HashMap<String, EventTarget> hashMap) {
        LynxContext lynxContext = this.mContext;
        if (lynxContext == null || lynxContext.getUIBody() == null) {
            return;
        }
        this.mContext.getUIBody().setChildrenLynxPageUI(hashMap);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget getRootLynxPageUI() {
        EventTarget eventTarget = this;
        while (eventTarget != null && eventTarget.getParentLynxPageUI() != null) {
            eventTarget = eventTarget.getParentLynxPageUI();
        }
        return eventTarget;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void setEventID(long j) {
        LynxBaseUI lynxBaseUI;
        if (getChildrenLynxPageUI() == null || (lynxBaseUI = (LynxBaseUI) getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this)))) == null || lynxBaseUI.getLynxContext() == null || lynxBaseUI.getLynxContext().getEventEmitter() == null) {
            return;
        }
        lynxBaseUI.getLynxContext().getEventEmitter().setEventID(j);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void startEventCapture(long j) {
        LynxContext lynxContext = this.mContext;
        if (lynxContext == null || lynxContext.getEventEmitter() == null) {
            return;
        }
        this.mContext.getEventEmitter().startEventCapture(j);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onEventCapture(boolean z, long j) {
        if (z) {
            if (getRootLynxPageUI() != null) {
                getRootLynxPageUI().startEventFire(false, j);
                return;
            }
            return;
        }
        LynxBaseUI lynxBaseUI = getChildrenLynxPageUI() != null ? (LynxBaseUI) getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this))) : null;
        if (lynxBaseUI != null) {
            if (lynxBaseUI.getLynxContext() == null || lynxBaseUI.getLynxContext().getEventEmitter() == null) {
                return;
            }
            lynxBaseUI.getLynxContext().getEventEmitter().startEventCapture(j);
            return;
        }
        startEventBubble(j);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void startEventBubble(long j) {
        LynxContext lynxContext = this.mContext;
        if (lynxContext == null || lynxContext.getEventEmitter() == null) {
            return;
        }
        this.mContext.getEventEmitter().startEventBubble(j);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onEventBubble(boolean z, long j) {
        if (z) {
            if (getRootLynxPageUI() != null) {
                getRootLynxPageUI().startEventFire(false, j);
            }
        } else if (getParentLynxPageUI() != null) {
            getParentLynxPageUI().startEventBubble(j);
        } else {
            startEventFire(false, j);
        }
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void startEventFire(boolean z, long j) {
        LynxContext lynxContext = this.mContext;
        if (lynxContext == null || lynxContext.getEventEmitter() == null) {
            return;
        }
        this.mContext.getEventEmitter().startEventFire(z, j);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onEventFire(boolean z, long j) {
        LynxBaseUI lynxBaseUI = getChildrenLynxPageUI() != null ? (LynxBaseUI) getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this))) : null;
        if (lynxBaseUI == null || lynxBaseUI.getLynxContext() == null || lynxBaseUI.getLynxContext().getEventEmitter() == null) {
            return;
        }
        lynxBaseUI.getLynxContext().getEventEmitter().startEventFire(z, j);
    }

    private float getTouchSlop() {
        return this.mOnResponseChain ? this.mTouchSlop * this.mContext.getResources().getDisplayMetrics().density : CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    public void registerScrollStateListener(ScrollStateChangeListener scrollStateChangeListener) {
        if (scrollStateChangeListener == null) {
            return;
        }
        synchronized (this) {
            if (this.mStateChangeListeners == null) {
                this.mStateChangeListeners = new HashSet();
            }
            this.mStateChangeListeners.add(scrollStateChangeListener);
            if (this.mStateChangeListeners.size() != 1) {
                return;
            }
            initScrollStateChangeListener();
            UIParent parent = getParent();
            if (parent instanceof LynxBaseUI) {
                ((LynxBaseUI) parent).registerScrollStateListener(this.mScrollStateChangeListener);
            }
        }
    }

    private synchronized void initScrollStateChangeListener() {
        if (this.mScrollStateChangeListener != null) {
            return;
        }
        this.mScrollStateChangeListener = new ScrollStateChangeListener() { // from class: com.lynx.tasm.behavior.ui.LynxBaseUI.2
            @Override // com.lynx.tasm.behavior.p000ui.ScrollStateChangeListener
            public void onScrollStateChanged(int i) {
                ScrollStateChangeListener[] scrollStateChangeListenerArr;
                synchronized (LynxBaseUI.this) {
                    scrollStateChangeListenerArr = (ScrollStateChangeListener[]) LynxBaseUI.this.mStateChangeListeners.toArray(new ScrollStateChangeListener[LynxBaseUI.this.mStateChangeListeners.size()]);
                }
                for (ScrollStateChangeListener scrollStateChangeListener : scrollStateChangeListenerArr) {
                    scrollStateChangeListener.onScrollStateChanged(i);
                }
            }
        };
    }

    public void unRegisterScrollStateListener(ScrollStateChangeListener scrollStateChangeListener) {
        boolean isEmpty;
        if (scrollStateChangeListener == null || this.mStateChangeListeners == null) {
            return;
        }
        synchronized (this) {
            this.mStateChangeListeners.remove(scrollStateChangeListener);
            isEmpty = this.mStateChangeListeners.isEmpty();
        }
        if (isEmpty) {
            UIParent parent = getParent();
            if (parent instanceof LynxBaseUI) {
                ((LynxBaseUI) parent).unRegisterScrollStateListener(this.mScrollStateChangeListener);
            }
        }
    }

    public void notifyScrollStateChanged(int i) {
        ScrollStateChangeListener[] scrollStateChangeListenerArr;
        if (this.mStateChangeListeners == null) {
            return;
        }
        synchronized (this) {
            scrollStateChangeListenerArr = (ScrollStateChangeListener[]) this.mStateChangeListeners.toArray(new ScrollStateChangeListener[this.mStateChangeListeners.size()]);
        }
        for (ScrollStateChangeListener scrollStateChangeListener : scrollStateChangeListenerArr) {
            scrollStateChangeListener.onScrollStateChanged(i);
        }
    }

    public Point getLastSize() {
        return this.mLastSize;
    }

    public Point getLatestSize() {
        return this.mLatestSize;
    }

    public void copyPropFromOldUiInUpdateFlatten(LynxBaseUI lynxBaseUI) {
        this.mIsFirstAnimatedReady = lynxBaseUI.mIsFirstAnimatedReady;
        this.mLastSize.set(lynxBaseUI.getLastSize().x, lynxBaseUI.getLastSize().y);
        this.mLatestSize.set(lynxBaseUI.getLatestSize().x, lynxBaseUI.getLatestSize().y);
        this.mFlattenChildrenCount = lynxBaseUI.mFlattenChildrenCount;
        setEvents(lynxBaseUI.getEvents());
    }

    public boolean getNeedSortChildren() {
        return this.mNeedSortChildren;
    }

    public void setNeedSortChildren(boolean z) {
        this.mNeedSortChildren = z;
    }

    public float getLastTranslateZ() {
        return this.mLastTranslateZ;
    }

    public void setLastTranslateZ(float f) {
        this.mLastTranslateZ = f;
    }

    public void setOffsetDescendantRectToLynxView(int[] iArr) {
        this.mOffsetDescendantRectToLynxView = new WeakReference<>(iArr);
    }

    public int[] getOffsetDescendantRectToLynxView() {
        int[] iArr = this.mOffsetDescendantRectToLynxView.get();
        return iArr != null ? iArr : sDefaultOffsetToLynxView;
    }

    public Matrix getHitTestMatrix() {
        this.mHitTestMatrix.reset();
        return this.mHitTestMatrix;
    }

    public void onListCellAppear(String str, LynxBaseUI lynxBaseUI) {
        if (this.mBlockListEvent) {
            return;
        }
        Iterator<LynxBaseUI> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().onListCellAppear(str, lynxBaseUI);
        }
    }

    public void onListCellDisAppear(String str, LynxBaseUI lynxBaseUI, boolean z) {
        if (this.mBlockListEvent) {
            return;
        }
        Iterator<LynxBaseUI> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().onListCellDisAppear(str, lynxBaseUI, z);
        }
    }

    public void onListCellPrepareForReuse(String str, LynxBaseUI lynxBaseUI) {
        if (this.mBlockListEvent) {
            return;
        }
        Iterator<LynxBaseUI> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().onListCellPrepareForReuse(str, lynxBaseUI);
        }
    }

    public String constructListStateCacheKey(String str, String str2, String str3) {
        StringBuilder append = new StringBuilder().append(str).append(RomUtils.SEPARATOR).append(str2).append(RomUtils.SEPARATOR);
        if (str3 == null) {
            str3 = "";
        }
        return append.append(str3).toString();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LynxBaseUI m4126clone() throws CloneNotSupportedException {
        LynxBaseUI createUI = this.mContext.getLynxUIOwner().createUI(this.mTagName, false);
        applyUIPaintStylesToTarget(createUI);
        Iterator<LynxBaseUI> it = getChildren().iterator();
        while (it.hasNext()) {
            LynxBaseUI m4126clone = it.next().m4126clone();
            createUI.insertChild(m4126clone, createUI.getChildren().size());
            ((UIGroup) createUI).insertView((LynxUI) m4126clone);
        }
        createUI.updateProperties(new StylesDiffMap(this.mProps));
        createUI.updateLayoutSize(getWidth(), getHeight());
        createUI.updateLayout(getLeft(), getTop(), getWidth(), getHeight(), getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), getMarginLeft(), getMarginTop(), getMarginRight(), createUI.getMarginBottom(), getBorderLeftWidth(), getBorderTopWidth(), getBorderRightWidth(), getBorderBottomWidth(), getBound());
        createUI.onLayoutFinish(0L, null);
        createUI.onNodeReady();
        return createUI;
    }

    public GestureArenaManager getGestureArenaManager() {
        LynxUIOwner lynxUIOwner;
        LynxContext lynxContext = this.mContext;
        if (lynxContext == null || (lynxUIOwner = lynxContext.getLynxUIOwner()) == null) {
            return null;
        }
        return lynxUIOwner.getGestureArenaManager();
    }

    @Override // com.lynx.tasm.gesture.LynxNewGestureDelegate
    public void setGestureDetectorState(int i, int i2) {
        GestureArenaManager gestureArenaManager;
        if (isEnableNewGesture() && (gestureArenaManager = getGestureArenaManager()) != null) {
            gestureArenaManager.setGestureDetectorState(getGestureArenaMemberId(), i, i2);
        }
    }

    @Override // com.lynx.tasm.gesture.LynxNewGestureDelegate
    public void consumeGesture(int i, ReadableMap readableMap) {
        if (!isEnableNewGesture() || readableMap == null) {
            return;
        }
        boolean z = readableMap.getBoolean("inner", true);
        boolean z2 = readableMap.getBoolean("consume", true);
        if (z) {
            consumeGesture(z2);
        } else {
            interceptGesture(z2);
        }
    }

    public boolean isEnableNewGesture() {
        return this.mGestureArenaMemberId > 0;
    }

    @LynxProp(name = PropsConstants.HIT_SLOP)
    public void setHitSlop(Dynamic dynamic) {
        if (dynamic != null) {
            if (dynamic.getType() == ReadableType.Map || dynamic.getType() == ReadableType.String) {
                if (dynamic.getType() == ReadableType.Map && dynamic.asMap().size() > 0) {
                    ReadableMap asMap = dynamic.asMap();
                    ReadableMapKeySetIterator keySetIterator = asMap.keySetIterator();
                    List asList = Arrays.asList(PropsConstants.HIT_SLOP_TOP, PropsConstants.HIT_SLOP_BOTTOM, PropsConstants.HIT_SLOP_LEFT, PropsConstants.HIT_SLOP_RIGHT);
                    while (keySetIterator.hasNextKey()) {
                        String nextKey = keySetIterator.nextKey();
                        if (asList.contains(nextKey)) {
                            float px = UnitUtils.toPx(asMap.getString(nextKey));
                            int indexOf = asList.indexOf(nextKey);
                            if (indexOf == 0) {
                                float f = this.mHitSlopTop;
                                if (f == px) {
                                    px = f;
                                }
                                this.mHitSlopTop = px;
                            } else if (indexOf == 1) {
                                float f2 = this.mHitSlopBottom;
                                if (f2 == px) {
                                    px = f2;
                                }
                                this.mHitSlopBottom = px;
                            } else if (indexOf == 2) {
                                float f3 = this.mHitSlopLeft;
                                if (f3 == px) {
                                    px = f3;
                                }
                                this.mHitSlopLeft = px;
                            } else if (indexOf == 3) {
                                float f4 = this.mHitSlopRight;
                                if (f4 == px) {
                                    px = f4;
                                }
                                this.mHitSlopRight = px;
                            }
                        }
                    }
                    return;
                }
                float px2 = UnitUtils.toPx(dynamic.asString());
                if (this.mHitSlopTop == px2 && this.mHitSlopBottom == px2 && this.mHitSlopLeft == px2 && this.mHitSlopRight == px2) {
                    return;
                }
                this.mHitSlopRight = px2;
                this.mHitSlopLeft = px2;
                this.mHitSlopBottom = px2;
                this.mHitSlopTop = px2;
            }
        }
    }

    public Window getWindow() {
        return ContextUtils.getWindow(this.mContext);
    }

    public TouchEventDispatcher getTouchEventDispatcher() {
        LynxContext lynxContext = this.mContext;
        if (lynxContext != null) {
            return lynxContext.getTouchEventDispatcher();
        }
        return null;
    }
}
