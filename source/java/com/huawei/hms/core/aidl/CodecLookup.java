package com.huawei.hms.core.aidl;

/* loaded from: classes6.dex */
public final class CodecLookup {
    private CodecLookup() {
    }

    public static MessageCodec find(int i) {
        if (i == 2) {
            return new MessageCodecV2();
        }
        return new MessageCodec();
    }
}
