package com.bytedance.trae.network;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HostResolver.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/network/AiRegion;", "", "<init>", "(Ljava/lang/String;I)V", "CN", "SG", "US", "Companion", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AiRegion {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AiRegion[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final AiRegion CN = new AiRegion("CN", 0);
    public static final AiRegion SG = new AiRegion("SG", 1);
    public static final AiRegion US = new AiRegion("US", 2);

    private static final /* synthetic */ AiRegion[] $values() {
        return new AiRegion[]{CN, SG, US};
    }

    public static EnumEntries<AiRegion> getEntries() {
        return $ENTRIES;
    }

    private AiRegion(String str, int i) {
    }

    static {
        AiRegion[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: HostResolver.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/network/AiRegion$Companion;", "", "<init>", "()V", "from", "Lcom/bytedance/trae/network/AiRegion;", "value", "", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AiRegion from(String value) {
            String str;
            if (value != null) {
                str = value.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str, "toUpperCase(...)");
            } else {
                str = null;
            }
            return Intrinsics.areEqual(str, "SG") ? AiRegion.SG : Intrinsics.areEqual(str, "US") ? AiRegion.US : AiRegion.CN;
        }
    }

    public static AiRegion valueOf(String str) {
        return (AiRegion) Enum.valueOf(AiRegion.class, str);
    }

    public static AiRegion[] values() {
        return (AiRegion[]) $VALUES.clone();
    }
}
