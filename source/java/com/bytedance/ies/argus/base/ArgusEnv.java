package com.bytedance.ies.argus.base;

import android.app.Application;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.applog.server.Api;
import com.bytedance.ies.argus.api.interfaces.ArgusInitConfig;
import com.bytedance.ies.argus.api.interfaces.ArgusInitSetting;
import com.bytedance.ies.argus.api.interfaces.ILifeCycleDepend;
import com.bytedance.ies.argus.api.interfaces.IUploadSignFailedLynxDepend;
import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.strategy.ITTMDataHandler;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: ArgusEnv.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 -2\u00020\u0001:\u0002,-B\u0005¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001f\u0010\"\u001a\u00060#R\u00020\u00008@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u0013\u0010(\u001a\u0004\u0018\u00010)8F¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/bytedance/ies/argus/base/ArgusEnv;", "", "()V", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "enableTTM", "", "getEnableTTM", "()Z", ReportConst.JSBConfigParam.ENV, "Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$AppEnv;", "getEnv", "()Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig$AppEnv;", "<set-?>", "Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig;", "initConfig", "getInitConfig", "()Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig;", "setInitConfig$anniex_release", "(Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig;)V", "initSetting", "Lcom/bytedance/ies/argus/api/interfaces/ArgusInitSetting;", "getInitSetting", "()Lcom/bytedance/ies/argus/api/interfaces/ArgusInitSetting;", "lifeCycleDepend", "Lcom/bytedance/ies/argus/api/interfaces/ILifeCycleDepend;", "getLifeCycleDepend", "()Lcom/bytedance/ies/argus/api/interfaces/ILifeCycleDepend;", "sharedScope", "Lkotlinx/coroutines/CoroutineScope;", "getSharedScope", "()Lkotlinx/coroutines/CoroutineScope;", "ttmParam", "Lcom/bytedance/ies/argus/base/ArgusEnv$ArgusEnvTTMParam;", "getTtmParam$anniex_release", "()Lcom/bytedance/ies/argus/base/ArgusEnv$ArgusEnvTTMParam;", "ttmParam$delegate", "Lkotlin/Lazy;", "uploadSignFailedLynxDepend", "Lcom/bytedance/ies/argus/api/interfaces/IUploadSignFailedLynxDepend;", "getUploadSignFailedLynxDepend", "()Lcom/bytedance/ies/argus/api/interfaces/IUploadSignFailedLynxDepend;", "ArgusEnvTTMParam", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusEnv {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<ArgusEnv> instance$delegate = LazyKt.lazy(new Function0<ArgusEnv>() { // from class: com.bytedance.ies.argus.base.ArgusEnv$Companion$instance$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ArgusEnv m599invoke() {
            return new ArgusEnv();
        }
    });
    private ArgusInitConfig initConfig;

    /* renamed from: ttmParam$delegate, reason: from kotlin metadata */
    private final Lazy ttmParam = LazyKt.lazy(new Function0<ArgusEnvTTMParam>() { // from class: com.bytedance.ies.argus.base.ArgusEnv$ttmParam$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ArgusEnv.ArgusEnvTTMParam m600invoke() {
            return new ArgusEnv.ArgusEnvTTMParam();
        }
    });
    private final CoroutineScope sharedScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());

    /* compiled from: ArgusEnv.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/base/ArgusEnv$Companion;", "", "()V", "instance", "Lcom/bytedance/ies/argus/base/ArgusEnv;", "getInstance", "()Lcom/bytedance/ies/argus/base/ArgusEnv;", "instance$delegate", "Lkotlin/Lazy;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArgusEnv getInstance() {
            return (ArgusEnv) ArgusEnv.instance$delegate.getValue();
        }
    }

    public final ArgusInitConfig getInitConfig() {
        return this.initConfig;
    }

    public final void setInitConfig$anniex_release(ArgusInitConfig argusInitConfig) {
        this.initConfig = argusInitConfig;
    }

    public final ArgusInitSetting getInitSetting() {
        ArgusInitConfig.HostInitConfig hostConfig;
        ArgusInitSetting settings;
        ArgusInitConfig argusInitConfig = this.initConfig;
        return (argusInitConfig == null || (hostConfig = argusInitConfig.getHostConfig()) == null || (settings = hostConfig.getSettings()) == null) ? new ArgusInitSetting(0L, 0, 0L, 7, null) : settings;
    }

    public final boolean getEnableTTM() {
        ArgusInitConfig.HostInitConfig hostConfig;
        ArgusInitConfig argusInitConfig = this.initConfig;
        if (argusInitConfig == null || (hostConfig = argusInitConfig.getHostConfig()) == null) {
            return false;
        }
        return hostConfig.getEnableTTM();
    }

    public final ArgusEnvTTMParam getTtmParam$anniex_release() {
        return (ArgusEnvTTMParam) this.ttmParam.getValue();
    }

    public final ArgusInitConfig.AppEnv getEnv() {
        ArgusInitConfig argusInitConfig = this.initConfig;
        if (argusInitConfig != null) {
            return argusInitConfig.getEnv();
        }
        return null;
    }

    public final Application getApplication() {
        ArgusInitConfig argusInitConfig = this.initConfig;
        if (argusInitConfig != null) {
            return argusInitConfig.getApplication();
        }
        return null;
    }

    public final IUploadSignFailedLynxDepend getUploadSignFailedLynxDepend() {
        ArgusInitConfig argusInitConfig = this.initConfig;
        if (argusInitConfig != null) {
            return argusInitConfig.getUploadSignFailedLynxDepend();
        }
        return null;
    }

    public final ILifeCycleDepend getLifeCycleDepend() {
        ArgusInitConfig argusInitConfig = this.initConfig;
        if (argusInitConfig != null) {
            return argusInitConfig.getLifeCycleDepend();
        }
        return null;
    }

    public final CoroutineScope getSharedScope() {
        return this.sharedScope;
    }

    /* compiled from: ArgusEnv.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/argus/base/ArgusEnv$ArgusEnvTTMParam;", "Lcom/bytedance/ies/argus/strategy/ITTMDataHandler;", "(Lcom/bytedance/ies/argus/base/ArgusEnv;)V", "getValue", "", Api.KEY_ENCRYPT_RESP_KEY, "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final class ArgusEnvTTMParam implements ITTMDataHandler {
        public ArgusEnvTTMParam() {
        }

        @Override // com.bytedance.ies.argus.strategy.ITTMDataHandler
        public boolean setValue(String str, Object obj) {
            return ITTMDataHandler.DefaultImpls.setValue(this, str, obj);
        }

        @Override // com.bytedance.ies.argus.strategy.ITTMDataHandler
        public Object getValue(String key) {
            Long versionCode;
            Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
            ArgusInitConfig.AppEnv env = ArgusEnv.this.getEnv();
            if (Intrinsics.areEqual(key, "version_code")) {
                return Long.valueOf((env == null || (versionCode = env.getVersionCode()) == null) ? 0L : versionCode.longValue());
            }
            if (!Intrinsics.areEqual(key, "channel") || env == null) {
                return null;
            }
            return env.getChannel();
        }
    }
}
