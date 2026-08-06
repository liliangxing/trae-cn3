package com.bytedance.push.interfaze;

import android.content.Intent;
import com.bytedance.push.event.sync.IBusinessExtraInfoProvider;
import com.bytedance.push.event.sync.INotificationDeleteListener;
import com.bytedance.push.event.sync.ISignalReportApi;
import com.bytedance.push.event.sync.ISignalReporter;
import com.bytedance.push.event.sync.IUserExitsSignalInfoProvider;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public interface ISignalReportService extends ISignalReportApi {
    public static final String BODY_KEY_EVENT = "event";
    public static final String RESPONSE_KEY_MESSAGE = "message";

    ConcurrentHashMap<String, WeakReference<IBusinessExtraInfoProvider>> getBusinessExtraInfoProviderMap();

    ISignalReporter getISignalReporter();

    IUserExitsSignalInfoProvider getIUserExitsValidityChecker();

    void onHwScreenConfigDisable();

    void onNotificationDelete(long j);

    void onReceiveSignal(Intent intent);

    void registerNotificationDeleteListener(INotificationDeleteListener iNotificationDeleteListener);

    boolean syncEventToPushServer(List<String> list, Map<String, String> map);

    void triggerSignalReport(String str);
}
