package com.bytedance.ies.bullet.service.context;

import androidx.exifinterface.media.ExifInterface;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;

/* compiled from: HashTypedMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\fJ\u001d\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0002\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000bH&¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/service/context/TypedMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "getAny", "k", "(Ljava/lang/Object;)Ljava/lang/Object;", "getBoolean", "", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "getString", "", "(Ljava/lang/Object;)Ljava/lang/String;", "putAnyIfAbsent", BaseSwitches.V, "(Ljava/lang/Object;Ljava/lang/Object;)Z", "putBooleanIfAbsent", "(Ljava/lang/Object;Z)Z", "putStringIfAbsent", "(Ljava/lang/Object;Ljava/lang/String;)Z", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface TypedMap<K, V> {
    V getAny(K k);

    Boolean getBoolean(K k);

    String getString(K k);

    boolean putAnyIfAbsent(K k, V v);

    boolean putBooleanIfAbsent(K k, boolean v);

    boolean putStringIfAbsent(K k, String v);
}
