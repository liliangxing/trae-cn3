package com.lynx.tasm.behavior.p000ui.image;

import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.LynxUI$$PropsSetter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AbsUIImage$$PropsSetter extends LynxUI$$PropsSetter {
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
        AbsUIImage absUIImage = (AbsUIImage) lynxBaseUI;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1937917490:
                if (str.equals(PropsConstants.CAP_INSETS_SCALE)) {
                    c = 0;
                    break;
                }
                break;
            case -1249491252:
                if (str.equals(PropsConstants.COVER_START)) {
                    c = 1;
                    break;
                }
                break;
            case -934531685:
                if (str.equals(PropsConstants.REPEAT)) {
                    c = 2;
                    break;
                }
                break;
            case -629825370:
                if (str.equals(PropsConstants.LOOP_COUNT)) {
                    c = 3;
                    break;
                }
                break;
            case -320982203:
                if (str.equals(PropsConstants.DISABLE_DEFAULT_RESIZE)) {
                    c = 4;
                    break;
                }
                break;
            case -256430480:
                if (str.equals(PropsConstants.PRE_FETCH_WIDTH)) {
                    c = 5;
                    break;
                }
                break;
            case 114148:
                if (str.equals(PropsConstants.SRC)) {
                    c = 6;
                    break;
                }
                break;
            case 3357091:
                if (str.equals(PropsConstants.MODE)) {
                    c = 7;
                    break;
                }
                break;
            case 207594941:
                if (str.equals(PropsConstants.PRE_FETCH_HEIGHT)) {
                    c = '\b';
                    break;
                }
                break;
            case 516005201:
                if (str.equals(PropsConstants.CAP_INSETS_BACKUP)) {
                    c = '\t';
                    break;
                }
                break;
            case 598246771:
                if (str.equals(PropsConstants.PLACEHOLDER)) {
                    c = '\n';
                    break;
                }
                break;
            case 681292984:
                if (str.equals(PropsConstants.BLUR_RADIUS)) {
                    c = 11;
                    break;
                }
                break;
            case 1198809474:
                if (str.equals(PropsConstants.DISABLE_DEFAULT_PLACEHOLDER)) {
                    c = '\f';
                    break;
                }
                break;
            case 1515751784:
                if (str.equals(PropsConstants.CAP_INSETS)) {
                    c = '\r';
                    break;
                }
                break;
            case 1615092063:
                if (str.equals(PropsConstants.AUTO_SIZE)) {
                    c = 14;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                absUIImage.setCapInsetsScale(stylesDiffMap.getString(str));
                return;
            case 1:
                absUIImage.setCoverStart(stylesDiffMap.getBoolean(str, false));
                return;
            case 2:
                absUIImage.setRepeat(stylesDiffMap.getBoolean(str, false));
                return;
            case 3:
                absUIImage.setLoopCount(stylesDiffMap.getInt(str, 0));
                return;
            case 4:
                absUIImage.setDisableDefaultResize(stylesDiffMap.getBoolean(str, false));
                return;
            case 5:
                absUIImage.setPreFetchWidth(stylesDiffMap.getString(str));
                return;
            case 6:
                absUIImage.setSource(stylesDiffMap.getString(str));
                return;
            case 7:
                absUIImage.setObjectFit(stylesDiffMap.getString(str));
                return;
            case '\b':
                absUIImage.setPreFetchHeight(stylesDiffMap.getString(str));
                return;
            case '\t':
                absUIImage.setCapInsetsBackUp(stylesDiffMap.getString(str));
                return;
            case '\n':
                absUIImage.setPlaceholder(stylesDiffMap.getString(str));
                return;
            case 11:
                absUIImage.setBlurRadius(stylesDiffMap.getString(str));
                return;
            case '\f':
                absUIImage.setDisableDefaultPlaceholder(stylesDiffMap.getBoolean(str, false));
                return;
            case '\r':
                absUIImage.setCapInsets(stylesDiffMap.getString(str));
                return;
            case 14:
                absUIImage.setAutoSize(stylesDiffMap.getBoolean(str, false));
                return;
            default:
                super.setProperty(lynxBaseUI, str, stylesDiffMap);
                return;
        }
    }
}
