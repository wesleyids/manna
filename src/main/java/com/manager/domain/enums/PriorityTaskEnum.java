package com.manager.domain.enums;

public enum PriorityTaskEnum {

    LOW("Low"),
    NORMAL("Normal"),
    MEDIUM("Medium"),
    HIGH("High");

    private String level;

    PriorityTaskEnum(String level) {
        this.level = level;
    }

    public String get() {
        return level;
    }
}
