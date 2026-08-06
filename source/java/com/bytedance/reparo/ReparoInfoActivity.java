package com.bytedance.reparo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.bytedance.reparo.core.PatchManager;
import com.bytedance.reparo.core.ReparoPatch;
import com.bytedance.reparo.core.parse.PatchRecordInfo;
import com.bytedance.reparo.core.patch.Patch;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ReparoInfoActivity extends Activity implements PatchManager.OnPatchChangeListener {
    private PatchInfoAdapter mAdapter;
    private ArrayList<Patch> localPatches = new ArrayList<>();
    private Handler mHandler = new Handler();

    public void com_bytedance_reparo_ReparoInfoActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        m301x414e69ca(this);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0720R.layout.reparo_info);
        if (!Reparo.getInstance().isHotFixReady()) {
            findViewById(C0720R.id.reparo_error_msg).setVisibility(0);
            findViewById(C0720R.id.reparo_info_container).setVisibility(8);
            return;
        }
        Map<PatchRecordInfo, Patch> queryLocalPatches = ReparoPatch.getInstance().queryLocalPatches();
        ReparoPatch.getInstance().registerOnPatchChangeListener(this);
        this.localPatches.clear();
        this.localPatches.addAll(queryLocalPatches.values());
        ListView listView = (ListView) findViewById(C0720R.id.reparo_info_list);
        PatchInfoAdapter patchInfoAdapter = new PatchInfoAdapter();
        this.mAdapter = patchInfoAdapter;
        listView.setAdapter((ListAdapter) patchInfoAdapter);
        findViewById(C0720R.id.reparo_fetch_patchs).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.reparo.ReparoInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Reparo.getInstance().loadRemotePatchAsync();
            }
        });
        findViewById(C0720R.id.reparo_clear_patchs).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.reparo.ReparoInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Reparo.getInstance().clearPatchForCrash();
                System.exit(0);
            }
        });
    }

    @Override // com.bytedance.reparo.core.PatchManager.OnPatchChangeListener
    public void onChanged(ConcurrentHashMap<PatchRecordInfo, Patch> concurrentHashMap) {
        this.mHandler.post(new Runnable() { // from class: com.bytedance.reparo.ReparoInfoActivity.3
            @Override // java.lang.Runnable
            public void run() {
                Map<PatchRecordInfo, Patch> queryLocalPatches = ReparoPatch.getInstance().queryLocalPatches();
                ReparoInfoActivity.this.localPatches.clear();
                ReparoInfoActivity.this.localPatches.addAll(queryLocalPatches.values());
                ReparoInfoActivity.this.mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (Reparo.getInstance().isHotFixReady()) {
            ReparoPatch.getInstance().unregisterOnPatchChangeListener(this);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    class PatchInfoViewHolder {
        TextView mPatchIdView;
        TextView mPatchInstallDirView;
        TextView mPatchVersionView;

        PatchInfoViewHolder() {
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    class PatchInfoAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        PatchInfoAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ReparoInfoActivity.this.localPatches.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ReparoInfoActivity.this.localPatches.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            PatchInfoViewHolder patchInfoViewHolder;
            if (view != null) {
                patchInfoViewHolder = (PatchInfoViewHolder) view.getTag();
            } else {
                view = ReparoInfoActivity.this.getLayoutInflater().inflate(C0720R.layout.reparo_info_item, viewGroup, false);
                patchInfoViewHolder = new PatchInfoViewHolder();
                view.setTag(patchInfoViewHolder);
                patchInfoViewHolder.mPatchIdView = (TextView) view.findViewById(C0720R.id.reparo_patch_id);
                patchInfoViewHolder.mPatchVersionView = (TextView) view.findViewById(C0720R.id.reparo_patch_version);
                patchInfoViewHolder.mPatchInstallDirView = (TextView) view.findViewById(C0720R.id.reparo_patch_install_dir);
            }
            PatchRecordInfo recordInfo = ((Patch) ReparoInfoActivity.this.localPatches.get(i)).getRecordInfo();
            patchInfoViewHolder.mPatchIdView.setText(recordInfo.getPatchId());
            patchInfoViewHolder.mPatchVersionView.setText(recordInfo.getPatchVersion());
            patchInfoViewHolder.mPatchInstallDirView.setText(recordInfo.getInstallDirPath());
            return view;
        }
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_reparo_ReparoInfoActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m301x414e69ca(ReparoInfoActivity reparoInfoActivity) {
        reparoInfoActivity.com_bytedance_reparo_ReparoInfoActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                reparoInfoActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
