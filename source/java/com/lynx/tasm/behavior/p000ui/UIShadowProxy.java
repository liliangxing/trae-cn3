package com.lynx.tasm.behavior.p000ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.animation.layout.LayoutAnimationManager;
import com.lynx.tasm.animation.transition.TransitionAnimationManager;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.utils.BorderRadius;
import com.lynx.tasm.behavior.p000ui.utils.BorderStyle;
import com.lynx.tasm.behavior.p000ui.utils.TransformProps;
import com.lynx.tasm.behavior.p000ui.view.AndroidView;
import com.lynx.tasm.utils.FloatUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIShadowProxy extends UIGroup<ShadowView> {
    private static final String TAG = "UIShadowProxy";
    private List<ShadowData> mBoxShadowList;
    private LynxBaseUI mChild;
    private Matrix mMatrix;
    private boolean mNeedUpdateShadow;
    private Outline mOutline;
    private TransformProps mTransform;
    private Boolean mTransformToUpdate;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public Rect getBoundRectForOverflow() {
        return null;
    }

    public boolean isNeedUpdateShadow() {
        return this.mNeedUpdateShadow;
    }

    public void setNeedUpdateShadow(boolean z) {
        this.mNeedUpdateShadow = z;
    }

    public UIShadowProxy(LynxContext lynxContext, LynxBaseUI lynxBaseUI) {
        super(lynxContext);
        this.mMatrix = new Matrix();
        this.mNeedUpdateShadow = false;
        this.mOverflow = 3;
        this.mChild = lynxBaseUI;
        lynxBaseUI.setParent(this);
        setSign(lynxBaseUI.getSign(), lynxBaseUI.getTagName());
        initialize();
        onInsertChild(lynxBaseUI, 0);
        super.insertDrawList(null, this.mChild);
        super.insertView((LynxUI) this.mChild);
        updateTransform();
        setVisibilityForView(this.mChild.getVisibility() ? 0 : 4);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public String getTagName() {
        LynxBaseUI lynxBaseUI = this.mChild;
        if (lynxBaseUI != null) {
            return lynxBaseUI.getTagName();
        }
        return null;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public String getIdSelector() {
        LynxBaseUI lynxBaseUI = this.mChild;
        if (lynxBaseUI != null) {
            return lynxBaseUI.getIdSelector();
        }
        return null;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public String getRefIdSelector() {
        LynxBaseUI lynxBaseUI = this.mChild;
        if (lynxBaseUI != null) {
            return lynxBaseUI.getRefIdSelector();
        }
        return null;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public void insertDrawList(LynxBaseUI lynxBaseUI, LynxBaseUI lynxBaseUI2) {
        ((LynxUI) this.mChild).insertDrawList(lynxBaseUI, lynxBaseUI2);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float f, float f2) {
        return hitTest(f, f2, false);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float f, float f2, boolean z) {
        LynxBaseUI lynxBaseUI = this.mChild;
        if (lynxBaseUI == null) {
            return null;
        }
        return lynxBaseUI.hitTest(f, f2, z);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public boolean containsPoint(float f, float f2) {
        return containsPoint(f, f2, false);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public boolean containsPoint(float f, float f2, boolean z) {
        LynxBaseUI lynxBaseUI = this.mChild;
        if (lynxBaseUI == null) {
            return false;
        }
        return lynxBaseUI.containsPoint(f, f2, z);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean childrenContainPoint(float f, float f2) {
        LynxBaseUI lynxBaseUI = this.mChild;
        if (lynxBaseUI == null) {
            return false;
        }
        return lynxBaseUI.childrenContainPoint(f, f2);
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup
    public void insertView(LynxUI lynxUI) {
        ((UIGroup) this.mChild).insertView(lynxUI);
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup
    public boolean isInsertViewCalled() {
        LynxBaseUI lynxBaseUI = this.mChild;
        if (lynxBaseUI instanceof UIGroup) {
            return ((UIGroup) lynxBaseUI).isInsertViewCalled();
        }
        return super.isInsertViewCalled();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean isFlatten() {
        return this.mChild.isFlatten();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public List<LynxBaseUI> getChildren() {
        return this.mChild.getChildren();
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public LynxBaseUI getChildAt(int i) {
        return this.mChild.mChildren.get(i);
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup
    public int getChildCount() {
        LynxBaseUI lynxBaseUI = this.mChild;
        if (lynxBaseUI instanceof UIGroup) {
            return ((UIGroup) lynxBaseUI).getChildCount();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public void initAccessibilityDelegate() {
        super.initAccessibilityDelegate();
        ViewCompat.setImportantForAccessibility(this.mView, 1);
    }

    public LynxBaseUI getChild() {
        return this.mChild;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public ShadowView createView(Context context) {
        return new ShadowView(this, context);
    }

    public void setOutlineStyle(BorderStyle borderStyle) {
        getOrCreateOutline().mStyle = borderStyle;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setOutlineColor(int i) {
        getOrCreateOutline().mColor = Integer.valueOf(i);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setOutlineWidth(float f) {
        getOrCreateOutline().mWidth = f;
    }

    private Outline getOrCreateOutline() {
        if (this.mOutline == null) {
            this.mOutline = new Outline();
            if (this.mView != 0) {
                ((ShadowView) this.mView).updateOutlineDrawer(this.mOutline);
            }
        }
        return this.mOutline;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void updateLayout(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, Rect rect) {
        this.mChild.updateLayout(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, rect);
        onLayoutUpdated();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onLayoutUpdated() {
        setNeedUpdateShadow(true);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void updateSticky(float[] fArr) {
        this.mChild.updateSticky(fArr);
        invalidate();
    }

    public void updateTransform() {
        this.mTransform = null;
        this.mTransformToUpdate = Boolean.valueOf(this.mChild.getTransformRaws() != null);
    }

    private void autoUpdateTransformMatrix() {
        if (this.mTransform == null && this.mTransformToUpdate.booleanValue()) {
            this.mTransformToUpdate = false;
            if (this.mChild.mTransformRaw == null) {
                this.mTransform = null;
            } else {
                Rect childFrameRect = getChildFrameRect();
                this.mTransform = TransformProps.processTransform(this.mChild.mTransformRaw, this.mContext.getUIBody().getFontSize(), getFontSize(), this.mContext.getUIBody().getWidth(), this.mContext.getUIBody().getHeight(), childFrameRect.width(), childFrameRect.height());
            }
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public Rect getBound() {
        return this.mChild.getBound();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public int getWidth() {
        return this.mChild.getWidth();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public int getHeight() {
        return this.mChild.getHeight();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public int getTop() {
        return this.mChild.getTop();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public int getLeft() {
        return this.mChild.getLeft();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public int getOriginTop() {
        return this.mChild.getOriginTop();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public int getOriginLeft() {
        return this.mChild.getOriginLeft();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setLeft(int i) {
        this.mChild.setLeft(i);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setTop(int i) {
        this.mChild.setTop(i);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setBound(Rect rect) {
        this.mChild.setBound(rect);
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void layout() {
        View view = (View) ((ShadowView) this.mView).getParent();
        if (view == null) {
            return;
        }
        ((ShadowView) this.mView).layout(0, 0, view.getWidth(), view.getHeight());
        if (((ShadowView) this.mView).getParent() instanceof ViewGroup) {
            ((ViewGroup) ((ShadowView) this.mView).getParent()).setClipChildren(false);
            ViewCompat.setClipBounds(this.mView, getBoundRectForOverflow());
        }
        LynxBaseUI lynxBaseUI = this.mChild;
        if (lynxBaseUI instanceof LynxUI) {
            ((LynxUI) lynxBaseUI).layout();
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public LynxBaseUI.TransOffset getTransformValue(float f, float f2, float f3, float f4) {
        return this.mChild.getTransformValue(f, f2, f3, f4);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean updateDrawingLayoutInfo(int i, int i2, Rect rect) {
        if (!this.mChild.updateDrawingLayoutInfo(i, i2, rect)) {
            return false;
        }
        setNeedUpdateShadow(true);
        invalidate();
        return true;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onDrawingPositionChanged() {
        super.onDrawingPositionChanged();
        setNeedUpdateShadow(true);
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void measure() {
        this.mChild.measure();
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void insertChild(LynxBaseUI lynxBaseUI, int i) {
        this.mChild.insertChild(lynxBaseUI, i);
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void removeChild(LynxBaseUI lynxBaseUI) {
        this.mChild.removeChild(lynxBaseUI);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public JavaOnlyMap getProps() {
        return this.mChild.getProps();
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup
    public void removeView(LynxBaseUI lynxBaseUI) {
        ((UIGroup) this.mChild).removeView(lynxBaseUI);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void updateExtraData(Object obj) {
        this.mChild.updateExtraData(obj);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void updateLayoutInfo(LynxBaseUI lynxBaseUI) {
        this.mChild.updateLayoutInfo(lynxBaseUI);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setBoxShadow(ReadableArray readableArray) {
        this.mBoxShadowList = ShadowData.parseShadow(readableArray);
        updateShadowAndOutline();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public float getAlpha() {
        LynxBaseUI lynxBaseUI = this.mChild;
        if (lynxBaseUI instanceof LynxUI) {
            return ((LynxUI) lynxBaseUI).getView().getAlpha();
        }
        return 1.0f;
    }

    public Matrix getMatrix() {
        this.mMatrix.reset();
        LynxBaseUI lynxBaseUI = this.mChild;
        if (!(lynxBaseUI instanceof LynxUI)) {
            return this.mMatrix;
        }
        View view = ((LynxUI) lynxBaseUI).getView();
        if (view != null) {
            float pivotX = view.getPivotX() + getLeft();
            float pivotY = view.getPivotY() + getTop();
            this.mMatrix.preTranslate(view.getTranslationX(), view.getTranslationY());
            this.mMatrix.preScale(view.getScaleX(), view.getScaleY(), pivotX, pivotY);
            this.mMatrix.preRotate(view.getRotation(), pivotX, pivotY);
        }
        return this.mMatrix;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public float getTranslationZ() {
        LynxBaseUI lynxBaseUI = this.mChild;
        if (lynxBaseUI instanceof LynxUI) {
            return ((LynxUI) lynxBaseUI).getTranslationZ();
        }
        return 0.0f;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public float getRealTimeTranslationZ() {
        LynxBaseUI lynxBaseUI = this.mChild;
        if (lynxBaseUI instanceof LynxUI) {
            return ((LynxUI) lynxBaseUI).getRealTimeTranslationZ();
        }
        return 0.0f;
    }

    public void notifyAnimating() {
        invalidate();
        setNeedUpdateShadow(true);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onPropsUpdated() {
        LynxBaseUI lynxBaseUI = this.mChild;
        if (lynxBaseUI != null) {
            lynxBaseUI.onPropsUpdated();
        }
        super.onPropsUpdated();
        setNeedUpdateShadow(true);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean checkStickyOnParentScroll(int i, int i2) {
        boolean checkStickyOnParentScroll = this.mChild.checkStickyOnParentScroll(i, i2);
        if (checkStickyOnParentScroll) {
            invalidate();
        }
        return checkStickyOnParentScroll;
    }

    private Rect getChildFrameRect() {
        return new Rect(this.mChild.getLeft(), this.mChild.getTop(), this.mChild.getLeft() + this.mChild.getWidth(), this.mChild.getTop() + this.mChild.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateShadowAndOutline() {
        float[] fArr;
        BorderRadius borderRadius = this.mChild.getLynxBackground().getBorderRadius();
        int width = this.mChild.getWidth();
        int height = this.mChild.getHeight();
        if (width == 0 || height == 0) {
            ((ShadowView) this.mView).clearShadowDrawerList();
            ((ShadowView) this.mView).clearOutlineDrawer();
            return;
        }
        InsetDrawer insetDrawer = null;
        if (borderRadius != null) {
            if (width > 0 && height > 0) {
                borderRadius.updateSize(width, height);
            }
            fArr = borderRadius.getArray();
        } else {
            fArr = null;
        }
        if (width > 0 && height > 0) {
            Rect childFrameRect = getChildFrameRect();
            Outline outline = this.mOutline;
            if (outline != null) {
                outline.mFrameRect = childFrameRect;
            }
            ((ShadowView) this.mView).updateOutlineDrawer(this.mOutline);
            ((ShadowView) this.mView).updateShadow(this.mBoxShadowList, childFrameRect, fArr);
        }
        if (((ShadowView) this.mView).hasInset()) {
            LynxBaseUI lynxBaseUI = this.mChild;
            if (lynxBaseUI != null && lynxBaseUI.getLynxBackground() != null) {
                insetDrawer = this.mChild.getLynxBackground().getBoxShadowInsetDrawer();
            }
            if (insetDrawer == null) {
                insetDrawer = new InsetDrawer((ShadowView) this.mView);
                this.mChild.getLynxBackground().setBoxShadowInsetDrawer(insetDrawer);
            }
            insetDrawer.updateUIPosition(this.mChild.getLeft(), this.mChild.getTop());
        }
        ((ShadowView) this.mView).invalidate();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Outline {
        public Integer mColor;
        public Rect mFrameRect;
        private Paint mPaint;
        private Path mPath;
        public float mWidth = 0.0f;
        public BorderStyle mStyle = BorderStyle.NONE;

        public Outline() {
            this.mColor = null;
            this.mColor = -16777216;
        }

        protected void onDraw(Canvas canvas) {
            Rect rect;
            BorderStyle borderStyle = this.mStyle;
            if (borderStyle == null || borderStyle.equals(BorderStyle.NONE) || this.mStyle.equals(BorderStyle.HIDDEN) || this.mWidth < 0.001d || (rect = this.mFrameRect) == null || rect.width() < 1 || this.mFrameRect.height() < 1) {
                return;
            }
            int save = canvas.save();
            doDraw(canvas);
            canvas.restoreToCount(save);
        }

        private void clipQuadrilateral(Canvas canvas, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            this.mPath.reset();
            this.mPath.moveTo(f, f2);
            this.mPath.lineTo(f3, f4);
            this.mPath.lineTo(f5, f6);
            this.mPath.lineTo(f7, f8);
            this.mPath.lineTo(f, f2);
            canvas.clipPath(this.mPath);
        }

        private void doDraw(Canvas canvas) {
            Rect rect = this.mFrameRect;
            int i = rect.left;
            int i2 = rect.top;
            int width = rect.width();
            int height = rect.height();
            float f = this.mWidth;
            int round = f < 1.0f ? 1 : Math.round(f);
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(false);
            this.mPaint.setStyle(Paint.Style.STROKE);
            Integer num = this.mColor;
            int intValue = num != null ? num.intValue() : -16777216;
            float f2 = i;
            float f3 = i2;
            float f4 = i - round;
            float f5 = i2 - round;
            int i3 = i + width;
            float f6 = i3 + round;
            float f7 = i3;
            float f8 = round;
            float f9 = f8 * 0.5f;
            float f10 = f3 - f9;
            canvas.save();
            clipQuadrilateral(canvas, f2, f3, f4, f5, f6, f5, f7, f3);
            int i4 = round * 2;
            float f11 = width + i4;
            this.mStyle.strokeBorderLine(canvas, this.mPaint, 1, this.mWidth, intValue, f4, f10, f6, f10, f11, f8);
            canvas.restore();
            int i5 = i2 + height;
            float f12 = i5;
            float f13 = i5 + round;
            float f14 = f7 + f9;
            canvas.save();
            clipQuadrilateral(canvas, f7, f3, f7, f12, f6, f13, f6, f5);
            float f15 = height + i4;
            this.mStyle.strokeBorderLine(canvas, this.mPaint, 2, this.mWidth, intValue, f14, f5, f14, f13, f15, f8);
            canvas.restore();
            float f16 = f12 + f9;
            canvas.save();
            clipQuadrilateral(canvas, f2, f12, f7, f12, f6, f13, f4, f13);
            this.mStyle.strokeBorderLine(canvas, this.mPaint, 3, this.mWidth, intValue, f6, f16, f4, f16, f11, f8);
            canvas.restore();
            float f17 = f2 - f9;
            canvas.save();
            clipQuadrilateral(canvas, f2, f3, f4, f5, f4, f13, f2, f12);
            this.mStyle.strokeBorderLine(canvas, this.mPaint, 0, this.mWidth, intValue, f17, f13, f17, f5, f15, f8);
            canvas.restore();
            this.mPaint.setAntiAlias(true);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class ShadowView extends AndroidView {
        private boolean mHasInset;
        private Outline mOutlineDrawer;
        private ArrayList<ShadowDrawer> mShadowDrawerList;
        private WeakReference<UIShadowProxy> mShadowProxy;

        @Override // com.lynx.tasm.behavior.p000ui.view.AndroidView, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        public ShadowView(UIShadowProxy uIShadowProxy, Context context) {
            super(context);
            this.mShadowProxy = new WeakReference<>(uIShadowProxy);
            setWillNotDraw(false);
        }

        public boolean hasInset() {
            return this.mHasInset;
        }

        public void updateOutlineDrawer(Outline outline) {
            this.mOutlineDrawer = outline;
        }

        public void updateShadow(List<ShadowData> list, Rect rect, float[] fArr) {
            this.mShadowDrawerList = null;
            if (list == null || list.isEmpty()) {
                return;
            }
            this.mShadowDrawerList = new ArrayList<>();
            for (ShadowData shadowData : list) {
                ShadowDrawer shadowDrawer = new ShadowDrawer();
                shadowDrawer.updateShadow(shadowData, rect, fArr);
                if (shadowDrawer.mBoxShadow != null && shadowDrawer.mBoxShadow.isInset()) {
                    this.mHasInset = true;
                }
                this.mShadowDrawerList.add(shadowDrawer);
            }
            invalidate();
        }

        public void clearShadowDrawerList() {
            ArrayList<ShadowDrawer> arrayList = this.mShadowDrawerList;
            if (arrayList != null) {
                arrayList.clear();
            }
            invalidate();
        }

        public void clearOutlineDrawer() {
            this.mOutlineDrawer = null;
        }

        public void drawInset(Canvas canvas) {
            ArrayList<ShadowDrawer> arrayList = this.mShadowDrawerList;
            if ((arrayList == null || arrayList.isEmpty()) && this.mOutlineDrawer == null) {
                return;
            }
            ArrayList<ShadowDrawer> arrayList2 = this.mShadowDrawerList;
            if (arrayList2 != null) {
                for (int size = arrayList2.size() - 1; size >= 0; size--) {
                    ShadowDrawer shadowDrawer = this.mShadowDrawerList.get(size);
                    if (shadowDrawer != null && shadowDrawer.mBoxShadow.isInset()) {
                        shadowDrawer.onDraw(canvas);
                    }
                }
            }
            Outline outline = this.mOutlineDrawer;
            if (outline != null) {
                outline.onDraw(canvas);
            }
        }

        private void drawOutset(Canvas canvas) {
            ArrayList<ShadowDrawer> arrayList = this.mShadowDrawerList;
            if ((arrayList == null || arrayList.isEmpty()) && this.mOutlineDrawer == null) {
                return;
            }
            UIShadowProxy uIShadowProxy = this.mShadowProxy.get();
            float alpha = uIShadowProxy != null ? uIShadowProxy.getAlpha() : 1.0f;
            if (alpha <= 0.001f) {
                return;
            }
            if (alpha < 1.0f) {
                canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), (int) (alpha * 255.0f), 31);
            } else {
                canvas.save();
            }
            if (uIShadowProxy != null) {
                Matrix matrix = this.mShadowProxy.get().getMatrix();
                if (!matrix.isIdentity()) {
                    canvas.concat(matrix);
                }
                setTranslationZ(this.mShadowProxy.get().getTranslationZ());
            }
            ArrayList<ShadowDrawer> arrayList2 = this.mShadowDrawerList;
            if (arrayList2 != null) {
                for (int size = arrayList2.size() - 1; size >= 0; size--) {
                    ShadowDrawer shadowDrawer = this.mShadowDrawerList.get(size);
                    if (shadowDrawer != null && !shadowDrawer.mBoxShadow.isInset()) {
                        shadowDrawer.onDraw(canvas);
                    }
                }
            }
            canvas.restore();
        }

        private void drawOutline(Canvas canvas) {
            Outline outline = this.mOutlineDrawer;
            if (outline != null) {
                outline.onDraw(canvas);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.lynx.tasm.behavior.p000ui.view.AndroidView, android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            UIShadowProxy uIShadowProxy = this.mShadowProxy.get();
            if (uIShadowProxy != null && uIShadowProxy.isNeedUpdateShadow()) {
                uIShadowProxy.updateShadowAndOutline();
                uIShadowProxy.setNeedUpdateShadow(false);
            }
            drawOutset(canvas);
            super.dispatchDraw(canvas);
            drawOutline(canvas);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class ShadowDrawer {
        static double[] multiplier = {1.0d, 0.8027415617602307d, 0.6443940149772542d, 0.5172818579717866d, 0.41524364653850576d, 0.3333333333333333d, 0.2075805205867436d, 0.1147980049924181d, 0.0424272859905955d, 0.0d};
        ShadowData mBoxShadow;
        final RectF mChildBounds;
        final RectF mChildOrigBounds;
        float[] mCornerOrigRadiusArray;
        float[] mCornerRadiusArray;
        Paint mCornerShadowPaintLB;
        Paint mCornerShadowPaintLT;
        Paint mCornerShadowPaintRB;
        Paint mCornerShadowPaintRT;
        Paint mEdgeShadowPaint;
        final Path boxPath = new Path();
        final Path origBoxPath = new Path();
        final Path cornerPathLT = new Path();
        final Path cornerPathRB = new Path();
        final Path cornerPathLB = new Path();
        final Path cornerPathRT = new Path();
        final Path edgePathTop = new Path();
        final Path edgePathBottom = new Path();
        final Path edgePathLeft = new Path();
        final Path edgePathRight = new Path();
        boolean mClipShadowPath = false;
        Paint mPaint = new Paint(5);

        public ShadowDrawer() {
            Paint paint = new Paint(5);
            this.mCornerShadowPaintLT = paint;
            paint.setStyle(Paint.Style.FILL);
            this.mCornerShadowPaintLT.setDither(true);
            this.mCornerShadowPaintRT = new Paint(this.mCornerShadowPaintLT);
            this.mCornerShadowPaintLB = new Paint(this.mCornerShadowPaintLT);
            this.mCornerShadowPaintRB = new Paint(this.mCornerShadowPaintLT);
            this.mChildBounds = new RectF();
            this.mChildOrigBounds = new RectF();
            this.mEdgeShadowPaint = new Paint(this.mCornerShadowPaintLT);
            this.mCornerRadiusArray = new float[8];
            this.mCornerOrigRadiusArray = new float[8];
        }

        private float calBorderRadiusAdjustForBound(RectF rectF, float[] fArr) {
            float f = 0.0f;
            if (FloatUtils.floatsEqual(rectF.width(), 0.0f) || FloatUtils.floatsEqual(rectF.height(), 0.0f)) {
                return 0.0f;
            }
            if (fArr[0] + fArr[2] > rectF.width()) {
                float width = (fArr[0] + fArr[2]) - rectF.width();
                if (width > 0.0f) {
                    f = width;
                }
            }
            if (fArr[4] + fArr[6] > rectF.width()) {
                float width2 = (fArr[4] + fArr[6]) - rectF.width();
                if (width2 > f) {
                    f = width2;
                }
            }
            if (fArr[1] + fArr[7] > rectF.height()) {
                float height = (fArr[1] + fArr[7]) - rectF.height();
                if (height > f) {
                    f = height;
                }
            }
            if (fArr[3] + fArr[5] <= rectF.height()) {
                return f;
            }
            float height2 = (fArr[3] + fArr[5]) - rectF.height();
            return height2 > f ? height2 : f;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
        
            if (r1 < 1.0f) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void adjustBorderRadiusForBound(RectF rectF, float[] fArr) {
            float f;
            if (FloatUtils.floatsEqual(rectF.width(), 0.0f) || FloatUtils.floatsEqual(rectF.height(), 0.0f)) {
                return;
            }
            if (fArr[0] + fArr[2] > rectF.width()) {
                f = rectF.width() / (fArr[0] + fArr[2]);
            }
            f = 1.0f;
            if (fArr[4] + fArr[6] > rectF.width()) {
                float width = rectF.width() / (fArr[4] + fArr[6]);
                if (width < f) {
                    f = width;
                }
            }
            if (fArr[1] + fArr[7] > rectF.height()) {
                float height = rectF.height() / (fArr[1] + fArr[7]);
                if (height < f) {
                    f = height;
                }
            }
            if (fArr[3] + fArr[5] > rectF.height()) {
                float height2 = rectF.height() / (fArr[3] + fArr[5]);
                if (height2 < f) {
                    f = height2;
                }
            }
            if (f < 1.0f) {
                for (int i = 0; i < 8; i++) {
                    fArr[i] = fArr[i] * f;
                }
            }
        }

        public void updateShadow(ShadowData shadowData, Rect rect, float[] fArr) {
            this.mBoxShadow = shadowData;
            if (fArr != null && fArr.length == 8) {
                System.arraycopy(fArr, 0, this.mCornerOrigRadiusArray, 0, 8);
            } else {
                Arrays.fill(this.mCornerOrigRadiusArray, 0.0f);
            }
            System.arraycopy(this.mCornerOrigRadiusArray, 0, this.mCornerRadiusArray, 0, 8);
            this.mChildBounds.set(rect);
            this.mChildOrigBounds.set(rect);
            ShadowData shadowData2 = this.mBoxShadow;
            if (shadowData2 != null) {
                float f = (shadowData2.spreadRadius - (this.mBoxShadow.blurRadius / 2.0f)) * (this.mBoxShadow.isInset() ? 1 : -1);
                if (f > 0.0f) {
                    float min = Math.min(this.mChildBounds.width(), this.mChildBounds.height()) / 2.0f;
                    if (f > min) {
                        f = min;
                    }
                }
                this.mChildBounds.inset(f, f);
                this.mChildBounds.offset(this.mBoxShadow.offsetX, this.mBoxShadow.offsetY);
                for (int i = 0; i < 8; i++) {
                    float[] fArr2 = this.mCornerRadiusArray;
                    fArr2[i] = Math.max(fArr2[i] - f, 0.0f);
                }
                adjustBorderRadiusForBound(this.mChildBounds, this.mCornerRadiusArray);
            }
            if (this.mBoxShadow != null) {
                float[] fArr3 = this.mCornerRadiusArray;
                buildShadowCorner(this.cornerPathLT, fArr3[0], fArr3[1]);
                buildShadowCorner(this.cornerPathRT, fArr3[2], fArr3[3]);
                buildShadowCorner(this.cornerPathRB, fArr3[4], fArr3[5]);
                buildShadowCorner(this.cornerPathLB, fArr3[6], fArr3[7]);
                buildShadowPaint();
                buildShadowPath();
            }
        }

        private void buildShadowPath() {
            Path path = new Path();
            Path path2 = new Path();
            Path path3 = new Path();
            Path path4 = new Path();
            this.boxPath.reset();
            this.origBoxPath.reset();
            this.boxPath.addRoundRect(this.mChildBounds, this.mCornerRadiusArray, Path.Direction.CW);
            this.origBoxPath.addRoundRect(this.mChildOrigBounds, this.mCornerOrigRadiusArray, Path.Direction.CW);
            if (Build.VERSION.SDK_INT >= 26) {
                this.boxPath.op(this.origBoxPath, this.mBoxShadow.isInset() ? Path.Op.REVERSE_DIFFERENCE : Path.Op.DIFFERENCE);
            } else {
                this.mClipShadowPath = true;
                this.boxPath.addRoundRect(this.mChildOrigBounds, this.mCornerOrigRadiusArray, Path.Direction.CCW);
            }
            this.mPaint.setColor(this.mBoxShadow.color);
            path.reset();
            path.set(this.origBoxPath);
            path.offset(-this.mChildBounds.left, -this.mChildBounds.top);
            Matrix matrix = new Matrix();
            path2.reset();
            path2.set(this.origBoxPath);
            matrix.reset();
            matrix.preRotate(-180.0f);
            matrix.preTranslate(-this.mChildBounds.right, -this.mChildBounds.bottom);
            path2.transform(matrix);
            path3.reset();
            path3.set(this.origBoxPath);
            matrix.reset();
            matrix.preRotate(-270.0f);
            matrix.preTranslate(-this.mChildBounds.left, -this.mChildBounds.bottom);
            path3.transform(matrix);
            path4.reset();
            path4.set(this.origBoxPath);
            matrix.reset();
            matrix.preRotate(-90.0f);
            matrix.preTranslate(-this.mChildBounds.right, -this.mChildBounds.top);
            path4.transform(matrix);
            Path.Op op = this.mBoxShadow.isInset() ? Path.Op.INTERSECT : Path.Op.DIFFERENCE;
            if (!this.cornerPathLT.isEmpty()) {
                this.cornerPathLT.op(path, op);
            }
            if (!this.cornerPathRB.isEmpty()) {
                this.cornerPathRB.op(path2, op);
            }
            if (!this.cornerPathLB.isEmpty()) {
                this.cornerPathLB.op(path3, op);
            }
            if (!this.cornerPathRT.isEmpty()) {
                this.cornerPathRT.op(path4, op);
            }
            this.edgePathTop.reset();
            this.edgePathBottom.reset();
            this.edgePathLeft.reset();
            this.edgePathRight.reset();
            float[] fArr = this.mCornerRadiusArray;
            float f = this.mBoxShadow.isInset() ? 0.0f : -this.mBoxShadow.blurRenderRadiusExtent;
            float f2 = this.mBoxShadow.isInset() ? this.mBoxShadow.blurRenderRadiusExtent : 0.0f;
            this.edgePathTop.addRect(fArr[0], f, this.mChildBounds.width() - fArr[2], f2, Path.Direction.CW);
            this.edgePathBottom.addRect(fArr[4], f, this.mChildBounds.width() - fArr[6], f2, Path.Direction.CW);
            this.edgePathLeft.addRect(fArr[7], f, this.mChildBounds.height() - fArr[1], f2, Path.Direction.CW);
            this.edgePathRight.addRect(fArr[3], f, this.mChildBounds.height() - fArr[5], f2, Path.Direction.CW);
            Path.Op op2 = this.mBoxShadow.isInset() ? Path.Op.INTERSECT : Path.Op.DIFFERENCE;
            if (!this.edgePathTop.isEmpty()) {
                this.edgePathTop.op(path, op2);
            }
            if (!this.edgePathBottom.isEmpty()) {
                this.edgePathBottom.op(path2, op2);
            }
            if (!this.edgePathLeft.isEmpty()) {
                this.edgePathLeft.op(path3, op2);
            }
            if (this.edgePathRight.isEmpty()) {
                return;
            }
            this.edgePathRight.op(path4, op2);
        }

        private void buildShadowCorner(Path path, float f, float f2) {
            path.reset();
            float f3 = this.mBoxShadow.isInset() ? this.mBoxShadow.blurRenderRadiusExtent : -this.mBoxShadow.blurRenderRadiusExtent;
            RectF rectF = new RectF(0.0f, 0.0f, f * 2.0f, f2 * 2.0f);
            RectF rectF2 = new RectF(rectF);
            if (f3 > 0.0f) {
                float min = Math.min(rectF2.width(), rectF2.height()) / 2.0f;
                if (f3 > min) {
                    f3 = min;
                }
            }
            if (f3 <= -0.1f || f3 >= 0.1f) {
                rectF2.inset(f3, f3);
                path.setFillType(Path.FillType.EVEN_ODD);
                path.moveTo(0.0f, f2);
                path.rLineTo(f3, 0.0f);
                path.arcTo(rectF2, 180.0f, 90.0f, false);
                path.arcTo(rectF, 270.0f, -90.0f, false);
                path.close();
            }
        }

        private void buildShadowPaint() {
            float f = this.mBoxShadow.blurRenderRadiusExtent;
            int[] iArr = {Color.alpha(this.mBoxShadow.color), Color.red(this.mBoxShadow.color), Color.green(this.mBoxShadow.color), Color.blue(this.mBoxShadow.color)};
            this.mPaint.setColor(this.mBoxShadow.color);
            int[] iArr2 = new int[multiplier.length];
            int i = 0;
            while (true) {
                double[] dArr = multiplier;
                if (i >= dArr.length) {
                    break;
                }
                iArr2[i] = Color.argb((int) (iArr[0] * dArr[i]), iArr[1], iArr[2], iArr[3]);
                i++;
            }
            Paint paint = this.mEdgeShadowPaint;
            if (!this.mBoxShadow.isInset()) {
                f = -f;
            }
            paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, f, iArr2, (float[]) null, Shader.TileMode.CLAMP));
            float[] fArr = this.mCornerRadiusArray;
            buildCornerShadowPaint(this.mCornerShadowPaintLT, iArr, fArr[0], fArr[1]);
            buildCornerShadowPaint(this.mCornerShadowPaintRT, iArr, fArr[2], fArr[3]);
            buildCornerShadowPaint(this.mCornerShadowPaintRB, iArr, fArr[4], fArr[5]);
            buildCornerShadowPaint(this.mCornerShadowPaintLB, iArr, fArr[6], fArr[7]);
        }

        private void buildCornerShadowPaint(Paint paint, int[] iArr, float f, float f2) {
            float f3 = this.mBoxShadow.blurRenderRadiusExtent;
            float f4 = (f + f2) / 2.0f;
            int length = multiplier.length;
            float f5 = 1.0f;
            float f6 = 0.0f;
            char c = 2;
            if (!this.mBoxShadow.isInset()) {
                float f7 = f3 + f4;
                if (f7 <= 1.0E-6d) {
                    paint.setShader(null);
                    return;
                }
                float f8 = f4 / f7;
                int i = length + 1;
                float[] fArr = new float[i];
                int[] iArr2 = new int[i];
                fArr[0] = 0.0f;
                fArr[1] = f8;
                iArr2[0] = this.mBoxShadow.color;
                iArr2[1] = this.mBoxShadow.color;
                for (int i2 = 2; i2 <= length; i2++) {
                    int i3 = i2 - 1;
                    fArr[i2] = (((1.0f - f8) * i3) / (length - 1)) + f8;
                    iArr2[i2] = Color.argb((int) (iArr[0] * multiplier[i3]), iArr[1], iArr[2], iArr[3]);
                }
                paint.setShader(new RadialGradient(f, f2, f7, iArr2, fArr, Shader.TileMode.CLAMP));
                return;
            }
            if (f4 <= 1.0E-6d) {
                paint.setShader(null);
                return;
            }
            float f9 = f3 / f4;
            int i4 = length + 1;
            float[] fArr2 = new float[i4];
            int[] iArr3 = new int[i4];
            fArr2[length] = 1.0f;
            iArr3[length] = this.mBoxShadow.color;
            int i5 = 1;
            while (i5 < length) {
                int i6 = length - i5;
                fArr2[i6] = Math.max(f5 - ((i5 * f9) / (length - 1)), f6);
                iArr3[i6] = Color.argb((int) (iArr[0] * multiplier[i5]), iArr[1], iArr[c], iArr[3]);
                i5++;
                f5 = 1.0f;
                f6 = 0.0f;
                c = 2;
            }
            fArr2[0] = f6;
            iArr3[0] = Color.argb(0, iArr[1], iArr[2], iArr[3]);
            paint.setShader(new RadialGradient(f, f2, f4, iArr3, fArr2, Shader.TileMode.CLAMP));
        }

        protected void onDraw(Canvas canvas) {
            if (this.mBoxShadow == null) {
                return;
            }
            int save = canvas.save();
            if (this.mClipShadowPath) {
                canvas.clipPath(this.origBoxPath, this.mBoxShadow.isInset() ? Region.Op.INTERSECT : Region.Op.DIFFERENCE);
            }
            canvas.drawPath(this.boxPath, this.mPaint);
            try {
                drawShadow(canvas);
            } catch (Exception e) {
                LLog.e(UIShadowProxy.TAG, "Exception occurred while drawing shadow: " + e.getStackTrace().toString());
            }
            canvas.restoreToCount(save);
        }

        private void drawShadow(Canvas canvas) {
            if (this.mBoxShadow == null) {
                return;
            }
            int save = canvas.save();
            canvas.translate(this.mChildBounds.left, this.mChildBounds.top);
            canvas.drawPath(this.cornerPathLT, this.mCornerShadowPaintLT);
            canvas.drawPath(this.edgePathTop, this.mEdgeShadowPaint);
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate(this.mChildBounds.right, this.mChildBounds.bottom);
            canvas.rotate(180.0f);
            canvas.drawPath(this.cornerPathRB, this.mCornerShadowPaintRB);
            canvas.drawPath(this.edgePathBottom, this.mEdgeShadowPaint);
            canvas.restoreToCount(save2);
            int save3 = canvas.save();
            canvas.translate(this.mChildBounds.left, this.mChildBounds.bottom);
            canvas.rotate(270.0f);
            canvas.drawPath(this.cornerPathLB, this.mCornerShadowPaintLB);
            canvas.drawPath(this.edgePathLeft, this.mEdgeShadowPaint);
            canvas.restoreToCount(save3);
            int save4 = canvas.save();
            canvas.translate(this.mChildBounds.right, this.mChildBounds.top);
            canvas.rotate(90.0f);
            canvas.drawPath(this.cornerPathRT, this.mCornerShadowPaintRT);
            canvas.drawPath(this.edgePathRight, this.mEdgeShadowPaint);
            canvas.restoreToCount(save4);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class InsetDrawer {
        private float mLeft;
        private ShadowView mShadowView;
        private float mTop;

        InsetDrawer(ShadowView shadowView) {
            this.mShadowView = shadowView;
        }

        public void updateUIPosition(float f, float f2) {
            this.mLeft = f;
            this.mTop = f2;
        }

        public void draw(Canvas canvas) {
            if (this.mShadowView != null) {
                int save = canvas.save();
                canvas.translate(-this.mLeft, -this.mTop);
                this.mShadowView.drawInset(canvas);
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean enableLayoutAnimation() {
        return this.mChild.enableLayoutAnimation();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public LayoutAnimationManager getLayoutAnimator() {
        return this.mChild.getLayoutAnimator();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public TransitionAnimationManager getTransitionAnimator() {
        return this.mChild.getTransitionAnimator();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void updatePropertiesInterval(StylesDiffMap stylesDiffMap) {
        getChild().updateProperties(stylesDiffMap);
        onPropsUpdated();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean isFirstAnimatedReady() {
        return this.mChild.isFirstAnimatedReady();
    }
}
