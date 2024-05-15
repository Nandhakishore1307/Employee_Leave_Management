package application;



/**
 *
 * @author WINDOWS 10
 */
public class productdata {

    
    private String fullname;
    private String username;
    private String email;
    private String address;
    private String dob;
    private String phonenumber;
    private String doj;
    private String leaveissuer;


    public productdata(String fullname,String username,String email,
    		String address,String dob,String phonenumber,String doj
    		,String leaveissuer) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.phonenumber = phonenumber;
        this.doj= doj;
        this.leaveissuer=leaveissuer;
    }
    


    public String getfullname() {
        return fullname;
    }

    public String getusername() {
        return username;
    }

    public String getemail() {
        return email;
    }
    
    public String getaddress(){
        return address;
    }

    public String getdob() {
        return dob;
    }
    public String getphonenumber(){
        return phonenumber;
    }


    public String getdoj() {
        return doj;
    }
    public String getleaveissuer() {
        return leaveissuer;
    }


}