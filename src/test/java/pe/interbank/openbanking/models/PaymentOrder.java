package pe.interbank.openbanking.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentOrder {

    private Integer amount;
    private String currency;
    private Buyer buyer;
    private List<Item> items = null;


}
