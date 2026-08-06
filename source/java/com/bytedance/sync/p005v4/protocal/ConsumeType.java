package com.bytedance.sync.p005v4.protocal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public enum ConsumeType implements WireEnum {
    OneByOne(0),
    Increment(1);

    public static final ProtoAdapter<ConsumeType> ADAPTER = new EnumAdapter<ConsumeType>() { // from class: com.bytedance.sync.v4.protocal.ConsumeType.ProtoAdapter_ConsumeType
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: fromValue, reason: merged with bridge method [inline-methods] */
        public ConsumeType m1010fromValue(int i) {
            return ConsumeType.fromValue(i);
        }
    };
    private final int value;

    ConsumeType(int i) {
        this.value = i;
    }

    public static ConsumeType fromValue(int i) {
        if (i == 0) {
            return OneByOne;
        }
        if (i != 1) {
            return null;
        }
        return Increment;
    }

    public int getValue() {
        return this.value;
    }
}
