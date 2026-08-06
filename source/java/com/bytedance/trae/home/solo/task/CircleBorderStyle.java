package com.bytedance.trae.home.solo.task;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: TaskModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "SOLID", "DASHED", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CircleBorderStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CircleBorderStyle[] $VALUES;
    public static final CircleBorderStyle NONE = new CircleBorderStyle("NONE", 0);
    public static final CircleBorderStyle SOLID = new CircleBorderStyle("SOLID", 1);
    public static final CircleBorderStyle DASHED = new CircleBorderStyle("DASHED", 2);

    private static final /* synthetic */ CircleBorderStyle[] $values() {
        return new CircleBorderStyle[]{NONE, SOLID, DASHED};
    }

    public static EnumEntries<CircleBorderStyle> getEntries() {
        return $ENTRIES;
    }

    private CircleBorderStyle(String str, int i) {
    }

    static {
        CircleBorderStyle[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static CircleBorderStyle valueOf(String str) {
        return (CircleBorderStyle) Enum.valueOf(CircleBorderStyle.class, str);
    }

    public static CircleBorderStyle[] values() {
        return (CircleBorderStyle[]) $VALUES.clone();
    }
}
