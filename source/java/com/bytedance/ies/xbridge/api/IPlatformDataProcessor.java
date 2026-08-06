package com.bytedance.ies.xbridge.api;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.exception.IllegalInputParamException;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: IPlatformDataProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J,\u0010\f\u001a\u00020\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010H&J0\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u00012\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010H&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/xbridge/api/IPlatformDataProcessor;", "", "matchPlatformType", "", "platformType", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "registerPlatformTypeConverter", "", "transformJSONObjectToXReadableMap", "Lcom/bytedance/ies/xbridge/XReadableMap;", "params", "Lorg/json/JSONObject;", "transformMapToPlatformData", "", "", "clazz", "Ljava/lang/Class;", "Lcom/bytedance/ies/xbridge/IDLXBridgeMethod;", "transformPlatformDataToMap", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IPlatformDataProcessor {
    boolean matchPlatformType(XBridgePlatformType platformType);

    void registerPlatformTypeConverter();

    XReadableMap transformJSONObjectToXReadableMap(JSONObject params);

    Object transformMapToPlatformData(Map<String, ? extends Object> params, Class<? extends IDLXBridgeMethod> clazz);

    Map<String, Object> transformPlatformDataToMap(Object params, Class<? extends IDLXBridgeMethod> clazz) throws IllegalInputParamException;
}
