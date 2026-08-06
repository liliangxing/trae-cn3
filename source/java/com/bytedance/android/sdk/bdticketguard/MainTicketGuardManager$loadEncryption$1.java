package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.android.sdk.bdticketguard.key.ReeKeyHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainTicketGuardManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"com/bytedance/android/sdk/bdticketguard/MainTicketGuardManager$loadEncryption$1", "Lcom/bytedance/android/sdk/bdticketguard/TicketInitCallback;", "onFinish", "", "reeResult", "", "(Ljava/lang/Boolean;)V", "bd_ticket_guard_core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MainTicketGuardManager$loadEncryption$1 implements TicketInitCallback {
    final /* synthetic */ TicketInitCallback $callback;
    final /* synthetic */ String $scene;
    final /* synthetic */ MainTicketGuardManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MainTicketGuardManager$loadEncryption$1(MainTicketGuardManager mainTicketGuardManager, String str, TicketInitCallback ticketInitCallback) {
        this.this$0 = mainTicketGuardManager;
        this.$scene = str;
        this.$callback = ticketInitCallback;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketInitCallback
    public void onFinish(Boolean reeResult) {
        ReeKeyHelper reeKeyHelper;
        if (Intrinsics.areEqual(reeResult, true)) {
            InitStatus initStatus = this.this$0.getInitStatusMap().get(TicketGuardApiKt.INIT_STATUS_ENCRYPTION);
            if (initStatus == null) {
                Intrinsics.throwNpe();
            }
            final InitStatus initStatus2 = initStatus;
            if (true ^ Intrinsics.areEqual(initStatus2.getInitResult(), true)) {
                synchronized (initStatus2.getInitLock()) {
                    if (initStatus2.getInitResult() == null) {
                        reeKeyHelper = this.this$0.getReeKeyHelper();
                        initStatus2.setInitResult(Boolean.valueOf(reeKeyHelper.tryInitEncryption()));
                    }
                    if (!Intrinsics.areEqual(initStatus2.getInitResult(), true) && !Intrinsics.areEqual(this.$scene, TicketGuardManagerKt.SCENE_TICKET_NETWORK)) {
                        this.this$0.requestCertInner(new GetCertCallback() { // from class: com.bytedance.android.sdk.bdticketguard.MainTicketGuardManager$loadEncryption$1$onFinish$$inlined$apply$lambda$1
                            @Override // com.bytedance.android.sdk.bdticketguard.GetCertCallback
                            public void onCallback(String resClientCert, String resServerCert) {
                                ReeKeyHelper reeKeyHelper2;
                                InitStatus initStatus3 = InitStatus.this;
                                reeKeyHelper2 = this.this$0.getReeKeyHelper();
                                initStatus3.setInitResult(Boolean.valueOf(reeKeyHelper2.hasEncryption()));
                                this.this$0.initCallback(InitStatus.this.getInitResult(), this.$callback);
                            }
                        }, this.$scene);
                        Unit unit = Unit.INSTANCE;
                    }
                    this.this$0.initCallback(initStatus2.getInitResult(), this.$callback);
                    Unit unit2 = Unit.INSTANCE;
                }
                return;
            }
            this.this$0.initCallback(initStatus2.getInitResult(), this.$callback);
            return;
        }
        this.this$0.initCallback(false, this.$callback);
    }
}
