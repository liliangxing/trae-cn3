package com.bytedance.trae.conversation.devices;

import com.bytedance.trae.conversation.devices.DirectoryEvent;
import com.bytedance.trae.conversation.network.CheckAuthorizationData;
import com.bytedance.trae.conversation.network.IGetProjectApi;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DirectoryViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.devices.DirectoryViewModel$checkNeedAuthorization$1", f = "DirectoryViewModel.kt", i = {}, l = {652, 658, 665}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DirectoryViewModel$checkNeedAuthorization$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ Function1<Boolean, Unit> $onResult;
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ DirectoryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DirectoryViewModel$checkNeedAuthorization$1(String str, String str2, Function1<? super Boolean, Unit> function1, DirectoryViewModel directoryViewModel, Continuation<? super DirectoryViewModel$checkNeedAuthorization$1> continuation) {
        super(2, continuation);
        this.$id = str;
        this.$path = str2;
        this.$onResult = function1;
        this.this$0 = directoryViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DirectoryViewModel$checkNeedAuthorization$1(this.$id, this.$path, this.$onResult, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableSharedFlow mutableSharedFlow;
        String errorMessage;
        MutableSharedFlow mutableSharedFlow2;
        String errorMessage2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Map<String, String> mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("cli_id", this.$id), TuplesKt.to("path", this.$path)});
            this.label = 1;
            obj = IGetProjectApi.INSTANCE.checkNeedAuthorizationRawCall(mapOf, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2 && i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        HttpDataResult.Success success = (HttpDataResult) obj;
        if (success instanceof HttpDataResult.Success) {
            BizResponse bizResp = success.getBizResp();
            if (!bizResp.isSuccess()) {
                mutableSharedFlow2 = this.this$0._events;
                errorMessage2 = this.this$0.errorMessage(bizResp.getCode(), bizResp.getMsg(), R.string.trae_dir_check_auth_failed);
                this.label = 2;
                if (mutableSharedFlow2.emit(new DirectoryEvent.ShowToast(errorMessage2), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                Function1<Boolean, Unit> function1 = this.$onResult;
                if (function1 != null) {
                    CheckAuthorizationData checkAuthorizationData = (CheckAuthorizationData) bizResp.getData();
                    function1.invoke(Boxing.boxBoolean(checkAuthorizationData != null ? checkAuthorizationData.getNeedAuthorization() : false));
                }
            }
        } else if (success instanceof HttpDataResult.Error) {
            mutableSharedFlow = this.this$0._events;
            HttpDataResult.Error error = (HttpDataResult.Error) success;
            errorMessage = this.this$0.errorMessage(error.getCode(), error.getMsg(), R.string.trae_dir_check_auth_failed);
            this.label = 3;
            if (mutableSharedFlow.emit(new DirectoryEvent.ShowToast(errorMessage), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }
}
