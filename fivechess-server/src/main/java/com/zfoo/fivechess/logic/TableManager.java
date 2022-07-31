package com.zfoo.fivechess.logic;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TableManager {
    private static final AtomicInteger globalTableId = new AtomicInteger(0);

    private static final Map<Integer, Table> tableIdTableMap = Maps.newConcurrentMap();

    public static int getNextTableId() {
        return globalTableId.getAndIncrement();
    }

    public static Table getTableByTableId(int tableId) {
        return tableIdTableMap.get(tableId);
    }

    public static Table addTable(int tableId) {
        if (tableIdTableMap.containsKey(tableId)) {
            return null;
        }

        Table table = new Table();
        table.setTableId(tableId);

        tableIdTableMap.put(tableId, table);

        return table;
    }

    public static void removeTable(int tableId) {
        tableIdTableMap.remove(tableId);
    }
}























