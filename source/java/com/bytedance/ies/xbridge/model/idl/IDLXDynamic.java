package com.bytedance.ies.xbridge.model.idl;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IDLXDynamic.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000fH&J\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0005H&J\b\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/xbridge/model/idl/IDLXDynamic;", "", "asArray", "", "asBoolean", "", "asByteArray", "", "asDouble", "", "asInt", "", "asLong", "", "asMap", "", "", "asString", "getType", "Lcom/bytedance/ies/xbridge/model/idl/XDynamicType;", "isNull", "recycle", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IDLXDynamic {
    List<Object> asArray();

    boolean asBoolean();

    byte[] asByteArray();

    double asDouble();

    int asInt();

    long asLong();

    Map<String, Object> asMap();

    String asString();

    XDynamicType getType();

    boolean isNull();

    void recycle();
}
