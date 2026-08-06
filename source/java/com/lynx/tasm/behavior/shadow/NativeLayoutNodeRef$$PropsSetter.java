package com.lynx.tasm.behavior.shadow;

import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NativeLayoutNodeRef$$PropsSetter extends ShadowNode$$PropsSetter {
    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void setProperty(ShadowNode shadowNode, String str, StylesDiffMap stylesDiffMap) {
        NativeLayoutNodeRef nativeLayoutNodeRef = (NativeLayoutNodeRef) shadowNode;
        str.hashCode();
        if (str.equals(PropsConstants.VERTICAL_ALIGN)) {
            nativeLayoutNodeRef.setVerticalAlign(stylesDiffMap.getArray(str));
        } else if (str.equals(PropsConstants.ID_SELECTOR)) {
            nativeLayoutNodeRef.setIdSelector(stylesDiffMap.getString(str));
        } else {
            super.setProperty(shadowNode, str, stylesDiffMap);
        }
    }
}
