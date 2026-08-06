package com.lynx.tasm.performance.performanceobserver;

import com.lynx.tasm.TimingHandler;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class InitContainerEntry extends PerformanceEntry {
    public double containerInitEnd;
    public double containerInitStart;
    public HashMap<String, Double> extraTiming;
    public double openTime;
    public double prepareTemplateEnd;
    public double prepareTemplateStart;

    public InitContainerEntry(HashMap<String, Object> hashMap) {
        super(hashMap);
        this.openTime = hashMap.get(TimingHandler.OPEN_TIME) != null ? ((Double) hashMap.get(TimingHandler.OPEN_TIME)).doubleValue() : -1.0d;
        this.containerInitStart = hashMap.get(TimingHandler.CONTAINER_INIT_START) != null ? ((Double) hashMap.get(TimingHandler.CONTAINER_INIT_START)).doubleValue() : -1.0d;
        this.containerInitEnd = hashMap.get(TimingHandler.CONTAINER_INIT_END) != null ? ((Double) hashMap.get(TimingHandler.CONTAINER_INIT_END)).doubleValue() : -1.0d;
        this.prepareTemplateStart = hashMap.get(TimingHandler.PREPARE_TEMPLATE_START) != null ? ((Double) hashMap.get(TimingHandler.PREPARE_TEMPLATE_START)).doubleValue() : -1.0d;
        this.prepareTemplateEnd = hashMap.get(TimingHandler.PREPARE_TEMPLATE_END) != null ? ((Double) hashMap.get(TimingHandler.PREPARE_TEMPLATE_END)).doubleValue() : -1.0d;
        this.extraTiming = hashMap.get("extraTiming") != null ? (HashMap) hashMap.get("extraTiming") : new HashMap<>();
    }
}
