package com.bytedance.trae.network;

import com.bytedance.networkstackapplib.NetworkStackConstant;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SseConnection.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/network/SseState;", "", "<init>", "(Ljava/lang/String;I)V", NetworkStackConstant.ERR_DISCONNECTED, "CONNECTING", "CONNECTED", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SseState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SseState[] $VALUES;
    public static final SseState DISCONNECTED = new SseState(NetworkStackConstant.ERR_DISCONNECTED, 0);
    public static final SseState CONNECTING = new SseState("CONNECTING", 1);
    public static final SseState CONNECTED = new SseState("CONNECTED", 2);

    private static final /* synthetic */ SseState[] $values() {
        return new SseState[]{DISCONNECTED, CONNECTING, CONNECTED};
    }

    public static EnumEntries<SseState> getEntries() {
        return $ENTRIES;
    }

    private SseState(String str, int i) {
    }

    static {
        SseState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static SseState valueOf(String str) {
        return (SseState) Enum.valueOf(SseState.class, str);
    }

    public static SseState[] values() {
        return (SseState[]) $VALUES.clone();
    }
}
