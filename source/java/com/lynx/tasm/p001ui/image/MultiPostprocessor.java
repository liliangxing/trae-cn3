package com.lynx.tasm.p001ui.image;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.Postprocessor;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MultiPostprocessor implements Postprocessor {
    private final List<Postprocessor> mPostprocessors;

    public static Postprocessor from(List<Postprocessor> list) {
        int size = list.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return list.get(0);
        }
        return new MultiPostprocessor(list);
    }

    private MultiPostprocessor(List<Postprocessor> list) {
        this.mPostprocessors = new LinkedList(list);
    }

    public String getName() {
        StringBuilder sb = new StringBuilder();
        for (Postprocessor postprocessor : this.mPostprocessors) {
            if (sb.length() > 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append(postprocessor.getName());
        }
        sb.insert(0, "MultiPostProcessor (");
        sb.append(")");
        return sb.toString();
    }

    public CacheKey getPostprocessorCacheKey() {
        LinkedList linkedList = new LinkedList();
        Iterator<Postprocessor> it = this.mPostprocessors.iterator();
        while (it.hasNext()) {
            linkedList.push(it.next().getPostprocessorCacheKey());
        }
        return new MultiCacheKey(linkedList);
    }

    public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        CloseableReference closeableReference = null;
        try {
            Iterator<Postprocessor> it = this.mPostprocessors.iterator();
            CloseableReference closeableReference2 = null;
            while (it.hasNext()) {
                closeableReference = it.next().process(closeableReference2 != null ? (Bitmap) closeableReference2.get() : bitmap, platformBitmapFactory);
                CloseableReference.closeSafely(closeableReference2);
                closeableReference2 = CloseableReference.cloneOrNull(closeableReference);
            }
            return CloseableReference.cloneOrNull(closeableReference);
        } finally {
            CloseableReference.closeSafely(closeableReference);
        }
    }
}
