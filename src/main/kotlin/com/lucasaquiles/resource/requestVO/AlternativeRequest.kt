package com.lucasaquiles.resource.requestVO

import java.math.BigDecimal
import javax.validation.constraints.NotBlank

data class AlternativeRequest(
        @NotBlank val alternative : String,
        @NotBlank val score: BigDecimal
)