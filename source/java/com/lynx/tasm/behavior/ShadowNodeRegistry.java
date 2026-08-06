package com.lynx.tasm.behavior;

import android.util.SparseArray;
import com.lynx.tasm.behavior.shadow.ShadowNode;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ShadowNodeRegistry {
    private final SparseArray<ShadowNode> mShadowNodeList = new SparseArray<>();

    public void addNode(ShadowNode shadowNode) {
        this.mShadowNodeList.put(shadowNode.getSignature(), shadowNode);
    }

    public ShadowNode removeNode(int i) {
        ShadowNode shadowNode = this.mShadowNodeList.get(i);
        this.mShadowNodeList.remove(i);
        return shadowNode;
    }

    public ShadowNode getNode(int i) {
        return this.mShadowNodeList.get(i);
    }

    public SparseArray<ShadowNode> getAllNodes() {
        return this.mShadowNodeList;
    }
}
