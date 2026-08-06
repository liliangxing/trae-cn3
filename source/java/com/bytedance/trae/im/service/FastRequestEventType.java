package com.bytedance.trae.im.service;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: IMEvent.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/im/service/FastRequestEventType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NoQuotaCanUpgrade", "NoQuotaCannotUpgrade", "HasQuotaCanUse", "HasQuotaCannotUse", "AlreadyUsing", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FastRequestEventType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FastRequestEventType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int value;
    public static final FastRequestEventType NoQuotaCanUpgrade = new FastRequestEventType("NoQuotaCanUpgrade", 0, 1);
    public static final FastRequestEventType NoQuotaCannotUpgrade = new FastRequestEventType("NoQuotaCannotUpgrade", 1, 2);
    public static final FastRequestEventType HasQuotaCanUse = new FastRequestEventType("HasQuotaCanUse", 2, 3);
    public static final FastRequestEventType HasQuotaCannotUse = new FastRequestEventType("HasQuotaCannotUse", 3, 4);
    public static final FastRequestEventType AlreadyUsing = new FastRequestEventType("AlreadyUsing", 4, 5);

    private static final /* synthetic */ FastRequestEventType[] $values() {
        return new FastRequestEventType[]{NoQuotaCanUpgrade, NoQuotaCannotUpgrade, HasQuotaCanUse, HasQuotaCannotUse, AlreadyUsing};
    }

    public static EnumEntries<FastRequestEventType> getEntries() {
        return $ENTRIES;
    }

    private FastRequestEventType(String str, int i, int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        FastRequestEventType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: IMEvent.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/im/service/FastRequestEventType$Companion;", "", "<init>", "()V", "fromValue", "Lcom/bytedance/trae/im/service/FastRequestEventType;", "value", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FastRequestEventType fromValue(int value) {
            Object obj;
            Iterator<E> it = FastRequestEventType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((FastRequestEventType) obj).getValue() == value) {
                    break;
                }
            }
            return (FastRequestEventType) obj;
        }
    }

    public static FastRequestEventType valueOf(String str) {
        return (FastRequestEventType) Enum.valueOf(FastRequestEventType.class, str);
    }

    public static FastRequestEventType[] values() {
        return (FastRequestEventType[]) $VALUES.clone();
    }
}
