package com.bytedance.kmp.network.bridge;

import com.bytedance.kmp.spi.KmpServiceManager;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: KmpMergedDtoSerializer.android.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0006\b\u0000\u0010\u000b\u0018\u0001\"\u0006\b\u0001\u0010\n\u0018\u00012\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0086H¢\u0006\u0002\u0010\u0014JF\u0010\u0015\u001a\u0004\u0018\u0001H\u000b\"\u0006\b\u0000\u0010\u000b\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0086H¢\u0006\u0002\u0010\u0018J4\u0010\u0019\u001a\u00020\r\"\u0006\b\u0000\u0010\u000b\u0018\u00012\u0006\u0010\u001a\u001a\u00020\u00012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0086H¢\u0006\u0002\u0010\u001dJ4\u0010\u001e\u001a\u00020\u0017\"\u0006\b\u0000\u0010\u000b\u0018\u00012\u0006\u0010\u001a\u001a\u0002H\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0086H¢\u0006\u0002\u0010\u001dR\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/bytedance/kmp/network/bridge/KmpMergedDtoSerializer;", "", "()V", "bridge", "Lcom/bytedance/kmp/network/bridge/IKmpDtoSerializeService;", "getBridge", "()Lcom/bytedance/kmp/network/bridge/IKmpDtoSerializeService;", "bridge$delegate", "Lkotlin/Lazy;", "fromJson", "RT", "DTO", "jsonString", "", "dtoInfo", "Lcom/bytedance/kmp/network/bridge/KmpSerializeDtoInfo;", "ktTransformer", "Lcom/bytedance/kmp/network/bridge/KmpCustomDtoTransformer;", "isAsync", "", "(Ljava/lang/String;Lcom/bytedance/kmp/network/bridge/KmpSerializeDtoInfo;Lcom/bytedance/kmp/network/bridge/KmpCustomDtoTransformer;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fromPb", "byteData", "", "([BLcom/bytedance/kmp/network/bridge/KmpSerializeDtoInfo;Lcom/bytedance/kmp/network/bridge/KmpCustomDtoTransformer;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toJson", "obj", "voInfo", "Lcom/bytedance/kmp/network/bridge/KmpSerializeVoInfo;", "(Ljava/lang/Object;Lcom/bytedance/kmp/network/bridge/KmpSerializeVoInfo;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toPb", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpMergedDtoSerializer {
    public static final KmpMergedDtoSerializer INSTANCE = new KmpMergedDtoSerializer();

    /* renamed from: bridge$delegate, reason: from kotlin metadata */
    private static final Lazy bridge = LazyKt.lazy(new Function0<IKmpDtoSerializeService>() { // from class: com.bytedance.kmp.network.bridge.KmpMergedDtoSerializer$bridge$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final IKmpDtoSerializeService m679invoke() {
            return (IKmpDtoSerializeService) KmpServiceManager.INSTANCE.get(Reflection.getOrCreateKotlinClass(IKmpDtoSerializeService.class));
        }
    });

    private KmpMergedDtoSerializer() {
    }

    public final IKmpDtoSerializeService getBridge() {
        return (IKmpDtoSerializeService) bridge.getValue();
    }

    public static /* synthetic */ Object fromJson$default(KmpMergedDtoSerializer kmpMergedDtoSerializer, String str, KmpSerializeDtoInfo kmpSerializeDtoInfo, KmpCustomDtoTransformer kmpCustomDtoTransformer, boolean z, Continuation continuation, int i, Object obj) {
        Object obj2;
        try {
            Intrinsics.needClassReification();
            Type type = new KmpMergedDtoSerializer$fromJson$type$1().getType();
            IKmpDtoSerializeService bridge2 = kmpMergedDtoSerializer.getBridge();
            if (bridge2 != null) {
                Intrinsics.checkNotNullExpressionValue(type, "type");
                obj2 = bridge2.fromJson(str, type);
            } else {
                obj2 = null;
            }
            Intrinsics.reifiedOperationMarker(2, "RT");
            Object obj3 = obj2;
            return obj2;
        } catch (Exception unused) {
            return null;
        }
    }

    public final /* synthetic */ <DTO, RT> Object fromJson(String str, KmpSerializeDtoInfo kmpSerializeDtoInfo, KmpCustomDtoTransformer<?> kmpCustomDtoTransformer, boolean z, Continuation<? super RT> continuation) {
        Object obj;
        try {
            Intrinsics.needClassReification();
            Type type = new KmpMergedDtoSerializer$fromJson$type$1().getType();
            IKmpDtoSerializeService bridge2 = getBridge();
            if (bridge2 != null) {
                Intrinsics.checkNotNullExpressionValue(type, "type");
                obj = bridge2.fromJson(str, type);
            } else {
                obj = null;
            }
            Intrinsics.reifiedOperationMarker(2, "RT");
            Object obj2 = obj;
            return obj;
        } catch (Exception unused) {
            return null;
        }
    }

    public static /* synthetic */ Object toJson$default(KmpMergedDtoSerializer kmpMergedDtoSerializer, Object obj, KmpSerializeVoInfo kmpSerializeVoInfo, boolean z, Continuation continuation, int i, Object obj2) {
        try {
            IKmpDtoSerializeService bridge2 = kmpMergedDtoSerializer.getBridge();
            if (bridge2 == null) {
                return "";
            }
            String json = bridge2.toJson(obj);
            return json != null ? json : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public final /* synthetic */ <DTO> Object toJson(Object obj, KmpSerializeVoInfo kmpSerializeVoInfo, boolean z, Continuation<? super String> continuation) {
        try {
            IKmpDtoSerializeService bridge2 = getBridge();
            if (bridge2 == null) {
                return "";
            }
            String json = bridge2.toJson(obj);
            return json != null ? json : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static /* synthetic */ Object fromPb$default(KmpMergedDtoSerializer kmpMergedDtoSerializer, byte[] bArr, KmpSerializeDtoInfo kmpSerializeDtoInfo, KmpCustomDtoTransformer kmpCustomDtoTransformer, boolean z, Continuation continuation, int i, Object obj) {
        Object obj2;
        try {
            IKmpDtoSerializeService bridge2 = kmpMergedDtoSerializer.getBridge();
            if (bridge2 != null) {
                Intrinsics.reifiedOperationMarker(4, "DTO");
                obj2 = bridge2.fromPb(bArr, Object.class);
            } else {
                obj2 = null;
            }
            Intrinsics.reifiedOperationMarker(2, "DTO");
            Object obj3 = obj2;
            return obj2;
        } catch (Exception unused) {
            return null;
        }
    }

    public final /* synthetic */ <DTO> Object fromPb(byte[] bArr, KmpSerializeDtoInfo kmpSerializeDtoInfo, KmpCustomDtoTransformer<?> kmpCustomDtoTransformer, boolean z, Continuation<? super DTO> continuation) {
        Object obj;
        try {
            IKmpDtoSerializeService bridge2 = getBridge();
            if (bridge2 != null) {
                Intrinsics.reifiedOperationMarker(4, "DTO");
                obj = bridge2.fromPb(bArr, Object.class);
            } else {
                obj = null;
            }
            Intrinsics.reifiedOperationMarker(2, "DTO");
            Object obj2 = obj;
            return obj;
        } catch (Exception unused) {
            return null;
        }
    }

    public static /* synthetic */ Object toPb$default(KmpMergedDtoSerializer kmpMergedDtoSerializer, Object obj, KmpSerializeVoInfo kmpSerializeVoInfo, boolean z, Continuation continuation, int i, Object obj2) {
        try {
            IKmpDtoSerializeService bridge2 = kmpMergedDtoSerializer.getBridge();
            if (bridge2 != null) {
                Intrinsics.reifiedOperationMarker(4, "DTO");
                byte[] pb = bridge2.toPb(obj, Object.class);
                if (pb != null) {
                    return pb;
                }
            }
            return new byte[0];
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    public final /* synthetic */ <DTO> Object toPb(DTO dto, KmpSerializeVoInfo kmpSerializeVoInfo, boolean z, Continuation<? super byte[]> continuation) {
        try {
            IKmpDtoSerializeService bridge2 = getBridge();
            if (bridge2 != null) {
                Intrinsics.reifiedOperationMarker(4, "DTO");
                byte[] pb = bridge2.toPb(dto, Object.class);
                if (pb != null) {
                    return pb;
                }
            }
            return new byte[0];
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}
