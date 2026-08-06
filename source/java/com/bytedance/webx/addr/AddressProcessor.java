package com.bytedance.webx.addr;

import android.net.Uri;
import com.bytedance.webx.AbsExtension;
import com.bytedance.webx.addr.AddressParam;
import com.bytedance.webx.base.logger.WLog;
import com.bytedance.webx.context.IContext;
import com.bytedance.webx.context.IContextItem;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AddressProcessor {
    private static final String TAG = "AddressProcessor";
    private AddressParam mContainerAddressParam;
    private IContext mContext;
    private boolean mIsApproveChangeded = false;
    private AddressParam mPageAddressParam;
    private Uri mUri;
    private String mUrl;

    public AddressProcessor(IContext iContext) {
        this.mContext = iContext;
    }

    public void onCreateContainer(String str) {
        handle(str, 0);
    }

    public void onChangePage(String str) {
        handle(str, 1);
    }

    private void handle(String str, int i) {
        if (str == null || !str.startsWith("http") || str.equals(this.mUrl)) {
            return;
        }
        this.mUrl = str;
        try {
            this.mUri = Uri.parse(str);
            String parseUriMatch = AddressParam.parseUriMatch(this.mContext.getEnv().mUriMatchs, this.mUri);
            if (parseUriMatch == null) {
                parseUriMatch = this.mUri.getQueryParameter("bdwk_extension");
            }
            if (i == 0) {
                List<AddressParam.BdwkParamItem> parseParam = AddressParam.parseParam(0, parseUriMatch);
                if (this.mContainerAddressParam == null) {
                    this.mContainerAddressParam = new AddressParam();
                }
                Iterator<AddressParam.BdwkParamItem> it = parseParam.iterator();
                while (it.hasNext()) {
                    this.mContainerAddressParam.add(it.next());
                }
            }
            if (this.mContainerAddressParam == null) {
                WLog.m43e(TAG, "h2 url = " + str);
                return;
            }
            List<AddressParam.BdwkParamItem> parseParam2 = AddressParam.parseParam(1, parseUriMatch);
            AddressParam addressParam = this.mPageAddressParam;
            if (addressParam == null) {
                this.mPageAddressParam = new AddressParam();
            } else {
                addressParam.clear();
            }
            Iterator<AddressParam.BdwkParamItem> it2 = parseParam2.iterator();
            while (it2.hasNext()) {
                this.mPageAddressParam.add(it2.next());
            }
            this.mPageAddressParam.pickMerge(this.mContainerAddressParam);
            updateAllApprove(this.mPageAddressParam);
        } catch (Exception e) {
            WLog.m44e(TAG, "h1 event = " + i + ", url = " + str, e);
        }
    }

    private void updateAllApprove(AddressParam addressParam) {
        if (addressParam == null || addressParam.isEmpty()) {
            if (this.mIsApproveChangeded) {
                restoreApprove();
                this.mIsApproveChangeded = false;
                return;
            }
            return;
        }
        updateApprove(addressParam);
    }

    private void updateApprove(AddressParam addressParam) {
        Iterator<IContextItem> itContextItems = this.mContext.itContextItems();
        while (itContextItems.hasNext()) {
            IContextItem next = itContextItems.next();
            if (next instanceof AbsExtension) {
                AbsExtension absExtension = (AbsExtension) next;
                if (absExtension.isMatchable()) {
                    Boolean approve = addressParam.getApprove(absExtension.getName());
                    if (approve != null) {
                        absExtension.setApprove(approve.booleanValue());
                        this.mIsApproveChangeded = true;
                    } else {
                        absExtension.setApprove(absExtension.getApproveDefault());
                    }
                }
            }
        }
    }

    private void restoreApprove() {
        Iterator<IContextItem> itContextItems = this.mContext.itContextItems();
        while (itContextItems.hasNext()) {
            IContextItem next = itContextItems.next();
            if (next instanceof AbsExtension) {
                AbsExtension absExtension = (AbsExtension) next;
                if (absExtension.isMatchable()) {
                    absExtension.setApprove(absExtension.getApproveDefault());
                }
            }
        }
    }
}
