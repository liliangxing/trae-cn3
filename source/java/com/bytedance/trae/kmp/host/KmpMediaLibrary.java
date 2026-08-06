package com.bytedance.trae.kmp.host;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpMediaLibrary.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/kmp/host/KmpMediaLibrary;", "", "<init>", "()V", "handler", "Lcom/bytedance/trae/kmp/host/KmpMediaLibraryHandler;", "configure", "", "saveLocalFile", "Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;", "localUri", "", "displayName", DBDefinition.MIME_TYPE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KmpMediaLibrary {
    public static final KmpMediaLibrary INSTANCE = new KmpMediaLibrary();
    private static KmpMediaLibraryHandler handler = NoopKmpMediaLibraryHandler.INSTANCE;
    public static final int $stable = 8;

    private KmpMediaLibrary() {
    }

    public final void configure(KmpMediaLibraryHandler handler2) {
        Intrinsics.checkNotNullParameter(handler2, "handler");
        handler = handler2;
    }

    public final Object saveLocalFile(String str, String str2, String str3, Continuation<? super KmpMediaLibrarySaveResult> continuation) {
        return handler.saveLocalFile(str, str2, str3, continuation);
    }
}
