package com.example.springjpapratice.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AccountStatus {
    INACTIVE(0), ACTIVE(1);
    private final Integer value;
}
