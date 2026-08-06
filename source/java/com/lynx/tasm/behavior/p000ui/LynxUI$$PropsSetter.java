package com.lynx.tasm.behavior.p000ui;

import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxUI$$PropsSetter extends LynxBaseUI$$PropsSetter {
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
        LynxUI lynxUI = (LynxUI) lynxBaseUI;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1970593579:
                if (str.equals(PropsConstants.TEST_TAG)) {
                    c = 0;
                    break;
                }
                break;
            case -1796753876:
                if (str.equals(PropsConstants.PAUSE_TRANSITION_NAME)) {
                    c = 1;
                    break;
                }
                break;
            case -1757493843:
                if (str.equals(PropsConstants.TRANSFORM_ORDER)) {
                    c = 2;
                    break;
                }
                break;
            case -1649314686:
                if (str.equals("clip-path")) {
                    c = 3;
                    break;
                }
                break;
            case -1613231517:
                if (str.equals(PropsConstants.RESUME_TRANSITION_NAME)) {
                    c = 4;
                    break;
                }
                break;
            case -1297725862:
                if (str.equals("layout-animation-create-property")) {
                    c = 5;
                    break;
                }
                break;
            case -1274492040:
                if (str.equals(PropsConstants.FILTER)) {
                    c = 6;
                    break;
                }
                break;
            case -1267206133:
                if (str.equals(PropsConstants.OPACITY)) {
                    c = 7;
                    break;
                }
                break;
            case -1091287993:
                if (str.equals(PropsConstants.OVERLAP)) {
                    c = '\b';
                    break;
                }
                break;
            case -1087342188:
                if (str.equals(PropsConstants.SHARED_ELEMENT)) {
                    c = '\t';
                    break;
                }
                break;
            case -1013209314:
                if (str.equals("layout-animation-create-delay")) {
                    c = '\n';
                    break;
                }
                break;
            case -412530555:
                if (str.equals("layout-animation-delete-timing-function")) {
                    c = 11;
                    break;
                }
                break;
            case -397950676:
                if (str.equals(PropsConstants.RENDER_TO_HARDWARE_TEXTURE)) {
                    c = '\f';
                    break;
                }
                break;
            case -316342365:
                if (str.equals("layout-animation-update-timing-function")) {
                    c = '\r';
                    break;
                }
                break;
            case -127928127:
                if (str.equals(PropsConstants.ACCESSIBILITY_ELEMENTS_HIDDEN)) {
                    c = 14;
                    break;
                }
                break;
            case -49240502:
                if (str.equals("layout-animation-delete-duration")) {
                    c = 15;
                    break;
                }
                break;
            case 37625839:
                if (str.equals(PropsConstants.OFFSET_DISTANCE)) {
                    c = 16;
                    break;
                }
                break;
            case 315007413:
                if (str.equals(PropsConstants.ACCESSIBILITY_LABEL)) {
                    c = 17;
                    break;
                }
                break;
            case 374052076:
                if (str.equals("layout-animation-update-duration")) {
                    c = 18;
                    break;
                }
                break;
            case 633600340:
                if (str.equals(PropsConstants.EXIT_TRANSITION_NAME)) {
                    c = 19;
                    break;
                }
                break;
            case 714841829:
                if (str.equals(PropsConstants.ENABLE_REUSE_ANIMATION_STATE)) {
                    c = 20;
                    break;
                }
                break;
            case 805728555:
                if (str.equals("layout-animation-update-delay")) {
                    c = 21;
                    break;
                }
                break;
            case 839919573:
                if (str.equals(PropsConstants.OFFSET_ROTATE)) {
                    c = 22;
                    break;
                }
                break;
            case 949630603:
                if (str.equals("layout-animation-delete-property")) {
                    c = 23;
                    break;
                }
                break;
            case 985926797:
                if (str.equals("layout-animation-delete-delay")) {
                    c = 24;
                    break;
                }
                break;
            case 1052666732:
                if (str.equals(PropsConstants.TRANSFORM)) {
                    c = 25;
                    break;
                }
                break;
            case 1229849887:
                if (str.equals(PropsConstants.OFFSET_PATH)) {
                    c = 26;
                    break;
                }
                break;
            case 1372923181:
                if (str.equals("layout-animation-update-property")) {
                    c = 27;
                    break;
                }
                break;
            case 1485345550:
                if (str.equals(PropsConstants.ENTER_TRANSITION_NAME)) {
                    c = 28;
                    break;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c = 29;
                    break;
                }
                break;
            case 1998370329:
                if (str.equals("layout-animation-create-duration")) {
                    c = 30;
                    break;
                }
                break;
            case 2022810070:
                if (str.equals("layout-animation-create-timing-function")) {
                    c = 31;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                lynxUI.setTestID(stylesDiffMap.getString(str));
                return;
            case 1:
                lynxUI.setPauseTransitionName(stylesDiffMap.getArray(str));
                return;
            case 2:
                lynxUI.setTransformOrder(stylesDiffMap.getDynamic(str));
                return;
            case 3:
                lynxUI.setClipPath(stylesDiffMap.getArray(str));
                return;
            case 4:
                lynxUI.setResumeTransitionName(stylesDiffMap.getArray(str));
                return;
            case 5:
                lynxUI.setLayoutAnimationCreateProperty(stylesDiffMap.getInt(str, 0));
                return;
            case 6:
                lynxUI.setFilter(stylesDiffMap.getArray(str));
                return;
            case 7:
                lynxUI.setAlpha(stylesDiffMap.getFloat(str, 1.0f));
                return;
            case '\b':
                lynxUI.setOverlap(stylesDiffMap.getDynamic(str));
                return;
            case '\t':
                lynxUI.setShareElement(stylesDiffMap.getString(str));
                return;
            case '\n':
                lynxUI.setLayoutAnimationCreateDelay(stylesDiffMap.getDouble(str, 0.0d));
                return;
            case 11:
                lynxUI.setLayoutAnimationDeleteTimingFunc(stylesDiffMap.getArray(str));
                return;
            case '\f':
                lynxUI.setRenderToHardwareTexture(stylesDiffMap.getBoolean(str, false));
                return;
            case '\r':
                lynxUI.setLayoutAnimationUpdateTimingFunc(stylesDiffMap.getArray(str));
                return;
            case 14:
                lynxUI.setAccessibilityElementsHidden(stylesDiffMap.getBoolean(str, false));
                return;
            case 15:
                lynxUI.setLayoutAnimationDeleteDuration(stylesDiffMap.getDouble(str, 0.0d));
                return;
            case 16:
                lynxUI.setOffsetDistance(stylesDiffMap.getFloat(str, 0.0f));
                return;
            case 17:
                lynxUI.setAccessibilityLabel(stylesDiffMap.getDynamic(str));
                return;
            case 18:
                lynxUI.setLayoutAnimationUpdateDuration(stylesDiffMap.getDouble(str, 0.0d));
                return;
            case 19:
                lynxUI.setExitTransitionName(stylesDiffMap.getArray(str));
                return;
            case 20:
                lynxUI.setEnableReuseAnimationState(stylesDiffMap.getBoolean(str, true));
                return;
            case 21:
                lynxUI.setLayoutAnimationUpdateDelay(stylesDiffMap.getDouble(str, 0.0d));
                return;
            case 22:
                lynxUI.setOffsetRotate(stylesDiffMap.getFloat(str, 0.0f));
                return;
            case 23:
                lynxUI.setLayoutAnimationDeleteProperty(stylesDiffMap.getInt(str, 0));
                return;
            case 24:
                lynxUI.setLayoutAnimationDeleteDelay(stylesDiffMap.getDouble(str, 0.0d));
                return;
            case 25:
                lynxUI.setTransform(stylesDiffMap.getArray(str));
                return;
            case 26:
                lynxUI.setOffsetPath(stylesDiffMap.getArray(str));
                return;
            case 27:
                lynxUI.setLayoutAnimationUpdateProperty(stylesDiffMap.getInt(str, 0));
                return;
            case 28:
                lynxUI.setEnterTransitionName(stylesDiffMap.getArray(str));
                return;
            case 29:
                lynxUI.setVisibility(stylesDiffMap.getInt(str, 1));
                return;
            case 30:
                lynxUI.setLayoutAnimationCreateDuration(stylesDiffMap.getDouble(str, 0.0d));
                return;
            case 31:
                lynxUI.setLayoutAnimationCreateTimingFunc(stylesDiffMap.getArray(str));
                return;
            default:
                super.setProperty(lynxBaseUI, str, stylesDiffMap);
                return;
        }
    }
}
