package com.lynx.tasm.behavior;

import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.p000ui.PropBundle;
import com.lynx.tasm.behavior.shadow.LayoutTick;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.event.EventsListener;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ShadowNodeOwner extends LayoutContext {
    private static final String TAG = "ShadowNodeOwner";
    private final BehaviorRegistry mBehaviorRegistry;
    private final LayoutTick mLayoutTick;
    private LynxContext mLynxContext;
    private final ShadowNodeRegistry mShadowNodeRegistry = new ShadowNodeRegistry();
    protected LayoutNodeManager mLayoutNodeManager = new LayoutNodeManager();

    public ShadowNodeOwner(LynxContext lynxContext, BehaviorRegistry behaviorRegistry, LayoutTick layoutTick) {
        this.mLynxContext = lynxContext;
        this.mBehaviorRegistry = behaviorRegistry;
        this.mLayoutTick = layoutTick;
        createNativeLayoutContext(this);
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public void detachNativePtr() {
        SparseArray<ShadowNode> allNodes;
        super.detachNativePtr();
        ShadowNodeRegistry shadowNodeRegistry = this.mShadowNodeRegistry;
        if (shadowNodeRegistry == null || (allNodes = shadowNodeRegistry.getAllNodes()) == null || allNodes.size() <= 0) {
            return;
        }
        for (int i = 0; i < allNodes.size(); i++) {
            allNodes.valueAt(i).destroy();
        }
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public int createNode(int i, String str, PropBundle propBundle, ReadableMapBuffer readableMapBuffer, boolean z) {
        return createNode(i, str, propBundle != null ? propBundle.getProps() : null, readableMapBuffer, propBundle != null ? propBundle.getEventHandlers() : null, z);
    }

    public int createNode(int i, String str, ReadableMap readableMap, ReadableMapBuffer readableMapBuffer, ReadableArray readableArray, boolean z) {
        int i2;
        ShadowNode createShadowNode = this.mBehaviorRegistry.get(str).createShadowNode();
        if (createShadowNode != null) {
            i2 = 4;
        } else {
            i2 = 1;
            if (!z) {
                return 1;
            }
            createShadowNode = new NativeLayoutNodeRef();
        }
        createShadowNode.setSignature(i);
        createShadowNode.setTagName(str);
        createShadowNode.setContext(this.mLynxContext);
        createShadowNode.setLayoutNodeManager(this.mLayoutNodeManager);
        createShadowNode.setEvents(EventsListener.convertEventListeners(readableArray));
        this.mShadowNodeRegistry.addNode(createShadowNode);
        if (readableMap != null) {
            createShadowNode.updateProperties(new StylesDiffMap(readableMap, readableMapBuffer));
        }
        if (!isDestroyed()) {
            createShadowNode.attachNativePtr(1L);
        }
        if (createShadowNode.isVirtual()) {
            i2 |= 2;
        }
        return (z && createShadowNode.supportInlineView()) ? i2 | 32 : i2;
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public void removeNode(int i, int i2, int i3) {
        ShadowNode node = this.mShadowNodeRegistry.getNode(i);
        if (node == null) {
            return;
        }
        try {
            node.removeChildAt(i3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            LLog.w(TAG, "Remove child out of bounds, parentSignature: " + i + ", index: " + i3 + ", childSignature: " + i2);
        }
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public void insertNode(int i, int i2, int i3) {
        ShadowNode node = this.mShadowNodeRegistry.getNode(i);
        ShadowNode node2 = this.mShadowNodeRegistry.getNode(i2);
        if (i3 == -1) {
            i3 = node.getChildCount();
        }
        try {
            node.addChildAt(node2, i3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            LLog.w(TAG, "Add child out of bounds, parentSignature: " + i + ", index: " + i3 + ", childSignature: " + i2);
        }
        node.markDirty();
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public void moveNode(int i, int i2, int i3, int i4) {
        ShadowNode node = this.mShadowNodeRegistry.getNode(i);
        ShadowNode node2 = this.mShadowNodeRegistry.getNode(i2);
        node.removeChildAt(i3);
        node.addChildAt(node2, i4);
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public void destroyNodes(int[] iArr) {
        for (int i : iArr) {
            ShadowNode removeNode = this.mShadowNodeRegistry.removeNode(i);
            if (removeNode != null) {
                removeNode.destroy();
            }
        }
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public void dispatchOnLayoutBefore(int i) {
        this.mShadowNodeRegistry.getNode(i).onLayoutBefore();
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public void dispatchOnLayout(int i, int i2, int i3, int i4, int i5) {
        this.mShadowNodeRegistry.getNode(i).onLayout(i2, i3, i4, i5);
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public void updateProps(int i, PropBundle propBundle, ReadableMapBuffer readableMapBuffer) {
        updateProps(i, propBundle != null ? propBundle.getProps() : null, readableMapBuffer, propBundle != null ? propBundle.getEventHandlers() : null);
    }

    public void updateProps(int i, ReadableMap readableMap, ReadableMapBuffer readableMapBuffer, ReadableArray readableArray) {
        ShadowNode node = this.mShadowNodeRegistry.getNode(i);
        if (node == null) {
            throw new RuntimeException("Trying to update non-existent view with tag " + i);
        }
        if (readableMap != null) {
            node.updateProperties(new StylesDiffMap(readableMap, readableMapBuffer));
        }
        if (readableArray != null) {
            node.setEvents(EventsListener.convertEventListeners(readableArray));
        }
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public void setFontFaces(ReadableMap readableMap) {
        this.mLynxContext.setFontFaces(readableMap.getMap("fontfaces"));
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public Object getExtraBundle(int i) {
        ShadowNode node = this.mShadowNodeRegistry.getNode(i);
        if (node == null) {
            return null;
        }
        return node.getExtraBundle();
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public void attachLayoutNodeManager(long j) {
        this.mLayoutNodeManager.attachNativePtr(j);
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public DisplayMetrics getScreenMetrics() {
        return this.mLynxContext.getScreenMetrics();
    }

    private void requestRelayout() {
        this.mLayoutTick.request(new Runnable() { // from class: com.lynx.tasm.behavior.ShadowNodeOwner.1
            @Override // java.lang.Runnable
            public void run() {
                ShadowNodeOwner.this.triggerLayout();
            }
        });
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    protected void scheduleLayout() {
        if (isDestroyed()) {
            return;
        }
        requestRelayout();
    }

    public ShadowNode getShadowNode(int i) {
        return this.mShadowNodeRegistry.getNode(i);
    }
}
