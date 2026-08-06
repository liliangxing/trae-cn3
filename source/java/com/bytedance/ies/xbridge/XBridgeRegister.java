package com.bytedance.ies.xbridge;

import com.bytedance.ies.xbridge.XBridgeRegister;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgeRegister.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u0010H\u0016J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/xbridge/XBridgeRegister;", "Lcom/bytedance/ies/xbridge/IRegister;", "()V", "table", "Lcom/bytedance/ies/xbridge/XBridgeRegister$XBridgeTable;", "getTable", "()Lcom/bytedance/ies/xbridge/XBridgeRegister$XBridgeTable;", "table$delegate", "Lkotlin/Lazy;", "findIDLMethod", "Lcom/bytedance/ies/xbridge/IDLXBridgeMethodProvider;", "name", "", "findMethod", "Lcom/bytedance/ies/xbridge/XBridgeMethodProvider;", "getIDLMethodList", "", "getMethodList", "registerMethod", "", "methodProvider", "XBridgeTable", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XBridgeRegister implements IRegister {

    /* renamed from: table$delegate, reason: from kotlin metadata */
    private final Lazy table = LazyKt.lazy(new Function0<XBridgeTable>() { // from class: com.bytedance.ies.xbridge.XBridgeRegister$table$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final XBridgeRegister.XBridgeTable m632invoke() {
            return new XBridgeRegister.XBridgeTable();
        }
    });

    private final XBridgeTable getTable() {
        return (XBridgeTable) this.table.getValue();
    }

    @Override // com.bytedance.ies.xbridge.IRegister
    public XBridgeMethodProvider findMethod(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getTable().find(name);
    }

    @Override // com.bytedance.ies.xbridge.IRegister
    public IDLXBridgeMethodProvider findIDLMethod(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getTable().findIDL(name);
    }

    @Override // com.bytedance.ies.xbridge.IRegister
    public void registerMethod(String name, XBridgeMethodProvider methodProvider) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(methodProvider, "methodProvider");
        getTable().add(name, methodProvider);
    }

    @Override // com.bytedance.ies.xbridge.IRegister
    public void registerMethod(String name, IDLXBridgeMethodProvider methodProvider) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(methodProvider, "methodProvider");
        getTable().add(name, methodProvider);
    }

    @Override // com.bytedance.ies.xbridge.IRegister
    public Map<String, XBridgeMethodProvider> getMethodList() {
        return getTable().getAll();
    }

    @Override // com.bytedance.ies.xbridge.IRegister
    public Map<String, IDLXBridgeMethodProvider> getIDLMethodList() {
        return getTable().getAllIDL();
    }

    /* compiled from: XBridgeRegister.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0005J\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0010J\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0010J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/xbridge/XBridgeRegister$XBridgeTable;", "", "()V", "idlMethodMap", "", "", "Lcom/bytedance/ies/xbridge/IDLXBridgeMethodProvider;", "methodMap", "Lcom/bytedance/ies/xbridge/XBridgeMethodProvider;", "add", "", "name", "methodProvider", "find", "findIDL", "getAll", "", "getAllIDL", "remove", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class XBridgeTable {
        private final Map<String, XBridgeMethodProvider> methodMap = new LinkedHashMap();
        private final Map<String, IDLXBridgeMethodProvider> idlMethodMap = new LinkedHashMap();

        public final void add(String name, XBridgeMethodProvider methodProvider) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(methodProvider, "methodProvider");
            this.methodMap.put(name, methodProvider);
        }

        public final void add(String name, IDLXBridgeMethodProvider methodProvider) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(methodProvider, "methodProvider");
            this.idlMethodMap.put(name, methodProvider);
        }

        public final void remove(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.methodMap.remove(name);
            this.idlMethodMap.remove(name);
        }

        public final XBridgeMethodProvider find(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return this.methodMap.get(name);
        }

        public final IDLXBridgeMethodProvider findIDL(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return this.idlMethodMap.get(name);
        }

        public final Map<String, XBridgeMethodProvider> getAll() {
            return MapsKt.toMap(this.methodMap);
        }

        public final Map<String, IDLXBridgeMethodProvider> getAllIDL() {
            return MapsKt.toMap(this.idlMethodMap);
        }
    }
}
