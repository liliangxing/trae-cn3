package com.bytedance.trae.conversation.fileupload;

import android.util.Log;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.PUT;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.auth.respository.PermissionConfigParser;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.trae.conversation.LoginUtils;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: FileUploadService.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0005+,-./B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JJ\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012J*\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0002J\u0016\u0010\"\u001a\u00020\u000b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u000bH\u0002J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/FileUploadService;", "", "api", "Lcom/bytedance/trae/conversation/fileupload/ResourceUploadApi;", "<init>", "(Lcom/bytedance/trae/conversation/fileupload/ResourceUploadApi;)V", "uploadSingleFile", "Lcom/bytedance/trae/conversation/fileupload/UploadResult;", MessagePart.TYPE_FILE, "Ljava/io/File;", "subTargetPath", "", "bizType", "Lcom/bytedance/trae/conversation/fileupload/BizType;", "contentType", "userId", "options", "Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;", "(Ljava/io/File;Ljava/lang/String;Lcom/bytedance/trae/conversation/fileupload/BizType;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadSingleFile", "", "oid", "enableMagic", "", "(Ljava/lang/String;Lcom/bytedance/trae/conversation/fileupload/BizType;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildUploadUrl", PermissionConfigParser.WEBCAST_HOST_NAMESPACE, "createObjectStoreApi", "Lcom/bytedance/trae/conversation/fileupload/FileUploadService$IObjectStoreApi;", "shouldUseTobObjectStorePutCompat", "logPutFailureResponse", "", "putResult", "Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;", "formatRetrofitHeaders", "headers", "", "Lcom/bytedance/retrofit2/client/Header;", "logLongWarn", "message", "readAllBytes", "input", "Ljava/io/InputStream;", "Companion", "UploadOptions", "ObjectStorePutResult", "IObjectStoreApi", "FileWithOptionalMagicTypedOutput", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FileUploadService {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int LOG_CHUNK_SIZE = 3000;

    @Deprecated
    public static final String TAG = "FileUploadService";
    private final ResourceUploadApi api;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileUploadService.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH'J0\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tH'¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/FileUploadService$IObjectStoreApi;", "", "put", "Lcom/bytedance/retrofit2/Call;", "", IWeixinService.ResponseConstants.URL, "body", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "headers", "", "addCommonParam", "", ApiRequest.METHOD_GET, "Lcom/bytedance/retrofit2/mime/TypedInput;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface IObjectStoreApi {
        @GET
        Call<TypedInput> get(@Url String url, @HeaderMap Map<String, String> headers);

        @PUT
        Call<String> put(@Url String url, @Body TypedOutput body, @HeaderMap Map<String, String> headers, @AddCommonParam boolean addCommonParam);
    }

    public FileUploadService(ResourceUploadApi resourceUploadApi) {
        Intrinsics.checkNotNullParameter(resourceUploadApi, "api");
        this.api = resourceUploadApi;
    }

    /* compiled from: FileUploadService.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/FileUploadService$Companion;", "", "<init>", "()V", "TAG", "", "LOG_CHUNK_SIZE", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: FileUploadService.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0084\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012O\b\u0002\u0010\u0005\u001aI\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JP\u0010\u001d\u001aI\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0006HÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010HÆ\u0003J\u0086\u0001\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032O\b\u0002\u0010\u0005\u001aI\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00062\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010HÆ\u0001J\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015RX\u0010\u0005\u001aI\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;", "", "enableMagic", "", "useV2", "onProgress", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "percent", "", "loaded", "total", "", "onFinish", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;", "<init>", "(ZZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;)V", "getEnableMagic", "()Z", "getUseV2", "getOnProgress", "()Lkotlin/jvm/functions/Function3;", "getOnFinish", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class UploadOptions {
        private final boolean enableMagic;
        private final Function1<UploadFinishInfo, Unit> onFinish;
        private final Function3<Integer, Long, Long, Unit> onProgress;
        private final boolean useV2;

        public UploadOptions() {
            this(false, false, null, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UploadOptions copy$default(UploadOptions uploadOptions, boolean z, boolean z2, Function3 function3, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                z = uploadOptions.enableMagic;
            }
            if ((i & 2) != 0) {
                z2 = uploadOptions.useV2;
            }
            if ((i & 4) != 0) {
                function3 = uploadOptions.onProgress;
            }
            if ((i & 8) != 0) {
                function1 = uploadOptions.onFinish;
            }
            return uploadOptions.copy(z, z2, function3, function1);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getEnableMagic() {
            return this.enableMagic;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getUseV2() {
            return this.useV2;
        }

        public final Function3<Integer, Long, Long, Unit> component3() {
            return this.onProgress;
        }

        public final Function1<UploadFinishInfo, Unit> component4() {
            return this.onFinish;
        }

        public final UploadOptions copy(boolean enableMagic, boolean useV2, Function3<? super Integer, ? super Long, ? super Long, Unit> onProgress, Function1<? super UploadFinishInfo, Unit> onFinish) {
            return new UploadOptions(enableMagic, useV2, onProgress, onFinish);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UploadOptions)) {
                return false;
            }
            UploadOptions uploadOptions = (UploadOptions) other;
            return this.enableMagic == uploadOptions.enableMagic && this.useV2 == uploadOptions.useV2 && Intrinsics.areEqual(this.onProgress, uploadOptions.onProgress) && Intrinsics.areEqual(this.onFinish, uploadOptions.onFinish);
        }

        public int hashCode() {
            int hashCode = ((Boolean.hashCode(this.enableMagic) * 31) + Boolean.hashCode(this.useV2)) * 31;
            Function3<Integer, Long, Long, Unit> function3 = this.onProgress;
            int hashCode2 = (hashCode + (function3 == null ? 0 : function3.hashCode())) * 31;
            Function1<UploadFinishInfo, Unit> function1 = this.onFinish;
            return hashCode2 + (function1 != null ? function1.hashCode() : 0);
        }

        public String toString() {
            return "UploadOptions(enableMagic=" + this.enableMagic + ", useV2=" + this.useV2 + ", onProgress=" + this.onProgress + ", onFinish=" + this.onFinish + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public UploadOptions(boolean z, boolean z2, Function3<? super Integer, ? super Long, ? super Long, Unit> function3, Function1<? super UploadFinishInfo, Unit> function1) {
            this.enableMagic = z;
            this.useV2 = z2;
            this.onProgress = function3;
            this.onFinish = function1;
        }

        public /* synthetic */ UploadOptions(boolean z, boolean z2, Function3 function3, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? null : function3, (i & 8) != 0 ? null : function1);
        }

        public final boolean getEnableMagic() {
            return this.enableMagic;
        }

        public final boolean getUseV2() {
            return this.useV2;
        }

        public final Function3<Integer, Long, Long, Unit> getOnProgress() {
            return this.onProgress;
        }

        public final Function1<UploadFinishInfo, Unit> getOnFinish() {
            return this.onFinish;
        }
    }

    public final Object uploadSingleFile(File file, String str, BizType bizType, String str2, String str3, UploadOptions uploadOptions, Continuation<? super UploadResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FileUploadService$uploadSingleFile$2(uploadOptions, str2, bizType, str, str3, this, file, null), continuation);
    }

    public static /* synthetic */ Object downloadSingleFile$default(FileUploadService fileUploadService, String str, BizType bizType, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            bizType = BizType.RemoteResource;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return fileUploadService.downloadSingleFile(str, bizType, z, continuation);
    }

    public final Object downloadSingleFile(String str, BizType bizType, boolean z, Continuation<? super byte[]> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FileUploadService$downloadSingleFile$2(this, str, bizType, z, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildUploadUrl(String host, String oid) {
        String trimEnd = StringsKt.trimEnd(StringsKt.trim(host).toString(), new char[]{'/'});
        String trimStart = StringsKt.trimStart(oid, new char[]{'/'});
        if (StringsKt.startsWith$default(trimEnd, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(trimEnd, "https://", false, 2, (Object) null)) {
            return trimEnd + '/' + trimStart;
        }
        return "https://" + trimEnd + '/' + trimStart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IObjectStoreApi createObjectStoreApi() {
        Object create = RetrofitUtils.createSsRetrofit("https://placeholder.trae/", CollectionsKt.listOf(new Interceptor() { // from class: com.bytedance.trae.conversation.fileupload.FileUploadService$$ExternalSyntheticLambda0
            public final SsResponse intercept(Interceptor.Chain chain) {
                SsResponse createObjectStoreApi$lambda$0;
                createObjectStoreApi$lambda$0 = FileUploadService.createObjectStoreApi$lambda$0(chain);
                return createObjectStoreApi$lambda$0;
            }
        }), (Converter.Factory) null).create(IObjectStoreApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return (IObjectStoreApi) create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SsResponse createObjectStoreApi$lambda$0(Interceptor.Chain chain) {
        Request request = chain.request();
        List headers = request.getHeaders();
        Intrinsics.checkNotNullExpressionValue(headers, "getHeaders(...)");
        List mutableList = CollectionsKt.toMutableList(headers);
        mutableList.add(new Header("x-ttnet-req-biz-id", "conversation_file_upload_object_store"));
        Request.Builder headers2 = request.newBuilder().headers(mutableList);
        Intrinsics.checkNotNullExpressionValue(headers2, "headers(...)");
        return chain.proceed(headers2.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldUseTobObjectStorePutCompat() {
        return LoginUtils.INSTANCE.isEnterpriseLogin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileUploadService.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0082\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;", "", "code", "", "isSuccessful", "", "message", "", "errorText", "headersText", "<init>", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "()Z", "getMessage", "()Ljava/lang/String;", "getErrorText", "getHeadersText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ObjectStorePutResult {
        private final int code;
        private final String errorText;
        private final String headersText;
        private final boolean isSuccessful;
        private final String message;

        public static /* synthetic */ ObjectStorePutResult copy$default(ObjectStorePutResult objectStorePutResult, int i, boolean z, String str, String str2, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = objectStorePutResult.code;
            }
            if ((i2 & 2) != 0) {
                z = objectStorePutResult.isSuccessful;
            }
            boolean z2 = z;
            if ((i2 & 4) != 0) {
                str = objectStorePutResult.message;
            }
            String str4 = str;
            if ((i2 & 8) != 0) {
                str2 = objectStorePutResult.errorText;
            }
            String str5 = str2;
            if ((i2 & 16) != 0) {
                str3 = objectStorePutResult.headersText;
            }
            return objectStorePutResult.copy(i, z2, str4, str5, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsSuccessful() {
            return this.isSuccessful;
        }

        /* renamed from: component3, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* renamed from: component4, reason: from getter */
        public final String getErrorText() {
            return this.errorText;
        }

        /* renamed from: component5, reason: from getter */
        public final String getHeadersText() {
            return this.headersText;
        }

        public final ObjectStorePutResult copy(int code, boolean isSuccessful, String message, String errorText, String headersText) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(errorText, "errorText");
            Intrinsics.checkNotNullParameter(headersText, "headersText");
            return new ObjectStorePutResult(code, isSuccessful, message, errorText, headersText);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ObjectStorePutResult)) {
                return false;
            }
            ObjectStorePutResult objectStorePutResult = (ObjectStorePutResult) other;
            return this.code == objectStorePutResult.code && this.isSuccessful == objectStorePutResult.isSuccessful && Intrinsics.areEqual(this.message, objectStorePutResult.message) && Intrinsics.areEqual(this.errorText, objectStorePutResult.errorText) && Intrinsics.areEqual(this.headersText, objectStorePutResult.headersText);
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.code) * 31) + Boolean.hashCode(this.isSuccessful)) * 31) + this.message.hashCode()) * 31) + this.errorText.hashCode()) * 31) + this.headersText.hashCode();
        }

        public String toString() {
            return "ObjectStorePutResult(code=" + this.code + ", isSuccessful=" + this.isSuccessful + ", message=" + this.message + ", errorText=" + this.errorText + ", headersText=" + this.headersText + ')';
        }

        public ObjectStorePutResult(int i, boolean z, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(str2, "errorText");
            Intrinsics.checkNotNullParameter(str3, "headersText");
            this.code = i;
            this.isSuccessful = z;
            this.message = str;
            this.errorText = str2;
            this.headersText = str3;
        }

        public /* synthetic */ ObjectStorePutResult(int i, boolean z, String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, z, (i2 & 4) != 0 ? "" : str, str2, (i2 & 16) != 0 ? "" : str3);
        }

        public final int getCode() {
            return this.code;
        }

        public final boolean isSuccessful() {
            return this.isSuccessful;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getErrorText() {
            return this.errorText;
        }

        public final String getHeadersText() {
            return this.headersText;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logPutFailureResponse(BizType bizType, ObjectStorePutResult putResult) {
        StringBuilder sb = new StringBuilder("uploadSingleFile put failed response: bizType=");
        sb.append(bizType);
        sb.append(", code=").append(putResult.getCode());
        sb.append(", message=").append(putResult.getMessage());
        sb.append("\nheaders:\n");
        String headersText = putResult.getHeadersText();
        if (StringsKt.isBlank(headersText)) {
            headersText = "<empty>";
        }
        sb.append(headersText);
        sb.append("\nbody:\n");
        String errorText = putResult.getErrorText();
        sb.append(StringsKt.isBlank(errorText) ? "<empty>" : errorText);
        logLongWarn(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatRetrofitHeaders(List<Header> headers) {
        return headers.isEmpty() ? "" : CollectionsKt.joinToString$default(headers, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.bytedance.trae.conversation.fileupload.FileUploadService$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                CharSequence formatRetrofitHeaders$lambda$4;
                formatRetrofitHeaders$lambda$4 = FileUploadService.formatRetrofitHeaders$lambda$4((Header) obj);
                return formatRetrofitHeaders$lambda$4;
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence formatRetrofitHeaders$lambda$4(Header header) {
        Intrinsics.checkNotNullParameter(header, "header");
        return header.getName() + ": " + header.getValue();
    }

    private final void logLongWarn(String message) {
        if (message.length() <= 3000) {
            FLogger.INSTANCE.w(TAG, message);
            Log.w(TAG, message);
            return;
        }
        int length = ((message.length() + LOG_CHUNK_SIZE) - 1) / LOG_CHUNK_SIZE;
        int i = 0;
        int i2 = 1;
        while (i < message.length()) {
            int coerceAtMost = RangesKt.coerceAtMost(i + LOG_CHUNK_SIZE, message.length());
            StringBuilder append = new StringBuilder("[").append(i2).append('/').append(length).append("] ");
            String substring = message.substring(i, coerceAtMost);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String sb = append.append(substring).toString();
            FLogger.INSTANCE.w(TAG, sb);
            Log.w(TAG, sb);
            i2++;
            i = coerceAtMost;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] readAllBytes(InputStream input) {
        InputStream inputStream = input;
        try {
            InputStream inputStream2 = inputStream;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[FConstants.DOWNLOAD_BUFFER_SIZE];
            while (true) {
                int read = inputStream2.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                    CloseableKt.closeFinally(inputStream, (Throwable) null);
                    return byteArray;
                }
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileUploadService.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B~\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012M\u0010\u000b\u001aI\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f¢\u0006\u0004\b\u0014\u0010\u0015J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000RU\u0010\u000b\u001aI\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;", "Lcom/bytedance/retrofit2/mime/TypedOutput;", MessagePart.TYPE_FILE, "Ljava/io/File;", "contentType", "", "enableMagic", "", "useV2", "totalBytes", "", "onProgress", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "percent", "loaded", "total", "", "<init>", "(Ljava/io/File;Ljava/lang/String;ZZJLkotlin/jvm/functions/Function3;)V", "fileName", "mimeType", "length", "writeTo", "out", "Ljava/io/OutputStream;", "md5Stub", "notifyProgress", "written", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class FileWithOptionalMagicTypedOutput implements TypedOutput {
        private final String contentType;
        private final boolean enableMagic;
        private final File file;
        private final Function3<Integer, Long, Long, Unit> onProgress;
        private final long totalBytes;
        private final boolean useV2;

        public String fileName() {
            return null;
        }

        public String md5Stub() {
            return "";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public FileWithOptionalMagicTypedOutput(File file, String str, boolean z, boolean z2, long j, Function3<? super Integer, ? super Long, ? super Long, Unit> function3) {
            Intrinsics.checkNotNullParameter(file, MessagePart.TYPE_FILE);
            Intrinsics.checkNotNullParameter(str, "contentType");
            this.file = file;
            this.contentType = str;
            this.enableMagic = z;
            this.useV2 = z2;
            this.totalBytes = j;
            this.onProgress = function3;
        }

        /* renamed from: mimeType, reason: from getter */
        public String getContentType() {
            return this.contentType;
        }

        public long length() {
            return this.file.length() + ResourceUploadUtilKt.getUploadMagicNumber(this.enableMagic, this.useV2).length;
        }

        public void writeTo(OutputStream out) {
            long j;
            Intrinsics.checkNotNullParameter(out, "out");
            byte[] uploadMagicNumber = ResourceUploadUtilKt.getUploadMagicNumber(this.enableMagic, this.useV2);
            long j2 = 0;
            if (!(uploadMagicNumber.length == 0)) {
                out.write(uploadMagicNumber);
                j = uploadMagicNumber.length + 0;
                notifyProgress(j);
            } else {
                j = 0;
            }
            FileInputStream fileInputStream = new FileInputStream(this.file);
            try {
                FileInputStream fileInputStream2 = fileInputStream;
                byte[] bArr = new byte[FConstants.DOWNLOAD_BUFFER_SIZE];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read > 0) {
                        if (this.useV2 && this.enableMagic) {
                            for (int i = 0; i < read; i++) {
                                bArr[i] = (byte) (bArr[i] ^ ResourceUploadUtilKt.getTRAE_XOR_KEY_V2()[(int) (j2 % ResourceUploadUtilKt.getTRAE_XOR_KEY_V2().length)]);
                                j2++;
                            }
                        }
                        out.write(bArr, 0, read);
                        j += read;
                        notifyProgress(j);
                    } else {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileInputStream, (Throwable) null);
                        return;
                    }
                }
            } finally {
            }
        }

        private final void notifyProgress(long written) {
            Function3<Integer, Long, Long, Unit> function3 = this.onProgress;
            if (function3 == null) {
                return;
            }
            long j = this.totalBytes;
            if (j <= 0) {
                j = length();
            }
            function3.invoke(Integer.valueOf(RangesKt.coerceIn(j <= 0 ? 0 : (int) ((100 * written) / j), 0, 100)), Long.valueOf(written), Long.valueOf(j));
        }
    }
}
