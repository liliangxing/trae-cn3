package com.lynx.tasm.behavior.p000ui.frame;

import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.LynxUI$$PropsSetter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIFrame$$PropsSetter extends LynxUI$$PropsSetter {
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
        UIFrame uIFrame = (UIFrame) lynxBaseUI;
        str.hashCode();
        if (str.equals(PropsConstants.SRC)) {
            uIFrame.setSrc(stylesDiffMap.getString(str));
        } else if (str.equals("data")) {
            uIFrame.setData(stylesDiffMap.getMap(str));
        } else {
            super.setProperty(lynxBaseUI, str, stylesDiffMap);
        }
    }
}
