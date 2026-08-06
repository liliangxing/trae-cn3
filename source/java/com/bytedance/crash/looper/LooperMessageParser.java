package com.bytedance.crash.looper;

import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LooperMessageParser {
    private static String typeName(int i, long j, long j2) {
        return i == 1 ? j <= 1 ? "idle" : 2 * j > j2 ? "native_busy" : j * 10 < j2 ? "native_lock" : "native_unknown" : i == 8 ? 2 * j > j2 ? "java_busy" : j * 10 < j2 ? "java_lock" : "java_unknown" : "normal";
    }

    private static String getBlockStack(JSONArray jSONArray, long j, long j2) {
        if (jSONArray == null) {
            return null;
        }
        long j3 = j2 + j;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            long optLong = optJSONObject.optLong("time");
            if (optLong >= j && optLong <= j3) {
                return optJSONObject.optString(TraceStatsConsts.STATS_KEY_TRACE);
            }
        }
        return null;
    }

    public static void addBlockStack(JSONArray jSONArray, JSONObject jSONObject, long j, boolean z) {
        long optLong;
        try {
            if (z) {
                optLong = jSONObject.optLong("currentMessageCost");
            } else {
                optLong = jSONObject.optLong("duration");
            }
            String blockStack = getBlockStack(jSONArray, j, optLong);
            if (blockStack != null) {
                JSONUtils.put(jSONObject, "block_stack", blockStack);
            }
        } catch (Throwable unused) {
        }
    }

    public static void pushToCrashBody(JSONObject jSONObject) {
        long j;
        long j2;
        int i;
        long j3;
        JSONArray optJSONArray = jSONObject.optJSONArray("history_message");
        JSONObject optJSONObject = jSONObject.optJSONObject("current_message");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("history_details");
        String str = "block_stack";
        JSONArray optJSONArray2 = jSONObject.optJSONArray("block_stack");
        if (optJSONObject2 == null) {
            JSONObject jSONObject2 = new JSONObject();
            JSONUtils.put(jSONObject2, "longestMsgType", "no_details");
            JSONUtils.put(jSONObject2, "longestMsg", "no_details");
            JSONUtils.put(jSONObject, "history_details", jSONObject2);
            return;
        }
        if (optJSONArray == null || optJSONArray.length() == 0) {
            JSONUtils.put(optJSONObject2, "longestMsgType", "no_history");
            JSONUtils.put(optJSONObject2, "longestMsg", "no_history");
            return;
        }
        long optLong = jSONObject.optLong("crash_time");
        long optLong2 = optJSONObject2.optLong("last_wall_time");
        long optLong3 = optJSONObject2.optLong("last_cpu_time");
        long j4 = 0;
        if (optLong == 0 || optLong2 == 0 || optLong3 == 0) {
            JSONUtils.put(optJSONObject2, "longestMsgType", "no_last_times");
            JSONUtils.put(optJSONObject2, "longestMsg", "no_last_times");
            return;
        }
        JSONUtils.put(optJSONObject2, "longestMsgType", "not_found");
        JSONUtils.put(optJSONObject2, "longestMsg", "not_found");
        if (optLong > optLong2 && optJSONObject != null) {
            j4 = optJSONObject.optLong("currentMessageCost");
            long j5 = optLong - optLong2;
            if (j5 < j4) {
                j4 = j5;
            }
            addBlockStack(optJSONArray2, optJSONObject, optLong2, true);
        }
        if (j4 < 5000) {
            long j6 = optLong - optLong2;
            int length = optJSONArray.length() - 1;
            long j7 = j4;
            int i2 = -1;
            while (length >= 0 && j6 < 10000) {
                long j8 = optLong2;
                JSONObject optJSONObject3 = optJSONArray.optJSONObject(length);
                if (optJSONObject3 == null) {
                    j3 = optLong3;
                } else {
                    long optLong4 = optJSONObject3.optLong("duration");
                    j6 += optLong4;
                    j3 = optLong3;
                    addBlockStack(optJSONArray2, optJSONObject3, optLong - j6, false);
                    if (j6 > 2500 && optLong4 > j7) {
                        i2 = length;
                        j7 = optLong4;
                    }
                }
                length--;
                optLong2 = j8;
                optLong3 = j3;
            }
            j = optLong2;
            j2 = optLong3;
            i = i2;
        } else {
            j = optLong2;
            j2 = optLong3;
            i = -1;
        }
        long j9 = j4;
        if (i < 0) {
            if (optJSONObject != null) {
                JSONUtils.put(optJSONObject2, "longestMsgWallDuration", Long.valueOf(j9));
                JSONUtils.put(optJSONObject2, "longestMessageCpuDuration", -1);
                JSONUtils.put(optJSONObject2, "longestMsgStartCpuTime", Long.valueOf(j2));
                JSONUtils.put(optJSONObject2, "longestMsgEndCpuTime", -1);
                JSONUtils.put(optJSONObject2, "longestMsgStartWallTime", Long.valueOf(j));
                JSONUtils.put(optJSONObject2, "longestMsgEndWallTime", Long.valueOf(j + j9));
                JSONUtils.put(optJSONObject2, "longestMsgType", PerfConsts.KEY_CURRENT_GALVANIC);
                JSONUtils.put(optJSONObject2, "longestMsg", optJSONObject.optString("message"));
                JSONUtils.put(optJSONObject2, "longestMsgBlockStack", optJSONObject.optString("block_stack"));
                return;
            }
            return;
        }
        int length2 = optJSONArray.length() - 1;
        while (length2 >= i) {
            String str2 = str;
            JSONObject optJSONObject4 = optJSONArray.optJSONObject(length2);
            if (optJSONObject4 != null) {
                j -= optJSONObject4.optLong("duration");
                j2 -= optJSONObject4.optLong("cpuDuration");
            }
            length2--;
            str = str2;
        }
        String str3 = str;
        JSONObject optJSONObject5 = optJSONArray.optJSONObject(i);
        if (optJSONObject5 != null) {
            long optLong5 = optJSONObject5.optLong("duration");
            long optLong6 = optJSONObject5.optLong("cpuDuration");
            JSONUtils.put(optJSONObject2, "longestMsgWallDuration", Long.valueOf(optLong5));
            JSONUtils.put(optJSONObject2, "longestMessageCpuDuration", Long.valueOf(optLong6));
            JSONUtils.put(optJSONObject2, "longestMsgStartCpuTime", Long.valueOf(j2));
            JSONUtils.put(optJSONObject2, "longestMsgEndCpuTime", Long.valueOf(j2 + optLong6));
            JSONUtils.put(optJSONObject2, "longestMsgStartWallTime", Long.valueOf(j));
            JSONUtils.put(optJSONObject2, "longestMsgEndWallTime", Long.valueOf(j + optLong5));
            JSONUtils.put(optJSONObject2, "longestMsgType", typeName(optJSONObject5.optInt("type"), optLong6, optLong5));
            JSONUtils.put(optJSONObject2, "longestMsg", optJSONObject5.optString("message"));
            JSONUtils.put(optJSONObject2, "longestMsgBlockStack", optJSONObject5.optString(str3));
        }
    }

    private static boolean isTraceEvil(JSONObject jSONObject, JSONObject jSONObject2) {
        long optLong = jSONObject.optLong("main_thread_cpu_tick") * jSONObject.optInt(Constants.KEY_HW_JIFFIES);
        long optLong2 = jSONObject2.optLong("longestMsgStartCpuTime");
        long optLong3 = jSONObject2.optLong("longestMsgEndCpuTime");
        if (optLong == 0 || optLong2 == 0) {
            return false;
        }
        return optLong >= (optLong2 / 10) * 10 && optLong < (optLong3 / 10) * 10;
    }

    public static void pushToFilters(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("history_message");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            JSONUtils.put(jSONObject2, "has_history_message", RouterConstants.TRUE);
        } else {
            JSONUtils.put(jSONObject2, "has_history_message", "false");
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("pending_messages");
        if (optJSONArray2 != null && optJSONArray2.length() > 0 && (optJSONObject = optJSONArray2.optJSONObject(0)) != null) {
            JSONUtils.put(jSONObject2, "npth_message_anr_with_barrier_new", String.valueOf(optJSONObject.optString("target").isEmpty()));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("history_details");
        if (optJSONObject2 != null) {
            JSONUtils.put(jSONObject2, "npth_message_longest_msg", optJSONObject2.optString("longestMsg"));
            JSONUtils.put(jSONObject2, "npth_message_longest_msg_type", optJSONObject2.optString("longestMsgType"));
            JSONUtils.put(jSONObject2, "npth_message_trace_is_evil", String.valueOf(isTraceEvil(jSONObject, optJSONObject2)));
            JSONUtils.put(jSONObject2, "npth_message_has_block_stack", String.valueOf(!"".equals(optJSONObject2.optString("longestMsgBlockStack"))));
        }
    }
}
