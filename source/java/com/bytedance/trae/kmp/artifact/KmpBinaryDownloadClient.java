package com.bytedance.trae.kmp.artifact;

import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import kotlin.Metadata;

/* compiled from: KmpArtifactIo.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadClient;", "", "downloadToFile", "Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadTask;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadRequest;", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface KmpBinaryDownloadClient {
    KmpBinaryDownloadTask downloadToFile(KmpBinaryDownloadRequest request);
}
