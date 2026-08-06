package com.bytedance.timonbase.scene.synchronizer;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* compiled from: ISenseStatusSynchronizer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\r\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¨\u0006\b"}, d2 = {"Lcom/bytedance/timonbase/scene/synchronizer/ISenseStatusSynchronizer;", ExifInterface.GPS_DIRECTION_TRUE, "", "getCurrentSenseStatus", "()Ljava/lang/Object;", "updateSenseStatus", "", "newStatus", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public interface ISenseStatusSynchronizer<T> {
    T getCurrentSenseStatus();

    void updateSenseStatus(Object newStatus);
}
