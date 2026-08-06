package com.lynx.tasm.p001ui.image;

import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIFilterImage$$PropsSetter extends UIImage$$PropsSetter {
    @Override // com.lynx.tasm.p001ui.image.UIImage$$PropsSetter, com.lynx.tasm.behavior.p000ui.image.AbsUIImage$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
        UIFilterImage uIFilterImage = (UIFilterImage) lynxBaseUI;
        str.hashCode();
        if (str.equals("drop-shadow")) {
            uIFilterImage.setDropShadow(stylesDiffMap.getString(str));
        } else {
            super.setProperty(lynxBaseUI, str, stylesDiffMap);
        }
    }
}
