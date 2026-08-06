package com.lynx.tasm.behavior.p000ui.list;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.utils.LynxUIMethodInvoker;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIListItem$$MethodInvoker implements LynxUIMethodInvoker<UIListItem> {
    @Override // com.lynx.tasm.behavior.utils.LynxUIMethodInvoker
    public void invoke(UIListItem uIListItem, String str, ReadableMap readableMap, Callback callback) {
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
            case 194959693:
                if (str.equals("takeScreenshot")) {
                    c = 2;
                    break;
                }
                break;
            case 692239790:
                if (str.equals("fetchAccessibilityTargets")) {
                    c = 3;
                    break;
                }
                break;
            case 1419773105:
                if (str.equals("requestUIInfo")) {
                    c = 4;
                    break;
                }
                break;
            case 1848904985:
                if (str.equals("requestAccessibilityFocus")) {
                    c = 5;
                    break;
                }
                break;
            case 1908871954:
                if (str.equals("scrollIntoView")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                uIListItem.innerText(readableMap, callback);
                return;
            case 1:
                uIListItem.boundingClientRect(readableMap, callback);
                return;
            case 2:
                uIListItem.takeScreenshot(readableMap, callback);
                return;
            case 3:
                uIListItem.fetchAccessibilityTargets(readableMap, callback);
                return;
            case 4:
                uIListItem.requestUIInfo(readableMap, callback);
                return;
            case 5:
                uIListItem.requestAccessibilityFocus(readableMap, callback);
                return;
            case 6:
                uIListItem.scrollIntoView(readableMap, callback);
                return;
            default:
                callback.invoke(new Object[]{3});
                return;
        }
    }
}
