package groom.buddy.area;

import lombok.Data;

import java.util.List;

@Data
public class AreaHomeResponseDTO {

    private double percentage;
    private String progressAreaType;
    private List<String> completeAreaTypes;
}
