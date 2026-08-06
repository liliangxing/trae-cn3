package com.bytedance.trae.conversation.products;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.PermissionRationaleDialog;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.fileupload.ResourceUploadUtilKt;
import com.bytedance.trae.conversation.products.DownloadCacheResult;
import com.bytedance.trae.conversation.products.SaveFileResult;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageParams;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadStartCallback;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: FileDownloadHelper.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005JD\u0010(\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u001e2\b\b\u0002\u0010,\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010-JD\u0010.\u001a\u00020/2\u0006\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u001e2\b\b\u0002\u0010,\u001a\u00020\u0014H\u0080@¢\u0006\u0004\b0\u0010-J \u00101\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020&2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005Jf\u00102\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00052\u0006\u00103\u001a\u0002042 \u00105\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f\u0018\u0001062\b\b\u0002\u0010+\u001a\u00020\u001e2\b\b\u0002\u0010,\u001a\u00020\u0014J^\u00107\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\b\u00108\u001a\u0004\u0018\u00010#2\u0006\u0010*\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00052\u0006\u00103\u001a\u0002042 \u00105\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f\u0018\u0001062\b\b\u0002\u0010,\u001a\u00020\u0014Jb\u00109\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u00103\u001a\u0002042 \u0010:\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f\u0018\u0001062\u0006\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u0014H\u0002JZ\u0010;\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\u0006\u00108\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u00103\u001a\u0002042 \u0010:\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f\u0018\u0001062\u0006\u0010,\u001a\u00020\u0014H\u0002J<\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050=2\u0006\u0010%\u001a\u00020&2\u0006\u00108\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0014H\u0002JJ\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050=2\u0006\u0010%\u001a\u00020&2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010-J$\u0010@\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020&2\u0006\u0010A\u001a\u00020\u00052\b\b\u0002\u0010B\u001a\u00020\u0005H\u0002J\"\u0010C\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\u0006\u0010A\u001a\u00020\u00052\b\b\u0002\u0010D\u001a\u00020\u0005H\u0002J*\u0010E\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020&2\u0006\u00108\u001a\u00020#2\u0006\u0010A\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u0005H\u0002J2\u0010F\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020&2\u0006\u00108\u001a\u00020#2\u0006\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J:\u0010I\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020&2\u0006\u00108\u001a\u00020#2\u0006\u0010G\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J \u0010K\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0002J&\u0010L\u001a\u00020\n2\u0006\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020\u00052\u0006\u00108\u001a\u00020#H\u0082@¢\u0006\u0002\u0010MJ\u0010\u0010N\u001a\u00020\f2\u0006\u0010O\u001a\u00020\u0005H\u0002J\u0010\u0010P\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/bytedance/trae/conversation/products/FileDownloadHelper;", "", "<init>", "()V", "TAG", "", "downloadContinuationMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlinx/coroutines/CancellableContinuation;", "Lcom/bytedance/trae/conversation/products/SaveFileResult;", "resumeDownloadContinuation", "", "downloadId", "result", "RESULT_CODE_FAILED_CRASH", "RESULT_CODE_FAILED_NO_WRITE_EXTERNAL_PERMISSION", "RESULT_CODE_SUCCESS", "RESULT_CODE_FAILED_DOWNLOAD", "MIN_TRIGGER_LOADING_DURATION", "", "downloadingDatas", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "downloadFinishBlk", "Lkotlin/Function1;", "uploadLoadingJobMap", "Lkotlinx/coroutines/Job;", "getExternalRelativePath", "isImage", "", "buildDisplayPath", "relativePath", "fileName", "getExternalTargetDir", "Ljava/io/File;", "getExistingFilePath", "context", "Landroid/content/Context;", "path", "downloadToCache", IWeixinService.ResponseConstants.URL, "sessionId", "needDecode", "createTime", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadToCacheWithResult", "Lcom/bytedance/trae/conversation/products/DownloadCacheResult;", "downloadToCacheWithResult$conversation_mainlandRelease", "getCachedFile", "saveFileAndLoading", "scope", "Lkotlinx/coroutines/CoroutineScope;", "finishCallback", "Lkotlin/Function3;", "copyCachedFileAndLoading", "cacheFile", "saveFileAndLoadingInternal", "dismissLoadingCallback", "copyCachedFileAndLoadingInternal", "copyCachedFile", "Lkotlin/Pair;", "downloadFile", "uri", "getExternalFilePath", "originalPath", "conversionId", "removeExternalFile", "conversationId", "copyToExternalDownload", "copyToExternalViaMediaStore", "originalName", "mimeType", "copyToExternalViaFileApi", DBData.FIELD_EXT, "getCacheFilePath", "saveFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelUpdateLoadingJob", "data", "getMimeType", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FileDownloadHelper {
    private final int RESULT_CODE_SUCCESS;
    private final String TAG = "FileDownloadHelper";
    private final ConcurrentHashMap<Integer, CancellableContinuation<SaveFileResult>> downloadContinuationMap = new ConcurrentHashMap<>();
    private final int RESULT_CODE_FAILED_CRASH = -1;
    private final int RESULT_CODE_FAILED_NO_WRITE_EXTERNAL_PERMISSION = 601;
    private final int RESULT_CODE_FAILED_DOWNLOAD = -2;
    private final long MIN_TRIGGER_LOADING_DURATION = 200;
    private final MutableStateFlow<List<String>> downloadingDatas = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    private final Function1<String, Unit> downloadFinishBlk = new Function1() { // from class: com.bytedance.trae.conversation.products.FileDownloadHelper$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit downloadFinishBlk$lambda$0;
            downloadFinishBlk$lambda$0 = FileDownloadHelper.downloadFinishBlk$lambda$0(FileDownloadHelper.this, (String) obj);
            return downloadFinishBlk$lambda$0;
        }
    };
    private final ConcurrentHashMap<String, Job> uploadLoadingJobMap = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    public final void resumeDownloadContinuation(int downloadId, SaveFileResult result) {
        Continuation continuation = (CancellableContinuation) this.downloadContinuationMap.remove(Integer.valueOf(downloadId));
        if (continuation != null && continuation.isActive()) {
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.constructor-impl(result));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit downloadFinishBlk$lambda$0(FileDownloadHelper fileDownloadHelper, String str) {
        Intrinsics.checkNotNullParameter(str, "data");
        List mutableList = CollectionsKt.toMutableList((Collection) fileDownloadHelper.downloadingDatas.getValue());
        mutableList.remove(str);
        fileDownloadHelper.downloadingDatas.setValue(mutableList);
        fileDownloadHelper.cancelUpdateLoadingJob(str);
        return Unit.INSTANCE;
    }

    private final String getExternalRelativePath(boolean isImage) {
        if (isImage) {
            return Environment.DIRECTORY_PICTURES + File.separator + "trae";
        }
        return Environment.DIRECTORY_DOWNLOADS + File.separator + SiteMessageParams.platform + File.separator + "trae";
    }

    private final String buildDisplayPath(String relativePath, String fileName) {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + relativePath + File.separator + fileName;
    }

    private final File getExternalTargetDir(boolean isImage) {
        if (isImage) {
            return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "trae");
        }
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), SiteMessageParams.platform + File.separator + "trae");
    }

    public final String getExistingFilePath(Context context, String path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        return getExternalFilePath$default(this, context, path, null, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object downloadToCache(Context context, String str, String str2, String str3, boolean z, long j, Continuation<? super File> continuation) {
        FileDownloadHelper$downloadToCache$1 fileDownloadHelper$downloadToCache$1;
        int i;
        DownloadCacheResult downloadCacheResult;
        if (continuation instanceof FileDownloadHelper$downloadToCache$1) {
            fileDownloadHelper$downloadToCache$1 = (FileDownloadHelper$downloadToCache$1) continuation;
            if ((fileDownloadHelper$downloadToCache$1.label & Integer.MIN_VALUE) != 0) {
                fileDownloadHelper$downloadToCache$1.label -= Integer.MIN_VALUE;
                FileDownloadHelper$downloadToCache$1 fileDownloadHelper$downloadToCache$12 = fileDownloadHelper$downloadToCache$1;
                Object obj = fileDownloadHelper$downloadToCache$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fileDownloadHelper$downloadToCache$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    fileDownloadHelper$downloadToCache$12.label = 1;
                    obj = downloadToCacheWithResult$conversation_mainlandRelease(context, str, str2, str3, z, j, fileDownloadHelper$downloadToCache$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                downloadCacheResult = (DownloadCacheResult) obj;
                if (!(downloadCacheResult instanceof DownloadCacheResult.Success)) {
                    return ((DownloadCacheResult.Success) downloadCacheResult).getFile();
                }
                if (downloadCacheResult instanceof DownloadCacheResult.Failure) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        fileDownloadHelper$downloadToCache$1 = new FileDownloadHelper$downloadToCache$1(this, continuation);
        FileDownloadHelper$downloadToCache$1 fileDownloadHelper$downloadToCache$122 = fileDownloadHelper$downloadToCache$1;
        Object obj2 = fileDownloadHelper$downloadToCache$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fileDownloadHelper$downloadToCache$122.label;
        if (i != 0) {
        }
        downloadCacheResult = (DownloadCacheResult) obj2;
        if (!(downloadCacheResult instanceof DownloadCacheResult.Success)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x018d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object downloadToCacheWithResult$conversation_mainlandRelease(Context context, String str, String str2, String str3, boolean z, long j, Continuation<? super DownloadCacheResult> continuation) {
        FileDownloadHelper$downloadToCacheWithResult$1 fileDownloadHelper$downloadToCacheWithResult$1;
        int i;
        File cacheFilePath;
        long j2;
        FileDownloadHelper fileDownloadHelper;
        boolean z2;
        File file;
        Long longOrNull;
        SaveFileResult saveFileResult;
        if (continuation instanceof FileDownloadHelper$downloadToCacheWithResult$1) {
            fileDownloadHelper$downloadToCacheWithResult$1 = (FileDownloadHelper$downloadToCacheWithResult$1) continuation;
            if ((fileDownloadHelper$downloadToCacheWithResult$1.label & Integer.MIN_VALUE) != 0) {
                fileDownloadHelper$downloadToCacheWithResult$1.label -= Integer.MIN_VALUE;
                Object obj = fileDownloadHelper$downloadToCacheWithResult$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fileDownloadHelper$downloadToCacheWithResult$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    cacheFilePath = getCacheFilePath(context, str2, str3);
                    String nameWithoutExtension = FilesKt.getNameWithoutExtension(cacheFilePath);
                    FLogger.INSTANCE.d(this.TAG, "downloadToCache: cacheFile=" + cacheFilePath + " exists=" + cacheFilePath.exists() + " length=" + cacheFilePath.length());
                    File parentFile = cacheFilePath.getParentFile();
                    if (parentFile != null) {
                        Boxing.boxBoolean(parentFile.mkdirs());
                    }
                    try {
                        File file2 = new File(cacheFilePath.getParent(), nameWithoutExtension + "_time.txt");
                        longOrNull = StringsKt.toLongOrNull((file2.exists() && file2.isFile()) ? StringsKt.trim(FilesKt.readText$default(file2, (Charset) null, 1, (Object) null)).toString() : "");
                    } catch (Throwable unused) {
                    }
                    if (longOrNull != null) {
                        j2 = longOrNull.longValue();
                        if (cacheFilePath.exists() && !cacheFilePath.isFile()) {
                            FilesKt.deleteRecursively(cacheFilePath);
                        }
                        if (!(cacheFilePath.exists() || cacheFilePath.length() == 0 || (j > 0 && j2 != j))) {
                            if (cacheFilePath.exists()) {
                                cacheFilePath.delete();
                            }
                            File parentFile2 = cacheFilePath.getParentFile();
                            if (parentFile2 != null) {
                                Boxing.boxBoolean(parentFile2.mkdirs());
                            }
                            fileDownloadHelper$downloadToCacheWithResult$1.L$0 = this;
                            fileDownloadHelper$downloadToCacheWithResult$1.L$1 = cacheFilePath;
                            fileDownloadHelper$downloadToCacheWithResult$1.Z$0 = z;
                            fileDownloadHelper$downloadToCacheWithResult$1.label = 1;
                            Object saveFile = saveFile(context, str, cacheFilePath, fileDownloadHelper$downloadToCacheWithResult$1);
                            if (saveFile == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            fileDownloadHelper = this;
                            file = cacheFilePath;
                            obj = saveFile;
                            z2 = z;
                        } else {
                            fileDownloadHelper = this;
                            z2 = z;
                            if (z2) {
                                try {
                                    FilesKt.writeBytes(cacheFilePath, ResourceUploadUtilKt.decodeContent(FilesKt.readBytes(cacheFilePath)));
                                } catch (Throwable th) {
                                    FLogger.INSTANCE.e(fileDownloadHelper.TAG, "decode failed", th);
                                    return new DownloadCacheResult.Failure(th.getMessage(), null, 2, null);
                                }
                            }
                            return new DownloadCacheResult.Success(cacheFilePath);
                        }
                    }
                    j2 = 0;
                    if (cacheFilePath.exists()) {
                        FilesKt.deleteRecursively(cacheFilePath);
                    }
                    if (!(cacheFilePath.exists() || cacheFilePath.length() == 0 || (j > 0 && j2 != j))) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z2 = fileDownloadHelper$downloadToCacheWithResult$1.Z$0;
                    file = (File) fileDownloadHelper$downloadToCacheWithResult$1.L$1;
                    fileDownloadHelper = (FileDownloadHelper) fileDownloadHelper$downloadToCacheWithResult$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                saveFileResult = (SaveFileResult) obj;
                if (!(saveFileResult instanceof SaveFileResult.Failure)) {
                    SaveFileResult.Failure failure = (SaveFileResult.Failure) saveFileResult;
                    FLogger.INSTANCE.e(fileDownloadHelper.TAG, "downloadToCache: download failed, error=" + failure.getMessage());
                    return new DownloadCacheResult.Failure(failure.getMessage(), failure.getHttpStatusCode());
                }
                if (!file.exists() || file.length() == 0) {
                    FLogger.INSTANCE.d(fileDownloadHelper.TAG, "downloadToCache: file invalid after download");
                    file.delete();
                    return new DownloadCacheResult.Failure("Downloaded file is invalid", null, 2, null);
                }
                cacheFilePath = file;
                if (z2) {
                }
                return new DownloadCacheResult.Success(cacheFilePath);
            }
        }
        fileDownloadHelper$downloadToCacheWithResult$1 = new FileDownloadHelper$downloadToCacheWithResult$1(this, continuation);
        Object obj2 = fileDownloadHelper$downloadToCacheWithResult$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fileDownloadHelper$downloadToCacheWithResult$1.label;
        if (i != 0) {
        }
        saveFileResult = (SaveFileResult) obj2;
        if (!(saveFileResult instanceof SaveFileResult.Failure)) {
        }
    }

    public final File getCachedFile(Context context, String sessionId, String path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(path, "path");
        File cacheFilePath = getCacheFilePath(context, sessionId, path);
        if (cacheFilePath.exists() && cacheFilePath.isFile() && cacheFilePath.length() > 0) {
            return cacheFilePath;
        }
        return null;
    }

    public final void saveFileAndLoading(Context context, final String url, final String sessionId, final String path, final CoroutineScope scope, final Function3<? super Integer, ? super String, ? super Long, Unit> finishCallback, final boolean needDecode, final long createTime) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (path == null) {
            return;
        }
        Job launch$default = BuildersKt.launch$default(scope, Dispatchers.getMain(), (CoroutineStart) null, new FileDownloadHelper$saveFileAndLoading$updateLoadingJob$1(this, path, null), 2, (Object) null);
        launch$default.invokeOnCompletion(new Function1() { // from class: com.bytedance.trae.conversation.products.FileDownloadHelper$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit saveFileAndLoading$lambda$2;
                saveFileAndLoading$lambda$2 = FileDownloadHelper.saveFileAndLoading$lambda$2(FileDownloadHelper.this, path, (Throwable) obj);
                return saveFileAndLoading$lambda$2;
            }
        });
        this.uploadLoadingJobMap.put(path, launch$default);
        if (Build.VERSION.SDK_INT <= 28 && ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            final FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity != null) {
                PermissionRationaleDialog.INSTANCE.showForPermission((Context) fragmentActivity, C0591R.drawable.trae_ic_permission_file, R.string.trae_permission_storage_title, R.string.trae_permission_storage_message, R.string.trae_permission_allow, R.string.trae_permission_deny, new Function0() { // from class: com.bytedance.trae.conversation.products.FileDownloadHelper$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit saveFileAndLoading$lambda$5;
                        saveFileAndLoading$lambda$5 = FileDownloadHelper.saveFileAndLoading$lambda$5(fragmentActivity, this, url, sessionId, path, scope, finishCallback, needDecode, createTime);
                        return saveFileAndLoading$lambda$5;
                    }
                }, (r19 & 128) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.PermissionRationaleDialog$Companion$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                } : null);
                return;
            }
            this.downloadFinishBlk.invoke(path);
            if (finishCallback != null) {
                finishCallback.invoke(Integer.valueOf(this.RESULT_CODE_FAILED_CRASH), "", 0L);
                return;
            }
            return;
        }
        Context applicationContext = AppHost.INSTANCE.getApplication().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        saveFileAndLoadingInternal(applicationContext, url, sessionId, path, scope, finishCallback, needDecode, createTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit saveFileAndLoading$lambda$2(FileDownloadHelper fileDownloadHelper, String str, Throwable th) {
        FLogger.INSTANCE.i(fileDownloadHelper.TAG, "invokeOnCompletion: " + th + " with path " + str);
        fileDownloadHelper.uploadLoadingJobMap.remove(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit saveFileAndLoading$lambda$5(FragmentActivity fragmentActivity, final FileDownloadHelper fileDownloadHelper, final String str, final String str2, final String str3, final CoroutineScope coroutineScope, final Function3 function3, final boolean z, final long j) {
        PermissionService.INSTANCE.permission(fragmentActivity, CollectionsKt.listOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}), new Function1() { // from class: com.bytedance.trae.conversation.products.FileDownloadHelper$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit saveFileAndLoading$lambda$5$lambda$4;
                saveFileAndLoading$lambda$5$lambda$4 = FileDownloadHelper.saveFileAndLoading$lambda$5$lambda$4(FileDownloadHelper.this, str, str2, str3, coroutineScope, function3, z, j, ((Boolean) obj).booleanValue());
                return saveFileAndLoading$lambda$5$lambda$4;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit saveFileAndLoading$lambda$5$lambda$4(FileDownloadHelper fileDownloadHelper, String str, String str2, String str3, CoroutineScope coroutineScope, Function3 function3, boolean z, long j, boolean z2) {
        if (z2) {
            Context applicationContext = AppHost.INSTANCE.getApplication().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            fileDownloadHelper.saveFileAndLoadingInternal(applicationContext, str, str2, str3, coroutineScope, function3, z, j);
        } else {
            FLogger.INSTANCE.d("Music Edit Error", "no permission");
            if (function3 != null) {
                function3.invoke(Integer.valueOf(fileDownloadHelper.RESULT_CODE_FAILED_NO_WRITE_EXTERNAL_PERMISSION), "", 0L);
            }
            fileDownloadHelper.downloadFinishBlk.invoke(str3);
        }
        return Unit.INSTANCE;
    }

    public final void copyCachedFileAndLoading(Context context, final File cacheFile, final String sessionId, final String path, final CoroutineScope scope, final Function3<? super Integer, ? super String, ? super Long, Unit> finishCallback, final long createTime) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (path == null) {
            return;
        }
        if (cacheFile == null || !cacheFile.exists() || cacheFile.length() == 0) {
            if (finishCallback != null) {
                finishCallback.invoke(Integer.valueOf(this.RESULT_CODE_FAILED_DOWNLOAD), "", 0L);
                return;
            }
            return;
        }
        Job launch$default = BuildersKt.launch$default(scope, Dispatchers.getMain(), (CoroutineStart) null, new FileDownloadHelper$copyCachedFileAndLoading$updateLoadingJob$1(this, path, null), 2, (Object) null);
        launch$default.invokeOnCompletion(new Function1() { // from class: com.bytedance.trae.conversation.products.FileDownloadHelper$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit copyCachedFileAndLoading$lambda$6;
                copyCachedFileAndLoading$lambda$6 = FileDownloadHelper.copyCachedFileAndLoading$lambda$6(FileDownloadHelper.this, path, (Throwable) obj);
                return copyCachedFileAndLoading$lambda$6;
            }
        });
        this.uploadLoadingJobMap.put(path, launch$default);
        if (Build.VERSION.SDK_INT <= 28 && ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity != null) {
                final FragmentActivity fragmentActivity2 = fragmentActivity;
                PermissionRationaleDialog.INSTANCE.showForPermission((Context) fragmentActivity, C0591R.drawable.trae_ic_permission_file, R.string.trae_permission_storage_title, R.string.trae_permission_storage_message, R.string.trae_permission_allow, R.string.trae_permission_deny, new Function0() { // from class: com.bytedance.trae.conversation.products.FileDownloadHelper$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit copyCachedFileAndLoading$lambda$9;
                        copyCachedFileAndLoading$lambda$9 = FileDownloadHelper.copyCachedFileAndLoading$lambda$9(fragmentActivity2, this, cacheFile, sessionId, path, scope, finishCallback, createTime);
                        return copyCachedFileAndLoading$lambda$9;
                    }
                }, (r19 & 128) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.PermissionRationaleDialog$Companion$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                } : null);
                return;
            } else {
                this.downloadFinishBlk.invoke(path);
                if (finishCallback != null) {
                    finishCallback.invoke(Integer.valueOf(this.RESULT_CODE_FAILED_CRASH), "", 0L);
                    return;
                }
                return;
            }
        }
        Context applicationContext = AppHost.INSTANCE.getApplication().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        copyCachedFileAndLoadingInternal(applicationContext, cacheFile, sessionId, path, scope, finishCallback, createTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copyCachedFileAndLoading$lambda$6(FileDownloadHelper fileDownloadHelper, String str, Throwable th) {
        FLogger.INSTANCE.i(fileDownloadHelper.TAG, "invokeOnCompletion: " + th + " with path " + str);
        fileDownloadHelper.uploadLoadingJobMap.remove(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copyCachedFileAndLoading$lambda$9(FragmentActivity fragmentActivity, final FileDownloadHelper fileDownloadHelper, final File file, final String str, final String str2, final CoroutineScope coroutineScope, final Function3 function3, final long j) {
        PermissionService.INSTANCE.permission(fragmentActivity, CollectionsKt.listOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}), new Function1() { // from class: com.bytedance.trae.conversation.products.FileDownloadHelper$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit copyCachedFileAndLoading$lambda$9$lambda$8;
                copyCachedFileAndLoading$lambda$9$lambda$8 = FileDownloadHelper.copyCachedFileAndLoading$lambda$9$lambda$8(FileDownloadHelper.this, file, str, str2, coroutineScope, function3, j, ((Boolean) obj).booleanValue());
                return copyCachedFileAndLoading$lambda$9$lambda$8;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copyCachedFileAndLoading$lambda$9$lambda$8(FileDownloadHelper fileDownloadHelper, File file, String str, String str2, CoroutineScope coroutineScope, Function3 function3, long j, boolean z) {
        if (z) {
            Context applicationContext = AppHost.INSTANCE.getApplication().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            fileDownloadHelper.copyCachedFileAndLoadingInternal(applicationContext, file, str, str2, coroutineScope, function3, j);
        } else {
            FLogger.INSTANCE.d("Music Edit Error", "no permission");
            if (function3 != null) {
                function3.invoke(Integer.valueOf(fileDownloadHelper.RESULT_CODE_FAILED_NO_WRITE_EXTERNAL_PERMISSION), "", 0L);
            }
            fileDownloadHelper.downloadFinishBlk.invoke(str2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Integer, String> copyCachedFile(Context context, File cacheFile, String sessionId, String path, long createTime) {
        if (!cacheFile.exists() || cacheFile.length() == 0) {
            return new Pair<>(Integer.valueOf(this.RESULT_CODE_FAILED_DOWNLOAD), "");
        }
        String externalFilePath = getExternalFilePath(context, path, sessionId);
        if (externalFilePath != null) {
            if (createTime <= 0) {
                FLogger.INSTANCE.d(this.TAG, "copyCachedFile: no createTime, existing file found=" + externalFilePath);
                return new Pair<>(Integer.valueOf(this.RESULT_CODE_SUCCESS), externalFilePath);
            }
            removeExternalFile(context, path, sessionId);
        }
        String copyToExternalDownload = copyToExternalDownload(context, cacheFile, path, sessionId);
        FLogger.INSTANCE.d(this.TAG, "copyCachedFile: copyToExternalDownload result=" + copyToExternalDownload + ", cacheFile=" + cacheFile.getAbsolutePath() + ", cacheExists=" + cacheFile.exists() + ", cacheSize=" + cacheFile.length());
        if (copyToExternalDownload != null) {
            return new Pair<>(Integer.valueOf(this.RESULT_CODE_SUCCESS), copyToExternalDownload);
        }
        FLogger.INSTANCE.e(this.TAG, "copyCachedFile: copyToExternalDownload failed for path=" + path);
        return new Pair<>(Integer.valueOf(this.RESULT_CODE_FAILED_DOWNLOAD), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0248 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0238  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object downloadFile(Context context, String str, String str2, String str3, boolean z, long j, Continuation<? super Pair<Integer, String>> continuation) {
        FileDownloadHelper$downloadFile$1 fileDownloadHelper$downloadFile$1;
        Object obj;
        int i;
        String externalFilePath;
        File file;
        long j2;
        File parentFile;
        boolean z2;
        Object obj2;
        Object obj3;
        Context context2;
        FileDownloadHelper fileDownloadHelper;
        File file2;
        boolean z3;
        String str4;
        String str5;
        String str6;
        long j3;
        File file3;
        Long longOrNull;
        String copyToExternalDownload;
        if (continuation instanceof FileDownloadHelper$downloadFile$1) {
            fileDownloadHelper$downloadFile$1 = (FileDownloadHelper$downloadFile$1) continuation;
            if ((fileDownloadHelper$downloadFile$1.label & Integer.MIN_VALUE) != 0) {
                fileDownloadHelper$downloadFile$1.label -= Integer.MIN_VALUE;
                obj = fileDownloadHelper$downloadFile$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fileDownloadHelper$downloadFile$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    externalFilePath = getExternalFilePath(context, str3, str2);
                    if (externalFilePath != null && j <= 0) {
                        FLogger.INSTANCE.d(this.TAG, "downloadFile: no createTime, existing file found=" + externalFilePath);
                        return new Pair(Boxing.boxInt(this.RESULT_CODE_SUCCESS), externalFilePath);
                    }
                    File cacheFilePath = getCacheFilePath(context, str2, str3);
                    FLogger.INSTANCE.d(this.TAG, "downloadFile: cacheFile=" + cacheFilePath + " exists=" + cacheFilePath.exists() + " length=" + cacheFilePath.length() + ' ' + j + ' ' + externalFilePath);
                    try {
                        file = new File(cacheFilePath.getParent(), FilesKt.getNameWithoutExtension(cacheFilePath) + "_time.txt");
                        try {
                            longOrNull = StringsKt.toLongOrNull((file.exists() && file.isFile()) ? StringsKt.trim(FilesKt.readText$default(file, (Charset) null, 1, (Object) null)).toString() : "");
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        file = null;
                    }
                    if (longOrNull != null) {
                        j2 = longOrNull.longValue();
                        parentFile = cacheFilePath.getParentFile();
                        if (parentFile != null) {
                            Boxing.boxBoolean(parentFile.mkdirs());
                        }
                        if (cacheFilePath.exists() && !cacheFilePath.isFile()) {
                            FilesKt.deleteRecursively(cacheFilePath);
                        }
                        z2 = cacheFilePath.exists() || cacheFilePath.length() == 0 || (j > 0 && j != j2);
                        obj2 = "";
                        FLogger.INSTANCE.d(this.TAG, "downloadFile: cacheFile=" + z2 + ' ' + j2);
                        if (!z2) {
                            if (cacheFilePath.exists()) {
                                cacheFilePath.delete();
                            }
                            File parentFile2 = cacheFilePath.getParentFile();
                            if (parentFile2 != null) {
                                Boxing.boxBoolean(parentFile2.mkdirs());
                            }
                            fileDownloadHelper$downloadFile$1.L$0 = this;
                            fileDownloadHelper$downloadFile$1.L$1 = context;
                            fileDownloadHelper$downloadFile$1.L$2 = str2;
                            fileDownloadHelper$downloadFile$1.L$3 = str3;
                            fileDownloadHelper$downloadFile$1.L$4 = externalFilePath;
                            fileDownloadHelper$downloadFile$1.L$5 = cacheFilePath;
                            fileDownloadHelper$downloadFile$1.L$6 = file;
                            fileDownloadHelper$downloadFile$1.Z$0 = z;
                            fileDownloadHelper$downloadFile$1.J$0 = j;
                            fileDownloadHelper$downloadFile$1.label = 1;
                            Object saveFile = saveFile(context, str, cacheFilePath, fileDownloadHelper$downloadFile$1);
                            if (saveFile == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            context2 = context;
                            str6 = externalFilePath;
                            obj = saveFile;
                            z3 = z;
                            fileDownloadHelper = this;
                            str4 = str2;
                            str5 = str3;
                            j3 = j;
                            file2 = cacheFilePath;
                            file3 = file;
                        } else {
                            obj3 = obj2;
                            context2 = context;
                            fileDownloadHelper = this;
                            file2 = cacheFilePath;
                            z3 = z;
                            str4 = str2;
                            str5 = str3;
                            if (z3) {
                                try {
                                    FilesKt.writeBytes(file2, ResourceUploadUtilKt.decodeContent(FilesKt.readBytes(file2)));
                                } catch (Throwable th) {
                                    FLogger.INSTANCE.e(fileDownloadHelper.TAG, "decode failed", th);
                                    return new Pair(Boxing.boxInt(fileDownloadHelper.RESULT_CODE_FAILED_DOWNLOAD), obj3);
                                }
                            }
                            if (externalFilePath != null) {
                                fileDownloadHelper.removeExternalFile(context2, str5, str4);
                            }
                            copyToExternalDownload = fileDownloadHelper.copyToExternalDownload(context2, file2, str5, str4);
                            FLogger.INSTANCE.d(fileDownloadHelper.TAG, "downloadFile: copyToExternalDownload result=" + copyToExternalDownload + ", cacheFile=" + file2.getAbsolutePath() + ", cacheExists=" + file2.exists() + ", cacheSize=" + file2.length());
                            if (copyToExternalDownload == null) {
                                return new Pair(Boxing.boxInt(fileDownloadHelper.RESULT_CODE_SUCCESS), copyToExternalDownload);
                            }
                            FLogger.INSTANCE.e(fileDownloadHelper.TAG, "downloadFile: copyToExternalDownload failed for path=" + str5);
                            return new Pair(Boxing.boxInt(fileDownloadHelper.RESULT_CODE_FAILED_DOWNLOAD), obj3);
                        }
                    }
                    j2 = 0;
                    parentFile = cacheFilePath.getParentFile();
                    if (parentFile != null) {
                    }
                    if (cacheFilePath.exists()) {
                        FilesKt.deleteRecursively(cacheFilePath);
                    }
                    if (cacheFilePath.exists()) {
                    }
                    obj2 = "";
                    FLogger.INSTANCE.d(this.TAG, "downloadFile: cacheFile=" + z2 + ' ' + j2);
                    if (!z2) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j3 = fileDownloadHelper$downloadFile$1.J$0;
                    z3 = fileDownloadHelper$downloadFile$1.Z$0;
                    file3 = (File) fileDownloadHelper$downloadFile$1.L$6;
                    file2 = (File) fileDownloadHelper$downloadFile$1.L$5;
                    str6 = (String) fileDownloadHelper$downloadFile$1.L$4;
                    str5 = (String) fileDownloadHelper$downloadFile$1.L$3;
                    str4 = (String) fileDownloadHelper$downloadFile$1.L$2;
                    context2 = (Context) fileDownloadHelper$downloadFile$1.L$1;
                    fileDownloadHelper = (FileDownloadHelper) fileDownloadHelper$downloadFile$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    obj2 = "";
                }
                if (!(((SaveFileResult) obj) instanceof SaveFileResult.Failure)) {
                    return new Pair(Boxing.boxInt(fileDownloadHelper.RESULT_CODE_FAILED_DOWNLOAD), obj2);
                }
                obj3 = obj2;
                if (!file2.exists() || file2.length() == 0) {
                    FLogger.INSTANCE.e(fileDownloadHelper.TAG, "downloadFile: file still invalid after download, exists=" + file2.exists() + ", length=" + file2.length());
                    file2.delete();
                    return new Pair(Boxing.boxInt(fileDownloadHelper.RESULT_CODE_FAILED_DOWNLOAD), obj3);
                }
                if (j3 > 0 && file3 != null) {
                    try {
                        FilesKt.writeText$default(file3, String.valueOf(j3), (Charset) null, 2, (Object) null);
                    } catch (Throwable unused3) {
                    }
                }
                externalFilePath = str6;
                if (z3) {
                }
                if (externalFilePath != null) {
                }
                copyToExternalDownload = fileDownloadHelper.copyToExternalDownload(context2, file2, str5, str4);
                FLogger.INSTANCE.d(fileDownloadHelper.TAG, "downloadFile: copyToExternalDownload result=" + copyToExternalDownload + ", cacheFile=" + file2.getAbsolutePath() + ", cacheExists=" + file2.exists() + ", cacheSize=" + file2.length());
                if (copyToExternalDownload == null) {
                }
            }
        }
        fileDownloadHelper$downloadFile$1 = new FileDownloadHelper$downloadFile$1(this, continuation);
        obj = fileDownloadHelper$downloadFile$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fileDownloadHelper$downloadFile$1.label;
        if (i != 0) {
        }
        if (!(((SaveFileResult) obj) instanceof SaveFileResult.Failure)) {
        }
    }

    static /* synthetic */ String getExternalFilePath$default(FileDownloadHelper fileDownloadHelper, Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        return fileDownloadHelper.getExternalFilePath(context, str, str2);
    }

    private final String getExternalFilePath(Context context, String originalPath, String conversionId) {
        Uri uri;
        String substringAfterLast$default = StringsKt.substringAfterLast$default(originalPath, '/', (String) null, 2, (Object) null);
        if (!TextUtils.isEmpty(conversionId)) {
            substringAfterLast$default = conversionId + '_' + substringAfterLast$default;
        }
        boolean startsWith$default = StringsKt.startsWith$default(getMimeType(substringAfterLast$default), "image/", false, 2, (Object) null);
        String externalRelativePath = getExternalRelativePath(startsWith$default);
        if (Build.VERSION.SDK_INT >= 29) {
            if (startsWith$default) {
                uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else {
                uri = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
            }
            Cursor query = context.getContentResolver().query(uri, new String[]{"_id", "_display_name", "_size"}, "_display_name = ? AND relative_path = ?", new String[]{substringAfterLast$default, externalRelativePath + '/'}, null);
            if (query != null) {
                Cursor cursor = query;
                try {
                    Cursor cursor2 = cursor;
                    if (cursor2.moveToFirst()) {
                        long j = cursor2.getLong(cursor2.getColumnIndexOrThrow("_size"));
                        String string = cursor2.getString(cursor2.getColumnIndexOrThrow("_display_name"));
                        if (j > 0) {
                            Intrinsics.checkNotNull(string);
                            String buildDisplayPath = buildDisplayPath(externalRelativePath, string);
                            CloseableKt.closeFinally(cursor, (Throwable) null);
                            return buildDisplayPath;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, (Throwable) null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursor, th);
                        throw th2;
                    }
                }
            }
            return null;
        }
        File file = new File(getExternalTargetDir(startsWith$default), substringAfterLast$default);
        if (file.exists() && file.isFile() && file.length() > 0) {
            return file.getAbsolutePath();
        }
        return null;
    }

    static /* synthetic */ void removeExternalFile$default(FileDownloadHelper fileDownloadHelper, Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        fileDownloadHelper.removeExternalFile(context, str, str2);
    }

    private final void removeExternalFile(Context context, String originalPath, String conversationId) {
        Uri uri;
        String substringAfterLast$default = StringsKt.substringAfterLast$default(originalPath, '/', (String) null, 2, (Object) null);
        if (!TextUtils.isEmpty(conversationId)) {
            substringAfterLast$default = conversationId + '_' + substringAfterLast$default;
        }
        boolean startsWith$default = StringsKt.startsWith$default(getMimeType(substringAfterLast$default), "image/", false, 2, (Object) null);
        String externalRelativePath = getExternalRelativePath(startsWith$default);
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                if (startsWith$default) {
                    uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else {
                    uri = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
                }
                FLogger.INSTANCE.d(this.TAG, "removeExternalFile: MediaStore deleted " + context.getContentResolver().delete(uri, "_display_name = ? AND relative_path = ?", new String[]{substringAfterLast$default, externalRelativePath + '/'}) + " rows for " + substringAfterLast$default);
                return;
            }
            File file = new File(getExternalTargetDir(startsWith$default), substringAfterLast$default);
            if (file.exists()) {
                FLogger.INSTANCE.d(this.TAG, "removeExternalFile: File.delete=" + file.delete() + " for " + file.getAbsolutePath());
            }
        } catch (Exception e) {
            FLogger.INSTANCE.e(this.TAG, "removeExternalFile failed for " + substringAfterLast$default, e);
        }
    }

    private final String copyToExternalDownload(Context context, File cacheFile, String originalPath, String conversationId) {
        String substringAfterLast$default = StringsKt.substringAfterLast$default(originalPath, '/', (String) null, 2, (Object) null);
        if (!TextUtils.isEmpty(conversationId)) {
            substringAfterLast$default = conversationId + '_' + substringAfterLast$default;
        }
        String str = substringAfterLast$default;
        String lowerCase = StringsKt.substringAfterLast(originalPath, '.', "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String mimeType = getMimeType(str);
        boolean startsWith$default = StringsKt.startsWith$default(mimeType, "image/", false, 2, (Object) null);
        if (Build.VERSION.SDK_INT >= 29) {
            return copyToExternalViaMediaStore(context, cacheFile, str, mimeType, startsWith$default);
        }
        return copyToExternalViaFileApi(context, cacheFile, str, lowerCase, mimeType, startsWith$default);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d1, code lost:
    
        if (r0 != null) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String copyToExternalViaMediaStore(Context context, File cacheFile, String originalName, String mimeType, boolean isImage) {
        Uri uri;
        String str;
        Cursor cursor;
        String externalRelativePath = getExternalRelativePath(isImage);
        if (isImage) {
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else {
            uri = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", originalName);
        contentValues.put("mime_type", mimeType);
        contentValues.put("relative_path", externalRelativePath);
        contentValues.put("is_pending", (Integer) 1);
        ContentResolver contentResolver = context.getContentResolver();
        Uri insert = contentResolver.insert(uri, contentValues);
        if (insert == null) {
            return null;
        }
        try {
            OutputStream openOutputStream = contentResolver.openOutputStream(insert);
            if (openOutputStream != null) {
                cursor = openOutputStream;
                try {
                    OutputStream outputStream = cursor;
                    cursor = new FileInputStream(cacheFile);
                    try {
                        long copyTo$default = ByteStreamsKt.copyTo$default(cursor, outputStream, 0, 2, (Object) null);
                        CloseableKt.closeFinally(cursor, (Throwable) null);
                        Long.valueOf(copyTo$default);
                        CloseableKt.closeFinally(cursor, (Throwable) null);
                    } finally {
                    }
                } finally {
                }
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("is_pending", (Integer) 0);
            if (contentResolver.update(insert, contentValues2, null, null) == 0) {
                FLogger.INSTANCE.w(this.TAG, "Failed to clear IS_PENDING for " + insert + ", deleting entry");
                contentResolver.delete(insert, null, null);
                return null;
            }
            Cursor query = contentResolver.query(insert, new String[]{"_display_name"}, null, null, null);
            if (query != null) {
                cursor = query;
                try {
                    Cursor cursor2 = cursor;
                    str = cursor2.moveToFirst() ? cursor2.getString(0) : null;
                    CloseableKt.closeFinally(cursor, (Throwable) null);
                } finally {
                    try {
                        throw th;
                    } finally {
                        CloseableKt.closeFinally(cursor, th);
                    }
                }
            }
            str = originalName;
            return buildDisplayPath(externalRelativePath, str);
        } catch (Exception e) {
            FLogger.INSTANCE.e(this.TAG, "copyToExternalViaMediaStore failed", e);
            try {
                contentResolver.delete(insert, null, null);
                return null;
            } catch (Exception e2) {
                FLogger.INSTANCE.e(this.TAG, "Failed to clean up MediaStore entry", e2);
                return null;
            }
        }
    }

    private final String copyToExternalViaFileApi(Context context, File cacheFile, String originalName, String ext, String mimeType, boolean isImage) {
        String str;
        File file;
        String str2 = originalName;
        File externalTargetDir = getExternalTargetDir(isImage);
        externalTargetDir.mkdirs();
        File file2 = new File(externalTargetDir, str2);
        if (file2.exists()) {
            String str3 = ext;
            if (str3.length() > 0) {
                str2 = StringsKt.substringBeforeLast$default(str2, '.', (String) null, 2, (Object) null);
            }
            int i = 1;
            do {
                if (str3.length() > 0) {
                    str = str2 + '(' + i + ")." + ext;
                } else {
                    str = str2 + '(' + i + ')';
                }
                file = new File(externalTargetDir, str);
                i++;
            } while (file.exists());
            file2 = file;
        }
        try {
            FilesKt.copyTo$default(cacheFile, file2, true, 0, 4, (Object) null);
            if (isImage) {
                MediaScannerConnection.scanFile(context, new String[]{file2.getAbsolutePath()}, new String[]{mimeType}, null);
            }
            return file2.getAbsolutePath();
        } catch (Exception e) {
            FLogger.INSTANCE.e(this.TAG, "copyToExternalViaFileApi failed", e);
            return null;
        }
    }

    private final File getCacheFilePath(Context context, String sessionId, String path) {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = path.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] digest = messageDigest.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
        String joinToString$default = ArraysKt.joinToString$default(digest, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.bytedance.trae.conversation.products.FileDownloadHelper$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                CharSequence cacheFilePath$lambda$18;
                cacheFilePath$lambda$18 = FileDownloadHelper.getCacheFilePath$lambda$18(((Byte) obj).byteValue());
                return cacheFilePath$lambda$18;
            }
        }, 30, (Object) null);
        String substringAfterLast = StringsKt.substringAfterLast(path, '.', "");
        if (substringAfterLast.length() > 0) {
            joinToString$default = joinToString$default + '.' + substringAfterLast;
        }
        File file = new File(new File(context.getCacheDir(), sessionId), joinToString$default);
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getCacheFilePath$lambda$18(byte b) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private final void cancelUpdateLoadingJob(String data) {
        Job job = this.uploadLoadingJobMap.get(data);
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0032. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0048 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getMimeType(String fileName) {
        String lowerCase = StringsKt.substringAfterLast(fileName, '.', "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        String str = mimeTypeFromExtension;
        if (!(str == null || str.length() == 0)) {
            return mimeTypeFromExtension;
        }
        switch (lowerCase.hashCode()) {
            case 1827:
                return !lowerCase.equals("7z") ? "application/octet-stream" : "application/x-7z-compressed";
            case 3479:
                if (lowerCase.equals("md")) {
                    return "text/markdown";
                }
                break;
            case 108184:
                if (lowerCase.equals("mkv")) {
                    return "video/x-matroska";
                }
                break;
            case 3145576:
                if (lowerCase.equals("flac")) {
                    return "audio/flac";
                }
                break;
            case 3198679:
                if (lowerCase.equals("heic")) {
                    return "image/heic";
                }
                break;
            case 3198682:
                if (lowerCase.equals("heif")) {
                }
                break;
        }
    }

    private final void saveFileAndLoadingInternal(Context context, String url, String sessionId, String fileName, CoroutineScope scope, Function3<? super Integer, ? super String, ? super Long, Unit> dismissLoadingCallback, boolean needDecode, long createTime) {
        BuildersKt.launch$default(scope, (CoroutineExceptionHandler) new C0758xd68b177a(CoroutineExceptionHandler.Key, dismissLoadingCallback, this, fileName), (CoroutineStart) null, new FileDownloadHelper$saveFileAndLoadingInternal$1(this, context, url, sessionId, fileName, needDecode, createTime, dismissLoadingCallback, null), 2, (Object) null);
    }

    private final void copyCachedFileAndLoadingInternal(Context context, File cacheFile, String sessionId, String fileName, CoroutineScope scope, Function3<? super Integer, ? super String, ? super Long, Unit> dismissLoadingCallback, long createTime) {
        BuildersKt.launch$default(scope, (CoroutineExceptionHandler) new C0757xf1cea940(CoroutineExceptionHandler.Key, dismissLoadingCallback, this, fileName), (CoroutineStart) null, new FileDownloadHelper$copyCachedFileAndLoadingInternal$1(this, context, cacheFile, sessionId, fileName, createTime, dismissLoadingCallback, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveFile(final Context context, String str, final File file, Continuation<? super SaveFileResult> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        final Ref.IntRef intRef = new Ref.IntRef();
        FLogger.INSTANCE.d(this.TAG, "saveFile: url=" + DownloadUrlLogSanitizer.INSTANCE.redactSensitiveQueryParams(str) + ", dir=" + file.getParent() + ", name=" + file.getName());
        IDownloadListener iDownloadListener = new AbsDownloadListener() { // from class: com.bytedance.trae.conversation.products.FileDownloadHelper$saveFile$2$listener$1
            public void onSuccessed(DownloadInfo entity) {
                FLogger.INSTANCE.i(FileDownloadHelper.this.TAG, "Download success: targetFilePath=" + (entity != null ? entity.getTargetFilePath() : null));
                FileDownloadHelper.this.resumeDownloadContinuation(intRef.element, new SaveFileResult.Success(entity != null ? entity.getTargetFilePath() : null));
            }

            public void onFailed(DownloadInfo entity, BaseException e) {
                int httpStatusCode;
                String[] strArr = new String[2];
                Integer num = null;
                strArr[0] = e != null ? e.getMessage() : null;
                strArr[1] = e != null ? e.toString() : null;
                String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.distinct(CollectionsKt.listOfNotNull(strArr)), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                if (StringsKt.isBlank(joinToString$default)) {
                    joinToString$default = null;
                }
                String str2 = joinToString$default;
                FLogger.INSTANCE.e(FileDownloadHelper.this.TAG, "Download failed: error=" + str2 + ", targetFilePath=" + (entity != null ? entity.getTargetFilePath() : null));
                FileDownloadHelper fileDownloadHelper = FileDownloadHelper.this;
                int i = intRef.element;
                if (entity == null) {
                    DownloadHttpException downloadHttpException = e instanceof DownloadHttpException ? (DownloadHttpException) e : null;
                    if (downloadHttpException != null) {
                        httpStatusCode = downloadHttpException.getHttpStatusCode();
                    }
                    fileDownloadHelper.resumeDownloadContinuation(i, new SaveFileResult.Failure(str2, num));
                }
                httpStatusCode = entity.getHttpStatusCode();
                num = Integer.valueOf(httpStatusCode);
                fileDownloadHelper.resumeDownloadContinuation(i, new SaveFileResult.Failure(str2, num));
            }

            public void onProgress(DownloadInfo entity) {
                super.onProgress(entity);
                FLogger.INSTANCE.d(FileDownloadHelper.this.TAG, "Download progress: " + (entity != null ? Integer.valueOf(entity.getDownloadProcess()) : null));
            }

            public void onStart(DownloadInfo entity) {
                super.onStart(entity);
                FLogger.INSTANCE.i(FileDownloadHelper.this.TAG, "Download start");
            }

            public void onRetry(DownloadInfo entity, BaseException e) {
                super.onRetry(entity, e);
                FLogger.INSTANCE.i(FileDownloadHelper.this.TAG, "Download retry: " + (entity != null ? Integer.valueOf(entity.getRetryCount()) : null) + ", error=" + (e != null ? e.getMessage() : null));
            }

            public void onCanceled(DownloadInfo entity) {
                super.onCanceled(entity);
                FLogger.INSTANCE.i(FileDownloadHelper.this.TAG, "Download canceled: " + file.getName());
            }
        };
        DownloadTask url = Downloader.with(context).taskKey(UUID.randomUUID().toString()).retryCount(3).autoSetHashCodeForSameTask(true).url(str);
        String parent = file.getParent();
        if (parent == null) {
            parent = context.getCacheDir().getAbsolutePath();
        }
        DownloadTask subThreadListener = url.savePath(parent).name(file.getName()).subThreadListener(iDownloadListener);
        intRef.element = subThreadListener.getDownloadId();
        this.downloadContinuationMap.put(Boxing.boxInt(intRef.element), cancellableContinuation);
        cancellableContinuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.bytedance.trae.conversation.products.FileDownloadHelper$saveFile$2$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                FileDownloadHelper.this.downloadContinuationMap.remove(Integer.valueOf(intRef.element));
                FLogger.INSTANCE.i(FileDownloadHelper.this.TAG, "Download cancel, downloadId=" + intRef.element + ", file=" + file.getName());
                Downloader.getInstance(context).cancel(intRef.element);
            }
        });
        subThreadListener.asyncDownload((IDownloadStartCallback) null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
