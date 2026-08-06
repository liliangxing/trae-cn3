package com.bytedance.trae.conversation.products;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HtmlArtifactRemoteArchiveUrlResolver.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;", "", "<init>", "(Ljava/lang/String;I)V", "ENSURE_SANDBOX_READY", "DIRECT_ARCHIVE", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HtmlArtifactRemoteArchiveResolveMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HtmlArtifactRemoteArchiveResolveMode[] $VALUES;
    public static final HtmlArtifactRemoteArchiveResolveMode ENSURE_SANDBOX_READY = new HtmlArtifactRemoteArchiveResolveMode("ENSURE_SANDBOX_READY", 0);
    public static final HtmlArtifactRemoteArchiveResolveMode DIRECT_ARCHIVE = new HtmlArtifactRemoteArchiveResolveMode("DIRECT_ARCHIVE", 1);

    private static final /* synthetic */ HtmlArtifactRemoteArchiveResolveMode[] $values() {
        return new HtmlArtifactRemoteArchiveResolveMode[]{ENSURE_SANDBOX_READY, DIRECT_ARCHIVE};
    }

    public static EnumEntries<HtmlArtifactRemoteArchiveResolveMode> getEntries() {
        return $ENTRIES;
    }

    private HtmlArtifactRemoteArchiveResolveMode(String str, int i) {
    }

    static {
        HtmlArtifactRemoteArchiveResolveMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static HtmlArtifactRemoteArchiveResolveMode valueOf(String str) {
        return (HtmlArtifactRemoteArchiveResolveMode) Enum.valueOf(HtmlArtifactRemoteArchiveResolveMode.class, str);
    }

    public static HtmlArtifactRemoteArchiveResolveMode[] values() {
        return (HtmlArtifactRemoteArchiveResolveMode[]) $VALUES.clone();
    }
}
