package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

/* renamed from: com.xiaomi.mipush.sdk.n */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class C1455n {

    /* renamed from: a */
    int f865a = 0;

    /* renamed from: a */
    String f866a = "";

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C1455n)) {
            return false;
        }
        C1455n c1455n = (C1455n) obj;
        return !TextUtils.isEmpty(c1455n.f866a) && c1455n.f866a.equals(this.f866a);
    }
}
