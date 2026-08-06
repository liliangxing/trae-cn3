package com.bytedance.trae.home.solo.setting;

import com.bytedance.trae.conversation.CreditsBalancePolicy;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: SettingsPointsBalancePresentation.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000 \u00062\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0005¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation;", "", "<init>", "()V", "Hidden", "Visible", "Companion", "Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation$Hidden;", "Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation$Visible;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class SettingsPointsBalancePresentation {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INFINITE_BALANCE_TEXT = "∞";

    public /* synthetic */ SettingsPointsBalancePresentation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: SettingsPointsBalancePresentation.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation$Hidden;", "Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Hidden extends SettingsPointsBalancePresentation {
        public static final int $stable = 0;
        public static final Hidden INSTANCE = new Hidden();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Hidden)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1902403230;
        }

        public String toString() {
            return "Hidden";
        }

        private Hidden() {
            super(null);
        }
    }

    private SettingsPointsBalancePresentation() {
    }

    /* compiled from: SettingsPointsBalancePresentation.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation$Visible;", "Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation;", "balanceText", "", "<init>", "(Ljava/lang/String;)V", "getBalanceText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Visible extends SettingsPointsBalancePresentation {
        public static final int $stable = 0;
        private final String balanceText;

        public static /* synthetic */ Visible copy$default(Visible visible, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = visible.balanceText;
            }
            return visible.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getBalanceText() {
            return this.balanceText;
        }

        public final Visible copy(String balanceText) {
            Intrinsics.checkNotNullParameter(balanceText, "balanceText");
            return new Visible(balanceText);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Visible) && Intrinsics.areEqual(this.balanceText, ((Visible) other).balanceText);
        }

        public int hashCode() {
            return this.balanceText.hashCode();
        }

        public String toString() {
            return "Visible(balanceText=" + this.balanceText + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Visible(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "balanceText");
            this.balanceText = str;
        }

        public final String getBalanceText() {
            return this.balanceText;
        }
    }

    /* compiled from: SettingsPointsBalancePresentation.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\nH\u0002R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation$Companion;", "", "<init>", "()V", "from", "Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation;", "ownerUserId", "", "currentUserId", "remaining", "", "infinite", "", "featureEnabled", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ZZ)Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation;", "formatFiniteBalance", "balance", "INFINITE_BALANCE_TEXT", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ SettingsPointsBalancePresentation from$default(Companion companion, String str, String str2, Long l, boolean z, boolean z2, int i, Object obj) {
            if ((i & 8) != 0) {
                z = false;
            }
            return companion.from(str, str2, l, z, z2);
        }

        public final SettingsPointsBalancePresentation from(String ownerUserId, String currentUserId, Long remaining, boolean infinite, boolean featureEnabled) {
            if ((ownerUserId != null && CreditsBalancePolicy.INSTANCE.belongsToCurrentUser(ownerUserId, currentUserId, featureEnabled)) && remaining != null) {
                return new Visible(infinite ? SettingsPointsBalancePresentation.INFINITE_BALANCE_TEXT : formatFiniteBalance(remaining.longValue()));
            }
            return Hidden.INSTANCE;
        }

        private final String formatFiniteBalance(long balance) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, "%,d", Arrays.copyOf(new Object[]{Long.valueOf(balance)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
    }
}
