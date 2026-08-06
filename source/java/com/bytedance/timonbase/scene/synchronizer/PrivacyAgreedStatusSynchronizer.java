package com.bytedance.timonbase.scene.synchronizer;

import kotlin.Metadata;

/* compiled from: PrivacyAgreedStatusSynchronizer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/timonbase/scene/synchronizer/PrivacyAgreedStatusSynchronizer;", "Lcom/bytedance/timonbase/scene/synchronizer/ISenseStatusSynchronizer;", "", "()V", "privacyAgreed", "getCurrentSenseStatus", "()Ljava/lang/Boolean;", "updateSenseStatus", "", "newStatus", "", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class PrivacyAgreedStatusSynchronizer implements ISenseStatusSynchronizer<Boolean> {
    public static final PrivacyAgreedStatusSynchronizer INSTANCE = new PrivacyAgreedStatusSynchronizer();
    private static boolean privacyAgreed = true;

    private PrivacyAgreedStatusSynchronizer() {
    }

    @Override // com.bytedance.timonbase.scene.synchronizer.ISenseStatusSynchronizer
    public void updateSenseStatus(Object newStatus) {
        if (newStatus instanceof Boolean) {
            privacyAgreed = ((Boolean) newStatus).booleanValue();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.timonbase.scene.synchronizer.ISenseStatusSynchronizer
    public Boolean getCurrentSenseStatus() {
        return Boolean.valueOf(privacyAgreed);
    }
}
