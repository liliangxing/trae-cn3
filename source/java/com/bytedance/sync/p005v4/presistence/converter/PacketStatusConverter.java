package com.bytedance.sync.p005v4.presistence.converter;

import com.bytedance.sync.p005v4.protocal.PacketStatus;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class PacketStatusConverter {
    public static PacketStatus revertTopicType(int i) {
        PacketStatus fromValue = PacketStatus.fromValue(i);
        return fromValue == null ? PacketStatus.Full : fromValue;
    }

    public static int converterStatus(PacketStatus packetStatus) {
        if (packetStatus == null) {
            return PacketStatus.Full.getValue();
        }
        return packetStatus.getValue();
    }
}
