package com.bytedance.annie.pro;

import kotlin.Metadata;

/* compiled from: AnnieProConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/annie/pro/AnnieProConstants;", "", "()V", "DEFAULT_LYNX_DEMO", "", "getDEFAULT_LYNX_DEMO", "()Ljava/lang/String;", "ONLINE_URL_PREFIX", "getONLINE_URL_PREFIX", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class AnnieProConstants {
    public static final AnnieProConstants INSTANCE = new AnnieProConstants();
    private static final String ONLINE_URL_PREFIX = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/annie/pro/application/";
    private static final String DEFAULT_LYNX_DEMO = "sslocal://lynxview/?app_id=annie_pro_test_1_douyin&enable_annie_pro=1&start_page=pages%2Findex%2Ftemplate.js";

    private AnnieProConstants() {
    }

    public final String getONLINE_URL_PREFIX() {
        return ONLINE_URL_PREFIX;
    }

    public final String getDEFAULT_LYNX_DEMO() {
        return DEFAULT_LYNX_DEMO;
    }
}
