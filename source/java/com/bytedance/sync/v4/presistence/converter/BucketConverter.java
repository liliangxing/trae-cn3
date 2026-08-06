package com.bytedance.sync.v4.presistence.converter;

import com.bytedance.sync.v4.protocal.Bucket;

/* loaded from: classes5.dex */
public class BucketConverter {
    public static Bucket revertDate(int i) {
        Bucket fromValue = Bucket.fromValue(i);
        return fromValue == null ? Bucket.Device : fromValue;
    }

    public static int converterDate(Bucket bucket) {
        if (bucket == null) {
            return Bucket.Device.getValue();
        }
        return bucket.getValue();
    }
}
