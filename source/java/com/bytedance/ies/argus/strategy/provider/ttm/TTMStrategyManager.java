package com.bytedance.ies.argus.strategy.provider.ttm;

import android.app.Application;
import android.util.Log;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider;
import com.tiktok.ttm.TTMCore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TTMStrategyManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/ttm/TTMStrategyManager;", "Lcom/bytedance/ies/argus/strategy/provider/ttm/ITTMStrategyManager;", "()V", "strategyProvider", "Lcom/bytedance/ies/argus/strategy/provider/ttm/TTMStrategyProvider;", "getStrategyProvider", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyProvider;", "hasInit", "", "parseTTMRuleByteCode", "", AlogMonitor.ALOG_RESULT_CODE, "", "nativeExtendFuncAddress", "processTTMRuleByteCodeLong", "codeString", "", "setup", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TTMStrategyManager implements ITTMStrategyManager {
    public static final String TAG = "TTMStrategyManager";
    private final TTMStrategyProvider strategyProvider = new TTMStrategyProvider();

    @Override // com.bytedance.ies.argus.strategy.provider.ttm.ITTMStrategyManager
    public boolean hasInit() {
        return TTMCore.getInstance().isInit();
    }

    @Override // com.bytedance.ies.argus.strategy.provider.ttm.ITTMStrategyManager
    public boolean setup() {
        Application application = ArgusEnv.INSTANCE.getInstance().getApplication();
        if (application != null) {
            TTMCore.Config config = new TTMCore.Config();
            config.globalEnable = true;
            config.reportEnable = true;
            config.crashDumpEnable = true;
            config.multiInstCacheEnable = true;
            config.multiInstCacheMaxSize = 30;
            config.multiInstCacheDefaultSize = 20;
            config.timeStaticConfig = 0;
            config.coreBuriedSamplingRate = 100000;
            config.generalBuriedSamplingRate = 100000;
            config.openJniCallOptimize = true;
            config.metricReporter = new TTMCore.MetricReporter() { // from class: com.bytedance.ies.argus.strategy.provider.ttm.TTMStrategyManager$setup$config$1$1
                public final void report(String str, String str2) {
                    Log.e("[TTMachineCost]", "eventName:" + str + "---jsonString:" + str2);
                }
            };
            config.machineWorkDir = application.getFilesDir().getAbsolutePath();
            TTMCore.getInstance().initTTM(config);
        } else {
            ArgusLog.e$default(ArgusLog.INSTANCE, TAG, "init ttm error: application is null", null, null, 12, null);
        }
        boolean hasInit = hasInit();
        if (!hasInit) {
            ArgusLog.e$default(ArgusLog.INSTANCE, TAG, "ttm init failed", null, null, 12, null);
        }
        return hasInit;
    }

    @Override // com.bytedance.ies.argus.strategy.provider.ttm.ITTMStrategyManager
    public BaseStrategyProvider getStrategyProvider() {
        return this.strategyProvider;
    }

    @Override // com.bytedance.ies.argus.strategy.provider.ttm.ITTMStrategyManager
    public long processTTMRuleByteCodeLong(String codeString, long nativeExtendFuncAddress) {
        Intrinsics.checkNotNullParameter(codeString, "codeString");
        return TTMCore.getInstance().parseTTMRuleByteCode(codeString, nativeExtendFuncAddress);
    }

    @Override // com.bytedance.ies.argus.strategy.provider.ttm.ITTMStrategyManager
    public long parseTTMRuleByteCode(byte[] code, long nativeExtendFuncAddress) {
        Intrinsics.checkNotNullParameter(code, AlogMonitor.ALOG_RESULT_CODE);
        return TTMCore.getInstance().parseTTMRuleByteCode(code, nativeExtendFuncAddress);
    }
}
