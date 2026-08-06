package com.bytedance.sync.p005v4.presistence.converter;

import com.bytedance.sync.p005v4.protocal.PacketCtrl;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
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
