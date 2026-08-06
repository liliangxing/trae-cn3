package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.trae.kmp.artifact.KmpArtifactIo;
import com.bytedance.trae.kmp.network.AndroidKmpHttpClientFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: AndroidArtifactRepositoryProvider.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/AndroidArtifactRepositoryProvider;", "", "<init>", "()V", "processScope", "Lkotlinx/coroutines/CoroutineScope;", "repository", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;", "getRepository", "()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;", "repository$delegate", "Lkotlin/Lazy;", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AndroidArtifactRepositoryProvider {
    public static final AndroidArtifactRepositoryProvider INSTANCE = new AndroidArtifactRepositoryProvider();
    private static final CoroutineScope processScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getDefault()));

    /* renamed from: repository$delegate, reason: from kotlin metadata */
    private static final Lazy repository = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.kmp.artifacts.artifact.AndroidArtifactRepositoryProvider$$ExternalSyntheticLambda0
        public final Object invoke() {
            ArtifactRepository repository_delegate$lambda$0;
            repository_delegate$lambda$0 = AndroidArtifactRepositoryProvider.repository_delegate$lambda$0();
            return repository_delegate$lambda$0;
        }
    });
    public static final int $stable = 8;

    private AndroidArtifactRepositoryProvider() {
    }

    public final ArtifactRepository getRepository() {
        return (ArtifactRepository) repository.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArtifactRepository repository_delegate$lambda$0() {
        return new ArtifactRepository(AndroidKmpHttpClientFactory.INSTANCE.get(), KmpArtifactIo.INSTANCE.binaryDownloadClient(), KmpArtifactIo.INSTANCE.fileSystem(), processScope, 0L, null, null, 112, null);
    }
}
