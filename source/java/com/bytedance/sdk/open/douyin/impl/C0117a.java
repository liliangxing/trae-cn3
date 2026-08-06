package com.bytedance.sdk.open.douyin.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.sdk.open.aweme.CommonConstants;
import com.bytedance.sdk.open.aweme.authorize.AuthImpl;
import com.bytedance.sdk.open.aweme.authorize.handler.SendAuthDataHandler;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.handler.IDataHandler;
import com.bytedance.sdk.open.aweme.commonability.CommonAbility;
import com.bytedance.sdk.open.aweme.commonability.CommonAbilityDataHandler;
import com.bytedance.sdk.open.aweme.commonability.CommonAbilityImpl;
import com.bytedance.sdk.open.aweme.helper.OpenEventHelper;
import com.bytedance.sdk.open.aweme.share.Share;
import com.bytedance.sdk.open.aweme.share.ShareDataHandler;
import com.bytedance.sdk.open.aweme.share.ShareImpl;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.douyin.C0114b;
import com.bytedance.sdk.open.douyin.C0115c;
import com.bytedance.sdk.open.douyin.C0116d;
import com.bytedance.sdk.open.douyin.ShareToContact;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.bytedance.sdk.open.douyin.model.OpenRecord;
import com.bytedance.sdk.open.douyin.p002ui.DouYinWebAuthorizeActivity;
import com.bytedance.sdk.open.tt.C0137c;
import com.bytedance.sdk.open.tt.C0138d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.bytedance.sdk.open.douyin.impl.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0117a implements DouYinOpenApi {

    /* renamed from: l */
    private static final String f58l = "DouYinOpenApiImpl";

    /* renamed from: m */
    private static final String f59m = "douyinapi.DouYinEntryActivity";

    /* renamed from: n */
    private static final String f60n = "share.SystemShareActivity";

    /* renamed from: o */
    private static final String f61o = "openability.CommonAbilityActivity";

    /* renamed from: p */
    public static final String f62p = "wap_authorize_url";

    /* renamed from: q */
    private static final int f63q = 1;

    /* renamed from: r */
    private static final int f64r = 2;

    /* renamed from: s */
    private static final int f65s = 3;

    /* renamed from: a */
    private Map<Integer, IDataHandler> f66a = new HashMap(2);

    /* renamed from: b */
    private ShareImpl f67b;

    /* renamed from: c */
    private AuthImpl f68c;

    /* renamed from: d */
    private C0116d f69d;

    /* renamed from: e */
    private C0115c f70e;

    /* renamed from: f */
    private final DouYinCheckHelperImpl f71f;

    /* renamed from: g */
    private CommonAbilityImpl f72g;

    /* renamed from: h */
    private final C0121e f73h;

    /* renamed from: i */
    private final C0120d f74i;

    /* renamed from: j */
    private WeakReference<Activity> f75j;

    /* renamed from: k */
    private String f76k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.open.douyin.impl.a$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f77a;

        static {
            int[] iArr = new int[CommonConstants.InvokeStrategy.values().length];
            f77a = iArr;
            try {
                iArr[CommonConstants.InvokeStrategy.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f77a[CommonConstants.InvokeStrategy.DOUYIN_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f77a[CommonConstants.InvokeStrategy.LITE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f77a[CommonConstants.InvokeStrategy.HOTSOON_ONLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f77a[CommonConstants.InvokeStrategy.LITE_AND_HOTSOON.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f77a[CommonConstants.InvokeStrategy.DOUYIN_AND_HOTSOON.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f77a[CommonConstants.InvokeStrategy.DOUYIN_AND_LITE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public C0117a(Activity activity, String str) {
        this.f75j = new WeakReference<>(activity);
        Context applicationContext = activity.getApplicationContext();
        this.f76k = str;
        C0123g c0123g = new C0123g(str);
        this.f67b = new ShareImpl(applicationContext, c0123g);
        this.f68c = new AuthImpl(str);
        this.f69d = new C0116d(str);
        this.f70e = new C0115c(str);
        this.f72g = new CommonAbilityImpl(applicationContext, str);
        this.f71f = new DouYinCheckHelperImpl(applicationContext);
        this.f73h = new C0121e(applicationContext, c0123g);
        this.f74i = new C0120d(applicationContext);
        this.f66a.put(1, new SendAuthDataHandler());
        this.f66a.put(2, new ShareDataHandler());
        this.f66a.put(3, new CommonAbilityDataHandler());
    }

    /* renamed from: a */
    private boolean m35a(Authorization.Request request) {
        return this.f68c.authorizeWeb(this.f75j.get(), DouYinWebAuthorizeActivity.class, request);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000d. Please report as an issue. */
    /* renamed from: a */
    List<BaseCheckHelperImpl> m36a(CommonConstants.InvokeStrategy invokeStrategy) {
        Object obj;
        Object obj2;
        ArrayList arrayList = new ArrayList();
        switch (a.f77a[invokeStrategy.ordinal()]) {
            case 1:
                arrayList.add(this.f71f);
                obj2 = this.f73h;
                arrayList.add(obj2);
                obj = this.f74i;
                arrayList.add(obj);
                break;
            case 2:
                obj = this.f71f;
                arrayList.add(obj);
                break;
            case 3:
                obj = this.f73h;
                arrayList.add(obj);
                break;
            case 4:
                obj = this.f74i;
                arrayList.add(obj);
                break;
            case 5:
                obj2 = this.f73h;
                arrayList.add(obj2);
                obj = this.f74i;
                arrayList.add(obj);
                break;
            case 6:
                obj2 = this.f71f;
                arrayList.add(obj2);
                obj = this.f74i;
                arrayList.add(obj);
                break;
            case 7:
                arrayList.add(this.f71f);
                obj = this.f73h;
                arrayList.add(obj);
                break;
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean authorize(Authorization.Request request) {
        return authorize(request, CommonConstants.InvokeStrategy.AUTO);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean authorize(Authorization.Request request, CommonConstants.InvokeStrategy invokeStrategy) {
        OpenEventHelper.mobApiInvoke("auth");
        if (request == null) {
            return false;
        }
        for (BaseCheckHelperImpl baseCheckHelperImpl : m36a(invokeStrategy)) {
            if ((!(baseCheckHelperImpl instanceof C0121e) || request.isSupportLite) && baseCheckHelperImpl.isAppSupportAuthorization()) {
                return this.f68c.authorizeNative(this.f75j.get(), request, baseCheckHelperImpl.getPackageName(), baseCheckHelperImpl.getRemoteAuthEntryActivity(), f59m, C0114b.f52e, "5.21.1-rc.0");
            }
        }
        return m35a(request);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean authorizeInThirdApp(Authorization.Request request) {
        OpenEventHelper.mobApiInvoke("sdkAuth");
        Activity activity = this.f75j.get();
        if (activity == null) {
            LogUtils.m30w(f58l, "authorizeInThirdApp: activity is null");
            return false;
        }
        try {
            return ((Boolean) Class.forName("com.bytedance.sdk.open.aweme.mobile_auth.DouYinMobileAuthApi").getMethod("authorizeInThirdApp", Activity.class, String.class, Authorization.Request.class).invoke(null, activity, this.f76k, request)).booleanValue();
        } catch (Exception e) {
            LogUtils.m28e(f58l, e);
            return false;
        }
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean authorizeWeb(Authorization.Request request) {
        OpenEventHelper.mobApiInvoke("web_auth");
        return m35a(request);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public String getSdkVersion() {
        return "5.21.1-rc.0";
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public String getWapUrlIfAuthByWap(Authorization.Response response) {
        Bundle bundle;
        OpenEventHelper.mobApiInvoke("getWapUrlIfAuthByWap");
        if (response == null || (bundle = response.extras) == null || !bundle.containsKey("wap_authorize_url")) {
            return null;
        }
        return response.extras.getString("wap_authorize_url", "");
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean handleIntent(Intent intent, IApiEventHandler iApiEventHandler) {
        if (iApiEventHandler == null) {
            return false;
        }
        if (intent == null) {
            iApiEventHandler.onErrorIntent(intent);
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            iApiEventHandler.onErrorIntent(intent);
            return false;
        }
        int i = extras.getInt("_bytedance_params_type");
        if (i == 0) {
            i = extras.getInt(ParamKeyConstants.ShareParams.TYPE);
        }
        switch (i) {
            case 1:
            case 2:
                return this.f66a.get(1).handle(i, extras, iApiEventHandler);
            case 3:
            case 4:
                return this.f66a.get(2).handle(i, extras, iApiEventHandler);
            case 5:
            case 6:
                return new C0138d().handle(i, extras, iApiEventHandler);
            case 7:
            case 8:
                return new C0137c().handle(i, extras, iApiEventHandler);
            case 9:
            case 10:
                return this.f66a.get(3).handle(i, extras, iApiEventHandler);
            default:
                LogUtils.m30w(f58l, "handleIntent: unknown type " + i);
                return this.f66a.get(1).handle(i, extras, iApiEventHandler);
        }
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppInstalled() {
        boolean z;
        Iterator<BaseCheckHelperImpl> it = m36a(CommonConstants.InvokeStrategy.AUTO).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().isAppInstalled()) {
                z = true;
                break;
            }
        }
        OpenEventHelper.mobApiInvoke("isAppInstalled", z);
        return z;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportAuthorization() {
        boolean z;
        Iterator<BaseCheckHelperImpl> it = m36a(CommonConstants.InvokeStrategy.AUTO).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().isAppSupportAuthorization()) {
                z = true;
                break;
            }
        }
        OpenEventHelper.mobApiInvoke("isAppSupportAuthorization", z);
        return z;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportAuthorization(boolean z) {
        boolean z2 = this.f71f.isAppSupportAuthorization() || (z && this.f73h.isAppSupportAuthorization());
        OpenEventHelper.mobApiInvoke("isAppSupportAuthorization", z2);
        return z2;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportMixShare() {
        boolean z;
        Iterator<BaseCheckHelperImpl> it = m36a(CommonConstants.InvokeStrategy.AUTO).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().isAppSupportMixShare()) {
                z = true;
                break;
            }
        }
        OpenEventHelper.mobApiInvoke("isAppSupportMixShare", z);
        return z;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportShare() {
        boolean z;
        Iterator<BaseCheckHelperImpl> it = m36a(CommonConstants.InvokeStrategy.AUTO).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().isAppSupportShare()) {
                z = true;
                break;
            }
        }
        OpenEventHelper.mobApiInvoke("isAppSupportShare", z);
        return z;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportShareCardToContact() {
        boolean z;
        Iterator<BaseCheckHelperImpl> it = m36a(CommonConstants.InvokeStrategy.AUTO).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().isSupportShareCardToContact()) {
                z = true;
                break;
            }
        }
        OpenEventHelper.mobApiInvoke("isAppSupportShareCardToContact", z);
        return z;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportShareToContacts() {
        boolean z;
        Iterator<BaseCheckHelperImpl> it = m36a(CommonConstants.InvokeStrategy.AUTO).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().isSupportShareToContact()) {
                z = true;
                break;
            }
        }
        OpenEventHelper.mobApiInvoke("isAppSupportShareToContacts", z);
        return z;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportShareToImageAlbum() {
        boolean z;
        Iterator<BaseCheckHelperImpl> it = m36a(CommonConstants.InvokeStrategy.AUTO).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().isAppSupportShareToImageAlbum()) {
                z = true;
                break;
            }
        }
        OpenEventHelper.mobApiInvoke("isAppSupportShareToImageAlbum", z);
        return z;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportShareToPublish() {
        boolean z;
        Iterator<BaseCheckHelperImpl> it = m36a(CommonConstants.InvokeStrategy.AUTO).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().isSupportShareToPublish()) {
                z = true;
                break;
            }
        }
        OpenEventHelper.mobApiInvoke("isAppSupportShareToPublish", z);
        return z;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportVerification() {
        boolean z;
        Iterator<BaseCheckHelperImpl> it = m36a(CommonConstants.InvokeStrategy.AUTO).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().isSupportVerify()) {
                z = true;
                break;
            }
        }
        OpenEventHelper.mobApiInvoke("isAppSupportVerification", z);
        return z;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isShareSupportFileProvider() {
        boolean z;
        Iterator<BaseCheckHelperImpl> it = m36a(CommonConstants.InvokeStrategy.AUTO).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().isShareSupportFileProvider()) {
                z = true;
                break;
            }
        }
        OpenEventHelper.mobApiInvoke("isShareSupportFileProvider", z);
        return z;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isSupportApi(int i, int i2) {
        return isSupportApi(i, i2, CommonConstants.InvokeStrategy.AUTO);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isSupportApi(int i, int i2, CommonConstants.InvokeStrategy invokeStrategy) {
        boolean z = false;
        if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
            return false;
        }
        Iterator<BaseCheckHelperImpl> it = m36a(invokeStrategy).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (it.next().isSupportApi(i, i2)) {
                z = true;
                break;
            }
        }
        OpenEventHelper.mobApiInvoke("isSupportApi", z, i, i2);
        return z;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isSupportCommonAbility(int i) {
        boolean z;
        Iterator<BaseCheckHelperImpl> it = m36a(CommonConstants.InvokeStrategy.AUTO).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().isSupportCommonAbility(i)) {
                z = true;
                break;
            }
        }
        OpenEventHelper.mobApiInvoke("isSupportCommonAbility", z, i);
        return z;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isSupportOpenRecordPage() {
        boolean z;
        Iterator<BaseCheckHelperImpl> it = m36a(CommonConstants.InvokeStrategy.AUTO).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().isSupportOpenRecordPage()) {
                z = true;
                break;
            }
        }
        OpenEventHelper.mobApiInvoke("isSupportOpenRecordPage", z);
        return z;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isSupportShareLunaMusic() {
        boolean z;
        Iterator<BaseCheckHelperImpl> it = m36a(CommonConstants.InvokeStrategy.AUTO).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().isSupportShareLunaMusic()) {
                z = true;
                break;
            }
        }
        OpenEventHelper.mobApiInvoke("isSupportShareLunaMusic", z);
        return z;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isSupportSwitchAccount() {
        boolean z;
        Iterator<BaseCheckHelperImpl> it = m36a(CommonConstants.InvokeStrategy.AUTO).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().isSupportAuthSwitchAccount()) {
                z = true;
                break;
            }
        }
        OpenEventHelper.mobApiInvoke("isSupportSwitchAccount", z);
        return z;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean openCommon(CommonAbility.Request request) {
        return openCommon(request, CommonConstants.InvokeStrategy.AUTO);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean openCommon(CommonAbility.Request request, CommonConstants.InvokeStrategy invokeStrategy) {
        OpenEventHelper.mobApiInvoke("common");
        if (request == null) {
            return false;
        }
        int i = request.commonType;
        for (BaseCheckHelperImpl baseCheckHelperImpl : m36a(invokeStrategy)) {
            if (baseCheckHelperImpl.isSupportCommonAbility(i)) {
                return this.f72g.open(this.f75j.get(), f59m, baseCheckHelperImpl.getPackageName(), f61o, request, C0114b.f52e, "5.21.1-rc.0");
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean openRecordPage(OpenRecord.Request request) {
        return openRecordPage(request, CommonConstants.InvokeStrategy.AUTO);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean openRecordPage(OpenRecord.Request request, CommonConstants.InvokeStrategy invokeStrategy) {
        OpenEventHelper.mobApiInvoke("open_record");
        for (BaseCheckHelperImpl baseCheckHelperImpl : m36a(invokeStrategy)) {
            if (baseCheckHelperImpl.isSupportOpenRecordPage()) {
                this.f70e.m32a(this.f75j.get(), f59m, baseCheckHelperImpl.getPackageName(), BaseCheckHelperImpl.REMOTE_SHARE_RECORD_ACTIVITY, request, C0114b.f52e, "5.21.1-rc.0");
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean share(Share.Request request) {
        return share(request, CommonConstants.InvokeStrategy.AUTO);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean share(Share.Request request, CommonConstants.InvokeStrategy invokeStrategy) {
        OpenEventHelper.mobApiInvoke("share");
        if (request == null) {
            return false;
        }
        for (BaseCheckHelperImpl baseCheckHelperImpl : m36a(invokeStrategy)) {
            int i = request.requireApi;
            if (i == 10003 ? baseCheckHelperImpl.isAppSupportShare() : baseCheckHelperImpl.isSupportApi(2, i)) {
                return this.f67b.share(this.f75j.get(), f59m, baseCheckHelperImpl.getPackageName(), f60n, request, baseCheckHelperImpl.getRemoteAuthEntryActivity(), C0114b.f52e, "5.21.1-rc.0");
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean shareToContacts(ShareToContact.Request request) {
        return shareToContacts(request, CommonConstants.InvokeStrategy.AUTO);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean shareToContacts(ShareToContact.Request request, CommonConstants.InvokeStrategy invokeStrategy) {
        OpenEventHelper.mobApiInvoke("im");
        for (BaseCheckHelperImpl baseCheckHelperImpl : m36a(invokeStrategy)) {
            if ((request.mInviteCard != null && baseCheckHelperImpl.isSupportShareCardToContact()) || baseCheckHelperImpl.isSupportShareToContact()) {
                return this.f69d.m34a(this.f75j.get(), f59m, baseCheckHelperImpl.getPackageName(), "openshare.ShareToContactsActivity", request);
            }
        }
        return false;
    }
}
