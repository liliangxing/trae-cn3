package com.bytedance.ies.argus.api.interfaces;

import android.app.Application;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.bdturing.localstorage.DbManager;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ArgusInitDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u00042345BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003JY\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00066"}, d2 = {"Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig;", "", "hostConfig", "Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$HostInitConfig;", "permissionConfigProvider", "Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;", "passportDepend", "Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$IPassportDepend;", ReportConst.JSBConfigParam.ENV, "Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$AppEnv;", "application", "Landroid/app/Application;", "uploadSignFailedLynxDepend", "Lcom/bytedance/ies/argus/api/interfaces/IUploadSignFailedLynxDepend;", "lifeCycleDepend", "Lcom/bytedance/ies/argus/api/interfaces/ILifeCycleDepend;", "(Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$HostInitConfig;Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$IPassportDepend;Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$AppEnv;Landroid/app/Application;Lcom/bytedance/ies/argus/api/interfaces/IUploadSignFailedLynxDepend;Lcom/bytedance/ies/argus/api/interfaces/ILifeCycleDepend;)V", "getApplication", "()Landroid/app/Application;", "getEnv", "()Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$AppEnv;", "getHostConfig", "()Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$HostInitConfig;", "initSetting", "Lcom/bytedance/ies/argus/api/interfaces/ArgusInitSetting;", "getInitSetting", "()Lcom/bytedance/ies/argus/api/interfaces/ArgusInitSetting;", "getLifeCycleDepend", "()Lcom/bytedance/ies/argus/api/interfaces/ILifeCycleDepend;", "getPassportDepend", "()Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$IPassportDepend;", "getPermissionConfigProvider", "()Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;", "getUploadSignFailedLynxDepend", "()Lcom/bytedance/ies/argus/api/interfaces/IUploadSignFailedLynxDepend;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "AppEnv", "GeckoEnv", "HostInitConfig", "IPassportDepend", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class ArgusInitConfig {
    private final Application application;
    private final AppEnv env;
    private final HostInitConfig hostConfig;
    private final ILifeCycleDepend lifeCycleDepend;
    private final IPassportDepend passportDepend;
    private final IPermissionConfigProvider permissionConfigProvider;
    private final IUploadSignFailedLynxDepend uploadSignFailedLynxDepend;

    /* compiled from: ArgusInitDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$GeckoEnv;", "", "(Ljava/lang/String;I)V", "PPE", "BOE", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum GeckoEnv {
        PPE,
        BOE
    }

    /* compiled from: ArgusInitDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$IPassportDepend;", "", "getSessionId", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface IPassportDepend {
        String getSessionId();
    }

    public static /* synthetic */ ArgusInitConfig copy$default(ArgusInitConfig argusInitConfig, HostInitConfig hostInitConfig, IPermissionConfigProvider iPermissionConfigProvider, IPassportDepend iPassportDepend, AppEnv appEnv, Application application, IUploadSignFailedLynxDepend iUploadSignFailedLynxDepend, ILifeCycleDepend iLifeCycleDepend, int i, Object obj) {
        if ((i & 1) != 0) {
            hostInitConfig = argusInitConfig.hostConfig;
        }
        if ((i & 2) != 0) {
            iPermissionConfigProvider = argusInitConfig.permissionConfigProvider;
        }
        IPermissionConfigProvider iPermissionConfigProvider2 = iPermissionConfigProvider;
        if ((i & 4) != 0) {
            iPassportDepend = argusInitConfig.passportDepend;
        }
        IPassportDepend iPassportDepend2 = iPassportDepend;
        if ((i & 8) != 0) {
            appEnv = argusInitConfig.env;
        }
        AppEnv appEnv2 = appEnv;
        if ((i & 16) != 0) {
            application = argusInitConfig.application;
        }
        Application application2 = application;
        if ((i & 32) != 0) {
            iUploadSignFailedLynxDepend = argusInitConfig.uploadSignFailedLynxDepend;
        }
        IUploadSignFailedLynxDepend iUploadSignFailedLynxDepend2 = iUploadSignFailedLynxDepend;
        if ((i & 64) != 0) {
            iLifeCycleDepend = argusInitConfig.lifeCycleDepend;
        }
        return argusInitConfig.copy(hostInitConfig, iPermissionConfigProvider2, iPassportDepend2, appEnv2, application2, iUploadSignFailedLynxDepend2, iLifeCycleDepend);
    }

    /* renamed from: component1, reason: from getter */
    public final HostInitConfig getHostConfig() {
        return this.hostConfig;
    }

    /* renamed from: component2, reason: from getter */
    public final IPermissionConfigProvider getPermissionConfigProvider() {
        return this.permissionConfigProvider;
    }

    /* renamed from: component3, reason: from getter */
    public final IPassportDepend getPassportDepend() {
        return this.passportDepend;
    }

    /* renamed from: component4, reason: from getter */
    public final AppEnv getEnv() {
        return this.env;
    }

    /* renamed from: component5, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* renamed from: component6, reason: from getter */
    public final IUploadSignFailedLynxDepend getUploadSignFailedLynxDepend() {
        return this.uploadSignFailedLynxDepend;
    }

    /* renamed from: component7, reason: from getter */
    public final ILifeCycleDepend getLifeCycleDepend() {
        return this.lifeCycleDepend;
    }

    public final ArgusInitConfig copy(HostInitConfig hostConfig, IPermissionConfigProvider permissionConfigProvider, IPassportDepend passportDepend, AppEnv env, Application application, IUploadSignFailedLynxDepend uploadSignFailedLynxDepend, ILifeCycleDepend lifeCycleDepend) {
        Intrinsics.checkNotNullParameter(hostConfig, "hostConfig");
        Intrinsics.checkNotNullParameter(env, ReportConst.JSBConfigParam.ENV);
        return new ArgusInitConfig(hostConfig, permissionConfigProvider, passportDepend, env, application, uploadSignFailedLynxDepend, lifeCycleDepend);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArgusInitConfig)) {
            return false;
        }
        ArgusInitConfig argusInitConfig = (ArgusInitConfig) other;
        return Intrinsics.areEqual(this.hostConfig, argusInitConfig.hostConfig) && Intrinsics.areEqual(this.permissionConfigProvider, argusInitConfig.permissionConfigProvider) && Intrinsics.areEqual(this.passportDepend, argusInitConfig.passportDepend) && Intrinsics.areEqual(this.env, argusInitConfig.env) && Intrinsics.areEqual(this.application, argusInitConfig.application) && Intrinsics.areEqual(this.uploadSignFailedLynxDepend, argusInitConfig.uploadSignFailedLynxDepend) && Intrinsics.areEqual(this.lifeCycleDepend, argusInitConfig.lifeCycleDepend);
    }

    public int hashCode() {
        int hashCode = this.hostConfig.hashCode() * 31;
        IPermissionConfigProvider iPermissionConfigProvider = this.permissionConfigProvider;
        int hashCode2 = (hashCode + (iPermissionConfigProvider == null ? 0 : iPermissionConfigProvider.hashCode())) * 31;
        IPassportDepend iPassportDepend = this.passportDepend;
        int hashCode3 = (((hashCode2 + (iPassportDepend == null ? 0 : iPassportDepend.hashCode())) * 31) + this.env.hashCode()) * 31;
        Application application = this.application;
        int hashCode4 = (hashCode3 + (application == null ? 0 : application.hashCode())) * 31;
        IUploadSignFailedLynxDepend iUploadSignFailedLynxDepend = this.uploadSignFailedLynxDepend;
        int hashCode5 = (hashCode4 + (iUploadSignFailedLynxDepend == null ? 0 : iUploadSignFailedLynxDepend.hashCode())) * 31;
        ILifeCycleDepend iLifeCycleDepend = this.lifeCycleDepend;
        return hashCode5 + (iLifeCycleDepend != null ? iLifeCycleDepend.hashCode() : 0);
    }

    public String toString() {
        return "ArgusInitConfig(hostConfig=" + this.hostConfig + ", permissionConfigProvider=" + this.permissionConfigProvider + ", passportDepend=" + this.passportDepend + ", env=" + this.env + ", application=" + this.application + ", uploadSignFailedLynxDepend=" + this.uploadSignFailedLynxDepend + ", lifeCycleDepend=" + this.lifeCycleDepend + ')';
    }

    public ArgusInitConfig(HostInitConfig hostInitConfig, IPermissionConfigProvider iPermissionConfigProvider, IPassportDepend iPassportDepend, AppEnv appEnv, Application application, IUploadSignFailedLynxDepend iUploadSignFailedLynxDepend, ILifeCycleDepend iLifeCycleDepend) {
        Intrinsics.checkNotNullParameter(hostInitConfig, "hostConfig");
        Intrinsics.checkNotNullParameter(appEnv, ReportConst.JSBConfigParam.ENV);
        this.hostConfig = hostInitConfig;
        this.permissionConfigProvider = iPermissionConfigProvider;
        this.passportDepend = iPassportDepend;
        this.env = appEnv;
        this.application = application;
        this.uploadSignFailedLynxDepend = iUploadSignFailedLynxDepend;
        this.lifeCycleDepend = iLifeCycleDepend;
    }

    public final HostInitConfig getHostConfig() {
        return this.hostConfig;
    }

    public final IPermissionConfigProvider getPermissionConfigProvider() {
        return this.permissionConfigProvider;
    }

    public final IPassportDepend getPassportDepend() {
        return this.passportDepend;
    }

    public final AppEnv getEnv() {
        return this.env;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final IUploadSignFailedLynxDepend getUploadSignFailedLynxDepend() {
        return this.uploadSignFailedLynxDepend;
    }

    public final ILifeCycleDepend getLifeCycleDepend() {
        return this.lifeCycleDepend;
    }

    public final ArgusInitSetting getInitSetting() {
        return this.hostConfig.getSettings();
    }

    /* compiled from: ArgusInitDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$HostInitConfig;", "", DbManager.KEY_SETTINGS, "Lcom/bytedance/ies/argus/api/interfaces/ArgusInitSetting;", "closeLynxVerify", "", "enableTTM", "(Lcom/bytedance/ies/argus/api/interfaces/ArgusInitSetting;ZZ)V", "getCloseLynxVerify", "()Z", "getEnableTTM", "getSettings", "()Lcom/bytedance/ies/argus/api/interfaces/ArgusInitSetting;", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final /* data */ class HostInitConfig {
        private final boolean closeLynxVerify;
        private final boolean enableTTM;
        private final ArgusInitSetting settings;

        public HostInitConfig() {
            this(null, false, false, 7, null);
        }

        public static /* synthetic */ HostInitConfig copy$default(HostInitConfig hostInitConfig, ArgusInitSetting argusInitSetting, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                argusInitSetting = hostInitConfig.settings;
            }
            if ((i & 2) != 0) {
                z = hostInitConfig.closeLynxVerify;
            }
            if ((i & 4) != 0) {
                z2 = hostInitConfig.enableTTM;
            }
            return hostInitConfig.copy(argusInitSetting, z, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final ArgusInitSetting getSettings() {
            return this.settings;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getCloseLynxVerify() {
            return this.closeLynxVerify;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getEnableTTM() {
            return this.enableTTM;
        }

        public final HostInitConfig copy(ArgusInitSetting settings, boolean closeLynxVerify, boolean enableTTM) {
            return new HostInitConfig(settings, closeLynxVerify, enableTTM);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HostInitConfig)) {
                return false;
            }
            HostInitConfig hostInitConfig = (HostInitConfig) other;
            return Intrinsics.areEqual(this.settings, hostInitConfig.settings) && this.closeLynxVerify == hostInitConfig.closeLynxVerify && this.enableTTM == hostInitConfig.enableTTM;
        }

        public int hashCode() {
            ArgusInitSetting argusInitSetting = this.settings;
            return ((((argusInitSetting == null ? 0 : argusInitSetting.hashCode()) * 31) + Boolean.hashCode(this.closeLynxVerify)) * 31) + Boolean.hashCode(this.enableTTM);
        }

        public String toString() {
            return "HostInitConfig(settings=" + this.settings + ", closeLynxVerify=" + this.closeLynxVerify + ", enableTTM=" + this.enableTTM + ')';
        }

        public HostInitConfig(ArgusInitSetting argusInitSetting, boolean z, boolean z2) {
            this.settings = argusInitSetting;
            this.closeLynxVerify = z;
            this.enableTTM = z2;
        }

        public /* synthetic */ HostInitConfig(ArgusInitSetting argusInitSetting, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : argusInitSetting, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2);
        }

        public final ArgusInitSetting getSettings() {
            return this.settings;
        }

        public final boolean getCloseLynxVerify() {
            return this.closeLynxVerify;
        }

        public final boolean getEnableTTM() {
            return this.enableTTM;
        }
    }

    /* compiled from: ArgusInitDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003JC\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0019\u0010!\u001a\u0004\u0018\u00010\u00122\b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0002\u0010#R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006$"}, d2 = {"Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$AppEnv;", "", "appId", "", "appVersion", "did", "channel", "debuggable", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAppId", "()Ljava/lang/String;", "getAppVersion", "getChannel", "getDebuggable", "()Z", "getDid", "versionCode", "", "getVersionCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "version2int", "versionStr", "(Ljava/lang/String;)Ljava/lang/Long;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final /* data */ class AppEnv {
        private final String appId;
        private final String appVersion;
        private final String channel;
        private final boolean debuggable;
        private final String did;
        private final Long versionCode;

        public AppEnv() {
            this(null, null, null, null, false, 31, null);
        }

        public static /* synthetic */ AppEnv copy$default(AppEnv appEnv, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = appEnv.appId;
            }
            if ((i & 2) != 0) {
                str2 = appEnv.appVersion;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                str3 = appEnv.did;
            }
            String str6 = str3;
            if ((i & 8) != 0) {
                str4 = appEnv.channel;
            }
            String str7 = str4;
            if ((i & 16) != 0) {
                z = appEnv.debuggable;
            }
            return appEnv.copy(str, str5, str6, str7, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAppId() {
            return this.appId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getAppVersion() {
            return this.appVersion;
        }

        /* renamed from: component3, reason: from getter */
        public final String getDid() {
            return this.did;
        }

        /* renamed from: component4, reason: from getter */
        public final String getChannel() {
            return this.channel;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getDebuggable() {
            return this.debuggable;
        }

        public final AppEnv copy(String appId, String appVersion, String did, String channel, boolean debuggable) {
            return new AppEnv(appId, appVersion, did, channel, debuggable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AppEnv)) {
                return false;
            }
            AppEnv appEnv = (AppEnv) other;
            return Intrinsics.areEqual(this.appId, appEnv.appId) && Intrinsics.areEqual(this.appVersion, appEnv.appVersion) && Intrinsics.areEqual(this.did, appEnv.did) && Intrinsics.areEqual(this.channel, appEnv.channel) && this.debuggable == appEnv.debuggable;
        }

        public int hashCode() {
            String str = this.appId;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.appVersion;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.did;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.channel;
            return ((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + Boolean.hashCode(this.debuggable);
        }

        public String toString() {
            return "AppEnv(appId=" + this.appId + ", appVersion=" + this.appVersion + ", did=" + this.did + ", channel=" + this.channel + ", debuggable=" + this.debuggable + ')';
        }

        public AppEnv(String str, String str2, String str3, String str4, boolean z) {
            this.appId = str;
            this.appVersion = str2;
            this.did = str3;
            this.channel = str4;
            this.debuggable = z;
            this.versionCode = version2int(str2);
        }

        public /* synthetic */ AppEnv(String str, String str2, String str3, String str4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) == 0 ? str4 : null, (i & 16) != 0 ? false : z);
        }

        public final String getAppId() {
            return this.appId;
        }

        public final String getAppVersion() {
            return this.appVersion;
        }

        public final String getDid() {
            return this.did;
        }

        public final String getChannel() {
            return this.channel;
        }

        public final boolean getDebuggable() {
            return this.debuggable;
        }

        public final Long getVersionCode() {
            return this.versionCode;
        }

        private static final String version2int$convertNumber(String str) {
            return str.length() == 1 ? "0" + str : str;
        }

        private final Long version2int(String versionStr) {
            if (versionStr == null) {
                return null;
            }
            List split$default = StringsKt.split$default(versionStr, new String[]{"."}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                arrayList.add(version2int$convertNumber((String) it.next()));
            }
            return Long.valueOf(Long.parseLong(CollectionsKt.joinToString$default(arrayList, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)));
        }
    }
}
