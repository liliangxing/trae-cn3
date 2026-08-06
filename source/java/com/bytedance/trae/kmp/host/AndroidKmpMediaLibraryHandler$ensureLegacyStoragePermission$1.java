package com.bytedance.trae.kmp.host;

import com.bytedance.memory.shrink.HprofMemoryConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidKmpMediaLibraryHandler.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.host.AndroidKmpMediaLibraryHandler", f = "AndroidKmpMediaLibraryHandler.kt", i = {}, l = {HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_INTERNED_STRING}, m = "ensureLegacyStoragePermission", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AndroidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidKmpMediaLibraryHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1(AndroidKmpMediaLibraryHandler androidKmpMediaLibraryHandler, Continuation<? super AndroidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1> continuation) {
        super(continuation);
        this.this$0 = androidKmpMediaLibraryHandler;
    }

    public final Object invokeSuspend(Object obj) {
        Object ensureLegacyStoragePermission;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        ensureLegacyStoragePermission = this.this$0.ensureLegacyStoragePermission((Continuation) this);
        return ensureLegacyStoragePermission;
    }
}
