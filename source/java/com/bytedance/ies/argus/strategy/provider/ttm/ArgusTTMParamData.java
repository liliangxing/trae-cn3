package com.bytedance.ies.argus.strategy.provider.ttm;

import com.bytedance.applog.server.Api;
import com.bytedance.ies.argus.strategy.ITTMDataHandler;
import com.tiktok.ttm.ttmparam.GenerateTTMData;
import com.tiktok.ttm.ttmparam.ITTMParamData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusTTMParamData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J$\u0010\u0015\u001a\u00020\u00162\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/ttm/ArgusTTMParamData;", "Lcom/tiktok/ttm/ttmparam/ITTMParamData;", "params", "Lcom/bytedance/ies/argus/strategy/ITTMDataHandler;", "(Lcom/bytedance/ies/argus/strategy/ITTMDataHandler;)V", "getParams", "()Lcom/bytedance/ies/argus/strategy/ITTMDataHandler;", "getDoubleValue", "", Api.KEY_ENCRYPT_RESP_KEY, "", "index", "", "getInputData", "", "", "getIntValue", "", "getObjectItem", "getStringValue", "getType", "replaceValue", "", "value", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ArgusTTMParamData extends ITTMParamData {
    private final ITTMDataHandler params;

    public int getType() {
        return 10;
    }

    public final ITTMDataHandler getParams() {
        return this.params;
    }

    public ArgusTTMParamData(ITTMDataHandler iTTMDataHandler) {
        Intrinsics.checkNotNullParameter(iTTMDataHandler, "params");
        this.params = iTTMDataHandler;
    }

    public Map<String, Object> getInputData() {
        return MapsKt.emptyMap();
    }

    public boolean replaceValue(String key, int index, Object value) {
        if (key == null || value == null) {
            return false;
        }
        return this.params.setValue(key, value);
    }

    public ITTMParamData getObjectItem(String key) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        try {
            return GenerateTTMData.generateTTMDataByData(this.params.getValue(key));
        } catch (Exception unused) {
            return null;
        }
    }

    public String getStringValue(String key, int index) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        try {
            Object value = this.params.getValue(key);
            String str = value instanceof String ? (String) value : null;
            return str == null ? "" : str;
        } catch (Exception unused) {
            return "";
        }
    }

    public long getIntValue(String key, int index) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        try {
            Object value = this.params.getValue(key);
            if (value instanceof Number) {
                return ((Number) value).longValue();
            }
            return ((value instanceof Boolean) && ((Boolean) value).booleanValue()) ? 1L : 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public double getDoubleValue(String key, int index) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        try {
            Object value = this.params.getValue(key);
            if (value instanceof Number) {
                return ((Number) value).doubleValue();
            }
            return ((value instanceof Boolean) && ((Boolean) value).booleanValue()) ? 1.0d : 0.0d;
        } catch (Exception unused) {
            return 0.0d;
        }
    }
}
