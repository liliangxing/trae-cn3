package com.bytedance.sdk.open.aweme.commonbase;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.bdplatform.model.BDPlatformConstants;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.core.OpenEventService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.init.DouYinSdkContext;
import com.bytedance.sdk.open.aweme.utils.AppUtil;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.aweme.utils.OpenUtils;
import com.bytedance.sdk.open.aweme.utils.ThreadUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class OpenEvent {
    private static final String TAG = "OpenEvent";
    private static volatile OpenEventService inst;
    private final String eventName;
    private final InterfaceC0101c paramsProvider;
    private final long timestamp;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class Builder {
        private final String eventName;
        private final long timestamp = System.currentTimeMillis();
        private final C0100b paramsBuilder = new C0100b();

        public Builder(String str) {
            this.eventName = str;
            addCommonParam();
        }

        private void addCommonParam() {
            this.paramsBuilder.m19a(BDPlatformConstants.EventKey.EVENT_KEY_SDK_VERSION, "5.21.1-rc.0");
            if (DouYinSdkContext.inst().getClientKey() != null) {
                this.paramsBuilder.m19a("client_key", DouYinSdkContext.inst().getClientKey());
            }
            this.paramsBuilder.m19a("is_open", Integer.valueOf(!OpenUtils.isInternal() ? 1 : 0));
            try {
                Context context = DouYinSdkContext.inst().getContext();
                this.paramsBuilder.m19a("douyin_install", Integer.valueOf(AppUtil.isAppInstalled(context, ParamKeyConstants.DOUYIN_PACKAGE_NAME) ? 1 : 0));
                this.paramsBuilder.m19a("dylite_install", Integer.valueOf(AppUtil.isAppInstalled(context, ParamKeyConstants.DOUYIN_LITE_PACKAGE_NAME) ? 1 : 0));
            } catch (Exception unused) {
            }
        }

        public Builder addKVJsonObject(JSONObject jSONObject) {
            this.paramsBuilder.m20a(jSONObject);
            return this;
        }

        public OpenEvent build() {
            return new OpenEvent(this.timestamp, this.eventName, this.paramsBuilder, null);
        }

        /* renamed from: kv */
        public Builder m18kv(String str, Object obj) {
            this.paramsBuilder.m19a(str, obj);
            return this;
        }
    }

    /* renamed from: com.bytedance.sdk.open.aweme.commonbase.OpenEvent$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    class RunnableC0099a implements Runnable {
        RunnableC0099a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                if (OpenEvent.this.paramsProvider != null) {
                    OpenEvent.putAll(jSONObject, OpenEvent.this.paramsProvider.mo21a());
                }
                OpenEventService access$200 = OpenEvent.access$200();
                if (access$200 != null) {
                    access$200.sendEventV3(OpenEvent.this.eventName, jSONObject);
                } else if (OpenUtils.isInternal()) {
                    LogUtils.m28e(OpenEvent.TAG, "please implement OpenEventService");
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.bytedance.sdk.open.aweme.commonbase.OpenEvent$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class C0100b implements InterfaceC0101c {

        /* renamed from: a */
        private JSONObject f39a;

        /* renamed from: a */
        public C0100b m19a(String str, Object obj) {
            if (str != null && obj != null) {
                try {
                    if (this.f39a == null) {
                        this.f39a = new JSONObject();
                    }
                    this.f39a.put(str, obj);
                } catch (JSONException unused) {
                }
            }
            return this;
        }

        /* renamed from: a */
        public C0100b m20a(JSONObject jSONObject) {
            if (this.f39a == null) {
                this.f39a = new JSONObject();
            }
            OpenEvent.putAll(this.f39a, jSONObject);
            return this;
        }

        @Override // com.bytedance.sdk.open.aweme.commonbase.OpenEvent.InterfaceC0101c
        /* renamed from: a */
        public JSONObject mo21a() {
            return this.f39a;
        }
    }

    /* renamed from: com.bytedance.sdk.open.aweme.commonbase.OpenEvent$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface InterfaceC0101c {
        /* renamed from: a */
        JSONObject mo21a();
    }

    private OpenEvent(long j, String str, InterfaceC0101c interfaceC0101c) {
        this.timestamp = j;
        this.eventName = str;
        this.paramsProvider = interfaceC0101c;
    }

    /* synthetic */ OpenEvent(long j, String str, InterfaceC0101c interfaceC0101c, RunnableC0099a runnableC0099a) {
        this(j, str, interfaceC0101c);
    }

    static /* synthetic */ OpenEventService access$200() {
        return getEventService();
    }

    private static OpenEventService getEventService() {
        if (inst == null) {
            synchronized (OpenEvent.class) {
                if (inst == null) {
                    inst = (OpenEventService) OpenServiceManager.getInst().getService(OpenEventService.class);
                }
            }
        }
        return inst;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putAll(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.get(next));
            }
        } catch (Throwable unused) {
        }
    }

    public void flush() {
        if (TextUtils.isEmpty(this.eventName)) {
            return;
        }
        ThreadUtils.summit(new RunnableC0099a());
    }
}
