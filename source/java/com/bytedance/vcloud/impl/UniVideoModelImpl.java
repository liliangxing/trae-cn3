package com.bytedance.vcloud.impl;

import com.bytedance.vcloud.uniplayer.UniKitService_androidKt;
import com.bytedance.vcloud.uniplayer.VideoModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UniVideoModel.android.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0017J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/bytedance/vcloud/impl/UniVideoModelImpl;", "Lcom/bytedance/vcloud/uniplayer/VideoModel;", "nativePtr", "", "(J)V", "cachedGears", "", "", "getNativePtr$uniplayer_release", "()J", "setNativePtr$uniplayer_release", "close", "", "dispose", "getAllGears", "isValid", "", "setUniqueId", "uniqueId", "uniqueIdLength", "", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UniVideoModelImpl implements VideoModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private volatile List<String> cachedGears;
    private long nativePtr;

    @JvmStatic
    public static final native long createJson(String str, int i);

    @JvmStatic
    public static final native long createVidQuery(String str, String str2, String str3);

    @JvmStatic
    public static final native long createVidUrl(String str, String str2, String str3, boolean z, String str4, String str5);

    @JvmStatic
    public static final native void destroy(long j);

    @JvmStatic
    public static final native String getAllGears(long j);

    @JvmStatic
    public static final native int getUniqueLen(long j);

    @JvmStatic
    public static final native boolean isValid(long j);

    @JvmStatic
    public static final native void setUniqueId(long j, String str);

    public UniVideoModelImpl(long j) {
        this.nativePtr = j;
    }

    /* renamed from: getNativePtr$uniplayer_release, reason: from getter */
    public final long getNativePtr() {
        return this.nativePtr;
    }

    public final void setNativePtr$uniplayer_release(long j) {
        this.nativePtr = j;
    }

    @Override // com.bytedance.vcloud.uniplayer.VideoModel
    public boolean isValid() {
        long j = this.nativePtr;
        if (j == 0) {
            return false;
        }
        return INSTANCE.isValid(j);
    }

    @Override // com.bytedance.vcloud.uniplayer.VideoModel
    public void setUniqueId(String uniqueId) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        long j = this.nativePtr;
        if (j == 0) {
            return;
        }
        INSTANCE.setUniqueId(j, uniqueId);
    }

    @Override // com.bytedance.vcloud.uniplayer.VideoModel
    public int uniqueIdLength() {
        long j = this.nativePtr;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.getUniqueLen(j);
    }

    @Override // com.bytedance.vcloud.uniplayer.VideoModel
    public List<String> getAllGears() {
        List<String> list = this.cachedGears;
        if (list != null) {
            return list;
        }
        long j = this.nativePtr;
        if (j == 0) {
            return CollectionsKt.emptyList();
        }
        String allGears = INSTANCE.getAllGears(j);
        if (allGears == null) {
            return CollectionsKt.emptyList();
        }
        List split$default = StringsKt.split$default(allGears, new char[]{'\n'}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (true ^ arrayList2.isEmpty()) {
            this.cachedGears = arrayList2;
        }
        return arrayList2;
    }

    @Override // com.bytedance.vcloud.uniplayer.VideoModel, java.lang.AutoCloseable
    public void close() {
        long j = this.nativePtr;
        if (j == 0) {
            return;
        }
        this.cachedGears = null;
        this.nativePtr = 0L;
        INSTANCE.destroy(j);
    }

    @Override // com.bytedance.vcloud.uniplayer.VideoModel
    @Deprecated(message = "Use close() or a use{} block instead.", replaceWith = @ReplaceWith(expression = "close()", imports = {}))
    public void dispose() {
        close();
    }

    /* compiled from: UniVideoModel.android.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0087 J#\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0087 J?\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0087 J\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0087 J\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u0004H\u0087 J\u0011\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0004H\u0087 J\u0011\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0004H\u0087 J\u0019\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0006H\u0087 ¨\u0006\u001c"}, d2 = {"Lcom/bytedance/vcloud/impl/UniVideoModelImpl$Companion;", "", "()V", "unip_videomodel_create_json", "", "json", "", "version", "", "unip_videomodel_create_vid_query", "vid", "query", "apiHost", "unip_videomodel_create_vid_url", "url", "headersCrlf", "needSetToken", "", "decryptionKey", "decryptionKeyNotEncoded", "unip_videomodel_destroy", "", "ptr", "unip_videomodel_get_all_gears", "unip_videomodel_get_unique_len", "unip_videomodel_isvalid", "unip_videomodel_set_unique_id", "uniqueId", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final long createJson(String str, int i) {
            return UniVideoModelImpl.createJson(str, i);
        }

        @JvmStatic
        public final long createVidQuery(String str, String str2, String str3) {
            return UniVideoModelImpl.createVidQuery(str, str2, str3);
        }

        @JvmStatic
        public final long createVidUrl(String str, String str2, String str3, boolean z, String str4, String str5) {
            return UniVideoModelImpl.createVidUrl(str, str2, str3, z, str4, str5);
        }

        @JvmStatic
        public final void destroy(long j) {
            UniVideoModelImpl.destroy(j);
        }

        @JvmStatic
        public final String getAllGears(long j) {
            return UniVideoModelImpl.getAllGears(j);
        }

        @JvmStatic
        public final int getUniqueLen(long j) {
            return UniVideoModelImpl.getUniqueLen(j);
        }

        @JvmStatic
        public final boolean isValid(long j) {
            return UniVideoModelImpl.isValid(j);
        }

        @JvmStatic
        public final void setUniqueId(long j, String str) {
            UniVideoModelImpl.setUniqueId(j, str);
        }

        private Companion() {
        }
    }

    static {
        UniKitService_androidKt.loadLibrary();
    }
}
