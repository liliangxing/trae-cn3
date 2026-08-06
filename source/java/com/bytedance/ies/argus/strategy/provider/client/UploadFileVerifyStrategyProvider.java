package com.bytedance.ies.argus.strategy.provider.client;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.argus.api.interfaces.ArgusInitConfig;
import com.bytedance.ies.argus.api.params.AboutToUploadFileParams;
import com.bytedance.ies.argus.api.params.BaseAspectParams;
import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusStrategyProviderType;
import com.bytedance.ies.argus.bean.ArgusUploadFileVerifyReason;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.bean.ContainerStrategyConfig;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider;
import com.bytedance.ies.argus.util.CommonUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: UploadFileVerifyStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0005\u001c\u001d\u001e\u001f B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2 \u0010\t\u001a\u001c0\nR\u0018\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0014\u0010\u001b\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0012H\u0002¨\u0006!"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyProvider;", "()V", "calculate", "", "rule", "Lcom/bytedance/ies/argus/bean/AspectConfigItem$AspectRuleItem;", "strategyConfig", "Lcom/bytedance/ies/argus/bean/ContainerStrategyConfig;", "context", "Lcom/bytedance/ies/argus/bean/AspectContext$CalculateContext;", "Lcom/bytedance/ies/argus/bean/AspectContext;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "checkFileValid", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$FileCheckResult;", "Landroid/content/Context;", "filePath", "", "type", "Lcom/bytedance/ies/argus/bean/ArgusStrategyProviderType;", "shouldBlockByRegex", "", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyConfig;", "idx", "", "enterFrom", "shouldBlockBySessionId", "Companion", "DetectResult", "Detector", "DetectorConfig", "FileCheckResult", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class UploadFileVerifyStrategyProvider extends BaseStrategyProvider {
    private static final int MAX_DETECT_TIMEOUT = 3000;
    private static final String TAG = "UploadFileVerifyStrategyProvider";

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public ArgusStrategyProviderType type() {
        return ArgusStrategyProviderType.UploadFileVerify;
    }

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public void calculate(AspectConfigItem.AspectRuleItem rule, ContainerStrategyConfig strategyConfig, AspectContext<? extends BaseAspectParams<?>, ? extends BaseRewritePayload>.CalculateContext context) {
        boolean z;
        String str;
        ArgusInitConfig.IPassportDepend passportDepend;
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(context, "context");
        BaseAspectParams<?> callerParams = context.getCallerParams();
        AspectVerifyResult<? extends BaseRewritePayload> verifyResult = context.getVerifyResult();
        if (!(callerParams instanceof AboutToUploadFileParams)) {
            AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.MISMATCH_PARAMS_TYPE, null, null, 6, null);
            return;
        }
        UploadFileVerifyStrategyConfig uploadFileVerifyStrategyConfig = strategyConfig != null ? strategyConfig.getUploadFileVerifyStrategyConfig() : null;
        if (uploadFileVerifyStrategyConfig == null) {
            AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.STRATEGY_CONFIG_IS_NULL, null, null, 6, null);
            return;
        }
        AboutToUploadFileParams aboutToUploadFileParams = (AboutToUploadFileParams) callerParams;
        String filePath = aboutToUploadFileParams.getFilePath();
        String enterFrom = aboutToUploadFileParams.getEnterFrom();
        List<String> skipDetectPathList = uploadFileVerifyStrategyConfig.getSkipDetectPathList();
        if (skipDetectPathList == null) {
            skipDetectPathList = CollectionsKt.emptyList();
        }
        List<String> list = skipDetectPathList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (CommonUtils.INSTANCE.matchReg(filePath, (String) it.next())) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            AspectVerifyResult.onPass$default(verifyResult, ArgusUploadFileVerifyReason.FILE_PATH_IN_SKIP_LIST, null, null, 6, null);
            return;
        }
        Application application = ArgusEnv.INSTANCE.getInstance().getApplication();
        if (application == null) {
            AspectVerifyResult.onError$default(verifyResult, ArgusUploadFileVerifyReason.APPLICATION_IS_NULL, null, null, 6, null);
            return;
        }
        FileCheckResult checkFileValid = checkFileValid(application, filePath);
        verifyResult.addExtra("file_can_read", Boolean.valueOf(checkFileValid.getCanRead()));
        Long fileSizeInKB = checkFileValid.getFileSizeInKB();
        verifyResult.addExtra("file_size_in_kb", Long.valueOf(fileSizeInKB != null ? fileSizeInKB.longValue() : -1L));
        if (!checkFileValid.getCanRead()) {
            AspectVerifyResult.onError$default(verifyResult, ArgusUploadFileVerifyReason.FILE_CAN_NOT_READ, null, null, 6, null);
            return;
        }
        Long fileSizeInKB2 = checkFileValid.getFileSizeInKB();
        if (fileSizeInKB2 == null) {
            AspectVerifyResult.onError$default(verifyResult, ArgusUploadFileVerifyReason.CAN_NOT_GET_FILE_SIZE, null, null, 6, null);
            return;
        }
        Integer maxDetectFileSizeInKB = uploadFileVerifyStrategyConfig.getMaxDetectFileSizeInKB();
        int intValue = maxDetectFileSizeInKB != null ? maxDetectFileSizeInKB.intValue() : -1;
        if (intValue > 0 && fileSizeInKB2.longValue() > intValue) {
            AspectVerifyResult.onPass$default(verifyResult, ArgusUploadFileVerifyReason.FILE_SIZE_EXCEED_LIMIT, null, null, 6, null);
            return;
        }
        if (uploadFileVerifyStrategyConfig.getEnableDetectSessionId()) {
            ArgusInitConfig initConfig = ArgusEnv.INSTANCE.getInstance().getInitConfig();
            String sessionId = (initConfig == null || (passportDepend = initConfig.getPassportDepend()) == null) ? null : passportDepend.getSessionId();
            String str2 = sessionId;
            if (str2 == null || str2.length() == 0) {
                AspectVerifyResult.onError$default(verifyResult, ArgusUploadFileVerifyReason.CAN_NOT_GET_SESSION_ID, null, null, 6, null);
                return;
            }
            str = sessionId;
        } else {
            str = null;
        }
        List<RegexConfig> regexConfigList = uploadFileVerifyStrategyConfig.getRegexConfigList();
        if (regexConfigList == null) {
            regexConfigList = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = regexConfigList.iterator();
        while (it2.hasNext()) {
            String pattern = ((RegexConfig) it2.next()).getPattern();
            if (pattern != null) {
                arrayList.add(pattern);
            }
        }
        ArrayList arrayList2 = arrayList;
        DetectResult detectResult = (DetectResult) BuildersKt.runBlocking$default((CoroutineContext) null, new UploadFileVerifyStrategyProvider$calculate$result$1(new Detector(filePath, str, arrayList2, uploadFileVerifyStrategyConfig.getDetectTimeout() != null ? RangesKt.coerceAtMost(r5.intValue(), 3000) : 3000, null, 16, null), application, null), 1, (Object) null);
        if (detectResult instanceof DetectResult.Fixed) {
            if (shouldBlockBySessionId(uploadFileVerifyStrategyConfig, enterFrom)) {
                AspectVerifyResult.onBlock$default(verifyResult, ArgusUploadFileVerifyReason.SESSION_ID_FOUND_MODE_BLOCK, null, null, 6, null);
                return;
            } else {
                AspectVerifyResult.onPass$default(verifyResult, ArgusUploadFileVerifyReason.SESSION_ID_FOUND_MODE_REPORT, null, null, 6, null);
                return;
            }
        }
        if (detectResult instanceof DetectResult.RegexHit) {
            DetectResult.RegexHit regexHit = (DetectResult.RegexHit) detectResult;
            verifyResult.addExtra("regex_hit_index", Integer.valueOf(regexHit.getPatternIndex()));
            String str3 = (String) CollectionsKt.getOrNull(arrayList2, regexHit.getPatternIndex());
            if (str3 == null) {
                str3 = "unknown";
            }
            verifyResult.addExtra("regex_hit_pattern", str3);
            if (shouldBlockByRegex(uploadFileVerifyStrategyConfig, regexHit.getPatternIndex(), enterFrom)) {
                AspectVerifyResult.onBlock$default(verifyResult, ArgusUploadFileVerifyReason.REGEX_HIT_MODE_BLOCK, null, null, 6, null);
                return;
            } else {
                AspectVerifyResult.onPass$default(verifyResult, ArgusUploadFileVerifyReason.REGEX_HIT_MODE_REPORT, null, null, 6, null);
                return;
            }
        }
        if (detectResult instanceof DetectResult.None) {
            AspectVerifyResult.onPass$default(verifyResult, ArgusUploadFileVerifyReason.FILE_MATCH_NOTHING, null, null, 6, null);
            return;
        }
        if (detectResult instanceof DetectResult.Timeout) {
            AspectVerifyResult.onPass$default(verifyResult, ArgusUploadFileVerifyReason.FILE_DETECT_TIMEOUT, null, null, 6, null);
        } else if (detectResult instanceof DetectResult.Error) {
            AspectVerifyResult.onError$default(verifyResult, ArgusUploadFileVerifyReason.UNEXPECTED_DETECT_RESULT, "errMsg: " + ((DetectResult.Error) detectResult).getReason().getMessage(), null, 4, null);
        } else {
            AspectVerifyResult.onError$default(verifyResult, ArgusUploadFileVerifyReason.UNEXPECTED_DETECT_RESULT, "errMsg: unknown", null, 4, null);
        }
    }

    private final boolean shouldBlockByRegex(UploadFileVerifyStrategyConfig uploadFileVerifyStrategyConfig, int i, String str) {
        RegexConfig regexConfig;
        List<String> blockEntryList;
        List<RegexConfig> regexConfigList = uploadFileVerifyStrategyConfig.getRegexConfigList();
        return (regexConfigList == null || (regexConfig = (RegexConfig) CollectionsKt.getOrNull(regexConfigList, i)) == null || (blockEntryList = regexConfig.getBlockEntryList()) == null || !blockEntryList.contains(str)) ? false : true;
    }

    private final boolean shouldBlockBySessionId(UploadFileVerifyStrategyConfig uploadFileVerifyStrategyConfig, String str) {
        List<String> sessionIdBlockEntryList = uploadFileVerifyStrategyConfig.getSessionIdBlockEntryList();
        return sessionIdBlockEntryList != null && sessionIdBlockEntryList.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UploadFileVerifyStrategyProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$FileCheckResult;", "", "canRead", "", "fileSizeInKB", "", "(ZLjava/lang/Long;)V", "getCanRead", "()Z", "getFileSizeInKB", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(ZLjava/lang/Long;)Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$FileCheckResult;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final /* data */ class FileCheckResult {
        private final boolean canRead;
        private final Long fileSizeInKB;

        public static /* synthetic */ FileCheckResult copy$default(FileCheckResult fileCheckResult, boolean z, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                z = fileCheckResult.canRead;
            }
            if ((i & 2) != 0) {
                l = fileCheckResult.fileSizeInKB;
            }
            return fileCheckResult.copy(z, l);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getCanRead() {
            return this.canRead;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getFileSizeInKB() {
            return this.fileSizeInKB;
        }

        public final FileCheckResult copy(boolean canRead, Long fileSizeInKB) {
            return new FileCheckResult(canRead, fileSizeInKB);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileCheckResult)) {
                return false;
            }
            FileCheckResult fileCheckResult = (FileCheckResult) other;
            return this.canRead == fileCheckResult.canRead && Intrinsics.areEqual(this.fileSizeInKB, fileCheckResult.fileSizeInKB);
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.canRead) * 31;
            Long l = this.fileSizeInKB;
            return hashCode + (l == null ? 0 : l.hashCode());
        }

        public String toString() {
            return "FileCheckResult(canRead=" + this.canRead + ", fileSizeInKB=" + this.fileSizeInKB + ')';
        }

        public FileCheckResult(boolean z, Long l) {
            this.canRead = z;
            this.fileSizeInKB = l;
        }

        public /* synthetic */ FileCheckResult(boolean z, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? null : l);
        }

        public final boolean getCanRead() {
            return this.canRead;
        }

        public final Long getFileSizeInKB() {
            return this.fileSizeInKB;
        }
    }

    /* compiled from: UploadFileVerifyStrategyProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult;", "", "()V", "Error", "Fixed", "None", "RegexHit", "Timeout", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult$Error;", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult$Fixed;", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult$None;", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult$RegexHit;", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult$Timeout;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static abstract class DetectResult {
        public /* synthetic */ DetectResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: UploadFileVerifyStrategyProvider.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult$Fixed;", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult;", "startByte", "", "endByte", "(JJ)V", "getEndByte", "()J", "getStartByte", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static final /* data */ class Fixed extends DetectResult {
            private final long endByte;
            private final long startByte;

            public static /* synthetic */ Fixed copy$default(Fixed fixed, long j, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = fixed.startByte;
                }
                if ((i & 2) != 0) {
                    j2 = fixed.endByte;
                }
                return fixed.copy(j, j2);
            }

            /* renamed from: component1, reason: from getter */
            public final long getStartByte() {
                return this.startByte;
            }

            /* renamed from: component2, reason: from getter */
            public final long getEndByte() {
                return this.endByte;
            }

            public final Fixed copy(long startByte, long endByte) {
                return new Fixed(startByte, endByte);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Fixed)) {
                    return false;
                }
                Fixed fixed = (Fixed) other;
                return this.startByte == fixed.startByte && this.endByte == fixed.endByte;
            }

            public int hashCode() {
                return (Long.hashCode(this.startByte) * 31) + Long.hashCode(this.endByte);
            }

            public String toString() {
                return "Fixed(startByte=" + this.startByte + ", endByte=" + this.endByte + ')';
            }

            public Fixed(long j, long j2) {
                super(null);
                this.startByte = j;
                this.endByte = j2;
            }

            public final long getEndByte() {
                return this.endByte;
            }

            public final long getStartByte() {
                return this.startByte;
            }
        }

        private DetectResult() {
        }

        /* compiled from: UploadFileVerifyStrategyProvider.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult$RegexHit;", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult;", "patternIndex", "", "matchText", "", "(ILjava/lang/String;)V", "getMatchText", "()Ljava/lang/String;", "getPatternIndex", "()I", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static final /* data */ class RegexHit extends DetectResult {
            private final String matchText;
            private final int patternIndex;

            public static /* synthetic */ RegexHit copy$default(RegexHit regexHit, int i, String str, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = regexHit.patternIndex;
                }
                if ((i2 & 2) != 0) {
                    str = regexHit.matchText;
                }
                return regexHit.copy(i, str);
            }

            /* renamed from: component1, reason: from getter */
            public final int getPatternIndex() {
                return this.patternIndex;
            }

            /* renamed from: component2, reason: from getter */
            public final String getMatchText() {
                return this.matchText;
            }

            public final RegexHit copy(int patternIndex, String matchText) {
                Intrinsics.checkNotNullParameter(matchText, "matchText");
                return new RegexHit(patternIndex, matchText);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RegexHit)) {
                    return false;
                }
                RegexHit regexHit = (RegexHit) other;
                return this.patternIndex == regexHit.patternIndex && Intrinsics.areEqual(this.matchText, regexHit.matchText);
            }

            public int hashCode() {
                return (Integer.hashCode(this.patternIndex) * 31) + this.matchText.hashCode();
            }

            public String toString() {
                return "RegexHit(patternIndex=" + this.patternIndex + ", matchText=" + this.matchText + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RegexHit(int i, String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "matchText");
                this.patternIndex = i;
                this.matchText = str;
            }

            public final String getMatchText() {
                return this.matchText;
            }

            public final int getPatternIndex() {
                return this.patternIndex;
            }
        }

        /* compiled from: UploadFileVerifyStrategyProvider.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult$None;", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult;", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static final class None extends DetectResult {
            public static final None INSTANCE = new None();

            private None() {
                super(null);
            }
        }

        /* compiled from: UploadFileVerifyStrategyProvider.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult$Timeout;", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult;", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static final class Timeout extends DetectResult {
            public static final Timeout INSTANCE = new Timeout();

            private Timeout() {
                super(null);
            }
        }

        /* compiled from: UploadFileVerifyStrategyProvider.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult$Error;", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult;", "reason", "", "(Ljava/lang/Throwable;)V", "getReason", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static final /* data */ class Error extends DetectResult {
            private final Throwable reason;

            public static /* synthetic */ Error copy$default(Error error, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    th = error.reason;
                }
                return error.copy(th);
            }

            /* renamed from: component1, reason: from getter */
            public final Throwable getReason() {
                return this.reason;
            }

            public final Error copy(Throwable reason) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                return new Error(reason);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && Intrinsics.areEqual(this.reason, ((Error) other).reason);
            }

            public int hashCode() {
                return this.reason.hashCode();
            }

            public String toString() {
                return "Error(reason=" + this.reason + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(Throwable th) {
                super(null);
                Intrinsics.checkNotNullParameter(th, "reason");
                this.reason = th;
            }

            public final Throwable getReason() {
                return this.reason;
            }
        }
    }

    /* compiled from: UploadFileVerifyStrategyProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectorConfig;", "", "ioBufferBytes", "", "regexWindowChars", "regexOverlapChars", "(III)V", "getIoBufferBytes", "()I", "getRegexOverlapChars", "getRegexWindowChars", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final /* data */ class DetectorConfig {
        private final int ioBufferBytes;
        private final int regexOverlapChars;
        private final int regexWindowChars;

        public DetectorConfig() {
            this(0, 0, 0, 7, null);
        }

        public static /* synthetic */ DetectorConfig copy$default(DetectorConfig detectorConfig, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = detectorConfig.ioBufferBytes;
            }
            if ((i4 & 2) != 0) {
                i2 = detectorConfig.regexWindowChars;
            }
            if ((i4 & 4) != 0) {
                i3 = detectorConfig.regexOverlapChars;
            }
            return detectorConfig.copy(i, i2, i3);
        }

        /* renamed from: component1, reason: from getter */
        public final int getIoBufferBytes() {
            return this.ioBufferBytes;
        }

        /* renamed from: component2, reason: from getter */
        public final int getRegexWindowChars() {
            return this.regexWindowChars;
        }

        /* renamed from: component3, reason: from getter */
        public final int getRegexOverlapChars() {
            return this.regexOverlapChars;
        }

        public final DetectorConfig copy(int ioBufferBytes, int regexWindowChars, int regexOverlapChars) {
            return new DetectorConfig(ioBufferBytes, regexWindowChars, regexOverlapChars);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DetectorConfig)) {
                return false;
            }
            DetectorConfig detectorConfig = (DetectorConfig) other;
            return this.ioBufferBytes == detectorConfig.ioBufferBytes && this.regexWindowChars == detectorConfig.regexWindowChars && this.regexOverlapChars == detectorConfig.regexOverlapChars;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.ioBufferBytes) * 31) + Integer.hashCode(this.regexWindowChars)) * 31) + Integer.hashCode(this.regexOverlapChars);
        }

        public String toString() {
            return "DetectorConfig(ioBufferBytes=" + this.ioBufferBytes + ", regexWindowChars=" + this.regexWindowChars + ", regexOverlapChars=" + this.regexOverlapChars + ')';
        }

        public DetectorConfig(int i, int i2, int i3) {
            this.ioBufferBytes = i;
            this.regexWindowChars = i2;
            this.regexOverlapChars = i3;
        }

        public /* synthetic */ DetectorConfig(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 65536 : i, (i4 & 2) != 0 ? 65536 : i2, (i4 & 4) != 0 ? 1024 : i3);
        }

        public final int getIoBufferBytes() {
            return this.ioBufferBytes;
        }

        public final int getRegexWindowChars() {
            return this.regexWindowChars;
        }

        public final int getRegexOverlapChars() {
            return this.regexOverlapChars;
        }
    }

    /* compiled from: UploadFileVerifyStrategyProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003J \u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J2\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0011H\u0002J\u0014\u0010)\u001a\u0004\u0018\u00010\u0014*\u00020*2\u0006\u0010+\u001a\u00020\u001bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$Detector;", "", "filePath", "", "fixedPattern", "regPatternList", "", "timeout", "", "config", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectorConfig;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JLcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectorConfig;)V", "asciiLowerInPlace", "", "buf", "", "off", "", "len", "detectFile", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractAscii", "bytes", "getInputStream", "Ljava/io/InputStream;", "indexOf", "data", "length", "target", "matchRegexFirst", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult$RegexHit;", "text", "", "start", TraceStatsConsts.STATS_KEY_END, "pattern", "Ljava/util/regex/Pattern;", "groupCount", "detectFileInner", "Lkotlinx/coroutines/CoroutineScope;", "ins", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Detector {
        private final DetectorConfig config;
        private final String filePath;
        private final String fixedPattern;
        private final List<String> regPatternList;
        private final long timeout;

        public Detector(String str, String str2, List<String> list, long j, DetectorConfig detectorConfig) {
            Intrinsics.checkNotNullParameter(str, "filePath");
            Intrinsics.checkNotNullParameter(detectorConfig, "config");
            this.filePath = str;
            this.fixedPattern = str2;
            this.regPatternList = list;
            this.timeout = j;
            this.config = detectorConfig;
        }

        public /* synthetic */ Detector(String str, String str2, List list, long j, DetectorConfig detectorConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, list, j, (i & 16) != 0 ? new DetectorConfig(0, 0, 0, 7, null) : detectorConfig);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
        /* JADX WARN: Type inference failed for: r9v0, types: [android.content.Context] */
        /* JADX WARN: Type inference failed for: r9v1, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r9v4 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object detectFile(Context context, Continuation<? super DetectResult> continuation) {
            UploadFileVerifyStrategyProvider$Detector$detectFile$1 uploadFileVerifyStrategyProvider$Detector$detectFile$1;
            int i;
            Closeable closeable;
            Exception e;
            DetectResult.Error error;
            try {
                if (continuation instanceof UploadFileVerifyStrategyProvider$Detector$detectFile$1) {
                    uploadFileVerifyStrategyProvider$Detector$detectFile$1 = (UploadFileVerifyStrategyProvider$Detector$detectFile$1) continuation;
                    if ((uploadFileVerifyStrategyProvider$Detector$detectFile$1.label & Integer.MIN_VALUE) != 0) {
                        uploadFileVerifyStrategyProvider$Detector$detectFile$1.label -= Integer.MIN_VALUE;
                        Object obj = uploadFileVerifyStrategyProvider$Detector$detectFile$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = uploadFileVerifyStrategyProvider$Detector$detectFile$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            InputStream inputStream = getInputStream(context, this.filePath);
                            if (inputStream == null) {
                                return null;
                            }
                            InputStream inputStream2 = inputStream;
                            try {
                                InputStream inputStream3 = inputStream2;
                                try {
                                    long j = this.timeout;
                                    UploadFileVerifyStrategyProvider$Detector$detectFile$2$1 uploadFileVerifyStrategyProvider$Detector$detectFile$2$1 = new UploadFileVerifyStrategyProvider$Detector$detectFile$2$1(this, inputStream, null);
                                    uploadFileVerifyStrategyProvider$Detector$detectFile$1.L$0 = inputStream2;
                                    uploadFileVerifyStrategyProvider$Detector$detectFile$1.label = 1;
                                    Object withTimeout = TimeoutKt.withTimeout(j, uploadFileVerifyStrategyProvider$Detector$detectFile$2$1, uploadFileVerifyStrategyProvider$Detector$detectFile$1);
                                    if (withTimeout == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj = withTimeout;
                                    closeable = inputStream2;
                                } catch (Exception e2) {
                                    e = e2;
                                    closeable = inputStream2;
                                    error = new DetectResult.Error(e);
                                    CloseableKt.closeFinally(closeable, (Throwable) null);
                                    return error;
                                } catch (TimeoutCancellationException unused) {
                                    closeable = inputStream2;
                                    error = DetectResult.Timeout.INSTANCE;
                                    CloseableKt.closeFinally(closeable, (Throwable) null);
                                    return error;
                                }
                            } catch (Throwable th) {
                                th = th;
                                context = inputStream2;
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    CloseableKt.closeFinally((Closeable) context, th);
                                    throw th2;
                                }
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            closeable = (Closeable) uploadFileVerifyStrategyProvider$Detector$detectFile$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                            } catch (TimeoutCancellationException unused2) {
                                error = DetectResult.Timeout.INSTANCE;
                                CloseableKt.closeFinally(closeable, (Throwable) null);
                                return error;
                            } catch (Exception e3) {
                                e = e3;
                                error = new DetectResult.Error(e);
                                CloseableKt.closeFinally(closeable, (Throwable) null);
                                return error;
                            }
                        }
                        error = (DetectResult) obj;
                        CloseableKt.closeFinally(closeable, (Throwable) null);
                        return error;
                    }
                }
                if (i != 0) {
                }
                error = (DetectResult) obj;
                CloseableKt.closeFinally(closeable, (Throwable) null);
                return error;
            } catch (Throwable th3) {
                th = th3;
            }
            uploadFileVerifyStrategyProvider$Detector$detectFile$1 = new UploadFileVerifyStrategyProvider$Detector$detectFile$1(this, continuation);
            Object obj2 = uploadFileVerifyStrategyProvider$Detector$detectFile$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = uploadFileVerifyStrategyProvider$Detector$detectFile$1.label;
        }

        /* JADX WARN: Removed duplicated region for block: B:65:0x0190  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x019e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final DetectResult detectFileInner(CoroutineScope coroutineScope, InputStream inputStream) {
            byte[] bArr;
            int i;
            Pattern pattern;
            int i2;
            int i3;
            StringBuilder sb;
            int i4;
            Detector detector = this;
            Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
            Intrinsics.checkNotNullParameter(inputStream, "ins");
            String str = detector.fixedPattern;
            int i5 = 0;
            boolean z = !(str == null || str.length() == 0);
            List<String> list = detector.regPatternList;
            boolean z2 = !(list == null || list.isEmpty());
            if (!z && !z2) {
                return DetectResult.None.INSTANCE;
            }
            if (z) {
                String str2 = detector.fixedPattern;
                Intrinsics.checkNotNull(str2);
                Locale locale = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                if (str2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = str2.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                Charset charset = Charsets.UTF_8;
                if (lowerCase == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                byte[] bytes = lowerCase.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                int length = bytes.length;
                if (length == 0) {
                    return DetectResult.None.INSTANCE;
                }
                bArr = bytes;
                i = length;
            } else {
                bArr = new byte[0];
                i = 0;
            }
            if (z2) {
                StringBuilder sb2 = new StringBuilder();
                List<String> list2 = detector.regPatternList;
                Intrinsics.checkNotNull(list2);
                int i6 = 0;
                for (Object obj : list2) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    String str3 = (String) obj;
                    if (i6 > 0) {
                        sb2.append("|");
                    }
                    sb2.append("((?:").append(str3).append("))");
                    i6 = i7;
                }
                pattern = Pattern.compile(sb2.toString(), 2);
            } else {
                pattern = null;
            }
            Pattern pattern2 = pattern;
            byte[] bArr2 = new byte[detector.config.getIoBufferBytes() + (z ? RangesKt.coerceAtLeast(i - 1, 0) : 0)];
            StringBuilder sb3 = new StringBuilder(detector.config.getRegexWindowChars() + detector.config.getRegexOverlapChars() + 8);
            long j = 0;
            int i8 = 0;
            while (true) {
                CoroutineScopeKt.ensureActive(coroutineScope);
                int read = inputStream.read(bArr2, i8, detector.config.getIoBufferBytes());
                if (read <= 0) {
                    return DetectResult.None.INSTANCE;
                }
                int i9 = i8 + read;
                if (z) {
                    detector.asciiLowerInPlace(bArr2, i5, i9);
                    int indexOf = detector.indexOf(bArr2, i9, bArr);
                    if (indexOf >= 0) {
                        long j2 = (j - i8) + indexOf;
                        return new DetectResult.Fixed(j2, i + j2);
                    }
                }
                if (z2 && pattern2 != null) {
                    String extractAscii = detector.extractAscii(bArr2, i5, i9);
                    sb3.append(extractAscii);
                    int regexWindowChars = detector.config.getRegexWindowChars() + detector.config.getRegexOverlapChars();
                    if (sb3.length() > regexWindowChars) {
                        sb3.delete(i5, sb3.length() - regexWindowChars);
                    }
                    int coerceAtLeast = RangesKt.coerceAtLeast(sb3.length() - (extractAscii.length() + detector.config.getRegexOverlapChars()), i5);
                    int length2 = sb3.length();
                    if (coerceAtLeast < length2) {
                        List<String> list3 = detector.regPatternList;
                        Intrinsics.checkNotNull(list3);
                        i2 = i9;
                        i3 = read;
                        sb = sb3;
                        DetectResult.RegexHit matchRegexFirst = matchRegexFirst(sb3, coerceAtLeast, length2, pattern2, list3.size());
                        if (matchRegexFirst != null) {
                            return matchRegexFirst;
                        }
                        if (z) {
                            i4 = 0;
                            i8 = 0;
                        } else {
                            i8 = i - 1;
                            if (i2 >= i8) {
                                i4 = 0;
                                System.arraycopy(bArr2, i2 - i8, bArr2, 0, i8);
                            } else {
                                i4 = 0;
                                i8 = i2;
                            }
                        }
                        j += i3;
                        detector = this;
                        i5 = i4;
                        sb3 = sb;
                    }
                }
                i2 = i9;
                i3 = read;
                sb = sb3;
                if (z) {
                }
                j += i3;
                detector = this;
                i5 = i4;
                sb3 = sb;
            }
        }

        private final int indexOf(byte[] data, int length, byte[] target) {
            int i;
            int length2 = target.length;
            if (length2 != 0 && (i = length - length2) >= 0) {
                int i2 = 0;
                while (true) {
                    for (int i3 = 0; i3 < length2; i3++) {
                        if (data[i2 + i3] != target[i3]) {
                            if (i2 == i) {
                                break;
                            }
                            i2++;
                        }
                    }
                    return i2;
                }
            }
            return -1;
        }

        private final void asciiLowerInPlace(byte[] buf, int off, int len) {
            for (int i = 0; i < len; i++) {
                int i2 = off + i;
                byte b = buf[i2];
                if (65 <= b && b < 91) {
                    buf[i2] = (byte) (b + 32);
                }
            }
        }

        private final String extractAscii(byte[] bytes, int off, int len) {
            StringBuilder sb = new StringBuilder(len);
            for (int i = 0; i < len; i++) {
                char c = (char) (bytes[off + i] & 255);
                if ((' ' <= c && c < 127) || c == '\n' || c == '\r' || c == '\t') {
                    sb.append(c);
                } else {
                    sb.append(' ');
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
            return sb2;
        }

        private final DetectResult.RegexHit matchRegexFirst(CharSequence text, int start, int end, Pattern pattern, int groupCount) {
            Matcher matcher = pattern.matcher(text);
            matcher.region(start, end);
            if (!matcher.find() || 1 > groupCount) {
                return null;
            }
            int i = 1;
            while (matcher.group(i) == null) {
                if (i == groupCount) {
                    return null;
                }
                i++;
            }
            String group = matcher.group(0);
            Intrinsics.checkNotNullExpressionValue(group, "m.group(0)");
            return new DetectResult.RegexHit(i - 1, group);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x003b A[Catch: Exception -> 0x006c, TryCatch #0 {Exception -> 0x006c, blocks: (B:3:0x000b, B:5:0x001e, B:10:0x002a, B:13:0x0033, B:15:0x003b, B:20:0x0045, B:23:0x004c, B:25:0x0057, B:27:0x005d, B:31:0x0064), top: B:2:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x006c A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x004b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x004c A[Catch: Exception -> 0x006c, TryCatch #0 {Exception -> 0x006c, blocks: (B:3:0x000b, B:5:0x001e, B:10:0x002a, B:13:0x0033, B:15:0x003b, B:20:0x0045, B:23:0x004c, B:25:0x0057, B:27:0x005d, B:31:0x0064), top: B:2:0x000b }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final InputStream getInputStream(Context context, String filePath) {
            boolean z;
            String path;
            FileInputStream fileInputStream;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            try {
                Uri parse = Uri.parse(filePath);
                Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
                String scheme = parse.getScheme();
                String str = scheme;
                if (str != null && str.length() != 0) {
                    z = false;
                    if (!z && !StringsKt.equals("file", scheme, true)) {
                        if (StringsKt.equals("content", scheme, true)) {
                            return null;
                        }
                        fileInputStream = context.getContentResolver().openInputStream(parse);
                        return fileInputStream;
                    }
                    path = parse.getPath();
                    if (path != null) {
                        return null;
                    }
                    File file = new File(path);
                    if (file.isFile() && file.exists() && file.canRead()) {
                        fileInputStream = new FileInputStream(file);
                        return fileInputStream;
                    }
                    return null;
                }
                z = true;
                if (!z) {
                    if (StringsKt.equals("content", scheme, true)) {
                    }
                }
                path = parse.getPath();
                if (path != null) {
                }
            } catch (Exception unused) {
                return null;
            }
        }
    }

    private final FileCheckResult checkFileValid(Context context, String filePath) {
        FileInputStream fileInputStream;
        Uri parse = Uri.parse(filePath);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        String scheme = parse.getScheme();
        String str = scheme;
        boolean z = false;
        int i = 2;
        Long l = null;
        if ((str == null || str.length() == 0) || StringsKt.equals("file", scheme, true)) {
            String path = parse.getPath();
            if (path == null) {
                return new FileCheckResult(z, l, i, l);
            }
            File file = new File(path);
            if (!file.exists() || !file.isFile() || !file.canRead()) {
                return new FileCheckResult(z, l, i, l);
            }
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    FileInputStream fileInputStream2 = fileInputStream;
                    FileCheckResult fileCheckResult = new FileCheckResult(true, Long.valueOf(file.length() / 1024));
                    CloseableKt.closeFinally(fileInputStream, (Throwable) null);
                    return fileCheckResult;
                } finally {
                    try {
                        throw th;
                    } finally {
                    }
                }
            } catch (Exception unused) {
                return new FileCheckResult(z, l, i, l);
            }
        }
        if (Intrinsics.areEqual(scheme, "content")) {
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(parse, "r");
                if (openFileDescriptor != null) {
                    fileInputStream = openFileDescriptor;
                    try {
                        FileCheckResult fileCheckResult2 = new FileCheckResult(true, Long.valueOf(fileInputStream.getStatSize() / 1024));
                        CloseableKt.closeFinally(fileInputStream, (Throwable) null);
                        return fileCheckResult2;
                    } finally {
                    }
                }
            } catch (Exception unused2) {
                return new FileCheckResult(z, l, i, l);
            }
        }
        return new FileCheckResult(z, l, i, l);
    }
}
