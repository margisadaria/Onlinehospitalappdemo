package e.margi.otpdynamicanotherone.Fragment;

public class Address
{
    private String address1;
    private String pincode1;
    private String mobileno1;
    private String emailid;
    private String password1;

    public Address()
    {

    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public Address(String emailid, String password1, String address1, String pincode1, String mobileno1) {
       this.emailid = emailid;
       this.password1 = password1;
        this.address1 = address1;
        this.pincode1 = pincode1;
        this.mobileno1 = mobileno1;
    }

    public String getAddress() {
        return address1;
    }

    public void setAddress(String address1) {
        this.address1 = address1;
    }

    public String getPincode() {
        return pincode1;
    }

    public void setPincode(String pincode1) {
        this.pincode1 = pincode1;
    }

    public String getMobileno1() {
        return mobileno1;
    }

    public void setMobileno(String mobileno1) {
        this.mobileno1 = mobileno1;
    }
}
