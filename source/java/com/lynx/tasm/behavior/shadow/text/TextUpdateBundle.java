package com.lynx.tasm.behavior.shadow.text;

import android.graphics.PointF;
import android.text.Layout;
import java.util.Set;

/* loaded from: classes7.dex */
public class TextUpdateBundle {
    private final boolean mHasImages;
    private final boolean mIsJustify;
    private boolean mNeedDrawStroke;
    private CharSequence mOriginText;
    private Layout mTextLayout;
    private PointF mTextTranslateOffset;
    private Set mViewTruncatedSet;

    public TextUpdateBundle(Layout layout, boolean z, Set set, boolean z2) {
        this.mTextLayout = layout;
        this.mHasImages = z;
        this.mViewTruncatedSet = set;
        this.mIsJustify = z2;
    }

    public Layout getTextLayout() {
        return this.mTextLayout;
    }

    public boolean hasImages() {
        return this.mHasImages;
    }

    public Set getViewTruncatedSet() {
        return this.mViewTruncatedSet;
    }

    public void setTextTranslateOffset(PointF pointF) {
        this.mTextTranslateOffset = pointF;
    }

    public void setNeedDrawStroke(boolean z) {
        this.mNeedDrawStroke = z;
    }

    public boolean getNeedDrawStroke() {
        return this.mNeedDrawStroke;
    }

    public PointF getTextTranslateOffset() {
        return this.mTextTranslateOffset;
    }

    public boolean isJustify() {
        return this.mIsJustify;
    }

    public void setOriginText(CharSequence charSequence) {
        this.mOriginText = charSequence;
    }

    public CharSequence getOriginText() {
        return this.mOriginText;
    }

    public void setViewTruncatedSet(Set set) {
        this.mViewTruncatedSet = set;
    }
}
