package api.ramengo.dto;

import api.ramengo.model.Protein;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProteinDTO(@NotNull Long id, @NotBlank String image,@NotBlank String name,@NotBlank String description,@NotNull Integer price) {
    public ProteinDTO(Protein protein) {
        this(protein.getId(), protein.getImage(), protein.getName(), protein.getDescription(), protein.getPrice());
    }
}
