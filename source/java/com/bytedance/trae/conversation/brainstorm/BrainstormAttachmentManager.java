package com.bytedance.trae.conversation.brainstorm;

import android.app.Application;
import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.LoginUtils;
import com.bytedance.trae.conversation.fileupload.BizType;
import com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi;
import com.bytedance.trae.conversation.fileupload.FileUploadService;
import com.bytedance.trae.conversation.fileupload.UploadResult;
import com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi;
import com.bytedance.trae.conversation.imageupload.FileValidationResult;
import com.bytedance.trae.conversation.imageupload.ImageUploadErrorCode;
import com.bytedance.trae.conversation.imageupload.ImageUploadException;
import com.bytedance.trae.conversation.imageupload.ImageUploadResult;
import com.bytedance.trae.conversation.imageupload.ImageUploadSdkConfig;
import com.bytedance.trae.conversation.imageupload.ImageUploadService;
import com.bytedance.trae.conversation.imageupload.ImageValidation;
import com.bytedance.trae.conversation.imageupload.ResourceRepoManager;
import com.bytedance.trae.conversation.imageupload.UploaderConfig;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: BrainstormAttachmentManager.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J2\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00172\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eH\u0086@¢\u0006\u0002\u0010!J<\u0010\"\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eH\u0086@¢\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020 J\b\u0010%\u001a\u00020&H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b\f\u0010\r*\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006("}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;", "", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "imageUploadServiceDelegate", "Lkotlin/Lazy;", "Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;", "imageUploadService", "getImageUploadService$delegate", "(Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;)Ljava/lang/Object;", "getImageUploadService", "()Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;", "fileUploadService", "Lcom/bytedance/trae/conversation/fileupload/FileUploadService;", "getFileUploadService", "()Lcom/bytedance/trae/conversation/fileupload/FileUploadService;", "fileUploadService$delegate", "Lkotlin/Lazy;", "uriToFile", "Ljava/io/File;", "uri", "Landroid/net/Uri;", "mimeType", "", "uploadImage", MessagePart.TYPE_FILE, "sourceUri", "onProgress", "Lkotlin/Function1;", "", "", "(Ljava/io/File;Landroid/net/Uri;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadFile", "(Ljava/io/File;Landroid/net/Uri;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "isEnterpriseLogin", "", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormAttachmentManager {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "BrainstormAttachmentManager";
    private final Application application;

    /* renamed from: fileUploadService$delegate, reason: from kotlin metadata */
    private final Lazy fileUploadService;
    private final Lazy<ImageUploadService> imageUploadServiceDelegate;

    public BrainstormAttachmentManager(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this.imageUploadServiceDelegate = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormAttachmentManager$$ExternalSyntheticLambda1
            public final Object invoke() {
                ImageUploadService imageUploadServiceDelegate$lambda$1;
                imageUploadServiceDelegate$lambda$1 = BrainstormAttachmentManager.imageUploadServiceDelegate$lambda$1();
                return imageUploadServiceDelegate$lambda$1;
            }
        });
        this.fileUploadService = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormAttachmentManager$$ExternalSyntheticLambda2
            public final Object invoke() {
                FileUploadService fileUploadService_delegate$lambda$3;
                fileUploadService_delegate$lambda$3 = BrainstormAttachmentManager.fileUploadService_delegate$lambda$3();
                return fileUploadService_delegate$lambda$3;
            }
        });
    }

    /* compiled from: BrainstormAttachmentManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$Companion;", "", "<init>", "()V", "TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageUploadService imageUploadServiceDelegate$lambda$1() {
        return new ImageUploadService(new ImageUploadSdkConfig(new UploaderConfig(AppHost.INSTANCE.getAppId(), HostResolver.INSTANCE.getHost(HostType.IMAGEX), null, null, 12, null), new ConversationCopilotImageUploadApi(new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormAttachmentManager$$ExternalSyntheticLambda0
            public final Object invoke() {
                String imageUploadServiceDelegate$lambda$1$lambda$0;
                imageUploadServiceDelegate$lambda$1$lambda$0 = BrainstormAttachmentManager.imageUploadServiceDelegate$lambda$1$lambda$0();
                return imageUploadServiceDelegate$lambda$1$lambda$0;
            }
        }, null, null, 6, null), new BrainstormAttachmentManager$imageUploadServiceDelegate$1$2(null), null, null, null, false, null, 248, null), null, null, null, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String imageUploadServiceDelegate$lambda$1$lambda$0() {
        return HostResolver.INSTANCE.getBaseUrl(HostType.AI);
    }

    private final ImageUploadService getImageUploadService() {
        return (ImageUploadService) this.imageUploadServiceDelegate.getValue();
    }

    private final FileUploadService getFileUploadService() {
        return (FileUploadService) this.fileUploadService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileUploadService fileUploadService_delegate$lambda$3() {
        return new FileUploadService(new ConversationCopilotResourceUploadApi(new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormAttachmentManager$$ExternalSyntheticLambda4
            public final Object invoke() {
                String fileUploadService_delegate$lambda$3$lambda$2;
                fileUploadService_delegate$lambda$3$lambda$2 = BrainstormAttachmentManager.fileUploadService_delegate$lambda$3$lambda$2();
                return fileUploadService_delegate$lambda$3$lambda$2;
            }
        }, null, null, 6, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String fileUploadService_delegate$lambda$3$lambda$2() {
        return HostResolver.INSTANCE.getBaseUrl(HostType.AI);
    }

    public final File uriToFile(Uri uri, String mimeType) {
        File file;
        ContentResolver contentResolver;
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            contentResolver = this.application.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
            String extensionFromMimeType = mimeType != null ? MimeTypeMap.getSingleton().getExtensionFromMimeType(mimeType) : null;
            StringBuilder append = new StringBuilder("brainstorm_attach_").append(System.currentTimeMillis()).append('.');
            if (extensionFromMimeType == null) {
                extensionFromMimeType = "bin";
            }
            file = new File(this.application.getCacheDir(), append.append(extensionFromMimeType).toString());
        } catch (Throwable unused) {
            file = null;
        }
        try {
            InputStream openInputStream = contentResolver.openInputStream(uri);
            if (openInputStream == null) {
                BrainstormAttachmentManager brainstormAttachmentManager = this;
                file.delete();
                return null;
            }
            FileOutputStream fileOutputStream = openInputStream;
            try {
                InputStream inputStream = fileOutputStream;
                fileOutputStream = new FileOutputStream(file);
                try {
                    ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, (Object) null);
                    CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                    CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                    return file;
                } finally {
                }
            } finally {
            }
        } catch (Throwable unused2) {
            if (file == null) {
                return null;
            }
            file.delete();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object uploadImage(File file, Uri uri, final Function1<? super Integer, Unit> function1, Continuation<? super String> continuation) {
        BrainstormAttachmentManager$uploadImage$1 brainstormAttachmentManager$uploadImage$1;
        int i;
        String str;
        AccountInfo accountInfo;
        UploadResult uploadResult;
        String error;
        Uri uri2 = uri;
        if (continuation instanceof BrainstormAttachmentManager$uploadImage$1) {
            brainstormAttachmentManager$uploadImage$1 = (BrainstormAttachmentManager$uploadImage$1) continuation;
            if ((brainstormAttachmentManager$uploadImage$1.label & Integer.MIN_VALUE) != 0) {
                brainstormAttachmentManager$uploadImage$1.label -= Integer.MIN_VALUE;
                BrainstormAttachmentManager$uploadImage$1 brainstormAttachmentManager$uploadImage$12 = brainstormAttachmentManager$uploadImage$1;
                Object obj = brainstormAttachmentManager$uploadImage$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = brainstormAttachmentManager$uploadImage$12.label;
                if (i == 0) {
                    if (i == 1) {
                        uri2 = (Uri) brainstormAttachmentManager$uploadImage$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        ImageUploadResult imageUploadResult = (ImageUploadResult) obj;
                        ResourceRepoManager resourceRepoManager = ResourceRepoManager.INSTANCE;
                        String tosUri = imageUploadResult.getTosUri();
                        String uri3 = uri2.toString();
                        Intrinsics.checkNotNullExpressionValue(uri3, "toString(...)");
                        resourceRepoManager.put(tosUri, uri3);
                        return imageUploadResult.getTosUri();
                    }
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    uri2 = (Uri) brainstormAttachmentManager$uploadImage$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    uploadResult = (UploadResult) obj;
                    if (uploadResult.getSuccess() || StringsKt.isBlank(uploadResult.getOid())) {
                        ImageUploadErrorCode imageUploadErrorCode = ImageUploadErrorCode.UPLOAD_FAILED;
                        error = uploadResult.getError();
                        if (error == null) {
                            error = "Upload failed";
                        }
                        throw new ImageUploadException(imageUploadErrorCode, error, null, 4, null);
                    }
                    ResourceRepoManager resourceRepoManager2 = ResourceRepoManager.INSTANCE;
                    String oid = uploadResult.getOid();
                    String uri4 = uri2.toString();
                    Intrinsics.checkNotNullExpressionValue(uri4, "toString(...)");
                    resourceRepoManager2.put(oid, uri4);
                    return uploadResult.getOid();
                }
                ResultKt.throwOnFailure(obj);
                boolean isEnterpriseLogin = isEnterpriseLogin();
                FLogger.INSTANCE.i(TAG, "uploadImage: isEnterpriseLogin=" + isEnterpriseLogin + ", sourceUri=" + uri2 + ", fileName=" + file.getName() + ", fileSize=" + file.length());
                Log.i(TAG, "uploadImage: isEnterpriseLogin=" + isEnterpriseLogin + ", sourceUri=" + uri2 + ", fileName=" + file.getName() + ", fileSize=" + file.length());
                if (!isEnterpriseLogin) {
                    FLogger.INSTANCE.i(TAG, "uploadImage branch=ImageX");
                    Log.i(TAG, "uploadImage branch=ImageX");
                    ImageUploadService imageUploadService = getImageUploadService();
                    brainstormAttachmentManager$uploadImage$12.L$0 = uri2;
                    brainstormAttachmentManager$uploadImage$12.label = 1;
                    obj = ImageUploadService.uploadImage$default(imageUploadService, file, function1, 0L, brainstormAttachmentManager$uploadImage$12, 4, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ImageUploadResult imageUploadResult2 = (ImageUploadResult) obj;
                    ResourceRepoManager resourceRepoManager3 = ResourceRepoManager.INSTANCE;
                    String tosUri2 = imageUploadResult2.getTosUri();
                    String uri32 = uri2.toString();
                    Intrinsics.checkNotNullExpressionValue(uri32, "toString(...)");
                    resourceRepoManager3.put(tosUri2, uri32);
                    return imageUploadResult2.getTosUri();
                }
                FLogger.INSTANCE.i(TAG, "uploadImage branch=ToBImagePresigned");
                Log.i(TAG, "uploadImage branch=ToBImagePresigned");
                FileValidationResult fileValidationResult = (FileValidationResult) ImageValidation.INSTANCE.validateFile(file).component1();
                if (!fileValidationResult.getValid()) {
                    ImageUploadErrorCode errorCode = fileValidationResult.getErrorCode();
                    if (errorCode == null) {
                        errorCode = ImageUploadErrorCode.UNKNOWN;
                    }
                    ImageUploadErrorCode imageUploadErrorCode2 = errorCode;
                    String errorMessage = fileValidationResult.getErrorMessage();
                    if (errorMessage == null) {
                        errorMessage = "Invalid file";
                    }
                    throw new ImageUploadException(imageUploadErrorCode2, errorMessage, null, 4, null);
                }
                ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
                if (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null || (str = accountInfo.getUserId()) == null) {
                    str = "";
                }
                String str2 = str;
                String str3 = UUID.randomUUID() + ".trae";
                FileUploadService fileUploadService = getFileUploadService();
                BizType bizType = BizType.Image;
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(FilesKt.getExtension(file));
                FileUploadService.UploadOptions uploadOptions = new FileUploadService.UploadOptions(false, false, new Function3() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormAttachmentManager$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        Unit uploadImage$lambda$8;
                        uploadImage$lambda$8 = BrainstormAttachmentManager.uploadImage$lambda$8(function1, ((Integer) obj2).intValue(), ((Long) obj3).longValue(), ((Long) obj4).longValue());
                        return uploadImage$lambda$8;
                    }
                }, null, 11, null);
                brainstormAttachmentManager$uploadImage$12.L$0 = uri2;
                brainstormAttachmentManager$uploadImage$12.label = 2;
                obj = fileUploadService.uploadSingleFile(file, str3, bizType, mimeTypeFromExtension, str2, uploadOptions, brainstormAttachmentManager$uploadImage$12);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                uploadResult = (UploadResult) obj;
                if (uploadResult.getSuccess()) {
                }
                ImageUploadErrorCode imageUploadErrorCode3 = ImageUploadErrorCode.UPLOAD_FAILED;
                error = uploadResult.getError();
                if (error == null) {
                }
                throw new ImageUploadException(imageUploadErrorCode3, error, null, 4, null);
            }
        }
        brainstormAttachmentManager$uploadImage$1 = new BrainstormAttachmentManager$uploadImage$1(this, continuation);
        BrainstormAttachmentManager$uploadImage$1 brainstormAttachmentManager$uploadImage$122 = brainstormAttachmentManager$uploadImage$1;
        Object obj2 = brainstormAttachmentManager$uploadImage$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = brainstormAttachmentManager$uploadImage$122.label;
        if (i == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit uploadImage$lambda$8(Function1 function1, int i, long j, long j2) {
        function1.invoke(Integer.valueOf(RangesKt.coerceIn(i, 0, 99)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object uploadFile(File file, Uri uri, String str, final Function1<? super Integer, Unit> function1, Continuation<? super String> continuation) {
        BrainstormAttachmentManager$uploadFile$1 brainstormAttachmentManager$uploadFile$1;
        int i;
        Uri uri2;
        Object uploadSingleFile;
        AccountInfo accountInfo;
        UploadResult uploadResult;
        if (continuation instanceof BrainstormAttachmentManager$uploadFile$1) {
            brainstormAttachmentManager$uploadFile$1 = (BrainstormAttachmentManager$uploadFile$1) continuation;
            if ((brainstormAttachmentManager$uploadFile$1.label & Integer.MIN_VALUE) != 0) {
                brainstormAttachmentManager$uploadFile$1.label -= Integer.MIN_VALUE;
                BrainstormAttachmentManager$uploadFile$1 brainstormAttachmentManager$uploadFile$12 = brainstormAttachmentManager$uploadFile$1;
                Object obj = brainstormAttachmentManager$uploadFile$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = brainstormAttachmentManager$uploadFile$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String str2 = UUID.randomUUID() + ".trae";
                    FileUploadService fileUploadService = getFileUploadService();
                    ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
                    String userId = (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getUserId();
                    FileUploadService.UploadOptions uploadOptions = new FileUploadService.UploadOptions(true, true, new Function3() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormAttachmentManager$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            Unit uploadFile$lambda$9;
                            uploadFile$lambda$9 = BrainstormAttachmentManager.uploadFile$lambda$9(function1, ((Integer) obj2).intValue(), ((Long) obj3).longValue(), ((Long) obj4).longValue());
                            return uploadFile$lambda$9;
                        }
                    }, null, 8, null);
                    uri2 = uri;
                    brainstormAttachmentManager$uploadFile$12.L$0 = uri2;
                    brainstormAttachmentManager$uploadFile$12.label = 1;
                    uploadSingleFile = fileUploadService.uploadSingleFile(file, str2, (r22 & 4) != 0 ? BizType.RemoteResource : null, (r22 & 8) != 0 ? null : str, (r22 & 16) != 0 ? null : userId, (r22 & 32) != 0 ? new FileUploadService.UploadOptions(false, false, null, null, 15, null) : uploadOptions, brainstormAttachmentManager$uploadFile$12);
                    if (uploadSingleFile == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Uri uri3 = (Uri) brainstormAttachmentManager$uploadFile$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    uploadSingleFile = obj;
                    uri2 = uri3;
                }
                uploadResult = (UploadResult) uploadSingleFile;
                if (uploadResult.getSuccess() || StringsKt.isBlank(uploadResult.getOid())) {
                    return null;
                }
                ResourceRepoManager resourceRepoManager = ResourceRepoManager.INSTANCE;
                String oid = uploadResult.getOid();
                String uri4 = uri2.toString();
                Intrinsics.checkNotNullExpressionValue(uri4, "toString(...)");
                resourceRepoManager.put(oid, uri4);
                return uploadResult.getOid();
            }
        }
        brainstormAttachmentManager$uploadFile$1 = new BrainstormAttachmentManager$uploadFile$1(this, continuation);
        BrainstormAttachmentManager$uploadFile$1 brainstormAttachmentManager$uploadFile$122 = brainstormAttachmentManager$uploadFile$1;
        Object obj2 = brainstormAttachmentManager$uploadFile$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = brainstormAttachmentManager$uploadFile$122.label;
        if (i != 0) {
        }
        uploadResult = (UploadResult) uploadSingleFile;
        if (uploadResult.getSuccess()) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit uploadFile$lambda$9(Function1 function1, int i, long j, long j2) {
        function1.invoke(Integer.valueOf(RangesKt.coerceIn(i, 0, 99)));
        return Unit.INSTANCE;
    }

    public final void release() {
        if (this.imageUploadServiceDelegate.isInitialized()) {
            try {
                Result.Companion companion = Result.Companion;
                BrainstormAttachmentManager brainstormAttachmentManager = this;
                getImageUploadService().close();
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        }
    }

    private final boolean isEnterpriseLogin() {
        return LoginUtils.INSTANCE.isEnterpriseLogin();
    }
}
