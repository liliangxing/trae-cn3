package com.bytedance.trae.conversation.products;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
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
/* compiled from: InputPreviewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.InputPreviewActivity$showDownloadOnly$2$1", f = "InputPreviewActivity.kt", i = {}, l = {599}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InputPreviewActivity$showDownloadOnly$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isLocalWork;
    int label;
    final /* synthetic */ InputPreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputPreviewActivity$showDownloadOnly$2$1(InputPreviewActivity inputPreviewActivity, boolean z, Continuation<? super InputPreviewActivity$showDownloadOnly$2$1> continuation) {
        super(2, continuation);
        this.this$0 = inputPreviewActivity;
        this.$isLocalWork = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InputPreviewActivity$showDownloadOnly$2$1(this.this$0, this.$isLocalWork, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x003b, code lost:
    
        if (android.text.TextUtils.isEmpty(r2) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String str;
        Object fetchFileUrl;
        String str2;
        boolean z;
        FileDownloadHelper fileDownloadHelper;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
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
            this.this$0.showLoadingDialog();
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
        String str10 = (String) fetchFileUrl;
        if (TextUtils.isEmpty(str10) || str10 == null) {
            this.this$0.hideLoadingDialog();
            this.this$0.showError();
            return Unit.INSTANCE;
        }
        this.this$0.fileUrl = str10;
        z = this.this$0.needDecode;
        fileDownloadHelper = this.this$0.fileDownloadHelper;
        Application application = AppHost.INSTANCE.getApplication();
        str3 = this.this$0.fileUrl;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
            str4 = null;
        } else {
            str4 = str3;
        }
        str5 = this.this$0.conversationId;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("conversationId");
            str6 = null;
        } else {
            str6 = str5;
        }
        if (this.$isLocalWork) {
            str7 = this.this$0.oidId;
            if (str7 == null) {
                str8 = "oidId";
                Intrinsics.throwUninitializedPropertyAccessException(str8);
                str9 = null;
            }
            str9 = str7;
        } else {
            str7 = this.this$0.fileName;
            if (str7 == null) {
                str8 = "fileName";
                Intrinsics.throwUninitializedPropertyAccessException(str8);
                str9 = null;
            }
            str9 = str7;
        }
        Application application2 = application;
        CoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this.this$0);
        final InputPreviewActivity inputPreviewActivity = this.this$0;
        fileDownloadHelper.saveFileAndLoading(application2, str4, str6, str9, lifecycleScope, new Function3() { // from class: com.bytedance.trae.conversation.products.InputPreviewActivity$showDownloadOnly$2$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                Unit invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = InputPreviewActivity$showDownloadOnly$2$1.invokeSuspend$lambda$0(InputPreviewActivity.this, ((Integer) obj2).intValue(), (String) obj3, ((Long) obj4).longValue());
                return invokeSuspend$lambda$0;
            }
        }, (r22 & 64) != 0 ? false : z, (r22 & 128) != 0 ? 0L : 0L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit invokeSuspend$lambda$0(InputPreviewActivity inputPreviewActivity, int i, String str, long j) {
        inputPreviewActivity.hideLoadingDialog();
        if (i == 0) {
            if (str.length() > 0) {
                inputPreviewActivity.openFileWithExternalApp(str);
                return Unit.INSTANCE;
            }
        }
        CustomToast.showLong((Context) inputPreviewActivity, inputPreviewActivity.getString(R.string.trae_doc_preview_download_failed));
        return Unit.INSTANCE;
    }
}
