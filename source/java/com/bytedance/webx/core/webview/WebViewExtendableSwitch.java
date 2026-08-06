package com.bytedance.webx.core.webview;

/* loaded from: classes6.dex */
public class WebViewExtendableSwitch {
    private static volatile IEnable sEnableObj;

    /* loaded from: classes6.dex */
    public interface IEnable {
        boolean isEnable();
    }

    public static void setEnable(IEnable iEnable) {
        synchronized (WebViewExtendableSwitch.class) {
            sEnableObj = iEnable;
        }
    }

    /* loaded from: classes6.dex */
    private static class StaticValue {
        private static boolean sEnable = true;

        private StaticValue() {
        }

        static /* synthetic */ boolean access$100() {
            return isEnable();
        }

        static {
            if (WebViewExtendableSwitch.sEnableObj != null) {
                synchronized (WebViewExtendableSwitch.class) {
                    if (WebViewExtendableSwitch.sEnableObj != null) {
                        sEnable = WebViewExtendableSwitch.sEnableObj.isEnable();
                    }
                }
            }
        }

        private static boolean isEnable() {
            return sEnable;
        }
    }

    public static boolean isEnable() {
        return StaticValue.access$100();
    }
}
