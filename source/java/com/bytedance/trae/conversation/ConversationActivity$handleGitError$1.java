package com.bytedance.trae.conversation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.bytedance.trae.common.widget.CustomConfirmDialog;
import com.bytedance.trae.conversation.git.GitHubConnectorError;
import com.bytedance.trae.conversation.git.GitHubConnectorManager;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$handleGitError$1", f = "ConversationActivity.kt", i = {0}, l = {1836}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationActivity$handleGitError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationActivity$handleGitError$1(ConversationActivity conversationActivity, Continuation<? super ConversationActivity$handleGitError$1> continuation) {
        super(2, continuation);
        this.this$0 = conversationActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> conversationActivity$handleGitError$1 = new ConversationActivity$handleGitError$1(this.this$0, continuation);
        conversationActivity$handleGitError$1.L$0 = obj;
        return conversationActivity$handleGitError$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        GitHubConnectorError gitHubConnectorError;
        String string;
        Object obj3;
        String message;
        GitHubConnectorManager gitHubConnectorManager;
        GitHubConnectorManager gitHubConnectorManager2;
        Object checkToken;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                ConversationActivity conversationActivity = this.this$0;
                Result.Companion companion = Result.Companion;
                gitHubConnectorManager2 = conversationActivity.getGitHubConnectorManager();
                this.L$0 = coroutineScope;
                this.label = 1;
                checkToken = gitHubConnectorManager2.checkToken(this);
                if (checkToken == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                checkToken = obj;
            }
            obj2 = Result.constructor-impl((String) checkToken);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        ConversationActivity conversationActivity2 = this.this$0;
        Throwable th2 = Result.exceptionOrNull-impl(obj2);
        if (th2 == null) {
            this.this$0.hideLoading();
            String str = (String) obj2;
            if (str == null || StringsKt.isBlank(str)) {
                ConversationActivity conversationActivity3 = this.this$0;
                try {
                    Result.Companion companion3 = Result.Companion;
                    gitHubConnectorManager = conversationActivity3.getGitHubConnectorManager();
                    obj3 = Result.constructor-impl(GitHubConnectorManager.buildOAuthUrl$default(gitHubConnectorManager, null, 1, null));
                } catch (Throwable th3) {
                    Result.Companion companion4 = Result.Companion;
                    obj3 = Result.constructor-impl(ResultKt.createFailure(th3));
                }
                ConversationActivity conversationActivity4 = this.this$0;
                Throwable th4 = Result.exceptionOrNull-impl(obj3);
                if (th4 != null) {
                    gitHubConnectorError = th4 instanceof GitHubConnectorError ? (GitHubConnectorError) th4 : null;
                    if ((gitHubConnectorError == null || (message = gitHubConnectorError.localizedMessage((Context) conversationActivity4)) == null) && (message = th4.getMessage()) == null) {
                        message = conversationActivity4.getString(com.bytedance.trae.multilanguage.R.string.trae_github_error_check_token_failed);
                        Intrinsics.checkNotNullExpressionValue(message, "getString(...)");
                    }
                    Toast.makeText((Context) conversationActivity4, message, 0).show();
                    return Unit.INSTANCE;
                }
                final String str2 = (String) obj3;
                Context context = (Context) this.this$0;
                String string2 = this.this$0.getString(com.bytedance.trae.multilanguage.R.string.trae_github_connect_title);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                String string3 = this.this$0.getString(com.bytedance.trae.multilanguage.R.string.trae_github_connect_message);
                String string4 = this.this$0.getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_dialog_btn_cancel);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                String string5 = this.this$0.getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_dialog_btn_confirm);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                final ConversationActivity conversationActivity5 = this.this$0;
                new CustomConfirmDialog(context, new CustomConfirmDialog.Config(string2, string3, null, null, string4, string5, null, 0.0f, null, null, null, null, 0, 0, 0, null, null, null, false, new Function1() { // from class: com.bytedance.trae.conversation.ConversationActivity$handleGitError$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj4) {
                        Unit invokeSuspend$lambda$4;
                        invokeSuspend$lambda$4 = ConversationActivity$handleGitError$1.invokeSuspend$lambda$4(ConversationActivity.this, str2, (String) obj4);
                        return invokeSuspend$lambda$4;
                    }
                }, null, 1572812, null)).show();
            } else {
                Toast.makeText((Context) this.this$0, com.bytedance.trae.multilanguage.R.string.trae_conversation_network_retry, 0).show();
            }
            return Unit.INSTANCE;
        }
        conversationActivity2.hideLoading();
        gitHubConnectorError = th2 instanceof GitHubConnectorError ? (GitHubConnectorError) th2 : null;
        if (gitHubConnectorError == null || (string = gitHubConnectorError.localizedMessage((Context) conversationActivity2)) == null) {
            string = conversationActivity2.getString(com.bytedance.trae.multilanguage.R.string.trae_github_error_check_token_failed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        Toast.makeText((Context) conversationActivity2, string, 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit invokeSuspend$lambda$4(ConversationActivity conversationActivity, String str, String str2) {
        try {
            conversationActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Throwable unused) {
            Toast.makeText((Context) conversationActivity, conversationActivity.getString(com.bytedance.trae.multilanguage.R.string.trae_github_error_check_token_failed), 0).show();
        }
        return Unit.INSTANCE;
    }
}
