package com.bytedance.trae.conversation.imageupload;

import com.bytedance.trae.conversation.imageupload.BduploaderImageXUploader;
import com.bytedance.trae.im.model.MessagePart;
import com.ss.bduploader.BDImageXInfo;
import com.ss.bduploader.BDImageXUploader;
import com.ss.bduploader.BDImageXUploaderListener;
import java.io.File;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: BduploaderImageXUploader.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011H\u0096@¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0013H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;", "Lcom/bytedance/trae/conversation/imageupload/ImageXUploader;", "<init>", "()V", "activeUploaders", "", "Lcom/ss/bduploader/BDImageXUploader;", "upload", "", MessagePart.TYPE_FILE, "Ljava/io/File;", "storeKey", "sts", "Lcom/bytedance/trae/conversation/imageupload/StsTokenData;", "uploaderConfig", "Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;", "onProgress", "Lkotlin/Function1;", "", "", "(Ljava/io/File;Ljava/lang/String;Lcom/bytedance/trae/conversation/imageupload/StsTokenData;Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "Events", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BduploaderImageXUploader implements ImageXUploader {
    private final Set<BDImageXUploader> activeUploaders;

    public BduploaderImageXUploader() {
        Set<BDImageXUploader> synchronizedSet = Collections.synchronizedSet(new LinkedHashSet());
        Intrinsics.checkNotNullExpressionValue(synchronizedSet, "synchronizedSet(...)");
        this.activeUploaders = synchronizedSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BduploaderImageXUploader.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;", "", "<init>", "()V", "getIntFieldOrMinusOne", "", "fieldName", "", "MSG_SINGLE_COMPLETE", "getMSG_SINGLE_COMPLETE", "()I", "MSG_SINGLE_FAIL", "getMSG_SINGLE_FAIL", "MSG_UPDATE_PROGRESS", "getMSG_UPDATE_PROGRESS", "MSG_ALL_COMPLETE", "getMSG_ALL_COMPLETE", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Events {
        public static final Events INSTANCE;
        private static final int MSG_ALL_COMPLETE;
        private static final int MSG_SINGLE_COMPLETE;
        private static final int MSG_SINGLE_FAIL;
        private static final int MSG_UPDATE_PROGRESS;

        private Events() {
        }

        private final int getIntFieldOrMinusOne(String fieldName) {
            Object obj;
            try {
                Result.Companion companion = Result.Companion;
                Events events = this;
                obj = Result.constructor-impl(Integer.valueOf(BDImageXUploader.class.getField(fieldName).getInt(null)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = -1;
            }
            return ((Number) obj).intValue();
        }

        static {
            Events events = new Events();
            INSTANCE = events;
            MSG_SINGLE_COMPLETE = events.getIntFieldOrMinusOne("MsgIsSingleImageComplete");
            MSG_SINGLE_FAIL = events.getIntFieldOrMinusOne("MsgIsSingleImageFail");
            MSG_UPDATE_PROGRESS = events.getIntFieldOrMinusOne("MsgIsUpdateProgress");
            MSG_ALL_COMPLETE = events.getIntFieldOrMinusOne("MsgIsComplete");
        }

        public final int getMSG_SINGLE_COMPLETE() {
            return MSG_SINGLE_COMPLETE;
        }

        public final int getMSG_SINGLE_FAIL() {
            return MSG_SINGLE_FAIL;
        }

        public final int getMSG_UPDATE_PROGRESS() {
            return MSG_UPDATE_PROGRESS;
        }

        public final int getMSG_ALL_COMPLETE() {
            return MSG_ALL_COMPLETE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.bytedance.trae.conversation.imageupload.ImageXUploader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object upload(File file, String str, StsTokenData stsTokenData, UploaderConfig uploaderConfig, final Function1<? super Integer, Unit> function1, Continuation<? super String> continuation) {
        BduploaderImageXUploader$upload$1 bduploaderImageXUploader$upload$1;
        int i;
        Object obj;
        BduploaderImageXUploader bduploaderImageXUploader;
        BDImageXUploader bDImageXUploader;
        if (continuation instanceof BduploaderImageXUploader$upload$1) {
            bduploaderImageXUploader$upload$1 = (BduploaderImageXUploader$upload$1) continuation;
            if ((bduploaderImageXUploader$upload$1.label & Integer.MIN_VALUE) != 0) {
                bduploaderImageXUploader$upload$1.label -= Integer.MIN_VALUE;
                Object obj2 = bduploaderImageXUploader$upload$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = bduploaderImageXUploader$upload$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    final BDImageXUploader bDImageXUploader2 = new BDImageXUploader();
                    this.activeUploaders.add(bDImageXUploader2);
                    bDImageXUploader2.setUploadDomain(uploaderConfig.getImageHost());
                    bDImageXUploader2.setFilePath(1, new String[]{file.getAbsolutePath()});
                    bDImageXUploader2.setFileStoreKeys(1, new String[]{str});
                    bDImageXUploader2.setNetworkType(403, 0);
                    bDImageXUploader2.setNetworkType(404, 1);
                    bDImageXUploader2.setTopAccessKey(stsTokenData.getAccessKeyId());
                    bDImageXUploader2.setTopSecretKey(stsTokenData.getSecretAccessKey());
                    bDImageXUploader2.setTopSessionToken(stsTokenData.getSessionToken());
                    bDImageXUploader2.setServiceID(stsTokenData.getServiceId());
                    bDImageXUploader2.setObjectType("image");
                    bDImageXUploader2.setMaxConcurrentFileNum(3);
                    bduploaderImageXUploader$upload$1.L$0 = this;
                    bduploaderImageXUploader$upload$1.L$1 = function1;
                    bduploaderImageXUploader$upload$1.L$2 = bDImageXUploader2;
                    bduploaderImageXUploader$upload$1.label = 1;
                    Continuation continuation2 = (Continuation) bduploaderImageXUploader$upload$1;
                    Continuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation2), 1);
                    cancellableContinuationImpl.initCancellability();
                    final Continuation continuation3 = (CancellableContinuation) cancellableContinuationImpl;
                    bDImageXUploader2.setListener(new BDImageXUploaderListener() { // from class: com.bytedance.trae.conversation.imageupload.BduploaderImageXUploader$upload$2$1
                        public int imageXUploadCheckNetState(int errorCode, int tryCount) {
                            return 1;
                        }

                        public void onLog(int what, int code, String info) {
                        }

                        public void onNotify(int what, long parameter, BDImageXInfo info) {
                            if (continuation3.isCompleted()) {
                                return;
                            }
                            String str2 = info != null ? info.mImageTosKey : null;
                            long j = info != null ? info.mErrorCode : 0L;
                            boolean z = true;
                            if (BduploaderImageXUploader.Events.INSTANCE.getMSG_SINGLE_COMPLETE() == -1) {
                                String str3 = str2;
                                if (!(str3 == null || StringsKt.isBlank(str3))) {
                                    Continuation continuation4 = continuation3;
                                    Result.Companion companion = Result.Companion;
                                    continuation4.resumeWith(Result.constructor-impl(str2));
                                    return;
                                }
                            }
                            if (BduploaderImageXUploader.Events.INSTANCE.getMSG_SINGLE_FAIL() == -1 && j != 0) {
                                Continuation continuation5 = continuation3;
                                Result.Companion companion2 = Result.Companion;
                                continuation5.resumeWith(Result.constructor-impl(ResultKt.createFailure(new ImageUploadException(ImageUploadErrorCode.UPLOAD_FAILED, "Upload failed, errorCode=" + j, null, 4, null))));
                                return;
                            }
                            if (what == BduploaderImageXUploader.Events.INSTANCE.getMSG_UPDATE_PROGRESS()) {
                                function1.invoke(Integer.valueOf(RangesKt.coerceIn((int) parameter, 0, 100)));
                                return;
                            }
                            if (what == BduploaderImageXUploader.Events.INSTANCE.getMSG_SINGLE_COMPLETE()) {
                                String str4 = str2;
                                if (str4 != null && !StringsKt.isBlank(str4)) {
                                    z = false;
                                }
                                if (!z) {
                                    Continuation continuation6 = continuation3;
                                    Result.Companion companion3 = Result.Companion;
                                    continuation6.resumeWith(Result.constructor-impl(str2));
                                    return;
                                } else {
                                    Continuation continuation7 = continuation3;
                                    Result.Companion companion4 = Result.Companion;
                                    continuation7.resumeWith(Result.constructor-impl(ResultKt.createFailure(new ImageUploadException(ImageUploadErrorCode.UPLOAD_FAILED, "Upload completed but mImageTosKey is empty", null, 4, null))));
                                    return;
                                }
                            }
                            if (what == BduploaderImageXUploader.Events.INSTANCE.getMSG_SINGLE_FAIL()) {
                                Continuation continuation8 = continuation3;
                                Result.Companion companion5 = Result.Companion;
                                continuation8.resumeWith(Result.constructor-impl(ResultKt.createFailure(new ImageUploadException(ImageUploadErrorCode.UPLOAD_FAILED, "Upload failed, errorCode=" + j, null, 4, null))));
                                return;
                            }
                            BduploaderImageXUploader.Events.INSTANCE.getMSG_ALL_COMPLETE();
                        }
                    });
                    continuation3.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.bytedance.trae.conversation.imageupload.BduploaderImageXUploader$upload$2$2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                            invoke((Throwable) obj3);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Throwable th) {
                            BDImageXUploader bDImageXUploader3 = bDImageXUploader2;
                            try {
                                Result.Companion companion = Result.Companion;
                                bDImageXUploader3.stop();
                                Result.constructor-impl(Unit.INSTANCE);
                            } catch (Throwable th2) {
                                Result.Companion companion2 = Result.Companion;
                                Result.constructor-impl(ResultKt.createFailure(th2));
                            }
                            BduploaderImageXUploader.upload$closeAndRemove(BduploaderImageXUploader.this, bDImageXUploader2);
                        }
                    });
                    try {
                        Result.Companion companion = Result.Companion;
                        BduploaderImageXUploader bduploaderImageXUploader2 = this;
                        bDImageXUploader2.start();
                        obj = Result.constructor-impl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    Throwable th2 = Result.exceptionOrNull-impl(obj);
                    if (th2 != null) {
                        Result.Companion companion3 = Result.Companion;
                        continuation3.resumeWith(Result.constructor-impl(ResultKt.createFailure(new ImageUploadException(ImageUploadErrorCode.UPLOAD_FAILED, "uploader.start() failed", th2))));
                    }
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation2);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    bduploaderImageXUploader = this;
                    obj2 = result;
                    bDImageXUploader = bDImageXUploader2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    bDImageXUploader = (BDImageXUploader) bduploaderImageXUploader$upload$1.L$2;
                    bduploaderImageXUploader = (BduploaderImageXUploader) bduploaderImageXUploader$upload$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                }
                upload$closeAndRemove(bduploaderImageXUploader, bDImageXUploader);
                return obj2;
            }
        }
        bduploaderImageXUploader$upload$1 = new BduploaderImageXUploader$upload$1(this, continuation);
        Object obj22 = bduploaderImageXUploader$upload$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bduploaderImageXUploader$upload$1.label;
        if (i != 0) {
        }
        upload$closeAndRemove(bduploaderImageXUploader, bDImageXUploader);
        return obj22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void upload$closeAndRemove(BduploaderImageXUploader bduploaderImageXUploader, BDImageXUploader bDImageXUploader) {
        try {
            Result.Companion companion = Result.Companion;
            bDImageXUploader.close();
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        bduploaderImageXUploader.activeUploaders.remove(bDImageXUploader);
    }

    @Override // com.bytedance.trae.conversation.imageupload.ImageXUploader
    public void close() {
        List<BDImageXUploader> list;
        synchronized (this.activeUploaders) {
            list = CollectionsKt.toList(this.activeUploaders);
        }
        for (BDImageXUploader bDImageXUploader : list) {
            try {
                Result.Companion companion = Result.Companion;
                BduploaderImageXUploader bduploaderImageXUploader = this;
                bDImageXUploader.stop();
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
            try {
                Result.Companion companion3 = Result.Companion;
                BduploaderImageXUploader bduploaderImageXUploader2 = this;
                bDImageXUploader.close();
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th2));
            }
        }
        this.activeUploaders.clear();
    }
}
