package com.lynx.tasm.behavior.shadow;

import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.utils.ShadowNodeSetter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ShadowNode$$PropsSetter implements ShadowNodeSetter<ShadowNode> {
    @Override // com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void setProperty(ShadowNode shadowNode, String str, StylesDiffMap stylesDiffMap) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1559879186:
                if (str.equals(PropsConstants.VERTICAL_ALIGN)) {
                    c = 0;
                    break;
                }
                break;
            case -992853731:
                if (str.equals(PropsConstants.IGNORE_FOCUS)) {
                    c = 1;
                    break;
                }
                break;
            case -804847959:
                if (str.equals(PropsConstants.POINTER_EVENTS)) {
                    c = 2;
                    break;
                }
                break;
            case 856740501:
                if (str.equals(PropsConstants.ENABLE_TOUCH_PSEUDO_PROPAGATION)) {
                    c = 3;
                    break;
                }
                break;
            case 1443214456:
                if (str.equals(PropsConstants.DATASET)) {
                    c = 4;
                    break;
                }
                break;
            case 2100930194:
                if (str.equals(PropsConstants.EVENT_THROUGH)) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                shadowNode.setVerticalAlign(stylesDiffMap.getArray(str));
                return;
            case 1:
                shadowNode.setIgnoreFocus(stylesDiffMap.getDynamic(str));
                return;
            case 2:
                shadowNode.setPointerEvents(stylesDiffMap.getInt(str, 0));
                return;
            case 3:
                shadowNode.setEventThroughPropagation(stylesDiffMap.getDynamic(str));
                return;
            case 4:
                shadowNode.setDataset(stylesDiffMap.getMap(str));
                return;
            case 5:
                shadowNode.setEventThrough(stylesDiffMap.getDynamic(str));
                return;
            default:
                return;
        }
    }
}
