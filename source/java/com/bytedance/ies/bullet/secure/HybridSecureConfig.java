package com.bytedance.ies.bullet.secure;

import android.content.Context;
import android.view.View;
import com.bytedance.ies.argus.api.interfaces.ArgusInitConfig;
import com.bytedance.ies.bullet.base.depend.INetworkDepend;
import com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HybridSecureConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001>B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u00109\u001a\u00020\u0000H\u0000¢\u0006\u0002\b:J\u0015\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0000H\u0000¢\u0006\u0002\b=R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bRD\u0010\t\u001a,\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nj\u0004\u0018\u0001`\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015RD\u0010\u0016\u001a,\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u0017\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nj\u0004\u0018\u0001`\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001b\u001a\u00020\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006?"}, d2 = {"Lcom/bytedance/ies/bullet/secure/HybridSecureConfig;", "", "()V", "argusInitHostConfig", "Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$HostInitConfig;", "getArgusInitHostConfig$anniex_release", "()Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$HostInitConfig;", "setArgusInitHostConfig$anniex_release", "(Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$HostInitConfig;)V", "createDenyView", "Lkotlin/Function3;", "Landroid/content/Context;", "", "Lkotlin/Function0;", "", "Lcom/bytedance/ies/bullet/service/base/GoBackMethod;", "Landroid/view/View;", "Lcom/bytedance/ies/bullet/secure/CreateDenyViewMethod;", "getCreateDenyView$anniex_release", "()Lkotlin/jvm/functions/Function3;", "setCreateDenyView$anniex_release", "(Lkotlin/jvm/functions/Function3;)V", "createNoticeView", "Lcom/bytedance/ies/bullet/service/base/ReloadMethod;", "Lcom/bytedance/ies/bullet/secure/CreateNoticeViewMethod;", "getCreateNoticeView$anniex_release", "setCreateNoticeView$anniex_release", "enableArgus", "", "getEnableArgus$anniex_release", "()Z", "setEnableArgus$anniex_release", "(Z)V", "networkDepend", "Lcom/bytedance/ies/bullet/base/depend/INetworkDepend;", "getNetworkDepend$anniex_release", "()Lcom/bytedance/ies/bullet/base/depend/INetworkDepend;", "setNetworkDepend$anniex_release", "(Lcom/bytedance/ies/bullet/base/depend/INetworkDepend;)V", "passportDepend", "Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$IPassportDepend;", "getPassportDepend$anniex_release", "()Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$IPassportDepend;", "setPassportDepend$anniex_release", "(Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$IPassportDepend;)V", "permissionConfigProvider", "Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;", "getPermissionConfigProvider$anniex_release", "()Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;", "setPermissionConfigProvider$anniex_release", "(Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;)V", "sccConfig", "Lcom/bytedance/ies/bullet/secure/SccConfig;", "getSccConfig$anniex_release", "()Lcom/bytedance/ies/bullet/secure/SccConfig;", "setSccConfig$anniex_release", "(Lcom/bytedance/ies/bullet/secure/SccConfig;)V", "clone", "clone$anniex_release", "merge", "config", "merge$anniex_release", "Builder", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HybridSecureConfig {
    private ArgusInitConfig.HostInitConfig argusInitHostConfig;
    private Function3<? super Context, ? super String, ? super Function0<Unit>, ? extends View> createDenyView;
    private Function3<? super Context, ? super String, ? super Function0<Unit>, ? extends View> createNoticeView;
    private boolean enableArgus;
    private INetworkDepend networkDepend;
    private ArgusInitConfig.IPassportDepend passportDepend;
    private IPermissionConfigProvider permissionConfigProvider;
    private SccConfig sccConfig;

    public /* synthetic */ HybridSecureConfig(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private HybridSecureConfig() {
    }

    public final Function3<Context, String, Function0<Unit>, View> getCreateDenyView$anniex_release() {
        return this.createDenyView;
    }

    public final void setCreateDenyView$anniex_release(Function3<? super Context, ? super String, ? super Function0<Unit>, ? extends View> function3) {
        this.createDenyView = function3;
    }

    public final Function3<Context, String, Function0<Unit>, View> getCreateNoticeView$anniex_release() {
        return this.createNoticeView;
    }

    public final void setCreateNoticeView$anniex_release(Function3<? super Context, ? super String, ? super Function0<Unit>, ? extends View> function3) {
        this.createNoticeView = function3;
    }

    /* renamed from: getNetworkDepend$anniex_release, reason: from getter */
    public final INetworkDepend getNetworkDepend() {
        return this.networkDepend;
    }

    public final void setNetworkDepend$anniex_release(INetworkDepend iNetworkDepend) {
        this.networkDepend = iNetworkDepend;
    }

    /* renamed from: getSccConfig$anniex_release, reason: from getter */
    public final SccConfig getSccConfig() {
        return this.sccConfig;
    }

    public final void setSccConfig$anniex_release(SccConfig sccConfig) {
        this.sccConfig = sccConfig;
    }

    /* renamed from: getEnableArgus$anniex_release, reason: from getter */
    public final boolean getEnableArgus() {
        return this.enableArgus;
    }

    public final void setEnableArgus$anniex_release(boolean z) {
        this.enableArgus = z;
    }

    /* renamed from: getArgusInitHostConfig$anniex_release, reason: from getter */
    public final ArgusInitConfig.HostInitConfig getArgusInitHostConfig() {
        return this.argusInitHostConfig;
    }

    public final void setArgusInitHostConfig$anniex_release(ArgusInitConfig.HostInitConfig hostInitConfig) {
        this.argusInitHostConfig = hostInitConfig;
    }

    /* renamed from: getPermissionConfigProvider$anniex_release, reason: from getter */
    public final IPermissionConfigProvider getPermissionConfigProvider() {
        return this.permissionConfigProvider;
    }

    public final void setPermissionConfigProvider$anniex_release(IPermissionConfigProvider iPermissionConfigProvider) {
        this.permissionConfigProvider = iPermissionConfigProvider;
    }

    /* renamed from: getPassportDepend$anniex_release, reason: from getter */
    public final ArgusInitConfig.IPassportDepend getPassportDepend() {
        return this.passportDepend;
    }

    public final void setPassportDepend$anniex_release(ArgusInitConfig.IPassportDepend iPassportDepend) {
        this.passportDepend = iPassportDepend;
    }

    public final HybridSecureConfig clone$anniex_release() {
        HybridSecureConfig hybridSecureConfig = new HybridSecureConfig();
        hybridSecureConfig.createDenyView = this.createDenyView;
        hybridSecureConfig.createNoticeView = this.createNoticeView;
        hybridSecureConfig.networkDepend = this.networkDepend;
        SccConfig sccConfig = this.sccConfig;
        hybridSecureConfig.sccConfig = sccConfig != null ? sccConfig.clone$anniex_release() : null;
        return hybridSecureConfig;
    }

    public final HybridSecureConfig merge$anniex_release(HybridSecureConfig config) {
        SccConfig sccConfig;
        Intrinsics.checkNotNullParameter(config, "config");
        Function3<? super Context, ? super String, ? super Function0<Unit>, ? extends View> function3 = config.createDenyView;
        if (function3 != null) {
            this.createDenyView = function3;
        }
        Function3<? super Context, ? super String, ? super Function0<Unit>, ? extends View> function32 = config.createNoticeView;
        if (function32 != null) {
            this.createNoticeView = function32;
        }
        INetworkDepend iNetworkDepend = config.networkDepend;
        if (iNetworkDepend != null) {
            this.networkDepend = iNetworkDepend;
        }
        SccConfig sccConfig2 = config.sccConfig;
        if (sccConfig2 != null && ((sccConfig = this.sccConfig) == null || sccConfig.merge$anniex_release(sccConfig2) == null)) {
            this.sccConfig = sccConfig2;
            Unit unit = Unit.INSTANCE;
        }
        return this;
    }

    /* compiled from: HybridSecureConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J4\u0010\u0006\u001a\u00020\u00002,\u0010\u0006\u001a(\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\f\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u000eJ4\u0010\u000f\u001a\u00020\u00002,\u0010\u000f\u001a(\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\u0010\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ies/bullet/secure/HybridSecureConfig$Builder;", "", "()V", "hybridSecureConfig", "Lcom/bytedance/ies/bullet/secure/HybridSecureConfig;", "build", "createDenyView", "Lkotlin/Function3;", "Landroid/content/Context;", "", "Lkotlin/Function0;", "", "Lcom/bytedance/ies/bullet/service/base/GoBackMethod;", "Landroid/view/View;", "Lcom/bytedance/ies/bullet/secure/CreateDenyViewMethod;", "createNoticeView", "Lcom/bytedance/ies/bullet/service/base/ReloadMethod;", "Lcom/bytedance/ies/bullet/secure/CreateNoticeViewMethod;", "enableArgus", "enable", "", "networkDepend", "Lcom/bytedance/ies/bullet/base/depend/INetworkDepend;", "passportDepend", "depend", "Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$IPassportDepend;", "permissionConfigProvider", "Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;", "sccConfig", "Lcom/bytedance/ies/bullet/secure/SccConfig;", "setArgusInitHostConfig", "argusInitHostConfig", "Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$HostInitConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Builder {
        private final HybridSecureConfig hybridSecureConfig = new HybridSecureConfig(null);

        public final Builder createDenyView(Function3<? super Context, ? super String, ? super Function0<Unit>, ? extends View> createDenyView) {
            Intrinsics.checkNotNullParameter(createDenyView, "createDenyView");
            this.hybridSecureConfig.setCreateDenyView$anniex_release(createDenyView);
            return this;
        }

        public final Builder createNoticeView(Function3<? super Context, ? super String, ? super Function0<Unit>, ? extends View> createNoticeView) {
            Intrinsics.checkNotNullParameter(createNoticeView, "createNoticeView");
            this.hybridSecureConfig.setCreateNoticeView$anniex_release(createNoticeView);
            return this;
        }

        public final Builder networkDepend(INetworkDepend networkDepend) {
            Intrinsics.checkNotNullParameter(networkDepend, "networkDepend");
            this.hybridSecureConfig.setNetworkDepend$anniex_release(networkDepend);
            return this;
        }

        public final Builder sccConfig(SccConfig sccConfig) {
            Intrinsics.checkNotNullParameter(sccConfig, "sccConfig");
            this.hybridSecureConfig.setSccConfig$anniex_release(sccConfig);
            return this;
        }

        public final Builder enableArgus(boolean enable) {
            this.hybridSecureConfig.setEnableArgus$anniex_release(enable);
            return this;
        }

        public final Builder setArgusInitHostConfig(ArgusInitConfig.HostInitConfig argusInitHostConfig) {
            Intrinsics.checkNotNullParameter(argusInitHostConfig, "argusInitHostConfig");
            this.hybridSecureConfig.setArgusInitHostConfig$anniex_release(argusInitHostConfig);
            return this;
        }

        public final Builder permissionConfigProvider(IPermissionConfigProvider permissionConfigProvider) {
            Intrinsics.checkNotNullParameter(permissionConfigProvider, "permissionConfigProvider");
            this.hybridSecureConfig.setPermissionConfigProvider$anniex_release(permissionConfigProvider);
            return this;
        }

        public final Builder passportDepend(ArgusInitConfig.IPassportDepend depend) {
            Intrinsics.checkNotNullParameter(depend, "depend");
            this.hybridSecureConfig.setPassportDepend$anniex_release(depend);
            return this;
        }

        /* renamed from: build, reason: from getter */
        public final HybridSecureConfig getHybridSecureConfig() {
            return this.hybridSecureConfig;
        }
    }
}
