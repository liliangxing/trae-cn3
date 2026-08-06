package com.bytedance.trae.login.service;

import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.trae.utils.logger.FLogger;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.service.LoginServiceImpl$uploadAvatarOversea$1", f = "LoginServiceImpl.kt", i = {}, l = {250}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LoginServiceImpl$uploadAvatarOversea$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Long, Unit> $onFail;
    final /* synthetic */ Function1<String, Unit> $onSuccess;
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ LoginServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LoginServiceImpl$uploadAvatarOversea$1(String str, Function1<? super Long, Unit> function1, LoginServiceImpl loginServiceImpl, Function1<? super String, Unit> function12, Continuation<? super LoginServiceImpl$uploadAvatarOversea$1> continuation) {
        super(2, continuation);
        this.$path = str;
        this.$onFail = function1;
        this.this$0 = loginServiceImpl;
        this.$onSuccess = function12;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginServiceImpl$uploadAvatarOversea$1(this.$path, this.$onFail, this.this$0, this.$onSuccess, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0081, code lost:
    
        r9.this$0.syncLocalUserInfo(kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to("avatar", r1)));
        r9.$onSuccess.invoke(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                File file = new File(this.$path);
                if (!file.exists()) {
                    this.$onFail.invoke(Boxing.boxLong(-1L));
                    return Unit.INSTANCE;
                }
                TypedFile typedFile = new TypedFile("image/jpeg", file);
                this.label = 1;
                obj = IOverseaProfileApi.INSTANCE.create().uploadAvatar(typedFile, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            OverseaUploadAvatarResponse overseaUploadAvatarResponse = (OverseaUploadAvatarResponse) obj;
            OverseaUploadAvatarData data = overseaUploadAvatarResponse.getData();
            String webUri = data != null ? data.getWebUri() : null;
            if (Intrinsics.areEqual(overseaUploadAvatarResponse.getMessage(), "success")) {
                String str = webUri;
                if (str != null && str.length() != 0) {
                    z = false;
                }
            }
            FLogger fLogger = FLogger.INSTANCE;
            StringBuilder sb = new StringBuilder("uploadAvatarOversea failed: errorCode=");
            OverseaUploadAvatarData data2 = overseaUploadAvatarResponse.getData();
            StringBuilder append = sb.append(data2 != null ? Boxing.boxInt(data2.getErrorCode()) : null).append(", desc=");
            OverseaUploadAvatarData data3 = overseaUploadAvatarResponse.getData();
            fLogger.mo426e("LoginServiceImpl", append.append(data3 != null ? data3.getDescription() : null).toString());
            this.$onFail.invoke(Boxing.boxLong(overseaUploadAvatarResponse.getData() != null ? r10.getErrorCode() : -1L));
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e("LoginServiceImpl", "uploadAvatarOversea exception: " + e.getMessage());
            this.$onFail.invoke(Boxing.boxLong(-1L));
        }
        return Unit.INSTANCE;
    }
}
