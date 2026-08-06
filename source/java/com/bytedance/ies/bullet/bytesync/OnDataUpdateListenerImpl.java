package com.bytedance.ies.bullet.bytesync;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.service.base.web.IWebKitViewService;
import com.bytedance.sync.interfaze.ISyncClient;
import com.bytedance.sync.interfaze.OnDataUpdateListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: OnDataUpdateListenerImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/bytesync/OnDataUpdateListenerImpl;", "Lcom/bytedance/sync/interfaze/OnDataUpdateListener;", "businessId", "", "(J)V", "getBusinessId", "()J", "onDataUpdate", "", "data", "Lcom/bytedance/sync/interfaze/ISyncClient$Data;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class OnDataUpdateListenerImpl implements OnDataUpdateListener {
    private final long businessId;

    public OnDataUpdateListenerImpl(long j) {
        this.businessId = j;
    }

    public final long getBusinessId() {
        return this.businessId;
    }

    public void onDataUpdate(ISyncClient.Data data) {
        Object obj;
        Unit unit;
        if (data == null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "OnDataUpdateListenerImpl", "ISyncClient.Data is null", null, null, 12, null);
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            OnDataUpdateListenerImpl onDataUpdateListenerImpl = this;
            byte[] bArr = data.data;
            Intrinsics.checkNotNullExpressionValue(bArr, "data.data");
            final JSONObject jSONObject = new JSONObject(new String(bArr, Charsets.UTF_8));
            List<WeakReference<IBulletContainer>> list = BytesyncManager.INSTANCE.getBulletContainerMap().get(Long.valueOf(this.businessId));
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    final IBulletContainer iBulletContainer = (IBulletContainer) ((WeakReference) it.next()).get();
                    if (iBulletContainer == null) {
                        HybridLogger.e$default(HybridLogger.INSTANCE, "OnDataUpdateListenerImpl", "container is null, drop msg " + jSONObject, null, null, 12, null);
                    } else {
                        iBulletContainer.onEvent(new IEvent() { // from class: com.bytedance.ies.bullet.bytesync.OnDataUpdateListenerImpl$onDataUpdate$1$1$1
                            @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
                            public String getName() {
                                return "bytesyncMsg";
                            }

                            @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
                            public Object getParams() {
                                if (IBulletContainer.this.getKitView() instanceof IWebKitViewService) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("data", jSONObject);
                                    return jSONObject2;
                                }
                                return jSONObject;
                            }
                        });
                        HybridLogger.i$default(HybridLogger.INSTANCE, "OnDataUpdateListenerImpl", "container: " + iBulletContainer.getSessionId() + " send msg: " + jSONObject + " success !!!", null, null, 12, null);
                    }
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            obj = Result.constructor-impl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "OnDataUpdateListenerImpl", "error is " + th2.getMessage(), null, null, 12, null);
        }
    }
}
