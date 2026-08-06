package com.huawei.hms.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Pair;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.device.C1072a;
import com.huawei.hms.framework.common.BundleUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HMSPackageManager {

    /* renamed from: o */
    private static HMSPackageManager f1889o;

    /* renamed from: p */
    private static final Object f1890p = new Object();

    /* renamed from: q */
    private static final Object f1891q = new Object();

    /* renamed from: r */
    private static final Object f1892r = new Object();

    /* renamed from: s */
    private static final Map<String, String> f1893s;

    /* renamed from: a */
    private final Context f1894a;

    /* renamed from: b */
    private final PackageManagerHelper f1895b;

    /* renamed from: c */
    private String f1896c;

    /* renamed from: d */
    private String f1897d;

    /* renamed from: e */
    private int f1898e;

    /* renamed from: f */
    private String f1899f;

    /* renamed from: g */
    private String f1900g;

    /* renamed from: h */
    private String f1901h;

    /* renamed from: i */
    private String f1902i;

    /* renamed from: j */
    private int f1903j;

    /* renamed from: k */
    private int f1904k;

    /* renamed from: l */
    private long f1905l;

    /* renamed from: m */
    private boolean f1906m;

    /* renamed from: n */
    private int f1907n;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class PackagePriorityInfo implements Comparable<PackagePriorityInfo> {

        /* renamed from: a */
        private String f1908a;

        /* renamed from: b */
        private String f1909b;

        /* renamed from: c */
        private String f1910c;

        /* renamed from: d */
        private String f1911d;

        /* renamed from: e */
        private String f1912e;

        /* renamed from: f */
        private Long f1913f;

        public PackagePriorityInfo(String str, String str2, String str3, String str4, String str5, long j) {
            this.f1908a = str;
            this.f1909b = str2;
            this.f1910c = str3;
            this.f1911d = str4;
            this.f1912e = str5;
            this.f1913f = Long.valueOf(j);
        }

        @Override // java.lang.Comparable
        public int compareTo(PackagePriorityInfo packagePriorityInfo) {
            if (TextUtils.equals(this.f1912e, packagePriorityInfo.f1912e)) {
                return this.f1913f.compareTo(packagePriorityInfo.f1913f);
            }
            return this.f1912e.compareTo(packagePriorityInfo.f1912e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.utils.HMSPackageManager$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class C1275a implements Comparator<ResolveInfo> {
        C1275a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ResolveInfo resolveInfo, ResolveInfo resolveInfo2) {
            String str = resolveInfo.serviceInfo.applicationInfo.packageName;
            String str2 = resolveInfo2.serviceInfo.applicationInfo.packageName;
            if (!HMSPackageManager.f1893s.containsKey(str) || !HMSPackageManager.f1893s.containsKey(str2)) {
                if (HMSPackageManager.f1893s.containsKey(str)) {
                    return -1;
                }
                return HMSPackageManager.f1893s.containsKey(str2) ? 1 : 0;
            }
            return str.compareTo(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.utils.HMSPackageManager$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class RunnableC1276b implements Runnable {
        RunnableC1276b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.m2120i("HMSPackageManager", "enter asyncOnceCheckMDMState");
            try {
                List<ResolveInfo> queryIntentServices = HMSPackageManager.this.f1894a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
                if (queryIntentServices == null || queryIntentServices.size() == 0) {
                    return;
                }
                Iterator<ResolveInfo> it = queryIntentServices.iterator();
                while (it.hasNext()) {
                    if ("com.huawei.hwid".equals(it.next().serviceInfo.applicationInfo.packageName)) {
                        HMSPackageManager.this.m2165d();
                    }
                }
                HMSLog.m2120i("HMSPackageManager", "quit asyncOnceCheckMDMState");
            } catch (Exception e) {
                HMSLog.m2118e("HMSPackageManager", "asyncOnceCheckMDMState query hms action failed. " + e.getMessage());
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f1893s = hashMap;
        hashMap.put("com.huawei.hwid", "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05");
        hashMap.put("com.huawei.hwid.tv", "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C");
    }

    private HMSPackageManager(Context context) {
        this.f1894a = context;
        this.f1895b = new PackageManagerHelper(context);
    }

    /* renamed from: c */
    private boolean m2164c(String str, String str2) {
        return Objects.equals(str2, this.f1895b.getPackageSigningCertificate(str)) || Objects.equals(str2, this.f1895b.getPackageSignature(str));
    }

    /* renamed from: d */
    private Pair<String, String> m2166d(String str, String str2) {
        if (!f1893s.containsKey(str) || !PackageConstants.SERVICES_SIGNATURE_V3.equalsIgnoreCase(str2)) {
            return null;
        }
        this.f1907n = 3;
        return new Pair<>(str, str2);
    }

    /* renamed from: e */
    private void m2169e(String str) {
        if (SystemUtils.isHuawei() || SystemUtils.isSystemApp(this.f1894a, str) || Build.VERSION.SDK_INT < 28 || m2160b(str)) {
            AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
        }
    }

    /* renamed from: f */
    private void m2170f() {
        synchronized (f1891q) {
            this.f1896c = null;
            this.f1897d = null;
            this.f1898e = 0;
        }
    }

    /* renamed from: g */
    private String m2171g() {
        String str;
        HMSLog.m2120i("HMSPackageManager", "Enter getAvailableHMSPackageNameForMultiService.");
        String str2 = this.f1899f;
        if (str2 != null) {
            m2162c(str2);
            if (!PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f1895b.getPackageStates(this.f1899f)) && (str = this.f1899f) != null) {
                return str;
            }
        }
        HMSLog.m2120i("HMSPackageManager", " return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public static HMSPackageManager getInstance(Context context) {
        synchronized (f1890p) {
            if (f1889o == null && context != null) {
                if (context.getApplicationContext() != null) {
                    f1889o = new HMSPackageManager(context.getApplicationContext());
                } else {
                    f1889o = new HMSPackageManager(context);
                }
                f1889o.m2176l();
                f1889o.m2159b();
            }
        }
        return f1889o;
    }

    /* renamed from: h */
    private Pair<String, String> m2172h() {
        try {
            List<ResolveInfo> queryIntentServices = this.f1894a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
            if (queryIntentServices != null && queryIntentServices.size() != 0) {
                m2155a(queryIntentServices);
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    String str = resolveInfo.serviceInfo.applicationInfo.packageName;
                    String packageSigningCertificate = this.f1895b.getPackageSigningCertificate(str);
                    String packageSignature = this.f1895b.getPackageSignature(str);
                    Pair<String, String> m2166d = m2166d(str, packageSigningCertificate);
                    if (m2166d != null) {
                        HMSLog.m2120i("HMSPackageManager", "signature V3 check success");
                        return m2166d;
                    }
                    Pair<String, String> m2149a = m2149a(resolveInfo.serviceInfo.metaData, str, packageSigningCertificate, packageSignature);
                    if (m2149a != null) {
                        HMSLog.m2120i("HMSPackageManager", "DSS signature check success");
                        return m2149a;
                    }
                    Pair<String, String> m2150a = m2150a(str, packageSignature);
                    if (m2150a != null) {
                        HMSLog.m2120i("HMSPackageManager", "signature V2 check success");
                        return m2150a;
                    }
                }
                return null;
            }
            HMSLog.m2118e("HMSPackageManager", "query hms action, resolveInfoList is null or empty.");
            return null;
        } catch (Exception e) {
            HMSLog.m2118e("HMSPackageManager", "getHmsPackageName query hms action failed. " + e.getMessage());
            return null;
        }
    }

    /* renamed from: i */
    private Pair<String, String> m2173i() {
        Pair<String, String> m2172h = m2172h();
        if (m2172h != null) {
            HMSLog.m2120i("HMSPackageManager", "aidlService pkgName: " + ((String) m2172h.first));
            this.f1901h = "com.huawei.hms.core.aidlservice";
            this.f1902i = null;
            return m2172h;
        }
        ArrayList<PackagePriorityInfo> m2174j = m2174j();
        if (m2174j == null) {
            HMSLog.m2118e("HMSPackageManager", "PackagePriorityInfo list is null");
            return null;
        }
        Iterator<PackagePriorityInfo> it = m2174j.iterator();
        while (it.hasNext()) {
            PackagePriorityInfo next = it.next();
            String str = next.f1908a;
            String str2 = next.f1909b;
            String str3 = next.f1910c;
            String str4 = next.f1911d;
            String packageSignature = this.f1895b.getPackageSignature(str);
            if (m2157a(str + ContainerUtils.FIELD_DELIMITER + packageSignature + ContainerUtils.FIELD_DELIMITER + str2, str3, str4)) {
                HMSLog.m2120i("HMSPackageManager", "result: " + str + ", " + str2 + ", " + next.f1913f);
                this.f1901h = PackageConstants.GENERAL_SERVICES_ACTION;
                m2167d(str2);
                return new Pair<>(str, packageSignature);
            }
        }
        return null;
    }

    /* renamed from: j */
    private ArrayList<PackagePriorityInfo> m2174j() {
        try {
            List<ResolveInfo> queryIntentServices = this.f1894a.getPackageManager().queryIntentServices(new Intent(PackageConstants.GENERAL_SERVICES_ACTION), 128);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                ArrayList<PackagePriorityInfo> arrayList = new ArrayList<>();
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    String str = resolveInfo.serviceInfo.applicationInfo.packageName;
                    long packageFirstInstallTime = this.f1895b.getPackageFirstInstallTime(str);
                    Bundle bundle = resolveInfo.serviceInfo.metaData;
                    if (bundle == null) {
                        HMSLog.m2118e("HMSPackageManager", "package " + str + " get metaData is null");
                    } else {
                        String m2152a = m2152a(bundle, "hms_app_checker_config");
                        String m2153a = m2153a(m2152a);
                        if (TextUtils.isEmpty(m2153a)) {
                            HMSLog.m2120i("HMSPackageManager", "get priority fail. hmsCheckerCfg: " + m2152a);
                        } else {
                            String m2152a2 = m2152a(bundle, "hms_app_signer_v2");
                            if (TextUtils.isEmpty(m2152a2)) {
                                HMSLog.m2120i("HMSPackageManager", "get signerV2 fail.");
                            } else {
                                String m2152a3 = m2152a(bundle, "hms_app_cert_chain");
                                if (TextUtils.isEmpty(m2152a3)) {
                                    HMSLog.m2120i("HMSPackageManager", "get certChain fail.");
                                } else {
                                    HMSLog.m2120i("HMSPackageManager", "add: " + str + ", " + m2152a + ", " + packageFirstInstallTime);
                                    arrayList.add(new PackagePriorityInfo(str, m2152a, m2152a2, m2152a3, m2153a, packageFirstInstallTime));
                                }
                            }
                        }
                    }
                }
                Collections.sort(arrayList);
                return arrayList;
            }
            HMSLog.m2118e("HMSPackageManager", "query aglite action, resolveInfoList is null or empty");
            return null;
        } catch (Exception e) {
            HMSLog.m2118e("HMSPackageManager", "query aglite action failed. " + e.getMessage());
            return null;
        }
    }

    /* renamed from: k */
    private void m2175k() {
        synchronized (f1891q) {
            Pair<String, String> m2172h = m2172h();
            if (m2172h == null) {
                HMSLog.m2118e("HMSPackageManager", "<initHmsPackageInfo> Failed to find HMS apk");
                m2170f();
                return;
            }
            String str = (String) m2172h.first;
            this.f1896c = str;
            this.f1897d = (String) m2172h.second;
            this.f1898e = this.f1895b.getPackageVersionCode(str);
            HMSLog.m2120i("HMSPackageManager", "<initHmsPackageInfo> Succeed to find HMS apk: " + this.f1896c + " version: " + this.f1898e);
        }
    }

    /* renamed from: l */
    private void m2176l() {
        synchronized (f1891q) {
            Pair<String, String> m2173i = m2173i();
            if (m2173i == null) {
                HMSLog.m2118e("HMSPackageManager", "<initHmsPackageInfoForMultiService> Failed to find HMS apk");
                m2168e();
                AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
            } else {
                this.f1899f = (String) m2173i.first;
                this.f1900g = (String) m2173i.second;
                this.f1903j = this.f1895b.getPackageVersionCode(m2171g());
                m2169e(this.f1899f);
                HMSLog.m2120i("HMSPackageManager", "<initHmsPackageInfoForMultiService> Succeed to find HMS apk: " + this.f1899f + " version: " + this.f1903j);
            }
        }
    }

    /* renamed from: m */
    private boolean m2177m() {
        Bundle bundle;
        PackageManager packageManager = this.f1894a.getPackageManager();
        if (packageManager == null) {
            HMSLog.m2118e("HMSPackageManager", "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
            return true;
        }
        try {
        } catch (AndroidException unused) {
            HMSLog.m2118e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.");
        } catch (RuntimeException e) {
            HMSLog.m2119e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.", e);
        }
        if (!TextUtils.isEmpty(this.f1901h) && (this.f1901h.equals(PackageConstants.GENERAL_SERVICES_ACTION) || this.f1901h.equals(PackageConstants.INTERNAL_SERVICES_ACTION))) {
            HMSLog.m2120i("HMSPackageManager", "action = " + this.f1901h + " exist");
            return false;
        }
        ApplicationInfo applicationInfo = packageManager.getPackageInfo(getHMSPackageName(), 128).applicationInfo;
        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("com.huawei.hms.kit.api_level:hmscore") && (getHmsVersionCode() >= 50000000 || getHmsVersionCode() <= 19999999)) {
            HMSLog.m2120i("HMSPackageManager", "MinApkVersion is disabled.");
            return false;
        }
        return true;
    }

    public String getHMSFingerprint() {
        String str = this.f1897d;
        return str == null ? "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05" : str;
    }

    public String getHMSPackageName() {
        HMSLog.m2120i("HMSPackageManager", "Enter getHMSPackageName");
        refresh();
        String str = this.f1896c;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f1895b.getPackageStates(str))) {
                HMSLog.m2120i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                m2175k();
            }
            String str2 = this.f1896c;
            if (str2 != null) {
                return str2;
            }
        }
        HMSLog.m2120i("HMSPackageManager", "return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public String getHMSPackageNameForMultiService() {
        HMSLog.m2120i("HMSPackageManager", "Enter getHMSPackageNameForMultiService");
        refreshForMultiService();
        String str = this.f1899f;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f1895b.getPackageStates(str))) {
                HMSLog.m2120i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                m2176l();
            }
            String str2 = this.f1899f;
            if (str2 != null) {
                return str2;
            }
        }
        HMSLog.m2120i("HMSPackageManager", "return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public PackageManagerHelper.PackageStates getHMSPackageStates() {
        synchronized (f1890p) {
            refresh();
            PackageManagerHelper.PackageStates packageStates = this.f1895b.getPackageStates(this.f1896c);
            PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
            if (packageStates == packageStates2) {
                m2170f();
                return packageStates2;
            }
            boolean z = false;
            if ("com.huawei.hwid".equals(this.f1896c) && m2165d() == 1) {
                return PackageManagerHelper.PackageStates.SPOOF;
            }
            if (packageStates == PackageManagerHelper.PackageStates.ENABLED && !m2164c(this.f1896c, this.f1897d)) {
                z = true;
            }
            return z ? packageStates2 : packageStates;
        }
    }

    public PackageManagerHelper.PackageStates getHMSPackageStatesForMultiService() {
        synchronized (f1890p) {
            refreshForMultiService();
            PackageManagerHelper.PackageStates packageStates = this.f1895b.getPackageStates(this.f1899f);
            PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
            if (packageStates == packageStates2) {
                m2168e();
                return packageStates2;
            }
            boolean z = false;
            if ("com.huawei.hwid".equals(this.f1899f) && m2165d() == 1) {
                return PackageManagerHelper.PackageStates.SPOOF;
            }
            if (packageStates == PackageManagerHelper.PackageStates.ENABLED && !m2164c(this.f1899f, this.f1900g)) {
                z = true;
            }
            return z ? packageStates2 : packageStates;
        }
    }

    public int getHmsMultiServiceVersion() {
        return this.f1895b.getPackageVersionCode(getHMSPackageNameForMultiService());
    }

    public int getHmsVersionCode() {
        return this.f1895b.getPackageVersionCode(getHMSPackageName());
    }

    public String getInnerServiceAction() {
        return PackageConstants.INTERNAL_SERVICES_ACTION;
    }

    public String getServiceAction() {
        return !TextUtils.isEmpty(this.f1901h) ? this.f1901h : "com.huawei.hms.core.aidlservice";
    }

    public boolean hmsVerHigherThan(int i) {
        if (this.f1898e >= i || !m2177m()) {
            return true;
        }
        int packageVersionCode = this.f1895b.getPackageVersionCode(getHMSPackageName());
        this.f1898e = packageVersionCode;
        return packageVersionCode >= i;
    }

    public boolean isApkNeedUpdate(int i) {
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.m2120i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", target version requirements: " + i);
        return hmsVersionCode < i;
    }

    public boolean isApkUpdateNecessary(int i) {
        if (isUpdateHmsForThirdPartyDevice()) {
            return true;
        }
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.m2120i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", minimum version requirements: " + i);
        return m2177m() && hmsVersionCode < i;
    }

    public boolean isUpdateHmsForThirdPartyDevice() {
        return "com.huawei.hwid".equals(this.f1899f) && AgHmsUpdateState.getInstance().isUpdateHms();
    }

    public boolean isUseOldCertificate() {
        return this.f1906m;
    }

    public void refresh() {
        if (TextUtils.isEmpty(this.f1896c) || TextUtils.isEmpty(this.f1897d)) {
            m2175k();
        }
        m2162c(this.f1896c);
    }

    public void refreshForMultiService() {
        if (TextUtils.isEmpty(this.f1899f) || TextUtils.isEmpty(this.f1900g)) {
            m2176l();
        }
        m2162c(this.f1899f);
    }

    public void resetMultiServiceState() {
        m2168e();
    }

    public void setUseOldCertificate(boolean z) {
        this.f1906m = z;
    }

    /* renamed from: b */
    private boolean m2160b(String str) {
        return !"com.huawei.hwid".equals(str) || this.f1907n == 3;
    }

    /* renamed from: a */
    private void m2155a(List<ResolveInfo> list) {
        if (list.size() <= 1) {
            return;
        }
        Collections.sort(list, new C1275a());
    }

    /* renamed from: b */
    private boolean m2161b(String str, String str2) {
        Map<String, String> map = f1893s;
        return map.containsKey(str) && map.get(str).equalsIgnoreCase(str2);
    }

    /* renamed from: c */
    private void m2162c(String str) {
        if ("com.huawei.hwid".equals(str) && AgHmsUpdateState.getInstance().isUpdateHms() && this.f1895b.getPackageVersionCode(str) >= AgHmsUpdateState.getInstance().getTargetVersionCode()) {
            AgHmsUpdateState.getInstance().resetUpdateState();
            HMSLog.m2120i("HMSPackageManager", "refresh update state for HMS V3");
        }
    }

    /* renamed from: b */
    private void m2159b() {
        new Thread(new RunnableC1276b(), "Thread-asyncOnceCheckMDMState").start();
    }

    /* renamed from: d */
    private void m2167d(String str) {
        String m2153a = m2153a(str);
        if (TextUtils.isEmpty(m2153a)) {
            return;
        }
        this.f1902i = m2153a.substring(9);
    }

    /* renamed from: e */
    private void m2168e() {
        synchronized (f1891q) {
            this.f1899f = null;
            this.f1900g = null;
            this.f1901h = null;
            this.f1902i = null;
            this.f1903j = 0;
        }
    }

    /* renamed from: a */
    private Pair<String, String> m2149a(Bundle bundle, String str, String str2, String str3) {
        String str4;
        if (bundle == null) {
            HMSLog.m2118e("HMSPackageManager", "DSS check: " + str + " for metadata is null");
            return null;
        }
        this.f1907n = 2;
        if (m2156a(bundle, str, str2)) {
            HMSLog.m2120i("HMSPackageManager", "support DSS V3 check");
            str3 = str2;
            str4 = "hms_app_signer_v3";
        } else {
            str4 = "hms_app_signer";
        }
        if (!bundle.containsKey(str4)) {
            HMSLog.m2118e("HMSPackageManager", "skip package " + str + " for no " + str4);
            return null;
        }
        if (!bundle.containsKey("hms_app_cert_chain")) {
            HMSLog.m2118e("HMSPackageManager", "skip package " + str + " for no cert chain");
            return null;
        }
        if (!m2157a(str + ContainerUtils.FIELD_DELIMITER + str3, bundle.getString(str4), bundle.getString("hms_app_cert_chain"))) {
            HMSLog.m2118e("HMSPackageManager", "checkSigner failed");
            return null;
        }
        if (str4.equals("hms_app_signer_v3")) {
            this.f1907n = 3;
        }
        return new Pair<>(str, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0028 A[Catch: all -> 0x0073, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x001c, B:11:0x0028, B:12:0x0042, B:15:0x0044, B:18:0x004b, B:19:0x006f), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044 A[Catch: all -> 0x0073, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x001c, B:11:0x0028, B:12:0x0042, B:15:0x0044, B:18:0x004b, B:19:0x006f), top: B:3:0x0007 }] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int m2165d() {
        boolean z;
        synchronized (f1892r) {
            HMSLog.m2120i("HMSPackageManager", "enter checkHmsIsSpoof");
            long packageFirstInstallTime = this.f1895b.getPackageFirstInstallTime("com.huawei.hwid");
            if (this.f1904k != 3 && this.f1905l == packageFirstInstallTime) {
                z = false;
                if (z) {
                    HMSLog.m2120i("HMSPackageManager", "quit checkHmsIsSpoof cached state: " + m2151a(this.f1904k));
                    return this.f1904k;
                }
                this.f1904k = m2163c() ? 2 : 1;
                this.f1905l = this.f1895b.getPackageFirstInstallTime("com.huawei.hwid");
                HMSLog.m2120i("HMSPackageManager", "quit checkHmsIsSpoof state: " + m2151a(this.f1904k));
                return this.f1904k;
            }
            z = true;
            if (z) {
            }
        }
    }

    /* renamed from: c */
    private boolean m2163c() {
        String hmsPath = ReadApkFileUtil.getHmsPath(this.f1894a);
        if (hmsPath == null) {
            HMSLog.m2120i("HMSPackageManager", "hmsPath is null!");
            return false;
        }
        if (!ReadApkFileUtil.isCertFound(hmsPath)) {
            HMSLog.m2120i("HMSPackageManager", "NO huawer.cer in HMS!");
            return false;
        }
        if (!ReadApkFileUtil.checkSignature()) {
            HMSLog.m2120i("HMSPackageManager", "checkSignature fail!");
            return false;
        }
        if (ReadApkFileUtil.verifyApkHash(hmsPath)) {
            return true;
        }
        HMSLog.m2120i("HMSPackageManager", "verifyApkHash fail!");
        return false;
    }

    /* renamed from: a */
    private Pair<String, String> m2150a(String str, String str2) {
        if (m2161b(str, str2)) {
            return new Pair<>(str, str2);
        }
        HMSLog.m2121w("HMSPackageManager", "check sign fail: " + str + BundleUtil.UNDERLINE_TAG + str2);
        return null;
    }

    /* renamed from: a */
    private boolean m2156a(Bundle bundle, String str, String str2) {
        return bundle.containsKey("hms_app_signer_v3") && !m2161b(str, str2) && Build.VERSION.SDK_INT >= 28;
    }

    /* renamed from: a */
    private String m2152a(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            HMSLog.m2118e("HMSPackageManager", "no " + str + " in metaData");
            return null;
        }
        return bundle.getString(str);
    }

    /* renamed from: a */
    private String m2153a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("priority=");
        if (indexOf == -1) {
            HMSLog.m2118e("HMSPackageManager", "get indexOfIdentifier -1");
            return null;
        }
        int indexOf2 = str.indexOf(",", indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        return str.substring(indexOf, indexOf2);
    }

    /* renamed from: a */
    private boolean m2157a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            List<X509Certificate> m1168b = C1072a.m1168b(str3);
            if (m1168b.size() == 0) {
                HMSLog.m2118e("HMSPackageManager", "certChain is empty");
                return false;
            }
            if (!C1072a.m1165a(C1072a.m1158a(this.f1894a), m1168b)) {
                HMSLog.m2118e("HMSPackageManager", "failed to verify cert chain");
                return false;
            }
            X509Certificate x509Certificate = m1168b.get(m1168b.size() - 1);
            if (!C1072a.m1163a(x509Certificate, "Huawei CBG HMS")) {
                HMSLog.m2118e("HMSPackageManager", "CN is invalid");
                return false;
            }
            if (!C1072a.m1170b(x509Certificate, "Huawei CBG Cloud Security Signer")) {
                HMSLog.m2118e("HMSPackageManager", "OU is invalid");
                return false;
            }
            if (C1072a.m1164a(x509Certificate, str, str2)) {
                return true;
            }
            HMSLog.m2118e("HMSPackageManager", "signature is invalid: " + str);
            return false;
        }
        HMSLog.m2118e("HMSPackageManager", "args is invalid");
        return false;
    }

    /* renamed from: a */
    private static String m2151a(int i) {
        if (i == 1) {
            return "SPOOFED";
        }
        if (i == 2) {
            return "SUCCESS";
        }
        if (i == 3) {
            return "UNCHECKED";
        }
        HMSLog.m2118e("HMSPackageManager", "invalid checkMDM state: " + i);
        return "";
    }
}
