package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem;
import com.bytedance.trae.kmp.artifact.KmpFileReference;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository$SharedTemporaryFile$release$1", f = "ArtifactRepository.kt", i = {0}, l = {542, 509}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArtifactRepository$SharedTemporaryFile$release$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $leaseId;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ArtifactRepository.SharedTemporaryFile this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactRepository$SharedTemporaryFile$release$1(ArtifactRepository.SharedTemporaryFile sharedTemporaryFile, long j, Continuation<? super ArtifactRepository$SharedTemporaryFile$release$1> continuation) {
        super(2, continuation);
        this.this$0 = sharedTemporaryFile;
        this.$leaseId = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArtifactRepository$SharedTemporaryFile$release$1(this.this$0, this.$leaseId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0070, code lost:
    
        if (r9 == 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        ArtifactRepository.SharedTemporaryFile sharedTemporaryFile;
        long j;
        Set set;
        int i;
        boolean z;
        int i2;
        KmpArtifactFileSystem kmpArtifactFileSystem;
        KmpFileReference kmpFileReference;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z2 = true;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.this$0.mutex;
                sharedTemporaryFile = this.this$0;
                j = this.$leaseId;
                this.L$0 = mutex;
                this.L$1 = sharedTemporaryFile;
                this.J$0 = j;
                this.label = 1;
                if (mutex.lock((Object) null, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i3 != 1) {
                    if (i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                j = this.J$0;
                sharedTemporaryFile = (ArtifactRepository.SharedTemporaryFile) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            set = sharedTemporaryFile.releasedLeaseIds;
            if (set.add(Boxing.boxLong(j))) {
                i = sharedTemporaryFile.activeLeases;
                sharedTemporaryFile.activeLeases = RangesKt.coerceAtLeast(i - 1, 0);
                z = sharedTemporaryFile.distributionFinished;
                if (z) {
                    i2 = sharedTemporaryFile.activeLeases;
                }
            }
            z2 = false;
            if (z2) {
                kmpArtifactFileSystem = this.this$0.fileSystem;
                kmpFileReference = this.this$0.file;
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                if (kmpArtifactFileSystem.delete(kmpFileReference, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } finally {
            mutex.unlock((Object) null);
        }
    }
}
