package com.bytedance.ruler.base.interfaces;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* compiled from: IParamGetter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&J\r\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/ruler/base/interfaces/IParamGetter;", ExifInterface.GPS_DIRECTION_TRUE, "", "getDataClass", "Ljava/lang/Class;", "getValue", "()Ljava/lang/Object;", "name", "", "ruler-base_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public interface IParamGetter<T> {
    Class<T> getDataClass();

    T getValue();

    String name();
}
