package com.bytedance.trae.home.solo.setting.viewmodel;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceManagementViewModel.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect;", "", "CopyToClipboard", "ShowCopySuccessToast", "RefreshDeviceCache", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$CopyToClipboard;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$RefreshDeviceCache;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$ShowCopySuccessToast;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface DeviceManagementEffect {

    /* compiled from: DeviceManagementViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$CopyToClipboard;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class CopyToClipboard implements DeviceManagementEffect {
        public static final int $stable = 0;
        private final String text;

        public static /* synthetic */ CopyToClipboard copy$default(CopyToClipboard copyToClipboard, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = copyToClipboard.text;
            }
            return copyToClipboard.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final CopyToClipboard copy(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new CopyToClipboard(text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CopyToClipboard) && Intrinsics.areEqual(this.text, ((CopyToClipboard) other).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "CopyToClipboard(text=" + this.text + ')';
        }

        public CopyToClipboard(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* compiled from: DeviceManagementViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$ShowCopySuccessToast;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class ShowCopySuccessToast implements DeviceManagementEffect {
        public static final int $stable = 0;
        public static final ShowCopySuccessToast INSTANCE = new ShowCopySuccessToast();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowCopySuccessToast)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 135819830;
        }

        public String toString() {
            return "ShowCopySuccessToast";
        }

        private ShowCopySuccessToast() {
        }
    }

    /* compiled from: DeviceManagementViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$RefreshDeviceCache;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class RefreshDeviceCache implements DeviceManagementEffect {
        public static final int $stable = 0;
        public static final RefreshDeviceCache INSTANCE = new RefreshDeviceCache();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RefreshDeviceCache)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1506000401;
        }

        public String toString() {
            return "RefreshDeviceCache";
        }

        private RefreshDeviceCache() {
        }
    }
}
