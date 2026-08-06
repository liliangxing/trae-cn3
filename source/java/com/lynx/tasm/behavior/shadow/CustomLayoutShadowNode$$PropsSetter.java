package com.lynx.tasm.behavior.shadow;

import com.lynx.tasm.behavior.StylesDiffMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CustomLayoutShadowNode$$PropsSetter extends ShadowNode$$PropsSetter {
    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void setProperty(ShadowNode shadowNode, String str, StylesDiffMap stylesDiffMap) {
        CustomLayoutShadowNode customLayoutShadowNode = (CustomLayoutShadowNode) shadowNode;
        str.hashCode();
        if (str.equals("custom-layout")) {
            customLayoutShadowNode.setCustomLayout(stylesDiffMap.getBoolean(str, false));
        } else {
            super.setProperty(shadowNode, str, stylesDiffMap);
        }
    }
}
