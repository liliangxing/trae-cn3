package com.bytedance.trae.kmp.host;

import com.bytedance.ug.sdk.deeplink.EventConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidKmpMediaLibraryHandler.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.host.AndroidKmpMediaLibraryHandler", f = "AndroidKmpMediaLibraryHandler.kt", i = {0, 0, 0, 0}, l = {109, 122}, m = "saveWithFileApi", n = {"this", EventConstants.PARAM_SOURCE, "displayName", "mimeType"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AndroidKmpMediaLibraryHandler$saveWithFileApi$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidKmpMediaLibraryHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidKmpMediaLibraryHandler$saveWithFileApi$1(AndroidKmpMediaLibraryHandler androidKmpMediaLibraryHandler, Continuation<? super AndroidKmpMediaLibraryHandler$saveWithFileApi$1> continuation) {
        super(continuation);
        this.this$0 = androidKmpMediaLibraryHandler;
    }

    public final Object invokeSuspend(Object obj) {
        Object saveWithFileApi;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        saveWithFileApi = this.this$0.saveWithFileApi(null, null, null, (Continuation) this);
        return saveWithFileApi;
    }
}
