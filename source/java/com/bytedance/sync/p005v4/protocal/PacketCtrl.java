package com.bytedance.sync.p005v4.protocal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public enum PacketCtrl implements WireEnum {
    Noop(0),
    NeedFin(1);

    public static final ProtoAdapter<PacketCtrl> ADAPTER = new EnumAdapter<PacketCtrl>() { // from class: com.bytedance.sync.v4.protocal.PacketCtrl.ProtoAdapter_PacketCtrl
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: fromValue, reason: merged with bridge method [inline-methods] */
        public PacketCtrl m1014fromValue(int i) {
            return PacketCtrl.fromValue(i);
        }
    };
    private final int value;

    PacketCtrl(int i) {
        this.value = i;
    }

    public static PacketCtrl fromValue(int i) {
        if (i == 0) {
            return Noop;
        }
        if (i != 1) {
            return null;
        }
        return NeedFin;
    }

    public int getValue() {
        return this.value;
    }
}
