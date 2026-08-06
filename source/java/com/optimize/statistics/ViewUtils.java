package com.optimize.statistics;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ViewUtils {
    private static final int LIMIT_CONTENT = 20;
    private static final int TAG_BANNERS = 84159247;
    private static Set<Integer> mBlackListId;
    private static SparseArray<String> mIdMap;
    private static LruCache<Class, String> sClassNameCache = new LruCache<>(100);

    private static String encryptContent(String str) {
        return str;
    }

    private static int getResourcePackageId(int i) {
        return (i >>> 24) & 255;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x034f A[LOOP:1: B:23:0x0099->B:37:0x034f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x035a A[EDGE_INSN: B:38:0x035a->B:76:0x035a BREAK  A[LOOP:1: B:23:0x0099->B:37:0x034f], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getViewInfo(View view) {
        Activity findActivity;
        int childAdapterPositionInRecyclerView;
        ArrayList arrayList;
        String str;
        String str2;
        ArrayList arrayList2 = null;
        if (view == null || (findActivity = findActivity(view.getContext())) == null) {
            return null;
        }
        ArrayList arrayList3 = new ArrayList(8);
        arrayList3.add(view);
        for (ViewParent parent = view.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            arrayList3.add((ViewGroup) parent);
        }
        int size = arrayList3.size() - 1;
        ViewPager viewPager = (View) arrayList3.get(size);
        WindowHelper.init();
        String subWindowPrefix = WindowHelper.getSubWindowPrefix(viewPager);
        if (!WindowHelper.isDecorView(viewPager) && !(viewPager.getParent() instanceof View)) {
            subWindowPrefix = subWindowPrefix + "/" + getSimpleClassName(viewPager.getClass());
            String idName = getIdName(viewPager, false);
            if (idName != null) {
                subWindowPrefix = subWindowPrefix + "#" + idName;
            }
        }
        if (viewPager instanceof ViewGroup) {
            ViewPager viewPager2 = (ViewGroup) viewPager;
            int i = size - 1;
            String str3 = subWindowPrefix;
            while (i >= 0) {
                ViewPager viewPager3 = (View) arrayList3.get(i);
                String simpleClassName = getSimpleClassName(viewPager3.getClass());
                int indexOfChild = viewPager2.indexOfChild(viewPager3);
                if (ClassHelper.instanceOfAndroidXViewPager(viewPager2)) {
                    indexOfChild = viewPager2.getCurrentItem();
                } else if (ClassHelper.instanceOfSupportViewPager(viewPager2)) {
                    indexOfChild = viewPager2.getCurrentItem();
                } else if (viewPager2 instanceof AdapterView) {
                    indexOfChild += ((AdapterView) viewPager2).getFirstVisiblePosition();
                } else if (ClassHelper.instanceOfRecyclerView(viewPager2) && (childAdapterPositionInRecyclerView = getChildAdapterPositionInRecyclerView(viewPager3, viewPager2)) >= 0) {
                    indexOfChild = childAdapterPositionInRecyclerView;
                }
                if (viewPager2 instanceof ExpandableListView) {
                    ExpandableListView expandableListView = (ExpandableListView) viewPager2;
                    long expandableListPosition = expandableListView.getExpandableListPosition(indexOfChild);
                    arrayList = arrayList3;
                    if (ExpandableListView.getPackedPositionType(expandableListPosition) == 2) {
                        if (indexOfChild < expandableListView.getHeaderViewsCount()) {
                            str = subWindowPrefix + "/ELH[" + indexOfChild + "]/" + ((Object) simpleClassName) + "[0]";
                            str2 = str3 + "/ELH[" + indexOfChild + "]/" + ((Object) simpleClassName) + "[0]";
                        } else {
                            int count = indexOfChild - (expandableListView.getCount() - expandableListView.getFooterViewsCount());
                            str = subWindowPrefix + "/ELF[" + count + "]/" + ((Object) simpleClassName) + "[0]";
                            str2 = str3 + "/ELF[" + count + "]/" + ((Object) simpleClassName) + "[0]";
                        }
                    } else {
                        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListPosition);
                        int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListPosition);
                        if (packedPositionChild != -1) {
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList(4);
                            }
                            arrayList2.add(String.valueOf(packedPositionGroup));
                            arrayList2.add(String.valueOf(packedPositionChild));
                            str = subWindowPrefix + "/ELVG[" + packedPositionGroup + "]/ELVC[" + packedPositionChild + "]/" + ((Object) simpleClassName) + "[0]";
                            str2 = str3 + "/ELVG[-]/ELVC[-]/" + ((Object) simpleClassName) + "[0]";
                        } else {
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList(4);
                            }
                            arrayList2.add(String.valueOf(packedPositionGroup));
                            str = subWindowPrefix + "/ELVG[" + packedPositionGroup + "]/" + ((Object) simpleClassName) + "[0]";
                            str2 = str3 + "/ELVG[-]/" + ((Object) simpleClassName) + "[0]";
                        }
                    }
                } else {
                    arrayList = arrayList3;
                    if (isListView(viewPager2)) {
                        Object tag = viewPager2.getTag(TAG_BANNERS);
                        if (tag instanceof List) {
                            List list = (List) tag;
                            if (list.size() > 0) {
                                indexOfChild = calcBannerItemPosition(list, indexOfChild);
                                truncateContent((String) list.get(indexOfChild));
                            }
                        }
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList(4);
                        }
                        arrayList2.add(String.valueOf(indexOfChild));
                        str3 = str3 + "/" + ((Object) simpleClassName) + "[-]";
                        subWindowPrefix = subWindowPrefix + "/" + ((Object) simpleClassName) + "[" + indexOfChild + "]";
                        if (viewPager3 instanceof ViewGroup) {
                            break;
                        }
                        viewPager2 = (ViewGroup) viewPager3;
                        i--;
                        arrayList3 = arrayList;
                    } else if (!ClassHelper.instanceofAndroidXSwipeRefreshLayout(viewPager2) && !ClassHelper.instanceOfSupportSwipeRefreshLayout(viewPager2)) {
                        str = subWindowPrefix + "/" + ((Object) simpleClassName) + "[" + indexOfChild + "]";
                        str2 = str3 + "/" + ((Object) simpleClassName) + "[" + indexOfChild + "]";
                    } else {
                        str = subWindowPrefix + "/" + ((Object) simpleClassName) + "[0]";
                        str2 = str3 + "/" + ((Object) simpleClassName) + "[0]";
                    }
                }
                subWindowPrefix = str;
                str3 = str2;
                if (viewPager3 instanceof ViewGroup) {
                }
            }
        }
        String simpleName = findActivity.getClass().getSimpleName();
        return simpleName + "/" + subWindowPrefix + "[" + getIdStringQuietly(simpleName, view.getContext().getResources(), view.getId()) + "]";
    }

    static boolean isListView(View view) {
        return (view instanceof AdapterView) || ClassHelper.instanceOfAndroidXRecyclerView(view) || ClassHelper.instanceOfAndroidXViewPager(view) || ClassHelper.instanceOfSupportRecyclerView(view) || ClassHelper.instanceOfSupportViewPager(view);
    }

    private static Activity findActivity(Context context) {
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        do {
            ContextWrapper contextWrapper = (ContextWrapper) context;
            if (!(contextWrapper instanceof Activity)) {
                context = contextWrapper.getBaseContext();
            } else {
                return (Activity) contextWrapper;
            }
        } while (context instanceof ContextWrapper);
        return null;
    }

    static String getSimpleClassName(Class cls) {
        String str = sClassNameCache.get(cls);
        if (TextUtils.isEmpty(str)) {
            str = cls.getSimpleName();
            if (TextUtils.isEmpty(str)) {
                str = "Anonymous";
            }
            sClassNameCache.put(cls, str);
        }
        return str;
    }

    static String getIdName(View view, boolean z) {
        if (z) {
            return null;
        }
        if (mIdMap == null) {
            mIdMap = new SparseArray<>();
        }
        if (mBlackListId == null) {
            mBlackListId = new HashSet();
        }
        int id = view.getId();
        if (id > 2130706432 && !mBlackListId.contains(Integer.valueOf(id))) {
            String str = mIdMap.get(id);
            if (str != null) {
                return str;
            }
            try {
                String resourceEntryName = view.getResources().getResourceEntryName(id);
                mIdMap.put(id, resourceEntryName);
                return resourceEntryName;
            } catch (Exception unused) {
                mBlackListId.add(Integer.valueOf(id));
            }
        }
        return null;
    }

    private static int getChildAdapterPositionInRecyclerView(View view, ViewGroup viewGroup) {
        if (ClassHelper.instanceOfAndroidXRecyclerView(viewGroup)) {
            return ((RecyclerView) viewGroup).getChildAdapterPosition(view);
        }
        if (ClassHelper.instanceOfSupportRecyclerView(viewGroup)) {
            try {
                return ((RecyclerView) viewGroup).getChildAdapterPosition(view);
            } catch (Throwable unused) {
                return ((RecyclerView) viewGroup).getChildPosition(view);
            }
        }
        if (ClassHelper.sHasCustomRecyclerView) {
            return ClassHelper.invokeCRVGetChildAdapterPositionMethod(viewGroup, view);
        }
        return -1;
    }

    static int calcBannerItemPosition(List list, int i) {
        return i % list.size();
    }

    static String truncateContent(String str) {
        if (str == null) {
            return "";
        }
        if (!TextUtils.isEmpty(str) && str.length() > 20) {
            str = str.substring(0, 20);
        }
        return encryptContent(str);
    }

    public static String getIdStringQuietly(Object obj, Resources resources, int i) {
        try {
            return getIdString(resources, i);
        } catch (Resources.NotFoundException unused) {
            String fallbackIdString = getFallbackIdString(i);
            Log.w("ViewUtils", "Unknown identifier encountered on " + obj + ": " + fallbackIdString);
            return fallbackIdString;
        }
    }

    public static String getIdString(Resources resources, int i) throws Resources.NotFoundException {
        String str;
        String str2;
        if (resources == null) {
            return getFallbackIdString(i);
        }
        if (getResourcePackageId(i) != 127) {
            str = resources.getResourcePackageName(i);
            str2 = Constants.COLON_SEPARATOR;
        } else {
            str = "";
            str2 = "";
        }
        String resourceTypeName = resources.getResourceTypeName(i);
        String resourceEntryName = resources.getResourceEntryName(i);
        StringBuilder sb = new StringBuilder(str.length() + 1 + str2.length() + resourceTypeName.length() + 1 + resourceEntryName.length());
        sb.append("@");
        sb.append(str);
        sb.append(str2);
        sb.append(resourceTypeName);
        sb.append("/");
        sb.append(resourceEntryName);
        return sb.toString();
    }

    private static String getFallbackIdString(int i) {
        return "#" + Integer.toHexString(i);
    }
}
