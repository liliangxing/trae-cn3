package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.android.live.core.setting.v2.tools.SettingV2Monitor;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: IPermissionConfigProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H&J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/ILocalStorage;", "", SettingV2Monitor.REPORT_TYPE_READ, "", "key", "readObject", "Lorg/json/JSONObject;", "write", "", "value", "writeObject", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface ILocalStorage {
    String read(String key);

    JSONObject readObject(String key);

    void write(String key, String value);

    void writeObject(String key, JSONObject value);
}
