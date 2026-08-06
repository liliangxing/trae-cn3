package com.lynx.tasm.behavior.p000ui;

import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxFlattenUI$$PropsSetter extends LynxBaseUI$$PropsSetter {
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
        LynxFlattenUI lynxFlattenUI = (LynxFlattenUI) lynxBaseUI;
        str.hashCode();
        if (str.equals(PropsConstants.OPACITY)) {
            lynxFlattenUI.setAlpha(stylesDiffMap.getFloat(str, 1.0f));
        } else if (str.equals(PropsConstants.TRANSFORM)) {
            lynxFlattenUI.setTransform(stylesDiffMap.getArray(str));
        } else {
            super.setProperty(lynxBaseUI, str, stylesDiffMap);
        }
    }
}
