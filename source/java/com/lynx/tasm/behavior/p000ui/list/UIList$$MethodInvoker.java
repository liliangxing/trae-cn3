package com.lynx.tasm.behavior.p000ui.list;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.utils.LynxUIMethodInvoker;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIList$$MethodInvoker implements LynxUIMethodInvoker<UIList> {
    @Override // com.lynx.tasm.behavior.utils.LynxUIMethodInvoker
    public void invoke(UIList uIList, String str, ReadableMap readableMap, Callback callback) {
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
            case -284097454:
                if (str.equals("initCache")) {
                    c = 5;
                    break;
                }
                break;
            case -231782127:
                if (str.equals("getScrollInfo")) {
                    c = 6;
                    break;
                }
                break;
            case -142621742:
                if (str.equals("removeStickyView")) {
                    c = 7;
                    break;
                }
                break;
            case 194959693:
                if (str.equals("takeScreenshot")) {
                    c = '\b';
                    break;
                }
                break;
            case 692239790:
                if (str.equals("fetchAccessibilityTargets")) {
                    c = '\t';
                    break;
                }
                break;
            case 1363070069:
                if (str.equals("getVisibleCells")) {
                    c = '\n';
                    break;
                }
                break;
            case 1419773105:
                if (str.equals("requestUIInfo")) {
                    c = 11;
                    break;
                }
                break;
            case 1848904985:
                if (str.equals("requestAccessibilityFocus")) {
                    c = '\f';
                    break;
                }
                break;
            case 1908871954:
                if (str.equals("scrollIntoView")) {
                    c = '\r';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                uIList.scrollToPosition(readableMap, callback);
                return;
            case 1:
                uIList.innerText(readableMap, callback);
                return;
            case 2:
                uIList.scrollBy(readableMap, callback);
                return;
            case 3:
                uIList.autoScroll(readableMap, callback);
                return;
            case 4:
                uIList.boundingClientRect(readableMap, callback);
                return;
            case 5:
                uIList.initCache();
                return;
            case 6:
                uIList.getScrollInfo(callback);
                return;
            case 7:
                uIList.removeStickyView();
                return;
            case '\b':
                uIList.takeScreenshot(readableMap, callback);
                return;
            case '\t':
                uIList.fetchAccessibilityTargets(readableMap, callback);
                return;
            case '\n':
                uIList.getVisibleCells(callback);
                return;
            case 11:
                uIList.requestUIInfo(readableMap, callback);
                return;
            case '\f':
                uIList.requestAccessibilityFocus(readableMap, callback);
                return;
            case '\r':
                uIList.scrollIntoView(readableMap, callback);
                return;
            default:
                callback.invoke(new Object[]{3});
                return;
        }
    }
}
