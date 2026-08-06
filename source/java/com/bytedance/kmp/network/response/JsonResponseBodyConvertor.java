package com.bytedance.kmp.network.response;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: ResponseBodyConvertor.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000b\u001a\u0004\u0018\u00018\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0002\u0010\u000eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/kmp/network/response/JsonResponseBodyConvertor;", "T", "", "Lcom/bytedance/kmp/network/response/ResponseBodyConvertor;", "deserializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "json", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "convert", "responseBody", "Lcom/bytedance/kmp/network/response/ResponseBody;", "(Lcom/bytedance/kmp/network/response/ResponseBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class JsonResponseBodyConvertor<T> implements ResponseBodyConvertor<T> {
    private final KSerializer<T> deserializer;
    private final Json json;

    public JsonResponseBodyConvertor(KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "deserializer");
        this.deserializer = kSerializer;
        this.json = JsonKt.Json$default((Json) null, new Function1<JsonBuilder, Unit>() { // from class: com.bytedance.kmp.network.response.JsonResponseBodyConvertor$json$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((JsonBuilder) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(JsonBuilder jsonBuilder) {
                Intrinsics.checkNotNullParameter(jsonBuilder, "$this$Json");
                jsonBuilder.setIgnoreUnknownKeys(true);
            }
        }, 1, (Object) null);
    }

    public final Json getJson() {
        return this.json;
    }

    @Override // com.bytedance.kmp.network.response.ResponseBodyConvertor
    public Object convert(ResponseBody responseBody, Continuation<? super T> continuation) {
        String string;
        if (responseBody == null || (string = responseBody.string()) == null) {
            return null;
        }
        return this.json.decodeFromString(this.deserializer, string);
    }
}
