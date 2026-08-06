package com.bytedance.trae.network;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HubNetConnection.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/network/TransportMode;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "CONNECTING", "WEBSOCKET", "SSE", "HTTP_FALLBACK", "SHUTDOWN", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TransportMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TransportMode[] $VALUES;
    public static final TransportMode IDLE = new TransportMode("IDLE", 0);
    public static final TransportMode CONNECTING = new TransportMode("CONNECTING", 1);
    public static final TransportMode WEBSOCKET = new TransportMode("WEBSOCKET", 2);
    public static final TransportMode SSE = new TransportMode("SSE", 3);
    public static final TransportMode HTTP_FALLBACK = new TransportMode("HTTP_FALLBACK", 4);
    public static final TransportMode SHUTDOWN = new TransportMode("SHUTDOWN", 5);

    private static final /* synthetic */ TransportMode[] $values() {
        return new TransportMode[]{IDLE, CONNECTING, WEBSOCKET, SSE, HTTP_FALLBACK, SHUTDOWN};
    }

    public static EnumEntries<TransportMode> getEntries() {
        return $ENTRIES;
    }

    private TransportMode(String str, int i) {
    }

    static {
        TransportMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static TransportMode valueOf(String str) {
        return (TransportMode) Enum.valueOf(TransportMode.class, str);
    }

    public static TransportMode[] values() {
        return (TransportMode[]) $VALUES.clone();
    }
}
