package com.bytedance.trae.conversation.chat.block.renderer;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PureShowWidgetPresentationState.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;", "", "<init>", "(Ljava/lang/String;I)V", "SHOW_LOADING", "SHOW_COMPLETED", "KEEP_COMPLETED", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PureShowWidgetPresentationMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PureShowWidgetPresentationMode[] $VALUES;
    public static final PureShowWidgetPresentationMode SHOW_LOADING = new PureShowWidgetPresentationMode("SHOW_LOADING", 0);
    public static final PureShowWidgetPresentationMode SHOW_COMPLETED = new PureShowWidgetPresentationMode("SHOW_COMPLETED", 1);
    public static final PureShowWidgetPresentationMode KEEP_COMPLETED = new PureShowWidgetPresentationMode("KEEP_COMPLETED", 2);

    private static final /* synthetic */ PureShowWidgetPresentationMode[] $values() {
        return new PureShowWidgetPresentationMode[]{SHOW_LOADING, SHOW_COMPLETED, KEEP_COMPLETED};
    }

    public static EnumEntries<PureShowWidgetPresentationMode> getEntries() {
        return $ENTRIES;
    }

    private PureShowWidgetPresentationMode(String str, int i) {
    }

    static {
        PureShowWidgetPresentationMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static PureShowWidgetPresentationMode valueOf(String str) {
        return (PureShowWidgetPresentationMode) Enum.valueOf(PureShowWidgetPresentationMode.class, str);
    }

    public static PureShowWidgetPresentationMode[] values() {
        return (PureShowWidgetPresentationMode[]) $VALUES.clone();
    }
}
