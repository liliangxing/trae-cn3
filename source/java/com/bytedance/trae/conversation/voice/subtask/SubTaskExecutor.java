package com.bytedance.trae.conversation.voice.subtask;

import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SubTaskProtocol.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;", "", "<init>", "(Ljava/lang/String;I)V", "ClientProxy", "ServerClosedLoop", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SubTaskExecutor {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SubTaskExecutor[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final SubTaskExecutor ClientProxy = new SubTaskExecutor("ClientProxy", 0);
    public static final SubTaskExecutor ServerClosedLoop = new SubTaskExecutor("ServerClosedLoop", 1);

    private static final /* synthetic */ SubTaskExecutor[] $values() {
        return new SubTaskExecutor[]{ClientProxy, ServerClosedLoop};
    }

    public static EnumEntries<SubTaskExecutor> getEntries() {
        return $ENTRIES;
    }

    private SubTaskExecutor(String str, int i) {
    }

    static {
        SubTaskExecutor[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: SubTaskProtocol.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor$Companion;", "", "<init>", "()V", "fromProtocol", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;", AccountMonitorConstants.CommonParameter.RAW, "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SubTaskExecutor fromProtocol(String raw) {
            return Intrinsics.areEqual(raw, SubTaskRequestMessage.EXECUTOR_SERVER) ? SubTaskExecutor.ServerClosedLoop : SubTaskExecutor.ClientProxy;
        }
    }

    public static SubTaskExecutor valueOf(String str) {
        return (SubTaskExecutor) Enum.valueOf(SubTaskExecutor.class, str);
    }

    public static SubTaskExecutor[] values() {
        return (SubTaskExecutor[]) $VALUES.clone();
    }
}
