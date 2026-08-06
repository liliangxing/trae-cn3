package com.bytedance.ies.bullet.web.pia;

import com.bytedance.forest.interceptor.ForestMonitor;
import com.bytedance.forest.interceptor.GlobalInterceptor;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.utils.LogUtils;
import com.bytedance.geckox.utils.MD5Utils;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.pia.core.api.resource.IPiaPreloader;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IReleasable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ForestPiaPreloader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00192\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\"\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\t2\u0010\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\t\u0012\u0002\b\u00030\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u0016\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/bullet/web/pia/ForestPiaPreloader;", "Lcom/bytedance/pia/core/api/resource/IPiaPreloader;", "Lcom/bytedance/pia/core/api/utils/IReleasable;", "Lcom/bytedance/forest/interceptor/ForestMonitor;", "()V", "piaPreloadListener", "Lcom/bytedance/pia/core/api/utils/IConsumer;", "Lcom/bytedance/pia/core/api/resource/IPiaPreloader$PerfInfo;", "uniqueId", "", "onLoadFinished", "", "response", "Lcom/bytedance/forest/model/Response;", "onLoadStart", "url", "requestParams", "Lcom/bytedance/forest/model/RequestParams;", ResourceInfo.RESOURCE_FROM_PRELOAD, "mainUrl", "subResource", "", "release", "setPerfListener", "listener", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestPiaPreloader implements IPiaPreloader, IReleasable, ForestMonitor {
    private static final String TAG = "ForestPiaPreloader";
    private IConsumer<IPiaPreloader.PerfInfo> piaPreloadListener;
    private final String uniqueId = MD5Utils.stringToMd5("pia_preload") + '-' + hashCode() + '-' + System.currentTimeMillis();

    public void onLoadStart(String url, RequestParams requestParams) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(requestParams, "requestParams");
    }

    @Override // com.bytedance.pia.core.api.resource.IPiaPreloader
    public void preload(String mainUrl, Map<String, ?> subResource) {
        Intrinsics.checkNotNullParameter(mainUrl, "mainUrl");
        Intrinsics.checkNotNullParameter(subResource, "subResource");
        r0.preload((r20 & 1) != 0 ? ForestLoader.INSTANCE.getDefault() : null, (r20 & 2) != 0 ? null : "", (r20 & 4) != 0 ? null : new JSONObject(subResource), "pia_preload", (r20 & 16) != 0 ? null : this.uniqueId, PreloadType.WEB, (r20 & 64) != 0 ? null : null, (r20 & 128) != 0 ? false : true);
    }

    @Override // com.bytedance.pia.core.api.resource.IPiaPreloader
    public void setPerfListener(IConsumer<IPiaPreloader.PerfInfo> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LogUtils.i$default(LogUtils.INSTANCE, "PiaCore", "[Forest] [Preload] set listener.", false, (Function3) null, (String) null, (Map) null, 60, (Object) null);
        GlobalInterceptor.INSTANCE.registerMonitor(this);
        this.piaPreloadListener = listener;
    }

    @Override // com.bytedance.pia.core.api.utils.IReleasable
    public void release() {
        LogUtils.i$default(LogUtils.INSTANCE, "PiaCore", "[Forest] [Preload] release preloader.", false, (Function3) null, (String) null, (Map) null, 60, (Object) null);
        GlobalInterceptor.INSTANCE.unregisterMonitor(this);
        this.piaPreloadListener = null;
    }

    public void onLoadFinished(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (this.piaPreloadListener == null) {
            LogUtils.e$default(LogUtils.INSTANCE, "PiaCore", "[Forest] [Preload] " + response.getRequest().getOriginUrl() + " finished but no perf listener injected", (Throwable) null, 4, (Object) null);
            return;
        }
        if (response.getRequest().isPreload()) {
            String groupId = response.getRequest().getGroupId();
            if (groupId == null) {
                Object obj = response.getRequest().getCustomParams().get("rl_container_uuid");
                groupId = obj instanceof String ? (String) obj : null;
            }
            if (Intrinsics.areEqual(groupId, this.uniqueId)) {
                Long l = (Long) response.getPerformanceInfo().get("res_load_start");
                long longValue = l != null ? l.longValue() : 0L;
                Long l2 = (Long) response.getPerformanceInfo().get("res_load_finish");
                long longValue2 = l2 != null ? l2.longValue() : 0L;
                LogUtils.i$default(LogUtils.INSTANCE, "PiaCore", "[Forest] [Preload] " + response.getRequest().getOriginUrl() + " finished, perf=[" + longValue + ", " + longValue2 + ']', false, (Function3) null, (String) null, (Map) null, 60, (Object) null);
                IConsumer<IPiaPreloader.PerfInfo> iConsumer = this.piaPreloadListener;
                Intrinsics.checkNotNull(iConsumer);
                iConsumer.accept(new IPiaPreloader.PerfInfo(response.getRequest().getOriginUrl(), longValue, longValue2));
            }
        }
    }
}
