package com.homework.consol;

public class CategoryDTO {
    private int code;
    private int areaCode;
    private String name;
    private String type;
    private String step;
    private String menu;
    private String orderableStatus;

    public CategoryDTO() {
    }

    public CategoryDTO(int code, int areaCode, String name, String type, String step, String menu, String orderableStatus) {
        this.code = code;
        this.areaCode = areaCode;
        this.name = name;
        this.type = type;
        this.step = step;
        this.menu = menu;
        this.orderableStatus = orderableStatus;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "code=" + code +
                ", areaCode=" + areaCode +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", step='" + step + '\'' +
                ", menu='" + menu + '\'' +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
