package com.bytedance.trae.conversation.products;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.products.ArchiveExtractionResult;
import com.bytedance.trae.conversation.products.HtmlArtifactPreviewFailure;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HtmlArtifactPreviewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity$startDownloadAndPreview$1", f = "HtmlArtifactPreviewActivity.kt", i = {0, 1, 1}, l = {289, 317, 378}, m = "invokeSuspend", n = {"fetchUrlStartTime", "fetchUrlDuration", "downloadStartTime"}, s = {"J$0", "J$0", "J$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class HtmlArtifactPreviewActivity$startDownloadAndPreview$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HtmlArtifactRemoteArchiveResolveMode $remoteResolveMode;
    final /* synthetic */ long $startTime;
    long J$0;
    long J$1;
    int label;
    final /* synthetic */ HtmlArtifactPreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HtmlArtifactPreviewActivity$startDownloadAndPreview$1(HtmlArtifactPreviewActivity htmlArtifactPreviewActivity, HtmlArtifactRemoteArchiveResolveMode htmlArtifactRemoteArchiveResolveMode, long j, Continuation<? super HtmlArtifactPreviewActivity$startDownloadAndPreview$1> continuation) {
        super(2, continuation);
        this.this$0 = htmlArtifactPreviewActivity;
        this.$remoteResolveMode = htmlArtifactRemoteArchiveResolveMode;
        this.$startTime = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HtmlArtifactPreviewActivity$startDownloadAndPreview$1(this.this$0, this.$remoteResolveMode, this.$startTime, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01b7  */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Integer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        long currentTimeMillis;
        Object fetchFileUrl;
        long currentTimeMillis2;
        long currentTimeMillis3;
        Object downloadAndUnzip;
        ArchiveExtractionResult archiveExtractionResult;
        String str;
        HtmlArtifactDownloadTarget htmlArtifactDownloadTarget;
        String str2;
        HtmlArtifactDownloadTarget htmlArtifactDownloadTarget2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            currentTimeMillis = System.currentTimeMillis();
            this.J$0 = currentTimeMillis;
            this.label = 1;
            fetchFileUrl = this.this$0.fetchFileUrl(this.$remoteResolveMode, (Continuation) this);
            if (fetchFileUrl == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                currentTimeMillis3 = this.J$1;
                currentTimeMillis2 = this.J$0;
                ResultKt.throwOnFailure(obj);
                downloadAndUnzip = obj;
                archiveExtractionResult = (ArchiveExtractionResult) downloadAndUnzip;
                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                if (archiveExtractionResult instanceof ArchiveExtractionResult.Success) {
                    if (!(archiveExtractionResult instanceof ArchiveExtractionResult.Failure)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    HtmlArtifactPreviewFailure failure = ((ArchiveExtractionResult.Failure) archiveExtractionResult).getFailure();
                    HtmlArtifactPreviewActivity htmlArtifactPreviewActivity = this.this$0;
                    boolean z2 = failure instanceof HtmlArtifactPreviewFailure.ArchiveDownload;
                    str = "unknown";
                    if (z2) {
                        StringBuilder sb = new StringBuilder("download_error_");
                        ?? httpStatusCode = ((HtmlArtifactPreviewFailure.ArchiveDownload) failure).getHttpStatusCode();
                        str = sb.append((Object) (httpStatusCode != 0 ? httpStatusCode : "unknown")).toString();
                    } else if (failure instanceof HtmlArtifactPreviewFailure.InvalidArchive) {
                        str = "invalid_archive";
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("download_duration_ms", currentTimeMillis4);
                    if (z2) {
                        HtmlArtifactPreviewFailure.ArchiveDownload archiveDownload = (HtmlArtifactPreviewFailure.ArchiveDownload) failure;
                        String message = archiveDownload.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        jSONObject.put("error_message", message);
                        Integer httpStatusCode2 = archiveDownload.getHttpStatusCode();
                        jSONObject.put("http_status_code", httpStatusCode2 != null ? httpStatusCode2.intValue() : -1);
                    }
                    Unit unit = Unit.INSTANCE;
                    htmlArtifactPreviewActivity.reportApm("fail", "download_unzip", str, jSONObject);
                    this.this$0.showError(failure);
                    return Unit.INSTANCE;
                }
                ArchiveExtractionResult.Success success = (ArchiveExtractionResult.Success) archiveExtractionResult;
                HtmlArtifactEntryResolver htmlArtifactEntryResolver = HtmlArtifactEntryResolver.INSTANCE;
                File extractDir = success.getExtractDir();
                htmlArtifactDownloadTarget = this.this$0.downloadTarget;
                HtmlArtifactDownloadTarget htmlArtifactDownloadTarget3 = null;
                if (htmlArtifactDownloadTarget == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadTarget");
                    htmlArtifactDownloadTarget = null;
                }
                File findEntryHtml = htmlArtifactEntryResolver.findEntryHtml(extractDir, htmlArtifactDownloadTarget.getRequestedHtmlName());
                if (findEntryHtml == null) {
                    FLogger fLogger = FLogger.INSTANCE;
                    StringBuilder sb2 = new StringBuilder("startDownloadAndPreview: no html entry found, path=");
                    str2 = this.this$0.path;
                    if (str2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("path");
                        str2 = null;
                    }
                    fLogger.e("HtmlArtifactPreview", sb2.append(str2).append(", extractDir=").append(success.getExtractDir().getAbsolutePath()).toString());
                    HtmlArtifactPreviewActivity htmlArtifactPreviewActivity2 = this.this$0;
                    JSONObject jSONObject2 = new JSONObject();
                    HtmlArtifactPreviewActivity htmlArtifactPreviewActivity3 = this.this$0;
                    jSONObject2.put("download_duration_ms", currentTimeMillis4);
                    htmlArtifactDownloadTarget2 = htmlArtifactPreviewActivity3.downloadTarget;
                    if (htmlArtifactDownloadTarget2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("downloadTarget");
                    } else {
                        htmlArtifactDownloadTarget3 = htmlArtifactDownloadTarget2;
                    }
                    jSONObject2.put("requested_html_name", htmlArtifactDownloadTarget3.getRequestedHtmlName());
                    Unit unit2 = Unit.INSTANCE;
                    htmlArtifactPreviewActivity2.reportApm("fail", "find_entry", "entry_unavailable", jSONObject2);
                    this.this$0.showError(HtmlArtifactPreviewFailure.EntryUnavailable.INSTANCE);
                    return Unit.INSTANCE;
                }
                long currentTimeMillis5 = System.currentTimeMillis() - this.$startTime;
                HtmlArtifactPreviewActivity htmlArtifactPreviewActivity4 = this.this$0;
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("total_duration_ms", currentTimeMillis5);
                jSONObject3.put("fetch_url_duration_ms", currentTimeMillis2);
                jSONObject3.put("download_duration_ms", currentTimeMillis4);
                Unit unit3 = Unit.INSTANCE;
                HtmlArtifactPreviewActivity.reportApm$default(htmlArtifactPreviewActivity4, "success", "complete", null, jSONObject3, 4, null);
                this.label = 3;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C07595(this.this$0, findEntryHtml, success, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            currentTimeMillis = this.J$0;
            ResultKt.throwOnFailure(obj);
            fetchFileUrl = obj;
        }
        String str3 = (String) fetchFileUrl;
        currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        String str4 = str3;
        if (str4 != null && str4.length() != 0) {
            z = false;
        }
        if (z) {
            HtmlArtifactPreviewActivity htmlArtifactPreviewActivity5 = this.this$0;
            JSONObject jSONObject4 = new JSONObject();
            HtmlArtifactRemoteArchiveResolveMode htmlArtifactRemoteArchiveResolveMode = this.$remoteResolveMode;
            jSONObject4.put("fetch_url_duration_ms", currentTimeMillis2);
            jSONObject4.put("resolve_mode", htmlArtifactRemoteArchiveResolveMode.name());
            Unit unit4 = Unit.INSTANCE;
            htmlArtifactPreviewActivity5.reportApm("fail", "fetch_url", "url_unavailable", jSONObject4);
            this.this$0.showError(HtmlArtifactPreviewFailure.UrlUnavailable.INSTANCE);
            return Unit.INSTANCE;
        }
        HtmlArtifactPreviewActivity htmlArtifactPreviewActivity6 = this.this$0;
        JSONObject jSONObject5 = new JSONObject();
        HtmlArtifactRemoteArchiveResolveMode htmlArtifactRemoteArchiveResolveMode2 = this.$remoteResolveMode;
        jSONObject5.put("fetch_url_duration_ms", currentTimeMillis2);
        jSONObject5.put("resolve_mode", htmlArtifactRemoteArchiveResolveMode2.name());
        Unit unit5 = Unit.INSTANCE;
        HtmlArtifactPreviewActivity.reportApm$default(htmlArtifactPreviewActivity6, "success", "fetch_url", null, jSONObject5, 4, null);
        currentTimeMillis3 = System.currentTimeMillis();
        this.J$0 = currentTimeMillis2;
        this.J$1 = currentTimeMillis3;
        this.label = 2;
        downloadAndUnzip = this.this$0.downloadAndUnzip(str3, (Continuation) this);
        if (downloadAndUnzip == coroutine_suspended) {
            return coroutine_suspended;
        }
        archiveExtractionResult = (ArchiveExtractionResult) downloadAndUnzip;
        long currentTimeMillis42 = System.currentTimeMillis() - currentTimeMillis3;
        if (archiveExtractionResult instanceof ArchiveExtractionResult.Success) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HtmlArtifactPreviewActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity$startDownloadAndPreview$1$5", f = "HtmlArtifactPreviewActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity$startDownloadAndPreview$1$5 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07595 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArchiveExtractionResult.Success $archive;
        final /* synthetic */ File $entryFile;
        int label;
        final /* synthetic */ HtmlArtifactPreviewActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07595(HtmlArtifactPreviewActivity htmlArtifactPreviewActivity, File file, ArchiveExtractionResult.Success success, Continuation<? super C07595> continuation) {
            super(2, continuation);
            this.this$0 = htmlArtifactPreviewActivity;
            this.$entryFile = file;
            this.$archive = success;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07595(this.this$0, this.$entryFile, this.$archive, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.showWebView(this.$entryFile, this.$archive.getArchiveFile());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
