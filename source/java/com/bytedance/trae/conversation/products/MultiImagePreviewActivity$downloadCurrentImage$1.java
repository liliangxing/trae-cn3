package com.bytedance.trae.conversation.products;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.multilanguage.R;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MultiImagePreviewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.MultiImagePreviewActivity$downloadCurrentImage$1", f = "MultiImagePreviewActivity.kt", i = {}, l = {570}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MultiImagePreviewActivity$downloadCurrentImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fileName;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ MultiImagePreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImagePreviewActivity$downloadCurrentImage$1(MultiImagePreviewActivity multiImagePreviewActivity, String str, String str2, Continuation<? super MultiImagePreviewActivity$downloadCurrentImage$1> continuation) {
        super(2, continuation);
        this.this$0 = multiImagePreviewActivity;
        this.$fileName = str;
        this.$url = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiImagePreviewActivity$downloadCurrentImage$1(this.this$0, this.$fileName, this.$url, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        FileDownloadHelper fileDownloadHelper;
        Function3 function3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new MultiImagePreviewActivity$downloadCurrentImage$1$cacheFile$1(this.this$0, this.$url, this.$fileName, null), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        File file = (File) obj;
        if (file != null) {
            fileDownloadHelper = this.this$0.fileDownloadHelper;
            LifecycleOwner lifecycleOwner = this.this$0;
            String str = this.$fileName;
            CoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner);
            function3 = this.this$0.downloadFinishCallback;
            fileDownloadHelper.copyCachedFileAndLoading((Context) lifecycleOwner, file, "", str, lifecycleScope, function3, (r20 & 64) != 0 ? 0L : 0L);
            return Unit.INSTANCE;
        }
        MultiImagePreviewActivity multiImagePreviewActivity = this.this$0;
        CustomToast.showLong((Context) multiImagePreviewActivity, multiImagePreviewActivity.getString(R.string.trae_doc_preview_download_failed));
        return Unit.INSTANCE;
    }
}
