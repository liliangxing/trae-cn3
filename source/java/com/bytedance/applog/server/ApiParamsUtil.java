package com.bytedance.applog.server;

import android.content.Context;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.UriConfig;
import com.bytedance.applog.engine.Engine;
import com.bytedance.applog.priority.EventPriorityItem;
import com.bytedance.applog.util.EncryptUtils;
import com.bytedance.bdinstall.Level;
import java.util.Collections;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ApiParamsUtil {
    private static final String SEND_TAIL_ENCRYPT = "tt_data=a";
    private final AppLogInstance appLogInstance;

    public ApiParamsUtil(AppLogInstance appLogInstance) {
        this.appLogInstance = appLogInstance;
    }

    public String[] getSendLogUris(Engine engine, boolean z, EventPriorityItem eventPriorityItem) {
        String[] priorityUris;
        UriConfig uriConfig = engine.getUriConfig();
        String[] realUris = z ? uriConfig.getRealUris() : uriConfig.getSendUris();
        if (eventPriorityItem != null && (priorityUris = eventPriorityItem.getPriorityUris(realUris, UriConfig.PATH_SEND)) != null && priorityUris.length > 0) {
            realUris = priorityUris;
        }
        return encryptSendLogUris(engine.getContext(), realUris);
    }

    public String[] encryptSendLogUris(Context context, String[] strArr) {
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            strArr2[i] = encryptSendLogUri(context, strArr[i]);
        }
        return strArr2;
    }

    public String encryptSendLogUri(Context context, String str) {
        if (this.appLogInstance.getEncryptAndCompress()) {
            if (str.contains("?")) {
                str = str + "&tt_data=a";
            } else {
                str = str + "?tt_data=a";
            }
        }
        return Api.filterQuery(this.appLogInstance.addNetCommonParams(context, str, true, Level.L1), EncryptUtils.KEYS_REPORT_QUERY);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T getValue(JSONObject jSONObject, String str, T t, Class<T> cls) {
        T t2;
        if (jSONObject == null) {
            return (T) this.appLogInstance.getHeaderValue(str, t, cls);
        }
        Object opt = jSONObject.opt(str);
        if (opt != null && cls != null) {
            try {
                t2 = cls.cast(opt);
            } catch (Throwable th) {
                this.appLogInstance.getLogger().error(Collections.singletonList("ApiParamsUtil"), "getValue cast failed", th, new Object[0]);
            }
            return t2 != null ? t : t2;
        }
        t2 = null;
        if (t2 != null) {
        }
    }
}
