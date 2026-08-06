package com.lynx.tasm.behavior.p000ui.scroll;

import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIScrollView$$PropsSetter extends AbsLynxUIScroll$$PropsSetter {
    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll$$PropsSetter, com.lynx.tasm.behavior.p000ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.p000ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
        UIScrollView uIScrollView = (UIScrollView) lynxBaseUI;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1305579111:
                if (str.equals("enable-nested-scroll")) {
                    c = 0;
                    break;
                }
                break;
            case -746453530:
                if (str.equals("android-touch-slop")) {
                    c = 1;
                    break;
                }
                break;
            case -711580976:
                if (str.equals("scroll-orientation")) {
                    c = 2;
                    break;
                }
                break;
            case 293962082:
                if (str.equals("fading-edge-length")) {
                    c = 3;
                    break;
                }
                break;
            case 294508746:
                if (str.equals("initial-scroll-offset")) {
                    c = 4;
                    break;
                }
                break;
            case 616977828:
                if (str.equals("android-preference-consume-gesture")) {
                    c = 5;
                    break;
                }
                break;
            case 1013897100:
                if (str.equals("force-can-scroll")) {
                    c = 6;
                    break;
                }
                break;
            case 1730905463:
                if (str.equals("initial-scroll-to-index")) {
                    c = 7;
                    break;
                }
                break;
            case 1868120577:
                if (str.equals("android-enable-new-bounce")) {
                    c = '\b';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                uIScrollView.setEnableNestedScroll(stylesDiffMap.getBoolean(str, false));
                return;
            case 1:
                uIScrollView.setTouchSlop(stylesDiffMap.getString(str));
                return;
            case 2:
                uIScrollView.setScrollOrientation(stylesDiffMap.getString(str));
                return;
            case 3:
                uIScrollView.setFadingEdgeLength(stylesDiffMap.getString(str));
                return;
            case 4:
                uIScrollView.setInitialScrollOffset(stylesDiffMap.isNull(str) ? null : Integer.valueOf(stylesDiffMap.getInt(str, 0)));
                return;
            case 5:
                uIScrollView.setPreferenceConsumeGesture(stylesDiffMap.getBoolean(str, false));
                return;
            case 6:
                uIScrollView.setForceCanScroll(stylesDiffMap.getBoolean(str, false));
                return;
            case 7:
                uIScrollView.setInitialScrollToIndex(stylesDiffMap.isNull(str) ? null : Integer.valueOf(stylesDiffMap.getInt(str, 0)));
                return;
            case '\b':
                uIScrollView.setEnableNewBounce(stylesDiffMap.getBoolean(str, false));
                return;
            default:
                super.setProperty(lynxBaseUI, str, stylesDiffMap);
                return;
        }
    }
}
