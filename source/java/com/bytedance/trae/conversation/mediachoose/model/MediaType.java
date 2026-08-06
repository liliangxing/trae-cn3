package com.bytedance.trae.conversation.mediachoose.model;

import com.lynx.tasm.provider.LynxProviderRegistry;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.apache.commons.codec.language.bm.Rule;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MediaType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;", "", "<init>", "(Ljava/lang/String;I)V", LynxProviderRegistry.LYNX_PROVIDER_TYPE_IMAGE, LynxProviderRegistry.LYNX_PROVIDER_TYPE_VIDEO, Rule.ALL, "ALL_EXCLUSIVE", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MediaType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MediaType[] $VALUES;
    public static final MediaType IMAGE = new MediaType(LynxProviderRegistry.LYNX_PROVIDER_TYPE_IMAGE, 0);
    public static final MediaType VIDEO = new MediaType(LynxProviderRegistry.LYNX_PROVIDER_TYPE_VIDEO, 1);
    public static final MediaType ALL = new MediaType(Rule.ALL, 2);
    public static final MediaType ALL_EXCLUSIVE = new MediaType("ALL_EXCLUSIVE", 3);

    private static final /* synthetic */ MediaType[] $values() {
        return new MediaType[]{IMAGE, VIDEO, ALL, ALL_EXCLUSIVE};
    }

    public static EnumEntries<MediaType> getEntries() {
        return $ENTRIES;
    }

    private MediaType(String str, int i) {
    }

    static {
        MediaType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static MediaType valueOf(String str) {
        return (MediaType) Enum.valueOf(MediaType.class, str);
    }

    public static MediaType[] values() {
        return (MediaType[]) $VALUES.clone();
    }
}
