package com.bytedance.sdk.open.douyin;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.base.InviteCardObject;
import com.bytedance.sdk.open.aweme.base.JoinGroupObject;
import com.bytedance.sdk.open.tt.C0135a;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ShareToContact extends C0135a {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class Request extends C0135a.a {
        public InviteCardObject mInviteCard;
        public JoinGroupObject mJoinGroupObject;

        public Request() {
        }

        public Request(Bundle bundle) {
            super(bundle);
            fromBundle(bundle);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public boolean checkArgs() {
            InviteCardObject inviteCardObject = this.mInviteCard;
            if (inviteCardObject == null || inviteCardObject.checkArgs()) {
                return super.checkArgs();
            }
            return false;
        }

        @Override // com.bytedance.sdk.open.tt.C0135a.a, com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.mInviteCard = InviteCardObject.unserialize(bundle);
            this.mJoinGroupObject = JoinGroupObject.unserialize(bundle);
        }

        @Override // com.bytedance.sdk.open.tt.C0135a.a, com.bytedance.sdk.open.aweme.common.model.BaseReq
        public int getType() {
            return 5;
        }

        @Override // com.bytedance.sdk.open.tt.C0135a.a, com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            InviteCardObject inviteCardObject = this.mInviteCard;
            if (inviteCardObject != null) {
                inviteCardObject.serialize(bundle);
            }
            JoinGroupObject joinGroupObject = this.mJoinGroupObject;
            if (joinGroupObject != null) {
                joinGroupObject.serialize(bundle);
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class Response extends C0135a.b {
        public Response() {
        }

        public Response(Bundle bundle) {
            fromBundle(bundle);
        }
    }
}
