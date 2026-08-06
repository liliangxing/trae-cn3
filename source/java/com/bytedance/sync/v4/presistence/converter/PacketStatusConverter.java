package com.bytedance.sync.v4.presistence.converter;

import com.bytedance.sync.v4.protocal.PacketStatus;

/* loaded from: classes5.dex */
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
