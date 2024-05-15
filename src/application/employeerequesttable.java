package application;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class employeerequesttable {
    final StringProperty name;
    final StringProperty phoneno;
    final StringProperty fromdate;
    final StringProperty todate;
    final StringProperty reason;
    final StringProperty status;
    

    public employeerequesttable(String name, String phoneno, String fromdate, String todate, String reason,String status) {
        this.name= new SimpleStringProperty(name);
        this.phoneno= new SimpleStringProperty(phoneno);
        this.fromdate = new SimpleStringProperty(fromdate);
        this.todate = new SimpleStringProperty(todate);
        this.reason = new SimpleStringProperty(reason);
		this.status = new SimpleStringProperty(status);
        
    }

    public final StringProperty nameProperty() {
        return this.name;
    }

    public final String getname() {
        return this.nameProperty().get();
    }

    public final void setname(final String name) {
        this.nameProperty().set(name);
    }

    public final StringProperty phonenoProperty() {
        return this.phoneno;
    }

    public final String getphoneno() {
        return this.phonenoProperty().get();
    }

    public final void setphoneno(final String phoneno) {
        this.phonenoProperty().set(phoneno);
    }

    public final StringProperty fromdateProperty() {
        return this.fromdate;
    }

    public final String getfromdate() {
        return this.fromdateProperty().get();
    }

    public final void setfromdate(final String fromdate) {
        this.fromdateProperty().set(fromdate);
    }

    public final StringProperty todateProperty() {
        return this.todate;
    }

    public final String gettodate() {
        return this.todateProperty().get();
    }

    public final void settodate(final String todate) {
        this.todateProperty().set(todate);
    }

    public final StringProperty reasonProperty() {
        return this.reason;
    }

    public final String getreason() {
        return this.reasonProperty().get();
    }

    public final void setreason(final String reason) {
        this.reasonProperty().set(reason);
    }
    public final StringProperty statusProperty() {
        return this.status;
    }

    public final String getstatus() {
        return this.statusProperty().get();
    }

    public final void setstatus(final String reason) {
        this.statusProperty().set(reason);
    }

   
}