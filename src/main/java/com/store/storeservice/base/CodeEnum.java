package com.store.storeservice.base;

import javafx.scene.input.KeyCodeCombination;

public enum CodeEnum {
    SUCCESS(200),
    DEFAULT_ASSWORD(800),
    ERROR(99999);

    private Integer code;

    private CodeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }
}
