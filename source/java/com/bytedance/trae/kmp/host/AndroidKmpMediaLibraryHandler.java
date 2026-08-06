package com.bytedance.trae.kmp.host;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.trae.kmp.host.KmpMediaLibraryPermissionFragment;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;

/* compiled from: AndroidKmpMediaLibraryHandler.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u000fJ \u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J&\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;", "Lcom/bytedance/trae/kmp/host/KmpMediaLibraryHandler;", "context", "Landroid/content/Context;", "activityProvider", "Lkotlin/Function0;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "saveLocalFile", "Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;", "localUri", "", "displayName", "mimeType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveWithMediaStore", EventConstants.PARAM_SOURCE, "Ljava/io/File;", "saveWithFileApi", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureLegacyStoragePermission", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scan", "file", "(Ljava/io/File;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveLocalFile", "uniqueFile", "directory", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AndroidKmpMediaLibraryHandler implements KmpMediaLibraryHandler {
    public static final int $stable = 8;
    private final Function0<FragmentActivity> activityProvider;
    private final Context context;

    public AndroidKmpMediaLibraryHandler(Context context, Function0<? extends FragmentActivity> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "activityProvider");
        this.context = context;
        this.activityProvider = function0;
    }

    @Override // com.bytedance.trae.kmp.host.KmpMediaLibraryHandler
    public Object saveLocalFile(String str, String str2, String str3, Continuation<? super KmpMediaLibrarySaveResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AndroidKmpMediaLibraryHandler$saveLocalFile$2(this, str, str2, str3, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KmpMediaLibrarySaveResult saveWithMediaStore(File source, String displayName, String mimeType) {
        Uri uri;
        String str;
        if (StringsKt.startsWith$default(mimeType, "video/", false, 2, (Object) null)) {
            uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else {
            if (!StringsKt.startsWith$default(mimeType, "image/", false, 2, (Object) null)) {
                throw new IllegalStateException(("Unsupported media type: " + mimeType).toString());
            }
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }
        if (StringsKt.startsWith$default(mimeType, "video/", false, 2, (Object) null)) {
            str = Environment.DIRECTORY_MOVIES + "/TRAE";
        } else {
            str = Environment.DIRECTORY_PICTURES + "/TRAE";
        }
        ContentResolver contentResolver = this.context.getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", displayName);
        contentValues.put("mime_type", mimeType);
        contentValues.put("relative_path", str);
        contentValues.put("is_pending", (Integer) 1);
        Uri insert = contentResolver.insert(uri, contentValues);
        if (insert == null) {
            throw new IllegalStateException("Failed to create media library entry".toString());
        }
        try {
            OutputStream openOutputStream = contentResolver.openOutputStream(insert);
            if (openOutputStream == null) {
                throw new IllegalStateException("Failed to open media library entry".toString());
            }
            BufferedInputStream bufferedInputStream = openOutputStream;
            try {
                OutputStream outputStream = bufferedInputStream;
                InputStream fileInputStream = new FileInputStream(source);
                bufferedInputStream = fileInputStream instanceof BufferedInputStream ? (BufferedInputStream) fileInputStream : new BufferedInputStream(fileInputStream, 8192);
                try {
                    ByteStreamsKt.copyTo$default(bufferedInputStream, outputStream, 0, 2, (Object) null);
                    CloseableKt.closeFinally(bufferedInputStream, (Throwable) null);
                    CloseableKt.closeFinally(bufferedInputStream, (Throwable) null);
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("is_pending", (Integer) 0);
                    Unit unit = Unit.INSTANCE;
                    if (!(contentResolver.update(insert, contentValues2, null, null) > 0)) {
                        throw new IllegalStateException("Failed to publish media library entry".toString());
                    }
                    return new KmpMediaLibrarySaveResult(true, null, 2, null);
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            contentResolver.delete(insert, null, null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object saveWithFileApi(File file, String str, String str2, Continuation<? super KmpMediaLibrarySaveResult> continuation) {
        AndroidKmpMediaLibraryHandler$saveWithFileApi$1 androidKmpMediaLibraryHandler$saveWithFileApi$1;
        int i;
        boolean z;
        String str3;
        String str4;
        File file2;
        AndroidKmpMediaLibraryHandler androidKmpMediaLibraryHandler;
        File externalStoragePublicDirectory;
        File file3;
        if (continuation instanceof AndroidKmpMediaLibraryHandler$saveWithFileApi$1) {
            androidKmpMediaLibraryHandler$saveWithFileApi$1 = (AndroidKmpMediaLibraryHandler$saveWithFileApi$1) continuation;
            if ((androidKmpMediaLibraryHandler$saveWithFileApi$1.label & Integer.MIN_VALUE) != 0) {
                androidKmpMediaLibraryHandler$saveWithFileApi$1.label -= Integer.MIN_VALUE;
                Object obj = androidKmpMediaLibraryHandler$saveWithFileApi$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidKmpMediaLibraryHandler$saveWithFileApi$1.label;
                z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    androidKmpMediaLibraryHandler$saveWithFileApi$1.L$0 = this;
                    androidKmpMediaLibraryHandler$saveWithFileApi$1.L$1 = file;
                    str3 = str;
                    androidKmpMediaLibraryHandler$saveWithFileApi$1.L$2 = str3;
                    str4 = str2;
                    androidKmpMediaLibraryHandler$saveWithFileApi$1.L$3 = str4;
                    androidKmpMediaLibraryHandler$saveWithFileApi$1.label = 1;
                    if (ensureLegacyStoragePermission(androidKmpMediaLibraryHandler$saveWithFileApi$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    file2 = file;
                    androidKmpMediaLibraryHandler = this;
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    String str5 = (String) androidKmpMediaLibraryHandler$saveWithFileApi$1.L$3;
                    String str6 = (String) androidKmpMediaLibraryHandler$saveWithFileApi$1.L$2;
                    File file4 = (File) androidKmpMediaLibraryHandler$saveWithFileApi$1.L$1;
                    AndroidKmpMediaLibraryHandler androidKmpMediaLibraryHandler2 = (AndroidKmpMediaLibraryHandler) androidKmpMediaLibraryHandler$saveWithFileApi$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    androidKmpMediaLibraryHandler = androidKmpMediaLibraryHandler2;
                    file2 = file4;
                    str4 = str5;
                    str3 = str6;
                }
                if (!StringsKt.startsWith$default(str4, "video/", false, 2, (Object) null)) {
                    externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
                } else if (StringsKt.startsWith$default(str4, "image/", false, 2, (Object) null)) {
                    externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                } else {
                    throw new IllegalStateException(("Unsupported media type: " + str4).toString());
                }
                file3 = new File(externalStoragePublicDirectory, "TRAE");
                if (!file3.isDirectory() && !file3.mkdirs()) {
                    z = false;
                }
                if (z) {
                    throw new IllegalStateException("Failed to create media library directory".toString());
                }
                File uniqueFile = androidKmpMediaLibraryHandler.uniqueFile(file3, str3);
                FilesKt.copyTo$default(file2, uniqueFile, false, 0, 6, (Object) null);
                androidKmpMediaLibraryHandler$saveWithFileApi$1.L$0 = null;
                androidKmpMediaLibraryHandler$saveWithFileApi$1.L$1 = null;
                androidKmpMediaLibraryHandler$saveWithFileApi$1.L$2 = null;
                androidKmpMediaLibraryHandler$saveWithFileApi$1.L$3 = null;
                androidKmpMediaLibraryHandler$saveWithFileApi$1.label = 2;
                obj = androidKmpMediaLibraryHandler.scan(uniqueFile, str4, androidKmpMediaLibraryHandler$saveWithFileApi$1);
                return obj == coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        androidKmpMediaLibraryHandler$saveWithFileApi$1 = new AndroidKmpMediaLibraryHandler$saveWithFileApi$1(this, continuation);
        Object obj2 = androidKmpMediaLibraryHandler$saveWithFileApi$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidKmpMediaLibraryHandler$saveWithFileApi$1.label;
        z = true;
        if (i != 0) {
        }
        if (!StringsKt.startsWith$default(str4, "video/", false, 2, (Object) null)) {
        }
        file3 = new File(externalStoragePublicDirectory, "TRAE");
        if (!file3.isDirectory()) {
            z = false;
        }
        if (z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object ensureLegacyStoragePermission(Continuation<? super Unit> continuation) {
        AndroidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1 androidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1;
        Object obj;
        int i;
        if (continuation instanceof AndroidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1) {
            androidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1 = (AndroidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1) continuation;
            if ((androidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1.label & Integer.MIN_VALUE) != 0) {
                androidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1.label -= Integer.MIN_VALUE;
                obj = androidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (ContextCompat.checkSelfPermission(this.context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                        return Unit.INSTANCE;
                    }
                    Object invoke = this.activityProvider.invoke();
                    if (invoke == null) {
                        throw new IllegalStateException("Storage permission cannot be requested without an active activity".toString());
                    }
                    KmpMediaLibraryPermissionFragment.Companion companion = KmpMediaLibraryPermissionFragment.INSTANCE;
                    androidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1.label = 1;
                    obj = companion.request((FragmentActivity) invoke, androidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (((Boolean) obj).booleanValue()) {
                    throw new IllegalStateException("Storage permission is required".toString());
                }
                return Unit.INSTANCE;
            }
        }
        androidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1 = new AndroidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1(this, continuation);
        obj = androidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File resolveLocalFile(String localUri) {
        if (StringsKt.startsWith$default(localUri, "file:", false, 2, (Object) null)) {
            return new File(new URI(localUri));
        }
        return new File(Uri.decode(localUri));
    }

    private final File uniqueFile(File directory, String displayName) {
        File file = new File(directory, displayName);
        if (!file.exists()) {
            return file;
        }
        String extension = FilesKt.getExtension(file);
        int i = 1;
        if (!(!StringsKt.isBlank(extension))) {
            extension = null;
        }
        String str = extension != null ? LibrarianImpl.Constants.DOT + extension : null;
        if (str == null) {
            str = "";
        }
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String removeSuffix = StringsKt.removeSuffix(name, str);
        while (true) {
            File file2 = new File(directory, removeSuffix + " (" + i + ')' + str);
            if (!file2.exists()) {
                return file2;
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object scan(final File file, String str, Continuation<? super KmpMediaLibrarySaveResult> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        MediaScannerConnection.scanFile(this.context, new String[]{file.getAbsolutePath()}, new String[]{str}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.bytedance.trae.kmp.host.AndroidKmpMediaLibraryHandler$scan$2$1
            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public final void onScanCompleted(String str2, Uri uri) {
                KmpMediaLibrarySaveResult kmpMediaLibrarySaveResult;
                if (cancellableContinuation.isActive()) {
                    Continuation continuation2 = cancellableContinuation;
                    Result.Companion companion = Result.Companion;
                    if (uri != null) {
                        kmpMediaLibrarySaveResult = new KmpMediaLibrarySaveResult(true, null, 2, null);
                    } else {
                        file.delete();
                        kmpMediaLibrarySaveResult = new KmpMediaLibrarySaveResult(false, "Failed to publish media library file");
                    }
                    continuation2.resumeWith(Result.constructor-impl(kmpMediaLibrarySaveResult));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
