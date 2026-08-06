package com.bytedance.trae.conversation.products;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: CoroutineExceptionHandler.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: com.bytedance.trae.conversation.products.FileDownloadHelper$copyCachedFileAndLoadingInternal$$inlined$CoroutineExceptionHandler$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0757xf1cea940 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ Function3 $dismissLoadingCallback$inlined;
    final /* synthetic */ String $fileName$inlined;
    final /* synthetic */ FileDownloadHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0757xf1cea940(CoroutineExceptionHandler.Key key, Function3 function3, FileDownloadHelper fileDownloadHelper, String str) {
        super((CoroutineContext.Key) key);
        this.$dismissLoadingCallback$inlined = function3;
        this.this$0 = fileDownloadHelper;
        this.$fileName$inlined = str;
    }

    public void handleException(CoroutineContext context, Throwable exception) {
        Function1 function1;
        int i;
        Function3 function3 = this.$dismissLoadingCallback$inlined;
        if (function3 != null) {
            i = this.this$0.RESULT_CODE_FAILED_CRASH;
            function3.invoke(Integer.valueOf(i), "", 0L);
        }
        function1 = this.this$0.downloadFinishBlk;
        function1.invoke(this.$fileName$inlined);
    }
}
