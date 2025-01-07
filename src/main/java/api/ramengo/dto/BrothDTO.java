package api.ramengo.dto;


import api.ramengo.model.Broth;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BrothDTO(@NotNull Long id, @NotBlank String image, @NotBlank String name, @NotBlank String description, @NotNull Integer price) {
    public BrothDTO(Broth broth){
        this(broth.getId(), broth.getImage(), broth.getName(), broth.getDescription(), broth.getPrice());
    }
}
