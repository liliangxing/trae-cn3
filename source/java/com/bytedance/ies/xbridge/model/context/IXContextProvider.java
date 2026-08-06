package com.bytedance.ies.xbridge.model.context;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.xbridge.api.IReleasable;
import kotlin.Metadata;

/* compiled from: XContextProviderFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u000f\u0010\u0003\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/xbridge/model/context/IXContextProvider;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ies/xbridge/api/IReleasable;", "provideInstance", "()Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IXContextProvider<T> extends IReleasable {
    T provideInstance();
}
