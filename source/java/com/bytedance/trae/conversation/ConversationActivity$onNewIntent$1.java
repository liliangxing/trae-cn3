package com.bytedance.trae.conversation;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import com.bytedance.trae.conversation.git.GitHubConnectorAuthorization;
import com.bytedance.trae.conversation.git.GitHubConnectorError;
import com.bytedance.trae.conversation.git.GitHubConnectorManager;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.widget.InputFragment;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ConversationActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$onNewIntent$1", f = "ConversationActivity.kt", i = {}, l = {2410}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class ConversationActivity$onNewIntent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationActivity$onNewIntent$1(ConversationActivity conversationActivity, Uri uri, Continuation<? super ConversationActivity$onNewIntent$1> continuation) {
        super(2, continuation);
        this.this$0 = conversationActivity;
        this.$uri = uri;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> conversationActivity$onNewIntent$1 = new ConversationActivity$onNewIntent$1(this.this$0, this.$uri, continuation);
        conversationActivity$onNewIntent$1.L$0 = obj;
        return conversationActivity$onNewIntent$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        String message;
        InputFragment inputFragment;
        GitHubConnectorManager gitHubConnectorManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ConversationActivity conversationActivity = this.this$0;
                Uri uri = this.$uri;
                Result.Companion companion = Result.Companion;
                gitHubConnectorManager = conversationActivity.getGitHubConnectorManager();
                String queryParameter = uri.getQueryParameter("code");
                this.label = 1;
                obj = GitHubConnectorManager.completeOAuthCallback$default(gitHubConnectorManager, queryParameter, null, this, 2, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            obj2 = Result.constructor-impl((GitHubConnectorAuthorization) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        ConversationActivity conversationActivity2 = this.this$0;
        if (Result.isSuccess-impl(obj2)) {
            inputFragment = conversationActivity2.getInputFragment();
            inputFragment.loadGitRepos();
        }
        ConversationActivity conversationActivity3 = this.this$0;
        Throwable th2 = Result.exceptionOrNull-impl(obj2);
        if (th2 != null) {
            GitHubConnectorError gitHubConnectorError = th2 instanceof GitHubConnectorError ? (GitHubConnectorError) th2 : null;
            if ((gitHubConnectorError == null || (message = gitHubConnectorError.localizedMessage((Context) conversationActivity3)) == null) && (message = th2.getMessage()) == null) {
                message = conversationActivity3.getString(com.bytedance.trae.multilanguage.R.string.trae_github_error_check_token_failed);
                Intrinsics.checkNotNullExpressionValue(message, "getString(...)");
            }
            Toast.makeText((Context) conversationActivity3, message, 0).show();
        }
        return Unit.INSTANCE;
    }
}
