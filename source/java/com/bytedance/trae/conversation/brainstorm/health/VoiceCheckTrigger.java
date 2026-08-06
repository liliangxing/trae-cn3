package com.bytedance.trae.conversation.brainstorm.health;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: VoiceCheckTrigger.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;", "", "checkPermission", "", "<init>", "(Ljava/lang/String;IZ)V", "getCheckPermission", "()Z", "INTRO_ENTERED", "INTRO_START_CLICK", "DISCUSSING_ENTERED", "APP_RESUMED", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VoiceCheckTrigger {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VoiceCheckTrigger[] $VALUES;
    private final boolean checkPermission;
    public static final VoiceCheckTrigger INTRO_ENTERED = new VoiceCheckTrigger("INTRO_ENTERED", 0, true);
    public static final VoiceCheckTrigger INTRO_START_CLICK = new VoiceCheckTrigger("INTRO_START_CLICK", 1, true);
    public static final VoiceCheckTrigger DISCUSSING_ENTERED = new VoiceCheckTrigger("DISCUSSING_ENTERED", 2, true);
    public static final VoiceCheckTrigger APP_RESUMED = new VoiceCheckTrigger("APP_RESUMED", 3, true);

    private static final /* synthetic */ VoiceCheckTrigger[] $values() {
        return new VoiceCheckTrigger[]{INTRO_ENTERED, INTRO_START_CLICK, DISCUSSING_ENTERED, APP_RESUMED};
    }

    public static EnumEntries<VoiceCheckTrigger> getEntries() {
        return $ENTRIES;
    }

    private VoiceCheckTrigger(String str, int i, boolean z) {
        this.checkPermission = z;
    }

    public final boolean getCheckPermission() {
        return this.checkPermission;
    }

    static {
        VoiceCheckTrigger[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static VoiceCheckTrigger valueOf(String str) {
        return (VoiceCheckTrigger) Enum.valueOf(VoiceCheckTrigger.class, str);
    }

    public static VoiceCheckTrigger[] values() {
        return (VoiceCheckTrigger[]) $VALUES.clone();
    }
}
