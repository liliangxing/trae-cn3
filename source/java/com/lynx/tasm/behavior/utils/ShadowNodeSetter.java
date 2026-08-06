package com.lynx.tasm.behavior.utils;

import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.shadow.ShadowNode;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface ShadowNodeSetter<T extends ShadowNode> extends Settable {
    void setProperty(ShadowNode shadowNode, String str, StylesDiffMap stylesDiffMap);
}
