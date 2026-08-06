package com.bytedance.trae.conversation.widget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputAttachmentListModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.widget.InputAttachmentListModel", f = "InputAttachmentListModel.kt", i = {}, l = {668, 685}, m = "uploadImageFile", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InputAttachmentListModel$uploadImageFile$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InputAttachmentListModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAttachmentListModel$uploadImageFile$1(InputAttachmentListModel inputAttachmentListModel, Continuation<? super InputAttachmentListModel$uploadImageFile$1> continuation) {
        super(continuation);
        this.this$0 = inputAttachmentListModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object uploadImageFile;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        uploadImageFile = this.this$0.uploadImageFile(null, null, null, (Continuation) this);
        return uploadImageFile;
    }
}
