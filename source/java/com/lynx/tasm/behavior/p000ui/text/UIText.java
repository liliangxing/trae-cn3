package com.lynx.tasm.behavior.p000ui.text;

import android.content.Context;
import android.graphics.RectF;
import android.text.Layout;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.MeaningfulPaintingArea;
import com.lynx.tasm.behavior.p000ui.UIGroup;
import com.lynx.tasm.behavior.p000ui.accessibility.CustomAccessibilityDelegateCompat;
import com.lynx.tasm.behavior.p000ui.utils.LynxUIHelper;
import com.lynx.tasm.behavior.shadow.text.TextUpdateBundle;
import com.lynx.tasm.gesture.GestureArenaMember;
import com.lynx.tasm.gesture.LynxNewGestureDelegate;
import com.lynx.tasm.gesture.detector.GestureDetector;
import com.lynx.tasm.gesture.handler.BaseGestureHandler;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIText extends UIGroup<AndroidText> implements IUIText, GestureArenaMember, LynxNewGestureDelegate {
    private Map<Integer, BaseGestureHandler> mGestureHandlers;
    private TextUpdateBundle mTextUpdateBundle;

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public boolean canConsumeGesture(float f, float f2) {
        return true;
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public int getMemberScrollX() {
        return 0;
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public int getMemberScrollY() {
        return 0;
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public int getScrollContainerDirection() {
        return 0;
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public boolean isAtBorder(boolean z) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean needGenerateMeaningfulPaintingArea() {
        return true;
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public void onGestureScrollBy(float f, float f2) {
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
    public UIText(Context context) {
        this((LynxContext) context);
    }

    public UIText(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public UIText(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
        this.mAccessibilityElementStatus = 1;
        if (!this.mContext.isTextOverflowEnabled() || this.mContext.isLayoutInElementModeOn()) {
            return;
        }
        this.mOverflow = 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public AndroidText createView(Context context) {
        return new AndroidText(context);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    protected MeaningfulPaintingArea convertToMeaningfulPaintingArea(int i, int i2) {
        int i3;
        if (getTextLayout() == null) {
            return null;
        }
        MeaningfulPaintingArea meaningfulPaintingArea = new MeaningfulPaintingArea(i + getOriginLeft(), i2 + getOriginTop(), getWidth(), getHeight(), true);
        meaningfulPaintingArea.setAlpha(this.mView != 0 ? ((AndroidText) this.mView).getAlpha() : getAlpha());
        meaningfulPaintingArea.setScaleX(this.mView != 0 ? ((AndroidText) this.mView).getScaleX() : getScaleX());
        meaningfulPaintingArea.setScaleY(this.mView != 0 ? ((AndroidText) this.mView).getScaleY() : getScaleY());
        if (this.mView != 0) {
            i3 = ((AndroidText) this.mView).getVisibility();
        } else {
            i3 = getVisibility() ? 0 : 4;
        }
        meaningfulPaintingArea.setVisibleStatus(i3);
        return meaningfulPaintingArea;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float f, float f2) {
        return hitTest(f, f2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float f, float f2, boolean z) {
        return this.mView == 0 ? this : UITextUtils.hitTest(this, f - (this.mPaddingLeft + this.mBorderLeftWidth), f2 - (this.mPaddingTop + this.mBorderTopWidth), this, ((AndroidText) this.mView).mTextLayout, UITextUtils.getSpanned((AndroidText) this.mView), ((AndroidText) getView()).mTextTranslateOffset, z);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void updateExtraData(Object obj) {
        if (obj instanceof TextUpdateBundle) {
            this.mTextUpdateBundle = (TextUpdateBundle) obj;
            ((AndroidText) this.mView).setTextBundle(this.mTextUpdateBundle);
            if (this.mEvents != null) {
                ((AndroidText) this.mView).setBindSelectionChange(this.mEvents.containsKey("selectionchange"), getSign());
            }
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public void didEnsureCreateView() {
        super.didEnsureCreateView();
        ((AndroidText) this.mView).setTextBundle(this.mTextUpdateBundle);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onNodeReady() {
        super.onNodeReady();
        if (this.mContext.isLayoutInElementModeOn()) {
            updateExtraData(this.mContext.getLynxUIOwner().takeTextLayout(getSign()));
        }
        if (((AndroidText) this.mView).mTextUpdateBundle != null) {
            UITextUtils.HandleInlineViewTruncated(((AndroidText) this.mView).mTextUpdateBundle, this);
        }
    }

    public CharSequence getOriginText() {
        return this.mView == 0 ? "" : ((AndroidText) this.mView).getOriginText();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public void initAccessibilityDelegate() {
        super.initAccessibilityDelegate();
        if (this.mView != 0) {
            ViewCompat.setAccessibilityDelegate(this.mView, new CustomAccessibilityDelegateCompat(this));
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        int i = this.mPaddingLeft + this.mBorderLeftWidth;
        int i2 = this.mPaddingRight + this.mBorderRightWidth;
        ((AndroidText) this.mView).setPadding(i, this.mPaddingTop + this.mBorderTopWidth, i2, this.mPaddingBottom + this.mBorderBottomWidth);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    @LynxProp(name = PropsConstants.ACCESSIBILITY_LABEL)
    public void setAccessibilityLabel(Dynamic dynamic) {
        super.setAccessibilityLabel(dynamic);
        if (this.mView != 0) {
            ((AndroidText) this.mView).setFocusable(true);
            ((AndroidText) this.mView).setContentDescription(getAccessibilityLabel());
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public CharSequence getAccessibilityLabel() {
        CharSequence accessibilityLabel = super.getAccessibilityLabel();
        return !TextUtils.isEmpty(accessibilityLabel) ? accessibilityLabel : ((AndroidText) this.mView).getText();
    }

    @Deprecated
    public void setTextGradient(String str) {
        LLog.e("UIText", "setTextGradient(String) is deprecated");
    }

    @LynxProp(defaultBoolean = false, name = "text-selection")
    public void setEnableTextSelection(boolean z) {
        ((AndroidText) this.mView).setEnableTextSelection(z);
    }

    @LynxProp(defaultBoolean = false, name = "custom-context-menu")
    public void setCustomContextMenu(boolean z) {
        ((AndroidText) this.mView).setCustomContextMenu(z);
    }

    @LynxProp(defaultBoolean = false, name = "custom-text-selection")
    public void setCustomTextSelection(boolean z) {
        ((AndroidText) this.mView).setCustomTextSelection(z);
    }

    @LynxProp(defaultInt = 0, name = "selection-background-color")
    public void setSelectionBackgroundColor(int i) {
        ((AndroidText) this.mView).updateSelectionBackgroundColor(i);
    }

    @LynxProp(defaultInt = 0, name = "selection-handle-color")
    public void setSelectionHandleColor(int i) {
        ((AndroidText) this.mView).updateSelectionHandleColor(i);
    }

    @LynxProp(defaultInt = 0, name = "selection-handle-size")
    public void setSelectionHandleSize(int i) {
        ((AndroidText) this.mView).updateSelectionHandleSize(i);
    }

    @Override // com.lynx.tasm.behavior.p000ui.text.IUIText
    public Layout getTextLayout() {
        if (this.mView == 0) {
            return null;
        }
        return ((AndroidText) this.mView).getTextLayout();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setConsumeHoverEvent(boolean z) {
        super.setConsumeHoverEvent(z);
        if (this.mView != 0) {
            ((AndroidText) this.mView).setConsumeHoverEvent(this.mConsumeHoverEvent);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        if (this.mView != 0) {
            ((AndroidText) this.mView).release();
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void copyPropFromOldUiInUpdateFlatten(LynxBaseUI lynxBaseUI) {
        super.copyPropFromOldUiInUpdateFlatten(lynxBaseUI);
        if (lynxBaseUI instanceof FlattenUIText) {
            updateExtraData(((FlattenUIText) lynxBaseUI).getTextBundle());
        }
    }

    @LynxUIMethod
    public void getTextBoundingRect(ReadableMap readableMap, Callback callback) {
        try {
            int i = readableMap.getInt("start");
            int i2 = readableMap.getInt("end");
            if (i <= i2 && i >= 0 && i2 >= 0) {
                if (this.mView != 0) {
                    ArrayList<RectF> textBoundingBoxes = ((AndroidText) this.mView).getTextBoundingBoxes(i, i2);
                    if (textBoundingBoxes.size() > 0) {
                        callback.invoke(new Object[]{0, getTextBoundingRectFromBoxes(textBoundingBoxes, readableMap, LynxUIHelper.getRelativePositionInfo(this, readableMap))});
                        return;
                    }
                }
                callback.invoke(new Object[]{1, "Can not find text bounding rect."});
                return;
            }
            callback.invoke(new Object[]{4, "parameter is invalid"});
        } catch (Exception e) {
            callback.invoke(new Object[]{1, e.getMessage()});
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008d A[Catch: Exception -> 0x0103, TryCatch #0 {Exception -> 0x0103, blocks: (B:3:0x000c, B:5:0x006b, B:9:0x0077, B:11:0x007d, B:15:0x0089, B:17:0x008d, B:19:0x00a9, B:22:0x00b7, B:23:0x00cd, B:25:0x00d0, B:27:0x00dc, B:32:0x00e5, B:39:0x00f4), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f4 A[Catch: Exception -> 0x0103, TRY_LEAVE, TryCatch #0 {Exception -> 0x0103, blocks: (B:3:0x000c, B:5:0x006b, B:9:0x0077, B:11:0x007d, B:15:0x0089, B:17:0x008d, B:19:0x00a9, B:22:0x00b7, B:23:0x00cd, B:25:0x00d0, B:27:0x00dc, B:32:0x00e5, B:39:0x00f4), top: B:2:0x000c }] */
    @LynxUIMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setTextSelection(ReadableMap readableMap, Callback callback) {
        int i;
        boolean z;
        boolean z2;
        try {
            double d = getLynxContext().getScreenMetrics().density;
            double d2 = ((readableMap.getDouble("startX") * d) - getPaddingLeft()) - getBorderLeftWidth();
            double d3 = ((readableMap.getDouble("startY") * d) - getPaddingTop()) - getBorderTopWidth();
            double d4 = ((readableMap.getDouble("endX") * d) - getPaddingLeft()) - getBorderLeftWidth();
            double d5 = ((readableMap.getDouble("endY") * d) - getPaddingTop()) - getBorderTopWidth();
            if (readableMap.hasKey("showStartHandle") && !readableMap.getBoolean("showStartHandle")) {
                z = false;
                if (readableMap.hasKey("showEndHandle") && !readableMap.getBoolean("showEndHandle")) {
                    z2 = false;
                    if (this.mView != 0) {
                        callback.invoke(new Object[]{6});
                        return;
                    }
                    ArrayList<RectF> textSelection = ((AndroidText) this.mView).setTextSelection((float) d2, (float) d3, (float) d4, (float) d5, z, z2);
                    if (textSelection.size() == 0) {
                        callback.invoke(new Object[]{0});
                        return;
                    }
                    RectF relativePositionInfo = LynxUIHelper.getRelativePositionInfo(this, readableMap);
                    JavaOnlyMap textBoundingRectFromBoxes = getTextBoundingRectFromBoxes(textSelection, readableMap, relativePositionInfo);
                    ArrayList<Float>[] handlesInfo = ((AndroidText) this.mView).getHandlesInfo();
                    JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
                    for (ArrayList<Float> arrayList : handlesInfo) {
                        javaOnlyArray.add(getHandleMap(arrayList, relativePositionInfo));
                    }
                    textBoundingRectFromBoxes.putArray("handles", javaOnlyArray);
                    i = 2;
                    try {
                        Object[] objArr = new Object[2];
                        objArr[0] = 0;
                        objArr[1] = textBoundingRectFromBoxes;
                        callback.invoke(objArr);
                        return;
                    } catch (Exception e) {
                        e = e;
                        Object[] objArr2 = new Object[i];
                        objArr2[0] = 1;
                        objArr2[1] = e.getMessage();
                        callback.invoke(objArr2);
                        return;
                    }
                }
                z2 = true;
                if (this.mView != 0) {
                }
            }
            z = true;
            if (readableMap.hasKey("showEndHandle")) {
                z2 = false;
                if (this.mView != 0) {
                }
            }
            z2 = true;
            if (this.mView != 0) {
            }
        } catch (Exception e2) {
            e = e2;
            i = 2;
        }
    }

    @LynxUIMethod
    public void getSelectedText(ReadableMap readableMap, Callback callback) {
        if (this.mView == 0) {
            callback.invoke(new Object[]{6});
            return;
        }
        String selectedText = ((AndroidText) this.mView).getSelectedText();
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.put("selectedText", selectedText);
        callback.invoke(new Object[]{0, javaOnlyMap});
    }

    private JavaOnlyMap getMapFromRect(RectF rectF, RectF rectF2) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        float f = getLynxContext().getScreenMetrics().density;
        javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_LEFT, (((rectF.left + getPaddingLeft()) + getBorderLeftWidth()) + rectF2.left) / f);
        javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_TOP, (((rectF.top + getPaddingTop()) + getBorderTopWidth()) + rectF2.top) / f);
        javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_RIGHT, (((rectF.left + getPaddingLeft()) + getBorderLeftWidth()) + rectF2.right) / f);
        javaOnlyMap.putDouble(PropsConstants.HIT_SLOP_BOTTOM, (((rectF.top + getPaddingTop()) + getBorderTopWidth()) + rectF2.bottom) / f);
        javaOnlyMap.putDouble("width", rectF2.width() / f);
        javaOnlyMap.putDouble("height", rectF2.height() / f);
        return javaOnlyMap;
    }

    private JavaOnlyMap getHandleMap(ArrayList<Float> arrayList, RectF rectF) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        float f = getLynxContext().getScreenMetrics().density;
        javaOnlyMap.putDouble("x", (((rectF.left + getPaddingLeft()) + getBorderLeftWidth()) + arrayList.get(0).floatValue()) / f);
        javaOnlyMap.putDouble("y", (((rectF.top + getPaddingTop()) + getBorderTopWidth()) + arrayList.get(1).floatValue()) / f);
        javaOnlyMap.putDouble("radius", arrayList.get(2).floatValue() / f);
        return javaOnlyMap;
    }

    private JavaOnlyMap getTextBoundingRectFromBoxes(ArrayList<RectF> arrayList, ReadableMap readableMap, RectF rectF) {
        RectF rectF2 = new RectF(arrayList.get(0));
        for (int i = 1; i < arrayList.size(); i++) {
            rectF2.union(arrayList.get(i));
        }
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putMap("boundingRect", getMapFromRect(rectF, rectF2));
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            javaOnlyArray.add(getMapFromRect(rectF, arrayList.get(i2)));
        }
        javaOnlyMap.putArray("boxes", javaOnlyArray);
        return javaOnlyMap;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onPropsUpdated() {
        super.onPropsUpdated();
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public void onInvalidate() {
        if (isEnableNewGesture()) {
            ViewCompat.postInvalidateOnAnimation(this.mView);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setGestureDetectors(Map<Integer, GestureDetector> map) {
        super.setGestureDetectors(map);
        if (map == null || map.isEmpty()) {
            return;
        }
        ((AndroidText) this.mView).setGestureManager(getGestureArenaManager());
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.gesture.GestureArenaMember
    public Map<Integer, BaseGestureHandler> getGestureHandlers() {
        return super.getGestureHandlers();
    }
}
