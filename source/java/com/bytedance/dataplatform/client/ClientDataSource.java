package com.bytedance.dataplatform.client;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ClientDataSource<T> {
    private ClientGroup<T>[] clientGroup;
    private List<Pair<String, Float>> clientVidlist = new ArrayList();
    private String layer;
    private String module;
    private String[] moduleExperiments;
    private double start;

    public ClientDataSource(String layer, double start, String module, String[] moduleExperiments, ClientGroup<T>... clientGroup) {
        this.layer = layer;
        this.start = start;
        this.module = module;
        this.moduleExperiments = moduleExperiments;
        this.clientGroup = clientGroup;
        for (ClientGroup<T> clientGroup2 : clientGroup) {
            this.clientVidlist.add(new Pair<>(clientGroup2.getVid(), Double.valueOf(clientGroup2.getPercent())));
        }
    }

    public String getLayer() {
        return this.layer;
    }

    public List<Pair<String, Float>> getClientVidlist() {
        return this.clientVidlist;
    }

    public double getStart() {
        return this.start;
    }

    public ClientGroup<T>[] getClientGroup() {
        return this.clientGroup;
    }

    public String getModule() {
        return this.module;
    }

    public String[] getModuleExperiments() {
        return this.moduleExperiments;
    }
}
