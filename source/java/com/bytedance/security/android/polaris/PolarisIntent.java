package com.bytedance.security.android.polaris;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PolarisIntent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J$\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0007J*\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/security/android/polaris/PolarisIntent;", "", "()V", "IMMUTABLE_FLAGS", "", "blockActions", "", "", "getTargetsUid", "intent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "isActionSecure", "", "isExternalTargetSecure", "isFlagsSecure", "isInternalTargetSecure", "allowedClass", "Ljava/lang/Class;", "allowedClassList", "polaris_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PolarisIntent {
    private static final int IMMUTABLE_FLAGS = 195;
    public static final PolarisIntent INSTANCE = new PolarisIntent();
    private static final List<String> blockActions = CollectionsKt.listOf(new String[]{"android.intent.action.CHOOSER", "android.intent.action.SEND", "android.intent.action.SEND_MULTIPLE", "android.media.action.IMAGE_CAPTURE", "android.media.action.IMAGE_CAPTURE_SECURE", "android.media.action.VIDEO_CAPTURE"});

    private PolarisIntent() {
    }

    private final boolean isFlagsSecure(Intent intent) {
        return (intent.getFlags() & IMMUTABLE_FLAGS) == 0;
    }

    private final boolean isActionSecure(Intent intent) {
        return !CollectionsKt.contains(blockActions, intent.getAction());
    }

    private final List<Integer> getTargetsUid(Intent intent, Context context) {
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        Intrinsics.checkExpressionValueIsNotNull(queryIntentActivities, "context.packageManager.q…tentActivities(intent, 0)");
        Iterator<T> it = queryIntentActivities.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((ResolveInfo) it.next()).activityInfo.applicationInfo.uid));
        }
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        Intrinsics.checkExpressionValueIsNotNull(queryIntentServices, "context.packageManager.q…IntentServices(intent, 0)");
        Iterator<T> it2 = queryIntentServices.iterator();
        while (it2.hasNext()) {
            arrayList.add(Integer.valueOf(((ResolveInfo) it2.next()).serviceInfo.applicationInfo.uid));
        }
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        Intrinsics.checkExpressionValueIsNotNull(queryBroadcastReceivers, "context.packageManager.q…dcastReceivers(intent, 0)");
        Iterator<T> it3 = queryBroadcastReceivers.iterator();
        while (it3.hasNext()) {
            arrayList.add(Integer.valueOf(((ResolveInfo) it3.next()).activityInfo.applicationInfo.uid));
        }
        return CollectionsKt.distinct(arrayList);
    }

    @JvmStatic
    public static final boolean isInternalTargetSecure(Intent intent, Context context, List<? extends Class<?>> allowedClassList) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(allowedClassList, "allowedClassList");
        ComponentName component = intent.getComponent();
        boolean z2 = false;
        if (component == null) {
            return false;
        }
        Intrinsics.checkExpressionValueIsNotNull(component, "intent.component ?: return false");
        List<? extends Class<?>> list = allowedClassList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Class) it.next()).getName());
        }
        ArrayList arrayList2 = arrayList;
        if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                if (Intrinsics.areEqual((String) it2.next(), component.getClassName())) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        List<Integer> targetsUid = INSTANCE.getTargetsUid(intent, context);
        if (!(targetsUid instanceof Collection) || !targetsUid.isEmpty()) {
            Iterator<T> it3 = targetsUid.iterator();
            while (it3.hasNext()) {
                if (!(((Number) it3.next()).intValue() == context.getApplicationInfo().uid)) {
                    break;
                }
            }
        }
        z2 = true;
        return z2 & z;
    }

    @JvmStatic
    public static final boolean isInternalTargetSecure(Intent intent, Context context, Class<?> allowedClass) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(allowedClass, "allowedClass");
        ComponentName component = intent.getComponent();
        boolean z = false;
        if (component == null) {
            return false;
        }
        Intrinsics.checkExpressionValueIsNotNull(component, "intent.component ?: return false");
        boolean areEqual = Intrinsics.areEqual(allowedClass.getName(), component.getClassName());
        List<Integer> targetsUid = INSTANCE.getTargetsUid(intent, context);
        if (!(targetsUid instanceof Collection) || !targetsUid.isEmpty()) {
            Iterator<T> it = targetsUid.iterator();
            while (it.hasNext()) {
                if (!(((Number) it.next()).intValue() == context.getApplicationInfo().uid)) {
                    break;
                }
            }
        }
        z = true;
        return z & areEqual;
    }

    @JvmStatic
    public static final boolean isExternalTargetSecure(Intent intent, Context context) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        Intrinsics.checkParameterIsNotNull(context, "context");
        List<Integer> targetsUid = INSTANCE.getTargetsUid(intent, context);
        boolean z = true;
        if (!(targetsUid instanceof Collection) || !targetsUid.isEmpty()) {
            Iterator<T> it = targetsUid.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((Number) it.next()).intValue() == context.getApplicationInfo().uid) {
                    z = false;
                    break;
                }
            }
        }
        PolarisIntent polarisIntent = INSTANCE;
        return polarisIntent.isActionSecure(intent) & polarisIntent.isFlagsSecure(intent) & z;
    }
}
