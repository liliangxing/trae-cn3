package com.bytedance.trae.conversation.fileupload;

import android.util.Log;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.trae.conversation.fileupload.FileUploadService;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.utils.logger.FLogger;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileUploadService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/conversation/fileupload/UploadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.fileupload.FileUploadService$uploadSingleFile$2", f = "FileUploadService.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {78, 179}, m = "invokeSuspend", n = {"$this$withContext", "progressCallback", "finishCallback", "usedContentType", "t0", "enableMagic", "useV2", "finishCallback", "oid", "resourceId", "checksums", "t0", "prepareMs", "t2", "uploadMs"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "J$0", "J$1", "J$2", "J$3"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FileUploadService$uploadSingleFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UploadResult>, Object> {
    final /* synthetic */ BizType $bizType;
    final /* synthetic */ String $contentType;
    final /* synthetic */ File $file;
    final /* synthetic */ FileUploadService.UploadOptions $options;
    final /* synthetic */ String $subTargetPath;
    final /* synthetic */ String $userId;
    long J$0;
    long J$1;
    long J$2;
    long J$3;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    boolean Z$1;
    int label;
    final /* synthetic */ FileUploadService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileUploadService$uploadSingleFile$2(FileUploadService.UploadOptions uploadOptions, String str, BizType bizType, String str2, String str3, FileUploadService fileUploadService, File file, Continuation<? super FileUploadService$uploadSingleFile$2> continuation) {
        super(2, continuation);
        this.$options = uploadOptions;
        this.$contentType = str;
        this.$bizType = bizType;
        this.$subTargetPath = str2;
        this.$userId = str3;
        this.this$0 = fileUploadService;
        this.$file = file;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fileUploadService$uploadSingleFile$2 = new FileUploadService$uploadSingleFile$2(this.$options, this.$contentType, this.$bizType, this.$subTargetPath, this.$userId, this.this$0, this.$file, continuation);
        fileUploadService$uploadSingleFile$2.L$0 = obj;
        return fileUploadService$uploadSingleFile$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super UploadResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(43:92|(4:94|(2:96|(1:98)(1:256))|257|(1:263))|264|101|102|103|104|(4:(3:249|250|(37:252|(1:108)(1:248)|109|110|(1:112)|113|(1:115)|116|(1:247)(1:120)|(1:122)(1:246)|123|(1:125)|126|(1:128)|129|(1:131)(1:245)|132|(19:137|(1:139)|143|(1:145)(1:243)|146|(1:148)(1:242)|149|150|151|152|153|(1:155)|156|(1:158)(1:238)|159|(1:161)(1:237)|162|164|(7:220|221|(1:223)|224|(3:226|227|228)(1:232)|229|230)(7:166|167|168|(1:170)|(3:172|173|(2:175|(16:180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|(1:196)(14:197|9|10|11|12|13|14|15|16|17|18|(0)|21|22))(7:177|178|179|18|(0)|21|22)))(1:216)|215|(0)(0)))|244|(0)|143|(0)(0)|146|(0)(0)|149|150|151|152|153|(0)|156|(0)(0)|159|(0)(0)|162|164|(0)(0)))|(20:134|137|(0)|143|(0)(0)|146|(0)(0)|149|150|151|152|153|(0)|156|(0)(0)|159|(0)(0)|162|164|(0)(0))|164|(0)(0))|106|(0)(0)|109|110|(0)|113|(0)|116|(1:118)|247|(0)(0)|123|(0)|126|(0)|129|(0)(0)|132|244|(0)|143|(0)(0)|146|(0)(0)|149|150|151|152|153|(0)|156|(0)(0)|159|(0)(0)|162) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x02d3, code lost:
    
        r36 = r2;
        r4 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0476, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0477, code lost:
    
        r9 = kotlin.Result.Companion;
        r0 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x02d0, code lost:
    
        if (r27 == null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x00ec, code lost:
    
        if (r13 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02b7, code lost:
    
        if (r27 == null) goto L86;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x041e A[Catch: all -> 0x0307, TRY_LEAVE, TryCatch #5 {all -> 0x0307, blocks: (B:250:0x02fe, B:118:0x037c, B:134:0x0412, B:139:0x041e), top: B:249:0x02fe }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0582  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0746  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x05a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0796 A[Catch: all -> 0x07c4, TryCatch #2 {all -> 0x07c4, blocks: (B:18:0x078e, B:20:0x0796, B:21:0x07ad, B:179:0x074c), top: B:178:0x074c }] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x051e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x07e4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0821  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0250 A[Catch: all -> 0x07ce, TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x07ce, blocks: (B:68:0x01fa, B:71:0x020f, B:83:0x0250, B:92:0x0290, B:101:0x02db), top: B:67:0x01fa }] */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        Function1<UploadFinishInfo, Unit> function1;
        Function1<UploadFinishInfo, Unit> function12;
        ResourceUploadApi resourceUploadApi;
        long j;
        Object resourceUploadUrl;
        Object obj2;
        boolean z;
        Function3<Integer, Long, Long, Unit> function3;
        String str12;
        boolean z2;
        Function1<UploadFinishInfo, Unit> function13;
        String str13;
        boolean z3;
        boolean shouldUseTobObjectStorePutCompat;
        boolean z4;
        String overrideResourceId;
        String overrideResourceId2;
        String overrideResourceId3;
        String overrideResourceId4;
        ContentChecksums calculateChecksums;
        String buildUploadUrl;
        String str14;
        boolean z5;
        FileUploadService.IObjectStoreApi createObjectStoreApi;
        Object obj3;
        String formatRetrofitHeaders;
        FileUploadService.ObjectStorePutResult objectStorePutResult;
        boolean z6;
        boolean z7;
        long j2;
        long j3;
        long j4;
        String str15;
        long j5;
        ContentChecksums contentChecksums;
        long j6;
        String str16;
        long j7;
        String str17;
        Function1<UploadFinishInfo, Unit> function14;
        ResourceUploadApi resourceUploadApi2;
        CommitResourceUploadResultRequest commitResourceUploadResultRequest;
        Continuation<? super Unit> continuation;
        Object commitResourceUploadResult;
        Object obj4;
        long j8;
        long j9;
        long j10;
        long j11;
        String str18;
        long j12;
        long j13;
        String str19;
        long currentTimeMillis;
        Function1<UploadFinishInfo, Unit> function15;
        String str20;
        long j14;
        String message;
        long j15;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                str = ", error=";
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Function3<Integer, Long, Long, Unit> onProgress = this.$options.getOnProgress();
                Function1<UploadFinishInfo, Unit> onFinish = this.$options.getOnFinish();
                long currentTimeMillis2 = System.currentTimeMillis();
                str2 = "uploadSingleFile commit success: bizType=";
                boolean enableMagic = this.$options.getEnableMagic();
                str3 = "uploadSingleFile commit skipped: bizType=";
                boolean useV2 = this.$options.getUseV2();
                if (enableMagic) {
                    str4 = "uploadSingleFile commit failed: bizType=";
                } else {
                    str4 = "uploadSingleFile commit failed: bizType=";
                    str5 = this.$contentType;
                }
                str5 = "application/octet-stream";
                str6 = ", oid=";
                FLogger fLogger = FLogger.INSTANCE;
                str7 = "uploadSingleFile commit start: bizType=";
                str8 = "Upload failed with status ";
                str9 = "uploadSingleFile put result: bizType=";
                str10 = "uploadSingleFile prepare success: bizType=";
                StringBuilder append = new StringBuilder("uploadSingleFile start: bizType=").append(this.$bizType).append(", subTargetPath=").append(this.$subTargetPath).append(", contentType=").append(this.$contentType).append(", usedContentType=").append(str5).append(", userIdBlank=");
                String str21 = this.$userId;
                fLogger.i(FileUploadService.TAG, append.append(str21 == null || StringsKt.isBlank(str21)).append(", enableMagic=").append(enableMagic).append(", useV2=").append(useV2).toString());
                StringBuilder append2 = new StringBuilder("uploadSingleFile start: bizType=").append(this.$bizType).append(", subTargetPath=").append(this.$subTargetPath).append(", contentType=").append(this.$contentType).append(", usedContentType=").append(str5).append(", userIdBlank=");
                String str22 = this.$userId;
                Log.i(FileUploadService.TAG, append2.append(str22 == null || StringsKt.isBlank(str22)).append(", enableMagic=").append(enableMagic).append(", useV2=").append(useV2).toString());
                try {
                    resourceUploadApi = this.this$0.api;
                    GetResourceUploadUrlRequest getResourceUploadUrlRequest = new GetResourceUploadUrlRequest(CollectionsKt.listOf(this.$subTargetPath), this.$bizType);
                    Continuation<? super GetResourceUploadUrlResponse> continuation2 = (Continuation) this;
                    this.L$0 = coroutineScope;
                    this.L$1 = onProgress;
                    function1 = onFinish;
                    try {
                        this.L$2 = function1;
                        this.L$3 = str5;
                        j = currentTimeMillis2;
                        this.J$0 = j;
                        this.Z$0 = enableMagic;
                        this.Z$1 = useV2;
                        this.label = 1;
                        resourceUploadUrl = resourceUploadApi.getResourceUploadUrl(getResourceUploadUrlRequest, continuation2);
                        obj2 = coroutine_suspended;
                        if (resourceUploadUrl == obj2) {
                            return obj2;
                        }
                        z = useV2;
                        function3 = onProgress;
                        str12 = str5;
                        z2 = enableMagic;
                    } catch (Throwable th) {
                        th = th;
                        str11 = str;
                        function12 = function1;
                        message = th.getMessage();
                        if (message == null) {
                        }
                        FLogger.INSTANCE.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                        Log.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                        if (function12 != null) {
                        }
                        return new UploadResult("", false, message, null, null, 24, null);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str11 = str;
                    function1 = onFinish;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j16 = this.J$3;
                    j9 = this.J$2;
                    j7 = this.J$1;
                    j8 = j16;
                    j6 = this.J$0;
                    contentChecksums = (ContentChecksums) this.L$3;
                    str16 = (String) this.L$2;
                    String str23 = (String) this.L$1;
                    Function1<UploadFinishInfo, Unit> function16 = (Function1) this.L$0;
                    try {
                        try {
                            ResultKt.throwOnFailure(obj);
                            str4 = "uploadSingleFile commit failed: bizType=";
                            str2 = "uploadSingleFile commit success: bizType=";
                            str17 = str23;
                            function14 = function16;
                            str = ", error=";
                            str15 = ", oid=";
                            try {
                                j15 = j6;
                                String str24 = str2;
                                try {
                                    FLogger.INSTANCE.i(FileUploadService.TAG, str24 + this.$bizType + str15 + str17);
                                    Log.i(FileUploadService.TAG, str24 + this.$bizType + str15 + str17);
                                    currentTimeMillis = System.currentTimeMillis() - j9;
                                    function15 = function14;
                                    str20 = str16;
                                    j14 = j8;
                                    str19 = str;
                                    j13 = j15;
                                } catch (Throwable th3) {
                                    th = th3;
                                    j2 = j9;
                                    j4 = j8;
                                    j6 = j15;
                                    try {
                                        long j17 = j6;
                                        String str25 = str4;
                                        str19 = str;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        function12 = function14;
                                        str11 = str;
                                        message = th.getMessage();
                                        if (message == null) {
                                            message = "Unknown upload error";
                                        }
                                        FLogger.INSTANCE.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                                        Log.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                                        if (function12 != null) {
                                            function12.invoke(new UploadFinishInfo(false, UploadStage.Prepare, message, null, 8, null));
                                            Unit unit = Unit.INSTANCE;
                                        }
                                        return new UploadResult("", false, message, null, null, 24, null);
                                    }
                                    try {
                                        long j18 = j4;
                                        FLogger.INSTANCE.w(FileUploadService.TAG, str25 + this.$bizType + str15 + str17 + str19 + th.getMessage(), th);
                                        Log.w(FileUploadService.TAG, str25 + this.$bizType + str15 + str17 + str19 + th.getMessage(), th);
                                        currentTimeMillis = System.currentTimeMillis() - j2;
                                        function15 = function14;
                                        str20 = str16;
                                        j13 = j17;
                                        j14 = j18;
                                        Unit unit2 = Unit.INSTANCE;
                                        j12 = currentTimeMillis;
                                        function13 = function15;
                                        j11 = j7;
                                        calculateChecksums = contentChecksums;
                                        j10 = j14;
                                        str11 = str19;
                                        str18 = str20;
                                        long currentTimeMillis3 = System.currentTimeMillis() - j13;
                                        if (function13 != null) {
                                        }
                                        return new UploadResult(str18, true, null, calculateChecksums.getSha256Hex(), Boxing.boxLong(calculateChecksums.getSizeBytes()), 4, null);
                                    } catch (Throwable th5) {
                                        th = th5;
                                        function12 = function14;
                                        str11 = str19;
                                        message = th.getMessage();
                                        if (message == null) {
                                        }
                                        FLogger.INSTANCE.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                                        Log.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                                        if (function12 != null) {
                                        }
                                        return new UploadResult("", false, message, null, null, 24, null);
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                j2 = j9;
                                j4 = j8;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            j2 = j9;
                            str4 = "uploadSingleFile commit failed: bizType=";
                            j4 = j8;
                            str17 = str23;
                            function14 = function16;
                            str = ", error=";
                            str15 = ", oid=";
                            long j172 = j6;
                            String str252 = str4;
                            str19 = str;
                            long j182 = j4;
                            FLogger.INSTANCE.w(FileUploadService.TAG, str252 + this.$bizType + str15 + str17 + str19 + th.getMessage(), th);
                            Log.w(FileUploadService.TAG, str252 + this.$bizType + str15 + str17 + str19 + th.getMessage(), th);
                            currentTimeMillis = System.currentTimeMillis() - j2;
                            function15 = function14;
                            str20 = str16;
                            j13 = j172;
                            j14 = j182;
                            Unit unit22 = Unit.INSTANCE;
                            j12 = currentTimeMillis;
                            function13 = function15;
                            j11 = j7;
                            calculateChecksums = contentChecksums;
                            j10 = j14;
                            str11 = str19;
                            str18 = str20;
                            long currentTimeMillis32 = System.currentTimeMillis() - j13;
                            if (function13 != null) {
                            }
                            return new UploadResult(str18, true, null, calculateChecksums.getSha256Hex(), Boxing.boxLong(calculateChecksums.getSizeBytes()), 4, null);
                        }
                        Unit unit222 = Unit.INSTANCE;
                        j12 = currentTimeMillis;
                        function13 = function15;
                        j11 = j7;
                        calculateChecksums = contentChecksums;
                        j10 = j14;
                        str11 = str19;
                        str18 = str20;
                        long currentTimeMillis322 = System.currentTimeMillis() - j13;
                        if (function13 != null) {
                            function13.invoke(new UploadFinishInfo(true, null, null, new UploadTimings(j11, j10, j12, currentTimeMillis322), 6, null));
                            Unit unit3 = Unit.INSTANCE;
                        }
                        return new UploadResult(str18, true, null, calculateChecksums.getSha256Hex(), Boxing.boxLong(calculateChecksums.getSizeBytes()), 4, null);
                    } catch (Throwable th8) {
                        th = th8;
                        function12 = function15;
                        str11 = str19;
                        message = th.getMessage();
                        if (message == null) {
                        }
                        FLogger.INSTANCE.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                        Log.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                        if (function12 != null) {
                        }
                        return new UploadResult("", false, message, null, null, 24, null);
                    }
                }
                boolean z8 = this.Z$1;
                boolean z9 = this.Z$0;
                str = ", error=";
                long j19 = this.J$0;
                str12 = (String) this.L$3;
                Function1<UploadFinishInfo, Unit> function17 = (Function1) this.L$2;
                Function3<Integer, Long, Long, Unit> function32 = (Function3) this.L$1;
                try {
                    ResultKt.throwOnFailure(obj);
                    str10 = "uploadSingleFile prepare success: bizType=";
                    str7 = "uploadSingleFile commit start: bizType=";
                    str8 = "Upload failed with status ";
                    str9 = "uploadSingleFile put result: bizType=";
                    obj2 = coroutine_suspended;
                    z = z8;
                    function1 = function17;
                    function3 = function32;
                    resourceUploadUrl = obj;
                    str3 = "uploadSingleFile commit skipped: bizType=";
                    str4 = "uploadSingleFile commit failed: bizType=";
                    str2 = "uploadSingleFile commit success: bizType=";
                    j = j19;
                    str6 = ", oid=";
                    z2 = z9;
                } catch (Throwable th9) {
                    th = th9;
                    str11 = str;
                    function12 = function17;
                    message = th.getMessage();
                    if (message == null) {
                    }
                    FLogger.INSTANCE.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                    Log.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                    if (function12 != null) {
                    }
                    return new UploadResult("", false, message, null, null, 24, null);
                }
            }
            GetResourceUploadUrlResponse getResourceUploadUrlResponse = (GetResourceUploadUrlResponse) resourceUploadUrl;
            List<String> uploadHosts = getResourceUploadUrlResponse.getUploadHosts();
            if (uploadHosts != null) {
                try {
                    str13 = (String) CollectionsKt.firstOrNull(uploadHosts);
                } catch (Throwable th10) {
                    th = th10;
                    function12 = function1;
                    str11 = str;
                    message = th.getMessage();
                    if (message == null) {
                    }
                    FLogger.INSTANCE.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                    Log.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                    if (function12 != null) {
                    }
                    return new UploadResult("", false, message, null, null, 24, null);
                }
            } else {
                str13 = null;
            }
            String str26 = str13;
            if (str26 != null && !StringsKt.isBlank(str26)) {
                z3 = false;
                if (!z3) {
                    if (function1 != null) {
                        function1.invoke(new UploadFinishInfo(false, UploadStage.Prepare, "No upload host found", null, 8, null));
                        Unit unit4 = Unit.INSTANCE;
                    }
                    return new UploadResult("", false, "No upload host found", null, null, 24, null);
                }
                List<StoreInfoItem> storeInfos = getResourceUploadUrlResponse.getStoreInfos();
                StoreInfoItem storeInfoItem = storeInfos != null ? (StoreInfoItem) CollectionsKt.firstOrNull(storeInfos) : null;
                if (storeInfoItem == null) {
                    if (function1 != null) {
                        function1.invoke(new UploadFinishInfo(false, UploadStage.Prepare, "No store info found", null, 8, null));
                        Unit unit5 = Unit.INSTANCE;
                    }
                    return new UploadResult("", false, "No store info found", null, null, 24, null);
                }
                String storeUri = storeInfoItem.getStoreUri();
                String auth = storeInfoItem.getAuth();
                shouldUseTobObjectStorePutCompat = this.this$0.shouldUseTobObjectStorePutCompat();
                if (shouldUseTobObjectStorePutCompat) {
                    String overrideResourceId5 = storeInfoItem.getOverrideResourceId();
                    if (overrideResourceId5 != null) {
                        if (!(!StringsKt.isBlank(overrideResourceId5))) {
                            overrideResourceId5 = null;
                        }
                    }
                    overrideResourceId5 = getResourceUploadUrlResponse.getOverrideResourceId();
                    if (overrideResourceId5 == null || !(!StringsKt.isBlank(overrideResourceId5))) {
                        overrideResourceId5 = null;
                    }
                }
                Object obj5 = obj2;
                String str27 = storeUri;
                FLogger fLogger2 = FLogger.INSTANCE;
                Function1<UploadFinishInfo, Unit> function18 = function1;
                try {
                    String str28 = str10;
                    String str29 = str12;
                    StringBuilder append3 = new StringBuilder(str28).append(this.$bizType).append(", hasSessionKey=");
                    String sessionKey = getResourceUploadUrlResponse.getSessionKey();
                    try {
                        if (sessionKey != null) {
                            try {
                                if (!StringsKt.isBlank(sessionKey)) {
                                    z4 = false;
                                    StringBuilder append4 = append3.append(z4).append(", host=").append(str13).append(", storeUri=").append(storeUri).append(", storeOverrideResourceId=");
                                    overrideResourceId = storeInfoItem.getOverrideResourceId();
                                    if (overrideResourceId == null) {
                                        overrideResourceId = "";
                                    }
                                    StringBuilder append5 = append4.append(overrideResourceId).append(", responseOverrideResourceId=");
                                    overrideResourceId2 = getResourceUploadUrlResponse.getOverrideResourceId();
                                    if (overrideResourceId2 == null) {
                                        overrideResourceId2 = "";
                                    }
                                    fLogger2.i(FileUploadService.TAG, append5.append(overrideResourceId2).append(", resourceId=").append(str27).toString());
                                    StringBuilder append6 = new StringBuilder(str28).append(this.$bizType).append(", hasSessionKey=");
                                    String sessionKey2 = getResourceUploadUrlResponse.getSessionKey();
                                    StringBuilder append7 = append6.append(sessionKey2 != null || StringsKt.isBlank(sessionKey2)).append(", host=").append(str13).append(", storeUri=").append(storeUri).append(", storeOverrideResourceId=");
                                    overrideResourceId3 = storeInfoItem.getOverrideResourceId();
                                    if (overrideResourceId3 == null) {
                                        overrideResourceId3 = "";
                                    }
                                    StringBuilder append8 = append7.append(overrideResourceId3).append(", responseOverrideResourceId=");
                                    overrideResourceId4 = getResourceUploadUrlResponse.getOverrideResourceId();
                                    if (overrideResourceId4 == null) {
                                        overrideResourceId4 = "";
                                    }
                                    Log.i(FileUploadService.TAG, append8.append(overrideResourceId4).append(", resourceId=").append(str27).toString());
                                    calculateChecksums = ResourceUploadUtilKt.calculateChecksums(this.$file, z2, !z);
                                    long currentTimeMillis4 = System.currentTimeMillis();
                                    String str30 = str27;
                                    long j20 = currentTimeMillis4 - j;
                                    buildUploadUrl = this.this$0.buildUploadUrl(str13, storeUri);
                                    String str31 = this.$userId;
                                    Map createMapBuilder = MapsKt.createMapBuilder();
                                    createMapBuilder.put("Authorization", auth);
                                    createMapBuilder.put("Content-CRC32", calculateChecksums.getCrc32Hex());
                                    createMapBuilder.put("Content-Type", str29);
                                    str14 = str31;
                                    if (str14 != null && !StringsKt.isBlank(str14)) {
                                        z5 = false;
                                        if (!z5) {
                                            createMapBuilder.put("X-Storage-U", ResourceUploadUtilKt.urlEncode(str31));
                                        }
                                        Map<String, String> build = MapsKt.build(createMapBuilder);
                                        FileUploadService.FileWithOptionalMagicTypedOutput fileWithOptionalMagicTypedOutput = new FileUploadService.FileWithOptionalMagicTypedOutput(this.$file, str29, z2, !z, calculateChecksums.getSizeBytes(), function3);
                                        createObjectStoreApi = this.this$0.createObjectStoreApi();
                                        SsResponse execute = createObjectStoreApi.put(buildUploadUrl, fileWithOptionalMagicTypedOutput, build, shouldUseTobObjectStorePutCompat).execute();
                                        Intrinsics.checkNotNullExpressionValue(execute, "execute(...)");
                                        int code = execute.code();
                                        boolean isSuccessful = execute.isSuccessful();
                                        Result.Companion companion = Result.Companion;
                                        obj3 = Result.constructor-impl((String) execute.body());
                                        if (Result.isFailure-impl(obj3)) {
                                            obj3 = null;
                                        }
                                        String str32 = (String) obj3;
                                        String str33 = str32 != null ? "" : str32;
                                        FileUploadService fileUploadService = this.this$0;
                                        List headers = execute.headers();
                                        Intrinsics.checkNotNullExpressionValue(headers, "headers(...)");
                                        formatRetrofitHeaders = fileUploadService.formatRetrofitHeaders(headers);
                                        objectStorePutResult = new FileUploadService.ObjectStorePutResult(code, !isSuccessful, null, str33, formatRetrofitHeaders, 4, null);
                                        String str34 = str9;
                                        FLogger.INSTANCE.i(FileUploadService.TAG, str34 + this.$bizType + ", code=" + objectStorePutResult.getCode() + ", isSuccessful=" + objectStorePutResult.isSuccessful());
                                        Log.i(FileUploadService.TAG, str34 + this.$bizType + ", code=" + objectStorePutResult.getCode() + ", isSuccessful=" + objectStorePutResult.isSuccessful());
                                        long currentTimeMillis5 = System.currentTimeMillis();
                                        long j21 = currentTimeMillis5 - currentTimeMillis4;
                                        if (objectStorePutResult.isSuccessful()) {
                                            try {
                                                this.this$0.logPutFailureResponse(this.$bizType, objectStorePutResult);
                                                StringBuilder append9 = new StringBuilder(str8).append(objectStorePutResult.getCode()).append(": ");
                                                String errorText = objectStorePutResult.getErrorText();
                                                if (StringsKt.isBlank(errorText)) {
                                                    errorText = "Unknown error";
                                                }
                                                String sb = append9.append(errorText).toString();
                                                if (function18 != null) {
                                                    function18.invoke(new UploadFinishInfo(false, UploadStage.Upload, sb, null, 8, null));
                                                    Unit unit6 = Unit.INSTANCE;
                                                }
                                                return new UploadResult("", false, sb, null, null, 24, null);
                                            } catch (Throwable th11) {
                                                th = th11;
                                                z2 = function18;
                                                function12 = z2;
                                                str11 = str;
                                                message = th.getMessage();
                                                if (message == null) {
                                                }
                                                FLogger.INSTANCE.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                                                Log.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                                                if (function12 != null) {
                                                }
                                                return new UploadResult("", false, message, null, null, 24, null);
                                            }
                                        }
                                        function13 = function18;
                                        try {
                                            String sessionKey3 = getResourceUploadUrlResponse.getSessionKey();
                                            if (sessionKey3 == null) {
                                                sessionKey3 = "";
                                            }
                                            if (shouldUseTobObjectStorePutCompat) {
                                                z6 = true;
                                            } else {
                                                z6 = true;
                                                if (!(!StringsKt.isBlank(sessionKey3))) {
                                                    z7 = false;
                                                    if (!z7) {
                                                        try {
                                                            String str35 = str7;
                                                            try {
                                                                str15 = str6;
                                                                try {
                                                                    FLogger.INSTANCE.i(FileUploadService.TAG, str35 + this.$bizType + str15 + storeUri + ", sessionKeyBlank=" + StringsKt.isBlank(sessionKey3));
                                                                    Log.i(FileUploadService.TAG, str35 + this.$bizType + str15 + storeUri + ", sessionKeyBlank=" + StringsKt.isBlank(sessionKey3));
                                                                    resourceUploadApi2 = this.this$0.api;
                                                                    commitResourceUploadResultRequest = new CommitResourceUploadResultRequest(CollectionsKt.listOf(storeUri), sessionKey3, this.$bizType);
                                                                    continuation = (Continuation) this;
                                                                    this.L$0 = function13;
                                                                    this.L$1 = storeUri;
                                                                    this.L$2 = str30;
                                                                    this.L$3 = calculateChecksums;
                                                                    this.J$0 = j;
                                                                    j3 = j;
                                                                    j5 = j20;
                                                                    try {
                                                                        this.J$1 = j5;
                                                                        this.J$2 = currentTimeMillis5;
                                                                        j2 = currentTimeMillis5;
                                                                        j4 = j21;
                                                                    } catch (Throwable th12) {
                                                                        th = th12;
                                                                        j2 = currentTimeMillis5;
                                                                        j4 = j21;
                                                                    }
                                                                } catch (Throwable th13) {
                                                                    th = th13;
                                                                    j2 = currentTimeMillis5;
                                                                    j3 = j;
                                                                    j4 = j21;
                                                                    j5 = j20;
                                                                    contentChecksums = calculateChecksums;
                                                                    j6 = j3;
                                                                    str16 = str30;
                                                                    j7 = j5;
                                                                    str17 = storeUri;
                                                                    function14 = function13;
                                                                    long j1722 = j6;
                                                                    String str2522 = str4;
                                                                    str19 = str;
                                                                    long j1822 = j4;
                                                                    FLogger.INSTANCE.w(FileUploadService.TAG, str2522 + this.$bizType + str15 + str17 + str19 + th.getMessage(), th);
                                                                    Log.w(FileUploadService.TAG, str2522 + this.$bizType + str15 + str17 + str19 + th.getMessage(), th);
                                                                    currentTimeMillis = System.currentTimeMillis() - j2;
                                                                    function15 = function14;
                                                                    str20 = str16;
                                                                    j13 = j1722;
                                                                    j14 = j1822;
                                                                    Unit unit2222 = Unit.INSTANCE;
                                                                    j12 = currentTimeMillis;
                                                                    function13 = function15;
                                                                    j11 = j7;
                                                                    calculateChecksums = contentChecksums;
                                                                    j10 = j14;
                                                                    str11 = str19;
                                                                    str18 = str20;
                                                                    long currentTimeMillis3222 = System.currentTimeMillis() - j13;
                                                                    if (function13 != null) {
                                                                    }
                                                                    return new UploadResult(str18, true, null, calculateChecksums.getSha256Hex(), Boxing.boxLong(calculateChecksums.getSizeBytes()), 4, null);
                                                                }
                                                            } catch (Throwable th14) {
                                                                th = th14;
                                                                j2 = currentTimeMillis5;
                                                                j3 = j;
                                                                str15 = str6;
                                                            }
                                                        } catch (Throwable th15) {
                                                            th = th15;
                                                            j2 = currentTimeMillis5;
                                                            j3 = j;
                                                            j4 = j21;
                                                            str15 = str6;
                                                        }
                                                        try {
                                                            this.J$3 = j4;
                                                            this.label = 2;
                                                            commitResourceUploadResult = resourceUploadApi2.commitResourceUploadResult(commitResourceUploadResultRequest, continuation);
                                                            obj4 = obj5;
                                                        } catch (Throwable th16) {
                                                            th = th16;
                                                            contentChecksums = calculateChecksums;
                                                            j6 = j3;
                                                            str16 = str30;
                                                            j7 = j5;
                                                            str17 = storeUri;
                                                            function14 = function13;
                                                            long j17222 = j6;
                                                            String str25222 = str4;
                                                            str19 = str;
                                                            long j18222 = j4;
                                                            FLogger.INSTANCE.w(FileUploadService.TAG, str25222 + this.$bizType + str15 + str17 + str19 + th.getMessage(), th);
                                                            Log.w(FileUploadService.TAG, str25222 + this.$bizType + str15 + str17 + str19 + th.getMessage(), th);
                                                            currentTimeMillis = System.currentTimeMillis() - j2;
                                                            function15 = function14;
                                                            str20 = str16;
                                                            j13 = j17222;
                                                            j14 = j18222;
                                                            Unit unit22222 = Unit.INSTANCE;
                                                            j12 = currentTimeMillis;
                                                            function13 = function15;
                                                            j11 = j7;
                                                            calculateChecksums = contentChecksums;
                                                            j10 = j14;
                                                            str11 = str19;
                                                            str18 = str20;
                                                            long currentTimeMillis32222 = System.currentTimeMillis() - j13;
                                                            if (function13 != null) {
                                                            }
                                                            return new UploadResult(str18, true, null, calculateChecksums.getSha256Hex(), Boxing.boxLong(calculateChecksums.getSizeBytes()), 4, null);
                                                        }
                                                        if (commitResourceUploadResult == obj4) {
                                                            return obj4;
                                                        }
                                                        contentChecksums = calculateChecksums;
                                                        j6 = j3;
                                                        j8 = j4;
                                                        j9 = j2;
                                                        str16 = str30;
                                                        j7 = j5;
                                                        str17 = storeUri;
                                                        function14 = function13;
                                                        j15 = j6;
                                                        String str242 = str2;
                                                        FLogger.INSTANCE.i(FileUploadService.TAG, str242 + this.$bizType + str15 + str17);
                                                        Log.i(FileUploadService.TAG, str242 + this.$bizType + str15 + str17);
                                                        currentTimeMillis = System.currentTimeMillis() - j9;
                                                        function15 = function14;
                                                        str20 = str16;
                                                        j14 = j8;
                                                        str19 = str;
                                                        j13 = j15;
                                                        Unit unit222222 = Unit.INSTANCE;
                                                        j12 = currentTimeMillis;
                                                        function13 = function15;
                                                        j11 = j7;
                                                        calculateChecksums = contentChecksums;
                                                        j10 = j14;
                                                        str11 = str19;
                                                        str18 = str20;
                                                        long currentTimeMillis322222 = System.currentTimeMillis() - j13;
                                                        if (function13 != null) {
                                                        }
                                                        return new UploadResult(str18, true, null, calculateChecksums.getSha256Hex(), Boxing.boxLong(calculateChecksums.getSizeBytes()), 4, null);
                                                    }
                                                    long j22 = j;
                                                    str11 = str;
                                                    try {
                                                        String str36 = str3;
                                                        FLogger.INSTANCE.i(FileUploadService.TAG, str36 + this.$bizType + ", reason=session_key_blank");
                                                        Boxing.boxInt(Log.i(FileUploadService.TAG, str36 + this.$bizType + ", reason=session_key_blank"));
                                                        j10 = j21;
                                                        j11 = j20;
                                                        str18 = str30;
                                                        j12 = 0;
                                                        j13 = j22;
                                                        long currentTimeMillis3222222 = System.currentTimeMillis() - j13;
                                                        if (function13 != null) {
                                                        }
                                                        return new UploadResult(str18, true, null, calculateChecksums.getSha256Hex(), Boxing.boxLong(calculateChecksums.getSizeBytes()), 4, null);
                                                    } catch (Throwable th17) {
                                                        th = th17;
                                                        function12 = function13;
                                                        message = th.getMessage();
                                                        if (message == null) {
                                                        }
                                                        FLogger.INSTANCE.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                                                        Log.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                                                        if (function12 != null) {
                                                        }
                                                        return new UploadResult("", false, message, null, null, 24, null);
                                                    }
                                                }
                                            }
                                            z7 = z6;
                                            if (!z7) {
                                            }
                                        } catch (Throwable th18) {
                                            th = th18;
                                            str11 = str;
                                            function12 = function13;
                                            message = th.getMessage();
                                            if (message == null) {
                                            }
                                            FLogger.INSTANCE.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                                            Log.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                                            if (function12 != null) {
                                            }
                                            return new UploadResult("", false, message, null, null, 24, null);
                                        }
                                    }
                                    z5 = true;
                                    if (!z5) {
                                    }
                                    Map<String, String> build2 = MapsKt.build(createMapBuilder);
                                    FileUploadService.FileWithOptionalMagicTypedOutput fileWithOptionalMagicTypedOutput2 = new FileUploadService.FileWithOptionalMagicTypedOutput(this.$file, str29, z2, !z, calculateChecksums.getSizeBytes(), function3);
                                    createObjectStoreApi = this.this$0.createObjectStoreApi();
                                    SsResponse execute2 = createObjectStoreApi.put(buildUploadUrl, fileWithOptionalMagicTypedOutput2, build2, shouldUseTobObjectStorePutCompat).execute();
                                    Intrinsics.checkNotNullExpressionValue(execute2, "execute(...)");
                                    int code2 = execute2.code();
                                    boolean isSuccessful2 = execute2.isSuccessful();
                                    Result.Companion companion2 = Result.Companion;
                                    obj3 = Result.constructor-impl((String) execute2.body());
                                    if (Result.isFailure-impl(obj3)) {
                                    }
                                    String str322 = (String) obj3;
                                    if (str322 != null) {
                                    }
                                    FileUploadService fileUploadService2 = this.this$0;
                                    List headers2 = execute2.headers();
                                    Intrinsics.checkNotNullExpressionValue(headers2, "headers(...)");
                                    formatRetrofitHeaders = fileUploadService2.formatRetrofitHeaders(headers2);
                                    objectStorePutResult = new FileUploadService.ObjectStorePutResult(code2, !isSuccessful2, null, str33, formatRetrofitHeaders, 4, null);
                                    String str342 = str9;
                                    FLogger.INSTANCE.i(FileUploadService.TAG, str342 + this.$bizType + ", code=" + objectStorePutResult.getCode() + ", isSuccessful=" + objectStorePutResult.isSuccessful());
                                    Log.i(FileUploadService.TAG, str342 + this.$bizType + ", code=" + objectStorePutResult.getCode() + ", isSuccessful=" + objectStorePutResult.isSuccessful());
                                    long currentTimeMillis52 = System.currentTimeMillis();
                                    long j212 = currentTimeMillis52 - currentTimeMillis4;
                                    if (objectStorePutResult.isSuccessful()) {
                                    }
                                }
                            } catch (Throwable th19) {
                                th = th19;
                                str11 = str;
                                function12 = function18;
                                message = th.getMessage();
                                if (message == null) {
                                }
                                FLogger.INSTANCE.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                                Log.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                                if (function12 != null) {
                                }
                                return new UploadResult("", false, message, null, null, 24, null);
                            }
                        }
                        if (str14 != null) {
                            z5 = false;
                            if (!z5) {
                            }
                            Map<String, String> build22 = MapsKt.build(createMapBuilder);
                            FileUploadService.FileWithOptionalMagicTypedOutput fileWithOptionalMagicTypedOutput22 = new FileUploadService.FileWithOptionalMagicTypedOutput(this.$file, str29, z2, !z, calculateChecksums.getSizeBytes(), function3);
                            createObjectStoreApi = this.this$0.createObjectStoreApi();
                            SsResponse execute22 = createObjectStoreApi.put(buildUploadUrl, fileWithOptionalMagicTypedOutput22, build22, shouldUseTobObjectStorePutCompat).execute();
                            Intrinsics.checkNotNullExpressionValue(execute22, "execute(...)");
                            int code22 = execute22.code();
                            boolean isSuccessful22 = execute22.isSuccessful();
                            Result.Companion companion22 = Result.Companion;
                            obj3 = Result.constructor-impl((String) execute22.body());
                            if (Result.isFailure-impl(obj3)) {
                            }
                            String str3222 = (String) obj3;
                            if (str3222 != null) {
                            }
                            FileUploadService fileUploadService22 = this.this$0;
                            List headers22 = execute22.headers();
                            Intrinsics.checkNotNullExpressionValue(headers22, "headers(...)");
                            formatRetrofitHeaders = fileUploadService22.formatRetrofitHeaders(headers22);
                            objectStorePutResult = new FileUploadService.ObjectStorePutResult(code22, !isSuccessful22, null, str33, formatRetrofitHeaders, 4, null);
                            String str3422 = str9;
                            FLogger.INSTANCE.i(FileUploadService.TAG, str3422 + this.$bizType + ", code=" + objectStorePutResult.getCode() + ", isSuccessful=" + objectStorePutResult.isSuccessful());
                            Log.i(FileUploadService.TAG, str3422 + this.$bizType + ", code=" + objectStorePutResult.getCode() + ", isSuccessful=" + objectStorePutResult.isSuccessful());
                            long currentTimeMillis522 = System.currentTimeMillis();
                            long j2122 = currentTimeMillis522 - currentTimeMillis4;
                            if (objectStorePutResult.isSuccessful()) {
                            }
                        }
                        if (objectStorePutResult.isSuccessful()) {
                        }
                    } catch (Throwable th20) {
                        th = th20;
                    }
                    z4 = true;
                    StringBuilder append42 = append3.append(z4).append(", host=").append(str13).append(", storeUri=").append(storeUri).append(", storeOverrideResourceId=");
                    overrideResourceId = storeInfoItem.getOverrideResourceId();
                    if (overrideResourceId == null) {
                    }
                    StringBuilder append52 = append42.append(overrideResourceId).append(", responseOverrideResourceId=");
                    overrideResourceId2 = getResourceUploadUrlResponse.getOverrideResourceId();
                    if (overrideResourceId2 == null) {
                    }
                    fLogger2.i(FileUploadService.TAG, append52.append(overrideResourceId2).append(", resourceId=").append(str27).toString());
                    StringBuilder append62 = new StringBuilder(str28).append(this.$bizType).append(", hasSessionKey=");
                    String sessionKey22 = getResourceUploadUrlResponse.getSessionKey();
                    StringBuilder append72 = append62.append(sessionKey22 != null || StringsKt.isBlank(sessionKey22)).append(", host=").append(str13).append(", storeUri=").append(storeUri).append(", storeOverrideResourceId=");
                    overrideResourceId3 = storeInfoItem.getOverrideResourceId();
                    if (overrideResourceId3 == null) {
                    }
                    StringBuilder append82 = append72.append(overrideResourceId3).append(", responseOverrideResourceId=");
                    overrideResourceId4 = getResourceUploadUrlResponse.getOverrideResourceId();
                    if (overrideResourceId4 == null) {
                    }
                    Log.i(FileUploadService.TAG, append82.append(overrideResourceId4).append(", resourceId=").append(str27).toString());
                    calculateChecksums = ResourceUploadUtilKt.calculateChecksums(this.$file, z2, !z);
                    long currentTimeMillis42 = System.currentTimeMillis();
                    String str302 = str27;
                    long j202 = currentTimeMillis42 - j;
                    buildUploadUrl = this.this$0.buildUploadUrl(str13, storeUri);
                    String str312 = this.$userId;
                    Map createMapBuilder2 = MapsKt.createMapBuilder();
                    createMapBuilder2.put("Authorization", auth);
                    createMapBuilder2.put("Content-CRC32", calculateChecksums.getCrc32Hex());
                    createMapBuilder2.put("Content-Type", str29);
                    str14 = str312;
                    z5 = true;
                    if (!z5) {
                    }
                    Map<String, String> build222 = MapsKt.build(createMapBuilder2);
                    FileUploadService.FileWithOptionalMagicTypedOutput fileWithOptionalMagicTypedOutput222 = new FileUploadService.FileWithOptionalMagicTypedOutput(this.$file, str29, z2, !z, calculateChecksums.getSizeBytes(), function3);
                    createObjectStoreApi = this.this$0.createObjectStoreApi();
                    SsResponse execute222 = createObjectStoreApi.put(buildUploadUrl, fileWithOptionalMagicTypedOutput222, build222, shouldUseTobObjectStorePutCompat).execute();
                    Intrinsics.checkNotNullExpressionValue(execute222, "execute(...)");
                    int code222 = execute222.code();
                    boolean isSuccessful222 = execute222.isSuccessful();
                    Result.Companion companion222 = Result.Companion;
                    obj3 = Result.constructor-impl((String) execute222.body());
                    if (Result.isFailure-impl(obj3)) {
                    }
                    String str32222 = (String) obj3;
                    if (str32222 != null) {
                    }
                    FileUploadService fileUploadService222 = this.this$0;
                    List headers222 = execute222.headers();
                    Intrinsics.checkNotNullExpressionValue(headers222, "headers(...)");
                    formatRetrofitHeaders = fileUploadService222.formatRetrofitHeaders(headers222);
                    objectStorePutResult = new FileUploadService.ObjectStorePutResult(code222, !isSuccessful222, null, str33, formatRetrofitHeaders, 4, null);
                    String str34222 = str9;
                    FLogger.INSTANCE.i(FileUploadService.TAG, str34222 + this.$bizType + ", code=" + objectStorePutResult.getCode() + ", isSuccessful=" + objectStorePutResult.isSuccessful());
                    Log.i(FileUploadService.TAG, str34222 + this.$bizType + ", code=" + objectStorePutResult.getCode() + ", isSuccessful=" + objectStorePutResult.isSuccessful());
                    long currentTimeMillis5222 = System.currentTimeMillis();
                    long j21222 = currentTimeMillis5222 - currentTimeMillis42;
                } catch (Throwable th21) {
                    th = th21;
                    str11 = str;
                    function13 = function18;
                    function12 = function13;
                    message = th.getMessage();
                    if (message == null) {
                    }
                    FLogger.INSTANCE.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                    Log.w(FileUploadService.TAG, "uploadSingleFile failed: bizType=" + this.$bizType + str11 + message, th);
                    if (function12 != null) {
                    }
                    return new UploadResult("", false, message, null, null, 24, null);
                }
            }
            z3 = true;
            if (!z3) {
            }
        } catch (Throwable th22) {
            th = th22;
            function13 = function1;
        }
    }
}
