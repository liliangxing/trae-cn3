package com.bytedance.trae.conversation.widget;

import android.net.Uri;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputAttachmentListModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.widget.InputAttachmentListModel$uploadWithFakeProgress$2", f = "InputAttachmentListModel.kt", i = {0}, l = {759}, m = "invokeSuspend", n = {"fakeProgressJob"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InputAttachmentListModel$uploadWithFakeProgress$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $itemUri;
    final /* synthetic */ Function2<Function1<? super Integer, Unit>, Continuation<? super Unit>, Object> $uploadBlock;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InputAttachmentListModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAttachmentListModel$uploadWithFakeProgress$2(InputAttachmentListModel inputAttachmentListModel, Uri uri, Function2<? super Function1<? super Integer, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super InputAttachmentListModel$uploadWithFakeProgress$2> continuation) {
        super(2, continuation);
        this.this$0 = inputAttachmentListModel;
        this.$itemUri = uri;
        this.$uploadBlock = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> inputAttachmentListModel$uploadWithFakeProgress$2 = new InputAttachmentListModel$uploadWithFakeProgress$2(this.this$0, this.$itemUri, this.$uploadBlock, continuation);
        inputAttachmentListModel$uploadWithFakeProgress$2.L$0 = obj;
        return inputAttachmentListModel$uploadWithFakeProgress$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ConcurrentHashMap concurrentHashMap;
        Job job;
        ConcurrentHashMap concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            final Ref.IntRef intRef = new Ref.IntRef();
            final Ref.IntRef intRef2 = new Ref.IntRef();
            final Ref.IntRef intRef3 = new Ref.IntRef();
            Job launch$default = BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C0811x50a31241(intRef, intRef2, intRef3, this.this$0, this.$itemUri, null), 3, (Object) null);
            concurrentHashMap = this.this$0.fakeProgressJobs;
            concurrentHashMap.put(this.$itemUri, launch$default);
            try {
                Function2<Function1<? super Integer, Unit>, Continuation<? super Unit>, Object> function2 = this.$uploadBlock;
                final InputAttachmentListModel inputAttachmentListModel = this.this$0;
                final Uri uri = this.$itemUri;
                Function1 function1 = new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        Unit invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = InputAttachmentListModel$uploadWithFakeProgress$2.invokeSuspend$lambda$1(intRef2, intRef, intRef3, inputAttachmentListModel, uri, ((Integer) obj2).intValue());
                        return invokeSuspend$lambda$1;
                    }
                };
                this.L$0 = launch$default;
                this.label = 1;
                if (function2.invoke(function1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                job = launch$default;
            } catch (Throwable th) {
                th = th;
                job = launch$default;
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                concurrentHashMap2 = this.this$0.fakeProgressJobs;
                concurrentHashMap2.remove(this.$itemUri);
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            job = (Job) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                concurrentHashMap2 = this.this$0.fakeProgressJobs;
                concurrentHashMap2.remove(this.$itemUri);
                throw th;
            }
        }
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        concurrentHashMap3 = this.this$0.fakeProgressJobs;
        concurrentHashMap3.remove(this.$itemUri);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$updateDisplayedProgress(Ref.IntRef intRef, Ref.IntRef intRef2, final Ref.IntRef intRef3, InputAttachmentListModel inputAttachmentListModel, Uri uri) {
        int max;
        if (intRef.element > 30) {
            max = intRef.element;
        } else {
            max = Math.max(intRef2.element, intRef.element);
        }
        if (max > intRef3.element) {
            intRef3.element = max;
            inputAttachmentListModel.updateItem(uri, new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    AttachmentItem invokeSuspend$updateDisplayedProgress$lambda$0;
                    invokeSuspend$updateDisplayedProgress$lambda$0 = InputAttachmentListModel$uploadWithFakeProgress$2.invokeSuspend$updateDisplayedProgress$lambda$0(intRef3, (AttachmentItem) obj);
                    return invokeSuspend$updateDisplayedProgress$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AttachmentItem invokeSuspend$updateDisplayedProgress$lambda$0(Ref.IntRef intRef, AttachmentItem attachmentItem) {
        AttachmentItem copy;
        copy = attachmentItem.copy((r30 & 1) != 0 ? attachmentItem.bucketId : 0L, (r30 & 2) != 0 ? attachmentItem.id : 0L, (r30 & 4) != 0 ? attachmentItem.fileName : null, (r30 & 8) != 0 ? attachmentItem.uri : null, (r30 & 16) != 0 ? attachmentItem.mimeType : null, (r30 & 32) != 0 ? attachmentItem.sizeBytes : 0L, (r30 & 64) != 0 ? attachmentItem.isImage : false, (r30 & 128) != 0 ? attachmentItem.uploadStatus : null, (r30 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? attachmentItem.uploadProgress : intRef.element, (r30 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? attachmentItem.uploadedOid : null, (r30 & 1024) != 0 ? attachmentItem.uploadError : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, InputAttachmentListModel inputAttachmentListModel, Uri uri, int i) {
        intRef.element = Math.min(i, 99);
        invokeSuspend$updateDisplayedProgress(intRef, intRef2, intRef3, inputAttachmentListModel, uri);
        return Unit.INSTANCE;
    }
}
