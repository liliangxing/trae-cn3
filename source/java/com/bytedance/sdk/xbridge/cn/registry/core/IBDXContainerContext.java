package com.bytedance.sdk.xbridge.cn.registry.core;

import android.app.Activity;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.sdk.xbridge.cn.service.JSEventDelegate;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IBDXBridgeContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J#\u0010\u0014\u001a\u0004\u0018\u0001H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0017H&¢\u0006\u0002\u0010\u0018J(\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001dH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXContainerContext;", "", "containerID", "", "getContainerID", "()Ljava/lang/String;", "jsEventDelegate", "Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;", "getJsEventDelegate", "()Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;", LynxBridgeCall.NAME_SPACE, "getNamespace", "platformType", "Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "getPlatformType", "()Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "getEngineView", "Landroid/view/View;", "getOwnerActivity", "Landroid/app/Activity;", "getService", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "sendEvent", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "params", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IBDXContainerContext {
    String getContainerID();

    View getEngineView();

    JSEventDelegate getJsEventDelegate();

    String getNamespace();

    Activity getOwnerActivity();

    PlatformType getPlatformType();

    <T> T getService(Class<T> clazz);

    void sendEvent(String eventName, Map<String, ? extends Object> params);
}
