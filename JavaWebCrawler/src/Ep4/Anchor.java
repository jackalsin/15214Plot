package Ep4;

import java.security.Timestamp;

/**
 * The anchor class.
 * Created by jacka on 3/25/2016.
 */
public class Anchor {

    private Domain domain;
    private String anchorHash;
    private String anchorURL;
    private int scanStatus;
    private boolean activated;
    private Timestamp modified;
    private Timestamp created;

    public Anchor(Domain domain, String anchorHash, String anchorURL) {
        this.domain = domain;
        this.anchorHash = anchorHash;
        this.anchorURL = anchorURL;
    }

    public Anchor(Domain domain, String anchorHash, String anchorURL, int scanStatus, boolean activated, Timestamp modified, Timestamp created) {
        this.domain = domain;
        this.anchorHash = anchorHash;
        this.anchorURL = anchorURL;
        this.scanStatus = scanStatus;
        this.activated = activated;
        this.modified = modified;
        this.created = created;
    }


    public Domain getDomain() {
        return domain;
    }

    public String getAnchorHash() {
        return anchorHash;
    }

    public String getAnchorURL() {
        return anchorURL;
    }

    public int getScanStatus() {
        return scanStatus;
    }

    public boolean isActivated() {
        return activated;
    }

    public Timestamp getModified() {
        return modified;
    }

    public Timestamp getCreated() {
        return created;
    }
}
