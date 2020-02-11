package e.margi.otpdynamicanotherone;

public class Doctor
{
    private String dname;
    private String dcontact;
    private String demail;
    private String dpassword;


    public Doctor()
    {

    }
    public Doctor(String dname, String dcontact, String demail, String dpassword)
    {
        this.dname = dname;
        this.dcontact = dcontact;
        this.demail = demail;
        this.dpassword = dpassword;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDcontact() {
        return dcontact;
    }

    public void setDcontact(String dcontact) {
        this.dcontact = dcontact;
    }

    public String getDemail() {
        return demail;
    }

    public void setDemail(String demail) {
        this.demail = demail;
    }

    public String getDpassword() {
        return dpassword;
    }

    public void setDpassword(String dpassword) {
        this.dpassword = dpassword;
    }


}
