package com.bytedance.kmp.network.bridge;

import com.bytedance.kmp.spi.IKmpService;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* compiled from: KmpMergedDtoSerializer.android.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\bJ)\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH&¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J'\u0010\u0013\u001a\u00020\f\"\u0004\b\u0000\u0010\n2\u0006\u0010\u0011\u001a\u0002H\n2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH&¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/kmp/network/bridge/IKmpDtoSerializeService;", "Lcom/bytedance/kmp/spi/IKmpService;", "fromJson", "RT", "jsonString", "", "type", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "fromPb", "DTO", "byteData", "", "clazz", "Ljava/lang/Class;", "([BLjava/lang/Class;)Ljava/lang/Object;", "toJson", "obj", "", "toPb", "(Ljava/lang/Object;Ljava/lang/Class;)[B", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IKmpDtoSerializeService extends IKmpService {
    <RT> RT fromJson(String jsonString, Type type);

    <DTO> DTO fromPb(byte[] byteData, Class<?> clazz);

    <RT> String toJson(Object obj);

    <DTO> byte[] toPb(DTO obj, Class<?> clazz);
}
