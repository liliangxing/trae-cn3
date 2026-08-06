package com.lynx.tasm.behavior.p000ui.scroll;

import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.view.UISimpleView$$PropsSetter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AbsLynxUIScroll$$PropsSetter extends UISimpleView$$PropsSetter {
    @Override // com.lynx.tasm.behavior.p000ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.p000ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
        AbsLynxUIScroll absLynxUIScroll = (AbsLynxUIScroll) lynxBaseUI;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2039913758:
                if (str.equals("block-descendant-focusability")) {
                    c = 0;
                    break;
                }
                break;
            case -2032847360:
                if (str.equals("scroll-to-index")) {
                    c = 1;
                    break;
                }
                break;
            case -1571036001:
                if (str.equals("lower-threshold")) {
                    c = 2;
                    break;
                }
                break;
            case -445000626:
                if (str.equals("enable-new-nested")) {
                    c = 3;
                    break;
                }
                break;
            case -402166408:
                if (str.equals("scroll-x")) {
                    c = 4;
                    break;
                }
                break;
            case -402166407:
                if (str.equals("scroll-y")) {
                    c = 5;
                    break;
                }
                break;
            case -169901481:
                if (str.equals("enable-scroll")) {
                    c = 6;
                    break;
                }
                break;
            case 65137827:
                if (str.equals("scroll-tap")) {
                    c = 7;
                    break;
                }
                break;
            case 65138261:
                if (str.equals("scroll-top")) {
                    c = '\b';
                    break;
                }
                break;
            case 257565167:
                if (str.equals("forbid-fling-focus-change")) {
                    c = '\t';
                    break;
                }
                break;
            case 660290816:
                if (str.equals("upper-threshold")) {
                    c = '\n';
                    break;
                }
                break;
            case 1751260029:
                if (str.equals("scroll-bar-enable")) {
                    c = 11;
                    break;
                }
                break;
            case 2019037959:
                if (str.equals("scroll-left")) {
                    c = '\f';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                absLynxUIScroll.setBlockDescendantFocusability(stylesDiffMap.getBoolean(str, false));
                return;
            case 1:
                absLynxUIScroll.scrollToIndex(stylesDiffMap.getInt(str, 0));
                return;
            case 2:
                absLynxUIScroll.setLowerThreshole(stylesDiffMap.getInt(str, 0));
                return;
            case 3:
                absLynxUIScroll.setEnableNewNested(stylesDiffMap.getBoolean(str, false));
                return;
            case 4:
                absLynxUIScroll.setScrollX(stylesDiffMap.getDynamic(str));
                return;
            case 5:
                absLynxUIScroll.setScrollY(stylesDiffMap.getDynamic(str));
                return;
            case 6:
                absLynxUIScroll.setEnableScroll(stylesDiffMap.getBoolean(str, true));
                return;
            case 7:
                absLynxUIScroll.setScrollTap(stylesDiffMap.getBoolean(str, false));
                return;
            case '\b':
                absLynxUIScroll.setScrollTop(stylesDiffMap.getInt(str, 0));
                return;
            case '\t':
                absLynxUIScroll.setForbidFlingFocusChange(stylesDiffMap.getBoolean(str, false));
                return;
            case '\n':
                absLynxUIScroll.setUpperThreshole(stylesDiffMap.getInt(str, 0));
                return;
            case 11:
                absLynxUIScroll.setScrollBarEnable(stylesDiffMap.getBoolean(str, false));
                return;
            case '\f':
                absLynxUIScroll.setScrollLeft(stylesDiffMap.getInt(str, 0));
                return;
            default:
                super.setProperty(lynxBaseUI, str, stylesDiffMap);
                return;
        }
    }
}
