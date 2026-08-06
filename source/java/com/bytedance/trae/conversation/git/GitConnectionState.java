package com.bytedance.trae.conversation.git;

import com.bytedance.networkstackapplib.NetworkStackConstant;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: GitSelectionViewModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitConnectionState;", "", "<init>", "(Ljava/lang/String;I)V", NetworkStackConstant.ERR_DISCONNECTED, "CONNECTING", "CONNECTED", "ERROR", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GitConnectionState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GitConnectionState[] $VALUES;
    public static final GitConnectionState DISCONNECTED = new GitConnectionState(NetworkStackConstant.ERR_DISCONNECTED, 0);
    public static final GitConnectionState CONNECTING = new GitConnectionState("CONNECTING", 1);
    public static final GitConnectionState CONNECTED = new GitConnectionState("CONNECTED", 2);
    public static final GitConnectionState ERROR = new GitConnectionState("ERROR", 3);

    private static final /* synthetic */ GitConnectionState[] $values() {
        return new GitConnectionState[]{DISCONNECTED, CONNECTING, CONNECTED, ERROR};
    }

    public static EnumEntries<GitConnectionState> getEntries() {
        return $ENTRIES;
    }

    private GitConnectionState(String str, int i) {
    }

    static {
        GitConnectionState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static GitConnectionState valueOf(String str) {
        return (GitConnectionState) Enum.valueOf(GitConnectionState.class, str);
    }

    public static GitConnectionState[] values() {
        return (GitConnectionState[]) $VALUES.clone();
    }
}
