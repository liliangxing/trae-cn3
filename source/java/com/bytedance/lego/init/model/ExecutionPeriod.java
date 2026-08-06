package com.bytedance.lego.init.model;

/* loaded from: classes4.dex */
public enum ExecutionPeriod {
    SPLASH_ON_CREATE,
    SPLASH_ON_START,
    SPLASH_ON_RESUME,
    SPLASH_ON_PAUSE,
    SPLASH_ON_STOP,
    SPLASH_ON_DESTROY,
    SPLASH_ON_ANY,
    MAIN_ON_CREATE,
    MAIN_ON_START,
    MAIN_ON_RESUME,
    MAIN_ON_PAUSE,
    MAIN_ON_STOP,
    MAIN_ON_DESTROY,
    MAIN_ON_ANY;

    public static ExecutionPeriod from(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1604499520:
                if (str.equals("MAIN_ON_DESTROY")) {
                    c = 0;
                    break;
                }
                break;
            case -364577614:
                if (str.equals("MAIN_ON_ANY")) {
                    c = 1;
                    break;
                }
                break;
            case 236883538:
                if (str.equals("SPLASH_ON_DESTROY")) {
                    c = 2;
                    break;
                }
                break;
            case 735015050:
                if (str.equals("SPLASH_ON_STOP")) {
                    c = 3;
                    break;
                }
                break;
            case 901014614:
                if (str.equals("MAIN_ON_CREATE")) {
                    c = 4;
                    break;
                }
                break;
            case 1307299406:
                if (str.equals("SPLASH_ON_PAUSE")) {
                    c = 5;
                    break;
                }
                break;
            case 1310616762:
                if (str.equals("SPLASH_ON_START")) {
                    c = 6;
                    break;
                }
                break;
            case 1318882183:
                if (str.equals("MAIN_ON_RESUME")) {
                    c = 7;
                    break;
                }
                break;
            case 1514603396:
                if (str.equals("SPLASH_ON_CREATE")) {
                    c = '\b';
                    break;
                }
                break;
            case 1583537628:
                if (str.equals("MAIN_ON_STOP")) {
                    c = '\t';
                    break;
                }
                break;
            case 1824808004:
                if (str.equals("SPLASH_ON_ANY")) {
                    c = '\n';
                    break;
                }
                break;
            case 1841695548:
                if (str.equals("MAIN_ON_PAUSE")) {
                    c = 11;
                    break;
                }
                break;
            case 1845012904:
                if (str.equals("MAIN_ON_START")) {
                    c = '\f';
                    break;
                }
                break;
            case 1932470965:
                if (str.equals("SPLASH_ON_RESUME")) {
                    c = '\r';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return MAIN_ON_DESTROY;
            case 1:
                return MAIN_ON_ANY;
            case 2:
                return SPLASH_ON_DESTROY;
            case 3:
                return SPLASH_ON_STOP;
            case 4:
                return MAIN_ON_CREATE;
            case 5:
                return SPLASH_ON_PAUSE;
            case 6:
                return SPLASH_ON_START;
            case 7:
                return MAIN_ON_RESUME;
            case '\b':
                return SPLASH_ON_CREATE;
            case '\t':
                return MAIN_ON_STOP;
            case '\n':
                return SPLASH_ON_ANY;
            case 11:
                return MAIN_ON_PAUSE;
            case '\f':
                return MAIN_ON_START;
            case '\r':
                return SPLASH_ON_RESUME;
            default:
                return null;
        }
    }
}
