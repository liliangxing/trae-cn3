package com.bytedance.ies.bullet.redirect.api;

import android.net.Uri;
import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAnnieXRedirectProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u000f2\u00020\u0001:\u0003\u000f\u0010\u0011J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/api/IAnnieXRedirectProcessor;", "", "canJumpInCurRoute", "", "uri", "Landroid/net/Uri;", "init", "", "initInfo", "Lcom/bytedance/ies/bullet/redirect/api/IAnnieXRedirectProcessor$RedirectInitInfo;", ReportConsts.RESPONSE_REDIRECT, "schema", "", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/ies/bullet/redirect/api/IAnnieXRedirectProcessor$RedirectCallback;", "Companion", "RedirectCallback", "RedirectInitInfo", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IAnnieXRedirectProcessor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String HOST = "annie_redirect";

    /* compiled from: IAnnieXRedirectProcessor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/api/IAnnieXRedirectProcessor$RedirectCallback;", "", "onFail", "", "code", "", "msg", "", "onSuccess", "finalSchema", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface RedirectCallback {
        void onFail(int code, String msg);

        void onSuccess(String finalSchema);
    }

    boolean canJumpInCurRoute(Uri uri);

    void init(RedirectInitInfo initInfo);

    boolean redirect(String schema, RedirectCallback callback);

    /* compiled from: IAnnieXRedirectProcessor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/api/IAnnieXRedirectProcessor$Companion;", "", "()V", "HOST", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String HOST = "annie_redirect";

        private Companion() {
        }
    }

    /* compiled from: IAnnieXRedirectProcessor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/api/IAnnieXRedirectProcessor$RedirectInitInfo;", "", "appVersion", "", "cdnSourceUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppVersion", "()Ljava/lang/String;", "getCdnSourceUrl", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class RedirectInitInfo {
        private final String appVersion;
        private final String cdnSourceUrl;

        public static /* synthetic */ RedirectInitInfo copy$default(RedirectInitInfo redirectInitInfo, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = redirectInitInfo.appVersion;
            }
            if ((i & 2) != 0) {
                str2 = redirectInitInfo.cdnSourceUrl;
            }
            return redirectInitInfo.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAppVersion() {
            return this.appVersion;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCdnSourceUrl() {
            return this.cdnSourceUrl;
        }

        public final RedirectInitInfo copy(String appVersion, String cdnSourceUrl) {
            return new RedirectInitInfo(appVersion, cdnSourceUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RedirectInitInfo)) {
                return false;
            }
            RedirectInitInfo redirectInitInfo = (RedirectInitInfo) other;
            return Intrinsics.areEqual(this.appVersion, redirectInitInfo.appVersion) && Intrinsics.areEqual(this.cdnSourceUrl, redirectInitInfo.cdnSourceUrl);
        }

        public int hashCode() {
            String str = this.appVersion;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.cdnSourceUrl;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "RedirectInitInfo(appVersion=" + this.appVersion + ", cdnSourceUrl=" + this.cdnSourceUrl + ')';
        }

        public RedirectInitInfo(String str, String str2) {
            this.appVersion = str;
            this.cdnSourceUrl = str2;
        }

        public /* synthetic */ RedirectInitInfo(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }

        public final String getAppVersion() {
            return this.appVersion;
        }

        public final String getCdnSourceUrl() {
            return this.cdnSourceUrl;
        }
    }
}
