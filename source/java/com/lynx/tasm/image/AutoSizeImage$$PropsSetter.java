package com.lynx.tasm.image;

import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AutoSizeImage$$PropsSetter extends ShadowNode$$PropsSetter {
    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void setProperty(ShadowNode shadowNode, String str, StylesDiffMap stylesDiffMap) {
        AutoSizeImage autoSizeImage = (AutoSizeImage) shadowNode;
        str.hashCode();
        if (str.equals(PropsConstants.SRC)) {
            autoSizeImage.setSrc(stylesDiffMap.getString(str));
        } else {
            super.setProperty(shadowNode, str, stylesDiffMap);
        }
    }
}
