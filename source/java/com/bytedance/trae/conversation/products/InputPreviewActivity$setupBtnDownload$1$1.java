package com.bytedance.trae.conversation.products;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputPreviewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.InputPreviewActivity$setupBtnDownload$1$1", f = "InputPreviewActivity.kt", i = {}, l = {694}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InputPreviewActivity$setupBtnDownload$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isLocalWork;
    int label;
    final /* synthetic */ InputPreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputPreviewActivity$setupBtnDownload$1$1(InputPreviewActivity inputPreviewActivity, boolean z, Continuation<? super InputPreviewActivity$setupBtnDownload$1$1> continuation) {
        super(2, continuation);
        this.this$0 = inputPreviewActivity;
        this.$isLocalWork = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InputPreviewActivity$setupBtnDownload$1$1(this.this$0, this.$isLocalWork, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        FileDownloadHelper fileDownloadHelper;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z;
        Function3 function3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.fetchFileUrl((Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        String str8 = (String) obj;
        if (TextUtils.isEmpty(str8) || str8 == null) {
            this.this$0.showError();
            return Unit.INSTANCE;
        }
        this.this$0.fileUrl = str8;
        fileDownloadHelper = this.this$0.fileDownloadHelper;
        Application application = AppHost.INSTANCE.getApplication();
        str = this.this$0.fileUrl;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
            str2 = null;
        } else {
            str2 = str;
        }
        str3 = this.this$0.conversationId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("conversationId");
            str4 = null;
        } else {
            str4 = str3;
        }
        if (this.$isLocalWork) {
            str5 = this.this$0.oidId;
            if (str5 == null) {
                str6 = "oidId";
                Intrinsics.throwUninitializedPropertyAccessException(str6);
                str7 = null;
            }
            str7 = str5;
        } else {
            str5 = this.this$0.fileName;
            if (str5 == null) {
                str6 = "fileName";
                Intrinsics.throwUninitializedPropertyAccessException(str6);
                str7 = null;
            }
            str7 = str5;
        }
        z = this.this$0.needDecode;
        CoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this.this$0);
        function3 = this.this$0.downloadFinishCallback;
        fileDownloadHelper.saveFileAndLoading(application, str2, str4, str7, lifecycleScope, function3, (r22 & 64) != 0 ? false : z, (r22 & 128) != 0 ? 0L : 0L);
        return Unit.INSTANCE;
    }
}
