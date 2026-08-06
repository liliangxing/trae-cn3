package com.bytedance.android.live.core.setting.v2.helper;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SettingOptConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/helper/SettingOptConfig;", "", "()V", "isAnnieOPt", "", "isOptV2", "isPreloadOpt", "isTransientMode", "isTypeOpt", "NewOptConfig", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class SettingOptConfig {
    public static final SettingOptConfig INSTANCE = new SettingOptConfig();

    public final boolean isAnnieOPt() {
        return true;
    }

    public final boolean isOptV2() {
        return true;
    }

    public final boolean isPreloadOpt() {
        return true;
    }

    public final boolean isTransientMode() {
        return true;
    }

    public final boolean isTypeOpt() {
        return true;
    }

    private SettingOptConfig() {
    }

    /* compiled from: SettingOptConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\t\"\u0004\b\f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/helper/SettingOptConfig$NewOptConfig;", "", "isTypeOpt", "", "isPreloadOpt", "isCommonOpt", "isTransientMode", "isAnnieOpt", "(ZZZZZ)V", "()Z", "setAnnieOpt", "(Z)V", "setCommonOpt", "setPreloadOpt", "setTransientMode", "setTypeOpt", "live-setting_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public static final class NewOptConfig {
        private boolean isAnnieOpt;
        private boolean isCommonOpt;
        private boolean isPreloadOpt;
        private boolean isTransientMode;
        private boolean isTypeOpt;

        public NewOptConfig() {
            this(false, false, false, false, false, 31, null);
        }

        public NewOptConfig(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
            this.isTypeOpt = z;
            this.isPreloadOpt = z2;
            this.isCommonOpt = z3;
            this.isTransientMode = z4;
            this.isAnnieOpt = z5;
        }

        /* renamed from: isTypeOpt, reason: from getter */
        public final boolean getIsTypeOpt() {
            return this.isTypeOpt;
        }

        public final void setTypeOpt(boolean z) {
            this.isTypeOpt = z;
        }

        /* renamed from: isPreloadOpt, reason: from getter */
        public final boolean getIsPreloadOpt() {
            return this.isPreloadOpt;
        }

        public final void setPreloadOpt(boolean z) {
            this.isPreloadOpt = z;
        }

        /* renamed from: isCommonOpt, reason: from getter */
        public final boolean getIsCommonOpt() {
            return this.isCommonOpt;
        }

        public final void setCommonOpt(boolean z) {
            this.isCommonOpt = z;
        }

        /* renamed from: isTransientMode, reason: from getter */
        public final boolean getIsTransientMode() {
            return this.isTransientMode;
        }

        public final void setTransientMode(boolean z) {
            this.isTransientMode = z;
        }

        public /* synthetic */ NewOptConfig(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? true : z4, (i & 16) != 0 ? true : z5);
        }

        /* renamed from: isAnnieOpt, reason: from getter */
        public final boolean getIsAnnieOpt() {
            return this.isAnnieOpt;
        }

        public final void setAnnieOpt(boolean z) {
            this.isAnnieOpt = z;
        }
    }
}
