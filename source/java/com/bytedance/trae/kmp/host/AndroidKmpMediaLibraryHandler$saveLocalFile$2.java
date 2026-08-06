package com.bytedance.trae.kmp.host;

import android.os.Build;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidKmpMediaLibraryHandler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.host.AndroidKmpMediaLibraryHandler$saveLocalFile$2", f = "AndroidKmpMediaLibraryHandler.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class AndroidKmpMediaLibraryHandler$saveLocalFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super KmpMediaLibrarySaveResult>, Object> {
    final /* synthetic */ String $displayName;
    final /* synthetic */ String $localUri;
    final /* synthetic */ String $mimeType;
    int label;
    final /* synthetic */ AndroidKmpMediaLibraryHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidKmpMediaLibraryHandler$saveLocalFile$2(AndroidKmpMediaLibraryHandler androidKmpMediaLibraryHandler, String str, String str2, String str3, Continuation<? super AndroidKmpMediaLibraryHandler$saveLocalFile$2> continuation) {
        super(2, continuation);
        this.this$0 = androidKmpMediaLibraryHandler;
        this.$localUri = str;
        this.$displayName = str2;
        this.$mimeType = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidKmpMediaLibraryHandler$saveLocalFile$2(this.this$0, this.$localUri, this.$displayName, this.$mimeType, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super KmpMediaLibrarySaveResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        File resolveLocalFile;
        KmpMediaLibrarySaveResult saveWithMediaStore;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                resolveLocalFile = this.this$0.resolveLocalFile(this.$localUri);
                if (!resolveLocalFile.isFile()) {
                    throw new IllegalStateException("Local file does not exist".toString());
                }
                String substringAfterLast$default = StringsKt.substringAfterLast$default(this.$displayName, '/', (String) null, 2, (Object) null);
                if (StringsKt.isBlank(substringAfterLast$default)) {
                    substringAfterLast$default = resolveLocalFile.getName();
                }
                String str = substringAfterLast$default;
                if (Build.VERSION.SDK_INT >= 29) {
                    AndroidKmpMediaLibraryHandler androidKmpMediaLibraryHandler = this.this$0;
                    Intrinsics.checkNotNull(str);
                    saveWithMediaStore = androidKmpMediaLibraryHandler.saveWithMediaStore(resolveLocalFile, str, this.$mimeType);
                    return saveWithMediaStore;
                }
                AndroidKmpMediaLibraryHandler androidKmpMediaLibraryHandler2 = this.this$0;
                Intrinsics.checkNotNull(str);
                this.label = 1;
                obj = androidKmpMediaLibraryHandler2.saveWithFileApi(resolveLocalFile, str, this.$mimeType, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return (KmpMediaLibrarySaveResult) obj;
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            return new KmpMediaLibrarySaveResult(false, th.getMessage());
        }
    }
}
