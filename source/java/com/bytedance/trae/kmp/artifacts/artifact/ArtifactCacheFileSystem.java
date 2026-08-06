package com.bytedance.trae.kmp.artifacts.artifact;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: ArtifactDiskCache.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem;", "", "list", "", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFile;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "", "reference", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ArtifactCacheFileSystem {
    Object delete(String str, Continuation<? super Boolean> continuation);

    Object list(Continuation<? super List<ArtifactCacheFile>> continuation);
}
