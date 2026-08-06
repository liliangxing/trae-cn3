package com.bytedance.trae.home.solo.setting;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GitHubOAuthActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.GitHubOAuthActivity$handleCallbackUri$1", f = "GitHubOAuthActivity.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GitHubOAuthActivity$handleCallbackUri$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ GitHubOAuthActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GitHubOAuthActivity$handleCallbackUri$1(GitHubOAuthActivity gitHubOAuthActivity, Uri uri, Continuation<? super GitHubOAuthActivity$handleCallbackUri$1> continuation) {
        super(2, continuation);
        this.this$0 = gitHubOAuthActivity;
        this.$uri = uri;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GitHubOAuthActivity$handleCallbackUri$1(this.this$0, this.$uri, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String message;
        GitHubConnectorManager connectorManager;
        String settingsRedirectUri;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                connectorManager = this.this$0.getConnectorManager();
                String queryParameter = this.$uri.getQueryParameter("code");
                settingsRedirectUri = this.this$0.getSettingsRedirectUri();
                this.label = 1;
                if (connectorManager.completeOAuthCallback(queryParameter, settingsRedirectUri, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.setResult(-1);
        } catch (Exception e) {
            GitHubConnectorError gitHubConnectorError = e instanceof GitHubConnectorError ? (GitHubConnectorError) e : null;
            if ((gitHubConnectorError == null || (message = gitHubConnectorError.localizedMessage((Context) this.this$0)) == null) && (message = e.getMessage()) == null) {
                message = "";
            }
            Toast.makeText((Context) this.this$0, this.this$0.getString(C0820R.string.trae_setting_connector_connect_failed) + ": " + message, 0).show();
            this.this$0.setResult(0);
        }
        this.this$0.finish();
        return Unit.INSTANCE;
    }
}
