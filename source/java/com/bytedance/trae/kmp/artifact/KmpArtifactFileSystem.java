package com.bytedance.trae.kmp.artifact;

import com.bytedance.android.live.core.setting.v2.tools.SettingV2Monitor;
import com.ss.android.download.api.constant.Downloads;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import net.openid.appauth.AuthorizationRequest;

/* compiled from: KmpArtifactIo.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&J&\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJ&\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0007\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aH¦@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0018J\u001e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H¦@¢\u0006\u0002\u0010!J\u001e\u0010\"\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H&¨\u0006&"}, d2 = {"Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;", "", "createTemporaryFile", "Lcom/bytedance/trae/kmp/artifact/KmpFileReference;", "prefix", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "file", "relativePath", "write", "", "bytes", "", "append", "", "(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;[BZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", SettingV2Monitor.REPORT_TYPE_READ, "offset", "", "length", "", "(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "metadata", "Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;", "(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "list", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exists", "delete", "atomicReplace", "source", Downloads.Impl.COLUMN_DESTINATION, "(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;Lcom/bytedance/trae/kmp/artifact/KmpFileReference;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", AuthorizationRequest.Display.TOUCH, "modifiedAtMillis", "(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "localUri", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface KmpArtifactFileSystem {
    Object atomicReplace(KmpFileReference kmpFileReference, KmpFileReference kmpFileReference2, Continuation<? super Unit> continuation);

    Object createTemporaryFile(String str, Continuation<? super KmpFileReference> continuation);

    Object delete(KmpFileReference kmpFileReference, Continuation<? super Boolean> continuation);

    Object exists(KmpFileReference kmpFileReference, Continuation<? super Boolean> continuation);

    KmpFileReference file(String relativePath);

    Object list(Continuation<? super List<KmpFileReference>> continuation);

    String localUri(KmpFileReference file);

    Object metadata(KmpFileReference kmpFileReference, Continuation<? super KmpFileMetadata> continuation);

    Object read(KmpFileReference kmpFileReference, long j, int i, Continuation<? super byte[]> continuation);

    Object touch(KmpFileReference kmpFileReference, long j, Continuation<? super Unit> continuation);

    Object write(KmpFileReference kmpFileReference, byte[] bArr, boolean z, Continuation<? super Unit> continuation);
}
