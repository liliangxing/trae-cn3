package com.bytedance.trae.network;

import com.bytedance.networkstackapplib.NetworkStackConstant;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: NetworkConnectState.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/network/NetworkConnectState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", NetworkStackConstant.ERR_DISCONNECTED, "CONNECTED", "CONNECTING", "Companion", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NetworkConnectState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NetworkConnectState[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int value;
    public static final NetworkConnectState DISCONNECTED = new NetworkConnectState(NetworkStackConstant.ERR_DISCONNECTED, 0, 0);
    public static final NetworkConnectState CONNECTED = new NetworkConnectState("CONNECTED", 1, 1);
    public static final NetworkConnectState CONNECTING = new NetworkConnectState("CONNECTING", 2, 2);

    private static final /* synthetic */ NetworkConnectState[] $values() {
        return new NetworkConnectState[]{DISCONNECTED, CONNECTED, CONNECTING};
    }

    public static EnumEntries<NetworkConnectState> getEntries() {
        return $ENTRIES;
    }

    private NetworkConnectState(String str, int i, int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        NetworkConnectState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: NetworkConnectState.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/network/NetworkConnectState$Companion;", "", "<init>", "()V", "fromValue", "Lcom/bytedance/trae/network/NetworkConnectState;", "value", "", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NetworkConnectState fromValue(int value) {
            Object obj;
            Iterator<E> it = NetworkConnectState.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((NetworkConnectState) obj).getValue() == value) {
                    break;
                }
            }
            return (NetworkConnectState) obj;
        }
    }

    public static NetworkConnectState valueOf(String str) {
        return (NetworkConnectState) Enum.valueOf(NetworkConnectState.class, str);
    }

    public static NetworkConnectState[] values() {
        return (NetworkConnectState[]) $VALUES.clone();
    }
}
