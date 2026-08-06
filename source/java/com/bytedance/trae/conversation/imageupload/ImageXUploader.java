package com.bytedance.trae.conversation.imageupload;

import com.bytedance.trae.conversation.imageupload.ImageXUploader;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* compiled from: BduploaderImageXUploader.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH¦@¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u000eH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/ImageXUploader;", "", "upload", "", "file", "Ljava/io/File;", "storeKey", "sts", "Lcom/bytedance/trae/conversation/imageupload/StsTokenData;", "uploaderConfig", "Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;", "onProgress", "Lkotlin/Function1;", "", "", "(Ljava/io/File;Ljava/lang/String;Lcom/bytedance/trae/conversation/imageupload/StsTokenData;Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ImageXUploader {
    void close();

    Object upload(File file, String str, StsTokenData stsTokenData, UploaderConfig uploaderConfig, Function1<? super Integer, Unit> function1, Continuation<? super String> continuation);

    /* compiled from: BduploaderImageXUploader.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static void close(ImageXUploader imageXUploader) {
        }

        public static /* synthetic */ Object upload$default(ImageXUploader imageXUploader, File file, String str, StsTokenData stsTokenData, UploaderConfig uploaderConfig, Function1 function1, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: upload");
            }
            if ((i & 16) != 0) {
                function1 = new Function1() { // from class: com.bytedance.trae.conversation.imageupload.ImageXUploader$DefaultImpls$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit upload$lambda$0;
                        upload$lambda$0 = ImageXUploader.DefaultImpls.upload$lambda$0(((Integer) obj2).intValue());
                        return upload$lambda$0;
                    }
                };
            }
            return imageXUploader.upload(file, str, stsTokenData, uploaderConfig, function1, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Unit upload$lambda$0(int i) {
            return Unit.INSTANCE;
        }
    }
}
