package com.bytedance.push.third;

import android.content.Context;
import android.content.Intent;
import com.bytedance.push.PushSupporter;
import com.ss.android.message.IPushLifeAdapter;
import com.ss.android.pushmanager.IMessageContext;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushLifeManager implements IPushLifeAdapter {
    private static volatile PushLifeManager inst;
    private IPushLifeAdapter.IPushDepend mIPushDepend;
    private List<IPushLifeAdapter> mIPushLifeAdapterList = Collections.emptyList();

    public void setPushDepend(IPushLifeAdapter.IPushDepend iPushDepend) {
    }

    public static PushLifeManager inst() {
        if (inst == null) {
            synchronized (PushLifeManager.class) {
                if (inst == null) {
                    inst = new PushLifeManager();
                }
            }
        }
        return inst;
    }

    private PushLifeManager() {
    }

    public void initOnApplication(Context context, IMessageContext iMessageContext) {
        this.mIPushDepend = new IPushLifeAdapter.IPushDepend() { // from class: com.bytedance.push.third.PushLifeManager.1
            public void onEvent(Context context2, String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
                PushSupporter.statisticsService().onEvent(context2, str, str2, str3, j, j2, jSONObject);
            }

            public void onEventV3(String str, JSONObject jSONObject) {
                PushSupporter.statisticsService().onEventV3(str, jSONObject);
            }
        };
        List<IPushLifeAdapter> list = this.mIPushLifeAdapterList;
        if (list != null) {
            for (IPushLifeAdapter iPushLifeAdapter : list) {
                try {
                    iPushLifeAdapter.setPushDepend(this.mIPushDepend);
                    iPushLifeAdapter.initOnApplication(context, iMessageContext);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void onStart() {
        List<IPushLifeAdapter> list = this.mIPushLifeAdapterList;
        if (list != null) {
            Iterator<IPushLifeAdapter> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onStart();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void handleAppLogUpdate(Context context, Map<String, String> map) {
        List<IPushLifeAdapter> list = this.mIPushLifeAdapterList;
        if (list != null) {
            Iterator<IPushLifeAdapter> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().handleAppLogUpdate(context, map);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void onSetSettingsData(Context context, JSONObject jSONObject) {
        List<IPushLifeAdapter> list = this.mIPushLifeAdapterList;
        if (list != null) {
            Iterator<IPushLifeAdapter> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onSetSettingsData(context, jSONObject);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void onNotifyServiceCreate(Context context) {
        List<IPushLifeAdapter> list = this.mIPushLifeAdapterList;
        if (list != null) {
            Iterator<IPushLifeAdapter> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onNotifyServiceCreate(context);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void onNotifyServiceStart(Intent intent) {
        List<IPushLifeAdapter> list = this.mIPushLifeAdapterList;
        if (list != null) {
            Iterator<IPushLifeAdapter> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onNotifyServiceStart(intent);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void onNotifyDestroy() {
        List<IPushLifeAdapter> list = this.mIPushLifeAdapterList;
        if (list != null) {
            Iterator<IPushLifeAdapter> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onNotifyDestroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void setPushLifeAdapters(List<IPushLifeAdapter> list) {
        this.mIPushLifeAdapterList = list;
    }
}
