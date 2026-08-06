package com.bytedance.ies.xbridge.base.runtime.depend;

import android.content.ClipData;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import kotlin.Metadata;

/* compiled from: IHostSystemActionDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostSystemActionDepend;", "", "getDefaultSensor", "Landroid/hardware/Sensor;", "sensorManager", "Landroid/hardware/SensorManager;", "type", "", "hasPrimaryClip", "", "context", "Landroid/content/Context;", "setPrimaryClip", "", "clipData", "Landroid/content/ClipData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IHostSystemActionDepend {
    Sensor getDefaultSensor(SensorManager sensorManager, int type);

    boolean hasPrimaryClip(Context context);

    void setPrimaryClip(Context context, ClipData clipData);
}
