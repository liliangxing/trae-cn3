package com.bytedance.ies.utility;

import android.content.Context;
import android.content.res.Resources;
import android.util.LongSparseArray;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.common.utility.reflect.JavaCalls;

/* loaded from: classes4.dex */
public class PreloadResCleaner {
    public static void cleanPreloadRes(Context context) {
        Resources resources = context.getApplicationContext().getResources();
        Object field = JavaCalls.getField(resources, "sPreloadedDrawables");
        if (field instanceof LongSparseArray[]) {
            for (LongSparseArray longSparseArray : (LongSparseArray[]) field) {
                CollectionUtils.clear(longSparseArray);
            }
        } else {
            CollectionUtils.clear((LongSparseArray) field);
        }
        CollectionUtils.clear(JavaCalls.getField(resources, "sPreloadedColorDrawables"));
        CollectionUtils.clear(JavaCalls.getField(resources, "sPreloadedColorStateLists"));
        CollectionUtils.clear(JavaCalls.getField(resources, "mDrawableCache"));
        CollectionUtils.clear(JavaCalls.getField(resources, "mColorDrawableCache"));
        CollectionUtils.clear(JavaCalls.getField(resources, "mColorStateListCache"));
    }
}
