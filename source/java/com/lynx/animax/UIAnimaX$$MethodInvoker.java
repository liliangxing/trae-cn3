package com.lynx.animax;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.utils.LynxUIMethodInvoker;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class UIAnimaX$$MethodInvoker implements LynxUIMethodInvoker<UIAnimaX> {
    public void invoke(UIAnimaX uIAnimaX, String str, ReadableMap readableMap, Callback callback) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1998037676:
                if (str.equals("isAnimating")) {
                    c = 0;
                    break;
                }
                break;
            case -1222700566:
                if (str.equals("getCurrentFrame")) {
                    c = 1;
                    break;
                }
                break;
            case -934426579:
                if (str.equals("resume")) {
                    c = 2;
                    break;
                }
                break;
            case -929558362:
                if (str.equals("listenAnimationUpdate")) {
                    c = 3;
                    break;
                }
                break;
            case -527962973:
                if (str.equals("innerText")) {
                    c = 4;
                    break;
                }
                break;
            case -407658560:
                if (str.equals("unsubscribeUpdateEvent")) {
                    c = 5;
                    break;
                }
                break;
            case -357431021:
                if (str.equals("boundingClientRect")) {
                    c = 6;
                    break;
                }
                break;
            case 3443508:
                if (str.equals("play")) {
                    c = 7;
                    break;
                }
                break;
            case 3526264:
                if (str.equals("seek")) {
                    c = '\b';
                    break;
                }
                break;
            case 3540994:
                if (str.equals("stop")) {
                    c = '\t';
                    break;
                }
                break;
            case 47962023:
                if (str.equals("subscribeUpdateEvent")) {
                    c = '\n';
                    break;
                }
                break;
            case 85887754:
                if (str.equals("getDuration")) {
                    c = 11;
                    break;
                }
                break;
            case 106440182:
                if (str.equals("pause")) {
                    c = '\f';
                    break;
                }
                break;
            case 194959693:
                if (str.equals("takeScreenshot")) {
                    c = '\r';
                    break;
                }
                break;
            case 247486643:
                if (str.equals("unsubscribeUpdateEvents")) {
                    c = 14;
                    break;
                }
                break;
            case 692239790:
                if (str.equals("fetchAccessibilityTargets")) {
                    c = 15;
                    break;
                }
                break;
            case 1396926815:
                if (str.equals("playSegment")) {
                    c = 16;
                    break;
                }
                break;
            case 1419773105:
                if (str.equals("requestUIInfo")) {
                    c = 17;
                    break;
                }
                break;
            case 1486822828:
                if (str.equals("subscribeUpdateEvents")) {
                    c = 18;
                    break;
                }
                break;
            case 1848904985:
                if (str.equals("requestAccessibilityFocus")) {
                    c = 19;
                    break;
                }
                break;
            case 1908871954:
                if (str.equals("scrollIntoView")) {
                    c = 20;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                uIAnimaX.isAnimating(readableMap, callback);
                return;
            case 1:
                uIAnimaX.getCurrentFrame(readableMap, callback);
                return;
            case 2:
                uIAnimaX.resume(readableMap, callback);
                return;
            case 3:
                uIAnimaX.listenAnimationUpdate(readableMap, callback);
                return;
            case 4:
                uIAnimaX.innerText(readableMap, callback);
                return;
            case 5:
                uIAnimaX.unsubscribeUpdateEvent(readableMap, callback);
                return;
            case 6:
                uIAnimaX.boundingClientRect(readableMap, callback);
                return;
            case 7:
                uIAnimaX.play(readableMap, callback);
                return;
            case '\b':
                uIAnimaX.seek(readableMap, callback);
                return;
            case '\t':
                uIAnimaX.stop(readableMap, callback);
                return;
            case '\n':
                uIAnimaX.subscribeUpdateEvent(readableMap, callback);
                return;
            case 11:
                uIAnimaX.getDuration(readableMap, callback);
                return;
            case '\f':
                uIAnimaX.pause(readableMap, callback);
                return;
            case '\r':
                uIAnimaX.takeScreenshot(readableMap, callback);
                return;
            case 14:
                uIAnimaX.unsubscribeUpdateEvents(readableMap, callback);
                return;
            case 15:
                uIAnimaX.fetchAccessibilityTargets(readableMap, callback);
                return;
            case 16:
                uIAnimaX.playSegment(readableMap, callback);
                return;
            case 17:
                uIAnimaX.requestUIInfo(readableMap, callback);
                return;
            case 18:
                uIAnimaX.subscribeUpdateEvents(readableMap, callback);
                return;
            case 19:
                uIAnimaX.requestAccessibilityFocus(readableMap, callback);
                return;
            case 20:
                uIAnimaX.scrollIntoView(readableMap, callback);
                return;
            default:
                callback.invoke(3);
                return;
        }
    }
}
