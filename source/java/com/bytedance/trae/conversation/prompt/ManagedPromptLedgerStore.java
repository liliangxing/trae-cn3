package com.bytedance.trae.conversation.prompt;

import com.bytedance.keva.Keva;
import com.bytedance.sync.interfaze.IFileDataCacheService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ManagedPromptLedger.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J \u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017J*\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00052\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170\u001a2\u0006\u0010\u001b\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\rJ\b\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;", "", "<init>", "()V", "REPO_NAME", "", "ACCOUNT_KEY_PREFIX", "ledger", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;", IFileDataCacheService.TYPE_SNAPSHOT, "Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;", "userId", "recordShown", "", "candidate", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;", "shownAtMillis", "", "savePendingBilling", "pending", "Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;", "clearPendingBilling", "expectedCampaignVersion", "", "mergeExposureHistory", "shownVersions", "", "lastShownAtMillis", "clearAllForDebug", "repo", "Lcom/bytedance/keva/Keva;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ManagedPromptLedgerStore {
    private static final String ACCOUNT_KEY_PREFIX = "account_";
    private static final String REPO_NAME = "trae_managed_prompt_ledger";
    public static final ManagedPromptLedgerStore INSTANCE = new ManagedPromptLedgerStore();
    private static final ManagedPromptLedger ledger = new ManagedPromptLedger(new ManagedPromptLedgerStorage() { // from class: com.bytedance.trae.conversation.prompt.ManagedPromptLedgerStore$ledger$1
        @Override // com.bytedance.trae.conversation.prompt.ManagedPromptLedgerStorage
        public String read(String userId) {
            Keva repo;
            Intrinsics.checkNotNullParameter(userId, "userId");
            repo = ManagedPromptLedgerStore.INSTANCE.repo();
            return repo.getString("account_" + userId, (String) null);
        }

        @Override // com.bytedance.trae.conversation.prompt.ManagedPromptLedgerStorage
        public void write(String userId, String serializedState) {
            Keva repo;
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(serializedState, "serializedState");
            repo = ManagedPromptLedgerStore.INSTANCE.repo();
            repo.storeString("account_" + userId, serializedState);
        }
    }, null, 2, null);

    private ManagedPromptLedgerStore() {
    }

    public final ManagedPromptLedgerState snapshot(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return ledger.snapshot(userId);
    }

    public static /* synthetic */ void recordShown$default(ManagedPromptLedgerStore managedPromptLedgerStore, String str, ManagedPromptCandidate managedPromptCandidate, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = System.currentTimeMillis();
        }
        managedPromptLedgerStore.recordShown(str, managedPromptCandidate, j);
    }

    public final void recordShown(String userId, ManagedPromptCandidate candidate, long shownAtMillis) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(candidate, "candidate");
        ledger.recordShown(userId, candidate, shownAtMillis);
    }

    public final void savePendingBilling(String userId, PendingBillingPromptRecord pending) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(pending, "pending");
        ledger.savePendingBilling(userId, pending);
    }

    public final void clearPendingBilling(String userId, int expectedCampaignVersion) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        ledger.clearPendingBilling(userId, expectedCampaignVersion);
    }

    public final void mergeExposureHistory(String userId, Map<String, Integer> shownVersions, long lastShownAtMillis) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(shownVersions, "shownVersions");
        ledger.mergeExposureHistory(userId, shownVersions, lastShownAtMillis);
    }

    public final void clearAllForDebug() {
        repo().clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Keva repo() {
        Keva repo = Keva.getRepo(REPO_NAME);
        Intrinsics.checkNotNullExpressionValue(repo, "getRepo(...)");
        return repo;
    }
}
