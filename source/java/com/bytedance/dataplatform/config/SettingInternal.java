package com.bytedance.dataplatform.config;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExperimentEntityUtiil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0086\n¢\u0006\u0002\u0010\nJ*\u0010\u0006\u001a\u0002H\u0007\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u0007H\u0086\n¢\u0006\u0002\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/bytedance/dataplatform/config/SettingInternal;", "", "isSticky", "", "(Z)V", "()Z", "invoke", ExifInterface.GPS_DIRECTION_TRUE, "key", "", "(Ljava/lang/String;)Ljava/lang/Object;", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "experiment_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public class SettingInternal {
    private final boolean isSticky;

    public SettingInternal(boolean z) {
        this.isSticky = z;
    }

    /* renamed from: isSticky, reason: from getter */
    public final boolean getIsSticky() {
        return this.isSticky;
    }

    public final /* synthetic */ <T> T invoke(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) ExperimentEntityUtiilKt.setting(key, Object.class, null, getIsSticky());
    }

    public final /* synthetic */ <T> T invoke(String key, T defaultValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(defaultValue, "defaultValue");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        T t = (T) ExperimentEntityUtiilKt.setting(key, Object.class, defaultValue, getIsSticky());
        if (t == null) {
            Intrinsics.throwNpe();
        }
        return t;
    }
}
