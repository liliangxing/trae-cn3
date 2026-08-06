package com.bytedance.trae.im.service.tenant;

import android.os.SystemClock;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.reflect.TypeToken;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: TenantUserConfigRepository.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0019J\u0016\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0005J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050!2\b\b\u0002\u0010\u001d\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u001eJ\u001a\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010\u001d\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u001eJ\u0018\u0010$\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u001eJ\u0006\u0010%\u001a\u00020\u0019J\u0006\u0010&\u001a\u00020\u0011J\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050!J \u0010(\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050!J\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0!J\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050!J\u0006\u0010.\u001a\u00020\u0013J\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000!J0\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00052\u000e\b\u0002\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050!2\b\b\u0002\u00105\u001a\u00020\u0005J\u000e\u00106\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u0005J(\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u00109\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010:J \u0010;\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0007H\u0002J\u001a\u0010=\u001a\u0004\u0018\u00010\u00112\u0006\u0010>\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u0007H\u0002J\b\u0010?\u001a\u00020\u0007H\u0002J\b\u0010@\u001a\u00020\u0007H\u0002J\b\u0010A\u001a\u00020\u0013H\u0002J\b\u0010B\u001a\u00020\u0013H\u0002J\f\u0010C\u001a\u00020\u0005*\u000200H\u0002J\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00110E2\u0006\u0010\u001d\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u001eJ \u0010F\u001a\b\u0012\u0004\u0012\u00020\u00110E2\u0010\u0010G\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010HH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;", "", "<init>", "()V", "TAG", "", "CACHE_TTL_MS", "", "EMPTY_REQUEST", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "refreshMutex", "Lkotlinx/coroutines/sync/Mutex;", "cacheStateLock", "accountConfigGeneration", "cachedConfig", "Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;", "hasSuccessfulConfig", "", "lastRefreshElapsedMs", "pollingJob", "Lkotlinx/coroutines/Job;", "asyncRefreshJob", "onAccountChanged", "", "startPolling", "stopPolling", "ensureFresh", TimonPipeline.KEY_SOURCE, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "triggerRefreshIfNeeded", "ensureEnterpriseBlacklistCommandsFresh", "", "ensureMcpWhitelistFresh", "Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;", "refreshMcpWhitelist", "clearCache", "getCachedConfig", "getBlacklistRepoUrlsCached", "isWorkspaceAIEnabled", "workspaceDir", "gitUrls", "getSecurityRulesCached", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;", "getEnterpriseBlacklistCommandsCached", "isMcpWhitelistEnabled", "getMcpWhitelists", "Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;", "isAllowedByStdioConfig", DBData.FIELD_TYPE, "command", "args", IWeixinService.ResponseConstants.URL, "isAllowedByHttpConfig", "refresh", "force", "generation", "(ZLjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markRefreshAttempt", "reason", "saveConfigIfCurrent", "data", "clearCacheAndBumpGeneration", "currentGeneration", "isCacheValid", "isEnterpriseLogin", "resolvedType", "fetchTenantUserConfig", "Lcom/bytedance/trae/network/response/HttpDataResult;", "parseTenantUserConfigResponse", "response", "Lcom/bytedance/retrofit2/SsResponse;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TenantUserConfigRepository {
    private static final long CACHE_TTL_MS = 600000;
    private static final String TAG = "TenantUserConfig";
    private static volatile long accountConfigGeneration;
    private static volatile Job asyncRefreshJob;
    private static volatile boolean hasSuccessfulConfig;
    private static volatile long lastRefreshElapsedMs;
    private static volatile Job pollingJob;
    public static final TenantUserConfigRepository INSTANCE = new TenantUserConfigRepository();
    private static final Map<String, Object> EMPTY_REQUEST = MapsKt.emptyMap();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()).plus((CoroutineExceptionHandler) new C0867x1908fe91(CoroutineExceptionHandler.Key)));
    private static final Mutex refreshMutex = MutexKt.Mutex$default(false, 1, (Object) null);
    private static final Object cacheStateLock = new Object();
    private static volatile TenantUserConfigResponse cachedConfig = TenantUserConfigResponse.INSTANCE.getEMPTY();

    private TenantUserConfigRepository() {
    }

    public final void onAccountChanged() {
        long clearCacheAndBumpGeneration = clearCacheAndBumpGeneration();
        if (isEnterpriseLogin()) {
            startPolling();
            BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new TenantUserConfigRepository$onAccountChanged$1(clearCacheAndBumpGeneration, null), 3, (Object) null);
        } else {
            stopPolling();
        }
    }

    public final void startPolling() {
        if (!isEnterpriseLogin()) {
            stopPolling();
            return;
        }
        Job job = pollingJob;
        boolean z = false;
        if (job != null && job.isActive()) {
            z = true;
        }
        if (z) {
            return;
        }
        pollingJob = BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new TenantUserConfigRepository$startPolling$1(null), 3, (Object) null);
    }

    public final void stopPolling() {
        Job job = pollingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        pollingJob = null;
    }

    public final Object ensureFresh(String str, Continuation<? super TenantUserConfigResponse> continuation) {
        return !isEnterpriseLogin() ? TenantUserConfigResponse.INSTANCE.getEMPTY() : isCacheValid() ? cachedConfig : refresh$default(this, false, str, 0L, continuation, 4, null);
    }

    public final TenantUserConfigResponse triggerRefreshIfNeeded(String source) {
        Intrinsics.checkNotNullParameter(source, TimonPipeline.KEY_SOURCE);
        if (!isEnterpriseLogin()) {
            return TenantUserConfigResponse.INSTANCE.getEMPTY();
        }
        if (isCacheValid()) {
            return cachedConfig;
        }
        Job job = asyncRefreshJob;
        boolean z = false;
        if (job != null && job.isActive()) {
            z = true;
        }
        if (!z) {
            asyncRefreshJob = BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new TenantUserConfigRepository$triggerRefreshIfNeeded$1(source, currentGeneration(), null), 3, (Object) null);
        }
        return cachedConfig;
    }

    public static /* synthetic */ Object ensureEnterpriseBlacklistCommandsFresh$default(TenantUserConfigRepository tenantUserConfigRepository, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "command_blacklist";
        }
        return tenantUserConfigRepository.ensureEnterpriseBlacklistCommandsFresh(str, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object ensureEnterpriseBlacklistCommandsFresh(String str, Continuation<? super List<String>> continuation) {
        C0868x4120e458 c0868x4120e458;
        int i;
        if (continuation instanceof C0868x4120e458) {
            c0868x4120e458 = (C0868x4120e458) continuation;
            if ((c0868x4120e458.label & Integer.MIN_VALUE) != 0) {
                c0868x4120e458.label -= Integer.MIN_VALUE;
                Object obj = c0868x4120e458.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c0868x4120e458.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    c0868x4120e458.label = 1;
                    obj = ensureFresh(str, c0868x4120e458);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((TenantUserConfigResponse) obj).getConfigInfo().getBlacklistCommands();
            }
        }
        c0868x4120e458 = new C0868x4120e458(this, continuation);
        Object obj2 = c0868x4120e458.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = c0868x4120e458.label;
        if (i != 0) {
        }
        return ((TenantUserConfigResponse) obj2).getConfigInfo().getBlacklistCommands();
    }

    public static /* synthetic */ Object ensureMcpWhitelistFresh$default(TenantUserConfigRepository tenantUserConfigRepository, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "mcp_whitelist";
        }
        return tenantUserConfigRepository.ensureMcpWhitelistFresh(str, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object ensureMcpWhitelistFresh(String str, Continuation<? super McpWhitelistConfigInfo> continuation) {
        TenantUserConfigRepository$ensureMcpWhitelistFresh$1 tenantUserConfigRepository$ensureMcpWhitelistFresh$1;
        int i;
        if (continuation instanceof TenantUserConfigRepository$ensureMcpWhitelistFresh$1) {
            tenantUserConfigRepository$ensureMcpWhitelistFresh$1 = (TenantUserConfigRepository$ensureMcpWhitelistFresh$1) continuation;
            if ((tenantUserConfigRepository$ensureMcpWhitelistFresh$1.label & Integer.MIN_VALUE) != 0) {
                tenantUserConfigRepository$ensureMcpWhitelistFresh$1.label -= Integer.MIN_VALUE;
                TenantUserConfigRepository$ensureMcpWhitelistFresh$1 tenantUserConfigRepository$ensureMcpWhitelistFresh$12 = tenantUserConfigRepository$ensureMcpWhitelistFresh$1;
                Object obj = tenantUserConfigRepository$ensureMcpWhitelistFresh$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = tenantUserConfigRepository$ensureMcpWhitelistFresh$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    tenantUserConfigRepository$ensureMcpWhitelistFresh$12.label = 1;
                    obj = refresh$default(this, true, str, 0L, tenantUserConfigRepository$ensureMcpWhitelistFresh$12, 4, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((TenantUserConfigResponse) obj).getMcpWhitelistConfig();
            }
        }
        tenantUserConfigRepository$ensureMcpWhitelistFresh$1 = new TenantUserConfigRepository$ensureMcpWhitelistFresh$1(this, continuation);
        TenantUserConfigRepository$ensureMcpWhitelistFresh$1 tenantUserConfigRepository$ensureMcpWhitelistFresh$122 = tenantUserConfigRepository$ensureMcpWhitelistFresh$1;
        Object obj2 = tenantUserConfigRepository$ensureMcpWhitelistFresh$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tenantUserConfigRepository$ensureMcpWhitelistFresh$122.label;
        if (i != 0) {
        }
        return ((TenantUserConfigResponse) obj2).getMcpWhitelistConfig();
    }

    public static /* synthetic */ Object refreshMcpWhitelist$default(TenantUserConfigRepository tenantUserConfigRepository, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "mcp_whitelist";
        }
        return tenantUserConfigRepository.refreshMcpWhitelist(str, continuation);
    }

    public final Object refreshMcpWhitelist(String str, Continuation<? super TenantUserConfigResponse> continuation) {
        return refresh$default(this, true, str, 0L, continuation, 4, null);
    }

    public final void clearCache() {
        clearCacheAndBumpGeneration();
    }

    public final TenantUserConfigResponse getCachedConfig() {
        return cachedConfig;
    }

    public final List<String> getBlacklistRepoUrlsCached() {
        List<TenantUserConfigBlacklistRepo> blacklistRepos = cachedConfig.getConfigInfo().getBlacklistRepos();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = blacklistRepos.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((TenantUserConfigBlacklistRepo) it.next()).getRepoUrls());
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean isWorkspaceAIEnabled$default(TenantUserConfigRepository tenantUserConfigRepository, String str, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        return tenantUserConfigRepository.isWorkspaceAIEnabled(str, list);
    }

    public final boolean isWorkspaceAIEnabled(String workspaceDir, List<String> gitUrls) {
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(gitUrls, "gitUrls");
        List<String> blacklistRepoUrlsCached = getBlacklistRepoUrlsCached();
        if (blacklistRepoUrlsCached.isEmpty()) {
            return true;
        }
        List<String> list = gitUrls;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (String str : list) {
                List<String> list2 = blacklistRepoUrlsCached;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    for (String str2 : list2) {
                        String str3 = str;
                        if (StringsKt.contains$default(str3, str2, false, 2, (Object) null) || StringsKt.contains$default(str2, str3, false, 2, (Object) null)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        if (z2) {
            return false;
        }
        if (workspaceDir == null) {
            workspaceDir = "";
        }
        String str4 = workspaceDir;
        if (StringsKt.isBlank(str4)) {
            return true;
        }
        List<String> list3 = blacklistRepoUrlsCached;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                if (StringsKt.contains$default(str4, (String) it.next(), false, 2, (Object) null)) {
                    z3 = false;
                    break;
                }
            }
        }
        z3 = true;
        return z3;
    }

    public final List<ContentSecurityRule> getSecurityRulesCached() {
        return cachedConfig.getSecurityRules();
    }

    public final List<String> getEnterpriseBlacklistCommandsCached() {
        return cachedConfig.getConfigInfo().getBlacklistCommands();
    }

    public final boolean isMcpWhitelistEnabled() {
        McpWhitelistConfigInfo mcpWhitelistConfig = cachedConfig.getMcpWhitelistConfig();
        return mcpWhitelistConfig != null && mcpWhitelistConfig.getGlobalEnable();
    }

    public final List<McpWhitelistItem> getMcpWhitelists() {
        McpWhitelistConfigInfo mcpWhitelistConfig = cachedConfig.getMcpWhitelistConfig();
        List<McpWhitelistItem> whitelists = mcpWhitelistConfig != null ? mcpWhitelistConfig.getWhitelists() : null;
        if (whitelists == null) {
            whitelists = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : whitelists) {
            if (((McpWhitelistItem) obj).getEnable()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean isAllowedByStdioConfig$default(TenantUserConfigRepository tenantUserConfigRepository, String str, String str2, List list, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 8) != 0) {
            str3 = "";
        }
        return tenantUserConfigRepository.isAllowedByStdioConfig(str, str2, list, str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0099 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[LOOP:0: B:20:0x004f->B:43:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isAllowedByStdioConfig(String type, String command, List<String> args, String url) {
        boolean z;
        Intrinsics.checkNotNullParameter(type, DBData.FIELD_TYPE);
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
        if (!isMcpWhitelistEnabled()) {
            return true;
        }
        McpWhitelistConfigInfo mcpWhitelistConfig = cachedConfig.getMcpWhitelistConfig();
        List<McpWhitelistItem> whitelists = mcpWhitelistConfig != null ? mcpWhitelistConfig.getWhitelists() : null;
        if (whitelists == null) {
            whitelists = CollectionsKt.emptyList();
        }
        if (whitelists.isEmpty()) {
            return false;
        }
        List<McpWhitelistItem> list = whitelists;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (McpWhitelistItem mcpWhitelistItem : list) {
                if (mcpWhitelistItem.getEnable() && Intrinsics.areEqual(INSTANCE.resolvedType(mcpWhitelistItem), type)) {
                    String command2 = mcpWhitelistItem.getCommand();
                    if (command2 == null) {
                        command2 = "";
                    }
                    if (Intrinsics.areEqual(command2, command) && Intrinsics.areEqual(mcpWhitelistItem.getArg(), args)) {
                        String url2 = mcpWhitelistItem.getUrl();
                        if (Intrinsics.areEqual(url2 != null ? url2 : "", url)) {
                            z = true;
                            if (!z) {
                                return true;
                            }
                        }
                    }
                }
                z = false;
                if (!z) {
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[LOOP:0: B:20:0x003f->B:36:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isAllowedByHttpConfig(String url) {
        boolean z;
        Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
        if (!isMcpWhitelistEnabled()) {
            return true;
        }
        McpWhitelistConfigInfo mcpWhitelistConfig = cachedConfig.getMcpWhitelistConfig();
        List<McpWhitelistItem> whitelists = mcpWhitelistConfig != null ? mcpWhitelistConfig.getWhitelists() : null;
        if (whitelists == null) {
            whitelists = CollectionsKt.emptyList();
        }
        if (whitelists.isEmpty()) {
            return false;
        }
        List<McpWhitelistItem> list = whitelists;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (McpWhitelistItem mcpWhitelistItem : list) {
                if (mcpWhitelistItem.getEnable() && Intrinsics.areEqual(INSTANCE.resolvedType(mcpWhitelistItem), "http")) {
                    String url2 = mcpWhitelistItem.getUrl();
                    if (url2 == null) {
                        url2 = "";
                    }
                    if (Intrinsics.areEqual(url2, url)) {
                        z = true;
                        if (!z) {
                            return true;
                        }
                    }
                }
                z = false;
                if (!z) {
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c7 A[Catch: all -> 0x0047, TryCatch #0 {all -> 0x0047, blocks: (B:12:0x0042, B:13:0x00c1, B:15:0x00c7, B:17:0x00cf, B:20:0x00d9, B:22:0x00e6, B:24:0x00f7, B:26:0x00fd, B:31:0x0105, B:33:0x015c, B:35:0x0162, B:36:0x0168, B:38:0x0175, B:40:0x0191, B:41:0x0199, B:43:0x019d, B:44:0x01c8, B:45:0x01cd), top: B:11:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0199 A[Catch: all -> 0x0047, TryCatch #0 {all -> 0x0047, blocks: (B:12:0x0042, B:13:0x00c1, B:15:0x00c7, B:17:0x00cf, B:20:0x00d9, B:22:0x00e6, B:24:0x00f7, B:26:0x00fd, B:31:0x0105, B:33:0x015c, B:35:0x0162, B:36:0x0168, B:38:0x0175, B:40:0x0191, B:41:0x0199, B:43:0x019d, B:44:0x01c8, B:45:0x01cd), top: B:11:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refresh(boolean z, String str, long j, Continuation<? super TenantUserConfigResponse> continuation) {
        TenantUserConfigRepository$refresh$1 tenantUserConfigRepository$refresh$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        String str2;
        boolean z2;
        Mutex mutex;
        Mutex mutex2;
        TenantUserConfigRepository tenantUserConfigRepository;
        TenantUserConfigResponse empty;
        String str3;
        HttpDataResult.Success success;
        List<McpWhitelistItem> whitelists;
        long j2 = j;
        try {
            if (continuation instanceof TenantUserConfigRepository$refresh$1) {
                tenantUserConfigRepository$refresh$1 = (TenantUserConfigRepository$refresh$1) continuation;
                if ((tenantUserConfigRepository$refresh$1.label & Integer.MIN_VALUE) != 0) {
                    tenantUserConfigRepository$refresh$1.label -= Integer.MIN_VALUE;
                    obj = tenantUserConfigRepository$refresh$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = tenantUserConfigRepository$refresh$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (!isEnterpriseLogin() || j2 != currentGeneration()) {
                            return TenantUserConfigResponse.INSTANCE.getEMPTY();
                        }
                        Mutex mutex3 = refreshMutex;
                        str2 = str;
                        tenantUserConfigRepository$refresh$1.L$0 = str2;
                        tenantUserConfigRepository$refresh$1.L$1 = mutex3;
                        z2 = z;
                        tenantUserConfigRepository$refresh$1.Z$0 = z2;
                        tenantUserConfigRepository$refresh$1.J$0 = j2;
                        tenantUserConfigRepository$refresh$1.label = 1;
                        if (mutex3.lock((Object) null, tenantUserConfigRepository$refresh$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mutex = mutex3;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            j2 = tenantUserConfigRepository$refresh$1.J$0;
                            mutex2 = (Mutex) tenantUserConfigRepository$refresh$1.L$1;
                            str3 = (String) tenantUserConfigRepository$refresh$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                success = (HttpDataResult) obj;
                                if (!(success instanceof HttpDataResult.Success)) {
                                    TenantUserConfigRepository tenantUserConfigRepository2 = INSTANCE;
                                    if (tenantUserConfigRepository2.isEnterpriseLogin() && j2 == tenantUserConfigRepository2.currentGeneration()) {
                                        TenantUserConfigResponse tenantUserConfigResponse = success.getBizResp().isSuccess() ? (TenantUserConfigResponse) success.getBizResp().getData() : null;
                                        if (tenantUserConfigResponse == null) {
                                            empty = tenantUserConfigRepository2.markRefreshAttempt(str3, "empty data or bizCode=" + success.getBizResp().getCode(), j2);
                                        } else if (tenantUserConfigRepository2.saveConfigIfCurrent(tenantUserConfigResponse, j2) == null) {
                                            empty = TenantUserConfigResponse.INSTANCE.getEMPTY();
                                        } else {
                                            FLogger fLogger = FLogger.INSTANCE;
                                            StringBuilder append = new StringBuilder("refresh success source=").append(str3).append(", repos=").append(tenantUserConfigResponse.getConfigInfo().getBlacklistRepos().size()).append(", commands=").append(tenantUserConfigResponse.getConfigInfo().getBlacklistCommands().size()).append(", rules=").append(tenantUserConfigResponse.getSecurityRules().size()).append(", mcpWhitelist=");
                                            McpWhitelistConfigInfo mcpWhitelistConfig = tenantUserConfigResponse.getMcpWhitelistConfig();
                                            fLogger.i(TAG, append.append((mcpWhitelistConfig == null || (whitelists = mcpWhitelistConfig.getWhitelists()) == null) ? 0 : whitelists.size()).toString());
                                            empty = tenantUserConfigResponse;
                                        }
                                    }
                                    empty = TenantUserConfigResponse.INSTANCE.getEMPTY();
                                } else {
                                    if (!(success instanceof HttpDataResult.Error)) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    empty = INSTANCE.markRefreshAttempt(str3, "network error code=" + ((HttpDataResult.Error) success).getCode() + ", msg=" + ((HttpDataResult.Error) success).getMsg(), j2);
                                }
                                mutex = mutex2;
                                mutex.unlock((Object) null);
                                return empty;
                            } catch (Throwable th) {
                                th = th;
                                mutex2.unlock((Object) null);
                                throw th;
                            }
                        }
                        j2 = tenantUserConfigRepository$refresh$1.J$0;
                        boolean z3 = tenantUserConfigRepository$refresh$1.Z$0;
                        mutex = (Mutex) tenantUserConfigRepository$refresh$1.L$1;
                        String str4 = (String) tenantUserConfigRepository$refresh$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        z2 = z3;
                        str2 = str4;
                    }
                    tenantUserConfigRepository = INSTANCE;
                    if (tenantUserConfigRepository.isEnterpriseLogin() && j2 == tenantUserConfigRepository.currentGeneration()) {
                        if (z2 && tenantUserConfigRepository.isCacheValid()) {
                            empty = cachedConfig;
                            mutex.unlock((Object) null);
                            return empty;
                        }
                        tenantUserConfigRepository$refresh$1.L$0 = str2;
                        tenantUserConfigRepository$refresh$1.L$1 = mutex;
                        tenantUserConfigRepository$refresh$1.J$0 = j2;
                        tenantUserConfigRepository$refresh$1.label = 2;
                        obj = tenantUserConfigRepository.fetchTenantUserConfig(str2, tenantUserConfigRepository$refresh$1);
                        if (obj != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str3 = str2;
                        mutex2 = mutex;
                        success = (HttpDataResult) obj;
                        if (!(success instanceof HttpDataResult.Success)) {
                        }
                        mutex = mutex2;
                        mutex.unlock((Object) null);
                        return empty;
                    }
                    empty = TenantUserConfigResponse.INSTANCE.getEMPTY();
                    mutex.unlock((Object) null);
                    return empty;
                }
            }
            tenantUserConfigRepository = INSTANCE;
            if (tenantUserConfigRepository.isEnterpriseLogin()) {
                if (z2) {
                }
                tenantUserConfigRepository$refresh$1.L$0 = str2;
                tenantUserConfigRepository$refresh$1.L$1 = mutex;
                tenantUserConfigRepository$refresh$1.J$0 = j2;
                tenantUserConfigRepository$refresh$1.label = 2;
                obj = tenantUserConfigRepository.fetchTenantUserConfig(str2, tenantUserConfigRepository$refresh$1);
                if (obj != coroutine_suspended) {
                }
            }
            empty = TenantUserConfigResponse.INSTANCE.getEMPTY();
            mutex.unlock((Object) null);
            return empty;
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutex;
            mutex2.unlock((Object) null);
            throw th;
        }
        tenantUserConfigRepository$refresh$1 = new TenantUserConfigRepository$refresh$1(this, continuation);
        obj = tenantUserConfigRepository$refresh$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tenantUserConfigRepository$refresh$1.label;
        if (i != 0) {
        }
    }

    static /* synthetic */ Object refresh$default(TenantUserConfigRepository tenantUserConfigRepository, boolean z, String str, long j, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            j = tenantUserConfigRepository.currentGeneration();
        }
        return tenantUserConfigRepository.refresh(z, str, j, continuation);
    }

    private final TenantUserConfigResponse markRefreshAttempt(String source, String reason, long generation) {
        TenantUserConfigResponse tenantUserConfigResponse;
        synchronized (cacheStateLock) {
            if (generation == accountConfigGeneration && INSTANCE.isEnterpriseLogin()) {
                lastRefreshElapsedMs = SystemClock.elapsedRealtime();
                tenantUserConfigResponse = cachedConfig;
            }
            tenantUserConfigResponse = null;
        }
        if (tenantUserConfigResponse == null) {
            return TenantUserConfigResponse.INSTANCE.getEMPTY();
        }
        FLogger.INSTANCE.w(TAG, "refresh failed source=" + source + ", " + reason);
        return tenantUserConfigResponse;
    }

    private final TenantUserConfigResponse saveConfigIfCurrent(TenantUserConfigResponse data, long generation) {
        synchronized (cacheStateLock) {
            if (generation == accountConfigGeneration && INSTANCE.isEnterpriseLogin()) {
                cachedConfig = data;
                hasSuccessfulConfig = true;
                lastRefreshElapsedMs = SystemClock.elapsedRealtime();
            }
            data = null;
        }
        return data;
    }

    private final long clearCacheAndBumpGeneration() {
        long j;
        synchronized (cacheStateLock) {
            Job job = asyncRefreshJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            asyncRefreshJob = null;
            cachedConfig = TenantUserConfigResponse.INSTANCE.getEMPTY();
            hasSuccessfulConfig = false;
            lastRefreshElapsedMs = 0L;
            accountConfigGeneration++;
            j = accountConfigGeneration;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long currentGeneration() {
        return accountConfigGeneration;
    }

    private final boolean isCacheValid() {
        long j = lastRefreshElapsedMs;
        return hasSuccessfulConfig && j > 0 && SystemClock.elapsedRealtime() - j < 600000;
    }

    private final boolean isEnterpriseLogin() {
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        return Intrinsics.areEqual((iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getLoginPlatform(), "enterprise");
    }

    private final String resolvedType(McpWhitelistItem mcpWhitelistItem) {
        String type = mcpWhitelistItem.getType();
        if (type == null) {
            type = "";
        }
        if (!StringsKt.isBlank(type)) {
            return type;
        }
        String url = mcpWhitelistItem.getUrl();
        if (url == null) {
            url = "";
        }
        if (!StringsKt.isBlank(url)) {
            String command = mcpWhitelistItem.getCommand();
            if (StringsKt.isBlank(command != null ? command : "")) {
                return "http";
            }
        }
        return "stdio";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(8:5|6|7|(1:(2:10|11)(2:24|25))(3:26|27|(1:29)(1:30))|12|13|(1:15)(2:18|(1:20)(2:21|22))|16))|38|6|7|(0)(0)|12|13|(0)(0)|16) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0081, code lost:
    
        r15 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
    
        r15 = new com.bytedance.trae.network.response.HttpDataResult.Error<>(-1001, "", r15, (java.lang.String) null, 8, (kotlin.jvm.internal.DefaultConstructorMarker) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
    
        r15 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0068, code lost:
    
        r0 = r15.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
    
        if (r0 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0073, code lost:
    
        r0 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0075, code lost:
    
        r15 = new com.bytedance.trae.network.response.HttpDataResult.Error<>(com.bytedance.sdk.account.api.AccountErrorCode.CommonError.COMMON_ERROR_AUTHORIZE, r0, r15, (java.lang.String) null, 8, (kotlin.jvm.internal.DefaultConstructorMarker) null);
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchTenantUserConfig(String str, Continuation<? super HttpDataResult<TenantUserConfigResponse>> continuation) {
        TenantUserConfigRepository$fetchTenantUserConfig$1 tenantUserConfigRepository$fetchTenantUserConfig$1;
        int i;
        HttpDataResult<TenantUserConfigResponse> error;
        TenantUserConfigRepository tenantUserConfigRepository;
        if (continuation instanceof TenantUserConfigRepository$fetchTenantUserConfig$1) {
            tenantUserConfigRepository$fetchTenantUserConfig$1 = (TenantUserConfigRepository$fetchTenantUserConfig$1) continuation;
            if ((tenantUserConfigRepository$fetchTenantUserConfig$1.label & Integer.MIN_VALUE) != 0) {
                tenantUserConfigRepository$fetchTenantUserConfig$1.label -= Integer.MIN_VALUE;
                Object obj = tenantUserConfigRepository$fetchTenantUserConfig$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = tenantUserConfigRepository$fetchTenantUserConfig$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ITenantUserConfigApi iTenantUserConfigApi = (ITenantUserConfigApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "base", ITenantUserConfigApi.class, (Converter.Factory) null, (String) null, (Map) null, false, 60, (Object) null);
                    Map<String, Object> map = EMPTY_REQUEST;
                    tenantUserConfigRepository$fetchTenantUserConfig$1.L$0 = this;
                    tenantUserConfigRepository$fetchTenantUserConfig$1.L$1 = str;
                    tenantUserConfigRepository$fetchTenantUserConfig$1.label = 1;
                    obj = iTenantUserConfigApi.getTenantUserConfig(map, tenantUserConfigRepository$fetchTenantUserConfig$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    tenantUserConfigRepository = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) tenantUserConfigRepository$fetchTenantUserConfig$1.L$1;
                    tenantUserConfigRepository = (TenantUserConfigRepository) tenantUserConfigRepository$fetchTenantUserConfig$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                error = tenantUserConfigRepository.parseTenantUserConfigResponse((SsResponse) obj);
                if (!(error instanceof HttpDataResult.Success)) {
                    FLogger.INSTANCE.d(TAG, "safeCall done source=" + str + ", bizCode=" + ((HttpDataResult.Success) error).getBizResp().getCode());
                } else {
                    if (!(error instanceof HttpDataResult.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    FLogger.INSTANCE.d(TAG, "safeCall done source=" + str + ", errorCode=" + ((HttpDataResult.Error) error).getCode());
                }
                return error;
            }
        }
        tenantUserConfigRepository$fetchTenantUserConfig$1 = new TenantUserConfigRepository$fetchTenantUserConfig$1(this, continuation);
        Object obj2 = tenantUserConfigRepository$fetchTenantUserConfig$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tenantUserConfigRepository$fetchTenantUserConfig$1.label;
        if (i != 0) {
        }
        error = tenantUserConfigRepository.parseTenantUserConfigResponse((SsResponse) obj2);
        if (!(error instanceof HttpDataResult.Success)) {
        }
        return error;
    }

    private final HttpDataResult<TenantUserConfigResponse> parseTenantUserConfigResponse(SsResponse<String> response) {
        TenantUserConfigResponse tenantUserConfigResponse;
        InputStream in;
        if (response == null) {
            return new HttpDataResult.Error<>(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "response is null", new NullPointerException("response is null"), (String) null, 8, (DefaultConstructorMarker) null);
        }
        String str = (String) response.body();
        if (str == null) {
            TypedInput errorBody = response.errorBody();
            if (errorBody == null || (in = errorBody.in()) == null) {
                str = null;
            } else {
                Reader inputStreamReader = new InputStreamReader(in, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, FConstants.DOWNLOAD_BUFFER_SIZE);
                try {
                    str = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                } finally {
                }
            }
            if (str == null) {
                return new HttpDataResult.Error<>(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "response body is null", new NullPointerException("response body is null"), (String) null, 8, (DefaultConstructorMarker) null);
            }
        }
        BizResponse bizResponse = (BizResponse) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(str, TypeToken.getParameterized(BizResponse.class, new Type[]{TenantUserConfigResponse.class}).getType());
        if (bizResponse == null) {
            return new HttpDataResult.Error<>(AccountErrorCode.CommonError.COMMON_ERROR_AUTHORIZE, "response envelope is null", new IllegalStateException("response envelope is null"), (String) null, 8, (DefaultConstructorMarker) null);
        }
        bizResponse.setupSSResponse(response);
        TenantUserConfigResponse tenantUserConfigResponse2 = (TenantUserConfigResponse) bizResponse.getData();
        if (tenantUserConfigResponse2 == null) {
            if (bizResponse.isSuccess()) {
                tenantUserConfigResponse2 = (TenantUserConfigResponse) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(str, TenantUserConfigResponse.class);
            } else {
                tenantUserConfigResponse = null;
                BizResponse bizResponse2 = new BizResponse(bizResponse.getCode(), bizResponse.getMsg(), bizResponse.getMessage(), bizResponse.getPayload(), tenantUserConfigResponse, bizResponse.getActivityMessage());
                bizResponse2.setupSSResponse(response);
                return new HttpDataResult.Success<>(bizResponse2, (Throwable) null);
            }
        }
        tenantUserConfigResponse = tenantUserConfigResponse2;
        BizResponse bizResponse22 = new BizResponse(bizResponse.getCode(), bizResponse.getMsg(), bizResponse.getMessage(), bizResponse.getPayload(), tenantUserConfigResponse, bizResponse.getActivityMessage());
        bizResponse22.setupSSResponse(response);
        return new HttpDataResult.Success<>(bizResponse22, (Throwable) null);
    }
}
