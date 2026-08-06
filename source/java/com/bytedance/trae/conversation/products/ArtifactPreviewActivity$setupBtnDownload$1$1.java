package com.bytedance.trae.conversation.products;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleCoroutineScope;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactPreviewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.ArtifactPreviewActivity$setupBtnDownload$1$1", f = "ArtifactPreviewActivity.kt", i = {}, l = {882}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactPreviewActivity$setupBtnDownload$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $needDecode;
    int label;
    final /* synthetic */ ArtifactPreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactPreviewActivity$setupBtnDownload$1$1(ArtifactPreviewActivity artifactPreviewActivity, Ref.BooleanRef booleanRef, Continuation<? super ArtifactPreviewActivity$setupBtnDownload$1$1> continuation) {
        super(2, continuation);
        this.this$0 = artifactPreviewActivity;
        this.$needDecode = booleanRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArtifactPreviewActivity$setupBtnDownload$1$1(this.this$0, this.$needDecode, continuation);
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
        long j;
        Function3<? super Integer, ? super String, ? super Long, Unit> function3;
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
        String str7 = (String) obj;
        if (TextUtils.isEmpty(str7) || str7 == null) {
            this.this$0.showError();
            return Unit.INSTANCE;
        }
        this.this$0.fileUrl = str7;
        fileDownloadHelper = this.this$0.fileDownloadHelper;
        Application application = AppHost.INSTANCE.getApplication();
        str = this.this$0.fileUrl;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
            str2 = null;
        } else {
            str2 = str;
        }
        str3 = this.this$0.chatSessionId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
            str4 = null;
        } else {
            str4 = str3;
        }
        str5 = this.this$0.path;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("path");
            str6 = null;
        } else {
            str6 = str5;
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this.this$0);
        j = this.this$0.createdTime;
        function3 = this.this$0.downloadFinishCallback;
        fileDownloadHelper.saveFileAndLoading(application, str2, str4, str6, (CoroutineScope) lifecycleScope, function3, this.$needDecode.element, j);
        return Unit.INSTANCE;
    }
}
