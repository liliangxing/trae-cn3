package com.lynx.tasm.behavior.p000ui.text;

import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.UIGroup$$PropsSetter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIText$$PropsSetter extends UIGroup$$PropsSetter {
    @Override // com.lynx.tasm.behavior.p000ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
        UIText uIText = (UIText) lynxBaseUI;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1157887457:
                if (str.equals("selection-handle-color")) {
                    c = 0;
                    break;
                }
                break;
            case -1145258555:
                if (str.equals("selection-handle-size")) {
                    c = 1;
                    break;
                }
                break;
            case 263767276:
                if (str.equals("text-selection")) {
                    c = 2;
                    break;
                }
                break;
            case 298809032:
                if (str.equals("custom-text-selection")) {
                    c = 3;
                    break;
                }
                break;
            case 315007413:
                if (str.equals(PropsConstants.ACCESSIBILITY_LABEL)) {
                    c = 4;
                    break;
                }
                break;
            case 543207321:
                if (str.equals("custom-context-menu")) {
                    c = 5;
                    break;
                }
                break;
            case 1137695781:
                if (str.equals("selection-background-color")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                uIText.setSelectionHandleColor(stylesDiffMap.getInt(str, 0));
                return;
            case 1:
                uIText.setSelectionHandleSize(stylesDiffMap.getInt(str, 0));
                return;
            case 2:
                uIText.setEnableTextSelection(stylesDiffMap.getBoolean(str, false));
                return;
            case 3:
                uIText.setCustomTextSelection(stylesDiffMap.getBoolean(str, false));
                return;
            case 4:
                uIText.setAccessibilityLabel(stylesDiffMap.getDynamic(str));
                return;
            case 5:
                uIText.setCustomContextMenu(stylesDiffMap.getBoolean(str, false));
                return;
            case 6:
                uIText.setSelectionBackgroundColor(stylesDiffMap.getInt(str, 0));
                return;
            default:
                super.setProperty(lynxBaseUI, str, stylesDiffMap);
                return;
        }
    }
}
