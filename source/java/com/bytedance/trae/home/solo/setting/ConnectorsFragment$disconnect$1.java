package com.bytedance.trae.home.solo.setting;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.SwitchCompat;
import com.bytedance.trae.conversation.git.GitHubConnectorError;
import com.bytedance.trae.conversation.git.GitHubConnectorManager;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.C0820R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConnectorsFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.ConnectorsFragment$disconnect$1", f = "ConnectorsFragment.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConnectorsFragment$disconnect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConnectorsFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectorsFragment$disconnect$1(ConnectorsFragment connectorsFragment, Continuation<? super ConnectorsFragment$disconnect$1> continuation) {
        super(2, continuation);
        this.this$0 = connectorsFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConnectorsFragment$disconnect$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0093, code lost:
    
        if (r0 == null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String message;
        GitHubConnectorManager gitHubConnectorManager;
        SwitchCompat switchCompat;
        LinearLayout linearLayout;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    gitHubConnectorManager = this.this$0.connectorManager;
                    if (gitHubConnectorManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("connectorManager");
                        gitHubConnectorManager = null;
                    }
                    this.label = 1;
                    if (gitHubConnectorManager.disconnect((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                switchCompat = this.this$0.switchGithub;
                if (switchCompat == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("switchGithub");
                    switchCompat = null;
                }
                switchCompat.setChecked(false);
                linearLayout = this.this$0.cardManageGithub;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cardManageGithub");
                    linearLayout = null;
                }
                linearLayout.setVisibility(8);
                Toast.makeText(this.this$0.requireContext(), C0820R.string.trae_setting_connector_disconnect_success, 0).show();
            } catch (Exception e) {
                GitHubConnectorError gitHubConnectorError = e instanceof GitHubConnectorError ? (GitHubConnectorError) e : null;
                if (gitHubConnectorError != null) {
                    Context requireContext = this.this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                    message = gitHubConnectorError.localizedMessage(requireContext);
                }
                message = e.getMessage();
                if (message == null) {
                    message = "";
                }
                Toast.makeText(this.this$0.requireContext(), this.this$0.getString(C0820R.string.trae_setting_connector_disconnect_failed) + ": " + message, 0).show();
            }
            return Unit.INSTANCE;
        } finally {
            this.this$0.isOperating = false;
            this.this$0.setInteractionEnabled(true);
        }
    }
}
