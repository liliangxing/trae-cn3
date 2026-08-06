package com.bytedance.tobshadow.bdtracker;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.tobshadow.applog.C0355R;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.C0389b0;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0411e {

    /* renamed from: a */
    public static String f535a;

    /* renamed from: com.bytedance.tobshadow.bdtracker.e$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class a implements Runnable {

        /* renamed from: a */
        public final Runnable f536a;

        /* renamed from: b */
        public final String f537b;

        /* renamed from: c */
        public final String f538c = Log.getStackTraceString(new RuntimeException("origin stacktrace"));

        public a(Runnable runnable, String str) {
            this.f536a = runnable;
            this.f537b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f536a.run();
            } catch (Throwable th) {
                LoggerImpl.global().error(1, C0380a.m252a("Oaid#Thread:").append(this.f537b).append(" exception\n").append(this.f538c).toString(), th, new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public static Activity m344a(Context context) {
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        do {
            ContextWrapper contextWrapper = (ContextWrapper) context;
            if (contextWrapper instanceof Activity) {
                return (Activity) contextWrapper;
            }
            context = contextWrapper.getBaseContext();
        } while (context instanceof ContextWrapper);
        return null;
    }

    /* renamed from: a */
    public static Class<?> m346a(String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                Class<?> m367b = m367b(str);
                if (m367b != null) {
                    return m367b;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m347a(Object obj) {
        return obj != null ? obj.toString() : "";
    }

    /* renamed from: a */
    public static List m348a() {
        return CollectionsKt.listOf(new String[]{"metrics_category", "metrics_name"});
    }

    /* renamed from: a */
    public static final <T> JSONArray m349a(List<T> list) {
        Intrinsics.checkParameterIsNotNull(list, "$this$listToJsonArray");
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static JSONObject m350a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            LinkedList linkedList = new LinkedList();
            while (keys.hasNext()) {
                linkedList.add(keys.next());
            }
            return new JSONObject(jSONObject, (String[]) linkedList.toArray(new String[0]));
        } catch (Throwable th) {
            LoggerImpl.global().error("copy safe json error", th, new Object[0]);
            return jSONObject;
        }
    }

    /* renamed from: a */
    public static JSONObject m351a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null) {
            try {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.opt(next));
                }
            } catch (Throwable th) {
                LoggerImpl.global().error("copy json error", th, new Object[0]);
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m352a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                LoggerImpl.global().error("closeSafely error", th, new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public static void m353a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable th) {
                LoggerImpl.global().error("endDbTransactionSafely error", th, new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public static void m356a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                LoggerImpl.global().error("closeSafely error", th, new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public static boolean m357a(Object obj, Object obj2) {
        return (obj != null || obj2 == null) && (obj == null || obj2 != null);
    }

    /* renamed from: a */
    public static boolean m358a(Object obj, Object obj2, String str) {
        if (!m357a(obj, obj2)) {
            return false;
        }
        if (obj instanceof JSONObject) {
            return m363a((JSONObject) obj, (JSONObject) obj2, str);
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            JSONArray jSONArray2 = (JSONArray) obj2;
            if (!m357a(jSONArray, jSONArray2)) {
                return false;
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj3 = jSONArray.get(i);
                hashMap.put(obj3, (!hashMap.containsKey(obj3) || hashMap.get(obj3) == null) ? 1 : Integer.valueOf(((Integer) hashMap.get(obj3)).intValue() + 1));
            }
            HashMap hashMap2 = new HashMap();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                Object obj4 = jSONArray2.get(i2);
                hashMap2.put(obj4, (!hashMap2.containsKey(obj4) || hashMap2.get(obj4) == null) ? 1 : Integer.valueOf(((Integer) hashMap2.get(obj4)).intValue() + 1));
            }
            if (hashMap.size() != hashMap2.size()) {
                return false;
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                if (!((Integer) entry.getValue()).equals((Integer) hashMap2.get(entry.getKey()))) {
                    return false;
                }
            }
            return true;
        }
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        String obj5 = obj.toString();
        String obj6 = obj2.toString();
        return m357a((Object) obj5, (Object) obj6) && obj5.equals(obj6);
    }

    /* renamed from: a */
    public static boolean m359a(Object obj, String str) {
        return m365a(obj == null, str);
    }

    /* renamed from: a */
    public static boolean m360a(Object obj, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                Class<?> m367b = m367b(str);
                if (m367b != null && m367b.isInstance(obj)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m361a(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || "unknown".equalsIgnoreCase(str) || "Null".equalsIgnoreCase(str) || "un_support".equalsIgnoreCase(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z = true;
                break;
            }
            if (str.charAt(i) != '0') {
                break;
            }
            i++;
        }
        return !z;
    }

    /* renamed from: a */
    public static boolean m362a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || (str != null && str.equals(str2));
    }

    /* renamed from: a */
    public static boolean m363a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        if (!m357a((Object) jSONObject, (Object) jSONObject2)) {
            return false;
        }
        if (jSONObject != null && jSONObject.length() != jSONObject2.length()) {
            return false;
        }
        Iterator<String> keys = jSONObject.keys();
        boolean z = true;
        while (keys.hasNext()) {
            String next = keys.next();
            z = m358a(jSONObject.get(next), jSONObject2.get(next), next);
            if (!z) {
                break;
            }
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m364a(JSONObject jSONObject, Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (jSONObject == null) {
            return false;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            Object obj = jSONObject.get(keys.next());
            if (obj == null) {
                return false;
            }
            if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj2 = jSONArray.get(i);
                    if (clsArr2 != null && !m366a(clsArr2, obj2.getClass())) {
                        return false;
                    }
                }
            } else if (clsArr != null && !m366a(clsArr, obj.getClass())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static <T> boolean m366a(T[] tArr, T t) {
        for (T t2 : tArr) {
            if (t2 == t) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static Class<?> m367b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m368b() {
        BufferedReader bufferedReader;
        String str = f535a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) read);
                }
                str2 = sb.toString();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        m356a((Closeable) bufferedReader);
        f535a = str2;
        LoggerImpl.global().debug(C0380a.m252a("getProcessName: ").append(f535a).toString(), new Object[0]);
        return f535a;
    }

    /* renamed from: b */
    public static String m369b(View view) {
        if (view == null) {
            return null;
        }
        return m374c(view) + "$$" + view.hashCode();
    }

    /* renamed from: b */
    public static JSONObject m370b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        m351a(jSONObject2, jSONObject);
        try {
            String m303a = C0404d.m303a(jSONObject2.optJSONObject("oaid"));
            if (TextUtils.isEmpty(m303a)) {
                return jSONObject2;
            }
            jSONObject2.put("oaid", m303a);
            return jSONObject2;
        } catch (Throwable th) {
            LoggerImpl.global().error("transferHeaderOaid error", th, new Object[0]);
            return jSONObject2;
        }
    }

    /* renamed from: c */
    public static synchronized String m373c() {
        String str;
        synchronized (C0411e.class) {
            str = UUID.randomUUID().toString().replace("-", "").toLowerCase() + System.currentTimeMillis();
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a2  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m374c(View view) {
        boolean z;
        Class<?> m346a;
        if (view == null) {
            return "";
        }
        if (view instanceof CheckBox) {
            return "CheckBox";
        }
        if (view instanceof RadioButton) {
            return "RadioButton";
        }
        if (view instanceof ToggleButton) {
            return "ToggleButton";
        }
        if (view instanceof CompoundButton) {
            return m360a((Object) view, "android.widget.Switch") ? "Switch" : m360a((Object) view, "android.support.v7.widget.SwitchCompat", "androidx.appcompat.widget.SwitchCompat") ? "SwitchCompat" : "";
        }
        if (view instanceof Button) {
            return "Button";
        }
        if (view instanceof CheckedTextView) {
            return "CheckedTextView";
        }
        if (view instanceof TextView) {
            return "TextView";
        }
        if (view instanceof ImageView) {
            return "ImageView";
        }
        if (view instanceof RatingBar) {
            return "RatingBar";
        }
        if (view instanceof SeekBar) {
            return "SeekBar";
        }
        if (view instanceof Spinner) {
            return "Spinner";
        }
        try {
            m346a = m346a("android.support.design.widget.TabLayout$TabView", "com.google.android.material.tabs.TabLayout$TabView");
        } catch (Throwable th) {
            LoggerImpl.global().error(Collections.singletonList("WidgetUtils"), "Check isTabView failed", th, new Object[0]);
        }
        if (m346a != null) {
            if (m346a.isAssignableFrom(view.getClass())) {
                z = true;
                if (!z) {
                    return "TabLayout";
                }
                if (m360a((Object) view, "android.support.design.widget.NavigationView", "com.google.android.material.navigation.NavigationView")) {
                    return "NavigationView";
                }
                if (view instanceof ViewGroup) {
                    if (m360a((Object) view, "android.support.v7.widget.CardView", "androidx.cardview.widget.CardView")) {
                        return "CardView";
                    }
                    if (m360a((Object) view, "android.support.design.widget.NavigationView", "com.google.android.material.navigation.NavigationView")) {
                        return "NavigationView";
                    }
                }
                try {
                    return view.getClass().getCanonicalName();
                } catch (Throwable th2) {
                    LoggerImpl.global().error(Collections.singletonList("WidgetUtils"), "getCanonicalName failed", th2, new Object[0]);
                    return "";
                }
            }
        }
        z = false;
        if (!z) {
        }
    }

    /* renamed from: c */
    public static JSONObject m375c(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return jSONObject2;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                jSONObject2.put(next, jSONObject.opt(next));
            } catch (JSONException e) {
                LoggerImpl.global().error(Collections.singletonList("JsonUtils"), "Merge json interrupted.", e, new Object[0]);
            }
        }
        return jSONObject2;
    }

    /* renamed from: c */
    public static boolean m376c(String str) {
        return !m379d(str);
    }

    /* renamed from: d */
    public static List m377d() {
        return CollectionsKt.emptyList();
    }

    /* renamed from: d */
    public static boolean m378d(View view) {
        if (view == null) {
            return false;
        }
        if (C0403c6.m301a(view)) {
            return true;
        }
        if (view.getWidth() <= 0 || view.getHeight() <= 0 || view.getAlpha() <= 0.0f || !view.getLocalVisibleRect(new Rect())) {
            return false;
        }
        return !(view.getVisibility() == 0 || view.getAnimation() == null || !view.getAnimation().getFillAfter()) || view.getVisibility() == 0;
    }

    /* renamed from: d */
    public static boolean m379d(String str) {
        return str != null && str.length() > 0;
    }

    /* renamed from: e */
    public static boolean m380e(View view) {
        boolean m378d = m378d(view);
        if (!m378d) {
            return m378d;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (!(parent instanceof View)) {
                return m378d;
            }
            if (!m378d((View) parent)) {
                break;
            }
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m381e(String str) {
        int length = str != null ? str.length() : 0;
        if (length < 13 || length > 128) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m372b(JSONObject jSONObject, JSONObject jSONObject2) {
        return (jSONObject == null || jSONObject2 == null) ? jSONObject == jSONObject2 || (jSONObject != null && jSONObject.equals(jSONObject2)) : jSONObject.toString().equals(jSONObject2.toString());
    }

    /* renamed from: a */
    public static final void m354a(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$disableViewExposureDebugMode");
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() instanceof C0545x0) {
                Drawable drawable = imageView.getDrawable();
                if (drawable == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.bytedance.tobshadow.applog.exposure.DebugDrawable");
                }
                imageView.setImageDrawable(((C0545x0) drawable).f1252a);
            }
        }
        if (view.getBackground() instanceof C0545x0) {
            Drawable background = view.getBackground();
            if (background == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.bytedance.tobshadow.applog.exposure.DebugDrawable");
            }
            view.setBackground(((C0545x0) background).f1252a);
        }
    }

    /* renamed from: b */
    public static final void m371b(View view, boolean z) {
        Intrinsics.checkParameterIsNotNull(view, "$this$setViewExposureVisible");
        int i = z ? -65536 : -256;
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() instanceof C0545x0) {
                Drawable drawable = imageView.getDrawable();
                if (drawable != null) {
                    ((C0545x0) drawable).f1221b.setColor(i);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.bytedance.tobshadow.applog.exposure.DebugDrawable");
                }
            }
        }
        if (view.getBackground() instanceof C0545x0) {
            Drawable background = view.getBackground();
            if (background != null) {
                ((C0545x0) background).f1221b.setColor(i);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.bytedance.tobshadow.applog.exposure.DebugDrawable");
            }
        }
        view.invalidate();
    }

    /* renamed from: a */
    public static boolean m365a(boolean z, String str) {
        if (!z) {
            return false;
        }
        LoggerImpl.global().ast("[Assert failed] {}", null, str);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:204:0x0200, code lost:
    
        if (r0 >= 0) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x007f, code lost:
    
        if (r7 < 2999) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0094, code lost:
    
        r7 = "/CustomWindow";
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x008f, code lost:
    
        if (r7 == com.bytedance.tobshadow.bdtracker.C0403c6.f489d) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x05e0, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) == false) goto L240;
     */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x05ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0593  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0493p4 m345a(View view, boolean z) {
        String str;
        boolean z2;
        String str2;
        String str3;
        ArrayList arrayList;
        int m285a;
        String str4;
        String m663c;
        LinkedList linkedList;
        Object tag;
        String resourceEntryName;
        String str5;
        Object obj;
        int i;
        ArrayList arrayList2;
        boolean z3;
        String str6;
        StringBuilder append;
        String sb;
        char c;
        String str7;
        StringBuilder sb2;
        String m286a;
        View view2 = view;
        Activity m344a = m344a(view.getContext());
        if (m344a == null && C0395b6.m290a(view.getContext(), C0395b6.m285a(view))) {
            return null;
        }
        if (z && C0395b6.m292b(view)) {
            return null;
        }
        ArrayList arrayList3 = new ArrayList(8);
        arrayList3.add(view2);
        for (ViewParent parent = view.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            arrayList3.add((ViewGroup) parent);
        }
        int i2 = 1;
        int size = arrayList3.size() - 1;
        RecyclerView recyclerView = (View) arrayList3.get(size);
        C0403c6.m300a();
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        if (layoutParams instanceof WindowManager.LayoutParams) {
            int i3 = ((WindowManager.LayoutParams) layoutParams).type;
            if (i3 != 1) {
                if (i3 >= 99 || recyclerView.getClass() != C0403c6.f488c) {
                    if (i3 >= 1999 || recyclerView.getClass() != C0403c6.f489d) {
                    }
                    str = "/PopupWindow";
                    char c2 = 11018;
                    int i4 = 0;
                    if (!C0403c6.m301a(recyclerView) && !(recyclerView.getParent() instanceof View)) {
                        str = str + "/" + C0395b6.m287a(recyclerView.getClass());
                        m286a = C0395b6.m286a((View) recyclerView, false);
                        if (m286a != null) {
                            z2 = recyclerView.getTag(84159242) != null;
                            str = str + "#" + m286a;
                            if (recyclerView instanceof ViewGroup) {
                                String str8 = null;
                                ArrayList arrayList4 = null;
                                String str9 = str;
                                boolean z4 = z2;
                                String str10 = str9;
                                ViewGroup viewGroup = (ViewGroup) recyclerView;
                                int i5 = size - 1;
                                while (i5 >= 0) {
                                    View view3 = (View) arrayList3.get(i5);
                                    Object tag2 = view3.getTag(C0355R.id.applog_tag_view_name);
                                    if (tag2 != null) {
                                        str9 = str9 + "/" + tag2;
                                        arrayList2 = arrayList3;
                                        str10 = "/" + tag2;
                                        c = c2;
                                    } else {
                                        String m287a = C0395b6.m287a(view3.getClass());
                                        int indexOfChild = viewGroup.indexOfChild(view3);
                                        if (((C0445i5.f687i && (viewGroup instanceof ViewPager)) ? i2 : i4) != 0 || C0445i5.m479c(viewGroup)) {
                                            try {
                                                indexOfChild = ((Integer) view.getClass().getMethod("getCurrentItem", new Class[0]).invoke(view2, new Object[0])).intValue();
                                            } catch (Throwable unused) {
                                                indexOfChild = viewGroup.indexOfChild(view3);
                                            }
                                        } else if (viewGroup instanceof AdapterView) {
                                            indexOfChild = ((AdapterView) viewGroup).getFirstVisiblePosition() + indexOfChild;
                                        } else if (((C0445i5.m475a((Object) viewGroup) || C0445i5.m478b((Object) viewGroup) || (C0445i5.f679a && C0445i5.f680b.isAssignableFrom(viewGroup.getClass()))) ? i2 : i4) != 0) {
                                            if (C0445i5.m475a((Object) viewGroup)) {
                                                i = ((RecyclerView) viewGroup).getChildAdapterPosition(view3);
                                            } else if (C0445i5.m478b((Object) viewGroup)) {
                                                try {
                                                    try {
                                                        i = ((Integer) view3.getClass().getMethod("getChildAdapterPosition", new Class[i4]).invoke(view3, new Object[i4])).intValue();
                                                    } catch (Throwable unused2) {
                                                        i = ((Integer) view3.getClass().getMethod("getChildPosition", new Class[i4]).invoke(view3, new Object[i4])).intValue();
                                                    }
                                                } catch (Throwable unused3) {
                                                }
                                            } else {
                                                if (C0445i5.f679a) {
                                                    try {
                                                        if (viewGroup.getClass() == C0445i5.f680b) {
                                                            Method method = C0445i5.f681c;
                                                            try {
                                                                Object[] objArr = new Object[1];
                                                                objArr[i4] = view3;
                                                                i = ((Integer) method.invoke(viewGroup, objArr)).intValue();
                                                            } catch (Throwable th) {
                                                                th = th;
                                                                LoggerImpl.global().error("invokeCRVGetChildAdapterPositionMethod failed", th, new Object[i4]);
                                                                i = -1;
                                                            }
                                                        }
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                    }
                                                }
                                                i = -1;
                                            }
                                        }
                                        i = indexOfChild;
                                        if (viewGroup instanceof ExpandableListView) {
                                            ExpandableListView expandableListView = (ExpandableListView) viewGroup;
                                            long expandableListPosition = expandableListView.getExpandableListPosition(i);
                                            arrayList2 = arrayList3;
                                            if (ExpandableListView.getPackedPositionType(expandableListPosition) == 2) {
                                                if (i < expandableListView.getHeaderViewsCount()) {
                                                    str7 = "/ELH[";
                                                    str6 = str10 + "/ELH[" + i + "]/" + ((Object) m287a) + "[0]";
                                                    sb2 = new StringBuilder();
                                                } else {
                                                    i -= expandableListView.getCount() - expandableListView.getFooterViewsCount();
                                                    str7 = "/ELF[";
                                                    str6 = str10 + "/ELF[" + i + "]/" + ((Object) m287a) + "[0]";
                                                    sb2 = new StringBuilder();
                                                }
                                                sb = sb2.append(str9).append(str7).append(i).append("]/").append((Object) m287a).append("[0]").toString();
                                            } else {
                                                int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListPosition);
                                                int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListPosition);
                                                if (packedPositionChild != -1) {
                                                    ArrayList arrayList5 = arrayList4 == null ? new ArrayList(4) : arrayList4;
                                                    arrayList5.add(String.valueOf(packedPositionGroup));
                                                    arrayList5.add(String.valueOf(packedPositionChild));
                                                    str6 = str10 + "/ELVG[" + packedPositionGroup + "]/ELVC[" + packedPositionChild + "]/" + ((Object) m287a) + "[0]";
                                                    sb = str9 + "/ELVG[-]/ELVC[-]/" + ((Object) m287a) + "[0]";
                                                    arrayList4 = arrayList5;
                                                } else {
                                                    ArrayList arrayList6 = arrayList4 == null ? new ArrayList(4) : arrayList4;
                                                    arrayList6.add(String.valueOf(packedPositionGroup));
                                                    arrayList4 = arrayList6;
                                                    str6 = str10 + "/ELVG[" + packedPositionGroup + "]/" + ((Object) m287a) + "[0]";
                                                    sb = str9 + "/ELVG[-]/" + ((Object) m287a) + "[0]";
                                                }
                                            }
                                        } else {
                                            arrayList2 = arrayList3;
                                            if (!(viewGroup instanceof AdapterView) && !C0445i5.m475a((Object) viewGroup)) {
                                                if (!(C0445i5.f687i && (viewGroup instanceof ViewPager)) && !C0445i5.m478b((Object) viewGroup) && !C0445i5.m479c(viewGroup)) {
                                                    z3 = false;
                                                    if (!z3) {
                                                        Object tag3 = viewGroup.getTag(84159247);
                                                        if (tag3 instanceof List) {
                                                            List list = (List) tag3;
                                                            if (list.size() > 0) {
                                                                i %= list.size();
                                                                str8 = C0395b6.m288a((String) list.get(i));
                                                            }
                                                        }
                                                        ArrayList arrayList7 = arrayList4 == null ? new ArrayList(4) : arrayList4;
                                                        arrayList7.add(String.valueOf(i));
                                                        arrayList4 = arrayList7;
                                                        str6 = str10 + "/" + ((Object) m287a) + "[" + i + "]";
                                                        sb = str9 + "/" + ((Object) m287a) + "[-]";
                                                    } else {
                                                        if (!(C0445i5.f688j && (viewGroup instanceof SwipeRefreshLayout))) {
                                                            if (!(C0445i5.f685g && m360a((Object) viewGroup, "android.support.v4.widget.SwipeRefreshLayout"))) {
                                                                str6 = str10 + "/" + ((Object) m287a) + "[" + i + "]";
                                                                append = new StringBuilder().append(str9).append("/").append((Object) m287a).append("[").append(i).append("]");
                                                                sb = append.toString();
                                                            }
                                                        }
                                                        str6 = str10 + "/" + ((Object) m287a) + "[0]";
                                                        append = new StringBuilder().append(str9).append("/").append((Object) m287a).append("[0]");
                                                        sb = append.toString();
                                                    }
                                                }
                                            }
                                            z3 = true;
                                            if (!z3) {
                                            }
                                        }
                                        String m286a2 = C0395b6.m286a(view3, z4);
                                        c = 11018;
                                        if (m286a2 != null) {
                                            if (view3.getTag(84159242) != null) {
                                                z4 = true;
                                            }
                                            str6 = str6 + "#" + m286a2;
                                            sb = sb + "#" + m286a2;
                                        }
                                        str9 = sb;
                                        str10 = str6;
                                    }
                                    if (!(view3 instanceof ViewGroup)) {
                                        break;
                                    }
                                    viewGroup = (ViewGroup) view3;
                                    i5--;
                                    c2 = c;
                                    arrayList3 = arrayList2;
                                    i2 = 1;
                                    i4 = 0;
                                    view2 = view;
                                }
                                str2 = str9;
                                str3 = str8;
                                arrayList = arrayList4;
                            } else {
                                str2 = str;
                                str3 = null;
                                arrayList = null;
                            }
                            m285a = C0395b6.m285a(view);
                            if (C0395b6.m290a(view.getContext(), m285a)) {
                                if (!C0389b0.f460i.isEmpty()) {
                                    for (C0389b0.b bVar : C0389b0.f460i.values()) {
                                        if (bVar != null && bVar.f466b.get() != null) {
                                            obj = bVar.f466b.get();
                                            View m660a = C0515s5.m660a(obj);
                                            if ((m660a == null || m660a.findViewById(view.getId()) == null) ? false : true) {
                                                break;
                                            }
                                        }
                                    }
                                }
                                obj = null;
                                if (obj != null) {
                                    str4 = obj.getClass().getName();
                                    m663c = C0515s5.m663c(obj);
                                } else {
                                    if (m344a != null) {
                                        str4 = m344a.getClass().getName();
                                    } else {
                                        C0549x4 m279a = C0389b0.m279a();
                                        str4 = m279a != null ? m279a.f1243u : "";
                                    }
                                    m663c = C0515s5.m663c(m344a);
                                }
                            } else {
                                str4 = (!C0389b0.f459h.containsKey(Integer.valueOf(m285a)) || (linkedList = (LinkedList) C0389b0.f459h.get(Integer.valueOf(m285a))) == null || linkedList.isEmpty()) ? "" : ((C0549x4) linkedList.getLast()).f1243u;
                                m663c = C0515s5.m663c(m344a);
                            }
                            String str11 = str4;
                            String str12 = m663c;
                            int width = view.getWidth();
                            int height = view.getHeight();
                            tag = view.getTag(C0355R.id.applog_tag_view_id);
                            if (tag != null) {
                                resourceEntryName = (String) tag;
                            }
                            if (view.getId() != -1) {
                                try {
                                    resourceEntryName = view.getResources().getResourceEntryName(view.getId());
                                    str5 = resourceEntryName;
                                } catch (Resources.NotFoundException unused4) {
                                } catch (Throwable th3) {
                                    LoggerImpl.global().error(Collections.singletonList("WidgetUtils"), "Get view id failed", th3, new Object[0]);
                                }
                                return new C0493p4(str11, str12, str2, str5, m374c(view), width, height, width / 2, height / 2, C0395b6.m289a(view, str3), arrayList);
                            }
                            str5 = "";
                            return new C0493p4(str11, str12, str2, str5, m374c(view), width, height, width / 2, height / 2, C0395b6.m289a(view, str3), arrayList);
                        }
                    }
                    z2 = false;
                    if (recyclerView instanceof ViewGroup) {
                    }
                    m285a = C0395b6.m285a(view);
                    if (C0395b6.m290a(view.getContext(), m285a)) {
                    }
                    String str112 = str4;
                    String str122 = m663c;
                    int width2 = view.getWidth();
                    int height2 = view.getHeight();
                    tag = view.getTag(C0355R.id.applog_tag_view_id);
                    if (tag != null) {
                    }
                    if (view.getId() != -1) {
                    }
                    str5 = "";
                    return new C0493p4(str112, str122, str2, str5, m374c(view), width2, height2, width2 / 2, height2 / 2, C0395b6.m289a(view, str3), arrayList);
                }
                str = "/DialogWindow";
                char c22 = 11018;
                int i42 = 0;
                if (!C0403c6.m301a(recyclerView)) {
                    str = str + "/" + C0395b6.m287a(recyclerView.getClass());
                    m286a = C0395b6.m286a((View) recyclerView, false);
                    if (m286a != null) {
                    }
                }
                z2 = false;
                if (recyclerView instanceof ViewGroup) {
                }
                m285a = C0395b6.m285a(view);
                if (C0395b6.m290a(view.getContext(), m285a)) {
                }
                String str1122 = str4;
                String str1222 = m663c;
                int width22 = view.getWidth();
                int height22 = view.getHeight();
                tag = view.getTag(C0355R.id.applog_tag_view_id);
                if (tag != null) {
                }
                if (view.getId() != -1) {
                }
                str5 = "";
                return new C0493p4(str1122, str1222, str2, str5, m374c(view), width22, height22, width22 / 2, height22 / 2, C0395b6.m289a(view, str3), arrayList);
            }
            str = "/MainWindow";
            char c222 = 11018;
            int i422 = 0;
            if (!C0403c6.m301a(recyclerView)) {
            }
            z2 = false;
            if (recyclerView instanceof ViewGroup) {
            }
            m285a = C0395b6.m285a(view);
            if (C0395b6.m290a(view.getContext(), m285a)) {
            }
            String str11222 = str4;
            String str12222 = m663c;
            int width222 = view.getWidth();
            int height222 = view.getHeight();
            tag = view.getTag(C0355R.id.applog_tag_view_id);
            if (tag != null) {
            }
            if (view.getId() != -1) {
            }
            str5 = "";
            return new C0493p4(str11222, str12222, str2, str5, m374c(view), width222, height222, width222 / 2, height222 / 2, C0395b6.m289a(view, str3), arrayList);
        }
        Class<?> cls = recyclerView.getClass();
        if (cls != C0403c6.f488c) {
        }
        str = "/MainWindow";
        char c2222 = 11018;
        int i4222 = 0;
        if (!C0403c6.m301a(recyclerView)) {
        }
        z2 = false;
        if (recyclerView instanceof ViewGroup) {
        }
        m285a = C0395b6.m285a(view);
        if (C0395b6.m290a(view.getContext(), m285a)) {
        }
        String str112222 = str4;
        String str122222 = m663c;
        int width2222 = view.getWidth();
        int height2222 = view.getHeight();
        tag = view.getTag(C0355R.id.applog_tag_view_id);
        if (tag != null) {
        }
        if (view.getId() != -1) {
        }
        str5 = "";
        return new C0493p4(str112222, str122222, str2, str5, m374c(view), width2222, height2222, width2222 / 2, height2222 / 2, C0395b6.m289a(view, str3), arrayList);
    }

    /* renamed from: a */
    public static void m355a(InterfaceC0478n3 interfaceC0478n3, JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
    }
}
