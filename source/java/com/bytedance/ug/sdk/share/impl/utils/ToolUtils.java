package com.bytedance.ug.sdk.share.impl.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ToolUtils {
    public static boolean isInstalledAppByIntent(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities;
        return (intent == null || (queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, ArtifactRepository.IO_CHUNK_SIZE)) == null || queryIntentActivities.size() <= 0) ? false : true;
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException
        	at java.base/java.util.BitSet.or(BitSet.java:941)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:759)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:838)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:711)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static boolean isInstalledApp(java.lang.String r3) {
        /*
            com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager r0 = com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager.getInstance()
            android.content.Context r0 = r0.getAppContext()
            r1 = 0
            if (r0 == 0) goto L23
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 == 0) goto L12
            goto L23
        L12:
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Exception -> L23
            android.content.pm.PackageInfo r3 = r0.getPackageInfo(r3, r1)     // Catch: java.lang.Exception -> L23
            if (r3 == 0) goto L23
            android.content.pm.ApplicationInfo r3 = r3.applicationInfo     // Catch: java.lang.Exception -> L23
            boolean r3 = r3.enabled     // Catch: java.lang.Exception -> L23
            if (r3 == 0) goto L23
            r1 = 1
        L23:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.ug.sdk.share.impl.utils.ToolUtils.isInstalledApp(java.lang.String):boolean");
    }

    public static Intent getLaunchIntentForPackage(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        if (!(context instanceof Activity)) {
            launchIntentForPackage.addFlags(268435456);
        }
        return launchIntentForPackage;
    }

    public static synchronized String getAppName(Context context) {
        String string;
        synchronized (ToolUtils.class) {
            try {
                string = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return string;
    }

    public static boolean tryStartIntent(Context context, Intent intent) {
        if (context != null && context.getPackageManager().resolveActivity(intent, 0) != null) {
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
