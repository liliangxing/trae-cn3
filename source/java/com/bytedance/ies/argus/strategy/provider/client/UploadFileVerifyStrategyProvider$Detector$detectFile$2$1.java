package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.strategy.provider.client.UploadFileVerifyStrategyProvider;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UploadFileVerifyStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.ies.argus.strategy.provider.client.UploadFileVerifyStrategyProvider$Detector$detectFile$2$1", f = "UploadFileVerifyStrategyProvider.kt", i = {}, l = {294}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class UploadFileVerifyStrategyProvider$Detector$detectFile$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UploadFileVerifyStrategyProvider.DetectResult>, Object> {
    final /* synthetic */ InputStream $ins;
    int label;
    final /* synthetic */ UploadFileVerifyStrategyProvider.Detector this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadFileVerifyStrategyProvider$Detector$detectFile$2$1(UploadFileVerifyStrategyProvider.Detector detector, InputStream inputStream, Continuation<? super UploadFileVerifyStrategyProvider$Detector$detectFile$2$1> continuation) {
        super(2, continuation);
        this.this$0 = detector;
        this.$ins = inputStream;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UploadFileVerifyStrategyProvider$Detector$detectFile$2$1(this.this$0, this.$ins, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super UploadFileVerifyStrategyProvider.DetectResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UploadFileVerifyStrategyProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ies.argus.strategy.provider.client.UploadFileVerifyStrategyProvider$Detector$detectFile$2$1$1", f = "UploadFileVerifyStrategyProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.ies.argus.strategy.provider.client.UploadFileVerifyStrategyProvider$Detector$detectFile$2$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class C11651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UploadFileVerifyStrategyProvider.DetectResult>, Object> {
        final /* synthetic */ InputStream $ins;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ UploadFileVerifyStrategyProvider.Detector this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11651(UploadFileVerifyStrategyProvider.Detector detector, InputStream inputStream, Continuation<? super C11651> continuation) {
            super(2, continuation);
            this.this$0 = detector;
            this.$ins = inputStream;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c11651 = new C11651(this.this$0, this.$ins, continuation);
            c11651.L$0 = obj;
            return c11651;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super UploadFileVerifyStrategyProvider.DetectResult> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return this.this$0.detectFileInner((CoroutineScope) this.L$0, this.$ins);
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new C11651(this.this$0, this.$ins, null), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
