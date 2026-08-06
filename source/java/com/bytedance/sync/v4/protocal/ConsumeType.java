package com.bytedance.sync.v4.protocal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* loaded from: classes5.dex */
public enum ConsumeType implements WireEnum {
    OneByOne(0),
    Increment(1);

    public static final ProtoAdapter<ConsumeType> ADAPTER = new EnumAdapter<ConsumeType>() { // from class: com.bytedance.sync.v4.protocal.ConsumeType.ProtoAdapter_ConsumeType
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.EnumAdapter
        public ConsumeType fromValue(int i) {
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

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
