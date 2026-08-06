package com.bytedance.applog.batch;

import com.bytedance.applog.AppLogHelper;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.monitor.exception.AppLogExceptionManager;
import com.bytedance.applog.monitor.p006v3.StageEventType;
import com.bytedance.applog.monitor.p006v3.StatsCountKeys;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PackCalculator {
    public static final int BUFFER_LENGTH = 5120;
    private boolean abort;
    private int beginLength;
    private final boolean enabled = PackOptConfig.packByLengthEnabled;
    private int eventV1Count;
    private int eventV3Count;
    private int length;
    private int logDataCount;

    public boolean isEnabled() {
        return this.enabled;
    }

    public void beginPack(JSONObject jSONObject) {
        if (this.enabled) {
            this.eventV3Count = 0;
            this.eventV1Count = 0;
            int utf8StringLength = getUtf8StringLength(jSONObject) + BUFFER_LENGTH;
            this.beginLength = utf8StringLength;
            this.length = utf8StringLength;
            this.abort = false;
        }
    }

    public boolean appendEventV3(JSONObject jSONObject) {
        int utf8StringLength = (this.eventV3Count == 0 ? 14 : 1) + getUtf8StringLength(jSONObject);
        if (!allowAppend(utf8StringLength)) {
            return false;
        }
        this.length += utf8StringLength;
        this.eventV3Count++;
        return true;
    }

    public boolean appendEventV1(JSONObject jSONObject) {
        int utf8StringLength = (this.eventV1Count == 0 ? 11 : 1) + getUtf8StringLength(jSONObject);
        if (!allowAppend(utf8StringLength)) {
            return false;
        }
        this.length += utf8StringLength;
        this.eventV1Count++;
        return true;
    }

    public boolean appendLogData(JSONObject jSONObject) {
        int utf8StringLength = (this.logDataCount == 0 ? 14 : 1) + getUtf8StringLength(jSONObject);
        if (!allowAppend(utf8StringLength)) {
            return false;
        }
        this.length += utf8StringLength;
        this.logDataCount++;
        return true;
    }

    public boolean allowAppend(int i) {
        return ((long) (this.length + i)) < PackOptConfig.packLimitLength;
    }

    public boolean appendLength(int i) {
        if (!allowAppend(i)) {
            return false;
        }
        this.length += i;
        return true;
    }

    public int getBeginLength() {
        return this.beginLength;
    }

    public int getLength() {
        return this.length;
    }

    public static boolean allowLength(int i) {
        return ((long) i) < PackOptConfig.packLimitLength;
    }

    public static boolean allowStringLength(String str) {
        return allowLength(getUtf8StringLength(str));
    }

    public static int getUtf8StringLength(JSONObject jSONObject) {
        if (jSONObject == null) {
            return 0;
        }
        Iterator<String> keys = jSONObject.keys();
        boolean z = true;
        int i = 2;
        while (keys.hasNext()) {
            if (!z) {
                i++;
            }
            String next = keys.next();
            i = i + getUtf8StringLength(next) + 3 + getValueUtf8Length(jSONObject.opt(next));
            z = false;
        }
        return i;
    }

    public static int getUtf8StringLength(JSONArray jSONArray) {
        if (jSONArray == null) {
            return 0;
        }
        boolean z = true;
        int i = 2;
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            if (!z) {
                i++;
            }
            i += getValueUtf8Length(jSONArray.opt(i2));
            i2++;
            z = false;
        }
        return i;
    }

    private static int getValueUtf8Length(Object obj) {
        if (obj instanceof JSONObject) {
            return getUtf8StringLength((JSONObject) obj);
        }
        if (obj instanceof JSONArray) {
            return getUtf8StringLength((JSONArray) obj);
        }
        if (obj instanceof String) {
            return getEscapedUtf8StringLength((String) obj) + 2;
        }
        return String.valueOf(obj).length();
    }

    private static int getEscapedUtf8StringLength(String str) {
        int i = 0;
        if (str == null) {
            return 0;
        }
        int i2 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != '\f' && charAt != '\r' && charAt != '\"' && charAt != '/' && charAt != '\\') {
                switch (charAt) {
                    case '\b':
                    case '\t':
                    case '\n':
                        break;
                    default:
                        if (charAt > 127) {
                            if (charAt > 2047) {
                                if (!Character.isHighSurrogate(charAt)) {
                                    i2 += 3;
                                    break;
                                } else {
                                    i2 += 4;
                                    i++;
                                    break;
                                }
                            }
                        } else {
                            i2++;
                            break;
                        }
                        break;
                }
            }
            i2 += 2;
            i++;
        }
        return i2;
    }

    public static int getUtf8StringLength(String str) {
        int i = 0;
        if (str == null) {
            return 0;
        }
        int i2 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt <= 127) {
                i2++;
            } else if (charAt <= 2047) {
                i2 += 2;
            } else if (Character.isHighSurrogate(charAt)) {
                i2 += 4;
                i++;
            } else {
                i2 += 3;
            }
            i++;
        }
        return i2;
    }

    public static int checkEventJSONLength(String str) {
        if (str == null || str.length() * 4 <= PackOptConfig.eventLimitLength) {
            return -1;
        }
        int utf8StringLength = getUtf8StringLength(str);
        if (utf8StringLength > PackOptConfig.eventLimitLength) {
            return utf8StringLength;
        }
        return -1;
    }

    public static String checkJSONLengthAndReplace(String str, StageEventType stageEventType, String str2, String str3) {
        int checkEventJSONLength = checkEventJSONLength(str3);
        if (checkEventJSONLength <= 0) {
            return str3;
        }
        AppLogExceptionManager.getInstance().dispatchOutOfDataBoundary(stageEventType, str2, str3, PackOptConfig.eventLimitLength);
        AppLogInstance instanceByAppId = AppLogHelper.getInstanceByAppId(str);
        if (instanceByAppId != null) {
            instanceByAppId.getMonitorHelper().increaseStats(StatsCountKeys.PARAMS_CLEARED_BY_EVENT_SIZE_LIMIT);
        }
        return getEventLengthLimitJSONString(checkEventJSONLength);
    }

    public static String getEventLengthLimitJSONString(int i) {
        return "{\"params_cleared_by_event_size_limit\":\"" + i + "\",\"max_event_size\":\"" + PackOptConfig.eventLimitLength + "\"}";
    }

    public void setAbort(boolean z) {
        this.abort = z;
    }

    public boolean isAbort() {
        return this.abort;
    }
}
