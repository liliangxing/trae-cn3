package com.bytedance.android.monitorV2.settings;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* compiled from: SettingsProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u000f\u0010\u0003\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/IProvider;", ExifInterface.GPS_DIRECTION_TRUE, "", "provideInstance", "()Ljava/lang/Object;", "release", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public interface IProvider<T> {
    T provideInstance();

    void release();
}
