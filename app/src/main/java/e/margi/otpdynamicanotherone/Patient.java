package e.margi.otpdynamicanotherone;

public class Patient
{
    String pname;
    String gender;
    String wpatient;
    String problem;
    String pemail;

    String ppassword;
    String age;


    public Patient()
    {

    }



    public Patient(String pname, String age, String gender,String pemail,String ppassword, String wpatient, String problem) {
        this.pname = pname;
        this.age=age;
        this.gender = gender;
        this.pemail = pemail;
        this.ppassword =ppassword;
        this.wpatient = wpatient;
        this.problem = problem;



    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
    public String getPemail() {
        return pemail;
    }

    public void setPemail(String pemail) {
        this.pemail = pemail;
    }

    public String getPpassword() {
        return ppassword;
    }

    public void setPpassword(String ppassword) {
        this.ppassword = ppassword;
    }



    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWpatient() {
        return wpatient;
    }

    public void setWpatient(String wpatient) {
        this.wpatient = wpatient;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

}

