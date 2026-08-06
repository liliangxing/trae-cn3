package com.bytedance.trae.conversation.plugin;

import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.network.IPluginApi;
import com.bytedance.trae.conversation.network.ListPluginsData;
import com.bytedance.trae.conversation.network.MarketplacePluginItem;
import com.bytedance.trae.conversation.network.PluginItem;
import com.bytedance.trae.conversation.tracker.PluginTracker;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: PluginListCache.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003:;<B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0002\u0010\u001fJ\"\u0010 \u001a\u00020!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0002\u0010\u001fJ\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010#\u001a\u00020!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010$\u001a\u0004\u0018\u00010\u000f2\u0006\u0010%\u001a\u00020\u000fJ\u0018\u0010&\u001a\u0004\u0018\u00010\u000f2\u0006\u0010%\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010'J&\u0010(\u001a\u0004\u0018\u00010\u00102\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010%\u001a\u00020\u000fH\u0002J\u0006\u0010*\u001a\u00020!J \u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\u0013H\u0082@¢\u0006\u0002\u0010,J>\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00132\u0006\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u0002002\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0082@¢\u0006\u0002\u00101J0\u00102\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010/\u001a\u0002002\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0082@¢\u0006\u0002\u00103J0\u00104\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0002J\u0018\u00107\u001a\u0002002\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00130\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/bytedance/trae/conversation/plugin/PluginListCache;", "", "<init>", "()V", "MARKETPLACE_TTL_MS", "", "INSTALLED_TTL_MS", "PAGE_SIZE", "", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "marketplaceByName", "", "", "Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;", "marketplaceLoadedAt", "marketplacePromise", "Lkotlinx/coroutines/Deferred;", "installedCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;", "Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;", "installedPromises", "", "Lcom/bytedance/trae/conversation/network/PluginItem;", "getPlugins", "Lcom/bytedance/trae/conversation/plugin/PluginListCache$PluginListResult;", "cliId", "workspaceFolder", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", OauthTokenTriggerScene.PRELOAD, "", "getCachedPlugins", "invalidateInstalled", "getCachedLocalizedDisplayName", "pluginName", "resolveLocalizedDisplayName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findMarketplaceItem", "map", "clearAll", "ensureMarketplaceLoading", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureInstalledLoading", "key", "isLocal", "", "(Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;ZLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAllInstalledPages", "(ZLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mergePlugins", "installed", "marketplace", "isFresh", "loadedAt", "ttl", "InstalledCacheKey", "InstalledCacheEntry", "PluginListResult", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginListCache {
    private static final long INSTALLED_TTL_MS = 30000;
    private static final long MARKETPLACE_TTL_MS = 300000;
    private static final int PAGE_SIZE = 50;
    private static volatile long marketplaceLoadedAt;
    private static Deferred<? extends Map<String, MarketplacePluginItem>> marketplacePromise;
    public static final PluginListCache INSTANCE = new PluginListCache();
    private static final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    private static volatile Map<String, MarketplacePluginItem> marketplaceByName = MapsKt.emptyMap();
    private static final ConcurrentHashMap<InstalledCacheKey, InstalledCacheEntry> installedCache = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<InstalledCacheKey, Deferred<List<PluginItem>>> installedPromises = new ConcurrentHashMap<>();

    private PluginListCache() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PluginListCache.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;", "", "isLocal", "", "cliId", "", "workspaceFolder", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "()Z", "getCliId", "()Ljava/lang/String;", "getWorkspaceFolder", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class InstalledCacheKey {
        private final String cliId;
        private final boolean isLocal;
        private final String workspaceFolder;

        public static /* synthetic */ InstalledCacheKey copy$default(InstalledCacheKey installedCacheKey, boolean z, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = installedCacheKey.isLocal;
            }
            if ((i & 2) != 0) {
                str = installedCacheKey.cliId;
            }
            if ((i & 4) != 0) {
                str2 = installedCacheKey.workspaceFolder;
            }
            return installedCacheKey.copy(z, str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsLocal() {
            return this.isLocal;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCliId() {
            return this.cliId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getWorkspaceFolder() {
            return this.workspaceFolder;
        }

        public final InstalledCacheKey copy(boolean isLocal, String cliId, String workspaceFolder) {
            return new InstalledCacheKey(isLocal, cliId, workspaceFolder);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InstalledCacheKey)) {
                return false;
            }
            InstalledCacheKey installedCacheKey = (InstalledCacheKey) other;
            return this.isLocal == installedCacheKey.isLocal && Intrinsics.areEqual(this.cliId, installedCacheKey.cliId) && Intrinsics.areEqual(this.workspaceFolder, installedCacheKey.workspaceFolder);
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.isLocal) * 31;
            String str = this.cliId;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.workspaceFolder;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "InstalledCacheKey(isLocal=" + this.isLocal + ", cliId=" + this.cliId + ", workspaceFolder=" + this.workspaceFolder + ')';
        }

        public InstalledCacheKey(boolean z, String str, String str2) {
            this.isLocal = z;
            this.cliId = str;
            this.workspaceFolder = str2;
        }

        public final String getCliId() {
            return this.cliId;
        }

        public final String getWorkspaceFolder() {
            return this.workspaceFolder;
        }

        public final boolean isLocal() {
            return this.isLocal;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PluginListCache.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;", "", "plugins", "", "Lcom/bytedance/trae/conversation/network/PluginItem;", "loadedAt", "", "<init>", "(Ljava/util/List;J)V", "getPlugins", "()Ljava/util/List;", "getLoadedAt", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class InstalledCacheEntry {
        private final long loadedAt;
        private final List<PluginItem> plugins;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InstalledCacheEntry copy$default(InstalledCacheEntry installedCacheEntry, List list, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                list = installedCacheEntry.plugins;
            }
            if ((i & 2) != 0) {
                j = installedCacheEntry.loadedAt;
            }
            return installedCacheEntry.copy(list, j);
        }

        public final List<PluginItem> component1() {
            return this.plugins;
        }

        /* renamed from: component2, reason: from getter */
        public final long getLoadedAt() {
            return this.loadedAt;
        }

        public final InstalledCacheEntry copy(List<PluginItem> plugins, long loadedAt) {
            Intrinsics.checkNotNullParameter(plugins, "plugins");
            return new InstalledCacheEntry(plugins, loadedAt);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InstalledCacheEntry)) {
                return false;
            }
            InstalledCacheEntry installedCacheEntry = (InstalledCacheEntry) other;
            return Intrinsics.areEqual(this.plugins, installedCacheEntry.plugins) && this.loadedAt == installedCacheEntry.loadedAt;
        }

        public int hashCode() {
            return (this.plugins.hashCode() * 31) + Long.hashCode(this.loadedAt);
        }

        public String toString() {
            return "InstalledCacheEntry(plugins=" + this.plugins + ", loadedAt=" + this.loadedAt + ')';
        }

        public InstalledCacheEntry(List<PluginItem> list, long j) {
            Intrinsics.checkNotNullParameter(list, "plugins");
            this.plugins = list;
            this.loadedAt = j;
        }

        public final List<PluginItem> getPlugins() {
            return this.plugins;
        }

        public final long getLoadedAt() {
            return this.loadedAt;
        }
    }

    /* compiled from: PluginListCache.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/plugin/PluginListCache$PluginListResult;", "", "plugins", "", "Lcom/bytedance/trae/conversation/network/PluginItem;", "fromCache", "", "<init>", "(Ljava/util/List;Z)V", "getPlugins", "()Ljava/util/List;", "getFromCache", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class PluginListResult {
        private final boolean fromCache;
        private final List<PluginItem> plugins;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PluginListResult copy$default(PluginListResult pluginListResult, List list, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                list = pluginListResult.plugins;
            }
            if ((i & 2) != 0) {
                z = pluginListResult.fromCache;
            }
            return pluginListResult.copy(list, z);
        }

        public final List<PluginItem> component1() {
            return this.plugins;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getFromCache() {
            return this.fromCache;
        }

        public final PluginListResult copy(List<PluginItem> plugins, boolean fromCache) {
            Intrinsics.checkNotNullParameter(plugins, "plugins");
            return new PluginListResult(plugins, fromCache);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PluginListResult)) {
                return false;
            }
            PluginListResult pluginListResult = (PluginListResult) other;
            return Intrinsics.areEqual(this.plugins, pluginListResult.plugins) && this.fromCache == pluginListResult.fromCache;
        }

        public int hashCode() {
            return (this.plugins.hashCode() * 31) + Boolean.hashCode(this.fromCache);
        }

        public String toString() {
            return "PluginListResult(plugins=" + this.plugins + ", fromCache=" + this.fromCache + ')';
        }

        public PluginListResult(List<PluginItem> list, boolean z) {
            Intrinsics.checkNotNullParameter(list, "plugins");
            this.plugins = list;
            this.fromCache = z;
        }

        public final List<PluginItem> getPlugins() {
            return this.plugins;
        }

        public final boolean getFromCache() {
            return this.fromCache;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002b. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0198 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0187 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0168 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getPlugins(String str, String str2, Continuation<? super PluginListResult> continuation) {
        PluginListCache$getPlugins$1 pluginListCache$getPlugins$1;
        InstalledCacheKey installedCacheKey;
        Mutex mutex2;
        PluginListCache pluginListCache;
        int i;
        Mutex mutex3;
        String str3;
        int i2;
        String str4;
        Mutex mutex4;
        InstalledCacheKey installedCacheKey2;
        InstalledCacheEntry installedCacheEntry;
        Object obj;
        PluginListCache pluginListCache2;
        boolean z;
        Object ensureMarketplaceLoading;
        InstalledCacheKey installedCacheKey3;
        String str5;
        Deferred deferred;
        Object await;
        Deferred deferred2;
        Object await2;
        Map<String, MarketplacePluginItem> map;
        String str6 = str;
        String str7 = str2;
        if (continuation instanceof PluginListCache$getPlugins$1) {
            pluginListCache$getPlugins$1 = (PluginListCache$getPlugins$1) continuation;
            if ((pluginListCache$getPlugins$1.label & Integer.MIN_VALUE) != 0) {
                pluginListCache$getPlugins$1.label -= Integer.MIN_VALUE;
                Object obj2 = pluginListCache$getPlugins$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (pluginListCache$getPlugins$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj2);
                        String str8 = str6;
                        boolean z2 = ((str8 == null || str8.length() == 0) ? (char) 1 : (char) 0) ^ 1;
                        installedCacheKey = new InstalledCacheKey(z2, str6, str7);
                        mutex2 = mutex;
                        pluginListCache$getPlugins$1.L$0 = this;
                        pluginListCache$getPlugins$1.L$1 = str6;
                        pluginListCache$getPlugins$1.L$2 = str7;
                        pluginListCache$getPlugins$1.L$3 = installedCacheKey;
                        pluginListCache$getPlugins$1.L$4 = mutex2;
                        pluginListCache$getPlugins$1.I$0 = z2 ? 1 : 0;
                        pluginListCache$getPlugins$1.label = 1;
                        if (mutex2.lock((Object) null, pluginListCache$getPlugins$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pluginListCache = this;
                        i = z2;
                        try {
                            InstalledCacheEntry installedCacheEntry2 = installedCache.get(installedCacheKey);
                            mutex2.unlock((Object) null);
                            mutex3 = mutex;
                            pluginListCache$getPlugins$1.L$0 = pluginListCache;
                            pluginListCache$getPlugins$1.L$1 = str6;
                            pluginListCache$getPlugins$1.L$2 = str7;
                            pluginListCache$getPlugins$1.L$3 = installedCacheKey;
                            pluginListCache$getPlugins$1.L$4 = installedCacheEntry2;
                            pluginListCache$getPlugins$1.L$5 = mutex3;
                            pluginListCache$getPlugins$1.I$0 = i;
                            pluginListCache$getPlugins$1.label = 2;
                            if (mutex3.lock((Object) null, pluginListCache$getPlugins$1) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str3 = str6;
                            i2 = i;
                            str4 = str7;
                            mutex4 = mutex3;
                            installedCacheKey2 = installedCacheKey;
                            installedCacheEntry = installedCacheEntry2;
                            try {
                                Map<String, MarketplacePluginItem> map2 = marketplaceByName;
                                PluginListCache pluginListCache3 = pluginListCache;
                                try {
                                    if (!INSTANCE.isFresh(marketplaceLoadedAt, 300000L)) {
                                        map2 = null;
                                    }
                                    mutex4.unlock((Object) null);
                                    if (installedCacheEntry == null) {
                                        pluginListCache2 = pluginListCache3;
                                        if (pluginListCache2.isFresh(installedCacheEntry.getLoadedAt(), 30000L) && map2 != null) {
                                            return new PluginListResult(pluginListCache2.mergePlugins(installedCacheEntry.getPlugins(), map2), true);
                                        }
                                    } else {
                                        pluginListCache2 = pluginListCache3;
                                    }
                                    z = true;
                                    pluginListCache$getPlugins$1.L$0 = pluginListCache2;
                                    pluginListCache$getPlugins$1.L$1 = str3;
                                    pluginListCache$getPlugins$1.L$2 = str4;
                                    pluginListCache$getPlugins$1.L$3 = installedCacheKey2;
                                    pluginListCache$getPlugins$1.L$4 = null;
                                    pluginListCache$getPlugins$1.L$5 = null;
                                    pluginListCache$getPlugins$1.I$0 = i2;
                                    pluginListCache$getPlugins$1.label = 3;
                                    ensureMarketplaceLoading = pluginListCache2.ensureMarketplaceLoading(pluginListCache$getPlugins$1);
                                    if (ensureMarketplaceLoading != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    installedCacheKey3 = installedCacheKey2;
                                    str5 = str3;
                                    Deferred deferred3 = (Deferred) ensureMarketplaceLoading;
                                    boolean z3 = i2 == 0 ? z : false;
                                    pluginListCache$getPlugins$1.L$0 = pluginListCache2;
                                    pluginListCache$getPlugins$1.L$1 = deferred3;
                                    pluginListCache$getPlugins$1.L$2 = null;
                                    pluginListCache$getPlugins$1.L$3 = null;
                                    pluginListCache$getPlugins$1.label = 4;
                                    obj2 = pluginListCache2.ensureInstalledLoading(installedCacheKey3, z3, str5, str4, pluginListCache$getPlugins$1);
                                    if (obj2 != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    deferred = deferred3;
                                    Deferred deferred4 = (Deferred) obj2;
                                    pluginListCache$getPlugins$1.L$0 = pluginListCache2;
                                    pluginListCache$getPlugins$1.L$1 = deferred4;
                                    pluginListCache$getPlugins$1.label = 5;
                                    await = deferred.await(pluginListCache$getPlugins$1);
                                    if (await != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj2 = await;
                                    deferred2 = deferred4;
                                    Map<String, MarketplacePluginItem> map3 = (Map) obj2;
                                    pluginListCache$getPlugins$1.L$0 = pluginListCache2;
                                    pluginListCache$getPlugins$1.L$1 = map3;
                                    pluginListCache$getPlugins$1.label = 6;
                                    await2 = deferred2.await(pluginListCache$getPlugins$1);
                                    if (await2 != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj2 = await2;
                                    map = map3;
                                    return new PluginListResult(pluginListCache2.mergePlugins((List) obj2, map), false);
                                } catch (Throwable th) {
                                    th = th;
                                    obj = null;
                                    mutex4.unlock(obj);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                obj = null;
                            }
                        } catch (Throwable th3) {
                            mutex2.unlock((Object) null);
                            throw th3;
                        }
                        break;
                    case 1:
                        int i3 = pluginListCache$getPlugins$1.I$0;
                        Mutex mutex5 = (Mutex) pluginListCache$getPlugins$1.L$4;
                        installedCacheKey = (InstalledCacheKey) pluginListCache$getPlugins$1.L$3;
                        String str9 = (String) pluginListCache$getPlugins$1.L$2;
                        String str10 = (String) pluginListCache$getPlugins$1.L$1;
                        PluginListCache pluginListCache4 = (PluginListCache) pluginListCache$getPlugins$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        i = i3;
                        str6 = str10;
                        pluginListCache = pluginListCache4;
                        mutex2 = mutex5;
                        str7 = str9;
                        InstalledCacheEntry installedCacheEntry22 = installedCache.get(installedCacheKey);
                        mutex2.unlock((Object) null);
                        mutex3 = mutex;
                        pluginListCache$getPlugins$1.L$0 = pluginListCache;
                        pluginListCache$getPlugins$1.L$1 = str6;
                        pluginListCache$getPlugins$1.L$2 = str7;
                        pluginListCache$getPlugins$1.L$3 = installedCacheKey;
                        pluginListCache$getPlugins$1.L$4 = installedCacheEntry22;
                        pluginListCache$getPlugins$1.L$5 = mutex3;
                        pluginListCache$getPlugins$1.I$0 = i;
                        pluginListCache$getPlugins$1.label = 2;
                        if (mutex3.lock((Object) null, pluginListCache$getPlugins$1) != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        i2 = pluginListCache$getPlugins$1.I$0;
                        mutex4 = (Mutex) pluginListCache$getPlugins$1.L$5;
                        installedCacheEntry = (InstalledCacheEntry) pluginListCache$getPlugins$1.L$4;
                        installedCacheKey2 = (InstalledCacheKey) pluginListCache$getPlugins$1.L$3;
                        str4 = (String) pluginListCache$getPlugins$1.L$2;
                        str3 = (String) pluginListCache$getPlugins$1.L$1;
                        pluginListCache = (PluginListCache) pluginListCache$getPlugins$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        Map<String, MarketplacePluginItem> map22 = marketplaceByName;
                        PluginListCache pluginListCache32 = pluginListCache;
                        if (!INSTANCE.isFresh(marketplaceLoadedAt, 300000L)) {
                        }
                        mutex4.unlock((Object) null);
                        if (installedCacheEntry == null) {
                        }
                        z = true;
                        pluginListCache$getPlugins$1.L$0 = pluginListCache2;
                        pluginListCache$getPlugins$1.L$1 = str3;
                        pluginListCache$getPlugins$1.L$2 = str4;
                        pluginListCache$getPlugins$1.L$3 = installedCacheKey2;
                        pluginListCache$getPlugins$1.L$4 = null;
                        pluginListCache$getPlugins$1.L$5 = null;
                        pluginListCache$getPlugins$1.I$0 = i2;
                        pluginListCache$getPlugins$1.label = 3;
                        ensureMarketplaceLoading = pluginListCache2.ensureMarketplaceLoading(pluginListCache$getPlugins$1);
                        if (ensureMarketplaceLoading != coroutine_suspended) {
                        }
                        break;
                    case 3:
                        i2 = pluginListCache$getPlugins$1.I$0;
                        InstalledCacheKey installedCacheKey4 = (InstalledCacheKey) pluginListCache$getPlugins$1.L$3;
                        String str11 = (String) pluginListCache$getPlugins$1.L$2;
                        str5 = (String) pluginListCache$getPlugins$1.L$1;
                        PluginListCache pluginListCache5 = (PluginListCache) pluginListCache$getPlugins$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        installedCacheKey3 = installedCacheKey4;
                        pluginListCache2 = pluginListCache5;
                        str4 = str11;
                        ensureMarketplaceLoading = obj2;
                        z = true;
                        Deferred deferred32 = (Deferred) ensureMarketplaceLoading;
                        if (i2 == 0) {
                        }
                        pluginListCache$getPlugins$1.L$0 = pluginListCache2;
                        pluginListCache$getPlugins$1.L$1 = deferred32;
                        pluginListCache$getPlugins$1.L$2 = null;
                        pluginListCache$getPlugins$1.L$3 = null;
                        pluginListCache$getPlugins$1.label = 4;
                        obj2 = pluginListCache2.ensureInstalledLoading(installedCacheKey3, z3, str5, str4, pluginListCache$getPlugins$1);
                        if (obj2 != coroutine_suspended) {
                        }
                        break;
                    case 4:
                        deferred = (Deferred) pluginListCache$getPlugins$1.L$1;
                        pluginListCache2 = (PluginListCache) pluginListCache$getPlugins$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        Deferred deferred42 = (Deferred) obj2;
                        pluginListCache$getPlugins$1.L$0 = pluginListCache2;
                        pluginListCache$getPlugins$1.L$1 = deferred42;
                        pluginListCache$getPlugins$1.label = 5;
                        await = deferred.await(pluginListCache$getPlugins$1);
                        if (await != coroutine_suspended) {
                        }
                        break;
                    case 5:
                        deferred2 = (Deferred) pluginListCache$getPlugins$1.L$1;
                        pluginListCache2 = (PluginListCache) pluginListCache$getPlugins$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        Map<String, MarketplacePluginItem> map32 = (Map) obj2;
                        pluginListCache$getPlugins$1.L$0 = pluginListCache2;
                        pluginListCache$getPlugins$1.L$1 = map32;
                        pluginListCache$getPlugins$1.label = 6;
                        await2 = deferred2.await(pluginListCache$getPlugins$1);
                        if (await2 != coroutine_suspended) {
                        }
                        break;
                    case 6:
                        map = (Map) pluginListCache$getPlugins$1.L$1;
                        pluginListCache2 = (PluginListCache) pluginListCache$getPlugins$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        return new PluginListResult(pluginListCache2.mergePlugins((List) obj2, map), false);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        pluginListCache$getPlugins$1 = new PluginListCache$getPlugins$1(this, continuation);
        Object obj22 = pluginListCache$getPlugins$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (pluginListCache$getPlugins$1.label) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object preload(String str, String str2, Continuation<? super Unit> continuation) {
        PluginListCache$preload$1 pluginListCache$preload$1;
        Object coroutine_suspended;
        int i;
        String str3;
        InstalledCacheKey installedCacheKey;
        PluginListCache pluginListCache;
        String str4;
        int i2;
        Object ensureInstalledLoading;
        Deferred deferred;
        Deferred deferred2;
        if (continuation instanceof PluginListCache$preload$1) {
            pluginListCache$preload$1 = (PluginListCache$preload$1) continuation;
            if ((pluginListCache$preload$1.label & Integer.MIN_VALUE) != 0) {
                pluginListCache$preload$1.label -= Integer.MIN_VALUE;
                Object obj = pluginListCache$preload$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pluginListCache$preload$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String str5 = str;
                    boolean z = ((str5 == null || str5.length() == 0) ? (char) 1 : (char) 0) ^ 1;
                    InstalledCacheKey installedCacheKey2 = new InstalledCacheKey(z, str, str2);
                    pluginListCache$preload$1.L$0 = this;
                    pluginListCache$preload$1.L$1 = str;
                    pluginListCache$preload$1.L$2 = str2;
                    pluginListCache$preload$1.L$3 = installedCacheKey2;
                    pluginListCache$preload$1.I$0 = z ? 1 : 0;
                    pluginListCache$preload$1.label = 1;
                    Object ensureMarketplaceLoading = ensureMarketplaceLoading(pluginListCache$preload$1);
                    if (ensureMarketplaceLoading == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str3 = str2;
                    installedCacheKey = installedCacheKey2;
                    pluginListCache = this;
                    str4 = str;
                    i2 = z ? 1 : 0;
                    obj = ensureMarketplaceLoading;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 4) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            deferred2 = (Deferred) pluginListCache$preload$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            pluginListCache$preload$1.L$0 = null;
                            pluginListCache$preload$1.label = 4;
                            if (deferred2.await(pluginListCache$preload$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        deferred = (Deferred) pluginListCache$preload$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        Deferred deferred3 = (Deferred) obj;
                        pluginListCache$preload$1.L$0 = deferred3;
                        pluginListCache$preload$1.label = 3;
                        if (deferred.await(pluginListCache$preload$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        deferred2 = deferred3;
                        pluginListCache$preload$1.L$0 = null;
                        pluginListCache$preload$1.label = 4;
                        if (deferred2.await(pluginListCache$preload$1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    }
                    i2 = pluginListCache$preload$1.I$0;
                    installedCacheKey = (InstalledCacheKey) pluginListCache$preload$1.L$3;
                    String str6 = (String) pluginListCache$preload$1.L$2;
                    str4 = (String) pluginListCache$preload$1.L$1;
                    PluginListCache pluginListCache2 = (PluginListCache) pluginListCache$preload$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str3 = str6;
                    pluginListCache = pluginListCache2;
                }
                Deferred deferred4 = (Deferred) obj;
                boolean z2 = i2 != 0;
                pluginListCache$preload$1.L$0 = deferred4;
                pluginListCache$preload$1.L$1 = null;
                pluginListCache$preload$1.L$2 = null;
                pluginListCache$preload$1.L$3 = null;
                pluginListCache$preload$1.label = 2;
                ensureInstalledLoading = pluginListCache.ensureInstalledLoading(installedCacheKey, z2, str4, str3, pluginListCache$preload$1);
                if (ensureInstalledLoading != coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = ensureInstalledLoading;
                deferred = deferred4;
                Deferred deferred32 = (Deferred) obj;
                pluginListCache$preload$1.L$0 = deferred32;
                pluginListCache$preload$1.label = 3;
                if (deferred.await(pluginListCache$preload$1) != coroutine_suspended) {
                }
            }
        }
        pluginListCache$preload$1 = new PluginListCache$preload$1(this, continuation);
        Object obj2 = pluginListCache$preload$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pluginListCache$preload$1.label;
        if (i != 0) {
        }
        Deferred deferred42 = (Deferred) obj2;
        if (i2 != 0) {
        }
        pluginListCache$preload$1.L$0 = deferred42;
        pluginListCache$preload$1.L$1 = null;
        pluginListCache$preload$1.L$2 = null;
        pluginListCache$preload$1.L$3 = null;
        pluginListCache$preload$1.label = 2;
        ensureInstalledLoading = pluginListCache.ensureInstalledLoading(installedCacheKey, z2, str4, str3, pluginListCache$preload$1);
        if (ensureInstalledLoading != coroutine_suspended) {
        }
    }

    public final List<PluginItem> getCachedPlugins(String cliId, String workspaceFolder) {
        String str = cliId;
        InstalledCacheEntry installedCacheEntry = installedCache.get(new InstalledCacheKey(!(str == null || str.length() == 0), cliId, workspaceFolder));
        if (installedCacheEntry == null || marketplaceByName.isEmpty()) {
            return null;
        }
        List<PluginItem> mergePlugins = mergePlugins(installedCacheEntry.getPlugins(), marketplaceByName);
        if (!mergePlugins.isEmpty()) {
            return mergePlugins;
        }
        return null;
    }

    public final void invalidateInstalled(String cliId, String workspaceFolder) {
        String str = cliId;
        installedCache.remove(new InstalledCacheKey(!(str == null || str.length() == 0), cliId, workspaceFolder));
    }

    public final String getCachedLocalizedDisplayName(String pluginName) {
        Intrinsics.checkNotNullParameter(pluginName, "pluginName");
        MarketplacePluginItem findMarketplaceItem = findMarketplaceItem(marketplaceByName, pluginName);
        if (findMarketplaceItem == null) {
            return null;
        }
        return MarketplacePluginItem.localizedDisplayName$default(findMarketplaceItem, null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveLocalizedDisplayName(String str, Continuation<? super String> continuation) {
        PluginListCache$resolveLocalizedDisplayName$1 pluginListCache$resolveLocalizedDisplayName$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        PluginListCache pluginListCache;
        PluginListCache pluginListCache2;
        MarketplacePluginItem findMarketplaceItem;
        if (continuation instanceof PluginListCache$resolveLocalizedDisplayName$1) {
            pluginListCache$resolveLocalizedDisplayName$1 = (PluginListCache$resolveLocalizedDisplayName$1) continuation;
            if ((pluginListCache$resolveLocalizedDisplayName$1.label & Integer.MIN_VALUE) != 0) {
                pluginListCache$resolveLocalizedDisplayName$1.label -= Integer.MIN_VALUE;
                obj = pluginListCache$resolveLocalizedDisplayName$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pluginListCache$resolveLocalizedDisplayName$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String cachedLocalizedDisplayName = getCachedLocalizedDisplayName(str);
                    if (cachedLocalizedDisplayName != null) {
                        return cachedLocalizedDisplayName;
                    }
                    pluginListCache$resolveLocalizedDisplayName$1.L$0 = this;
                    pluginListCache$resolveLocalizedDisplayName$1.L$1 = str;
                    pluginListCache$resolveLocalizedDisplayName$1.label = 1;
                    obj = ensureMarketplaceLoading(pluginListCache$resolveLocalizedDisplayName$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pluginListCache = this;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        str = (String) pluginListCache$resolveLocalizedDisplayName$1.L$1;
                        pluginListCache2 = (PluginListCache) pluginListCache$resolveLocalizedDisplayName$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        findMarketplaceItem = pluginListCache2.findMarketplaceItem((Map) obj, str);
                        if (findMarketplaceItem != null) {
                            return null;
                        }
                        String localizedDisplayName$default = MarketplacePluginItem.localizedDisplayName$default(findMarketplaceItem, null, 1, null);
                        if (!StringsKt.isBlank(localizedDisplayName$default)) {
                            return localizedDisplayName$default;
                        }
                        return null;
                    }
                    str = (String) pluginListCache$resolveLocalizedDisplayName$1.L$1;
                    pluginListCache = (PluginListCache) pluginListCache$resolveLocalizedDisplayName$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                pluginListCache$resolveLocalizedDisplayName$1.L$0 = pluginListCache;
                pluginListCache$resolveLocalizedDisplayName$1.L$1 = str;
                pluginListCache$resolveLocalizedDisplayName$1.label = 2;
                obj = ((Deferred) obj).await(pluginListCache$resolveLocalizedDisplayName$1);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                pluginListCache2 = pluginListCache;
                findMarketplaceItem = pluginListCache2.findMarketplaceItem((Map) obj, str);
                if (findMarketplaceItem != null) {
                }
            }
        }
        pluginListCache$resolveLocalizedDisplayName$1 = new PluginListCache$resolveLocalizedDisplayName$1(this, continuation);
        obj = pluginListCache$resolveLocalizedDisplayName$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pluginListCache$resolveLocalizedDisplayName$1.label;
        if (i != 0) {
        }
        pluginListCache$resolveLocalizedDisplayName$1.L$0 = pluginListCache;
        pluginListCache$resolveLocalizedDisplayName$1.L$1 = str;
        pluginListCache$resolveLocalizedDisplayName$1.label = 2;
        obj = ((Deferred) obj).await(pluginListCache$resolveLocalizedDisplayName$1);
        if (obj != coroutine_suspended) {
        }
    }

    private final MarketplacePluginItem findMarketplaceItem(Map<String, MarketplacePluginItem> map, String pluginName) {
        MarketplacePluginItem marketplacePluginItem = map.get(pluginName);
        if (marketplacePluginItem != null) {
            return marketplacePluginItem;
        }
        int lastIndexOf$default = StringsKt.lastIndexOf$default(pluginName, ':', 0, false, 6, (Object) null);
        if (lastIndexOf$default <= 0) {
            return null;
        }
        String substring = pluginName.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        MarketplacePluginItem marketplacePluginItem2 = map.get(substring);
        if (marketplacePluginItem2 != null) {
            return marketplacePluginItem2;
        }
        return null;
    }

    public final void clearAll() {
        BuildersKt.runBlocking$default((CoroutineContext) null, new PluginListCache$clearAll$1(null), 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object ensureMarketplaceLoading(Continuation<? super Deferred<? extends Map<String, MarketplacePluginItem>>> continuation) {
        PluginListCache$ensureMarketplaceLoading$1 pluginListCache$ensureMarketplaceLoading$1;
        int i;
        Mutex mutex2;
        Deferred<? extends Map<String, MarketplacePluginItem>> deferred;
        try {
            if (continuation instanceof PluginListCache$ensureMarketplaceLoading$1) {
                pluginListCache$ensureMarketplaceLoading$1 = (PluginListCache$ensureMarketplaceLoading$1) continuation;
                if ((pluginListCache$ensureMarketplaceLoading$1.label & Integer.MIN_VALUE) != 0) {
                    pluginListCache$ensureMarketplaceLoading$1.label -= Integer.MIN_VALUE;
                    Object obj = pluginListCache$ensureMarketplaceLoading$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = pluginListCache$ensureMarketplaceLoading$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex3 = mutex;
                        pluginListCache$ensureMarketplaceLoading$1.L$0 = mutex3;
                        pluginListCache$ensureMarketplaceLoading$1.label = 1;
                        if (mutex3.lock((Object) null, pluginListCache$ensureMarketplaceLoading$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mutex2 = mutex3;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutex2 = (Mutex) pluginListCache$ensureMarketplaceLoading$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    if (!INSTANCE.isFresh(marketplaceLoadedAt, 300000L) && (!marketplaceByName.isEmpty())) {
                        return CompletableDeferredKt.CompletableDeferred(marketplaceByName);
                    }
                    deferred = marketplacePromise;
                    if (deferred == null && deferred.isActive()) {
                        return deferred;
                    }
                    Deferred<? extends Map<String, MarketplacePluginItem>> async$default = BuildersKt.async$default(scope, (CoroutineContext) null, (CoroutineStart) null, new PluginListCache$ensureMarketplaceLoading$2$deferred$1(null), 3, (Object) null);
                    marketplacePromise = async$default;
                    return async$default;
                }
            }
            if (!INSTANCE.isFresh(marketplaceLoadedAt, 300000L)) {
            }
            deferred = marketplacePromise;
            if (deferred == null) {
            }
            Deferred<? extends Map<String, MarketplacePluginItem>> async$default2 = BuildersKt.async$default(scope, (CoroutineContext) null, (CoroutineStart) null, new PluginListCache$ensureMarketplaceLoading$2$deferred$1(null), 3, (Object) null);
            marketplacePromise = async$default2;
            return async$default2;
        } finally {
            mutex2.unlock((Object) null);
        }
        pluginListCache$ensureMarketplaceLoading$1 = new PluginListCache$ensureMarketplaceLoading$1(this, continuation);
        Object obj2 = pluginListCache$ensureMarketplaceLoading$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pluginListCache$ensureMarketplaceLoading$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object ensureInstalledLoading(InstalledCacheKey installedCacheKey, boolean z, String str, String str2, Continuation<? super Deferred<? extends List<PluginItem>>> continuation) {
        PluginListCache$ensureInstalledLoading$1 pluginListCache$ensureInstalledLoading$1;
        int i;
        boolean z2;
        Mutex mutex2;
        InstalledCacheKey installedCacheKey2;
        String str3;
        boolean z3;
        String str4;
        InstalledCacheEntry installedCacheEntry;
        Deferred<List<PluginItem>> deferred;
        try {
            if (continuation instanceof PluginListCache$ensureInstalledLoading$1) {
                pluginListCache$ensureInstalledLoading$1 = (PluginListCache$ensureInstalledLoading$1) continuation;
                if ((pluginListCache$ensureInstalledLoading$1.label & Integer.MIN_VALUE) != 0) {
                    pluginListCache$ensureInstalledLoading$1.label -= Integer.MIN_VALUE;
                    Object obj = pluginListCache$ensureInstalledLoading$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = pluginListCache$ensureInstalledLoading$1.label;
                    z2 = true;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex2 = mutex;
                        installedCacheKey2 = installedCacheKey;
                        pluginListCache$ensureInstalledLoading$1.L$0 = installedCacheKey2;
                        pluginListCache$ensureInstalledLoading$1.L$1 = str;
                        pluginListCache$ensureInstalledLoading$1.L$2 = str2;
                        pluginListCache$ensureInstalledLoading$1.L$3 = mutex2;
                        pluginListCache$ensureInstalledLoading$1.Z$0 = z;
                        pluginListCache$ensureInstalledLoading$1.label = 1;
                        if (mutex2.lock((Object) null, pluginListCache$ensureInstalledLoading$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str3 = str2;
                        z3 = z;
                        str4 = str;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        z3 = pluginListCache$ensureInstalledLoading$1.Z$0;
                        mutex2 = (Mutex) pluginListCache$ensureInstalledLoading$1.L$3;
                        String str5 = (String) pluginListCache$ensureInstalledLoading$1.L$2;
                        String str6 = (String) pluginListCache$ensureInstalledLoading$1.L$1;
                        InstalledCacheKey installedCacheKey3 = (InstalledCacheKey) pluginListCache$ensureInstalledLoading$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        installedCacheKey2 = installedCacheKey3;
                        str3 = str5;
                        str4 = str6;
                    }
                    installedCacheEntry = installedCache.get(installedCacheKey2);
                    if (installedCacheEntry == null && INSTANCE.isFresh(installedCacheEntry.getLoadedAt(), 30000L)) {
                        return CompletableDeferredKt.CompletableDeferred(installedCacheEntry.getPlugins());
                    }
                    ConcurrentHashMap<InstalledCacheKey, Deferred<List<PluginItem>>> concurrentHashMap = installedPromises;
                    deferred = concurrentHashMap.get(installedCacheKey2);
                    if (deferred == null && deferred.isActive()) {
                        return deferred;
                    }
                    CoroutineScope coroutineScope = scope;
                    if (z3) {
                        z2 = false;
                    }
                    Deferred<List<PluginItem>> async$default = BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PluginListCache$ensureInstalledLoading$2$deferred$1(z2, str4, str3, installedCacheKey2, null), 3, (Object) null);
                    concurrentHashMap.put(installedCacheKey2, async$default);
                    return async$default;
                }
            }
            installedCacheEntry = installedCache.get(installedCacheKey2);
            if (installedCacheEntry == null) {
            }
            ConcurrentHashMap<InstalledCacheKey, Deferred<List<PluginItem>>> concurrentHashMap2 = installedPromises;
            deferred = concurrentHashMap2.get(installedCacheKey2);
            if (deferred == null) {
            }
            CoroutineScope coroutineScope2 = scope;
            if (z3) {
            }
            Deferred<List<PluginItem>> async$default2 = BuildersKt.async$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new PluginListCache$ensureInstalledLoading$2$deferred$1(z2, str4, str3, installedCacheKey2, null), 3, (Object) null);
            concurrentHashMap2.put(installedCacheKey2, async$default2);
            return async$default2;
        } finally {
            mutex2.unlock((Object) null);
        }
        pluginListCache$ensureInstalledLoading$1 = new PluginListCache$ensureInstalledLoading$1(this, continuation);
        Object obj2 = pluginListCache$ensureInstalledLoading$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pluginListCache$ensureInstalledLoading$1.label;
        z2 = true;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0148, code lost:
    
        if (((kotlin.text.StringsKt.isBlank(r14) ^ true) && r2.add(r14)) != false) goto L56;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Type inference failed for: r13v10, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0100 -> B:11:0x0106). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchAllInstalledPages(boolean z, String str, String str2, Continuation<? super List<PluginItem>> continuation) {
        PluginListCache$fetchAllInstalledPages$1 pluginListCache$fetchAllInstalledPages$1;
        int i;
        LinkedHashSet linkedHashSet;
        String str3;
        Ref.ObjectRef objectRef;
        Collection collection;
        String str4;
        String str5;
        String str6;
        ?? r13;
        Collection collection2;
        String str7;
        HttpDataResult httpDataResult;
        ListPluginsData listPluginsData;
        if (continuation instanceof PluginListCache$fetchAllInstalledPages$1) {
            pluginListCache$fetchAllInstalledPages$1 = (PluginListCache$fetchAllInstalledPages$1) continuation;
            if ((pluginListCache$fetchAllInstalledPages$1.label & Integer.MIN_VALUE) != 0) {
                pluginListCache$fetchAllInstalledPages$1.label -= Integer.MIN_VALUE;
                Object obj = pluginListCache$fetchAllInstalledPages$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pluginListCache$fetchAllInstalledPages$1.label;
                if (i == 0) {
                    if (i == 1) {
                        z = pluginListCache$fetchAllInstalledPages$1.Z$0;
                        objectRef = (Ref.ObjectRef) pluginListCache$fetchAllInstalledPages$1.L$4;
                        r13 = (Set) pluginListCache$fetchAllInstalledPages$1.L$3;
                        collection2 = (List) pluginListCache$fetchAllInstalledPages$1.L$2;
                        str7 = (String) pluginListCache$fetchAllInstalledPages$1.L$1;
                        str6 = (String) pluginListCache$fetchAllInstalledPages$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        httpDataResult = (HttpDataResult) obj;
                        Collection collection3 = collection2;
                        linkedHashSet = r13;
                        str3 = str6;
                        if (!(httpDataResult instanceof HttpDataResult.Success)) {
                        }
                        return collection3;
                    }
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z = pluginListCache$fetchAllInstalledPages$1.Z$0;
                    objectRef = (Ref.ObjectRef) pluginListCache$fetchAllInstalledPages$1.L$4;
                    Set set = (Set) pluginListCache$fetchAllInstalledPages$1.L$3;
                    collection2 = (List) pluginListCache$fetchAllInstalledPages$1.L$2;
                    str7 = (String) pluginListCache$fetchAllInstalledPages$1.L$1;
                    str6 = (String) pluginListCache$fetchAllInstalledPages$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    r13 = set;
                    httpDataResult = (HttpDataResult) obj;
                    Collection collection32 = collection2;
                    linkedHashSet = r13;
                    str3 = str6;
                    if (!(httpDataResult instanceof HttpDataResult.Success)) {
                        BizResponse bizResp = ((HttpDataResult.Success) httpDataResult).getBizResp();
                        if (bizResp.isSuccess() && (listPluginsData = (ListPluginsData) bizResp.getData()) != null) {
                            CollectionsKt.addAll(collection32, listPluginsData.getAllItems());
                            String nextPageToken = listPluginsData.getNextPageToken();
                            if (nextPageToken != null) {
                            }
                            nextPageToken = null;
                            objectRef.element = nextPageToken;
                            if (objectRef.element != null) {
                                str4 = str7;
                                collection = collection32;
                                Map createMapBuilder = MapsKt.createMapBuilder();
                                createMapBuilder.put("page_size", "50");
                                createMapBuilder.put("sort_by", "created_at");
                                createMapBuilder.put("sort_order", "desc");
                                str5 = (String) objectRef.element;
                                if (str5 != null) {
                                }
                                if (z) {
                                    if (str3 != null) {
                                    }
                                    if (str4 != null) {
                                        createMapBuilder.put("workspace_folder", str4);
                                    }
                                }
                                Map<String, String> build = MapsKt.build(createMapBuilder);
                                if (!z) {
                                    IPluginApi.Companion companion = IPluginApi.INSTANCE;
                                    pluginListCache$fetchAllInstalledPages$1.L$0 = str3;
                                    pluginListCache$fetchAllInstalledPages$1.L$1 = str4;
                                    pluginListCache$fetchAllInstalledPages$1.L$2 = collection;
                                    pluginListCache$fetchAllInstalledPages$1.L$3 = linkedHashSet;
                                    pluginListCache$fetchAllInstalledPages$1.L$4 = objectRef;
                                    pluginListCache$fetchAllInstalledPages$1.Z$0 = z;
                                    pluginListCache$fetchAllInstalledPages$1.label = 1;
                                    Object listLocalPlugins = companion.listLocalPlugins(build, pluginListCache$fetchAllInstalledPages$1);
                                    if (listLocalPlugins == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    str6 = str3;
                                    r13 = linkedHashSet;
                                    collection2 = collection;
                                    str7 = str4;
                                    httpDataResult = (HttpDataResult) listLocalPlugins;
                                    Collection collection322 = collection2;
                                    linkedHashSet = r13;
                                    str3 = str6;
                                    if (!(httpDataResult instanceof HttpDataResult.Success)) {
                                        if (!(httpDataResult instanceof HttpDataResult.Error)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        PluginTracker.INSTANCE.trackAuthFail("plugin_list", "fetch_installed_error");
                                    }
                                } else {
                                    IPluginApi.Companion companion2 = IPluginApi.INSTANCE;
                                    pluginListCache$fetchAllInstalledPages$1.L$0 = str3;
                                    pluginListCache$fetchAllInstalledPages$1.L$1 = str4;
                                    pluginListCache$fetchAllInstalledPages$1.L$2 = collection;
                                    pluginListCache$fetchAllInstalledPages$1.L$3 = linkedHashSet;
                                    pluginListCache$fetchAllInstalledPages$1.L$4 = objectRef;
                                    pluginListCache$fetchAllInstalledPages$1.Z$0 = z;
                                    pluginListCache$fetchAllInstalledPages$1.label = 2;
                                    Object listRemotePlugins = companion2.listRemotePlugins(build, pluginListCache$fetchAllInstalledPages$1);
                                    if (listRemotePlugins == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    str6 = str3;
                                    r13 = linkedHashSet;
                                    collection2 = collection;
                                    str7 = str4;
                                    obj = listRemotePlugins;
                                    httpDataResult = (HttpDataResult) obj;
                                    Collection collection3222 = collection2;
                                    linkedHashSet = r13;
                                    str3 = str6;
                                    if (!(httpDataResult instanceof HttpDataResult.Success)) {
                                    }
                                }
                            }
                        }
                    }
                    return collection3222;
                }
                ResultKt.throwOnFailure(obj);
                Collection collection4 = (List) new ArrayList();
                linkedHashSet = new LinkedHashSet();
                str3 = str;
                objectRef = new Ref.ObjectRef();
                collection = collection4;
                str4 = str2;
                Map createMapBuilder2 = MapsKt.createMapBuilder();
                createMapBuilder2.put("page_size", "50");
                createMapBuilder2.put("sort_by", "created_at");
                createMapBuilder2.put("sort_order", "desc");
                str5 = (String) objectRef.element;
                if (str5 != null) {
                }
                if (z) {
                }
                Map<String, String> build2 = MapsKt.build(createMapBuilder2);
                if (!z) {
                }
            }
        }
        pluginListCache$fetchAllInstalledPages$1 = new PluginListCache$fetchAllInstalledPages$1(this, continuation);
        Object obj2 = pluginListCache$fetchAllInstalledPages$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pluginListCache$fetchAllInstalledPages$1.label;
        if (i == 0) {
        }
    }

    private final List<PluginItem> mergePlugins(List<PluginItem> installed, Map<String, MarketplacePluginItem> marketplace) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : installed) {
            if (((PluginItem) obj).getEnabled()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (marketplace.isEmpty()) {
            return arrayList2;
        }
        ArrayList<PluginItem> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        for (PluginItem pluginItem : arrayList3) {
            MarketplacePluginItem marketplacePluginItem = marketplace.get(pluginItem.getName());
            if (marketplacePluginItem != null) {
                String pluginId = marketplacePluginItem.getPluginId();
                String name = marketplacePluginItem.getName();
                if (name == null) {
                    name = "";
                }
                pluginItem = pluginItem.copy((r32 & 1) != 0 ? pluginItem.pluginId : pluginId, (r32 & 2) != 0 ? pluginItem.name : name, (r32 & 4) != 0 ? pluginItem.originPluginName : null, (r32 & 8) != 0 ? pluginItem.dirName : null, (r32 & 16) != 0 ? pluginItem.displayName : MarketplacePluginItem.localizedDisplayName$default(marketplacePluginItem, null, 1, null), (r32 & 32) != 0 ? pluginItem.description : null, (r32 & 64) != 0 ? pluginItem.iconUrl : marketplacePluginItem.getIconUrl(), (r32 & 128) != 0 ? pluginItem.version : null, (r32 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? pluginItem.registry : null, (r32 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? pluginItem.marketplacePluginId : null, (r32 & 1024) != 0 ? pluginItem.enabled : false, (r32 & 2048) != 0 ? pluginItem.connectorJson : null, (r32 & 4096) != 0 ? pluginItem.disabledAbilities : null, (r32 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? pluginItem.createdAt : null, (r32 & 16384) != 0 ? pluginItem.updatedAt : null);
            }
            arrayList4.add(pluginItem);
        }
        return arrayList4;
    }

    private final boolean isFresh(long loadedAt, long ttl) {
        return loadedAt > 0 && System.currentTimeMillis() - loadedAt < ttl;
    }
}
