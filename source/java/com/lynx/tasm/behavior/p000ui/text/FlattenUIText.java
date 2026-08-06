package com.lynx.tasm.behavior.p000ui.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextUtils;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.p000ui.LynxFlattenUI;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.p000ui.MeaningfulPaintingArea;
import com.lynx.tasm.behavior.p000ui.ViewInfo;
import com.lynx.tasm.behavior.shadow.text.TextHelper;
import com.lynx.tasm.behavior.shadow.text.TextUpdateBundle;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FlattenUIText extends LynxFlattenUI implements IUIText {
    private boolean mHasImage;
    private boolean mIsJustify;
    private boolean mNeedDrawStroke;
    private CharSequence mOriginText;
    private TextUpdateBundle mTextBundle;
    private Layout mTextLayout;
    private PointF mTextTranslateOffset;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean needGenerateMeaningfulPaintingArea() {
        return true;
    }

    @Deprecated
    public void setColor(int i) {
    }

    @Deprecated
    public void setColor(Dynamic dynamic) {
    }

    @Deprecated
    public void setTextGradient(ReadableArray readableArray) {
    }

    @Deprecated
    public FlattenUIText(Context context) {
        this((LynxContext) context);
    }

    public FlattenUIText(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public FlattenUIText(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
        this.mAccessibilityElementStatus = 1;
        if (!this.mContext.isTextOverflowEnabled() || this.mContext.isLayoutInElementModeOn()) {
            return;
        }
        this.mOverflow = 3;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    protected MeaningfulPaintingArea convertToMeaningfulPaintingArea(int i, int i2) {
        if (getTextLayout() == null) {
            return null;
        }
        MeaningfulPaintingArea meaningfulPaintingArea = new MeaningfulPaintingArea(i + getOriginLeft(), i2 + getOriginTop(), getWidth(), getHeight(), true);
        meaningfulPaintingArea.setAlpha(getAlpha());
        meaningfulPaintingArea.setScaleX(getScaleX());
        meaningfulPaintingArea.setScaleY(getScaleY());
        return meaningfulPaintingArea;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void updateExtraData(Object obj) {
        if (obj instanceof TextUpdateBundle) {
            setTextBundle((TextUpdateBundle) obj);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onNodeReady() {
        super.onNodeReady();
        if (this.mContext.isLayoutInElementModeOn()) {
            updateExtraData(this.mContext.getLynxUIOwner().takeTextLayout(getSign()));
        }
        TextUpdateBundle textUpdateBundle = this.mTextBundle;
        if (textUpdateBundle != null) {
            UITextUtils.HandleInlineViewTruncated(textUpdateBundle, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TextUpdateBundle getTextBundle() {
        return this.mTextBundle;
    }

    public void setTextBundle(TextUpdateBundle textUpdateBundle) {
        this.mTextBundle = textUpdateBundle;
        dispatchDetachImageSpan();
        this.mTextLayout = textUpdateBundle.getTextLayout();
        this.mTextTranslateOffset = textUpdateBundle.getTextTranslateOffset();
        this.mHasImage = textUpdateBundle.hasImages();
        this.mNeedDrawStroke = textUpdateBundle.getNeedDrawStroke();
        this.mIsJustify = textUpdateBundle.isJustify();
        this.mOriginText = textUpdateBundle.getOriginText();
        if (this.mHasImage && (getText() instanceof Spanned)) {
            AbsInlineImageSpan.possiblyUpdateInlineImageSpans((Spanned) getText(), new DrawableCallback(this));
        }
        invalidate();
    }

    public CharSequence getOriginText() {
        return this.mOriginText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxFlattenUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void detachWithViewInfo(ViewInfo viewInfo) {
        super.detachWithViewInfo(viewInfo);
        if (this.mHasImage && (getText() instanceof Spanned)) {
            AbsInlineImageSpan.possiblyUpdateInlineImageSpans((Spanned) getText(), new DrawableCallback(this));
        }
    }

    private void dispatchDetachImageSpan() {
        if (this.mHasImage && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (AbsInlineImageSpan absInlineImageSpan : (AbsInlineImageSpan[]) spanned.getSpans(0, spanned.length(), AbsInlineImageSpan.class)) {
                absInlineImageSpan.onDetachedFromWindow();
                if (!getLynxContext().isEnginePoolEnabled()) {
                    absInlineImageSpan.setCallback(null);
                }
            }
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        invalidate();
    }

    public CharSequence getText() {
        Layout layout = this.mTextLayout;
        if (layout != null) {
            return layout.getText();
        }
        return null;
    }

    @Deprecated
    public void setTextGradient(String str) {
        LLog.e("FlattenUIText", "setTextGradient(String) is deprecated");
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxFlattenUI
    public void onDraw(Canvas canvas) {
        TraceEvent.beginSection("text.FlattenUIText.onDraw");
        super.onDraw(canvas);
        if (this.mTextLayout == null || isDetachedWithView()) {
            TraceEvent.endSection("text.FlattenUIText.onDraw");
            return;
        }
        int i = this.mPaddingLeft + this.mBorderLeftWidth;
        int i2 = this.mPaddingRight + this.mBorderRightWidth;
        int i3 = this.mPaddingTop + this.mBorderTopWidth;
        int i4 = this.mPaddingBottom + this.mBorderBottomWidth;
        canvas.save();
        if (getOverflow() != 0) {
            Rect boundRectForOverflow = getBoundRectForOverflow();
            if (boundRectForOverflow != null) {
                canvas.clipRect(boundRectForOverflow);
            }
        } else if (!this.mContext.isTextOverflowEnabled()) {
            canvas.clipRect(i, i3, getWidth() - i2, getHeight() - i4);
        }
        canvas.translate(i + this.mTextTranslateOffset.x, i3 + this.mTextTranslateOffset.y);
        Layout layout = this.mTextLayout;
        AbsInlineImageSpan.possiblyHandleInlineImageRequestResult(layout != null ? (Spanned) layout.getText() : null);
        if (this.mIsJustify && Build.VERSION.SDK_INT < 26) {
            TextHelper.drawText(canvas, this.mTextLayout, (getWidth() - i) - i2);
        } else {
            this.mTextLayout.draw(canvas);
        }
        if (this.mNeedDrawStroke) {
            TextHelper.drawTextStroke(this.mTextLayout, canvas);
        }
        TextHelper.drawLine(canvas, this.mTextLayout);
        canvas.restore();
        TraceEvent.endSection("text.FlattenUIText.onDraw");
    }

    public int getDrawOffsetLeft() {
        int i = this.mPaddingLeft + this.mBorderLeftWidth;
        PointF pointF = this.mTextTranslateOffset;
        return i + (pointF != null ? (int) pointF.x : 0);
    }

    public int getDrawOffsetTop() {
        int i = this.mPaddingTop + this.mBorderTopWidth;
        PointF pointF = this.mTextTranslateOffset;
        return i + (pointF != null ? (int) pointF.y : 0);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public CharSequence getAccessibilityLabel() {
        CharSequence accessibilityLabel = super.getAccessibilityLabel();
        return !TextUtils.isEmpty(accessibilityLabel) ? accessibilityLabel : getText();
    }

    @Override // com.lynx.tasm.behavior.p000ui.text.IUIText
    public Layout getTextLayout() {
        return this.mTextLayout;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float f, float f2) {
        return hitTest(f, f2, false);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float f, float f2, boolean z) {
        float f3 = f - (this.mPaddingLeft + this.mBorderLeftWidth);
        float f4 = f2 - (this.mPaddingTop + this.mBorderTopWidth);
        Layout layout = this.mTextLayout;
        return UITextUtils.hitTest(this, f3, f4, this, layout, UITextUtils.getSpanned(layout), this.mTextTranslateOffset, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class DrawableCallback implements Drawable.Callback {
        private final WeakReference<FlattenUIText> mWeakText;
        private WeakReference<ViewInfo> mWeakViewInfo;

        public DrawableCallback(FlattenUIText flattenUIText) {
            this.mWeakText = new WeakReference<>(flattenUIText);
            if (flattenUIText.getLynxContext().isEnginePoolEnabled() && (flattenUIText.mDrawParent instanceof LynxUI)) {
                this.mWeakViewInfo = new WeakReference<>(((LynxUI) flattenUIText.mDrawParent).getViewInfo());
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (UIThreadUtils.isOnUiThread()) {
                WeakReference<ViewInfo> weakReference = this.mWeakViewInfo;
                ViewInfo viewInfo = weakReference != null ? weakReference.get() : null;
                if (viewInfo != null) {
                    viewInfo.invalidate();
                    return;
                }
                FlattenUIText flattenUIText = this.mWeakText.get();
                if (flattenUIText != null) {
                    flattenUIText.invalidate();
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            UIThreadUtils.runOnUiThreadAtTime(runnable, drawable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            UIThreadUtils.removeCallbacks(runnable, drawable);
        }
    }

    private void release() {
        if (this.mHasImage && (getText() instanceof Spanned)) {
            AbsInlineImageSpan.possiblyUpdateInlineImageSpans((Spanned) getText(), null);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        release();
    }
}
