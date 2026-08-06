package com.bytedance.trae.home.solo.setting;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: UserPayStatusApi.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;", "", "value", "", "displayText", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getValue", "()I", "getDisplayText", "()Ljava/lang/String;", "FREE", "PRO", "PRO_PLUS", "ULTRA", "TRIAL", "LITE", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserPayIdentity {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UserPayIdentity[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String displayText;
    private final int value;
    public static final UserPayIdentity FREE = new UserPayIdentity("FREE", 0, 0, "Free");
    public static final UserPayIdentity PRO = new UserPayIdentity("PRO", 1, 1, "Pro");
    public static final UserPayIdentity PRO_PLUS = new UserPayIdentity("PRO_PLUS", 2, 2, "Pro+");
    public static final UserPayIdentity ULTRA = new UserPayIdentity("ULTRA", 3, 3, "Ultra");
    public static final UserPayIdentity TRIAL = new UserPayIdentity("TRIAL", 4, 4, "Pro");
    public static final UserPayIdentity LITE = new UserPayIdentity("LITE", 5, 5, "Lite");

    private static final /* synthetic */ UserPayIdentity[] $values() {
        return new UserPayIdentity[]{FREE, PRO, PRO_PLUS, ULTRA, TRIAL, LITE};
    }

    public static EnumEntries<UserPayIdentity> getEntries() {
        return $ENTRIES;
    }

    private UserPayIdentity(String str, int i, int i2, String str2) {
        this.value = i2;
        this.displayText = str2;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        UserPayIdentity[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: UserPayStatusApi.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/UserPayIdentity$Companion;", "", "<init>", "()V", "fromValue", "Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;", "value", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UserPayIdentity fromValue(int value) {
            Object obj;
            Iterator<E> it = UserPayIdentity.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((UserPayIdentity) obj).getValue() == value) {
                    break;
                }
            }
            UserPayIdentity userPayIdentity = (UserPayIdentity) obj;
            return userPayIdentity == null ? UserPayIdentity.FREE : userPayIdentity;
        }
    }

    public static UserPayIdentity valueOf(String str) {
        return (UserPayIdentity) Enum.valueOf(UserPayIdentity.class, str);
    }

    public static UserPayIdentity[] values() {
        return (UserPayIdentity[]) $VALUES.clone();
    }
}
