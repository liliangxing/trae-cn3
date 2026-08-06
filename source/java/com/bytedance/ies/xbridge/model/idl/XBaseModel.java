package com.bytedance.ies.xbridge.model.idl;

import androidx.webkit.Profile;
import com.bytedance.ies.xbridge.exception.XBridgeException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* compiled from: XBaseModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0016\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003H'J\b\u0010\u0005\u001a\u00020\u0006H'¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xbridge/model/idl/XBaseModel;", "", "convert", "", "", "toJSON", "Lorg/json/JSONObject;", Profile.DEFAULT_PROFILE_NAME, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface XBaseModel {
    Map<String, Object> convert() throws XBridgeException;

    JSONObject toJSON();

    /* compiled from: XBaseModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xbridge/model/idl/XBaseModel$Default;", "Lcom/bytedance/ies/xbridge/model/idl/XBaseModel;", "()V", "convert", "", "", "", "toJSON", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Default implements XBaseModel {
        @Override // com.bytedance.ies.xbridge.model.idl.XBaseModel
        public JSONObject toJSON() {
            return new JSONObject();
        }

        @Override // com.bytedance.ies.xbridge.model.idl.XBaseModel
        public Map<String, Object> convert() {
            return MapsKt.emptyMap();
        }
    }
}
