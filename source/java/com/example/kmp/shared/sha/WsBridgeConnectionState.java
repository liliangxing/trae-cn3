package com.example.kmp.shared.sha;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: TTWsClientBridge.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/example/kmp/shared/sha/WsBridgeConnectionState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "CONNECTING", "DISCONNECTING", "FAILED", "CLOSED", "CONNECTED", "kmpNativeBridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WsBridgeConnectionState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WsBridgeConnectionState[] $VALUES;
    public static final WsBridgeConnectionState UNKNOWN = new WsBridgeConnectionState("UNKNOWN", 0);
    public static final WsBridgeConnectionState CONNECTING = new WsBridgeConnectionState("CONNECTING", 1);
    public static final WsBridgeConnectionState DISCONNECTING = new WsBridgeConnectionState("DISCONNECTING", 2);
    public static final WsBridgeConnectionState FAILED = new WsBridgeConnectionState("FAILED", 3);
    public static final WsBridgeConnectionState CLOSED = new WsBridgeConnectionState("CLOSED", 4);
    public static final WsBridgeConnectionState CONNECTED = new WsBridgeConnectionState("CONNECTED", 5);

    private static final /* synthetic */ WsBridgeConnectionState[] $values() {
        return new WsBridgeConnectionState[]{UNKNOWN, CONNECTING, DISCONNECTING, FAILED, CLOSED, CONNECTED};
    }

    public static EnumEntries<WsBridgeConnectionState> getEntries() {
        return $ENTRIES;
    }

    private WsBridgeConnectionState(String str, int i) {
    }

    static {
        WsBridgeConnectionState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static WsBridgeConnectionState valueOf(String str) {
        return (WsBridgeConnectionState) Enum.valueOf(WsBridgeConnectionState.class, str);
    }

    public static WsBridgeConnectionState[] values() {
        return (WsBridgeConnectionState[]) $VALUES.clone();
    }
}
