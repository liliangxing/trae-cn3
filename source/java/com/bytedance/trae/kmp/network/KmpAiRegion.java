package com.bytedance.trae.kmp.network;

import com.bytedance.praisedialoglib.PraiseDialogConstant;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: KmpHostResolver.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/kmp/network/KmpAiRegion;", "", "<init>", "(Ljava/lang/String;I)V", "CN", "SG", "US", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpAiRegion {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ KmpAiRegion[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: CN */
    public static final KmpAiRegion f124CN = new KmpAiRegion("CN", 0);

    /* renamed from: SG */
    public static final KmpAiRegion f125SG = new KmpAiRegion("SG", 1);

    /* renamed from: US */
    public static final KmpAiRegion f126US = new KmpAiRegion("US", 2);

    private static final /* synthetic */ KmpAiRegion[] $values() {
        return new KmpAiRegion[]{f124CN, f125SG, f126US};
    }

    public static EnumEntries<KmpAiRegion> getEntries() {
        return $ENTRIES;
    }

    private KmpAiRegion(String str, int i) {
    }

    static {
        KmpAiRegion[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: KmpHostResolver.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/kmp/network/KmpAiRegion$Companion;", "", "<init>", "()V", PraiseDialogConstant.FROM, "Lcom/bytedance/trae/kmp/network/KmpAiRegion;", "value", "", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KmpAiRegion from(String value) {
            String str;
            if (value != null) {
                str = value.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str, "toUpperCase(...)");
            } else {
                str = null;
            }
            return Intrinsics.areEqual(str, "SG") ? KmpAiRegion.f125SG : Intrinsics.areEqual(str, "US") ? KmpAiRegion.f126US : KmpAiRegion.f124CN;
        }
    }

    public static KmpAiRegion valueOf(String str) {
        return (KmpAiRegion) Enum.valueOf(KmpAiRegion.class, str);
    }

    public static KmpAiRegion[] values() {
        return (KmpAiRegion[]) $VALUES.clone();
    }
}
