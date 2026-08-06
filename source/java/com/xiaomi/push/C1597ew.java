package com.xiaomi.push;

import java.nio.ByteBuffer;

/* renamed from: com.xiaomi.push.ew */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1597ew extends C1591eq {
    public C1597ew() {
        m2438a("PING", (String) null);
        m2437a("0");
        m2434a(0);
    }

    @Override // com.xiaomi.push.C1591eq
    /* renamed from: c */
    public int mo2450c() {
        if (m2429a().length == 0) {
            return 0;
        }
        return super.mo2450c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.C1591eq
    /* renamed from: a */
    public ByteBuffer mo2432a(ByteBuffer byteBuffer) {
        return m2429a().length == 0 ? byteBuffer : super.mo2432a(byteBuffer);
    }
}
