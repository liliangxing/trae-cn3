package com.lynx.tasm.behavior.p000ui.scroll;

import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxUIScrollView$$PropsSetter extends LynxUIScrollViewInternal$$PropsSetter {
    @Override // com.lynx.tasm.behavior.p000ui.scroll.LynxUIScrollViewInternal$$PropsSetter, com.lynx.tasm.behavior.p000ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.p000ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
        LynxUIScrollView lynxUIScrollView = (LynxUIScrollView) lynxBaseUI;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2116748730:
                if (str.equals("backwards-nested-scroll")) {
                    c = 0;
                    break;
                }
                break;
            case -1571036001:
                if (str.equals("lower-threshold")) {
                    c = 1;
                    break;
                }
                break;
            case -1475521756:
                if (str.equals("forwards-nested-scroll")) {
                    c = 2;
                    break;
                }
                break;
            case -711580976:
                if (str.equals("scroll-orientation")) {
                    c = 3;
                    break;
                }
                break;
            case -411446853:
                if (str.equals("initial-scroll-index")) {
                    c = 4;
                    break;
                }
                break;
            case -169901481:
                if (str.equals("enable-scroll")) {
                    c = 5;
                    break;
                }
                break;
            case 70310635:
                if (str.equals("bounces")) {
                    c = 6;
                    break;
                }
                break;
            case 294508746:
                if (str.equals("initial-scroll-offset")) {
                    c = 7;
                    break;
                }
                break;
            case 660290816:
                if (str.equals("upper-threshold")) {
                    c = '\b';
                    break;
                }
                break;
            case 875338749:
                if (str.equals("scroll-event-throttle")) {
                    c = '\t';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                lynxUIScrollView.setBackwardsNestedScroll(stylesDiffMap.getInt(str, 0));
                return;
            case 1:
                lynxUIScrollView.setLowerThreshold(stylesDiffMap.getString(str));
                return;
            case 2:
                lynxUIScrollView.setForwardsNestedScroll(stylesDiffMap.getInt(str, 0));
                return;
            case 3:
                lynxUIScrollView.setScrollOrientation(stylesDiffMap.getString(str));
                return;
            case 4:
                lynxUIScrollView.setInitialScrollIndex(stylesDiffMap.getInt(str, 0));
                return;
            case 5:
                lynxUIScrollView.setEnableScroll(stylesDiffMap.getBoolean(str, false));
                return;
            case 6:
                lynxUIScrollView.setBounces(stylesDiffMap.getBoolean(str, false));
                return;
            case 7:
                lynxUIScrollView.setInitialScrollOffset(stylesDiffMap.getString(str));
                return;
            case '\b':
                lynxUIScrollView.setUpperThreshold(stylesDiffMap.getString(str));
                return;
            case '\t':
                lynxUIScrollView.setScrollEventThrottle(stylesDiffMap.getFloat(str, 0.0f));
                return;
            default:
                super.setProperty(lynxBaseUI, str, stylesDiffMap);
                return;
        }
    }
}
