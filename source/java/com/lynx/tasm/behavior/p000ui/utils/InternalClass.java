package com.lynx.tasm.behavior.p000ui.utils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class InternalClass {
    public static boolean isInternal(String str) {
        int length = str.length();
        if (length < 30 || length > 56) {
            return false;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2028483860:
                if (str.equals("com.bytedance.ies.xelement.LynxVideoManager")) {
                    c = 0;
                    break;
                }
                break;
            case -1854994243:
                if (str.equals("com.bytedance.ies.xelement.input.LynxTextAreaView")) {
                    c = 1;
                    break;
                }
                break;
            case -1725681285:
                if (str.equals("com.lynx.tasm.behavior.ui.view.UIComponent")) {
                    c = 2;
                    break;
                }
                break;
            case -1720131364:
                if (str.equals("com.bytedance.ies.xelement.LynxAudio")) {
                    c = 3;
                    break;
                }
                break;
            case -1712172717:
                if (str.equals("com.bytedance.ies.xelement.banner.LynxSwiperView")) {
                    c = 4;
                    break;
                }
                break;
            case -1596125177:
                if (str.equals("com.bytedance.ies.xelement.LynxBounceView")) {
                    c = 5;
                    break;
                }
                break;
            case -1573666574:
                if (str.equals("com.lynx.tasm.behavior.ui.list.AbsLynxList")) {
                    c = 6;
                    break;
                }
                break;
            case -1551876794:
                if (str.equals("com.lynx.tasm.behavior.ui.LynxUI")) {
                    c = 7;
                    break;
                }
                break;
            case -1345663129:
                if (str.equals("com.lynx.tasm.behavior.ui.view.UIView")) {
                    c = '\b';
                    break;
                }
                break;
            case -1024338617:
                if (str.equals("com.lynx.tasm.behavior.ui.list.UIList")) {
                    c = '\t';
                    break;
                }
                break;
            case -870490237:
                if (str.equals("com.lynx.tasm.behavior.ui.image.AbsUIImage")) {
                    c = '\n';
                    break;
                }
                break;
            case -682959738:
                if (str.equals("com.lynx.tasm.behavior.ui.LynxFlattenUI")) {
                    c = 11;
                    break;
                }
                break;
            case -637562189:
                if (str.equals("com.lynx.tasm.ui.image.FlattenUIImage")) {
                    c = '\f';
                    break;
                }
                break;
            case -456219100:
                if (str.equals("com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll")) {
                    c = '\r';
                    break;
                }
                break;
            case -393429139:
                if (str.equals("com.bytedance.lynx.tasm.ui.imageloader.UIImage")) {
                    c = 14;
                    break;
                }
                break;
            case -249145083:
                if (str.equals("com.bytedance.ies.xelement.pickview.LynxPickerViewColumn")) {
                    c = 15;
                    break;
                }
                break;
            case -218759993:
                if (str.equals("com.bytedance.ies.xelement.picker.LynxPickerView")) {
                    c = 16;
                    break;
                }
                break;
            case -209103412:
                if (str.equals("com.bytedance.ies.xelement.LynxScrollView")) {
                    c = 17;
                    break;
                }
                break;
            case 192726430:
                if (str.equals("com.bytedance.ies.xelement.LynxLottieView")) {
                    c = 18;
                    break;
                }
                break;
            case 537521975:
                if (str.equals("com.lynx.tasm.ui.image.UIImage")) {
                    c = 19;
                    break;
                }
                break;
            case 585766408:
                if (str.equals("com.bytedance.ies.xelement.LynxImpressionView")) {
                    c = 20;
                    break;
                }
                break;
            case 605034231:
                if (str.equals("com.lynx.tasm.behavior.ui.LynxBaseUI")) {
                    c = 21;
                    break;
                }
                break;
            case 1009264893:
                if (str.equals("com.bytedance.ies.xelement.overlay.LynxOverlayView")) {
                    c = 22;
                    break;
                }
                break;
            case 1194871167:
                if (str.equals("com.lynx.tasm.behavior.ui.text.FlattenUIText")) {
                    c = 23;
                    break;
                }
                break;
            case 1329895866:
                if (str.equals("com.bytedance.ies.xelement.LynxVideoManagerLite")) {
                    c = 24;
                    break;
                }
                break;
            case 1616759199:
                if (str.equals("com.lynx.tasm.ui.image.UIFilterImage")) {
                    c = 25;
                    break;
                }
                break;
            case 1941372425:
                if (str.equals("com.lynx.tasm.behavior.ui.swiper.XSwiperUI")) {
                    c = 26;
                    break;
                }
                break;
            case 2014648661:
                if (str.equals("com.bytedance.lynx.tasm.ui.imageloader.UIFilterImage")) {
                    c = 27;
                    break;
                }
                break;
            case 2059015650:
                if (str.equals("com.bytedance.ies.xelement.pickview.LynxPickView")) {
                    c = 28;
                    break;
                }
                break;
            case 2118870631:
                if (str.equals("com.lynx.tasm.behavior.ui.text.UIText")) {
                    c = 29;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
            case 11:
            case '\f':
            case '\r':
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
                return true;
            default:
                return false;
        }
    }
}
