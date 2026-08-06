package com.bytedance.common.util;

import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* loaded from: classes3.dex */
public class IceCreamSandwichV14Compat {
    private static final int FONT_BIG_PERCENT = 125;
    private static final int FONT_DEFAULT_PERCENT = 100;
    private static final int FONT_LARGE_PERCENT = 150;
    public static final int FONT_SIZE_BIG = 3;
    public static final int FONT_SIZE_LARGE = 4;
    public static final int FONT_SIZE_NORMAL = 2;
    public static final int FONT_SIZE_SMALL = 1;
    private static final int FONT_SMALL_PERCENT = 75;
    static final BaseImpl IMPL = new IceCreamSandwichImpl();
    public static final int UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW = 1;

    /* loaded from: classes3.dex */
    private static class BaseImpl {
        public void setUiOptions(Window window, int i) {
        }

        public void setUiOptions(Window window, int i, int i2) {
        }

        private BaseImpl() {
        }

        public void setWebViewTextSize(WebView webView, int i) {
            WebSettings.TextSize textSize = WebSettings.TextSize.NORMAL;
            if (i == 3) {
                textSize = WebSettings.TextSize.LARGER;
            } else if (i == 1) {
                textSize = WebSettings.TextSize.SMALLER;
            } else if (i == 4) {
                textSize = WebSettings.TextSize.LARGEST;
            }
            webView.getSettings().setTextSize(textSize);
        }
    }

    /* loaded from: classes3.dex */
    private static class IceCreamSandwichImpl extends BaseImpl {
        private IceCreamSandwichImpl() {
            super();
        }

        @Override // com.bytedance.common.util.IceCreamSandwichV14Compat.BaseImpl
        public void setWebViewTextSize(WebView webView, int i) {
            int i2 = i == 1 ? 75 : 100;
            if (i == 3) {
                i2 = 125;
            }
            if (i == 4) {
                i2 = 150;
            }
            webView.getSettings().setTextZoom(i2);
        }

        @Override // com.bytedance.common.util.IceCreamSandwichV14Compat.BaseImpl
        public void setUiOptions(Window window, int i) {
            window.setUiOptions(i);
        }

        @Override // com.bytedance.common.util.IceCreamSandwichV14Compat.BaseImpl
        public void setUiOptions(Window window, int i, int i2) {
            window.setUiOptions(i, i2);
        }
    }

    public static void setWebViewTextSize(WebView webView, int i) {
        IMPL.setWebViewTextSize(webView, i);
    }

    public static void setUiOptions(Window window, int i, int i2) {
        IMPL.setUiOptions(window, i, i2);
    }

    public static void setUiOptions(Window window, int i) {
        IMPL.setUiOptions(window, i);
    }
}
