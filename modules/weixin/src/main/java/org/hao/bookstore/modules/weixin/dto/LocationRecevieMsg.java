package org.hao.bookstore.modules.weixin.dto;

import org.hao.bookstore.modules.weixin.constants.MessageType;

public class LocationRecevieMsg extends RecevieMsg {

    private static final long serialVersionUID = -3314386868547667712L;
    private double            locationX;
    private double            locationY;
    private double            scale;
    private String            label;

    public double getLocationX() {
        return locationX;
    }

    public void setLocationX(double locationX) {
        this.locationX = locationX;
    }

    public double getLocationY() {
        return locationY;
    }

    public void setLocationY(double locationY) {
        this.locationY = locationY;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public MessageType getMsgType() {
        return MessageType.location;
    }
}
