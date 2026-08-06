package com.bytedance.push.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.utils.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ManifestUtils {
    private static List<ActivityInfo> sActivities;
    private static Bundle sMetadata;
    private static List<String> sPermissions;
    private static List<ProviderInfo> sProviders;
    private static List<ActivityInfo> sReceivers;
    private static List<ServiceInfo> sServices;

    private static List<String> getAllPermissions(Context context) throws PackageManager.NameNotFoundException {
        String[] strArr;
        if (sPermissions == null) {
            synchronized (ManifestUtils.class) {
                if (sPermissions == null && (strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions) != null) {
                    sPermissions = Arrays.asList(strArr);
                }
            }
        }
        return sPermissions;
    }

    public static boolean checkPermissions(Context context, String str, String str2, List<String> list) throws PackageManager.NameNotFoundException {
        List<String> allPermissions = getAllPermissions(context);
        if (allPermissions == null || allPermissions.isEmpty()) {
            PushSupporter.logger().mo247e(str, str2 + ".You need to declare permission(s) {" + list + "} in AndroidManifest.xml");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (String str3 : list) {
            if (!allPermissions.contains(str3)) {
                arrayList.add(str3);
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        PushSupporter.logger().mo247e(str, str2 + ".You need to declare permission(s) {" + arrayList + "} in AndroidManifest.xml");
        return false;
    }

    public static boolean checkMetadata(Context context, String str, String str2, List<String> list) throws PackageManager.NameNotFoundException {
        Bundle metadata = getMetadata(context);
        if ((metadata == null || metadata.isEmpty()) && !list.isEmpty()) {
            PushSupporter.logger().mo247e(str, str2 + " metadata is empty!!!");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (String str3 : list) {
            if (metadata == null || !metadata.containsKey(str3)) {
                arrayList.add(str3);
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        PushSupporter.logger().mo247e(str, str2 + ".You need to declare metadata {" + arrayList + "} in AndroidManifest.xml");
        return false;
    }

    private static Bundle getMetadata(Context context) throws PackageManager.NameNotFoundException {
        if (sMetadata == null) {
            synchronized (ManifestUtils.class) {
                if (sMetadata == null) {
                    sMetadata = context.getPackageManager().getPackageInfo(context.getPackageName(), 128).applicationInfo.metaData;
                }
            }
        }
        return sMetadata;
    }

    public static boolean checkService(Context context, String str, String str2, List<Component> list) throws PackageManager.NameNotFoundException {
        boolean z;
        if (list == null || list.isEmpty()) {
            return true;
        }
        List<ServiceInfo> services = getServices(context);
        if (services == null || services.size() == 0) {
            PushSupporter.logger().mo247e(str, str2 + ". You need to declare service(s) {" + list + "} in AndroidManifest.xml");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = true;
        for (Component component : list) {
            Iterator<ServiceInfo> it = services.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ServiceInfo next = it.next();
                if (TextUtils.equals(next.name, component.name)) {
                    boolean equals = TextUtils.equals(component.processName, next.processName);
                    boolean equals2 = !TextUtils.isEmpty(component.permission) ? TextUtils.equals(next.permission, component.permission) : true;
                    if (!equals) {
                        PushSupporter.logger().mo247e(str, str2 + " service configure error: " + component.name + " should be declared in process " + component.processName + ", but now in " + next.processName);
                        z2 = false;
                    }
                    if (!equals2) {
                        PushSupporter.logger().mo247e(str, str2 + " service configure error: " + component.name + " need permission(s) {" + component.permission + "}, but now " + next.permission);
                        z2 = false;
                    }
                    if (component.intentFilter != null) {
                        boolean z3 = true;
                        for (Component.IntentFilter intentFilter : component.intentFilter) {
                            if (intentFilter.actions != null) {
                                for (String str3 : intentFilter.actions) {
                                    if (!checkServiceFilter(context, component.name, intentFilter, str3)) {
                                        PushSupporter.logger().mo247e(str, str2 + component.name + " need to declare {" + str3 + "} action(s) in AndroidManifest.xml");
                                        z3 = false;
                                    }
                                }
                            }
                        }
                        if (!z3) {
                            z2 = false;
                        }
                    }
                    z = true;
                }
            }
            if (!z) {
                arrayList.add(component);
            }
        }
        if (!arrayList.isEmpty()) {
            PushSupporter.logger().mo247e(str, str2 + " need to declare service(s) {" + arrayList + "} in AndroidManifest.xml");
        }
        return z2 && arrayList.isEmpty();
    }

    private static List<ServiceInfo> getServices(Context context) throws PackageManager.NameNotFoundException {
        ServiceInfo[] serviceInfoArr;
        if (sServices == null) {
            synchronized (ManifestUtils.class) {
                if (sServices == null && (serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 516).services) != null) {
                    sServices = Arrays.asList(serviceInfoArr);
                }
            }
        }
        return sServices;
    }

    public static boolean checkReceiver(Context context, String str, String str2, List<Component> list) throws PackageManager.NameNotFoundException {
        boolean z;
        if (list == null || list.isEmpty()) {
            return true;
        }
        List<ActivityInfo> receivers = getReceivers(context);
        if (receivers == null || receivers.size() == 0) {
            PushSupporter.logger().mo247e(str, str2 + " error configuration:" + list);
            return false;
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = true;
        for (Component component : list) {
            Iterator<ActivityInfo> it = receivers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ActivityInfo next = it.next();
                if (TextUtils.equals(next.name, component.name)) {
                    if (!TextUtils.equals(component.processName, next.processName)) {
                        PushSupporter.logger().mo247e(str, str2 + " receiver configure error: " + component.name + " should be in" + component.processName + ",but now in " + next.processName + " process");
                        z2 = false;
                    }
                    if (!(!TextUtils.isEmpty(component.permission) ? TextUtils.equals(next.permission, component.permission) : true)) {
                        PushSupporter.logger().mo247e(str, str2 + " receiver configure error: " + component.name + " need permission " + component.permission + ", but now the permission is:" + next.permission);
                        z2 = false;
                    }
                    if (component.intentFilter != null) {
                        boolean z3 = true;
                        for (Component.IntentFilter intentFilter : component.intentFilter) {
                            if (intentFilter.actions != null) {
                                for (String str3 : intentFilter.actions) {
                                    if (!checkReceiverFilter(context, component.name, intentFilter, str3)) {
                                        PushSupporter.logger().mo247e(str, str2 + " " + component.name + " configure error，need action : " + str3);
                                        z3 = false;
                                    }
                                }
                            }
                        }
                        if (!z3) {
                            z2 = false;
                        }
                    }
                    z = true;
                }
            }
            if (!z) {
                arrayList.add(component);
            }
        }
        if (!arrayList.isEmpty()) {
            PushSupporter.logger().mo247e(str, str2 + " receiver configure error: " + arrayList);
        }
        return z2 && arrayList.isEmpty();
    }

    private static List<ActivityInfo> getReceivers(Context context) throws PackageManager.NameNotFoundException {
        ActivityInfo[] activityInfoArr;
        if (sReceivers == null) {
            synchronized (ManifestUtils.class) {
                if (sReceivers == null && (activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 514).receivers) != null) {
                    sReceivers = Arrays.asList(activityInfoArr);
                }
            }
        }
        return sReceivers;
    }

    private static boolean checkReceiverFilter(Context context, String str, Component.IntentFilter intentFilter, String str2) {
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        if (intentFilter.categories != null) {
            Iterator<String> it = intentFilter.categories.iterator();
            while (it.hasNext()) {
                intent.addCategory(it.next());
            }
        }
        intent.setAction(str2);
        if (intentFilter.data != null) {
            if (!TextUtils.isEmpty(intentFilter.mimeType)) {
                intent.setDataAndType(intentFilter.data, intentFilter.mimeType);
            } else {
                intent.setData(intentFilter.data);
            }
        } else if (!TextUtils.isEmpty(intentFilter.mimeType)) {
            intent.setType(intentFilter.mimeType);
        }
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 576);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            return false;
        }
        for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
            if (resolveInfo.activityInfo != null && TextUtils.equals(resolveInfo.activityInfo.name, str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkServiceFilter(Context context, String str, Component.IntentFilter intentFilter, String str2) {
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        if (intentFilter.categories != null) {
            Iterator<String> it = intentFilter.categories.iterator();
            while (it.hasNext()) {
                intent.addCategory(it.next());
            }
        }
        intent.setAction(str2);
        if (intentFilter.data != null) {
            intent.setData(intentFilter.data);
        }
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            return false;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            if (resolveInfo.serviceInfo != null && (TextUtils.isEmpty(str) || TextUtils.equals(resolveInfo.serviceInfo.name, str))) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkActivityFilter(Context context, String str, Component.IntentFilter intentFilter, String str2) {
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        if (intentFilter.categories != null) {
            Iterator<String> it = intentFilter.categories.iterator();
            while (it.hasNext()) {
                intent.addCategory(it.next());
            }
        }
        intent.setAction(str2);
        if (intentFilter.data != null) {
            intent.setData(intentFilter.data);
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 576);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return false;
        }
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            if (resolveInfo.activityInfo != null && TextUtils.equals(resolveInfo.activityInfo.name, str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkActivities(Context context, String str, String str2, List<Component> list) throws PackageManager.NameNotFoundException {
        boolean z;
        if (list == null || list.isEmpty()) {
            return true;
        }
        List<ActivityInfo> activities = getActivities(context);
        if (activities == null || activities.size() == 0) {
            PushSupporter.logger().mo247e(str, str2 + ". You need to declare activity(s) {" + list + "} in AndroidManifest.xml");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = true;
        for (Component component : list) {
            Iterator<ActivityInfo> it = activities.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ActivityInfo next = it.next();
                if (TextUtils.equals(next.name, component.name)) {
                    if (!TextUtils.equals(component.processName, next.processName)) {
                        PushSupporter.logger().mo247e(str, str2 + component.name + " should be declared in process " + component.processName + ", but now in process " + next.processName);
                        z2 = false;
                    }
                    if (!(!TextUtils.isEmpty(component.permission) ? TextUtils.equals(next.permission, component.permission) : true)) {
                        PushSupporter.logger().mo247e(str, str2 + component.name + " need permission(s) {" + component.permission + "}, but now is " + next.permission);
                        z2 = false;
                    }
                    if (component.intentFilter != null) {
                        boolean z3 = true;
                        for (Component.IntentFilter intentFilter : component.intentFilter) {
                            if (intentFilter.actions != null) {
                                for (String str3 : intentFilter.actions) {
                                    if (!checkActivityFilter(context, component.name, intentFilter, str3)) {
                                        PushSupporter.logger().mo247e(str, str2 + " " + component.name + " need action " + str3);
                                        z3 = false;
                                    }
                                }
                            }
                        }
                        if (!z3) {
                            z2 = false;
                        }
                    }
                    z = true;
                }
            }
            if (!z) {
                arrayList.add(component);
            }
        }
        if (!arrayList.isEmpty()) {
            PushSupporter.logger().mo247e(str, str2 + ".You should declare activities {" + arrayList + "} in AndroidManifest.xml");
        }
        return z2 && arrayList.isEmpty();
    }

    private static List<ActivityInfo> getActivities(Context context) throws PackageManager.NameNotFoundException {
        ActivityInfo[] activityInfoArr;
        if (sActivities == null) {
            synchronized (ManifestUtils.class) {
                if (sActivities == null && (activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 513).activities) != null) {
                    sActivities = Arrays.asList(activityInfoArr);
                }
            }
        }
        return sActivities;
    }

    public static boolean checkContentProviders(Context context, String str, String str2, List<Component> list) throws PackageManager.NameNotFoundException {
        boolean z;
        if (list == null || list.isEmpty()) {
            return true;
        }
        List<ProviderInfo> providers = getProviders(context);
        if (providers == null || providers.size() == 0) {
            PushSupporter.logger().mo247e(str, str2 + " need to declare ContentProvider(s) " + list);
            return false;
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = true;
        for (Component component : list) {
            Iterator<ProviderInfo> it = providers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ProviderInfo next = it.next();
                if (TextUtils.equals(next.name, component.name)) {
                    if (!TextUtils.equals(component.processName, next.processName)) {
                        PushSupporter.logger().mo247e(str, str2 + component.name + " should be declared in process " + component.processName + ", but now is " + next.processName);
                        z2 = false;
                    }
                    if (!TextUtils.isEmpty(component.authorities) ? TextUtils.equals(next.authority, component.authorities) : true) {
                        z = true;
                    } else {
                        PushSupporter.logger().mo247e(str, str2 + component.name + " need permission(s) {" + component.authorities + "}, but now is" + next.authority);
                        z = true;
                        z2 = false;
                    }
                }
            }
            if (!z) {
                arrayList.add(component);
            }
        }
        if (!arrayList.isEmpty()) {
            PushSupporter.logger().mo247e(str, str2 + " .You should declare activities {" + arrayList + "} in AndroidManifest.xml");
        }
        return z2 && arrayList.isEmpty();
    }

    private static List<ProviderInfo> getProviders(Context context) throws PackageManager.NameNotFoundException {
        ProviderInfo[] providerInfoArr;
        if (sProviders == null) {
            synchronized (ManifestUtils.class) {
                if (sProviders == null && (providerInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 520).providers) != null) {
                    sProviders = Arrays.asList(providerInfoArr);
                }
            }
        }
        return sProviders;
    }
}
