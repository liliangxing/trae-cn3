package com.lynx.tasm.behavior.shadow.text;

import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.shadow.ShadowNode;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AbsInlineImageShadowNode$$PropsSetter extends BaseTextShadowNode$$PropsSetter {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void setProperty(ShadowNode shadowNode, String str, StylesDiffMap stylesDiffMap) {
        char c;
        AbsInlineImageShadowNode absInlineImageShadowNode = (AbsInlineImageShadowNode) shadowNode;
        str.hashCode();
        switch (str.hashCode()) {
            case -1820411228:
                if (str.equals(PropsConstants.BORDER_BOTTOM_RIGHT_RADIUS)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1559879186:
                if (str.equals(PropsConstants.VERTICAL_ALIGN)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1032412580:
                if (str.equals(PropsConstants.BORDER_TOP_RIGHT_RADIUS)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -585734562:
                if (str.equals(PropsConstants.BORDER_LEFT_COLOR)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -570796884:
                if (str.equals(PropsConstants.BORDER_LEFT_STYLE)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -567450431:
                if (str.equals(PropsConstants.BORDER_LEFT_WIDTH)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 114148:
                if (str.equals(PropsConstants.SRC)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 3357091:
                if (str.equals(PropsConstants.MODE)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 143851658:
                if (str.equals(PropsConstants.BORDER_TOP_COLOR)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 158789336:
                if (str.equals(PropsConstants.BORDER_TOP_STYLE)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 162135789:
                if (str.equals(PropsConstants.BORDER_TOP_WIDTH)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 307025104:
                if (str.equals(PropsConstants.BORDER_STYLE)) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 310371557:
                if (str.equals(PropsConstants.BORDER_WIDTH)) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 419144785:
                if (str.equals(PropsConstants.BORDER_RIGHT_COLOR)) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 434082463:
                if (str.equals(PropsConstants.BORDER_RIGHT_STYLE)) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 437428916:
                if (str.equals(PropsConstants.BORDER_RIGHT_WIDTH)) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 605322756:
                if (str.equals(PropsConstants.BACKGROUND_COLOR)) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 609634231:
                if (str.equals(PropsConstants.BORDER_BOTTOM_LEFT_RADIUS)) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 881039699:
                if (str.equals(PropsConstants.BORDER_RADIUS)) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 956705090:
                if (str.equals(PropsConstants.BORDER_BOTTOM_COLOR)) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 971642768:
                if (str.equals(PropsConstants.BORDER_BOTTOM_STYLE)) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 974989221:
                if (str.equals(PropsConstants.BORDER_BOTTOM_WIDTH)) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 1466337535:
                if (str.equals(PropsConstants.BORDER_TOP_LEFT_RADIUS)) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                absInlineImageShadowNode.setBorderRadius(3, stylesDiffMap.getArray(str));
                return;
            case 1:
                absInlineImageShadowNode.setVerticalAlign(stylesDiffMap.getArray(str));
                return;
            case 2:
                absInlineImageShadowNode.setBorderRadius(2, stylesDiffMap.getArray(str));
                return;
            case 3:
                absInlineImageShadowNode.setBorderColor(0, stylesDiffMap.isNull(str) ? null : Integer.valueOf(stylesDiffMap.getInt(str, 0)));
                return;
            case 4:
                absInlineImageShadowNode.setBorderStyle(1, stylesDiffMap.getInt(str, -1));
                return;
            case 5:
                absInlineImageShadowNode.setBorderWidth(1, stylesDiffMap.getInt(str, 0));
                return;
            case 6:
                absInlineImageShadowNode.setSource(stylesDiffMap.getString(str));
                return;
            case 7:
                absInlineImageShadowNode.setMode(stylesDiffMap.getString(str));
                return;
            case '\b':
                absInlineImageShadowNode.setBorderColor(2, stylesDiffMap.isNull(str) ? null : Integer.valueOf(stylesDiffMap.getInt(str, 0)));
                return;
            case '\t':
                absInlineImageShadowNode.setBorderStyle(3, stylesDiffMap.getInt(str, -1));
                return;
            case '\n':
                absInlineImageShadowNode.setBorderWidth(3, stylesDiffMap.getInt(str, 0));
                return;
            case 11:
                absInlineImageShadowNode.setBorderStyle(0, stylesDiffMap.getInt(str, -1));
                return;
            case '\f':
                absInlineImageShadowNode.setBorderWidth(0, stylesDiffMap.getInt(str, 0));
                return;
            case '\r':
                absInlineImageShadowNode.setBorderColor(1, stylesDiffMap.isNull(str) ? null : Integer.valueOf(stylesDiffMap.getInt(str, 0)));
                return;
            case 14:
                absInlineImageShadowNode.setBorderStyle(2, stylesDiffMap.getInt(str, -1));
                return;
            case 15:
                absInlineImageShadowNode.setBorderWidth(2, stylesDiffMap.getInt(str, 0));
                return;
            case 16:
                absInlineImageShadowNode.setBackgroundColor(stylesDiffMap.getInt(str, 0));
                return;
            case 17:
                absInlineImageShadowNode.setBorderRadius(4, stylesDiffMap.getArray(str));
                return;
            case 18:
                absInlineImageShadowNode.setBorderRadius(0, stylesDiffMap.getArray(str));
                return;
            case 19:
                absInlineImageShadowNode.setBorderColor(3, stylesDiffMap.isNull(str) ? null : Integer.valueOf(stylesDiffMap.getInt(str, 0)));
                return;
            case 20:
                absInlineImageShadowNode.setBorderStyle(4, stylesDiffMap.getInt(str, -1));
                return;
            case 21:
                absInlineImageShadowNode.setBorderWidth(4, stylesDiffMap.getInt(str, 0));
                return;
            case 22:
                absInlineImageShadowNode.setBorderRadius(1, stylesDiffMap.getArray(str));
                return;
            default:
                super.setProperty(shadowNode, str, stylesDiffMap);
                return;
        }
    }
}
