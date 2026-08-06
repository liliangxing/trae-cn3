package com.bytedance.ug.sdk.deeplink;

import com.bytedance.upc.Constants;

/* loaded from: classes4.dex */
public enum UriType {
    ILLEGAL("0"),
    APP_LINKS("1"),
    UNIVERSE_LINK("2"),
    URI_SCHEME("3"),
    CLIPBOARD(Constants.RECOMMEND_BASE_ON_FOLLOW_LIST),
    DEVICE_PRINT(Constants.CONTENT_RICHNESS_EXPANSION_FREQUENCY);

    private String value;

    UriType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
