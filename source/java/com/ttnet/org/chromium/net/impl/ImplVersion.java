package com.ttnet.org.chromium.net.impl;

/* loaded from: classes7.dex */
public class ImplVersion {
    private static final int API_LEVEL = 16;
    private static final String CRONET_VERSION = "107.0.5273.2";
    private static final String LAST_CHANGE = "603916514ff3ad53ca76adab85de50686218bcbf";

    public static int getApiLevel() {
        return 16;
    }

    public static String getCronetVersion() {
        return CRONET_VERSION;
    }

    public static String getCronetVersionWithLastChange() {
        return "107.0.5273.2@60391651";
    }

    public static String getLastChange() {
        return LAST_CHANGE;
    }

    private ImplVersion() {
    }
}
