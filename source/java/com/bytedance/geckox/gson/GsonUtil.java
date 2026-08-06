package com.bytedance.geckox.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GsonUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/geckox/gson/GsonUtil;", "", "()V", "gson", "Lcom/google/gson/Gson;", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GsonUtil {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final GsonUtil sGsonUtil = new GsonUtil();
    private final Gson gson = INSTANCE.buildGson();

    @JvmStatic
    public static final GsonUtil inst() {
        return INSTANCE.inst();
    }

    private GsonUtil() {
    }

    /* renamed from: gson, reason: from getter */
    public final Gson getGson() {
        return this.gson;
    }

    /* compiled from: GsonUtil.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/geckox/gson/GsonUtil$Companion;", "", "()V", "sGsonUtil", "Lcom/bytedance/geckox/gson/GsonUtil;", "buildGson", "Lcom/google/gson/Gson;", "inst", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final GsonUtil inst() {
            return GsonUtil.sGsonUtil;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Gson buildGson() {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Boolean.TYPE, new BooleanTypeAdapter());
            gsonBuilder.registerTypeAdapter(Boolean.TYPE, new BooleanTypeAdapter());
            Gson create = gsonBuilder.create();
            Intrinsics.checkExpressionValueIsNotNull(create, "builder.create()");
            return create;
        }
    }
}
