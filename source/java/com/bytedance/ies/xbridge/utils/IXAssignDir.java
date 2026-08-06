package com.bytedance.ies.xbridge.utils;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* compiled from: IXAssignDir.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0005J\r\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/xbridge/utils/IXAssignDir;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "getValue", "()Ljava/lang/Object;", "Creator", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IXAssignDir<V> {
    V getValue();

    /* compiled from: IXAssignDir.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xbridge/utils/IXAssignDir$Creator;", "", "()V", "create", "Lcom/bytedance/ies/xbridge/utils/IXAssignDir;", ExifInterface.GPS_DIRECTION_TRUE, "obj", "(Ljava/lang/Object;)Lcom/bytedance/ies/xbridge/utils/IXAssignDir;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator {
        public static final Creator INSTANCE = new Creator();

        private Creator() {
        }

        public final <T> IXAssignDir<T> create(final T obj) {
            return new IXAssignDir<T>() { // from class: com.bytedance.ies.xbridge.utils.IXAssignDir$Creator$create$1
                @Override // com.bytedance.ies.xbridge.utils.IXAssignDir
                public T getValue() {
                    return obj;
                }
            };
        }
    }
}
