package api.ramengo.dto;


import api.ramengo.model.Broth;

public record BrothDTO(Long id, String image, String name, String description, Integer price) {
    public BrothDTO(Broth broth){
        this(broth.getId(), broth.getImage(), broth.getName(), broth.getDescription(), broth.getPrice());
    }
}
