package pe.interbank.openbanking.utils;

public enum WebServiceEndpoints {

    GENERATE_TOKEN("/security/v1/oauth/token"),
    PAYMENT_ORDER("/payment-gateway/v1/payment-orders");

    private final String path;

    WebServiceEndpoints(String path) {
        this.path = path;
    }

    public String getPath(){
        return path;
    }
}
