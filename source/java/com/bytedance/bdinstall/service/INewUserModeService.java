package com.bytedance.bdinstall.service;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface INewUserModeService {
    void addNewUserModeExtra(JSONObject jSONObject);

    NUApi getApi();

    boolean isNewUserMode();

    void mapCustomParams(Map<String, String> map);

    void start();

    <T> T tryReplaceService(Class<T> cls, T t);
}
