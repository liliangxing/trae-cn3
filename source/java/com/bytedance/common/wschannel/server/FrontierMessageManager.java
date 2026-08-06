package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.utils.WsAsyncIOTaskManager;
import com.bytedance.common.wschannel.utils.WsAsyncTask;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FrontierMessageManager {
    private static final String FRONTIER_MSGID_ACK_HEADER = "x_frontier_ack_msgid";
    private static final String FRONTIER_MSGID_HEADER = "x_frontier_msgid";
    private static final String FRONTIER_MSG_ACK_ENABLED_HEADER = "x_frontier_is_ack";
    private static final String FRONTIER_MSG_ACK_ENABLED_VALUE = "1";
    private static final String FRONTIER_QOS_ACK_ENABLED_HEADER = "x_frontier_qos_ack";
    private static final String FRONTIER_QOS_ACK_ENABLED_VALUE = "1";
    private static final String FRONTIER_QOS_HEADER = "x_frontier_qos";
    private static final String FRONTIER_QOS_VALUE = "2";
    private static final String FRONTIER_TTL_HEADER = "x_frontier_ttl";
    private static final String LOG_TYPE = "frontier_qos2";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static final int WAIT_QOS_INIT_MAX_MILLS = 3000;
    private static Context sContext;
    private static IFrontierMessageDepend sFrontierMessageDepend;
    private static volatile FrontierPersistentBuffer sFrontierPersistentBuffer;
    private static volatile boolean sQos2Enabled;
    private static Object sTTNetInitInstance;
    private static final AtomicBoolean sLazyInitFinished = new AtomicBoolean(false);
    private static CountDownLatch sQoSInitFinishedCountDown = new CountDownLatch(1);
    private static final String TAG = "FrontierMessageManager";

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface IFrontierMessageDepend {
        void messageLogReport(String str, JSONObject jSONObject);
    }

    public static void enableQos2OnFrontierConnection(boolean z, Context context, IFrontierMessageDepend iFrontierMessageDepend) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        sQos2Enabled = z;
        sContext = context;
        sFrontierMessageDepend = iFrontierMessageDepend;
    }

    public static void reportFrontierMessageLog(JSONObject jSONObject) {
        IFrontierMessageDepend iFrontierMessageDepend = sFrontierMessageDepend;
        if (iFrontierMessageDepend != null) {
            iFrontierMessageDepend.messageLogReport(LOG_TYPE, jSONObject);
        }
        try {
            Object obj = sTTNetInitInstance;
            if (obj != null) {
                Reflect.m213on(obj).call("monitorLogSend", new Class[]{String.class, JSONObject.class}, LOG_TYPE, jSONObject);
            }
        } catch (Throwable unused) {
        }
    }

    private static void tryWaitPersistentBufferInit() {
        if (sLazyInitFinished.get()) {
            return;
        }
        try {
            sQoSInitFinishedCountDown.await(WsConstants.EXIT_DELAY_TIME, TimeUnit.MILLISECONDS);
            if (sQoSInitFinishedCountDown.getCount() == 1) {
                sQoSInitFinishedCountDown.countDown();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setPersistentBufferInitFinished() {
        sLazyInitFinished.set(true);
        sQoSInitFinishedCountDown.countDown();
    }

    private static Map<String, String> covertMsgHeadersToMap(List<WsChannelMsg.MsgHeader> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (WsChannelMsg.MsgHeader msgHeader : list) {
            if (!TextUtils.isEmpty(msgHeader.getKey()) && !TextUtils.isEmpty(msgHeader.getValue())) {
                hashMap.put(msgHeader.getKey(), msgHeader.getValue());
            }
        }
        return hashMap;
    }

    private static boolean isValidMsgHeader(Map<String, String> map) {
        if (map.containsKey(FRONTIER_QOS_HEADER) && map.containsKey("x_frontier_msgid") && map.containsKey(FRONTIER_TTL_HEADER) && map.get(FRONTIER_QOS_HEADER) != null && map.get(FRONTIER_QOS_HEADER).equals("2")) {
            String str = map.get("x_frontier_msgid");
            try {
                if (!TextUtils.isEmpty(str)) {
                    return str.getBytes(UrlUtils.UTF_8).length == 32 && Long.valueOf(map.get(FRONTIER_TTL_HEADER)).longValue() > 0;
                }
            } catch (UnsupportedEncodingException | Exception unused) {
            }
        }
        return false;
    }

    private static boolean isValidAckMsgHeader(Map<String, String> map) {
        return map.containsKey(FRONTIER_QOS_HEADER) && map.containsKey(FRONTIER_QOS_ACK_ENABLED_HEADER) && map.containsKey(FRONTIER_MSG_ACK_ENABLED_HEADER) && map.containsKey(FRONTIER_MSGID_ACK_HEADER) && map.get(FRONTIER_QOS_HEADER) != null && map.get(FRONTIER_QOS_HEADER).equals("2") && map.get(FRONTIER_QOS_ACK_ENABLED_HEADER) != null && map.get(FRONTIER_QOS_ACK_ENABLED_HEADER).equals("1") && map.get(FRONTIER_MSG_ACK_ENABLED_HEADER) != null && map.get(FRONTIER_MSG_ACK_ENABLED_HEADER).equals("1") && !TextUtils.isEmpty(map.get(FRONTIER_MSGID_ACK_HEADER));
    }

    private static String[] getAckMsgIdFromCurrentMessage(Map<String, String> map) {
        if (map.containsKey(FRONTIER_MSG_ACK_ENABLED_HEADER) && map.containsKey(FRONTIER_MSGID_ACK_HEADER) && map.get(FRONTIER_MSG_ACK_ENABLED_HEADER).equals("1") && !TextUtils.isEmpty(map.get(FRONTIER_MSGID_ACK_HEADER))) {
            return map.get(FRONTIER_MSGID_ACK_HEADER).split(",");
        }
        return null;
    }

    private static boolean isFrontierMsgHeader(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(FRONTIER_QOS_HEADER) || str.equals("x_frontier_msgid") || str.equals(FRONTIER_TTL_HEADER) || str.equals(FRONTIER_MSGID_ACK_HEADER) || str.equals(FRONTIER_MSG_ACK_ENABLED_HEADER);
    }

    private static void removeFrontierHeaderForWsMsg(WsChannelMsg wsChannelMsg) {
        Iterator<WsChannelMsg.MsgHeader> it;
        if (wsChannelMsg == null || wsChannelMsg.getMsgHeaders() == null || (it = wsChannelMsg.getMsgHeaders().iterator()) == null) {
            return;
        }
        while (it.hasNext()) {
            if (isFrontierMsgHeader(it.next().getKey())) {
                it.remove();
            }
        }
    }

    private static void initTTNetInitInstance() {
        if (sTTNetInitInstance != null) {
            return;
        }
        try {
            sTTNetInitInstance = Class.forName(TTNET_INIT_CLASS).newInstance();
            if (Logger.debug()) {
                Logger.m190d(TAG, "Get TTNetInit instance success.");
            }
        } catch (Throwable th) {
            Logger.m193e(TAG, "Get TTNetInit instance failed.");
            th.printStackTrace();
        }
    }

    public static boolean shouldDropMessageByFilter(WsChannelMsg wsChannelMsg) {
        if (!sQos2Enabled) {
            return false;
        }
        try {
            Map<String, String> covertMsgHeadersToMap = covertMsgHeadersToMap(wsChannelMsg.getMsgHeaders());
            if (covertMsgHeadersToMap != null && !covertMsgHeadersToMap.isEmpty()) {
                boolean isValidAckMsgHeader = isValidAckMsgHeader(covertMsgHeadersToMap);
                boolean isValidMsgHeader = isValidMsgHeader(covertMsgHeadersToMap);
                if (!isValidAckMsgHeader && !isValidMsgHeader) {
                    return false;
                }
                AtomicBoolean atomicBoolean = sLazyInitFinished;
                if (!atomicBoolean.get()) {
                    initTTNetInitInstance();
                    WsAsyncIOTaskManager.getInstance().postTask(new WsAsyncTask() { // from class: com.bytedance.common.wschannel.server.FrontierMessageManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FrontierPersistentBuffer unused = FrontierMessageManager.sFrontierPersistentBuffer = new FrontierPersistentBuffer(FrontierMessageManager.sContext);
                            FrontierMessageManager.sFrontierPersistentBuffer.initFinished();
                        }
                    });
                    tryWaitPersistentBufferInit();
                }
                if (!atomicBoolean.get() || sFrontierPersistentBuffer == null) {
                    return false;
                }
                if (Logger.debug()) {
                    Logger.m190d(TAG, "origin wschannel msg:" + wsChannelMsg.toString());
                }
                if (isValidAckMsgHeader) {
                    sFrontierPersistentBuffer.ackMessage(covertMsgHeadersToMap.get(FRONTIER_MSGID_ACK_HEADER).split(","));
                    return true;
                }
                sFrontierPersistentBuffer.ackMessage(getAckMsgIdFromCurrentMessage(covertMsgHeadersToMap));
                removeFrontierHeaderForWsMsg(wsChannelMsg);
                return sFrontierPersistentBuffer.shouldDropMessageAndUpdateFile(covertMsgHeadersToMap.get("x_frontier_msgid"), Long.valueOf(covertMsgHeadersToMap.get(FRONTIER_TTL_HEADER)).longValue());
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean isQos2Enabled() {
        return sQos2Enabled;
    }
}
