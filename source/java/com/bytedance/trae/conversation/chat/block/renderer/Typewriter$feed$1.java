package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Typewriter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.Typewriter$feed$1", f = "Typewriter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class Typewriter$feed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $text;
    int label;
    final /* synthetic */ Typewriter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Typewriter$feed$1(Typewriter typewriter, String str, Continuation<? super Typewriter$feed$1> continuation) {
        super(2, continuation);
        this.this$0 = typewriter;
        this.$text = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Typewriter$feed$1(this.this$0, this.$text, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z;
        int i;
        int i2;
        Job job;
        CoroutineScope coroutineScope;
        int i3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            z = this.this$0.cancelled;
            if (z) {
                return Unit.INSTANCE;
            }
            i = this.this$0.end;
            this.this$0.fullText = this.$text;
            this.this$0.end = this.$text.length();
            i2 = this.this$0.end;
            if (i2 > i) {
                Typewriter typewriter = this.this$0;
                i3 = typewriter.remainingBytes;
                String substring = this.$text.substring(i);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                typewriter.remainingBytes = i3 + StringsKt.encodeToByteArray(substring).length;
            }
            job = this.this$0.job;
            boolean z2 = false;
            if (job != null && job.isActive()) {
                z2 = true;
            }
            if (!z2) {
                Typewriter typewriter2 = this.this$0;
                coroutineScope = Typewriter.scope;
                typewriter2.job = BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C06961(this.this$0, null), 3, (Object) null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Typewriter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.Typewriter$feed$1$1", f = "Typewriter.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.chat.block.renderer.Typewriter$feed$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ Typewriter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06961(Typewriter typewriter, Continuation<? super C06961> continuation) {
            super(2, continuation);
            this.this$0 = typewriter;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06961(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object loop;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                loop = this.this$0.loop((Continuation) this);
                if (loop == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
