package com.bytedance.ies.bullet.monitor.reliability;

import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.lite.utils.AnnieXLiteUtilsKt;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.LoadStage;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.monitor.reliability.AbsSendCustomPerfMetricMethodIDL;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.ies.bullet.service.monitor.reliability.ReliabilityReporter;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.MethodModelBean;
import com.bytedance.sdk.xbridge.cn.XBridgeDynamicModel;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: SendCustomPerfMetricMethod.kt */
@XBridgeMethod(name = "sendCustomPerfMetric", owner = "zhangjiangkun")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/monitor/reliability/SendCustomPerfMetricMethod;", "Lcom/bytedance/ies/bullet/monitor/reliability/AbsSendCustomPerfMetricMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/ies/bullet/monitor/reliability/AbsSendCustomPerfMetricMethodIDL$SendCustomPerfMetricParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/ies/bullet/monitor/reliability/AbsSendCustomPerfMetricMethodIDL$SendCustomPerfMetricResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SendCustomPerfMetricMethod extends AbsSendCustomPerfMetricMethodIDL {
    public /* bridge */ /* synthetic */ void handle(IBDXBridgeContext iBDXBridgeContext, XBaseParamModel xBaseParamModel, CompletionBlock completionBlock) {
        handle(iBDXBridgeContext, (AbsSendCustomPerfMetricMethodIDL.SendCustomPerfMetricParamModel) xBaseParamModel, (CompletionBlock<AbsSendCustomPerfMetricMethodIDL.SendCustomPerfMetricResultModel>) completionBlock);
    }

    public SendCustomPerfMetricMethod() {
        XBridgeDynamicModel.INSTANCE.addMethodModelMap(getClass(), new MethodModelBean(AbsSendCustomPerfMetricMethodIDL.SendCustomPerfMetricParamModel.class, AbsSendCustomPerfMetricMethodIDL.SendCustomPerfMetricResultModel.class));
    }

    public void handle(IBDXBridgeContext bridgeContext, AbsSendCustomPerfMetricMethodIDL.SendCustomPerfMetricParamModel params, CompletionBlock<AbsSendCustomPerfMetricMethodIDL.SendCustomPerfMetricResultModel> callback) {
        IBulletContainer iBulletContainer;
        BulletContext bulletContext;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IContainer isAnnieXLite = AnnieXLiteUtilsKt.isAnnieXLite(bridgeContext);
        if (isAnnieXLite != null) {
            MonitorManager.INSTANCE.reportEndToEndTraceWithSafeAction$anniex_release(isAnnieXLite.getBid(), isAnnieXLite.getContainerId());
            CompletionBlock.DefaultImpls.onSuccess$default(callback, XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsSendCustomPerfMetricMethodIDL.SendCustomPerfMetricResultModel.class)), (String) null, 2, (Object) null);
            return;
        }
        ContextProviderFactory contextProviderFactory = (ContextProviderFactory) bridgeContext.getService(ContextProviderFactory.class);
        if (contextProviderFactory != null && (iBulletContainer = (IBulletContainer) contextProviderFactory.provideInstance(IBulletContainer.class)) != null && (bulletContext = iBulletContainer.getBulletContext()) != null) {
            bulletContext.getContainerContext().setLoadStatus(MetricConstant.MONITOR_STAGE_UPDATE);
            bulletContext.getMonitorContext().setLoadStage(LoadStage.UPDATE);
            bulletContext.getMonitorContext().setEndToEndStage("data_update");
            ReliabilityReporter.INSTANCE.reportSuccessStage(bulletContext, MetricConstant.MONITOR_STAGE_UPDATE);
            ReliabilityReporter.INSTANCE.traceEndToEnd(bulletContext);
        }
        CompletionBlock.DefaultImpls.onSuccess$default(callback, XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsSendCustomPerfMetricMethodIDL.SendCustomPerfMetricResultModel.class)), (String) null, 2, (Object) null);
    }
}
