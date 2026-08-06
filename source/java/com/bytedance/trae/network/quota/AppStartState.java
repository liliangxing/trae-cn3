package com.bytedance.trae.network.quota;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AppStartState.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/network/quota/AppStartState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NormalStart", "ColdStart", "HotStart", "WarmStart", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AppStartState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AppStartState[] $VALUES;
    private final int value;
    public static final AppStartState NormalStart = new AppStartState("NormalStart", 0, -1);
    public static final AppStartState ColdStart = new AppStartState("ColdStart", 1, 0);
    public static final AppStartState HotStart = new AppStartState("HotStart", 2, 1);
    public static final AppStartState WarmStart = new AppStartState("WarmStart", 3, 2);

    private static final /* synthetic */ AppStartState[] $values() {
        return new AppStartState[]{NormalStart, ColdStart, HotStart, WarmStart};
    }

    public static EnumEntries<AppStartState> getEntries() {
        return $ENTRIES;
    }

    private AppStartState(String str, int i, int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        AppStartState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static AppStartState valueOf(String str) {
        return (AppStartState) Enum.valueOf(AppStartState.class, str);
    }

    public static AppStartState[] values() {
        return (AppStartState[]) $VALUES.clone();
    }
}
