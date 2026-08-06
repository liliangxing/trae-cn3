package com.bytedance.ies.lynx.lynx_adapter.wrapper;

import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: ReadableArrayWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u001d\u001a\u00020\u0004H&J\u0012\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001fH&¨\u0006 "}, d2 = {"Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/ReadableArrayWrapper;", "", "getArray", "index", "", "getBoolean", "", "getByte", "", "getByteArray", "", "getChar", "", "getDouble", "", "getDynamic", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/DynamicWrapper;", "getInt", "getLong", "", "getMap", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/ReadableMapWrapper;", "getShort", "", "getString", "", "getType", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/ReadableTypeWrapper;", "isNull", "size", "toArrayList", "Ljava/util/ArrayList;", "lynx-adapter_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public interface ReadableArrayWrapper {
    ReadableArrayWrapper getArray(int index);

    boolean getBoolean(int index);

    byte getByte(int index);

    byte[] getByteArray(int index);

    char getChar(int index);

    double getDouble(int index);

    DynamicWrapper getDynamic(int index);

    int getInt(int index);

    long getLong(int index);

    ReadableMapWrapper getMap(int index);

    short getShort(int index);

    String getString(int index);

    ReadableTypeWrapper getType(int index);

    boolean isNull(int index);

    int size();

    ArrayList<Object> toArrayList();
}
