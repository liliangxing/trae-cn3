package com.bytedance.ies.argus.bean;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.argus.strategy.provider.client.CSRFProtectConfig;
import com.bytedance.ies.argus.strategy.provider.client.JSBAuthConfig;
import com.bytedance.ies.argus.strategy.provider.client.LoginStateSourceVerifyStrategyConfig;
import com.bytedance.ies.argus.strategy.provider.client.LynxLoadWhiteListConfig;
import com.bytedance.ies.argus.strategy.provider.client.LynxSSRUrlVerifyStrategyConfig;
import com.bytedance.ies.argus.strategy.provider.client.LynxSignVerifyConfig;
import com.bytedance.ies.argus.strategy.provider.client.MotionStrategyConfig;
import com.bytedance.ies.argus.strategy.provider.client.PrefetchStrategyConfig;
import com.bytedance.ies.argus.strategy.provider.client.UploadFileVerifyStrategyConfig;
import com.bytedance.ies.argus.strategy.provider.client.WebLoadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContainerStrategyConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0081\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020<HÖ\u0001R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006="}, d2 = {"Lcom/bytedance/ies/argus/bean/ContainerStrategyConfig;", "", "webUrlListVerify", "Lcom/bytedance/ies/argus/strategy/provider/client/WebLoadConfig;", "jsbCall", "Lcom/bytedance/ies/argus/strategy/provider/client/JSBAuthConfig;", "lynxSignVerify", "Lcom/bytedance/ies/argus/strategy/provider/client/LynxSignVerifyConfig;", "prefetch", "Lcom/bytedance/ies/argus/strategy/provider/client/PrefetchStrategyConfig;", "csrfProtectConfig", "Lcom/bytedance/ies/argus/strategy/provider/client/CSRFProtectConfig;", "lynxLoadWhiteList", "Lcom/bytedance/ies/argus/strategy/provider/client/LynxLoadWhiteListConfig;", "motionVerify", "Lcom/bytedance/ies/argus/strategy/provider/client/MotionStrategyConfig;", "lynxSSRUrlVerify", "Lcom/bytedance/ies/argus/strategy/provider/client/LynxSSRUrlVerifyStrategyConfig;", "uploadFileVerifyStrategyConfig", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyConfig;", "loginStateSourceVerify", "Lcom/bytedance/ies/argus/strategy/provider/client/LoginStateSourceVerifyStrategyConfig;", "(Lcom/bytedance/ies/argus/strategy/provider/client/WebLoadConfig;Lcom/bytedance/ies/argus/strategy/provider/client/JSBAuthConfig;Lcom/bytedance/ies/argus/strategy/provider/client/LynxSignVerifyConfig;Lcom/bytedance/ies/argus/strategy/provider/client/PrefetchStrategyConfig;Lcom/bytedance/ies/argus/strategy/provider/client/CSRFProtectConfig;Lcom/bytedance/ies/argus/strategy/provider/client/LynxLoadWhiteListConfig;Lcom/bytedance/ies/argus/strategy/provider/client/MotionStrategyConfig;Lcom/bytedance/ies/argus/strategy/provider/client/LynxSSRUrlVerifyStrategyConfig;Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyConfig;Lcom/bytedance/ies/argus/strategy/provider/client/LoginStateSourceVerifyStrategyConfig;)V", "getCsrfProtectConfig", "()Lcom/bytedance/ies/argus/strategy/provider/client/CSRFProtectConfig;", "getJsbCall", "()Lcom/bytedance/ies/argus/strategy/provider/client/JSBAuthConfig;", "getLoginStateSourceVerify", "()Lcom/bytedance/ies/argus/strategy/provider/client/LoginStateSourceVerifyStrategyConfig;", "getLynxLoadWhiteList", "()Lcom/bytedance/ies/argus/strategy/provider/client/LynxLoadWhiteListConfig;", "getLynxSSRUrlVerify", "()Lcom/bytedance/ies/argus/strategy/provider/client/LynxSSRUrlVerifyStrategyConfig;", "getLynxSignVerify", "()Lcom/bytedance/ies/argus/strategy/provider/client/LynxSignVerifyConfig;", "getMotionVerify", "()Lcom/bytedance/ies/argus/strategy/provider/client/MotionStrategyConfig;", "getPrefetch", "()Lcom/bytedance/ies/argus/strategy/provider/client/PrefetchStrategyConfig;", "getUploadFileVerifyStrategyConfig", "()Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyConfig;", "getWebUrlListVerify", "()Lcom/bytedance/ies/argus/strategy/provider/client/WebLoadConfig;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class ContainerStrategyConfig {

    @SerializedName(ArgusStrategyName.CSRF_PROTECT)
    private final CSRFProtectConfig csrfProtectConfig;

    @SerializedName(ArgusStrategyName.JSB_AUTH)
    private final JSBAuthConfig jsbCall;

    @SerializedName(ArgusStrategyName.LOGIN_STATE_SOURCE_VERIFY)
    private final LoginStateSourceVerifyStrategyConfig loginStateSourceVerify;

    @SerializedName(ArgusStrategyName.Lynx_LOAD_WHITE_LIST_VERIFY)
    private final LynxLoadWhiteListConfig lynxLoadWhiteList;

    @SerializedName(ArgusStrategyName.LYNX_SSR_URL_VERIFY)
    private final LynxSSRUrlVerifyStrategyConfig lynxSSRUrlVerify;

    @SerializedName(ArgusStrategyName.LYNX_SIGN_VERIFY)
    private final LynxSignVerifyConfig lynxSignVerify;

    @SerializedName(ArgusStrategyName.MOTION_VERIFY)
    private final MotionStrategyConfig motionVerify;

    @SerializedName(ArgusStrategyName.PREFETCH_WHITE_LIST)
    private final PrefetchStrategyConfig prefetch;

    @SerializedName(ArgusStrategyName.UPLOAD_FILE_VERIFY)
    private final UploadFileVerifyStrategyConfig uploadFileVerifyStrategyConfig;

    @SerializedName(ArgusStrategyName.WEB_URL_LIST_VERIFY)
    private final WebLoadConfig webUrlListVerify;

    public ContainerStrategyConfig() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* renamed from: component1, reason: from getter */
    public final WebLoadConfig getWebUrlListVerify() {
        return this.webUrlListVerify;
    }

    /* renamed from: component10, reason: from getter */
    public final LoginStateSourceVerifyStrategyConfig getLoginStateSourceVerify() {
        return this.loginStateSourceVerify;
    }

    /* renamed from: component2, reason: from getter */
    public final JSBAuthConfig getJsbCall() {
        return this.jsbCall;
    }

    /* renamed from: component3, reason: from getter */
    public final LynxSignVerifyConfig getLynxSignVerify() {
        return this.lynxSignVerify;
    }

    /* renamed from: component4, reason: from getter */
    public final PrefetchStrategyConfig getPrefetch() {
        return this.prefetch;
    }

    /* renamed from: component5, reason: from getter */
    public final CSRFProtectConfig getCsrfProtectConfig() {
        return this.csrfProtectConfig;
    }

    /* renamed from: component6, reason: from getter */
    public final LynxLoadWhiteListConfig getLynxLoadWhiteList() {
        return this.lynxLoadWhiteList;
    }

    /* renamed from: component7, reason: from getter */
    public final MotionStrategyConfig getMotionVerify() {
        return this.motionVerify;
    }

    /* renamed from: component8, reason: from getter */
    public final LynxSSRUrlVerifyStrategyConfig getLynxSSRUrlVerify() {
        return this.lynxSSRUrlVerify;
    }

    /* renamed from: component9, reason: from getter */
    public final UploadFileVerifyStrategyConfig getUploadFileVerifyStrategyConfig() {
        return this.uploadFileVerifyStrategyConfig;
    }

    public final ContainerStrategyConfig copy(WebLoadConfig webUrlListVerify, JSBAuthConfig jsbCall, LynxSignVerifyConfig lynxSignVerify, PrefetchStrategyConfig prefetch, CSRFProtectConfig csrfProtectConfig, LynxLoadWhiteListConfig lynxLoadWhiteList, MotionStrategyConfig motionVerify, LynxSSRUrlVerifyStrategyConfig lynxSSRUrlVerify, UploadFileVerifyStrategyConfig uploadFileVerifyStrategyConfig, LoginStateSourceVerifyStrategyConfig loginStateSourceVerify) {
        return new ContainerStrategyConfig(webUrlListVerify, jsbCall, lynxSignVerify, prefetch, csrfProtectConfig, lynxLoadWhiteList, motionVerify, lynxSSRUrlVerify, uploadFileVerifyStrategyConfig, loginStateSourceVerify);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContainerStrategyConfig)) {
            return false;
        }
        ContainerStrategyConfig containerStrategyConfig = (ContainerStrategyConfig) other;
        return Intrinsics.areEqual(this.webUrlListVerify, containerStrategyConfig.webUrlListVerify) && Intrinsics.areEqual(this.jsbCall, containerStrategyConfig.jsbCall) && Intrinsics.areEqual(this.lynxSignVerify, containerStrategyConfig.lynxSignVerify) && Intrinsics.areEqual(this.prefetch, containerStrategyConfig.prefetch) && Intrinsics.areEqual(this.csrfProtectConfig, containerStrategyConfig.csrfProtectConfig) && Intrinsics.areEqual(this.lynxLoadWhiteList, containerStrategyConfig.lynxLoadWhiteList) && Intrinsics.areEqual(this.motionVerify, containerStrategyConfig.motionVerify) && Intrinsics.areEqual(this.lynxSSRUrlVerify, containerStrategyConfig.lynxSSRUrlVerify) && Intrinsics.areEqual(this.uploadFileVerifyStrategyConfig, containerStrategyConfig.uploadFileVerifyStrategyConfig) && Intrinsics.areEqual(this.loginStateSourceVerify, containerStrategyConfig.loginStateSourceVerify);
    }

    public int hashCode() {
        WebLoadConfig webLoadConfig = this.webUrlListVerify;
        int hashCode = (webLoadConfig == null ? 0 : webLoadConfig.hashCode()) * 31;
        JSBAuthConfig jSBAuthConfig = this.jsbCall;
        int hashCode2 = (hashCode + (jSBAuthConfig == null ? 0 : jSBAuthConfig.hashCode())) * 31;
        LynxSignVerifyConfig lynxSignVerifyConfig = this.lynxSignVerify;
        int hashCode3 = (hashCode2 + (lynxSignVerifyConfig == null ? 0 : lynxSignVerifyConfig.hashCode())) * 31;
        PrefetchStrategyConfig prefetchStrategyConfig = this.prefetch;
        int hashCode4 = (hashCode3 + (prefetchStrategyConfig == null ? 0 : prefetchStrategyConfig.hashCode())) * 31;
        CSRFProtectConfig cSRFProtectConfig = this.csrfProtectConfig;
        int hashCode5 = (hashCode4 + (cSRFProtectConfig == null ? 0 : cSRFProtectConfig.hashCode())) * 31;
        LynxLoadWhiteListConfig lynxLoadWhiteListConfig = this.lynxLoadWhiteList;
        int hashCode6 = (hashCode5 + (lynxLoadWhiteListConfig == null ? 0 : lynxLoadWhiteListConfig.hashCode())) * 31;
        MotionStrategyConfig motionStrategyConfig = this.motionVerify;
        int hashCode7 = (hashCode6 + (motionStrategyConfig == null ? 0 : motionStrategyConfig.hashCode())) * 31;
        LynxSSRUrlVerifyStrategyConfig lynxSSRUrlVerifyStrategyConfig = this.lynxSSRUrlVerify;
        int hashCode8 = (hashCode7 + (lynxSSRUrlVerifyStrategyConfig == null ? 0 : lynxSSRUrlVerifyStrategyConfig.hashCode())) * 31;
        UploadFileVerifyStrategyConfig uploadFileVerifyStrategyConfig = this.uploadFileVerifyStrategyConfig;
        int hashCode9 = (hashCode8 + (uploadFileVerifyStrategyConfig == null ? 0 : uploadFileVerifyStrategyConfig.hashCode())) * 31;
        LoginStateSourceVerifyStrategyConfig loginStateSourceVerifyStrategyConfig = this.loginStateSourceVerify;
        return hashCode9 + (loginStateSourceVerifyStrategyConfig != null ? loginStateSourceVerifyStrategyConfig.hashCode() : 0);
    }

    public String toString() {
        return "ContainerStrategyConfig(webUrlListVerify=" + this.webUrlListVerify + ", jsbCall=" + this.jsbCall + ", lynxSignVerify=" + this.lynxSignVerify + ", prefetch=" + this.prefetch + ", csrfProtectConfig=" + this.csrfProtectConfig + ", lynxLoadWhiteList=" + this.lynxLoadWhiteList + ", motionVerify=" + this.motionVerify + ", lynxSSRUrlVerify=" + this.lynxSSRUrlVerify + ", uploadFileVerifyStrategyConfig=" + this.uploadFileVerifyStrategyConfig + ", loginStateSourceVerify=" + this.loginStateSourceVerify + ')';
    }

    public ContainerStrategyConfig(WebLoadConfig webLoadConfig, JSBAuthConfig jSBAuthConfig, LynxSignVerifyConfig lynxSignVerifyConfig, PrefetchStrategyConfig prefetchStrategyConfig, CSRFProtectConfig cSRFProtectConfig, LynxLoadWhiteListConfig lynxLoadWhiteListConfig, MotionStrategyConfig motionStrategyConfig, LynxSSRUrlVerifyStrategyConfig lynxSSRUrlVerifyStrategyConfig, UploadFileVerifyStrategyConfig uploadFileVerifyStrategyConfig, LoginStateSourceVerifyStrategyConfig loginStateSourceVerifyStrategyConfig) {
        this.webUrlListVerify = webLoadConfig;
        this.jsbCall = jSBAuthConfig;
        this.lynxSignVerify = lynxSignVerifyConfig;
        this.prefetch = prefetchStrategyConfig;
        this.csrfProtectConfig = cSRFProtectConfig;
        this.lynxLoadWhiteList = lynxLoadWhiteListConfig;
        this.motionVerify = motionStrategyConfig;
        this.lynxSSRUrlVerify = lynxSSRUrlVerifyStrategyConfig;
        this.uploadFileVerifyStrategyConfig = uploadFileVerifyStrategyConfig;
        this.loginStateSourceVerify = loginStateSourceVerifyStrategyConfig;
    }

    public /* synthetic */ ContainerStrategyConfig(WebLoadConfig webLoadConfig, JSBAuthConfig jSBAuthConfig, LynxSignVerifyConfig lynxSignVerifyConfig, PrefetchStrategyConfig prefetchStrategyConfig, CSRFProtectConfig cSRFProtectConfig, LynxLoadWhiteListConfig lynxLoadWhiteListConfig, MotionStrategyConfig motionStrategyConfig, LynxSSRUrlVerifyStrategyConfig lynxSSRUrlVerifyStrategyConfig, UploadFileVerifyStrategyConfig uploadFileVerifyStrategyConfig, LoginStateSourceVerifyStrategyConfig loginStateSourceVerifyStrategyConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : webLoadConfig, (i & 2) != 0 ? null : jSBAuthConfig, (i & 4) != 0 ? null : lynxSignVerifyConfig, (i & 8) != 0 ? null : prefetchStrategyConfig, (i & 16) != 0 ? null : cSRFProtectConfig, (i & 32) != 0 ? null : lynxLoadWhiteListConfig, (i & 64) != 0 ? null : motionStrategyConfig, (i & 128) != 0 ? null : lynxSSRUrlVerifyStrategyConfig, (i & 256) != 0 ? null : uploadFileVerifyStrategyConfig, (i & 512) == 0 ? loginStateSourceVerifyStrategyConfig : null);
    }

    public final WebLoadConfig getWebUrlListVerify() {
        return this.webUrlListVerify;
    }

    public final JSBAuthConfig getJsbCall() {
        return this.jsbCall;
    }

    public final LynxSignVerifyConfig getLynxSignVerify() {
        return this.lynxSignVerify;
    }

    public final PrefetchStrategyConfig getPrefetch() {
        return this.prefetch;
    }

    public final CSRFProtectConfig getCsrfProtectConfig() {
        return this.csrfProtectConfig;
    }

    public final LynxLoadWhiteListConfig getLynxLoadWhiteList() {
        return this.lynxLoadWhiteList;
    }

    public final MotionStrategyConfig getMotionVerify() {
        return this.motionVerify;
    }

    public final LynxSSRUrlVerifyStrategyConfig getLynxSSRUrlVerify() {
        return this.lynxSSRUrlVerify;
    }

    public final UploadFileVerifyStrategyConfig getUploadFileVerifyStrategyConfig() {
        return this.uploadFileVerifyStrategyConfig;
    }

    public final LoginStateSourceVerifyStrategyConfig getLoginStateSourceVerify() {
        return this.loginStateSourceVerify;
    }
}
