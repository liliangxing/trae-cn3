package com.bytedance.trae.conversation.products;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileDownloadHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.FileDownloadHelper$copyCachedFileAndLoadingInternal$1", f = "FileDownloadHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FileDownloadHelper$copyCachedFileAndLoadingInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $cacheFile;
    final /* synthetic */ Context $context;
    final /* synthetic */ long $createTime;
    final /* synthetic */ Function3<Integer, String, Long, Unit> $dismissLoadingCallback;
    final /* synthetic */ String $fileName;
    final /* synthetic */ String $sessionId;
    int label;
    final /* synthetic */ FileDownloadHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FileDownloadHelper$copyCachedFileAndLoadingInternal$1(FileDownloadHelper fileDownloadHelper, Context context, File file, String str, String str2, long j, Function3<? super Integer, ? super String, ? super Long, Unit> function3, Continuation<? super FileDownloadHelper$copyCachedFileAndLoadingInternal$1> continuation) {
        super(2, continuation);
        this.this$0 = fileDownloadHelper;
        this.$context = context;
        this.$cacheFile = file;
        this.$sessionId = str;
        this.$fileName = str2;
        this.$createTime = j;
        this.$dismissLoadingCallback = function3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileDownloadHelper$copyCachedFileAndLoadingInternal$1(this.this$0, this.$context, this.$cacheFile, this.$sessionId, this.$fileName, this.$createTime, this.$dismissLoadingCallback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Function1 function1;
        Pair copyCachedFile;
        Function1 function12;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            copyCachedFile = this.this$0.copyCachedFile(this.$context, this.$cacheFile, this.$sessionId, this.$fileName, this.$createTime);
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            Function3<Integer, String, Long, Unit> function3 = this.$dismissLoadingCallback;
            if (function3 != null) {
                function3.invoke(copyCachedFile.getFirst(), copyCachedFile.getSecond(), Boxing.boxLong(elapsedRealtime2));
            }
            function12 = this.this$0.downloadFinishBlk;
            function12.invoke(this.$fileName);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            function1 = this.this$0.downloadFinishBlk;
            function1.invoke(this.$fileName);
            throw th;
        }
    }
}
