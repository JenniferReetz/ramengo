package api.ramengo.dto;

import jakarta.validation.constraints.NotNull;

public record OrderDTO(@NotNull
                       Long brothId,
                       Long proteinId) {

}
