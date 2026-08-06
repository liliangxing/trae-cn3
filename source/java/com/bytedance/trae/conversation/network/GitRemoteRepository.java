package com.bytedance.trae.conversation.network;

import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.trae.conversation.git.GitConnectionState;
import com.bytedance.trae.conversation.network.IGetGitApi;
import com.bytedance.trae.login.bytecloud.BytecloudAuthManager;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: GitRemoteRepository.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 >2\u00020\u0001:\u0003=>?B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001cJ\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bJ\r\u0010\u001f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010 J4\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020\u000b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000bH\u0086@¢\u0006\u0002\u0010(J@\u0010)\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020\u000b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000bH\u0086@¢\u0006\u0002\u0010+JI\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0-2.\u0010.\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001000/\"\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000100H\u0002¢\u0006\u0002\u00101J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u00105J\u0016\u00106\u001a\u0002032\u0006\u0010*\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u00107J\u001c\u00108\u001a\b\u0012\u0004\u0012\u0002090\u00072\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bJ \u0010:\u001a\u0002032\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u000bH\u0086@¢\u0006\u0002\u0010;J,\u0010<\u001a\u0002032\b\u0010*\u001a\u0004\u0018\u00010\u000b2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010\u000bH\u0082@¢\u0006\u0002\u0010(R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006@"}, d2 = {"Lcom/bytedance/trae/conversation/network/GitRemoteRepository;", "", "<init>", "()V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "cachedRepos", "", "Lcom/bytedance/trae/conversation/network/GitRepository;", "cachedAllRepos", "nextPageToken", "", "total", "", "Ljava/lang/Long;", "preloaded", "", "branchCacheMap", "", "Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;", "_gitConnectionState", "Lcom/bytedance/trae/conversation/git/GitConnectionState;", "gitConnectionState", "getGitConnectionState", "()Lcom/bytedance/trae/conversation/git/GitConnectionState;", "reset", "", OauthTokenTriggerScene.PRELOAD, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedRepos", "getNextPageToken", "getTotal", "()Ljava/lang/Long;", "listBranches", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/conversation/network/ListBranchesData;", "repoUrl", "pageSize", "", "pageToken", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchBranches", "keyword", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildQuery", "", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Ljava/util/Map;", "fetchRepos", "Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;", "forceFetch", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchRepos", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchBranches", "Lcom/bytedance/trae/conversation/network/GitBranch;", "fetchReposPage", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listRepositoriesFromServer", "BranchCache", "Companion", "Result", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GitRemoteRepository {
    public static final long CODE_GIT_DISCONNECTED = 991402;
    public static final long CODE_GIT_TOKEN_EXPIRE = 991403;
    private static final int MAX_BRANCH_CACHE_SIZE = 50;
    private String nextPageToken;
    private boolean preloaded;
    private Long total;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<GitRemoteRepository> instance$delegate = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.network.GitRemoteRepository$$ExternalSyntheticLambda0
        public final Object invoke() {
            GitRemoteRepository instance_delegate$lambda$8;
            instance_delegate$lambda$8 = GitRemoteRepository.instance_delegate$lambda$8();
            return instance_delegate$lambda$8;
        }
    });
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);
    private List<GitRepository> cachedRepos = CollectionsKt.emptyList();
    private List<GitRepository> cachedAllRepos = CollectionsKt.emptyList();
    private final Map<String, BranchCache> branchCacheMap = new LinkedHashMap();
    private GitConnectionState _gitConnectionState = GitConnectionState.DISCONNECTED;

    private GitRemoteRepository() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GitRemoteRepository.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J@\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;", "", "branches", "", "Lcom/bytedance/trae/conversation/network/GitBranch;", "total", "", "nextPageToken", "", "isFull", "", "<init>", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Z)V", "getBranches", "()Ljava/util/List;", "getTotal", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNextPageToken", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Z)Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;", "equals", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class BranchCache {
        private final List<GitBranch> branches;
        private final boolean isFull;
        private final String nextPageToken;
        private final Long total;

        public BranchCache() {
            this(null, null, null, false, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BranchCache copy$default(BranchCache branchCache, List list, Long l, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                list = branchCache.branches;
            }
            if ((i & 2) != 0) {
                l = branchCache.total;
            }
            if ((i & 4) != 0) {
                str = branchCache.nextPageToken;
            }
            if ((i & 8) != 0) {
                z = branchCache.isFull;
            }
            return branchCache.copy(list, l, str, z);
        }

        public final List<GitBranch> component1() {
            return this.branches;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getTotal() {
            return this.total;
        }

        /* renamed from: component3, reason: from getter */
        public final String getNextPageToken() {
            return this.nextPageToken;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsFull() {
            return this.isFull;
        }

        public final BranchCache copy(List<GitBranch> branches, Long total, String nextPageToken, boolean isFull) {
            Intrinsics.checkNotNullParameter(branches, "branches");
            return new BranchCache(branches, total, nextPageToken, isFull);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BranchCache)) {
                return false;
            }
            BranchCache branchCache = (BranchCache) other;
            return Intrinsics.areEqual(this.branches, branchCache.branches) && Intrinsics.areEqual(this.total, branchCache.total) && Intrinsics.areEqual(this.nextPageToken, branchCache.nextPageToken) && this.isFull == branchCache.isFull;
        }

        public int hashCode() {
            int hashCode = this.branches.hashCode() * 31;
            Long l = this.total;
            int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
            String str = this.nextPageToken;
            return ((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.isFull);
        }

        public String toString() {
            return "BranchCache(branches=" + this.branches + ", total=" + this.total + ", nextPageToken=" + this.nextPageToken + ", isFull=" + this.isFull + ')';
        }

        public BranchCache(List<GitBranch> list, Long l, String str, boolean z) {
            Intrinsics.checkNotNullParameter(list, "branches");
            this.branches = list;
            this.total = l;
            this.nextPageToken = str;
            this.isFull = z;
        }

        public /* synthetic */ BranchCache(List list, Long l, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str, (i & 8) != 0 ? false : z);
        }

        public final List<GitBranch> getBranches() {
            return this.branches;
        }

        public final Long getTotal() {
            return this.total;
        }

        public final String getNextPageToken() {
            return this.nextPageToken;
        }

        public final boolean isFull() {
            return this.isFull;
        }
    }

    /* renamed from: getGitConnectionState, reason: from getter */
    public final GitConnectionState get_gitConnectionState() {
        return this._gitConnectionState;
    }

    /* compiled from: GitRemoteRepository.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;", "", "<init>", "()V", "CODE_GIT_DISCONNECTED", "", "CODE_GIT_TOKEN_EXPIRE", "MAX_BRANCH_CACHE_SIZE", "", "instance", "Lcom/bytedance/trae/conversation/network/GitRemoteRepository;", "getInstance", "()Lcom/bytedance/trae/conversation/network/GitRemoteRepository;", "instance$delegate", "Lkotlin/Lazy;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GitRemoteRepository getInstance() {
            return (GitRemoteRepository) GitRemoteRepository.instance$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GitRemoteRepository instance_delegate$lambda$8() {
        return new GitRemoteRepository();
    }

    /* compiled from: GitRemoteRepository.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003JX\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017¨\u0006'"}, d2 = {"Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;", "", "success", "", "items", "", "Lcom/bytedance/trae/conversation/network/GitRepository;", "total", "", "nextPageToken", "", AccountMonitorConstants.CommonParameter.ERROR, "errorMessage", "<init>", "(ZLjava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getSuccess", "()Z", "getItems", "()Ljava/util/List;", "getTotal", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNextPageToken", "()Ljava/lang/String;", "getErrorCode", "getErrorMessage", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZLjava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;", "equals", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Result {
        private final Long errorCode;
        private final String errorMessage;
        private final List<GitRepository> items;
        private final String nextPageToken;
        private final boolean success;
        private final Long total;

        public static /* synthetic */ Result copy$default(Result result, boolean z, List list, Long l, String str, Long l2, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = result.success;
            }
            if ((i & 2) != 0) {
                list = result.items;
            }
            List list2 = list;
            if ((i & 4) != 0) {
                l = result.total;
            }
            Long l3 = l;
            if ((i & 8) != 0) {
                str = result.nextPageToken;
            }
            String str3 = str;
            if ((i & 16) != 0) {
                l2 = result.errorCode;
            }
            Long l4 = l2;
            if ((i & 32) != 0) {
                str2 = result.errorMessage;
            }
            return result.copy(z, list2, l3, str3, l4, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getSuccess() {
            return this.success;
        }

        public final List<GitRepository> component2() {
            return this.items;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getTotal() {
            return this.total;
        }

        /* renamed from: component4, reason: from getter */
        public final String getNextPageToken() {
            return this.nextPageToken;
        }

        /* renamed from: component5, reason: from getter */
        public final Long getErrorCode() {
            return this.errorCode;
        }

        /* renamed from: component6, reason: from getter */
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final Result copy(boolean success, List<GitRepository> items, Long total, String nextPageToken, Long errorCode, String errorMessage) {
            Intrinsics.checkNotNullParameter(items, "items");
            return new Result(success, items, total, nextPageToken, errorCode, errorMessage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return this.success == result.success && Intrinsics.areEqual(this.items, result.items) && Intrinsics.areEqual(this.total, result.total) && Intrinsics.areEqual(this.nextPageToken, result.nextPageToken) && Intrinsics.areEqual(this.errorCode, result.errorCode) && Intrinsics.areEqual(this.errorMessage, result.errorMessage);
        }

        public int hashCode() {
            int hashCode = ((Boolean.hashCode(this.success) * 31) + this.items.hashCode()) * 31;
            Long l = this.total;
            int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
            String str = this.nextPageToken;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            Long l2 = this.errorCode;
            int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
            String str2 = this.errorMessage;
            return hashCode4 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Result(success=" + this.success + ", items=" + this.items + ", total=" + this.total + ", nextPageToken=" + this.nextPageToken + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ')';
        }

        public Result(boolean z, List<GitRepository> list, Long l, String str, Long l2, String str2) {
            Intrinsics.checkNotNullParameter(list, "items");
            this.success = z;
            this.items = list;
            this.total = l;
            this.nextPageToken = str;
            this.errorCode = l2;
            this.errorMessage = str2;
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public /* synthetic */ Result(boolean z, List list, Long l, String str, Long l2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? null : str2);
        }

        public final List<GitRepository> getItems() {
            return this.items;
        }

        public final Long getTotal() {
            return this.total;
        }

        public final String getNextPageToken() {
            return this.nextPageToken;
        }

        public final Long getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }
    }

    public final void reset() {
        this.cachedRepos = CollectionsKt.emptyList();
        this.cachedAllRepos = CollectionsKt.emptyList();
        this.nextPageToken = null;
        this.total = null;
        this.preloaded = false;
        this.branchCacheMap.clear();
        this._gitConnectionState = GitConnectionState.DISCONNECTED;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0088 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:12:0x0032, B:13:0x0080, B:15:0x0088, B:16:0x0090), top: B:11:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064 A[Catch: all -> 0x0098, TRY_LEAVE, TryCatch #1 {all -> 0x0098, blocks: (B:28:0x0060, B:30:0x0064, B:34:0x006c), top: B:27:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object preload(Continuation<? super Unit> continuation) {
        GitRemoteRepository$preload$1 gitRemoteRepository$preload$1;
        int i;
        Mutex mutex;
        GitRemoteRepository gitRemoteRepository;
        Mutex mutex2;
        Throwable th;
        GitRemoteRepository gitRemoteRepository2;
        Result result;
        try {
            if (continuation instanceof GitRemoteRepository$preload$1) {
                gitRemoteRepository$preload$1 = (GitRemoteRepository$preload$1) continuation;
                if ((gitRemoteRepository$preload$1.label & Integer.MIN_VALUE) != 0) {
                    gitRemoteRepository$preload$1.label -= Integer.MIN_VALUE;
                    Object obj = gitRemoteRepository$preload$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = gitRemoteRepository$preload$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mutex;
                        gitRemoteRepository$preload$1.L$0 = this;
                        gitRemoteRepository$preload$1.L$1 = mutex;
                        gitRemoteRepository$preload$1.label = 1;
                        if (mutex.lock((Object) null, gitRemoteRepository$preload$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        gitRemoteRepository = this;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutex2 = (Mutex) gitRemoteRepository$preload$1.L$1;
                            gitRemoteRepository2 = (GitRemoteRepository) gitRemoteRepository$preload$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                result = (Result) obj;
                                if (result.getSuccess()) {
                                    gitRemoteRepository2.cachedAllRepos = result.getItems();
                                    gitRemoteRepository2.preloaded = true;
                                }
                                Unit unit = Unit.INSTANCE;
                                mutex2.unlock((Object) null);
                                return Unit.INSTANCE;
                            } catch (Throwable th2) {
                                th = th2;
                                mutex2.unlock((Object) null);
                                throw th;
                            }
                        }
                        Mutex mutex3 = (Mutex) gitRemoteRepository$preload$1.L$1;
                        gitRemoteRepository = (GitRemoteRepository) gitRemoteRepository$preload$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex3;
                    }
                    if (gitRemoteRepository.preloaded) {
                        Integer boxInt = Boxing.boxInt(100);
                        gitRemoteRepository$preload$1.L$0 = gitRemoteRepository;
                        gitRemoteRepository$preload$1.L$1 = mutex;
                        gitRemoteRepository$preload$1.label = 2;
                        Object listRepositoriesFromServer = gitRemoteRepository.listRepositoriesFromServer(null, boxInt, null, gitRemoteRepository$preload$1);
                        if (listRepositoriesFromServer == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mutex2 = mutex;
                        obj = listRepositoriesFromServer;
                        gitRemoteRepository2 = gitRemoteRepository;
                        result = (Result) obj;
                        if (result.getSuccess()) {
                        }
                        Unit unit2 = Unit.INSTANCE;
                        mutex2.unlock((Object) null);
                        return Unit.INSTANCE;
                    }
                    Unit unit3 = Unit.INSTANCE;
                    mutex.unlock((Object) null);
                    return unit3;
                }
            }
            if (gitRemoteRepository.preloaded) {
            }
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock((Object) null);
            throw th;
        }
        gitRemoteRepository$preload$1 = new GitRemoteRepository$preload$1(this, continuation);
        Object obj2 = gitRemoteRepository$preload$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = gitRemoteRepository$preload$1.label;
        if (i != 0) {
        }
    }

    public final List<GitRepository> getCachedRepos() {
        return this.cachedRepos;
    }

    public final String getNextPageToken() {
        return this.nextPageToken;
    }

    public final Long getTotal() {
        return this.total;
    }

    public static /* synthetic */ Object listBranches$default(GitRemoteRepository gitRemoteRepository, String str, Integer num, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return gitRemoteRepository.listBranches(str, num, str2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object listBranches(String str, Integer num, String str2, Continuation<? super HttpDataResult<ListBranchesData>> continuation) {
        GitRemoteRepository$listBranches$1 gitRemoteRepository$listBranches$1;
        int i;
        int i2;
        Object safeCall;
        GitRemoteRepository gitRemoteRepository;
        String nextPageToken;
        String nextPageToken2;
        HttpDataResult.Success success;
        ListBranchesData listBranchesData;
        String str3 = str;
        if (continuation instanceof GitRemoteRepository$listBranches$1) {
            gitRemoteRepository$listBranches$1 = (GitRemoteRepository$listBranches$1) continuation;
            if ((gitRemoteRepository$listBranches$1.label & Integer.MIN_VALUE) != 0) {
                gitRemoteRepository$listBranches$1.label -= Integer.MIN_VALUE;
                Object obj = gitRemoteRepository$listBranches$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = gitRemoteRepository$listBranches$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String str4 = str2;
                    i2 = (str4 == null || StringsKt.isBlank(str4)) ? 1 : 0;
                    BranchCache branchCache = this.branchCacheMap.get(str3);
                    if (branchCache != null) {
                        if (i2 != 0) {
                            List take = CollectionsKt.take(branchCache.getBranches(), num != null ? num.intValue() : branchCache.getBranches().size());
                            if (take.size() < branchCache.getBranches().size()) {
                                nextPageToken2 = branchCache.getNextPageToken();
                                if (nextPageToken2 == null) {
                                    nextPageToken2 = String.valueOf(take.size());
                                }
                            } else {
                                nextPageToken2 = branchCache.getNextPageToken();
                            }
                            return new HttpDataResult.Success(new BizResponse(0L, (String) null, (String) null, (String) null, new ListBranchesData(take, branchCache.getTotal(), nextPageToken2), (String) null, 44, (DefaultConstructorMarker) null), (Throwable) null);
                        }
                        if (!branchCache.isFull()) {
                            Integer intOrNull = str2 != null ? StringsKt.toIntOrNull(str2) : null;
                            if (intOrNull != null && intOrNull.intValue() < branchCache.getBranches().size()) {
                                List take2 = CollectionsKt.take(CollectionsKt.drop(branchCache.getBranches(), intOrNull.intValue()), num != null ? num.intValue() : branchCache.getBranches().size() - intOrNull.intValue());
                                int intValue = intOrNull.intValue() + take2.size();
                                if (intValue < branchCache.getBranches().size()) {
                                    nextPageToken = String.valueOf(intValue);
                                } else {
                                    nextPageToken = branchCache.getNextPageToken();
                                }
                                return new HttpDataResult.Success(new BizResponse(0L, (String) null, (String) null, (String) null, new ListBranchesData(take2, branchCache.getTotal(), nextPageToken), (String) null, 44, (DefaultConstructorMarker) null), (Throwable) null);
                            }
                        }
                    }
                    Map<String, String> buildQuery = buildQuery(TuplesKt.to("repo_url", str3), TuplesKt.to("page_size", num), TuplesKt.to("page_token", str2 != null ? str2 : "1"));
                    IGetGitApi.Companion companion = IGetGitApi.INSTANCE;
                    Map<String, String> emptyMap = MapsKt.emptyMap();
                    GitRemoteRepository$listBranches$result$1 gitRemoteRepository$listBranches$result$1 = new GitRemoteRepository$listBranches$result$1(buildQuery, null);
                    gitRemoteRepository$listBranches$1.L$0 = this;
                    gitRemoteRepository$listBranches$1.L$1 = str3;
                    gitRemoteRepository$listBranches$1.I$0 = i2;
                    gitRemoteRepository$listBranches$1.label = 1;
                    safeCall = companion.safeCall(emptyMap, gitRemoteRepository$listBranches$result$1, gitRemoteRepository$listBranches$1);
                    if (safeCall == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    gitRemoteRepository = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i3 = gitRemoteRepository$listBranches$1.I$0;
                    String str5 = (String) gitRemoteRepository$listBranches$1.L$1;
                    gitRemoteRepository = (GitRemoteRepository) gitRemoteRepository$listBranches$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    i2 = i3;
                    str3 = str5;
                    safeCall = obj;
                }
                success = (HttpDataResult) safeCall;
                if (success instanceof HttpDataResult.Success) {
                    HttpDataResult.Success success2 = success;
                    if (success2.getBizResp().isSuccess() && (listBranchesData = (ListBranchesData) success2.getBizResp().getData()) != null) {
                        List<GitBranch> items = listBranchesData.getItems();
                        if (items == null) {
                            items = CollectionsKt.emptyList();
                        }
                        BranchCache branchCache2 = gitRemoteRepository.branchCacheMap.get(str3);
                        if (i2 != 0) {
                            if (items.size() <= 50) {
                                Map<String, BranchCache> map = gitRemoteRepository.branchCacheMap;
                                Long total = listBranchesData.getTotal();
                                String nextPageToken3 = listBranchesData.getNextPageToken();
                                String nextPageToken4 = listBranchesData.getNextPageToken();
                                map.put(str3, new BranchCache(items, total, nextPageToken3, nextPageToken4 == null || nextPageToken4.length() == 0));
                            }
                        } else if (branchCache2 != null && !branchCache2.isFull()) {
                            List plus = CollectionsKt.plus(branchCache2.getBranches(), items);
                            if (plus.size() <= 50) {
                                Map<String, BranchCache> map2 = gitRemoteRepository.branchCacheMap;
                                String nextPageToken5 = listBranchesData.getNextPageToken();
                                String nextPageToken6 = listBranchesData.getNextPageToken();
                                map2.put(str3, BranchCache.copy$default(branchCache2, plus, null, nextPageToken5, nextPageToken6 == null || nextPageToken6.length() == 0, 2, null));
                            } else {
                                gitRemoteRepository.branchCacheMap.put(str3, BranchCache.copy$default(branchCache2, CollectionsKt.take(plus, 50), null, listBranchesData.getNextPageToken(), true, 2, null));
                            }
                        }
                    }
                }
                return success;
            }
        }
        gitRemoteRepository$listBranches$1 = new GitRemoteRepository$listBranches$1(this, continuation);
        Object obj2 = gitRemoteRepository$listBranches$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = gitRemoteRepository$listBranches$1.label;
        if (i != 0) {
        }
        success = (HttpDataResult) safeCall;
        if (success instanceof HttpDataResult.Success) {
        }
        return success;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchBranches(String str, String str2, Integer num, String str3, Continuation<? super HttpDataResult<ListBranchesData>> continuation) {
        GitRemoteRepository$fetchBranches$1 gitRemoteRepository$fetchBranches$1;
        int i;
        int i2;
        Map<String, String> buildQuery;
        Object safeCall;
        GitRemoteRepository gitRemoteRepository;
        HttpDataResult.Success success;
        String str4;
        HttpDataResult.Success success2;
        ListBranchesData listBranchesData;
        List<GitBranch> items;
        String str5 = str;
        String str6 = str2;
        if (continuation instanceof GitRemoteRepository$fetchBranches$1) {
            gitRemoteRepository$fetchBranches$1 = (GitRemoteRepository$fetchBranches$1) continuation;
            if ((gitRemoteRepository$fetchBranches$1.label & Integer.MIN_VALUE) != 0) {
                gitRemoteRepository$fetchBranches$1.label -= Integer.MIN_VALUE;
                Object obj = gitRemoteRepository$fetchBranches$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = gitRemoteRepository$fetchBranches$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String str7 = str3;
                    i2 = (str7 == null || StringsKt.isBlank(str7)) ? 1 : 0;
                    String str8 = str3 != null ? str3 : "1";
                    if (BytecloudAuthManager.INSTANCE.isBytecloudLogin()) {
                        buildQuery = buildQuery(TuplesKt.to("repo_url", str5), TuplesKt.to("keyword", str6), TuplesKt.to("page_size", num), TuplesKt.to("page_token", str8));
                    } else {
                        buildQuery = buildQuery(TuplesKt.to("repo_url", str5), TuplesKt.to("keyword", str6), TuplesKt.to("page_size", num));
                    }
                    IGetGitApi.Companion companion = IGetGitApi.INSTANCE;
                    Map<String, String> emptyMap = MapsKt.emptyMap();
                    GitRemoteRepository$fetchBranches$result$1 gitRemoteRepository$fetchBranches$result$1 = new GitRemoteRepository$fetchBranches$result$1(buildQuery, null);
                    gitRemoteRepository$fetchBranches$1.L$0 = this;
                    gitRemoteRepository$fetchBranches$1.L$1 = str5;
                    gitRemoteRepository$fetchBranches$1.L$2 = str6;
                    gitRemoteRepository$fetchBranches$1.I$0 = i2;
                    gitRemoteRepository$fetchBranches$1.label = 1;
                    safeCall = companion.safeCall(emptyMap, gitRemoteRepository$fetchBranches$result$1, gitRemoteRepository$fetchBranches$1);
                    if (safeCall == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    gitRemoteRepository = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i3 = gitRemoteRepository$fetchBranches$1.I$0;
                    str6 = (String) gitRemoteRepository$fetchBranches$1.L$2;
                    String str9 = (String) gitRemoteRepository$fetchBranches$1.L$1;
                    gitRemoteRepository = (GitRemoteRepository) gitRemoteRepository$fetchBranches$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    i2 = i3;
                    str5 = str9;
                    safeCall = obj;
                }
                success = (HttpDataResult) safeCall;
                str4 = str6;
                if (!(str4 != null || str4.length() == 0) && (success instanceof HttpDataResult.Success)) {
                    success2 = success;
                    if (success2.getBizResp().isSuccess() && (listBranchesData = (ListBranchesData) success2.getBizResp().getData()) != null) {
                        items = listBranchesData.getItems();
                        if (items == null) {
                            items = CollectionsKt.emptyList();
                        }
                        BranchCache branchCache = gitRemoteRepository.branchCacheMap.get(str5);
                        if (i2 == 0) {
                            if (items.size() <= 50) {
                                Map<String, BranchCache> map = gitRemoteRepository.branchCacheMap;
                                Long total = listBranchesData.getTotal();
                                String nextPageToken = listBranchesData.getNextPageToken();
                                String nextPageToken2 = listBranchesData.getNextPageToken();
                                map.put(str5, new BranchCache(items, total, nextPageToken, nextPageToken2 == null || nextPageToken2.length() == 0));
                            }
                        } else if (branchCache != null && !branchCache.isFull()) {
                            List plus = CollectionsKt.plus(branchCache.getBranches(), items);
                            if (plus.size() <= 50) {
                                Map<String, BranchCache> map2 = gitRemoteRepository.branchCacheMap;
                                String nextPageToken3 = listBranchesData.getNextPageToken();
                                String nextPageToken4 = listBranchesData.getNextPageToken();
                                map2.put(str5, BranchCache.copy$default(branchCache, plus, null, nextPageToken3, nextPageToken4 == null || nextPageToken4.length() == 0, 2, null));
                            } else {
                                gitRemoteRepository.branchCacheMap.put(str5, BranchCache.copy$default(branchCache, CollectionsKt.take(plus, 50), null, listBranchesData.getNextPageToken(), true, 2, null));
                            }
                        }
                    }
                }
                return success;
            }
        }
        gitRemoteRepository$fetchBranches$1 = new GitRemoteRepository$fetchBranches$1(this, continuation);
        Object obj2 = gitRemoteRepository$fetchBranches$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = gitRemoteRepository$fetchBranches$1.label;
        if (i != 0) {
        }
        success = (HttpDataResult) safeCall;
        str4 = str6;
        if (!(str4 != null || str4.length() == 0)) {
            return success;
        }
        success2 = success;
        if (success2.getBizResp().isSuccess()) {
            items = listBranchesData.getItems();
            if (items == null) {
            }
            BranchCache branchCache2 = gitRemoteRepository.branchCacheMap.get(str5);
            if (i2 == 0) {
            }
        }
        return success;
    }

    private final Map<String, String> buildQuery(Pair<String, ? extends Object>... pairs) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair<String, ? extends Object> pair : pairs) {
            String str = (String) pair.component1();
            Object component2 = pair.component2();
            if (component2 != null) {
                linkedHashMap.put(str, component2.toString());
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a9, code lost:
    
        if (r4.longValue() != com.bytedance.trae.conversation.network.GitRemoteRepository.CODE_GIT_DISCONNECTED) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0099 A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:12:0x0036, B:13:0x0091, B:15:0x0099, B:18:0x00ab, B:21:0x00be, B:22:0x00c9, B:26:0x00b2, B:29:0x00c1, B:30:0x00a0, B:32:0x00cc, B:33:0x00d3), top: B:11:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cc A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:12:0x0036, B:13:0x0091, B:15:0x0099, B:18:0x00ab, B:21:0x00be, B:22:0x00c9, B:26:0x00b2, B:29:0x00c1, B:30:0x00a0, B:32:0x00cc, B:33:0x00d3), top: B:11:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchRepos(boolean z, Continuation<? super Result> continuation) {
        GitRemoteRepository$fetchRepos$1 gitRemoteRepository$fetchRepos$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        boolean z2;
        Mutex mutex;
        GitRemoteRepository gitRemoteRepository;
        Mutex mutex2;
        GitRemoteRepository gitRemoteRepository2;
        List<GitRepository> list;
        Result result;
        GitConnectionState gitConnectionState;
        try {
            if (continuation instanceof GitRemoteRepository$fetchRepos$1) {
                gitRemoteRepository$fetchRepos$1 = (GitRemoteRepository$fetchRepos$1) continuation;
                if ((gitRemoteRepository$fetchRepos$1.label & Integer.MIN_VALUE) != 0) {
                    gitRemoteRepository$fetchRepos$1.label -= Integer.MIN_VALUE;
                    obj = gitRemoteRepository$fetchRepos$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = gitRemoteRepository$fetchRepos$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex3 = this.mutex;
                        gitRemoteRepository$fetchRepos$1.L$0 = this;
                        gitRemoteRepository$fetchRepos$1.L$1 = mutex3;
                        z2 = z;
                        gitRemoteRepository$fetchRepos$1.Z$0 = z2;
                        gitRemoteRepository$fetchRepos$1.label = 1;
                        if (mutex3.lock((Object) null, gitRemoteRepository$fetchRepos$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mutex = mutex3;
                        gitRemoteRepository = this;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutex2 = (Mutex) gitRemoteRepository$fetchRepos$1.L$1;
                            gitRemoteRepository2 = (GitRemoteRepository) gitRemoteRepository$fetchRepos$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                result = (Result) obj;
                                if (result.getSuccess()) {
                                    Long errorCode = result.getErrorCode();
                                    if (errorCode != null) {
                                    }
                                    Long errorCode2 = result.getErrorCode();
                                    if (errorCode2 != null && errorCode2.longValue() == CODE_GIT_TOKEN_EXPIRE) {
                                        gitRemoteRepository2.cachedAllRepos = CollectionsKt.emptyList();
                                        gitConnectionState = GitConnectionState.DISCONNECTED;
                                        gitRemoteRepository2._gitConnectionState = gitConnectionState;
                                        mutex2.unlock((Object) null);
                                        return result;
                                    }
                                    gitConnectionState = GitConnectionState.ERROR;
                                    gitRemoteRepository2._gitConnectionState = gitConnectionState;
                                    mutex2.unlock((Object) null);
                                    return result;
                                }
                                list = result.getItems();
                                gitRemoteRepository2.cachedAllRepos = list;
                                gitRemoteRepository = gitRemoteRepository2;
                                gitRemoteRepository.cachedRepos = list;
                                gitRemoteRepository.nextPageToken = null;
                                gitRemoteRepository.total = Boxing.boxLong(list.size());
                                gitRemoteRepository._gitConnectionState = GitConnectionState.CONNECTED;
                                result = new Result(true, gitRemoteRepository.cachedRepos, gitRemoteRepository.total, null, null, null, 48, null);
                                mutex2.unlock((Object) null);
                                return result;
                            } catch (Throwable th) {
                                th = th;
                                mutex2.unlock((Object) null);
                                throw th;
                            }
                        }
                        z2 = gitRemoteRepository$fetchRepos$1.Z$0;
                        mutex = (Mutex) gitRemoteRepository$fetchRepos$1.L$1;
                        gitRemoteRepository = (GitRemoteRepository) gitRemoteRepository$fetchRepos$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    if (!(!gitRemoteRepository.cachedAllRepos.isEmpty()) && !z2) {
                        list = gitRemoteRepository.cachedAllRepos;
                        mutex2 = mutex;
                        gitRemoteRepository.cachedRepos = list;
                        gitRemoteRepository.nextPageToken = null;
                        gitRemoteRepository.total = Boxing.boxLong(list.size());
                        gitRemoteRepository._gitConnectionState = GitConnectionState.CONNECTED;
                        result = new Result(true, gitRemoteRepository.cachedRepos, gitRemoteRepository.total, null, null, null, 48, null);
                        mutex2.unlock((Object) null);
                        return result;
                    }
                    Integer boxInt = Boxing.boxInt(100);
                    gitRemoteRepository$fetchRepos$1.L$0 = gitRemoteRepository;
                    gitRemoteRepository$fetchRepos$1.L$1 = mutex;
                    gitRemoteRepository$fetchRepos$1.label = 2;
                    obj = gitRemoteRepository.listRepositoriesFromServer(null, boxInt, null, gitRemoteRepository$fetchRepos$1);
                    if (obj != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutex2 = mutex;
                    gitRemoteRepository2 = gitRemoteRepository;
                    result = (Result) obj;
                    if (result.getSuccess()) {
                    }
                }
            }
            if (!(!gitRemoteRepository.cachedAllRepos.isEmpty())) {
            }
            Integer boxInt2 = Boxing.boxInt(100);
            gitRemoteRepository$fetchRepos$1.L$0 = gitRemoteRepository;
            gitRemoteRepository$fetchRepos$1.L$1 = mutex;
            gitRemoteRepository$fetchRepos$1.label = 2;
            obj = gitRemoteRepository.listRepositoriesFromServer(null, boxInt2, null, gitRemoteRepository$fetchRepos$1);
            if (obj != coroutine_suspended) {
            }
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutex;
            mutex2.unlock((Object) null);
            throw th;
        }
        gitRemoteRepository$fetchRepos$1 = new GitRemoteRepository$fetchRepos$1(this, continuation);
        obj = gitRemoteRepository$fetchRepos$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = gitRemoteRepository$fetchRepos$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0079 A[Catch: all -> 0x0130, TRY_LEAVE, TryCatch #0 {all -> 0x0130, blocks: (B:26:0x0071, B:28:0x0079, B:32:0x0094, B:36:0x00b6, B:38:0x0114, B:39:0x00ba, B:40:0x00c9, B:42:0x00cf, B:44:0x00ee, B:50:0x010c, B:56:0x0110), top: B:25:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0094 A[Catch: all -> 0x0130, TRY_ENTER, TryCatch #0 {all -> 0x0130, blocks: (B:26:0x0071, B:28:0x0079, B:32:0x0094, B:36:0x00b6, B:38:0x0114, B:39:0x00ba, B:40:0x00c9, B:42:0x00cf, B:44:0x00ee, B:50:0x010c, B:56:0x0110), top: B:25:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object searchRepos(String str, Continuation<? super Result> continuation) {
        GitRemoteRepository$searchRepos$1 gitRemoteRepository$searchRepos$1;
        int i;
        String str2;
        Mutex mutex;
        GitRemoteRepository gitRemoteRepository;
        Mutex mutex2;
        ArrayList arrayList;
        boolean z;
        Result result;
        try {
            if (continuation instanceof GitRemoteRepository$searchRepos$1) {
                gitRemoteRepository$searchRepos$1 = (GitRemoteRepository$searchRepos$1) continuation;
                if ((gitRemoteRepository$searchRepos$1.label & Integer.MIN_VALUE) != 0) {
                    gitRemoteRepository$searchRepos$1.label -= Integer.MIN_VALUE;
                    Object obj = gitRemoteRepository$searchRepos$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = gitRemoteRepository$searchRepos$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex3 = this.mutex;
                        gitRemoteRepository$searchRepos$1.L$0 = this;
                        str2 = str;
                        gitRemoteRepository$searchRepos$1.L$1 = str2;
                        gitRemoteRepository$searchRepos$1.L$2 = mutex3;
                        gitRemoteRepository$searchRepos$1.label = 1;
                        if (mutex3.lock((Object) null, gitRemoteRepository$searchRepos$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mutex = mutex3;
                        gitRemoteRepository = this;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutex2 = (Mutex) gitRemoteRepository$searchRepos$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                result = (Result) obj;
                                mutex = mutex2;
                                mutex.unlock((Object) null);
                                return result;
                            } catch (Throwable th) {
                                th = th;
                                mutex2.unlock((Object) null);
                                throw th;
                            }
                        }
                        Mutex mutex4 = (Mutex) gitRemoteRepository$searchRepos$1.L$2;
                        String str3 = (String) gitRemoteRepository$searchRepos$1.L$1;
                        gitRemoteRepository = (GitRemoteRepository) gitRemoteRepository$searchRepos$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex4;
                        str2 = str3;
                    }
                    if (!BytecloudAuthManager.INSTANCE.isBytecloudLogin()) {
                        Integer boxInt = Boxing.boxInt(100);
                        gitRemoteRepository$searchRepos$1.L$0 = mutex;
                        gitRemoteRepository$searchRepos$1.L$1 = null;
                        gitRemoteRepository$searchRepos$1.L$2 = null;
                        gitRemoteRepository$searchRepos$1.label = 2;
                        obj = gitRemoteRepository.listRepositoriesFromServer(str2, boxInt, null, gitRemoteRepository$searchRepos$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mutex2 = mutex;
                        result = (Result) obj;
                        mutex = mutex2;
                        mutex.unlock((Object) null);
                        return result;
                    }
                    String lowerCase = StringsKt.trim(str2).toString().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (lowerCase.length() == 0) {
                        arrayList = gitRemoteRepository.cachedAllRepos;
                    } else {
                        List<GitRepository> list = gitRemoteRepository.cachedAllRepos;
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj2 : list) {
                            GitRepository gitRepository = (GitRepository) obj2;
                            String lowerCase2 = gitRepository.getName().toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                            if (!StringsKt.contains$default(lowerCase2, lowerCase, false, 2, (Object) null)) {
                                String lowerCase3 = gitRepository.getFullName().toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                if (!StringsKt.contains$default(lowerCase3, lowerCase, false, 2, (Object) null)) {
                                    z = false;
                                    if (!z) {
                                        arrayList2.add(obj2);
                                    }
                                }
                            }
                            z = true;
                            if (!z) {
                            }
                        }
                        arrayList = arrayList2;
                    }
                    result = new Result(true, arrayList, Boxing.boxLong(r12.size()), null, null, null, 48, null);
                    mutex.unlock((Object) null);
                    return result;
                }
            }
            if (!BytecloudAuthManager.INSTANCE.isBytecloudLogin()) {
            }
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutex;
            mutex2.unlock((Object) null);
            throw th;
        }
        gitRemoteRepository$searchRepos$1 = new GitRemoteRepository$searchRepos$1(this, continuation);
        Object obj3 = gitRemoteRepository$searchRepos$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = gitRemoteRepository$searchRepos$1.label;
        if (i != 0) {
        }
    }

    public final List<GitBranch> searchBranches(String repoUrl, String keyword) {
        Intrinsics.checkNotNullParameter(repoUrl, "repoUrl");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        BranchCache branchCache = this.branchCacheMap.get(repoUrl);
        if (branchCache == null) {
            return CollectionsKt.emptyList();
        }
        String lowerCase = StringsKt.trim(keyword).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str = lowerCase;
        if (str.length() == 0) {
            return branchCache.getBranches();
        }
        List<GitBranch> branches = branchCache.getBranches();
        ArrayList arrayList = new ArrayList();
        for (Object obj : branches) {
            String lowerCase2 = ((GitBranch) obj).getName().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (StringsKt.contains$default(lowerCase2, str, false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d0, code lost:
    
        if (r9.longValue() == com.bytedance.trae.conversation.network.GitRemoteRepository.CODE_GIT_DISCONNECTED) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c0 A[Catch: all -> 0x003a, TryCatch #1 {all -> 0x003a, blocks: (B:12:0x0036, B:13:0x0086, B:16:0x0090, B:17:0x00af, B:21:0x009d, B:22:0x00c0, B:25:0x00d2, B:28:0x00e5, B:29:0x00ea, B:30:0x00d9, B:33:0x00e8, B:34:0x00c7), top: B:11:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchReposPage(int i, String str, Continuation<? super Result> continuation) {
        GitRemoteRepository$fetchReposPage$1 gitRemoteRepository$fetchReposPage$1;
        Object obj;
        Object coroutine_suspended;
        int i2;
        GitRemoteRepository gitRemoteRepository;
        String str2;
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        String str3;
        GitRemoteRepository gitRemoteRepository2;
        Result result;
        GitConnectionState gitConnectionState;
        try {
            if (continuation instanceof GitRemoteRepository$fetchReposPage$1) {
                gitRemoteRepository$fetchReposPage$1 = (GitRemoteRepository$fetchReposPage$1) continuation;
                if ((gitRemoteRepository$fetchReposPage$1.label & Integer.MIN_VALUE) != 0) {
                    gitRemoteRepository$fetchReposPage$1.label -= Integer.MIN_VALUE;
                    obj = gitRemoteRepository$fetchReposPage$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i2 = gitRemoteRepository$fetchReposPage$1.label;
                    if (i2 != 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex3 = this.mutex;
                        gitRemoteRepository$fetchReposPage$1.L$0 = this;
                        gitRemoteRepository$fetchReposPage$1.L$1 = str;
                        gitRemoteRepository$fetchReposPage$1.L$2 = mutex3;
                        gitRemoteRepository$fetchReposPage$1.I$0 = i;
                        gitRemoteRepository$fetchReposPage$1.label = 1;
                        if (mutex3.lock((Object) null, gitRemoteRepository$fetchReposPage$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        gitRemoteRepository = this;
                        str2 = str;
                        mutex = mutex3;
                    } else {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutex2 = (Mutex) gitRemoteRepository$fetchReposPage$1.L$2;
                            str3 = (String) gitRemoteRepository$fetchReposPage$1.L$1;
                            gitRemoteRepository2 = (GitRemoteRepository) gitRemoteRepository$fetchReposPage$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                result = (Result) obj;
                                if (!result.getSuccess()) {
                                    if (str3 == null) {
                                        gitRemoteRepository2.cachedAllRepos = result.getItems();
                                        gitRemoteRepository2.cachedRepos = result.getItems();
                                    } else {
                                        List<GitRepository> plus = CollectionsKt.plus(gitRemoteRepository2.cachedAllRepos, result.getItems());
                                        gitRemoteRepository2.cachedAllRepos = plus;
                                        gitRemoteRepository2.cachedRepos = plus;
                                    }
                                    gitRemoteRepository2.nextPageToken = result.getNextPageToken();
                                    gitRemoteRepository2.total = result.getTotal();
                                    gitRemoteRepository2._gitConnectionState = GitConnectionState.CONNECTED;
                                } else {
                                    Long errorCode = result.getErrorCode();
                                    if (errorCode != null) {
                                    }
                                    Long errorCode2 = result.getErrorCode();
                                    if (errorCode2 != null && errorCode2.longValue() == CODE_GIT_TOKEN_EXPIRE) {
                                        gitConnectionState = GitConnectionState.DISCONNECTED;
                                        gitRemoteRepository2._gitConnectionState = gitConnectionState;
                                    }
                                    gitConnectionState = GitConnectionState.ERROR;
                                    gitRemoteRepository2._gitConnectionState = gitConnectionState;
                                }
                                mutex2.unlock((Object) null);
                                return result;
                            } catch (Throwable th2) {
                                th = th2;
                                mutex2.unlock((Object) null);
                                throw th;
                            }
                        }
                        i = gitRemoteRepository$fetchReposPage$1.I$0;
                        mutex = (Mutex) gitRemoteRepository$fetchReposPage$1.L$2;
                        str2 = (String) gitRemoteRepository$fetchReposPage$1.L$1;
                        gitRemoteRepository = (GitRemoteRepository) gitRemoteRepository$fetchReposPage$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    Integer boxInt = Boxing.boxInt(i);
                    gitRemoteRepository$fetchReposPage$1.L$0 = gitRemoteRepository;
                    gitRemoteRepository$fetchReposPage$1.L$1 = str2;
                    gitRemoteRepository$fetchReposPage$1.L$2 = mutex;
                    gitRemoteRepository$fetchReposPage$1.label = 2;
                    obj = gitRemoteRepository.listRepositoriesFromServer(null, boxInt, str2, gitRemoteRepository$fetchReposPage$1);
                    if (obj != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutex2 = mutex;
                    str3 = str2;
                    gitRemoteRepository2 = gitRemoteRepository;
                    result = (Result) obj;
                    if (!result.getSuccess()) {
                    }
                    mutex2.unlock((Object) null);
                    return result;
                }
            }
            Integer boxInt2 = Boxing.boxInt(i);
            gitRemoteRepository$fetchReposPage$1.L$0 = gitRemoteRepository;
            gitRemoteRepository$fetchReposPage$1.L$1 = str2;
            gitRemoteRepository$fetchReposPage$1.L$2 = mutex;
            gitRemoteRepository$fetchReposPage$1.label = 2;
            obj = gitRemoteRepository.listRepositoriesFromServer(null, boxInt2, str2, gitRemoteRepository$fetchReposPage$1);
            if (obj != coroutine_suspended) {
            }
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock((Object) null);
            throw th;
        }
        gitRemoteRepository$fetchReposPage$1 = new GitRemoteRepository$fetchReposPage$1(this, continuation);
        obj = gitRemoteRepository$fetchReposPage$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = gitRemoteRepository$fetchReposPage$1.label;
        if (i2 != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object listRepositoriesFromServer(String str, Integer num, String str2, Continuation<? super Result> continuation) {
        GitRemoteRepository$listRepositoriesFromServer$1 gitRemoteRepository$listRepositoriesFromServer$1;
        int i;
        HttpDataResult.Success success;
        String str3;
        if (continuation instanceof GitRemoteRepository$listRepositoriesFromServer$1) {
            gitRemoteRepository$listRepositoriesFromServer$1 = (GitRemoteRepository$listRepositoriesFromServer$1) continuation;
            if ((gitRemoteRepository$listRepositoriesFromServer$1.label & Integer.MIN_VALUE) != 0) {
                gitRemoteRepository$listRepositoriesFromServer$1.label -= Integer.MIN_VALUE;
                Object obj = gitRemoteRepository$listRepositoriesFromServer$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = gitRemoteRepository$listRepositoriesFromServer$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    HashMap hashMap = new HashMap();
                    hashMap.put("page_size", String.valueOf(num));
                    if (str2 != null) {
                        hashMap.put("page_token", str2);
                    }
                    String str4 = str;
                    if (!(str4 == null || StringsKt.isBlank(str4))) {
                        hashMap.put("keyword", StringsKt.trim(str4).toString());
                    }
                    IGetGitApi.Companion companion = IGetGitApi.INSTANCE;
                    gitRemoteRepository$listRepositoriesFromServer$1.label = 1;
                    obj = companion.listRepositoriesRawCall(hashMap, gitRemoteRepository$listRepositoriesFromServer$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                success = (HttpDataResult) obj;
                if (!(success instanceof HttpDataResult.Success)) {
                    BizResponse bizResp = success.getBizResp();
                    if (!bizResp.isSuccess()) {
                        boolean z = false;
                        List list = null;
                        Long l = null;
                        String str5 = null;
                        Long boxLong = Boxing.boxLong(bizResp.getCode());
                        String msg = bizResp.getMsg();
                        if (msg == null) {
                            String message = bizResp.getMessage();
                            str3 = message == null ? "获取仓库列表失败" : message;
                        } else {
                            str3 = msg;
                        }
                        return new Result(z, list, l, str5, boxLong, str3, 14, null);
                    }
                    ListRepositoriesData listRepositoriesData = (ListRepositoriesData) bizResp.getData();
                    boolean z2 = true;
                    List<GitRepository> items = listRepositoriesData != null ? listRepositoriesData.getItems() : null;
                    if (items == null) {
                        items = CollectionsKt.emptyList();
                    }
                    return new Result(z2, items, listRepositoriesData != null ? listRepositoriesData.getTotal() : null, listRepositoriesData != null ? listRepositoriesData.getNextPageToken() : null, null, null, 48, null);
                }
                if (!(success instanceof HttpDataResult.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                List list2 = null;
                Long l2 = null;
                String str6 = null;
                Long boxLong2 = Boxing.boxLong(r1.getCode());
                String msg2 = ((HttpDataResult.Error) success).getMsg();
                return new Result(false, list2, l2, str6, boxLong2, msg2.length() == 0 ? "获取仓库列表失败" : msg2, 14, null);
            }
        }
        gitRemoteRepository$listRepositoriesFromServer$1 = new GitRemoteRepository$listRepositoriesFromServer$1(this, continuation);
        Object obj2 = gitRemoteRepository$listRepositoriesFromServer$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = gitRemoteRepository$listRepositoriesFromServer$1.label;
        if (i != 0) {
        }
        success = (HttpDataResult) obj2;
        if (!(success instanceof HttpDataResult.Success)) {
        }
    }
}
