package com.bytedance.trae.conversation.products;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
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
@DebugMetadata(c = "com.bytedance.trae.conversation.products.FileDownloadHelper$saveFileAndLoadingInternal$1", f = "FileDownloadHelper.kt", i = {0}, l = {381}, m = "invokeSuspend", n = {"startTimeStamp"}, s = {"J$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FileDownloadHelper$saveFileAndLoadingInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ long $createTime;
    final /* synthetic */ Function3<Integer, String, Long, Unit> $dismissLoadingCallback;
    final /* synthetic */ String $fileName;
    final /* synthetic */ boolean $needDecode;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ String $url;
    long J$0;
    int label;
    final /* synthetic */ FileDownloadHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FileDownloadHelper$saveFileAndLoadingInternal$1(FileDownloadHelper fileDownloadHelper, Context context, String str, String str2, String str3, boolean z, long j, Function3<? super Integer, ? super String, ? super Long, Unit> function3, Continuation<? super FileDownloadHelper$saveFileAndLoadingInternal$1> continuation) {
        super(2, continuation);
        this.this$0 = fileDownloadHelper;
        this.$context = context;
        this.$url = str;
        this.$sessionId = str2;
        this.$fileName = str3;
        this.$needDecode = z;
        this.$createTime = j;
        this.$dismissLoadingCallback = function3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileDownloadHelper$saveFileAndLoadingInternal$1(this.this$0, this.$context, this.$url, this.$sessionId, this.$fileName, this.$needDecode, this.$createTime, this.$dismissLoadingCallback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Function1 function1;
        long j;
        Function1 function12;
        Function1 function13;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.J$0 = elapsedRealtime;
                this.label = 1;
                obj = this.this$0.downloadFile(this.$context, this.$url, this.$sessionId, this.$fileName, this.$needDecode, this.$createTime, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j = elapsedRealtime;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.J$0;
                ResultKt.throwOnFailure(obj);
            }
            Pair pair = (Pair) obj;
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - j;
            Function3<Integer, String, Long, Unit> function3 = this.$dismissLoadingCallback;
            if (function3 != null) {
                function3.invoke(pair.getFirst(), pair.getSecond(), Boxing.boxLong(elapsedRealtime2));
            }
            function12 = this.this$0.downloadFinishBlk;
            function12.invoke(this.$fileName);
            function13 = this.this$0.downloadFinishBlk;
            function13.invoke(this.$fileName);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            function1 = this.this$0.downloadFinishBlk;
            function1.invoke(this.$fileName);
            throw th;
        }
    }
}
