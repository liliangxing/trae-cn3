package com.bytedance.trae.conversation.chat.toolcall;

import com.bytedance.trae.im.model.ConfirmInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ToolExecutionStatus.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", DebugCoroutineInfoImplKt.RUNNING, "SUCCESS", "FAILED", "SKIPPED", "CANCELED", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ToolExecutionStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ToolExecutionStatus[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final ToolExecutionStatus PENDING = new ToolExecutionStatus("PENDING", 0);
    public static final ToolExecutionStatus RUNNING = new ToolExecutionStatus(DebugCoroutineInfoImplKt.RUNNING, 1);
    public static final ToolExecutionStatus SUCCESS = new ToolExecutionStatus("SUCCESS", 2);
    public static final ToolExecutionStatus FAILED = new ToolExecutionStatus("FAILED", 3);
    public static final ToolExecutionStatus SKIPPED = new ToolExecutionStatus("SKIPPED", 4);
    public static final ToolExecutionStatus CANCELED = new ToolExecutionStatus("CANCELED", 5);

    private static final /* synthetic */ ToolExecutionStatus[] $values() {
        return new ToolExecutionStatus[]{PENDING, RUNNING, SUCCESS, FAILED, SKIPPED, CANCELED};
    }

    public static EnumEntries<ToolExecutionStatus> getEntries() {
        return $ENTRIES;
    }

    private ToolExecutionStatus(String str, int i) {
    }

    static {
        ToolExecutionStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: ToolExecutionStatus.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;", "", "<init>", "()V", "fromString", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;", "status", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
        
            if (r2.equals("error") == false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:?, code lost:
        
            return com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus.FAILED;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004b, code lost:
        
            if (r2.equals("failed") == false) goto L33;
         */
        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0006. Please report as an issue. */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final ToolExecutionStatus fromString(String status) {
            if (status != null) {
                switch (status.hashCode()) {
                    case -1867169789:
                        if (status.equals("success")) {
                            return ToolExecutionStatus.SUCCESS;
                        }
                        break;
                    case -1281977283:
                        break;
                    case -682587753:
                        if (status.equals("pending")) {
                            return ToolExecutionStatus.PENDING;
                        }
                        break;
                    case -123173735:
                        if (status.equals(ConfirmInfo.STATUS_CANCELED)) {
                            return ToolExecutionStatus.CANCELED;
                        }
                        break;
                    case 96784904:
                        break;
                    case 1550783935:
                        if (status.equals("running")) {
                            return ToolExecutionStatus.RUNNING;
                        }
                        break;
                    case 2147444528:
                        if (status.equals(ConfirmInfo.STATUS_SKIPPED)) {
                            return ToolExecutionStatus.SKIPPED;
                        }
                        break;
                }
            }
            return ToolExecutionStatus.PENDING;
        }
    }

    public static ToolExecutionStatus valueOf(String str) {
        return (ToolExecutionStatus) Enum.valueOf(ToolExecutionStatus.class, str);
    }

    public static ToolExecutionStatus[] values() {
        return (ToolExecutionStatus[]) $VALUES.clone();
    }
}
