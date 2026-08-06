package com.bytedance.trae.conversation.billing;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.trae.conversation.TocCreditsPolicy;
import com.bytedance.trae.conversation.billing.BillingUpgradeCandidateState;
import com.bytedance.trae.conversation.chat.UserPayIdentityService;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet;
import com.bytedance.trae.conversation.prompt.ManagedPromptCandidateState;
import com.bytedance.trae.conversation.prompt.ManagedPromptDisplayOutcome;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: BillingUpgradePromptCoordinator.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001%B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010 \u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0005H\u0002J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\n\u0010$\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;", "", "<init>", "()V", "TAG", "", "NAVIGATION_MAX_WAIT_MS", "", "CONVERSATION_PROMPT_MAX_WAIT_MS", "engine", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;", "prewarm", "", "clearCacheForDebug", "awaitReady", "", "maxWaitMs", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "candidateSnapshot", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;", "candidateSnapshot$conversation_mainlandRelease", "showCandidate", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;", "activity", "Landroidx/fragment/app/FragmentActivity;", "expectedUserId", "promptData", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;", "showCandidate$conversation_mainlandRelease", "recordShown", "userId", "isHostReady", "hasPrompt", "tag", "currentSession", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;", "currentUserId", "CandidateSnapshot", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BillingUpgradePromptCoordinator {
    public static final long CONVERSATION_PROMPT_MAX_WAIT_MS = 30000;
    public static final BillingUpgradePromptCoordinator INSTANCE;
    public static final long NAVIGATION_MAX_WAIT_MS = 5000;
    private static final String TAG = "BillingUpgradePrompt";
    private static final BillingUpgradePromptEngine engine;

    private BillingUpgradePromptCoordinator() {
    }

    static {
        BillingUpgradePromptCoordinator billingUpgradePromptCoordinator = new BillingUpgradePromptCoordinator();
        INSTANCE = billingUpgradePromptCoordinator;
        engine = new BillingUpgradePromptEngine(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())), new BillingUpgradePromptCoordinator$engine$1(billingUpgradePromptCoordinator), new BillingUpgradePromptCoordinator$engine$2(BillingUpgradePromptStore.INSTANCE), new BillingUpgradePromptCoordinator$engine$3(UserPayIdentityService.INSTANCE), new BillingUpgradePromptCoordinator$engine$4(BillingUpgradePromptStore.INSTANCE), new BillingUpgradePromptCoordinator$engine$5(BillingUpgradePromptStore.INSTANCE), new BillingUpgradePromptCoordinator$engine$6(BillingUpgradePromptStore.INSTANCE), 0, 128, null);
    }

    public final void prewarm() {
        engine.prewarm();
    }

    public final void clearCacheForDebug() {
        BillingUpgradePromptStore.INSTANCE.clearAll();
        engine.reset();
    }

    public static /* synthetic */ Object awaitReady$default(BillingUpgradePromptCoordinator billingUpgradePromptCoordinator, long j, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 5000;
        }
        return billingUpgradePromptCoordinator.awaitReady(j, continuation);
    }

    public final Object awaitReady(long j, Continuation<? super Boolean> continuation) {
        return engine.awaitReady(j, continuation);
    }

    /* compiled from: BillingUpgradePromptCoordinator.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;", "", "state", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;", "promptData", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;", "<init>", "(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V", "getState", "()Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;", "getPromptData", "()Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class CandidateSnapshot {
        private final BillingUpgradePromptData promptData;
        private final ManagedPromptCandidateState state;

        public static /* synthetic */ CandidateSnapshot copy$default(CandidateSnapshot candidateSnapshot, ManagedPromptCandidateState managedPromptCandidateState, BillingUpgradePromptData billingUpgradePromptData, int i, Object obj) {
            if ((i & 1) != 0) {
                managedPromptCandidateState = candidateSnapshot.state;
            }
            if ((i & 2) != 0) {
                billingUpgradePromptData = candidateSnapshot.promptData;
            }
            return candidateSnapshot.copy(managedPromptCandidateState, billingUpgradePromptData);
        }

        /* renamed from: component1, reason: from getter */
        public final ManagedPromptCandidateState getState() {
            return this.state;
        }

        /* renamed from: component2, reason: from getter */
        public final BillingUpgradePromptData getPromptData() {
            return this.promptData;
        }

        public final CandidateSnapshot copy(ManagedPromptCandidateState state, BillingUpgradePromptData promptData) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new CandidateSnapshot(state, promptData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CandidateSnapshot)) {
                return false;
            }
            CandidateSnapshot candidateSnapshot = (CandidateSnapshot) other;
            return Intrinsics.areEqual(this.state, candidateSnapshot.state) && Intrinsics.areEqual(this.promptData, candidateSnapshot.promptData);
        }

        public int hashCode() {
            int hashCode = this.state.hashCode() * 31;
            BillingUpgradePromptData billingUpgradePromptData = this.promptData;
            return hashCode + (billingUpgradePromptData == null ? 0 : billingUpgradePromptData.hashCode());
        }

        public String toString() {
            return "CandidateSnapshot(state=" + this.state + ", promptData=" + this.promptData + ')';
        }

        public CandidateSnapshot(ManagedPromptCandidateState managedPromptCandidateState, BillingUpgradePromptData billingUpgradePromptData) {
            Intrinsics.checkNotNullParameter(managedPromptCandidateState, "state");
            this.state = managedPromptCandidateState;
            this.promptData = billingUpgradePromptData;
        }

        public /* synthetic */ CandidateSnapshot(ManagedPromptCandidateState managedPromptCandidateState, BillingUpgradePromptData billingUpgradePromptData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(managedPromptCandidateState, (i & 2) != 0 ? null : billingUpgradePromptData);
        }

        public final ManagedPromptCandidateState getState() {
            return this.state;
        }

        public final BillingUpgradePromptData getPromptData() {
            return this.promptData;
        }
    }

    public final CandidateSnapshot candidateSnapshot$conversation_mainlandRelease() {
        int i = 2;
        BillingUpgradePromptData billingUpgradePromptData = null;
        if (!TocCreditsPolicy.INSTANCE.isEnabled()) {
            return new CandidateSnapshot(ManagedPromptCandidateState.Ineligible.INSTANCE, billingUpgradePromptData, i, billingUpgradePromptData);
        }
        String currentUserId = currentUserId();
        if (currentUserId == null) {
            return new CandidateSnapshot(ManagedPromptCandidateState.Ineligible.INSTANCE, billingUpgradePromptData, i, billingUpgradePromptData);
        }
        BillingUpgradeCandidateState candidateState = engine.candidateState(currentUserId);
        if (Intrinsics.areEqual(candidateState, BillingUpgradeCandidateState.Preparing.INSTANCE)) {
            return new CandidateSnapshot(ManagedPromptCandidateState.Preparing.INSTANCE, billingUpgradePromptData, i, billingUpgradePromptData);
        }
        if (Intrinsics.areEqual(candidateState, BillingUpgradeCandidateState.Ineligible.INSTANCE)) {
            return new CandidateSnapshot(ManagedPromptCandidateState.Ineligible.INSTANCE, billingUpgradePromptData, i, billingUpgradePromptData);
        }
        if (!(candidateState instanceof BillingUpgradeCandidateState.Eligible)) {
            throw new NoWhenBranchMatchedException();
        }
        return new CandidateSnapshot(new ManagedPromptCandidateState.Eligible(BillingUpgradePromptPolicy.INSTANCE.getManagedCandidate$conversation_mainlandRelease()), ((BillingUpgradeCandidateState.Eligible) candidateState).getPromptData());
    }

    public final ManagedPromptDisplayOutcome showCandidate$conversation_mainlandRelease(FragmentActivity activity, String expectedUserId, BillingUpgradePromptData promptData) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(expectedUserId, "expectedUserId");
        Intrinsics.checkNotNullParameter(promptData, "promptData");
        if (!Intrinsics.areEqual(currentUserId(), expectedUserId) || !TocCreditsPolicy.INSTANCE.isEnabled()) {
            return ManagedPromptDisplayOutcome.NotShown;
        }
        if (BillingUpgradePromptStore.INSTANCE.hasShown(expectedUserId)) {
            engine.markShown(expectedUserId);
            return ManagedPromptDisplayOutcome.NotShown;
        }
        BillingUpgradePromptBottomSheet findFragmentByTag = activity.getSupportFragmentManager().findFragmentByTag(BillingUpgradePromptBottomSheet.TAG);
        BillingUpgradePromptBottomSheet billingUpgradePromptBottomSheet = findFragmentByTag instanceof BillingUpgradePromptBottomSheet ? findFragmentByTag : null;
        if (billingUpgradePromptBottomSheet != null) {
            if (Intrinsics.areEqual(billingUpgradePromptBottomSheet.getOwnerUserId$conversation_mainlandRelease(), expectedUserId)) {
                recordShown(expectedUserId);
            }
            return ManagedPromptDisplayOutcome.Shown;
        }
        if (hasPrompt(activity, DeviceFlowContainerBottomSheet.TAG)) {
            return ManagedPromptDisplayOutcome.TemporarilyBlocked;
        }
        if (!isHostReady(activity)) {
            return ManagedPromptDisplayOutcome.TemporarilyBlocked;
        }
        Fragment newInstance = BillingUpgradePromptBottomSheet.INSTANCE.newInstance(expectedUserId, promptData);
        try {
            newInstance.showNow(activity.getSupportFragmentManager(), BillingUpgradePromptBottomSheet.TAG);
            if (newInstance.isAdded() && activity.getSupportFragmentManager().findFragmentByTag(BillingUpgradePromptBottomSheet.TAG) == newInstance) {
                recordShown(expectedUserId);
                activity = ManagedPromptDisplayOutcome.Shown;
            } else {
                activity = ManagedPromptDisplayOutcome.NotShown;
            }
            return activity;
        } catch (Throwable th) {
            TraeLogUtil.INSTANCE.w(TAG, "show billing upgrade prompt failed", th);
            if (newInstance.isAdded() && activity.getSupportFragmentManager().findFragmentByTag(BillingUpgradePromptBottomSheet.TAG) == newInstance) {
                recordShown(expectedUserId);
                return ManagedPromptDisplayOutcome.Shown;
            }
            return ManagedPromptDisplayOutcome.NotShown;
        }
    }

    private final void recordShown(String userId) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            BillingUpgradePromptCoordinator billingUpgradePromptCoordinator = this;
            BillingUpgradePromptStore.INSTANCE.markShown(userId);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            TraeLogUtil.INSTANCE.w(TAG, "persist billing upgrade prompt state failed", th2);
        }
        engine.markShown(userId);
    }

    private final boolean isHostReady(FragmentActivity activity) {
        return (activity.isFinishing() || activity.isDestroyed() || !activity.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) || activity.getSupportFragmentManager().isStateSaved()) ? false : true;
    }

    private final boolean hasPrompt(FragmentActivity activity, String tag) {
        return activity.getSupportFragmentManager().findFragmentByTag(tag) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingUpgradePromptSession currentSession() {
        String currentUserId;
        if (TocCreditsPolicy.INSTANCE.isEnabled() && (currentUserId = currentUserId()) != null) {
            return new BillingUpgradePromptSession(currentUserId, null, 2, null);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String currentUserId() {
        Object obj;
        ILoginService iLoginService;
        String str;
        AccountInfo accountInfo;
        try {
            Result.Companion companion = Result.Companion;
            BillingUpgradePromptCoordinator billingUpgradePromptCoordinator = this;
            iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (iLoginService != null && (accountInfo = iLoginService.getAccountInfo()) != null) {
            if (!accountInfo.isLogin()) {
                accountInfo = null;
            }
            if (accountInfo != null && (str = accountInfo.getUserId()) != null && (!StringsKt.isBlank(str))) {
                obj = Result.constructor-impl(str);
                return (String) (Result.isFailure-impl(obj) ? null : obj);
            }
        }
        str = null;
        obj = Result.constructor-impl(str);
        return (String) (Result.isFailure-impl(obj) ? null : obj);
    }
}
