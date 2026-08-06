package com.lynx.animax;

import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class UIAnimaX$$PropsSetter extends LynxUI$.PropsSetter {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
        char c;
        UIAnimaX uIAnimaX = (UIAnimaX) lynxBaseUI;
        str.hashCode();
        switch (str.hashCode()) {
            case -1673124846:
                if (str.equals("android-enable-screenshot")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1489589134:
                if (str.equals("objectfit")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1426073969:
                if (str.equals("ignore-lynx-lifecycle")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1340550148:
                if (str.equals("fps-event-interval")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1162629129:
                if (str.equals("object-position")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -846027028:
                if (str.equals("multi-thread-accelerate")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -839971427:
                if (str.equals("anti-aliasing")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -819151396:
                if (str.equals("dynamic-resource")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -795328846:
                if (str.equals("keeplastframe")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -629825370:
                if (str.equals("loop-count")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -303648977:
                if (str.equals("video-frame-timeout")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -261882880:
                if (str.equals("src-format")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 114148:
                if (str.equals("src")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 114586:
                if (str.equals("tag")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 3271912:
                if (str.equals("json")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 3327652:
                if (str.equals("loop")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 109641799:
                if (str.equals("speed")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 508360187:
                if (str.equals("end-frame")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 1068228937:
                if (str.equals("max-frame-rate")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 1327968322:
                if (str.equals("start-frame")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 1352104895:
                if (str.equals("ignore-attach-status")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 1568893902:
                if (str.equals("display-mode")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case 1821306136:
                if (str.equals("src-polyfill")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case 1978397892:
                if (str.equals("auto-reverse")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                uIAnimaX.setEnableScreenshot(stylesDiffMap.getBoolean(str, false));
                return;
            case 1:
                uIAnimaX.setObjectFit(stylesDiffMap.getString(str));
                return;
            case 2:
                uIAnimaX.setIgnoreLynxLifecycle(stylesDiffMap.getBoolean(str, false));
                return;
            case 3:
                uIAnimaX.setFpsEventInterval(stylesDiffMap.getInt(str, 0));
                return;
            case 4:
                uIAnimaX.setObjectPosition(stylesDiffMap.getString(str));
                return;
            case 5:
                uIAnimaX.setProgress(stylesDiffMap.getFloat(str, 0.0f));
                return;
            case 6:
                uIAnimaX.setMultiThreadAccelerate(stylesDiffMap.getBoolean(str, true));
                return;
            case 7:
                uIAnimaX.setAntiAliasing(stylesDiffMap.getString(str));
                return;
            case '\b':
                uIAnimaX.setDynamicResource(stylesDiffMap.getBoolean(str, false));
                return;
            case '\t':
                uIAnimaX.setKeepLastFrame(stylesDiffMap.getBoolean(str, true));
                return;
            case '\n':
                uIAnimaX.setLoopCount(stylesDiffMap.getInt(str, 1));
                return;
            case 11:
                uIAnimaX.setVideoFrameTimeout(stylesDiffMap.getInt(str, 0));
                return;
            case '\f':
                uIAnimaX.setSrcFormat(stylesDiffMap.getString(str));
                return;
            case '\r':
                uIAnimaX.setSrc(stylesDiffMap.getString(str));
                return;
            case 14:
                uIAnimaX.setTag(stylesDiffMap.getString(str));
                return;
            case 15:
                uIAnimaX.setJson(stylesDiffMap.getString(str));
                return;
            case 16:
                uIAnimaX.setLoop(stylesDiffMap.getBoolean(str, false));
                return;
            case 17:
                uIAnimaX.setSpeed(stylesDiffMap.getFloat(str, 0.0f));
                return;
            case 18:
                uIAnimaX.setEndFrame(stylesDiffMap.getInt(str, -1));
                return;
            case 19:
                uIAnimaX.setMaxFrameRate(stylesDiffMap.getDouble(str, 0.0d));
                return;
            case 20:
                uIAnimaX.setStartFrame(stylesDiffMap.getInt(str, 0));
                return;
            case 21:
                uIAnimaX.setIgnoreAttachStatus(stylesDiffMap.getBoolean(str, false));
                return;
            case 22:
                uIAnimaX.setAutoPlay(stylesDiffMap.getBoolean(str, true));
                return;
            case 23:
                uIAnimaX.setDisplayMode(stylesDiffMap.getString(str));
                return;
            case 24:
                uIAnimaX.setSrcPolyfill(stylesDiffMap.getMap(str));
                return;
            case 25:
                uIAnimaX.setReverseMode(stylesDiffMap.getBoolean(str, false));
                return;
            default:
                super.setProperty(lynxBaseUI, str, stylesDiffMap);
                return;
        }
    }
}
