/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applications;

/**
 *
 * @author calsifer
 */
public class CustomApplicationClassForJailorApproval {
    private final String name;
    private final String nid;
    private final String id;
    private final String body;
    private final String applicanttype;

    public CustomApplicationClassForJailorApproval(String name, String nid, String id, String body, String applicanttype) {
        this.name = name;
        this.nid = nid;
        this.id = id;
        this.body = body;
        this.applicanttype = applicanttype;
    }

    public String getName() {
        return name;
    }

    public String getNid() {
        return nid;
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getApplicanttype() {
        return applicanttype;
    }
    
}
