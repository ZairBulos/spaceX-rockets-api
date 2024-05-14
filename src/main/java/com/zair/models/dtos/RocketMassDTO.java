package com.zair.models.dtos;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class RocketMassDTO {
    private final Long kg;
    private final Long lb;
}
