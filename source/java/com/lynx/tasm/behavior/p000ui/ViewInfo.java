package com.lynx.tasm.behavior.p000ui;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import com.lynx.tasm.animation.keyframe.KeyframeManager;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.p000ui.MeaningfulPaintingArea;
import com.lynx.tasm.behavior.p000ui.image.LynxImageManager;
import com.lynx.tasm.behavior.p000ui.shapes.BasicShape;
import com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan;
import com.lynx.tasm.behavior.p000ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.p000ui.utils.LynxBackground;
import com.lynx.tasm.behavior.p000ui.utils.MaskDrawable;
import com.lynx.tasm.behavior.p000ui.utils.ViewHelper;
import com.lynx.tasm.rendernode.compat.RenderNodeCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ViewInfo implements IDrawChildHook {
    boolean clipToRadius;
    int mBoundsHeight;
    int mBoundsWidth;
    BasicShape mClipPath;
    Path mClipPathInBeforeDispatchDraw;
    Rect mClipRectInBeforeDispatchDraw;
    boolean mHasOverlappingRendering;
    int mHeight;
    private LynxImageManager mImageManagerUsedInBeforeDraw;
    MaskDrawable mMaskDrawable;
    int[] mOrder;
    Rect mOverflowClipRect;
    IProcessViewInfoHook mProcessHook;
    float mSkewX;
    float mSkewY;
    View mView;
    int mWidth;
    boolean mNeedGenerateMeaningfulPaintingArea = false;
    KeyframeManager mKeyframeManager = null;
    int mCurrentDrawIndex = 0;
    ArrayList<SubDrawInfo> mSubDrawInfoArray = new ArrayList<>();

    public void detachWithUI() {
    }

    public ViewInfo(IProcessViewInfoHook iProcessViewInfoHook, View view) {
        this.mProcessHook = iProcessViewInfoHook;
        this.mView = view;
    }

    public void detachFromUI() {
        this.mProcessHook = null;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setSkewX(float f) {
        this.mSkewX = f;
    }

    public void setSkewY(float f) {
        this.mSkewY = f;
    }

    public void setClipPath(BasicShape basicShape) {
        this.mClipPath = basicShape;
    }

    public void setDrawingOrder(int[] iArr) {
        this.mOrder = iArr;
    }

    public void setHasOverlappingRendering(boolean z) {
        this.mHasOverlappingRendering = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void markNeedGenerateMeaningfulPaintingArea(boolean z) {
        this.mNeedGenerateMeaningfulPaintingArea = z;
    }

    public void setKeyframeManager(KeyframeManager keyframeManager) {
        this.mKeyframeManager = keyframeManager;
    }

    public void setClipToRadius(boolean z) {
        this.clipToRadius = z;
    }

    public void setClipPathInBeforeDispatchDraw(Path path) {
        this.mClipPathInBeforeDispatchDraw = path;
    }

    public void setClipRectInBeforeDispatchDraw(Rect rect) {
        this.mClipRectInBeforeDispatchDraw = rect;
    }

    public void setOverflowClipRect(Rect rect) {
        this.mOverflowClipRect = rect;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class SubDrawInfo {
        float mAlpha;
        LynxBackground mBackground;
        Rect mBound;
        int mDrawOffsetX;
        int mDrawOffsetY;
        int mHeight;
        boolean mIsView;
        int mLeft;
        LynxImageManager mLynxImageManager;
        boolean mNeedGenerateMeaningfulPaintingArea;
        int mOverflow;
        int mPaddingBottom;
        int mPaddingLeft;
        int mPaddingRight;
        int mPaddingTop;
        RenderNodeCompat mRenderNode;
        float mSkewX;
        float mSkewY;
        View mSubView;
        ViewInfo mSubViewInfo;
        Layout mTextLayout;
        int mTop;
        int mWidth;

        public SubDrawInfo(boolean z, Rect rect, RenderNodeCompat renderNodeCompat, LynxBackground lynxBackground) {
            this.mLynxImageManager = null;
            this.mTextLayout = null;
            this.mLeft = 0;
            this.mTop = 0;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mAlpha = 1.0f;
            this.mDrawOffsetX = 0;
            this.mDrawOffsetY = 0;
            this.mSkewX = 0.0f;
            this.mSkewY = 0.0f;
            this.mOverflow = 0;
            this.mNeedGenerateMeaningfulPaintingArea = false;
            this.mIsView = z;
            this.mBound = rect;
            this.mRenderNode = renderNodeCompat;
            this.mBackground = lynxBackground;
        }

        public SubDrawInfo(boolean z, Rect rect, RenderNodeCompat renderNodeCompat, LynxBackground lynxBackground, ViewInfo viewInfo, View view) {
            this(z, rect, renderNodeCompat, lynxBackground);
            this.mSubViewInfo = viewInfo;
            this.mSubView = view;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void markNeedGenerateMeaningfulPaintingArea(boolean z) {
            this.mNeedGenerateMeaningfulPaintingArea = z;
        }

        public void setImageManager(LynxImageManager lynxImageManager) {
            this.mLynxImageManager = lynxImageManager;
        }

        public void setTextLayout(Layout layout) {
            this.mTextLayout = layout;
        }

        public void setDrawOffset(int i, int i2) {
            this.mDrawOffsetX = i;
            this.mDrawOffsetY = i2;
        }

        public void setFlattenUIInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f) {
            this.mLeft = i;
            this.mTop = i2;
            this.mWidth = i3;
            this.mHeight = i4;
            this.mPaddingLeft = i5;
            this.mPaddingRight = i7;
            this.mPaddingTop = i6;
            this.mPaddingBottom = i8;
            this.mAlpha = f;
        }

        public void recordSubView(LynxBaseUI lynxBaseUI, View view) {
            if (lynxBaseUI instanceof LynxUI) {
                LynxUI lynxUI = (LynxUI) lynxBaseUI;
                this.mSubView = view;
                this.mLeft = lynxUI.getLeft();
                this.mTop = lynxUI.getTop();
                this.mWidth = lynxUI.getWidth();
                this.mHeight = lynxUI.getHeight();
                this.mSkewX = lynxUI.getSkewX();
                this.mSkewY = lynxUI.getSkewY();
                this.mOverflow = lynxUI.getOverflow();
            }
        }
    }

    public void addSubDrawInfo(int i, SubDrawInfo subDrawInfo) {
        if (i < 0) {
            return;
        }
        int size = this.mSubDrawInfoArray.size();
        if (i > size) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.mSubDrawInfoArray.add(null);
            }
            this.mSubDrawInfoArray.add(subDrawInfo);
            return;
        }
        this.mSubDrawInfoArray.add(i, subDrawInfo);
    }

    public void clearSubDrawInfo() {
        this.mSubDrawInfoArray.clear();
    }

    public void setBoundsWidth(int i) {
        this.mBoundsWidth = i;
    }

    public void setBoundsHeight(int i) {
        this.mBoundsHeight = i;
    }

    public void setMaskDrawable(MaskDrawable maskDrawable) {
        this.mMaskDrawable = maskDrawable;
    }

    public void setImageManagerUsedInBeforeDraw(LynxImageManager lynxImageManager) {
        this.mImageManagerUsedInBeforeDraw = lynxImageManager;
    }

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public void beforeDraw(Canvas canvas) {
        Path path;
        IProcessViewInfoHook iProcessViewInfoHook = this.mProcessHook;
        if (iProcessViewInfoHook != null) {
            iProcessViewInfoHook.beforeProcessViewInfo(this);
        }
        LynxImageManager lynxImageManager = this.mImageManagerUsedInBeforeDraw;
        if (lynxImageManager != null) {
            lynxImageManager.onDraw(canvas);
        }
        float f = this.mSkewX;
        if (f != 0.0f || this.mSkewY != 0.0f) {
            canvas.skew(f, this.mSkewY);
            canvas.translate((-this.mView.getPivotY()) * this.mSkewX, (-this.mView.getPivotX()) * this.mSkewY);
        }
        BasicShape basicShape = this.mClipPath;
        if (basicShape == null || (path = basicShape.getPath(this.mWidth, this.mHeight)) == null) {
            return;
        }
        canvas.clipPath(path);
    }

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public void beforeDispatchDraw(Canvas canvas) {
        IProcessViewInfoHook iProcessViewInfoHook = this.mProcessHook;
        if (iProcessViewInfoHook != null) {
            iProcessViewInfoHook.beforeDispatchProcessViewInfo(this);
        }
        this.mCurrentDrawIndex = 0;
        if (this.clipToRadius) {
            Path path = this.mClipPathInBeforeDispatchDraw;
            if (path != null) {
                canvas.clipPath(path);
            } else {
                Rect rect = this.mClipRectInBeforeDispatchDraw;
                if (rect != null) {
                    canvas.clipRect(rect);
                }
            }
        }
        Rect rect2 = this.mOverflowClipRect;
        if (rect2 != null) {
            canvas.clipRect(rect2);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public Rect beforeDrawChild(Canvas canvas, View view, long j) {
        IProcessViewInfoHook iProcessViewInfoHook = this.mProcessHook;
        if (iProcessViewInfoHook != null) {
            iProcessViewInfoHook.beforeProcessChildViewInfo(this, view, j);
        }
        while (this.mCurrentDrawIndex < this.mSubDrawInfoArray.size()) {
            SubDrawInfo subDrawInfo = this.mSubDrawInfoArray.get(this.mCurrentDrawIndex);
            if (subDrawInfo == null) {
                LLog.e("ViewInfo", "drawWithSubDrawInfo: info is null");
            } else {
                if (subDrawInfo.mIsView) {
                    Rect rect = subDrawInfo.mBound;
                    this.mCurrentDrawIndex++;
                    return rect;
                }
                drawWithSubDrawInfo(subDrawInfo, canvas);
            }
            this.mCurrentDrawIndex++;
        }
        return null;
    }

    private void drawWithSubDrawInfo(SubDrawInfo subDrawInfo, Canvas canvas) {
        Rect rect = subDrawInfo.mBound;
        int save = canvas.save();
        if (rect != null) {
            canvas.clipRect(rect);
        }
        if (subDrawInfo.mLeft != 0 || subDrawInfo.mTop != 0) {
            canvas.translate(subDrawInfo.mLeft, subDrawInfo.mTop);
        }
        if (subDrawInfo.mAlpha < 1.0f) {
            canvas.saveLayerAlpha(0.0f, 0.0f, subDrawInfo.mWidth, subDrawInfo.mHeight, (int) (subDrawInfo.mAlpha * 255.0f), 31);
        }
        if (subDrawInfo.mBackground != null && subDrawInfo.mBackground.getDrawable() != null) {
            subDrawInfo.mBackground.updatePaddingWidths(subDrawInfo.mPaddingTop, subDrawInfo.mPaddingRight, subDrawInfo.mPaddingBottom, subDrawInfo.mPaddingLeft);
            BackgroundDrawable drawable = subDrawInfo.mBackground.getDrawable();
            drawable.setBounds(0, 0, subDrawInfo.mWidth, subDrawInfo.mHeight);
            drawable.draw(canvas);
        }
        if (subDrawInfo.mTextLayout != null) {
            canvas.translate(subDrawInfo.mDrawOffsetX, subDrawInfo.mDrawOffsetY);
            if (subDrawInfo.mWidth > 0 && subDrawInfo.mHeight > 0) {
                canvas.clipRect(0, 0, subDrawInfo.mWidth, subDrawInfo.mHeight);
            }
            AbsInlineImageSpan.possiblyHandleInlineImageRequestResult((Spanned) subDrawInfo.mTextLayout.getText());
            subDrawInfo.mTextLayout.draw(canvas);
        }
        if (subDrawInfo.mLynxImageManager != null) {
            subDrawInfo.mLynxImageManager.onDraw(canvas);
        }
        canvas.restoreToCount(save);
    }

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public void afterDrawChild(Canvas canvas, View view, long j) {
        IProcessViewInfoHook iProcessViewInfoHook = this.mProcessHook;
        if (iProcessViewInfoHook != null) {
            iProcessViewInfoHook.afterProcessChildViewInfo(this, view, j);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public void afterDispatchDraw(Canvas canvas) {
        IProcessViewInfoHook iProcessViewInfoHook = this.mProcessHook;
        if (iProcessViewInfoHook != null) {
            iProcessViewInfoHook.afterDispatchProcessViewInfo(this);
        }
        while (this.mCurrentDrawIndex < this.mSubDrawInfoArray.size()) {
            drawWithSubDrawInfo(this.mSubDrawInfoArray.get(this.mCurrentDrawIndex), canvas);
            this.mCurrentDrawIndex++;
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public void afterDraw(Canvas canvas) {
        IProcessViewInfoHook iProcessViewInfoHook = this.mProcessHook;
        if (iProcessViewInfoHook != null) {
            iProcessViewInfoHook.afterProcessViewInfo(this);
        }
        MaskDrawable maskDrawable = this.mMaskDrawable;
        if (maskDrawable != null) {
            maskDrawable.setBounds(0, 0, this.mBoundsWidth, this.mBoundsHeight);
            this.mMaskDrawable.draw(canvas);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public int getChildDrawingOrder(int i, int i2) {
        int[] iArr = this.mOrder;
        return (iArr == null || i2 >= iArr.length) ? i2 : iArr[i2];
    }

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public boolean hasOverlappingRendering() {
        return this.mHasOverlappingRendering;
    }

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public void performLayoutChildrenUI() {
        IProcessViewInfoHook iProcessViewInfoHook = this.mProcessHook;
        if (iProcessViewInfoHook != null) {
            iProcessViewInfoHook.processLayoutChildren();
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public void performMeasureChildrenUI() {
        IProcessViewInfoHook iProcessViewInfoHook = this.mProcessHook;
        if (iProcessViewInfoHook != null) {
            iProcessViewInfoHook.processMeasureChildren();
        }
    }

    public void invalidate() {
        View view = this.mView;
        if (view == null) {
            return;
        }
        view.invalidate();
    }

    public void invalidateMeaningfulPaintingArea() {
        KeyEvent.Callback callback = this.mView;
        if (callback instanceof MeaningfulPaintingArea.IMeaningfulPaintingAreaInvalidateHook) {
            ((MeaningfulPaintingArea.IMeaningfulPaintingAreaInvalidateHook) callback).invalidateMeaningfulPaintingArea();
        }
    }

    public void generateMeaningfulPaintingArea(int i, int i2, ArrayList<MeaningfulPaintingArea> arrayList) {
        View view = this.mView;
        int left = i + (view != null ? view.getLeft() : 0);
        View view2 = this.mView;
        int top = i2 + (view2 != null ? view2.getTop() : 0);
        if (this.mView != null && this.mNeedGenerateMeaningfulPaintingArea) {
            int width = this.mView.getWidth();
            int height = this.mView.getHeight();
            LynxImageManager lynxImageManager = this.mImageManagerUsedInBeforeDraw;
            MeaningfulPaintingArea meaningfulPaintingArea = new MeaningfulPaintingArea(left, top, width, height, lynxImageManager != null ? lynxImageManager.getHasContent().booleanValue() : true);
            meaningfulPaintingArea.setAlpha(this.mView.getAlpha());
            meaningfulPaintingArea.setScaleX(this.mView.getScaleX());
            meaningfulPaintingArea.setScaleY(this.mView.getScaleY());
            meaningfulPaintingArea.setVisibleStatus(this.mView.getVisibility());
            arrayList.add(meaningfulPaintingArea);
        }
        Iterator<SubDrawInfo> it = this.mSubDrawInfoArray.iterator();
        while (it.hasNext()) {
            SubDrawInfo next = it.next();
            if (next != null) {
                if (next.mSubView instanceof MeaningfulPaintingArea.IMeaningfulPaintingAreaInvalidateHook) {
                    MeaningfulPaintingArea.IMeaningfulPaintingAreaInvalidateHook iMeaningfulPaintingAreaInvalidateHook = (MeaningfulPaintingArea.IMeaningfulPaintingAreaInvalidateHook) next.mSubView;
                    if (iMeaningfulPaintingAreaInvalidateHook.getDrawChildHook() instanceof ViewInfo) {
                        ((ViewInfo) iMeaningfulPaintingAreaInvalidateHook.getDrawChildHook()).generateMeaningfulPaintingArea(left, top, arrayList);
                    }
                } else if (next.mNeedGenerateMeaningfulPaintingArea) {
                    arrayList.add(new MeaningfulPaintingArea(left + next.mLeft, top + next.mTop, next.mWidth, next.mHeight, next.mLynxImageManager != null ? next.mLynxImageManager.getHasContent().booleanValue() : true));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void measure() {
        Iterator<SubDrawInfo> it = this.mSubDrawInfoArray.iterator();
        while (it.hasNext()) {
            SubDrawInfo next = it.next();
            if (next.mIsView && next.mSubViewInfo != null && next.mSubView != null) {
                ViewHelper.measureView(next.mSubView, next.mWidth, next.mHeight);
                next.mSubViewInfo.measure();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void layout() {
        Iterator<SubDrawInfo> it = this.mSubDrawInfoArray.iterator();
        while (it.hasNext()) {
            SubDrawInfo next = it.next();
            if (next.mIsView && next.mSubViewInfo != null && next.mSubView != null) {
                next.mSubView.layout(next.mLeft, next.mTop, next.mLeft + next.mWidth, next.mTop + next.mHeight);
                next.mSubViewInfo.layout();
            }
        }
    }
}
