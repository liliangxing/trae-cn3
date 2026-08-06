package com.bytedance.platform.horae.java_impl.async;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.platform.horae.OnEventOccur;
import com.bytedance.platform.horae.common.Logger;
import com.bytedance.platform.horae.java_impl.ServiceFollowBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AsyncScheduleCenter extends Handler {
    private static final int CREATE_SERVICE = 114;
    public static final int SEND_MESSAGE = 100;
    public static final int STOP_MESSAGE = 101;
    private Map<String, List<Message>> mReverseMessages;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 100) {
            if (message.obj instanceof Message) {
                final Message message2 = (Message) message.obj;
                if (AsyncMessageHandleUtils.isServiceOrReceiverMessage(message2)) {
                    ServiceFollowBean fetchServiceName = ServiceFollowBean.fetchServiceName(message2);
                    if (TextUtils.isEmpty(fetchServiceName.mServiceName)) {
                        List<Message> list = this.mReverseMessages.get(fetchServiceName.mToken);
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(message2);
                        this.mReverseMessages.put(fetchServiceName.mToken, list);
                        Logger.m205e("AsyncScheduleCenter", "Hint reversed message , first store it!");
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    int i = message2.what;
                    OnEventOccur onEventOccur = AsyncServiceScheduleManager.getInstance().getOnEventOccur();
                    AsyncMessageHandleUtils.handleMessage(message2);
                    addServiceFollowBean(fetchServiceName);
                    if (onEventOccur != null) {
                        onEventOccur.onAsyncDispatchComponents(fetchServiceName.mServiceName, i, System.currentTimeMillis() - currentTimeMillis);
                    }
                    List<Message> list2 = this.mReverseMessages.get(fetchServiceName.mToken);
                    if (list2 != null && message2.what == 114) {
                        for (Message message3 : list2) {
                            Logger.m205e("AsyncScheduleCenter", "Hint reverse message's father = " + fetchServiceName + "so fix it!");
                            fetchServiceName = ServiceFollowBean.fetchServiceName(message3);
                            Logger.m205e("AsyncScheduleCenter", "After father message now service follow bean is " + fetchServiceName);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            int i2 = message3.what;
                            AsyncMessageHandleUtils.handleMessage(message3);
                            if (onEventOccur != null) {
                                onEventOccur.onAsyncDispatchComponents(fetchServiceName.mServiceName, i2, System.currentTimeMillis() - currentTimeMillis2);
                            }
                            addServiceFollowBean(fetchServiceName);
                        }
                        list2.clear();
                    }
                    Logger.m205e("AsyncScheduleCenter", "Handle message " + message2);
                    return;
                }
                new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.platform.horae.java_impl.async.AsyncScheduleCenter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AsyncMessageHandleUtils.handleMessage(message2);
                    }
                });
                return;
            }
            return;
        }
        AsyncServiceTrackMonitor.getInstance().notifySubThreadDown();
    }

    private void addServiceFollowBean(ServiceFollowBean serviceFollowBean) {
        try {
            AsyncServiceTrackMonitor.getInstance().addServiceFollowBean(serviceFollowBean);
            if (AsyncServiceTrackMonitor.getInstance().getServiceTraceInfo().size() > 100) {
                AsyncServiceTrackMonitor.getInstance().getServiceTraceInfo().subList(0, 50).clear();
            }
        } catch (Throwable unused) {
        }
    }

    public AsyncScheduleCenter(Looper looper) {
        super(looper);
        this.mReverseMessages = new HashMap();
    }
}
