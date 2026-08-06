package com.bytedance.trae.network.ttnet;

import com.bytedance.android.jsonopt.JsonOptUtil;
import com.bytedance.article.common.network.SSNetworkClient;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.compression.zstd.Zstd;
import com.bytedance.compression.zstd.ZstdCompress;
import com.bytedance.compression.zstd.ZstdDecompress;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.retrofit2.OptConfig;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.security.api.SecurityService;
import com.bytedance.trae.network.ConnectionTypeListener;
import com.bytedance.trae.network.interceptor.AccountInterceptor;
import com.bytedance.trae.network.interceptor.HttpEnvInterceptor;
import com.bytedance.trae.network.interceptor.IntranetTimeoutInterceptor;
import com.bytedance.trae.network.interceptor.MaxLengthMonitorInterceptor;
import com.bytedance.trae.network.interceptor.MinorModeInterceptor;
import com.bytedance.trae.network.interceptor.TTNetEncryptHeaderInterceptor;
import com.bytedance.trae.network.util.NetworkControlUtils;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.config.JsonOptConfig;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ttnet.org.chromium.net.urlconnection.MessageLoop;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.chromium.CronetAppProviderManager;
import org.chromium.CronetDependManager;

/* compiled from: TTNetExt.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010$\u001a\u00020%2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020%H\u0002J\u0010\u0010(\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u001fJ\b\u0010*\u001a\u0004\u0018\u00010\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b!\u0010\u001b¨\u0006+"}, d2 = {"Lcom/bytedance/trae/network/ttnet/TTNetExt;", "", "<init>", "()V", "TAG", "", "configServersArray", "", "getConfigServersArray", "()[Ljava/lang/String;", "setConfigServersArray", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "serviceDomainMap", "", "getServiceDomainMap", "()Ljava/util/Map;", "setServiceDomainMap", "(Ljava/util/Map;)V", "connectionTypeListeners", "", "Lcom/bytedance/trae/network/ConnectionTypeListener;", "getConnectionTypeListeners", "()Ljava/util/List;", "enableAntiSniffing", "", "getEnableAntiSniffing", "()Z", "setEnableAntiSniffing", "(Z)V", "networkInfo", "Lcom/bytedance/trae/network/ttnet/NetInfo;", "enableBootNetOpt", "getEnableBootNetOpt", "enableBootNetOpt$delegate", "Lkotlin/Lazy;", EventConstants.PARAM_SOURCE_INIT, "", "([Ljava/lang/String;Ljava/util/Map;Z)V", "initZstd", "setUserRegionInfo", "netInfo", "getUserEsimNetworkInfo", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TTNetExt {
    private static NetInfo networkInfo;
    public static final TTNetExt INSTANCE = new TTNetExt();
    private static final String TAG = "TTNetExt";
    private static String[] configServersArray = new String[0];
    private static Map<String, String> serviceDomainMap = MapsKt.emptyMap();
    private static final List<ConnectionTypeListener> connectionTypeListeners = new ArrayList();
    private static boolean enableAntiSniffing = true;

    /* renamed from: enableBootNetOpt$delegate, reason: from kotlin metadata */
    private static final Lazy enableBootNetOpt = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.network.ttnet.TTNetExt$$ExternalSyntheticLambda3
        public final Object invoke() {
            boolean enableBootNetOpt_delegate$lambda$0;
            enableBootNetOpt_delegate$lambda$0 = TTNetExt.enableBootNetOpt_delegate$lambda$0();
            return Boolean.valueOf(enableBootNetOpt_delegate$lambda$0);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enableBootNetOpt_delegate$lambda$0() {
        return false;
    }

    private TTNetExt() {
    }

    public final String[] getConfigServersArray() {
        return configServersArray;
    }

    public final void setConfigServersArray(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        configServersArray = strArr;
    }

    public final Map<String, String> getServiceDomainMap() {
        return serviceDomainMap;
    }

    public final void setServiceDomainMap(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        serviceDomainMap = map;
    }

    public final List<ConnectionTypeListener> getConnectionTypeListeners() {
        return connectionTypeListeners;
    }

    public final boolean getEnableAntiSniffing() {
        return enableAntiSniffing;
    }

    public final void setEnableAntiSniffing(boolean z) {
        enableAntiSniffing = z;
    }

    private final boolean getEnableBootNetOpt() {
        return ((Boolean) enableBootNetOpt.getValue()).booleanValue();
    }

    public final void init(String[] configServersArray2, Map<String, String> serviceDomainMap2, boolean enableAntiSniffing2) {
        Object obj;
        SecurityService securityService;
        Interceptor createBdInterceptor;
        Intrinsics.checkNotNullParameter(configServersArray2, "configServersArray");
        Intrinsics.checkNotNullParameter(serviceDomainMap2, "serviceDomainMap");
        configServersArray = configServersArray2;
        serviceDomainMap = serviceDomainMap2;
        enableAntiSniffing = enableAntiSniffing2;
        try {
            Result.Companion companion = Result.Companion;
            TTNetExt tTNetExt = this;
            CronetDependManager.inst().setAdapter(CronetDependAdapter.INSTANCE);
            CronetAppProviderManager.inst().setAdapter(CronetDependAdapter.INSTANCE);
            TTNetInit.setTTNetDepend(TTNetDependency.INSTANCE);
            if (!AppHost.Companion.isOversea()) {
                StoreRegionManager.useDomesticStoreRegion(true);
            }
            TTNetInit.setCronetDepend(CronetDependAdapter.INSTANCE);
            TTNetInit.setBypassOfflineCheck(true);
            TTNetInit.setStateDelayNewStrategyEnabled(true);
            if (getEnableBootNetOpt()) {
                JsonOptConfig.enableJsonOpt(true);
                JsonOptConfig.enableTNCJsonOpt(true);
                JsonOptConfig.setJsonHandler(new JsonOptConfig.IJsonHandler() { // from class: com.bytedance.trae.network.ttnet.TTNetExt$$ExternalSyntheticLambda0
                    @Override // com.bytedance.ttnet.config.JsonOptConfig.IJsonHandler
                    public final String optString(String str, String[] strArr) {
                        String init$lambda$3$lambda$1;
                        init$lambda$3$lambda$1 = TTNetExt.init$lambda$3$lambda$1(str, strArr);
                        return init$lambda$3$lambda$1;
                    }
                });
                OptConfig.setEnableRequestOpt(true);
            }
            TTNetInit.tryInitTTNet(AppHost.Companion.getApplication(), AppHost.Companion.getApplication(), ApiProcessHook.INSTANCE, MonitorProcessHook.INSTANCE, new NetworkParams.CommandListener() { // from class: com.bytedance.trae.network.ttnet.TTNetExt$init$1$2
                public String getHeaderKey() {
                    return "";
                }

                public void onCommandReceived(List<String> values) {
                    Intrinsics.checkNotNullParameter(values, "values");
                }
            }, true, true);
            TTNetInit.preInitCronetKernel();
            ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.trae.network.ttnet.TTNetExt$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    TTNetExt.this.initZstd();
                }
            });
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Result.exceptionOrNull-impl(obj);
        RetrofitUtils.addInterceptor(new IntranetTimeoutInterceptor());
        RetrofitUtils.addInterceptor(new HttpEnvInterceptor());
        RetrofitUtils.addInterceptor(new AccountInterceptor());
        RetrofitUtils.addInterceptor(new TTNetEncryptHeaderInterceptor());
        RetrofitUtils.addInterceptor(new MinorModeInterceptor());
        RetrofitUtils.addInterceptor(new MaxLengthMonitorInterceptor());
        if (!AppHost.Companion.isOversea() && (securityService = (SecurityService) ServiceManager.get().getService(SecurityService.class)) != null && (createBdInterceptor = securityService.createBdInterceptor()) != null) {
            RetrofitUtils.addInterceptor(createBdInterceptor);
        }
        NetworkClient.setDefault(new SSNetworkClient());
        MessageLoop.disableVaildThreadAssert(true);
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.trae.network.ttnet.TTNetExt$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                TTNetExt.init$lambda$6();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String init$lambda$3$lambda$1(String str, String[] strArr) {
        return JsonOptUtil.optJSONData(strArr, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$6() {
        if (NetworkControlUtils.INSTANCE.getEnableBootNqeOpt() > 0) {
            return;
        }
        NetworkControlUtils.INSTANCE.startSpeedStrategy(ErrorType.BOOT, NetworkControlUtils.INSTANCE.getEnableBootPathOpt(), 60000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initZstd() {
        long[] funAddressesBySymbols = Zstd.getFunAddressesBySymbols(new String[]{"ZSTD_createDCtx", "ZSTD_decompressStream", "ZSTD_freeDCtx", "ZSTD_isError", "ZSTD_createDDict", "ZSTD_DCtx_refDDict", "ZSTD_freeDDict", "ZSTD_DCtx_reset"});
        if (funAddressesBySymbols != null && funAddressesBySymbols.length == 8) {
            long j = funAddressesBySymbols[0];
            if (j != 0) {
                long j2 = funAddressesBySymbols[1];
                if (j2 != 0) {
                    long j3 = funAddressesBySymbols[2];
                    if (j3 != 0) {
                        long j4 = funAddressesBySymbols[3];
                        if (j4 != 0) {
                            long j5 = funAddressesBySymbols[4];
                            if (j5 != 0) {
                                long j6 = funAddressesBySymbols[5];
                                if (j6 != 0) {
                                    long j7 = funAddressesBySymbols[6];
                                    if (j7 != 0) {
                                        long j8 = funAddressesBySymbols[7];
                                        if (j8 != 0) {
                                            try {
                                                TTNetInit.setZstdFuncAddr(j, j2, j3, j4, j5, j6, j7, j8);
                                            } catch (Exception unused) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        TTRequestCompressManager.setAddZstdCompressCallback(new TTRequestCompressManager.AddZstdCompressCallback() { // from class: com.bytedance.trae.network.ttnet.TTNetExt$initZstd$1
            @Override // com.bytedance.retrofit2.mime.TTRequestCompressManager.AddZstdCompressCallback
            public byte[] compress(byte[] src, int level) {
                Intrinsics.checkNotNullParameter(src, "src");
                try {
                    return ZstdCompress.compress(src, level);
                } catch (Exception unused2) {
                    return null;
                }
            }

            @Override // com.bytedance.retrofit2.mime.TTRequestCompressManager.AddZstdCompressCallback
            public byte[] decompress(byte[] src, int originalSize) {
                Intrinsics.checkNotNullParameter(src, "src");
                try {
                    return ZstdDecompress.decompress(src, originalSize);
                } catch (Exception unused2) {
                    return null;
                }
            }
        });
    }

    public final void setUserRegionInfo(NetInfo netInfo) {
        networkInfo = netInfo;
    }

    public final NetInfo getUserEsimNetworkInfo() {
        return networkInfo;
    }
}
