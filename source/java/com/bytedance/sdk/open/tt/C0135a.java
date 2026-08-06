package com.bytedance.sdk.open.tt;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.base.MediaContent;
import com.bytedance.sdk.open.aweme.common.model.BaseReq;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;
import com.bytedance.sdk.open.douyin.model.ContactHtmlObject;
import com.bytedance.sdk.open.tt.InterfaceC0136b;

/* renamed from: com.bytedance.sdk.open.tt.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0135a {

    /* renamed from: com.bytedance.sdk.open.tt.a$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class a extends BaseReq {
        public ContactHtmlObject htmlObject;
        public String mClientKey;
        public MediaContent mMediaContent;
        public String mState;

        public a() {
        }

        public a(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void fromBundle(Bundle bundle) {
            this.callerPackage = bundle.getString(InterfaceC0136b.a.f212l);
            this.extras = bundle.getBundle(InterfaceC0136b.a.f205e);
            this.callerLocalEntry = bundle.getString(InterfaceC0136b.a.f213m);
            this.mClientKey = bundle.getString(InterfaceC0136b.a.f203c);
            this.mMediaContent = MediaContent.Builder.fromBundle(bundle);
            this.htmlObject = ContactHtmlObject.unserialize(bundle);
            this.mState = bundle.getString(InterfaceC0136b.a.f204d, "");
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public int getType() {
            return 5;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putInt(InterfaceC0136b.a.f210j, getType());
            bundle.putBundle(InterfaceC0136b.a.f205e, this.extras);
            bundle.putString(InterfaceC0136b.a.f213m, this.callerLocalEntry);
            bundle.putString(InterfaceC0136b.a.f204d, this.mState);
            bundle.putString(InterfaceC0136b.a.f203c, this.mClientKey);
            MediaContent mediaContent = this.mMediaContent;
            if (mediaContent != null) {
                bundle.putAll(MediaContent.Builder.toBundle(mediaContent));
            }
            ContactHtmlObject contactHtmlObject = this.htmlObject;
            if (contactHtmlObject != null) {
                contactHtmlObject.serialize(bundle);
            }
        }
    }

    /* renamed from: com.bytedance.sdk.open.tt.a$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class b extends BaseResp {
        public String mState;

        public b() {
        }

        public b(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public void fromBundle(Bundle bundle) {
            this.errorCode = bundle.getInt(InterfaceC0136b.a.f208h);
            this.errorMsg = bundle.getString(InterfaceC0136b.a.f209i);
            this.extras = bundle.getBundle(InterfaceC0136b.a.f205e);
            this.mState = bundle.getString(InterfaceC0136b.a.f204d);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public int getType() {
            return 6;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public void toBundle(Bundle bundle) {
            bundle.putInt(InterfaceC0136b.a.f208h, this.errorCode);
            bundle.putString(InterfaceC0136b.a.f209i, this.errorMsg);
            bundle.putInt(InterfaceC0136b.a.f210j, getType());
            bundle.putBundle(InterfaceC0136b.a.f205e, this.extras);
        }
    }
}
