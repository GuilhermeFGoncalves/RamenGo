package ramenGo.com.demo.web.request;


public class OrderCreateRequest {

    private String brothId;
    private String proteinId;

    public OrderCreateRequest(String brothId, String proteinId) {
        this.brothId = brothId;
        this.proteinId = proteinId;
    }

    public void setBrothId(String brothId) {
        this.brothId = brothId;
    }

    public void setProteinId(String proteinId) {
        this.proteinId = proteinId;
    }

    public String getBrothId() {
        return brothId;
    }

    public String getProteinId() {
        return proteinId;
    }
}
