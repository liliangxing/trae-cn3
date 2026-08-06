package com.bytedance.sync.v4.protocal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* loaded from: classes5.dex */
public enum PacketStatus implements WireEnum {
    Full(0),
    OnlySave(1);

    public static final ProtoAdapter<PacketStatus> ADAPTER = new EnumAdapter<PacketStatus>() { // from class: com.bytedance.sync.v4.protocal.PacketStatus.ProtoAdapter_PacketStatus
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.EnumAdapter
        public PacketStatus fromValue(int i) {
            return PacketStatus.fromValue(i);
        }
    };
    private final int value;

    PacketStatus(int i) {
        this.value = i;
    }

    public static PacketStatus fromValue(int i) {
        if (i == 0) {
            return Full;
        }
        if (i != 1) {
            return null;
        }
        return OnlySave;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
