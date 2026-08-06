package com.xiaomi.push;

import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public final class ew extends eq {
    public ew() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    @Override // com.xiaomi.push.eq
    public int c() {
        if (a().length == 0) {
            return 0;
        }
        return super.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.eq
    /* renamed from: a */
    public ByteBuffer mo9869a(ByteBuffer byteBuffer) {
        return a().length == 0 ? byteBuffer : super.mo9869a(byteBuffer);
    }
}
