package com.bytedance.crash.dumper;

import android.app.Activity;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ViewTree {
    public static final String FILE_NAME = "viewTree.txt";

    public static void dump(File file) {
        JSONArray viewTree = getViewTree();
        if (viewTree != null) {
            try {
                FileUtils.writeFile(new File(file, FILE_NAME), viewTree, false);
            } catch (Throwable unused) {
            }
        }
    }

    private static JSONArray getViewTree() {
        Window window;
        View peekDecorView;
        JSONArray jSONArray = new JSONArray();
        ArrayList<WeakReference<Activity>> allActivities = ActivityLifecycle.getAllActivities();
        if (allActivities == null || allActivities.size() <= 0) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<WeakReference<Activity>> it = allActivities.iterator();
        while (it.hasNext()) {
            Activity activity = it.next().get();
            if (activity != null && (window = activity.getWindow()) != null && (peekDecorView = window.peekDecorView()) != null) {
                JSONObject jSONObject = new JSONObject();
                linkedList.add(new Pair(peekDecorView, jSONObject));
                jSONArray.put(jSONObject);
            }
        }
        while (!linkedList.isEmpty()) {
            Pair pair = (Pair) linkedList.pop();
            View view = (View) pair.first;
            JSONObject jSONObject2 = (JSONObject) pair.second;
            JSONUtils.put(jSONObject2, "cls", String.valueOf(view.getClass()));
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                JSONArray jSONArray2 = new JSONArray();
                JSONUtils.put(jSONObject2, "children", jSONArray2);
                for (int i = 0; i < childCount; i++) {
                    try {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt != null) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONArray2.put(jSONObject3);
                            linkedList.push(new Pair(childAt, jSONObject3));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return jSONArray;
    }
}
