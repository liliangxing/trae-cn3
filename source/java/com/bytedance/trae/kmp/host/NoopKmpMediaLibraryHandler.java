package com.bytedance.trae.kmp.host;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: KmpMediaLibrary.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/kmp/host/NoopKmpMediaLibraryHandler;", "Lcom/bytedance/trae/kmp/host/KmpMediaLibraryHandler;", "<init>", "()V", "saveLocalFile", "Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;", "localUri", "", "displayName", DBDefinition.MIME_TYPE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
final class NoopKmpMediaLibraryHandler implements KmpMediaLibraryHandler {
    public static final NoopKmpMediaLibraryHandler INSTANCE = new NoopKmpMediaLibraryHandler();

    private NoopKmpMediaLibraryHandler() {
    }

    @Override // com.bytedance.trae.kmp.host.KmpMediaLibraryHandler
    public Object saveLocalFile(String str, String str2, String str3, Continuation<? super KmpMediaLibrarySaveResult> continuation) {
        return new KmpMediaLibrarySaveResult(false, "Media library handler is not configured");
    }
}
