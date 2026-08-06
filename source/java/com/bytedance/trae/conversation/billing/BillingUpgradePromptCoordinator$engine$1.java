package com.bytedance.trae.conversation.billing;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: BillingUpgradePromptCoordinator.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
/* synthetic */ class BillingUpgradePromptCoordinator$engine$1 extends FunctionReferenceImpl implements Function0<BillingUpgradePromptSession> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingUpgradePromptCoordinator$engine$1(Object obj) {
        super(0, obj, BillingUpgradePromptCoordinator.class, "currentSession", "currentSession()Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;", 0);
    }

    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final BillingUpgradePromptSession m1166invoke() {
        BillingUpgradePromptSession currentSession;
        currentSession = ((BillingUpgradePromptCoordinator) this.receiver).currentSession();
        return currentSession;
    }
}
