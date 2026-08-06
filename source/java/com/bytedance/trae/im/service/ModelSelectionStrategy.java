package com.bytedance.trae.im.service;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ICreateAgentTask.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/im/service/ModelSelectionStrategy;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AUTO", "MANUAL", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModelSelectionStrategy {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ModelSelectionStrategy[] $VALUES;

    @SerializedName("auto")
    public static final ModelSelectionStrategy AUTO = new ModelSelectionStrategy("AUTO", 0, "auto");

    @SerializedName("manual")
    public static final ModelSelectionStrategy MANUAL = new ModelSelectionStrategy("MANUAL", 1, "manual");
    private final String value;

    private static final /* synthetic */ ModelSelectionStrategy[] $values() {
        return new ModelSelectionStrategy[]{AUTO, MANUAL};
    }

    public static EnumEntries<ModelSelectionStrategy> getEntries() {
        return $ENTRIES;
    }

    private ModelSelectionStrategy(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        ModelSelectionStrategy[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ModelSelectionStrategy valueOf(String str) {
        return (ModelSelectionStrategy) Enum.valueOf(ModelSelectionStrategy.class, str);
    }

    public static ModelSelectionStrategy[] values() {
        return (ModelSelectionStrategy[]) $VALUES.clone();
    }
}
