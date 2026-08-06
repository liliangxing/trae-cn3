package com.bytedance.sync.p005v4.protocal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public enum Flag implements WireEnum {
    None(0),
    ACK(1),
    Data(2),
    Sync(3),
    Poll(4),
    FIN(5);

    public static final ProtoAdapter<Flag> ADAPTER = new EnumAdapter<Flag>() { // from class: com.bytedance.sync.v4.protocal.Flag.ProtoAdapter_Flag
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: fromValue, reason: merged with bridge method [inline-methods] */
        public Flag m1012fromValue(int i) {
            return Flag.fromValue(i);
        }
    };
    private final int value;

    Flag(int i) {
        this.value = i;
    }

    public static Flag fromValue(int i) {
        if (i == 0) {
            return None;
        }
        if (i == 1) {
            return ACK;
        }
        if (i == 2) {
            return Data;
        }
        if (i == 3) {
            return Sync;
        }
        if (i == 4) {
            return Poll;
        }
        if (i != 5) {
            return null;
        }
        return FIN;
    }

    public int getValue() {
        return this.value;
    }
}
