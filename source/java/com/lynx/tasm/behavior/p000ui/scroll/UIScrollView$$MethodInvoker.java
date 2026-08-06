package com.lynx.tasm.behavior.p000ui.scroll;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.utils.LynxUIMethodInvoker;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIScrollView$$MethodInvoker implements LynxUIMethodInvoker<UIScrollView> {
    @Override // com.lynx.tasm.behavior.utils.LynxUIMethodInvoker
    public void invoke(UIScrollView uIScrollView, String str, ReadableMap readableMap, Callback callback) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -527962973:
                if (str.equals("innerText")) {
                    c = 0;
                    break;
                }
                break;
            case -402165756:
                if (str.equals("scrollBy")) {
                    c = 1;
                    break;
                }
                break;
            case -402165208:
                if (str.equals("scrollTo")) {
                    c = 2;
                    break;
                }
                break;
            case -398364324:
                if (str.equals("autoScroll")) {
                    c = 3;
                    break;
                }
                break;
            case -357431021:
                if (str.equals("boundingClientRect")) {
                    c = 4;
                    break;
                }
                break;
            case -231782127:
                if (str.equals("getScrollInfo")) {
                    c = 5;
                    break;
                }
                break;
            case 194959693:
                if (str.equals("takeScreenshot")) {
                    c = 6;
                    break;
                }
                break;
            case 692239790:
                if (str.equals("fetchAccessibilityTargets")) {
                    c = 7;
                    break;
                }
                break;
            case 1419773105:
                if (str.equals("requestUIInfo")) {
                    c = '\b';
                    break;
                }
                break;
            case 1848904985:
                if (str.equals("requestAccessibilityFocus")) {
                    c = '\t';
                    break;
                }
                break;
            case 1908871954:
                if (str.equals("scrollIntoView")) {
                    c = '\n';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                uIScrollView.innerText(readableMap, callback);
                return;
            case 1:
                uIScrollView.scrollBy(readableMap, callback);
                return;
            case 2:
                uIScrollView.scrollTo(readableMap, callback);
                return;
            case 3:
                uIScrollView.autoScroll(readableMap);
                return;
            case 4:
                uIScrollView.boundingClientRect(readableMap, callback);
                return;
            case 5:
                uIScrollView.getScrollInfo(callback);
                return;
            case 6:
                uIScrollView.takeScreenshot(readableMap, callback);
                return;
            case 7:
                uIScrollView.fetchAccessibilityTargets(readableMap, callback);
                return;
            case '\b':
                uIScrollView.requestUIInfo(readableMap, callback);
                return;
            case '\t':
                uIScrollView.requestAccessibilityFocus(readableMap, callback);
                return;
            case '\n':
                uIScrollView.scrollIntoView(readableMap, callback);
                return;
            default:
                callback.invoke(new Object[]{3});
                return;
        }
    }
}
