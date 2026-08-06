package com.bytedance.trae.im.service;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.apache.commons.codec.language.bm.Rule;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: IListClisService.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/im/service/CliListSource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "REGISTERED", "CONNECTED", Rule.ALL, "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CliListSource {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CliListSource[] $VALUES;
    private final String value;
    public static final CliListSource REGISTERED = new CliListSource("REGISTERED", 0, "registered");
    public static final CliListSource CONNECTED = new CliListSource("CONNECTED", 1, "connected");
    public static final CliListSource ALL = new CliListSource(Rule.ALL, 2, "all");

    private static final /* synthetic */ CliListSource[] $values() {
        return new CliListSource[]{REGISTERED, CONNECTED, ALL};
    }

    public static EnumEntries<CliListSource> getEntries() {
        return $ENTRIES;
    }

    private CliListSource(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        CliListSource[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static CliListSource valueOf(String str) {
        return (CliListSource) Enum.valueOf(CliListSource.class, str);
    }

    public static CliListSource[] values() {
        return (CliListSource[]) $VALUES.clone();
    }
}
