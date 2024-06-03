package ramenGo.com.demo.web.response;

public class RedVenturesOrderGenerateIdResponse {
    private String orderId;

    public RedVenturesOrderGenerateIdResponse(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
