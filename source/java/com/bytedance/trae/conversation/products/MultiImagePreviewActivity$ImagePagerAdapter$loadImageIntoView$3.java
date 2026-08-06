package com.bytedance.trae.conversation.products;

import android.net.Uri;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.products.MultiImagePreviewActivity;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MultiImagePreviewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$3", f = "MultiImagePreviewActivity.kt", i = {}, l = {964}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MultiImagePreviewActivity.ImagePagerAdapter.ImageViewHolder $holder;
    final /* synthetic */ String $path;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ MultiImagePreviewActivity.ImagePagerAdapter this$0;
    final /* synthetic */ MultiImagePreviewActivity this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$3(MultiImagePreviewActivity.ImagePagerAdapter.ImageViewHolder imageViewHolder, String str, MultiImagePreviewActivity.ImagePagerAdapter imagePagerAdapter, MultiImagePreviewActivity multiImagePreviewActivity, String str2, Continuation<? super MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$3> continuation) {
        super(2, continuation);
        this.$holder = imageViewHolder;
        this.$path = str;
        this.this$0 = imagePagerAdapter;
        this.this$1 = multiImagePreviewActivity;
        this.$url = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$3(this.$holder, this.$path, this.this$0, this.this$1, this.$url, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new C0774x436deda4(this.this$1, this.$url, this.$path, null), (Continuation) this);
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
        if (!Intrinsics.areEqual(this.$holder.getBoundPath(), this.$path)) {
            return Unit.INSTANCE;
        }
        if (file != null && file.exists() && file.length() > 0) {
            MultiImagePreviewActivity.ImagePagerAdapter imagePagerAdapter = this.this$0;
            MultiImagePreviewActivity.ImagePagerAdapter.ImageViewHolder imageViewHolder = this.$holder;
            Uri fromFile = Uri.fromFile(file);
            Intrinsics.checkNotNullExpressionValue(fromFile, "fromFile(...)");
            imagePagerAdapter.loadUri(imageViewHolder, fromFile);
        }
        return Unit.INSTANCE;
    }
}
