package com.bytedance.kmp.spi;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* compiled from: KmpServiceManager.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\u0007J(\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\t\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H&J-\u0010\n\u001a\u00020\u000b\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00062\u0006\u0010\f\u001a\u0002H\u0003H&¢\u0006\u0002\u0010\rJ.\u0010\n\u001a\u00020\u000b\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00030\tH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/kmp/spi/IKmpServiceManagerHost;", "", "get", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/kmp/spi/IKmpService;", "clazz", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Lcom/bytedance/kmp/spi/IKmpService;", "getAll", "", "put", "", "impl", "(Lkotlin/reflect/KClass;Lcom/bytedance/kmp/spi/IKmpService;)V", "implList", "spi_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IKmpServiceManagerHost {
    <T extends IKmpService> T get(KClass<T> clazz);

    <T extends IKmpService> List<T> getAll(KClass<T> clazz);

    <T extends IKmpService> void put(KClass<T> clazz, T impl);

    <T extends IKmpService> void put(KClass<T> clazz, List<? extends T> implList);
}
