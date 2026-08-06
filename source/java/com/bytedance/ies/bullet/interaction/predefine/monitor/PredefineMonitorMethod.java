package com.bytedance.ies.bullet.interaction.predefine.monitor;

import com.bytedance.ies.bullet.interaction.predefine.monitor.AbsXPredefineMonitorMethodIDL;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* compiled from: PredefineMonitorMethod.kt */
@XBridgeMethod(name = "x.predefineMonitor")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/interaction/predefine/monitor/PredefineMonitorMethod;", "Lcom/bytedance/ies/bullet/interaction/predefine/monitor/AbsXPredefineMonitorMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/ies/bullet/interaction/predefine/monitor/AbsXPredefineMonitorMethodIDL$XPredefineMonitorParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/ies/bullet/interaction/predefine/monitor/AbsXPredefineMonitorMethodIDL$XPredefineMonitorResultModel;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PredefineMonitorMethod extends AbsXPredefineMonitorMethodIDL {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String url = "";
    private static HashMap<String, PredefineReportInfo> records = new HashMap<>();

    public /* bridge */ /* synthetic */ void handle(IBDXBridgeContext iBDXBridgeContext, XBaseParamModel xBaseParamModel, CompletionBlock completionBlock) {
        handle(iBDXBridgeContext, (AbsXPredefineMonitorMethodIDL.XPredefineMonitorParamModel) xBaseParamModel, (CompletionBlock<AbsXPredefineMonitorMethodIDL.XPredefineMonitorResultModel>) completionBlock);
    }

    /* compiled from: PredefineMonitorMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R6\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/bullet/interaction/predefine/monitor/PredefineMonitorMethod$Companion;", "", "()V", "records", "Ljava/util/HashMap;", "", "Lcom/bytedance/ies/bullet/interaction/predefine/monitor/PredefineReportInfo;", "Lkotlin/collections/HashMap;", "getRecords", "()Ljava/util/HashMap;", "setRecords", "(Ljava/util/HashMap;)V", "url", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getUrl() {
            return PredefineMonitorMethod.url;
        }

        public final void setUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            PredefineMonitorMethod.url = str;
        }

        public final HashMap<String, PredefineReportInfo> getRecords() {
            return PredefineMonitorMethod.records;
        }

        public final void setRecords(HashMap<String, PredefineReportInfo> hashMap) {
            Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
            PredefineMonitorMethod.records = hashMap;
        }
    }

    public void handle(IBDXBridgeContext bridgeContext, AbsXPredefineMonitorMethodIDL.XPredefineMonitorParamModel params, CompletionBlock<AbsXPredefineMonitorMethodIDL.XPredefineMonitorResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IMonitorReportService iMonitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(IMonitorReportService.class);
        if (iMonitorReportService != null) {
            ReportInfo reportInfo = new ReportInfo("bdx_predefine_monitor", null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
            reportInfo.setUrl(url);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", url);
            jSONObject.put("group", params.getGroup());
            jSONObject.put("time_cull", params.getTimeCull());
            jSONObject.put("fe_duration", params.getFeDuration());
            jSONObject.put("schema_pkgs", params.getSchemaPkgs());
            jSONObject.put("schema_pkg_num", params.getSchemaPkgNum());
            jSONObject.put("predefine_pkgs", params.getPredefinePkgs());
            jSONObject.put("predefine_pkg_num", params.getPredefinePkgNum());
            jSONObject.put("predefine_state", params.getPredefineState());
            jSONObject.put("extra", params.getExtra());
            PredefineReportInfo predefineReportInfo = records.get(url);
            jSONObject.put("client_file_preload_duration", String.valueOf(predefineReportInfo != null ? predefineReportInfo.getPredefineRecords() : null));
            PredefineReportInfo predefineReportInfo2 = records.get(url);
            jSONObject.put("client_meta_fetch", predefineReportInfo2 != null ? Boolean.valueOf(predefineReportInfo2.getClientMetaFetch()) : null);
            PredefineReportInfo predefineReportInfo3 = records.get(url);
            reportInfo.setMetrics(jSONObject.put("client_predefine_enable", predefineReportInfo3 != null ? Boolean.valueOf(predefineReportInfo3.getClientPredefineEnable()) : null));
            iMonitorReportService.report(reportInfo);
        }
        AbsXPredefineMonitorMethodIDL.XPredefineMonitorResultModel createXModel = XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXPredefineMonitorMethodIDL.XPredefineMonitorResultModel.class));
        createXModel.setCode((Number) 1);
        CompletionBlock.DefaultImpls.onSuccess$default(callback, createXModel, (String) null, 2, (Object) null);
    }
}
