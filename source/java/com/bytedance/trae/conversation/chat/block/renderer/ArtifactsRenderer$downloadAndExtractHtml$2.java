package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.products.DownloadCacheResult;
import com.bytedance.trae.conversation.products.FileDownloadHelper;
import com.bytedance.trae.conversation.products.HtmlArtifactDownloadTarget;
import com.bytedance.trae.conversation.products.HtmlArtifactEntryResolver;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.utils.logger.FLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* compiled from: ArtifactsRenderer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$downloadAndExtractHtml$2", f = "ArtifactsRenderer.kt", i = {0}, l = {1336}, m = "invokeSuspend", n = {"downloadTarget"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class ArtifactsRenderer$downloadAndExtractHtml$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ String $cliType;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ JSONObject $extras;
    final /* synthetic */ String $filePath;
    final /* synthetic */ String $url;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactsRenderer$downloadAndExtractHtml$2(String str, String str2, String str3, String str4, JSONObject jSONObject, Context context, Continuation<? super ArtifactsRenderer$downloadAndExtractHtml$2> continuation) {
        super(2, continuation);
        this.$filePath = str;
        this.$url = str2;
        this.$conversationId = str3;
        this.$cliType = str4;
        this.$extras = jSONObject;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArtifactsRenderer$downloadAndExtractHtml$2(this.$filePath, this.$url, this.$conversationId, this.$cliType, this.$extras, this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x0080 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        boolean z;
        Object downloadToCacheWithResult$conversation_mainlandRelease;
        HtmlArtifactDownloadTarget htmlArtifactDownloadTarget;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HtmlArtifactDownloadTarget fromPreviewPath = HtmlArtifactDownloadTarget.INSTANCE.fromPreviewPath(this.$filePath);
                FileDownloadHelper fileDownloadHelper = new FileDownloadHelper();
                Context applicationContext = AppHost.INSTANCE.getApplication().getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                String str = this.$url;
                String str2 = this.$conversationId;
                String localRequestPath = fromPreviewPath.getLocalRequestPath();
                if (!Intrinsics.areEqual(this.$cliType, CliType.LOCAL.getValue()) && !Intrinsics.areEqual(this.$cliType, CliType.IDE.getValue())) {
                    z = false;
                    this.L$0 = fromPreviewPath;
                    this.label = 1;
                    downloadToCacheWithResult$conversation_mainlandRelease = fileDownloadHelper.downloadToCacheWithResult$conversation_mainlandRelease(applicationContext, str, str2, localRequestPath, (r19 & 16) != 0 ? false : z, (r19 & 32) != 0 ? 0L : 0L, (Continuation) this);
                    if (downloadToCacheWithResult$conversation_mainlandRelease != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    htmlArtifactDownloadTarget = fromPreviewPath;
                }
                z = true;
                this.L$0 = fromPreviewPath;
                this.label = 1;
                downloadToCacheWithResult$conversation_mainlandRelease = fileDownloadHelper.downloadToCacheWithResult$conversation_mainlandRelease(applicationContext, str, str2, localRequestPath, (r19 & 16) != 0 ? false : z, (r19 & 32) != 0 ? 0L : 0L, (Continuation) this);
                if (downloadToCacheWithResult$conversation_mainlandRelease != coroutine_suspended) {
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                htmlArtifactDownloadTarget = (HtmlArtifactDownloadTarget) this.L$0;
                ResultKt.throwOnFailure(obj);
                downloadToCacheWithResult$conversation_mainlandRelease = obj;
            }
            DownloadCacheResult downloadCacheResult = (DownloadCacheResult) downloadToCacheWithResult$conversation_mainlandRelease;
            if (downloadCacheResult instanceof DownloadCacheResult.Success) {
                ArtifactFileUrlHelper.INSTANCE.reportApm("download_html", this.$cliType, "success", "", this.$extras);
                File file = ((DownloadCacheResult.Success) downloadCacheResult).getFile();
                if (file.exists() && file.length() != 0) {
                    File file2 = new File(this.$context.getFilesDir(), "html_artifacts/" + this.$conversationId + '/' + StringsKt.substringBeforeLast$default(htmlArtifactDownloadTarget.getRequestedHtmlName(), '.', (String) null, 2, (Object) null));
                    if (file2.exists()) {
                        FilesKt.deleteRecursively(file2);
                    }
                    file2.mkdirs();
                    FileOutputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
                    String str3 = this.$cliType;
                    JSONObject jSONObject = this.$extras;
                    try {
                        ZipInputStream zipInputStream2 = zipInputStream;
                        for (ZipEntry nextEntry = zipInputStream2.getNextEntry(); nextEntry != null; nextEntry = zipInputStream2.getNextEntry()) {
                            File file3 = new File(file2, nextEntry.getName());
                            String canonicalPath = file3.getCanonicalPath();
                            Intrinsics.checkNotNullExpressionValue(canonicalPath, "getCanonicalPath(...)");
                            String canonicalPath2 = file2.getCanonicalPath();
                            Intrinsics.checkNotNullExpressionValue(canonicalPath2, "getCanonicalPath(...)");
                            if (!StringsKt.startsWith$default(canonicalPath, canonicalPath2, false, 2, (Object) null)) {
                                ArtifactFileUrlHelper.INSTANCE.reportApm("unzip_html", str3, "failed", "outside_of_dir", jSONObject);
                                throw new SecurityException("Zip entry is outside of the target dir: " + nextEntry.getName());
                            }
                            if (nextEntry.isDirectory()) {
                                Boxing.boxBoolean(file3.mkdirs());
                            } else {
                                File parentFile = file3.getParentFile();
                                if (parentFile != null) {
                                    Boxing.boxBoolean(parentFile.mkdirs());
                                }
                                zipInputStream = new FileOutputStream(file3);
                                try {
                                    Boxing.boxLong(ByteStreamsKt.copyTo$default(zipInputStream2, zipInputStream, 0, 2, (Object) null));
                                    CloseableKt.closeFinally(zipInputStream, (Throwable) null);
                                } finally {
                                }
                            }
                            zipInputStream2.closeEntry();
                        }
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(zipInputStream, (Throwable) null);
                        ArtifactFileUrlHelper.INSTANCE.reportApm("unzip_html", this.$cliType, "success", "", this.$extras);
                        return HtmlArtifactEntryResolver.INSTANCE.findEntryHtml(file2, htmlArtifactDownloadTarget.getRequestedHtmlName());
                    } finally {
                    }
                }
                ArtifactFileUrlHelper.INSTANCE.reportApm("download_html", this.$cliType, "failed", "cache_file_error", this.$extras);
                return null;
            }
            if (!(downloadCacheResult instanceof DownloadCacheResult.Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            ArtifactFileUrlHelper.INSTANCE.reportApm("download_html", this.$cliType, "failed", ((DownloadCacheResult.Failure) downloadCacheResult).getMessage(), this.$extras);
            return null;
        } catch (Throwable th) {
            ArtifactFileUrlHelper.INSTANCE.reportApm("download_html", this.$cliType, "failed", th.getMessage(), this.$extras);
            FLogger.INSTANCE.e("AgentBlock", "downloadAndExtractHtml failed", th);
            return null;
        }
    }
}
