package com.bytedance.trae.conversation.widget;

import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.fileupload.BizType;
import com.bytedance.trae.conversation.fileupload.FileUploadService;
import com.bytedance.trae.conversation.fileupload.UploadResult;
import com.bytedance.trae.conversation.imageupload.ResourceRepoManager;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.widget.InputAttachmentListModel$addAttachment$3;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.multilanguage.R;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.UUID;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputAttachmentListModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.widget.InputAttachmentListModel$addAttachment$3", f = "InputAttachmentListModel.kt", i = {}, l = {445}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InputAttachmentListModel$addAttachment$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AttachmentItem $item;
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InputAttachmentListModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAttachmentListModel$addAttachment$3(AttachmentItem attachmentItem, InputAttachmentListModel inputAttachmentListModel, Uri uri, Continuation<? super InputAttachmentListModel$addAttachment$3> continuation) {
        super(2, continuation);
        this.$item = attachmentItem;
        this.this$0 = inputAttachmentListModel;
        this.$uri = uri;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> inputAttachmentListModel$addAttachment$3 = new InputAttachmentListModel$addAttachment$3(this.$item, this.this$0, this.$uri, continuation);
        inputAttachmentListModel$addAttachment$3.L$0 = obj;
        return inputAttachmentListModel$addAttachment$3;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        File uriToFile;
        Object uploadWithFakeProgress;
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Uri uri = this.$item.getUri();
            this.this$0.updateItem(uri, new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$addAttachment$3$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    AttachmentItem invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = InputAttachmentListModel$addAttachment$3.invokeSuspend$lambda$0((AttachmentItem) obj2);
                    return invokeSuspend$lambda$0;
                }
            });
            uriToFile = this.this$0.uriToFile(this.$uri, this.$item.getMimeType());
            if (uriToFile != null) {
                this.label = 1;
                uploadWithFakeProgress = this.this$0.uploadWithFakeProgress(uri, new C08073(coroutineScope, uriToFile, this.$uri, this.this$0, uri, this.$item, null), (Continuation) this);
                if (uploadWithFakeProgress == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                final String string = this.this$0.getApplication().getString(R.string.trae_file_invalid_format);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                this.this$0.updateItem(uri, new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$addAttachment$3$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        AttachmentItem invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = InputAttachmentListModel$addAttachment$3.invokeSuspend$lambda$1(string, (AttachmentItem) obj2);
                        return invokeSuspend$lambda$1;
                    }
                });
                mutableLiveData = this.this$0._uploadError;
                mutableLiveData.postValue(string);
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
    public static final AttachmentItem invokeSuspend$lambda$0(AttachmentItem attachmentItem) {
        AttachmentItem copy;
        copy = attachmentItem.copy((r30 & 1) != 0 ? attachmentItem.bucketId : 0L, (r30 & 2) != 0 ? attachmentItem.id : 0L, (r30 & 4) != 0 ? attachmentItem.fileName : null, (r30 & 8) != 0 ? attachmentItem.uri : null, (r30 & 16) != 0 ? attachmentItem.mimeType : null, (r30 & 32) != 0 ? attachmentItem.sizeBytes : 0L, (r30 & 64) != 0 ? attachmentItem.isImage : false, (r30 & 128) != 0 ? attachmentItem.uploadStatus : AttachmentUploadStatus.Uploading, (r30 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? attachmentItem.uploadProgress : 0, (r30 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? attachmentItem.uploadedOid : null, (r30 & 1024) != 0 ? attachmentItem.uploadError : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AttachmentItem invokeSuspend$lambda$1(String str, AttachmentItem attachmentItem) {
        AttachmentItem copy;
        copy = attachmentItem.copy((r30 & 1) != 0 ? attachmentItem.bucketId : 0L, (r30 & 2) != 0 ? attachmentItem.id : 0L, (r30 & 4) != 0 ? attachmentItem.fileName : null, (r30 & 8) != 0 ? attachmentItem.uri : null, (r30 & 16) != 0 ? attachmentItem.mimeType : null, (r30 & 32) != 0 ? attachmentItem.sizeBytes : 0L, (r30 & 64) != 0 ? attachmentItem.isImage : false, (r30 & 128) != 0 ? attachmentItem.uploadStatus : AttachmentUploadStatus.Error, (r30 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? attachmentItem.uploadProgress : 0, (r30 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? attachmentItem.uploadedOid : null, (r30 & 1024) != 0 ? attachmentItem.uploadError : str);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InputAttachmentListModel.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "onProgress", "Lkotlin/Function1;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.widget.InputAttachmentListModel$addAttachment$3$3", f = "InputAttachmentListModel.kt", i = {}, l = {448}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.widget.InputAttachmentListModel$addAttachment$3$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C08073 extends SuspendLambda implements Function2<Function1<? super Integer, ? extends Unit>, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$launch;
        final /* synthetic */ File $file;
        final /* synthetic */ AttachmentItem $item;
        final /* synthetic */ Uri $itemUri;
        final /* synthetic */ Uri $uri;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ InputAttachmentListModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08073(CoroutineScope coroutineScope, File file, Uri uri, InputAttachmentListModel inputAttachmentListModel, Uri uri2, AttachmentItem attachmentItem, Continuation<? super C08073> continuation) {
            super(2, continuation);
            this.$$this$launch = coroutineScope;
            this.$file = file;
            this.$uri = uri;
            this.this$0 = inputAttachmentListModel;
            this.$itemUri = uri2;
            this.$item = attachmentItem;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c08073 = new C08073(this.$$this$launch, this.$file, this.$uri, this.this$0, this.$itemUri, this.$item, continuation);
            c08073.L$0 = obj;
            return c08073;
        }

        public final Object invoke(Function1<? super Integer, Unit> function1, Continuation<? super Unit> continuation) {
            return create(function1, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            FileUploadService fileUploadService;
            Object uploadSingleFile;
            AccountInfo accountInfo;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    final Function1 function1 = (Function1) this.L$0;
                    String str = UUID.randomUUID() + ".trae";
                    InputAttachmentListModel inputAttachmentListModel = this.this$0;
                    File file = this.$file;
                    AttachmentItem attachmentItem = this.$item;
                    Result.Companion companion = Result.Companion;
                    fileUploadService = inputAttachmentListModel.getFileUploadService();
                    String mimeType = attachmentItem.getMimeType();
                    ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
                    String userId = (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getUserId();
                    FileUploadService.UploadOptions uploadOptions = new FileUploadService.UploadOptions(true, true, new Function3() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$addAttachment$3$3$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj3, Object obj4, Object obj5) {
                            Unit invokeSuspend$lambda$1$lambda$0;
                            invokeSuspend$lambda$1$lambda$0 = InputAttachmentListModel$addAttachment$3.C08073.invokeSuspend$lambda$1$lambda$0(function1, ((Integer) obj3).intValue(), ((Long) obj4).longValue(), ((Long) obj5).longValue());
                            return invokeSuspend$lambda$1$lambda$0;
                        }
                    }, null, 8, null);
                    this.label = 1;
                    uploadSingleFile = fileUploadService.uploadSingleFile(file, str, (r22 & 4) != 0 ? BizType.RemoteResource : null, (r22 & 8) != 0 ? null : mimeType, (r22 & 16) != 0 ? null : userId, (r22 & 32) != 0 ? new FileUploadService.UploadOptions(false, false, null, null, 15, null) : uploadOptions, this);
                    if (uploadSingleFile == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    uploadSingleFile = obj;
                }
                obj2 = Result.constructor-impl((UploadResult) uploadSingleFile);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj2);
            if (th2 != null) {
                String message = th2.getMessage();
                obj2 = new UploadResult("", false, message == null ? "Upload failed" : message, null, null, 24, null);
            }
            final UploadResult uploadResult = (UploadResult) obj2;
            this.$file.delete();
            if (uploadResult.getSuccess() && (!StringsKt.isBlank(uploadResult.getOid()))) {
                ResourceRepoManager resourceRepoManager = ResourceRepoManager.INSTANCE;
                String oid = uploadResult.getOid();
                String uri = this.$uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
                resourceRepoManager.put(oid, uri);
                this.this$0.updateItem(this.$itemUri, new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$addAttachment$3$3$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj3) {
                        AttachmentItem invokeSuspend$lambda$3;
                        invokeSuspend$lambda$3 = InputAttachmentListModel$addAttachment$3.C08073.invokeSuspend$lambda$3(UploadResult.this, (AttachmentItem) obj3);
                        return invokeSuspend$lambda$3;
                    }
                });
            } else {
                String error = uploadResult.getError();
                final String str2 = error != null ? error : "Upload failed";
                this.this$0.updateItem(this.$itemUri, new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$addAttachment$3$3$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj3) {
                        AttachmentItem invokeSuspend$lambda$4;
                        invokeSuspend$lambda$4 = InputAttachmentListModel$addAttachment$3.C08073.invokeSuspend$lambda$4(str2, (AttachmentItem) obj3);
                        return invokeSuspend$lambda$4;
                    }
                });
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1$lambda$0(Function1 function1, int i, long j, long j2) {
            function1.invoke(Integer.valueOf(i));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AttachmentItem invokeSuspend$lambda$3(UploadResult uploadResult, AttachmentItem attachmentItem) {
            AttachmentItem copy;
            copy = attachmentItem.copy((r30 & 1) != 0 ? attachmentItem.bucketId : 0L, (r30 & 2) != 0 ? attachmentItem.id : 0L, (r30 & 4) != 0 ? attachmentItem.fileName : null, (r30 & 8) != 0 ? attachmentItem.uri : null, (r30 & 16) != 0 ? attachmentItem.mimeType : null, (r30 & 32) != 0 ? attachmentItem.sizeBytes : 0L, (r30 & 64) != 0 ? attachmentItem.isImage : false, (r30 & 128) != 0 ? attachmentItem.uploadStatus : AttachmentUploadStatus.Success, (r30 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? attachmentItem.uploadProgress : 100, (r30 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? attachmentItem.uploadedOid : uploadResult.getOid(), (r30 & 1024) != 0 ? attachmentItem.uploadError : null);
            return copy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AttachmentItem invokeSuspend$lambda$4(String str, AttachmentItem attachmentItem) {
            AttachmentItem copy;
            copy = attachmentItem.copy((r30 & 1) != 0 ? attachmentItem.bucketId : 0L, (r30 & 2) != 0 ? attachmentItem.id : 0L, (r30 & 4) != 0 ? attachmentItem.fileName : null, (r30 & 8) != 0 ? attachmentItem.uri : null, (r30 & 16) != 0 ? attachmentItem.mimeType : null, (r30 & 32) != 0 ? attachmentItem.sizeBytes : 0L, (r30 & 64) != 0 ? attachmentItem.isImage : false, (r30 & 128) != 0 ? attachmentItem.uploadStatus : AttachmentUploadStatus.Error, (r30 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? attachmentItem.uploadProgress : 0, (r30 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? attachmentItem.uploadedOid : null, (r30 & 1024) != 0 ? attachmentItem.uploadError : str);
            return copy;
        }
    }
}
