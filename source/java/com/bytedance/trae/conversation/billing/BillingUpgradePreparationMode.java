package com.bytedance.trae.conversation.billing;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BillingUpgradePreparation.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;", "", "<init>", "(Ljava/lang/String;I)V", "PromptEligible", "SilentRecovery", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BillingUpgradePreparationMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BillingUpgradePreparationMode[] $VALUES;
    public static final BillingUpgradePreparationMode PromptEligible = new BillingUpgradePreparationMode("PromptEligible", 0);
    public static final BillingUpgradePreparationMode SilentRecovery = new BillingUpgradePreparationMode("SilentRecovery", 1);

    private static final /* synthetic */ BillingUpgradePreparationMode[] $values() {
        return new BillingUpgradePreparationMode[]{PromptEligible, SilentRecovery};
    }

    public static EnumEntries<BillingUpgradePreparationMode> getEntries() {
        return $ENTRIES;
    }

    private BillingUpgradePreparationMode(String str, int i) {
    }

    static {
        BillingUpgradePreparationMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static BillingUpgradePreparationMode valueOf(String str) {
        return (BillingUpgradePreparationMode) Enum.valueOf(BillingUpgradePreparationMode.class, str);
    }

    public static BillingUpgradePreparationMode[] values() {
        return (BillingUpgradePreparationMode[]) $VALUES.clone();
    }
}
