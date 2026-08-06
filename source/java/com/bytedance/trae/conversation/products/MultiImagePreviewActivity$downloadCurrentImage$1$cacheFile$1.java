package com.bytedance.trae.conversation.products;

import android.net.Uri;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
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
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MultiImagePreviewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.MultiImagePreviewActivity$downloadCurrentImage$1$cacheFile$1", f = "MultiImagePreviewActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class MultiImagePreviewActivity$downloadCurrentImage$1$cacheFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ String $fileName;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ MultiImagePreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImagePreviewActivity$downloadCurrentImage$1$cacheFile$1(MultiImagePreviewActivity multiImagePreviewActivity, String str, String str2, Continuation<? super MultiImagePreviewActivity$downloadCurrentImage$1$cacheFile$1> continuation) {
        super(2, continuation);
        this.this$0 = multiImagePreviewActivity;
        this.$url = str;
        this.$fileName = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiImagePreviewActivity$downloadCurrentImage$1$cacheFile$1(this.this$0, this.$url, this.$fileName, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        File copyLocalUriToCache;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        MultiImagePreviewActivity multiImagePreviewActivity = this.this$0;
        Uri parse = Uri.parse(this.$url);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        copyLocalUriToCache = multiImagePreviewActivity.copyLocalUriToCache(parse, this.$fileName);
        return copyLocalUriToCache;
    }
}
