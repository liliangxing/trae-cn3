package com.bytedance.lego.init.generate;

import com.bytedance.lego.init.IFeedShowTaskCollector;
import com.bytedance.lego.init.model.FeedShowTaskInfo;
import com.bytedance.trae.init.task.InitNpthAsyncTask;
import com.bytedance.trae.init.task.InitNpthGwpAsanTask;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class FeedShowTaskCollector__trae_android_app implements IFeedShowTaskCollector {
    @Override // com.bytedance.lego.init.IFeedShowTaskCollector
    public void collectTask(List<FeedShowTaskInfo> list) {
        list.add(new FeedShowTaskInfo("InitNpthAsyncTask", "client_tech", new InitNpthAsyncTask(), false, -100));
        list.add(new FeedShowTaskInfo("InitNpthGwpAsanTask", "client_tech", new InitNpthGwpAsanTask(), false, -100));
    }
}
