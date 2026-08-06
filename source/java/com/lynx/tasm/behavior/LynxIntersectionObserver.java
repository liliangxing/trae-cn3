package com.lynx.tasm.behavior;

import android.graphics.RectF;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.utils.LynxConstants;
import com.lynx.tasm.utils.UnitUtils;
import com.ss.android.deviceregister.base.OaidModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxIntersectionObserver {
    private static final String TAG = "LynxIntersectionObserver";
    private LynxBaseUI mAttachedUI;
    private LynxBaseUI mContainer;
    private float mInitialRatio;
    private boolean mIsCustomEventObserver;
    private WeakReference<LynxIntersectionObserverManager> mManager;
    private float mMarginBottom;
    private float mMarginLeft;
    private float mMarginRight;
    private float mMarginTop;
    private ArrayList<LynxUIObservationTarget> mObservationTargets;
    private boolean mObserveAll;
    private int mObserverId;
    private boolean mRelativeToScreen;
    private LynxBaseUI mRoot;
    private ArrayList<Float> mThresholds;

    public LynxIntersectionObserver(LynxIntersectionObserverManager lynxIntersectionObserverManager, int i, String str, ReadableMap readableMap) {
        this.mManager = new WeakReference<>(lynxIntersectionObserverManager);
        this.mObserverId = i;
        if (LynxConstants.LYNX_DEFAULT_COMPONENT_ID.equals(str)) {
            this.mContainer = this.mManager.get().getContext().getUIBody();
        } else {
            this.mContainer = this.mManager.get().getContext().findLynxUIByComponentId(str);
        }
        this.mThresholds = new ArrayList<>();
        ReadableArray array = readableMap.getArray("thresholds");
        if (array != null) {
            for (int i2 = 0; i2 < array.size(); i2++) {
                this.mThresholds.add(Float.valueOf((float) array.getDouble(i2)));
            }
        } else {
            this.mThresholds.add(Float.valueOf(0.0f));
        }
        this.mInitialRatio = (float) readableMap.getDouble("initialRatio", 0.0d);
        this.mObserveAll = readableMap.getBoolean("observeAll", false);
        this.mObservationTargets = new ArrayList<>();
        this.mIsCustomEventObserver = false;
    }

    public LynxIntersectionObserver(LynxIntersectionObserverManager lynxIntersectionObserverManager, ReadableMap readableMap, LynxBaseUI lynxBaseUI) {
        this(lynxIntersectionObserverManager, -1, LynxConstants.LYNX_DEFAULT_COMPONENT_ID, readableMap);
        this.mAttachedUI = lynxBaseUI;
        String string = readableMap.getString("relativeToIdSelector", (String) null);
        this.mRelativeToScreen = readableMap.getBoolean("relativeToScreen", false);
        this.mMarginLeft = UnitUtils.toPx(readableMap.getString("marginLeft", "0"));
        this.mMarginRight = UnitUtils.toPx(readableMap.getString("marginRight", "0"));
        this.mMarginTop = UnitUtils.toPx(readableMap.getString("marginTop", "0"));
        this.mMarginBottom = UnitUtils.toPx(readableMap.getString("marginBottom", "0"));
        if (string != null && string.startsWith("#")) {
            this.mRoot = this.mManager.get().getContext().getLynxUIOwner().findLynxUIByIdSelectorSearchUp(string.substring(1), this.mAttachedUI);
        }
        this.mIsCustomEventObserver = true;
        LynxUIObservationTarget lynxUIObservationTarget = new LynxUIObservationTarget();
        lynxUIObservationTarget.f0ui = lynxBaseUI;
        this.mObservationTargets.add(lynxUIObservationTarget);
        checkForIntersectionWithTarget(lynxUIObservationTarget, getRootRect(), true);
    }

    public LynxBaseUI getAttachedUI() {
        return this.mAttachedUI;
    }

    public int getObserverId() {
        return this.mObserverId;
    }

    public LynxContext getContext() {
        LynxIntersectionObserverManager lynxIntersectionObserverManager = this.mManager.get();
        if (lynxIntersectionObserverManager == null) {
            LLog.e(TAG, "getContext failed because mManager is null");
            return null;
        }
        return lynxIntersectionObserverManager.getContext();
    }

    private LynxUIOwner getRootUIOwner() {
        LynxContext context = getContext();
        if (context == null) {
            LLog.e(TAG, "getRootUIOwner failed because context is null");
            return null;
        }
        return context.getLynxUIOwner();
    }

    public void relativeTo(String str, ReadableMap readableMap) {
        if (str.startsWith("#")) {
            if (getContext() == null) {
                LLog.e(TAG, "relativeTo failed because context is null");
                this.mRoot = null;
            } else {
                this.mRoot = getContext().findLynxUIByIdSelector(str.substring(1), this.mContainer);
            }
            if (this.mRoot == null) {
                LLog.w(TAG, "Can't find element, finding in element");
                if (getRootUIOwner() == null) {
                    LLog.e(TAG, "relativeTo failed because UIOwner is null");
                } else {
                    this.mRoot = getRootUIOwner().findLynxUIByIdSelector(str.substring(1));
                }
            }
            parseMargin(readableMap);
        }
    }

    public void relativeToViewport(ReadableMap readableMap) {
        this.mRoot = null;
        parseMargin(readableMap);
    }

    public void relativeToScreen(ReadableMap readableMap) {
        this.mRoot = null;
        this.mRelativeToScreen = true;
        parseMargin(readableMap);
    }

    public void observe(String str, int i) {
        LynxBaseUI findLynxUIBySign;
        if (getContext() == null) {
            LLog.e(TAG, "observe failed because context is null");
            return;
        }
        if (str.startsWith("#")) {
            findLynxUIBySign = getContext().findLynxUIByIdSelector(str.substring(1), this.mContainer);
            if (findLynxUIBySign == null) {
                LLog.w(TAG, "Can't find element, finding in element");
                if (getRootUIOwner() == null) {
                    LLog.e(TAG, "observe failed because UIOwner is null");
                } else {
                    findLynxUIBySign = getRootUIOwner().findLynxUIByIdSelector(str.substring(1));
                }
            }
        } else {
            try {
                findLynxUIBySign = getContext().findLynxUIBySign(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                LLog.e(TAG, "observe failed because uid is invalid");
                return;
            }
        }
        if (findLynxUIBySign != null) {
            for (int i2 = 0; i2 < this.mObservationTargets.size(); i2++) {
                if (this.mObservationTargets.get(i2).f0ui == findLynxUIBySign) {
                    return;
                }
            }
            LynxUIObservationTarget lynxUIObservationTarget = new LynxUIObservationTarget();
            lynxUIObservationTarget.f0ui = findLynxUIBySign;
            lynxUIObservationTarget.jsCallbackId = i;
            this.mObservationTargets.add(lynxUIObservationTarget);
            checkForIntersectionWithTarget(lynxUIObservationTarget, getRootRect(), true);
        }
    }

    public void disconnect() {
        this.mObservationTargets.clear();
        this.mManager.get().removeIntersectionObserver(this.mObserverId);
    }

    private void parseMargin(ReadableMap readableMap) {
        this.mMarginLeft = UnitUtils.toPx(readableMap.getString(PropsConstants.HIT_SLOP_LEFT, "0"));
        this.mMarginRight = UnitUtils.toPx(readableMap.getString(PropsConstants.HIT_SLOP_RIGHT, "0"));
        this.mMarginTop = UnitUtils.toPx(readableMap.getString(PropsConstants.HIT_SLOP_TOP, "0"));
        this.mMarginBottom = UnitUtils.toPx(readableMap.getString(PropsConstants.HIT_SLOP_BOTTOM, "0"));
    }

    public void checkForIntersections() {
        if (this.mObservationTargets.size() == 0) {
            return;
        }
        RectF rootRect = getRootRect();
        Iterator<LynxUIObservationTarget> it = this.mObservationTargets.iterator();
        while (it.hasNext()) {
            checkForIntersectionWithTarget(it.next(), rootRect, false);
        }
    }

    private void checkForIntersectionWithTarget(LynxUIObservationTarget lynxUIObservationTarget, RectF rectF, boolean z) {
        LynxIntersectionObserverManager lynxIntersectionObserverManager;
        WeakReference<LynxIntersectionObserverManager> weakReference = this.mManager;
        if (weakReference == null || (lynxIntersectionObserverManager = weakReference.get()) == null) {
            return;
        }
        RectF boundsOnScreenOfLynxBaseUI = lynxIntersectionObserverManager.getBoundsOnScreenOfLynxBaseUI(lynxUIObservationTarget.f0ui);
        RectF computeTargetAndRootIntersection = computeTargetAndRootIntersection(lynxUIObservationTarget.f0ui, boundsOnScreenOfLynxBaseUI, rectF);
        IntersectionObserverEntry intersectionObserverEntry = new IntersectionObserverEntry();
        boolean z2 = true;
        if (computeTargetAndRootIntersection != null && !computeTargetAndRootIntersection.isEmpty()) {
            intersectionObserverEntry.isIntersecting = true;
        }
        intersectionObserverEntry.boundingClientRect = boundsOnScreenOfLynxBaseUI;
        intersectionObserverEntry.relativeRect = rectF;
        intersectionObserverEntry.intersectionRect = computeTargetAndRootIntersection;
        intersectionObserverEntry.time = 0.0d;
        intersectionObserverEntry.relativeToId = (lynxUIObservationTarget.f0ui == null || lynxUIObservationTarget.f0ui.getIdSelector() == null) ? "" : lynxUIObservationTarget.f0ui.getIdSelector();
        intersectionObserverEntry.update();
        IntersectionObserverEntry intersectionObserverEntry2 = lynxUIObservationTarget.entry;
        lynxUIObservationTarget.entry = intersectionObserverEntry;
        int i = lynxUIObservationTarget.jsCallbackId;
        if (!z) {
            z2 = hasCrossedThreshold(intersectionObserverEntry2, intersectionObserverEntry);
        } else if (this.mInitialRatio >= intersectionObserverEntry.intersectionRatio) {
            z2 = false;
        }
        if (z2) {
            if (this.mIsCustomEventObserver) {
                lynxIntersectionObserverManager.sendIntersectionObserverEvent(this.mAttachedUI.getSign(), intersectionObserverEntry.toDictionary());
            } else {
                lynxIntersectionObserverManager.callIntersectionObserver(this.mObserverId, i, intersectionObserverEntry.toDictionary());
            }
        }
    }

    private boolean hasCrossedThreshold(IntersectionObserverEntry intersectionObserverEntry, IntersectionObserverEntry intersectionObserverEntry2) {
        float f = (intersectionObserverEntry == null || intersectionObserverEntry.intersectionRect == null) ? -1.0f : intersectionObserverEntry.intersectionRatio;
        float f2 = intersectionObserverEntry2.intersectionRect != null ? intersectionObserverEntry2.intersectionRatio : -1.0f;
        if (f == f2) {
            return false;
        }
        Iterator<Float> it = this.mThresholds.iterator();
        while (it.hasNext()) {
            float floatValue = it.next().floatValue();
            if (floatValue != f && floatValue != f2) {
                if ((floatValue < f) != (floatValue < f2)) {
                }
            }
            return true;
        }
        return false;
    }

    private RectF computeTargetAndRootIntersection(LynxBaseUI lynxBaseUI, RectF rectF, RectF rectF2) {
        LynxIntersectionObserverManager lynxIntersectionObserverManager;
        boolean z;
        RectF rectF3;
        if (!lynxBaseUI.isVisible() || (lynxIntersectionObserverManager = this.mManager.get()) == null) {
            return null;
        }
        LynxBaseUI lynxBaseUI2 = (LynxBaseUI) lynxBaseUI.getParent();
        LynxBaseUI lynxBaseUI3 = this.mRoot;
        boolean z2 = false;
        if (lynxBaseUI3 == null) {
            if (lynxIntersectionObserverManager.getContext() == null || lynxIntersectionObserverManager.getContext().getLynxUIOwner() == null) {
                LLog.e(TAG, "Get UI error");
            } else {
                lynxBaseUI3 = lynxIntersectionObserverManager.getContext().getLynxUIOwner().getRootUI();
            }
        }
        RectF rectF4 = rectF;
        while (!z2 && lynxBaseUI2 != null) {
            if (!lynxBaseUI2.isVisible()) {
                return null;
            }
            if (lynxBaseUI2 == lynxBaseUI3) {
                z = true;
                rectF3 = this.mRelativeToScreen ? lynxIntersectionObserverManager.getBoundsOnScreenOfLynxBaseUI(lynxBaseUI2) : rectF2;
            } else if (lynxBaseUI2.getOverflow() == 0) {
                z = z2;
                rectF3 = lynxIntersectionObserverManager.getBoundsOnScreenOfLynxBaseUI(lynxBaseUI2);
            } else {
                z = z2;
                rectF3 = null;
            }
            if (rectF3 != null) {
                rectF4 = rectF3.intersects(rectF4.left, rectF4.top, rectF4.right, rectF4.bottom) ? new RectF(Math.max(rectF3.left, rectF4.left), Math.max(rectF3.top, rectF4.top), Math.min(rectF3.right, rectF4.right), Math.min(rectF3.bottom, rectF4.bottom)) : null;
            }
            if (rectF4 == null) {
                break;
            }
            lynxBaseUI2 = (LynxBaseUI) lynxBaseUI2.getParent();
            z2 = z;
        }
        if (this.mRelativeToScreen) {
            RectF boundsOnScreenOfLynxBaseUI = lynxIntersectionObserverManager.getBoundsOnScreenOfLynxBaseUI(lynxIntersectionObserverManager.getContext().getLynxUIOwner().getRootUI());
            rectF.offset(boundsOnScreenOfLynxBaseUI.left, boundsOnScreenOfLynxBaseUI.top);
            if (rectF4 != null) {
                rectF4.offset(boundsOnScreenOfLynxBaseUI.left, boundsOnScreenOfLynxBaseUI.top);
                if (!rectF4.intersect(rectF2)) {
                    return null;
                }
            }
        }
        return rectF4;
    }

    private RectF getRootRect() {
        RectF boundsOnScreenOfLynxBaseUI;
        RectF rectF = new RectF();
        LynxIntersectionObserverManager lynxIntersectionObserverManager = this.mManager.get();
        if (lynxIntersectionObserverManager == null) {
            return rectF;
        }
        LynxBaseUI lynxBaseUI = this.mRoot;
        if (lynxBaseUI != null) {
            boundsOnScreenOfLynxBaseUI = lynxIntersectionObserverManager.getBoundsOnScreenOfLynxBaseUI(lynxBaseUI);
        } else if (this.mRelativeToScreen) {
            boundsOnScreenOfLynxBaseUI = lynxIntersectionObserverManager.getWindowRect(getContext());
        } else {
            boundsOnScreenOfLynxBaseUI = lynxIntersectionObserverManager.getBoundsOnScreenOfLynxBaseUI(lynxIntersectionObserverManager.getContext().getUIBody());
        }
        boundsOnScreenOfLynxBaseUI.left -= this.mMarginLeft;
        boundsOnScreenOfLynxBaseUI.right += this.mMarginRight;
        boundsOnScreenOfLynxBaseUI.top -= this.mMarginTop;
        boundsOnScreenOfLynxBaseUI.bottom += this.mMarginBottom;
        return boundsOnScreenOfLynxBaseUI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class LynxUIObservationTarget {
        public IntersectionObserverEntry entry;
        public int jsCallbackId;

        /* renamed from: ui */
        public LynxBaseUI f0ui;

        private LynxUIObservationTarget() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class IntersectionObserverEntry {
        public RectF boundingClientRect;
        public float intersectionRatio;
        public RectF intersectionRect;
        public boolean isIntersecting;
        public RectF relativeRect;
        public String relativeToId;
        public double time;

        private IntersectionObserverEntry() {
        }

        public void update() {
            if (this.intersectionRect == null) {
                this.intersectionRatio = 0.0f;
                return;
            }
            float width = this.boundingClientRect.width() * this.boundingClientRect.height();
            float width2 = this.intersectionRect.width() * this.intersectionRect.height();
            if (width > 0.0f) {
                this.intersectionRatio = width2 / width;
            } else {
                this.intersectionRatio = 0.0f;
            }
        }

        public JavaOnlyMap toDictionary() {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.putMap("relativeRect", rectToDictionary(this.relativeRect));
            javaOnlyMap.putMap("boundingClientRect", rectToDictionary(this.boundingClientRect));
            javaOnlyMap.putMap("intersectionRect", rectToDictionary(this.intersectionRect));
            javaOnlyMap.putDouble("intersectionRatio", this.intersectionRatio);
            javaOnlyMap.putBoolean("isIntersecting", this.isIntersecting);
            javaOnlyMap.putDouble(OaidModel.KEY_TIME, this.time);
            javaOnlyMap.putString("observerId", this.relativeToId);
            return javaOnlyMap;
        }

        private JavaOnlyMap rectToDictionary(RectF rectF) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            if (rectF != null) {
                javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_LEFT, rectF.left);
                javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_RIGHT, rectF.right);
                javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_TOP, rectF.top);
                javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_BOTTOM, rectF.bottom);
            } else {
                javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_LEFT, 0.0d);
                javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_RIGHT, 0.0d);
                javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_TOP, 0.0d);
                javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_BOTTOM, 0.0d);
            }
            return javaOnlyMap;
        }
    }
}
