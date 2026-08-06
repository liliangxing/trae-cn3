package com.bytedance.trae.settings.impl.feature;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FeatureCapabilityScope.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;", "", "remoteKey", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRemoteKey", "()Ljava/lang/String;", "TOC", "SSO", "TOB", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureCapabilityScope {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FeatureCapabilityScope[] $VALUES;
    private final String remoteKey;
    public static final FeatureCapabilityScope TOC = new FeatureCapabilityScope("TOC", 0, "toc");
    public static final FeatureCapabilityScope SSO = new FeatureCapabilityScope("SSO", 1, "sso");
    public static final FeatureCapabilityScope TOB = new FeatureCapabilityScope("TOB", 2, "tob");

    private static final /* synthetic */ FeatureCapabilityScope[] $values() {
        return new FeatureCapabilityScope[]{TOC, SSO, TOB};
    }

    public static EnumEntries<FeatureCapabilityScope> getEntries() {
        return $ENTRIES;
    }

    private FeatureCapabilityScope(String str, int i, String str2) {
        this.remoteKey = str2;
    }

    public final String getRemoteKey() {
        return this.remoteKey;
    }

    static {
        FeatureCapabilityScope[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static FeatureCapabilityScope valueOf(String str) {
        return (FeatureCapabilityScope) Enum.valueOf(FeatureCapabilityScope.class, str);
    }

    public static FeatureCapabilityScope[] values() {
        return (FeatureCapabilityScope[]) $VALUES.clone();
    }
}
