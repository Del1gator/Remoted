package ru.enikeian.main.Enums;

public enum Mode {
    VIP("vip_"),
    CAPTURE_THE_FLAG("ctf_"),
    CAPTURE_POINTS("cp_"),
    CAPTURE_ALL_POINTS("cap_"),
    ZOMBIE_INFECT("zi_"),
    DEATH_MATCH("dm_"),
    ESCORT_MINECART("pl_");

    Mode(String map_prefix) {
        this.map_prefix = map_prefix;
    }

    private final String map_prefix;

    public String getPrefix() {
        return map_prefix;}
}
