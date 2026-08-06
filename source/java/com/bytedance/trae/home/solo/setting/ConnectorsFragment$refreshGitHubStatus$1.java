package com.bytedance.trae.home.solo.setting;

import android.widget.LinearLayout;
import androidx.appcompat.widget.SwitchCompat;
import com.bytedance.sdk.xbridge.cn.websocket.utils.WebSocketConsts;
import com.bytedance.trae.conversation.git.GitHubConnectorManager;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConnectorsFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.ConnectorsFragment$refreshGitHubStatus$1", f = "ConnectorsFragment.kt", i = {0}, l = {91}, m = "invokeSuspend", n = {WebSocketConsts.StateType_CONNECTED}, s = {"I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConnectorsFragment$refreshGitHubStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int label;
    final /* synthetic */ ConnectorsFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectorsFragment$refreshGitHubStatus$1(ConnectorsFragment connectorsFragment, Continuation<? super ConnectorsFragment$refreshGitHubStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = connectorsFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConnectorsFragment$refreshGitHubStatus$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005b A[Catch: Exception -> 0x0068, TryCatch #0 {Exception -> 0x0068, blocks: (B:6:0x0012, B:7:0x003e, B:9:0x0044, B:15:0x0053, B:17:0x005b, B:20:0x0063), top: B:5:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        GitHubConnectorManager gitHubConnectorManager;
        SwitchCompat switchCompat;
        SwitchCompat switchCompat2;
        LinearLayout linearLayout;
        boolean z;
        SwitchCompat switchCompat3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        LinearLayout linearLayout2 = null;
        boolean z2 = true;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                gitHubConnectorManager = this.this$0.connectorManager;
                if (gitHubConnectorManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("connectorManager");
                    gitHubConnectorManager = null;
                }
                this.I$0 = 0;
                this.label = 1;
                obj = gitHubConnectorManager.checkToken((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Exception unused) {
                i = 0;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception unused2) {
            }
        }
        String str = (String) obj;
        if (str != null && !StringsKt.isBlank(str)) {
            z = false;
            i = z ? 1 : 0;
            switchCompat3 = this.this$0.switchGithub;
            if (switchCompat3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("switchGithub");
                switchCompat3 = null;
            }
            if (i != 0) {
                z2 = false;
            }
            switchCompat3.setChecked(z2);
            switchCompat = this.this$0.switchGithub;
            if (switchCompat == null) {
                Intrinsics.throwUninitializedPropertyAccessException("switchGithub");
                switchCompat = null;
            }
            switchCompat.jumpDrawablesToCurrentState();
            switchCompat2 = this.this$0.switchGithub;
            if (switchCompat2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("switchGithub");
                switchCompat2 = null;
            }
            switchCompat2.setVisibility(0);
            linearLayout = this.this$0.cardManageGithub;
            if (linearLayout != null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardManageGithub");
            } else {
                linearLayout2 = linearLayout;
            }
            linearLayout2.setVisibility(i == 0 ? 8 : 0);
            return Unit.INSTANCE;
        }
        z = true;
        if (z) {
        }
        switchCompat3 = this.this$0.switchGithub;
        if (switchCompat3 == null) {
        }
        if (i != 0) {
        }
        switchCompat3.setChecked(z2);
        switchCompat = this.this$0.switchGithub;
        if (switchCompat == null) {
        }
        switchCompat.jumpDrawablesToCurrentState();
        switchCompat2 = this.this$0.switchGithub;
        if (switchCompat2 == null) {
        }
        switchCompat2.setVisibility(0);
        linearLayout = this.this$0.cardManageGithub;
        if (linearLayout != null) {
        }
        linearLayout2.setVisibility(i == 0 ? 8 : 0);
        return Unit.INSTANCE;
    }
}
