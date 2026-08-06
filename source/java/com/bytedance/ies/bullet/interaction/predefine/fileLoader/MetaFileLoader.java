package com.bytedance.ies.bullet.interaction.predefine.fileLoader;

import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.HybridLoggerConst;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.interaction.predefine.PredefineManager;
import com.bytedance.ies.bullet.interaction.predefine.api.IPredefineFileLoader;
import com.bytedance.ies.bullet.interaction.predefine.model.JSFileCacheModel;
import com.bytedance.ies.bullet.interaction.predefine.model.MetaExternal;
import com.bytedance.ies.bullet.interaction.predefine.model.MetaFilePath;
import com.bytedance.ies.bullet.interaction.predefine.model.MetaModelConfig;
import com.bytedance.ies.bullet.interaction.predefine.model.Signature;
import com.bytedance.ies.bullet.interaction.predefine.monitor.PredefineMonitorMethod;
import com.bytedance.ies.bullet.interaction.predefine.monitor.PredefineRecordInfo;
import com.bytedance.ies.bullet.interaction.predefine.monitor.PredefineReportInfo;
import com.bytedance.ies.bullet.interaction.predefine.security.PredefineFileValidate;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MetaFileLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/interaction/predefine/fileLoader/MetaFileLoader;", "Lcom/bytedance/ies/bullet/interaction/predefine/api/IPredefineFileLoader;", "metaModelConfig", "Lcom/bytedance/ies/bullet/interaction/predefine/model/MetaModelConfig;", "(Lcom/bytedance/ies/bullet/interaction/predefine/model/MetaModelConfig;)V", "fileValidate", "Lcom/bytedance/ies/bullet/interaction/predefine/security/PredefineFileValidate;", "loadFile", "", "matchRuleItem", "", "url", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class MetaFileLoader implements IPredefineFileLoader {
    private final PredefineFileValidate fileValidate;
    private final MetaModelConfig metaModelConfig;

    public MetaFileLoader(MetaModelConfig metaModelConfig) {
        Intrinsics.checkNotNullParameter(metaModelConfig, "metaModelConfig");
        this.metaModelConfig = metaModelConfig;
        this.fileValidate = PredefineFileValidate.INSTANCE;
    }

    @Override // com.bytedance.ies.bullet.interaction.predefine.api.IPredefineFileLoader
    public void loadFile(final String matchRuleItem, final String url) {
        Signature signature;
        MetaFilePath filePath;
        String filePath2;
        Intrinsics.checkNotNullParameter(matchRuleItem, "matchRuleItem");
        Intrinsics.checkNotNullParameter(url, "url");
        JSFileCacheModel jSFileCacheModel = PredefineManager.INSTANCE.getCacheJSFilePath().get(matchRuleItem);
        boolean z = false;
        if (jSFileCacheModel != null && (filePath2 = jSFileCacheModel.getFilePath()) != null && LoaderUtil.INSTANCE.isNotNullOrEmpty(filePath2)) {
            z = true;
        }
        if (z) {
            PredefineRecordInfo predefineRecordInfo = new PredefineRecordInfo(matchRuleItem, 0L, "MEMORY_CACHE", false);
            PredefineReportInfo predefineReportInfo = PredefineMonitorMethod.INSTANCE.getRecords().get(url);
            if (predefineReportInfo == null) {
                predefineReportInfo = new PredefineReportInfo();
            }
            predefineReportInfo.getPredefineRecords().add(predefineRecordInfo);
            PredefineMonitorMethod.INSTANCE.getRecords().put(url, predefineReportInfo);
            HybridLogger.i$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "loadFile from cache result:" + predefineRecordInfo + ",thread:" + Thread.currentThread().getName(), null, null, 12, null);
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, MetaExternal> externalsMap = this.metaModelConfig.getExternalsMap();
        final MetaExternal metaExternal = externalsMap != null ? externalsMap.get(matchRuleItem) : null;
        String str = this.metaModelConfig.getPublishPath() + '/' + ((metaExternal == null || (filePath = metaExternal.getFilePath()) == null) ? null : filePath.getModule());
        final PredefineFileValidate.TypeEnum convertValidateType = this.fileValidate.convertValidateType((metaExternal == null || (signature = metaExternal.getSignature()) == null) ? null : signature.getType());
        r10.loadAsync((r22 & 1) != 0 ? ForestLoader.INSTANCE.getDefault() : null, str, (r22 & 4) != 0 ? null : null, Scene.LYNX_EXTERNAL_JS, "", (r22 & 32) != 0 ? null : new TaskConfig(null, 1, null), (r22 & 64) != 0 ? false : false, (r22 & 128) != 0 ? null : null, new Function1<Response, Unit>() { // from class: com.bytedance.ies.bullet.interaction.predefine.fileLoader.MetaFileLoader$loadFile$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Response) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Response response) {
                PredefineFileValidate predefineFileValidate;
                String str2;
                Signature signature2;
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isSucceed()) {
                    String filePath3 = response.getFilePath();
                    boolean z2 = false;
                    boolean z3 = response.getFrom() == ResourceFrom.BUILTIN || response.getFrom() == ResourceFrom.GECKO;
                    String str3 = null;
                    File file = filePath3 != null ? new File(filePath3) : null;
                    if (filePath3 != null) {
                        if (file != null && file.exists()) {
                            z2 = true;
                        }
                        if (!z2 || PredefineFileValidate.TypeEnum.this == null) {
                            return;
                        }
                        predefineFileValidate = this.fileValidate;
                        PredefineFileValidate.TypeEnum typeEnum = PredefineFileValidate.TypeEnum.this;
                        MetaExternal metaExternal2 = metaExternal;
                        if (metaExternal2 != null && (signature2 = metaExternal2.getSignature()) != null) {
                            str3 = signature2.getModule();
                        }
                        boolean validateFile = predefineFileValidate.validateFile(typeEnum, str3, file);
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (validateFile) {
                            JSFileCacheModel jSFileCacheModel2 = new JSFileCacheModel("file://" + file.getPath(), z3, currentTimeMillis2);
                            String str4 = matchRuleItem;
                            ResourceFrom from = response.getFrom();
                            if (from == null || (str2 = from.name()) == null) {
                                str2 = "";
                            }
                            PredefineRecordInfo predefineRecordInfo2 = new PredefineRecordInfo(str4, currentTimeMillis2, str2, false);
                            PredefineReportInfo predefineReportInfo2 = PredefineMonitorMethod.INSTANCE.getRecords().get(url);
                            if (predefineReportInfo2 == null) {
                                predefineReportInfo2 = new PredefineReportInfo();
                            }
                            predefineReportInfo2.getPredefineRecords().add(predefineRecordInfo2);
                            PredefineMonitorMethod.INSTANCE.getRecords().put(url, predefineReportInfo2);
                            HybridLogger.i$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "meta loadFile result:" + jSFileCacheModel2 + ",thread:" + Thread.currentThread().getName(), null, null, 12, null);
                            PredefineManager.INSTANCE.getCacheJSFilePath().put(matchRuleItem, jSFileCacheModel2);
                        }
                    }
                }
            }
        });
    }
}
