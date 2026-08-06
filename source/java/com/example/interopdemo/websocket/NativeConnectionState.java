package com.example.interopdemo.websocket;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: NativeRawWsListener.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/example/interopdemo/websocket/NativeConnectionState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "CONNECTING", "DISCONNECTING", "FAILED", "CLOSED", "CONNECTED", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NativeConnectionState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NativeConnectionState[] $VALUES;
    public static final NativeConnectionState UNKNOWN = new NativeConnectionState("UNKNOWN", 0);
    public static final NativeConnectionState CONNECTING = new NativeConnectionState("CONNECTING", 1);
    public static final NativeConnectionState DISCONNECTING = new NativeConnectionState("DISCONNECTING", 2);
    public static final NativeConnectionState FAILED = new NativeConnectionState("FAILED", 3);
    public static final NativeConnectionState CLOSED = new NativeConnectionState("CLOSED", 4);
    public static final NativeConnectionState CONNECTED = new NativeConnectionState("CONNECTED", 5);

    private static final /* synthetic */ NativeConnectionState[] $values() {
        return new NativeConnectionState[]{UNKNOWN, CONNECTING, DISCONNECTING, FAILED, CLOSED, CONNECTED};
    }

    public static EnumEntries<NativeConnectionState> getEntries() {
        return $ENTRIES;
    }

    private NativeConnectionState(String str, int i) {
    }

    static {
        NativeConnectionState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static NativeConnectionState valueOf(String str) {
        return (NativeConnectionState) Enum.valueOf(NativeConnectionState.class, str);
    }

    public static NativeConnectionState[] values() {
        return (NativeConnectionState[]) $VALUES.clone();
    }
}
