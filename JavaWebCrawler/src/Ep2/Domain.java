package Ep2;

import java.security.Timestamp;
import java.sql.Time;

/**
 * Created by jacka on 3/25/2016.
 */
public class Domain {
    private String domainHash;
    private String domainURL;
    private boolean activated;
    private Timestamp modified;
    private Timestamp created;


    /**
     * The constructor that has all the field initialized.
     * Load data from the database
     * @param domainHash
     * @param domainURL
     * @param activated
     * @param modified
     * @param created
     */
    public Domain(String domainHash, String domainURL, boolean activated, Timestamp modified, Timestamp created) {
        this.domainHash = domainHash;
        this.domainURL = domainURL;
        this.activated = activated;
        this.modified = modified;
        this.created = created;
    }

    /**
     * The constructor to initial two fields .
     * @param domainHash
     * @param domainURL
     */
    public Domain(String domainHash, String domainURL) {
        this.domainHash = domainHash;
        this.domainURL = domainURL;
    }


    public String getDomainHash() {
        return domainHash;
    }

    public String getDomainURL() {
        return domainURL;
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
