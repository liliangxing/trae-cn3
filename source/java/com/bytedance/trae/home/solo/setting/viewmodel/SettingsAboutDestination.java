package com.bytedance.trae.home.solo.setting.viewmodel;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsUiState.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;", "", "WebUrl", "ExternalBrowser", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination$ExternalBrowser;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination$WebUrl;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SettingsAboutDestination {

    /* compiled from: SettingsUiState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination$WebUrl;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class WebUrl implements SettingsAboutDestination {
        public static final int $stable = 0;
        private final String url;

        public static /* synthetic */ WebUrl copy$default(WebUrl webUrl, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = webUrl.url;
            }
            return webUrl.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final WebUrl copy(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new WebUrl(url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WebUrl) && Intrinsics.areEqual(this.url, ((WebUrl) other).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "WebUrl(url=" + this.url + ')';
        }

        public WebUrl(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* compiled from: SettingsUiState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination$ExternalBrowser;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class ExternalBrowser implements SettingsAboutDestination {
        public static final int $stable = 0;
        private final String url;

        public static /* synthetic */ ExternalBrowser copy$default(ExternalBrowser externalBrowser, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = externalBrowser.url;
            }
            return externalBrowser.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final ExternalBrowser copy(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new ExternalBrowser(url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ExternalBrowser) && Intrinsics.areEqual(this.url, ((ExternalBrowser) other).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "ExternalBrowser(url=" + this.url + ')';
        }

        public ExternalBrowser(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public final String getUrl() {
            return this.url;
        }
    }
}
