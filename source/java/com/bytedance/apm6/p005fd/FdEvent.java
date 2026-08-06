package com.bytedance.apm6.p005fd;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import com.bytedance.apm6.util.ListUtils;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FdEvent extends PerfBaseEvent {
    private static final String KEY_FD_COUNT = "fd_count";
    private static final String KEY_FD_DETAIL = "fd_detail";
    private static final String PERF_KEY_FD = "fd";
    private int fdCount;
    private List<String> fdNames;
    private boolean isFront;

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraValues() {
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected String getServiceName() {
        return "fd";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }

    public FdEvent(int i, List<String> list, boolean z) {
        this.fdCount = i;
        this.fdNames = list;
        this.isFront = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject createRootJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_FD_COUNT, this.fdCount);
            if (!ListUtils.isEmpty(this.fdNames)) {
                jSONObject.put(KEY_FD_DETAIL, ListUtils.listToString(this.fdNames, "\n"));
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getExtraStatus() {
        JSONObject extraStatus = super.getExtraStatus();
        if (extraStatus == null) {
            try {
                extraStatus = new JSONObject();
            } catch (Exception unused) {
            }
        }
        extraStatus.put(CommonKey.KEY_IS_FRONT, this.isFront);
        return extraStatus;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getFilters() {
        return PerfFilterManager.getInstance().getPerfFiltersJson();
    }
}
