package com.bytedance.trae.conversation.brainstorm;

import android.net.Uri;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.brainstorm.model.AttachmentState;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.tracker.AsrDiscussAction;
import com.bytedance.trae.conversation.tracker.TraeAITracker;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.utils.logger.FLogger;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrainstormViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$startUpload$job$1", f = "BrainstormViewModel.kt", i = {0, 1}, l = {627, 629, 683, 683, 683}, m = "invokeSuspend", n = {MessagePart.TYPE_FILE, MessagePart.TYPE_FILE}, s = {"L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormViewModel$startUpload$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BrainstormAttachment $attachment;
    final /* synthetic */ String $attachmentId;
    final /* synthetic */ Uri $sourceUri;
    final /* synthetic */ long $uploadStartMs;
    Object L$0;
    int label;
    final /* synthetic */ BrainstormViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrainstormViewModel$startUpload$job$1(BrainstormViewModel brainstormViewModel, Uri uri, BrainstormAttachment brainstormAttachment, String str, long j, Continuation<? super BrainstormViewModel$startUpload$job$1> continuation) {
        super(2, continuation);
        this.this$0 = brainstormViewModel;
        this.$sourceUri = uri;
        this.$attachment = brainstormAttachment;
        this.$attachmentId = str;
        this.$uploadStartMs = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrainstormViewModel$startUpload$job$1(this.this$0, this.$sourceUri, this.$attachment, this.$attachmentId, this.$uploadStartMs, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x01b2: INVOKE (r20 I:long) = (r11 I:java.io.File) VIRTUAL call: java.io.File.length():long A[Catch: all -> 0x01f9, MD:():long (c)] (LINE:676), block:B:62:0x0183 */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0202: INVOKE 
      (r4v1 ?? I:com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$startUpload$job$1$5)
      (r11 I:java.io.File)
      (r10 I:kotlin.coroutines.Continuation)
     DIRECT call: com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$startUpload$job$1.5.<init>(java.io.File, kotlin.coroutines.Continuation):void A[MD:(java.io.File, kotlin.coroutines.Continuation<? super com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$startUpload$job$1$5>):void (m)], block:B:72:0x01fa */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ea A[Catch: all -> 0x004b, TryCatch #1 {all -> 0x004b, blocks: (B:20:0x0039, B:22:0x00d6, B:23:0x00d8, B:25:0x00de, B:30:0x00ea, B:34:0x011a, B:37:0x0125, B:40:0x012e, B:44:0x0045, B:46:0x00b1, B:52:0x0093, B:54:0x009b, B:57:0x00b4), top: B:2:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0176 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011a A[Catch: all -> 0x004b, TryCatch #1 {all -> 0x004b, blocks: (B:20:0x0039, B:22:0x00d6, B:23:0x00d8, B:25:0x00de, B:30:0x00ea, B:34:0x011a, B:37:0x0125, B:40:0x012e, B:44:0x0045, B:46:0x00b1, B:52:0x0093, B:54:0x009b, B:57:0x00b4), top: B:2:0x0012 }] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.io.File] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SuspendLambda c06585;
        ?? length;
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        BrainstormAttachmentManager brainstormAttachmentManager;
        File uriToFile;
        BrainstormAttachmentManager brainstormAttachmentManager2;
        Object uploadFile;
        BrainstormAttachmentManager brainstormAttachmentManager3;
        Object uploadImage;
        final String str;
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Throwable th) {
            try {
                FLogger.INSTANCE.w("BrainstormViewModel", "attachment upload failed: " + this.$attachment.getAttachmentId(), th);
                BrainstormViewModel.updateAttachment$default(this.this$0, this.$attachmentId, false, new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj2) {
                        BrainstormAttachment invokeSuspend$lambda$5;
                        invokeSuspend$lambda$5 = BrainstormViewModel$startUpload$job$1.invokeSuspend$lambda$5(th, (BrainstormAttachment) obj2);
                        return invokeSuspend$lambda$5;
                    }
                }, 2, null);
                BrainstormViewModel brainstormViewModel = this.this$0;
                BrainstormAttachment brainstormAttachment = this.$attachment;
                long length2 = length.length();
                long j = this.$uploadStartMs;
                String message = th.getMessage();
                brainstormViewModel.reportVoiceFileUploadEnd(brainstormAttachment, length2, j, "failed", message == null ? th.getClass().getSimpleName() : message);
                TraeAITracker.trackAsrDiscuss$default(TraeAITracker.INSTANCE, AsrDiscussAction.ATTACH_UPLOAD_FAILED, null, 2, null);
                this.L$0 = null;
                this.label = 4;
                if (BuildersKt.withContext(Dispatchers.getIO(), new C06585(length, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable th2) {
                th = th2;
                this.L$0 = th;
                this.label = 5;
                if (BuildersKt.withContext(Dispatchers.getIO(), new C06585(c06585, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            brainstormAttachmentManager = this.this$0.attachmentManager;
            uriToFile = brainstormAttachmentManager.uriToFile(this.$sourceUri, this.$attachment.getMimeType());
            if (uriToFile == null) {
                final BrainstormViewModel brainstormViewModel2 = this.this$0;
                BrainstormViewModel.updateAttachment$default(brainstormViewModel2, this.$attachmentId, false, new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        BrainstormAttachment invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = BrainstormViewModel$startUpload$job$1.invokeSuspend$lambda$0(BrainstormViewModel.this, (BrainstormAttachment) obj2);
                        return invokeSuspend$lambda$0;
                    }
                }, 2, null);
                BrainstormViewModel brainstormViewModel3 = this.this$0;
                BrainstormAttachment brainstormAttachment2 = this.$attachment;
                brainstormViewModel3.reportVoiceFileUploadEnd(brainstormAttachment2, brainstormAttachment2.getSizeBytes(), this.$uploadStartMs, "failed", "file_invalid_format");
                return Unit.INSTANCE;
            }
            final BrainstormViewModel brainstormViewModel4 = this.this$0;
            final String str2 = this.$attachmentId;
            Function1<? super Integer, Unit> function1 = new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2) {
                    Unit invokeSuspend$lambda$2;
                    invokeSuspend$lambda$2 = BrainstormViewModel$startUpload$job$1.invokeSuspend$lambda$2(BrainstormViewModel.this, str2, ((Integer) obj2).intValue());
                    return invokeSuspend$lambda$2;
                }
            };
            if (this.$attachment.getUseImageUpload()) {
                brainstormAttachmentManager3 = this.this$0.attachmentManager;
                this.L$0 = uriToFile;
                this.label = 1;
                uploadImage = brainstormAttachmentManager3.uploadImage(uriToFile, this.$sourceUri, function1, (Continuation) this);
                if (uploadImage == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = (String) uploadImage;
            } else {
                brainstormAttachmentManager2 = this.this$0.attachmentManager;
                this.L$0 = uriToFile;
                this.label = 2;
                uploadFile = brainstormAttachmentManager2.uploadFile(uriToFile, this.$sourceUri, this.$attachment.getMimeType(), function1, (Continuation) this);
                if (uploadFile == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = (String) uploadFile;
            }
        } else if (i == 1) {
            uriToFile = (File) this.L$0;
            ResultKt.throwOnFailure(obj);
            uploadImage = obj;
            str = (String) uploadImage;
        } else {
            if (i != 2) {
                if (i == 3 || i == 4) {
                    ResultKt.throwOnFailure(obj);
                    concurrentHashMap = this.this$0.attachmentUploadJobs;
                    concurrentHashMap.remove(this.$attachmentId);
                    return Unit.INSTANCE;
                }
                if (i != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = (Throwable) this.L$0;
                ResultKt.throwOnFailure(obj);
                concurrentHashMap2 = this.this$0.attachmentUploadJobs;
                concurrentHashMap2.remove(this.$attachmentId);
                throw th;
            }
            uriToFile = (File) this.L$0;
            ResultKt.throwOnFailure(obj);
            uploadFile = obj;
            str = (String) uploadFile;
        }
        String str3 = str;
        if (str3 != null && !StringsKt.isBlank(str3)) {
            z = false;
            if (!z) {
                BrainstormViewModel.updateAttachment$default(this.this$0, this.$attachmentId, false, new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj2) {
                        BrainstormAttachment invokeSuspend$lambda$3;
                        invokeSuspend$lambda$3 = BrainstormViewModel$startUpload$job$1.invokeSuspend$lambda$3((BrainstormAttachment) obj2);
                        return invokeSuspend$lambda$3;
                    }
                }, 2, null);
                this.this$0.reportVoiceFileUploadEnd(this.$attachment, uriToFile.length(), this.$uploadStartMs, "failed", "upload_empty_ref");
                TraeAITracker.trackAsrDiscuss$default(TraeAITracker.INSTANCE, AsrDiscussAction.ATTACH_UPLOAD_FAILED, null, 2, null);
            } else {
                boolean z2 = this.$attachment.getGroupId() != null;
                BrainstormViewModel brainstormViewModel5 = this.this$0;
                String str4 = this.$attachmentId;
                boolean z3 = !z2;
                final boolean z4 = z2;
                brainstormViewModel5.updateAttachment(str4, z3, new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj2) {
                        BrainstormAttachment invokeSuspend$lambda$4;
                        invokeSuspend$lambda$4 = BrainstormViewModel$startUpload$job$1.invokeSuspend$lambda$4(str, z4, (BrainstormAttachment) obj2);
                        return invokeSuspend$lambda$4;
                    }
                });
                this.this$0.reportVoiceFileUploadEnd(this.$attachment, uriToFile.length(), this.$uploadStartMs, "success", "");
                TraeAITracker.trackAsrDiscuss$default(TraeAITracker.INSTANCE, AsrDiscussAction.ATTACH_UPLOAD_SUCCESS, null, 2, null);
                this.this$0.onAttachmentUploadDone(this.$attachmentId);
            }
            this.L$0 = null;
            this.label = 3;
            if (BuildersKt.withContext(Dispatchers.getIO(), new C06585(uriToFile, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            concurrentHashMap = this.this$0.attachmentUploadJobs;
            concurrentHashMap.remove(this.$attachmentId);
            return Unit.INSTANCE;
        }
        z = true;
        if (!z) {
        }
        this.L$0 = null;
        this.label = 3;
        if (BuildersKt.withContext(Dispatchers.getIO(), new C06585(uriToFile, null), (Continuation) this) == coroutine_suspended) {
        }
        concurrentHashMap = this.this$0.attachmentUploadJobs;
        concurrentHashMap.remove(this.$attachmentId);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrainstormAttachment invokeSuspend$lambda$0(BrainstormViewModel brainstormViewModel, BrainstormAttachment brainstormAttachment) {
        BrainstormAttachment copy;
        copy = brainstormAttachment.copy((r33 & 1) != 0 ? brainstormAttachment.attachmentId : null, (r33 & 2) != 0 ? brainstormAttachment.displayName : null, (r33 & 4) != 0 ? brainstormAttachment.mimeType : null, (r33 & 8) != 0 ? brainstormAttachment.sizeBytes : 0L, (r33 & 16) != 0 ? brainstormAttachment.localUri : null, (r33 & 32) != 0 ? brainstormAttachment.isImage : false, (r33 & 64) != 0 ? brainstormAttachment.useImageUpload : false, (r33 & 128) != 0 ? brainstormAttachment.state : AttachmentState.Failed, (r33 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? brainstormAttachment.progress : 0, (r33 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? brainstormAttachment.uploadedRef : null, (r33 & 1024) != 0 ? brainstormAttachment.errorMessage : brainstormViewModel.getApplication().getString(R.string.trae_file_invalid_format), (r33 & 2048) != 0 ? brainstormAttachment.notifiedToBot : false, (r33 & 4096) != 0 ? brainstormAttachment.createdAtMs : 0L, (r33 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? brainstormAttachment.groupId : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2(BrainstormViewModel brainstormViewModel, String str, final int i) {
        BrainstormViewModel.updateAttachment$default(brainstormViewModel, str, false, new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                BrainstormAttachment invokeSuspend$lambda$2$lambda$1;
                invokeSuspend$lambda$2$lambda$1 = BrainstormViewModel$startUpload$job$1.invokeSuspend$lambda$2$lambda$1(i, (BrainstormAttachment) obj);
                return invokeSuspend$lambda$2$lambda$1;
            }
        }, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrainstormAttachment invokeSuspend$lambda$2$lambda$1(int i, BrainstormAttachment brainstormAttachment) {
        BrainstormAttachment copy;
        if (brainstormAttachment.getState() != AttachmentState.Uploading) {
            return brainstormAttachment;
        }
        copy = brainstormAttachment.copy((r33 & 1) != 0 ? brainstormAttachment.attachmentId : null, (r33 & 2) != 0 ? brainstormAttachment.displayName : null, (r33 & 4) != 0 ? brainstormAttachment.mimeType : null, (r33 & 8) != 0 ? brainstormAttachment.sizeBytes : 0L, (r33 & 16) != 0 ? brainstormAttachment.localUri : null, (r33 & 32) != 0 ? brainstormAttachment.isImage : false, (r33 & 64) != 0 ? brainstormAttachment.useImageUpload : false, (r33 & 128) != 0 ? brainstormAttachment.state : null, (r33 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? brainstormAttachment.progress : RangesKt.coerceIn(i, 0, 99), (r33 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? brainstormAttachment.uploadedRef : null, (r33 & 1024) != 0 ? brainstormAttachment.errorMessage : null, (r33 & 2048) != 0 ? brainstormAttachment.notifiedToBot : false, (r33 & 4096) != 0 ? brainstormAttachment.createdAtMs : 0L, (r33 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? brainstormAttachment.groupId : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrainstormAttachment invokeSuspend$lambda$3(BrainstormAttachment brainstormAttachment) {
        BrainstormAttachment copy;
        copy = brainstormAttachment.copy((r33 & 1) != 0 ? brainstormAttachment.attachmentId : null, (r33 & 2) != 0 ? brainstormAttachment.displayName : null, (r33 & 4) != 0 ? brainstormAttachment.mimeType : null, (r33 & 8) != 0 ? brainstormAttachment.sizeBytes : 0L, (r33 & 16) != 0 ? brainstormAttachment.localUri : null, (r33 & 32) != 0 ? brainstormAttachment.isImage : false, (r33 & 64) != 0 ? brainstormAttachment.useImageUpload : false, (r33 & 128) != 0 ? brainstormAttachment.state : AttachmentState.Failed, (r33 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? brainstormAttachment.progress : 0, (r33 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? brainstormAttachment.uploadedRef : null, (r33 & 1024) != 0 ? brainstormAttachment.errorMessage : "Upload failed", (r33 & 2048) != 0 ? brainstormAttachment.notifiedToBot : false, (r33 & 4096) != 0 ? brainstormAttachment.createdAtMs : 0L, (r33 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? brainstormAttachment.groupId : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrainstormAttachment invokeSuspend$lambda$4(String str, boolean z, BrainstormAttachment brainstormAttachment) {
        BrainstormAttachment copy;
        copy = brainstormAttachment.copy((r33 & 1) != 0 ? brainstormAttachment.attachmentId : null, (r33 & 2) != 0 ? brainstormAttachment.displayName : null, (r33 & 4) != 0 ? brainstormAttachment.mimeType : null, (r33 & 8) != 0 ? brainstormAttachment.sizeBytes : 0L, (r33 & 16) != 0 ? brainstormAttachment.localUri : null, (r33 & 32) != 0 ? brainstormAttachment.isImage : false, (r33 & 64) != 0 ? brainstormAttachment.useImageUpload : false, (r33 & 128) != 0 ? brainstormAttachment.state : AttachmentState.Uploaded, (r33 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? brainstormAttachment.progress : 100, (r33 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? brainstormAttachment.uploadedRef : str, (r33 & 1024) != 0 ? brainstormAttachment.errorMessage : null, (r33 & 2048) != 0 ? brainstormAttachment.notifiedToBot : false, (r33 & 4096) != 0 ? brainstormAttachment.createdAtMs : z ? brainstormAttachment.getCreatedAtMs() : System.currentTimeMillis(), (r33 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? brainstormAttachment.groupId : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrainstormAttachment invokeSuspend$lambda$5(Throwable th, BrainstormAttachment brainstormAttachment) {
        BrainstormAttachment copy;
        AttachmentState attachmentState = AttachmentState.Failed;
        String message = th.getMessage();
        if (message == null) {
            message = "Upload failed";
        }
        copy = brainstormAttachment.copy((r33 & 1) != 0 ? brainstormAttachment.attachmentId : null, (r33 & 2) != 0 ? brainstormAttachment.displayName : null, (r33 & 4) != 0 ? brainstormAttachment.mimeType : null, (r33 & 8) != 0 ? brainstormAttachment.sizeBytes : 0L, (r33 & 16) != 0 ? brainstormAttachment.localUri : null, (r33 & 32) != 0 ? brainstormAttachment.isImage : false, (r33 & 64) != 0 ? brainstormAttachment.useImageUpload : false, (r33 & 128) != 0 ? brainstormAttachment.state : attachmentState, (r33 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? brainstormAttachment.progress : 0, (r33 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? brainstormAttachment.uploadedRef : null, (r33 & 1024) != 0 ? brainstormAttachment.errorMessage : message, (r33 & 2048) != 0 ? brainstormAttachment.notifiedToBot : false, (r33 & 4096) != 0 ? brainstormAttachment.createdAtMs : 0L, (r33 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? brainstormAttachment.groupId : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BrainstormViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$startUpload$job$1$5", f = "BrainstormViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$startUpload$job$1$5 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06585 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Boolean>>, Object> {
        final /* synthetic */ File $file;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06585(File file, Continuation<? super C06585> continuation) {
            super(2, continuation);
            this.$file = file;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c06585 = new C06585(this.$file, continuation);
            c06585.L$0 = obj;
            return c06585;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<Boolean>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            File file = this.$file;
            try {
                Result.Companion companion = Result.Companion;
                obj2 = Result.constructor-impl(Boxing.boxBoolean(file.delete()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
            }
            return Result.box-impl(obj2);
        }
    }
}
