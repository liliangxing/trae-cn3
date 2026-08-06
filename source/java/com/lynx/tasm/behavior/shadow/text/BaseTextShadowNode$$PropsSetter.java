package com.lynx.tasm.behavior.shadow.text;

import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BaseTextShadowNode$$PropsSetter extends ShadowNode$$PropsSetter {
    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void setProperty(ShadowNode shadowNode, String str, StylesDiffMap stylesDiffMap) {
        BaseTextShadowNode baseTextShadowNode = (BaseTextShadowNode) shadowNode;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2137322088:
                if (str.equals(PropsConstants.INCLUDE_FONT_PADDING)) {
                    c = 0;
                    break;
                }
                break;
            case -2125209152:
                if (str.equals(PropsConstants.TEXT_SHADOW)) {
                    c = 1;
                    break;
                }
                break;
            case -2006495646:
                if (str.equals(PropsConstants.WHITE_SPACE)) {
                    c = 2;
                    break;
                }
                break;
            case -1988401764:
                if (str.equals(PropsConstants.LETTER_SPACING)) {
                    c = 3;
                    break;
                }
                break;
            case -1961254866:
                if (str.equals(PropsConstants.TEXT_STROKE_COLOR)) {
                    c = 4;
                    break;
                }
                break;
            case -1942970735:
                if (str.equals(PropsConstants.TEXT_STROKE_WIDTH)) {
                    c = 5;
                    break;
                }
                break;
            case -1923578189:
                if (str.equals(PropsConstants.FONT_STYLE)) {
                    c = 6;
                    break;
                }
                break;
            case -1846328470:
                if (str.equals(PropsConstants.LINE_SPACING)) {
                    c = 7;
                    break;
                }
                break;
            case -1613296421:
                if (str.equals(PropsConstants.FONT_VARIATION_SETTINGS)) {
                    c = '\b';
                    break;
                }
                break;
            case -1586082113:
                if (str.equals(PropsConstants.FONT_SIZE)) {
                    c = '\t';
                    break;
                }
                break;
            case -1477575976:
                if (str.equals(PropsConstants.FONT_FEATURE_SETTINGS)) {
                    c = '\n';
                    break;
                }
                break;
            case -1328339619:
                if (str.equals(PropsConstants.TEXT_FAKE_BOLD)) {
                    c = 11;
                    break;
                }
                break;
            case -1215680224:
                if (str.equals(PropsConstants.LINE_HEIGHT)) {
                    c = '\f';
                    break;
                }
                break;
            case -1080127274:
                if (str.equals("custom-baseline-shift")) {
                    c = '\r';
                    break;
                }
                break;
            case -1004442098:
                if (str.equals(PropsConstants.BITMAP_GRADIENT)) {
                    c = 14;
                    break;
                }
                break;
            case -962590849:
                if (str.equals(PropsConstants.DRIECTION)) {
                    c = 15;
                    break;
                }
                break;
            case -930515806:
                if (str.equals(PropsConstants.TEXT_OVERFLOW)) {
                    c = 16;
                    break;
                }
                break;
            case -231573485:
                if (str.equals(PropsConstants.ENABLE_FONT_SCALING)) {
                    c = 17;
                    break;
                }
                break;
            case -20349561:
                if (str.equals(PropsConstants.ANDROID_EMOJI_COMPAT)) {
                    c = 18;
                    break;
                }
                break;
            case 3556653:
                if (str.equals(PropsConstants.TEXT)) {
                    c = 19;
                    break;
                }
                break;
            case 94842723:
                if (str.equals(PropsConstants.COLOR)) {
                    c = 20;
                    break;
                }
                break;
            case 108532386:
                if (str.equals(PropsConstants.FONT_FAMILY)) {
                    c = 21;
                    break;
                }
                break;
            case 125536225:
                if (str.equals("use-web-line-height")) {
                    c = 22;
                    break;
                }
                break;
            case 375997564:
                if (str.equals(PropsConstants.WORD_BREAK_STRATEGY)) {
                    c = 23;
                    break;
                }
                break;
            case 431477072:
                if (str.equals(PropsConstants.TEXT_DECORATION)) {
                    c = 24;
                    break;
                }
                break;
            case 598800822:
                if (str.equals(PropsConstants.FONT_WEIGHT)) {
                    c = 25;
                    break;
                }
                break;
            case 746232421:
                if (str.equals(PropsConstants.TEXT_ALIGN)) {
                    c = 26;
                    break;
                }
                break;
            case 856877710:
                if (str.equals("text-vertical-align")) {
                    c = 27;
                    break;
                }
                break;
            case 1050625329:
                if (str.equals(PropsConstants.FONT_OPTICAL_SIZING)) {
                    c = 28;
                    break;
                }
                break;
            case 1629007544:
                if (str.equals(PropsConstants.TEXT_MAXLINE)) {
                    c = 29;
                    break;
                }
                break;
            case 1889098060:
                if (str.equals(PropsConstants.TEXT_INDENT)) {
                    c = 30;
                    break;
                }
                break;
            case 2104465578:
                if (str.equals(PropsConstants.TEXT_MAXLENGTH)) {
                    c = 31;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                baseTextShadowNode.setIncludeFontPadding(stylesDiffMap.getBoolean(str, false));
                return;
            case 1:
                baseTextShadowNode.setTextShadow(stylesDiffMap.getArray(str));
                return;
            case 2:
                baseTextShadowNode.setWhiteSpace(stylesDiffMap.getInt(str, 0));
                return;
            case 3:
                baseTextShadowNode.setLetterSpacing(stylesDiffMap.getFloat(str, 1.0E21f));
                return;
            case 4:
                baseTextShadowNode.setTextStrokeColor(stylesDiffMap.getDynamic(str));
                return;
            case 5:
                baseTextShadowNode.setTextStrokeWidth(stylesDiffMap.getFloat(str, 0.0f));
                return;
            case 6:
                baseTextShadowNode.setFontStyle(stylesDiffMap.getInt(str, 0));
                return;
            case 7:
                baseTextShadowNode.setLineSpacing(stylesDiffMap.getFloat(str, 0.0f));
                return;
            case '\b':
                baseTextShadowNode.setFontVariationSettings(stylesDiffMap.getArray(str));
                return;
            case '\t':
                baseTextShadowNode.setFontSize(stylesDiffMap.getFloat(str, 1.0E21f));
                return;
            case '\n':
                baseTextShadowNode.setFontFeatureSettings(stylesDiffMap.getArray(str));
                return;
            case 11:
                baseTextShadowNode.setTextFakeBold(stylesDiffMap.getBoolean(str, false));
                return;
            case '\f':
                baseTextShadowNode.setLineHeight(stylesDiffMap.getFloat(str, 1.0E21f));
                return;
            case '\r':
                baseTextShadowNode.setBaselineShift(stylesDiffMap.getString(str));
                return;
            case 14:
                baseTextShadowNode.setEnableBitmapGradient(stylesDiffMap.getBoolean(str, false));
                return;
            case 15:
                baseTextShadowNode.setDirection(stylesDiffMap.getInt(str, 0));
                return;
            case 16:
                baseTextShadowNode.setTextOverflow(stylesDiffMap.getInt(str, 0));
                return;
            case 17:
                baseTextShadowNode.setEnableFontScaling(stylesDiffMap.getString(str));
                return;
            case 18:
                baseTextShadowNode.setEnableEmojiCompat(stylesDiffMap.getBoolean(str, false));
                return;
            case 19:
                baseTextShadowNode.setText(stylesDiffMap.getDynamic(str));
                return;
            case 20:
                baseTextShadowNode.setColor(stylesDiffMap.getDynamic(str));
                return;
            case 21:
                baseTextShadowNode.setFontFamily(stylesDiffMap.getString(str));
                return;
            case 22:
                baseTextShadowNode.setUseWebLineHeight(stylesDiffMap.getBoolean(str, false));
                return;
            case 23:
                baseTextShadowNode.setWordBreakStrategy(stylesDiffMap.getInt(str, 0));
                return;
            case 24:
                baseTextShadowNode.setTextDecoration(stylesDiffMap.getArray(str));
                return;
            case 25:
                baseTextShadowNode.setFontWeight(stylesDiffMap.getInt(str, 0));
                return;
            case 26:
                baseTextShadowNode.setTextAlign(stylesDiffMap.getInt(str, 3));
                return;
            case 27:
                baseTextShadowNode.setTextVerticalAlign(stylesDiffMap.getString(str));
                return;
            case 28:
                baseTextShadowNode.setFontFeatureSettings(stylesDiffMap.getInt(str, 0));
                return;
            case 29:
                baseTextShadowNode.setTextMaxLine(stylesDiffMap.getString(str));
                return;
            case 30:
                baseTextShadowNode.setTextIndent(stylesDiffMap.getArray(str));
                return;
            case 31:
                baseTextShadowNode.setTextMaxLength(stylesDiffMap.getString(str));
                return;
            default:
                super.setProperty(shadowNode, str, stylesDiffMap);
                return;
        }
    }
}
