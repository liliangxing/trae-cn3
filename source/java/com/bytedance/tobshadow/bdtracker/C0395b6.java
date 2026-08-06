package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.SparseArray;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.bytedance.tobshadow.applog.C0355R;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bytedance.tobshadow.bdtracker.b6 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0395b6 {

    /* renamed from: a */
    public static final SparseArray<String> f473a = new SparseArray<>(4);

    /* renamed from: b */
    public static final Set<Integer> f474b = new HashSet(4);

    /* renamed from: c */
    public static final LruCache<Class, String> f475c = new LruCache<>(100);

    /* renamed from: a */
    public static int m285a(View view) {
        Display display;
        if (view == null || (display = view.getDisplay()) == null) {
            return 0;
        }
        return display.getDisplayId();
    }

    /* renamed from: a */
    public static String m286a(View view, boolean z) {
        int id;
        Object tag = view.getTag(84159242);
        if (tag != null && (tag instanceof String)) {
            return (String) tag;
        }
        if (!z && (id = view.getId()) > 2130706432 && !f474b.contains(Integer.valueOf(id))) {
            SparseArray<String> sparseArray = f473a;
            String str = sparseArray.get(id);
            if (str != null) {
                return str;
            }
            try {
                String resourceEntryName = view.getResources().getResourceEntryName(id);
                sparseArray.put(id, resourceEntryName);
                return resourceEntryName;
            } catch (Exception unused) {
                f474b.add(Integer.valueOf(id));
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m287a(Class cls) {
        LruCache<Class, String> lruCache = f475c;
        String str = lruCache.get(cls);
        if (TextUtils.isEmpty(str)) {
            str = cls.getSimpleName();
            if (TextUtils.isEmpty(str)) {
                str = "Anonymous";
            }
            lruCache.put(cls, str);
            if (!C0445i5.f686h && !C0445i5.f683e && !C0445i5.f679a && str.contains("RecyclerView")) {
                try {
                    if (C0445i5.m473a((Class<?>) cls) != null && C0445i5.f681c != null) {
                        C0445i5.f680b = cls;
                        C0445i5.f679a = true;
                    }
                } catch (Exception e) {
                    LoggerImpl.global().error("checkCustomRecyclerView failed", e, new Object[0]);
                }
            }
        }
        return str;
    }

    /* renamed from: a */
    public static String m288a(String str) {
        return str == null ? "" : (TextUtils.isEmpty(str) || str.length() <= 20) ? str : str.substring(0, 20);
    }

    /* renamed from: a */
    public static boolean m290a(Context context, int i) {
        try {
            return ((DisplayManager) context.getSystemService("display")).getDisplays()[0].getDisplayId() == i;
        } catch (Exception unused) {
            return true;
        }
    }

    /* renamed from: b */
    public static boolean m292b(View view) {
        return view == null || view.getTag(C0355R.id.applog_tag_ignore) != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ca, code lost:
    
        if (r0.getText() != null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x010d, code lost:
    
        r0 = r0.getText();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x010b, code lost:
    
        if (r0.getText() != null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0133, code lost:
    
        if (r0 != null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0143, code lost:
    
        if (r0 != null) goto L84;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<String> m289a(View view, String str) {
        String url;
        TextView textView;
        CharSequence text;
        Object tag = view.getTag(84159244);
        ArrayList<String> arrayList = null;
        if (tag != null) {
            url = String.valueOf(tag);
        } else {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                ArrayList<String> arrayList2 = new ArrayList<>(childCount);
                for (int i = 0; i < childCount && viewGroup.getChildAt(i).getVisibility() == 0; i++) {
                    arrayList2.addAll(m289a(viewGroup.getChildAt(i), (String) null));
                }
                url = null;
                arrayList = arrayList2;
            } else if (view instanceof EditText) {
                if (view.getTag(84159251) != null) {
                    EditText editText = (EditText) view;
                    int inputType = editText.getInputType() & 4095;
                    if (!(inputType == 129 || inputType == 225 || inputType == 18 || inputType == 145)) {
                        try {
                            Field declaredField = TextView.class.getDeclaredField("mText");
                            declaredField.setAccessible(true);
                            text = (CharSequence) declaredField.get(editText);
                        } catch (Throwable th) {
                            LoggerImpl.global().error(Collections.singletonList("ViewUtils"), "getEditTextText failed", th, new Object[0]);
                            text = null;
                        }
                        if (text == null) {
                            url = "";
                        }
                        url = text.toString();
                    }
                }
                url = null;
            } else if (view instanceof RatingBar) {
                url = String.valueOf(((RatingBar) view).getRating());
            } else if (view instanceof Spinner) {
                Spinner spinner = (Spinner) view;
                Object selectedItem = spinner.getSelectedItem();
                if (selectedItem instanceof String) {
                    url = (String) selectedItem;
                } else {
                    View selectedView = spinner.getSelectedView();
                    if (selectedView instanceof TextView) {
                        textView = (TextView) selectedView;
                    }
                    url = null;
                }
            } else if (view instanceof SeekBar) {
                url = String.valueOf(((SeekBar) view).getProgress());
            } else {
                if (view instanceof RadioGroup) {
                    RadioGroup radioGroup = (RadioGroup) view;
                    View findViewById = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
                    if (findViewById != null && (findViewById instanceof RadioButton)) {
                        RadioButton radioButton = (RadioButton) findViewById;
                        if (radioButton.getText() != null) {
                            text = radioButton.getText();
                            url = text.toString();
                        }
                    }
                } else if (view instanceof TextView) {
                    textView = (TextView) view;
                } else if (!(view instanceof ImageView)) {
                    if (view instanceof WebView) {
                        WebView webView = (WebView) view;
                        if (!m291a(webView)) {
                            url = webView.getUrl();
                        }
                    }
                    if (C0445i5.m477b(view)) {
                        url = ((com.tencent.smtt.sdk.WebView) view).getUrl();
                    }
                } else if (!TextUtils.isEmpty(str)) {
                    url = str;
                }
                url = null;
            }
        }
        if (arrayList == null) {
            if (TextUtils.isEmpty(url)) {
                if (str == null) {
                    str = view.getContentDescription() != null ? view.getContentDescription().toString() : url;
                }
                url = m288a(str);
            }
            arrayList = new ArrayList<>(1);
            if (!TextUtils.isEmpty(url)) {
                arrayList.add(url);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m291a(WebView webView) {
        Object obj;
        try {
            Field declaredField = WebView.class.getDeclaredField("mProvider");
            declaredField.setAccessible(true);
            obj = declaredField.get(webView);
        } catch (Exception e) {
            LoggerImpl.global().error(Collections.singletonList("ViewUtils"), "Check isDestroyed failed", e, new Object[0]);
        }
        if ("android.webkit.WebViewClassic".equals(obj)) {
            Field declaredField2 = obj.getClass().getDeclaredField("mWebViewCore");
            declaredField2.setAccessible(true);
            return declaredField2.get(obj) == null;
        }
        Field declaredField3 = obj.getClass().getDeclaredField("mAwContents");
        declaredField3.setAccessible(true);
        Object obj2 = declaredField3.get(obj);
        Method declaredMethod = obj2.getClass().getDeclaredMethod("isDestroyed", Integer.TYPE);
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(obj2, 0);
        if (invoke instanceof Boolean) {
            return ((Boolean) invoke).booleanValue();
        }
        return false;
    }
}
