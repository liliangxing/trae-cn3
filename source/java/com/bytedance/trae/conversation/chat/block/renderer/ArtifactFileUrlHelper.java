package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.im.service.ChatSessionResponse;
import com.bytedance.trae.im.service.GetDownloadUrlData;
import com.bytedance.trae.im.service.GetDownloadUrlRequest;
import com.bytedance.trae.im.service.IChatSessionApi;
import com.bytedance.trae.im.service.IGetDownloadUrlApi;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.platform.service.ApmService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: ArtifactFileUrlHelper.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002*+B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0014J&\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J \u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J6\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;", "", "<init>", "()V", "TAG", "", "DOWNLOAD_URL_MAX_RETRIES", "", "DOWNLOAD_URL_RETRY_DELAY_MS", "", "IM_ARTIFACT_PREVIEW", "fetchFileUrl", "Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;", "chatSessionId", "cliType", "path", "messageId", "conversationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchRemoteFileUrl", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchLocalFileUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "normalizeFilePath", "filePath", "workspacePath", "buildFileUrl", "explorerUrl", "fetchTextContent", IWeixinService.ResponseConstants.URL, "readAllBytes", "", "input", "Ljava/io/InputStream;", "reportApm", "", "step", DBData.FIELD_TYPE, PageDataManager.EXTRA_STATUS, "reason", "extras", "Lorg/json/JSONObject;", "FileUrlResult", "TxtFetchApi", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactFileUrlHelper {
    private static final int DOWNLOAD_URL_MAX_RETRIES = 20;
    private static final long DOWNLOAD_URL_RETRY_DELAY_MS = 2000;
    private static final String IM_ARTIFACT_PREVIEW = "im_artifact_preview";
    public static final ArtifactFileUrlHelper INSTANCE = new ArtifactFileUrlHelper();
    private static final String TAG = "ArtifactFileUrlHelper";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArtifactFileUrlHelper.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bb\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$TxtFetchApi;", "", ApiRequest.METHOD_GET, "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", IWeixinService.ResponseConstants.URL, "", "maxLength", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface TxtFetchApi {
        @GET
        Call<TypedInput> get(@Url String url, @MaxLength int maxLength);
    }

    private ArtifactFileUrlHelper() {
    }

    /* compiled from: ArtifactFileUrlHelper.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;", "", IWeixinService.ResponseConstants.URL, "", "isDeleted", "", "<init>", "(Ljava/lang/String;Z)V", "getUrl", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class FileUrlResult {
        private final boolean isDeleted;
        private final String url;

        public static /* synthetic */ FileUrlResult copy$default(FileUrlResult fileUrlResult, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fileUrlResult.url;
            }
            if ((i & 2) != 0) {
                z = fileUrlResult.isDeleted;
            }
            return fileUrlResult.copy(str, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsDeleted() {
            return this.isDeleted;
        }

        public final FileUrlResult copy(String url, boolean isDeleted) {
            return new FileUrlResult(url, isDeleted);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileUrlResult)) {
                return false;
            }
            FileUrlResult fileUrlResult = (FileUrlResult) other;
            return Intrinsics.areEqual(this.url, fileUrlResult.url) && this.isDeleted == fileUrlResult.isDeleted;
        }

        public int hashCode() {
            String str = this.url;
            return ((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.isDeleted);
        }

        public String toString() {
            return "FileUrlResult(url=" + this.url + ", isDeleted=" + this.isDeleted + ')';
        }

        public FileUrlResult(String str, boolean z) {
            this.url = str;
            this.isDeleted = z;
        }

        public /* synthetic */ FileUrlResult(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? false : z);
        }

        public final String getUrl() {
            return this.url;
        }

        public final boolean isDeleted() {
            return this.isDeleted;
        }
    }

    public final Object fetchFileUrl(String str, String str2, String str3, String str4, String str5, Continuation<? super FileUrlResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ArtifactFileUrlHelper$fetchFileUrl$2(str2, str, str3, str5, str4, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(8:5|6|(1:(1:9)(2:42|43))(2:44|(1:46)(1:47))|10|11|12|13|(7:15|(1:17)(1:33)|18|(1:20)(1:32)|21|(1:25)|(2:27|28)(2:30|31))(2:34|(2:36|37)(2:38|39))))|48|6|(0)(0)|10|11|12|13|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchRemoteFileUrl(String str, String str2, Continuation<? super FileUrlResult> continuation) {
        ArtifactFileUrlHelper$fetchRemoteFileUrl$1 artifactFileUrlHelper$fetchRemoteFileUrl$1;
        int i;
        ArtifactFileUrlHelper artifactFileUrlHelper;
        HttpDataResult.Success success;
        if (continuation instanceof ArtifactFileUrlHelper$fetchRemoteFileUrl$1) {
            artifactFileUrlHelper$fetchRemoteFileUrl$1 = (ArtifactFileUrlHelper$fetchRemoteFileUrl$1) continuation;
            if ((artifactFileUrlHelper$fetchRemoteFileUrl$1.label & Integer.MIN_VALUE) != 0) {
                artifactFileUrlHelper$fetchRemoteFileUrl$1.label -= Integer.MIN_VALUE;
                Object obj = artifactFileUrlHelper$fetchRemoteFileUrl$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = artifactFileUrlHelper$fetchRemoteFileUrl$1.label;
                boolean z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    IChatSessionApi.Companion companion = IChatSessionApi.INSTANCE;
                    artifactFileUrlHelper$fetchRemoteFileUrl$1.L$0 = this;
                    artifactFileUrlHelper$fetchRemoteFileUrl$1.L$1 = str;
                    artifactFileUrlHelper$fetchRemoteFileUrl$1.L$2 = str2;
                    artifactFileUrlHelper$fetchRemoteFileUrl$1.label = 1;
                    obj = companion.getChatSessionRawCall(str, artifactFileUrlHelper$fetchRemoteFileUrl$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    artifactFileUrlHelper = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str2 = (String) artifactFileUrlHelper$fetchRemoteFileUrl$1.L$2;
                    str = (String) artifactFileUrlHelper$fetchRemoteFileUrl$1.L$1;
                    artifactFileUrlHelper = (ArtifactFileUrlHelper) artifactFileUrlHelper$fetchRemoteFileUrl$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                success = (HttpDataResult) obj;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("chatSessionId", str);
                jSONObject.put("path", str2);
                int i2 = 2;
                boolean z2 = false;
                String str3 = null;
                if (!(success instanceof HttpDataResult.Success)) {
                    HttpDataResult.Success success2 = success;
                    ChatSessionResponse chatSessionResponse = (ChatSessionResponse) success2.getBizResp().getData();
                    String explorerUrl = chatSessionResponse != null ? chatSessionResponse.getExplorerUrl() : null;
                    ChatSessionResponse chatSessionResponse2 = (ChatSessionResponse) success2.getBizResp().getData();
                    String workspacePath = chatSessionResponse2 != null ? chatSessionResponse2.getWorkspacePath() : null;
                    String str4 = explorerUrl;
                    if (str4 != null && str4.length() != 0) {
                        z = false;
                    }
                    if (z) {
                        artifactFileUrlHelper.reportApm("fetch_file_url", "remote", "failed", "url_null", jSONObject);
                        return new FileUrlResult(str3, z2, i2, str3);
                    }
                    artifactFileUrlHelper.reportApm("fetch_file_url", "remote", "success", null, jSONObject);
                    return new FileUrlResult(artifactFileUrlHelper.buildFileUrl(explorerUrl, artifactFileUrlHelper.normalizeFilePath(str2, workspacePath)), z2, i2, str3);
                }
                if (!(success instanceof HttpDataResult.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                HttpDataResult.Error error = (HttpDataResult.Error) success;
                artifactFileUrlHelper.reportApm("fetch_file_url", "remote", "failed", error.getCode() + '_' + error.getMsg(), jSONObject);
                return new FileUrlResult(str3, z2, i2, str3);
            }
        }
        artifactFileUrlHelper$fetchRemoteFileUrl$1 = new ArtifactFileUrlHelper$fetchRemoteFileUrl$1(this, continuation);
        Object obj2 = artifactFileUrlHelper$fetchRemoteFileUrl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = artifactFileUrlHelper$fetchRemoteFileUrl$1.label;
        boolean z3 = true;
        if (i != 0) {
        }
        success = (HttpDataResult) obj2;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("chatSessionId", str);
        jSONObject2.put("path", str2);
        int i22 = 2;
        boolean z22 = false;
        String str32 = null;
        if (!(success instanceof HttpDataResult.Success)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0168 -> B:11:0x016d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0173 -> B:12:0x0171). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchLocalFileUrl(String str, String str2, String str3, Continuation<? super FileUrlResult> continuation) {
        ArtifactFileUrlHelper$fetchLocalFileUrl$1 artifactFileUrlHelper$fetchLocalFileUrl$1;
        ArtifactFileUrlHelper artifactFileUrlHelper;
        int i;
        JSONObject jSONObject;
        String str4;
        String str5;
        String str6;
        ArtifactFileUrlHelper artifactFileUrlHelper2;
        int i2;
        ArtifactFileUrlHelper artifactFileUrlHelper3;
        String str7;
        String str8;
        String str9;
        JSONObject jSONObject2;
        HttpDataResult.Success success;
        Map<String, String> urlMap;
        if (continuation instanceof ArtifactFileUrlHelper$fetchLocalFileUrl$1) {
            artifactFileUrlHelper$fetchLocalFileUrl$1 = (ArtifactFileUrlHelper$fetchLocalFileUrl$1) continuation;
            if ((artifactFileUrlHelper$fetchLocalFileUrl$1.label & Integer.MIN_VALUE) != 0) {
                artifactFileUrlHelper$fetchLocalFileUrl$1.label -= Integer.MIN_VALUE;
                artifactFileUrlHelper = this;
                Object obj = artifactFileUrlHelper$fetchLocalFileUrl$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = artifactFileUrlHelper$fetchLocalFileUrl$1.label;
                int i3 = 2;
                boolean z = true;
                z = true;
                String str10 = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    jSONObject = new JSONObject();
                    str4 = str2;
                    try {
                        jSONObject.put("conversationId", str4);
                        str6 = str3;
                        try {
                            jSONObject.put("messageId", str6);
                            str5 = str;
                            try {
                                jSONObject.put("path", str5);
                            } catch (Throwable unused) {
                            }
                        } catch (Throwable unused2) {
                            str5 = str;
                        }
                    } catch (Throwable unused3) {
                        str5 = str;
                        str6 = str3;
                    }
                    artifactFileUrlHelper2 = artifactFileUrlHelper;
                    i2 = 0;
                    if (i2 >= 21) {
                    }
                } else if (i == 1) {
                    i2 = artifactFileUrlHelper$fetchLocalFileUrl$1.I$0;
                    JSONObject jSONObject3 = (JSONObject) artifactFileUrlHelper$fetchLocalFileUrl$1.L$4;
                    String str11 = (String) artifactFileUrlHelper$fetchLocalFileUrl$1.L$3;
                    String str12 = (String) artifactFileUrlHelper$fetchLocalFileUrl$1.L$2;
                    str9 = (String) artifactFileUrlHelper$fetchLocalFileUrl$1.L$1;
                    ArtifactFileUrlHelper artifactFileUrlHelper4 = (ArtifactFileUrlHelper) artifactFileUrlHelper$fetchLocalFileUrl$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    jSONObject2 = jSONObject3;
                    str7 = str11;
                    artifactFileUrlHelper3 = artifactFileUrlHelper4;
                    str8 = str12;
                    success = (HttpDataResult) obj;
                    if (!(success instanceof HttpDataResult.Success)) {
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = artifactFileUrlHelper$fetchLocalFileUrl$1.I$0;
                    JSONObject jSONObject4 = (JSONObject) artifactFileUrlHelper$fetchLocalFileUrl$1.L$4;
                    str6 = (String) artifactFileUrlHelper$fetchLocalFileUrl$1.L$3;
                    String str13 = (String) artifactFileUrlHelper$fetchLocalFileUrl$1.L$2;
                    String str14 = (String) artifactFileUrlHelper$fetchLocalFileUrl$1.L$1;
                    ArtifactFileUrlHelper artifactFileUrlHelper5 = (ArtifactFileUrlHelper) artifactFileUrlHelper$fetchLocalFileUrl$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    jSONObject = jSONObject4;
                    str4 = str13;
                    str5 = str14;
                    artifactFileUrlHelper2 = artifactFileUrlHelper5;
                    i2++;
                    z = true;
                    str10 = null;
                    if (i2 >= 21) {
                        IGetDownloadUrlApi.Companion companion = IGetDownloadUrlApi.INSTANCE;
                        GetDownloadUrlRequest getDownloadUrlRequest = new GetDownloadUrlRequest(CollectionsKt.listOf(str5), str4, str6, Boxing.boxBoolean(z));
                        artifactFileUrlHelper$fetchLocalFileUrl$1.L$0 = artifactFileUrlHelper2;
                        artifactFileUrlHelper$fetchLocalFileUrl$1.L$1 = str5;
                        artifactFileUrlHelper$fetchLocalFileUrl$1.L$2 = str4;
                        artifactFileUrlHelper$fetchLocalFileUrl$1.L$3 = str6;
                        artifactFileUrlHelper$fetchLocalFileUrl$1.L$4 = jSONObject;
                        artifactFileUrlHelper$fetchLocalFileUrl$1.I$0 = i2;
                        artifactFileUrlHelper$fetchLocalFileUrl$1.label = z ? 1 : 0;
                        Object downloadUrlRawCall = companion.getDownloadUrlRawCall(getDownloadUrlRequest, artifactFileUrlHelper$fetchLocalFileUrl$1);
                        if (downloadUrlRawCall == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str8 = str4;
                        str7 = str6;
                        artifactFileUrlHelper3 = artifactFileUrlHelper2;
                        str9 = str5;
                        jSONObject2 = jSONObject;
                        obj = downloadUrlRawCall;
                        success = (HttpDataResult) obj;
                        if (!(success instanceof HttpDataResult.Success)) {
                            HttpDataResult.Success success2 = success;
                            GetDownloadUrlData getDownloadUrlData = (GetDownloadUrlData) success2.getBizResp().getData();
                            String str15 = (getDownloadUrlData == null || (urlMap = getDownloadUrlData.getUrlMap()) == null) ? str10 : urlMap.get(str9);
                            if (str15 != null) {
                                if (str15.length() == 0 ? z : false) {
                                    artifactFileUrlHelper3.reportApm("fetch_file_url", "local", "failed", "url_is_null", jSONObject2);
                                    return new FileUrlResult(str10, z);
                                }
                                artifactFileUrlHelper3.reportApm("fetch_file_url", "local", "success", "", jSONObject2);
                                return new FileUrlResult(str15, false, i3, str10);
                            }
                            long code = success2.getBizResp().getCode();
                            if (code == 202) {
                                String str16 = str9;
                                String str17 = str8;
                                String str18 = str7;
                                artifactFileUrlHelper3.reportApm("fetch_file_url", "local", "failed", "202", jSONObject2);
                                if (i2 < 20) {
                                    artifactFileUrlHelper$fetchLocalFileUrl$1.L$0 = artifactFileUrlHelper3;
                                    artifactFileUrlHelper$fetchLocalFileUrl$1.L$1 = str16;
                                    artifactFileUrlHelper$fetchLocalFileUrl$1.L$2 = str17;
                                    artifactFileUrlHelper$fetchLocalFileUrl$1.L$3 = str18;
                                    artifactFileUrlHelper$fetchLocalFileUrl$1.L$4 = jSONObject2;
                                    artifactFileUrlHelper$fetchLocalFileUrl$1.I$0 = i2;
                                    artifactFileUrlHelper$fetchLocalFileUrl$1.label = 2;
                                    if (DelayKt.delay(2000L, artifactFileUrlHelper$fetchLocalFileUrl$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    str13 = str17;
                                    jSONObject4 = jSONObject2;
                                    str6 = str18;
                                    str14 = str16;
                                    artifactFileUrlHelper5 = artifactFileUrlHelper3;
                                    jSONObject = jSONObject4;
                                    str4 = str13;
                                    str5 = str14;
                                    artifactFileUrlHelper2 = artifactFileUrlHelper5;
                                    i2++;
                                    z = true;
                                    str10 = null;
                                    if (i2 >= 21) {
                                        artifactFileUrlHelper2.reportApm("fetch_file_url", "local", "failed", "uploading", jSONObject);
                                        String str19 = null;
                                        return new FileUrlResult(str19, false, i3, str19);
                                    }
                                } else {
                                    str4 = str17;
                                    jSONObject = jSONObject2;
                                    str6 = str18;
                                    str5 = str16;
                                    artifactFileUrlHelper2 = artifactFileUrlHelper3;
                                    i2++;
                                    z = true;
                                    str10 = null;
                                    if (i2 >= 21) {
                                    }
                                }
                            } else {
                                artifactFileUrlHelper3.reportApm("fetch_file_url", "local", "failed", code + "", jSONObject2);
                                return new FileUrlResult(null, true);
                            }
                        } else {
                            if (!(success instanceof HttpDataResult.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            HttpDataResult.Error error = (HttpDataResult.Error) success;
                            artifactFileUrlHelper3.reportApm("fetch_file_url", "local", "failed", error.getCode() + '_' + error.getMsg(), jSONObject2);
                            String str20 = null;
                            return new FileUrlResult(str20, false, i3, str20);
                        }
                    }
                }
            }
        }
        artifactFileUrlHelper = this;
        artifactFileUrlHelper$fetchLocalFileUrl$1 = new ArtifactFileUrlHelper$fetchLocalFileUrl$1(artifactFileUrlHelper, continuation);
        Object obj2 = artifactFileUrlHelper$fetchLocalFileUrl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = artifactFileUrlHelper$fetchLocalFileUrl$1.label;
        int i32 = 2;
        boolean z2 = true;
        z2 = true;
        String str102 = null;
        if (i != 0) {
        }
    }

    static /* synthetic */ String normalizeFilePath$default(ArtifactFileUrlHelper artifactFileUrlHelper, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return artifactFileUrlHelper.normalizeFilePath(str, str2);
    }

    private final String normalizeFilePath(String filePath, String workspacePath) {
        String str = workspacePath;
        if (!(str == null || str.length() == 0)) {
            String str2 = StringsKt.endsWith$default(workspacePath, "/", false, 2, (Object) null) ? workspacePath : workspacePath + '/';
            if (StringsKt.endsWith$default(workspacePath, "/", false, 2, (Object) null)) {
                workspacePath = StringsKt.dropLast(workspacePath, 1);
            }
            for (String str3 : CollectionsKt.listOf(new String[]{str2, workspacePath})) {
                if (StringsKt.startsWith$default(filePath, str3, false, 2, (Object) null)) {
                    String substring = filePath.substring(str3.length());
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    return StringsKt.removePrefix(substring, "/");
                }
            }
        }
        if (!StringsKt.startsWith$default(filePath, "/", false, 2, (Object) null)) {
            return filePath;
        }
        String substring2 = filePath.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        return substring2;
    }

    private final String buildFileUrl(String explorerUrl, String path) {
        String encode = URLEncoder.encode(path, "UTF-8");
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
        if (xTToken == null) {
            xTToken = "";
        }
        return StringsKt.trimEnd(explorerUrl, new char[]{'/'}) + "/file/" + encode + "?download=true&authorization=" + URLEncoder.encode("Cloud-IDE-JWT " + xTToken, "UTF-8");
    }

    public final Object fetchTextContent(String str, String str2, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ArtifactFileUrlHelper$fetchTextContent$2(str2, str, null), continuation);
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

    public final void reportApm(String step, String type, String status, String reason, JSONObject extras) {
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(type, DBData.FIELD_TYPE);
        Intrinsics.checkNotNullParameter(status, PageDataManager.EXTRA_STATUS);
        try {
            Result.Companion companion = Result.Companion;
            ArtifactFileUrlHelper artifactFileUrlHelper = this;
            ApmService apmService = ApmService.INSTANCE;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("step", step);
            jSONObject.put(DBData.FIELD_TYPE, type);
            jSONObject.put(PageDataManager.EXTRA_STATUS, status);
            if (reason != null) {
                jSONObject.put("reason", reason);
            }
            Unit unit = Unit.INSTANCE;
            apmService.monitorEventForSlardar(IM_ARTIFACT_PREVIEW, jSONObject, (JSONObject) null, extras);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }
}
