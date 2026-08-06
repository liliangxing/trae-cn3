package com.bytedance.ies.bullet.forest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: lynx_ssr_processor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J#\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/bullet/forest/LynxSSRData;", "", "chunks", "", "Lcom/bytedance/ies/bullet/forest/ReactLynxSSRChunk;", "hydrateUrl", "", "(Ljava/util/List;Ljava/lang/String;)V", "getChunks", "()Ljava/util/List;", "getHydrateUrl", "()Ljava/lang/String;", "initData", "getInitData", "ssrResult", "", "getSsrResult", "()[B", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class LynxSSRData {
    private final List<ReactLynxSSRChunk> chunks;
    private final String hydrateUrl;
    private final String initData;
    private final byte[] ssrResult;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LynxSSRData copy$default(LynxSSRData lynxSSRData, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = lynxSSRData.chunks;
        }
        if ((i & 2) != 0) {
            str = lynxSSRData.hydrateUrl;
        }
        return lynxSSRData.copy(list, str);
    }

    public final List<ReactLynxSSRChunk> component1() {
        return this.chunks;
    }

    /* renamed from: component2, reason: from getter */
    public final String getHydrateUrl() {
        return this.hydrateUrl;
    }

    public final LynxSSRData copy(List<ReactLynxSSRChunk> chunks, String hydrateUrl) {
        Intrinsics.checkNotNullParameter(chunks, "chunks");
        Intrinsics.checkNotNullParameter(hydrateUrl, "hydrateUrl");
        return new LynxSSRData(chunks, hydrateUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LynxSSRData)) {
            return false;
        }
        LynxSSRData lynxSSRData = (LynxSSRData) other;
        return Intrinsics.areEqual(this.chunks, lynxSSRData.chunks) && Intrinsics.areEqual(this.hydrateUrl, lynxSSRData.hydrateUrl);
    }

    public int hashCode() {
        return (this.chunks.hashCode() * 31) + this.hydrateUrl.hashCode();
    }

    public String toString() {
        return "LynxSSRData(chunks=" + this.chunks + ", hydrateUrl=" + this.hydrateUrl + ')';
    }

    public LynxSSRData(List<ReactLynxSSRChunk> list, String str) {
        Object obj;
        Object obj2;
        byte[] body;
        byte[] body2;
        String decodeToString;
        Intrinsics.checkNotNullParameter(list, "chunks");
        Intrinsics.checkNotNullParameter(str, "hydrateUrl");
        this.chunks = list;
        this.hydrateUrl = str;
        Iterator<T> it = list.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            } else {
                obj2 = it.next();
                if (((ReactLynxSSRChunk) obj2).getType() == 1) {
                    break;
                }
            }
        }
        ReactLynxSSRChunk reactLynxSSRChunk = (ReactLynxSSRChunk) obj2;
        if (reactLynxSSRChunk == null || (body = reactLynxSSRChunk.getBody()) == null) {
            StringBuilder sb = new StringBuilder("can not find chunk type 1, all types:");
            List<ReactLynxSSRChunk> list2 = this.chunks;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(Integer.valueOf(((ReactLynxSSRChunk) it2.next()).getType()));
            }
            throw new IllegalStateException(sb.append(arrayList).toString());
        }
        this.ssrResult = body;
        Iterator<T> it3 = this.chunks.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next = it3.next();
            if (((ReactLynxSSRChunk) next).getType() == 2) {
                obj = next;
                break;
            }
        }
        ReactLynxSSRChunk reactLynxSSRChunk2 = (ReactLynxSSRChunk) obj;
        if (reactLynxSSRChunk2 != null && (body2 = reactLynxSSRChunk2.getBody()) != null && (decodeToString = StringsKt.decodeToString(body2)) != null) {
            this.initData = decodeToString;
            return;
        }
        StringBuilder sb2 = new StringBuilder("can not find chunk type 2, all types:");
        List<ReactLynxSSRChunk> list3 = this.chunks;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        Iterator<T> it4 = list3.iterator();
        while (it4.hasNext()) {
            arrayList2.add(Integer.valueOf(((ReactLynxSSRChunk) it4.next()).getType()));
        }
        throw new IllegalStateException(sb2.append(arrayList2).toString());
    }

    public final List<ReactLynxSSRChunk> getChunks() {
        return this.chunks;
    }

    public final String getHydrateUrl() {
        return this.hydrateUrl;
    }

    public final byte[] getSsrResult() {
        return this.ssrResult;
    }

    public final String getInitData() {
        return this.initData;
    }
}
