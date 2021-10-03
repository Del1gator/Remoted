package ru.enikeian.main.Enums;

public enum Mode {
    VIP("vip_", "Спасение VIP"),
    CAPTURE_THE_FLAG("ctf_", "Захват флага"),
    CAPTURE_POINTS("cp_", "Защита контрольных точек"),
    CAPTURE_ALL_POINTS("cap_", "Захват и защита точек"),
    ZOMBIE_INFECT("zi_", "Заражение"),
    DEATH_MATCH("dm_", "Смертельный матч"),
    ESCORT_MINECART("pl_", "Сопровождение вагонетки");

    Mode(String map_prefix, String expanded) {
        this.map_prefix = map_prefix;
        this.expanded = expanded;

    }

    private final String map_prefix;
    private final String expanded;

    public String getPrefix() {
        return map_prefix;
    }

    public String getExpanded() {
        return expanded;
    }
}
