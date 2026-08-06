package com.lynx.tasm.animation;

import com.lynx.tasm.base.LLog;

/* loaded from: classes6.dex */
public final class PropertyFactory {
    public static final int fromPropertyString(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1383228885:
                if (str.equals("bottom")) {
                    c = 0;
                    break;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    c = 1;
                    break;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    c = 2;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 3;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 4;
                    break;
                }
                break;
            case 115029:
                if (str.equals("top")) {
                    c = 5;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c = 6;
                    break;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    c = 7;
                    break;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    c = '\b';
                    break;
                }
                break;
            case 605322756:
                if (str.equals("background-color")) {
                    c = '\t';
                    break;
                }
                break;
            case 1052666732:
                if (str.equals("transform")) {
                    c = '\n';
                    break;
                }
                break;
            case 1910893003:
                if (str.equals(AnimationConstant.PROP_STR_SCALE_X_Y)) {
                    c = 11;
                    break;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c = '\f';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 2048;
            case 1:
                return 1;
            case 2:
                return 32;
            case 3:
                return 2;
            case 4:
                return 4;
            case 5:
                return 512;
            case 6:
                return 256;
            case 7:
                return 1024;
            case '\b':
                return 16;
            case '\t':
                return 64;
            case '\n':
                return 4096;
            case 11:
                return 8;
            case '\f':
                return 128;
            default:
                LLog.DTHROW(new IllegalArgumentException("Unsupported animated property: " + str));
                return 0;
        }
    }

    public static final String propertyToString(int i) {
        if (i == 1) {
            return "opacity";
        }
        if (i == 2) {
            return "scaleX";
        }
        switch (i) {
            case 4:
                return "scaleY";
            case 8:
                return AnimationConstant.PROP_STR_SCALE_X_Y;
            case 16:
                return "width";
            case 32:
                return "height";
            case 64:
                return "background-color";
            case 128:
                return "visibility";
            case 256:
                return "left";
            case 512:
                return "top";
            case 1024:
                return "right";
            case 2048:
                return "bottom";
            case 4096:
                return "transform";
            default:
                LLog.DTHROW(new IllegalArgumentException("Unsupported animated property: " + i));
                return "none";
        }
    }
}
