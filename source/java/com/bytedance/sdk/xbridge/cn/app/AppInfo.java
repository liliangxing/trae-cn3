package com.bytedance.sdk.xbridge.cn.app;

import com.bytedance.sdk.xbridge.cn.app.AbsXCheckAppsInfoMethodIDL;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: XCheckAppsInfoMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/app/AppInfo;", "Lcom/bytedance/sdk/xbridge/cn/app/AbsXCheckAppsInfoMethodIDL$XBridgeBeanXCheckAppsInfo;", "()V", "is_install", "", "()Ljava/lang/Number;", "set_install", "(Ljava/lang/Number;)V", "version_code", "", "getVersion_code", "()Ljava/lang/String;", "setVersion_code", "(Ljava/lang/String;)V", "version_name", "getVersion_name", "setVersion_name", "convert", "", "", "toJSON", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AppInfo implements AbsXCheckAppsInfoMethodIDL.XBridgeBeanXCheckAppsInfo {
    private Number is_install = (Number) 0;
    private String version_code = "";
    private String version_name = "";

    @Override // com.bytedance.sdk.xbridge.cn.app.AbsXCheckAppsInfoMethodIDL.XBridgeBeanXCheckAppsInfo
    /* renamed from: is_install, reason: from getter */
    public Number getIs_install() {
        return this.is_install;
    }

    @Override // com.bytedance.sdk.xbridge.cn.app.AbsXCheckAppsInfoMethodIDL.XBridgeBeanXCheckAppsInfo
    public void set_install(Number number) {
        this.is_install = number;
    }

    @Override // com.bytedance.sdk.xbridge.cn.app.AbsXCheckAppsInfoMethodIDL.XBridgeBeanXCheckAppsInfo
    public String getVersion_code() {
        return this.version_code;
    }

    @Override // com.bytedance.sdk.xbridge.cn.app.AbsXCheckAppsInfoMethodIDL.XBridgeBeanXCheckAppsInfo
    public void setVersion_code(String str) {
        this.version_code = str;
    }

    @Override // com.bytedance.sdk.xbridge.cn.app.AbsXCheckAppsInfoMethodIDL.XBridgeBeanXCheckAppsInfo
    public String getVersion_name() {
        return this.version_name;
    }

    @Override // com.bytedance.sdk.xbridge.cn.app.AbsXCheckAppsInfoMethodIDL.XBridgeBeanXCheckAppsInfo
    public void setVersion_name(String str) {
        this.version_name = str;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("is_install", getIs_install());
        jSONObject.put("version_code", getVersion_code());
        jSONObject.put("version_name", getVersion_name());
        return jSONObject;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public Map<String, Object> convert() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Number is_install = getIs_install();
        Intrinsics.checkNotNull(is_install, "null cannot be cast to non-null type kotlin.Any");
        linkedHashMap.put("is_install", is_install);
        String version_code = getVersion_code();
        Intrinsics.checkNotNull(version_code, "null cannot be cast to non-null type kotlin.Any");
        linkedHashMap.put("version_code", version_code);
        String version_name = getVersion_name();
        Intrinsics.checkNotNull(version_name, "null cannot be cast to non-null type kotlin.Any");
        linkedHashMap.put("version_name", version_name);
        return linkedHashMap;
    }
}
