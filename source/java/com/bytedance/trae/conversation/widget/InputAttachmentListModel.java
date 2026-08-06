package com.bytedance.trae.conversation.widget;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
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
import com.bytedance.trae.conversation.imageupload.UploaderConfig;
import com.bytedance.trae.conversation.mediachoose.model.MediaItem;
import com.bytedance.trae.conversation.settings.WorkAttachmentSettings;
import com.bytedance.trae.conversation.settings.WorkAttachmentSettingsService;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: InputAttachmentListModel.kt */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 o2\u00020\u0001:\u0001oB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u00020@J\u0006\u0010B\u001a\u00020@J\u0006\u0010C\u001a\u00020@J\u0014\u0010D\u001a\u00020\u001f2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0011J\u0006\u0010F\u001a\u00020GJ\u0006\u0010H\u001a\u00020@J\u0006\u0010I\u001a\u00020@J\u0006\u0010J\u001a\u00020@J\u0006\u0010K\u001a\u00020@J\u0014\u0010L\u001a\u00020\u001f2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0011J\u0016\u0010N\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020*2\u0006\u0010P\u001a\u00020QJ\u0016\u0010R\u001a\u00020\u001f2\u0006\u0010S\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020UJ\u000e\u0010V\u001a\u00020\u001f2\u0006\u0010S\u001a\u00020\u000eJ\u0006\u0010W\u001a\u00020\u001fJ\u0014\u0010X\u001a\u00020\u001f2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011J\b\u0010Y\u001a\u00020\u001fH\u0014J4\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010\u00072\u0012\u0010_\u001a\u000e\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020\u001f0`H\u0082@¢\u0006\u0002\u0010bJ\b\u0010c\u001a\u00020GH\u0002J$\u0010d\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020*2\u0012\u0010f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0`H\u0002JU\u0010g\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020*2=\u0010h\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020\u001f0`¢\u0006\f\bj\u0012\b\bk\u0012\u0004\b\b(_\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0l\u0012\u0006\u0012\u0004\u0018\u00010\u000b0iH\u0082@¢\u0006\u0002\u0010mJ\u001e\u0010n\u001a\u0004\u0018\u00010]2\u0006\u0010O\u001a\u00020*2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0007H\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00118F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00118F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00118F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0018R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u0013¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0013¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0015R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b2\u00103*\u0004\b0\u00101R\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b6\u00107R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u00109\u001a\u0004\b<\u0010=¨\u0006p"}, d2 = {"Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "attachmentLock", "", "_attachmentList", "", "Lcom/bytedance/trae/conversation/widget/AttachmentItem;", "_attachments", "Landroidx/lifecycle/MutableLiveData;", "", "attachments", "Landroidx/lifecycle/LiveData;", "getAttachments", "()Landroidx/lifecycle/LiveData;", "uploadedImages", "getUploadedImages", "()Ljava/util/List;", "uploadedFiles", "getUploadedFiles", "selectedMediaItems", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;", "getSelectedMediaItems", "_fileTooLarge", "", "fileTooLarge", "getFileTooLarge", "_totalSizeTooLarge", "totalSizeTooLarge", "getTotalSizeTooLarge", "_uploadError", "uploadError", "getUploadError", "fakeProgressJobs", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/net/Uri;", "Lkotlinx/coroutines/Job;", "imageUploadServiceDelegate", "Lkotlin/Lazy;", "Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;", "imageUploadService", "getImageUploadService$delegate", "(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;)Ljava/lang/Object;", "getImageUploadService", "()Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;", "fileUploadService", "Lcom/bytedance/trae/conversation/fileupload/FileUploadService;", "getFileUploadService", "()Lcom/bytedance/trae/conversation/fileupload/FileUploadService;", "fileUploadService$delegate", "Lkotlin/Lazy;", "workAttachmentSettings", "Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;", "getWorkAttachmentSettings", "()Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;", "workAttachmentSettings$delegate", "getWorkAttachmentTotalCount", "", "getWorkAttachmentRemainTotalSize", "getWorkAttachmentTotalSize", "getSingleSize", "addImages", "items", "isCanAddAttachment", "", "getRemainCount", "getWorkSingleImageSize", "getCodeImageSize", "getCodeImageMaxCount", "addImageAttachments", "list", "addAttachment", "uri", "context", "Landroid/content/Context;", "retryUpload", "item", "mode", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "removeAttachment", "clearAttachments", "setAttachments", "onCleared", "uploadImageFile", "Lcom/bytedance/trae/conversation/fileupload/UploadResult;", MessagePart.TYPE_FILE, "Ljava/io/File;", "mimeType", "onProgress", "Lkotlin/Function1;", "", "(Ljava/io/File;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isEnterpriseLogin", "updateItem", "itemUri", "transform", "uploadWithFakeProgress", "uploadBlock", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/coroutines/Continuation;", "(Landroid/net/Uri;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uriToFile", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InputAttachmentListModel extends AndroidViewModel {
    private static final int FAKE_PROGRESS_INCREMENT = 1;
    private static final long FAKE_PROGRESS_INTERVAL_MS = 200;
    private static final int FAKE_PROGRESS_MAX = 30;
    private final String TAG;
    private final List<AttachmentItem> _attachmentList;
    private final MutableLiveData<List<AttachmentItem>> _attachments;
    private final MutableLiveData<Unit> _fileTooLarge;
    private final MutableLiveData<Unit> _totalSizeTooLarge;
    private final MutableLiveData<String> _uploadError;
    private final Object attachmentLock;
    private final LiveData<List<AttachmentItem>> attachments;
    private final ConcurrentHashMap<Uri, Job> fakeProgressJobs;
    private final LiveData<Unit> fileTooLarge;

    /* renamed from: fileUploadService$delegate, reason: from kotlin metadata */
    private final Lazy fileUploadService;
    private final Lazy<ImageUploadService> imageUploadServiceDelegate;
    private final LiveData<Unit> totalSizeTooLarge;
    private final LiveData<String> uploadError;

    /* renamed from: workAttachmentSettings$delegate, reason: from kotlin metadata */
    private final Lazy workAttachmentSettings;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAttachmentListModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.TAG = "InputAttachmentListModel";
        this.attachmentLock = new Object();
        this._attachmentList = new ArrayList();
        LiveData<List<AttachmentItem>> mutableLiveData = new MutableLiveData<>(CollectionsKt.emptyList());
        this._attachments = mutableLiveData;
        this.attachments = mutableLiveData;
        LiveData<Unit> mutableLiveData2 = new MutableLiveData<>();
        this._fileTooLarge = mutableLiveData2;
        this.fileTooLarge = mutableLiveData2;
        LiveData<Unit> mutableLiveData3 = new MutableLiveData<>();
        this._totalSizeTooLarge = mutableLiveData3;
        this.totalSizeTooLarge = mutableLiveData3;
        LiveData<String> mutableLiveData4 = new MutableLiveData<>();
        this._uploadError = mutableLiveData4;
        this.uploadError = mutableLiveData4;
        this.fakeProgressJobs = new ConcurrentHashMap<>();
        this.imageUploadServiceDelegate = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$$ExternalSyntheticLambda4
            public final Object invoke() {
                ImageUploadService imageUploadServiceDelegate$lambda$8;
                imageUploadServiceDelegate$lambda$8 = InputAttachmentListModel.imageUploadServiceDelegate$lambda$8();
                return imageUploadServiceDelegate$lambda$8;
            }
        });
        this.fileUploadService = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$$ExternalSyntheticLambda5
            public final Object invoke() {
                FileUploadService fileUploadService_delegate$lambda$10;
                fileUploadService_delegate$lambda$10 = InputAttachmentListModel.fileUploadService_delegate$lambda$10();
                return fileUploadService_delegate$lambda$10;
            }
        });
        this.workAttachmentSettings = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$$ExternalSyntheticLambda6
            public final Object invoke() {
                WorkAttachmentSettings workAttachmentSettings_delegate$lambda$11;
                workAttachmentSettings_delegate$lambda$11 = InputAttachmentListModel.workAttachmentSettings_delegate$lambda$11();
                return workAttachmentSettings_delegate$lambda$11;
            }
        });
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final LiveData<List<AttachmentItem>> getAttachments() {
        return this.attachments;
    }

    public final List<AttachmentItem> getUploadedImages() {
        ArrayList arrayList;
        synchronized (this.attachmentLock) {
            List<AttachmentItem> list = this._attachmentList;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                AttachmentItem attachmentItem = (AttachmentItem) obj;
                if (attachmentItem.isImage() && attachmentItem.getUploadStatus() == AttachmentUploadStatus.Success) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public final List<AttachmentItem> getUploadedFiles() {
        ArrayList arrayList;
        synchronized (this.attachmentLock) {
            List<AttachmentItem> list = this._attachmentList;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (((AttachmentItem) obj).getUploadStatus() == AttachmentUploadStatus.Success) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public final List<MediaItem> getSelectedMediaItems() {
        ArrayList arrayList;
        MediaItem mediaItem;
        synchronized (this.attachmentLock) {
            List<AttachmentItem> list = this._attachmentList;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (((AttachmentItem) obj).isImage()) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                mediaItem = InputAttachmentListModelKt.toMediaItem((AttachmentItem) it.next());
                arrayList4.add(mediaItem);
            }
            arrayList = arrayList4;
        }
        return arrayList;
    }

    public final LiveData<Unit> getFileTooLarge() {
        return this.fileTooLarge;
    }

    public final LiveData<Unit> getTotalSizeTooLarge() {
        return this.totalSizeTooLarge;
    }

    public final LiveData<String> getUploadError() {
        return this.uploadError;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageUploadService imageUploadServiceDelegate$lambda$8() {
        return new ImageUploadService(new ImageUploadSdkConfig(new UploaderConfig(AppHost.INSTANCE.getAppId(), HostResolver.INSTANCE.getHost(HostType.IMAGEX), null, null, 12, null), new ConversationCopilotImageUploadApi(new Function0() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$$ExternalSyntheticLambda7
            public final Object invoke() {
                String imageUploadServiceDelegate$lambda$8$lambda$7;
                imageUploadServiceDelegate$lambda$8$lambda$7 = InputAttachmentListModel.imageUploadServiceDelegate$lambda$8$lambda$7();
                return imageUploadServiceDelegate$lambda$8$lambda$7;
            }
        }, null, null, 6, null), new InputAttachmentListModel$imageUploadServiceDelegate$1$2(null), null, null, null, false, null, 248, null), null, null, null, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String imageUploadServiceDelegate$lambda$8$lambda$7() {
        return HostResolver.INSTANCE.getBaseUrl(HostType.AI);
    }

    private final ImageUploadService getImageUploadService() {
        return (ImageUploadService) this.imageUploadServiceDelegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FileUploadService getFileUploadService() {
        return (FileUploadService) this.fileUploadService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileUploadService fileUploadService_delegate$lambda$10() {
        return new FileUploadService(new ConversationCopilotResourceUploadApi(new Function0() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$$ExternalSyntheticLambda2
            public final Object invoke() {
                String fileUploadService_delegate$lambda$10$lambda$9;
                fileUploadService_delegate$lambda$10$lambda$9 = InputAttachmentListModel.fileUploadService_delegate$lambda$10$lambda$9();
                return fileUploadService_delegate$lambda$10$lambda$9;
            }
        }, null, null, 6, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String fileUploadService_delegate$lambda$10$lambda$9() {
        return HostResolver.INSTANCE.getBaseUrl(HostType.AI);
    }

    private final WorkAttachmentSettings getWorkAttachmentSettings() {
        return (WorkAttachmentSettings) this.workAttachmentSettings.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WorkAttachmentSettings workAttachmentSettings_delegate$lambda$11() {
        return WorkAttachmentSettingsService.INSTANCE.getWorkAttachmentSettings();
    }

    public final long getWorkAttachmentTotalCount() {
        long totalCount = getWorkAttachmentSettings().getTotalCount();
        if (totalCount > 0) {
            return totalCount;
        }
        return 20L;
    }

    public final long getWorkAttachmentRemainTotalSize() {
        long totalSize = getWorkAttachmentSettings().getTotalSize();
        long j = 0;
        if (totalSize <= 0) {
            totalSize = 1073741824;
        }
        synchronized (this.attachmentLock) {
            Iterator<T> it = this._attachmentList.iterator();
            while (it.hasNext()) {
                j += ((AttachmentItem) it.next()).getSizeBytes();
            }
        }
        return totalSize - j;
    }

    public final long getWorkAttachmentTotalSize() {
        long totalSize = getWorkAttachmentSettings().getTotalSize();
        if (totalSize > 0) {
            return totalSize;
        }
        return 1073741824L;
    }

    public final long getSingleSize() {
        long workSingleAttachmentSize = getWorkAttachmentSettings().getWorkSingleAttachmentSize();
        if (workSingleAttachmentSize > 0) {
            return workSingleAttachmentSize;
        }
        return 209715200L;
    }

    public final void addImages(List<MediaItem> items) {
        AttachmentItem attachmentItem;
        Intrinsics.checkNotNullParameter(items, "items");
        FLogger.INSTANCE.i(this.TAG, "addImages: count=" + items.size() + ", isEnterpriseLogin=" + isEnterpriseLogin() + ", uploadPath=Image");
        Log.i(this.TAG, "addImages: count=" + items.size() + ", isEnterpriseLogin=" + isEnterpriseLogin() + ", uploadPath=Image");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.attachmentLock) {
            List<AttachmentItem> list = this._attachmentList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((AttachmentItem) it.next()).getUri());
            }
            Set set = CollectionsKt.toSet(arrayList);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : items) {
                if (!set.contains(((MediaItem) obj).getUri())) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                attachmentItem = InputAttachmentListModelKt.toAttachmentItem((MediaItem) it2.next());
                arrayList4.add(attachmentItem);
            }
            objectRef.element = arrayList4;
            if (((List) objectRef.element).isEmpty()) {
                return;
            }
            this._attachmentList.addAll((Collection) objectRef.element);
            this._attachments.postValue(CollectionsKt.toList(this._attachmentList));
            Unit unit = Unit.INSTANCE;
            Iterator it3 = ((Iterable) objectRef.element).iterator();
            while (it3.hasNext()) {
                BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new InputAttachmentListModel$addImages$2$1((AttachmentItem) it3.next(), this, null), 2, (Object) null);
            }
        }
    }

    public final boolean isCanAddAttachment() {
        int size;
        synchronized (this.attachmentLock) {
            size = this._attachmentList.size();
        }
        FLogger.INSTANCE.d(this.TAG, "isCanAddAttachment:" + size + ' ' + getWorkAttachmentTotalCount());
        return ((long) size) < getWorkAttachmentTotalCount();
    }

    public final long getRemainCount() {
        int size;
        synchronized (this.attachmentLock) {
            size = this._attachmentList.size();
        }
        return getWorkAttachmentTotalCount() - size;
    }

    public final long getWorkSingleImageSize() {
        long workSingleImageSize = getWorkAttachmentSettings().getWorkSingleImageSize();
        if (workSingleImageSize > 0) {
            return workSingleImageSize;
        }
        return 104857600L;
    }

    public final long getCodeImageSize() {
        long codeSingleImageSize = getWorkAttachmentSettings().getCodeSingleImageSize();
        if (codeSingleImageSize > 0) {
            return codeSingleImageSize;
        }
        return 104857600L;
    }

    public final long getCodeImageMaxCount() {
        long codeTotalImageCount = getWorkAttachmentSettings().getCodeTotalImageCount();
        if (codeTotalImageCount > 0) {
            return codeTotalImageCount;
        }
        return 5L;
    }

    public final void addImageAttachments(List<MediaItem> list) {
        boolean z;
        Intrinsics.checkNotNullParameter(list, "list");
        FLogger.INSTANCE.i(this.TAG, "addImageAttachments: count=" + list.size() + ", isEnterpriseLogin=" + isEnterpriseLogin() + ", uploadPath=RemoteResource");
        Log.i(this.TAG, "addImageAttachments: count=" + list.size() + ", isEnterpriseLogin=" + isEnterpriseLogin() + ", uploadPath=RemoteResource");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.attachmentLock) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (true) {
                boolean z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                MediaItem mediaItem = (MediaItem) next;
                List<AttachmentItem> list2 = this._attachmentList;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator<T> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (Intrinsics.areEqual(((AttachmentItem) it2.next()).getUri(), mediaItem.getUri())) {
                            break;
                        }
                    }
                }
                z2 = true;
                if (z2) {
                    arrayList.add(next);
                }
            }
            ArrayList<MediaItem> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (MediaItem mediaItem2 : arrayList2) {
                long id = mediaItem2.getId();
                long hashCode = mediaItem2.getUri().toString().hashCode();
                String fileName = mediaItem2.getFileName();
                Uri uri = mediaItem2.getUri();
                String mimeType = mediaItem2.getMimeType();
                long sizeBytes = mediaItem2.getSizeBytes();
                String mimeType2 = mediaItem2.getMimeType();
                if (mimeType2 != null && StringsKt.startsWith$default(mimeType2, "image/", false, 2, (Object) null)) {
                    z = true;
                    arrayList3.add(new AttachmentItem(id, hashCode, fileName, uri, mimeType, sizeBytes, z, AttachmentUploadStatus.Pending, 0, null, null, 1536, null));
                }
                z = false;
                arrayList3.add(new AttachmentItem(id, hashCode, fileName, uri, mimeType, sizeBytes, z, AttachmentUploadStatus.Pending, 0, null, null, 1536, null));
            }
            objectRef.element = arrayList3;
            if (((List) objectRef.element).isEmpty()) {
                return;
            }
            this._attachmentList.addAll((Collection) objectRef.element);
            this._attachments.postValue(CollectionsKt.toList(this._attachmentList));
            Unit unit = Unit.INSTANCE;
            Iterator it3 = ((Iterable) objectRef.element).iterator();
            while (it3.hasNext()) {
                BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new InputAttachmentListModel$addImageAttachments$2$1(this, (AttachmentItem) it3.next(), null), 2, (Object) null);
            }
        }
    }

    public final void addAttachment(Uri uri, Context context) {
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(context, "context");
        FLogger.INSTANCE.i(this.TAG, "addAttachment: uri=" + uri + ", isEnterpriseLogin=" + isEnterpriseLogin() + ", uploadPath=RemoteResource");
        Log.i(this.TAG, "addAttachment: uri=" + uri + ", isEnterpriseLogin=" + isEnterpriseLogin() + ", uploadPath=RemoteResource");
        synchronized (this.attachmentLock) {
            List<AttachmentItem> list = this._attachmentList;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((AttachmentItem) it.next()).getUri(), uri)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                return;
            }
            Unit unit = Unit.INSTANCE;
            try {
                z2 = context.getContentResolver().query(uri, new String[]{"mime_type", "_size", "_display_name"}, null, null, null);
            } catch (Throwable unused) {
                z2 = null;
            }
            if (z2 == null) {
                this._uploadError.postValue(getApplication().getString(R.string.trae_file_invalid_format));
                return;
            }
            try {
                if (!z2.moveToFirst()) {
                    this._uploadError.postValue(getApplication().getString(R.string.trae_file_invalid_format));
                    z2.close();
                    return;
                }
                int columnIndex = z2.getColumnIndex("_size");
                long j = 0;
                long j2 = columnIndex != -1 ? z2.getLong(columnIndex) : 0L;
                FLogger.INSTANCE.d(this.TAG, "addAttachment:sizeBytes:" + j2);
                if (j2 > getSingleSize()) {
                    this._fileTooLarge.postValue(Unit.INSTANCE);
                    z2.close();
                    return;
                }
                synchronized (this.attachmentLock) {
                    try {
                        try {
                            Iterator<T> it2 = this._attachmentList.iterator();
                            while (it2.hasNext()) {
                                j += ((AttachmentItem) it2.next()).getSizeBytes();
                            }
                        } finally {
                            z3 = z2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            FLogger.INSTANCE.e(this.TAG, "addAttachment", th);
                            this._uploadError.postValue(getApplication().getString(R.string.trae_file_invalid_format));
                            return;
                        } finally {
                            z3.close();
                        }
                    }
                }
                FLogger.INSTANCE.d(this.TAG, "addAttachment:currentTotalSize:" + j);
                if (j + j2 > getWorkAttachmentTotalSize()) {
                    this._totalSizeTooLarge.postValue(Unit.INSTANCE);
                    z2.close();
                    return;
                }
                int columnIndex2 = z2.getColumnIndex("mime_type");
                String string = columnIndex2 != -1 ? z2.getString(columnIndex2) : null;
                int columnIndex3 = z2.getColumnIndex("_display_name");
                String string2 = columnIndex3 != -1 ? z2.getString(columnIndex3) : null;
                long hashCode = uri.toString().hashCode();
                z2 = string != null && StringsKt.startsWith$default(string, "image/", false, 2, (Object) null);
                String str = string;
                String str2 = string2;
                Cursor cursor = z2;
                AttachmentItem attachmentItem = new AttachmentItem(0L, hashCode, str2, uri, str, j2, z2, AttachmentUploadStatus.Pending, 0, null, null, 1536, null);
                cursor.close();
                synchronized (this.attachmentLock) {
                    this._attachmentList.add(attachmentItem);
                    this._attachments.postValue(CollectionsKt.toList(this._attachmentList));
                    Unit unit2 = Unit.INSTANCE;
                }
                BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new InputAttachmentListModel$addAttachment$3(attachmentItem, this, uri, null), 2, (Object) null);
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void retryUpload(AttachmentItem item, ChatMode mode) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (item.getUploadStatus() != AttachmentUploadStatus.Error) {
            return;
        }
        Uri uri = item.getUri();
        updateItem(uri, new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                AttachmentItem retryUpload$lambda$31;
                retryUpload$lambda$31 = InputAttachmentListModel.retryUpload$lambda$31((AttachmentItem) obj);
                return retryUpload$lambda$31;
            }
        });
        boolean z = mode == ChatMode.CODE && item.isImage();
        FLogger.INSTANCE.i(this.TAG, "retryUpload: mode=" + mode + ", isImage=" + item.isImage() + ", useImageUpload=" + z + ", isEnterpriseLogin=" + isEnterpriseLogin());
        Log.i(this.TAG, "retryUpload: mode=" + mode + ", isImage=" + item.isImage() + ", useImageUpload=" + z + ", isEnterpriseLogin=" + isEnterpriseLogin());
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new InputAttachmentListModel$retryUpload$2(this, item, uri, z, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AttachmentItem retryUpload$lambda$31(AttachmentItem attachmentItem) {
        AttachmentItem copy;
        Intrinsics.checkNotNullParameter(attachmentItem, "it");
        copy = attachmentItem.copy((r30 & 1) != 0 ? attachmentItem.bucketId : 0L, (r30 & 2) != 0 ? attachmentItem.id : 0L, (r30 & 4) != 0 ? attachmentItem.fileName : null, (r30 & 8) != 0 ? attachmentItem.uri : null, (r30 & 16) != 0 ? attachmentItem.mimeType : null, (r30 & 32) != 0 ? attachmentItem.sizeBytes : 0L, (r30 & 64) != 0 ? attachmentItem.isImage : false, (r30 & 128) != 0 ? attachmentItem.uploadStatus : AttachmentUploadStatus.Uploading, (r30 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? attachmentItem.uploadProgress : 0, (r30 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? attachmentItem.uploadedOid : null, (r30 & 1024) != 0 ? attachmentItem.uploadError : null);
        return copy;
    }

    public final void removeAttachment(final AttachmentItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        synchronized (this.attachmentLock) {
            CollectionsKt.removeAll(this._attachmentList, new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    boolean removeAttachment$lambda$33$lambda$32;
                    removeAttachment$lambda$33$lambda$32 = InputAttachmentListModel.removeAttachment$lambda$33$lambda$32(AttachmentItem.this, (AttachmentItem) obj);
                    return Boolean.valueOf(removeAttachment$lambda$33$lambda$32);
                }
            });
            this._attachments.postValue(CollectionsKt.toList(this._attachmentList));
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeAttachment$lambda$33$lambda$32(AttachmentItem attachmentItem, AttachmentItem attachmentItem2) {
        Intrinsics.checkNotNullParameter(attachmentItem2, "it");
        return Intrinsics.areEqual(attachmentItem2.getUri(), attachmentItem.getUri());
    }

    public final void clearAttachments() {
        Collection<Job> values = this.fakeProgressJobs.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
        }
        this.fakeProgressJobs.clear();
        synchronized (this.attachmentLock) {
            this._attachmentList.clear();
            this._attachments.postValue(CollectionsKt.emptyList());
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setAttachments(List<AttachmentItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        synchronized (this.attachmentLock) {
            this._attachmentList.clear();
            this._attachmentList.addAll(items);
            this._attachments.postValue(CollectionsKt.toList(this._attachmentList));
            Unit unit = Unit.INSTANCE;
        }
    }

    protected void onCleared() {
        super.onCleared();
        Collection<Job> values = this.fakeProgressJobs.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
        }
        this.fakeProgressJobs.clear();
        if (this.imageUploadServiceDelegate.isInitialized()) {
            getImageUploadService().close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object uploadImageFile(File file, String str, final Function1<? super Integer, Unit> function1, Continuation<? super UploadResult> continuation) {
        InputAttachmentListModel$uploadImageFile$1 inputAttachmentListModel$uploadImageFile$1;
        int i;
        String str2;
        AccountInfo accountInfo;
        UploadResult uploadResult;
        String error;
        if (continuation instanceof InputAttachmentListModel$uploadImageFile$1) {
            inputAttachmentListModel$uploadImageFile$1 = (InputAttachmentListModel$uploadImageFile$1) continuation;
            if ((inputAttachmentListModel$uploadImageFile$1.label & Integer.MIN_VALUE) != 0) {
                inputAttachmentListModel$uploadImageFile$1.label -= Integer.MIN_VALUE;
                InputAttachmentListModel$uploadImageFile$1 inputAttachmentListModel$uploadImageFile$12 = inputAttachmentListModel$uploadImageFile$1;
                Object obj = inputAttachmentListModel$uploadImageFile$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = inputAttachmentListModel$uploadImageFile$12.label;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                        return new UploadResult(((ImageUploadResult) obj).getTosUri(), true, null, null, null, 28, null);
                    }
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    uploadResult = (UploadResult) obj;
                    if (!uploadResult.getSuccess() && !StringsKt.isBlank(uploadResult.getOid())) {
                        return uploadResult;
                    }
                    ImageUploadErrorCode imageUploadErrorCode = ImageUploadErrorCode.UPLOAD_FAILED;
                    error = uploadResult.getError();
                    if (error == null) {
                        error = "Upload failed";
                    }
                    throw new ImageUploadException(imageUploadErrorCode, error, null, 4, null);
                }
                ResultKt.throwOnFailure(obj);
                boolean isEnterpriseLogin = isEnterpriseLogin();
                FLogger.INSTANCE.i(this.TAG, "uploadImageFile: isEnterpriseLogin=" + isEnterpriseLogin + ", mimeType=" + str + ", fileName=" + file.getName() + ", fileSize=" + file.length());
                Log.i(this.TAG, "uploadImageFile: isEnterpriseLogin=" + isEnterpriseLogin + ", mimeType=" + str + ", fileName=" + file.getName() + ", fileSize=" + file.length());
                if (!isEnterpriseLogin) {
                    FLogger.INSTANCE.i(this.TAG, "uploadImageFile branch=ImageX");
                    Log.i(this.TAG, "uploadImageFile branch=ImageX");
                    ImageUploadService imageUploadService = getImageUploadService();
                    inputAttachmentListModel$uploadImageFile$12.label = 1;
                    obj = ImageUploadService.uploadImage$default(imageUploadService, file, function1, 0L, inputAttachmentListModel$uploadImageFile$12, 4, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return new UploadResult(((ImageUploadResult) obj).getTosUri(), true, null, null, null, 28, null);
                }
                FLogger.INSTANCE.i(this.TAG, "uploadImageFile branch=ToBImagePresigned");
                Log.i(this.TAG, "uploadImageFile branch=ToBImagePresigned");
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
                if (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null || (str2 = accountInfo.getUserId()) == null) {
                    str2 = "";
                }
                String str3 = str2;
                String str4 = UUID.randomUUID() + ".trae";
                FileUploadService fileUploadService = getFileUploadService();
                BizType bizType = BizType.Image;
                FileUploadService.UploadOptions uploadOptions = new FileUploadService.UploadOptions(false, false, new Function3() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentListModel$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        Unit uploadImageFile$lambda$38;
                        uploadImageFile$lambda$38 = InputAttachmentListModel.uploadImageFile$lambda$38(function1, ((Integer) obj2).intValue(), ((Long) obj3).longValue(), ((Long) obj4).longValue());
                        return uploadImageFile$lambda$38;
                    }
                }, null, 11, null);
                inputAttachmentListModel$uploadImageFile$12.label = 2;
                obj = fileUploadService.uploadSingleFile(file, str4, bizType, str, str3, uploadOptions, inputAttachmentListModel$uploadImageFile$12);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                uploadResult = (UploadResult) obj;
                if (!uploadResult.getSuccess()) {
                }
                ImageUploadErrorCode imageUploadErrorCode3 = ImageUploadErrorCode.UPLOAD_FAILED;
                error = uploadResult.getError();
                if (error == null) {
                }
                throw new ImageUploadException(imageUploadErrorCode3, error, null, 4, null);
            }
        }
        inputAttachmentListModel$uploadImageFile$1 = new InputAttachmentListModel$uploadImageFile$1(this, continuation);
        InputAttachmentListModel$uploadImageFile$1 inputAttachmentListModel$uploadImageFile$122 = inputAttachmentListModel$uploadImageFile$1;
        Object obj2 = inputAttachmentListModel$uploadImageFile$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = inputAttachmentListModel$uploadImageFile$122.label;
        if (i == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit uploadImageFile$lambda$38(Function1 function1, int i, long j, long j2) {
        function1.invoke(Integer.valueOf(i));
        return Unit.INSTANCE;
    }

    private final boolean isEnterpriseLogin() {
        return LoginUtils.INSTANCE.isEnterpriseLogin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void updateItem(Uri itemUri, Function1<? super AttachmentItem, AttachmentItem> transform) {
        synchronized (this.attachmentLock) {
            Iterator<AttachmentItem> it = this._attachmentList.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual(it.next().getUri(), itemUri)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i >= 0) {
                List<AttachmentItem> list = this._attachmentList;
                list.set(i, transform.invoke(list.get(i)));
            }
            this._attachments.postValue(CollectionsKt.toList(this._attachmentList));
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object uploadWithFakeProgress(Uri uri, Function2<? super Function1<? super Integer, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new InputAttachmentListModel$uploadWithFakeProgress$2(this, uri, function2, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    static /* synthetic */ File uriToFile$default(InputAttachmentListModel inputAttachmentListModel, Uri uri, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return inputAttachmentListModel.uriToFile(uri, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File uriToFile(Uri uri, String mimeType) {
        try {
            ContentResolver contentResolver = getApplication().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
            String extensionFromMimeType = mimeType != null ? MimeTypeMap.getSingleton().getExtensionFromMimeType(mimeType) : null;
            File cacheDir = getApplication().getCacheDir();
            Intrinsics.checkNotNullExpressionValue(cacheDir, "getCacheDir(...)");
            File createUploadTempFile = UploadTempFileFactoryKt.createUploadTempFile(cacheDir, extensionFromMimeType);
            InputStream openInputStream = contentResolver.openInputStream(uri);
            if (openInputStream != null) {
                FileOutputStream fileOutputStream = openInputStream;
                try {
                    InputStream inputStream = fileOutputStream;
                    fileOutputStream = new FileOutputStream(createUploadTempFile);
                    try {
                        long copyTo$default = ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, (Object) null);
                        CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                        Long.valueOf(copyTo$default);
                        CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                    } finally {
                    }
                } finally {
                }
            }
            return createUploadTempFile;
        } catch (Throwable unused) {
            return null;
        }
    }
}
