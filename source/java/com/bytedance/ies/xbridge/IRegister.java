package com.bytedance.ies.xbridge;

import java.util.Map;
import kotlin.Metadata;

/* compiled from: IRegister.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\tH&J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\tH&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0003H&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/xbridge/IRegister;", "", "findIDLMethod", "Lcom/bytedance/ies/xbridge/IDLXBridgeMethodProvider;", "name", "", "findMethod", "Lcom/bytedance/ies/xbridge/XBridgeMethodProvider;", "getIDLMethodList", "", "getMethodList", "registerMethod", "", "methodProvider", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IRegister {
    IDLXBridgeMethodProvider findIDLMethod(String name);

    XBridgeMethodProvider findMethod(String name);

    Map<String, IDLXBridgeMethodProvider> getIDLMethodList();

    Map<String, XBridgeMethodProvider> getMethodList();

    void registerMethod(String name, IDLXBridgeMethodProvider methodProvider);

    void registerMethod(String name, XBridgeMethodProvider methodProvider);
}
