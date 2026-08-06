package com.lynx.tasm.p001ui.image;

import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode$$PropsSetter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FrescoInlineImageShadowNode$$PropsSetter extends AbsInlineImageShadowNode$$PropsSetter {
    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void setProperty(ShadowNode shadowNode, String str, StylesDiffMap stylesDiffMap) {
        FrescoInlineImageShadowNode frescoInlineImageShadowNode = (FrescoInlineImageShadowNode) shadowNode;
        str.hashCode();
        if (str.equals(PropsConstants.SKIP_REDIRECTION)) {
            frescoInlineImageShadowNode.setSkipRedirection(stylesDiffMap.getBoolean(str, false));
        } else if (str.equals(PropsConstants.LOOP_COUNT)) {
            frescoInlineImageShadowNode.setLoopCount(stylesDiffMap.getInt(str, 0));
        } else {
            super.setProperty(shadowNode, str, stylesDiffMap);
        }
    }
}
