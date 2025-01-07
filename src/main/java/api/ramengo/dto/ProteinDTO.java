package api.ramengo.dto;

import api.ramengo.model.Protein;

public record ProteinDTO(Long id, String image, String name, String description, Integer price) {
    public ProteinDTO(Protein protein) {
        this(protein.getId(), protein.getImage(), protein.getName(), protein.getDescription(), protein.getPrice());
    }
}
