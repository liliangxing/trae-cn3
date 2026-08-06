package com.bytedance.sdk.account.ticketguard;

import com.bytedance.android.sdk.bdticketguard.INetwork;
import com.bytedance.android.sdk.bdticketguard.TTHeader;
import com.bytedance.android.sdk.bdticketguard.TTResponse;
import com.bytedance.sdk.account.utils.NetworkUtils;
import com.bytedance.sdk.account.utils.TicketGuardUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class TicketGuardNetwork implements INetwork {
    public TTResponse executePost(int i, String str, Map<String, String> map, List<TTHeader> list) throws Exception {
        List convertToTokenHeader = TicketGuardUtils.convertToTokenHeader(list);
        if (map == null) {
            map = new HashMap<>();
        }
        if (convertToTokenHeader == null) {
            convertToTokenHeader = new ArrayList();
        }
        com.ss.android.TTResponse executePost = NetworkUtils.executePost(i, str, map, convertToTokenHeader);
        if (executePost == null) {
            return null;
        }
        return new TTResponse(executePost.getUrl(), executePost.getStatus(), TicketGuardUtils.convertToTicketGuardHeader(executePost.getHeaders()), executePost.getBody());
    }
}
