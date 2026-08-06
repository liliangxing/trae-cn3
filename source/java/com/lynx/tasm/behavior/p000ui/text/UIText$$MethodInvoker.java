package com.lynx.tasm.behavior.p000ui.text;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.utils.LynxUIMethodInvoker;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIText$$MethodInvoker implements LynxUIMethodInvoker<UIText> {
    @Override // com.lynx.tasm.behavior.utils.LynxUIMethodInvoker
    public void invoke(UIText uIText, String str, ReadableMap readableMap, Callback callback) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -527962973:
                if (str.equals("innerText")) {
                    c = 0;
                    break;
                }
                break;
            case -357431021:
                if (str.equals("boundingClientRect")) {
                    c = 1;
                    break;
                }
                break;
            case -127960866:
                if (str.equals("getSelectedText")) {
                    c = 2;
                    break;
                }
                break;
            case -95358563:
                if (str.equals("setTextSelection")) {
                    c = 3;
                    break;
                }
                break;
            case 194959693:
                if (str.equals("takeScreenshot")) {
                    c = 4;
                    break;
                }
                break;
            case 692239790:
                if (str.equals("fetchAccessibilityTargets")) {
                    c = 5;
                    break;
                }
                break;
            case 850462443:
                if (str.equals("getTextBoundingRect")) {
                    c = 6;
                    break;
                }
                break;
            case 1419773105:
                if (str.equals("requestUIInfo")) {
                    c = 7;
                    break;
                }
                break;
            case 1848904985:
                if (str.equals("requestAccessibilityFocus")) {
                    c = '\b';
                    break;
                }
                break;
            case 1908871954:
                if (str.equals("scrollIntoView")) {
                    c = '\t';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                uIText.innerText(readableMap, callback);
                return;
            case 1:
                uIText.boundingClientRect(readableMap, callback);
                return;
            case 2:
                uIText.getSelectedText(readableMap, callback);
                return;
            case 3:
                uIText.setTextSelection(readableMap, callback);
                return;
            case 4:
                uIText.takeScreenshot(readableMap, callback);
                return;
            case 5:
                uIText.fetchAccessibilityTargets(readableMap, callback);
                return;
            case 6:
                uIText.getTextBoundingRect(readableMap, callback);
                return;
            case 7:
                uIText.requestUIInfo(readableMap, callback);
                return;
            case '\b':
                uIText.requestAccessibilityFocus(readableMap, callback);
                return;
            case '\t':
                uIText.scrollIntoView(readableMap, callback);
                return;
            default:
                callback.invoke(new Object[]{3});
                return;
        }
    }
}
