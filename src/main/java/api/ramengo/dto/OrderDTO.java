package api.ramengo.dto;

import jakarta.validation.constraints.NotNull;

public record OrderDTO(@NotNull
                       Long brothId,
                       @NotNull
                       Long proteinId) {

}
