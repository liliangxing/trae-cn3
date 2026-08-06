package com.lynx.tasm.behavior.p000ui.list.container;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.utils.LynxUIMethodInvoker;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIListContainer$$MethodInvoker implements LynxUIMethodInvoker<UIListContainer> {
    @Override // com.lynx.tasm.behavior.utils.LynxUIMethodInvoker
    public void invoke(UIListContainer uIListContainer, String str, ReadableMap readableMap, Callback callback) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -980170895:
                if (str.equals("scrollToPosition")) {
                    c = 0;
                    break;
                }
                break;
            case -527962973:
                if (str.equals("innerText")) {
                    c = 1;
                    break;
                }
                break;
            case -402165756:
                if (str.equals("scrollBy")) {
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
            case 1363070069:
                if (str.equals("getVisibleCells")) {
                    c = '\b';
                    break;
                }
                break;
            case 1419773105:
                if (str.equals("requestUIInfo")) {
                    c = '\t';
                    break;
                }
                break;
            case 1848904985:
                if (str.equals("requestAccessibilityFocus")) {
                    c = '\n';
                    break;
                }
                break;
            case 1908871954:
                if (str.equals("scrollIntoView")) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                uIListContainer.scrollToPosition(readableMap, callback);
                return;
            case 1:
                uIListContainer.innerText(readableMap, callback);
                return;
            case 2:
                uIListContainer.scrollBy(readableMap, callback);
                return;
            case 3:
                uIListContainer.autoScroll(readableMap, callback);
                return;
            case 4:
                uIListContainer.boundingClientRect(readableMap, callback);
                return;
            case 5:
                uIListContainer.getScrollInfo(callback);
                return;
            case 6:
                uIListContainer.takeScreenshot(readableMap, callback);
                return;
            case 7:
                uIListContainer.fetchAccessibilityTargets(readableMap, callback);
                return;
            case '\b':
                uIListContainer.getVisibleCells(readableMap, callback);
                return;
            case '\t':
                uIListContainer.requestUIInfo(readableMap, callback);
                return;
            case '\n':
                uIListContainer.requestAccessibilityFocus(readableMap, callback);
                return;
            case 11:
                uIListContainer.scrollIntoView(readableMap, callback);
                return;
            default:
                callback.invoke(new Object[]{3});
                return;
        }
    }
}
