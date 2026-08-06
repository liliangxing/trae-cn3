package com.bytedance.sdk.account.user;

import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface IBDAccountEntityFactory<T extends IBDAccountUserEntity> {
    T parseUserInfo(JSONObject jSONObject) throws Exception;

    T parseUserInfo(JSONObject jSONObject, JSONObject jSONObject2) throws Exception;
}
