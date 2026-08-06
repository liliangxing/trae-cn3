package com.lynx.tasm.behavior.p000ui;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.utils.LynxUIMethodInvoker;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxBaseUI$$MethodInvoker implements LynxUIMethodInvoker<LynxBaseUI> {
    @Override // com.lynx.tasm.behavior.utils.LynxUIMethodInvoker
    public void invoke(LynxBaseUI lynxBaseUI, String str, ReadableMap readableMap, Callback callback) {
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
            case 692239790:
                if (str.equals("fetchAccessibilityTargets")) {
                    c = 2;
                    break;
                }
                break;
            case 1419773105:
                if (str.equals("requestUIInfo")) {
                    c = 3;
                    break;
                }
                break;
            case 1848904985:
                if (str.equals("requestAccessibilityFocus")) {
                    c = 4;
                    break;
                }
                break;
            case 1908871954:
                if (str.equals("scrollIntoView")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                lynxBaseUI.innerText(readableMap, callback);
                return;
            case 1:
                lynxBaseUI.boundingClientRect(readableMap, callback);
                return;
            case 2:
                lynxBaseUI.fetchAccessibilityTargets(readableMap, callback);
                return;
            case 3:
                lynxBaseUI.requestUIInfo(readableMap, callback);
                return;
            case 4:
                lynxBaseUI.requestAccessibilityFocus(readableMap, callback);
                return;
            case 5:
                lynxBaseUI.scrollIntoView(readableMap, callback);
                return;
            default:
                callback.invoke(new Object[]{3});
                return;
        }
    }
}
