package com.lynx.tasm.behavior.p000ui.view;

import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIComponent$$PropsSetter extends UIView$$PropsSetter {
    @Override // com.lynx.tasm.behavior.p000ui.view.UIView$$PropsSetter, com.lynx.tasm.behavior.p000ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.p000ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
        UIComponent uIComponent = (UIComponent) lynxBaseUI;
        str.hashCode();
        if (str.equals(PropsConstants.Z_INDEX)) {
            uIComponent.setZIndex(stylesDiffMap.getInt(str, 0));
        } else if (str.equals(PropsConstants.ITEM_KEY)) {
            uIComponent.setItemKey(stylesDiffMap.getString(str));
        } else {
            super.setProperty(lynxBaseUI, str, stylesDiffMap);
        }
    }
}
