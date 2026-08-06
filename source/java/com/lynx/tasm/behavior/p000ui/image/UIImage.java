package com.lynx.tasm.behavior.p000ui.image;

import android.graphics.Canvas;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.MeaningfulPaintingArea;
import com.lynx.tasm.behavior.p000ui.UIParams;
import com.lynx.tasm.behavior.p000ui.ViewInfo;
import com.lynx.tasm.behavior.p000ui.view.AndroidView;
import com.lynx.tasm.behavior.p000ui.view.UIView;
import com.lynx.tasm.event.EventsListener;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIImage extends UIView {
    LynxImageManager mLynxImageManager;

    @Override // com.lynx.tasm.behavior.p000ui.view.UIView, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public int getInitialOverflowType() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean needGenerateMeaningfulPaintingArea() {
        return true;
    }

    public UIImage(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public UIImage(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
        if (this.mContext != null && this.mContext.isFallbackProcess() && this.mContext.getUIBodyView() != null && (obj instanceof UIParams)) {
            setNodeIndex(((UIParams) obj).mNodeIndex);
            this.mLynxImageManager = lynxContext.getUIBodyView().obtainImageAccordingToNodeIndex(this.mNodeIndex);
        }
        if (this.mLynxImageManager == null) {
            this.mLynxImageManager = new LynxImageManager(getLynxContext());
        }
        this.mLynxImageManager.setLynxBaseUI(this);
        ((AndroidView) this.mView).setWillNotDraw(false);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    protected MeaningfulPaintingArea convertToMeaningfulPaintingArea(int i, int i2) {
        LynxImageManager lynxImageManager = this.mLynxImageManager;
        if (lynxImageManager != null) {
            lynxImageManager.tryHandleResult();
        }
        int originLeft = i + getOriginLeft();
        int originTop = i2 + getOriginTop();
        int width = getWidth();
        int height = getHeight();
        LynxImageManager lynxImageManager2 = this.mLynxImageManager;
        int i3 = 0;
        MeaningfulPaintingArea meaningfulPaintingArea = new MeaningfulPaintingArea(originLeft, originTop, width, height, lynxImageManager2 != null ? lynxImageManager2.getHasContent().booleanValue() : false);
        meaningfulPaintingArea.setAlpha(this.mView != 0 ? ((AndroidView) this.mView).getAlpha() : getAlpha());
        meaningfulPaintingArea.setScaleX(this.mView != 0 ? ((AndroidView) this.mView).getScaleX() : getScaleX());
        meaningfulPaintingArea.setScaleY(this.mView != 0 ? ((AndroidView) this.mView).getScaleY() : getScaleY());
        if (this.mView != 0) {
            i3 = ((AndroidView) this.mView).getVisibility();
        } else if (!getVisibility()) {
            i3 = 4;
        }
        meaningfulPaintingArea.setVisibleStatus(i3);
        return meaningfulPaintingArea;
    }

    private void ensureLynxImageManager() {
        if (this.mLynxImageManager != null) {
            return;
        }
        LynxImageManager lynxImageManager = new LynxImageManager(getLynxContext());
        this.mLynxImageManager = lynxImageManager;
        lynxImageManager.setLynxBaseUI(this);
        this.mLynxImageManager.setEvents(this.mEvents);
        this.mLynxImageManager.updatePropertiesInterval(this.mProps);
        this.mLynxImageManager.onLayoutUpdated(getWidth(), getHeight(), getPaddingLeft(), getPaddingRight(), getPaddingTop(), getPaddingBottom());
        this.mLynxImageManager.onNodeReady();
    }

    @LynxUIMethod
    public void pauseAnimation(ReadableMap readableMap, Callback callback) {
        ensureLynxImageManager();
        this.mLynxImageManager.pauseAnimation(readableMap, callback);
    }

    @LynxUIMethod
    public void resumeAnimation(ReadableMap readableMap, Callback callback) {
        ensureLynxImageManager();
        this.mLynxImageManager.resumeAnimation(readableMap, callback);
    }

    @LynxUIMethod
    public void stopAnimation(ReadableMap readableMap, Callback callback) {
        ensureLynxImageManager();
        this.mLynxImageManager.stopAnimation(readableMap, callback);
    }

    @LynxUIMethod
    public void startAnimate(ReadableMap readableMap, Callback callback) {
        ensureLynxImageManager();
        this.mLynxImageManager.startAnimate(readableMap, callback);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setImageRendering(int i) {
        ensureLynxImageManager();
        super.setImageRendering(i);
        this.mLynxImageManager.setIsPixelated(i == 2);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void updatePropertiesInterval(StylesDiffMap stylesDiffMap) {
        ensureLynxImageManager();
        super.updatePropertiesInterval(stylesDiffMap);
        this.mLynxImageManager.updatePropertiesInterval(stylesDiffMap.mBackingMap);
    }

    @Override // com.lynx.tasm.behavior.p000ui.view.UIView, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onPropsUpdated() {
        ensureLynxImageManager();
        super.onPropsUpdated();
        this.mLynxImageManager.onPropsUpdated();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onNodeReady() {
        ensureLynxImageManager();
        super.onNodeReady();
        if (this.mLynxBackground.getDrawable() != null) {
            this.mLynxImageManager.setBorderWidth(this.mLynxBackground.getDrawable().getDirectionAwareBorderInsets());
            if (this.mLynxBackground.getBorderRadius() != null) {
                this.mLynxImageManager.setBorderRadius(this.mLynxBackground.getBorderRadius().getArray(), this.mLynxBackground.getBorderRadius().updateSize(getWidth(), getHeight()));
            }
        }
        this.mLynxImageManager.onNodeReady();
    }

    @Override // com.lynx.tasm.behavior.p000ui.view.UIView, com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        LynxImageManager lynxImageManager = this.mLynxImageManager;
        if (lynxImageManager != null) {
            lynxImageManager.destroy();
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public void beforeDraw(Canvas canvas) {
        ensureLynxImageManager();
        super.beforeDraw(canvas);
        this.mLynxImageManager.onDraw(canvas);
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.IProcessViewInfoHook
    public void beforeProcessViewInfo(ViewInfo viewInfo) {
        ensureLynxImageManager();
        if (this.mLynxImageManager != null) {
            this.mViewInfo.setImageManagerUsedInBeforeDraw(this.mLynxImageManager);
        }
        super.beforeProcessViewInfo(viewInfo);
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onAttach() {
        super.onAttach();
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setEvents(Map<String, EventsListener> map) {
        ensureLynxImageManager();
        super.setEvents(map);
        this.mLynxImageManager.setEvents(map);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onLayoutUpdated() {
        ensureLynxImageManager();
        super.onLayoutUpdated();
        this.mLynxImageManager.onLayoutUpdated(getWidth(), getHeight(), getPaddingLeft(), getPaddingRight(), getPaddingTop(), getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void detachWithViewInfo(ViewInfo viewInfo) {
        LynxImageManager lynxImageManager = this.mLynxImageManager;
        if (lynxImageManager != null) {
            lynxImageManager.setLynxBaseUI(null);
            this.mLynxImageManager.setViewInfo(this.mViewInfo != null ? this.mViewInfo : viewInfo);
            getLynxContext().getUIBodyView().registerImageAccordingToNodeIndex(this.mNodeIndex, this.mLynxImageManager);
            this.mLynxImageManager = null;
        }
        super.detachWithViewInfo(viewInfo);
    }
}
