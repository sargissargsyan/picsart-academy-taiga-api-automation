package io.taiga.api.models;

public class PrivateExtraInfo {
    public boolean can_be_updated;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isCan_be_updated() {
        return can_be_updated;
    }

    public void setCan_be_updated(boolean can_be_updated) {
        this.can_be_updated = can_be_updated;
    }

    public String reason;
}
