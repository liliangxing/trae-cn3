package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.content.ClipData;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.runtime.model.XGetLocationCallback;
import kotlin.Metadata;

/* compiled from: IHostSystemActionDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J(\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0013H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostSystemActionDepend;", "", "getDefaultSensor", "Landroid/hardware/Sensor;", "sensorManager", "Landroid/hardware/SensorManager;", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "bridgeName", "", "type", "", "getLocation", "", "context", "Landroid/content/Context;", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/sdk/xbridge/cn/runtime/model/XGetLocationCallback;", "getPrimaryClip", "Landroid/content/ClipData;", "hasPrimaryClip", "", "setPrimaryClip", "clipData", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IHostSystemActionDepend {
    Sensor getDefaultSensor(SensorManager sensorManager, IBDXBridgeContext bridgeContext, String bridgeName, int type);

    void getLocation(Context context, XGetLocationCallback callback);

    ClipData getPrimaryClip(Context context, IBDXBridgeContext bridgeContext, String bridgeName);

    boolean hasPrimaryClip(Context context, IBDXBridgeContext bridgeContext, String bridgeName);

    void setPrimaryClip(Context context, IBDXBridgeContext bridgeContext, String bridgeName, ClipData clipData);
}
