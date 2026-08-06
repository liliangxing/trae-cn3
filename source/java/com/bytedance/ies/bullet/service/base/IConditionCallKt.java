package com.bytedance.ies.bullet.service.base;

import android.net.Uri;
import com.bytedance.ies.bullet.base.settings.SecuritySettingConfig;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.settings.LegoBootFinishCommitter;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.IntegerParam;
import com.bytedance.reparo.core.exception.PatchException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: IConditionCall.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\ba\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0004\u001a\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\u0006\u0010\b\u001a\u00020\u0004\u001a\u0006\u0010\t\u001a\u00020\n\u001a\u0006\u0010\u000b\u001a\u00020\n\u001a\u0006\u0010\f\u001a\u00020\u0004\u001a\u0006\u0010\r\u001a\u00020\n\u001a\u0006\u0010\u000e\u001a\u00020\n\u001a\u0006\u0010\u000f\u001a\u00020\n\u001a\u0006\u0010\u0010\u001a\u00020\n\u001a\u0006\u0010\u0011\u001a\u00020\u0004\u001a\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015\u001a\u0006\u0010\u0016\u001a\u00020\u0004\u001a\u0006\u0010\u0017\u001a\u00020\u0004\u001a\u0006\u0010\u0018\u001a\u00020\u0004\u001a\u0006\u0010\u0019\u001a\u00020\u0004\u001a\u0006\u0010\u001a\u001a\u00020\u0004\u001a\u0006\u0010\u001b\u001a\u00020\u0004\u001a\u0006\u0010\u001c\u001a\u00020\u0004\u001a\u0006\u0010\u001d\u001a\u00020\u0004\u001a\u0006\u0010\u001e\u001a\u00020\u0004\u001a\u0006\u0010\u001f\u001a\u00020\u0004\u001a\u0006\u0010 \u001a\u00020\u0004\u001a\u0006\u0010!\u001a\u00020\u0004\u001a\u0006\u0010\"\u001a\u00020\u0004\u001a\u0006\u0010#\u001a\u00020\u0004\u001a\u0006\u0010$\u001a\u00020\u0004\u001a\u0006\u0010%\u001a\u00020\u0004\u001a\u0006\u0010&\u001a\u00020\u0004\u001a\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\u0006\u0010(\u001a\u00020\u0004\u001a\u0006\u0010)\u001a\u00020\u0004\u001a\u0006\u0010*\u001a\u00020\u0004\u001a\u0006\u0010+\u001a\u00020\u0004\u001a\u0006\u0010,\u001a\u00020\u0004\u001a\u0006\u0010-\u001a\u00020\u0004\u001a\u0006\u0010.\u001a\u00020\u0004\u001a\u0006\u0010/\u001a\u00020\u0004\u001a\u0006\u00100\u001a\u00020\u0004\u001a\u0006\u00101\u001a\u00020\u0004\u001a\u0006\u00102\u001a\u00020\u0004\u001a\u0006\u00103\u001a\u00020\u0004\u001a\u0006\u00104\u001a\u00020\u0004\u001a\u0006\u00105\u001a\u00020\u0004\u001a\u0006\u00106\u001a\u00020\u0004\u001a\u0006\u00107\u001a\u00020\u0004\u001a\u0006\u00108\u001a\u00020\u0004\u001a\u0006\u00109\u001a\u00020\u0004\u001a\u0006\u0010:\u001a\u00020\u0004\u001a\u0006\u0010;\u001a\u00020\u0004\u001a\u0006\u0010<\u001a\u00020\u0004\u001a\u0006\u0010=\u001a\u00020\u0004\u001a\u0006\u0010>\u001a\u00020\u0004\u001a\u0006\u0010?\u001a\u00020\u0004\u001a\u0006\u0010@\u001a\u00020\u0004\u001a\u0006\u0010A\u001a\u00020\u0004\u001a\u0006\u0010B\u001a\u00020\u0004\u001a\u0006\u0010C\u001a\u00020\u0004\u001a\u0006\u0010D\u001a\u00020\u0004\u001a\u0006\u0010E\u001a\u00020\u0004\u001a\u0006\u0010F\u001a\u00020\u0004\u001a\u0006\u0010G\u001a\u00020\u0004\u001a\u0006\u0010H\u001a\u00020\u0004\u001a\u0006\u0010I\u001a\u00020\u0004\u001a\u0006\u0010J\u001a\u00020\u0004\u001a\u0006\u0010K\u001a\u00020\u0004\u001a\u0006\u0010L\u001a\u00020\u0004\u001a\u0006\u0010M\u001a\u00020\u0004\u001a\u0006\u0010N\u001a\u00020\u0004\u001a\u0006\u0010O\u001a\u00020\u0004\u001a\u0006\u0010P\u001a\u00020\u0004\u001a\u0006\u0010Q\u001a\u00020\u0004\u001a\u0006\u0010R\u001a\u00020\u0004\u001a\u0006\u0010S\u001a\u00020\u0004\u001a\u0006\u0010T\u001a\u00020\u0004\u001a\u0006\u0010U\u001a\u00020\u0004\u001a\u0006\u0010V\u001a\u00020\u0004\u001a\u0006\u0010W\u001a\u00020\u0004\u001a\u0006\u0010X\u001a\u00020\u0004\u001a\u0006\u0010Y\u001a\u00020\u0004\u001a\u0006\u0010Z\u001a\u00020\u0004\u001a\u0006\u0010[\u001a\u00020\u0004\u001a\u0006\u0010\\\u001a\u00020\u0004\u001a\u0006\u0010]\u001a\u00020\u0004\u001a\u0006\u0010^\u001a\u00020\u0004\u001a\u0006\u0010_\u001a\u00020\u0004\u001a\u0006\u0010`\u001a\u00020\u0004\u001a\u0006\u0010a\u001a\u00020\u0004\u001a\u0006\u0010b\u001a\u00020\u0004\u001a\u0006\u0010c\u001a\u00020\u0004\u001a\u0006\u0010d\u001a\u00020\u0004\u001a\u0006\u0010e\u001a\u00020\u0004\u001a\u0006\u0010f\u001a\u00020\u0004\u001a\u0006\u0010g\u001a\u00020\u0004\u001a\u0006\u0010h\u001a\u00020\u0004\u001a\u0006\u0010i\u001a\u00020\u0004\u001a\u0006\u0010j\u001a\u00020\u0004\u001a\u0006\u0010k\u001a\u00020\u0004\u001a\u0006\u0010l\u001a\u00020\u0004\u001a\u0006\u0010m\u001a\u00020\u0004\u001a\u0006\u0010n\u001a\u00020\u0004\u001a\u0006\u0010o\u001a\u00020\u0004\u001a\u0006\u0010p\u001a\u00020\u0004\u001a\u0006\u0010q\u001a\u00020\u0004\u001a\u0006\u0010r\u001a\u00020\u0004\u001a\u0006\u0010s\u001a\u00020\u0004\u001a\u0006\u0010t\u001a\u00020\u0004\u001a\u000e\u0010u\u001a\u00020\u00042\u0006\u0010v\u001a\u00020w\u001a\u0006\u0010x\u001a\u00020\u0004\u001a\u000e\u0010y\u001a\u00020\u00042\u0006\u0010z\u001a\u00020{\u001a\u0006\u0010|\u001a\u00020\u0004\u001a\u000e\u0010}\u001a\u00020\u00042\u0006\u0010z\u001a\u00020{\u001a\u0006\u0010~\u001a\u00020\u0004\u001a\u0006\u0010\u007f\u001a\u00020\u0004\u001a\u0007\u0010\u0080\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u0081\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u0082\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u0083\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u0084\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u0085\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u0086\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u0087\u0001\u001a\u00020\u0004\u001a\u0013\u0010\u0088\u0001\u001a\u00020\u00042\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001\u001a\u0013\u0010\u008b\u0001\u001a\u00020\u00042\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001\u001a\u0007\u0010\u008c\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u008d\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u008e\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u008f\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u0090\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u0091\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u0092\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u0093\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u0094\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u0095\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u0096\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u0097\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u0098\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u0099\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u009a\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u009b\u0001\u001a\u00020\u0004\u001a\u0007\u0010\u009c\u0001\u001a\u00020\u0004\u001a\r\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\u0007\u0010\u009e\u0001\u001a\u00020\n\u001a\u0007\u0010\u009f\u0001\u001a\u00020\u0004\u001a\u0007\u0010 \u0001\u001a\u00020\u0004\u001a\u0007\u0010¡\u0001\u001a\u00020\u0004\u001a\n\u0010¢\u0001\u001a\u00030£\u0001H\u0000\u001a\u0007\u0010¤\u0001\u001a\u00020\u0004\u001a\u0007\u0010¥\u0001\u001a\u00020\u0004\u001a\u0007\u0010¦\u0001\u001a\u00020\u0004\u001a\u0007\u0010§\u0001\u001a\u00020\u0004\u001a\u0007\u0010¨\u0001\u001a\u00020\u0004\u001a\u0007\u0010©\u0001\u001a\u00020\u0004\u001a\u0018\u0010ª\u0001\u001a\u00020\u00042\t\u0010«\u0001\u001a\u0004\u0018\u00010\n¢\u0006\u0003\u0010¬\u0001\u001a\t\u0010\u00ad\u0001\u001a\u00020\u0004H\u0000¨\u0006®\u0001"}, d2 = {"annieFlowBlackList", "", "", "annieFlowEnableUrlSessionId", "", "annieFlowWhiteList", "annieLiteBlackList", "annieLiteWhiteList", "annieXFixActivityDynamicProps", "annieXFlowCacheSize", "", "annieXFlowReleaseInternal", "annieXLiteExtraJSBFix", "annieXLitePageFixCloseAfterOpenInternal", "annieXLitePageFixCloseAfterOpenSuccessInternal", "annieXLiveJSB2InstanceLimit", "annieXStreamPrefetchChunkSize", "annieXWebcastPadFoldPopupHeightSwitch", "delayRunbulletSetting", "", MetricConstant.MONITOR_STAGE_UPDATE, "Lkotlin/Function0;", "disableActivityInfoRecordOpt", "disableAddSessionId", "disableAnnieXPopupPadAdapter", "disableBridgeContainerLeak", "disablePopupPadAdapter", "disablePopupStatusBarParams", "disableTouchOutsizeA11yFocusFix", "enableAnnieConvertJsonOpt", "enableAnnieXBridgeThreadOpt", "enableAnnieXBulletFallback", "enableAnnieXCardFixedLynxGroup", "enableAnnieXDialogHideAbleFix", "enableAnnieXDialogNestedScrollFix", "enableAnnieXEndToEndReport", "enableAnnieXFixDownloadWorkerJSByCDN", "enableAnnieXFlowPage", "enableAnnieXFlowPopup", "enableAnnieXFlowSwitchWhiteList", "enableAnnieXIgnoreJSB2Failure", "enableAnnieXJsbParamInNumberAdapterFix", "enableAnnieXLitePage", "enableAnnieXLitePageClose", "enableAnnieXLiveBcmChainFix", "enableAnnieXLiveCompactMode", "enableAnnieXLiveDialogClickMaskCloseFix", "enableAnnieXLiveJSBCodeFix", "enableAnnieXLiveLynxInitDataFix", "enableAnnieXLiveMethodFactoryFix", "enableAnnieXLiveMethodFactoryMapFix", "enableAnnieXLiveTypeSchemaFieldFix", "enableAnnieXLoadEngineExpFix", "enableAnnieXOrientationEvent", "enableAnnieXPadAdapterGravityFix", "enableAnnieXPadGPContainerMigration", "enableAnnieXPadOrFoldPopupHeightFix", "enableAnnieXPageSoftInputModeDefault", "enableAnnieXPopupLoopMeasureFix", "enableAnnieXRealScreenSizeFix", "enableAnnieXWebKitKeyboardFix", "enableAnnieXWebcastInitDataThreadOpt", "enableAnnieXWebcastWebPopupSoftInputAdapter", "enableAnnieXWorkerMd5Check", "enableAnnieXWorkerTaskInitImmediately", "enableAnnieXWorkerTaskInitOnce", "enableAnniexFlowCancelFix", "enableArgusFetchCdnConfigInternal", "enableAttachEngineToUiThread", "enableBridgeCanRunInBackgroundFix", "enableBridgePreInit", "enableBridgeProviderRelease", "enableBridgeReleaseCode", "enableBulletContextRelease", "enableBulletPrerenderCallMonitor", "enableBulletPrerenderLynxPropsFix", "enableBulletSettingDelay", "enableCardAppendPropsFix", "enableCardBidParamRegister", "enableCardBuilderPropsFix", "enableChangeLynxUrl", "enableClearTopEventNewUrlFix", "enableContextFreeLifeCycleFix", "enableCopyDataBugfix", "enableDevicePropsRollBack", "enableDialogRestoreInstanceState", "enableDpToPxRoundToIntFix", "enableDynamicLoadV8", "enableECStatefulMethodsFragmentSceneFix", "enableFixDestroyWithOutForestRelease", "enableFixDialogDestroy", "enableFixNeedOutAnimation", "enableFixedLynxGroup", "enableFlowPageAnnieInitFix", "enableFlowPageCloseFix", "enableFlowPageContextFix", "enableFlowUpdateContext", "enableForceBindBulletPopupService", "enableForestTemplateProvider", "enableGeckoLoaderSecure", "enableGlobalTemplateProvider", "enableHybridMultiCustomReport", "enableJsbBridgeReleaseOpt", "enableJsonOpt", "enableLitePageBidExpand", "enableLitePageBridgeFix", "enableLitePageBusinessBehavior", "enableLitePageLiveInitFix", "enableLiveMethodFactoryRegisterMonitor", "enableLoadFailedOnUIThread", "enableLynx100ErrorFix", "enableLynxAnimax", "enableLynxCardLifeCycleFix", "enableLynxCardPrefetchWithBid", "enableLynxViewBuilderParamsFix", "enableMixLogic", "enableOrientationGPFix", "enableOrientationOnLayoutChange", "uri", "Landroid/net/Uri;", "enablePadAdapterChannelStyle", "enablePadAdapterMigrationToUniformStyle", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "enablePadAdapterUniformStyle", "enablePadPopupMigrationToUniformStyle", "enablePadUpdateFrameBottomFix", "enablePrefetchDataGlobalProps", "enablePreloadBeforeLoad", "enableRedirectDefaultCache", "enableReloadContextMerge", "enableRemoveSamePageFix", "enableSLMonitorJSBErrorParams", "enableSafeAreaHeight", "enableSchemaNotParseLoop", "enableSecLinkReportEntry", "enableThirdPartyWebLogic", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "enableThirdPartyWebUi", "enableToutiaoGlobalPropsInject", "enableViewAttachStack", "enableWebKitViewUpdateGlobalProps", "enableWebStandard", "enableWebcastLitePageGlobalPropsFix", "enableWorkerEventReset", "enableXBridgeContextLeakFix", "enableXBridgeParamProxyEnhancement", "enableXUploadImageUriFix", "fixAnnieResourceLoad", "fixAnnieXMethodFinder", "fixBridgeStorage", "fixJsonLong2Double", "fixLynxKitViewLeak", "fixLynxUrlOfHdt", "fixMultiMediaQuery", "fixPrefetchQueryObject", "getAnnieXLiveTokenParamAdaptionList", "getBridgeContainerLeakValue", "getEnableAnnieXUrlParamFix", "getEnableLitePageBidBehaviorOpt", "getEnableLitePageBidOpt", "getHybridSecureConfig", "Lcom/bytedance/ies/bullet/base/settings/SecuritySettingConfig;", "latchSkipAuth", "latchSkipBpea", "lokiJsbLogDropSwitch", "lokiJsbOptSwitch", "mixJsbSwitch", "separateVMSdkLoad", "shouldIgnoreHttpStatusCode", "statusCode", "(Ljava/lang/Integer;)Z", "switchBridgeDownloadToDownloader", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IConditionCallKt {
    public static final boolean disableAddSessionId() {
        CommonConfig commonConfig;
        Boolean disableAddSessionId;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (disableAddSessionId = commonConfig.getDisableAddSessionId()) == null) {
            return false;
        }
        return disableAddSessionId.booleanValue();
    }

    public static final boolean disableBridgeContainerLeak() {
        CommonConfig commonConfig;
        Boolean disableBridgeContainerLeak;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (disableBridgeContainerLeak = commonConfig.getDisableBridgeContainerLeak()) == null) {
            return false;
        }
        return disableBridgeContainerLeak.booleanValue();
    }

    public static final int getBridgeContainerLeakValue() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) {
            return 1;
        }
        return provideBulletSettings.getEnableGlobalLayoutMemLeak();
    }

    public static final boolean disableActivityInfoRecordOpt() {
        CommonConfig commonConfig;
        Boolean disableActivityInfoRecord;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (disableActivityInfoRecord = commonConfig.getDisableActivityInfoRecord()) == null) {
            return false;
        }
        return disableActivityInfoRecord.booleanValue();
    }

    public static final boolean enablePreloadBeforeLoad() {
        CommonConfig commonConfig;
        Boolean enablePreloadBeforeLoad;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enablePreloadBeforeLoad = commonConfig.getEnablePreloadBeforeLoad()) == null) {
            return true;
        }
        return enablePreloadBeforeLoad.booleanValue();
    }

    public static final boolean enableDynamicLoadV8() {
        CommonConfig commonConfig;
        Boolean enableDynamicLoadV8;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableDynamicLoadV8 = commonConfig.getEnableDynamicLoadV8()) == null) {
            return true;
        }
        return enableDynamicLoadV8.booleanValue();
    }

    public static final boolean latchSkipBpea() {
        CommonConfig commonConfig;
        Boolean latchSkipBpea;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (latchSkipBpea = commonConfig.getLatchSkipBpea()) == null) {
            return true;
        }
        return latchSkipBpea.booleanValue();
    }

    public static final boolean latchSkipAuth() {
        CommonConfig commonConfig;
        Boolean latchSkipAuth;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (latchSkipAuth = commonConfig.getLatchSkipAuth()) == null) {
            return true;
        }
        return latchSkipAuth.booleanValue();
    }

    public static final boolean mixJsbSwitch() {
        CommonConfig commonConfig;
        Boolean mixJsbOptSwitch;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (mixJsbOptSwitch = commonConfig.getMixJsbOptSwitch()) == null) {
            return true;
        }
        return mixJsbOptSwitch.booleanValue();
    }

    public static final boolean annieXFixActivityDynamicProps() {
        CommonConfig commonConfig;
        Boolean annieXFixActivityDynamicProps;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (annieXFixActivityDynamicProps = commonConfig.getAnnieXFixActivityDynamicProps()) == null) {
            return true;
        }
        return annieXFixActivityDynamicProps.booleanValue();
    }

    public static final boolean lokiJsbOptSwitch() {
        CommonConfig commonConfig;
        Boolean lokiJsbOptSwitch;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (lokiJsbOptSwitch = commonConfig.getLokiJsbOptSwitch()) == null) {
            return true;
        }
        return lokiJsbOptSwitch.booleanValue();
    }

    public static final boolean lokiJsbLogDropSwitch() {
        CommonConfig commonConfig;
        Boolean lokiJsbLogDropSwitch;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (lokiJsbLogDropSwitch = commonConfig.getLokiJsbLogDropSwitch()) == null) {
            return true;
        }
        return lokiJsbLogDropSwitch.booleanValue();
    }

    public static final boolean enableFixedLynxGroup() {
        CommonConfig commonConfig;
        Boolean enableFixedLynxGroup;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableFixedLynxGroup = commonConfig.getEnableFixedLynxGroup()) == null) {
            return true;
        }
        return enableFixedLynxGroup.booleanValue();
    }

    public static final boolean disablePopupPadAdapter() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return true;
        }
        return commonConfig.getDisablePopupPadAdapter();
    }

    public static final boolean fixBridgeStorage() {
        CommonConfig commonConfig;
        Boolean fixBridgeStorage;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (fixBridgeStorage = commonConfig.getFixBridgeStorage()) == null) {
            return true;
        }
        return fixBridgeStorage.booleanValue();
    }

    public static final boolean fixMultiMediaQuery() {
        CommonConfig commonConfig;
        Boolean fixMultiMediaQuery;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (fixMultiMediaQuery = commonConfig.getFixMultiMediaQuery()) == null) {
            return true;
        }
        return fixMultiMediaQuery.booleanValue();
    }

    public static final boolean enableGeckoLoaderSecure() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) {
            return false;
        }
        return provideBulletSettings.getEnableGeckoLoaderSecure();
    }

    public static final boolean enableGlobalTemplateProvider() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) {
            return false;
        }
        return provideBulletSettings.getEnableGlobalTemplateProvider();
    }

    public static final boolean enableForestTemplateProvider() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) {
            return false;
        }
        return provideBulletSettings.getEnableForestTemplateProvider();
    }

    public static final boolean enableXBridgeContextLeakFix() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) {
            return false;
        }
        return provideBulletSettings.getEnableXBridgeContextLeakFix();
    }

    public static final boolean enableMixLogic() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) {
            return true;
        }
        return provideBulletSettings.getEnableMixLogic();
    }

    public static final boolean enableRedirectDefaultCache() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) {
            return false;
        }
        return provideBulletSettings.getEnableRedirectDefaultCache();
    }

    public static final boolean enableReloadContextMerge() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) {
            return false;
        }
        return provideBulletSettings.getEnableReloadContextMerge();
    }

    public static final boolean separateVMSdkLoad() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) {
            return false;
        }
        return provideBulletSettings.getSeparateVMSdkLoad();
    }

    public static final boolean enableBulletContextRelease() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return true;
        }
        return commonConfig.getEnableBulletContextRelease();
    }

    public static final boolean enableBridgeProviderRelease() {
        CommonConfig commonConfig;
        Boolean enableBridgeProviderRelease;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableBridgeProviderRelease = commonConfig.getEnableBridgeProviderRelease()) == null) {
            return true;
        }
        return enableBridgeProviderRelease.booleanValue();
    }

    public static final boolean enableBridgePreInit() {
        CommonConfig commonConfig;
        Boolean enableBridgePreInit;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableBridgePreInit = commonConfig.getEnableBridgePreInit()) == null) {
            return false;
        }
        return enableBridgePreInit.booleanValue();
    }

    public static final boolean enableBridgeReleaseCode() {
        CommonConfig commonConfig;
        Boolean enableBridgeReleaseCode;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableBridgeReleaseCode = commonConfig.getEnableBridgeReleaseCode()) == null) {
            return true;
        }
        return enableBridgeReleaseCode.booleanValue();
    }

    public static final boolean fixLynxKitViewLeak() {
        CommonConfig commonConfig;
        Boolean fixLynxKitViewLeak;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (fixLynxKitViewLeak = commonConfig.getFixLynxKitViewLeak()) == null) {
            return true;
        }
        return fixLynxKitViewLeak.booleanValue();
    }

    public static final boolean enableAnnieXLiveCompactMode() {
        CommonConfig commonConfig;
        Boolean enableAnnieXLiveCompactMode;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXLiveCompactMode = commonConfig.getEnableAnnieXLiveCompactMode()) == null) {
            return true;
        }
        return enableAnnieXLiveCompactMode.booleanValue();
    }

    public static final boolean fixJsonLong2Double() {
        CommonConfig commonConfig;
        Boolean fixJsonLong2Double;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (fixJsonLong2Double = commonConfig.getFixJsonLong2Double()) == null) {
            return true;
        }
        return fixJsonLong2Double.booleanValue();
    }

    public static final boolean fixAnnieResourceLoad() {
        CommonConfig commonConfig;
        Boolean fixAnnieResourceLoad;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (fixAnnieResourceLoad = commonConfig.getFixAnnieResourceLoad()) == null) {
            return true;
        }
        return fixAnnieResourceLoad.booleanValue();
    }

    public static final boolean fixLynxUrlOfHdt() {
        CommonConfig commonConfig;
        Boolean fixLynxUrlOfHdt;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (fixLynxUrlOfHdt = commonConfig.getFixLynxUrlOfHdt()) == null) {
            return true;
        }
        return fixLynxUrlOfHdt.booleanValue();
    }

    public static final boolean enableCopyDataBugfix() {
        CommonConfig commonConfig;
        Boolean enableCopyDataBugfix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableCopyDataBugfix = commonConfig.getEnableCopyDataBugfix()) == null) {
            return true;
        }
        return enableCopyDataBugfix.booleanValue();
    }

    public static final boolean enableLoadFailedOnUIThread() {
        CommonConfig commonConfig;
        Boolean enableLoadFailedOnUIThread;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableLoadFailedOnUIThread = commonConfig.getEnableLoadFailedOnUIThread()) == null) {
            return true;
        }
        return enableLoadFailedOnUIThread.booleanValue();
    }

    public static final boolean enableDevicePropsRollBack() {
        CommonConfig commonConfig;
        Boolean enableDevicePropsRollBack;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableDevicePropsRollBack = commonConfig.getEnableDevicePropsRollBack()) == null) {
            return true;
        }
        return enableDevicePropsRollBack.booleanValue();
    }

    public static final boolean enableCardBidParamRegister() {
        CommonConfig commonConfig;
        Boolean enableCardBidParamRegister;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableCardBidParamRegister = commonConfig.getEnableCardBidParamRegister()) == null) {
            return true;
        }
        return enableCardBidParamRegister.booleanValue();
    }

    public static final boolean enableCardAppendPropsFix() {
        CommonConfig commonConfig;
        Boolean enableCardAppendPropsFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableCardAppendPropsFix = commonConfig.getEnableCardAppendPropsFix()) == null) {
            return true;
        }
        return enableCardAppendPropsFix.booleanValue();
    }

    public static final boolean enableChangeLynxUrl() {
        CommonConfig commonConfig;
        Boolean enableChangeLynxUrl;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableChangeLynxUrl = commonConfig.getEnableChangeLynxUrl()) == null) {
            return true;
        }
        return enableChangeLynxUrl.booleanValue();
    }

    public static final boolean enableXUploadImageUriFix() {
        CommonConfig commonConfig;
        Boolean enableXUploadImageUriFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableXUploadImageUriFix = commonConfig.getEnableXUploadImageUriFix()) == null) {
            return true;
        }
        return enableXUploadImageUriFix.booleanValue();
    }

    public static final boolean enableLynxCardLifeCycleFix() {
        CommonConfig commonConfig;
        Boolean enableLynxCardLifeCycleFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableLynxCardLifeCycleFix = commonConfig.getEnableLynxCardLifeCycleFix()) == null) {
            return true;
        }
        return enableLynxCardLifeCycleFix.booleanValue();
    }

    public static final boolean enableContextFreeLifeCycleFix() {
        CommonConfig commonConfig;
        Boolean enableContextFreeLifeCycleFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableContextFreeLifeCycleFix = commonConfig.getEnableContextFreeLifeCycleFix()) == null) {
            return true;
        }
        return enableContextFreeLifeCycleFix.booleanValue();
    }

    public static final boolean enableLynx100ErrorFix() {
        CommonConfig commonConfig;
        Boolean enableLynx100ErrorFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableLynx100ErrorFix = commonConfig.getEnableLynx100ErrorFix()) == null) {
            return true;
        }
        return enableLynx100ErrorFix.booleanValue();
    }

    public static final boolean enableAttachEngineToUiThread() {
        CommonConfig commonConfig;
        Boolean attachEngineToUiThread;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (attachEngineToUiThread = commonConfig.getAttachEngineToUiThread()) == null) {
            return true;
        }
        return attachEngineToUiThread.booleanValue();
    }

    public static final boolean enableBulletPrerenderLynxPropsFix() {
        CommonConfig commonConfig;
        Boolean enableBulletPrerenderLynxPropsFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableBulletPrerenderLynxPropsFix = commonConfig.getEnableBulletPrerenderLynxPropsFix()) == null) {
            return true;
        }
        return enableBulletPrerenderLynxPropsFix.booleanValue();
    }

    public static final boolean enableBulletPrerenderCallMonitor() {
        CommonConfig commonConfig;
        Boolean enableBulletPrerenderCallMonitor;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableBulletPrerenderCallMonitor = commonConfig.getEnableBulletPrerenderCallMonitor()) == null) {
            return true;
        }
        return enableBulletPrerenderCallMonitor.booleanValue();
    }

    public static final boolean enableFixDestroyWithOutForestRelease() {
        CommonConfig commonConfig;
        Boolean enableFixDestroyWithOutForestRelease;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableFixDestroyWithOutForestRelease = commonConfig.getEnableFixDestroyWithOutForestRelease()) == null) {
            return true;
        }
        return enableFixDestroyWithOutForestRelease.booleanValue();
    }

    public static final boolean enableSchemaNotParseLoop() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return true;
        }
        return commonConfig.getEnableSchemaNotParseLoop();
    }

    public static final boolean enableLynxAnimax() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return true;
        }
        return commonConfig.getEnableLynxAnimax();
    }

    public static final boolean enableCardBuilderPropsFix() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return true;
        }
        return commonConfig.getEnableCardBuilderPropsFix();
    }

    public static final boolean annieXWebcastPadFoldPopupHeightSwitch() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return false;
        }
        return commonConfig.getAnnieXWebcastPadFoldPopupHeightSwitch();
    }

    public static final boolean enableClearTopEventNewUrlFix() {
        CommonConfig commonConfig;
        Boolean enableClearTopEventNewUrlFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableClearTopEventNewUrlFix = commonConfig.getEnableClearTopEventNewUrlFix()) == null) {
            return true;
        }
        return enableClearTopEventNewUrlFix.booleanValue();
    }

    public static final boolean enableRemoveSamePageFix() {
        CommonConfig commonConfig;
        Boolean enableRemoveSamePageFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableRemoveSamePageFix = commonConfig.getEnableRemoveSamePageFix()) == null) {
            return true;
        }
        return enableRemoveSamePageFix.booleanValue();
    }

    public static final boolean enableAnnieXCardFixedLynxGroup() {
        CommonConfig commonConfig;
        Boolean enableAnnieXCardFixedLynxGroup;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXCardFixedLynxGroup = commonConfig.getEnableAnnieXCardFixedLynxGroup()) == null) {
            return false;
        }
        return enableAnnieXCardFixedLynxGroup.booleanValue();
    }

    public static final boolean enableDialogRestoreInstanceState() {
        CommonConfig commonConfig;
        Boolean enableDialogRestoreInstanceState;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableDialogRestoreInstanceState = commonConfig.getEnableDialogRestoreInstanceState()) == null) {
            return false;
        }
        return enableDialogRestoreInstanceState.booleanValue();
    }

    public static final boolean enableWebStandard() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) {
            return false;
        }
        return provideBulletSettings.getEnableWebStandard();
    }

    public static final boolean enableThirdPartyWebLogic(BulletContext bulletContext) {
        ISchemaData schemaData;
        Integer num = null;
        if (bulletContext != null && (schemaData = bulletContext.getSchemaData()) != null) {
            num = new IntegerParam(schemaData, SchemaConstants.QUERY_KEY_WEB_DOMAIN_PARTY, null).getValue();
        }
        return (num == null || num.intValue() == 1) ? false : true;
    }

    public static final boolean enableThirdPartyWebUi(BulletContext bulletContext) {
        ISchemaData schemaData;
        Boolean value;
        if (bulletContext == null || (schemaData = bulletContext.getSchemaData()) == null || (value = new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_ENABLE_THIRD_PARTY_WEB_UI, false).getValue()) == null) {
            return false;
        }
        return value.booleanValue();
    }

    public static final SecuritySettingConfig getHybridSecureConfig() {
        SecuritySettingConfig securitySettingConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        return (iBulletSettingsService == null || (securitySettingConfig = (SecuritySettingConfig) iBulletSettingsService.obtainSettings(SecuritySettingConfig.class)) == null) ? new SecuritySettingConfig() : securitySettingConfig;
    }

    public static final boolean enableLynxCardPrefetchWithBid() {
        CommonConfig commonConfig;
        Boolean enableLynxCardPrefetchWithBid;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableLynxCardPrefetchWithBid = commonConfig.getEnableLynxCardPrefetchWithBid()) == null) {
            return true;
        }
        return enableLynxCardPrefetchWithBid.booleanValue();
    }

    public static final boolean enableAnnieXLitePage() {
        CommonConfig commonConfig;
        Boolean enableAnnieXLitePage;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXLitePage = commonConfig.getEnableAnnieXLitePage()) == null) {
            return true;
        }
        return enableAnnieXLitePage.booleanValue();
    }

    public static final boolean enableAnnieXFlowPage() {
        CommonConfig commonConfig;
        Boolean enableAnnieXFlowPage;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXFlowPage = commonConfig.getEnableAnnieXFlowPage()) == null) {
            return true;
        }
        return enableAnnieXFlowPage.booleanValue();
    }

    public static final boolean enableAnnieXFlowPopup() {
        CommonConfig commonConfig;
        Boolean enableAnnieXFlowPopup;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXFlowPopup = commonConfig.getEnableAnnieXFlowPopup()) == null) {
            return true;
        }
        return enableAnnieXFlowPopup.booleanValue();
    }

    public static final List<String> enableAnnieXFlowSwitchWhiteList() {
        CommonConfig commonConfig;
        List<String> enableAnnieXFlowSwitchWhiteList;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        return (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXFlowSwitchWhiteList = commonConfig.getEnableAnnieXFlowSwitchWhiteList()) == null) ? CollectionsKt.emptyList() : enableAnnieXFlowSwitchWhiteList;
    }

    public static final int annieXLitePageFixCloseAfterOpenInternal() {
        CommonConfig commonConfig;
        Integer annieXLitePageFixCloseAfterOpenInternal;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        return (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (annieXLitePageFixCloseAfterOpenInternal = commonConfig.getAnnieXLitePageFixCloseAfterOpenInternal()) == null) ? PatchException.ERR_LOAD_SO_MD5_NOT_MATCH : annieXLitePageFixCloseAfterOpenInternal.intValue();
    }

    public static final int annieXLitePageFixCloseAfterOpenSuccessInternal() {
        CommonConfig commonConfig;
        Integer annieXLitePageFixCloseAfterOpenSuccessInternal;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        return (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (annieXLitePageFixCloseAfterOpenSuccessInternal = commonConfig.getAnnieXLitePageFixCloseAfterOpenSuccessInternal()) == null) ? PatchException.ERR_LOAD_SO_MD5_NOT_MATCH : annieXLitePageFixCloseAfterOpenSuccessInternal.intValue();
    }

    public static final int annieXStreamPrefetchChunkSize() {
        CommonConfig commonConfig;
        Integer annieXStreamPrefetchChunkSize;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (annieXStreamPrefetchChunkSize = commonConfig.getAnnieXStreamPrefetchChunkSize()) == null) {
            return 102400;
        }
        return annieXStreamPrefetchChunkSize.intValue();
    }

    public static final boolean enablePrefetchDataGlobalProps() {
        CommonConfig commonConfig;
        Boolean enablePrefetchDataGlobalProps;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enablePrefetchDataGlobalProps = commonConfig.getEnablePrefetchDataGlobalProps()) == null) {
            return true;
        }
        return enablePrefetchDataGlobalProps.booleanValue();
    }

    public static final boolean disablePopupStatusBarParams() {
        CommonConfig commonConfig;
        Boolean disablePopupStatusBarParams;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (disablePopupStatusBarParams = commonConfig.getDisablePopupStatusBarParams()) == null) {
            return true;
        }
        return disablePopupStatusBarParams.booleanValue();
    }

    public static final boolean enableJsonOpt() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) {
            return false;
        }
        return provideBulletSettings.getEnableJsonOpt();
    }

    public static final boolean enableAnnieXPageSoftInputModeDefault() {
        CommonConfig commonConfig;
        Boolean enableAnnieXPageSoftInputModeDefault;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXPageSoftInputModeDefault = commonConfig.getEnableAnnieXPageSoftInputModeDefault()) == null) {
            return true;
        }
        return enableAnnieXPageSoftInputModeDefault.booleanValue();
    }

    public static final boolean enableAnnieXLiveDialogClickMaskCloseFix() {
        CommonConfig commonConfig;
        Boolean enableAnnieXLiveDialogClickMaskCloseFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXLiveDialogClickMaskCloseFix = commonConfig.getEnableAnnieXLiveDialogClickMaskCloseFix()) == null) {
            return true;
        }
        return enableAnnieXLiveDialogClickMaskCloseFix.booleanValue();
    }

    public static final List<String> getAnnieXLiveTokenParamAdaptionList() {
        CommonConfig commonConfig;
        List<String> annieXLiveTokenParamAdaptionList;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        return (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (annieXLiveTokenParamAdaptionList = commonConfig.getAnnieXLiveTokenParamAdaptionList()) == null) ? CollectionsKt.emptyList() : annieXLiveTokenParamAdaptionList;
    }

    public static final boolean enableECStatefulMethodsFragmentSceneFix() {
        CommonConfig commonConfig;
        Boolean enableECStatefulMethodsFragmentSceneFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableECStatefulMethodsFragmentSceneFix = commonConfig.getEnableECStatefulMethodsFragmentSceneFix()) == null) {
            return true;
        }
        return enableECStatefulMethodsFragmentSceneFix.booleanValue();
    }

    public static final boolean enableAnnieXPopupLoopMeasureFix() {
        CommonConfig commonConfig;
        Boolean enableAnnieXPopupLoopMeasureFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXPopupLoopMeasureFix = commonConfig.getEnableAnnieXPopupLoopMeasureFix()) == null) {
            return true;
        }
        return enableAnnieXPopupLoopMeasureFix.booleanValue();
    }

    public static final boolean enableAnnieXLiveMethodFactoryFix() {
        CommonConfig commonConfig;
        Boolean enableAnnieXLiveMethodFactoryFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXLiveMethodFactoryFix = commonConfig.getEnableAnnieXLiveMethodFactoryFix()) == null) {
            return true;
        }
        return enableAnnieXLiveMethodFactoryFix.booleanValue();
    }

    public static final boolean enableAnnieXLiveMethodFactoryMapFix() {
        CommonConfig commonConfig;
        Boolean enableAnnieXLiveMethodFactoryMapFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXLiveMethodFactoryMapFix = commonConfig.getEnableAnnieXLiveMethodFactoryMapFix()) == null) {
            return true;
        }
        return enableAnnieXLiveMethodFactoryMapFix.booleanValue();
    }

    public static final boolean enableLiveMethodFactoryRegisterMonitor() {
        CommonConfig commonConfig;
        Boolean enableLiveMethodFactoryRegisterMonitor;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableLiveMethodFactoryRegisterMonitor = commonConfig.getEnableLiveMethodFactoryRegisterMonitor()) == null) {
            return true;
        }
        return enableLiveMethodFactoryRegisterMonitor.booleanValue();
    }

    public static final boolean enableAnnieXWebKitKeyboardFix() {
        CommonConfig commonConfig;
        Boolean enableAnnieXWebKitKeyboardFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXWebKitKeyboardFix = commonConfig.getEnableAnnieXWebKitKeyboardFix()) == null) {
            return true;
        }
        return enableAnnieXWebKitKeyboardFix.booleanValue();
    }

    public static final boolean enableSafeAreaHeight() {
        CommonConfig commonConfig;
        Boolean enableSafeAreaHeight;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableSafeAreaHeight = commonConfig.getEnableSafeAreaHeight()) == null) {
            return false;
        }
        return enableSafeAreaHeight.booleanValue();
    }

    public static final boolean enableAnnieXLiveBcmChainFix() {
        CommonConfig commonConfig;
        Boolean enableAnnieXLiveBcmChainFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXLiveBcmChainFix = commonConfig.getEnableAnnieXLiveBcmChainFix()) == null) {
            return true;
        }
        return enableAnnieXLiveBcmChainFix.booleanValue();
    }

    public static final boolean enableAnnieXBridgeThreadOpt() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) {
            return true;
        }
        return provideBulletSettings.getEnableAnnieXBridgeThreadOpt();
    }

    public static final int annieXFlowCacheSize() {
        CommonConfig commonConfig;
        Integer annieXFlowCacheSize;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (annieXFlowCacheSize = commonConfig.getAnnieXFlowCacheSize()) == null) {
            return 5;
        }
        return annieXFlowCacheSize.intValue();
    }

    public static final int annieXFlowReleaseInternal() {
        CommonConfig commonConfig;
        Integer annieXFlowReleaseInternal;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (annieXFlowReleaseInternal = commonConfig.getAnnieXFlowReleaseInternal()) == null) {
            return 10000;
        }
        return annieXFlowReleaseInternal.intValue();
    }

    public static final boolean annieFlowEnableUrlSessionId() {
        CommonConfig commonConfig;
        Boolean annieFlowEnableUrlSessionId;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (annieFlowEnableUrlSessionId = commonConfig.getAnnieFlowEnableUrlSessionId()) == null) {
            return true;
        }
        return annieFlowEnableUrlSessionId.booleanValue();
    }

    public static final boolean enableSLMonitorJSBErrorParams() {
        CommonConfig commonConfig;
        Boolean enableSLMonitorJSBErrorParams;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableSLMonitorJSBErrorParams = commonConfig.getEnableSLMonitorJSBErrorParams()) == null) {
            return true;
        }
        return enableSLMonitorJSBErrorParams.booleanValue();
    }

    public static final List<String> annieFlowBlackList() {
        CommonConfig commonConfig;
        List<String> annieXFlowBlackList;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        return (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (annieXFlowBlackList = commonConfig.getAnnieXFlowBlackList()) == null) ? new ArrayList() : annieXFlowBlackList;
    }

    public static final List<String> annieLiteBlackList() {
        CommonConfig commonConfig;
        List<String> annieXLiteBlackList;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        return (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (annieXLiteBlackList = commonConfig.getAnnieXLiteBlackList()) == null) ? new ArrayList() : annieXLiteBlackList;
    }

    public static final List<String> annieFlowWhiteList() {
        CommonConfig commonConfig;
        List<String> annieXFlowWhiteList;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        return (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (annieXFlowWhiteList = commonConfig.getAnnieXFlowWhiteList()) == null) ? new ArrayList() : annieXFlowWhiteList;
    }

    public static final List<String> annieLiteWhiteList() {
        CommonConfig commonConfig;
        List<String> annieXLiteWhiteList;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        return (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (annieXLiteWhiteList = commonConfig.getAnnieXLiteWhiteList()) == null) ? new ArrayList() : annieXLiteWhiteList;
    }

    public static final boolean annieXLiteExtraJSBFix() {
        CommonConfig commonConfig;
        Boolean annieXLiteExtraJSBFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (annieXLiteExtraJSBFix = commonConfig.getAnnieXLiteExtraJSBFix()) == null) {
            return true;
        }
        return annieXLiteExtraJSBFix.booleanValue();
    }

    public static final boolean enableWorkerEventReset() {
        CommonConfig commonConfig;
        Boolean enable_worker_event_reset;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enable_worker_event_reset = commonConfig.getEnable_worker_event_reset()) == null) {
            return true;
        }
        return enable_worker_event_reset.booleanValue();
    }

    public static final boolean enableAnnieXEndToEndReport() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return true;
        }
        return commonConfig.getEnableAnnieXEndToEndReport();
    }

    public static final boolean enableAnnieXLoadEngineExpFix() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return true;
        }
        return commonConfig.getEnableAnnieXLoadEngineExpFix();
    }

    public static final boolean enableAnnieXWorkerMd5Check() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return true;
        }
        return commonConfig.getEnableAnnieXWorkerMd5Check();
    }

    public static final boolean enableAnnieXFixDownloadWorkerJSByCDN() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return true;
        }
        return commonConfig.getEnableAnnieXFixDownloadWorkerJSByCDN();
    }

    public static final boolean enableAnnieXWorkerTaskInitOnce() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return true;
        }
        return commonConfig.getEnableAnnieXWorkerTaskInitOnce();
    }

    public static final boolean enableAnnieXWorkerTaskInitImmediately() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return true;
        }
        return commonConfig.getEnableAnnieXWorkerTaskInitImmediately();
    }

    public static final boolean enableViewAttachStack() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return true;
        }
        return commonConfig.getEnableViewAttachStack();
    }

    public static final boolean enableBridgeCanRunInBackgroundFix() {
        CommonConfig commonConfig;
        Boolean enableBridgeCanRunInBackgroundFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableBridgeCanRunInBackgroundFix = commonConfig.getEnableBridgeCanRunInBackgroundFix()) == null) {
            return true;
        }
        return enableBridgeCanRunInBackgroundFix.booleanValue();
    }

    public static final boolean enableAnnieXDialogHideAbleFix() {
        CommonConfig commonConfig;
        Boolean enableAnnieXDialogHideAbleFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXDialogHideAbleFix = commonConfig.getEnableAnnieXDialogHideAbleFix()) == null) {
            return true;
        }
        return enableAnnieXDialogHideAbleFix.booleanValue();
    }

    public static final boolean enableAnnieXDialogNestedScrollFix() {
        CommonConfig commonConfig;
        Boolean enableAnnieXDialogNestedScrollFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXDialogNestedScrollFix = commonConfig.getEnableAnnieXDialogNestedScrollFix()) == null) {
            return true;
        }
        return enableAnnieXDialogNestedScrollFix.booleanValue();
    }

    public static final boolean disableTouchOutsizeA11yFocusFix() {
        CommonConfig commonConfig;
        Boolean disableTouchOutsizeA11yFocus;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (disableTouchOutsizeA11yFocus = commonConfig.getDisableTouchOutsizeA11yFocus()) == null) {
            return false;
        }
        return disableTouchOutsizeA11yFocus.booleanValue();
    }

    public static final boolean enableAnnieXPadAdapterGravityFix() {
        CommonConfig commonConfig;
        Boolean enableAnnieXPadAdapterGravityFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXPadAdapterGravityFix = commonConfig.getEnableAnnieXPadAdapterGravityFix()) == null) {
            return true;
        }
        return enableAnnieXPadAdapterGravityFix.booleanValue();
    }

    public static final boolean enableAnnieXLiveTypeSchemaFieldFix() {
        CommonConfig commonConfig;
        Boolean enableAnnieXLiveTypeSchemaFieldFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXLiveTypeSchemaFieldFix = commonConfig.getEnableAnnieXLiveTypeSchemaFieldFix()) == null) {
            return true;
        }
        return enableAnnieXLiveTypeSchemaFieldFix.booleanValue();
    }

    public static final boolean enableForceBindBulletPopupService() {
        CommonConfig commonConfig;
        Boolean enableForceBindBulletPopupService;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableForceBindBulletPopupService = commonConfig.getEnableForceBindBulletPopupService()) == null) {
            return true;
        }
        return enableForceBindBulletPopupService.booleanValue();
    }

    public static final boolean enableAnnieXWebcastWebPopupSoftInputAdapter() {
        CommonConfig commonConfig;
        Boolean enableAnnieXWebcastWebPopupSoftInputAdapter;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXWebcastWebPopupSoftInputAdapter = commonConfig.getEnableAnnieXWebcastWebPopupSoftInputAdapter()) == null) {
            return true;
        }
        return enableAnnieXWebcastWebPopupSoftInputAdapter.booleanValue();
    }

    public static final boolean enableAnnieXWebcastInitDataThreadOpt() {
        CommonConfig commonConfig;
        Boolean enableAnnieXWebcastInitDataThreadOpt;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXWebcastInitDataThreadOpt = commonConfig.getEnableAnnieXWebcastInitDataThreadOpt()) == null) {
            return true;
        }
        return enableAnnieXWebcastInitDataThreadOpt.booleanValue();
    }

    public static final boolean enableXBridgeParamProxyEnhancement() {
        CommonConfig commonConfig;
        Boolean enableXBridgeParamProxyEnhancement;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableXBridgeParamProxyEnhancement = commonConfig.getEnableXBridgeParamProxyEnhancement()) == null) {
            return true;
        }
        return enableXBridgeParamProxyEnhancement.booleanValue();
    }

    public static final boolean enableFlowUpdateContext() {
        CommonConfig commonConfig;
        Boolean enableFlowUpdateContext;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableFlowUpdateContext = commonConfig.getEnableFlowUpdateContext()) == null) {
            return true;
        }
        return enableFlowUpdateContext.booleanValue();
    }

    public static final boolean shouldIgnoreHttpStatusCode(Integer num) {
        CommonConfig commonConfig;
        List<Integer> ignoreHttpStatusCode;
        if (num == null) {
            return false;
        }
        int intValue = num.intValue();
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (ignoreHttpStatusCode = commonConfig.getIgnoreHttpStatusCode()) == null) {
            return false;
        }
        return ignoreHttpStatusCode.contains(Integer.valueOf(intValue));
    }

    public static final boolean switchBridgeDownloadToDownloader() {
        CommonConfig commonConfig;
        Boolean switchBridgeDownloadToDownloader;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (switchBridgeDownloadToDownloader = commonConfig.getSwitchBridgeDownloadToDownloader()) == null) {
            return true;
        }
        return switchBridgeDownloadToDownloader.booleanValue();
    }

    public static final int annieXLiveJSB2InstanceLimit() {
        CommonConfig commonConfig;
        Integer annieXLiveJSB2InstanceLimit;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (annieXLiveJSB2InstanceLimit = commonConfig.getAnnieXLiveJSB2InstanceLimit()) == null) {
            return 0;
        }
        return annieXLiveJSB2InstanceLimit.intValue();
    }

    public static final boolean enableJsbBridgeReleaseOpt() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) {
            return true;
        }
        return provideBulletSettings.getEnableBridgeLeakFix();
    }

    public static final boolean enableAnnieXRealScreenSizeFix() {
        CommonConfig commonConfig;
        Boolean enableAnnieXRealScreenSizeFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXRealScreenSizeFix = commonConfig.getEnableAnnieXRealScreenSizeFix()) == null) {
            return true;
        }
        return enableAnnieXRealScreenSizeFix.booleanValue();
    }

    public static final boolean enableAnnieXJsbParamInNumberAdapterFix() {
        CommonConfig commonConfig;
        Boolean enableAnnieXJsbParamInNumberAdapterFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXJsbParamInNumberAdapterFix = commonConfig.getEnableAnnieXJsbParamInNumberAdapterFix()) == null) {
            return true;
        }
        return enableAnnieXJsbParamInNumberAdapterFix.booleanValue();
    }

    public static final boolean enableArgusFetchCdnConfigInternal() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) {
            return true;
        }
        return provideBulletSettings.getEnableArgusFetchCdnConfigInternal();
    }

    public static final boolean enableSecLinkReportEntry() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        return (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null || !provideBulletSettings.getEnableSecLinkReportEntry()) ? false : true;
    }

    public static final boolean enableWebKitViewUpdateGlobalProps() {
        CommonConfig commonConfig;
        Boolean enableWebKitViewUpdateGlobalProps;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableWebKitViewUpdateGlobalProps = commonConfig.getEnableWebKitViewUpdateGlobalProps()) == null) {
            return true;
        }
        return enableWebKitViewUpdateGlobalProps.booleanValue();
    }

    public static final boolean enableOrientationOnLayoutChange(Uri uri) {
        CommonConfig commonConfig;
        Intrinsics.checkNotNullParameter(uri, "uri");
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        List<String> orientationOnLayoutChangeBlackList = (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) ? null : commonConfig.getOrientationOnLayoutChangeBlackList();
        String str = uri2;
        if (str.length() > 0) {
            List<String> list = orientationOnLayoutChangeBlackList;
            if (!(list == null || list.isEmpty())) {
                Iterator<T> it = orientationOnLayoutChangeBlackList.iterator();
                while (it.hasNext()) {
                    if (StringsKt.contains$default(str, (String) it.next(), false, 2, (Object) null)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static final boolean enableAnnieXOrientationEvent() {
        CommonConfig commonConfig;
        Boolean enableAnnieXOrientationEvent;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXOrientationEvent = commonConfig.getEnableAnnieXOrientationEvent()) == null) {
            return true;
        }
        return enableAnnieXOrientationEvent.booleanValue();
    }

    public static final boolean enableLitePageBidExpand() {
        CommonConfig commonConfig;
        Boolean enableLitePageBidExpand;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableLitePageBidExpand = commonConfig.getEnableLitePageBidExpand()) == null) {
            return true;
        }
        return enableLitePageBidExpand.booleanValue();
    }

    public static final boolean enableFixNeedOutAnimation() {
        CommonConfig commonConfig;
        Boolean enableFixNeedOutAnimation;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableFixNeedOutAnimation = commonConfig.getEnableFixNeedOutAnimation()) == null) {
            return true;
        }
        return enableFixNeedOutAnimation.booleanValue();
    }

    public static final boolean getEnableAnnieXUrlParamFix() {
        CommonConfig commonConfig;
        Boolean enableAnnieXUrlParamFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXUrlParamFix = commonConfig.getEnableAnnieXUrlParamFix()) == null) {
            return true;
        }
        return enableAnnieXUrlParamFix.booleanValue();
    }

    public static final boolean getEnableLitePageBidOpt() {
        CommonConfig commonConfig;
        Boolean enableLitePageBidOpt;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableLitePageBidOpt = commonConfig.getEnableLitePageBidOpt()) == null) {
            return true;
        }
        return enableLitePageBidOpt.booleanValue();
    }

    public static final boolean getEnableLitePageBidBehaviorOpt() {
        CommonConfig commonConfig;
        Boolean enableLitePageBidBehaviorOpt;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableLitePageBidBehaviorOpt = commonConfig.getEnableLitePageBidBehaviorOpt()) == null) {
            return true;
        }
        return enableLitePageBidBehaviorOpt.booleanValue();
    }

    public static final boolean enableLitePageBusinessBehavior() {
        CommonConfig commonConfig;
        Boolean enableLitePageBusinessBehavior;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableLitePageBusinessBehavior = commonConfig.getEnableLitePageBusinessBehavior()) == null) {
            return true;
        }
        return enableLitePageBusinessBehavior.booleanValue();
    }

    public static final boolean enableLitePageLiveInitFix() {
        CommonConfig commonConfig;
        Boolean enableLitePageLiveInitFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableLitePageLiveInitFix = commonConfig.getEnableLitePageLiveInitFix()) == null) {
            return true;
        }
        return enableLitePageLiveInitFix.booleanValue();
    }

    public static final boolean enablePadUpdateFrameBottomFix() {
        CommonConfig commonConfig;
        Boolean enablePadUpdateFrameBottomFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enablePadUpdateFrameBottomFix = commonConfig.getEnablePadUpdateFrameBottomFix()) == null) {
            return true;
        }
        return enablePadUpdateFrameBottomFix.booleanValue();
    }

    public static final boolean enableDpToPxRoundToIntFix() {
        CommonConfig commonConfig;
        Boolean enableDpToPxRoundToIntFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableDpToPxRoundToIntFix = commonConfig.getEnableDpToPxRoundToIntFix()) == null) {
            return true;
        }
        return enableDpToPxRoundToIntFix.booleanValue();
    }

    public static final boolean enablePadAdapterUniformStyle() {
        CommonConfig commonConfig;
        Boolean enablePadAdapterUniformStyle;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enablePadAdapterUniformStyle = commonConfig.getEnablePadAdapterUniformStyle()) == null) {
            return true;
        }
        return enablePadAdapterUniformStyle.booleanValue();
    }

    public static final boolean enablePadAdapterChannelStyle() {
        CommonConfig commonConfig;
        Boolean enablePadAdapterChannelStyle;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enablePadAdapterChannelStyle = commonConfig.getEnablePadAdapterChannelStyle()) == null) {
            return true;
        }
        return enablePadAdapterChannelStyle.booleanValue();
    }

    public static final boolean enablePadAdapterMigrationToUniformStyle(ISchemaData iSchemaData) {
        BulletSettings provideBulletSettings;
        List<String> padAdapterMigrationToUniformStyleWhiteList;
        BulletSettings provideBulletSettings2;
        Intrinsics.checkNotNullParameter(iSchemaData, "schemaData");
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if ((iSettingService == null || (provideBulletSettings2 = iSettingService.provideBulletSettings()) == null || !provideBulletSettings2.getEnablePadAdapterMigrationToUniformStyle()) ? false : true) {
            return true;
        }
        String uri = iSchemaData.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "schemaData.url.toString()");
        ISettingService iSettingService2 = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService2 != null && (provideBulletSettings = iSettingService2.provideBulletSettings()) != null && (padAdapterMigrationToUniformStyleWhiteList = provideBulletSettings.getPadAdapterMigrationToUniformStyleWhiteList()) != null) {
            Iterator<T> it = padAdapterMigrationToUniformStyleWhiteList.iterator();
            while (it.hasNext()) {
                if (StringsKt.contains$default(uri, (String) it.next(), false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean enableAnniexFlowCancelFix() {
        CommonConfig commonConfig;
        Boolean enableAnniexFlowCancelFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnniexFlowCancelFix = commonConfig.getEnableAnniexFlowCancelFix()) == null) {
            return true;
        }
        return enableAnniexFlowCancelFix.booleanValue();
    }

    public static final boolean enableLitePageBridgeFix() {
        CommonConfig commonConfig;
        Boolean enableLitePageBridgeFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableLitePageBridgeFix = commonConfig.getEnableLitePageBridgeFix()) == null) {
            return true;
        }
        return enableLitePageBridgeFix.booleanValue();
    }

    public static final boolean enableAnnieXPadOrFoldPopupHeightFix() {
        CommonConfig commonConfig;
        Boolean enableAnnieXPadOrFoldPopupHeightFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXPadOrFoldPopupHeightFix = commonConfig.getEnableAnnieXPadOrFoldPopupHeightFix()) == null) {
            return true;
        }
        return enableAnnieXPadOrFoldPopupHeightFix.booleanValue();
    }

    public static final boolean enableAnnieXIgnoreJSB2Failure() {
        CommonConfig commonConfig;
        Boolean enableAnnieXIgnoreJSB2Failure;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXIgnoreJSB2Failure = commonConfig.getEnableAnnieXIgnoreJSB2Failure()) == null) {
            return true;
        }
        return enableAnnieXIgnoreJSB2Failure.booleanValue();
    }

    public static final boolean enableLynxViewBuilderParamsFix() {
        CommonConfig commonConfig;
        Boolean enableLynxViewBuilderParamsFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableLynxViewBuilderParamsFix = commonConfig.getEnableLynxViewBuilderParamsFix()) == null) {
            return true;
        }
        return enableLynxViewBuilderParamsFix.booleanValue();
    }

    public static final boolean enablePadPopupMigrationToUniformStyle(ISchemaData iSchemaData) {
        BulletSettings provideBulletSettings;
        List<String> padPopupMigrationToUniformStyleWhiteList;
        BulletSettings provideBulletSettings2;
        Intrinsics.checkNotNullParameter(iSchemaData, "schemaData");
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if ((iSettingService == null || (provideBulletSettings2 = iSettingService.provideBulletSettings()) == null || !provideBulletSettings2.getEnablePadPopupMigrationToUniformStyle()) ? false : true) {
            return true;
        }
        String uri = iSchemaData.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "schemaData.url.toString()");
        ISettingService iSettingService2 = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService2 != null && (provideBulletSettings = iSettingService2.provideBulletSettings()) != null && (padPopupMigrationToUniformStyleWhiteList = provideBulletSettings.getPadPopupMigrationToUniformStyleWhiteList()) != null) {
            Iterator<T> it = padPopupMigrationToUniformStyleWhiteList.iterator();
            while (it.hasNext()) {
                if (StringsKt.contains$default(uri, (String) it.next(), false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean fixPrefetchQueryObject() {
        CommonConfig commonConfig;
        Boolean fixPrefetchQueryObject;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (fixPrefetchQueryObject = commonConfig.getFixPrefetchQueryObject()) == null) {
            return true;
        }
        return fixPrefetchQueryObject.booleanValue();
    }

    public static final boolean enableFlowPageCloseFix() {
        CommonConfig commonConfig;
        Boolean enableFlowPageCloseFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableFlowPageCloseFix = commonConfig.getEnableFlowPageCloseFix()) == null) {
            return true;
        }
        return enableFlowPageCloseFix.booleanValue();
    }

    public static final boolean enableFlowPageAnnieInitFix() {
        CommonConfig commonConfig;
        Boolean enableFlowPageAnnieInitFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableFlowPageAnnieInitFix = commonConfig.getEnableFlowPageAnnieInitFix()) == null) {
            return true;
        }
        return enableFlowPageAnnieInitFix.booleanValue();
    }

    public static final boolean enableOrientationGPFix() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return false;
        }
        return Intrinsics.areEqual(commonConfig.getEnableOrientationGPFix(), true);
    }

    public static final boolean enableFlowPageContextFix() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return false;
        }
        return Intrinsics.areEqual(commonConfig.getEnableFlowPageContextFix(), true);
    }

    public static final boolean enableAnnieXLiveJSBCodeFix() {
        CommonConfig commonConfig;
        Boolean enableAnnieXLiveJSBCodeFix;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableAnnieXLiveJSBCodeFix = commonConfig.getEnableAnnieXLiveJSBCodeFix()) == null) {
            return true;
        }
        return enableAnnieXLiveJSBCodeFix.booleanValue();
    }

    public static final boolean disableAnnieXPopupPadAdapter() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return false;
        }
        return Intrinsics.areEqual(commonConfig.getDisableAnnieXPopupPadAdapter(), true);
    }

    public static final boolean enableHybridMultiCustomReport() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return false;
        }
        return Intrinsics.areEqual(commonConfig.getEnableHybridMultiCustomReport(), true);
    }

    public static final boolean enableAnnieXLiveLynxInitDataFix() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return false;
        }
        return Intrinsics.areEqual(commonConfig.getEnableAnnieXLiveLynxInitDataFix(), true);
    }

    public static final boolean enableAnnieXLitePageClose() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return false;
        }
        return Intrinsics.areEqual(commonConfig.getEnableAnnieXLitePageClose(), true);
    }

    public static final boolean enableAnnieXBulletFallback() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return false;
        }
        return Intrinsics.areEqual(commonConfig.getEnableAnnieXBulletFallback(), true);
    }

    public static final boolean enableBulletSettingDelay() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        return (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null || !provideBulletSettings.getEnableBulletSettingDelay()) ? false : true;
    }

    public static final void delayRunbulletSetting(Function0<Unit> function0) {
        BulletSettings provideBulletSettings;
        LegoBootFinishCommitter bulletSettingRunner;
        Intrinsics.checkNotNullParameter(function0, MetricConstant.MONITOR_STAGE_UPDATE);
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null || (bulletSettingRunner = provideBulletSettings.getBulletSettingRunner()) == null) {
            return;
        }
        bulletSettingRunner.start(function0);
    }

    public static final boolean enableAnnieConvertJsonOpt() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) {
            return false;
        }
        return provideBulletSettings.getEnableAnnieConvertJsonOpt();
    }

    public static final boolean enableWebcastLitePageGlobalPropsFix() {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) {
            return false;
        }
        return Intrinsics.areEqual(commonConfig.getEnableWebcastLitePageGlobalPropsFix(), true);
    }

    public static final boolean fixAnnieXMethodFinder() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) {
            return false;
        }
        return provideBulletSettings.getFixAnnieXMethodFinder();
    }

    public static final boolean enableAnnieXPadGPContainerMigration() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        return (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null || !provideBulletSettings.getEnableAnnieXPadGPContainerMigration()) ? false : true;
    }

    public static final boolean enableToutiaoGlobalPropsInject() {
        CommonConfig commonConfig;
        Boolean enableToutiaoGlobalPropsInject;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableToutiaoGlobalPropsInject = commonConfig.getEnableToutiaoGlobalPropsInject()) == null) {
            return true;
        }
        return enableToutiaoGlobalPropsInject.booleanValue();
    }

    public static final boolean enableFixDialogDestroy() {
        CommonConfig commonConfig;
        Boolean enableFixDialogDestroy;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enableFixDialogDestroy = commonConfig.getEnableFixDialogDestroy()) == null) {
            return true;
        }
        return enableFixDialogDestroy.booleanValue();
    }
}
