package com.bytedance.trae.conversation.widget;

import android.net.Uri;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.fileupload.UploadResult;
import com.bytedance.trae.conversation.imageupload.ResourceRepoManager;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.widget.InputAttachmentListModel$addImages$2$1;
import com.bytedance.trae.multilanguage.R;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputAttachmentListModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.widget.InputAttachmentListModel$addImages$2$1", f = "InputAttachmentListModel.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InputAttachmentListModel$addImages$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AttachmentItem $item;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InputAttachmentListModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAttachmentListModel$addImages$2$1(AttachmentItem attachmentItem, InputAttachmentListModel inputAttachmentListModel, Continuation<? super InputAttachmentListModel$addImages$2$1> continuation) {
        super(2, continuation);
        this.$item = attachmentItem;
        this.this$0 = inputAttachmentListModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> inputAttachmentListModel$addImages$2$1 = new InputAttachmentListModel$addImages$2$1(this.$item, this.this$0, continuation);
        inputAttachmentListModel$addImages$2$1.L$0 = obj;
        return inputAttachmentListModel$addImages$2$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        File uriToFile;
        Object uploadWithFakeProgress;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Uri uri = this.$item.getUri();
            uriToFile = this.this$0.uriToFile(this.$item.getUri(), this.$item.getMimeType());
            if (uriToFile != null) {
                this.this$0.updateItem(uri, new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$addImages$2$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        AttachmentItem invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = InputAttachmentListModel$addImages$2$1.invokeSuspend$lambda$1((AttachmentItem) obj2);
                        return invokeSuspend$lambda$1;
                    }
                });
                this.label = 1;
                uploadWithFakeProgress = this.this$0.uploadWithFakeProgress(uri, new C08093(coroutineScope, uriToFile, this.this$0, this.$item, uri, null), (Continuation) this);
                if (uploadWithFakeProgress == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                InputAttachmentListModel inputAttachmentListModel = this.this$0;
                Uri uri2 = this.$item.getUri();
                final InputAttachmentListModel inputAttachmentListModel2 = this.this$0;
                inputAttachmentListModel.updateItem(uri2, new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$addImages$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        AttachmentItem invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = InputAttachmentListModel$addImages$2$1.invokeSuspend$lambda$0(InputAttachmentListModel.this, (AttachmentItem) obj2);
                        return invokeSuspend$lambda$0;
                    }
                });
                return Unit.INSTANCE;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AttachmentItem invokeSuspend$lambda$0(InputAttachmentListModel inputAttachmentListModel, AttachmentItem attachmentItem) {
        AttachmentItem copy;
        copy = attachmentItem.copy((r30 & 1) != 0 ? attachmentItem.bucketId : 0L, (r30 & 2) != 0 ? attachmentItem.id : 0L, (r30 & 4) != 0 ? attachmentItem.fileName : null, (r30 & 8) != 0 ? attachmentItem.uri : null, (r30 & 16) != 0 ? attachmentItem.mimeType : null, (r30 & 32) != 0 ? attachmentItem.sizeBytes : 0L, (r30 & 64) != 0 ? attachmentItem.isImage : false, (r30 & 128) != 0 ? attachmentItem.uploadStatus : AttachmentUploadStatus.Error, (r30 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? attachmentItem.uploadProgress : 0, (r30 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? attachmentItem.uploadedOid : null, (r30 & 1024) != 0 ? attachmentItem.uploadError : inputAttachmentListModel.getApplication().getString(R.string.trae_file_invalid_format));
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AttachmentItem invokeSuspend$lambda$1(AttachmentItem attachmentItem) {
        AttachmentItem copy;
        copy = attachmentItem.copy((r30 & 1) != 0 ? attachmentItem.bucketId : 0L, (r30 & 2) != 0 ? attachmentItem.id : 0L, (r30 & 4) != 0 ? attachmentItem.fileName : null, (r30 & 8) != 0 ? attachmentItem.uri : null, (r30 & 16) != 0 ? attachmentItem.mimeType : null, (r30 & 32) != 0 ? attachmentItem.sizeBytes : 0L, (r30 & 64) != 0 ? attachmentItem.isImage : false, (r30 & 128) != 0 ? attachmentItem.uploadStatus : AttachmentUploadStatus.Uploading, (r30 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? attachmentItem.uploadProgress : 0, (r30 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? attachmentItem.uploadedOid : null, (r30 & 1024) != 0 ? attachmentItem.uploadError : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InputAttachmentListModel.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "onProgress", "Lkotlin/Function1;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.widget.InputAttachmentListModel$addImages$2$1$3", f = "InputAttachmentListModel.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.widget.InputAttachmentListModel$addImages$2$1$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C08093 extends SuspendLambda implements Function2<Function1<? super Integer, ? extends Unit>, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$launch;
        final /* synthetic */ File $file;
        final /* synthetic */ AttachmentItem $item;
        final /* synthetic */ Uri $itemUri;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ InputAttachmentListModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08093(CoroutineScope coroutineScope, File file, InputAttachmentListModel inputAttachmentListModel, AttachmentItem attachmentItem, Uri uri, Continuation<? super C08093> continuation) {
            super(2, continuation);
            this.$$this$launch = coroutineScope;
            this.$file = file;
            this.this$0 = inputAttachmentListModel;
            this.$item = attachmentItem;
            this.$itemUri = uri;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c08093 = new C08093(this.$$this$launch, this.$file, this.this$0, this.$item, this.$itemUri, continuation);
            c08093.L$0 = obj;
            return c08093;
        }

        public final Object invoke(Function1<? super Integer, Unit> function1, Continuation<? super Unit> continuation) {
            return create(function1, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    final Function1 function1 = (Function1) this.L$0;
                    InputAttachmentListModel inputAttachmentListModel = this.this$0;
                    File file = this.$file;
                    AttachmentItem attachmentItem = this.$item;
                    Result.Companion companion = Result.Companion;
                    String mimeType = attachmentItem.getMimeType();
                    Function1 function12 = new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$addImages$2$1$3$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj3) {
                            Unit invokeSuspend$lambda$1$lambda$0;
                            invokeSuspend$lambda$1$lambda$0 = InputAttachmentListModel$addImages$2$1.C08093.invokeSuspend$lambda$1$lambda$0(function1, ((Integer) obj3).intValue());
                            return invokeSuspend$lambda$1$lambda$0;
                        }
                    };
                    this.label = 1;
                    obj = inputAttachmentListModel.uploadImageFile(file, mimeType, function12, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                obj2 = Result.constructor-impl((UploadResult) obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
            }
            this.$file.delete();
            AttachmentItem attachmentItem2 = this.$item;
            InputAttachmentListModel inputAttachmentListModel2 = this.this$0;
            Uri uri = this.$itemUri;
            Throwable th2 = Result.exceptionOrNull-impl(obj2);
            if (th2 == null) {
                final UploadResult uploadResult = (UploadResult) obj2;
                ResourceRepoManager resourceRepoManager = ResourceRepoManager.INSTANCE;
                String oid = uploadResult.getOid();
                String uri2 = attachmentItem2.getUri().toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
                resourceRepoManager.put(oid, uri2);
                inputAttachmentListModel2.updateItem(uri, new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$addImages$2$1$3$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj3) {
                        AttachmentItem invokeSuspend$lambda$3$lambda$2;
                        invokeSuspend$lambda$3$lambda$2 = InputAttachmentListModel$addImages$2$1.C08093.invokeSuspend$lambda$3$lambda$2(UploadResult.this, (AttachmentItem) obj3);
                        return invokeSuspend$lambda$3$lambda$2;
                    }
                });
            } else {
                final String message = th2.getMessage();
                if (message == null) {
                    message = "Upload failed";
                }
                inputAttachmentListModel2.updateItem(uri, new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$addImages$2$1$3$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj3) {
                        AttachmentItem invokeSuspend$lambda$5$lambda$4;
                        invokeSuspend$lambda$5$lambda$4 = InputAttachmentListModel$addImages$2$1.C08093.invokeSuspend$lambda$5$lambda$4(message, (AttachmentItem) obj3);
                        return invokeSuspend$lambda$5$lambda$4;
                    }
                });
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1$lambda$0(Function1 function1, int i) {
            function1.invoke(Integer.valueOf(i));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AttachmentItem invokeSuspend$lambda$3$lambda$2(UploadResult uploadResult, AttachmentItem attachmentItem) {
            AttachmentItem copy;
            copy = attachmentItem.copy((r30 & 1) != 0 ? attachmentItem.bucketId : 0L, (r30 & 2) != 0 ? attachmentItem.id : 0L, (r30 & 4) != 0 ? attachmentItem.fileName : null, (r30 & 8) != 0 ? attachmentItem.uri : null, (r30 & 16) != 0 ? attachmentItem.mimeType : null, (r30 & 32) != 0 ? attachmentItem.sizeBytes : 0L, (r30 & 64) != 0 ? attachmentItem.isImage : false, (r30 & 128) != 0 ? attachmentItem.uploadStatus : AttachmentUploadStatus.Success, (r30 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? attachmentItem.uploadProgress : 100, (r30 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? attachmentItem.uploadedOid : uploadResult.getOid(), (r30 & 1024) != 0 ? attachmentItem.uploadError : null);
            return copy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AttachmentItem invokeSuspend$lambda$5$lambda$4(String str, AttachmentItem attachmentItem) {
            AttachmentItem copy;
            copy = attachmentItem.copy((r30 & 1) != 0 ? attachmentItem.bucketId : 0L, (r30 & 2) != 0 ? attachmentItem.id : 0L, (r30 & 4) != 0 ? attachmentItem.fileName : null, (r30 & 8) != 0 ? attachmentItem.uri : null, (r30 & 16) != 0 ? attachmentItem.mimeType : null, (r30 & 32) != 0 ? attachmentItem.sizeBytes : 0L, (r30 & 64) != 0 ? attachmentItem.isImage : false, (r30 & 128) != 0 ? attachmentItem.uploadStatus : AttachmentUploadStatus.Error, (r30 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? attachmentItem.uploadProgress : 0, (r30 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? attachmentItem.uploadedOid : null, (r30 & 1024) != 0 ? attachmentItem.uploadError : str);
            return copy;
        }
    }
}
