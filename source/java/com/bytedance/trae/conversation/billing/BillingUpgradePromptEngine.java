package com.bytedance.trae.conversation.billing;

import com.bytedance.trae.conversation.billing.BillingUpgradeCandidateState;
import com.bytedance.trae.conversation.billing.BillingUpgradePreparationResult;
import com.bytedance.trae.im.model.MessagePart;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: BillingUpgradePromptEngine.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u00012Bö\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\b\u0012\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f\u0012%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\u00140\b\u00128\b\u0002\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000f\u0012#\b\u0002\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00170\b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\"\u001a\u00020\u0017J\u0016\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0086@¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010(\u001a\u00020)2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010*\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010+\u001a\u00020\u0017J\u0010\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010-H\u0002J \u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR+\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\u00140\bX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00170\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "currentSession", "Lkotlin/Function0;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;", "hasShown", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "userId", "", "fetchPreparation", "Lkotlin/Function2;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;", "loadPending", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;", "savePending", "promptData", "", "clearPending", "maxAttemptsPerSession", "", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;I)V", "Lkotlin/jvm/functions/Function2;", "lock", "entries", "", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;", "prewarm", "awaitReady", "maxWaitMs", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pendingPromptData", "candidateState", "Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState;", "markShown", "reset", "startPreparationIfNeeded", "Lkotlinx/coroutines/Deferred;", "completePreparation", "requestedSession", "requestedEntry", "result", "Entry", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BillingUpgradePromptEngine {
    private final Function1<String, Unit> clearPending;
    private final Function0<BillingUpgradePromptSession> currentSession;
    private final Map<String, Entry> entries;
    private final Function2<BillingUpgradePreparationMode, Continuation<? super BillingUpgradePreparationResult>, Object> fetchPreparation;
    private final Function1<String, Boolean> hasShown;
    private final Function1<String, BillingUpgradePromptData> loadPending;
    private final Object lock;
    private final int maxAttemptsPerSession;
    private final Function2<String, BillingUpgradePromptData, Unit> savePending;
    private final CoroutineScope scope;

    /* JADX WARN: Multi-variable type inference failed */
    public BillingUpgradePromptEngine(CoroutineScope coroutineScope, Function0<BillingUpgradePromptSession> function0, Function1<? super String, Boolean> function1, Function2<? super BillingUpgradePreparationMode, ? super Continuation<? super BillingUpgradePreparationResult>, ? extends Object> function2, Function1<? super String, BillingUpgradePromptData> function12, Function2<? super String, ? super BillingUpgradePromptData, Unit> function22, Function1<? super String, Unit> function13, int i) {
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(function0, "currentSession");
        Intrinsics.checkNotNullParameter(function1, "hasShown");
        Intrinsics.checkNotNullParameter(function2, "fetchPreparation");
        Intrinsics.checkNotNullParameter(function12, "loadPending");
        Intrinsics.checkNotNullParameter(function22, "savePending");
        Intrinsics.checkNotNullParameter(function13, "clearPending");
        this.scope = coroutineScope;
        this.currentSession = function0;
        this.hasShown = function1;
        this.fetchPreparation = function2;
        this.loadPending = function12;
        this.savePending = function22;
        this.clearPending = function13;
        this.maxAttemptsPerSession = i;
        this.lock = new Object();
        this.entries = new LinkedHashMap();
    }

    public /* synthetic */ BillingUpgradePromptEngine(CoroutineScope coroutineScope, Function0 function0, Function1 function1, Function2 function2, Function1 function12, Function2 function22, Function1 function13, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, function0, function1, function2, (i2 & 16) != 0 ? new Function1() { // from class: com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine.1
            public final Void invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "it");
                return null;
            }
        } : function12, (i2 & 32) != 0 ? new Function2() { // from class: com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = BillingUpgradePromptEngine._init_$lambda$0((String) obj, (BillingUpgradePromptData) obj2);
                return _init_$lambda$0;
            }
        } : function22, (i2 & 64) != 0 ? new Function1() { // from class: com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$1;
                _init_$lambda$1 = BillingUpgradePromptEngine._init_$lambda$1((String) obj);
                return _init_$lambda$1;
            }
        } : function13, (i2 & 128) != 0 ? 2 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(String str, BillingUpgradePromptData billingUpgradePromptData) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(billingUpgradePromptData, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BillingUpgradePromptEngine.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003JO\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001J\u0013\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006/"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;", "", "attempts", "", MessagePart.TYPE_TERMINAL, "", "promptShownInProcess", "pendingRestored", "pendingPromptData", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;", "preparation", "Lkotlinx/coroutines/Deferred;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;", "<init>", "(IZZZLcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;Lkotlinx/coroutines/Deferred;)V", "getAttempts", "()I", "setAttempts", "(I)V", "getTerminal", "()Z", "setTerminal", "(Z)V", "getPromptShownInProcess", "setPromptShownInProcess", "getPendingRestored", "setPendingRestored", "getPendingPromptData", "()Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;", "setPendingPromptData", "(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V", "getPreparation", "()Lkotlinx/coroutines/Deferred;", "setPreparation", "(Lkotlinx/coroutines/Deferred;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Entry {
        private int attempts;
        private BillingUpgradePromptData pendingPromptData;
        private boolean pendingRestored;
        private Deferred<? extends BillingUpgradePreparationResult> preparation;
        private boolean promptShownInProcess;
        private boolean terminal;

        public Entry() {
            this(0, false, false, false, null, null, 63, null);
        }

        public static /* synthetic */ Entry copy$default(Entry entry, int i, boolean z, boolean z2, boolean z3, BillingUpgradePromptData billingUpgradePromptData, Deferred deferred, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = entry.attempts;
            }
            if ((i2 & 2) != 0) {
                z = entry.terminal;
            }
            boolean z4 = z;
            if ((i2 & 4) != 0) {
                z2 = entry.promptShownInProcess;
            }
            boolean z5 = z2;
            if ((i2 & 8) != 0) {
                z3 = entry.pendingRestored;
            }
            boolean z6 = z3;
            if ((i2 & 16) != 0) {
                billingUpgradePromptData = entry.pendingPromptData;
            }
            BillingUpgradePromptData billingUpgradePromptData2 = billingUpgradePromptData;
            if ((i2 & 32) != 0) {
                deferred = entry.preparation;
            }
            return entry.copy(i, z4, z5, z6, billingUpgradePromptData2, deferred);
        }

        /* renamed from: component1, reason: from getter */
        public final int getAttempts() {
            return this.attempts;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getTerminal() {
            return this.terminal;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getPromptShownInProcess() {
            return this.promptShownInProcess;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getPendingRestored() {
            return this.pendingRestored;
        }

        /* renamed from: component5, reason: from getter */
        public final BillingUpgradePromptData getPendingPromptData() {
            return this.pendingPromptData;
        }

        public final Deferred<BillingUpgradePreparationResult> component6() {
            return this.preparation;
        }

        public final Entry copy(int attempts, boolean terminal, boolean promptShownInProcess, boolean pendingRestored, BillingUpgradePromptData pendingPromptData, Deferred<? extends BillingUpgradePreparationResult> preparation) {
            return new Entry(attempts, terminal, promptShownInProcess, pendingRestored, pendingPromptData, preparation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) other;
            return this.attempts == entry.attempts && this.terminal == entry.terminal && this.promptShownInProcess == entry.promptShownInProcess && this.pendingRestored == entry.pendingRestored && Intrinsics.areEqual(this.pendingPromptData, entry.pendingPromptData) && Intrinsics.areEqual(this.preparation, entry.preparation);
        }

        public int hashCode() {
            int hashCode = ((((((Integer.hashCode(this.attempts) * 31) + Boolean.hashCode(this.terminal)) * 31) + Boolean.hashCode(this.promptShownInProcess)) * 31) + Boolean.hashCode(this.pendingRestored)) * 31;
            BillingUpgradePromptData billingUpgradePromptData = this.pendingPromptData;
            int hashCode2 = (hashCode + (billingUpgradePromptData == null ? 0 : billingUpgradePromptData.hashCode())) * 31;
            Deferred<? extends BillingUpgradePreparationResult> deferred = this.preparation;
            return hashCode2 + (deferred != null ? deferred.hashCode() : 0);
        }

        public String toString() {
            return "Entry(attempts=" + this.attempts + ", terminal=" + this.terminal + ", promptShownInProcess=" + this.promptShownInProcess + ", pendingRestored=" + this.pendingRestored + ", pendingPromptData=" + this.pendingPromptData + ", preparation=" + this.preparation + ')';
        }

        public Entry(int i, boolean z, boolean z2, boolean z3, BillingUpgradePromptData billingUpgradePromptData, Deferred<? extends BillingUpgradePreparationResult> deferred) {
            this.attempts = i;
            this.terminal = z;
            this.promptShownInProcess = z2;
            this.pendingRestored = z3;
            this.pendingPromptData = billingUpgradePromptData;
            this.preparation = deferred;
        }

        public /* synthetic */ Entry(int i, boolean z, boolean z2, boolean z3, BillingUpgradePromptData billingUpgradePromptData, Deferred deferred, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? false : z2, (i2 & 8) == 0 ? z3 : false, (i2 & 16) != 0 ? null : billingUpgradePromptData, (i2 & 32) != 0 ? null : deferred);
        }

        public final int getAttempts() {
            return this.attempts;
        }

        public final void setAttempts(int i) {
            this.attempts = i;
        }

        public final boolean getTerminal() {
            return this.terminal;
        }

        public final void setTerminal(boolean z) {
            this.terminal = z;
        }

        public final boolean getPromptShownInProcess() {
            return this.promptShownInProcess;
        }

        public final void setPromptShownInProcess(boolean z) {
            this.promptShownInProcess = z;
        }

        public final boolean getPendingRestored() {
            return this.pendingRestored;
        }

        public final void setPendingRestored(boolean z) {
            this.pendingRestored = z;
        }

        public final BillingUpgradePromptData getPendingPromptData() {
            return this.pendingPromptData;
        }

        public final void setPendingPromptData(BillingUpgradePromptData billingUpgradePromptData) {
            this.pendingPromptData = billingUpgradePromptData;
        }

        public final Deferred<BillingUpgradePreparationResult> getPreparation() {
            return this.preparation;
        }

        public final void setPreparation(Deferred<? extends BillingUpgradePreparationResult> deferred) {
            this.preparation = deferred;
        }
    }

    public final void prewarm() {
        startPreparationIfNeeded();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitReady(long j, Continuation<? super Boolean> continuation) {
        BillingUpgradePromptEngine$awaitReady$1 billingUpgradePromptEngine$awaitReady$1;
        int i;
        if (continuation instanceof BillingUpgradePromptEngine$awaitReady$1) {
            billingUpgradePromptEngine$awaitReady$1 = (BillingUpgradePromptEngine$awaitReady$1) continuation;
            if ((billingUpgradePromptEngine$awaitReady$1.label & Integer.MIN_VALUE) != 0) {
                billingUpgradePromptEngine$awaitReady$1.label -= Integer.MIN_VALUE;
                Object obj = billingUpgradePromptEngine$awaitReady$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = billingUpgradePromptEngine$awaitReady$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (j <= 0) {
                        return Boxing.boxBoolean(startPreparationIfNeeded() == null);
                    }
                    BillingUpgradePromptEngine$awaitReady$2 billingUpgradePromptEngine$awaitReady$2 = new BillingUpgradePromptEngine$awaitReady$2(this, null);
                    billingUpgradePromptEngine$awaitReady$1.label = 1;
                    obj = TimeoutKt.withTimeoutOrNull(j, billingUpgradePromptEngine$awaitReady$2, billingUpgradePromptEngine$awaitReady$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Boolean bool = (Boolean) obj;
                return Boxing.boxBoolean(bool != null ? bool.booleanValue() : false);
            }
        }
        billingUpgradePromptEngine$awaitReady$1 = new BillingUpgradePromptEngine$awaitReady$1(this, continuation);
        Object obj2 = billingUpgradePromptEngine$awaitReady$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = billingUpgradePromptEngine$awaitReady$1.label;
        if (i != 0) {
        }
        Boolean bool2 = (Boolean) obj2;
        return Boxing.boxBoolean(bool2 != null ? bool2.booleanValue() : false);
    }

    public final BillingUpgradePromptData pendingPromptData(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        String shownKey = BillingUpgradePromptPolicy.INSTANCE.shownKey(userId);
        synchronized (this.lock) {
            Entry entry = this.entries.get(shownKey);
            if (entry == null) {
                return null;
            }
            if (!entry.getPromptShownInProcess() && !((Boolean) this.hasShown.invoke(userId)).booleanValue()) {
                return entry.getPendingPromptData();
            }
            entry.setPromptShownInProcess(true);
            entry.setPendingPromptData(null);
            return null;
        }
    }

    public final BillingUpgradeCandidateState candidateState(String userId) {
        BillingUpgradeCandidateState.Preparing preparing;
        BillingUpgradePromptData pendingPromptData;
        Intrinsics.checkNotNullParameter(userId, "userId");
        BillingUpgradePromptSession billingUpgradePromptSession = (BillingUpgradePromptSession) this.currentSession.invoke();
        if (!Intrinsics.areEqual(billingUpgradePromptSession != null ? billingUpgradePromptSession.getUserId() : null, userId)) {
            return BillingUpgradeCandidateState.Ineligible.INSTANCE;
        }
        String shownKey = BillingUpgradePromptPolicy.INSTANCE.shownKey(userId);
        synchronized (this.lock) {
            Entry entry = this.entries.get(shownKey);
            boolean z = false;
            if (entry != null && entry.getPromptShownInProcess()) {
                z = true;
            }
            if (!z && !((Boolean) this.hasShown.invoke(userId)).booleanValue()) {
                if (entry != null && (pendingPromptData = entry.getPendingPromptData()) != null) {
                    return new BillingUpgradeCandidateState.Eligible(pendingPromptData);
                }
                if (entry != null && entry.getTerminal()) {
                    preparing = BillingUpgradeCandidateState.Ineligible.INSTANCE;
                    return preparing;
                }
                preparing = BillingUpgradeCandidateState.Preparing.INSTANCE;
                return preparing;
            }
            return BillingUpgradeCandidateState.Ineligible.INSTANCE;
        }
    }

    public final void markShown(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        String shownKey = BillingUpgradePromptPolicy.INSTANCE.shownKey(userId);
        synchronized (this.lock) {
            Map<String, Entry> map = this.entries;
            Entry entry = map.get(shownKey);
            if (entry == null) {
                entry = new Entry(0, false, false, false, null, null, 63, null);
                map.put(shownKey, entry);
            }
            Entry entry2 = entry;
            entry2.setPromptShownInProcess(true);
            entry2.setPendingPromptData(null);
            Entry entry3 = entry;
        }
        try {
            Result.Companion companion = Result.Companion;
            BillingUpgradePromptEngine billingUpgradePromptEngine = this;
            this.clearPending.invoke(userId);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public final void reset() {
        synchronized (this.lock) {
            this.entries.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055 A[Catch: all -> 0x0127, TryCatch #1 {, blocks: (B:8:0x0012, B:10:0x001e, B:11:0x0032, B:13:0x003c, B:18:0x0055, B:20:0x0061, B:25:0x0079, B:26:0x00c0, B:28:0x00c6, B:32:0x00ce, B:33:0x00d1, B:37:0x00d9, B:39:0x00df, B:43:0x00ea, B:44:0x00ef, B:47:0x00ed, B:48:0x0122, B:51:0x0083, B:53:0x0089, B:56:0x00ad, B:59:0x00b4, B:61:0x00b8, B:66:0x00a3, B:55:0x008c, B:22:0x0064), top: B:7:0x0012, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c6 A[Catch: all -> 0x0127, TRY_LEAVE, TryCatch #1 {, blocks: (B:8:0x0012, B:10:0x001e, B:11:0x0032, B:13:0x003c, B:18:0x0055, B:20:0x0061, B:25:0x0079, B:26:0x00c0, B:28:0x00c6, B:32:0x00ce, B:33:0x00d1, B:37:0x00d9, B:39:0x00df, B:43:0x00ea, B:44:0x00ef, B:47:0x00ed, B:48:0x0122, B:51:0x0083, B:53:0x0089, B:56:0x00ad, B:59:0x00b4, B:61:0x00b8, B:66:0x00a3, B:55:0x008c, B:22:0x0064), top: B:7:0x0012, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d7 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d9 A[Catch: all -> 0x0127, TRY_ENTER, TryCatch #1 {, blocks: (B:8:0x0012, B:10:0x001e, B:11:0x0032, B:13:0x003c, B:18:0x0055, B:20:0x0061, B:25:0x0079, B:26:0x00c0, B:28:0x00c6, B:32:0x00ce, B:33:0x00d1, B:37:0x00d9, B:39:0x00df, B:43:0x00ea, B:44:0x00ef, B:47:0x00ed, B:48:0x0122, B:51:0x0083, B:53:0x0089, B:56:0x00ad, B:59:0x00b4, B:61:0x00b8, B:66:0x00a3, B:55:0x008c, B:22:0x0064), top: B:7:0x0012, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0083 A[Catch: all -> 0x0127, TryCatch #1 {, blocks: (B:8:0x0012, B:10:0x001e, B:11:0x0032, B:13:0x003c, B:18:0x0055, B:20:0x0061, B:25:0x0079, B:26:0x00c0, B:28:0x00c6, B:32:0x00ce, B:33:0x00d1, B:37:0x00d9, B:39:0x00df, B:43:0x00ea, B:44:0x00ef, B:47:0x00ed, B:48:0x0122, B:51:0x0083, B:53:0x0089, B:56:0x00ad, B:59:0x00b4, B:61:0x00b8, B:66:0x00a3, B:55:0x008c, B:22:0x0064), top: B:7:0x0012, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Deferred<BillingUpgradePreparationResult> startPreparationIfNeeded() {
        boolean z;
        Object obj;
        Deferred<BillingUpgradePreparationResult> preparation;
        BillingUpgradePreparationMode billingUpgradePreparationMode;
        final BillingUpgradePromptSession billingUpgradePromptSession = (BillingUpgradePromptSession) this.currentSession.invoke();
        if (billingUpgradePromptSession == null) {
            return null;
        }
        synchronized (this.lock) {
            Map<String, Entry> map = this.entries;
            String key = billingUpgradePromptSession.getKey();
            Entry entry = map.get(key);
            if (entry == null) {
                entry = new Entry(0, false, false, false, null, null, 63, null);
                map.put(key, entry);
            }
            Entry entry2 = entry;
            if (!entry2.getPromptShownInProcess() && !((Boolean) this.hasShown.invoke(billingUpgradePromptSession.getUserId())).booleanValue()) {
                z = false;
                if (!z) {
                    entry2.setPromptShownInProcess(true);
                    entry2.setPendingPromptData(null);
                    if (!entry2.getPendingRestored()) {
                        entry2.setPendingRestored(true);
                        try {
                            Result.Companion companion = Result.Companion;
                            BillingUpgradePromptEngine billingUpgradePromptEngine = this;
                            this.clearPending.invoke(billingUpgradePromptSession.getUserId());
                            Result.constructor-impl(Unit.INSTANCE);
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            Result.constructor-impl(ResultKt.createFailure(th));
                        }
                    }
                    preparation = entry2.getPreparation();
                    if (preparation != null) {
                        if (!preparation.isCompleted()) {
                            return preparation;
                        }
                        entry2.setPreparation(null);
                    }
                    if (entry2.getPendingPromptData() == null) {
                        return null;
                    }
                    if (!entry2.getTerminal() && entry2.getAttempts() < this.maxAttemptsPerSession) {
                        if (z) {
                            billingUpgradePreparationMode = BillingUpgradePreparationMode.SilentRecovery;
                        } else {
                            billingUpgradePreparationMode = BillingUpgradePreparationMode.PromptEligible;
                        }
                        entry2.setAttempts(entry2.getAttempts() + 1);
                        final Deferred<BillingUpgradePreparationResult> async$default = BuildersKt.async$default(this.scope, (CoroutineContext) null, CoroutineStart.LAZY, new C0639xc2ed9011(this, billingUpgradePreparationMode, billingUpgradePromptSession, entry2, null), 1, (Object) null);
                        entry2.setPreparation(async$default);
                        async$default.invokeOnCompletion(new Function1() { // from class: com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj2) {
                                Unit startPreparationIfNeeded$lambda$17$lambda$16;
                                startPreparationIfNeeded$lambda$17$lambda$16 = BillingUpgradePromptEngine.startPreparationIfNeeded$lambda$17$lambda$16(BillingUpgradePromptEngine.this, billingUpgradePromptSession, async$default, (Throwable) obj2);
                                return startPreparationIfNeeded$lambda$17$lambda$16;
                            }
                        });
                        async$default.start();
                        return async$default;
                    }
                    entry2.setTerminal(true);
                    return null;
                }
                if (!entry2.getPendingRestored()) {
                    entry2.setPendingRestored(true);
                    try {
                        Result.Companion companion3 = Result.Companion;
                        BillingUpgradePromptEngine billingUpgradePromptEngine2 = this;
                        obj = Result.constructor-impl((BillingUpgradePromptData) this.loadPending.invoke(billingUpgradePromptSession.getUserId()));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    BillingUpgradePromptData billingUpgradePromptData = (BillingUpgradePromptData) obj;
                    if (billingUpgradePromptData != null) {
                        entry2.setTerminal(true);
                        entry2.setPendingPromptData(billingUpgradePromptData);
                        return null;
                    }
                }
                preparation = entry2.getPreparation();
                if (preparation != null) {
                }
                if (entry2.getPendingPromptData() == null) {
                }
            }
            z = true;
            if (!z) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startPreparationIfNeeded$lambda$17$lambda$16(BillingUpgradePromptEngine billingUpgradePromptEngine, BillingUpgradePromptSession billingUpgradePromptSession, Deferred deferred, Throwable th) {
        synchronized (billingUpgradePromptEngine.lock) {
            Entry entry = billingUpgradePromptEngine.entries.get(billingUpgradePromptSession.getKey());
            if (entry != null) {
                if (!(entry.getPreparation() == deferred)) {
                    entry = null;
                }
                if (entry != null) {
                    entry.setPreparation(null);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void completePreparation(BillingUpgradePromptSession requestedSession, Entry requestedEntry, BillingUpgradePreparationResult result) {
        boolean z;
        Object obj;
        BillingUpgradePromptSession billingUpgradePromptSession = (BillingUpgradePromptSession) this.currentSession.invoke();
        synchronized (this.lock) {
            Entry entry = this.entries.get(requestedSession.getKey());
            if (entry != null) {
                BillingUpgradePromptData billingUpgradePromptData = null;
                if (!(entry == requestedEntry)) {
                    entry = null;
                }
                if (entry != null) {
                    if (!Intrinsics.areEqual(billingUpgradePromptSession != null ? billingUpgradePromptSession.getKey() : null, requestedSession.getKey())) {
                        this.entries.remove(requestedSession.getKey());
                        return;
                    }
                    if (result instanceof BillingUpgradePreparationResult.PromptReady) {
                        entry.setTerminal(true);
                        BillingUpgradePromptPolicy billingUpgradePromptPolicy = BillingUpgradePromptPolicy.INSTANCE;
                        if (!entry.getPromptShownInProcess() && !((Boolean) this.hasShown.invoke(requestedSession.getUserId())).booleanValue()) {
                            z = false;
                            if (billingUpgradePromptPolicy.shouldShow(z)) {
                                try {
                                    Result.Companion companion = Result.Companion;
                                    BillingUpgradePromptEngine billingUpgradePromptEngine = this;
                                    this.savePending.invoke(requestedSession.getUserId(), ((BillingUpgradePreparationResult.PromptReady) result).getPromptData());
                                    obj = Result.constructor-impl(true);
                                } catch (Throwable th) {
                                    Result.Companion companion2 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                                if (Result.isFailure-impl(obj)) {
                                    obj = false;
                                }
                                boolean booleanValue = ((Boolean) obj).booleanValue();
                                BillingUpgradePromptData promptData = ((BillingUpgradePreparationResult.PromptReady) result).getPromptData();
                                if (Boolean.valueOf(booleanValue).booleanValue()) {
                                    billingUpgradePromptData = promptData;
                                }
                            }
                            entry.setPendingPromptData(billingUpgradePromptData);
                            Unit unit = Unit.INSTANCE;
                        }
                        z = true;
                        if (billingUpgradePromptPolicy.shouldShow(z)) {
                        }
                        entry.setPendingPromptData(billingUpgradePromptData);
                        Unit unit2 = Unit.INSTANCE;
                    } else if (Intrinsics.areEqual(result, BillingUpgradePreparationResult.SwitchAcceptedSilently.INSTANCE)) {
                        entry.setTerminal(true);
                        entry.setPendingPromptData(null);
                        Unit unit3 = Unit.INSTANCE;
                    } else if (Intrinsics.areEqual(result, BillingUpgradePreparationResult.AlreadyUpgraded.INSTANCE)) {
                        entry.setTerminal(true);
                        entry.setPendingPromptData(null);
                        Unit unit4 = Unit.INSTANCE;
                    } else if (Intrinsics.areEqual(result, BillingUpgradePreparationResult.RetryableFailure.INSTANCE)) {
                        entry.setPendingPromptData(null);
                        entry.setTerminal(entry.getAttempts() >= this.maxAttemptsPerSession);
                        Unit unit5 = Unit.INSTANCE;
                    } else {
                        if (!Intrinsics.areEqual(result, BillingUpgradePreparationResult.StaleAccount.INSTANCE)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        this.entries.remove(requestedSession.getKey());
                    }
                }
            }
        }
    }
}
