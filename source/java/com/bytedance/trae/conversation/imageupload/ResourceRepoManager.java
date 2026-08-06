package com.bytedance.trae.conversation.imageupload;

import android.util.LruCache;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceRepoManager.kt */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004*\u0001\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u001a\u0010\u000e\u001a\u00020\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\fJ \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0014J\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0014J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u0017\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;", "", "<init>", "()V", "MAX_SIZE", "", "imageIdToUrlCache", "com/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1", "Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1;", "put", "", "imageId", "", "url", "putAll", "map", "", "get", "getAll", "imageIds", "", "getMissing", "remove", "clear", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResourceRepoManager {
    private static final int MAX_SIZE = 150;
    public static final ResourceRepoManager INSTANCE = new ResourceRepoManager();
    private static final ResourceRepoManager$imageIdToUrlCache$1 imageIdToUrlCache = new LruCache<String, String>() { // from class: com.bytedance.trae.conversation.imageupload.ResourceRepoManager$imageIdToUrlCache$1
    };

    private ResourceRepoManager() {
    }

    public final synchronized void put(String imageId, String url) {
        Intrinsics.checkNotNullParameter(imageId, "imageId");
        Intrinsics.checkNotNullParameter(url, "url");
        imageIdToUrlCache.put(imageId, url);
    }

    public final synchronized void putAll(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            imageIdToUrlCache.put(entry.getKey(), entry.getValue());
        }
    }

    public final synchronized String get(String imageId) {
        Intrinsics.checkNotNullParameter(imageId, "imageId");
        return imageIdToUrlCache.get(imageId);
    }

    public final synchronized Map<String, String> getAll(List<String> imageIds) {
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(imageIds, "imageIds");
        linkedHashMap = new LinkedHashMap();
        for (String str : imageIds) {
            String str2 = imageIdToUrlCache.get(str);
            if (str2 != null) {
                linkedHashMap.put(str, str2);
            }
        }
        return linkedHashMap;
    }

    public final synchronized List<String> getMissing(List<String> imageIds) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(imageIds, "imageIds");
        arrayList = new ArrayList();
        for (Object obj : imageIds) {
            if (imageIdToUrlCache.get((String) obj) == null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final synchronized void remove(String imageId) {
        Intrinsics.checkNotNullParameter(imageId, "imageId");
        imageIdToUrlCache.remove(imageId);
    }

    public final synchronized void clear() {
        imageIdToUrlCache.evictAll();
    }
}
