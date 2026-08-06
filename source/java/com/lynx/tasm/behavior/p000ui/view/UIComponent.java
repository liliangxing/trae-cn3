package com.lynx.tasm.behavior.p000ui.view;

import android.content.Context;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.PropsConstants;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIComponent extends UIView {
    private String mItemKey;
    private NodeReadyListener mNodeReadyListener;
    private OnUpdateListener mOnUpdateListener;
    private String mType;
    private int mZIndex;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface NodeReadyListener {
        void onComponentNodeReady(UIComponent uIComponent);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface OnUpdateListener {
        void onLayoutUpdated(UIComponent uIComponent);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean isAccessibilityHostUI() {
        return true;
    }

    public UIComponent(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public UIComponent(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
        this.mZIndex = 0;
        if (lynxContext.getDefaultOverflowVisible()) {
            this.mOverflow = 3;
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.view.UIView
    protected AndroidView onCreateView(Context context) {
        return new ComponentView(context);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        OnUpdateListener onUpdateListener = this.mOnUpdateListener;
        if (onUpdateListener != null) {
            onUpdateListener.onLayoutUpdated(this);
        }
    }

    public void setOnUpdateListener(OnUpdateListener onUpdateListener) {
        this.mOnUpdateListener = onUpdateListener;
    }

    public OnUpdateListener getOnUpdateListener() {
        return this.mOnUpdateListener;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    @Override // com.lynx.tasm.behavior.p000ui.view.UIView, com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        this.mOnUpdateListener = null;
        this.mNodeReadyListener = null;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onNodeReady() {
        super.onNodeReady();
        NodeReadyListener nodeReadyListener = this.mNodeReadyListener;
        if (nodeReadyListener != null) {
            nodeReadyListener.onComponentNodeReady(this);
        }
    }

    public void setNodeReadyListener(NodeReadyListener nodeReadyListener) {
        this.mNodeReadyListener = nodeReadyListener;
    }

    @LynxProp(name = PropsConstants.ITEM_KEY)
    public void setItemKey(String str) {
        this.mItemKey = str;
    }

    public String getItemKey() {
        return this.mItemKey;
    }

    @LynxProp(defaultInt = 0, name = PropsConstants.Z_INDEX)
    public void setZIndex(int i) {
        this.mZIndex = i;
    }

    public int getZIndex() {
        return this.mZIndex;
    }
}
