package com.bytedance.sync.v4.presistence.converter;

import com.bytedance.sync.v4.protocal.PacketCtrl;

/* loaded from: classes5.dex */
public class PacketCtrlConverter {
    public static PacketCtrl revertTopicType(int i) {
        PacketCtrl fromValue = PacketCtrl.fromValue(i);
        return fromValue == null ? PacketCtrl.Noop : fromValue;
    }

    public static int converterStatus(PacketCtrl packetCtrl) {
        if (packetCtrl == null) {
            return PacketCtrl.Noop.getValue();
        }
        return packetCtrl.getValue();
    }
}
