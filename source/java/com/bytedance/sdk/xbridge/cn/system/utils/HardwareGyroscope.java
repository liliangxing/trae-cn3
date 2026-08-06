package com.bytedance.sdk.xbridge.cn.system.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostSystemActionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.tracing.log.Fields;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HardwareGyroscope.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016H\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0016J \u0010!\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0007J\u0006\u0010#\u001a\u00020\"R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/utils/HardwareGyroscope;", "Landroid/hardware/SensorEventListener;", "()V", "eventParams", "", "", "", "handler", "Landroid/os/Handler;", "orientationAngles", "", "rotationMatrix", "rotationReading", "runnable", "Ljava/lang/Runnable;", "sensorManager", "Landroid/hardware/SensorManager;", "init", "", "context", "Landroid/content/Context;", "interval", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "bridgeName", "onAccuracyChanged", "sensor", "Landroid/hardware/Sensor;", "accuracy", "onSensorChanged", Fields.EVENT, "Landroid/hardware/SensorEvent;", "startGyroscope", "", "stopGyroscope", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class HardwareGyroscope implements SensorEventListener {
    private static Handler handler;
    private static Runnable runnable;
    private static SensorManager sensorManager;
    public static final HardwareGyroscope INSTANCE = new HardwareGyroscope();
    private static Map<String, ? extends Object> eventParams = MapsKt.emptyMap();
    private static final float[] rotationReading = new float[4];
    private static final float[] rotationMatrix = new float[9];
    private static final float[] orientationAngles = new float[3];

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
    }

    private HardwareGyroscope() {
    }

    public final void init(Context context, final int interval, IBDXBridgeContext bridgeContext, String bridgeName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(bridgeName, "bridgeName");
        stopGyroscope();
        if (interval < 1 || interval > 1000) {
            return;
        }
        Object systemService = context.getSystemService("sensor");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        sensorManager = (SensorManager) systemService;
        handler = new Handler();
        Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.system.utils.HardwareGyroscope$init$1
            @Override // java.lang.Runnable
            public void run() {
                Map map;
                Handler handler2;
                Map map2;
                Map map3;
                map = HardwareGyroscope.eventParams;
                if (!map.isEmpty()) {
                    Event event = new Event("onGyroscopeChange", 0L, (XReadableMap) null, 4, (DefaultConstructorMarker) null);
                    map2 = HardwareGyroscope.eventParams;
                    event.setMapParams(map2);
                    EventCenter.enqueueEvent(event);
                    Event event2 = new Event("onGyroscopeChange", 0L, (XReadableMap) null, 4, (DefaultConstructorMarker) null);
                    map3 = HardwareGyroscope.eventParams;
                    event2.setMapParams(map3);
                    EventCenter.enqueueEvent(event2);
                }
                handler2 = HardwareGyroscope.handler;
                if (handler2 != null) {
                    handler2.postDelayed(this, interval);
                }
            }
        };
        runnable = runnable2;
        Handler handler2 = handler;
        if (handler2 != null) {
            handler2.post(runnable2);
        }
        startGyroscope(interval, bridgeContext, bridgeName);
    }

    public final boolean startGyroscope(int interval, IBDXBridgeContext bridgeContext, String bridgeName) {
        int i;
        IHostSystemActionDepend hostSystemActionDepend;
        Sensor defaultSensor;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(bridgeName, "bridgeName");
        int i2 = 1000 / interval;
        boolean z = false;
        if (i2 >= 0 && i2 < 10) {
            i = 3;
        } else {
            if (10 <= i2 && i2 < 30) {
                z = true;
            }
            i = z ? 2 : 1;
        }
        SensorManager sensorManager2 = sensorManager;
        if (sensorManager2 != null && (hostSystemActionDepend = XBaseRuntime.INSTANCE.getHostSystemActionDepend()) != null && (defaultSensor = hostSystemActionDepend.getDefaultSensor(sensorManager2, bridgeContext, bridgeName, 15)) != null) {
            sensorManager2.registerListener(this, defaultSensor, i);
        }
        return true;
    }

    public final boolean stopGyroscope() {
        Handler handler2;
        SensorManager sensorManager2 = sensorManager;
        if (sensorManager2 != null) {
            sensorManager2.unregisterListener(this);
        }
        Runnable runnable2 = runnable;
        if (runnable2 != null && (handler2 = handler) != null) {
            handler2.removeCallbacks(runnable2);
        }
        sensorManager = null;
        handler = null;
        runnable = null;
        eventParams = MapsKt.emptyMap();
        return true;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
        if (event.sensor.getType() == 15) {
            float[] fArr = event.values;
            float[] fArr2 = rotationReading;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            float[] fArr3 = rotationMatrix;
            SensorManager.getRotationMatrixFromVector(fArr3, fArr2);
            float[] fArr4 = orientationAngles;
            SensorManager.getOrientation(fArr3, fArr4);
            eventParams = MapsKt.mapOf(new Pair[]{TuplesKt.to("yaw", Float.valueOf(-fArr4[0])), TuplesKt.to("pitch", Float.valueOf(-fArr4[1])), TuplesKt.to("roll", Float.valueOf(fArr4[2]))});
        }
    }
}
