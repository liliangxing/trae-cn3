package com.lynx.tasm.behavior.shadow.text;

import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.shadow.ShadowNode;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TextShadowNode$$PropsSetter extends BaseTextShadowNode$$PropsSetter {
    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void setProperty(ShadowNode shadowNode, String str, StylesDiffMap stylesDiffMap) {
        TextShadowNode textShadowNode = (TextShadowNode) shadowNode;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1801128308:
                if (str.equals("tail-color-convert")) {
                    c = 0;
                    break;
                }
                break;
            case -1215680224:
                if (str.equals(PropsConstants.LINE_HEIGHT)) {
                    c = 1;
                    break;
                }
                break;
            case -356469693:
                if (str.equals(PropsConstants.X_AUTO_FONT_SIZE)) {
                    c = 2;
                    break;
                }
                break;
            case 679001436:
                if (str.equals("enable-full-justify")) {
                    c = 3;
                    break;
                }
                break;
            case 1381862785:
                if (str.equals(PropsConstants.HYPHENS)) {
                    c = 4;
                    break;
                }
                break;
            case 1713623170:
                if (str.equals("text-single-line-vertical-align")) {
                    c = 5;
                    break;
                }
                break;
            case 2010704238:
                if (str.equals(PropsConstants.X_AUTO_FONT_SIZE_PRESET_SIZES)) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                textShadowNode.setEnableTailColorConvert(stylesDiffMap.getBoolean(str, false));
                return;
            case 1:
                textShadowNode.setLineHeight(stylesDiffMap.getFloat(str, 1.0E21f));
                return;
            case 2:
                textShadowNode.setAutoFontSize(stylesDiffMap.getArray(str));
                return;
            case 3:
                textShadowNode.setEnableFullJustify(stylesDiffMap.getBoolean(str, false));
                return;
            case 4:
                textShadowNode.setHyphen(stylesDiffMap.getInt(str, 0));
                return;
            case 5:
                textShadowNode.setVerticalTextAlign(stylesDiffMap.getString(str));
                return;
            case 6:
                textShadowNode.setAutoFontSizePresetSizes(stylesDiffMap.getArray(str));
                return;
            default:
                super.setProperty(shadowNode, str, stylesDiffMap);
                return;
        }
    }
}
