package com.lynx.tasm.behavior.p000ui;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.p000ui.IDrawChildHook;
import com.lynx.tasm.behavior.p000ui.UIBody;
import com.lynx.tasm.behavior.p000ui.ViewInfo;
import com.lynx.tasm.behavior.p000ui.image.FlattenUIImage;
import com.lynx.tasm.behavior.p000ui.list.UIList;
import com.lynx.tasm.behavior.p000ui.text.FlattenUIText;
import com.lynx.tasm.behavior.p000ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.p000ui.view.AndroidView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class UIGroup<T extends ViewGroup> extends LynxUI<T> implements UIParent, IDrawChildHook {
    private static final String TAG = "UIGroup";
    private int mCurrentDrawIndex;
    private LynxBaseUI mCurrentDrawUI;
    private ViewGroupDrawingOrderHelper mDrawingOrderHelper;
    private boolean mIsInsertViewCalled;
    private Rect mOverflowClipRect;
    private static WeakHashMap<View, Integer> mZIndexHash = new WeakHashMap<>();
    private static final float[] mEventCoords = new float[2];
    private static final PointF mTempPoint = new PointF();
    private static final float[] mMatrixTransformCoords = new float[2];
    private static final Matrix mInverseMatrix = new Matrix();

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public void afterDraw(Canvas canvas) {
    }

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public void afterDrawChild(Canvas canvas, View view, long j) {
    }

    public boolean enableAutoClipRadius() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.p000ui.UIParent
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return null;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.p000ui.UIParent
    public boolean needCustomLayout() {
        return false;
    }

    public boolean isInsertViewCalled() {
        return this.mIsInsertViewCalled;
    }

    public UIGroup(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public UIGroup(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
        this.mCurrentDrawIndex = 0;
        this.mCurrentDrawUI = this.mDrawHead;
        this.mOverflowClipRect = new Rect();
        this.mIsInsertViewCalled = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void initialize() {
        super.initialize();
        this.mDrawingOrderHelper = new ViewGroupDrawingOrderHelper((ViewGroup) getView());
        if (this.mView instanceof IDrawChildHook.IDrawChildHookBinding) {
            ((IDrawChildHook.IDrawChildHookBinding) this.mView).bindDrawChildHook(this);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void markDetachWithViewRecursively(boolean z) {
        if (z) {
            this.mViewInfo = new ViewInfo(this, this.mView);
            this.mViewInfo.markNeedGenerateMeaningfulPaintingArea(needGenerateMeaningfulPaintingArea());
            if (this.mView instanceof IDrawChildHook.IDrawChildHookBinding) {
                ((IDrawChildHook.IDrawChildHookBinding) this.mView).bindDrawChildHook(this.mViewInfo);
            }
        }
        super.markDetachWithViewRecursively(z);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.IProcessViewInfoHook
    public void beforeProcessViewInfo(ViewInfo viewInfo) {
        super.beforeProcessViewInfo(viewInfo);
        ViewGroupDrawingOrderHelper viewGroupDrawingOrderHelper = this.mDrawingOrderHelper;
        if (viewGroupDrawingOrderHelper != null) {
            viewGroupDrawingOrderHelper.prepareChildDrawingOrder();
            viewInfo.setDrawingOrder(this.mDrawingOrderHelper.getDrawingOrderIndices());
        }
        viewInfo.setHasOverlappingRendering(hasOverlappingRendering());
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.IProcessViewInfoHook
    public void beforeDispatchProcessViewInfo(ViewInfo viewInfo) {
        super.beforeDispatchProcessViewInfo(viewInfo);
        this.mCurrentDrawUI = this.mDrawHead;
        this.mCurrentDrawIndex = 0;
        viewInfo.clearSubDrawInfo();
        boolean z = getClipToRadius() || (this.mContext.getDefaultOverflowVisible() && this.mOverflow == 0 && enableAutoClipRadius());
        viewInfo.setClipToRadius(z);
        if (z) {
            BackgroundDrawable drawable = getLynxBackground() != null ? getLynxBackground().getDrawable() : null;
            Path innerClipPathForBorderRadius = drawable != null ? drawable.getInnerClipPathForBorderRadius() : null;
            boolean z2 = (getSkewX() == 0.0f && getSkewY() == 0.0f) ? false : true;
            if (innerClipPathForBorderRadius != null) {
                viewInfo.setClipPathInBeforeDispatchDraw(innerClipPathForBorderRadius);
                viewInfo.setClipRectInBeforeDispatchDraw(null);
            } else if (z2) {
                viewInfo.setClipPathInBeforeDispatchDraw(null);
                viewInfo.setClipRectInBeforeDispatchDraw(getClipBounds());
            } else {
                viewInfo.setClipPathInBeforeDispatchDraw(null);
                viewInfo.setClipRectInBeforeDispatchDraw(null);
            }
        }
        viewInfo.setOverflowClipRect(null);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.IProcessViewInfoHook
    public void beforeProcessChildViewInfo(ViewInfo viewInfo, View view, long j) {
        super.beforeProcessChildViewInfo(viewInfo, view, j);
        LynxBaseUI lynxBaseUI = this.mCurrentDrawUI;
        while (lynxBaseUI != null) {
            if (!lynxBaseUI.isFlatten()) {
                LynxUI lynxUI = (LynxUI) lynxBaseUI;
                if (lynxUI.getView() == view) {
                    this.mCurrentDrawUI = lynxBaseUI.mNextDrawUI;
                    ViewInfo.SubDrawInfo subDrawInfo = new ViewInfo.SubDrawInfo(true, lynxBaseUI.getBound(), null, null, lynxUI.mViewInfo, lynxUI.getView());
                    subDrawInfo.markNeedGenerateMeaningfulPaintingArea(lynxBaseUI.needGenerateMeaningfulPaintingArea());
                    viewInfo.addSubDrawInfo(this.mCurrentDrawIndex, subDrawInfo);
                    subDrawInfo.recordSubView(lynxBaseUI, view);
                    this.mCurrentDrawIndex++;
                    return;
                }
            } else if (lynxBaseUI.isFlatten()) {
                ViewInfo.SubDrawInfo subDrawInfo2 = new ViewInfo.SubDrawInfo(false, lynxBaseUI.getBound(), null, lynxBaseUI.getLynxBackground());
                subDrawInfo2.setFlattenUIInfo(lynxBaseUI.getLeft(), lynxBaseUI.getTop(), lynxBaseUI.getWidth(), lynxBaseUI.getHeight(), lynxBaseUI.getPaddingLeft(), lynxBaseUI.getPaddingTop(), lynxBaseUI.getPaddingRight(), lynxBaseUI.getPaddingBottom(), ((LynxFlattenUI) lynxBaseUI).getAlpha());
                subDrawInfo2.markNeedGenerateMeaningfulPaintingArea(lynxBaseUI.needGenerateMeaningfulPaintingArea());
                tryAddInfoForSubDraw(subDrawInfo2, lynxBaseUI);
                viewInfo.addSubDrawInfo(this.mCurrentDrawIndex, subDrawInfo2);
            }
            lynxBaseUI = lynxBaseUI.mNextDrawUI;
            this.mCurrentDrawIndex++;
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.IProcessViewInfoHook
    public void afterDispatchProcessViewInfo(ViewInfo viewInfo) {
        super.afterDispatchProcessViewInfo(viewInfo);
        LynxBaseUI lynxBaseUI = this.mCurrentDrawUI;
        while (lynxBaseUI != null) {
            if (lynxBaseUI.isFlatten() && !(lynxBaseUI instanceof UIShadowProxy)) {
                ViewInfo.SubDrawInfo subDrawInfo = new ViewInfo.SubDrawInfo(false, lynxBaseUI.getBound(), null, lynxBaseUI.getLynxBackground());
                subDrawInfo.setFlattenUIInfo(lynxBaseUI.getLeft(), lynxBaseUI.getTop(), lynxBaseUI.getWidth(), lynxBaseUI.getHeight(), lynxBaseUI.getPaddingLeft(), lynxBaseUI.getPaddingTop(), lynxBaseUI.getPaddingRight(), lynxBaseUI.getPaddingBottom(), ((LynxFlattenUI) lynxBaseUI).getAlpha());
                subDrawInfo.markNeedGenerateMeaningfulPaintingArea(lynxBaseUI.needGenerateMeaningfulPaintingArea());
                tryAddInfoForSubDraw(subDrawInfo, lynxBaseUI);
                viewInfo.addSubDrawInfo(this.mCurrentDrawIndex, subDrawInfo);
            }
            lynxBaseUI = lynxBaseUI.mNextDrawUI;
            this.mCurrentDrawIndex++;
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.IProcessViewInfoHook
    public void processLayoutChildren() {
        performLayoutChildrenUI();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.IProcessViewInfoHook
    public void processMeasureChildren() {
        performMeasureChildrenUI();
    }

    private void tryAddInfoForSubDraw(ViewInfo.SubDrawInfo subDrawInfo, LynxBaseUI lynxBaseUI) {
        if (lynxBaseUI instanceof FlattenUIImage) {
            subDrawInfo.setImageManager(((FlattenUIImage) lynxBaseUI).getLynxImageManagerForViewInfo());
        }
        if (lynxBaseUI instanceof FlattenUIText) {
            FlattenUIText flattenUIText = (FlattenUIText) lynxBaseUI;
            subDrawInfo.setTextLayout(flattenUIText.getTextLayout());
            subDrawInfo.setDrawOffset(flattenUIText.getDrawOffsetLeft(), flattenUIText.getDrawOffsetTop());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getRealParentView() {
        return this.mView;
    }

    public void onInsertChild(LynxBaseUI lynxBaseUI, int i) {
        lynxBaseUI.setOffsetDescendantRectToLynxView(getOffsetDescendantRectToLynxView());
        this.mChildren.add(i, lynxBaseUI);
        lynxBaseUI.setParent(this);
    }

    public void insertChildWhenRebuildView(LynxBaseUI lynxBaseUI) {
        if (lynxBaseUI instanceof LynxUI) {
            int i = 0;
            for (LynxBaseUI lynxBaseUI2 = this.mDrawHead; lynxBaseUI2 != null && lynxBaseUI != lynxBaseUI2; lynxBaseUI2 = lynxBaseUI2.mNextDrawUI) {
                if (lynxBaseUI2 instanceof LynxUI) {
                    i++;
                }
            }
            View view = ((LynxUI) lynxBaseUI).getView();
            if (view.getParent() != null) {
                if (view.getParent() == this.mView) {
                    view.requestLayout();
                    return;
                }
                ((ViewGroup) view.getParent()).removeView(view);
            }
            ((ViewGroup) this.mView).addView(view, i);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void insertChild(LynxBaseUI lynxBaseUI, int i) {
        onInsertChild(lynxBaseUI, i);
        this.mIsInsertViewCalled = true;
    }

    public void insertView(LynxUI lynxUI) {
        if (this.mContext != null && this.mContext.isFallbackProcess() && lynxUI.getView().getParent() == getView()) {
            lynxUI.getView().requestLayout();
            return;
        }
        int i = -1;
        for (LynxBaseUI lynxBaseUI = this.mDrawHead; lynxBaseUI != null; lynxBaseUI = lynxBaseUI.mNextDrawUI) {
            if (lynxBaseUI instanceof LynxUI) {
                i++;
            }
            if (lynxBaseUI == lynxUI) {
                break;
            }
        }
        if (lynxUI.mView.getParent() != null && (lynxUI.mView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) lynxUI.mView.getParent()).removeView(lynxUI.mView);
            onRemoveChildUI(lynxUI);
        }
        ((ViewGroup) this.mView).addView(lynxUI.mView, i);
        onAddChildUI(lynxUI, i);
    }

    public boolean onRemoveChild(LynxBaseUI lynxBaseUI) {
        if (!this.mChildren.remove(lynxBaseUI)) {
            return false;
        }
        lynxBaseUI.setParent(null);
        return true;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void removeChild(LynxBaseUI lynxBaseUI) {
        if (onRemoveChild(lynxBaseUI)) {
            removeView(lynxBaseUI);
        }
    }

    public void removeView(LynxBaseUI lynxBaseUI) {
        if (lynxBaseUI instanceof LynxUI) {
            LynxUI lynxUI = (LynxUI) lynxBaseUI;
            ((ViewGroup) this.mView).removeView(lynxUI.mView);
            if (lynxBaseUI instanceof UIList) {
                ((ViewGroup) this.mView).removeView(((UIList) lynxBaseUI).getContainer());
            }
            onRemoveChildUI(lynxUI);
            return;
        }
        invalidate();
    }

    public void removeAll() {
        for (LynxBaseUI lynxBaseUI = this.mDrawHead; lynxBaseUI != null; lynxBaseUI = lynxBaseUI.mNextDrawUI) {
            lynxBaseUI.setDrawParent(null);
        }
        this.mDrawHead = null;
        Iterator<LynxBaseUI> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().setParent(null);
        }
        this.mChildren.clear();
        if (this.mView != 0) {
            ((ViewGroup) this.mView).removeAllViews();
        }
    }

    public void measureChildren() {
        Iterator<LynxBaseUI> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().measure();
        }
    }

    public void layoutChildren() {
        for (int i = 0; i < this.mChildren.size(); i++) {
            LynxBaseUI lynxBaseUI = this.mChildren.get(i);
            if (!needCustomLayout()) {
                if (!lynxBaseUI.isFlatten()) {
                    ((LynxUI) lynxBaseUI).layout();
                } else {
                    ((LynxFlattenUI) lynxBaseUI).layout(lynxBaseUI.getOriginLeft(), lynxBaseUI.getOriginTop(), null);
                }
            } else if (lynxBaseUI instanceof UIGroup) {
                ((UIGroup) lynxBaseUI).layoutChildren();
            }
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void measure() {
        if (((ViewGroup) this.mView).isLayoutRequested()) {
            measureChildren();
            super.measure();
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void layout() {
        if (((ViewGroup) this.mView).isLayoutRequested()) {
            super.layout();
            layoutChildren();
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public void beforeDispatchDraw(Canvas canvas) {
        this.mCurrentDrawUI = this.mDrawHead;
        this.mCurrentDrawIndex = 0;
        boolean z = (getSkewX() == 0.0f && getSkewY() == 0.0f) ? false : true;
        if (getClipToRadius() || (this.mContext.getDefaultOverflowVisible() && this.mOverflow == 0 && enableAutoClipRadius())) {
            BackgroundDrawable drawable = getLynxBackground() != null ? getLynxBackground().getDrawable() : null;
            if (drawable == null || !(drawable instanceof BackgroundDrawable)) {
                return;
            }
            Path innerClipPathForBorderRadius = drawable.getInnerClipPathForBorderRadius();
            if (innerClipPathForBorderRadius != null) {
                canvas.clipPath(innerClipPathForBorderRadius);
            } else if (z) {
                canvas.clipRect(getClipBounds());
            }
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public void afterDispatchDraw(Canvas canvas) {
        for (LynxBaseUI lynxBaseUI = this.mCurrentDrawUI; lynxBaseUI != null; lynxBaseUI = lynxBaseUI.mNextDrawUI) {
            if (lynxBaseUI.isFlatten() && !(lynxBaseUI instanceof UIShadowProxy)) {
                drawChild((LynxFlattenUI) lynxBaseUI, canvas);
            }
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public void beforeDraw(Canvas canvas) {
        Path path;
        if (getSkewX() != 0.0f || getSkewY() != 0.0f) {
            canvas.skew(getSkewX(), getSkewY());
            canvas.translate((-((ViewGroup) this.mView).getPivotY()) * getSkewX(), (-((ViewGroup) this.mView).getPivotX()) * getSkewY());
        }
        if (this.mClipPath == null || (path = this.mClipPath.getPath(getWidth(), getHeight())) == null) {
            return;
        }
        canvas.clipPath(path);
    }

    private Rect drawFlattenUIBefore(Canvas canvas, View view, long j) {
        for (LynxBaseUI lynxBaseUI = this.mCurrentDrawUI; lynxBaseUI != null; lynxBaseUI = lynxBaseUI.mNextDrawUI) {
            if (!lynxBaseUI.isFlatten()) {
                if (((LynxUI) lynxBaseUI).getView() == view) {
                    Rect bound = lynxBaseUI.getBound();
                    this.mCurrentDrawUI = lynxBaseUI.mNextDrawUI;
                    return bound;
                }
            } else if (lynxBaseUI.isFlatten()) {
                drawChild((LynxFlattenUI) lynxBaseUI, canvas);
            }
        }
        return null;
    }

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public Rect beforeDrawChild(Canvas canvas, View view, long j) {
        return drawFlattenUIBefore(canvas, view, j);
    }

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public int getChildDrawingOrder(int i, int i2) {
        ViewGroupDrawingOrderHelper viewGroupDrawingOrderHelper = this.mDrawingOrderHelper;
        return viewGroupDrawingOrderHelper != null ? viewGroupDrawingOrderHelper.getChildDrawingOrder(i, i2) : i2;
    }

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public boolean hasOverlappingRendering() {
        return hasOverlappingRenderingEnabled();
    }

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public void performLayoutChildrenUI() {
        layoutChildren();
    }

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public void performMeasureChildrenUI() {
        measureChildren();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawChild(LynxFlattenUI lynxFlattenUI, Canvas canvas) {
        Rect bound = lynxFlattenUI.getBound();
        canvas.save();
        if (bound != null) {
            canvas.clipRect(bound);
        }
        lynxFlattenUI.innerDraw(canvas);
        canvas.restore();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        Iterator<LynxBaseUI> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onAttach() {
        super.onAttach();
        dispatchOnAttach();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onDetach() {
        super.onDetach();
        dispatchOnDetach();
    }

    public void dispatchOnAttach() {
        Iterator<LynxBaseUI> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().onAttach();
        }
    }

    public void dispatchOnDetach() {
        Iterator<LynxBaseUI> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().onDetach();
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public int getIndex(LynxBaseUI lynxBaseUI) {
        return this.mChildren.indexOf(lynxBaseUI);
    }

    public int getChildCount() {
        return this.mChildren.size();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public LynxBaseUI getChildAt(int i) {
        return this.mChildren.get(i);
    }

    public EventTarget findUIWithCustomLayout(float f, float f2, UIGroup uIGroup) {
        HashMap hashMap = new HashMap();
        for (int childCount = uIGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            LynxBaseUI childAt = uIGroup.getChildAt(childCount);
            if (childAt instanceof UIShadowProxy) {
                childAt = ((UIShadowProxy) childAt).getChild();
            }
            if (childAt instanceof LynxUI) {
                LynxUI lynxUI = (LynxUI) childAt;
                hashMap.put(lynxUI.getView(), lynxUI);
            } else {
                LLog.DTHROW(new RuntimeException("ui that need custom layout should not have flatten child!"));
            }
        }
        return findUIWithCustomLayoutByChildren(f, f2, uIGroup, hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected EventTarget findUIWithCustomLayoutByChildren(float f, float f2, UIGroup uIGroup, Map<View, LynxUI> map) {
        float[] fArr = {f, f2};
        LynxUI findTouchTargetOnViewChian = findTouchTargetOnViewChian(fArr, (ViewGroup) uIGroup.getView(), map);
        if (findTouchTargetOnViewChian == null) {
            return uIGroup;
        }
        if (findTouchTargetOnViewChian.needCustomLayout() && (findTouchTargetOnViewChian instanceof UIGroup)) {
            UIGroup uIGroup2 = (UIGroup) findTouchTargetOnViewChian;
            return uIGroup2.findUIWithCustomLayout(fArr[0], fArr[1], uIGroup2);
        }
        if (this.mContext.getEnableEventRefactor()) {
            return findTouchTargetOnViewChian.hitTest(fArr[0], fArr[1]);
        }
        return findTouchTargetOnViewChian.hitTest(fArr[0] + findTouchTargetOnViewChian.getScrollX(), fArr[1] + findTouchTargetOnViewChian.getScrollY());
    }

    private LynxUI findTouchTargetOnViewChian(float[] fArr, ViewGroup viewGroup, Map<View, LynxUI> map) {
        LynxUI lynxUI = null;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (this.mContext.getEnableEventRefactor()) {
                float[] fArr2 = new float[2];
                if (isTransformedTouchPointInView(fArr, viewGroup, childAt, fArr2)) {
                    if (map.containsKey(childAt)) {
                        lynxUI = map.get(childAt);
                        fArr[0] = fArr2[0];
                        fArr[1] = fArr2[1];
                    } else if ((childAt instanceof ViewGroup) && (lynxUI = findTouchTargetOnViewChian(fArr2, (ViewGroup) childAt, map)) != null) {
                        fArr[0] = fArr2[0];
                        fArr[1] = fArr2[1];
                    }
                    if (lynxUI != null) {
                        return lynxUI;
                    }
                } else {
                    continue;
                }
            } else {
                PointF pointF = mTempPoint;
                if (isTransformedTouchPointInView(fArr[0], fArr[1], viewGroup, childAt, pointF)) {
                    float f = fArr[0];
                    float f2 = fArr[1];
                    fArr[0] = pointF.x;
                    fArr[1] = pointF.y;
                    if (map.containsKey(childAt)) {
                        lynxUI = map.get(childAt);
                    } else if (childAt instanceof ViewGroup) {
                        lynxUI = findTouchTargetOnViewChian(fArr, (ViewGroup) childAt, map);
                    }
                    if (lynxUI != null) {
                        return lynxUI;
                    }
                    fArr[0] = f;
                    fArr[1] = f2;
                } else {
                    continue;
                }
            }
        }
        return lynxUI;
    }

    private boolean isTransformedTouchPointInView(float[] fArr, View view, View view2, float[] fArr2) {
        float[] targetPoint = getTargetPoint(fArr[0], fArr[1], view.getScrollX(), view.getScrollY(), view2, view2.getMatrix());
        float f = targetPoint[0];
        fArr2[0] = f;
        fArr2[1] = targetPoint[1];
        if (f >= 0.0f && f < view2.getRight() - view2.getLeft()) {
            float f2 = fArr2[1];
            if (f2 >= 0.0f && f2 < view2.getBottom() - view2.getTop()) {
                return true;
            }
        }
        return false;
    }

    private boolean isTransformedTouchPointInView(float f, float f2, ViewGroup viewGroup, View view, PointF pointF) {
        float scrollX = (f + viewGroup.getScrollX()) - view.getLeft();
        float scrollY = (f2 + viewGroup.getScrollY()) - view.getTop();
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            float[] fArr = mMatrixTransformCoords;
            fArr[0] = scrollX;
            fArr[1] = scrollY;
            Matrix matrix2 = mInverseMatrix;
            matrix.invert(matrix2);
            matrix2.mapPoints(fArr);
            scrollX = fArr[0];
            scrollY = fArr[1];
        }
        if (scrollX < 0.0f || scrollX >= view.getRight() - view.getLeft() || scrollY < 0.0f || scrollY >= view.getBottom() - view.getTop()) {
            return false;
        }
        pointF.set(scrollX, scrollY);
        return true;
    }

    private void onAddChildUI(LynxUI lynxUI, int i) {
        if (ENABLE_ZINDEX) {
            this.mDrawingOrderHelper.handleAddView(lynxUI.getView());
            setChildrenDrawingOrderEnabledHelper(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
        }
    }

    private void onRemoveChildUI(LynxUI lynxUI) {
        if (ENABLE_ZINDEX) {
            this.mDrawingOrderHelper.handleRemoveView(lynxUI.getView());
            setChildrenDrawingOrderEnabledHelper(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
        }
    }

    public static void setViewZIndex(View view, int i) {
        mZIndexHash.put(view, Integer.valueOf(i));
    }

    public static Integer getViewZIndex(View view) {
        return mZIndexHash.get(view);
    }

    public void updateDrawingOrder() {
        this.mDrawingOrderHelper.update();
        setChildrenDrawingOrderEnabledHelper(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
        invalidate();
    }

    public View getAccessibilityHostView() {
        return this.mView;
    }

    private void setChildrenDrawingOrderEnabledHelper(boolean z) {
        if (this.mView instanceof AndroidView) {
            ((AndroidView) this.mView).setChildrenDrawingOrderEnabled(z);
        } else if (this.mView instanceof UIBody.UIBodyView) {
            ((UIBody.UIBodyView) this.mView).setChildrenDrawingOrderEnabled(z);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
    }
}
