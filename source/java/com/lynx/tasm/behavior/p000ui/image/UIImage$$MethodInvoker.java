package com.lynx.tasm.behavior.p000ui.image;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.utils.LynxUIMethodInvoker;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIImage$$MethodInvoker implements LynxUIMethodInvoker<UIImage> {
    @Override // com.lynx.tasm.behavior.utils.LynxUIMethodInvoker
    public void invoke(UIImage uIImage, String str, ReadableMap readableMap, Callback callback) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1296995794:
                if (str.equals("pauseAnimation")) {
                    c = 0;
                    break;
                }
                break;
            case -991382497:
                if (str.equals("startAnimate")) {
                    c = 1;
                    break;
                }
                break;
            case -893184606:
                if (str.equals("stopAnimation")) {
                    c = 2;
                    break;
                }
                break;
            case -527962973:
                if (str.equals("innerText")) {
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
            case 1236882903:
                if (str.equals("resumeAnimation")) {
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
                uIImage.pauseAnimation(readableMap, callback);
                return;
            case 1:
                uIImage.startAnimate(readableMap, callback);
                return;
            case 2:
                uIImage.stopAnimation(readableMap, callback);
                return;
            case 3:
                uIImage.innerText(readableMap, callback);
                return;
            case 4:
                uIImage.boundingClientRect(readableMap, callback);
                return;
            case 5:
                uIImage.takeScreenshot(readableMap, callback);
                return;
            case 6:
                uIImage.fetchAccessibilityTargets(readableMap, callback);
                return;
            case 7:
                uIImage.resumeAnimation(readableMap, callback);
                return;
            case '\b':
                uIImage.requestUIInfo(readableMap, callback);
                return;
            case '\t':
                uIImage.requestAccessibilityFocus(readableMap, callback);
                return;
            case '\n':
                uIImage.scrollIntoView(readableMap, callback);
                return;
            default:
                callback.invoke(new Object[]{3});
                return;
        }
    }
}
