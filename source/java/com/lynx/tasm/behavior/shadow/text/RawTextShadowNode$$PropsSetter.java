package com.lynx.tasm.behavior.shadow.text;

import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RawTextShadowNode$$PropsSetter extends ShadowNode$$PropsSetter {
    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void setProperty(ShadowNode shadowNode, String str, StylesDiffMap stylesDiffMap) {
        RawTextShadowNode rawTextShadowNode = (RawTextShadowNode) shadowNode;
        str.hashCode();
        if (str.equals("pseudo")) {
            rawTextShadowNode.setPsuedo(stylesDiffMap.getBoolean(str, false));
        } else if (str.equals(PropsConstants.TEXT)) {
            rawTextShadowNode.setText(stylesDiffMap.getDynamic(str));
        } else {
            super.setProperty(shadowNode, str, stylesDiffMap);
        }
    }
}
