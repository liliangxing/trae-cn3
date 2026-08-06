package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MiPushClient;

/* renamed from: com.xiaomi.push.ec */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public enum EnumC1577ec {
    COMMAND_REGISTER(MiPushClient.COMMAND_REGISTER),
    COMMAND_UNREGISTER(MiPushClient.COMMAND_UNREGISTER),
    COMMAND_SET_ALIAS(MiPushClient.COMMAND_SET_ALIAS),
    COMMAND_UNSET_ALIAS(MiPushClient.COMMAND_UNSET_ALIAS),
    COMMAND_SET_ACCOUNT(MiPushClient.COMMAND_SET_ACCOUNT),
    COMMAND_UNSET_ACCOUNT(MiPushClient.COMMAND_UNSET_ACCOUNT),
    COMMAND_SUBSCRIBE_TOPIC(MiPushClient.COMMAND_SUBSCRIBE_TOPIC),
    COMMAND_UNSUBSCRIBE_TOPIC(MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC),
    COMMAND_SET_ACCEPT_TIME(MiPushClient.COMMAND_SET_ACCEPT_TIME),
    COMMAND_CHK_VDEVID("check-vdeviceid");


    /* renamed from: a */
    public final String f1521a;

    EnumC1577ec(String str) {
        this.f1521a = str;
    }

    /* renamed from: a */
    public static int m2340a(String str) {
        int i = -1;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        for (EnumC1577ec enumC1577ec : values()) {
            if (enumC1577ec.f1521a.equals(str)) {
                i = C1565dr.m2260a(enumC1577ec);
            }
        }
        return i;
    }
}
