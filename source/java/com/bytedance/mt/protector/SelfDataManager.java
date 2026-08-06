package com.bytedance.mt.protector;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.Expose;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SelfDataManager {
    private static final int CACHE_SIZE = 5;
    private static final String TAG = "BusinessTokenManager";
    private static final long dataTimeout = 180000;
    private static SelfDataManager instance = new SelfDataManager();
    private final ThreadLocal<SelfDataItem> mItemLocal = new ThreadLocal<>();
    private final List<SelfDataItem> selfDataItems = Collections.synchronizedList(new ArrayList());
    private final Gson gson = new GsonBuilder().setLenient().excludeFieldsWithoutExposeAnnotation().create();
    private final long initTimeStamp = System.currentTimeMillis();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class SelfDataItem {

        @Expose
        JsonElement payload;
        Throwable sourceThrowable;

        @Expose
        long timeStamp;

        @Expose
        String type;

        SelfDataItem() {
        }

        public String toString() {
            return "SelfDataItem{, payload=" + this.payload + ", timeStamp=" + this.timeStamp + ", type=" + this.type + '}';
        }

        public JsonElement toJsonObject(Gson gson) {
            return gson.toJsonTree(this);
        }
    }

    private SelfDataManager() {
    }

    public static SelfDataManager getInstance() {
        return instance;
    }

    public void addData(String str, JsonElement jsonElement, Throwable th) {
        SelfDataItem selfDataItem = new SelfDataItem();
        selfDataItem.type = str;
        if (jsonElement != null) {
            selfDataItem.payload = jsonElement;
        } else {
            selfDataItem.payload = JsonNull.INSTANCE;
        }
        selfDataItem.sourceThrowable = th;
        selfDataItem.timeStamp = System.currentTimeMillis();
        if (this.selfDataItems.size() >= 5) {
            this.selfDataItems.remove(0);
        }
        this.selfDataItems.add(selfDataItem);
        this.mItemLocal.set(selfDataItem);
    }

    public void clearData() {
        this.selfDataItems.clear();
    }

    public JsonObject toJsonObject() {
        return toJsonObject(null);
    }

    private String getStack(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        printWriter.close();
        return stringWriter.toString();
    }

    private boolean isSameException(Throwable th, Throwable th2) {
        if (th == null || th2 == null) {
            return false;
        }
        if (th == th2) {
            return true;
        }
        return TextUtils.equals(getStack(th), getStack(th2));
    }

    public JsonObject toJsonObject(Throwable th) {
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        SelfDataItem selfDataItem = this.mItemLocal.get();
        if (selfDataItem != null && isSameException(selfDataItem.sourceThrowable, th)) {
            jsonArray.add(selfDataItem.toJsonObject(this.gson));
        } else {
            synchronized (this.selfDataItems) {
                for (SelfDataItem selfDataItem2 : this.selfDataItems) {
                    if (th == null) {
                        jsonArray.add(selfDataItem2.toJsonObject(this.gson));
                    } else if (selfDataItem2 != null && isSameException(selfDataItem2.sourceThrowable, th)) {
                        jsonArray.add(selfDataItem2.toJsonObject(this.gson));
                    }
                }
                this.selfDataItems.size();
            }
        }
        jsonObject.add("initTimeStamp", new JsonPrimitive(Long.valueOf(this.initTimeStamp)));
        jsonObject.add("reportTimeStamp", new JsonPrimitive(Long.valueOf(System.currentTimeMillis())));
        jsonObject.add("data", jsonArray);
        LogUtils.dWithTag(TAG, "toJsonObject" + jsonObject.toString());
        return jsonObject;
    }
}
