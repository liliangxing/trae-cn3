package com.bytedance.sync.p005v4.protocal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public enum InfoKey implements WireEnum {
    Params(0),
    CustomParams(1),
    ErrCode(100),
    ErrMsg(101);

    public static final ProtoAdapter<InfoKey> ADAPTER = new EnumAdapter<InfoKey>() { // from class: com.bytedance.sync.v4.protocal.InfoKey.ProtoAdapter_InfoKey
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: fromValue, reason: merged with bridge method [inline-methods] */
        public InfoKey m1013fromValue(int i) {
            return InfoKey.fromValue(i);
        }
    };
    private final int value;

    InfoKey(int i) {
        this.value = i;
    }

    public static InfoKey fromValue(int i) {
        if (i == 0) {
            return Params;
        }
        if (i == 1) {
            return CustomParams;
        }
        if (i == 100) {
            return ErrCode;
        }
        if (i != 101) {
            return null;
        }
        return ErrMsg;
    }

    public int getValue() {
        return this.value;
    }
}
