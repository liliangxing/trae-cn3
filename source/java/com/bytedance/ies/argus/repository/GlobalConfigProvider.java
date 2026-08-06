package com.bytedance.ies.argus.repository;

import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.bean.ArgusGlobalCommonConfig;
import com.bytedance.ies.argus.bean.GlobalDefinition;
import com.bytedance.ies.argus.bean.ReportConfig;
import com.bytedance.ies.argus.util.ArgusGsonUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* compiled from: GlobalConfigProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/argus/repository/GlobalConfigProvider;", "Lcom/bytedance/ies/argus/repository/BaseConfigProvider;", "Lcom/bytedance/ies/argus/bean/GlobalConfigModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "commonConfig", "Lcom/bytedance/ies/argus/bean/ArgusGlobalCommonConfig;", "addDefaultCollector", "", "getGlobalDef", "Lcom/bytedance/ies/argus/bean/GlobalDefinition;", "getReportConfig", "Lcom/bytedance/ies/argus/bean/ReportConfig;", "innerParse", "data", "Lorg/json/JSONObject;", "info", "Lcom/bytedance/ies/argus/repository/ConfigInfo;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GlobalConfigProvider extends BaseConfigProvider<com.bytedance.ies.argus.bean.GlobalConfigModel> {
    public static final String TAG = "GlobalConfigProvider";
    private ArgusGlobalCommonConfig commonConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalConfigProvider(CoroutineScope coroutineScope) {
        super(coroutineScope);
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        addDefaultCollector();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.ies.argus.repository.BaseConfigProvider
    public com.bytedance.ies.argus.bean.GlobalConfigModel innerParse(JSONObject data, ConfigInfo info) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(info, "info");
        return com.bytedance.ies.argus.bean.GlobalConfigModel.INSTANCE.init(data, info);
    }

    public final GlobalDefinition getGlobalDef() {
        ArgusGlobalCommonConfig argusGlobalCommonConfig = this.commonConfig;
        if (argusGlobalCommonConfig != null) {
            return argusGlobalCommonConfig.getGlobalDef();
        }
        return null;
    }

    public final ReportConfig getReportConfig() {
        ArgusGlobalCommonConfig argusGlobalCommonConfig = this.commonConfig;
        if (argusGlobalCommonConfig != null) {
            return argusGlobalCommonConfig.getReportConfig();
        }
        return null;
    }

    private final void addDefaultCollector() {
        registerCollector(new Function1<com.bytedance.ies.argus.bean.GlobalConfigModel, Unit>() { // from class: com.bytedance.ies.argus.repository.GlobalConfigProvider$addDefaultCollector$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((com.bytedance.ies.argus.bean.GlobalConfigModel) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(com.bytedance.ies.argus.bean.GlobalConfigModel globalConfigModel) {
                Intrinsics.checkNotNullParameter(globalConfigModel, "it");
                JSONObject optJSONObject = globalConfigModel.getData().optJSONObject(SettingsManager.COMMON_SERVICE);
                if (optJSONObject == null) {
                    ArgusLog.e$default(ArgusLog.INSTANCE, GlobalConfigProvider.TAG, "update common config fail: key-common is null", null, null, 12, null);
                    return;
                }
                ArgusGlobalCommonConfig argusGlobalCommonConfig = (ArgusGlobalCommonConfig) ArgusGsonUtils.INSTANCE.safelyFromJSONObjectToClass(optJSONObject, ArgusGlobalCommonConfig.class);
                if (argusGlobalCommonConfig != null) {
                    argusGlobalCommonConfig.setConfInfo(globalConfigModel.getConfInfo());
                    GlobalConfigProvider.this.commonConfig = argusGlobalCommonConfig;
                    ArgusLog.i$default(ArgusLog.INSTANCE, GlobalConfigProvider.TAG, "update common config success", null, 4, null);
                }
            }
        });
    }
}
