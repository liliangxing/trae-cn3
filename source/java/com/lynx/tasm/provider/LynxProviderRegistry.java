package com.lynx.tasm.provider;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class LynxProviderRegistry {
    public static final String LYNX_PROVIDER_TYPE_DYNAMIC_COMPONENT = "DYNAMIC_COMPONENT";
    public static final String LYNX_PROVIDER_TYPE_EXTERNAL_JS = "EXTERNAL_JS_SOURCE";
    public static final String LYNX_PROVIDER_TYPE_FONT = "FONT";
    public static final String LYNX_PROVIDER_TYPE_I18N_TEXT = "I18N_TEXT";
    public static final String LYNX_PROVIDER_TYPE_IMAGE = "IMAGE";
    public static final String LYNX_PROVIDER_TYPE_LOTTIE = "LOTTIE";
    public static final String LYNX_PROVIDER_TYPE_LYNX_CORE_JS = "LYNX_CORE_JS";
    public static final String LYNX_PROVIDER_TYPE_SVG = "SVG";
    public static final String LYNX_PROVIDER_TYPE_TEMPLATE = "TEMPLATE";
    public static final String LYNX_PROVIDER_TYPE_THEME = "THEME";
    public static final String LYNX_PROVIDER_TYPE_VIDEO = "VIDEO";
    final Map<String, LynxResourceProvider> resourceProviders = new HashMap();

    public void addLynxResourceProvider(String str, LynxResourceProvider lynxResourceProvider) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.resourceProviders.put(str, lynxResourceProvider);
    }

    public LynxResourceProvider getProviderByKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.resourceProviders.get(str);
    }

    public void clear() {
        this.resourceProviders.clear();
    }
}
