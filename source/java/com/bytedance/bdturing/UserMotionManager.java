package com.bytedance.bdturing;

import com.bytedance.bdturing.methods.JsCallParser;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import net.openid.appauth.AuthorizationRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class UserMotionManager {
    private static ReentrantLock mMotionLock = new ReentrantLock();
    private static List<JSONObject> mMotionList = new LinkedList();

    public static void collectUserMotion(long j, float f, float f2, int i, float f3, float f4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", j);
            jSONObject.put("force", f);
            jSONObject.put("majorRadius", f2);
            jSONObject.put("phase", i);
            jSONObject.put("x", f3);
            jSONObject.put("y", f4);
            try {
                mMotionLock.lockInterruptibly();
                mMotionList.add(jSONObject);
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                mMotionLock.unlock();
                throw th;
            }
            mMotionLock.unlock();
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void clearMotionList() {
        try {
            mMotionLock.lockInterruptibly();
            mMotionList.clear();
        } catch (Exception unused) {
        } catch (Throwable th) {
            mMotionLock.unlock();
            throw th;
        }
        mMotionLock.unlock();
    }

    public static void responseGetTouchToJs(JsCallParser jsCallParser) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os_name", "android");
            mMotionLock.lockInterruptibly();
            jSONObject.put(AuthorizationRequest.Display.TOUCH, new JSONArray((Collection) mMotionList));
            LogUtil.d("onTouch", "responseGetTouchToJs motion list size " + mMotionList.size());
            mMotionList.clear();
            LogUtil.d("onTouch", "responseGetTouchToJs end motion list size " + mMotionList.size());
        } catch (Exception unused) {
        } catch (Throwable th) {
            mMotionLock.unlock();
            throw th;
        }
        mMotionLock.unlock();
        try {
            jsCallParser.response(1, jSONObject);
        } catch (Exception unused2) {
        }
    }
}
