package pe.interbank.openbanking.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    private String identifier;
    private String description;
    private Integer quantity;
    private Integer value;


}
