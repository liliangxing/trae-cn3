package com.bytedance.trae.conversation.widget;

import android.net.Uri;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputAttachmentListModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.widget.InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1", f = "InputAttachmentListModel.kt", i = {}, l = {748}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.trae.conversation.widget.InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0811x50a31241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $backendProgress;
    final /* synthetic */ Ref.IntRef $displayedProgress;
    final /* synthetic */ Ref.IntRef $fakeProgress;
    final /* synthetic */ Uri $itemUri;
    int label;
    final /* synthetic */ InputAttachmentListModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0811x50a31241(Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, InputAttachmentListModel inputAttachmentListModel, Uri uri, Continuation<? super C0811x50a31241> continuation) {
        super(2, continuation);
        this.$fakeProgress = intRef;
        this.$backendProgress = intRef2;
        this.$displayedProgress = intRef3;
        this.this$0 = inputAttachmentListModel;
        this.$itemUri = uri;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0811x50a31241(this.$fakeProgress, this.$backendProgress, this.$displayedProgress, this.this$0, this.$itemUri, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002f -> B:5:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        C0811x50a31241 c0811x50a31241;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c0811x50a31241 = this;
            if (c0811x50a31241.$fakeProgress.element < 30) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            c0811x50a31241 = this;
            Ref.IntRef intRef = c0811x50a31241.$fakeProgress;
            intRef.element = Math.min(intRef.element + 1, 30);
            InputAttachmentListModel$uploadWithFakeProgress$2.invokeSuspend$updateDisplayedProgress(c0811x50a31241.$backendProgress, c0811x50a31241.$fakeProgress, c0811x50a31241.$displayedProgress, c0811x50a31241.this$0, c0811x50a31241.$itemUri);
            if (c0811x50a31241.$fakeProgress.element < 30) {
                c0811x50a31241.label = 1;
                if (DelayKt.delay(200L, (Continuation) c0811x50a31241) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Ref.IntRef intRef2 = c0811x50a31241.$fakeProgress;
                intRef2.element = Math.min(intRef2.element + 1, 30);
                InputAttachmentListModel$uploadWithFakeProgress$2.invokeSuspend$updateDisplayedProgress(c0811x50a31241.$backendProgress, c0811x50a31241.$fakeProgress, c0811x50a31241.$displayedProgress, c0811x50a31241.this$0, c0811x50a31241.$itemUri);
                if (c0811x50a31241.$fakeProgress.element < 30) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
