package com.bytedance.kmp.network.response;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: ResponseBodyConvertor.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00018\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/kmp/network/response/ResponseBodyConvertor;", ExifInterface.GPS_DIRECTION_TRUE, "", "convert", "responseBody", "Lcom/bytedance/kmp/network/response/ResponseBody;", "(Lcom/bytedance/kmp/network/response/ResponseBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ResponseBodyConvertor<T> {
    Object convert(ResponseBody responseBody, Continuation<? super T> continuation);
}
