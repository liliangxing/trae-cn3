package com.lynx.tasm.behavior.shadow;

import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.Assertions;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.PaintingContext;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.shadow.text.EventTargetSpan;
import com.lynx.tasm.behavior.utils.PropsUpdater;
import com.lynx.tasm.event.EventsListener;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ShadowNode extends LayoutNode {
    private static final String TAG = "lynx_ShadowNode";
    private ArrayList<ShadowNode> mChildren;
    protected LynxContext mContext;
    private boolean mDestroyed;
    protected Map<String, EventsListener> mEvents;
    private ShadowNode mParent;
    private ShadowNode mRootNode;
    protected ShadowStyle mShadowStyle;
    private String mTagName;
    protected ReadableMap mDataset = new JavaOnlyMap();
    protected EventTarget.EnableStatus mIgnoreFocus = EventTarget.EnableStatus.Undefined;
    protected EventTarget.EnableStatus mEventThrough = EventTarget.EnableStatus.Undefined;
    protected EventTarget.PointerEventsValue mPointerEvents = EventTarget.PointerEventsValue.Unset;
    protected boolean mEnableTouchPseudoPropagation = true;

    public Object getExtraBundle() {
        return null;
    }

    public boolean isVirtual() {
        return false;
    }

    public void onAfterUpdateTransaction() {
    }

    @Deprecated
    public void onCollectExtraUpdates(PaintingContext paintingContext) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
    }

    public boolean supportInlineView() {
        return false;
    }

    public final String getTagName() {
        return (String) Assertions.assertNotNull(this.mTagName);
    }

    public void setEvents(Map<String, EventsListener> map) {
        this.mEvents = map;
    }

    public void addChildAt(ShadowNode shadowNode, int i) {
        if (shadowNode.getParent() != null) {
            throw new RuntimeException("Tried to add child that already has a parent! Remove it from its parent first.");
        }
        if (this.mChildren == null) {
            this.mChildren = new ArrayList<>(4);
        }
        this.mChildren.add(i, shadowNode);
        shadowNode.mParent = this;
    }

    public ShadowNode removeChildAt(int i) {
        ArrayList<ShadowNode> arrayList = this.mChildren;
        if (arrayList == null) {
            throw new ArrayIndexOutOfBoundsException("Index " + i + " out of bounds: node has no children");
        }
        ShadowNode remove = arrayList.remove(i);
        remove.mParent = null;
        return remove;
    }

    public final int getChildCount() {
        ArrayList<ShadowNode> arrayList = this.mChildren;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final ShadowNode getChildAt(int i) {
        ArrayList<ShadowNode> arrayList = this.mChildren;
        if (arrayList == null) {
            throw new ArrayIndexOutOfBoundsException("Index " + i + " out of bounds: node has no children");
        }
        return arrayList.get(i);
    }

    public final int indexOf(ShadowNode shadowNode) {
        ArrayList<ShadowNode> arrayList = this.mChildren;
        if (arrayList == null) {
            return -1;
        }
        return arrayList.indexOf(shadowNode);
    }

    public final void updateProperties(StylesDiffMap stylesDiffMap) {
        try {
            PropsUpdater.updateProps(this, stylesDiffMap);
            onAfterUpdateTransaction();
        } catch (Exception e) {
            LLog.e(TAG, "Catch exception for tag: " + getTagName());
            getContext().handleException(e);
        }
    }

    public final void setTagName(String str) {
        this.mTagName = str;
    }

    public final ShadowNode getParent() {
        return this.mParent;
    }

    public final LynxContext getContext() {
        return (LynxContext) Assertions.assertNotNull(this.mContext);
    }

    public void setContext(LynxContext lynxContext) {
        this.mContext = lynxContext;
    }

    public ShadowStyle getShadowStyle() {
        return this.mShadowStyle;
    }

    public String toString() {
        return this.mTagName;
    }

    @Override // com.lynx.tasm.behavior.shadow.LayoutNode
    public final void destroy() {
        this.mDestroyed = true;
        onDestroy();
        super.destroy();
    }

    public final boolean isDestroyed() {
        return this.mDestroyed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportNullError(String str) {
        if (this.mContext != null) {
            this.mContext.handleLynxError(new LynxError(60401, str, "", "error"));
        }
    }

    private ShadowNode findNonVirtualNode() {
        if (!isVirtual()) {
            return this;
        }
        ShadowNode parent = getParent();
        while (parent != null && parent.isVirtual()) {
            parent = parent.getParent();
        }
        return parent;
    }

    @Override // com.lynx.tasm.behavior.shadow.LayoutNode
    public void markDirty() {
        if (this.mDestroyed) {
            return;
        }
        if (!isVirtual()) {
            super.markDirty();
            return;
        }
        ShadowNode findNonVirtualNode = findNonVirtualNode();
        if (findNonVirtualNode != null) {
            findNonVirtualNode.markDirty();
        }
    }

    @Override // com.lynx.tasm.behavior.shadow.LayoutNode
    public boolean isDirty() {
        if (!isVirtual()) {
            return super.isDirty();
        }
        ShadowNode findNonVirtualNode = findNonVirtualNode();
        if (findNonVirtualNode != null) {
            return findNonVirtualNode.isDirty();
        }
        return false;
    }

    @LynxProp(name = PropsConstants.VERTICAL_ALIGN)
    public void setVerticalAlign(ReadableArray readableArray) {
        if (this.mContext.isTextRefactorEnabled()) {
            return;
        }
        setVerticalAlignOnShadowNode(readableArray);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVerticalAlignOnShadowNode(ReadableArray readableArray) {
        if (this.mShadowStyle == null) {
            this.mShadowStyle = new ShadowStyle();
        }
        if (readableArray == null || readableArray.size() < 2) {
            this.mShadowStyle.verticalAlign = 0;
            this.mShadowStyle.verticalAlignLength = 0.0f;
        } else {
            this.mShadowStyle.verticalAlign = readableArray.getInt(0);
            this.mShadowStyle.verticalAlignLength = (float) readableArray.getDouble(1);
        }
        markDirty();
    }

    @LynxProp(name = PropsConstants.IGNORE_FOCUS)
    public void setIgnoreFocus(Dynamic dynamic) {
        if (dynamic == null) {
            this.mIgnoreFocus = EventTarget.EnableStatus.Undefined;
            return;
        }
        try {
            this.mIgnoreFocus = dynamic.asBoolean() ? EventTarget.EnableStatus.Enable : EventTarget.EnableStatus.Disable;
        } catch (Throwable th) {
            LLog.i(TAG, th.toString());
            this.mIgnoreFocus = EventTarget.EnableStatus.Undefined;
        }
    }

    @LynxProp(name = PropsConstants.EVENT_THROUGH)
    public void setEventThrough(Dynamic dynamic) {
        if (dynamic == null) {
            this.mEventThrough = EventTarget.EnableStatus.Undefined;
        }
        try {
            this.mEventThrough = dynamic.asBoolean() ? EventTarget.EnableStatus.Enable : EventTarget.EnableStatus.Disable;
        } catch (Throwable th) {
            LLog.i(TAG, th.toString());
            this.mEventThrough = EventTarget.EnableStatus.Undefined;
        }
    }

    @LynxProp(name = PropsConstants.POINTER_EVENTS)
    public void setPointerEvents(int i) {
        if (i < EventTarget.PointerEventsValue.Auto.ordinal() || i >= EventTarget.PointerEventsValue.Unset.ordinal()) {
            return;
        }
        this.mPointerEvents = EventTarget.PointerEventsValue.values()[i];
    }

    @LynxProp(name = PropsConstants.DATASET)
    public void setDataset(ReadableMap readableMap) {
        this.mDataset = readableMap;
    }

    public boolean needGenerateEventTargetSpan() {
        Map<String, EventsListener> map = this.mEvents;
        return ((map == null || map.isEmpty()) && this.mIgnoreFocus == EventTarget.EnableStatus.Undefined && this.mEventThrough == EventTarget.EnableStatus.Undefined && this.mPointerEvents == EventTarget.PointerEventsValue.Unset) ? false : true;
    }

    public EventTargetSpan toEventTargetSpan() {
        return new EventTargetSpan(getSignature(), this.mEvents, this.mIgnoreFocus, this.mEnableTouchPseudoPropagation, this.mEventThrough, this.mPointerEvents, this.mDataset);
    }

    @LynxProp(name = PropsConstants.ENABLE_TOUCH_PSEUDO_PROPAGATION)
    public void setEventThroughPropagation(Dynamic dynamic) {
        if (dynamic == null) {
            this.mEnableTouchPseudoPropagation = true;
            return;
        }
        try {
            this.mEnableTouchPseudoPropagation = dynamic.asBoolean();
        } catch (Throwable th) {
            LLog.i(TAG, th.toString());
            this.mEnableTouchPseudoPropagation = true;
        }
    }
}
