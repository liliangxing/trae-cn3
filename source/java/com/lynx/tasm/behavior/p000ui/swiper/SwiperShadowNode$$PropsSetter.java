package com.lynx.tasm.behavior.p000ui.swiper;

import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.shadow.CustomLayoutShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.shadow.ShadowNode;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class SwiperShadowNode$$PropsSetter extends CustomLayoutShadowNode$$PropsSetter {
    @Override // com.lynx.tasm.behavior.shadow.CustomLayoutShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void setProperty(ShadowNode shadowNode, String str, StylesDiffMap stylesDiffMap) {
        SwiperShadowNode swiperShadowNode = (SwiperShadowNode) shadowNode;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1984141450:
                if (str.equals("vertical")) {
                    c = 0;
                    break;
                }
                break;
            case -686438324:
                if (str.equals("max-x-scale")) {
                    c = 1;
                    break;
                }
                break;
            case -111166008:
                if (str.equals("next-margin")) {
                    c = 2;
                    break;
                }
                break;
            case 3357091:
                if (str.equals(PropsConstants.MODE)) {
                    c = 3;
                    break;
                }
                break;
            case 24002884:
                if (str.equals("previous-margin")) {
                    c = 4;
                    break;
                }
                break;
            case 201065357:
                if (str.equals("max-y-scale")) {
                    c = 5;
                    break;
                }
                break;
            case 1665556140:
                if (str.equals("page-margin")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                swiperShadowNode.setVertical(stylesDiffMap.getBoolean(str, false));
                return;
            case 1:
                swiperShadowNode.setMaxXScale(stylesDiffMap.getDouble(str, 0.0d));
                return;
            case 2:
                swiperShadowNode.setNextMargin(stylesDiffMap.getDynamic(str));
                return;
            case 3:
                swiperShadowNode.setMode(stylesDiffMap.getString(str));
                return;
            case 4:
                swiperShadowNode.setPreviousMargin(stylesDiffMap.getDynamic(str));
                return;
            case 5:
                swiperShadowNode.setMaxYScale(stylesDiffMap.getDouble(str, 0.0d));
                return;
            case 6:
                swiperShadowNode.setPageMargin(stylesDiffMap.getDynamic(str));
                return;
            default:
                super.setProperty(shadowNode, str, stylesDiffMap);
                return;
        }
    }
}
