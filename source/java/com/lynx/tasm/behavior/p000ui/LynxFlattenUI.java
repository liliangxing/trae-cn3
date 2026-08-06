package com.lynx.tasm.behavior.p000ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.p000ui.utils.BackgroundDrawable;
import com.lynx.tasm.rendernode.compat.RenderNodeCompat;
import com.lynx.tasm.rendernode.compat.RenderNodeFactory;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxFlattenUI extends LynxBaseUI {
    public static Method sSetUsageHint;
    private float mAlpha;
    private RenderNodeCompat mBackgroundRenderNode;
    private boolean mIsValidate;
    private RenderNodeCompat mRenderNode;

    protected boolean enableRenderNode() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public float getRealTimeTranslationZ() {
        return 0.0f;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public float getTranslationX() {
        return 0.0f;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public float getTranslationY() {
        return 0.0f;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public float getTranslationZ() {
        return 0.0f;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean isFlatten() {
        return true;
    }

    @Deprecated
    protected LynxFlattenUI(Context context) {
        this((LynxContext) context);
    }

    public LynxFlattenUI(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public LynxFlattenUI(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
        this.mAlpha = 1.0f;
        this.mIsValidate = false;
        if (enableRenderNode()) {
            this.mRenderNode = RenderNodeFactory.getInstance().createRenderNodeCompat();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void detachWithViewInfo(ViewInfo viewInfo) {
        if (enableRenderNode()) {
            this.mRenderNode = RenderNodeFactory.getInstance().createRenderNodeCompat();
        }
        super.detachWithViewInfo(viewInfo);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setSign(int i, String str) {
        super.setSign(i, str);
        if (this.mContext.getDefaultOverflowVisible()) {
            if (str.equals("view") || str.equals("component")) {
                this.mOverflow = 3;
            }
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public int getInitialOverflowType() {
        return (this.mContext.getDefaultOverflowVisible() && ("view".equals(getTagName()) || "component".equals(getTagName()))) ? 0 : 1;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void measure() {
        Iterator<LynxBaseUI> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().measure();
        }
    }

    public void layout(int i, int i2, Rect rect) {
        updateDrawingLayoutInfo(i, i2, rect);
        Rect rect2 = new Rect(getLeft(), getTop(), getLeft() + getWidth(), getTop() + getHeight());
        int overflow = getOverflow();
        boolean z = (overflow & 1) != 0;
        boolean z2 = (overflow & 2) != 0;
        DisplayMetrics screenMetrics = getLynxContext().getScreenMetrics();
        if (z && z2 && rect == null) {
            rect2 = null;
        } else {
            if (z) {
                if (rect == null) {
                    rect2.left = -screenMetrics.widthPixels;
                    rect2.right = screenMetrics.widthPixels * 2;
                } else {
                    rect2.left = rect.left;
                    rect2.right = rect.right;
                }
            } else if (rect != null) {
                rect2.left = rect2.left > rect.left ? rect2.left : rect.left;
                rect2.right = rect2.right < rect.right ? rect2.right : rect.right;
            }
            if (z2) {
                if (rect == null) {
                    rect2.top = -screenMetrics.heightPixels;
                    rect2.bottom = screenMetrics.heightPixels * 2;
                } else {
                    rect2.top = rect.top;
                    rect2.bottom = rect.bottom;
                }
            } else if (rect != null) {
                rect2.top = rect2.top > rect.top ? rect2.top : rect.top;
                rect2.bottom = rect2.bottom < rect.bottom ? rect2.bottom : rect.bottom;
            }
        }
        for (LynxBaseUI lynxBaseUI : this.mChildren) {
            int originLeft = lynxBaseUI.getOriginLeft() + i;
            int originTop = lynxBaseUI.getOriginTop() + i2;
            if (!lynxBaseUI.isFlatten()) {
                lynxBaseUI.updateDrawingLayoutInfo(originLeft, originTop, rect2);
                ((LynxUI) lynxBaseUI).layout();
            } else if (lynxBaseUI.isFlatten()) {
                ((LynxFlattenUI) lynxBaseUI).layout(originLeft, originTop, rect2);
            }
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onDrawingPositionChanged() {
        invalidate();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.p000ui.UIParent
    public void requestLayout() {
        this.mIsValidate = false;
        if (this.mDrawParent != null) {
            this.mDrawParent.requestLayout();
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.p000ui.UIParent
    public void invalidate() {
        this.mIsValidate = false;
        if (this.mDrawParent != null) {
            this.mDrawParent.invalidate();
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    @LynxProp(defaultFloat = DisplayMetricsHolder.DEFAULT_SCREEN_SCALE, name = PropsConstants.OPACITY)
    public void setAlpha(float f) {
        this.mAlpha = f;
        invalidate();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    @LynxProp(name = PropsConstants.TRANSFORM)
    public void setTransform(ReadableArray readableArray) {
        super.setTransform(readableArray);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void innerDraw(Canvas canvas) {
        if (this.mRenderNode == null || !isHardwareDraw(canvas)) {
            draw(canvas);
            return;
        }
        boolean z = this.mIsValidate;
        this.mIsValidate = true;
        if (!z || !this.mRenderNode.hasDisplayList()) {
            updateRenderNode(this.mRenderNode);
        }
        if (this.mRenderNode.hasDisplayList()) {
            this.mRenderNode.drawRenderNode(canvas);
        }
    }

    public final RenderNodeCompat updateRenderNode() {
        boolean z = this.mIsValidate;
        this.mIsValidate = true;
        if (!z || !this.mRenderNode.hasDisplayList()) {
            updateRenderNode(this.mRenderNode);
        }
        return this.mRenderNode;
    }

    protected void updateRenderNode(RenderNodeCompat renderNodeCompat) {
        int width = getWidth();
        int height = getHeight();
        int left = getLeft();
        int top = getTop();
        int i = left + width;
        int i2 = top + height;
        if (getOverflow() != 0) {
            Rect clipBounds = getClipBounds();
            i = clipBounds.right + left;
            i2 = clipBounds.bottom + top;
            left += clipBounds.left;
            top += clipBounds.top;
            width = i - left;
            height = i2 - top;
        }
        renderNodeCompat.setPosition(left, top, i, i2);
        Canvas beginRecording = renderNodeCompat.beginRecording(width, height);
        try {
            beginRecording.translate(-left, -top);
            draw(beginRecording);
        } finally {
            renderNodeCompat.endRecording(beginRecording);
        }
    }

    private boolean isHardwareDraw(Canvas canvas) {
        return canvas.isHardwareAccelerated();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onAttach() {
        super.onAttach();
        invalidate();
    }

    public void draw(Canvas canvas) {
        TraceEvent.beginSection("LynxFlattenUI.draw.");
        if (this.mAlpha <= 0.0f) {
            TraceEvent.endSection("LynxFlattenUI.draw.");
            return;
        }
        int left = getLeft();
        int top = getTop();
        int save = canvas.save();
        if ((left | top) != 0) {
            canvas.translate(left, top);
        }
        if (this.mAlpha < 1.0f) {
            canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), (int) (this.mAlpha * 255.0f), 31);
        }
        onDraw(canvas);
        canvas.restoreToCount(save);
        TraceEvent.endSection("LynxFlattenUI.draw.");
    }

    private RenderNodeCompat getDrawableRenderNode(Drawable drawable, RenderNodeCompat renderNodeCompat) throws InvocationTargetException, IllegalAccessException {
        if (renderNodeCompat == null) {
            renderNodeCompat = RenderNodeFactory.getInstance().createRenderNodeCompat();
            sSetUsageHint.invoke(renderNodeCompat.getRenderNode(), 1);
        }
        Rect bounds = drawable.getBounds();
        Canvas beginRecording = renderNodeCompat.beginRecording(bounds.width(), bounds.height());
        beginRecording.translate(-bounds.left, -bounds.top);
        try {
            drawable.draw(beginRecording);
            renderNodeCompat.endRecording(beginRecording);
            renderNodeCompat.setPosition(bounds.left, bounds.top, bounds.right, bounds.bottom);
            return renderNodeCompat;
        } catch (Throwable th) {
            renderNodeCompat.endRecording(beginRecording);
            throw th;
        }
    }

    public void onDraw(Canvas canvas) {
        BackgroundDrawable drawable = this.mLynxBackground.getDrawable();
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, getWidth(), getHeight());
        if (this.mContext.getForceDarkAllowed() && sSetUsageHint != null && canvas.isHardwareAccelerated()) {
            try {
                RenderNodeCompat drawableRenderNode = getDrawableRenderNode(drawable, this.mBackgroundRenderNode);
                this.mBackgroundRenderNode = drawableRenderNode;
                if (drawableRenderNode.hasDisplayList()) {
                    drawableRenderNode.drawRenderNode(canvas);
                } else {
                    drawable.draw(canvas);
                }
                return;
            } catch (Exception unused) {
                drawable.draw(canvas);
                return;
            }
        }
        drawable.draw(canvas);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public float getAlpha() {
        return this.mAlpha;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    protected void setPosition(int i, int i2) {
        if (getOriginTop() != i2) {
            setOriginTop(i2);
            setTop(i2);
        }
        if (getOriginLeft() != i) {
            setOriginLeft(i);
            setLeft(i);
        }
    }
}
