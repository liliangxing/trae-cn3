package com.bytedance.trae.home.solo.setting;

import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.network.ThirdPartyTokenRepository;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.home.solo.setting.DeleteAccountFragment;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeleteAccountFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.DeleteAccountFragment$init$1", f = "DeleteAccountFragment.kt", i = {0}, l = {186}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeleteAccountFragment$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeleteAccountFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteAccountFragment$init$1(DeleteAccountFragment deleteAccountFragment, Continuation<? super DeleteAccountFragment$init$1> continuation) {
        super(2, continuation);
        this.this$0 = deleteAccountFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deleteAccountFragment$init$1 = new DeleteAccountFragment$init$1(this.this$0, continuation);
        deleteAccountFragment$init$1.L$0 = obj;
        return deleteAccountFragment$init$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        CancelUserCheckResponse cancelUserCheckResponse;
        String str;
        ILoginService iLoginService;
        AccountInfo accountInfo;
        Map<String, String> platformUserNames;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = (CoroutineScope) this.L$0;
                this.label = 1;
                obj = IAccountCancelApi.INSTANCE.userCheck((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            cancelUserCheckResponse = (CancelUserCheckResponse) obj;
        } catch (Exception e) {
            FLogger.INSTANCE.e("DeleteAccountFragment", "init failed: " + e.getMessage());
            DeleteAccountFragment deleteAccountFragment = this.this$0;
            String string = deleteAccountFragment.getString(C0820R.string.trae_delete_check_failed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            deleteAccountFragment.showToast(string);
            if (this.this$0.isAdded()) {
                this.this$0.getParentFragmentManager().popBackStack();
            }
        }
        if (cancelUserCheckResponse.getErrorCode() != 0) {
            DeleteAccountFragment deleteAccountFragment2 = this.this$0;
            String description = cancelUserCheckResponse.getDescription();
            if (description == null && (description = cancelUserCheckResponse.getMessage()) == null) {
                description = this.this$0.getString(C0820R.string.trae_delete_check_failed);
                Intrinsics.checkNotNullExpressionValue(description, "getString(...)");
            }
            deleteAccountFragment2.showToast(description);
            if (!this.this$0.isAdded()) {
                return Unit.INSTANCE;
            }
            this.this$0.getParentFragmentManager().popBackStack();
            return Unit.INSTANCE;
        }
        CancelUserCheckData data = cancelUserCheckResponse.getData();
        this.this$0.valueTicket = data != null ? data.getValueTicket() : null;
        if (!AppHost.INSTANCE.isOversea()) {
            this.this$0.authType = DeleteAccountFragment.AuthType.SMS_CODE;
            DeleteAccountFragment deleteAccountFragment3 = this.this$0;
            try {
                Result.Companion companion = Result.Companion;
                iLoginService = deleteAccountFragment3.loginService;
                str = Result.constructor-impl((iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getPhoneNumber());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                str = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (!Result.isFailure-impl(str)) {
                r3 = str;
            }
            deleteAccountFragment3.userMobile = r3;
        } else {
            if (data == null || data.getAuthType() != 2) {
                z = false;
            }
            if (!z) {
                this.this$0.authType = DeleteAccountFragment.AuthType.EMAIL_CODE;
            } else {
                List<String> oauthPlatforms = data.getOauthPlatforms();
                String str2 = oauthPlatforms != null ? (String) CollectionsKt.firstOrNull(oauthPlatforms) : null;
                if (Intrinsics.areEqual(str2, "google")) {
                    this.this$0.authType = DeleteAccountFragment.AuthType.GOOGLE;
                    DeleteAccountFragment deleteAccountFragment4 = this.this$0;
                    Map<String, String> platformUserNames2 = data.getPlatformUserNames();
                    deleteAccountFragment4.nickname = platformUserNames2 != null ? platformUserNames2.get("google") : null;
                } else if (Intrinsics.areEqual(str2, ThirdPartyTokenRepository.TYPE_GITHUB)) {
                    this.this$0.authType = DeleteAccountFragment.AuthType.GITHUB;
                    DeleteAccountFragment deleteAccountFragment5 = this.this$0;
                    Map<String, String> platformUserNames3 = data.getPlatformUserNames();
                    deleteAccountFragment5.nickname = platformUserNames3 != null ? platformUserNames3.get(ThirdPartyTokenRepository.TYPE_GITHUB) : null;
                } else {
                    this.this$0.authType = DeleteAccountFragment.AuthType.GITHUB;
                    DeleteAccountFragment deleteAccountFragment6 = this.this$0;
                    if (str2 != null && (platformUserNames = data.getPlatformUserNames()) != null) {
                        r3 = platformUserNames.get(str2);
                    }
                    deleteAccountFragment6.nickname = r3;
                }
            }
        }
        this.this$0.showLoading(false);
        this.this$0.showStep(DeleteAccountFragment.Step.VERIFY);
        return Unit.INSTANCE;
    }
}
