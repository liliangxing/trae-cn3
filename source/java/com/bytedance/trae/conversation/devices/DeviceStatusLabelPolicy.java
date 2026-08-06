package com.bytedance.trae.conversation.devices;

import kotlin.Metadata;

/* compiled from: DeviceStatusLabelPolicy.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DeviceStatusLabelPolicy;", "", "<init>", "()V", "resolve", "Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;", "isOnline", "", "isPaired", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeviceStatusLabelPolicy {
    public static final DeviceStatusLabelPolicy INSTANCE = new DeviceStatusLabelPolicy();

    private DeviceStatusLabelPolicy() {
    }

    public final DeviceStatusLabel resolve(boolean isOnline, boolean isPaired) {
        if (!isPaired) {
            return DeviceStatusLabel.UNPAIRED;
        }
        if (isOnline) {
            return DeviceStatusLabel.ONLINE;
        }
        return DeviceStatusLabel.OFFLINE;
    }
}
