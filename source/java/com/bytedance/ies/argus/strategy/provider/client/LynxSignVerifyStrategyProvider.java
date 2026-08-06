package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.api.interfaces.ILifeCycleDepend;
import com.bytedance.ies.argus.api.interfaces.IUploadSignFailedLynxDepend;
import com.bytedance.ies.argus.api.params.ArgusResourceLoaderInfo;
import com.bytedance.ies.argus.api.params.LoadTemplateParams;
import com.bytedance.ies.argus.api.params.LynxSignVerifyCallerParams;
import com.bytedance.ies.argus.api.params.SignBlockVersion;
import com.bytedance.ies.argus.api.params.TimestampStatus;
import com.bytedance.ies.argus.aspect.eventCenter.BaseViewContext;
import com.bytedance.ies.argus.aspect.eventCenter.GlobalEventCenter;
import com.bytedance.ies.argus.aspect.eventCenter.LynxViewContext;
import com.bytedance.ies.argus.aspect.helper.TASMFileHelper;
import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusFeId;
import com.bytedance.ies.argus.bean.ArgusLynxSignVerifyReason;
import com.bytedance.ies.argus.bean.ArgusStrategyProviderType;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.bean.ContainerStrategyConfig;
import com.bytedance.ies.argus.bean.TASMEncryptInfo;
import com.bytedance.ies.argus.bean.TASMVerifyType;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import com.bytedance.ies.argus.repository.MonitorConfig;
import com.bytedance.ies.argus.repository.SecuritySettingConfigModel;
import com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import com.bytedance.ies.argus.util.RegUtils;
import com.bytedance.lynx.service.security.LynxSecurityErrorCode;
import com.bytedance.lynx.service.security.LynxSecurityVerificationEntity;
import com.bytedance.sdk.xbridge.cn.auth.PermissionConfigV2Parser;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigBean;
import com.lynx.tasm.service.security.ILynxSecurityService;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: LynxSignVerifyStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\u0010\t\u001a\u000e0\nR\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000bH\u0016J@\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J8\u0010\u0019\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J*\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J&\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J&\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J,\u0010$\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002J\u001c\u0010(\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002J\b\u0010)\u001a\u00020*H\u0016J$\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020'2\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002¨\u0006."}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/LynxSignVerifyStrategyProvider;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyProvider;", "()V", "calculate", "", "rule", "Lcom/bytedance/ies/argus/bean/AspectConfigItem$AspectRuleItem;", "strategyConfig", "Lcom/bytedance/ies/argus/bean/ContainerStrategyConfig;", "context", "Lcom/bytedance/ies/argus/bean/AspectContext$CalculateContext;", "Lcom/bytedance/ies/argus/bean/AspectContext;", "checkLynxFile", "verification", "Lcom/bytedance/lynx/service/security/LynxSecurityVerificationEntity;", "callerParams", "Lcom/bytedance/ies/argus/api/params/LynxSignVerifyCallerParams;", "verifyResult", "Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "lynxContainerConfig", "Lcom/bytedance/ies/argus/strategy/provider/client/LynxSignVerifyConfig;", "realVerifyMode", "", "viewContext", "Lcom/bytedance/ies/argus/aspect/eventCenter/LynxViewContext;", "checkLynxSign", "handleHighRiskUrlDegrade", "highRiskUrlDegradeList", "", "", "handleTimestampVerify", "handleURLDegrade", "isLegacySigned", "", "legacyTasm", "Lcom/bytedance/ies/argus/bean/TASMEncryptInfo;", "legacyCheckLynxSign", "legacyTasmInfo", "originTasm", "", "reportRetrySuccessInfo", "type", "Lcom/bytedance/ies/argus/bean/ArgusStrategyProviderType;", "uploadSignFailedLynxFile", "byteArray", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxSignVerifyStrategyProvider extends BaseStrategyProvider {
    public static final long GLOBAL_SIGN_ID = 0;
    public static final String TAG = "LynxSignVerifyStrategyProvider";

    /* compiled from: LynxSignVerifyStrategyProvider.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LynxSecurityErrorCode.values().length];
            try {
                iArr[LynxSecurityErrorCode.LynxSecurityErrorCodeErrorSign.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LynxSecurityErrorCode.LynxSecurityErrorCodePKNotFound.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LynxSecurityErrorCode.LynxSecurityErrorCodeUnSigned.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public ArgusStrategyProviderType type() {
        return ArgusStrategyProviderType.LynxSignVerify;
    }

    private final boolean isLegacySigned(TASMEncryptInfo legacyTasm) {
        String appId = legacyTasm.getAppId();
        return appId != null && Integer.parseInt(appId) > 0;
    }

    private final void handleURLDegrade(LynxSignVerifyCallerParams callerParams, AspectVerifyResult<?> verifyResult, LynxSignVerifyConfig lynxContainerConfig) {
        boolean z = true;
        callerParams.setDegraded(true);
        List<String> urlDegradeList = lynxContainerConfig != null ? lynxContainerConfig.getUrlDegradeList() : null;
        if (urlDegradeList == null) {
            ArgusLog.e$default(ArgusLog.INSTANCE, TAG, "abnormal pass, url degraded list is null, unsigned file url degrade success", null, null, 12, null);
            AspectVerifyResult.onPass$default(verifyResult, ArgusLynxSignVerifyReason.USE_DEGRAED_BUT_WHITE_LIST_IS_NULL, null, null, 6, null);
            return;
        }
        boolean z2 = !callerParams.getIsSigned();
        String verifyUrl = callerParams.getVerifyUrl();
        List<String> list = urlDegradeList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (RegUtils.INSTANCE.matchReg(verifyUrl, (String) it.next())) {
                    break;
                }
            }
        }
        z = false;
        if (z) {
            if (z2) {
                AspectVerifyResult.onPass$default(verifyResult, ArgusLynxSignVerifyReason.URL_DEGRADE_SUCCESS, "unsigned file url degrade success", null, 4, null);
                return;
            } else {
                AspectVerifyResult.onPass$default(verifyResult, ArgusLynxSignVerifyReason.FORCE_USE_URL_VERIFY_SUCCESS, "origin verify code is " + verifyResult.getReasonCode() + ", url degrade success", null, 4, null);
                return;
            }
        }
        if (z2) {
            AspectVerifyResult.onBlock$default(verifyResult, ArgusLynxSignVerifyReason.URL_DEGRADE_FAILED, "unsigned file url degrade failed, verify url is " + verifyUrl, null, 4, null);
        } else {
            AspectVerifyResult.onBlock$default(verifyResult, ArgusLynxSignVerifyReason.FORCE_USE_URL_VERIFY_FAILED, "origin verify code is " + verifyResult.getReasonCode() + ", url degrade failed, verify url is " + verifyUrl, null, 4, null);
        }
    }

    private final void legacyCheckLynxSign(LynxSignVerifyCallerParams callerParams, TASMEncryptInfo legacyTasmInfo, byte[] originTasm, AspectVerifyResult<?> verifyResult) {
        Long longOrNull;
        Long longOrNull2;
        callerParams.setSignBlockVersion(SignBlockVersion.OLD);
        String appId = legacyTasmInfo.getAppId();
        callerParams.setTasmFeId((appId == null || (longOrNull2 = StringsKt.toLongOrNull(appId)) == null) ? ArgusFeId.NOT_MATCH.getLongValue() : longOrNull2.longValue());
        String appId2 = legacyTasmInfo.getAppId();
        callerParams.setFeId((appId2 == null || (longOrNull = StringsKt.toLongOrNull(appId2)) == null) ? ArgusFeId.NOT_MATCH.getLongValue() : longOrNull.longValue());
        AuthConfigBean authConfig$default = PermissionConfigV2Parser.getAuthConfig$default(PermissionConfigV2Parser.INSTANCE, String.valueOf(callerParams.getTasmFeId()), (String) null, 2, (Object) null);
        if (authConfig$default == null) {
            callerParams.setFeId(ArgusFeId.NO_AUTH_CONFIG.getLongValue());
            AspectVerifyResult.onBlock$default(verifyResult, ArgusLynxSignVerifyReason.NO_CONFIG, callerParams.getTasmFeId() + " pk not found", null, 4, null);
        } else {
            if (legacyTasmInfo.getType() == TASMVerifyType.SIGN) {
                if (TASMFileHelper.INSTANCE.verifyFileBySign(legacyTasmInfo, originTasm, authConfig$default.getPublic_key().getRsa())) {
                    AspectVerifyResult.onPass$default(verifyResult, ArgusLynxSignVerifyReason.SIGN_SUCCESS, callerParams.getTasmFeId() + " legacy sign success", null, 4, null);
                    return;
                } else {
                    callerParams.setFeId(ArgusFeId.SIGN_BUT_VERIFY_ERROR.getLongValue());
                    AspectVerifyResult.onBlock$default(verifyResult, ArgusLynxSignVerifyReason.TASM_SIGN_FAIL, callerParams.getTasmFeId() + " legacy sign failed", null, 4, null);
                    return;
                }
            }
            AspectVerifyResult.onBlock$default(verifyResult, ArgusLynxSignVerifyReason.UN_KNOWN, "legacy unknown sign verify type", null, 4, null);
        }
    }

    private final void checkLynxSign(LynxSecurityVerificationEntity verification, LynxSignVerifyCallerParams callerParams, AspectVerifyResult<?> verifyResult, LynxSignVerifyConfig lynxContainerConfig, LynxViewContext viewContext) {
        LoadTemplateParams templateInfo;
        LoadTemplateParams templateInfo2;
        Boolean disableGlobalPkSign;
        boolean booleanValue = (lynxContainerConfig == null || (disableGlobalPkSign = lynxContainerConfig.getDisableGlobalPkSign()) == null) ? false : disableGlobalPkSign.booleanValue();
        ILynxSecurityService.LynxTasmType tasmType = verification.getTasmType();
        long signId = verification.getSignId();
        String str = null;
        callerParams.setResourceInfo((viewContext == null || (templateInfo2 = viewContext.getTemplateInfo(tasmType)) == null) ? null : templateInfo2.getLoaderInfo());
        if (viewContext != null && (templateInfo = viewContext.getTemplateInfo(tasmType)) != null) {
            str = templateInfo.getEnterFrom();
        }
        callerParams.setEnterFrom(str);
        callerParams.setFeId(signId);
        callerParams.setTasmFeId(signId);
        if (verification.getVerified()) {
            callerParams.setSignBlockVersion(SignBlockVersion.NEW);
            if (signId != 0) {
                AspectVerifyResult.onPass$default(verifyResult, ArgusLynxSignVerifyReason.SIGN_SUCCESS, "biz " + signId + " sign success", null, 4, null);
                return;
            } else if (!booleanValue) {
                AspectVerifyResult.onPass$default(verifyResult, ArgusLynxSignVerifyReason.SIGN_SUCCESS, "global pk sign verify success", null, 4, null);
                return;
            } else {
                AspectVerifyResult.onBlock$default(verifyResult, ArgusLynxSignVerifyReason.DISABLE_GLOBAL_SIGN, "global sign success but disable", null, 4, null);
                return;
            }
        }
        LynxSecurityErrorCode errorCode = verification.getErrorCode();
        int i = errorCode == null ? -1 : WhenMappings.$EnumSwitchMapping$0[errorCode.ordinal()];
        if (i == 1) {
            callerParams.setSignBlockVersion(SignBlockVersion.NEW);
            callerParams.setFeId(ArgusFeId.SIGN_BUT_VERIFY_ERROR.getLongValue());
            AspectVerifyResult.onBlock$default(verifyResult, ArgusLynxSignVerifyReason.TASM_SIGN_FAIL, "sign id " + signId + ", new block sign failed", null, 4, null);
            return;
        }
        if (i == 2) {
            callerParams.setSignBlockVersion(SignBlockVersion.NEW);
            callerParams.setFeId(ArgusFeId.NO_AUTH_CONFIG.getLongValue());
            AspectVerifyResult.onBlock$default(verifyResult, ArgusLynxSignVerifyReason.NO_CONFIG, "feId: " + signId + " pk not found", null, 4, null);
        } else {
            if (i == 3) {
                byte[] originTasm = verification.getOriginTasm();
                TASMEncryptInfo parse = TASMFileHelper.INSTANCE.parse(originTasm);
                if (parse == null) {
                    AspectVerifyResult.onBlock$default(verifyResult, ArgusLynxSignVerifyReason.TASM_PARSE_FAILED, "parse tasm failed", null, 4, null);
                    return;
                } else if (!isLegacySigned(parse)) {
                    callerParams.setSigned(false);
                    return;
                } else {
                    legacyCheckLynxSign(callerParams, parse, originTasm, verifyResult);
                    return;
                }
            }
            AspectVerifyResult.onError$default(verifyResult, ArgusLynxSignVerifyReason.UN_KNOWN, "unknown error code: " + verification.getErrorCode(), null, 4, null);
        }
    }

    private final void handleTimestampVerify(LynxSignVerifyCallerParams callerParams, AspectVerifyResult<?> verifyResult, LynxSignVerifyConfig lynxContainerConfig) {
        Long blockTimestamp = lynxContainerConfig != null ? lynxContainerConfig.getBlockTimestamp() : null;
        List<String> highRiskSceneList = lynxContainerConfig != null ? lynxContainerConfig.getHighRiskSceneList() : null;
        List<String> highRiskUrlDegradeList = lynxContainerConfig != null ? lynxContainerConfig.getHighRiskUrlDegradeList() : null;
        ArgusResourceLoaderInfo resourceInfo = callerParams.getResourceInfo();
        callerParams.setLastModified(resourceInfo != null ? resourceInfo.getLastModified() : null);
        Long lastModified = callerParams.getLastModified();
        callerParams.setDegraded(true);
        if (blockTimestamp == null || highRiskUrlDegradeList == null || highRiskSceneList == null) {
            AspectVerifyResult.onError$default(verifyResult, ArgusLynxSignVerifyReason.TS_VERIFY_PARAMS_IS_NULL, "blockTimestamp is null: " + (blockTimestamp == null) + ", highRiskUrlDegradeList is null: " + (highRiskUrlDegradeList == null) + ", highRiskSceneList is null: " + (highRiskSceneList == null), null, 4, null);
            return;
        }
        String scene = callerParams.getScene();
        if (highRiskSceneList.contains("*") || (scene != null && highRiskSceneList.contains(scene))) {
            callerParams.setHighRisk(true);
        }
        if (lastModified == null || lastModified.longValue() <= blockTimestamp.longValue()) {
            callerParams.setTsStatus(lastModified == null ? TimestampStatus.UNKNOWN : TimestampStatus.LessOrEqual);
            handleURLDegrade(callerParams, verifyResult, lynxContainerConfig);
            return;
        }
        callerParams.setTsStatus(TimestampStatus.Greater);
        if (callerParams.getIsHighRisk()) {
            handleHighRiskUrlDegrade(callerParams, verifyResult, highRiskUrlDegradeList);
        } else {
            handleURLDegrade(callerParams, verifyResult, lynxContainerConfig);
        }
    }

    private final void handleHighRiskUrlDegrade(LynxSignVerifyCallerParams callerParams, AspectVerifyResult<?> verifyResult, List<String> highRiskUrlDegradeList) {
        List<String> list = highRiskUrlDegradeList;
        boolean z = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (RegUtils.INSTANCE.matchReg(callerParams.getVerifyUrl(), (String) it.next())) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            AspectVerifyResult.onPass$default(verifyResult, ArgusLynxSignVerifyReason.URL_DEGRADE_SUCCESS, "high risk url degrade success", null, 4, null);
        } else {
            AspectVerifyResult.onBlock$default(verifyResult, ArgusLynxSignVerifyReason.URL_DEGRADE_FAILED, "high risk url degrade failed. verify url: " + callerParams.getVerifyUrl(), null, 4, null);
        }
    }

    private final void checkLynxFile(LynxSecurityVerificationEntity verification, LynxSignVerifyCallerParams callerParams, AspectVerifyResult<?> verifyResult, LynxSignVerifyConfig lynxContainerConfig, int realVerifyMode, LynxViewContext viewContext) {
        List<Integer> emptyList;
        com.bytedance.ies.argus.repository.LynxSignVerifyConfig lynxSignVerifyStrategyConfig;
        try {
            checkLynxSign(verification, callerParams, verifyResult, lynxContainerConfig, viewContext);
            if (!callerParams.getIsSigned()) {
                callerParams.setTasmFeId(ArgusFeId.NOT_MATCH.getLongValue());
                callerParams.setFeId(ArgusFeId.NOT_MATCH.getLongValue());
                if (realVerifyMode == 1) {
                    AspectVerifyResult.onPass$default(verifyResult, ArgusLynxSignVerifyReason.NOT_VERIFY_UNSIGNED_FILE, "not verify unsigned file when verify only", null, 4, null);
                    return;
                }
                if (lynxContainerConfig != null ? Intrinsics.areEqual(lynxContainerConfig.getEnableTsVerify(), true) : false) {
                    handleTimestampVerify(callerParams, verifyResult, lynxContainerConfig);
                    return;
                } else {
                    handleURLDegrade(callerParams, verifyResult, lynxContainerConfig);
                    return;
                }
            }
            if (verifyResult.getReasonCode() == ArgusLynxSignVerifyReason.NO_CONFIG.getCode()) {
                if (realVerifyMode == 1) {
                    AspectVerifyResult.onPass$default(verifyResult, ArgusLynxSignVerifyReason.VERIFY_ONLY_NO_CONFIG, "verify only but no fe id config", null, 4, null);
                    return;
                } else {
                    handleURLDegrade(callerParams, verifyResult, lynxContainerConfig);
                    return;
                }
            }
            SecuritySettingConfigModel securitySettingConfig = ArgusConfigManager.INSTANCE.getInstance().getSecuritySettingConfig();
            if (securitySettingConfig == null || (lynxSignVerifyStrategyConfig = securitySettingConfig.getLynxSignVerifyStrategyConfig()) == null || (emptyList = lynxSignVerifyStrategyConfig.getForceDegradeCodeList()) == null) {
                emptyList = CollectionsKt.emptyList();
            }
            if (emptyList.contains(Integer.valueOf(verifyResult.getReasonCode()))) {
                handleURLDegrade(callerParams, verifyResult, lynxContainerConfig);
            }
        } catch (Exception e) {
            ArgusLog.e$default(ArgusLog.INSTANCE, TAG, "verify lynx file failed, error: " + e.getMessage(), null, null, 12, null);
            AspectVerifyResult.onError$default(verifyResult, ArgusLynxSignVerifyReason.LOGIC_ERROR, "verify lynx file failed, error: " + e.getMessage(), null, 4, null);
        }
    }

    private final void reportRetrySuccessInfo(LynxSignVerifyCallerParams callerParams, AspectVerifyResult<?> verifyResult) {
        SecuritySettingConfigModel securitySettingConfig = ArgusConfigManager.INSTANCE.getInstance().getSecuritySettingConfig();
        MonitorConfig monitorConfig = securitySettingConfig != null ? securitySettingConfig.getMonitorConfig() : null;
        if (monitorConfig != null ? monitorConfig.getEnableUploadLynxSignFailedFile() : false) {
            String verifyUrl = callerParams.getVerifyUrl();
            Map<String, Integer> signFailedVerifyUrl2CountMap = GlobalEventCenter.INSTANCE.getInstance().getSignFailedVerifyUrl2CountMap();
            if (signFailedVerifyUrl2CountMap.get(verifyUrl) == null) {
                return;
            }
            IUploadSignFailedLynxDepend uploadSignFailedLynxDepend = ArgusEnv.INSTANCE.getInstance().getUploadSignFailedLynxDepend();
            if (uploadSignFailedLynxDepend != null) {
                byte[] bArr = new byte[1];
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, Object> entry : verifyResult.getExtra().entrySet()) {
                    JSONUtilsKt.safelyPut(jSONObject, entry.getKey(), entry.getValue());
                }
                JSONUtilsKt.safelyPut(jSONObject, "action", verifyResult.getAction().getStrValue());
                JSONUtilsKt.safelyPut(jSONObject, "reason_code", Integer.valueOf(verifyResult.getReasonCode()));
                JSONUtilsKt.safelyPut(jSONObject, "failed_count", signFailedVerifyUrl2CountMap.get(verifyUrl));
                Unit unit = Unit.INSTANCE;
                uploadSignFailedLynxDepend.upload(bArr, jSONObject);
            }
            GlobalEventCenter.INSTANCE.getInstance().getSignFailedVerifyUrl2CountMap().remove(verifyUrl);
        }
    }

    private final void uploadSignFailedLynxFile(byte[] byteArray, LynxSignVerifyCallerParams callerParams, AspectVerifyResult<?> verifyResult) {
        List<Integer> emptyList;
        SecuritySettingConfigModel securitySettingConfig = ArgusConfigManager.INSTANCE.getInstance().getSecuritySettingConfig();
        MonitorConfig monitorConfig = securitySettingConfig != null ? securitySettingConfig.getMonitorConfig() : null;
        if (monitorConfig != null ? monitorConfig.getEnableUploadLynxSignFailedFile() : false) {
            if (monitorConfig == null || (emptyList = monitorConfig.getUploadLynxVerifyCodeList()) == null) {
                emptyList = CollectionsKt.emptyList();
            }
            if (emptyList.contains(Integer.valueOf(verifyResult.getReasonCode()))) {
                Map<String, Integer> signFailedVerifyUrl2CountMap = GlobalEventCenter.INSTANCE.getInstance().getSignFailedVerifyUrl2CountMap();
                String verifyUrl = callerParams.getVerifyUrl();
                Integer num = signFailedVerifyUrl2CountMap.get(verifyUrl);
                signFailedVerifyUrl2CountMap.put(verifyUrl, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
                IUploadSignFailedLynxDepend uploadSignFailedLynxDepend = ArgusEnv.INSTANCE.getInstance().getUploadSignFailedLynxDepend();
                if (uploadSignFailedLynxDepend != null) {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, Object> entry : verifyResult.getExtra().entrySet()) {
                        JSONUtilsKt.safelyPut(jSONObject, entry.getKey(), entry.getValue());
                    }
                    JSONUtilsKt.safelyPut(jSONObject, "action", verifyResult.getAction().getStrValue());
                    JSONUtilsKt.safelyPut(jSONObject, "reason_code", Integer.valueOf(verifyResult.getReasonCode()));
                    JSONUtilsKt.safelyPut(jSONObject, "failed_count", signFailedVerifyUrl2CountMap.get(verifyUrl));
                    Unit unit = Unit.INSTANCE;
                    uploadSignFailedLynxDepend.upload(byteArray, jSONObject);
                }
            }
        }
    }

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public void calculate(AspectConfigItem.AspectRuleItem rule, ContainerStrategyConfig strategyConfig, AspectContext<?, ?>.CalculateContext context) {
        LynxViewContext lynxViewContext;
        ILifeCycleDepend lifeCycleDepend;
        LoadTemplateParams templateInfo;
        LynxSignVerifyConfig lynxSignVerify;
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(context, "context");
        Object callerParams = context.getCallerParams();
        AspectVerifyResult<?> verifyResult = context.getVerifyResult();
        if (!(callerParams instanceof LynxSignVerifyCallerParams)) {
            AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.MISMATCH_PARAMS_TYPE, null, null, 6, null);
            return;
        }
        int verifyMode = (strategyConfig == null || (lynxSignVerify = strategyConfig.getLynxSignVerify()) == null) ? 0 : lynxSignVerify.getVerifyMode();
        if (verifyMode == 0) {
            AspectVerifyResult.onPass$default(verifyResult, ArgusLynxSignVerifyReason.CONTAINER_DISABLE_SIGN, null, null, 6, null);
            return;
        }
        LynxSignVerifyCallerParams lynxSignVerifyCallerParams = (LynxSignVerifyCallerParams) callerParams;
        LynxSecurityVerificationEntity verification = lynxSignVerifyCallerParams.getVerification();
        ILynxSecurityService.LynxTasmType tasmType = verification.getTasmType();
        ArgusResourceLoaderInfo argusResourceLoaderInfo = null;
        LynxSignVerifyConfig lynxSignVerify2 = strategyConfig != null ? strategyConfig.getLynxSignVerify() : null;
        BaseViewContext<?> viewContext = context.getViewContext();
        LynxViewContext lynxViewContext2 = viewContext instanceof LynxViewContext ? (LynxViewContext) viewContext : null;
        lynxSignVerifyCallerParams.setScene(context.getArgusSceneTag());
        checkLynxFile(verification, lynxSignVerifyCallerParams, verifyResult, lynxSignVerify2, verifyMode, lynxViewContext2);
        context.getVerifyResult().addExtra("sign_verify_mode", String.valueOf(verifyMode));
        if (verifyResult.isPass() && tasmType == ILynxSecurityService.LynxTasmType.TYPE_TEMPLATE && lynxViewContext2 != null) {
            lynxViewContext = lynxViewContext2;
            lynxViewContext2.recordJsbAuthInfo$anniex_release(lynxSignVerifyCallerParams.getFeId(), lynxSignVerifyCallerParams.getTasmFeId(), lynxSignVerifyCallerParams.getVerifyUrl());
        } else {
            lynxViewContext = lynxViewContext2;
        }
        if (verifyResult.isBlock() && (lifeCycleDepend = ArgusEnv.INSTANCE.getInstance().getLifeCycleDepend()) != null) {
            if (lynxViewContext != null && (templateInfo = lynxViewContext.getTemplateInfo(tasmType)) != null) {
                argusResourceLoaderInfo = templateInfo.getLoaderInfo();
            }
            lifeCycleDepend.onLynxSignFailed(argusResourceLoaderInfo);
            ArgusLog.e$default(ArgusLog.INSTANCE, TAG, "trigger onLynxSignFailed", null, null, 12, null);
        }
        if (verifyResult.isBlock() || verifyResult.getReasonCode() > 100) {
            uploadSignFailedLynxFile(verification.getOriginTasm(), lynxSignVerifyCallerParams, verifyResult);
        } else {
            reportRetrySuccessInfo(lynxSignVerifyCallerParams, verifyResult);
        }
    }
}
