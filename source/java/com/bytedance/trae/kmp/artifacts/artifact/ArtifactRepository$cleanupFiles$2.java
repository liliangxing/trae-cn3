package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem;
import com.bytedance.trae.kmp.artifact.KmpFileReference;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository$cleanupFiles$2", f = "ArtifactRepository.kt", i = {}, l = {354}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArtifactRepository$cleanupFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Collection<KmpFileReference> $files;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ArtifactRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactRepository$cleanupFiles$2(Collection<KmpFileReference> collection, ArtifactRepository artifactRepository, Continuation<? super ArtifactRepository$cleanupFiles$2> continuation) {
        super(2, continuation);
        this.$files = collection;
        this.this$0 = artifactRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArtifactRepository$cleanupFiles$2(this.$files, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ArtifactRepository artifactRepository;
        Iterator it;
        KmpArtifactFileSystem kmpArtifactFileSystem;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Collection<KmpFileReference> collection = this.$files;
            artifactRepository = this.this$0;
            it = collection.iterator();
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) this.L$1;
            artifactRepository = (ArtifactRepository) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable unused) {
            }
        }
        while (it.hasNext()) {
            KmpFileReference kmpFileReference = (KmpFileReference) it.next();
            try {
                kmpArtifactFileSystem = artifactRepository.fileSystem;
                this.L$0 = artifactRepository;
                this.L$1 = it;
                this.label = 1;
            } catch (Throwable unused2) {
            }
            if (kmpArtifactFileSystem.delete(kmpFileReference, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
