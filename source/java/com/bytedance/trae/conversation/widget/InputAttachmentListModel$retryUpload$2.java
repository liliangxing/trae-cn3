package com.bytedance.trae.conversation.widget;

import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.fileupload.BizType;
import com.bytedance.trae.conversation.fileupload.FileUploadService;
import com.bytedance.trae.conversation.fileupload.UploadResult;
import com.bytedance.trae.conversation.imageupload.ResourceRepoManager;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.widget.InputAttachmentListModel$retryUpload$2;
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
@DebugMetadata(c = "com.bytedance.trae.conversation.widget.InputAttachmentListModel$retryUpload$2", f = "InputAttachmentListModel.kt", i = {}, l = {530}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InputAttachmentListModel$retryUpload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AttachmentItem $item;
    final /* synthetic */ Uri $itemUri;
    final /* synthetic */ boolean $useImageUpload;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InputAttachmentListModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAttachmentListModel$retryUpload$2(InputAttachmentListModel inputAttachmentListModel, AttachmentItem attachmentItem, Uri uri, boolean z, Continuation<? super InputAttachmentListModel$retryUpload$2> continuation) {
        super(2, continuation);
        this.this$0 = inputAttachmentListModel;
        this.$item = attachmentItem;
        this.$itemUri = uri;
        this.$useImageUpload = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> inputAttachmentListModel$retryUpload$2 = new InputAttachmentListModel$retryUpload$2(this.this$0, this.$item, this.$itemUri, this.$useImageUpload, continuation);
        inputAttachmentListModel$retryUpload$2.L$0 = obj;
        return inputAttachmentListModel$retryUpload$2;
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
            uriToFile = this.this$0.uriToFile(this.$item.getUri(), this.$item.getMimeType());
            if (uriToFile != null) {
                this.label = 1;
                uploadWithFakeProgress = this.this$0.uploadWithFakeProgress(this.$itemUri, new C08102(this.$useImageUpload, coroutineScope, uriToFile, this.$item, this.this$0, this.$itemUri, null), (Continuation) this);
                if (uploadWithFakeProgress == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                final InputAttachmentListModel inputAttachmentListModel = this.this$0;
                inputAttachmentListModel.updateItem(this.$itemUri, new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$retryUpload$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        AttachmentItem invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = InputAttachmentListModel$retryUpload$2.invokeSuspend$lambda$0(InputAttachmentListModel.this, (AttachmentItem) obj2);
                        return invokeSuspend$lambda$0;
                    }
                });
                mutableLiveData = this.this$0._uploadError;
                mutableLiveData.postValue(this.this$0.getApplication().getString(R.string.trae_file_invalid_format));
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InputAttachmentListModel.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "onProgress", "Lkotlin/Function1;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.widget.InputAttachmentListModel$retryUpload$2$2", f = "InputAttachmentListModel.kt", i = {}, l = {533, 569}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.widget.InputAttachmentListModel$retryUpload$2$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C08102 extends SuspendLambda implements Function2<Function1<? super Integer, ? extends Unit>, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$launch;
        final /* synthetic */ File $file;
        final /* synthetic */ AttachmentItem $item;
        final /* synthetic */ Uri $itemUri;
        final /* synthetic */ boolean $useImageUpload;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ InputAttachmentListModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08102(boolean z, CoroutineScope coroutineScope, File file, AttachmentItem attachmentItem, InputAttachmentListModel inputAttachmentListModel, Uri uri, Continuation<? super C08102> continuation) {
            super(2, continuation);
            this.$useImageUpload = z;
            this.$$this$launch = coroutineScope;
            this.$file = file;
            this.$item = attachmentItem;
            this.this$0 = inputAttachmentListModel;
            this.$itemUri = uri;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c08102 = new C08102(this.$useImageUpload, this.$$this$launch, this.$file, this.$item, this.this$0, this.$itemUri, continuation);
            c08102.L$0 = obj;
            return c08102;
        }

        public final Object invoke(Function1<? super Integer, Unit> function1, Continuation<? super Unit> continuation) {
            return create(function1, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0135  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0190  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0096  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object obj3;
            Throwable th;
            final String str;
            MutableLiveData mutableLiveData;
            Throwable th2;
            final UploadResult uploadResult;
            MutableLiveData mutableLiveData2;
            FileUploadService fileUploadService;
            Object uploadSingleFile;
            AccountInfo accountInfo;
            Object uploadImageFile;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                } catch (Throwable th3) {
                    Result.Companion companion = Result.Companion;
                    obj3 = Result.constructor-impl(ResultKt.createFailure(th3));
                }
            } catch (Throwable th4) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th4));
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Function1 function1 = (Function1) this.L$0;
                if (this.$useImageUpload) {
                    InputAttachmentListModel inputAttachmentListModel = this.this$0;
                    File file = this.$file;
                    AttachmentItem attachmentItem = this.$item;
                    Result.Companion companion3 = Result.Companion;
                    String mimeType = attachmentItem.getMimeType();
                    Function1 function12 = new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj4) {
                            Unit invokeSuspend$lambda$1$lambda$0;
                            invokeSuspend$lambda$1$lambda$0 = InputAttachmentListModel$retryUpload$2.C08102.invokeSuspend$lambda$1$lambda$0(function1, ((Integer) obj4).intValue());
                            return invokeSuspend$lambda$1$lambda$0;
                        }
                    };
                    this.label = 1;
                    uploadImageFile = inputAttachmentListModel.uploadImageFile(file, mimeType, function12, this);
                    if (uploadImageFile == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = Result.constructor-impl((UploadResult) uploadImageFile);
                    this.$file.delete();
                    AttachmentItem attachmentItem2 = this.$item;
                    InputAttachmentListModel inputAttachmentListModel2 = this.this$0;
                    Uri uri = this.$itemUri;
                    th = Result.exceptionOrNull-impl(obj2);
                    if (th != null) {
                    }
                    return Unit.INSTANCE;
                }
                String str2 = UUID.randomUUID() + ".trae";
                InputAttachmentListModel inputAttachmentListModel3 = this.this$0;
                File file2 = this.$file;
                AttachmentItem attachmentItem3 = this.$item;
                Result.Companion companion4 = Result.Companion;
                fileUploadService = inputAttachmentListModel3.getFileUploadService();
                String mimeType2 = attachmentItem3.getMimeType();
                ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
                String userId = (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getUserId();
                FileUploadService.UploadOptions uploadOptions = new FileUploadService.UploadOptions(true, true, new Function3() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj4, Object obj5, Object obj6) {
                        Unit invokeSuspend$lambda$7$lambda$6;
                        invokeSuspend$lambda$7$lambda$6 = InputAttachmentListModel$retryUpload$2.C08102.invokeSuspend$lambda$7$lambda$6(function1, ((Integer) obj4).intValue(), ((Long) obj5).longValue(), ((Long) obj6).longValue());
                        return invokeSuspend$lambda$7$lambda$6;
                    }
                }, null, 8, null);
                this.label = 2;
                uploadSingleFile = fileUploadService.uploadSingleFile(file2, str2, (r22 & 4) != 0 ? BizType.RemoteResource : null, (r22 & 8) != 0 ? null : mimeType2, (r22 & 16) != 0 ? null : userId, (r22 & 32) != 0 ? new FileUploadService.UploadOptions(false, false, null, null, 15, null) : uploadOptions, this);
                if (uploadSingleFile == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj3 = Result.constructor-impl((UploadResult) uploadSingleFile);
                th2 = Result.exceptionOrNull-impl(obj3);
                if (th2 != null) {
                }
                uploadResult = (UploadResult) obj3;
                this.$file.delete();
                if (!uploadResult.getSuccess()) {
                }
                String error = uploadResult.getError();
                if (error != null) {
                }
                this.this$0.updateItem(this.$itemUri, new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj4) {
                        AttachmentItem invokeSuspend$lambda$10;
                        invokeSuspend$lambda$10 = InputAttachmentListModel$retryUpload$2.C08102.invokeSuspend$lambda$10(str, (AttachmentItem) obj4);
                        return invokeSuspend$lambda$10;
                    }
                });
                mutableLiveData2 = this.this$0._uploadError;
                mutableLiveData2.postValue(str);
                return Unit.INSTANCE;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                uploadImageFile = obj;
                obj2 = Result.constructor-impl((UploadResult) uploadImageFile);
                this.$file.delete();
                AttachmentItem attachmentItem22 = this.$item;
                InputAttachmentListModel inputAttachmentListModel22 = this.this$0;
                Uri uri2 = this.$itemUri;
                th = Result.exceptionOrNull-impl(obj2);
                if (th != null) {
                    final UploadResult uploadResult2 = (UploadResult) obj2;
                    ResourceRepoManager resourceRepoManager = ResourceRepoManager.INSTANCE;
                    String oid = uploadResult2.getOid();
                    String uri3 = attachmentItem22.getUri().toString();
                    Intrinsics.checkNotNullExpressionValue(uri3, "toString(...)");
                    resourceRepoManager.put(oid, uri3);
                    inputAttachmentListModel22.updateItem(uri2, new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj4) {
                            AttachmentItem invokeSuspend$lambda$3$lambda$2;
                            invokeSuspend$lambda$3$lambda$2 = InputAttachmentListModel$retryUpload$2.C08102.invokeSuspend$lambda$3$lambda$2(UploadResult.this, (AttachmentItem) obj4);
                            return invokeSuspend$lambda$3$lambda$2;
                        }
                    });
                } else {
                    String message = th.getMessage();
                    str = message != null ? message : "Upload failed";
                    inputAttachmentListModel22.updateItem(uri2, new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj4) {
                            AttachmentItem invokeSuspend$lambda$5$lambda$4;
                            invokeSuspend$lambda$5$lambda$4 = InputAttachmentListModel$retryUpload$2.C08102.invokeSuspend$lambda$5$lambda$4(str, (AttachmentItem) obj4);
                            return invokeSuspend$lambda$5$lambda$4;
                        }
                    });
                    mutableLiveData = inputAttachmentListModel22._uploadError;
                    mutableLiveData.postValue(str);
                }
                return Unit.INSTANCE;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            uploadSingleFile = obj;
            obj3 = Result.constructor-impl((UploadResult) uploadSingleFile);
            th2 = Result.exceptionOrNull-impl(obj3);
            if (th2 != null) {
                String message2 = th2.getMessage();
                obj3 = new UploadResult("", false, message2 == null ? "Upload failed" : message2, null, null, 24, null);
            }
            uploadResult = (UploadResult) obj3;
            this.$file.delete();
            if (!uploadResult.getSuccess() && (!StringsKt.isBlank(uploadResult.getOid()))) {
                ResourceRepoManager resourceRepoManager2 = ResourceRepoManager.INSTANCE;
                String oid2 = uploadResult.getOid();
                String uri4 = this.$item.getUri().toString();
                Intrinsics.checkNotNullExpressionValue(uri4, "toString(...)");
                resourceRepoManager2.put(oid2, uri4);
                this.this$0.updateItem(this.$itemUri, new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj4) {
                        AttachmentItem invokeSuspend$lambda$9;
                        invokeSuspend$lambda$9 = InputAttachmentListModel$retryUpload$2.C08102.invokeSuspend$lambda$9(UploadResult.this, (AttachmentItem) obj4);
                        return invokeSuspend$lambda$9;
                    }
                });
            } else {
                String error2 = uploadResult.getError();
                str = error2 != null ? error2 : "Upload failed";
                this.this$0.updateItem(this.$itemUri, new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj4) {
                        AttachmentItem invokeSuspend$lambda$10;
                        invokeSuspend$lambda$10 = InputAttachmentListModel$retryUpload$2.C08102.invokeSuspend$lambda$10(str, (AttachmentItem) obj4);
                        return invokeSuspend$lambda$10;
                    }
                });
                mutableLiveData2 = this.this$0._uploadError;
                mutableLiveData2.postValue(str);
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$7$lambda$6(Function1 function1, int i, long j, long j2) {
            function1.invoke(Integer.valueOf(i));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AttachmentItem invokeSuspend$lambda$9(UploadResult uploadResult, AttachmentItem attachmentItem) {
            AttachmentItem copy;
            copy = attachmentItem.copy((r30 & 1) != 0 ? attachmentItem.bucketId : 0L, (r30 & 2) != 0 ? attachmentItem.id : 0L, (r30 & 4) != 0 ? attachmentItem.fileName : null, (r30 & 8) != 0 ? attachmentItem.uri : null, (r30 & 16) != 0 ? attachmentItem.mimeType : null, (r30 & 32) != 0 ? attachmentItem.sizeBytes : 0L, (r30 & 64) != 0 ? attachmentItem.isImage : false, (r30 & 128) != 0 ? attachmentItem.uploadStatus : AttachmentUploadStatus.Success, (r30 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? attachmentItem.uploadProgress : 100, (r30 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? attachmentItem.uploadedOid : uploadResult.getOid(), (r30 & 1024) != 0 ? attachmentItem.uploadError : null);
            return copy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AttachmentItem invokeSuspend$lambda$10(String str, AttachmentItem attachmentItem) {
            AttachmentItem copy;
            copy = attachmentItem.copy((r30 & 1) != 0 ? attachmentItem.bucketId : 0L, (r30 & 2) != 0 ? attachmentItem.id : 0L, (r30 & 4) != 0 ? attachmentItem.fileName : null, (r30 & 8) != 0 ? attachmentItem.uri : null, (r30 & 16) != 0 ? attachmentItem.mimeType : null, (r30 & 32) != 0 ? attachmentItem.sizeBytes : 0L, (r30 & 64) != 0 ? attachmentItem.isImage : false, (r30 & 128) != 0 ? attachmentItem.uploadStatus : AttachmentUploadStatus.Error, (r30 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? attachmentItem.uploadProgress : 0, (r30 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? attachmentItem.uploadedOid : null, (r30 & 1024) != 0 ? attachmentItem.uploadError : str);
            return copy;
        }
    }
}
