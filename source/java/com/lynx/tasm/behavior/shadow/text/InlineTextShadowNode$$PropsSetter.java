package com.lynx.tasm.behavior.shadow.text;

import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.shadow.ShadowNode;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class InlineTextShadowNode$$PropsSetter extends BaseTextShadowNode$$PropsSetter {
    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void setProperty(ShadowNode shadowNode, String str, StylesDiffMap stylesDiffMap) {
        InlineTextShadowNode inlineTextShadowNode = (InlineTextShadowNode) shadowNode;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1820411228:
                if (str.equals(PropsConstants.BORDER_BOTTOM_RIGHT_RADIUS)) {
                    c = 0;
                    break;
                }
                break;
            case -1559879186:
                if (str.equals(PropsConstants.VERTICAL_ALIGN)) {
                    c = 1;
                    break;
                }
                break;
            case -1032412580:
                if (str.equals(PropsConstants.BORDER_TOP_RIGHT_RADIUS)) {
                    c = 2;
                    break;
                }
                break;
            case -20727064:
                if (str.equals(PropsConstants.BACKGROUND_POSITION)) {
                    c = 3;
                    break;
                }
                break;
            case 605322756:
                if (str.equals(PropsConstants.BACKGROUND_COLOR)) {
                    c = 4;
                    break;
                }
                break;
            case 609634231:
                if (str.equals(PropsConstants.BORDER_BOTTOM_LEFT_RADIUS)) {
                    c = 5;
                    break;
                }
                break;
            case 610793468:
                if (str.equals(PropsConstants.BACKGROUND_IMAGE)) {
                    c = 6;
                    break;
                }
                break;
            case 881039699:
                if (str.equals(PropsConstants.BORDER_RADIUS)) {
                    c = 7;
                    break;
                }
                break;
            case 1266923840:
                if (str.equals(PropsConstants.BACKGROUND_SIZE)) {
                    c = '\b';
                    break;
                }
                break;
            case 1466337535:
                if (str.equals(PropsConstants.BORDER_TOP_LEFT_RADIUS)) {
                    c = '\t';
                    break;
                }
                break;
            case 2005447450:
                if (str.equals(PropsConstants.BACKGROUND_REPEAT)) {
                    c = '\n';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                inlineTextShadowNode.setBorderRadius(3, stylesDiffMap.getArray(str));
                return;
            case 1:
                inlineTextShadowNode.setVerticalAlign(stylesDiffMap.getArray(str));
                return;
            case 2:
                inlineTextShadowNode.setBorderRadius(2, stylesDiffMap.getArray(str));
                return;
            case 3:
                inlineTextShadowNode.setBackgroundPosition(stylesDiffMap.getArray(str));
                return;
            case 4:
                inlineTextShadowNode.setBackgroundColor(stylesDiffMap.getInt(str, 0));
                return;
            case 5:
                inlineTextShadowNode.setBorderRadius(4, stylesDiffMap.getArray(str));
                return;
            case 6:
                inlineTextShadowNode.setBackgroundImage(stylesDiffMap.getArray(str));
                return;
            case 7:
                inlineTextShadowNode.setBorderRadius(0, stylesDiffMap.getArray(str));
                return;
            case '\b':
                inlineTextShadowNode.setBackgroundSize(stylesDiffMap.getArray(str));
                return;
            case '\t':
                inlineTextShadowNode.setBorderRadius(1, stylesDiffMap.getArray(str));
                return;
            case '\n':
                inlineTextShadowNode.setBackgroundRepeat(stylesDiffMap.getArray(str));
                return;
            default:
                super.setProperty(shadowNode, str, stylesDiffMap);
                return;
        }
    }
}
