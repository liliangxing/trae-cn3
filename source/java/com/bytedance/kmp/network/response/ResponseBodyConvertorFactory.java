package com.bytedance.kmp.network.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;

/* compiled from: ResponseBodyConvertor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/kmp/network/response/ResponseBodyConvertorFactory;", "", "()V", "create", "Lcom/bytedance/kmp/network/response/ResponseBodyConvertor;", "type", "Lkotlin/reflect/KType;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ResponseBodyConvertorFactory {
    public static final ResponseBodyConvertorFactory INSTANCE = new ResponseBodyConvertorFactory();

    private ResponseBodyConvertorFactory() {
    }

    public final ResponseBodyConvertor<?> create(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type.getClassifier(), Reflection.getOrCreateKotlinClass(ResponseBody.class))) {
            return new DefaultResponseBodyConvertor();
        }
        if (Intrinsics.areEqual(type.getClassifier(), Reflection.getOrCreateKotlinClass(String.class))) {
            return new StringResponseBodyConvertor();
        }
        if (Intrinsics.areEqual(type.getClassifier(), Reflection.getOrCreateKotlinClass(byte[].class))) {
            return new ByteArrayResponseBodyConvertor();
        }
        KSerializer serializer = SerializersKt.serializer(type);
        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
        return new JsonResponseBodyConvertor(serializer);
    }
}
