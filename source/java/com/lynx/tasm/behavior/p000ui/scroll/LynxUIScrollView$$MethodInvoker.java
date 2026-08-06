package com.lynx.tasm.behavior.p000ui.scroll;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.utils.LynxUIMethodInvoker;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxUIScrollView$$MethodInvoker implements LynxUIMethodInvoker<LynxUIScrollView> {
    @Override // com.lynx.tasm.behavior.utils.LynxUIMethodInvoker
    public void invoke(LynxUIScrollView lynxUIScrollView, String str, ReadableMap readableMap, Callback callback) {
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
            case 194959693:
                if (str.equals("takeScreenshot")) {
                    c = 5;
                    break;
                }
                break;
            case 692239790:
                if (str.equals("fetchAccessibilityTargets")) {
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
                lynxUIScrollView.innerText(readableMap, callback);
                return;
            case 1:
                lynxUIScrollView.scrollBy(readableMap, callback);
                return;
            case 2:
                lynxUIScrollView.scrollTo(readableMap, callback);
                return;
            case 3:
                lynxUIScrollView.autoScroll(readableMap, callback);
                return;
            case 4:
                lynxUIScrollView.boundingClientRect(readableMap, callback);
                return;
            case 5:
                lynxUIScrollView.takeScreenshot(readableMap, callback);
                return;
            case 6:
                lynxUIScrollView.fetchAccessibilityTargets(readableMap, callback);
                return;
            case 7:
                lynxUIScrollView.requestUIInfo(readableMap, callback);
                return;
            case '\b':
                lynxUIScrollView.requestAccessibilityFocus(readableMap, callback);
                return;
            case '\t':
                lynxUIScrollView.scrollIntoView(readableMap, callback);
                return;
            default:
                callback.invoke(new Object[]{3});
                return;
        }
    }
}
