package com.bytedance.ies.bullet.interaction.predefine;

import android.net.Uri;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.HybridLoggerConst;
import com.bytedance.ies.bullet.interaction.predefine.api.IPredefine;
import com.bytedance.ies.bullet.interaction.predefine.api.IPredefineFileLoader;
import com.bytedance.ies.bullet.interaction.predefine.fileLoader.MetaFileLoader;
import com.bytedance.ies.bullet.interaction.predefine.model.JSFileCacheModel;
import com.bytedance.ies.bullet.interaction.predefine.model.MetaModelConfig;
import com.bytedance.ies.bullet.interaction.predefine.model.WasmDisableListConfig;
import com.bytedance.ies.bullet.interaction.predefine.monitor.PredefineMonitorMethod;
import com.bytedance.ies.bullet.interaction.predefine.monitor.PredefineRecordInfo;
import com.bytedance.ies.bullet.interaction.predefine.monitor.PredefineReportInfo;
import com.bytedance.ies.bullet.service.base.IPreLoadServiceKt;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.router.RouterServiceKt;
import com.bytedance.pia.core.plugins.BootPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PredefineManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018H\u0016J$\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u001b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u001f\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010\u00162\u0006\u0010!\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/bytedance/ies/bullet/interaction/predefine/PredefineManager;", "Lcom/bytedance/ies/bullet/interaction/predefine/api/IPredefine;", "()V", "SCHEMA_CONFIG_TAG", "", "SCHEMA_TAG", "cacheJSFilePath", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/ies/bullet/interaction/predefine/model/JSFileCacheModel;", "getCacheJSFilePath", "()Ljava/util/concurrent/ConcurrentHashMap;", "fileLoader", "Lcom/bytedance/ies/bullet/interaction/predefine/api/IPredefineFileLoader;", "getFileLoader", "()Lcom/bytedance/ies/bullet/interaction/predefine/api/IPredefineFileLoader;", "setFileLoader", "(Lcom/bytedance/ies/bullet/interaction/predefine/api/IPredefineFileLoader;)V", "findTargetJsFile", "", "uri", "Landroid/net/Uri;", "metaModelConfig", "Lcom/bytedance/ies/bullet/interaction/predefine/model/MetaModelConfig;", "matchRule", "", "getTargetJsFiles", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getWasmDisableConfig", BootPlugin.RESULT_CONFIG_KEY, "predefine", "recordReportInfo", "metaConfig", "decodeUri", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PredefineManager implements IPredefine {
    public static IPredefineFileLoader fileLoader;
    public static final PredefineManager INSTANCE = new PredefineManager();
    private static final String SCHEMA_TAG = "predefine";
    private static final String SCHEMA_CONFIG_TAG = "predefine_config";
    private static final ConcurrentHashMap<String, JSFileCacheModel> cacheJSFilePath = new ConcurrentHashMap<>();

    private PredefineManager() {
    }

    public final IPredefineFileLoader getFileLoader() {
        IPredefineFileLoader iPredefineFileLoader = fileLoader;
        if (iPredefineFileLoader != null) {
            return iPredefineFileLoader;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fileLoader");
        return null;
    }

    public final void setFileLoader(IPredefineFileLoader iPredefineFileLoader) {
        Intrinsics.checkNotNullParameter(iPredefineFileLoader, "<set-?>");
        fileLoader = iPredefineFileLoader;
    }

    public final ConcurrentHashMap<String, JSFileCacheModel> getCacheJSFilePath() {
        return cacheJSFilePath;
    }

    @Override // com.bytedance.ies.bullet.interaction.predefine.api.IPredefine
    public void predefine(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        MetaModelConfig metaModelConfig = iBulletSettingsService != null ? (MetaModelConfig) iBulletSettingsService.obtainSettings(MetaModelConfig.class) : null;
        Uri parse = Uri.parse(Uri.decode(uri.toString()));
        if (metaModelConfig != null ? Intrinsics.areEqual(metaModelConfig.getEnablePredefine(), true) : false) {
            setFileLoader(new MetaFileLoader(metaModelConfig));
            Intrinsics.checkNotNullExpressionValue(parse, "decodeUri");
            findTargetJsFile(parse, metaModelConfig);
        }
    }

    private final void recordReportInfo(MetaModelConfig metaConfig, Uri decodeUri) {
        PredefineMonitorMethod.Companion companion = PredefineMonitorMethod.INSTANCE;
        String uri = decodeUri.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "decodeUri.toString()");
        companion.setUrl(uri);
        PredefineReportInfo predefineReportInfo = new PredefineReportInfo();
        HashMap<String, PredefineReportInfo> records = PredefineMonitorMethod.INSTANCE.getRecords();
        String uri2 = decodeUri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "decodeUri.toString()");
        records.put(uri2, predefineReportInfo);
        if (!(metaConfig != null ? Intrinsics.areEqual(metaConfig.getEnablePredefine(), true) : false)) {
            predefineReportInfo.setClientPredefineEnable(metaConfig != null ? Intrinsics.areEqual(metaConfig.getEnablePredefine(), true) : false);
            predefineReportInfo.setClientMetaFetch(metaConfig != null);
            predefineReportInfo.getPredefineRecords().clear();
        } else {
            setFileLoader(new MetaFileLoader(metaConfig));
            predefineReportInfo.setClientMetaFetch(true);
            predefineReportInfo.setClientPredefineEnable(true);
            predefineReportInfo.getPredefineRecords().clear();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0023 A[Catch: Exception -> 0x003b, TRY_LEAVE, TryCatch #0 {Exception -> 0x003b, blocks: (B:3:0x000b, B:5:0x0016, B:12:0x0023), top: B:2:0x000b }] */
    @Override // com.bytedance.ies.bullet.interaction.predefine.api.IPredefine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void findTargetJsFile(Uri uri, MetaModelConfig metaModelConfig) {
        boolean z;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(metaModelConfig, "metaModelConfig");
        try {
            String queryParameter = uri.getQueryParameter(SCHEMA_TAG);
            String str = queryParameter;
            if (str != null && str.length() != 0) {
                z = false;
                if (z) {
                    recordReportInfo(metaModelConfig, uri);
                    findTargetJsFile(uri, StringsKt.split$default(queryParameter, new String[]{","}, false, 0, 6, (Object) null));
                    return;
                }
                return;
            }
            z = true;
            if (z) {
            }
        } catch (Exception e) {
            HybridLogger hybridLogger = HybridLogger.INSTANCE;
            StringBuilder sb = new StringBuilder("findTargetJsFile error:");
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            HybridLogger.e$default(hybridLogger, HybridLoggerConst.MODULE_PREDEFINE, sb.append(message).toString(), null, null, 12, null);
        }
    }

    @Override // com.bytedance.ies.bullet.interaction.predefine.api.IPredefine
    public void findTargetJsFile(Uri uri, List<String> matchRule) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(matchRule, "matchRule");
        if (matchRule.isEmpty() && fileLoader == null) {
            return;
        }
        List<String> wasmDisableConfig = getWasmDisableConfig(RouterServiceKt.getQueryParameterSafely(uri, SCHEMA_CONFIG_TAG));
        for (String str : matchRule) {
            boolean z = false;
            if (wasmDisableConfig != null && wasmDisableConfig.contains(str)) {
                z = true;
            }
            if (z) {
                PredefineRecordInfo predefineRecordInfo = new PredefineRecordInfo(str, -1L, "", true);
                PredefineReportInfo predefineReportInfo = PredefineMonitorMethod.INSTANCE.getRecords().get(uri.toString());
                if (predefineReportInfo == null) {
                    predefineReportInfo = new PredefineReportInfo();
                }
                predefineReportInfo.getPredefineRecords().add(predefineRecordInfo);
                HashMap<String, PredefineReportInfo> records = PredefineMonitorMethod.INSTANCE.getRecords();
                String uri2 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
                records.put(uri2, predefineReportInfo);
            } else {
                IPredefineFileLoader fileLoader2 = getFileLoader();
                String uri3 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri3, "uri.toString()");
                fileLoader2.loadFile(str, uri3);
            }
        }
    }

    @Override // com.bytedance.ies.bullet.interaction.predefine.api.IPredefine
    public ArrayList<String> getTargetJsFiles(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String queryParameter = Uri.parse(Uri.decode(uri.toString())).getQueryParameter(SCHEMA_TAG);
        if (queryParameter == null || queryParameter.length() == 0) {
            return null;
        }
        List<String> split$default = StringsKt.split$default(queryParameter, new String[]{","}, false, 0, 6, (Object) null);
        ArrayList<String> arrayList = new ArrayList<>();
        List<String> wasmDisableConfig = getWasmDisableConfig(RouterServiceKt.getQueryParameterSafely(uri, SCHEMA_CONFIG_TAG));
        for (String str : split$default) {
            if (!(wasmDisableConfig != null && wasmDisableConfig.contains(str))) {
                JSFileCacheModel jSFileCacheModel = cacheJSFilePath.get(str);
                if ((jSFileCacheModel != null ? jSFileCacheModel.getFilePath() : null) != null) {
                    if (jSFileCacheModel.getFilePath().length() > 0) {
                        arrayList.add(jSFileCacheModel.getFilePath());
                    }
                }
            }
        }
        return arrayList;
    }

    private final List<String> getWasmDisableConfig(String configKey) {
        JSONArray optJSONArray;
        JSONObject config;
        if (configKey == null) {
            return null;
        }
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        WasmDisableListConfig wasmDisableListConfig = iBulletSettingsService != null ? (WasmDisableListConfig) iBulletSettingsService.obtainSettings(WasmDisableListConfig.class) : null;
        HybridLogger.i$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "getWasmDisableConfig configKey:" + configKey + ",wasmDisableList:null", null, null, 12, null);
        if (((wasmDisableListConfig == null || (config = wasmDisableListConfig.getConfig()) == null) ? null : config.optJSONArray(configKey)) == null || (optJSONArray = wasmDisableListConfig.getConfig().optJSONArray(configKey)) == null) {
            return null;
        }
        return IPreLoadServiceKt.toStringList(optJSONArray);
    }
}
