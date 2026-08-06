package com.bytedance.trae.conversation.products;

import android.content.Context;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.products.ArchiveExtractionResult;
import com.bytedance.trae.conversation.products.DownloadCacheResult;
import com.bytedance.trae.conversation.products.HtmlArtifactPreviewFailure;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.utils.logger.FLogger;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HtmlArtifactPreviewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity$downloadAndUnzip$2", f = "HtmlArtifactPreviewActivity.kt", i = {}, l = {456}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class HtmlArtifactPreviewActivity$downloadAndUnzip$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArchiveExtractionResult>, Object> {
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ HtmlArtifactPreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HtmlArtifactPreviewActivity$downloadAndUnzip$2(HtmlArtifactPreviewActivity htmlArtifactPreviewActivity, String str, Continuation<? super HtmlArtifactPreviewActivity$downloadAndUnzip$2> continuation) {
        super(2, continuation);
        this.this$0 = htmlArtifactPreviewActivity;
        this.$url = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HtmlArtifactPreviewActivity$downloadAndUnzip$2(this.this$0, this.$url, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArchiveExtractionResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00ae A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        FileDownloadHelper fileDownloadHelper;
        String str;
        String str2;
        HtmlArtifactDownloadTarget htmlArtifactDownloadTarget;
        String str3;
        boolean z;
        long j;
        Object downloadToCacheWithResult$conversation_mainlandRelease;
        String str4;
        HtmlArtifactDownloadTarget htmlArtifactDownloadTarget2;
        String str5;
        String str6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                fileDownloadHelper = this.this$0.fileDownloadHelper;
                Context applicationContext = AppHost.INSTANCE.getApplication().getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                String str7 = this.$url;
                str = this.this$0.conversationId;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("conversationId");
                    str2 = null;
                } else {
                    str2 = str;
                }
                htmlArtifactDownloadTarget = this.this$0.downloadTarget;
                if (htmlArtifactDownloadTarget == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadTarget");
                    htmlArtifactDownloadTarget = null;
                }
                String localRequestPath = htmlArtifactDownloadTarget.getLocalRequestPath();
                str3 = this.this$0.cliType;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cliType");
                    str3 = null;
                }
                if (!Intrinsics.areEqual(str3, CliType.LOCAL.getValue())) {
                    str4 = this.this$0.cliType;
                    if (str4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cliType");
                        str4 = null;
                    }
                    if (!Intrinsics.areEqual(str4, CliType.IDE.getValue())) {
                        z = false;
                        j = this.this$0.createdTime;
                        this.label = 1;
                        downloadToCacheWithResult$conversation_mainlandRelease = fileDownloadHelper.downloadToCacheWithResult$conversation_mainlandRelease(applicationContext, str7, str2, localRequestPath, z, j, (Continuation) this);
                        if (downloadToCacheWithResult$conversation_mainlandRelease == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                z = true;
                j = this.this$0.createdTime;
                this.label = 1;
                downloadToCacheWithResult$conversation_mainlandRelease = fileDownloadHelper.downloadToCacheWithResult$conversation_mainlandRelease(applicationContext, str7, str2, localRequestPath, z, j, (Continuation) this);
                if (downloadToCacheWithResult$conversation_mainlandRelease == coroutine_suspended) {
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                downloadToCacheWithResult$conversation_mainlandRelease = obj;
            }
            DownloadCacheResult downloadCacheResult = (DownloadCacheResult) downloadToCacheWithResult$conversation_mainlandRelease;
            if (!(downloadCacheResult instanceof DownloadCacheResult.Success)) {
                if (!(downloadCacheResult instanceof DownloadCacheResult.Failure)) {
                    throw new NoWhenBranchMatchedException();
                }
                FLogger.INSTANCE.e("HtmlArtifactPreview", "downloadAndUnzip: download failed, error=" + ((DownloadCacheResult.Failure) downloadCacheResult).getMessage());
                return new ArchiveExtractionResult.Failure(new HtmlArtifactPreviewFailure.ArchiveDownload(((DownloadCacheResult.Failure) downloadCacheResult).getMessage(), ((DownloadCacheResult.Failure) downloadCacheResult).getHttpStatusCode()));
            }
            File file = ((DownloadCacheResult.Success) downloadCacheResult).getFile();
            if (file.exists() && file.length() != 0) {
                htmlArtifactDownloadTarget2 = this.this$0.downloadTarget;
                if (htmlArtifactDownloadTarget2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadTarget");
                    htmlArtifactDownloadTarget2 = null;
                }
                String substringBeforeLast$default = StringsKt.substringBeforeLast$default(htmlArtifactDownloadTarget2.getRequestedHtmlName(), '.', (String) null, 2, (Object) null);
                File filesDir = this.this$0.getFilesDir();
                StringBuilder sb = new StringBuilder("html_artifacts/");
                str5 = this.this$0.conversationId;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("conversationId");
                    str6 = null;
                } else {
                    str6 = str5;
                }
                File file2 = new File(filesDir, sb.append(str6).append('/').append(substringBeforeLast$default).toString());
                if (file2.exists()) {
                    FilesKt.deleteRecursively(file2);
                }
                file2.mkdirs();
                this.this$0.unzipFile(file, file2);
                FLogger.INSTANCE.d("HtmlArtifactPreview", "downloadAndUnzip: extracted to " + file2.getAbsolutePath());
                return new ArchiveExtractionResult.Success(file2, file);
            }
            FLogger.INSTANCE.e("HtmlArtifactPreview", "downloadAndUnzip: download failed");
            return new ArchiveExtractionResult.Failure(new HtmlArtifactPreviewFailure.ArchiveDownload("Downloaded file is invalid", null, 2, null));
        } catch (Throwable th) {
            FLogger.INSTANCE.e("HtmlArtifactPreview", "downloadAndUnzip failed", th);
            return new ArchiveExtractionResult.Failure(HtmlArtifactPreviewFailure.InvalidArchive.INSTANCE);
        }
    }
}
