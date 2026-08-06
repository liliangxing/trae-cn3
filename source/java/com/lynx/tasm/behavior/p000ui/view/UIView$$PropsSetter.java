package com.lynx.tasm.behavior.p000ui.view;

import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIView$$PropsSetter extends UISimpleView$$PropsSetter {
    @Override // com.lynx.tasm.behavior.p000ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.p000ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
        UIView uIView = (UIView) lynxBaseUI;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1389119727:
                if (str.equals("impression_id")) {
                    c = 0;
                    break;
                }
                break;
            case -505576881:
                if (str.equals("copyable")) {
                    c = 1;
                    break;
                }
                break;
            case -400775539:
                if (str.equals("blur-sampling")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                uIView.setImpressionId(stylesDiffMap.getString(str));
                return;
            case 1:
                uIView.copyable(stylesDiffMap.getBoolean(str, false));
                return;
            case 2:
                uIView.setBlurSampling(stylesDiffMap.getInt(str, 0));
                return;
            default:
                super.setProperty(lynxBaseUI, str, stylesDiffMap);
                return;
        }
    }
}
