package com.bytedance.trae.conversation.products;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.multilanguage.R;
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
/* compiled from: ArtifactPreviewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.ArtifactPreviewActivity$showDownloadOnly$2$1", f = "ArtifactPreviewActivity.kt", i = {}, l = {776}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactPreviewActivity$showDownloadOnly$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ArtifactPreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactPreviewActivity$showDownloadOnly$2$1(ArtifactPreviewActivity artifactPreviewActivity, Continuation<? super ArtifactPreviewActivity$showDownloadOnly$2$1> continuation) {
        super(2, continuation);
        this.this$0 = artifactPreviewActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArtifactPreviewActivity$showDownloadOnly$2$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x003b, code lost:
    
        if (android.text.TextUtils.isEmpty(r2) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String str;
        Object fetchFileUrl;
        String str2;
        String str3;
        FileDownloadHelper fileDownloadHelper;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        long j;
        String str10;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            str = this.this$0.fileUrl;
            if (str != null) {
                str2 = this.this$0.fileUrl;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
                    str2 = null;
                }
            }
            this.label = 1;
            fetchFileUrl = this.this$0.fetchFileUrl((Continuation) this);
            if (fetchFileUrl == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            fetchFileUrl = obj;
        }
        String str11 = (String) fetchFileUrl;
        if (TextUtils.isEmpty(str11) || str11 == null) {
            this.this$0.showError();
            return Unit.INSTANCE;
        }
        this.this$0.fileUrl = str11;
        str3 = this.this$0.cliType;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cliType");
            str3 = null;
        }
        if (!Intrinsics.areEqual(str3, CliType.LOCAL.getValue())) {
            str10 = this.this$0.cliType;
            if (str10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cliType");
                str10 = null;
            }
            if (!Intrinsics.areEqual(str10, CliType.IDE.getValue())) {
                z = false;
            }
        }
        boolean z2 = z;
        this.this$0.showLoadingDialog();
        fileDownloadHelper = this.this$0.fileDownloadHelper;
        Application application = AppHost.INSTANCE.getApplication();
        str4 = this.this$0.fileUrl;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
            str5 = null;
        } else {
            str5 = str4;
        }
        str6 = this.this$0.chatSessionId;
        if (str6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
            str7 = null;
        } else {
            str7 = str6;
        }
        str8 = this.this$0.path;
        if (str8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("path");
            str9 = null;
        } else {
            str9 = str8;
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this.this$0);
        j = this.this$0.createdTime;
        final ArtifactPreviewActivity artifactPreviewActivity = this.this$0;
        fileDownloadHelper.saveFileAndLoading(application, str5, str7, str9, (CoroutineScope) lifecycleScope, new Function3() { // from class: com.bytedance.trae.conversation.products.ArtifactPreviewActivity$showDownloadOnly$2$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                Unit invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = ArtifactPreviewActivity$showDownloadOnly$2$1.invokeSuspend$lambda$0(ArtifactPreviewActivity.this, ((Integer) obj2).intValue(), (String) obj3, ((Long) obj4).longValue());
                return invokeSuspend$lambda$0;
            }
        }, z2, j);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit invokeSuspend$lambda$0(ArtifactPreviewActivity artifactPreviewActivity, int i, String str, long j) {
        artifactPreviewActivity.hideLoadingDialog();
        if (i == 0) {
            if (str.length() > 0) {
                artifactPreviewActivity.openFileWithExternalApp(str);
                return Unit.INSTANCE;
            }
        }
        CustomToast.showLong((Context) artifactPreviewActivity, artifactPreviewActivity.getString(R.string.trae_doc_preview_download_failed));
        return Unit.INSTANCE;
    }
}
