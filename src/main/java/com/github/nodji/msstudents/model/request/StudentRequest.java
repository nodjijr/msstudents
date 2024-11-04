package com.github.nodji.msstudents.model.request;

import java.util.UUID;

public record StudentRequest(UUID id, String name, String code, String email, Integer age) {
}
