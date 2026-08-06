package com.bytedance.trae.home.solo.setting.data;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsCreditsRepository.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState;", "", "Hidden", "Loading", "Visible", "Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Hidden;", "Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Loading;", "Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SettingsCreditsState {

    /* compiled from: SettingsCreditsRepository.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Hidden;", "Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Hidden implements SettingsCreditsState {
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
            return 2025129748;
        }

        public String toString() {
            return "Hidden";
        }

        private Hidden() {
        }
    }

    /* compiled from: SettingsCreditsRepository.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Loading;", "Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Loading implements SettingsCreditsState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Loading)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 2073535762;
        }

        public String toString() {
            return "Loading";
        }

        private Loading() {
        }
    }

    /* compiled from: SettingsCreditsRepository.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;", "Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState;", "balanceText", "", "<init>", "(Ljava/lang/String;)V", "getBalanceText", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Visible implements SettingsCreditsState {
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

        public Visible(String balanceText) {
            Intrinsics.checkNotNullParameter(balanceText, "balanceText");
            this.balanceText = balanceText;
        }

        public final String getBalanceText() {
            return this.balanceText;
        }
    }
}
