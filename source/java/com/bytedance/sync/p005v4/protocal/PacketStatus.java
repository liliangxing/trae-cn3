package com.bytedance.sync.p005v4.protocal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public enum PacketStatus implements WireEnum {
    Full(0),
    OnlySave(1);

    public static final ProtoAdapter<PacketStatus> ADAPTER = new EnumAdapter<PacketStatus>() { // from class: com.bytedance.sync.v4.protocal.PacketStatus.ProtoAdapter_PacketStatus
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: fromValue, reason: merged with bridge method [inline-methods] */
        public PacketStatus m1015fromValue(int i) {
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

    public int getValue() {
        return this.value;
    }
}
